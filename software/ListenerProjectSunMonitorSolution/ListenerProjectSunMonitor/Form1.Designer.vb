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
        Me.SuspendLayout()
        '
        'labIP
        '
        Me.labIP.AutoSize = True
        Me.labIP.Location = New System.Drawing.Point(238, 278)
        Me.labIP.Name = "labIP"
        Me.labIP.Size = New System.Drawing.Size(55, 13)
        Me.labIP.TabIndex = 1
        Me.labIP.Text = "IP Adress:"
        '
        'lblStatus
        '
        Me.lblStatus.AutoSize = True
        Me.lblStatus.Location = New System.Drawing.Point(12, 278)
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
        'frmMain
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.ControlLightLight
        Me.ClientSize = New System.Drawing.Size(377, 300)
        Me.Controls.Add(Me.lblListen)
        Me.Controls.Add(Me.lblStatus)
        Me.Controls.Add(Me.labIP)
        Me.Name = "frmMain"
        Me.Text = "All hearing ear"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents labIP As Label
    Friend WithEvents lblStatus As Label
    Friend WithEvents Timer1 As Timer
    Friend WithEvents tmrListen As Timer
    Friend WithEvents lblListen As Label
End Class
