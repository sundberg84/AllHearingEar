package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Activity.LoadLayout(\"mainAHE\")";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("mainAHE")),main.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(4194304);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 57;BA.debugLine="StartService(UDPmodul)";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("StartService",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())));
 BA.debugLineNum = 59;BA.debugLine="UDPsocket1.initialize(\"UDP\", 11320, 1)";
Debug.ShouldStop(67108864);
main._udpsocket1.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 11320)),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 60;BA.debugLine="UDPsocket2.initialize(\"UDP\", 11319, 1)";
Debug.ShouldStop(134217728);
main._udpsocket2.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 11319)),(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 61;BA.debugLine="UDPsocket3.Initialize(\"UDP\", 11318, 1500)";
Debug.ShouldStop(268435456);
main._udpsocket3.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 11318)),(Object)(BA.numberCast(int.class, 1500)));
 BA.debugLineNum = 62;BA.debugLine="streamer.Initialize(\"streamer\", 10000, False, 16";
Debug.ShouldStop(536870912);
main._streamer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("streamer")),(Object)(BA.numberCast(int.class, 10000)),(Object)(main.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(int.class, 16)),(Object)(main._streamer.getField(true,"VOLUME_MUSIC")));
 BA.debugLineNum = 63;BA.debugLine="Timer.Initialize(\"Timer\", 1000)";
