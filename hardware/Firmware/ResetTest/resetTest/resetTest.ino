const int resetPIN = 4;     // the number of the pushbutton pin

void setup() {
  // put your setup code here, to run once:


  // initialize the pushbutton pin as an input:

  pinMode(4,INPUT);
  pinMode(5,INPUT);

}

void loop() {
  // put your main code here, to run repeatedly:

  Serial.begin(115200);


          Serial.print("4: "); Serial.println(digitalRead(4));
            Serial.print("5: "); Serial.println(digitalRead(5));


 if (digitalRead(resetPIN)) {
    //Reset settings
    Serial.println("Nolla WIFI");
  }
  
  delay(2000);

}
