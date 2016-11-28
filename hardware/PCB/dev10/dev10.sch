EESchema Schematic File Version 2
LIBS:power
LIBS:device
LIBS:transistors
LIBS:conn
LIBS:linear
LIBS:regul
LIBS:74xx
LIBS:cmos4000
LIBS:adc-dac
LIBS:memory
LIBS:xilinx
LIBS:microcontrollers
LIBS:dsp
LIBS:microchip
LIBS:analog_switches
LIBS:motorola
LIBS:texas
LIBS:intel
LIBS:audio
LIBS:interface
LIBS:digital-audio
LIBS:philips
LIBS:display
LIBS:cypress
LIBS:siliconi
LIBS:opto
LIBS:atmel
LIBS:contrib
LIBS:valves
LIBS:dev3-cache
LIBS:dev10-cache
EELAYER 25 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L ESP-07v2 U2
U 1 1 5824CC2A
P 5400 3850
F 0 "U2" H 5400 3750 50  0000 C CNN
F 1 "ESP-07v2" H 5400 3950 50  0000 C CNN
F 2 "dev_02_kicad:ESP-07v2" H 5400 3850 50  0001 C CNN
F 3 "" H 5400 3850 50  0001 C CNN
	1    5400 3850
	1    0    0    -1  
$EndComp
$Comp
L R R1
U 1 1 5824D0BF
P 4300 3750
F 0 "R1" V 4380 3750 50  0000 C CNN
F 1 "10k" V 4300 3750 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 4230 3750 50  0001 C CNN
F 3 "" H 4300 3750 50  0000 C CNN
	1    4300 3750
	0    1    1    0   
$EndComp
$Comp
L R R2
U 1 1 5824D172
P 6350 4350
F 0 "R2" V 6430 4350 50  0000 C CNN
F 1 "10k" V 6350 4350 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 6280 4350 50  0001 C CNN
F 3 "" H 6350 4350 50  0000 C CNN
	1    6350 4350
	1    0    0    -1  
$EndComp
Wire Wire Line
	6300 4150 6400 4150
Wire Wire Line
	6350 4150 6350 4200
Connection ~ 6350 4150
Wire Wire Line
	6350 4500 6350 4850
Wire Wire Line
	5400 4750 5400 4800
Wire Wire Line
	5400 4800 6350 4800
Connection ~ 6350 4800
Wire Wire Line
	4100 2850 4100 3750
Wire Wire Line
	5400 2950 5400 2850
Wire Wire Line
	5400 2850 4050 2850
Connection ~ 4100 2850
$Comp
L JUMPER JP1
U 1 1 5824DC06
P 6650 3950
F 0 "JP1" H 6650 4100 50  0000 C CNN
F 1 "F Reset" H 6650 3870 50  0000 C CNN
F 2 "Buttons_Switches_SMD:SW_SPST_EVQPE1" H 6650 3950 50  0001 C CNN
F 3 "" H 6650 3950 50  0000 C CNN
	1    6650 3950
	1    0    0    -1  
$EndComp
Wire Wire Line
	6300 3950 6350 3950
Wire Wire Line
	6950 3950 7000 3950
$Comp
L GND #PWR01
U 1 1 5824DC97
P 7000 3950
F 0 "#PWR01" H 7000 3700 50  0001 C CNN
F 1 "GND" H 7000 3800 50  0000 C CNN
F 2 "" H 7000 3950 50  0000 C CNN
F 3 "" H 7000 3950 50  0000 C CNN
	1    7000 3950
	0    -1   -1   0   
$EndComp
$Comp
L GND #PWR02
U 1 1 5824DCB5
P 6350 4850
F 0 "#PWR02" H 6350 4600 50  0001 C CNN
F 1 "GND" H 6350 4700 50  0000 C CNN
F 2 "" H 6350 4850 50  0000 C CNN
F 3 "" H 6350 4850 50  0000 C CNN
	1    6350 4850
	1    0    0    -1  
$EndComp
Text GLabel 6300 3550 2    60   Input ~ 0
RX
Text GLabel 6300 3650 2    60   Input ~ 0
TX
NoConn ~ 6300 3850
Wire Wire Line
	6300 3750 6850 3750
$Comp
L R R3
U 1 1 5824DE0A
P 6600 3550
F 0 "R3" V 6680 3550 50  0000 C CNN
F 1 "10k" V 6600 3550 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 6530 3550 50  0001 C CNN
F 3 "" H 6600 3550 50  0000 C CNN
	1    6600 3550
	1    0    0    -1  
$EndComp
Wire Wire Line
	6600 3750 6600 3700
Connection ~ 6600 3750
Wire Wire Line
	6600 3400 6600 3350
