Imports System.Threading
Imports System.Net
Imports System.Net.Sockets
Imports System.Text
Imports System.Delegate



Module Udp

    Dim logInfo As String

    '----------------------------------------------------------------------------
    ' UDP Server (11318 för mottagning av Audio)
    '----------------------------------------------------------------------------
    Public RemoteIpEndPoint As New System.Net.IPEndPoint(System.Net.IPAddress.Any, 0)
    Public ThreadReceive As System.Threading.Thread
    Public receivingUdpAudio As UdpClient
    Public UDPAudioStatus As Boolean = True

    'Starta en ny thread för Audiomottagning,
    'Allt som behövs är att kalla udpAudioThread(). Ingen timer/ticks på denna. 
    Public Sub udpAudioThread()
        receivingUdpAudio = New System.Net.Sockets.UdpClient(11318)
        ThreadReceive = New System.Threading.Thread(AddressOf ReceiveAudioMessages)
        ThreadReceive.Start()

    End Sub

    'Skapa servertråden (görs automatiskt från udpAudioThread()
    Public Sub ReceiveAudioMessages()
        While (UDPAudioStatus)

            Try
                Dim receiveBytes As [Byte]() = receivingUdpAudio.Receive(RemoteIpEndPoint)
                Dim BitDet As BitArray
                BitDet = New BitArray(receiveBytes)
                Dim strReturnData As String = System.Text.Encoding.Unicode.GetString(receiveBytes)
                CreateAudioStream(receiveBytes)
            Catch
                MsgBox("Error in UDP (audio) reciever! - Closing server!") 
                UDPAudioStatus = False
                receivingUdpAudio.Close()
            End Try

        End While
    End Sub

    Public Function StopAudioUDP()
        UDPAudioStatus = False
        receivingUdpAudio.Close()
        Return "UDP (audio) stopped!"
    End Function

    '----------------------------------------------------------------------------
    ' UDP Client (11319 för skickande OCH mottagande av status/commands)
    '----------------------------------------------------------------------------

    Public UdpSender As New UdpClient(11319)
    Public Function SendUDP(IP As String, Port As Integer, senddata As Byte())
        'Använd denna om du exempelvis vill skicka en sync eller annat via UDP.
        'Exempelvis SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("1"))

        If senddata.length > "4" Then
            Return "UDP message not sent! Max 4 bytes data!"
        Else
            UdpSender.Connect(IP, Port)
            UdpSender.Send(senddata, senddata.Length)
            UdpSender.Close()
            Return "UDP message sent, ok!"
        End If

    End Function

    Private Sub writeUDPDataStatus(remoteIP As String, data As String)
        'Denna är till för att lägga till udpserver status/data i lbConnections
        logInfo = "IP: " + remoteIP + " Data: " + data + " Längd: " + data.Length.ToString()
        main.Invoke(New writeUDPDataStatusDelegate(AddressOf UDPDataTolbConnections))
    End Sub

    'Denna är till för att lägga till udpserver status/data i lbConnections (thread)
    Public Delegate Sub writeUDPDataStatusDelegate()
    Public Sub UDPDataTolbConnections()

        main.addLog(logInfo)

    End Sub

End Module
