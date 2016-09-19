#include <ESP8266WiFi.h>
#include <WiFiUDP.h>
#include <SPI.h>

// wifi connection variables
const char* ssid     = "EAMWWS_A";
const char* password = "castleofhorror";

IPAddress ipBroadCast(217,210,144,102);
unsigned int udpRemotePort=11319;
unsigned int udplocalPort=11319;
int sensorPin = A0;    // select the input pin for the potentiometer
int sensorValue = 0;  // variable to store the value coming from the sensor
unsigned long lastRequest, lastsensorvalue = 0;
const int UDP_PACKET_SIZE = 48;
char udpBuffer[UDP_PACKET_SIZE];
WiFiUDP udp;
//================================================================
// Setup hardware, serial port, and connect to wifi.
//================================================================
 
void setup() {
  delay(6000);
  WiFi.disconnect();
  delay(6000);
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
  
   pinMode(sensorPin, INPUT);
}
//================================================================
// Function to send udp message
//================================================================
void fncUdpSend(int msg)
{
  //trcpy(udpBuffer, "Bajskorv"); 
  udp.beginPacket(ipBroadCast, udpRemotePort);
  //udp.write(udpBuffer, sizeof(udpBuffer));
  udp.write(msg);
  udp.endPacket();

  }
//================================================================
// LOOP MAIN
//================================================================



// send udp packet each 5 secconds
void loop() {
  
unsigned long now = millis();
sensorValue = analogRead(sensorPin);   
  
if ((now - lastRequest) > 1000){  

  Serial.print("Mörker: ");
  Serial.println(sensorValue / 100);
  lastRequest = now;
if (sensorValue > (lastsensorvalue + 10)){   

  Serial.print("Sensorvalue: ");
  Serial.print(sensorValue);
  Serial.print("Lastsensorvalue");
  Serial.println(lastsensorvalue);
  //fncUdpSend(sensorValue);
  lastsensorvalue = sensorValue;
  
}

if (sensorValue > (lastsensorvalue - 10)){   

  Serial.print("Sensorvalue: ");
  Serial.print(sensorValue);
  Serial.print("Lastsensorvalue");
  Serial.println(lastsensorvalue);
  //fncUdpSend(sensorValue);
  lastsensorvalue = sensorValue;
  
}
}
}
