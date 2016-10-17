﻿Imports System.Threading
Imports System.Net
Imports System.Net.Sockets
Imports System.Text


Module Udp
    Public UDPRevStatus As Boolean = True

    Public UdpSender As New UdpClient(11319)

    Public receivingUdpClient As UdpClient
    Public RemoteIpEndPoint As New System.Net.IPEndPoint(System.Net.IPAddress.Any, 0)
    Public ThreadReceive As System.Threading.Thread



    'Starta en ny thread för servern
    Public Sub udpThread()

        receivingUdpClient = New System.Net.Sockets.UdpClient(11318)
        ThreadReceive = New System.Threading.Thread(AddressOf ReceiveMessages)
        ThreadReceive.Start()

    End Sub

    'Skapa servertråden
    Public Sub ReceiveMessages()

        While (UDPRevStatus)

            Try
                Dim receiveBytes As [Byte]() = receivingUdpClient.Receive(RemoteIpEndPoint)

                Dim BitDet As BitArray
                BitDet = New BitArray(receiveBytes)

                Dim strReturnData As String = System.Text.Encoding.Unicode.GetString(receiveBytes)

                CreateAudioStream(receiveBytes)

            Catch
                MsgBox("Error in UDP reciever!")
                UDPRevStatus = False
                receivingUdpClient.Close()
            End Try


        End While

    End Sub

    Public Function SendUDP(IP As String, Port As Integer, senddata As Byte())
        'Använd denna om du exempelvis vill skicka en sync eller annat via UDP.
        'Exempelvis SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("1"))

        UdpSender.Connect(IP, Port)
        UdpSender.Send(senddata, senddata.Length)
        UdpSender.Close()
        Return "Sync sent"

    End Function


End Module
