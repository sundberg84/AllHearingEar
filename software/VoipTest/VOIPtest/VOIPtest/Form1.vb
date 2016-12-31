Option Strict On

Imports NAudio.Wave
Imports System.Net
Imports System.Net.Sockets

Public Class Form1

    Dim TimeIt1 As New Stopwatch ' For testing
    Dim TimeIt2 As New Stopwatch ' For testing

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.Text = "VoxViaUDPTx"
        Me.Location = New Point(CInt((Screen.PrimaryScreen.WorkingArea.Width / 2) - (Me.Width / 2)), CInt((Screen.PrimaryScreen.WorkingArea.Height / 2) - (Me.Height / 2)))

        Dim waveInDevices As Integer = WaveIn.DeviceCount
        For waveInDevice As Integer = 0 To waveInDevices - 1
            Dim deviceInfo As WaveInCapabilities = WaveIn.GetCapabilities(waveInDevice)
            ListBox1.Items.Add("WaveInDev=" & waveInDevice & "  " & deviceInfo.ProductName & "  " & "DevChannels=" & deviceInfo.Channels)
        Next

        Button1.Enabled = False
        Button2.Enabled = False

        Label1.Text = "Waiting"
        Label2.Text = "Waiting"
        Label4.Text = "Waiting"
        Label5.Text = "Waiting"

        Dim LocalIPList As System.Net.IPHostEntry = Dns.GetHostEntry(Environment.MachineName)
        For Each LocalIP As IPAddress In LocalIPList.AddressList
            If LocalIP.AddressFamily = AddressFamily.InterNetwork Then
                VoxViaUDPIPAddress = LocalIP
                VoxViaUDPRemoteIpEndPoint = New IPEndPoint(VoxViaUDPIPAddress, VoxViaUDPLogicalPortNumber)
            End If
        Next

    End Sub

    ' Abort/Close threads and WaveIn recorder on Form close. Make sure you close Form using X button and not shutting down
    ' using Visual Studio Debugger or threads may not abort/close.

    Private Sub Form1_FormClosing(sender As Object, e As EventArgs) Handles Me.FormClosing
        Try
            VoxViaUDP.Abort()
        Catch ex As Exception
        End Try
        Try
            VoxViaUDPTxClient.Close()
        Catch ex As Exception
        End Try
        Try
            RecordIt.StopRecording()
        Catch ex As Exception
        End Try
    End Sub

    Private Sub ListBox1_SelectedIndexChanged(sender As Object, e As EventArgs) Handles ListBox1.SelectedIndexChanged
        Button1.Enabled = False
        Button2.Enabled = False

        Try
            VoxViaUDP.Abort()
        Catch ex As Exception
        End Try
        Try
            VoxViaUDPTxClient.Close()
        Catch ex As Exception
        End Try
        Try
            RecordIt.StopRecording()
        Catch ex As Exception
        End Try

        Dim InputStartLoc As Integer = ListBox1.SelectedItem.ToString.IndexOf("="c) + 1
        Dim InputEndLoc As Integer = ListBox1.SelectedItem.ToString.IndexOf(" "c)
        InputDevice = CInt(ListBox1.SelectedItem.ToString.Substring(InputStartLoc, InputEndLoc - InputStartLoc))

        Dim ChannelsStartLoc As Integer = ListBox1.SelectedItem.ToString.LastIndexOf("="c) + 1
        NumberofChannels = CInt(ListBox1.SelectedItem.ToString.Substring(ChannelsStartLoc, ListBox1.SelectedItem.ToString.Count - ChannelsStartLoc))

        Button1.Enabled = True
        Button2.Enabled = True
    End Sub

    Dim WaveData() As Byte                    ' The wave data to send.
    Dim InputDevice As Integer = 0            ' Altered by input device selected in ListBox.
    Dim NumberofChannels As Integer = 0       ' Retrieved from input device selected in ListBox.
    Dim SamplingRate As Integer = 10000        ' Recommend always use this amount. Keep byte amount to send per second at 32000 bytes.
    Dim RecordIt As New WaveIn()              ' Create WaveIn.

    Private Sub Transmit_Vox_Click(sender As Object, e As EventArgs) Handles Button1.Click
        RecordIt.DeviceNumber = InputDevice
        RecordIt.BufferMilliseconds = 50 ' Record 40 Milliseconds of data before sending it to keep packets under 1500 byte payloads at 1280 per. 25 packets at 1280 per = 32000 bytes or 1 second recorded data.
        AddHandler RecordIt.DataAvailable, AddressOf RecordIt_DataAvailable
        RecordIt.WaveFormat = New WaveFormat(SamplingRate, NumberofChannels)
        RecordIt.StartRecording()
    End Sub

    Private Sub RecordIt_DataAvailable(sender As Object, e As WaveInEventArgs)
        TimeIt1.Restart()
        WaveData = e.Buffer
        Label1.Text = "The recorded bytes are " & e.BytesRecorded.ToString & "."
        Label2.Text = "The Subs code completed in " & TimeIt1.ElapsedTicks.ToString & " ticks."
        VoxViaUDPTransmitter()
        TimeIt1.Stop()
    End Sub

    ' VoxViaUDPTx - Start VoxViaUDPRx Listener first ___________________________________________________________________________

    Dim VoxViaUDP As System.Threading.Thread
    Dim VoxViaUDPIPAddress As IPAddress
    Dim VoxViaUDPLogicalPortNumber As Integer = 11319
    Dim VoxViaUDPRemoteIpEndPoint As IPEndPoint
    Dim VoxViaUDPTxClient As UdpClient

    Private Sub VoxViaUDPTransmitter()
        TimeIt2.Restart()
        AbortVoxViaUDPThread = False
        VoxViaUDPTxClient = New UdpClient
        VoxViaUDPTxClient.Connect(VoxViaUDPIPAddress, VoxViaUDPLogicalPortNumber)
        VoxViaUDP = New System.Threading.Thread(AddressOf VoxViaUDPThread)
        VoxViaUDP.Start()
    End Sub

    Dim AbortVoxViaUDPThread As Boolean = False
    Dim BytesSent As Integer = 0

    Private Sub VoxViaUDPThread()
        Try
            If AbortVoxViaUDPThread = False Then
                BytesSent = VoxViaUDPTxClient.Send(WaveData, WaveData.Count)
                VoxViaUDPTxClient.Close()
                TimeIt2.Stop()
                Invoke(New VoxViaUDPDelDelegate(AddressOf VoxViaUDPDel))
            End If
        Catch ex As Exception
        End Try
    End Sub

    Private Delegate Sub VoxViaUDPDelDelegate()

    Private Sub VoxViaUDPDel()
        Try
            Label4.Text = "Bytes sent = " & BytesSent.ToString & "."
            Label5.Text = "The two Subs code completed in " & TimeIt2.ElapsedTicks.ToString & " ticks basically."
        Catch ex As Exception
        End Try
    End Sub

    Private Sub Stop_Transmitting_Click(sender As Object, e As EventArgs) Handles Button2.Click
        RecordIt.StopRecording()
        Label1.Text = "Waiting"
        Label2.Text = "Waiting"
        Label4.Text = "Waiting"
        Label5.Text = "Waiting"
    End Sub

End Class