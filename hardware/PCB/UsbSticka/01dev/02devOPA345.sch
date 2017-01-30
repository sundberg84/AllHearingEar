EESchema Schematic File Version 2
LIBS:02devOPA345-rescue
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
LIBS:andreas_footprints
LIBS:ferrite
LIBS:02devOPA345-cache
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
L USB_B P1
U 1 1 58495BE0
P 2700 1800
F 0 "P1" H 2900 1600 50  0000 C CNN
F 1 "USB_B" H 2650 2000 50  0000 C CNN
F 2 "ASKicadLib:USB_A_AS" V 2650 1700 50  0001 C CNN
F 3 "" V 2650 1700 50  0000 C CNN
	1    2700 1800
	0    -1   -1   0   
$EndComp
$Comp
L LM1117-3.3 U1
U 1 1 58495D09
P 3850 2000
F 0 "U1" H 3950 1750 50  0000 C CNN
F 1 "LM1117-3.3" H 3850 2250 50  0000 C CNN
F 2 "TO_SOT_Packages_SMD:SOT-223" H 3850 2000 50  0001 C CNN
F 3 "" H 3850 2000 50  0000 C CNN
	1    3850 2000
	1    0    0    -1  
$EndComp
$Comp
L ESP-07v2 U2
U 1 1 58495FE2
P 5750 2100
F 0 "U2" H 5750 2000 50  0000 C CNN
F 1 "ESP-07v2" H 5750 2200 50  0000 C CNN
F 2 "ASKicadLib:ESP-07_AS" H 5750 2100 50  0001 C CNN
F 3 "" H 5750 2100 50  0001 C CNN
	1    5750 2100
	1    0    0    -1  
$EndComp
$Comp
L MCP3201 U4
U 1 1 58495F1E
P 7850 4250
F 0 "U4" H 7650 4550 50  0000 L CNN
F 1 "MCP3201" H 8050 4550 50  0000 L CNN
F 2 "Power_Integrations:PDIP-8" H 7850 4250 50  0001 C CIN
F 3 "" H 7850 4250 50  0000 C CNN
	1    7850 4250
	1    0    0    -1  
$EndComp
$Comp
L CONN_01X03 P2
U 1 1 58496661
P 7200 1800
F 0 "P2" H 7200 2000 50  0000 C CNN
F 1 "Debug" V 7300 1800 50  0000 C CNN
F 2 "Socket_Strips:Socket_Strip_Straight_1x03" H 7200 1800 50  0001 C CNN
F 3 "" H 7200 1800 50  0000 C CNN
	1    7200 1800
	1    0    0    -1  
$EndComp
$Comp
L C C2
U 1 1 58496BB4
P 3250 2250
F 0 "C2" H 3275 2350 50  0000 L CNN
F 1 "10uF" H 3275 2150 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 3288 2100 50  0001 C CNN
F 3 "" H 3250 2250 50  0000 C CNN
	1    3250 2250
	1    0    0    -1  
$EndComp
$Comp
L C C1
U 1 1 58496C2E
P 4250 2200
F 0 "C1" H 4275 2300 50  0000 L CNN
F 1 "0,1uF" H 4275 2100 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 4288 2050 50  0001 C CNN
F 3 "" H 4250 2200 50  0000 C CNN
	1    4250 2200
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR14
U 1 1 58496CB6
P 3250 2450
F 0 "#PWR14" H 3250 2200 50  0001 C CNN
F 1 "GND" H 3250 2300 50  0000 C CNN
F 2 "" H 3250 2450 50  0000 C CNN
F 3 "" H 3250 2450 50  0000 C CNN
	1    3250 2450
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR11
U 1 1 58496D02
P 3850 2350
F 0 "#PWR11" H 3850 2100 50  0001 C CNN
F 1 "GND" H 3850 2200 50  0000 C CNN
F 2 "" H 3850 2350 50  0000 C CNN
F 3 "" H 3850 2350 50  0000 C CNN
	1    3850 2350
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR12
U 1 1 58496D25
P 4250 2400
F 0 "#PWR12" H 4250 2150 50  0001 C CNN
F 1 "GND" H 4250 2250 50  0000 C CNN
F 2 "" H 4250 2400 50  0000 C CNN
F 3 "" H 4250 2400 50  0000 C CNN
	1    4250 2400
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR6
U 1 1 58496D48
P 3100 1700
F 0 "#PWR6" H 3100 1450 50  0001 C CNN
F 1 "GND" H 3100 1550 50  0000 C CNN
F 2 "" H 3100 1700 50  0000 C CNN
F 3 "" H 3100 1700 50  0000 C CNN
	1    3100 1700
	0    -1   -1   0   
