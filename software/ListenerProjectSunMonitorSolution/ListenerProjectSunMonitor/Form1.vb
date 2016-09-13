Imports System.Net
Imports System.Text.Encoding

Public Class frmMain

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim IPhost As IPHostEntry = Dns.GetHostByName(Dns.GetHostName())
            labIP.Text = "IP Adress: " & IPhost.AddressList(0).ToString()
        Catch ex As Exception
            MsgBox("There is an Error!")
        End Try

        Timer1.Enabled = True

    End Sub


    Private Function getcomputername() As String
        Return Dns.GetHostName
    End Function

    Function ConnectionStatus() As Boolean
        Return My.Computer.Network.Ping("8.8.8.8")
    End Function

    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick
        Try
            If ConnectionStatus() = True Then
                lblStatus.Text = "Status: " & "Ansluten!"
            ElseIf ConnectionStatus() = False Then
                lblStatus.Text = "Status: " & "Ej ansluten!"
            End If
        Catch ex As Exception
            lblStatus.Text = "Status: " & "Ej ansluten!"
        End Try

    End Sub

    Private Sub tmrListen_Tick(sender As Object, e As EventArgs) Handles tmrListen.Tick

    End Sub
End Class
