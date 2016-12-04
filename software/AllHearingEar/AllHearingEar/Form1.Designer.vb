<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class main
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(main))
        Me.BtnListen = New System.Windows.Forms.Button()
        Me.LBLogg = New System.Windows.Forms.ListBox()
        Me.CBLogg = New System.Windows.Forms.CheckBox()
        Me.CBAutoStart = New System.Windows.Forms.CheckBox()
        Me.NotifyIcon1 = New System.Windows.Forms.NotifyIcon(Me.components)
        Me.ContextMenuStrip1 = New System.Windows.Forms.ContextMenuStrip(Me.components)
        Me.OpenAllHearingEarToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.ExitToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.Timer1 = New System.Windows.Forms.Timer(Me.components)
        Me.LinkLabel1 = New System.Windows.Forms.LinkLabel()
        Me.GroupBox1 = New System.Windows.Forms.GroupBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.TBVolume1 = New System.Windows.Forms.TrackBar()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.TBSens4 = New System.Windows.Forms.TrackBar()
        Me.TBSens3 = New System.Windows.Forms.TrackBar()
        Me.TBSens2 = New System.Windows.Forms.TrackBar()
        Me.TBSens1 = New System.Windows.Forms.TrackBar()
        Me.PBdelete4 = New System.Windows.Forms.PictureBox()
        Me.PBdelete3 = New System.Windows.Forms.PictureBox()
        Me.PBdelete2 = New System.Windows.Forms.PictureBox()
        Me.PBdelete1 = New System.Windows.Forms.PictureBox()
        Me.PBok4 = New System.Windows.Forms.PictureBox()
        Me.PBok3 = New System.Windows.Forms.PictureBox()
        Me.PBok2 = New System.Windows.Forms.PictureBox()
        Me.PBok1 = New System.Windows.Forms.PictureBox()
        Me.txtUnit4 = New System.Windows.Forms.TextBox()
        Me.txtUnit3 = New System.Windows.Forms.TextBox()
        Me.txtUnit2 = New System.Windows.Forms.TextBox()
        Me.txtUnit1 = New System.Windows.Forms.TextBox()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.txtManSync = New System.Windows.Forms.TextBox()
        Me.ContextMenuStrip1.SuspendLayout()
        Me.GroupBox1.SuspendLayout()
        CType(Me.TBVolume1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.TBSens4, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.TBSens3, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.TBSens2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.TBSens1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete4, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete3, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok4, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok3, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'BtnListen
        '
        Me.BtnListen.Location = New System.Drawing.Point(12, 218)
        Me.BtnListen.Name = "BtnListen"
        Me.BtnListen.Size = New System.Drawing.Size(75, 23)
        Me.BtnListen.TabIndex = 0
        Me.BtnListen.Text = "Disconnect"
        Me.BtnListen.UseVisualStyleBackColor = True
        '
        'LBLogg
        '
        Me.LBLogg.FormattingEnabled = True
        Me.LBLogg.Location = New System.Drawing.Point(12, 291)
        Me.LBLogg.Name = "LBLogg"
        Me.LBLogg.Size = New System.Drawing.Size(349, 173)
        Me.LBLogg.TabIndex = 1
        '
        'CBLogg
        '
        Me.CBLogg.AutoSize = True
        Me.CBLogg.Location = New System.Drawing.Point(12, 268)
        Me.CBLogg.Name = "CBLogg"
        Me.CBLogg.Size = New System.Drawing.Size(70, 17)
        Me.CBLogg.TabIndex = 3
        Me.CBLogg.Text = "Show log"
        Me.CBLogg.UseVisualStyleBackColor = True
        '
        'CBAutoStart
        '
        Me.CBAutoStart.AutoSize = True
        Me.CBAutoStart.Location = New System.Drawing.Point(12, 245)
        Me.CBAutoStart.Name = "CBAutoStart"
        Me.CBAutoStart.Size = New System.Drawing.Size(135, 17)
        Me.CBAutoStart.TabIndex = 4
        Me.CBAutoStart.Text = "Autostart AllHearingEar"
        Me.CBAutoStart.TextAlign = System.Drawing.ContentAlignment.BottomLeft
        Me.CBAutoStart.UseVisualStyleBackColor = True
        '
        'NotifyIcon1
        '
        Me.NotifyIcon1.BalloonTipIcon = System.Windows.Forms.ToolTipIcon.Info
        Me.NotifyIcon1.ContextMenuStrip = Me.ContextMenuStrip1
        Me.NotifyIcon1.Icon = CType(resources.GetObject("NotifyIcon1.Icon"), System.Drawing.Icon)
        Me.NotifyIcon1.Text = "All Hearing Ear"
        '
        'ContextMenuStrip1
        '
        Me.ContextMenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.OpenAllHearingEarToolStripMenuItem, Me.ExitToolStripMenuItem})
        Me.ContextMenuStrip1.Name = "ContextMenuStrip1"
        Me.ContextMenuStrip1.Size = New System.Drawing.Size(185, 48)
        '
        'OpenAllHearingEarToolStripMenuItem
        '
        Me.OpenAllHearingEarToolStripMenuItem.Name = "OpenAllHearingEarToolStripMenuItem"
        Me.OpenAllHearingEarToolStripMenuItem.Size = New System.Drawing.Size(184, 22)
        Me.OpenAllHearingEarToolStripMenuItem.Text = "Open All Hearing Ear"
        '
        'ExitToolStripMenuItem
        '
        Me.ExitToolStripMenuItem.Name = "ExitToolStripMenuItem"
        Me.ExitToolStripMenuItem.Size = New System.Drawing.Size(184, 22)
        Me.ExitToolStripMenuItem.Text = "Exit"
        '
        'Timer1
        '
        Me.Timer1.Enabled = True
        '
        'LinkLabel1
        '
        Me.LinkLabel1.AutoSize = True
        Me.LinkLabel1.Location = New System.Drawing.Point(211, 275)
        Me.LinkLabel1.Name = "LinkLabel1"
        Me.LinkLabel1.Size = New System.Drawing.Size(148, 13)
        Me.LinkLabel1.TabIndex = 6
        Me.LinkLabel1.TabStop = True
        Me.LinkLabel1.Text = "http://www.allhearingear.com"
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.Label2)
        Me.GroupBox1.Controls.Add(Me.TBVolume1)
        Me.GroupBox1.Controls.Add(Me.Label1)
        Me.GroupBox1.Controls.Add(Me.TBSens4)
        Me.GroupBox1.Controls.Add(Me.TBSens3)
        Me.GroupBox1.Controls.Add(Me.TBSens2)
        Me.GroupBox1.Controls.Add(Me.TBSens1)
        Me.GroupBox1.Controls.Add(Me.PBdelete4)
        Me.GroupBox1.Controls.Add(Me.PBdelete3)
        Me.GroupBox1.Controls.Add(Me.PBdelete2)
        Me.GroupBox1.Controls.Add(Me.PBdelete1)
        Me.GroupBox1.Controls.Add(Me.PBok4)
        Me.GroupBox1.Controls.Add(Me.PBok3)
        Me.GroupBox1.Controls.Add(Me.PBok2)
        Me.GroupBox1.Controls.Add(Me.PBok1)
        Me.GroupBox1.Controls.Add(Me.txtUnit4)
        Me.GroupBox1.Controls.Add(Me.txtUnit3)
        Me.GroupBox1.Controls.Add(Me.txtUnit2)
        Me.GroupBox1.Controls.Add(Me.txtUnit1)
        Me.GroupBox1.Location = New System.Drawing.Point(12, 66)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(349, 129)
        Me.GroupBox1.TabIndex = 5
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Units:"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(286, 0)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(42, 13)
        Me.Label2.TabIndex = 7
        Me.Label2.Text = "Master:"
        '
        'TBVolume1
        '
        Me.TBVolume1.AutoSize = False
        Me.TBVolume1.Location = New System.Drawing.Point(298, 19)
        Me.TBVolume1.Name = "TBVolume1"
        Me.TBVolume1.Orientation = System.Windows.Forms.Orientation.Vertical
        Me.TBVolume1.Size = New System.Drawing.Size(30, 98)
        Me.TBVolume1.TabIndex = 16
        Me.TBVolume1.TickStyle = System.Windows.Forms.TickStyle.None
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(151, 0)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(57, 13)
        Me.Label1.TabIndex = 7
        Me.Label1.Text = "Sensitivity:"
        '
        'TBSens4
        '
        Me.TBSens4.AutoSize = False
        Me.TBSens4.Enabled = False
        Me.TBSens4.Location = New System.Drawing.Point(145, 97)
        Me.TBSens4.Maximum = 9
        Me.TBSens4.Name = "TBSens4"
        Me.TBSens4.Size = New System.Drawing.Size(83, 20)
        Me.TBSens4.TabIndex = 15
        Me.TBSens4.TabStop = False
        Me.TBSens4.TickStyle = System.Windows.Forms.TickStyle.None
        Me.TBSens4.Visible = False
        '
        'TBSens3
        '
        Me.TBSens3.AutoSize = False
        Me.TBSens3.Enabled = False
        Me.TBSens3.Location = New System.Drawing.Point(145, 71)
        Me.TBSens3.Maximum = 9
        Me.TBSens3.Name = "TBSens3"
        Me.TBSens3.Size = New System.Drawing.Size(83, 20)
        Me.TBSens3.TabIndex = 14
        Me.TBSens3.TabStop = False
        Me.TBSens3.TickStyle = System.Windows.Forms.TickStyle.None
        Me.TBSens3.Visible = False
        '
        'TBSens2
        '
        Me.TBSens2.AutoSize = False
        Me.TBSens2.Enabled = False
        Me.TBSens2.Location = New System.Drawing.Point(145, 45)
        Me.TBSens2.Maximum = 9
        Me.TBSens2.Name = "TBSens2"
        Me.TBSens2.Size = New System.Drawing.Size(83, 20)
        Me.TBSens2.TabIndex = 13
        Me.TBSens2.TabStop = False
        Me.TBSens2.TickStyle = System.Windows.Forms.TickStyle.None
        Me.TBSens2.Visible = False
        '
        'TBSens1
        '
        Me.TBSens1.AutoSize = False
        Me.TBSens1.Enabled = False
        Me.TBSens1.LargeChange = 1
        Me.TBSens1.Location = New System.Drawing.Point(145, 19)
        Me.TBSens1.Maximum = 9
        Me.TBSens1.Name = "TBSens1"
        Me.TBSens1.Size = New System.Drawing.Size(83, 20)
        Me.TBSens1.TabIndex = 12
        Me.TBSens1.TabStop = False
        Me.TBSens1.TickStyle = System.Windows.Forms.TickStyle.None
        Me.TBSens1.Visible = False
        '
        'PBdelete4
        '
        Me.PBdelete4.Image = Global.AllHearingEar.My.Resources.Resources.delete
        Me.PBdelete4.Location = New System.Drawing.Point(112, 97)
        Me.PBdelete4.Name = "PBdelete4"
        Me.PBdelete4.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete4.TabIndex = 11
        Me.PBdelete4.TabStop = False
        Me.PBdelete4.Visible = False
        '
        'PBdelete3
        '
        Me.PBdelete3.Image = Global.AllHearingEar.My.Resources.Resources.delete
        Me.PBdelete3.Location = New System.Drawing.Point(112, 71)
        Me.PBdelete3.Name = "PBdelete3"
        Me.PBdelete3.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete3.TabIndex = 10
        Me.PBdelete3.TabStop = False
        Me.PBdelete3.Visible = False
        '
        'PBdelete2
        '
        Me.PBdelete2.Image = Global.AllHearingEar.My.Resources.Resources.delete
        Me.PBdelete2.Location = New System.Drawing.Point(112, 45)
        Me.PBdelete2.Name = "PBdelete2"
        Me.PBdelete2.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete2.TabIndex = 9
        Me.PBdelete2.TabStop = False
        Me.PBdelete2.Visible = False
        '
        'PBdelete1
        '
        Me.PBdelete1.Image = Global.AllHearingEar.My.Resources.Resources.delete
        Me.PBdelete1.Location = New System.Drawing.Point(112, 19)
        Me.PBdelete1.Name = "PBdelete1"
        Me.PBdelete1.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete1.TabIndex = 8
        Me.PBdelete1.TabStop = False
        Me.PBdelete1.Visible = False
        '
        'PBok4
        '
        Me.PBok4.Image = Global.AllHearingEar.My.Resources.Resources.greeok
        Me.PBok4.Location = New System.Drawing.Point(112, 99)
        Me.PBok4.Name = "PBok4"
        Me.PBok4.Size = New System.Drawing.Size(15, 15)
        Me.PBok4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok4.TabIndex = 7
        Me.PBok4.TabStop = False
        Me.PBok4.Visible = False
        '
        'PBok3
        '
        Me.PBok3.Image = Global.AllHearingEar.My.Resources.Resources.greeok
        Me.PBok3.Location = New System.Drawing.Point(112, 73)
        Me.PBok3.Name = "PBok3"
        Me.PBok3.Size = New System.Drawing.Size(15, 15)
        Me.PBok3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok3.TabIndex = 6
        Me.PBok3.TabStop = False
        Me.PBok3.Visible = False
        '
        'PBok2
        '
        Me.PBok2.Image = Global.AllHearingEar.My.Resources.Resources.greeok
        Me.PBok2.Location = New System.Drawing.Point(112, 47)
        Me.PBok2.Name = "PBok2"
        Me.PBok2.Size = New System.Drawing.Size(15, 15)
        Me.PBok2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok2.TabIndex = 5
        Me.PBok2.TabStop = False
        Me.PBok2.Visible = False
        '
        'PBok1
        '
        Me.PBok1.Image = Global.AllHearingEar.My.Resources.Resources.greeok
        Me.PBok1.Location = New System.Drawing.Point(112, 21)
        Me.PBok1.Name = "PBok1"
        Me.PBok1.Size = New System.Drawing.Size(15, 15)
        Me.PBok1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok1.TabIndex = 4
        Me.PBok1.TabStop = False
        Me.PBok1.Visible = False
        '
        'txtUnit4
        '
        Me.txtUnit4.Location = New System.Drawing.Point(6, 97)
        Me.txtUnit4.Name = "txtUnit4"
        Me.txtUnit4.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit4.TabIndex = 3
        '
        'txtUnit3
        '
        Me.txtUnit3.Location = New System.Drawing.Point(6, 71)
        Me.txtUnit3.Name = "txtUnit3"
        Me.txtUnit3.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit3.TabIndex = 2
        '
        'txtUnit2
        '
        Me.txtUnit2.Location = New System.Drawing.Point(6, 45)
        Me.txtUnit2.Name = "txtUnit2"
        Me.txtUnit2.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit2.TabIndex = 1
        '
        'txtUnit1
        '
        Me.txtUnit1.Location = New System.Drawing.Point(6, 19)
        Me.txtUnit1.Name = "txtUnit1"
        Me.txtUnit1.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit1.TabIndex = 0
        Me.txtUnit1.Text = "Enter name:"
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(284, 218)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(77, 23)
        Me.Button1.TabIndex = 7
        Me.Button1.Text = "Manual sync"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = Global.AllHearingEar.My.Resources.Resources.AHE
        Me.PictureBox1.Location = New System.Drawing.Point(0, -1)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(374, 61)
        Me.PictureBox1.TabIndex = 2
        Me.PictureBox1.TabStop = False
        '
        'txtManSync
        '
        Me.txtManSync.Location = New System.Drawing.Point(261, 247)
        Me.txtManSync.Name = "txtManSync"
        Me.txtManSync.Size = New System.Drawing.Size(100, 20)
        Me.txtManSync.TabIndex = 8
        Me.txtManSync.Text = "IP adress:"
        Me.txtManSync.Visible = False
        '
        'main
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(373, 475)
        Me.ContextMenuStrip = Me.ContextMenuStrip1
        Me.Controls.Add(Me.txtManSync)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.LinkLabel1)
        Me.Controls.Add(Me.CBAutoStart)
        Me.Controls.Add(Me.CBLogg)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.LBLogg)
        Me.Controls.Add(Me.BtnListen)
        Me.Controls.Add(Me.GroupBox1)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.MaximizeBox = False
        Me.Name = "main"
        Me.Text = "AllHearingEar"
        Me.ContextMenuStrip1.ResumeLayout(False)
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        CType(Me.TBVolume1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.TBSens4, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.TBSens3, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.TBSens2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.TBSens1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete4, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete3, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok4, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok3, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents BtnListen As Button
    Friend WithEvents LBLogg As ListBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents CBLogg As CheckBox
    Friend WithEvents CBAutoStart As CheckBox
    Friend WithEvents NotifyIcon1 As NotifyIcon
    Friend WithEvents ContextMenuStrip1 As ContextMenuStrip
    Friend WithEvents OpenAllHearingEarToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents ExitToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents Timer1 As Timer
    Friend WithEvents LinkLabel1 As LinkLabel
    Friend WithEvents GroupBox1 As GroupBox
    Friend WithEvents TBSens4 As TrackBar
    Friend WithEvents TBSens3 As TrackBar
    Friend WithEvents TBSens2 As TrackBar
    Friend WithEvents TBSens1 As TrackBar
    Friend WithEvents PBdelete4 As PictureBox
    Friend WithEvents PBdelete3 As PictureBox
    Friend WithEvents PBdelete2 As PictureBox
    Friend WithEvents PBdelete1 As PictureBox
    Friend WithEvents PBok4 As PictureBox
    Friend WithEvents PBok3 As PictureBox
    Friend WithEvents PBok2 As PictureBox
    Friend WithEvents PBok1 As PictureBox
    Friend WithEvents txtUnit4 As TextBox
    Friend WithEvents txtUnit3 As TextBox
    Friend WithEvents txtUnit2 As TextBox
    Friend WithEvents txtUnit1 As TextBox
    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents TBVolume1 As TrackBar
    Friend WithEvents Button1 As Button
    Friend WithEvents txtManSync As TextBox
End Class
