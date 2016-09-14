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
        Me.labIP = New System.Windows.Forms.Label()
        Me.lblStatus = New System.Windows.Forms.Label()
        Me.Timer1 = New System.Windows.Forms.Timer(Me.components)
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
        Me.GroupBox1.SuspendLayout()
        Me.SuspendLayout()
        '
        'labIP
        '
        Me.labIP.AutoSize = True
        Me.labIP.Location = New System.Drawing.Point(238, 235)
        Me.labIP.Name = "labIP"
        Me.labIP.Size = New System.Drawing.Size(55, 13)
        Me.labIP.TabIndex = 1
        Me.labIP.Text = "IP Adress:"
        '
        'lblStatus
        '
        Me.lblStatus.AutoSize = True
        Me.lblStatus.Location = New System.Drawing.Point(12, 235)
        Me.lblStatus.Name = "lblStatus"
        Me.lblStatus.Size = New System.Drawing.Size(40, 13)
        Me.lblStatus.TabIndex = 2
        Me.lblStatus.Text = "Status:"
        '
        'Timer1
        '
        Me.Timer1.Interval = 5
        '
        'tmrListen
        '
        Me.tmrListen.Enabled = True
        '
        'lblListen
        '
        Me.lblListen.AutoSize = True
        Me.lblListen.Location = New System.Drawing.Point(13, 24)
        Me.lblListen.Name = "lblListen"
        Me.lblListen.Size = New System.Drawing.Size(43, 13)
        Me.lblListen.TabIndex = 3
        Me.lblListen.Text = "Indata: "
        '
        'Receive_Vox
        '
        Me.Receive_Vox.Location = New System.Drawing.Point(16, 166)
        Me.Receive_Vox.Name = "Receive_Vox"
        Me.Receive_Vox.Size = New System.Drawing.Size(75, 23)
        Me.Receive_Vox.TabIndex = 8
        Me.Receive_Vox.Text = "Lyssna"
        Me.Receive_Vox.UseVisualStyleBackColor = True
        '
        'Stop_Receiving
        '
        Me.Stop_Receiving.Enabled = False
        Me.Stop_Receiving.Location = New System.Drawing.Point(97, 166)
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
        Me.GroupBox1.Location = New System.Drawing.Point(16, 51)
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
        Me.CBAutostart.Location = New System.Drawing.Point(16, 195)
        Me.CBAutostart.Name = "CBAutostart"
        Me.CBAutostart.Size = New System.Drawing.Size(173, 17)
        Me.CBAutostart.TabIndex = 11
        Me.CBAutostart.Text = "Starta AHE när windows startar"
        Me.CBAutostart.UseVisualStyleBackColor = True
        '
        'frmMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.ControlLightLight
        Me.ClientSize = New System.Drawing.Size(371, 257)
        Me.Controls.Add(Me.CBAutostart)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.Stop_Receiving)
        Me.Controls.Add(Me.Receive_Vox)
        Me.Controls.Add(Me.lblListen)
        Me.Controls.Add(Me.lblStatus)
        Me.Controls.Add(Me.labIP)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Name = "frmMain"
        Me.Text = "All hearing ear"
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents labIP As Label
    Friend WithEvents lblStatus As Label
    Friend WithEvents Timer1 As Timer
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
End Class
