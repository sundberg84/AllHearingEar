Imports System.Media
Module Audio


    Dim RcvdWaveFileBytes As New List(Of Byte())
    Dim CompleteStream() As Byte

    'CreateAudioStream är main thread - skicka UDP data hit.
    Public Sub CreateAudioStream(inputRawAudio As List(Of Byte()))

        '--//DEBUG//--
        If inputRawAudio.Count <= 0 Then
            MsgBox("No data arrived!", vbAbort, "Error")
            Exit Sub
        End If

        '--//STREAM//--
        CreateWavStream(10000, inputRawAudio.Count, inputRawAudio)

        'Klar - spela upp - Spela upp SKITEN!!!
        Using Audio As New IO.MemoryStream(CompleteStream)
            Dim player As New Media.SoundPlayer(Audio)
            player.Play()
        End Using


    End Sub

    Private Sub CreateWavStream(s_rate As Integer, sample_size As Integer, WaveData As List(Of Byte()))

        's_rate = Kommer i @20kHz från AHE
        'Om du vill spara på hårddisken (lägga till senare?)

        Dim sample As New List(Of Byte)
        sample.Clear()
        For i = 0 To 48
            sample.AddRange(WaveData(i)) ' Add indexes 0 to 24 byte arrays to WaveData from RcvdWaveFileBytes
        Next

        WaveData.RemoveRange(0, 50) ' Remove indexes 0 to 24 (25 total indexes) from RcvdWaveFileBytes

        Dim ChunkID() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("RIFF")
        Dim Format() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("WAVE")
        Dim Subchunk1ID() As Byte = System.Text.ASCIIEncoding.ASCII.GetBytes("fmt ")

        Dim sample_rate As Integer
        Dim num_channels As Integer = 2
        Dim bytes_per_sample As Integer = 2 '(*8 för bits/sample)
        Dim byte_rate As Integer

        If s_rate < 0 Then
            sample_rate = 10000
        Else
            sample_rate = s_rate
        End If

        byte_rate = CInt(num_channels * sample_rate * (bytes_per_sample * 8) / 8)

        'Se http://soundfile.sapp.org/doc/WaveFormat/ för hur en WAVE format är uppbyggt (RIFF, FMT, DATA).

        Dim AudioStream As New IO.MemoryStream
        Using AudioStream

            '/* RIFF */ 
            AudioStream.Write(ChunkID, 0, 4)                                                            'ChunkID, 4 bytes
            AudioStream.Write(BitConv(sample.Count + 36, 4), 0, 4)                                       'FileSize, 4 bytes
            AudioStream.Write(Format, 0, 4)                                                             'Format, 4 bytes

            '/* FMT */
            AudioStream.Write(Subchunk1ID, 0, 4)                                                        'Subchunk1ID , bytes
            AudioStream.Write(BitConv(16, 4), 0, 4)                                                     'Subchunk1Size    , 4 bytes
            AudioStream.Write(BitConv(1, 2), 0, 2)                                                      'AudioFormat      ,  2 bytes
            AudioStream.Write(BitConv(num_channels, 2), 0, 2)                                           'NumChannels      , 2 bytes
            AudioStream.Write(BitConv(sample_rate, 4), 0, 4)                                            'SamplesHertz, 4 bytes
            AudioStream.Write(BitConv(byte_rate, 4), 0, 4)                                              'BytesPerSecond, 4 bytes == SampleRate * NumChannels * BitsPerSample/8
            AudioStream.Write(BitConv(((num_channels * (bytes_per_sample * 8)) / 8), 2), 0, 2)          'BlockAlign       , 2 bytes == NumChannels * BitsPerSample/8
            AudioStream.Write(BitConv(8 * bytes_per_sample, 2), 0, 2)                                   'bits/sample, 2 bytes (8 bits = 8, 16 bits = 16, etc.)

            '/* DATA */
            AudioStream.Write(System.Text.ASCIIEncoding.ASCII.GetBytes("data"), 0, 4)
            AudioStream.Write(BitConv((sample.Count), 4), 0, 4)

            'Stream är nu klar för att ta emot data (Lägg till ljudet (sample) som sista delen av DATA).
            AudioStream.Write(sample.ToArray, 0, sample.Count)

            CompleteStream = AudioStream.ToArray

        End Using

        'AudioStream.Flush()
        AudioStream.Close()

    End Sub

    Private Function BitConv(ByRef Value As Integer, ByRef Length As Integer) As Byte()
        Dim b() As Byte = BitConverter.GetBytes(Value)
        Dim Helper As New List(Of Byte)
        Helper = b.ToList
        Return Helper.GetRange(0, Length).ToArray
    End Function

End Module