$EndComp
NoConn ~ 3000 1900
NoConn ~ 3000 1800
$Comp
L GND #PWR2
U 1 1 58496E15
P 2600 1450
F 0 "#PWR2" H 2600 1200 50  0001 C CNN
F 1 "GND" H 2600 1300 50  0000 C CNN
F 2 "" H 2600 1450 50  0000 C CNN
F 3 "" H 2600 1450 50  0000 C CNN
	1    2600 1450
	-1   0    0    1   
$EndComp
$Comp
L R R2
U 1 1 58496E46
P 4600 2000
F 0 "R2" V 4680 2000 50  0000 C CNN
F 1 "10k" V 4600 2000 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 4530 2000 50  0001 C CNN
F 3 "" H 4600 2000 50  0000 C CNN
	1    4600 2000
	0    1    1    0   
$EndComp
$Comp
L VCC #PWR1
U 1 1 58496F27
P 5750 1150
F 0 "#PWR1" H 5750 1000 50  0001 C CNN
F 1 "VCC" H 5750 1300 50  0000 C CNN
F 2 "" H 5750 1150 50  0000 C CNN
F 3 "" H 5750 1150 50  0000 C CNN
	1    5750 1150
	1    0    0    -1  
$EndComp
NoConn ~ 4850 1800
NoConn ~ 4850 1900
NoConn ~ 4850 2100
NoConn ~ 4850 2400
Text GLabel 4800 2200 0    60   Input ~ 0
SCLK
Text GLabel 4800 2300 0    60   Input ~ 0
MISO
$Comp
L VCC #PWR7
U 1 1 5849724E
P 4350 1700
F 0 "#PWR7" H 4350 1550 50  0001 C CNN
F 1 "VCC" H 4350 1850 50  0000 C CNN
F 2 "" H 4350 1700 50  0000 C CNN
F 3 "" H 4350 1700 50  0000 C CNN
	1    4350 1700
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR5
U 1 1 58497429
P 6950 1650
F 0 "#PWR5" H 6950 1400 50  0001 C CNN
F 1 "GND" H 6950 1500 50  0000 C CNN
F 2 "" H 6950 1650 50  0000 C CNN
F 3 "" H 6950 1650 50  0000 C CNN
	1    6950 1650
	-1   0    0    1   
$EndComp
$Comp
L R R1
U 1 1 584974BB
P 7600 1800
F 0 "R1" V 7680 1800 50  0000 C CNN
F 1 "10k" V 7600 1800 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 7530 1800 50  0001 C CNN
F 3 "" H 7600 1800 50  0000 C CNN
	1    7600 1800
	1    0    0    -1  
$EndComp
$Comp
L SW_PUSH SW1
U 1 1 5849753C
P 7950 2000
F 0 "SW1" H 8100 2110 50  0000 C CNN
F 1 "SW_PUSH" H 7950 1920 50  0000 C CNN
F 2 "Buttons_Switches_SMD:SW_SPST_EVQPE1" H 7950 2000 50  0001 C CNN
F 3 "" H 7950 2000 50  0000 C CNN
	1    7950 2000
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR3
U 1 1 58497756
P 7600 1600
F 0 "#PWR3" H 7600 1350 50  0001 C CNN
F 1 "GND" H 7600 1450 50  0000 C CNN
F 2 "" H 7600 1600 50  0000 C CNN
F 3 "" H 7600 1600 50  0000 C CNN
	1    7600 1600
	-1   0    0    1   
