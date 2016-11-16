//Libraries
#include <ESP8266WiFi.h>          //https://github.com/esp8266/Arduino
#include <DNSServer.h>
#include <ESP8266WebServer.h>
#include <WiFiManager.h>         //https://github.com/tzapu/WiFiManager
#include <WiFiUDP.h>
#include <SPI.h>

//UDP Variabler
const int UDP_PACKET_SIZE = 64; 
//ABBB
//A = 1 byte = 1-9, vad ska hända = Sync, Volym, Debug?
  //0 = SYNC
  //1 = ACK
  //2 = VOLYM
//B = 3 byte = 001-999, Volym eller annan info - MAX 3 chars.

char incomingPacket[UDP_PACKET_SIZE];
char incomingUDP[UDP_PACKET_SIZE];

IPAddress ipServer(0, 0, 0, 0);
unsigned int udpServerPort = 11319;
unsigned int udpPingPort = 11319;
unsigned int udpSoundPort = 11318;
WiFiUDP udp;

//Microfon variabler.
unsigned long lastRequest = 0;
unsigned long lastPing;
unsigned long now;

// ADC
uint16_t adc_buf[2][700]; // ADC data buffer, double buffered
int current_adc_buf; // which data buffer is being used for the ADC (the other is being sent)
unsigned int adc_buf_pos; // position in the ADC data buffer
int send_samples_now; // flag to signal that a buffer is ready to be sent

// Pin definitions:
// const int scePin = 15; // SCE - Chip select

#define SILENCE_EMA_WEIGHT 1024
#define ENVELOPE_EMA_WEIGHT 2
int32_t silence_value = 2048; // computed as an exponential moving average of the signal
uint16_t envelope_threshold = 10; // envelope threshold to trigger data sending
uint32_t send_sound_util = 0; // date until sound transmission ends after an envelope threshold has triggered sound transmission
int enable_highpass_filter = 1;

// ÖVrigt
const int resetPIN = 4;     // the number of the pushbutton pin

void setup() {

  //Debug
  Serial.begin(115200);
  Serial.println("Startar...");

  //Klientnamn på routern.
  wifi_station_set_hostname("AllHearingEar");

  //WiFiManager startar
  WiFiManager wifiManager;

  // initialize the pushbutton pin as an input:
  pinMode(resetPIN, INPUT);

  delay(1000);
  Serial.println(digitalRead(resetPIN));
  if (digitalRead(resetPIN)) {
    //Reset settings
    Serial.println("Clear WIFI");
    //Använd denna om du vill plocka bort SSID och lösernord.
    //wifiManager.resetSettings();
  }

  //Hämta tidigare sparade SSID/Lösen eller starta portal om det behövs.
  wifiManager.autoConnect("AllHearingEar");

  //Starta SPI för digital input.
  spiBegin();

  // Starta UDP protokoll.
  udp.begin(udpPingPort);

  //IPAddress ipServer(217, 210, 144, 102); //Marcus
  //IPAddress ipServer(192, 168, 1, 116); //LAN

  // Vänta inkommande sync från servern
  Serial.print("Väntar sync.");
  while (ipServer < 1) {
    UdpRecieveSync();
  }

  //Aktivera hårdvarutimer för 12,5kHz.
  timer1_isr_init();
  timer1_attachInterrupt(sample_isr);
  timer1_enable(TIM_DIV16, TIM_EDGE, TIM_LOOP);
  timer1_write(clockCyclesPerMicrosecond() / 16 * 50); //80us = 12.5kHz sampling freq

  Serial.print("Sync - IP Server: ");
  Serial.println(ipServer);
}

void loop()
{  
  
  UdpRecieveData();
  
  if (send_samples_now) {
    /* We're ready to send a buffer of samples over wifi. Decide if it has to happen or not,
       that is, if the sound level is above a certain threshold. */

    // Update silence and envelope computations
    uint16_t number_of_samples = sizeof(adc_buf[0]) / sizeof(adc_buf[0][0]);
    int32_t accum_silence = 0;
    int32_t envelope_value = 0;

    uint8_t *writeptr = (uint8_t *)(&adc_buf[!current_adc_buf][0]);
    uint16_t *readptr;
    uint16_t last = 0;
    for (unsigned int i = 0; i < number_of_samples; i++) {
      readptr = &adc_buf[!current_adc_buf][i];
      int32_t val = *readptr;
      int32_t rectified;

      if (enable_highpass_filter) {
        *readptr = filterloop(val) + 2048;
        val = *readptr;
      }

      rectified = abs(val - silence_value);

      accum_silence += val;
      envelope_value += rectified;

      // delta7-compress the data
      writeptr = delta7_sample(last, readptr, writeptr);
      last = val;
    }
    accum_silence /= number_of_samples;
    envelope_value /= number_of_samples;
    silence_value = (SILENCE_EMA_WEIGHT * silence_value + accum_silence) / (SILENCE_EMA_WEIGHT + 1);
    envelope_value = envelope_value;

    if (envelope_value > envelope_threshold) {
      send_sound_util = millis() + 15000;
    }

    if (millis() < send_sound_util) {
      udp.beginPacket(ipServer, udpSoundPort);
      udp.write((const uint8_t *)(&adc_buf[!current_adc_buf][0]), writeptr - (uint8_t *)&adc_buf[!current_adc_buf][0]);
      udp.endPacket();
    }

    send_samples_now = 0;
    
    //Serial.print("Silence val "); Serial.print(silence_value); Serial.print(" envelope val "); Serial.print(envelope_value);
    //Serial.print("delay "); Serial.print(millis() - now);
    //Serial.println("");

  }

  // If not sending anything, add a delay to enable modem sleep
  if (millis() > send_sound_util) {
    
    delay(10);
  }
}

