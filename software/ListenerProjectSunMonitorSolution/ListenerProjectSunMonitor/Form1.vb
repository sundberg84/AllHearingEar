
Imports System.Net
Imports System.Net.Sockets
Imports System.Text.Encoding
Imports System.Threading




Public Class frmMain



    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load


        Me.Text = "All Hearing Ear"
        Me.Location = New Point(CInt((Screen.PrimaryScreen.WorkingArea.Width / 2) - (Me.Width / 2)), CInt((Screen.PrimaryScreen.WorkingArea.Height / 2) - (Me.Height / 2)))

        subscriber.Client.ReceiveTimeout = 100
        subscriber.Client.Blocking = False

        'Loggbok info
        LBLogg.Items.Add(DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " Startup succesfull!")

        'Nolla alla anslutningar
        Connectionstatus1 = False
        Connectionstatus2 = False
        Connectionstatus3 = False
        Connectionstatus4 = False


        NotifyIcon1.Visible = True 'Visa icon i taskbar vid start.

        'Ladda alla nödvändiga värden

        Me.CBAutostart.CheckState = My.Settings.chk1
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

        NumberOfUnitsSynced = My.Settings.NumOfSynUn

        'Visa synkade enheter
        If txtUnit1.Text <> "" Then
            txtUnit1.Visible = True
            txtUnit1.Enabled = False
            PBdelete1.Visible = True
            PBdelete1.Enabled = True
        End If
        If txtUnit2.Text <> "" Then
            txtUnit2.Visible = True
            txtUnit2.Enabled = False
            PBdelete2.Visible = True
            PBdelete2.Enabled = True
        End If
        If txtUnit3.Text <> "" Then
            txtUnit3.Visible = True
            txtUnit3.Enabled = False
            PBdelete3.Visible = True
            PBdelete3.Enabled = True
        End If
        If txtUnit4.Text <> "" Then
            txtUnit4.Visible = True
            txtUnit4.Enabled = False
            PBdelete4.Visible = True
            PBdelete4.Enabled = True
        End If

        'Kör findslot för att veta hur många enheter det finns syncade och för att veta vilken slot nästa enhet ska hamna i.
        Call FindSlot()

    End Sub

    Private Sub Form1_FormClosing(sender As Object, e As EventArgs) Handles Me.FormClosing

        'Spara alla nödvändiga värden.

        My.Settings.chk1 = Me.CBAutostart.CheckState
        My.Settings.hip1 = AHESyncIP1
        My.Settings.hip2 = AHESyncIP2
        My.Settings.hip3 = AHESyncIP3
        My.Settings.hip4 = AHESyncIP4
        My.Settings.syncName1 = AHEsyncName1
        My.Settings.syncName2 = AHEsyncName2
        My.Settings.syncName3 = AHEsyncName3
        My.Settings.syncName4 = AHEsyncName4
        My.Settings.NumOfSynUn = NumberOfUnitsSynced
        My.Settings.Save()

    End Sub

    'tmrListen lyssnar efter packet från alla IPadresser och alla portar.
    'ticks är räknare som känner av ifall vi fortfarande har anslutning var 5,5 sekund.
    '--------------------------------------------------------------------


    Dim ticks, ticks2, ticks3, ticks4 As Integer

    Private Sub tmrListen_Tick(ByVal sender As System.Object, ByVal e As EventArgs) Handles tmrListen.Tick

        ticks = ticks + 1
        ticks2 = ticks2 + 1

        If ticks > 54 Then
            txtUnit1.BackColor = SystemColors.Menu
            If Connectionstatus1 = True Then
                Call ConStat()
            End If
        End If

        If ticks2 > 54 Then
            txtUnit2.BackColor = SystemColors.Menu
            If Connectionstatus2 = True Then
                Call ConStat()
            End If
        End If

        If ticks3 > 54 Then
            txtUnit3.BackColor = SystemColors.Menu
            If Connectionstatus3 = True Then
                Call ConStat()
            End If
        End If

        If ticks3 > 54 Then
            txtUnit4.BackColor = SystemColors.Menu
            If Connectionstatus4 = True Then
                Call ConStat()
            End If
        End If
    End Sub

    Dim subscriber As New Sockets.UdpClient(11319)
    Private Sub TmrSync_Tick(ByVal sender As System.Object, ByVal e As EventArgs) Handles TmrSync.Tick

        Try
            Dim respondSync As IPEndPoint = New IPEndPoint(IPAddress.Any, 0)
            Dim rcvbytes2() As Byte = subscriber.Receive(respondSync)
            lblHwip.Text = ASCII.GetString(rcvbytes2)
            If lblHwip.Text = "1" Then
                lblHwip.Text = respondSync.Address.ToString()
                CurrentSync = respondSync.Address.ToString()

                Call SyncNew()


            ElseIf lblHwip.Text = "0" Or lblHwip.Text = "" Then
                lblHwip.Text = "Inga AHE svarade!"

            End If

        Catch ex As Exception

        End Try


    End Sub

    Private Sub Receive_Vox_Click(sender As Object, e As EventArgs) Handles Receive_Vox.Click
        If Receive_Vox.Text = "Listen" Then
            btnSetup.Enabled = False
            Receive_Vox.Text = "Stop"
        ElseIf Receive_Vox.Text = "Stop" Then
            btnSetup.Enabled = True
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You disconnected from All Hearing Ear!")
            Receive_Vox.Text = "Listen"
            txtUnit1.BackColor = SystemColors.Menu
            txtUnit2.BackColor = SystemColors.Menu
            txtUnit3.BackColor = SystemColors.Menu
            txtUnit4.BackColor = SystemColors.Menu
        End If


    End Sub

    'Visa Loggbok vid checkbox.
    '--------------------------
    Private Sub CBLogg_CheckedChanged(sender As Object, e As EventArgs) Handles CBLogg.CheckedChanged
        If CBLogg.Checked = True Then
            Me.Height = 555
        Else
            Me.Height = 308
        End If
    End Sub

    'Kod för att minimering av program ska visas i taskbar. Inkl Stripmenu och dubbelklick.
    '--------------------------------------------------------------------------------------
    Private Sub ExitToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ExitToolStripMenuItem.Click
        End
    End Sub

    Private Sub ShowToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles ShowToolStripMenuItem.Click
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

    Private Sub frmMain_SizeChanged(sender As Object, e As EventArgs) Handles Me.SizeChanged
        If Me.WindowState = FormWindowState.Minimized Then

            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Running minimized", ToolTipIcon.Info)
            Me.ShowInTaskbar = False
            Me.Visible = False
        Else

            Me.ShowInTaskbar = True
            Me.Visible = True
        End If
    End Sub

    'Länk till vår hemsida.
    '----------------------
    Private Sub Label5_MouseDown(sender As Object, e As MouseEventArgs) Handles Label5.MouseDown
        Try
            System.Diagnostics.Process.Start("http://www.google.se")
        Catch

        End Try
    End Sub


    'Kod för att CBAutostart checkbox för autostart fungerar som den ska.
    '--------------------------------------------------------------------
    Private Sub CBAutostart_CheckedChanged(sender As Object, e As EventArgs) Handles CBAutostart.CheckedChanged

        Dim applicationName As String = Application.ProductName
        Dim applicationPath As String = Application.ExecutablePath

        If CBAutostart.Checked Then
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


    Dim publisher As New Sockets.UdpClient(0)
    Dim SynkIP As String
    Dim SynktoPort As Integer
    Dim SynkWord As Byte = 1
    Private Sub btnSetup_Click(sender As Object, e As EventArgs) Handles btnSetup.Click

        SynktoPort = 11319
        SynkIP = "192.168.1.88"

        If btnSetup.Text = "Sync" Then
            TmrSync.Enabled = True
            btnSetup.Text = "Stop sync"
            Receive_Vox.Enabled = False
        ElseIf btnSetup.Text = "Stop sync" Then
            TmrSync.Enabled = False
            btnSetup.Text = "Sync"
            lblHwip.Text = ""
            Receive_Vox.Enabled = True
        End If

        publisher.Connect(SynkIP, SynktoPort)
        Dim sendbytes() As Byte = ASCII.GetBytes(SynkWord)
        publisher.Send(sendbytes, sendbytes.Length)

    End Sub

    Private Sub PBdelete1_Click(sender As Object, e As EventArgs) Handles PBdelete1.Click

        AHEsyncName1 = ""
        AHESyncIP1 = ""
        txtUnit1.Text = ""
        PBdelete1.Enabled = False
        PBdelete1.Visible = False


        Call FindSlot()

    End Sub

    Private Sub PBok1_Click(sender As Object, e As EventArgs) Handles PBok1.Click

        If txtUnit1.Text = "" Then
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

        Call FindSlot()
    End Sub

    Dim CurrentSync As String
    Dim NumberOfUnitsSynced As Integer
    'Definiera värden som ska sparas när program sparas.
    Dim AHESyncIP1 As String
    Dim AHEsyncName1 As String
    Dim AHESyncIP2 As String
    Dim AHEsyncName2 As String
    Dim AHESyncIP3 As String
    Dim AHEsyncName3 As String
    Dim AHESyncIP4 As String
    Dim AHEsyncName4 As String

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
                    txtUnit1.Text = CurrentSync
                    AHESyncIP1 = CurrentSync

                    Call FindSlot()
                Case 1
                    txtUnit2.Visible = True
                    PBok2.Visible = True
                    PBok2.Enabled = True
                    txtUnit2.Text = CurrentSync
                    AHESyncIP2 = CurrentSync

                    Call FindSlot()
                Case 2
                    txtUnit3.Visible = True
                    PBok3.Visible = True
                    PBok3.Enabled = True
                    txtUnit3.Text = CurrentSync
                    AHESyncIP3 = CurrentSync

                    Call FindSlot()
                Case 3
                    txtUnit4.Visible = True
                    PBok4.Visible = True
                    PBok4.Enabled = True
                    txtUnit4.Text = CurrentSync
                    AHESyncIP4 = CurrentSync

                    Call FindSlot()

            End Select
        End If



    End Sub

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

                End If
            End If

            If txtUnit3.Text = "" Then
                txtUnit3.Text = txtUnit4.Text
                txtUnit4.Text = ""
                AHESyncIP3 = AHESyncIP4
                AHEsyncName3 = AHEsyncName4
                PBdelete4.Visible = False
                PBok4.Visible = False
                If txtUnit3.Text > "" Then
                    PBdelete3.Visible = True
                    PBdelete3.Enabled = True

                End If
                If txtUnit3.Text = "" Then
                    txtUnit3.Enabled = True
                    txtUnit3.Visible = False
                End If
            End If

            If txtUnit2.Text = "" Then
                txtUnit2.Text = txtUnit3.Text
                txtUnit3.Text = ""
                AHESyncIP2 = AHESyncIP3
                AHEsyncName2 = AHEsyncName3
                PBok3.Visible = False
                PBdelete3.Visible = False
                If txtUnit2.Text > "" Then
                    PBdelete2.Visible = True
                    PBdelete2.Enabled = True

                End If
                If txtUnit2.Text = "" Then
                    txtUnit2.Enabled = True
                    txtUnit2.Visible = False
                End If

            End If

            If txtUnit1.Text = "" Then
                txtUnit1.Text = txtUnit2.Text
                txtUnit2.Text = ""
                AHESyncIP1 = AHESyncIP2
                AHEsyncName1 = AHEsyncName2
                PBok2.Visible = False
                PBdelete2.Visible = False
                If txtUnit1.Text > "" Then
                    PBdelete1.Visible = True
                    PBdelete1.Enabled = True

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

    Private Sub ConStat()


        If txtUnit1.BackColor = Color.LightGreen And Connectionstatus1 = False Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + AHEsyncName1)
            Connectionstatus1 = True
        ElseIf txtUnit1.BackColor = SystemColors.Menu And Connectionstatus1 = True Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + AHEsyncName1)
            Connectionstatus1 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName1, ToolTipIcon.Info)
        End If

        If txtUnit2.BackColor = Color.LightGreen And Connectionstatus2 = False Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + AHEsyncName2)
            Connectionstatus2 = True
        ElseIf txtUnit2.BackColor = SystemColors.Menu And Connectionstatus2 = True Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + AHEsyncName2)
            Connectionstatus2 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName2, ToolTipIcon.Info)
        End If

        If txtUnit3.BackColor = Color.LightGreen And Connectionstatus3 = False Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + AHEsyncName3)
            Connectionstatus3 = True
        ElseIf txtUnit3.BackColor = SystemColors.Menu And Connectionstatus3 = True Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + AHEsyncName3)
            Connectionstatus3 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName3, ToolTipIcon.Info)
        End If

        If txtUnit4.BackColor = Color.LightGreen And Connectionstatus4 = False Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You are connected to: " + AHEsyncName4)
            Connectionstatus4 = True
        ElseIf txtUnit4.BackColor = SystemColors.Menu And Connectionstatus4 = True Then
            LBLogg.Items.Add(Environment.NewLine + DateAndTime.DateString + " " + DateAndTime.TimeOfDay + " You lost connection to: " + AHEsyncName4)
            Connectionstatus4 = False
            NotifyIcon1.ShowBalloonTip(1, "All Hearing Ear", "Connection lost to: " + AHEsyncName4, ToolTipIcon.Info)
        End If



    End Sub

End Class