$Comp
L GND #PWR03
U 1 1 5824DEB2
P 6600 3350
F 0 "#PWR03" H 6600 3100 50  0001 C CNN
F 1 "GND" H 6600 3200 50  0000 C CNN
F 2 "" H 6600 3350 50  0000 C CNN
F 3 "" H 6600 3350 50  0000 C CNN
	1    6600 3350
	-1   0    0    1   
$EndComp
$Comp
L SW_PUSH SW1
U 1 1 5824DEE2
P 7150 3750
F 0 "SW1" H 7300 3860 50  0000 C CNN
F 1 "SW_PUSH" H 7150 3670 50  0000 C CNN
F 2 "Buttons_Switches_SMD:SW_SPST_EVQPE1" H 7150 3750 50  0001 C CNN
F 3 "" H 7150 3750 50  0000 C CNN
	1    7150 3750
	1    0    0    -1  
$EndComp
$Comp
L VCC #PWR04
U 1 1 5824DFC7
P 7450 3750
F 0 "#PWR04" H 7450 3600 50  0001 C CNN
F 1 "VCC" H 7450 3900 50  0000 C CNN
F 2 "" H 7450 3750 50  0000 C CNN
F 3 "" H 7450 3750 50  0000 C CNN
	1    7450 3750
	0    1    1    0   
$EndComp
$Comp
L VCC #PWR05
U 1 1 5824DFEB
P 4050 2850
F 0 "#PWR05" H 4050 2700 50  0001 C CNN
F 1 "VCC" H 4050 3000 50  0000 C CNN
F 2 "" H 4050 2850 50  0000 C CNN
F 3 "" H 4050 2850 50  0000 C CNN
	1    4050 2850
	0    -1   -1   0   
$EndComp
Text GLabel 6400 4150 2    60   Input ~ 0
SS
Text GLabel 4500 3950 0    60   Input ~ 0
SCLK
Text GLabel 4500 4050 0    60   Input ~ 0
MISO
Wire Wire Line
	4500 3750 4450 3750
Wire Wire Line
	4100 3750 4150 3750
$Comp
L LM1117-3.3 U1
U 1 1 5824E18B
P 4600 4800
F 0 "U1" H 4700 4550 50  0000 C CNN
F 1 "LM1117-3.3" H 4600 5050 50  0000 C CNN
F 2 "TO_SOT_Packages_SMD:SOT-223" H 4600 4800 50  0001 C CNN
F 3 "" H 4600 4800 50  0000 C CNN
	1    4600 4800
	1    0    0    -1  
$EndComp
$Comp
L VCC #PWR06
U 1 1 5824E1F5
P 5000 4800
F 0 "#PWR06" H 5000 4650 50  0001 C CNN
F 1 "VCC" H 5000 4950 50  0000 C CNN
F 2 "" H 5000 4800 50  0000 C CNN
F 3 "" H 5000 4800 50  0000 C CNN
	1    5000 4800
	0    1    1    0   
$EndComp
$Comp
L GND #PWR07
U 1 1 5824E215
P 4600 5200
F 0 "#PWR07" H 4600 4950 50  0001 C CNN
F 1 "GND" H 4600 5050 50  0000 C CNN
F 2 "" H 4600 5200 50  0000 C CNN
F 3 "" H 4600 5200 50  0000 C CNN
	1    4600 5200
	1    0    0    -1  
$EndComp
$Comp
L +5V #PWR08
U 1 1 5824E2AC
P 4200 4800
F 0 "#PWR08" H 4200 4650 50  0001 C CNN
F 1 "+5V" H 4200 4940 50  0000 C CNN
F 2 "" H 4200 4800 50  0000 C CNN
F 3 "" H 4200 4800 50  0000 C CNN
	1    4200 4800
	0    -1   -1   0   
$EndComp
$Comp
L C C1
U 1 1 5824E356
P 4250 5000
F 0 "C1" H 4275 5100 50  0000 L CNN
F 1 "C" H 4275 4900 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 4288 4850 50  0001 C CNN
F 3 "" H 4250 5000 50  0000 C CNN
	1    4250 5000
	1    0    0    -1  
$EndComp
$Comp
L C C2
U 1 1 5824E3C5
P 4950 5000
F 0 "C2" H 4975 5100 50  0000 L CNN
F 1 "C" H 4975 4900 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 4988 4850 50  0001 C CNN
F 3 "" H 4950 5000 50  0000 C CNN
	1    4950 5000
	1    0    0    -1  
$EndComp
Wire Wire Line
	4900 4800 5000 4800
Wire Wire Line
	4950 4850 4950 4800
Connection ~ 4950 4800
Wire Wire Line
	4200 4800 4300 4800
Wire Wire Line
	4250 4850 4250 4800
Connection ~ 4250 4800
Wire Wire Line
	4250 5150 4950 5150
Wire Wire Line
	4600 5100 4600 5200
