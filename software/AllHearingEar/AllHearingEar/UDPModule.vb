Imports System.Net.Sockets
Imports System.Net
Imports System.Text.Encoding

Module Udp

    '----------------------------------------------------------------------------
    ' UDP Server (11318 för mottagning av Audio)
    '----------------------------------------------------------------------------
    Dim RemoteIpEndPoint As New System.Net.IPEndPoint(System.Net.IPAddress.Any, 11318)
    Dim ThreadReceive As System.Threading.Thread
    Dim receivingUdpAudio As System.Net.Sockets.UdpClient
    Public UDPAudioStatus As Boolean = True
    Dim logInfo As String

    'Starta en ny thread för Audiomottagning,
    'Allt som behövs är att kalla udpAudioThread(). Ingen timer/ticks på denna. 
    Public Sub udpAudioThread()
        ThreadReceive = New System.Threading.Thread(AddressOf ReceiveAudioMessages)
        ThreadReceive.Priority = Threading.ThreadPriority.Highest
        ThreadReceive.Start()
        'writeUDPDataStatus("0", "UDP (audio) started!") 'Log 'Använd denna raden för debug.
    End Sub

    'Skapa servertråden (görs automatiskt från udpAudioThread()
    Dim receiveBytes As New List(Of Byte()) ' A List of Byte Arrays per index, not just single bytes per index.

    Private Sub ReceiveAudioMessages()
        Try
            Do
                If UDPAudioStatus = True Then
                    receivingUdpAudio = New UdpClient(11318)
                    receiveBytes.Add(receivingUdpAudio.Receive(RemoteIpEndPoint))
                    receivingUdpAudio.Close()
                Else
                    writeUDPDataStatus("0", "Error In UDP (audio) reciever! - Closing server!") 'Log
                    Exit Do
                End If
                'Invoke(New CollectUDPdataStreamDelegate(AddressOf CollectUDPdataStream))

                If receiveBytes.Count > 50 Then ' (Testing at 2 seconds data) Should be 32000 bytes or 1 second of recorded data. 25 * 1280 bytes per rcvd packet = 32000 bytes.
                    CreateAudioStream(receiveBytes)
                End If

            Loop

        Catch ex As Exception
        End Try
    End Sub

    Public Function StopAudioUDP()
        'Plockade bort raden UDPAudioStatus = False efter krock med start av UDP igen. Vilket löste problemet.
        'UDPAudioStatus = False
        receivingUdpAudio.Close()
        'writeUDPDataStatus("0", "UDP (audio) stopped!") 'Använd denna raden för debug.
        Return "UDP (audio) stopped!"

    End Function

    '----------------------------------------------------------------------------
    ' UDP Client (11319 för skickande OCH mottagande av status/commands)
    '----------------------------------------------------------------------------

    Public UdpSender As New UdpClient(11319)
    Public Function SendUDP(IP As String, Port As Integer, senddata As Byte())

        'Använd denna om du exempelvis vill skicka en sync eller annat via UDP.
        'Exempelvis SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("1"))

        If senddata.Length > "4" Then
            Return "UDP message not sent! Max 4 bytes data!"
        Else

            UdpSender.EnableBroadcast = True
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