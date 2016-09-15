#include <ESP8266WiFi.h>
#include <WiFiUDP.h>

// wifi connection variables
const char* ssid     = "EAMWWS_B";
const char* password = "castleofhorror";

IPAddress ipBroadCast(217,210,144,102);
unsigned int udpRemotePort=11000;
unsigned int udplocalPort=11000;
const int UDP_PACKET_SIZE = 48;
char udpBuffer[ UDP_PACKET_SIZE];
WiFiUDP udp;
//================================================================
// Setup hardware, serial port, and connect to wifi.
//================================================================
 
void setup() {
  Serial.begin(115200);
  delay(10);
  // We start by connecting to a WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
 
  //  Try to connect to wifi access point
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
      delay(500);
      Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected"); 
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  Serial.println("Starting UDP");
 
  // set udp port for listen
  udp.begin(udplocalPort);
  Serial.print("Local port: ");
  Serial.println(udp.localPort());
}
//================================================================
// Function to send udp message
//================================================================
void fncUdpSend()
{
  strcpy(udpBuffer, "hello testing message"); 
  udp.beginPacket(ipBroadCast, udpRemotePort);
  udp.write(udpBuffer, sizeof(udpBuffer));
  udp.endPacket();
  }
//================================================================
// LOOP MAIN
//================================================================
// send udp packet each 5 secconds
 
void loop() {
    delay (5000);
   fncUdpSend();
}
