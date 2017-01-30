package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,52);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Activity.LoadLayout(\"mainAHE\")";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("mainAHE")),main.mostCurrent.activityBA);
 BA.debugLineNum = 55;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(4194304);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 56;BA.debugLine="StartService(UDPmodul)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartService",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())));
 };
 BA.debugLineNum = 59;BA.debugLine="IME.Initialize(\"IME\")";
Debug.ShouldStop(67108864);
main.mostCurrent._ime.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("IME")));
 BA.debugLineNum = 60;BA.debugLine="UpdateUI";
Debug.ShouldStop(134217728);
_updateui();
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,68);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,63);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 63;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="StartService(UDPmodul)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartService",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())));
 BA.debugLineNum = 65;BA.debugLine="UpdateUI";
Debug.ShouldStop(1);
_updateui();
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmanual_click() throws Exception{
try {
		Debug.PushSubsStack("btnManual_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,114);
if (RapidSub.canDelegate("btnmanual_click")) return main.remoteMe.runUserSub(false, "main","btnmanual_click");
 BA.debugLineNum = 114;BA.debugLine="Sub btnManual_click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="If txtManIP.Visible=False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main.mostCurrent._txtmanip.runMethod(true,"getVisible"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 116;BA.debugLine="Panel1.Visible=True";
Debug.ShouldStop(524288);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 117;BA.debugLine="txtManIP.Visible=True";
Debug.ShouldStop(1048576);
main.mostCurrent._txtmanip.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 118;BA.debugLine="btnOK.Visible=True";
Debug.ShouldStop(2097152);
main.mostCurrent._btnok.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 120;BA.debugLine="txtManIP.Visible=False";
Debug.ShouldStop(8388608);
main.mostCurrent._txtmanip.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 121;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(16777216);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 122;BA.debugLine="btnOK.Visible=False";
Debug.ShouldStop(33554432);
main.mostCurrent._btnok.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
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
public static RemoteObject  _btnmute_click() throws Exception{
try {
		Debug.PushSubsStack("btnMute_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,78);
if (RapidSub.canDelegate("btnmute_click")) return main.remoteMe.runUserSub(false, "main","btnmute_click");
 BA.debugLineNum = 78;BA.debugLine="Sub btnMute_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="If btnMute.Text=\"Mute\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",main.mostCurrent._btnmute.runMethod(true,"getText"),BA.ObjectToString("Mute"))) { 
 BA.debugLineNum = 80;BA.debugLine="btnMute.text=\"Listen\"";
Debug.ShouldStop(32768);
main.mostCurrent._btnmute.runMethod(true,"setText",RemoteObject.createImmutable(("Listen")));
 BA.debugLineNum = 81;BA.debugLine="mute = True";
Debug.ShouldStop(65536);
main._mute = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 82;BA.debugLine="CallSub(UDPmodul, \"astream_stop\")";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())),(Object)(RemoteObject.createImmutable("astream_stop")));
 }else {
 BA.debugLineNum = 84;BA.debugLine="btnMute.text=\"Mute\"";
Debug.ShouldStop(524288);
main.mostCurrent._btnmute.runMethod(true,"setText",RemoteObject.createImmutable(("Mute")));
 BA.debugLineNum = 85;BA.debugLine="mute = False";
Debug.ShouldStop(1048576);
main._mute = main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnok_click() throws Exception{
try {
		Debug.PushSubsStack("btnOK_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,139);
if (RapidSub.canDelegate("btnok_click")) return main.remoteMe.runUserSub(false, "main","btnok_click");
 BA.debugLineNum = 139;BA.debugLine="Sub btnOK_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="IME.HideKeyboard";
Debug.ShouldStop(2048);
main.mostCurrent._ime.runVoidMethod ("HideKeyboard",main.mostCurrent.activityBA);
 BA.debugLineNum = 142;BA.debugLine="ManualIP = txtManIP.Text";
Debug.ShouldStop(8192);
main.mostCurrent._manualip = main.mostCurrent._txtmanip.runMethod(true,"getText");
 BA.debugLineNum = 143;BA.debugLine="If ManualIP <> \"\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("!",main.mostCurrent._manualip,BA.ObjectToString(""))) { 
 BA.debugLineNum = 144;BA.debugLine="CallSub(UDPmodul, \"BtnSync\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())),(Object)(RemoteObject.createImmutable("BtnSync")));
 BA.debugLineNum = 145;BA.debugLine="ManualIP=\"\"";
Debug.ShouldStop(65536);
main.mostCurrent._manualip = BA.ObjectToString("");
 BA.debugLineNum = 146;BA.debugLine="txtManIP.Text =\"\"";
Debug.ShouldStop(131072);
main.mostCurrent._txtmanip.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 147;BA.debugLine="txtManIP.Visible=False";
Debug.ShouldStop(262144);
main.mostCurrent._txtmanip.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 148;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(524288);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 149;BA.debugLine="btnOK.Visible=False";
Debug.ShouldStop(1048576);
main.mostCurrent._btnok.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 151;BA.debugLine="Msgbox(\"Enter a valid IPaddress.\", \"AHE\")";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Enter a valid IPaddress.")),(Object)(RemoteObject.createImmutable("AHE")),main.mostCurrent.activityBA);
 BA.debugLineNum = 152;BA.debugLine="ManualIP=\"\"";
Debug.ShouldStop(8388608);
main.mostCurrent._manualip = BA.ObjectToString("");
 BA.debugLineNum = 153;BA.debugLine="txtManIP.Text =\"\"";
Debug.ShouldStop(16777216);
main.mostCurrent._txtmanip.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 154;BA.debugLine="txtManIP.Visible=False";
Debug.ShouldStop(33554432);
main.mostCurrent._txtmanip.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 155;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(67108864);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 156;BA.debugLine="btnOK.Visible=False";
Debug.ShouldStop(134217728);
main.mostCurrent._btnok.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 158;BA.debugLine="End Sub";
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
public static RemoteObject  _btnsync_click() throws Exception{
try {
		Debug.PushSubsStack("btnSync_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,74);
if (RapidSub.canDelegate("btnsync_click")) return main.remoteMe.runUserSub(false, "main","btnsync_click");
 BA.debugLineNum = 74;BA.debugLine="Sub btnSync_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="CallSub(UDPmodul, \"BtnSync\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())),(Object)(RemoteObject.createImmutable("BtnSync")));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnManual As Button";
main.mostCurrent._btnmanual = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnSync As Button";
main.mostCurrent._btnsync = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private btnMute As Button";
main.mostCurrent._btnmute = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private EditText1 As EditText";
main.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private lblUnit1 As Label";
main.mostCurrent._lblunit1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private lblUnit2 As Label";
main.mostCurrent._lblunit2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblUnit3 As Label";
main.mostCurrent._lblunit3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private lblUnit4 As Label";
main.mostCurrent._lblunit4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private pnlUnits As Panel";
main.mostCurrent._pnlunits = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private imgConStat As ImageView";
main.mostCurrent._imgconstat = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Public mute As Boolean";
main._mute = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 41;BA.debugLine="Dim green As Int = 0xFF05CE00";
main._green = BA.numberCast(int.class, 0xff05ce00);
 //BA.debugLineNum = 42;BA.debugLine="Dim red As Int = 0xFFC40000";
main._red = BA.numberCast(int.class, 0xffc40000);
 //BA.debugLineNum = 43;BA.debugLine="Public ManualIP As String";
main.mostCurrent._manualip = RemoteObject.createImmutable("");
 //BA.debugLineNum = 44;BA.debugLine="Dim IME As IME";
main.mostCurrent._ime = RemoteObject.createNew ("anywheresoftware.b4a.objects.IME");
 //BA.debugLineNum = 45;BA.debugLine="Private txtManIP As EditText";
main.mostCurrent._txtmanip = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private btnOK As Button";
main.mostCurrent._btnok = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Public Sens As String";
main.mostCurrent._sens = RemoteObject.createImmutable("");
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
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sbsens_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("SBSens_ValueChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,159);
if (RapidSub.canDelegate("sbsens_valuechanged")) return main.remoteMe.runUserSub(false, "main","sbsens_valuechanged", _value, _userchanged);
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 159;BA.debugLine="Sub SBSens_ValueChanged (Value As Int, UserChanged";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="Sens = Value";
Debug.ShouldStop(-2147483648);
main.mostCurrent._sens = BA.NumberToString(_value);
 BA.debugLineNum = 161;BA.debugLine="CallSub(UDPmodul, \"TBSens\")";
Debug.ShouldStop(1);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())),(Object)(RemoteObject.createImmutable("TBSens")));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtmanip_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("txtManIP_EnterPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,125);
if (RapidSub.canDelegate("txtmanip_enterpressed")) return main.remoteMe.runUserSub(false, "main","txtmanip_enterpressed");
 BA.debugLineNum = 125;BA.debugLine="Sub txtManIP_EnterPressed";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="ManualIP = txtManIP.Text";
Debug.ShouldStop(536870912);
main.mostCurrent._manualip = main.mostCurrent._txtmanip.runMethod(true,"getText");
 BA.debugLineNum = 127;BA.debugLine="If ManualIP <> \"\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("!",main.mostCurrent._manualip,BA.ObjectToString(""))) { 
 BA.debugLineNum = 128;BA.debugLine="CallSub(UDPmodul, \"BtnSync\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.mostCurrent.activityBA,(Object)((main.mostCurrent._udpmodul.getObject())),(Object)(RemoteObject.createImmutable("BtnSync")));
 BA.debugLineNum = 129;BA.debugLine="ManualIP=\"\"";
Debug.ShouldStop(1);
main.mostCurrent._manualip = BA.ObjectToString("");
 BA.debugLineNum = 130;BA.debugLine="txtManIP.Text =\"\"";
Debug.ShouldStop(2);
main.mostCurrent._txtmanip.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 }else {
 BA.debugLineNum = 132;BA.debugLine="Msgbox(\"Enter a valid IPaddress.\", \"AHE\")";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToString("Enter a valid IPaddress.")),(Object)(RemoteObject.createImmutable("AHE")),main.mostCurrent.activityBA);
 BA.debugLineNum = 133;BA.debugLine="ManualIP=\"\"";
Debug.ShouldStop(16);
main.mostCurrent._manualip = BA.ObjectToString("");
 BA.debugLineNum = 134;BA.debugLine="txtManIP.Text =\"\"";
Debug.ShouldStop(32);
main.mostCurrent._txtmanip.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 135;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(64);
main.mostCurrent._panel1.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 136;BA.debugLine="btnOK.Visible=False";
Debug.ShouldStop(128);
main.mostCurrent._btnok.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 138;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("UpdateUI (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,91);
if (RapidSub.canDelegate("updateui")) return main.remoteMe.runUserSub(false, "main","updateui");
 BA.debugLineNum = 91;BA.debugLine="Public Sub UpdateUI";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 94;BA.debugLine="If UDPmodul.ConnectionStatus=True Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main.mostCurrent._udpmodul._connectionstatus,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 95;BA.debugLine="imgConStat.Bitmap = LoadBitmap(File.DirAssets, \"P";
Debug.ShouldStop(1073741824);
main.mostCurrent._imgconstat.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Pyr_Connected.png"))).getObject()));
 }else {
 BA.debugLineNum = 97;BA.debugLine="imgConStat.Bitmap = LoadBitmap(File.DirAssets, \"P";
Debug.ShouldStop(1);
main.mostCurrent._imgconstat.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("Pyr_Disconnected.png"))).getObject()));
 };
 BA.debugLineNum = 101;BA.debugLine="lblUnit1.Text = UDPmodul.Unit1";
Debug.ShouldStop(16);
main.mostCurrent._lblunit1.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit1));
 BA.debugLineNum = 103;BA.debugLine="If UDPmodul.ConnectionStatus= True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent._udpmodul._connectionstatus,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 104;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
Debug.ShouldStop(128);
main.mostCurrent._lblunit2.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit2));
 BA.debugLineNum = 105;BA.debugLine="lblUnit2.TextColor = green";
Debug.ShouldStop(256);
main.mostCurrent._lblunit2.runMethod(true,"setTextColor",main._green);
 }else {
 BA.debugLineNum = 107;BA.debugLine="lblUnit2.TextColor = red";
Debug.ShouldStop(1024);
main.mostCurrent._lblunit2.runMethod(true,"setTextColor",main._red);
 BA.debugLineNum = 108;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
Debug.ShouldStop(2048);
main.mostCurrent._lblunit2.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit2));
 };
 BA.debugLineNum = 111;BA.debugLine="lblUnit3.Text = UDPmodul.unit3";
Debug.ShouldStop(16384);
main.mostCurrent._lblunit3.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit3));
 BA.debugLineNum = 112;BA.debugLine="lblUnit4.Text = UDPmodul.unit4";
Debug.ShouldStop(32768);
main.mostCurrent._lblunit4.runMethod(true,"setText",(main.mostCurrent._udpmodul._unit4));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
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
}