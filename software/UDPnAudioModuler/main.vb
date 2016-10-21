Imports System.Text

Public Class main

    Public Sub main_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        'Skicka Sync
        LBLogg.Items.Add(SendUDP("192.168.1.255", 11319, Encoding.ASCII.GetBytes("1")))
        udpAudioThread()


    End Sub


    Private Sub main_FormClosed(sender As Object, e As FormClosedEventArgs) Handles Me.FormClosed
        'När vi stänger main så ska alla udp stängas.
        StopAudioUDP()
        End
    End Sub

    Public Sub addLog(udpInfo As String)
        'Lägg till log
        LBLogg.Items.Add(udpInfo)
        'Gör inte statusrutan större än vad som behövs, ta bort om över 25 poster.
        If LBLogg.Items.Count > 25 Then
            LBLogg.Items.RemoveAt(0)
        End If
    End Sub

End Class

