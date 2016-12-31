﻿# AllHearingEar
 
## Slogan (eng)
Open the world for your headphones!
Are you afraid of missing out on something with your headphones covering your ears? 

## Produktbeskrivning (eng)
We believe it’s possible to combine a world with your headphones covering your ears and still not miss anything important happening IRL. Are you a gamer with sleeping children or a reader listening to recorded books and are afraid of missing something is happening? We have the product for you - AllHearingEar! Just because you are covering your ears to fully enjoy your sound should not stop you from hearing a crying baby or a visitor ringing the doorbell. 

The AllHearingEar is always and secure connected to you home Wi-Fi and alerts you with the exact recording in real time. This way you can enjoy your gaming, videos, music or voice with headphones in both ears and still safely know you will be alerted if needed.

The AllHearingEar is a onetime, low-cost hardware you connect to your home Wi-Fi. Free apps and software are downloaded and run in the background of your PC, smartphone or tablet. The software and hardware have a live status and will alert you if disconnected. You have the endless possibility to adjust trigger limits from even the smallest sound to a small orchestra.

All this to be able to enjoy your gaming in full 7.1 sound or a quiet book tucked inside a blanket by the fire - and always know you are in control.


## Idé:
Skapa en babymonitor som ansluter till hemmanätverket via WI-FI och bryter aktivt ljud i din hemdator samt spelar upp ljudet som tas upp av mikrofonen i babymonitorn. 
Detta för att kunna underlätta för användaren av datorn när användaren spelar spel, ser film, lyssnar på musik eller liknande.
Idén uppkom när jag och min bror spelade datorspel tillsammans och båda två var tvungna att sitta med endast en hörlur på ena örat.
Vi vill alltså ha möjlighet att höra våra barn om de eventuellt vaknar, utan att tappa ljud när vi arbetar med våra datorer.

##Namn
Om vi nu ska köra på illuminati pyramid kan vi istället för att produkten heter all-seeing-eye heta all-hearing-ear ?

### Utförande
USB-stick
Pyramid

## Ström?

USB Anslutningar - Konsument står för egna adapters.
Anslutes till telefonladdare - standard USB / MicroUSB.

## Hårdvara

Andreas bygger hårdvara i form av kretskort och mikrofoner. Samt designar ett snyggt och praktiskt hölje!

- Esp8266 Wifi Accesspoint/Server (https://github.com/tzapu/WiFiManager )

- Atmega328p

- 5V VCC (iphone laddare?) Batteri?

- 3.3V för Esp?

- Electret Microphone Amplifier MAX4466

- Statusled?

- Nattlampa LED

- Hårdvaru

- 3d printad iluminati pyramid (http://www.shapeways.com/product/G3PZPGYJB/illuminati-flat-peice-v2e)
-Hål undertill för väggfäste!

- Microfoner: https://store.invensense.com/ProductDetail/ICS43432-InvenSense-Inc/495200/

## Länkar Hårdvara

https://www.hackster.io/middleca/sending-sound-over-the-internet-f097b4

Https://plus.google.com/wm/1/+MarkChaney/posts/EpTNcAjxMak

https://perso.aquilenet.fr/~sven337/english/2016/07/14/DIY-wifi-baby-monitor.html

#### Ljud/Mic till Arduino:

Https://perso.aquilenet.fr/~sven337/english/2016/07/14/DIY-wifi-baby-monitor.html

https://electronpi.wordpress.com/2013/05/28/getting-going-with-an-electret-microphone-and-an-arduino/
Inkl flera länkar på denna sida!

https://www.youtube.com/watch?v=SToBPCajwc0: Mini project: Amplified electret microphone 

Sök arduino electret microphone circuit

## Wishlist
Kamera

##Mjukvara

Marcus utformar en mjukvara till Windows som synkar hårdvaran och bryter eventuellt ljud som spelas upp från datorn. För att sedan spela upp ljudet från monitorn.
Synkning av hårdvara,
 
Volymkontroll för uppspelning av ljud upptaget av mikrofon, 

Volymkontroll för dämpning av ljud aktiva i PC,
 
Volymkontroll för känslighet i mikrofon,
 
Alternativ för autostart av program (Checkbox),
 
Statusinformation, 

Länk till hemsida.

### Länkar till källor.

https://www.nuget.org/packages/NAudio/1.7.3 (NAudio API för inspelning av ljud i VB)

https://social.msdn.microsoft.com/Forums/vstudio/en-US/c9841350-2d83-4863-b491-6d9f75bb1daa/stream-mic-audio-to-another-computer?forum=vbgeneral (Exempelprogramm för ljudstream via UDP.)

http://www.codeproject.com/Articles/19485/A-Voice-Chat-Application-in-C - A Voice Chat Application in C#

### Wishlist
Knapp för att visa video.
Alternativ för att få video picture in picture när monitor aktiveras.

### Språk
Listener programmeras i Visual Basic då språket är mer känt av Marcus och kod för att skicka och lyssna bevisats fungera och uppfylla de krav vi har.

###Steg 1: Hitta kod för kommunikation mellan mikrofon och dator.
- UDP / TCP?
Valt protokoll är UDP då det inte behöver ett svar från client innan nästa packet skickas. UDP streamar hela tiden med risk att tappa delar av packet.
 
Då krav på ljudkvalité inte är stort i vårt projekt riskerar vi inte lagg genom att använda TCP.

Två testprogram är färdiga. Sändare och Lyssnare som streamar ljud via UDP. 

###Steg 2: Ändra ljudnivåer i dator för att mikrofonen ska få prioritet på datorn.

###Steg 3: Push/Pull lösning

###Steg 4: Användarinställningar / Decibelbegränsning

###Steg 5: Grafiskt user interface.
Löser sig på ett enkelt sätt då vi använder VB Form application.

##Det kommerciella

###Ce/Fee
###Strömadapter
###Förpackning
###Ekonomi
Kickstarter?
###Marknadsföring
###Målgrupp
Gamers
Unga med barn
Teknikintresserade (hörlurar) (Sälja hörlurar tillsammans?)
###Användningsområde

Gamers som passar barnen men vill spela

Mammor som lyssnar på ljudböcker? (Kräver app ios/Android?)

Egenföretagare med barn som behöver jobba kväll och vill lyssna på musik.

Studerande med barn som jobbar med datorn och lyssnar på musik.

Musiker som jobbar hemma.

Arbetande tjänstemän som behöver använda en dator i jobbet medans barnen sover.

##Produktbeskrivning/Anvädningsområde
Vi vill alltså ha möjlighet att höra våra barn om de eventuellt vaknar, utan att tappa ljud när vi arbetar med våra datorer.
På ett smart sätt höra din omgivning, exempelvis barn som vaknar, utan att tappa ljud via hörlurarna när man arbetar vid dator/platta/mobil.

##Logg / Rev historia! (Använda github.com för kod??)
Sept 2016
Hårdvara
Beställt hårdvara (ESP8266, Mikrofon)
Tänk köra Wifi via (https://github.com/tzapu/WiFiManager) direkt på ESP8266
Börjar bygge av hårdvara
Mjukvara


