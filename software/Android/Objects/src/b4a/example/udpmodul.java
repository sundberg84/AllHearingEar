package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class udpmodul extends android.app.Service {
	public static class udpmodul_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, udpmodul.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static udpmodul mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return udpmodul.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "b4a.example", "b4a.example.udpmodul");
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        processBA.setActivityPaused(false);
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.udpmodul", processBA, _service);
		}
        BA.LogInfo("** Service (udpmodul) Create **");
        processBA.raiseEvent(null, "service_create");
        processBA.runHook("oncreate", this, null);
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		handleStart(intent);
    }
    @Override
    public int onStartCommand(android.content.Intent intent, int flags, int startId) {
    	handleStart(intent);
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (udpmodul) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
	@Override
	public void onDestroy() {
        BA.LogInfo("** Service (udpmodul) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _udpsocket1 = null;
public static anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _udpsocket2 = null;
public static anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _udpsocket3 = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static anywheresoftware.b4a.audio.AudioStreamer _streamer = null;
public static int _ticks = 0;
public static boolean _connectionstatus = false;
public static String _aheip = "";
public static String _unit1 = "";
public static String _unit2 = "";
public static String _unit3 = "";
public static String _unit4 = "";
public b4a.example.main _main = null;
public static String  _astream_newdata(byte[] _buffer) throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Sub astream_NewData (Buffer() As Byte)";
 //BA.debugLineNum = 115;BA.debugLine="streamer.Write(Buffer)";
_streamer.Write(_buffer);
 //BA.debugLineNum = 116;BA.debugLine="If Main.mute = False Then";
if (mostCurrent._main._mute==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 117;BA.debugLine="streamer.StartPlaying";
_streamer.StartPlaying();
 };
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public static String  _astream_stop() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Sub astream_Stop";
 //BA.debugLineNum = 123;BA.debugLine="streamer.StopPlaying";
_streamer.StopPlaying();
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim UDPsocket1 As UDPSocket";
_udpsocket1 = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket();
 //BA.debugLineNum = 9;BA.debugLine="Dim UDPsocket2 As UDPSocket";
_udpsocket2 = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket();
 //BA.debugLineNum = 10;BA.debugLine="Dim UDPsocket3 As UDPSocket";
_udpsocket3 = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket();
 //BA.debugLineNum = 11;BA.debugLine="Private Timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 12;BA.debugLine="Dim streamer As AudioStreamer";
_streamer = new anywheresoftware.b4a.audio.AudioStreamer();
 //BA.debugLineNum = 13;BA.debugLine="Private Ticks As Int";
_ticks = 0;
 //BA.debugLineNum = 14;BA.debugLine="Public ConnectionStatus As Boolean = False";
_connectionstatus = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 15;BA.debugLine="Public AHEIP As String";
_aheip = "";
 //BA.debugLineNum = 16;BA.debugLine="Public Unit1 As String";
_unit1 = "";
 //BA.debugLineNum = 17;BA.debugLine="Public Unit2 As String";
_unit2 = "";
 //BA.debugLineNum = 18;BA.debugLine="Public Unit3 As String";
_unit3 = "";
 //BA.debugLineNum = 19;BA.debugLine="Public Unit4 As String";
_unit4 = "";
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _sendudp(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _socketa,String _command,String _ipadress,String _port) throws Exception{
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _data = null;
 //BA.debugLineNum = 76;BA.debugLine="Sub SendUDP(SocketA As UDPSocket, Command As Strin";
 //BA.debugLineNum = 77;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
 //BA.debugLineNum = 78;BA.debugLine="Dim data() As Byte";
_data = new byte[(int) (0)];
;
 //BA.debugLineNum = 79;BA.debugLine="data = Command.GetBytes(\"UTF8\")";
_data = _command.getBytes("UTF8");
 //BA.debugLineNum = 80;BA.debugLine="Packet.Initialize(data, IPadress, Port)";
_packet.Initialize(_data,_ipadress,(int)(Double.parseDouble(_port)));
 //BA.debugLineNum = 81;BA.debugLine="SocketA.Send(Packet)";
_socketa.Send(_packet);
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 23;BA.debugLine="UDPsocket3.Initialize(\"UDP\", 11318, 1400)";
_udpsocket3.Initialize(processBA,"UDP",(int) (11318),(int) (1400));
 //BA.debugLineNum = 24;BA.debugLine="UDPsocket2.Initialize(\"UDP\", 11320, 2)";
_udpsocket2.Initialize(processBA,"UDP",(int) (11320),(int) (2));
 //BA.debugLineNum = 25;BA.debugLine="UDPsocket1.Initialize(\"UDP\", 11319, 2)";
_udpsocket1.Initialize(processBA,"UDP",(int) (11319),(int) (2));
 //BA.debugLineNum = 26;BA.debugLine="streamer.Initialize(\"streamer\", 10000, False, 16,";
_streamer.Initialize(processBA,"streamer",(int) (10000),anywheresoftware.b4a.keywords.Common.False,(int) (16),_streamer.VOLUME_MUSIC);
 //BA.debugLineNum = 27;BA.debugLine="Timer1.Initialize(\"Timer1\", 1000)";
_timer1.Initialize(processBA,"Timer1",(long) (1000));
 //BA.debugLineNum = 28;BA.debugLine="Timer1.Enabled =False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 30;BA.debugLine="Unit1 = \"Disconnected\"";
_unit1 = "Disconnected";
 //BA.debugLineNum = 31;BA.debugLine="Unit2 = \"Press Sync AHE to synchronize.\"";
_unit2 = "Press Sync AHE to synchronize.";
 //BA.debugLineNum = 32;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 33;BA.debugLine="SendUDP(UDPsocket1, \"0\", \"192.168.1.255\", 11319)";
_sendudp(_udpsocket1,"0","192.168.1.255",BA.NumberToString(11319));
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub Timer1_Tick";
 //BA.debugLineNum = 88;BA.debugLine="Ticks = Ticks + 1";
_ticks = (int) (_ticks+1);
 //BA.debugLineNum = 89;BA.debugLine="Unit4 = Ticks";
_unit4 = BA.NumberToString(_ticks);
 //BA.debugLineNum = 91;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 93;BA.debugLine="If Ticks > 8 And AHEIP <> \"\" Then";
if (_ticks>8 && (_aheip).equals("") == false) { 
 //BA.debugLineNum = 95;BA.debugLine="SendUDP(UDPsocket1, \"0\", AHEIP, 11319)";
_sendudp(_udpsocket1,"0",_aheip,BA.NumberToString(11319));
 };
 //BA.debugLineNum = 98;BA.debugLine="If Ticks > 11 Then";
if (_ticks>11) { 
 //BA.debugLineNum = 99;BA.debugLine="ConnectionStatus = False";
_connectionstatus = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 100;BA.debugLine="ToastMessageShow(\"You lost connection to AHE\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("You lost connection to AHE",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 101;BA.debugLine="Unit1 = AHEIP";
_unit1 = _aheip;
 //BA.debugLineNum = 102;BA.debugLine="Unit2 =\"Status: Disconnected\"";
_unit2 = "Status: Disconnected";
 //BA.debugLineNum = 103;BA.debugLine="Unit3 =\"Try pressing the Sync AHE button!\"";
_unit3 = "Try pressing the Sync AHE button!";
 //BA.debugLineNum = 104;BA.debugLine="Unit4 =\"Check that your hardware is powered!\"";
_unit4 = "Check that your hardware is powered!";
 //BA.debugLineNum = 105;BA.debugLine="Timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 106;BA.debugLine="Ticks = 0";
_ticks = (int) (0);
 //BA.debugLineNum = 107;BA.debugLine="UpdateUI";
_updateui();
 };
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
String _msg = "";
 //BA.debugLineNum = 45;BA.debugLine="Sub UDP_PacketArrived(Packet As UDPPacket)";
 //BA.debugLineNum = 47;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 48;BA.debugLine="msg = BytesToString(Packet.Data, Packet.Offset, P";
_msg = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
 //BA.debugLineNum = 49;BA.debugLine="Unit3 = msg";
_unit3 = _msg;
 //BA.debugLineNum = 51;BA.debugLine="If AHEIP = \"\" And msg = \"1\" Then";
if ((_aheip).equals("") && (_msg).equals("1")) { 
 //BA.debugLineNum = 52;BA.debugLine="AHEIP = Packet.HostAddress";
_aheip = _packet.getHostAddress();
 };
 //BA.debugLineNum = 55;BA.debugLine="If AHEIP <> \"\" And ConnectionStatus = False And m";
if ((_aheip).equals("") == false && _connectionstatus==anywheresoftware.b4a.keywords.Common.False && (_msg).equals("1")) { 
 //BA.debugLineNum = 56;BA.debugLine="ConnectionStatus=True";
_connectionstatus = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 57;BA.debugLine="ToastMessageShow(\"You are connected\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("You are connected",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 58;BA.debugLine="Unit1 = \"Connected to: \" & Packet.HostAddress";
_unit1 = "Connected to: "+_packet.getHostAddress();
 //BA.debugLineNum = 59;BA.debugLine="Unit2 = \"Connected\"";
_unit2 = "Connected";
 //BA.debugLineNum = 60;BA.debugLine="Unit3 = \"\"";
_unit3 = "";
 //BA.debugLineNum = 61;BA.debugLine="Unit4 =\"\"";
_unit4 = "";
 //BA.debugLineNum = 62;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 63;BA.debugLine="UpdateUI";
_updateui();
 };
 //BA.debugLineNum = 67;BA.debugLine="If msg = \"1\" And ConnectionStatus = True Then";
if ((_msg).equals("1") && _connectionstatus==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 68;BA.debugLine="Ticks = 0";
_ticks = (int) (0);
 }else {
 //BA.debugLineNum = 70;BA.debugLine="astream_NewData(Packet.Data)";
_astream_newdata(_packet.getData());
 };
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _updateui() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Private Sub UpdateUI";
 //BA.debugLineNum = 128;BA.debugLine="CallSub(Main, \"UpdateUI\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._main.getObject()),"UpdateUI");
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
}
