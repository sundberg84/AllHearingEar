Module Audio

    ' Wave header

    Dim RcvdWaveFileBytes As New List(Of Byte())
    Dim CompleteStream() As Byte



    'CreateAudioStream är main thread - skicka UDP data hit.
    Public Sub CreateAudioStream(inputRawAudio As Byte())


        '--//DEBUG//--
        If inputRawAudio.Length <= 0 Then
            MsgBox("No data arrived!", vbAbort, "Error")
            Exit Sub
        End If

        '--//STREAM//--
        CreateWavStream(8000, inputRawAudio.Count, inputRawAudio)

        'Klar - spela upp - Spela upp SKITEN!!!
        Using Audio As New IO.MemoryStream(CompleteStream)
            Dim player As New Media.SoundPlayer(Audio)
            player.Play()
        End Using

        'Audiostream - hur dödar vi denna? Räcker det att döda den i CreateWavStream ??
        'Om vi tar close - fungerar det bara en gång?


    End Sub


    Private Sub CreateWavStream(s_rate As Integer, sample_size As Integer, sample As Byte())

        's_rate = Kommer i @20kHz från AHE
        'Om du vill spara på hårddisken (lägga till senare?)

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

        'C++: fwrite (data,size,antal/längd,fil)
        'VB: .write(data byte,offset,antal/längd)

        'Se http://soundfile.sapp.org/doc/WaveFormat/ för hur en WAVE format är uppbyggt (RIFF, FMT, DATA).

        Dim AudioStream As New IO.MemoryStream
        Using AudioStream

            '/* RIFF */ 
            AudioStream.Write(ChunkID, 0, 4)                                                            'ChunkID, 4 bytes
            AudioStream.Write(BitConv(sample_size + 36, 4), 0, 4)                                       'FileSize, 4 bytes
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
            AudioStream.Write(BitConv((sample_size), 4), 0, 4)

            'Stream är nu klar för att ta emot data (Sample, sista delen av DATA).
            For n As Integer = 0 To sample.Length
                'Lägg till data enligt stream 
                AudioStream.Write(sample.ToArray, 0, sample.Count)
            Next

            CompleteStream = AudioStream.ToArray

        End Using

        AudioStream.Flush()
        AudioStream.Close()
        'Dödar denna DIM och gör en andra omgång error?

    End Sub

    Private Function BitConv(ByRef Value As Integer, ByRef Length As Integer) As Byte()
        Dim b() As Byte = BitConverter.GetBytes(Value)
        Dim Helper As New List(Of Byte)
        Helper = b.ToList
        Return Helper.GetRange(0, Length).ToArray
    End Function

End Module