$EndComp
$Comp
L VCC #PWR9
U 1 1 584977A9
P 8300 2000
F 0 "#PWR9" H 8300 1850 50  0001 C CNN
F 1 "VCC" H 8300 2150 50  0000 C CNN
F 2 "" H 8300 2000 50  0000 C CNN
F 3 "" H 8300 2000 50  0000 C CNN
	1    8300 2000
	0    1    1    0   
$EndComp
NoConn ~ 6650 2100
NoConn ~ 6650 2300
$Comp
L SW_PUSH SW2
U 1 1 5849792E
P 7100 2200
F 0 "SW2" H 7250 2310 50  0000 C CNN
F 1 "SW_PUSH" H 7100 2120 50  0000 C CNN
F 2 "Buttons_Switches_SMD:SW_SPST_EVQPE1" H 7100 2200 50  0001 C CNN
F 3 "" H 7100 2200 50  0000 C CNN
	1    7100 2200
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR10
U 1 1 584979DE
P 7450 2200
F 0 "#PWR10" H 7450 1950 50  0001 C CNN
F 1 "GND" H 7450 2050 50  0000 C CNN
F 2 "" H 7450 2200 50  0000 C CNN
F 3 "" H 7450 2200 50  0000 C CNN
	1    7450 2200
	0    -1   -1   0   
$EndComp
Text GLabel 6800 2400 2    60   Input ~ 0
SS
$Comp
L GND #PWR16
U 1 1 58497BC9
P 5750 3050
F 0 "#PWR16" H 5750 2800 50  0001 C CNN
F 1 "GND" H 5750 2900 50  0000 C CNN
F 2 "" H 5750 3050 50  0000 C CNN
F 3 "" H 5750 3050 50  0000 C CNN
	1    5750 3050
	1    0    0    -1  
$EndComp
$Comp
L R R3
U 1 1 58497D8F
P 6700 2600
F 0 "R3" V 6780 2600 50  0000 C CNN
F 1 "10k" V 6700 2600 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 6630 2600 50  0001 C CNN
F 3 "" H 6700 2600 50  0000 C CNN
	1    6700 2600
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR15
U 1 1 58497DF0
P 6700 2800
F 0 "#PWR15" H 6700 2550 50  0001 C CNN
F 1 "GND" H 6700 2650 50  0000 C CNN
F 2 "" H 6700 2800 50  0000 C CNN
F 3 "" H 6700 2800 50  0000 C CNN
	1    6700 2800
	1    0    0    -1  
$EndComp
Text GLabel 8400 4350 2    60   Input ~ 0
SCLK
Text GLabel 8750 4250 2    60   Input ~ 0
MISO
Text GLabel 8400 4150 2    60   Input ~ 0
SS
$Comp
L GND #PWR23
U 1 1 58498754
P 7950 4800
F 0 "#PWR23" H 7950 4550 50  0001 C CNN
F 1 "GND" H 7950 4650 50  0000 C CNN
F 2 "" H 7950 4800 50  0000 C CNN
F 3 "" H 7950 4800 50  0000 C CNN
	1    7950 4800
	1    0    0    -1  
$EndComp
$Comp
L C C5
U 1 1 584989F9
P 8150 3800
F 0 "C5" H 8175 3900 50  0000 L CNN
F 1 "0,1" H 8175 3700 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 8188 3650 50  0001 C CNN
F 3 "" H 8150 3800 50  0000 C CNN
	1    8150 3800
	0    1    1    0   
$EndComp
$Comp
L GND #PWR19
U 1 1 58498B1C
P 8350 3800
F 0 "#PWR19" H 8350 3550 50  0001 C CNN
F 1 "GND" H 8350 3650 50  0000 C CNN
F 2 "" H 8350 3800 50  0000 C CNN
F 3 "" H 8350 3800 50  0000 C CNN
	1    8350 3800
	0    -1   -1   0   
$EndComp
$Comp
L C C10
U 1 1 58499029
P 7600 4850
F 0 "C10" H 7625 4950 50  0000 L CNN
F 1 "0,1" H 7625 4750 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 7638 4700 50  0001 C CNN
F 3 "" H 7600 4850 50  0000 C CNN
	1    7600 4850
	0    -1   -1   0   