Debug.ShouldStop(1073741824);
main._timer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("Timer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 64;BA.debugLine="Timer.Enabled = True";
Debug.ShouldStop(-2147483648);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,76);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 76;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,72);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 72;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(128);
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_newdata(RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("astream_NewData (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,112);
if (RapidSub.canDelegate("astream_newdata")) return main.remoteMe.runUserSub(false, "main","astream_newdata", _buffer);
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 112;BA.debugLine="Sub astream_NewData (Buffer() As Byte)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="streamer.Write(Buffer)";
Debug.ShouldStop(65536);
main._streamer.runVoidMethod ("Write",(Object)(_buffer));
 BA.debugLineNum = 114;BA.debugLine="streamer.StartPlaying";
Debug.ShouldStop(131072);
main._streamer.runVoidMethod ("StartPlaying");
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmute_click() throws Exception{
try {
		Debug.PushSubsStack("btnMute_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,120);
if (RapidSub.canDelegate("btnmute_click")) return main.remoteMe.runUserSub(false, "main","btnmute_click");
 BA.debugLineNum = 120;BA.debugLine="Sub btnMute_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="If btnMute.Text=\"Mute\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",main.mostCurrent._btnmute.runMethod(true,"getText"),BA.ObjectToString("Mute"))) { 
 BA.debugLineNum = 122;BA.debugLine="btnMute.text=\"Listen\"";
Debug.ShouldStop(33554432);
main.mostCurrent._btnmute.runMethod(true,"setText",RemoteObject.createImmutable(("Listen")));
 BA.debugLineNum = 123;BA.debugLine="Timer.Enabled=False";
Debug.ShouldStop(67108864);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 125;BA.debugLine="btnMute.text=\"Mute\"";
Debug.ShouldStop(268435456);
main.mostCurrent._btnmute.runMethod(true,"setText",RemoteObject.createImmutable(("Mute")));
 BA.debugLineNum = 126;BA.debugLine="Timer.Enabled=True";
Debug.ShouldStop(536870912);
main._timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 36;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private btnManual As Button";
main.mostCurrent._btnmanual = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private btnSync As Button";
main.mostCurrent._btnsync = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private btnMute As Button";
main.mostCurrent._btnmute = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private EditText1 As EditText";
main.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private lblUnit1 As Label";
main.mostCurrent._lblunit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private lblUnit2 As Label";
main.mostCurrent._lblunit2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private lblUnit3 As Label";
main.mostCurrent._lblunit3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private lblUnit4 As Label";
main.mostCurrent._lblunit4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private pnlUnits As Panel";
main.mostCurrent._pnlunits = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Public bConnect As Boolean";
main._bconnect = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
udpmodul_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
udpmodul.myClass = BA.getDeviceClass ("b4a.example.udpmodul");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim UDPsocket3 As UDPSocket";
main._udpsocket3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 21;BA.debugLine="Dim UDPsocket1 As UDPSocket";
main._udpsocket1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 22;BA.debugLine="Dim UDPsocket2 As UDPSocket";
main._udpsocket2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 23;BA.debugLine="Dim streamer As AudioStreamer";
main._streamer = RemoteObject.createNew ("anywheresoftware.b4a.audio.AudioStreamer");
 //BA.debugLineNum = 24;BA.debugLine="Dim Timer As Timer";
main._timer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 25;BA.debugLine="Dim UDPsocket3 As UDPSocket";
main._udpsocket3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 26;BA.debugLine="Dim UDPsocket1 As UDPSocket";
main._udpsocket1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 27;BA.debugLine="Dim UDPsocket2 As UDPSocket";
main._udpsocket2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 28;BA.debugLine="Dim streamer As AudioStreamer";
main._streamer = RemoteObject.createNew ("anywheresoftware.b4a.audio.AudioStreamer");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sendudp(RemoteObject _socketa,RemoteObject _command,RemoteObject _ipadress,RemoteObject _port) throws Exception{
try {
		Debug.PushSubsStack("SendUDP (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("sendudp")) return main.remoteMe.runUserSub(false, "main","sendudp", _socketa, _command, _ipadress, _port);
RemoteObject _packet = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");
RemoteObject _data = null;
Debug.locals.put("SocketA", _socketa);
Debug.locals.put("Command", _command);
Debug.locals.put("IPadress", _ipadress);
Debug.locals.put("Port", _port);
 BA.debugLineNum = 87;BA.debugLine="Sub SendUDP(SocketA As UDPSocket, Command As Strin";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="Dim Packet As UDPPacket";
Debug.ShouldStop(8388608);
_packet = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 89;BA.debugLine="Dim data() As Byte";
Debug.ShouldStop(16777216);
_data = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 90;BA.debugLine="data = Command.GetBytes(\"UTF8\")";
Debug.ShouldStop(33554432);
_data = _command.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("data", _data);
 BA.debugLineNum = 91;BA.debugLine="Packet.Initialize(data, IPadress, Port)";
Debug.ShouldStop(67108864);
_packet.runVoidMethod ("Initialize",(Object)(_data),(Object)(_ipadress),(Object)(BA.numberCast(int.class, _port)));
 BA.debugLineNum = 92;BA.debugLine="SocketA.Send(Packet)";
Debug.ShouldStop(134217728);
_socketa.runVoidMethod ("Send",(Object)(_packet));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _timer_tick() throws Exception{
try {
		Debug.PushSubsStack("Timer_tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("timer_tick")) return main.remoteMe.runUserSub(false, "main","timer_tick");
 BA.debugLineNum = 83;BA.debugLine="Sub Timer_tick";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="SendUDP(UDPsocket2, \"1\", \"192.168.1.255\", 11319)";
Debug.ShouldStop(524288);
_sendudp(main._udpsocket2,BA.ObjectToString("1"),BA.ObjectToString("192.168.1.255"),BA.NumberToString(11319));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _udp_packetarrived(RemoteObject _packet) throws Exception{
try {
		Debug.PushSubsStack("UDP_PacketArrived (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,98);
if (RapidSub.canDelegate("udp_packetarrived")) return main.remoteMe.runUserSub(false, "main","udp_packetarrived", _packet);
RemoteObject _msg = RemoteObject.createImmutable("");
Debug.locals.put("packet", _packet);
 BA.debugLineNum = 98;BA.debugLine="Sub UDP_PacketArrived(packet As UDPPacket)";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Dim msg As String";
Debug.ShouldStop(4);
_msg = RemoteObject.createImmutable("");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 100;BA.debugLine="msg = BytesToString(packet.data, packet.Offset, p";
Debug.ShouldStop(8);
_msg = main.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_packet.runMethod(false,"getData")),(Object)(_packet.runMethod(true,"getOffset")),(Object)(_packet.runMethod(true,"getLength")),(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("msg", _msg);
 BA.debugLineNum = 101;BA.debugLine="lblUnit3.Text = msg";
Debug.ShouldStop(16);
main.mostCurrent._lblunit3.runMethod(true,"setText",(_msg));
 BA.debugLineNum = 103;BA.debugLine="If msg = \"1\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_msg,BA.ObjectToString("1"))) { 
 BA.debugLineNum = 104;BA.debugLine="lblUnit3.Text = \"ping\"";
Debug.ShouldStop(128);
main.mostCurrent._lblunit3.runMethod(true,"setText",RemoteObject.createImmutable(("ping")));
 }else {
 BA.debugLineNum = 106;BA.debugLine="lblUnit3.text =\"annat\"";
Debug.ShouldStop(512);
main.mostCurrent._lblunit3.runMethod(true,"setText",RemoteObject.createImmutable(("annat")));
 BA.debugLineNum = 107;BA.debugLine="astream_NewData(packet.data)";
Debug.ShouldStop(1024);
_astream_newdata(_packet.runMethod(false,"getData"));
 };
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}