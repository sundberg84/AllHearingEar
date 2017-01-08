package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _udpsocket1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmanual = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsync = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmute = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblunit1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblunit2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblunit3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblunit4 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlunits = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public static boolean _mute = false;
public static int _green = 0;
public static int _red = 0;
public static String _manualip = "";
public anywheresoftware.b4a.objects.EditTextWrapper _txtmanip = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
public b4a.example.udpmodul _udpmodul = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"mainAHE\")";
mostCurrent._activity.LoadLayout("mainAHE",mostCurrent.activityBA);
 //BA.debugLineNum = 50;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 51;BA.debugLine="StartService(UDPmodul)";
anywheresoftware.b4a.keywords.Common.StartService(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()));
 };
 //BA.debugLineNum = 53;BA.debugLine="UpdateUI";
_updateui();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 57;BA.debugLine="StartService(UDPmodul)";
anywheresoftware.b4a.keywords.Common.StartService(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()));
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _btnmanual_click() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub btnManual_click";
 //BA.debugLineNum = 108;BA.debugLine="If txtManIP.Visible=False Then";
if (mostCurrent._txtmanip.getVisible()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 109;BA.debugLine="Panel1.Visible=True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 110;BA.debugLine="txtManIP.Visible=True";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 111;BA.debugLine="btnOK.Visible=True";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 113;BA.debugLine="txtManIP.Visible=False";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 114;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 115;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _btnmute_click() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub btnMute_Click";
 //BA.debugLineNum = 81;BA.debugLine="If btnMute.Text=\"Mute\" Then";
if ((mostCurrent._btnmute.getText()).equals("Mute")) { 
 //BA.debugLineNum = 82;BA.debugLine="btnMute.text=\"Listen\"";
mostCurrent._btnmute.setText((Object)("Listen"));
 //BA.debugLineNum = 83;BA.debugLine="mute = True";
_mute = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 84;BA.debugLine="CallSub(UDPmodul, \"astream_stop\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()),"astream_stop");
 }else {
 //BA.debugLineNum = 86;BA.debugLine="btnMute.text=\"Mute\"";
mostCurrent._btnmute.setText((Object)("Mute"));
 };
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _btnok_click() throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Sub btnOK_Click";
 //BA.debugLineNum = 133;BA.debugLine="ManualIP = txtManIP.Text";
mostCurrent._manualip = mostCurrent._txtmanip.getText();
 //BA.debugLineNum = 134;BA.debugLine="If ManualIP <> \"\" Then";
if ((mostCurrent._manualip).equals("") == false) { 
 //BA.debugLineNum = 135;BA.debugLine="SendUDP(UDPsocket1, \"0\", ManualIP, 11319)";
_sendudp(_udpsocket1,"0",mostCurrent._manualip,BA.NumberToString(11319));
 //BA.debugLineNum = 136;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
 //BA.debugLineNum = 137;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
 //BA.debugLineNum = 138;BA.debugLine="txtManIP.Visible=False";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 139;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 140;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 142;BA.debugLine="Msgbox(\"Enter a valid IPaddress.\", \"AHE\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Enter a valid IPaddress.","AHE",mostCurrent.activityBA);
 //BA.debugLineNum = 143;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
 //BA.debugLineNum = 144;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
 //BA.debugLineNum = 145;BA.debugLine="txtManIP.Visible=False";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 146;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 147;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _btnsync_click() throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Sub btnSync_Click";
 //BA.debugLineNum = 67;BA.debugLine="SendUDP(UDPsocket1, \"0\", \"192.168.1.255\", 11319)";
_sendudp(_udpsocket1,"0","192.168.1.255",BA.NumberToString(11319));
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private btnManual As Button";
mostCurrent._btnmanual = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private btnSync As Button";
mostCurrent._btnsync = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private btnMute As Button";
mostCurrent._btnmute = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private EditText1 As EditText";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private lblUnit1 As Label";
mostCurrent._lblunit1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private lblUnit2 As Label";
mostCurrent._lblunit2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private lblUnit3 As Label";
mostCurrent._lblunit3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lblUnit4 As Label";
mostCurrent._lblunit4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private pnlUnits As Panel";
mostCurrent._pnlunits = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Public mute As Boolean";
_mute = false;
 //BA.debugLineNum = 39;BA.debugLine="Dim green As Int = 0xFF05CE00";
_green = (int) (0xff05ce00);
 //BA.debugLineNum = 40;BA.debugLine="Dim red As Int = 0xFFC40000";
_red = (int) (0xffc40000);
 //BA.debugLineNum = 41;BA.debugLine="Public ManualIP As String";
mostCurrent._manualip = "";
 //BA.debugLineNum = 43;BA.debugLine="Private txtManIP As EditText";
mostCurrent._txtmanip = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private btnOK As Button";
mostCurrent._btnok = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
udpmodul._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim UDPsocket1 As UDPSocket";
_udpsocket1 = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _sendudp(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _socketa,String _command,String _ipadress,String _port) throws Exception{
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _data = null;
 //BA.debugLineNum = 71;BA.debugLine="Sub SendUDP(SocketA As UDPSocket, Command As Strin";
 //BA.debugLineNum = 72;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
 //BA.debugLineNum = 73;BA.debugLine="Dim data() As Byte";
_data = new byte[(int) (0)];
;
 //BA.debugLineNum = 74;BA.debugLine="data = Command.GetBytes(\"UTF8\")";
_data = _command.getBytes("UTF8");
 //BA.debugLineNum = 75;BA.debugLine="Packet.Initialize(data, IPadress, Port)";
_packet.Initialize(_data,_ipadress,(int)(Double.parseDouble(_port)));
 //BA.debugLineNum = 76;BA.debugLine="SocketA.Send(Packet)";
_socketa.Send(_packet);
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _txtmanip_enterpressed() throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub txtManIP_EnterPressed";
 //BA.debugLineNum = 119;BA.debugLine="ManualIP = txtManIP.Text";
mostCurrent._manualip = mostCurrent._txtmanip.getText();
 //BA.debugLineNum = 120;BA.debugLine="If ManualIP <> \"\" Then";
if ((mostCurrent._manualip).equals("") == false) { 
 //BA.debugLineNum = 121;BA.debugLine="SendUDP(UDPsocket1, \"0\", ManualIP, 11319)";
_sendudp(_udpsocket1,"0",mostCurrent._manualip,BA.NumberToString(11319));
 //BA.debugLineNum = 122;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
 //BA.debugLineNum = 123;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
 }else {
 //BA.debugLineNum = 125;BA.debugLine="Msgbox(\"Enter a valid IPaddress.\", \"AHE\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Enter a valid IPaddress.","AHE",mostCurrent.activityBA);
 //BA.debugLineNum = 126;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
 //BA.debugLineNum = 127;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
 //BA.debugLineNum = 128;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 129;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _updateui() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Public Sub UpdateUI";
 //BA.debugLineNum = 94;BA.debugLine="lblUnit1.Text = UDPmodul.Unit1";
mostCurrent._lblunit1.setText((Object)(mostCurrent._udpmodul._unit1));
 //BA.debugLineNum = 96;BA.debugLine="If UDPmodul.ConnectionStatus= True Then";
if (mostCurrent._udpmodul._connectionstatus==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 97;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
mostCurrent._lblunit2.setText((Object)(mostCurrent._udpmodul._unit2));
 //BA.debugLineNum = 98;BA.debugLine="lblUnit2.TextColor = green";
mostCurrent._lblunit2.setTextColor(_green);
 }else {
 //BA.debugLineNum = 100;BA.debugLine="lblUnit2.TextColor = red";
mostCurrent._lblunit2.setTextColor(_red);
 //BA.debugLineNum = 101;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
mostCurrent._lblunit2.setText((Object)(mostCurrent._udpmodul._unit2));
 };
 //BA.debugLineNum = 104;BA.debugLine="lblUnit3.Text = UDPmodul.unit3";
mostCurrent._lblunit3.setText((Object)(mostCurrent._udpmodul._unit3));
 //BA.debugLineNum = 105;BA.debugLine="lblUnit4.Text = UDPmodul.unit4";
mostCurrent._lblunit4.setText((Object)(mostCurrent._udpmodul._unit4));
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
}