void UdpSend(byte msg)
{
  udp.beginPacket(ipServer, udpServerPort);
  udp.write(msg);
  udp.endPacket();
}

void UdpRecieveSync(){
  
  unsigned long now = millis();
  if ((ipServer < 1) && (now - lastRequest) > 5000) {
    lastRequest = now;
    Serial.print(".");
  }

  int packetSize = udp.parsePacket();
  if (packetSize) {
    ipServer = udp.remoteIP();
    int len = udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    //Ack!
    UdpSend(1);
  }
  
}

void UdpRecieveData()
{
  
  int packetSizeD = udp.parsePacket();
  if (packetSizeD) {
   //Serial.printf("Received %d bytes from %s, port %d\n", packetSizeD, udp.remoteIP().toString().c_str(), udp.remotePort());
    udp.read(incomingUDP, 255);     
    uint8_t swUDP = incomingUDP[0] - '0';
    Serial.println(swUDP);   
    
    switch (swUDP) {
      case 0:
        Serial.println("0: Ping from computer");        
        UdpSend(49);        
        break;      
      case 1:
        //ACK från dator
        Serial.println("1: Ack from computer");
        UdpSend(49);
        break;
      case 2:
        Serial.println("2: Volume from computer");
        Serial.print("Volume: "); Serial.println(incomingUDP[1]);
        //Sätt volym.
        envelope_threshold = incomingUDP[1] * 10;     
        if (envelope_threshold == 0){envelope_threshold = 5;}
        break;
      default:
        Serial.println("Nothing to switch");
        break;
    }
  }
}

static inline void setDataBits(uint16_t bits) {
  const uint32_t mask = ~((SPIMMOSI << SPILMOSI) | (SPIMMISO << SPILMISO));
  bits--;
  SPI1U1 = ((SPI1U1 & mask) | ((bits << SPILMOSI) | (bits << SPILMISO)));
}

void spiBegin(void)
{
  SPI.begin();
  SPI.setDataMode(SPI_MODE0);
  SPI.setBitOrder(MSBFIRST);
  SPI.setClockDivider(SPI_CLOCK_DIV8);
  SPI.setHwCs(1);
  setDataBits(16);
}

#define ICACHE_RAM_ATTR     __attribute__((section(".iram.text")))
/* SPI code based on the SPI library */
static inline ICACHE_RAM_ATTR uint16_t transfer16(void) {
  union {
    uint16_t val;
    struct {
      uint8_t lsb;
      uint8_t msb;
    };
  } out;


  // Transfer 16 bits at once, leaving HW CS low for the whole 16 bits
  while (SPI1CMD & SPIBUSY) {}
  SPI1W0 = 0;
  SPI1CMD |= SPIBUSY;
  while (SPI1CMD & SPIBUSY) {}

  /* Follow MCP3201's datasheet: return value looks like this:
  xxxBA987 65432101
  We want
  76543210 0000BA98
  So swap the bytes, select 12 bits starting at bit 1, and shift right by one.
  */

  out.val = SPI1W0 & 0xFFFF;
  uint8_t tmp = out.msb;
  out.msb = out.lsb;
  out.lsb = tmp;

  out.val &= (0x0FFF << 1);
  out.val >>= 1;
  //Serial.println(out.val);
  return out.val;
}

void ICACHE_RAM_ATTR sample_isr(void)
{
  uint16_t val;
  // Read a sample from ADC
  val = transfer16();
  adc_buf[current_adc_buf][adc_buf_pos] = val & 0xFFF;
  adc_buf_pos++;

  // If the buffer is full, signal it's ready to be sent and switch to the other one
  if (adc_buf_pos > sizeof(adc_buf[0]) / sizeof(adc_buf[0][0])) {
    adc_buf_pos = 0;
    current_adc_buf = !current_adc_buf;
    send_samples_now = 1;
  }
}

#define NZEROS 5
#define NPOLES 5
#define GAIN   1.129790960e+00f
static float xv[NZEROS + 1], yv[NPOLES + 1];

static float filterloop(float input)
{ for (;;)
  { xv[0] = xv[1]; xv[1] = xv[2]; xv[2] = xv[3]; xv[3] = xv[4]; xv[4] = xv[5];
    xv[5] = input / GAIN;
    yv[0] = yv[1]; yv[1] = yv[2]; yv[2] = yv[3]; yv[3] = yv[4]; yv[4] = yv[5];
    yv[5] =   (xv[5] - xv[0]) + 5 * (xv[1] - xv[4]) + 10 * (xv[3] - xv[2])
              + (  0.7834365141f * yv[0]) + ( -4.1083230157f * yv[1])
              + (  8.6224512099f * yv[2]) + ( -9.0535899276f * yv[3])
              + (  4.7560230574f * yv[4]);
    return yv[5];
  }
}

uint8_t *delta7_sample(uint16_t last, uint16_t *readptr, uint8_t *writeptr)
{
  const uint8_t lowbyte1 = *((uint8_t *)readptr);
  const uint8_t highbyte1 = *((uint8_t *)readptr + 1);
  const uint16_t val = *readptr;
  const int32_t diff = val - last;

  // 7bit delta not wanted, output as-is
  *writeptr++ = highbyte1;
  *writeptr++ = lowbyte1;

  return writeptr;
}