$EndComp
$Comp
L GND #PWR24
U 1 1 584993C0
P 7450 4850
F 0 "#PWR24" H 7450 4600 50  0001 C CNN
F 1 "GND" H 7450 4700 50  0000 C CNN
F 2 "" H 7450 4850 50  0000 C CNN
F 3 "" H 7450 4850 50  0000 C CNN
	1    7450 4850
	0    1    1    0   
$EndComp
$Comp
L FERRITE FB1
U 1 1 5849DA18
P 6300 3700
F 0 "FB1" H 6225 3625 40  0000 L CNN
F 1 "FERRITE" H 6225 3550 40  0000 L CNN
F 2 "Capacitors_SMD:C_0805_HandSoldering" H 6300 3600 60  0001 C CNN
F 3 "" H 6300 3600 60  0000 C CNN
	1    6300 3700
	0    -1   -1   0   
$EndComp
$Comp
L GNDA #PWR4
U 1 1 5849F85B
P 3050 1650
F 0 "#PWR4" H 3050 1400 50  0001 C CNN
F 1 "GNDA" H 3050 1500 50  0000 C CNN
F 2 "" H 3050 1650 50  0000 C CNN
F 3 "" H 3050 1650 50  0000 C CNN
	1    3050 1650
	-1   0    0    1   
$EndComp
$Comp
L +5V #PWR8
U 1 1 584C9DC3
P 3450 1900
F 0 "#PWR8" H 3450 1750 50  0001 C CNN
F 1 "+5V" H 3450 2040 50  0000 C CNN
F 2 "" H 3450 1900 50  0000 C CNN
F 3 "" H 3450 1900 50  0000 C CNN
	1    3450 1900
	1    0    0    -1  
$EndComp
$Comp
L GNDA #PWR21
U 1 1 584C9864
P 2650 4200
F 0 "#PWR21" H 2650 3950 50  0001 C CNN
F 1 "GNDA" H 2650 4050 50  0000 C CNN
F 2 "" H 2650 4200 50  0000 C CNN
F 3 "" H 2650 4200 50  0000 C CNN
	1    2650 4200
	0    -1   -1   0   
$EndComp
$Comp
L CONN_01X02 P3
U 1 1 58497FE6
P 2200 4150
F 0 "P3" H 2200 4300 50  0000 C CNN
F 1 "MIC" V 2300 4150 50  0000 C CNN
F 2 "Socket_Strips:Socket_Strip_Straight_1x02" H 2200 4150 50  0001 C CNN
F 3 "" H 2200 4150 50  0000 C CNN
	1    2200 4150
	-1   0    0    1   
$EndComp
$Comp
L R R7
U 1 1 5883C011
P 3600 4100
F 0 "R7" V 3680 4100 50  0000 C CNN
F 1 "10k" V 3600 4100 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 3530 4100 50  0001 C CNN
F 3 "" H 3600 4100 50  0000 C CNN
	1    3600 4100
	0    1    1    0   
$EndComp
$Comp
L C C7
U 1 1 5883C0F0
P 3050 4100
F 0 "C7" H 3075 4200 50  0000 L CNN
F 1 "4,7" H 3075 4000 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 3088 3950 50  0001 C CNN
F 3 "" H 3050 4100 50  0000 C CNN
	1    3050 4100
	0    -1   -1   0   
$EndComp
$Comp
L R R5
U 1 1 5883C2C5
P 2700 3850
F 0 "R5" V 2780 3850 50  0000 C CNN
F 1 "2,2k" V 2700 3850 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 2630 3850 50  0001 C CNN
F 3 "" H 2700 3850 50  0000 C CNN
	1    2700 3850
	-1   0    0    1   
$EndComp
$Comp
L R R9
U 1 1 5883C67A
P 3400 4550
F 0 "R9" V 3480 4550 50  0000 C CNN
F 1 "10k" V 3400 4550 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 3330 4550 50  0001 C CNN
F 3 "" H 3400 4550 50  0000 C CNN
	1    3400 4550
	1    0    0    -1  
