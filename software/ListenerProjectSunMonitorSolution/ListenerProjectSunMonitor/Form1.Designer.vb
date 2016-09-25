<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class frmMain
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(frmMain))
        Me.TmrSync = New System.Windows.Forms.Timer(Me.components)
        Me.tmrListen = New System.Windows.Forms.Timer(Me.components)
        Me.Receive_Vox = New System.Windows.Forms.Button()
        Me.Stop_Receiving = New System.Windows.Forms.Button()
        Me.GroupBox1 = New System.Windows.Forms.GroupBox()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.CBAutostart = New System.Windows.Forms.CheckBox()
        Me.TxtLogg = New System.Windows.Forms.TextBox()
        Me.CBLogg = New System.Windows.Forms.CheckBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.NotifyIcon1 = New System.Windows.Forms.NotifyIcon(Me.components)
        Me.ContextMenuStrip1 = New System.Windows.Forms.ContextMenuStrip(Me.components)
        Me.ShowToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.ExitToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.btnSetup = New System.Windows.Forms.Button()
        Me.GroupBox2 = New System.Windows.Forms.GroupBox()
        Me.PBdelete4 = New System.Windows.Forms.PictureBox()
        Me.PBok4 = New System.Windows.Forms.PictureBox()
        Me.PBdelete3 = New System.Windows.Forms.PictureBox()
        Me.PBok3 = New System.Windows.Forms.PictureBox()
        Me.PBdelete2 = New System.Windows.Forms.PictureBox()
        Me.PBok2 = New System.Windows.Forms.PictureBox()
        Me.PBdelete1 = New System.Windows.Forms.PictureBox()
        Me.PBok1 = New System.Windows.Forms.PictureBox()
        Me.txtUnit4 = New System.Windows.Forms.TextBox()
        Me.txtUnit3 = New System.Windows.Forms.TextBox()
        Me.txtUnit2 = New System.Windows.Forms.TextBox()
        Me.txtUnit1 = New System.Windows.Forms.TextBox()
        Me.lblHwip = New System.Windows.Forms.Label()
        Me.GroupBox1.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.ContextMenuStrip1.SuspendLayout()
        Me.GroupBox2.SuspendLayout()
        CType(Me.PBdelete4, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok4, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete3, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok3, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBdelete1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.PBok1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'TmrSync
        '
        '
        'tmrListen
        '
        '
        'Receive_Vox
        '
        Me.Receive_Vox.Location = New System.Drawing.Point(16, 198)
        Me.Receive_Vox.Name = "Receive_Vox"
        Me.Receive_Vox.Size = New System.Drawing.Size(75, 23)
        Me.Receive_Vox.TabIndex = 8
        Me.Receive_Vox.Text = "Lyssna"
        Me.Receive_Vox.UseVisualStyleBackColor = True
        '
        'Stop_Receiving
        '
        Me.Stop_Receiving.Enabled = False
        Me.Stop_Receiving.Location = New System.Drawing.Point(97, 198)
        Me.Stop_Receiving.Name = "Stop_Receiving"
        Me.Stop_Receiving.Size = New System.Drawing.Size(75, 23)
        Me.Stop_Receiving.TabIndex = 9
        Me.Stop_Receiving.Text = "Sluta Lyssna"
        Me.Stop_Receiving.UseVisualStyleBackColor = True
        '
        'GroupBox1
        '
        Me.GroupBox1.Controls.Add(Me.Label4)
        Me.GroupBox1.Controls.Add(Me.Label3)
        Me.GroupBox1.Controls.Add(Me.Label2)
        Me.GroupBox1.Controls.Add(Me.Label1)
        Me.GroupBox1.Location = New System.Drawing.Point(16, 398)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(339, 109)
        Me.GroupBox1.TabIndex = 10
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Data Recieved"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(6, 87)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(39, 13)
        Me.Label4.TabIndex = 11
        Me.Label4.Text = "Label4"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(6, 63)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(39, 13)
        Me.Label3.TabIndex = 10
        Me.Label3.Text = "Label3"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(6, 39)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(39, 13)
        Me.Label2.TabIndex = 9
        Me.Label2.Text = "Label2"
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(6, 16)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(39, 13)
        Me.Label1.TabIndex = 8
        Me.Label1.Text = "Label1"
        '
        'CBAutostart
        '
        Me.CBAutostart.AutoSize = True
        Me.CBAutostart.Location = New System.Drawing.Point(16, 227)
        Me.CBAutostart.Name = "CBAutostart"
        Me.CBAutostart.Size = New System.Drawing.Size(173, 17)
        Me.CBAutostart.TabIndex = 11
        Me.CBAutostart.Text = "Starta AHE när windows startar"
        Me.CBAutostart.UseVisualStyleBackColor = True
        '
        'TxtLogg
        '
        Me.TxtLogg.Location = New System.Drawing.Point(16, 270)
        Me.TxtLogg.Multiline = True
        Me.TxtLogg.Name = "TxtLogg"
        Me.TxtLogg.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.TxtLogg.Size = New System.Drawing.Size(339, 122)
        Me.TxtLogg.TabIndex = 12
        Me.TxtLogg.Text = "Logg"
        '
        'CBLogg
        '
        Me.CBLogg.AutoSize = True
        Me.CBLogg.Location = New System.Drawing.Point(16, 247)
        Me.CBLogg.Name = "CBLogg"
        Me.CBLogg.Size = New System.Drawing.Size(69, 17)
        Me.CBLogg.TabIndex = 13
        Me.CBLogg.Text = "Visa logg"
        Me.CBLogg.UseVisualStyleBackColor = True
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(0, 0)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(376, 62)
        Me.PictureBox1.TabIndex = 14
        Me.PictureBox1.TabStop = False
        '
        'NotifyIcon1
        '
        Me.NotifyIcon1.ContextMenuStrip = Me.ContextMenuStrip1
        Me.NotifyIcon1.Icon = CType(resources.GetObject("NotifyIcon1.Icon"), System.Drawing.Icon)
        Me.NotifyIcon1.Text = "All Hearing Ear"
        '
        'ContextMenuStrip1
        '
        Me.ContextMenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.ShowToolStripMenuItem, Me.ExitToolStripMenuItem})
        Me.ContextMenuStrip1.Name = "ContextMenuStrip1"
        Me.ContextMenuStrip1.Size = New System.Drawing.Size(185, 48)
        '
        'ShowToolStripMenuItem
        '
        Me.ShowToolStripMenuItem.Name = "ShowToolStripMenuItem"
        Me.ShowToolStripMenuItem.Size = New System.Drawing.Size(184, 22)
        Me.ShowToolStripMenuItem.Text = "Open All Hearing Ear"
        '
        'ExitToolStripMenuItem
        '
        Me.ExitToolStripMenuItem.Name = "ExitToolStripMenuItem"
        Me.ExitToolStripMenuItem.Size = New System.Drawing.Size(184, 22)
        Me.ExitToolStripMenuItem.Text = "Exit"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Cursor = System.Windows.Forms.Cursors.Hand
        Me.Label5.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label5.ForeColor = System.Drawing.Color.Blue
        Me.Label5.Location = New System.Drawing.Point(213, 251)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(148, 13)
        Me.Label5.TabIndex = 15
        Me.Label5.Text = "http://www.allhearingear.com"
        '
        'btnSetup
        '
        Me.btnSetup.Location = New System.Drawing.Point(280, 198)
        Me.btnSetup.Name = "btnSetup"
        Me.btnSetup.Size = New System.Drawing.Size(75, 23)
        Me.btnSetup.TabIndex = 22
        Me.btnSetup.Text = "Sync"
        Me.btnSetup.UseVisualStyleBackColor = True
        '
        'GroupBox2
        '
        Me.GroupBox2.Controls.Add(Me.PBdelete4)
        Me.GroupBox2.Controls.Add(Me.PBok4)
        Me.GroupBox2.Controls.Add(Me.PBdelete3)
        Me.GroupBox2.Controls.Add(Me.PBok3)
        Me.GroupBox2.Controls.Add(Me.PBdelete2)
        Me.GroupBox2.Controls.Add(Me.PBok2)
        Me.GroupBox2.Controls.Add(Me.PBdelete1)
        Me.GroupBox2.Controls.Add(Me.PBok1)
        Me.GroupBox2.Controls.Add(Me.txtUnit4)
        Me.GroupBox2.Controls.Add(Me.txtUnit3)
        Me.GroupBox2.Controls.Add(Me.txtUnit2)
        Me.GroupBox2.Controls.Add(Me.txtUnit1)
        Me.GroupBox2.Location = New System.Drawing.Point(16, 63)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(339, 129)
        Me.GroupBox2.TabIndex = 23
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Enheter"
        '
        'PBdelete4
        '
        Me.PBdelete4.Enabled = False
        Me.PBdelete4.Image = CType(resources.GetObject("PBdelete4.Image"), System.Drawing.Image)
        Me.PBdelete4.Location = New System.Drawing.Point(116, 97)
        Me.PBdelete4.Name = "PBdelete4"
        Me.PBdelete4.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete4.TabIndex = 11
        Me.PBdelete4.TabStop = False
        Me.PBdelete4.Visible = False
        '
        'PBok4
        '
        Me.PBok4.Enabled = False
        Me.PBok4.Image = CType(resources.GetObject("PBok4.Image"), System.Drawing.Image)
        Me.PBok4.Location = New System.Drawing.Point(116, 99)
        Me.PBok4.Name = "PBok4"
        Me.PBok4.Size = New System.Drawing.Size(15, 15)
        Me.PBok4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok4.TabIndex = 10
        Me.PBok4.TabStop = False
        Me.PBok4.Visible = False
        '
        'PBdelete3
        '
        Me.PBdelete3.Enabled = False
        Me.PBdelete3.Image = CType(resources.GetObject("PBdelete3.Image"), System.Drawing.Image)
        Me.PBdelete3.Location = New System.Drawing.Point(116, 71)
        Me.PBdelete3.Name = "PBdelete3"
        Me.PBdelete3.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete3.TabIndex = 9
        Me.PBdelete3.TabStop = False
        Me.PBdelete3.Visible = False
        '
        'PBok3
        '
        Me.PBok3.Enabled = False
        Me.PBok3.Image = CType(resources.GetObject("PBok3.Image"), System.Drawing.Image)
        Me.PBok3.Location = New System.Drawing.Point(116, 73)
        Me.PBok3.Name = "PBok3"
        Me.PBok3.Size = New System.Drawing.Size(15, 15)
        Me.PBok3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok3.TabIndex = 8
        Me.PBok3.TabStop = False
        Me.PBok3.Visible = False
        '
        'PBdelete2
        '
        Me.PBdelete2.Enabled = False
        Me.PBdelete2.Image = CType(resources.GetObject("PBdelete2.Image"), System.Drawing.Image)
        Me.PBdelete2.Location = New System.Drawing.Point(116, 45)
        Me.PBdelete2.Name = "PBdelete2"
        Me.PBdelete2.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete2.TabIndex = 7
        Me.PBdelete2.TabStop = False
        Me.PBdelete2.Visible = False
        '
        'PBok2
        '
        Me.PBok2.Enabled = False
        Me.PBok2.Image = CType(resources.GetObject("PBok2.Image"), System.Drawing.Image)
        Me.PBok2.Location = New System.Drawing.Point(116, 47)
        Me.PBok2.Name = "PBok2"
        Me.PBok2.Size = New System.Drawing.Size(15, 15)
        Me.PBok2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok2.TabIndex = 6
        Me.PBok2.TabStop = False
        Me.PBok2.Visible = False
        '
        'PBdelete1
        '
        Me.PBdelete1.Enabled = False
        Me.PBdelete1.Image = CType(resources.GetObject("PBdelete1.Image"), System.Drawing.Image)
        Me.PBdelete1.Location = New System.Drawing.Point(116, 19)
        Me.PBdelete1.Name = "PBdelete1"
        Me.PBdelete1.Size = New System.Drawing.Size(18, 18)
        Me.PBdelete1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBdelete1.TabIndex = 5
        Me.PBdelete1.TabStop = False
        Me.PBdelete1.Visible = False
        '
        'PBok1
        '
        Me.PBok1.Enabled = False
        Me.PBok1.Image = CType(resources.GetObject("PBok1.Image"), System.Drawing.Image)
        Me.PBok1.Location = New System.Drawing.Point(116, 22)
        Me.PBok1.Name = "PBok1"
        Me.PBok1.Size = New System.Drawing.Size(15, 15)
        Me.PBok1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PBok1.TabIndex = 4
        Me.PBok1.TabStop = False
        Me.PBok1.Visible = False
        '
        'txtUnit4
        '
        Me.txtUnit4.Location = New System.Drawing.Point(10, 97)
        Me.txtUnit4.Name = "txtUnit4"
        Me.txtUnit4.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit4.TabIndex = 3
        Me.txtUnit4.Visible = False
        '
        'txtUnit3
        '
        Me.txtUnit3.Location = New System.Drawing.Point(10, 71)
        Me.txtUnit3.Name = "txtUnit3"
        Me.txtUnit3.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit3.TabIndex = 2
        Me.txtUnit3.Visible = False
        '
        'txtUnit2
        '
        Me.txtUnit2.BackColor = System.Drawing.SystemColors.Window
        Me.txtUnit2.Location = New System.Drawing.Point(10, 45)
        Me.txtUnit2.Name = "txtUnit2"
        Me.txtUnit2.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit2.TabIndex = 1
        Me.txtUnit2.Visible = False
        '
        'txtUnit1
        '
        Me.txtUnit1.BackColor = System.Drawing.SystemColors.Window
        Me.txtUnit1.Location = New System.Drawing.Point(10, 19)
        Me.txtUnit1.Name = "txtUnit1"
        Me.txtUnit1.Size = New System.Drawing.Size(100, 20)
        Me.txtUnit1.TabIndex = 0
        Me.txtUnit1.Visible = False
        '
        'lblHwip
        '
        Me.lblHwip.AutoSize = True
        Me.lblHwip.Location = New System.Drawing.Point(277, 231)
        Me.lblHwip.Name = "lblHwip"
        Me.lblHwip.Size = New System.Drawing.Size(0, 13)
        Me.lblHwip.TabIndex = 24
        '
        'frmMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.ControlLightLight
        Me.ClientSize = New System.Drawing.Size(373, 511)
        Me.Controls.Add(Me.lblHwip)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.btnSetup)
        Me.Controls.Add(Me.TxtLogg)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.CBLogg)
        Me.Controls.Add(Me.CBAutostart)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.Stop_Receiving)
        Me.Controls.Add(Me.Receive_Vox)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.Name = "frmMain"
        Me.Text = "All Hearing Ear"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ContextMenuStrip1.ResumeLayout(False)
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox2.PerformLayout()
        CType(Me.PBdelete4, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok4, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete3, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok3, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBdelete1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.PBok1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents TmrSync As Timer
    Friend WithEvents tmrListen As Timer
    Friend WithEvents Receive_Vox As Button
    Friend WithEvents Stop_Receiving As Button
    Friend WithEvents GroupBox1 As GroupBox
    Friend WithEvents Label4 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents CBAutostart As CheckBox
    Friend WithEvents TxtLogg As TextBox
    Friend WithEvents CBLogg As CheckBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents NotifyIcon1 As NotifyIcon
    Friend WithEvents ShowToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents ExitToolStripMenuItem As ToolStripMenuItem
    Private WithEvents ContextMenuStrip1 As ContextMenuStrip
    Friend WithEvents Label5 As Label
    Friend WithEvents btnSetup As Button
    Friend WithEvents GroupBox2 As GroupBox
    Friend WithEvents txtUnit1 As TextBox
    Friend WithEvents txtUnit4 As TextBox
    Friend WithEvents txtUnit3 As TextBox
    Friend WithEvents txtUnit2 As TextBox
    Friend WithEvents PBdelete1 As PictureBox
    Friend WithEvents PBok1 As PictureBox
    Friend WithEvents PBdelete4 As PictureBox
    Friend WithEvents PBok4 As PictureBox
    Friend WithEvents PBdelete3 As PictureBox
    Friend WithEvents PBok3 As PictureBox
    Friend WithEvents PBdelete2 As PictureBox
    Friend WithEvents PBok2 As PictureBox
    Friend WithEvents lblHwip As Label
End Class
