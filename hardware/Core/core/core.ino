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
//IPAddress ipBroadCast(217,210,144,102);
IPAddress ipBroadCast(0, 0, 0, 0);
unsigned int udpRemotePort=11319;
unsigned int udplocalPort=11319;
WiFiUDP udp;

//Microfon variabler.
int sensorPin = A0;    // select the input pin for the potentiometer
int sensorValue = 0;  // variable to store the value coming from the sensor
unsigned long lastRequest, lastsensorvalue = 0;

void setup() {

  //Debug
  Serial.begin(115200);

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
  Serial.println("Connected!");

  // Starta UDP protokoll.
  udp.begin(udplocalPort);
  Serial.print("UDP Local port: ");
  Serial.println(udp.localPort());

  pinMode(sensorPin, INPUT);

  Serial.println(ipBroadCast);
  while (ipBroadCast < 1) {

    UdpRecieve();
    
  }
  
  
}

void loop() {
  // put your main code here, to run repeatedly:
  //sensorValue = analogRead(sensorPin);
  //Serial.print("Sensorvalue: ");
  //Serial.println(sensorValue);
  //fncUdpSend(sensorValue);
  //delay(5000);

}

void UdpSend(int msg)
{
  //trcpy(udpBuffer, "Bajskorv");
  //udp.beginPacket(ipBroadCast, udpRemotePort);
  //udp.write(udpBuffer, sizeof(udpBuffer));
  //udp.write(msg);
  //udp.endPacket();
}

void UdpRecieve() {
  int packetSize = udp.parsePacket();
  if (packetSize)
  {
    Serial.printf("Received %d bytes from %s, port %d\n", packetSize, udp.remoteIP().toString().c_str(), udp.remotePort());
    int len = udp.read(incomingPacket, 255);
    if (len > 0)
    {
      incomingPacket[len] = 0;
    }
    Serial.printf("UDP packet contents: %s\n", incomingPacket);
    ipBroadCast == udp.remoteIP();
    Serial.println(ipBroadCast);
   
  //Skriv tillbaka!  
  udp.beginPacket(udp.remoteIP(), udp.remotePort());
  udp.write("Jag tog din IP - hehe");
  udp.endPacket();
    
  }

}