$EndComp
$Comp
L R R6
U 1 1 5883C74A
P 3400 3900
F 0 "R6" V 3480 3900 50  0000 C CNN
F 1 "10k" V 3400 3900 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 3330 3900 50  0001 C CNN
F 3 "" H 3400 3900 50  0000 C CNN
	1    3400 3900
	1    0    0    -1  
$EndComp
$Comp
L GNDA #PWR25
U 1 1 5883C9E5
P 3400 5000
F 0 "#PWR25" H 3400 4750 50  0001 C CNN
F 1 "GNDA" H 3400 4850 50  0000 C CNN
F 2 "" H 3400 5000 50  0000 C CNN
F 3 "" H 3400 5000 50  0000 C CNN
	1    3400 5000
	1    0    0    -1  
$EndComp
$Comp
L C C9
U 1 1 5883CA35
P 3200 4550
F 0 "C9" H 3225 4650 50  0000 L CNN
F 1 "4,7" H 3225 4450 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 3238 4400 50  0001 C CNN
F 3 "" H 3200 4550 50  0000 C CNN
	1    3200 4550
	-1   0    0    1   
$EndComp
$Comp
L VCC #PWR17
U 1 1 5887A831
P 6300 3500
F 0 "#PWR17" H 6300 3350 50  0001 C CNN
F 1 "VCC" H 6300 3650 50  0000 C CNN
F 2 "" H 6300 3500 50  0000 C CNN
F 3 "" H 6300 3500 50  0000 C CNN
	1    6300 3500
	1    0    0    -1  
$EndComp
Wire Wire Line
	3000 2000 3550 2000
Wire Wire Line
	3250 2000 3250 2100
Connection ~ 3250 2000
Wire Wire Line
	3000 1700 3100 1700
Wire Wire Line
	3850 2300 3850 2350
Wire Wire Line
	3250 2400 3250 2450
Wire Wire Line
	4250 2350 4250 2400
Wire Wire Line
	4150 2000 4450 2000
Wire Wire Line
	4250 2050 4250 2000
Connection ~ 4250 2000
Wire Wire Line
	2600 1450 2600 1500
Wire Wire Line
	4850 2000 4750 2000
Wire Wire Line
	5750 1200 5750 1150
Wire Wire Line
	4850 2200 4800 2200
Wire Wire Line
	4850 2300 4800 2300
Connection ~ 4350 2000
Wire Wire Line
	4350 2000 4350 1700
Wire Wire Line
	7000 1800 6650 1800
Wire Wire Line
	6650 1900 7000 1900
Wire Wire Line
	7000 1700 6950 1700
Wire Wire Line
	6950 1700 6950 1650
Wire Wire Line
	6650 2000 7650 2000
Wire Wire Line
	7600 2000 7600 1950
Connection ~ 7600 2000
Wire Wire Line
	7600 1650 7600 1600
Wire Wire Line
	8250 2000 8300 2000
Wire Wire Line
	6650 2200 6800 2200
Wire Wire Line
	7400 2200 7450 2200
Wire Wire Line
	6650 2400 6800 2400
Connection ~ 6700 2400
Wire Wire Line
	5750 3000 5750 3050
Wire Wire Line
	6700 2400 6700 2450
Wire Wire Line
	6700 2750 6700 2800
Wire Wire Line
	8350 4350 8400 4350
Wire Wire Line
	8350 4250 8750 4250
Wire Wire Line
	8350 4150 8400 4150
Wire Wire Line
	7950 4650 7950 4800
Wire Wire Line
	7950 3700 7950 3850
Wire Wire Line
	7950 3800 8000 3800
Connection ~ 7950 3800
Wire Wire Line
	8300 3800 8350 3800
Wire Wire Line
	7200 4150 7350 4150
Wire Wire Line
	3050 1700 3050 1650
Connection ~ 3050 1700
Connection ~ 3450 2000
Wire Wire Line
	3450 2000 3450 1900
Wire Wire Line
	3200 4100 3450 4100
