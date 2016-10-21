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
        Me.LBLogg = New System.Windows.Forms.ListBox()
        Me.audioStatus = New System.Windows.Forms.ListBox()
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
        Me.audioStatus.Location = New System.Drawing.Point(486, 12)
        Me.audioStatus.Name = "audioStatus"
        Me.audioStatus.Size = New System.Drawing.Size(295, 342)
        Me.audioStatus.TabIndex = 1
        '
        'main
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(793, 377)
        Me.Controls.Add(Me.audioStatus)
        Me.Controls.Add(Me.LBLogg)
        Me.Name = "main"
        Me.Text = "Form1"
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents LBLogg As ListBox
    Friend WithEvents audioStatus As ListBox
End Class
