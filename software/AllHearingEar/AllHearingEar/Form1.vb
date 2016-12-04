Imports System.Text
Imports System.Net
Imports System.Text.Encoding


Public Class main

    <Runtime.InteropServices.DllImport("winmm.dll")>
    Public Shared Function waveOutSetVolume(ByVal hwo As IntPtr, ByVal dwVolume As UInteger) As Integer
    End Function


    Private Sub TBVolume1_ValueChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TBVolume1.ValueChanged
        Dim NewVolume As Integer = ((UShort.MaxValue / 10) * TBVolume1.Value)
        ' Set the same volume for both the left and the right channels 
        Dim NewVolumeAllChannels As UInteger = ((CUInt(NewVolume) And &HFFFF) Or (CUInt(NewVolume) << 16))

        ' Set the volume 
        waveOutSetVolume(IntPtr.Zero, NewVolumeAllChannels)
    End Sub

    Private Sub main_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.Text = "All Hearing Ear"
        Me.Location = New Point(CInt((Screen.PrimaryScreen.WorkingArea.Width / 2) - (Me.Width / 2)), CInt((Screen.PrimaryScreen.WorkingArea.Height / 2) - (Me.Height / 2)))

        subscriber.Client.ReceiveTimeout = 100
        subscriber.Client.Blocking = False

        'Loggbok info
        addLog(DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " Startup successfull!")

        'Nolla alla anslutningar
        Connectionstatus1 = False
        Connectionstatus2 = False
        Connectionstatus3 = False
        Connectionstatus4 = False


        NotifyIcon1.Visible = True 'Visa icon i taskbar vid start.

        'Ladda alla nödvändiga värden



        Me.CBAutoStart.CheckState = My.Settings.chk1
        Me.AHESyncIP1 = My.Settings.hip1
        Me.AHESyncIP2 = My.Settings.hip2
        Me.AHESyncIP3 = My.Settings.hip3
        Me.AHESyncIP4 = My.Settings.hip4
        txtUnit1.Text = My.Settings.syncName1
        txtUnit2.Text = My.Settings.syncName2
        txtUnit3.Text = My.Settings.syncName3
        txtUnit4.Text = My.Settings.syncName4
        AHEsyncName1 = My.Settings.syncName1
        AHEsyncName2 = My.Settings.syncName2
        AHEsyncName3 = My.Settings.syncName3
        AHEsyncName4 = My.Settings.syncName4
        TBSens1.Value = My.Settings.Sens1
        TBSens2.Value = My.Settings.Sens2
        TBSens3.Value = My.Settings.Sens3
        TBSens4.Value = My.Settings.Sens4
        TBVolume1.Value = My.Settings.OutsetVolume
        NumberOfUnitsSynced = My.Settings.NumOfSynUn





        'Visa synkade enheter
        If txtUnit1.Text <> "" Then
            txtUnit1.Visible = True
            txtUnit1.Enabled = False
            PBdelete1.Visible = True
            PBdelete1.Enabled = True
            TBSens1.Visible = True
            TBSens1.Enabled = True
        End If
        If txtUnit2.Text <> "" Then
            txtUnit2.Visible = True
            txtUnit2.Enabled = False
            PBdelete2.Visible = True
            PBdelete2.Enabled = True
            TBSens2.Visible = True
            TBSens2.Enabled = True
        End If
        If txtUnit3.Text <> "" Then
            txtUnit3.Visible = True
            txtUnit3.Enabled = False
            PBdelete3.Visible = True
            PBdelete3.Enabled = True
            TBSens3.Visible = True
            TBSens3.Enabled = True
        End If
        If txtUnit4.Text <> "" Then
            txtUnit4.Visible = True
            txtUnit4.Enabled = False
            PBdelete4.Visible = True
            PBdelete4.Enabled = True
            TBSens4.Visible = True
            TBSens4.Enabled = True
        End If

        'Kör findslot för att veta hur många enheter det finns syncade och för att veta vilken slot nästa enhet ska hamna i.
        Call FindSlot()



    End Sub

    Private Sub main_FormClosing(sender As Object, e As EventArgs) Handles Me.FormClosing

        'Spara alla nödvändiga värden.

        My.Settings.chk1 = Me.CBAutoStart.CheckState
        My.Settings.hip1 = AHESyncIP1
        My.Settings.hip2 = AHESyncIP2
        My.Settings.hip3 = AHESyncIP3
        My.Settings.hip4 = AHESyncIP4
        My.Settings.syncName1 = AHEsyncName1
        My.Settings.syncName2 = AHEsyncName2
        My.Settings.syncName3 = AHEsyncName3
        My.Settings.syncName4 = AHEsyncName4
        My.Settings.NumOfSynUn = NumberOfUnitsSynced
        My.Settings.Sens1 = TBSens1.Value
        My.Settings.Sens2 = TBSens2.Value
        My.Settings.Sens3 = TBSens3.Value
        My.Settings.Sens4 = TBSens4.Value
        My.Settings.OutsetVolume = TBVolume1.Value
        My.Settings.Save()
        End
    End Sub

    Private Sub BtnListen_Click(sender As Object, e As EventArgs) Handles BtnListen.Click
        'Finns det syncade AHE så ska AudioMottagningen starta.
        If BtnListen.Text = "Connect" Then

            'Skicka en förfrågan om nya AHE enheten.
            SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("0"))
            BtnListen.Text = "Disconnect"
            Timer1.Enabled = True
            udpAudioThread()
        ElseIf BtnListen.Text = "Disconnect" Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You disconnected from All Hearing Ear!")
            BtnListen.Text = "Connect"
            txtUnit1.BackColor = SystemColors.Menu
            txtUnit2.BackColor = SystemColors.Menu
            txtUnit3.BackColor = SystemColors.Menu
            txtUnit4.BackColor = SystemColors.Menu
            Connectionstatus1 = False
            Connectionstatus2 = False
            Connectionstatus3 = False
            Connectionstatus4 = False
            Pingtick = 0
            Timer1.Enabled = False
            'subscriber.Close()
            'StopAudioUDP()
        End If


    End Sub

    Private Sub CBAutoStart_CheckedChanged(sender As Object, e As EventArgs) Handles CBAutoStart.CheckedChanged
        Dim applicationName As String = Application.ProductName
        Dim applicationPath As String = Application.ExecutablePath

        If CBAutoStart.Checked Then
            Dim regKey As Microsoft.Win32.RegistryKey
            regKey = Microsoft.Win32.Registry.CurrentUser.OpenSubKey("SOFTWARE\Microsoft\Windows\CurrentVersion\Run", True)
            regKey.SetValue(applicationName, """" & applicationPath & """")
            regKey.Close()
        Else
            Dim regkey As Microsoft.Win32.RegistryKey
            regkey = Microsoft.Win32.Registry.CurrentUser.OpenSubKey("SOFTWARE\Microsoft\Windows\CurrentVersion\Run", True)
            regkey.DeleteValue(applicationName, False)
            regkey.Close()
        End If
    End Sub

    Private Sub CBLogg_CheckedChanged(sender As Object, e As EventArgs) Handles CBLogg.CheckedChanged
        If CBLogg.Checked = True Then
            Me.Height = 514
        Else
            Me.Height = 330
        End If
    End Sub

    Private Sub PBok1_Click(sender As Object, e As EventArgs) Handles PBok1.Click

        If txtUnit1.Text = "Enter name:" Then
            MsgBox("Du måste ange namn på enheten!", vbOKOnly, "All hearing ear")
        Else
            AHEsyncName1 = txtUnit1.Text
            txtUnit1.Enabled = False
            PBdelete1.Visible = True
            PBdelete1.Enabled = True
            PBok1.Enabled = False
            PBok1.Visible = False
        End If

    End Sub

    Private Sub PBdelete1_Click(sender As Object, e As EventArgs) Handles PBdelete1.Click

        AHEsyncName1 = ""
        AHESyncIP1 = ""
        txtUnit1.Text = ""
        PBdelete1.Enabled = False
        PBdelete1.Visible = False
        TBSens1.Value = 0
        TBSens1.Visible = False
        Call FindSlot()

    End Sub

    Private Sub PBok2_Click(sender As Object, e As EventArgs) Handles PBok2.Click

        If txtUnit2.Text = "" Then
            MsgBox("Du måste ange namn på enheten!", vbOKOnly, "All hearing ear")
        Else
            AHEsyncName2 = txtUnit2.Text
            txtUnit2.Enabled = False
            PBdelete2.Visible = True
            PBdelete2.Enabled = True
            PBok2.Enabled = False
            PBok2.Visible = False
        End If

    End Sub

    Private Sub PBdelete2_Click(sender As Object, e As EventArgs) Handles PBdelete2.Click

        txtUnit2.Text = ""
        PBdelete2.Enabled = False
        PBdelete2.Visible = False
        AHEsyncName2 = ""
        AHESyncIP2 = ""
        TBSens2.Value = 0
        TBSens2.Visible = False
        Call FindSlot()

    End Sub

    Private Sub PBok3_Click(sender As Object, e As EventArgs) Handles PBok3.Click

        If txtUnit3.Text = "" Then
            MsgBox("Du måste ange namn på enheten!", vbOKOnly, "All hearing ear")
        Else
            AHEsyncName3 = txtUnit3.Text
            txtUnit3.Enabled = False
            PBdelete3.Visible = True
            PBdelete3.Enabled = True
            PBok3.Enabled = False
            PBok3.Visible = False
        End If

    End Sub

    Private Sub PBdelete3_Click(sender As Object, e As EventArgs) Handles PBdelete3.Click
        txtUnit3.Text = ""
        PBdelete3.Enabled = False
        PBdelete3.Visible = False
        AHEsyncName3 = ""
        AHESyncIP3 = ""
        TBSens3.Value = 0
        TBSens3.Visible = False
        Call FindSlot()
    End Sub

    Private Sub PBok4_Click(sender As Object, e As EventArgs) Handles PBok4.Click
        If txtUnit4.Text = "" Then
            MsgBox("Du måste ange namn på enheten!", vbOKOnly, "All hearing ear")
        Else
            AHEsyncName4 = txtUnit3.Text
            txtUnit4.Enabled = False
            PBdelete4.Visible = True
            PBdelete4.Enabled = True
            PBok4.Enabled = False
            PBok4.Visible = False
        End If
    End Sub

    Private Sub PBdelete4_Click(sender As Object, e As EventArgs) Handles PBdelete4.Click
        txtUnit4.Text = ""
        PBdelete4.Enabled = False
        PBdelete4.Visible = False
        AHEsyncName4 = ""
        AHESyncIP4 = ""
        TBSens4.Value = 0
        TBSens4.Visible = False

        Call FindSlot()
    End Sub



    'Kod för att minimering av program ska visas i taskbar. Inkl Stripmenu och dubbelklick.
    '--------------------------------------------------------------------------------------
    Private Sub ExitToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ExitToolStripMenuItem.Click
        End
    End Sub

    Private Sub OpenToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles OpenAllHearingEarToolStripMenuItem.Click
        Try
            Me.Visible = True
            Me.WindowState = FormWindowState.Normal
            Me.ShowInTaskbar = True
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
            Me.ShowInTaskbar = True
        Catch ex As Exception

        End Try
    End Sub

    Private Sub main_SizeChanged(sender As Object, e As EventArgs) Handles Me.SizeChanged
        If Me.WindowState = FormWindowState.Minimized Then

            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Running minimized", ToolTipIcon.Info)
            Me.ShowInTaskbar = False
            Me.Visible = False
        Else

            Me.ShowInTaskbar = True
            Me.Visible = True
        End If
    End Sub

    Dim CurrentSync As String
    Dim NumberOfUnitsSynced As Integer
    'Definiera värden som ska sparas när program sparas.
    Public AHESyncIP1 As String
    Dim AHEsyncName1 As String
    Dim AHESyncIP2 As String
    Dim AHEsyncName2 As String
    Dim AHESyncIP3 As String
    Dim AHEsyncName3 As String
    Dim AHESyncIP4 As String
    Dim AHEsyncName4 As String

    'Funktion för att hitta vilken slot ny enhet ska lagras i.
    '---------------------------------------------------------
    Public Sub SyncNew()

        Call FindSlot()

        If CurrentSync = AHESyncIP1 Or CurrentSync = AHESyncIP2 Or CurrentSync = AHESyncIP3 Or CurrentSync = AHESyncIP4 Then
            'MsgBox("AHE redan synkad!", MsgBoxStyle.OkOnly, "All hearing ear")
        Else
            Select Case NumberOfUnitsSynced
                Case 0
                    txtUnit1.Visible = True
                    PBok1.Visible = True
                    PBok1.Enabled = True
                    TBSens1.Visible = True
                    TBSens1.Enabled = True
                    txtUnit1.Text = CurrentSync
                    AHESyncIP1 = CurrentSync

                    Call FindSlot()
                Case 1
                    txtUnit2.Visible = True
                    PBok2.Visible = True
                    PBok2.Enabled = True
                    TBSens2.Visible = True
                    TBSens2.Enabled = True
                    txtUnit2.Text = CurrentSync
                    AHESyncIP2 = CurrentSync

                    Call FindSlot()
                Case 2
                    txtUnit3.Visible = True
                    PBok3.Visible = True
                    PBok3.Enabled = True
                    TBSens3.Visible = True
                    TBSens3.Enabled = True
                    txtUnit3.Text = CurrentSync
                    AHESyncIP3 = CurrentSync

                    Call FindSlot()
                Case 3
                    txtUnit4.Visible = True
                    PBok4.Visible = True
                    PBok4.Enabled = True
                    TBSens4.Visible = True
                    TBSens4.Enabled = True
                    txtUnit4.Text = CurrentSync
                    AHESyncIP4 = CurrentSync

                    Call FindSlot()

            End Select
            CurrentSync = ""
        End If



    End Sub


    'Funktion för att sortera och visa anslutna enheter
    '--------------------------------------------------
    Dim SyncDone As Integer
    Public Sub FindSlot()


        Do Until SyncDone = 5
            If txtUnit4.Text = "" Then

                txtUnit4.Enabled = True
                txtUnit4.Visible = False
                PBok4.Visible = False
                If txtUnit4.Text > "" Then
                    PBdelete4.Visible = True
                    PBdelete4.Enabled = True
                    TBSens4.Visible = True
                    TBSens4.Enabled = True
                End If
            End If

            If txtUnit3.Text = "" Then
                txtUnit3.Text = txtUnit4.Text
                txtUnit4.Text = ""
                AHESyncIP3 = AHESyncIP4
                AHEsyncName3 = AHEsyncName4
                TBSens3.Value = TBSens4.Value
                TBSens4.Visible = False
                TBSens4.Value = 0
                PBdelete4.Visible = False
                PBok4.Visible = False
                If txtUnit3.Text > "" Then
                    PBdelete3.Visible = True
                    PBdelete3.Enabled = True
                    TBSens3.Visible = True
                End If
                If txtUnit3.Text = "" Then
                    txtUnit3.Enabled = True
                    txtUnit3.Visible = False
                    TBSens3.Visible = False
                End If
            End If

            If txtUnit2.Text = "" Then
                txtUnit2.Text = txtUnit3.Text
                txtUnit3.Text = ""
                AHESyncIP2 = AHESyncIP3
                AHEsyncName2 = AHEsyncName3
                TBSens2.Value = TBSens3.Value
                TBSens3.Visible = False
                TBSens3.Value = 0
                PBok3.Visible = False
                PBdelete3.Visible = False
                If txtUnit2.Text > "" Then
                    PBdelete2.Visible = True
                    PBdelete2.Enabled = True
                    TBSens2.Visible = True
                End If
                If txtUnit2.Text = "" Then
                    txtUnit2.Enabled = True
                    txtUnit2.Visible = False
                    TBSens2.Visible = False
                End If

            End If

            If txtUnit1.Text = "" Then
                txtUnit1.Text = txtUnit2.Text
                txtUnit2.Text = ""
                AHESyncIP1 = AHESyncIP2
                AHEsyncName1 = AHEsyncName2
                TBSens1.Value = TBSens2.Value
                TBSens2.Visible = False
                TBSens2.Value = 0
                PBok2.Visible = False
                PBdelete2.Visible = False
                If txtUnit1.Text > "" Then
                    PBdelete1.Visible = True
                    PBdelete1.Enabled = True
                    TBSens1.Visible = True
                End If

            End If

            If txtUnit4.Text > "" And txtUnit3.Text > "" And txtUnit2.Text > "" And txtUnit1.Text > "" Then
                NumberOfUnitsSynced = 4

            End If

            If txtUnit4.Text = "" And txtUnit3.Text > "" And txtUnit2.Text > "" And txtUnit1.Text > "" Then
                NumberOfUnitsSynced = 3

            End If

            If txtUnit4.Text = "" And txtUnit3.Text = "" And txtUnit2.Text > "" And txtUnit1.Text > "" Then
                NumberOfUnitsSynced = 2

            End If

            If txtUnit4.Text = "" And txtUnit3.Text = "" And txtUnit2.Text = "" And txtUnit1.Text > "" Then
                NumberOfUnitsSynced = 1

            End If

            If txtUnit4.Text = "" And txtUnit3.Text = "" And txtUnit2.Text = "" And txtUnit1.Text = "" Then
                NumberOfUnitsSynced = 0
                txtUnit1.Visible = False
                txtUnit1.Enabled = True
            End If
            SyncDone = SyncDone + 1
        Loop



        If SyncDone = 5 Then
            SyncDone = 0
        End If

    End Sub

    'Logga anslutning/avbrott.
    '-------------------------
    Dim Connectionstatus1, Connectionstatus2, Connectionstatus3, Connectionstatus4 As Boolean
    Dim ticks, ticks2, ticks3, ticks4, Pingtick As Integer


    'Länk till hemsida
    '------------------
    Private Sub LinkLabel1_MouseDown(sender As Object, e As MouseEventArgs) Handles LinkLabel1.MouseDown
        Try
            System.Diagnostics.Process.Start("http://www.google.se")
        Catch

        End Try
    End Sub

    'Pingfunktion i Timer
    '---------------------
    Dim LookForPing As Integer
    Dim subscriber As New Sockets.UdpClient(11319)


    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If Button1.Text = "Manual sync" Then
            txtManSync.Visible = True
            Button1.Text = "Sync"
        ElseIf Button1.Text = "Sync" Then
            If txtManSync.Text = "" Then
                addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " No IP adress specified.")
            End If
            Try
                SendUDP(txtManSync.Text, 11319, Encoding.ASCII.GetBytes("0"))
                Button1.Text = "Manual sync"
                txtManSync.Visible = False
                txtManSync.Text = "IP adress:"
            Catch ex As Exception
                addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " No IP adress specified.")
            End Try


        End If

    End Sub
    Dim StartUp As Boolean = False
    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick

        If StartUp = False Then
            'Fråga efter nya enheter när programmet startar.
            'Skicka en förfrågan om nya AHE enheten.
            SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("0"))
            StartUp = True

            If AHESyncIP1 <> "" Or AHESyncIP2 <> "" Or AHESyncIP3 <> "" Or AHESyncIP4 <> "" Then
                udpAudioThread()
            End If
            'Starta ljud om programmet har syncade AHEenheter.
        End If


        Try
            Dim respondPing As IPEndPoint = New IPEndPoint(IPAddress.Any, 0)
            Dim rcvPingbytes() As Byte = subscriber.Receive(respondPing)
            LookForPing = ASCII.GetString(rcvPingbytes)

            'addLog("Debug (11319): " & LookForPing)

            If LookForPing = 1 Then
                CurrentSync = respondPing.Address.ToString()


                If CurrentSync = AHESyncIP1 Or CurrentSync = AHESyncIP2 Or CurrentSync = AHESyncIP3 Or CurrentSync = AHESyncIP4 Then
                Else
                    addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You found a new AHE: " + CurrentSync)
                    udpAudioThread()
                End If
                Call SyncNew()
            End If

            If respondPing.Address.ToString = AHESyncIP1 And LookForPing = 1 Then
                txtUnit1.BackColor = Color.LightGreen
                ticks = 0
                Call ConStat()
            End If

            If respondPing.Address.ToString = AHESyncIP2 And LookForPing = 1 Then
                txtUnit2.BackColor = Color.LightGreen
                ticks2 = 0
                Call ConStat()
            End If

            If respondPing.Address.ToString = AHESyncIP3 And LookForPing = 1 Then
                txtUnit3.BackColor = Color.LightGreen
                ticks3 = 0
                Call ConStat()
            End If

            If respondPing.Address.ToString = AHESyncIP4 And LookForPing = 1 Then
                txtUnit4.BackColor = Color.LightGreen
                ticks4 = 0
                Call ConStat()
            End If

        Catch ex As Exception

        End Try


        If AHESyncIP1 <> "" Then
            ticks += 1
        End If
        If AHESyncIP2 <> "" Then
            ticks2 += 1
        End If
        If AHESyncIP3 <> "" Then
            ticks3 += 1
        End If
        If AHESyncIP4 <> "" Then
            ticks4 += 1
        End If

        If ticks > 54 Then
            SendUDP(AHESyncIP1, 11319, Encoding.ASCII.GetBytes("0"))
            If ticks > 64 Then
                txtUnit1.BackColor = SystemColors.Menu
                If Connectionstatus1 = True Then
                    Call ConStat()
                End If
            End If
        End If

        If ticks2 > 54 Then
            SendUDP(AHESyncIP2, 11319, Encoding.ASCII.GetBytes("0"))
            If ticks2 > 64 Then
                txtUnit2.BackColor = SystemColors.Menu
                If Connectionstatus2 = True Then
                    Call ConStat()
                End If
            End If
        End If

        If ticks3 > 54 Then
            SendUDP(AHESyncIP3, 11319, Encoding.ASCII.GetBytes("0"))
            If ticks3 > 64 Then
                txtUnit3.BackColor = SystemColors.Menu
                If Connectionstatus3 = True Then
                    Call ConStat()
                End If
            End If
        End If

        If ticks4 > 54 Then
            SendUDP(AHESyncIP4, 11319, Encoding.ASCII.GetBytes("0"))
            If ticks4 > 64 Then
                txtUnit4.BackColor = SystemColors.Menu
                If Connectionstatus4 = True Then
                    Call ConStat()
                End If
            End If
        End If



        Pingtick += 1
        If Pingtick = 40 Then
            If AHESyncIP1 <> "" Then
                SendUDP(AHESyncIP1, 11319, Encoding.ASCII.GetBytes("0"))
            End If
            If AHESyncIP2 <> "" Then
                SendUDP(AHESyncIP2, 11319, Encoding.ASCII.GetBytes("0"))
            End If
            If AHESyncIP3 <> "" Then
                SendUDP(AHESyncIP3, 11319, Encoding.ASCII.GetBytes("0"))
            End If
            If AHESyncIP4 <> "" Then
                SendUDP(AHESyncIP4, 11319, Encoding.ASCII.GetBytes("0"))
            End If
            Pingtick = 0
        End If

    End Sub


    'Kontroll och funktion o anslutningsstatus
    '-----------------------------------------
    Private Sub ConStat()


        If txtUnit1.BackColor = Color.LightGreen And Connectionstatus1 = False Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + txtUnit1.Text)
            Connectionstatus1 = True
        ElseIf txtUnit1.BackColor = SystemColors.Menu And Connectionstatus1 = True Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + txtUnit1.Text)
            Connectionstatus1 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName1, ToolTipIcon.Info)
        End If

        If txtUnit2.BackColor = Color.LightGreen And Connectionstatus2 = False Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + txtUnit2.Text)
            Connectionstatus2 = True
        ElseIf txtUnit2.BackColor = SystemColors.Menu And Connectionstatus2 = True Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + txtUnit2.Text)
            Connectionstatus2 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName2, ToolTipIcon.Info)
        End If

        If txtUnit3.BackColor = Color.LightGreen And Connectionstatus3 = False Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + txtUnit3.Text)
            Connectionstatus3 = True
        ElseIf txtUnit3.BackColor = SystemColors.Menu And Connectionstatus3 = True Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + txtUnit3.Text)
            Connectionstatus3 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName3, ToolTipIcon.Info)
        End If

        If txtUnit4.BackColor = Color.LightGreen And Connectionstatus4 = False Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + txtUnit4.Text)
            Connectionstatus4 = True
        ElseIf txtUnit4.BackColor = SystemColors.Menu And Connectionstatus4 = True Then
            addLog(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + txtUnit4.Text)
            Connectionstatus4 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName4, ToolTipIcon.Info)
        End If



    End Sub

    Private Sub Tb1Sound_Scroll(sender As Object, e As EventArgs) Handles Tb1Sound.Scroll

    End Sub



    Public Sub addLog(udpInfo As String)
        'Lägg till log
        LBLogg.Items.Add(udpInfo)
        'Gör inte statusrutan större än vad som behövs, ta bort om över 25 poster.
        If LBLogg.Items.Count > 15 Then
            LBLogg.Items.RemoveAt(0)
        End If
    End Sub


    'Kontroll för att skicka ljudkänslighet till AHE

    Private Sub TBSens1_MouseUp(sender As Object, e As MouseEventArgs) Handles TBSens1.MouseUp
        SendUDP(AHESyncIP1, 11319, Encoding.ASCII.GetBytes("2" + TBSens1.Value.ToString))
        addLog(txtUnit1.Text & " Set sensitivity: " & TBSens1.Value.ToString * 10)
    End Sub

    Private Sub TBSens2_MouseUp(sender As Object, e As MouseEventArgs) Handles TBSens2.MouseUp
        SendUDP(AHESyncIP2, 11319, Encoding.ASCII.GetBytes("2" + TBSens2.Value.ToString))
        addLog(txtUnit2.Text & " Set sensitivity: " & TBSens2.Value.ToString * 10)
    End Sub

    Private Sub TBSens3_MouseUp(sender As Object, e As MouseEventArgs) Handles TBSens3.MouseUp
        SendUDP(AHESyncIP3, 11319, Encoding.ASCII.GetBytes("2" + TBSens3.Value.ToString))
        addLog(txtUnit3.Text & " Set sensitivity: " & TBSens3.Value.ToString * 10)
    End Sub

    Private Sub TBSens4_MouseUp(sender As Object, e As MouseEventArgs) Handles TBSens4.MouseUp
        SendUDP(AHESyncIP4, 11319, Encoding.ASCII.GetBytes("2" + TBSens4.Value.ToString))
        addLog(txtUnit4.Text & " Set sensitivity: " & TBSens4.Value.ToString * 10)
    End Sub

    Private Sub txtManSync_MouseClick(sender As Object, e As MouseEventArgs) Handles txtManSync.MouseClick
        If txtManSync.Text = "IP adress:" Then
            txtManSync.Text = ""
        End If
    End Sub

    Private Sub Tb1Sound_MouseUp(sender As Object, e As MouseEventArgs) Handles Tb1Sound.MouseUp
        addLog(SendUDP(AHESyncIP1, 11319, Encoding.ASCII.GetBytes("3" + (Tb1Sound.Value.ToString))))
        addLog(txtUnit1.Text & " Set sounds length: " & Tb1Sound.Value.ToString * 3.333 & " sek")
    End Sub
End Class
