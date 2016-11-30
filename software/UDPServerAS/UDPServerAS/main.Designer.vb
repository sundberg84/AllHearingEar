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
        Me.LBLogg = New System.Windows.Forms.ListBox()
        Me.audioStatus = New System.Windows.Forms.ListBox()
        Me.clients = New System.Windows.Forms.ListBox()
        Me.listentrenitton = New System.Windows.Forms.Timer(Me.components)
        Me.femSekPing = New System.Windows.Forms.Timer(Me.components)
        Me.SuspendLayout()
        '
        'LBLogg
        '
        Me.LBLogg.FormattingEnabled = True
        Me.LBLogg.Location = New System.Drawing.Point(12, 12)
        Me.LBLogg.Name = "LBLogg"
        Me.LBLogg.Size = New System.Drawing.Size(451, 342)
        Me.LBLogg.TabIndex = 0
        '
        'audioStatus
        '
        Me.audioStatus.FormattingEnabled = True
        Me.audioStatus.Location = New System.Drawing.Point(469, 12)
        Me.audioStatus.Name = "audioStatus"
        Me.audioStatus.Size = New System.Drawing.Size(295, 342)
        Me.audioStatus.TabIndex = 1
        '
        'clients
        '
        Me.clients.FormattingEnabled = True
        Me.clients.Location = New System.Drawing.Point(12, 360)
        Me.clients.Name = "clients"
        Me.clients.Size = New System.Drawing.Size(451, 121)
        Me.clients.TabIndex = 2
        '
        'listentrenitton
        '
        Me.listentrenitton.Interval = 1000
        '
        'femSekPing
        '
        Me.femSekPing.Interval = 4950
        '
        'main
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(768, 492)
        Me.Controls.Add(Me.clients)
        Me.Controls.Add(Me.audioStatus)
        Me.Controls.Add(Me.LBLogg)
        Me.Name = "main"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents LBLogg As ListBox
    Friend WithEvents audioStatus As ListBox
    Friend WithEvents clients As ListBox
    Friend WithEvents femSekPing As Timer
    Private WithEvents listentrenitton As Timer
End Class