Connection ~ 4600 5150
$Comp
L USB_OTG P1
U 1 1 5824E589
P 3700 4400
F 0 "P1" H 4025 4275 50  0000 C CNN
F 1 "Power" H 3700 4600 50  0000 C CNN
F 2 "ASKicadLib:USB_Mini-B_AS" V 3650 4300 50  0001 C CNN
F 3 "" V 3650 4300 50  0000 C CNN
	1    3700 4400
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR09
U 1 1 5824E655
P 3900 4700
F 0 "#PWR09" H 3900 4450 50  0001 C CNN
F 1 "GND" H 3900 4550 50  0000 C CNN
F 2 "" H 3900 4700 50  0000 C CNN
F 3 "" H 3900 4700 50  0000 C CNN
	1    3900 4700
	1    0    0    -1  
$EndComp
$Comp
L +5V #PWR010
U 1 1 5824E67E
P 3500 4700
F 0 "#PWR010" H 3500 4550 50  0001 C CNN
F 1 "+5V" H 3500 4840 50  0000 C CNN
F 2 "" H 3500 4700 50  0000 C CNN
F 3 "" H 3500 4700 50  0000 C CNN
	1    3500 4700
	-1   0    0    1   
$EndComp
$Comp
L GND #PWR011
U 1 1 5824E6A7
P 4100 4300
F 0 "#PWR011" H 4100 4050 50  0001 C CNN
F 1 "GND" H 4100 4150 50  0000 C CNN
F 2 "" H 4100 4300 50  0000 C CNN
F 3 "" H 4100 4300 50  0000 C CNN
	1    4100 4300
	0    -1   -1   0   
$EndComp
$Comp
L CONN_01X05 P2
U 1 1 5824E6C8
P 6050 3000
F 0 "P2" H 6050 3300 50  0000 C CNN
F 1 "Audio" V 6150 3000 50  0000 C CNN
F 2 "Pin_Headers:Pin_Header_Straight_1x05" H 6050 3000 50  0001 C CNN
F 3 "" H 6050 3000 50  0000 C CNN
	1    6050 3000
	0    1    1    0   
$EndComp
$Comp
L GND #PWR012
U 1 1 5824E8BA
P 6300 2750
F 0 "#PWR012" H 6300 2500 50  0001 C CNN
F 1 "GND" H 6300 2600 50  0000 C CNN
F 2 "" H 6300 2750 50  0000 C CNN
F 3 "" H 6300 2750 50  0000 C CNN
	1    6300 2750
	0    -1   -1   0   
$EndComp
$Comp
L VCC #PWR013
U 1 1 5824E911
P 5800 2750
F 0 "#PWR013" H 5800 2600 50  0001 C CNN
F 1 "VCC" H 5800 2900 50  0000 C CNN
F 2 "" H 5800 2750 50  0000 C CNN
F 3 "" H 5800 2750 50  0000 C CNN
	1    5800 2750
	0    -1   -1   0   
$EndComp
Text GLabel 6050 2800 1    60   Input ~ 0
MISO
Text GLabel 6150 2800 1    60   Input ~ 0
SCLK
Text GLabel 5950 2800 1    60   Input ~ 0
SS
Wire Wire Line
	5800 2750 5850 2750
Wire Wire Line
	5850 2750 5850 2800
Wire Wire Line
	6300 2750 6250 2750
Wire Wire Line
	6250 2750 6250 2800
$Comp
L CONN_01X03 P3
U 1 1 5824E9F1
P 6950 4350
F 0 "P3" H 6950 4550 50  0000 C CNN
F 1 "Debug" V 7050 4350 50  0000 C CNN
F 2 "Pin_Headers:Pin_Header_Straight_1x03" H 6950 4350 50  0001 C CNN
F 3 "" H 6950 4350 50  0000 C CNN
	1    6950 4350
	0    -1   -1   0   
$EndComp
$Comp
L GND #PWR014
U 1 1 5824EA74
P 6800 4600
F 0 "#PWR014" H 6800 4350 50  0001 C CNN
F 1 "GND" H 6800 4450 50  0000 C CNN
F 2 "" H 6800 4600 50  0000 C CNN
F 3 "" H 6800 4600 50  0000 C CNN
	1    6800 4600
	0    1    1    0   
$EndComp
Text GLabel 6950 4550 3    60   Input ~ 0
RX
Text GLabel 7050 4550 3    60   Input ~ 0
TX
Wire Wire Line
	6800 4600 6850 4600
Wire Wire Line
	6850 4600 6850 4550
NoConn ~ 4500 3550
NoConn ~ 4500 3650
NoConn ~ 4500 3850
NoConn ~ 4500 4150
NoConn ~ 3600 4700
NoConn ~ 3700 4700
NoConn ~ 3800 4700
NoConn ~ 6300 4050
$EndSCHEMATC