Wire Wire Line
	2400 4100 2900 4100
Wire Wire Line
	2700 4100 2700 4000
Connection ~ 2700 4100
Wire Wire Line
	2700 3450 2700 3700
Connection ~ 3400 4250
Wire Wire Line
	3400 3450 3400 3750
Wire Wire Line
	3400 4700 3400 5000
Wire Wire Line
	3200 4400 3200 4350
Wire Wire Line
	3200 4350 3400 4350
Connection ~ 3400 4350
Wire Wire Line
	3200 4700 3200 4750
Wire Wire Line
	3200 4750 3400 4750
Connection ~ 3400 4750
Wire Wire Line
	2400 4200 2650 4200
Wire Wire Line
	3400 4050 3400 4400
$Comp
L R R4
U 1 1 5883BDB3
P 4400 3250
F 0 "R4" V 4480 3250 50  0000 C CNN
F 1 "820k" V 4400 3250 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 4330 3250 50  0001 C CNN
F 3 "" H 4400 3250 50  0000 C CNN
	1    4400 3250
	0    1    1    0   
$EndComp
Wire Wire Line
	4300 3900 4300 3850
Wire Wire Line
	4300 3850 5300 3850
$Comp
L C C4
U 1 1 588A3AB8
P 4250 3650
F 0 "C4" H 4275 3750 50  0000 L CNN
F 1 "0,1" H 4275 3550 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 4288 3500 50  0001 C CNN
F 3 "" H 4250 3650 50  0000 C CNN
	1    4250 3650
	0    1    1    0   
$EndComp
$Comp
L GND #PWR18
U 1 1 588A3B8A
P 4050 3650
F 0 "#PWR18" H 4050 3400 50  0001 C CNN
F 1 "GND" H 4050 3500 50  0000 C CNN
F 2 "" H 4050 3650 50  0000 C CNN
F 3 "" H 4050 3650 50  0000 C CNN
	1    4050 3650
	0    1    1    0   
$EndComp
$Comp
L OPA345 U3
U 1 1 588A36DC
P 4300 4250
F 0 "U3" H 4450 4250 50  0000 C CNN
F 1 "OPA345" V 4200 4250 50  0000 C CNN
F 2 "TO_SOT_Packages_SMD:SOT-23-5" H 4650 4000 50  0001 C CIN
F 3 "" H 4300 4250 50  0000 C CNN
	1    4300 4250
	1    0    0    -1  
$EndComp
Wire Wire Line
	4850 4250 5750 4250
Wire Wire Line
	5050 3050 5050 4250
Wire Wire Line
	3800 3050 3800 4100
Wire Wire Line
	3750 4100 3850 4100
Connection ~ 5050 4250
Wire Wire Line
	5050 3250 4550 3250
Wire Wire Line
	4250 3250 3800 3250
Connection ~ 5050 3250
Connection ~ 3800 3250
$Comp
L C C3
U 1 1 588A4569
P 4400 3050
F 0 "C3" H 4425 3150 50  0000 L CNN
F 1 "0,1" H 4425 2950 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 4438 2900 50  0001 C CNN
F 3 "" H 4400 3050 50  0000 C CNN
	1    4400 3050
	0    1    1    0   
$EndComp
Wire Wire Line
	4250 3050 3800 3050
Wire Wire Line
	4550 3050 5050 3050
Wire Wire Line
	4050 3650 4100 3650
Wire Wire Line
	4400 3650 4500 3650
Wire Wire Line
	4500 3650 4500 3850
Connection ~ 4500 3850
Connection ~ 3800 4100
Wire Wire Line
	3400 4250 3700 4250
Wire Wire Line
	3700 4250 3700 4450
Wire Wire Line
	3700 4450 3850 4450
Wire Wire Line
	4300 4600 4300 4750
Wire Wire Line
	4300 4750 4750 4750
Wire Wire Line
	5300 3850 5300 4100
Wire Wire Line
	5300 4100 6850 4100
Wire Wire Line
	6300 3800 6300 4100
Wire Wire Line
	6850 3700 6850 5000
Wire Wire Line
	6850 5000 7750 5000
