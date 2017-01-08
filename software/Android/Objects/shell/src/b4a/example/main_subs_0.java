package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Activity.LoadLayout(\"mainAHE\")";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("mainAHE")),main.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(8192);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 47;BA.debugLine="StartService(UDPmodul)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartService",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())));
 };
 BA.debugLineNum = 49;BA.debugLine="UpdateUI";
Debug.ShouldStop(65536);
_updateui();
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,56);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,52);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="StartService(UDPmodul)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("StartService",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())));
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("btnMute_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("btnmute_click")) return main.remoteMe.runUserSub(false, "main","btnmute_click");
 BA.debugLineNum = 77;BA.debugLine="Sub btnMute_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="If btnMute.Text=\"Mute\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",main.mostCurrent._btnmute.runMethod(true,"getText"),BA.ObjectToString("Mute"))) { 
 BA.debugLineNum = 79;BA.debugLine="btnMute.text=\"Listen\"";
Debug.ShouldStop(16384);
main.mostCurrent._btnmute.runMethod(true,"setText",RemoteObject.createImmutable(("Listen")));
 }else {
 BA.debugLineNum = 83;BA.debugLine="btnMute.text=\"Mute\"";
Debug.ShouldStop(262144);
main.mostCurrent._btnmute.runMethod(true,"setText",RemoteObject.createImmutable(("Mute")));
 };
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsync_click() throws Exception{
try {
		Debug.PushSubsStack("btnSync_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("btnsync_click")) return main.remoteMe.runUserSub(false, "main","btnsync_click");
 BA.debugLineNum = 62;BA.debugLine="Sub btnSync_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="SendUDP(UDPsocket1, \"1\", \"192.168.1.255\", 11319)";
Debug.ShouldStop(1073741824);
_sendudp(main._udpsocket1,BA.ObjectToString("1"),BA.ObjectToString("192.168.1.255"),BA.NumberToString(11319));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private btnManual As Button";
main.mostCurrent._btnmanual = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnSync As Button";
main.mostCurrent._btnsync = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnMute As Button";
main.mostCurrent._btnmute = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private EditText1 As EditText";
main.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private lblUnit1 As Label";
main.mostCurrent._lblunit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblUnit2 As Label";
main.mostCurrent._lblunit2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lblUnit3 As Label";
main.mostCurrent._lblunit3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblUnit4 As Label";
main.mostCurrent._lblunit4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private pnlUnits As Panel";
main.mostCurrent._pnlunits = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Dim green As Int = 0xFF05CE00";
main._green = BA.numberCast(int.class, 0xff05ce00);
 //BA.debugLineNum = 39;BA.debugLine="Dim red As Int = 0xFFC40000";
main._red = BA.numberCast(int.class, 0xffc40000);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 20;BA.debugLine="Dim UDPsocket1 As UDPSocket";
main._udpsocket1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sendudp(RemoteObject _socketa,RemoteObject _command,RemoteObject _ipadress,RemoteObject _port) throws Exception{
try {
		Debug.PushSubsStack("SendUDP (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,67);
if (RapidSub.canDelegate("sendudp")) return main.remoteMe.runUserSub(false, "main","sendudp", _socketa, _command, _ipadress, _port);
RemoteObject _packet = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");
RemoteObject _data = null;
Debug.locals.put("SocketA", _socketa);
Debug.locals.put("Command", _command);
Debug.locals.put("IPadress", _ipadress);
Debug.locals.put("Port", _port);
 BA.debugLineNum = 67;BA.debugLine="Sub SendUDP(SocketA As UDPSocket, Command As Strin";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Dim Packet As UDPPacket";
Debug.ShouldStop(8);
_packet = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 69;BA.debugLine="Dim data() As Byte";
Debug.ShouldStop(16);
_data = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 70;BA.debugLine="data = Command.GetBytes(\"UTF8\")";
Debug.ShouldStop(32);
_data = _command.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("data", _data);
 BA.debugLineNum = 71;BA.debugLine="Packet.Initialize(data, IPadress, Port)";
Debug.ShouldStop(64);
_packet.runVoidMethod ("Initialize",(Object)(_data),(Object)(_ipadress),(Object)(BA.numberCast(int.class, _port)));
 BA.debugLineNum = 72;BA.debugLine="SocketA.Send(Packet)";
Debug.ShouldStop(128);
_socketa.runVoidMethod ("Send",(Object)(_packet));
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
public static RemoteObject  _updateui() throws Exception{
try {
		Debug.PushSubsStack("UpdateUI (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("updateui")) return main.remoteMe.runUserSub(false, "main","updateui");
 BA.debugLineNum = 90;BA.debugLine="Public Sub UpdateUI";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="lblUnit1.Text = UDPmodul.Unit1";
Debug.ShouldStop(67108864);
main.mostCurrent._lblunit1.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit1));
 BA.debugLineNum = 93;BA.debugLine="If UDPmodul.ConnectionStatus= True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._udpmodul._connectionstatus,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 94;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
Debug.ShouldStop(536870912);
main.mostCurrent._lblunit2.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit2));
 BA.debugLineNum = 95;BA.debugLine="lblUnit2.TextColor = green";
Debug.ShouldStop(1073741824);
main.mostCurrent._lblunit2.runMethod(true,"setTextColor",main._green);
 }else {
 BA.debugLineNum = 97;BA.debugLine="lblUnit2.TextColor = red";
Debug.ShouldStop(1);
main.mostCurrent._lblunit2.runMethod(true,"setTextColor",main._red);
 BA.debugLineNum = 98;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
Debug.ShouldStop(2);
main.mostCurrent._lblunit2.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit2));
 };
 BA.debugLineNum = 101;BA.debugLine="lblUnit3.Text = UDPmodul.unit3";
Debug.ShouldStop(16);
main.mostCurrent._lblunit3.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit3));
 BA.debugLineNum = 102;BA.debugLine="lblUnit4.Text = UDPmodul.unit4";
Debug.ShouldStop(32);
main.mostCurrent._lblunit4.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit4));
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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