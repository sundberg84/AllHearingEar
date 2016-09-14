Imports System.Net
Imports System.Text.Encoding

Public Class frmMain

    Dim subscriber As New Sockets.UdpClient(11000)

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

        subscriber.Client.ReceiveTimeout = 100
        subscriber.Client.Blocking = False

        'Här hittar vi IPadressen på den lokala datorn. Denna ska användas i webapplication vid synkning av hårdvara/mjukvara.
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

    'Pinga IPadress
    Function ConnectionStatus() As Boolean
        Return My.Computer.Network.Ping("8.8.8.8")
    End Function

    'Timer1 kollar hela tiden om ConnectionStatus får ett svar.
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

    'tmrListen lyssnar efter packet från alla IPadresser och alla portar.
    Private Sub tmrListen_Tick(ByVal sender As System.Object, ByVal e As EventArgs) Handles Timer1.Tick

        Try
            Dim ep As IPEndPoint = New IPEndPoint(IPAddress.Any, 0)
            Dim rcvbytes() As Byte = subscriber.Receive(ep)
            lblListen.Text = ASCII.GetString(rcvbytes)
        Catch ex As Exception
        End Try

    End Sub

End Class