Wire Wire Line
	7750 5000 7750 4650
Connection ~ 6300 4100
Connection ~ 7750 4850
Wire Wire Line
	6300 3500 6300 3600
$Comp
L R R8
U 1 1 588A6540
P 5900 4250
F 0 "R8" V 5980 4250 50  0000 C CNN
F 1 "500" V 5900 4250 50  0000 C CNN
F 2 "Resistors_SMD:R_0805" V 5830 4250 50  0001 C CNN
F 3 "" H 5900 4250 50  0000 C CNN
	1    5900 4250
	0    1    1    0   
$EndComp
Wire Wire Line
	6050 4250 7200 4250
Wire Wire Line
	7200 4250 7200 4150
Wire Wire Line
	6100 4250 6100 4350
Connection ~ 6100 4250
$Comp
L C C8
U 1 1 588A67A8
P 6100 4500
F 0 "C8" H 6125 4600 50  0000 L CNN
F 1 "3300pF" H 6125 4400 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 6138 4350 50  0001 C CNN
F 3 "" H 6100 4500 50  0000 C CNN
	1    6100 4500
	1    0    0    -1  
$EndComp
Wire Wire Line
	6100 4650 6100 4750
$Comp
L GND #PWR22
U 1 1 588A68A8
P 6100 4750
F 0 "#PWR22" H 6100 4500 50  0001 C CNN
F 1 "GND" H 6100 4600 50  0000 C CNN
F 2 "" H 6100 4750 50  0000 C CNN
F 3 "" H 6100 4750 50  0000 C CNN
	1    6100 4750
	1    0    0    -1  
$EndComp
Wire Wire Line
	7350 4350 6500 4350
Wire Wire Line
	6500 4350 6500 4700
Wire Wire Line
	6500 4700 4750 4700
Connection ~ 6100 4700
Wire Wire Line
	4750 4700 4750 4750
Wire Wire Line
	4750 3850 4750 3450
Wire Wire Line
	4750 3450 2700 3450
Connection ~ 4750 3850
Connection ~ 3400 3450
$Comp
L C C11
U 1 1 588A6AF9
P 3050 2250
F 0 "C11" H 3075 2350 50  0000 L CNN
F 1 "0,1uF" H 3075 2150 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 3088 2100 50  0001 C CNN
F 3 "" H 3050 2250 50  0000 C CNN
	1    3050 2250
	1    0    0    -1  
$EndComp
$Comp
L GND #PWR13
U 1 1 588A6B83
P 3050 2450
F 0 "#PWR13" H 3050 2200 50  0001 C CNN
F 1 "GND" H 3050 2300 50  0000 C CNN
F 2 "" H 3050 2450 50  0000 C CNN
F 3 "" H 3050 2450 50  0000 C CNN
	1    3050 2450
	1    0    0    -1  
$EndComp
Wire Wire Line
	3050 2450 3050 2400
Wire Wire Line
	3050 2100 3050 2000
Connection ~ 3050 2000
Wire Wire Line
	7950 3700 6850 3700
Connection ~ 6850 4100
Wire Wire Line
	6300 3550 6200 3550
Connection ~ 6300 3550
$Comp
L C C?
U 1 1 588CCCA0
P 6050 3550
F 0 "C?" H 6075 3650 50  0000 L CNN
F 1 "0,1uF" H 6075 3450 50  0000 L CNN
F 2 "Capacitors_SMD:C_0805" H 6088 3400 50  0001 C CNN
F 3 "" H 6050 3550 50  0000 C CNN
	1    6050 3550
	0    1    1    0   
$EndComp
Wire Wire Line
	5900 3550 5850 3550
$Comp
L GND #PWR?
U 1 1 588CCE7C
P 5850 3550
F 0 "#PWR?" H 5850 3300 50  0001 C CNN
F 1 "GND" H 5850 3400 50  0000 C CNN
F 2 "" H 5850 3550 50  0000 C CNN
F 3 "" H 5850 3550 50  0000 C CNN
	1    5850 3550
	0    1    1    0   
$EndComp
$EndSCHEMATC
