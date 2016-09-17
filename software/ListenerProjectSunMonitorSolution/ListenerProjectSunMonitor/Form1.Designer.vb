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
        Me.TmrLogg = New System.Windows.Forms.Timer(Me.components)
        Me.tmrListen = New System.Windows.Forms.Timer(Me.components)
        Me.lblListen = New System.Windows.Forms.Label()
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
        Me.GroupBox1.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.ContextMenuStrip1.SuspendLayout()
        Me.SuspendLayout()
        '
        'TmrLogg
        '
        Me.TmrLogg.Interval = 1000
        '
        'tmrListen
        '
        '
        'lblListen
        '
        Me.lblListen.AutoSize = True
        Me.lblListen.ForeColor = System.Drawing.Color.Black
        Me.lblListen.Location = New System.Drawing.Point(13, 252)
        Me.lblListen.Name = "lblListen"
        Me.lblListen.Size = New System.Drawing.Size(62, 13)
        Me.lblListen.TabIndex = 3
        Me.lblListen.Text = "Ej ansluten!"
        '
        'Receive_Vox
        '
        Me.Receive_Vox.Location = New System.Drawing.Point(16, 183)
        Me.Receive_Vox.Name = "Receive_Vox"
        Me.Receive_Vox.Size = New System.Drawing.Size(75, 23)
        Me.Receive_Vox.TabIndex = 8
        Me.Receive_Vox.Text = "Lyssna"
        Me.Receive_Vox.UseVisualStyleBackColor = True
        '
        'Stop_Receiving
        '
        Me.Stop_Receiving.Enabled = False
        Me.Stop_Receiving.Location = New System.Drawing.Point(97, 183)
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
        Me.GroupBox1.Location = New System.Drawing.Point(16, 68)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(343, 109)
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
        Me.CBAutostart.Location = New System.Drawing.Point(16, 212)
        Me.CBAutostart.Name = "CBAutostart"
        Me.CBAutostart.Size = New System.Drawing.Size(173, 17)
        Me.CBAutostart.TabIndex = 11
        Me.CBAutostart.Text = "Starta AHE när windows startar"
        Me.CBAutostart.UseVisualStyleBackColor = True
        '
        'TxtLogg
        '
        Me.TxtLogg.Location = New System.Drawing.Point(19, 278)
        Me.TxtLogg.Multiline = True
        Me.TxtLogg.Name = "TxtLogg"
        Me.TxtLogg.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.TxtLogg.Size = New System.Drawing.Size(339, 155)
        Me.TxtLogg.TabIndex = 12
        Me.TxtLogg.Text = "Logg"
        '
        'CBLogg
        '
        Me.CBLogg.AutoSize = True
        Me.CBLogg.Location = New System.Drawing.Point(16, 232)
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
        Me.ContextMenuStrip1.Size = New System.Drawing.Size(185, 70)
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
        Me.ExitToolStripMenuItem.Size = New System.Drawing.Size(103, 22)
        Me.ExitToolStripMenuItem.Text = "Exit"
        '
        'frmMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.ControlLightLight
        Me.ClientSize = New System.Drawing.Size(371, 442)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.CBLogg)
        Me.Controls.Add(Me.TxtLogg)
        Me.Controls.Add(Me.CBAutostart)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.Stop_Receiving)
        Me.Controls.Add(Me.Receive_Vox)
        Me.Controls.Add(Me.lblListen)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.Name = "frmMain"
        Me.Text = "All hearing ear"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ContextMenuStrip1.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents TmrLogg As Timer
    Friend WithEvents tmrListen As Timer
    Friend WithEvents lblListen As Label
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
End Class
