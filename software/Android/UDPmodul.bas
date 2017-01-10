Type=Service
Version=5.02
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public UDPsocket1 As UDPSocket
	Dim UDPsocket2 As UDPSocket
	Dim UDPsocket3 As UDPSocket
	Private Timer1 As Timer
	Dim streamer As AudioStreamer
	Private Ticks As Int
	Public ConnectionStatus As Boolean = False
	Public AHEIP As String
	Public Unit1 As String
	Public Unit2 As String
	Public Unit3 As String
	Public Unit4 As String
	Dim notis As Notification
End Sub

Sub Service_Create
	UDPsocket3.Initialize("UDP", 11318, 1400)
	UDPsocket2.Initialize("UDP", 11320, 2)
	UDPsocket1.Initialize("UDP", 11319, 2)
	streamer.Initialize("streamer", 10000, False, 16, streamer.VOLUME_MUSIC)
	Timer1.Initialize("Timer1", 1000)
	Timer1.Enabled =False
		'Uppdatera UI vid start av app.
	Unit1 = "Disconnected"
	Unit2 = "Press Sync AHE to synchronize."
	UpdateUI
	SendUDP(UDPsocket1, "0", "192.168.1.255", 11319)
	
	'Ikon visas på toppen av telefonen.
	notis.Initialize
	notis.Icon="icon"
	notis.Vibrate=True
	notis.Sound=True
	
	
		
End Sub
	
Sub Service_Start (StartingIntent As Intent)
	
End Sub

Sub Service_Destroy
	UDPsocket1.Close
	UDPsocket2.Close
	UDPsocket3.Close
	notis.Cancel(1)
End Sub

'Lyssna efter UDPpacket från AHE
Sub UDP_PacketArrived(Packet As UDPPacket)
	
	Dim msg As String
	msg = BytesToString(Packet.Data, Packet.Offset, Packet.Length, "UTF8")
	Unit3 = msg

	If AHEIP = "" And msg = "1" Then
	AHEIP = Packet.HostAddress
	End If
	
	If AHEIP <> "" And ConnectionStatus = False And msg = "1" Then
		ConnectionStatus=True
		ToastMessageShow("You are connected", True)
		Unit1 = "Connected to: " & Packet.HostAddress
		Unit2 = "Connected"
		Unit3 = ""
		Unit4 =""
		Timer1.Enabled = True
		notis.SetInfo("All hearing ear", "All hearing ear is connected", Me)
		notis.Notify(1)
		UpdateUI

	End If
	
	'Plocka bort 1-orna från streamen samt återställa räknaren(?)
	If msg = "1" And ConnectionStatus = True Then
	Ticks = 0
	Else
	astream_NewData(Packet.Data)
	Ticks = 0
	End If

End Sub

'UDPsender
Sub SendUDP(SocketA As UDPSocket, Command As String, IPadress As String, Port As String)
	Dim Packet As UDPPacket
	Dim data() As Byte
	data = Command.GetBytes("UTF8")
	Packet.Initialize(data, IPadress, Port)
	SocketA.Send(Packet)
End Sub

Sub BtnSync
	SendUDP(UDPsocket1, "0", "192.168.1.255", 11319)
End Sub

'Timer1 kod (Uppdatera interface med rätt information för användaren. (ConnectionStatus, Färger, meddelanden)

Sub Timer1_Tick

	Ticks = Ticks + 1
	Unit4 = Ticks

	UpdateUI
	
	If Ticks > 8 And AHEIP <> "" Then
			
			SendUDP(UDPsocket1, "0", AHEIP, 11319)
			
	End If
		If Ticks > 11 Then
		ConnectionStatus = False
			ToastMessageShow("You lost connection to AHE", True)
			Unit1 = AHEIP
			Unit2 ="Status: Disconnected"
			Unit3 ="Try pressing the Sync AHE button!"
			Unit4 ="Check that your hardware is powered!"
			notis.SetInfo("All hearing ear", "You lost connection to All hearing ear", Me)
			notis.Notify(1)
			Timer1.Enabled = False
			Ticks = 0

			UpdateUI
	End If
	
End Sub

'AudioStream#######################################################

Sub astream_NewData (Buffer() As Byte)
	streamer.Write(Buffer)
	If Main.mute = False Then
	streamer.StartPlaying
	End If
End Sub
'###################################################################

Sub astream_Stop
	streamer.StopPlaying
End Sub

'Uppdatera User Interface
Private Sub UpdateUI
	CallSub(Main, "UpdateUI")
End Sub	

