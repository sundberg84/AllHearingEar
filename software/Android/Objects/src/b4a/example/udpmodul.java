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
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.udpmodul");
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
public static anywheresoftware.b4a.objects.NotificationWrapper _notis = null;
public b4a.example.main _main = null;
public static String  _astream_newdata(byte[] _buffer) throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub astream_NewData (Buffer() As Byte)";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="streamer.Write(Buffer)";
_streamer.Write(_buffer);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If Main.mute = False Then";
if (mostCurrent._main._mute==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="streamer.StartPlaying";
_streamer.StartPlaying();
 };
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="End Sub";
return "";
}
public static String  _astream_stop() throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub astream_Stop";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="streamer.StopPlaying";
_streamer.StopPlaying();
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public static String  _btnsync() throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub BtnSync";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="SendUDP(UDPsocket1, \"0\", \"192.168.1.255\", 11319)";
_sendudp(_udpsocket1,"0","192.168.1.255",BA.NumberToString(11319));
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _sendudp(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _socketa,String _command,String _ipadress,String _port) throws Exception{
RDebugUtils.currentModule="udpmodul";
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _data = null;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub SendUDP(SocketA As UDPSocket, Command As Strin";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim data() As Byte";
_data = new byte[(int) (0)];
;
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="data = Command.GetBytes(\"UTF8\")";
_data = _command.getBytes("UTF8");
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="Packet.Initialize(data, IPadress, Port)";
_packet.Initialize(_data,_ipadress,(int)(Double.parseDouble(_port)));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="SocketA.Send(Packet)";
_socketa.Send(_packet);
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="UDPsocket3.Initialize(\"UDP\", 11318, 1400)";
_udpsocket3.Initialize(processBA,"UDP",(int) (11318),(int) (1400));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="UDPsocket2.Initialize(\"UDP\", 11320, 2)";
_udpsocket2.Initialize(processBA,"UDP",(int) (11320),(int) (2));
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="UDPsocket1.Initialize(\"UDP\", 11319, 2)";
_udpsocket1.Initialize(processBA,"UDP",(int) (11319),(int) (2));
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="streamer.Initialize(\"streamer\", 10000, False, 16,";
_streamer.Initialize(processBA,"streamer",(int) (10000),anywheresoftware.b4a.keywords.Common.False,(int) (16),_streamer.VOLUME_MUSIC);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="Timer1.Initialize(\"Timer1\", 1000)";
_timer1.Initialize(processBA,"Timer1",(long) (1000));
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="Timer1.Enabled =False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="Unit1 = \"Disconnected\"";
_unit1 = "Disconnected";
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="Unit2 = \"Press Sync AHE to synchronize.\"";
_unit2 = "Press Sync AHE to synchronize.";
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="UpdateUI";
_updateui();
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="SendUDP(UDPsocket1, \"0\", \"192.168.1.255\", 11319)";
_sendudp(_udpsocket1,"0","192.168.1.255",BA.NumberToString(11319));
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="notis.Initialize";
_notis.Initialize();
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="notis.Icon=\"icon\"";
_notis.setIcon("icon");
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="notis.OnGoingEvent=True";
_notis.setOnGoingEvent(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="notis.Vibrate=False";
_notis.setVibrate(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="notis.Sound=False";
_notis.setSound(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="End Sub";
return "";
}
public static String  _updateui() throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub UpdateUI";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="CallSub(Main, \"UpdateUI\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._main.getObject()),"UpdateUI");
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="UDPsocket1.Close";
_udpsocket1.Close();
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="UDPsocket2.Close";
_udpsocket2.Close();
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="UDPsocket3.Close";
_udpsocket3.Close();
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="notis.OnGoingEvent=False";
_notis.setOnGoingEvent(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="notis.Cancel(1)";
_notis.Cancel((int) (1));
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
RDebugUtils.currentModule="udpmodul";
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Timer1_Tick";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Ticks = Ticks + 1";
_ticks = (int) (_ticks+1);
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Unit4 = Ticks";
_unit4 = BA.NumberToString(_ticks);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="UpdateUI";
_updateui();
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="If Ticks > 8 And AHEIP <> \"\" Then";
if (_ticks>8 && (_aheip).equals("") == false) { 
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="SendUDP(UDPsocket1, \"0\", AHEIP, 11319)";
_sendudp(_udpsocket1,"0",_aheip,BA.NumberToString(11319));
 };
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="If Ticks > 11 Then";
if (_ticks>11) { 
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="ConnectionStatus = False";
_connectionstatus = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="ToastMessageShow(\"You lost connection to AHE\",";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("You lost connection to AHE",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="Unit1 = AHEIP";
_unit1 = _aheip;
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="Unit2 =\"Status: Disconnected\"";
_unit2 = "Status: Disconnected";
RDebugUtils.currentLine=1179665;
 //BA.debugLineNum = 1179665;BA.debugLine="Unit3 =\"Try pressing the Sync AHE button!\"";
_unit3 = "Try pressing the Sync AHE button!";
RDebugUtils.currentLine=1179666;
 //BA.debugLineNum = 1179666;BA.debugLine="Unit4 =\"Check that your hardware is powered!\"";
_unit4 = "Check that your hardware is powered!";
RDebugUtils.currentLine=1179667;
 //BA.debugLineNum = 1179667;BA.debugLine="notis.SetInfo(\"All hearing ear\", \"You lost conn";
_notis.SetInfo(processBA,"All hearing ear","You lost connection to All hearing ear",udpmodul.getObject());
RDebugUtils.currentLine=1179668;
 //BA.debugLineNum = 1179668;BA.debugLine="notis.Notify(1)";
_notis.Notify((int) (1));
RDebugUtils.currentLine=1179669;
 //BA.debugLineNum = 1179669;BA.debugLine="Timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179670;
 //BA.debugLineNum = 1179670;BA.debugLine="Ticks = 0";
_ticks = (int) (0);
RDebugUtils.currentLine=1179672;
 //BA.debugLineNum = 1179672;BA.debugLine="UpdateUI";
_updateui();
 };
RDebugUtils.currentLine=1179675;
 //BA.debugLineNum = 1179675;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
RDebugUtils.currentModule="udpmodul";
String _msg = "";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub UDP_PacketArrived(Packet As UDPPacket)";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim msg As String";
_msg = "";
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="msg = BytesToString(Packet.Data, Packet.Offset, P";
_msg = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="Unit3 = msg";
_unit3 = _msg;
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="If AHEIP = \"\" And msg = \"1\" Then";
if ((_aheip).equals("") && (_msg).equals("1")) { 
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="AHEIP = Packet.HostAddress";
_aheip = _packet.getHostAddress();
 };
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="If AHEIP <> \"\" And ConnectionStatus = False And m";
if ((_aheip).equals("") == false && _connectionstatus==anywheresoftware.b4a.keywords.Common.False && (_msg).equals("1")) { 
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="ConnectionStatus=True";
_connectionstatus = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="ToastMessageShow(\"You are connected\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("You are connected",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="Unit1 = \"Connected to: \" & Packet.HostAddress";
_unit1 = "Connected to: "+_packet.getHostAddress();
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="Unit2 = \"Connected\"";
_unit2 = "Connected";
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="Unit3 = \"\"";
_unit3 = "";
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="Unit4 =\"\"";
_unit4 = "";
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="notis.SetInfo(\"All hearing ear\", \"All hearing ea";
_notis.SetInfo(processBA,"All hearing ear","All hearing ear is connected",udpmodul.getObject());
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="notis.Notify(1)";
_notis.Notify((int) (1));
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="UpdateUI";
_updateui();
 };
RDebugUtils.currentLine=983065;
 //BA.debugLineNum = 983065;BA.debugLine="If msg = \"1\" And ConnectionStatus = True Then";
if ((_msg).equals("1") && _connectionstatus==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=983066;
 //BA.debugLineNum = 983066;BA.debugLine="Ticks = 0";
_ticks = (int) (0);
 }else {
RDebugUtils.currentLine=983068;
 //BA.debugLineNum = 983068;BA.debugLine="astream_NewData(Packet.Data)";
_astream_newdata(_packet.getData());
RDebugUtils.currentLine=983069;
 //BA.debugLineNum = 983069;BA.debugLine="Ticks = 0";
_ticks = (int) (0);
 };
RDebugUtils.currentLine=983072;
 //BA.debugLineNum = 983072;BA.debugLine="End Sub";
return "";
}
}