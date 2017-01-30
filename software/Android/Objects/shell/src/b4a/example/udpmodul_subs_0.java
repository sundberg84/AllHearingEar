package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class udpmodul_subs_0 {


public static RemoteObject  _astream_newdata(RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("astream_NewData (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,144);
if (RapidSub.canDelegate("astream_newdata")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","astream_newdata", _buffer);
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 144;BA.debugLine="Sub astream_NewData (Buffer() As Byte)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="streamer.Write(Buffer)";
Debug.ShouldStop(65536);
udpmodul._streamer.runVoidMethod ("Write",(Object)(_buffer));
 BA.debugLineNum = 146;BA.debugLine="If Main.mute = False Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",udpmodul.mostCurrent._main._mute,udpmodul.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 147;BA.debugLine="streamer.StartPlaying";
Debug.ShouldStop(262144);
udpmodul._streamer.runVoidMethod ("StartPlaying");
 };
 BA.debugLineNum = 149;BA.debugLine="End Sub";
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
public static RemoteObject  _astream_stop() throws Exception{
try {
		Debug.PushSubsStack("astream_Stop (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,152);
if (RapidSub.canDelegate("astream_stop")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","astream_stop");
 BA.debugLineNum = 152;BA.debugLine="Sub astream_Stop";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="streamer.StopPlaying";
Debug.ShouldStop(16777216);
udpmodul._streamer.runVoidMethod ("StopPlaying");
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsync() throws Exception{
try {
		Debug.PushSubsStack("BtnSync (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,103);
if (RapidSub.canDelegate("btnsync")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","btnsync");
 BA.debugLineNum = 103;BA.debugLine="Sub BtnSync";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="SendUDP(UDPsocket1, \"0\", \"192.168.1.255\", 11319)";
Debug.ShouldStop(128);
_sendudp(udpmodul._udpsocket1,BA.ObjectToString("0"),BA.ObjectToString("192.168.1.255"),BA.NumberToString(11319));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Public UDPsocket1 As UDPSocket";
udpmodul._udpsocket1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 9;BA.debugLine="Dim UDPsocket2 As UDPSocket";
udpmodul._udpsocket2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 10;BA.debugLine="Dim UDPsocket3 As UDPSocket";
udpmodul._udpsocket3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 11;BA.debugLine="Private Timer1 As Timer";
udpmodul._timer1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 12;BA.debugLine="Dim streamer As AudioStreamer";
udpmodul._streamer = RemoteObject.createNew ("anywheresoftware.b4a.audio.AudioStreamer");
 //BA.debugLineNum = 13;BA.debugLine="Private Ticks As Int";
udpmodul._ticks = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="Public ConnectionStatus As Boolean = False";
udpmodul._connectionstatus = udpmodul.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 15;BA.debugLine="Public AHEIP As String";
udpmodul._aheip = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Public Unit1 As String";
udpmodul._unit1 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Public Unit2 As String";
udpmodul._unit2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Public Unit3 As String";
udpmodul._unit3 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Public Unit4 As String";
udpmodul._unit4 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Dim notis As Notification";
udpmodul._notis = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sendudp(RemoteObject _socketa,RemoteObject _command,RemoteObject _ipadress,RemoteObject _port) throws Exception{
try {
		Debug.PushSubsStack("SendUDP (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,95);
if (RapidSub.canDelegate("sendudp")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","sendudp", _socketa, _command, _ipadress, _port);
RemoteObject _packet = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");
RemoteObject _data = null;
Debug.locals.put("SocketA", _socketa);
Debug.locals.put("Command", _command);
Debug.locals.put("IPadress", _ipadress);
Debug.locals.put("Port", _port);
 BA.debugLineNum = 95;BA.debugLine="Sub SendUDP(SocketA As UDPSocket, Command As Strin";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="Dim Packet As UDPPacket";
Debug.ShouldStop(-2147483648);
_packet = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 97;BA.debugLine="Dim data() As Byte";
Debug.ShouldStop(1);
_data = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 98;BA.debugLine="data = Command.GetBytes(\"UTF8\")";
Debug.ShouldStop(2);
_data = _command.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("data", _data);
 BA.debugLineNum = 99;BA.debugLine="Packet.Initialize(data, IPadress, Port)";
Debug.ShouldStop(4);
_packet.runVoidMethod ("Initialize",(Object)(_data),(Object)(_ipadress),(Object)(BA.numberCast(int.class, _port)));
 BA.debugLineNum = 100;BA.debugLine="SocketA.Send(Packet)";
Debug.ShouldStop(8);
_socketa.runVoidMethod ("Send",(Object)(_packet));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,23);
if (RapidSub.canDelegate("service_create")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","service_create");
 BA.debugLineNum = 23;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 24;BA.debugLine="UDPsocket3.Initialize(\"UDP\", 11318, 1400)";
Debug.ShouldStop(8388608);
udpmodul._udpsocket3.runVoidMethod ("Initialize",udpmodul.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 11318)),(Object)(BA.numberCast(int.class, 1400)));
 BA.debugLineNum = 25;BA.debugLine="UDPsocket2.Initialize(\"UDP\", 11320, 2)";
Debug.ShouldStop(16777216);
udpmodul._udpsocket2.runVoidMethod ("Initialize",udpmodul.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 11320)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 26;BA.debugLine="UDPsocket1.Initialize(\"UDP\", 11319, 2)";
Debug.ShouldStop(33554432);
udpmodul._udpsocket1.runVoidMethod ("Initialize",udpmodul.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 11319)),(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 27;BA.debugLine="streamer.Initialize(\"streamer\", 10000, False, 16,";
Debug.ShouldStop(67108864);
udpmodul._streamer.runVoidMethod ("Initialize",udpmodul.processBA,(Object)(BA.ObjectToString("streamer")),(Object)(BA.numberCast(int.class, 10000)),(Object)(udpmodul.mostCurrent.__c.getField(true,"False")),(Object)(BA.numberCast(int.class, 16)),(Object)(udpmodul._streamer.getField(true,"VOLUME_MUSIC")));
 BA.debugLineNum = 28;BA.debugLine="Timer1.Initialize(\"Timer1\", 1000)";
Debug.ShouldStop(134217728);
udpmodul._timer1.runVoidMethod ("Initialize",udpmodul.processBA,(Object)(BA.ObjectToString("Timer1")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 29;BA.debugLine="Timer1.Enabled =False";
Debug.ShouldStop(268435456);
udpmodul._timer1.runMethod(true,"setEnabled",udpmodul.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 31;BA.debugLine="Unit1 = \"Disconnected\"";
Debug.ShouldStop(1073741824);
udpmodul._unit1 = BA.ObjectToString("Disconnected");
 BA.debugLineNum = 32;BA.debugLine="Unit2 = \"Press Sync AHE to synchronize.\"";
Debug.ShouldStop(-2147483648);
udpmodul._unit2 = BA.ObjectToString("Press Sync AHE to synchronize.");
 BA.debugLineNum = 33;BA.debugLine="UpdateUI";
Debug.ShouldStop(1);
_updateui();
 BA.debugLineNum = 34;BA.debugLine="SendUDP(UDPsocket1, \"0\", \"192.168.1.255\", 11319)";
Debug.ShouldStop(2);
_sendudp(udpmodul._udpsocket1,BA.ObjectToString("0"),BA.ObjectToString("192.168.1.255"),BA.NumberToString(11319));
 BA.debugLineNum = 37;BA.debugLine="notis.Initialize";
Debug.ShouldStop(16);
udpmodul._notis.runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="notis.Icon=\"icon\"";
Debug.ShouldStop(32);
udpmodul._notis.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 39;BA.debugLine="notis.Vibrate=True";
Debug.ShouldStop(64);
udpmodul._notis.runVoidMethod ("setVibrate",udpmodul.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 40;BA.debugLine="notis.Sound=True";
Debug.ShouldStop(128);
udpmodul._notis.runVoidMethod ("setSound",udpmodul.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
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
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,51);
if (RapidSub.canDelegate("service_destroy")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","service_destroy");
 BA.debugLineNum = 51;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="SendUDP(UDPsocket1, \"4\", AHEIP, 11319)";
Debug.ShouldStop(524288);
_sendudp(udpmodul._udpsocket1,BA.ObjectToString("4"),udpmodul._aheip,BA.NumberToString(11319));
 BA.debugLineNum = 53;BA.debugLine="UDPsocket1.Close";
Debug.ShouldStop(1048576);
udpmodul._udpsocket1.runVoidMethod ("Close");
 BA.debugLineNum = 54;BA.debugLine="UDPsocket2.Close";
Debug.ShouldStop(2097152);
udpmodul._udpsocket2.runVoidMethod ("Close");
 BA.debugLineNum = 55;BA.debugLine="UDPsocket3.Close";
Debug.ShouldStop(4194304);
udpmodul._udpsocket3.runVoidMethod ("Close");
 BA.debugLineNum = 56;BA.debugLine="notis.Cancel(1)";
Debug.ShouldStop(8388608);
udpmodul._notis.runVoidMethod ("Cancel",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,47);
if (RapidSub.canDelegate("service_start")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 47;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tbsens() throws Exception{
try {
		Debug.PushSubsStack("TBSens (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,107);
if (RapidSub.canDelegate("tbsens")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","tbsens");
 BA.debugLineNum = 107;BA.debugLine="Sub TBSens";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="SendUDP(UDPsocket1, \"2\" + Main.Sens, \"192.168.1.2";
Debug.ShouldStop(2048);
_sendudp(udpmodul._udpsocket1,BA.NumberToString(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, "2"),BA.numberCast(double.class, udpmodul.mostCurrent._main._sens)}, "+",1, 0)),BA.ObjectToString("192.168.1.255"),BA.NumberToString(11319));
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
public static RemoteObject  _timer1_tick() throws Exception{
try {
		Debug.PushSubsStack("Timer1_Tick (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,113);
if (RapidSub.canDelegate("timer1_tick")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","timer1_tick");
 BA.debugLineNum = 113;BA.debugLine="Sub Timer1_Tick";
Debug.ShouldStop(65536);
 BA.debugLineNum = 115;BA.debugLine="Ticks = Ticks + 1";
Debug.ShouldStop(262144);
udpmodul._ticks = RemoteObject.solve(new RemoteObject[] {udpmodul._ticks,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 116;BA.debugLine="Unit4 = Ticks";
Debug.ShouldStop(524288);
udpmodul._unit4 = BA.NumberToString(udpmodul._ticks);
 BA.debugLineNum = 118;BA.debugLine="UpdateUI";
Debug.ShouldStop(2097152);
_updateui();
 BA.debugLineNum = 120;BA.debugLine="If Ticks > 8 And AHEIP <> \"\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",udpmodul._ticks,BA.numberCast(double.class, 8)) && RemoteObject.solveBoolean("!",udpmodul._aheip,BA.ObjectToString(""))) { 
 BA.debugLineNum = 122;BA.debugLine="SendUDP(UDPsocket1, \"0\", AHEIP, 11319)";
Debug.ShouldStop(33554432);
_sendudp(udpmodul._udpsocket1,BA.ObjectToString("0"),udpmodul._aheip,BA.NumberToString(11319));
 };
 BA.debugLineNum = 125;BA.debugLine="If Ticks > 11 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",udpmodul._ticks,BA.numberCast(double.class, 11))) { 
 BA.debugLineNum = 126;BA.debugLine="ConnectionStatus = False";
Debug.ShouldStop(536870912);
udpmodul._connectionstatus = udpmodul.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 127;BA.debugLine="ToastMessageShow(\"You lost connection to AHE\",";
Debug.ShouldStop(1073741824);
udpmodul.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("You lost connection to AHE")),(Object)(udpmodul.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 128;BA.debugLine="Unit1 = AHEIP";
Debug.ShouldStop(-2147483648);
udpmodul._unit1 = udpmodul._aheip;
 BA.debugLineNum = 129;BA.debugLine="Unit2 =\"Status: Disconnected\"";
Debug.ShouldStop(1);
udpmodul._unit2 = BA.ObjectToString("Status: Disconnected");
 BA.debugLineNum = 130;BA.debugLine="Unit3 =\"Try pressing the Sync AHE button!\"";
Debug.ShouldStop(2);
udpmodul._unit3 = BA.ObjectToString("Try pressing the Sync AHE button!");
 BA.debugLineNum = 131;BA.debugLine="Unit4 =\"Check that your hardware is powered!\"";
Debug.ShouldStop(4);
udpmodul._unit4 = BA.ObjectToString("Check that your hardware is powered!");
 BA.debugLineNum = 132;BA.debugLine="notis.SetInfo(\"All hearing ear\", \"You lost conn";
Debug.ShouldStop(8);
udpmodul._notis.runVoidMethod ("SetInfo",udpmodul.processBA,(Object)(BA.ObjectToString("All hearing ear")),(Object)(BA.ObjectToString("You lost connection to All hearing ear")),(Object)(udpmodul.getObject()));
 BA.debugLineNum = 133;BA.debugLine="notis.Notify(1)";
Debug.ShouldStop(16);
udpmodul._notis.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 134;BA.debugLine="Timer1.Enabled = False";
Debug.ShouldStop(32);
udpmodul._timer1.runMethod(true,"setEnabled",udpmodul.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 135;BA.debugLine="Ticks = 0";
Debug.ShouldStop(64);
udpmodul._ticks = BA.numberCast(int.class, 0);
 BA.debugLineNum = 137;BA.debugLine="UpdateUI";
Debug.ShouldStop(256);
_updateui();
 };
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("UDP_PacketArrived (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,60);
if (RapidSub.canDelegate("udp_packetarrived")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","udp_packetarrived", _packet);
RemoteObject _msg = RemoteObject.createImmutable("");
Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 60;BA.debugLine="Sub UDP_PacketArrived(Packet As UDPPacket)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 62;BA.debugLine="Dim msg As String";
Debug.ShouldStop(536870912);
_msg = RemoteObject.createImmutable("");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 63;BA.debugLine="msg = BytesToString(Packet.Data, Packet.Offset, P";
Debug.ShouldStop(1073741824);
_msg = udpmodul.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_packet.runMethod(false,"getData")),(Object)(_packet.runMethod(true,"getOffset")),(Object)(_packet.runMethod(true,"getLength")),(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("msg", _msg);
 BA.debugLineNum = 64;BA.debugLine="Unit3 = msg";
Debug.ShouldStop(-2147483648);
udpmodul._unit3 = _msg;
 BA.debugLineNum = 66;BA.debugLine="If AHEIP = \"\" And msg = \"1\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",udpmodul._aheip,BA.ObjectToString("")) && RemoteObject.solveBoolean("=",_msg,BA.ObjectToString("1"))) { 
 BA.debugLineNum = 67;BA.debugLine="AHEIP = Packet.HostAddress";
Debug.ShouldStop(4);
udpmodul._aheip = _packet.runMethod(true,"getHostAddress");
 };
 BA.debugLineNum = 70;BA.debugLine="If AHEIP <> \"\" And ConnectionStatus = False And m";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",udpmodul._aheip,BA.ObjectToString("")) && RemoteObject.solveBoolean("=",udpmodul._connectionstatus,udpmodul.mostCurrent.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_msg,BA.ObjectToString("1"))) { 
 BA.debugLineNum = 71;BA.debugLine="ConnectionStatus=True";
Debug.ShouldStop(64);
udpmodul._connectionstatus = udpmodul.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 72;BA.debugLine="ToastMessageShow(\"You are connected\", True)";
Debug.ShouldStop(128);
udpmodul.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("You are connected")),(Object)(udpmodul.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 73;BA.debugLine="Unit1 = \"Connected to: \" & Packet.HostAddress";
Debug.ShouldStop(256);
udpmodul._unit1 = RemoteObject.concat(RemoteObject.createImmutable("Connected to: "),_packet.runMethod(true,"getHostAddress"));
 BA.debugLineNum = 74;BA.debugLine="Unit2 = \"Connected\"";
Debug.ShouldStop(512);
udpmodul._unit2 = BA.ObjectToString("Connected");
 BA.debugLineNum = 75;BA.debugLine="Unit3 = \"\"";
Debug.ShouldStop(1024);
udpmodul._unit3 = BA.ObjectToString("");
 BA.debugLineNum = 76;BA.debugLine="Unit4 =\"\"";
Debug.ShouldStop(2048);
udpmodul._unit4 = BA.ObjectToString("");
 BA.debugLineNum = 77;BA.debugLine="Timer1.Enabled = True";
Debug.ShouldStop(4096);
udpmodul._timer1.runMethod(true,"setEnabled",udpmodul.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 78;BA.debugLine="notis.SetInfo(\"All hearing ear\", \"All hearing ea";
Debug.ShouldStop(8192);
udpmodul._notis.runVoidMethod ("SetInfo",udpmodul.processBA,(Object)(BA.ObjectToString("All hearing ear")),(Object)(BA.ObjectToString("All hearing ear is connected")),(Object)(udpmodul.getObject()));
 BA.debugLineNum = 79;BA.debugLine="notis.Notify(1)";
Debug.ShouldStop(16384);
udpmodul._notis.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 80;BA.debugLine="UpdateUI";
Debug.ShouldStop(32768);
_updateui();
 };
 BA.debugLineNum = 85;BA.debugLine="If msg = \"1\" And ConnectionStatus = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_msg,BA.ObjectToString("1")) && RemoteObject.solveBoolean("=",udpmodul._connectionstatus,udpmodul.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 86;BA.debugLine="Ticks = 0";
Debug.ShouldStop(2097152);
udpmodul._ticks = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 88;BA.debugLine="astream_NewData(Packet.Data)";
Debug.ShouldStop(8388608);
_astream_newdata(_packet.runMethod(false,"getData"));
 BA.debugLineNum = 89;BA.debugLine="Ticks = 0";
Debug.ShouldStop(16777216);
udpmodul._ticks = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updateui() throws Exception{
try {
		Debug.PushSubsStack("UpdateUI (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,157);
if (RapidSub.canDelegate("updateui")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","updateui");
 BA.debugLineNum = 157;BA.debugLine="Private Sub UpdateUI";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="CallSub(Main, \"UpdateUI\")";
Debug.ShouldStop(536870912);
udpmodul.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",udpmodul.processBA,(Object)((udpmodul.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("UpdateUI")));
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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