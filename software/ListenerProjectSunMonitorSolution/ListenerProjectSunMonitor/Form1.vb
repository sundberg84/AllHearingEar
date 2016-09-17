Imports System.Net
Imports System.Text.Encoding
Imports System.Net.Sockets
Imports Microsoft.Win32

Public Class frmMain

    Dim subscriber As New Sockets.UdpClient(11000)

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        Me.Text = "All Hearing Ear"
        Me.Location = New Point(CInt((Screen.PrimaryScreen.WorkingArea.Width / 2) - (Me.Width / 2)), CInt((Screen.PrimaryScreen.WorkingArea.Height / 2) - (Me.Height / 2)))
        Dim LocalIPList As System.Net.IPHostEntry = Dns.GetHostEntry(Environment.MachineName)
        For Each LocalIP As IPAddress In LocalIPList.AddressList
            If LocalIP.AddressFamily = AddressFamily.InterNetwork Then
                VoxViaUDPIPAddress = LocalIP
                VoxViaUDPRemoteIpEndPoint = New IPEndPoint(VoxViaUDPIPAddress, VoxViaUDPLogicalPortNumber)
            End If
        Next
        Label1.Text = "Waiting"
        Label2.Text = "Waiting"
        Label3.Text = "Waiting"
        Label4.Text = "Waiting"

        subscriber.Client.ReceiveTimeout = 100
        subscriber.Client.Blocking = False
        TxtLogg.Text = DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " Startup succesfull!"

        Connectionstatus = False
        lblListen.ForeColor = Color.Red
        NotifyIcon1.Visible = False 'Visa inte icon i taskbar vid start.


    End Sub

    ' Abort/Close threads on Form close. Make sure you close Form using X button and not shutting down
    ' using Visual Studio Debugger or threads may not abort/close.

    Private Sub Form1_FormClosing(sender As Object, e As EventArgs) Handles Me.FormClosing
        Try
            AbortVoxViaUDPThread = True
        Catch ex As Exception
        End Try
        Try
            VoxViaUDP.Abort()
        Catch ex As Exception
        End Try
        Try
            VoxViaUDPRxClient.Close()
        Catch ex As Exception
        End Try
    End Sub

    'tmrListen lyssnar efter packet från alla IPadresser och alla portar.
    Dim ticks As Integer = 0
    Private Sub tmrListen_Tick(ByVal sender As System.Object, ByVal e As EventArgs) Handles tmrListen.Tick


        ticks = ticks + 1
        If ticks > 55 Then
            lblListen.Text = "Ej ansluten!"
            lblListen.ForeColor = Color.Red

            If Connectionstatus = True Then
                Call ConStat()
            End If

        End If

            Try
            Dim ep As IPEndPoint = New IPEndPoint(IPAddress.Any, 0)
            Dim rcvbytes() As Byte = subscriber.Receive(ep)
            lblListen.Text = "Ansluten!" 'ASCII.GetString(rcvbytes)
            lblListen.ForeColor = Color.Green
            ticks = 0
            Call ConStat()
        Catch ex As Exception

        End Try

    End Sub

    'Logga anslutning/avbrott.
    Dim Connectionstatus As Boolean

    Private Function ConStat()


        If lblListen.Text = "Ansluten!" And Connectionstatus = False Then
            TxtLogg.Text = TxtLogg.Text & Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to All Hearing Ear!"
            Connectionstatus = True
        ElseIf lblListen.Text = "Ej ansluten!" And Connectionstatus = True Then
            TxtLogg.Text = TxtLogg.Text & Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to All Hearing Ear!"
            Connectionstatus = False
        End If

    End Function

    ' UDP VOX receiver code _________________________________________________________________________________________

    Dim VoxViaUDP As System.Threading.Thread
    Dim VoxViaUDPIPAddress As IPAddress
    Dim VoxViaUDPLogicalPortNumber As Integer = 11000
    Dim VoxViaUDPRemoteIpEndPoint As System.Net.IPEndPoint
    Dim VoxViaUDPRxClient As System.Net.Sockets.UdpClient

    Private Sub Receive_Vox_Click(sender As Object, e As EventArgs) Handles Receive_Vox.Click
        Dim LocalIPList As System.Net.IPHostEntry = Dns.GetHostEntry(Environment.MachineName)

        tmrListen.Enabled = True

        For Each LocalIP As IPAddress In LocalIPList.AddressList
            If LocalIP.AddressFamily = AddressFamily.InterNetwork Then
                VoxViaUDPIPAddress = LocalIP
                VoxViaUDPRemoteIpEndPoint = New IPEndPoint(VoxViaUDPIPAddress, VoxViaUDPLogicalPortNumber)
            End If
        Next
        Try
            VoxViaUDP.Abort()
        Catch ex As Exception
        End Try
        Try
            VoxViaUDPRxClient.Close()
        Catch ex As Exception
        End Try
        AbortVoxViaUDPThread = False
        VoxViaUDP = New System.Threading.Thread(AddressOf VoxViaUDPReceivingThread)
        VoxViaUDP.Start()

        Receive_Vox.Enabled = False

        Stop_Receiving.Enabled = True
        tmrListen.Enabled = True

    End Sub

    Dim BytesRcvd As Integer = 0
    Dim AbortVoxViaUDPThread As Boolean = False
    Dim RcvdWaveFileBytes As New List(Of Byte()) ' A List of Byte Arrays per index, not just single bytes per index.

    Private Sub VoxViaUDPReceivingThread()
        Try
            Do
                If AbortVoxViaUDPThread = False Then
                    VoxViaUDPRxClient = New UdpClient(VoxViaUDPLogicalPortNumber)
                    RcvdWaveFileBytes.Add(VoxViaUDPRxClient.Receive(VoxViaUDPRemoteIpEndPoint))
                    VoxViaUDPRxClient.Close()
                Else
                    Exit Do
                End If
                Invoke(New VoxViaUDPDelDelegate(AddressOf VoxViaUDPDel))
            Loop
        Catch ex As Exception
        End Try
    End Sub

    Private Delegate Sub VoxViaUDPDelDelegate()

    Private Sub VoxViaUDPDel()
        If AbortVoxViaUDPThread = False Then
            Label1.Text = "The current received byte count prior to removal and playing is " & (RcvdWaveFileBytes.Count * 1280).ToString & "."
            If RcvdWaveFileBytes.Count > 50 Then ' (Testing at 2 seconds data) Should be 32000 bytes or 1 second of recorded data. 25 * 1280 bytes per rcvd packet = 32000 bytes.
                CreateWaveHeaderAndPlay()
            End If
        End If
    End Sub

    ' Wave header

    Dim FileType() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("RIFF")          ' The ASCII text string "RIFF", 4 bytes.
    Dim FileSize() As Byte                                                             ' The file size not including the "RIFF" description (4 bytes) and header type "WAVE" (4 bytes). This is file size - 8. Or Wave Data size + 36 which is all byte counts except RIFF and WAVE bytes.
    Dim HeaderType() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("WAVE")        ' The ASCII text string "WAVE", 4 bytes.
    Dim Format() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("fmt ")            ' The ASCII text string "fmt "(The space is also included), 4 bytes including one of anything.
    Dim FormatLength() As Byte                                                         ' The size of the WAVE type format. This is usually 16 but can be other sizes. I use 16 for this code. 4 bytes.
    Dim WaveTypePCM() As Byte                                                          ' Type of WAVE format. This is a PCM header = 01. Other values indicates some forms of compression. 2 bytes.
    Dim Channels() As Byte                                                             ' Channels 1 for mono, 2 for stereo. 2 bytes.
    Dim SamplesHertz() As Byte                                                         ' Samples Hz is number of samples per second, or frequency in hertz and is 4 bytes.
    Dim BytesPerSecond() As Byte                                                       ' BytesPerSecond is "Number of channels * Samples per second * Bits per Sample / 8". 4 bytes.
    Dim Align() As Byte                                                                ' Align is "Number of channels * Bits per Sample / 8". 2 bytes.
    Dim BitsPerSample() As Byte                                                        ' Bits per sample is usually 32, 24, 16 or 8. Using 16 for this code. 2 bytes.
    Dim DataDescHeader() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("data")    ' The data description header is the ASCII text string "data". 4 bytes.
    Dim SizeOfData() As Byte                                                           ' Number of bytes of data within the data section. 4 bytes.
    Dim WaveData As New List(Of Byte)                                                  ' The wave data.
    Dim CompleteWaveFile() As Byte
    Dim NumberofChannels As Integer = 2
    Dim SamplingRate As Integer = 8000

    Private Sub CreateWaveHeaderAndPlay()
        WaveData.Clear()
        For i = 0 To 49
            WaveData.AddRange(RcvdWaveFileBytes(i)) ' Add indexes 0 to 24 byte arrays to WaveData from RcvdWaveFileBytes
        Next
        Label2.Text = "WaveData created at " & Now.ToLongTimeString & "."
        RcvdWaveFileBytes.RemoveRange(0, 50) ' Remove indexes 0 to 24 (25 total indexes) from RcvdWaveFileBytes
        FileSize = WaveFileHelper(WaveData.Count + 36, 4)
        FormatLength = WaveFileHelper(16, 4)
        WaveTypePCM = WaveFileHelper(1, 2)
        Channels = WaveFileHelper(NumberofChannels, 2)
        SamplesHertz = WaveFileHelper(SamplingRate, 4)
        Dim BPS As Integer = CInt(2 * SamplingRate * 16 / 8)
        BytesPerSecond = WaveFileHelper(BPS, 4)
        Dim AlignInfo As Integer = CInt(2 * 16 / 8)
        Align = WaveFileHelper(AlignInfo, 2)
        BitsPerSample = WaveFileHelper(16, 2)
        SizeOfData = WaveFileHelper(WaveData.Count, 4)
        Using MS As New IO.MemoryStream
            MS.Write(FileType, 0, FileType.Length)             ' 4 bytes
            MS.Write(FileSize, 0, FileSize.Length)             ' 4 bytes
            MS.Write(HeaderType, 0, HeaderType.Length)         ' 4 bytes
            MS.Write(Format, 0, Format.Length)                 ' 4 bytes
            MS.Write(FormatLength, 0, FormatLength.Length)     ' 4 bytes
            MS.Write(WaveTypePCM, 0, WaveTypePCM.Length)       ' 2 bytes
            MS.Write(Channels, 0, Channels.Length)             ' 2 bytes
            MS.Write(SamplesHertz, 0, SamplesHertz.Length)     ' 4 bytes
            MS.Write(BytesPerSecond, 0, BytesPerSecond.Length) ' 4 bytes
            MS.Write(Align, 0, Align.Length)                   ' 2 bytes
            MS.Write(BitsPerSample, 0, BitsPerSample.Length)   ' 2 bytes
            MS.Write(DataDescHeader, 0, DataDescHeader.Length) ' 4 bytes
            MS.Write(SizeOfData, 0, SizeOfData.Length)         ' 4 bytes
            MS.Write(WaveData.ToArray, 0, WaveData.Count)      ' Number of bytes determined by sampled data
            CompleteWaveFile = MS.ToArray
        End Using
        Label3.Text = "SoundPlayer started at " & Now.ToLongTimeString & "."
        Using MS As New IO.MemoryStream(CompleteWaveFile)
            Dim player As New Media.SoundPlayer(MS)
            player.Play()
        End Using
        Label4.Text = "SoundPlayer last finished at " & Now.ToLongTimeString & "."
    End Sub

    Private Function WaveFileHelper(ByRef Value As Integer, ByRef Length As Integer) As Byte()
        Dim b() As Byte = BitConverter.GetBytes(Value)
        Dim Helper As New List(Of Byte)
        Helper = b.ToList
        Return Helper.GetRange(0, Length).ToArray
    End Function

    Private Sub Stop_Receiving_Click(sender As Object, e As EventArgs) Handles Stop_Receiving.Click
        Try
            AbortVoxViaUDPThread = True
        Catch ex As Exception
        End Try
        Try
            VoxViaUDP.Abort()
        Catch ex As Exception
        End Try
        Try
            VoxViaUDPRxClient.Close()
        Catch ex As Exception
        End Try
        Label1.Text = "Waiting"
        Label2.Text = "Waiting"
        Label3.Text = "Waiting"
        Label4.Text = "Waiting"

        Receive_Vox.Enabled = True
        Stop_Receiving.Enabled = False
        tmrListen.Enabled = False

        lblListen.Text = "Ej ansluten!"
        lblListen.ForeColor = Color.Red
        TxtLogg.Text = TxtLogg.Text & Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You disconnected from All Hearing Ear!"

    End Sub

    Private Sub CBLogg_CheckedChanged(sender As Object, e As EventArgs) Handles CBLogg.CheckedChanged
        If CBLogg.Checked = True Then
            Me.Height = 480
        Else
            Me.Height = 310
        End If
    End Sub

    Private Sub ExitToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ExitToolStripMenuItem.Click
        NotifyIcon1.Visible = False
        Try
            AbortVoxViaUDPThread = True
        Catch ex As Exception
        End Try
        Try
            VoxViaUDP.Abort()
        Catch ex As Exception
        End Try
        Try
            VoxViaUDPRxClient.Close()
        Catch ex As Exception
        End Try
        End
    End Sub



    Private Sub ShowToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ShowToolStripMenuItem.Click
        Try
            Me.Visible = True
            Me.WindowState = FormWindowState.Normal
            NotifyIcon1.Visible = False
        Catch ex As Exception

        End Try
    End Sub

    Private Sub NotifyIcon1_MouseDown(ByVal sender As System.Object, ByVal e As System.Windows.Forms.MouseEventArgs) Handles NotifyIcon1.MouseDown
        If MouseButtons = MouseButtons.Right Then
            ContextMenuStrip1.Show()
        End If
    End Sub

    Private Sub NotifyIcon1_MouseDoubleClick(sender As Object, e As MouseEventArgs) Handles NotifyIcon1.MouseDoubleClick
        Try
            Me.Visible = True
            Me.WindowState = FormWindowState.Normal
            NotifyIcon1.Visible = False
        Catch ex As Exception

        End Try
    End Sub

    Private Sub frmMain_SizeChanged(sender As Object, e As EventArgs) Handles Me.SizeChanged
        If Me.WindowState = FormWindowState.Minimized Then
            NotifyIcon1.Visible = True
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Running minimized", ToolTipIcon.Info)
            Me.ShowInTaskbar = False
        ElseIf Me.WindowState.Normal Then
            NotifyIcon1.Visible = False
            Me.ShowInTaskbar = True
        End If
    End Sub
End Class
