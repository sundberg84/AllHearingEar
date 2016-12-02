Imports System.Net.Sockets
Imports System.Net
Imports System.Text.Encoding


Module Udp

    Dim logInfo As String

    '----------------------------------------------------------------------------
    ' UDP Server (11318 för mottagning av Audio)
    '----------------------------------------------------------------------------
    Public RemoteIpEndPoint As New System.Net.IPEndPoint(System.Net.IPAddress.Any, 11318)
    Public ThreadReceive As System.Threading.Thread
    Public receivingUdpAudio As New System.Net.Sockets.UdpClient(11318)
    Public UDPAudioStatus As Boolean = True

    'Starta en ny thread för Audiomottagning,
    'Allt som behövs är att kalla udpAudioThread(). Ingen timer/ticks på denna. 
    Public Sub udpAudioThread()
        ThreadReceive = New System.Threading.Thread(AddressOf ReceiveAudioMessages)
        ThreadReceive.Start()
        writeUDPDataStatus("0", "UDP (audio) started!") 'Log
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
                writeUDPDataStatus("0", "Error in UDP (audio) reciever! - Closing server!")
                UDPAudioStatus = False
                receivingUdpAudio.Close()
                writeUDPDataStatus("0", "Error In UDP (audio) reciever! - Closing server!") 'Log
            End Try

        End While
    End Sub

    Public Function StopAudioUDP()
        UDPAudioStatus = False
        receivingUdpAudio.Close()
        Return "UDP (audio) stopped!"
        writeUDPDataStatus("0", "UDP (audio) stopped!") 'Log
    End Function

    '----------------------------------------------------------------------------
    ' UDP Client (11319 för skickande OCH mottagande av status/commands)
    '----------------------------------------------------------------------------

    Public UdpSender As New UdpClient(0)
    Public Function SendUDP(IP As String, Port As Integer, senddata As Byte())

        'Använd denna om du exempelvis vill skicka en sync eller annat via UDP.
        'Exempelvis SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("1"))

        If senddata.Length > "4" Then
            Return "UDP message not sent! Max 4 bytes data!"
        Else
            UdpSender.Connect(IP, Port)
            UdpSender.Send(senddata, senddata.Length)
            'UdpSender.Close()
            Return "UDP message sent, ok!"
        End If

    End Function

    Private Sub writeUDPDataStatus(remoteIP As String, data As String)
        'Denna är till för att lägga till udpserver status/data i lbConnections - skapar koppling modul och main.
        'För att kalla en logfunktion från modulen skriv: writeUDPDataStatus(remoteIP, data) så hamnar detta i lbConnections
        If remoteIP = "0" Then
            logInfo = data
        Else
            logInfo = "IP: " + remoteIP + " Data: " + data + " Längd: " + data.Length.ToString()
        End If
        main.Invoke(New writeUDPDataStatusDelegate(AddressOf UDPDataTolbConnections))
    End Sub

    'Denna är till för att lägga till udpserver status/data i lbConnections (thread)
    Public Delegate Sub writeUDPDataStatusDelegate()
    Public Sub UDPDataTolbConnections()
        main.addLog(logInfo)
    End Sub

End Module