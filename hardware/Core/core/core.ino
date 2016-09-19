//Libraries
#include <ESP8266WiFi.h>          //https://github.com/esp8266/Arduino
#include <DNSServer.h>
#include <ESP8266WebServer.h>
#include <WiFiManager.h>         //https://github.com/tzapu/WiFiManager
#include <WiFiUDP.h>
#include <SPI.h>

//UDP Variabler
const int UDP_PACKET_SIZE = 48;
char incomingPacket[UDP_PACKET_SIZE];
//IPAddress ipServer(217,210,144,102);
IPAddress ipServer(0, 0, 0, 0);
unsigned int udpServerPort = 11319;
unsigned int udplocalPort = 11319;
WiFiUDP udp;

//Microfon variabler.
int sensorPin = A0;    // select the input pin for the potentiometer
int sensorValue = 0;  // variable to store the value coming from the sensor
unsigned long lastRequest = 0;

void setup() {

  //Debug
  Serial.begin(115200);
  Serial.println("Startar...");

  //Klientnamn på routern.
  wifi_station_set_hostname("AllHearingEar");

  //WiFiManager startar
  WiFiManager wifiManager;

  //Använd denna om du vill plocka bort SSID och lösernord.
  //wifiManager.resetSettings();

  //Använd denna om du vill ha exakt IP för portalen.
  //wifiManager.setAPConfig(IPAddress(10,0,1,1), IPAddress(10,0,1,1), IPAddress(255,255,255,0));

  //Hämta tidigare sparade SSID/Lösen eller starta portal om det behövs.
  wifiManager.autoConnect("AllHearingEar");
  Serial.println("Wifi ansluten!");

  // Starta UDP protokoll.
  udp.begin(udplocalPort);

  // Vänta inkommande sync från servern
  Serial.print("Väntar server.");
  while (ipServer < 1) {
    UdpRecieve();
  }
  Serial.print("IP Server: ");
  Serial.println(ipServer);

}
void loop() {

  //Ping varje 5 sek (om inte ljud skickats).
  unsigned long now = millis();
  if ((now - lastRequest) > 5000) {
    lastRequest = now;
    UdpSend(1);
  }
}

void UdpSend(int msg)
{
  udp.beginPacket(ipServer, udpServerPort);
  udp.write(msg);
  udp.endPacket();
}

void UdpRecieve() {

  unsigned long now = millis();
  if ((ipServer < 1) && (now - lastRequest) > 5000) {
    lastRequest = now;
    Serial.print(".");
  }

  int packetSize = udp.parsePacket();
  if (packetSize) {
    Serial.printf("Received %d bytes from %s, port %d\n", packetSize, udp.remoteIP().toString().c_str(), udp.remotePort());
    ipServer = udp.remoteIP();
    int len = udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    //Serial.printf("UDP packet contents: %s\n", incomingPacket);

    //Ack!
    UdpSend(1);

  }

}


