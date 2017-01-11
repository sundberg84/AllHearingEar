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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = main.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, udpmodul.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
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
public anywheresoftware.b4a.objects.ImageViewWrapper _imgconstat = null;
public static boolean _mute = false;
public static int _green = 0;
public static int _red = 0;
public static String _manualip = "";
public anywheresoftware.b4a.objects.IME _ime = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmanip = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnok = null;
public b4a.example.udpmodul _udpmodul = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"mainAHE\")";
mostCurrent._activity.LoadLayout("mainAHE",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="StartService(UDPmodul)";
anywheresoftware.b4a.keywords.Common.StartService(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()));
 };
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="IME.Initialize(\"IME\")";
mostCurrent._ime.Initialize("IME");
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="UpdateUI";
_updateui();
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="End Sub";
return "";
}
public static String  _updateui() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Public Sub UpdateUI";
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="If UDPmodul.ConnectionStatus=True Then";
if (mostCurrent._udpmodul._connectionstatus==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="imgConStat.Bitmap = LoadBitmap(File.DirAssets, \"P";
mostCurrent._imgconstat.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Pyr_Connected.png").getObject()));
 }else {
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="imgConStat.Bitmap = LoadBitmap(File.DirAssets, \"P";
mostCurrent._imgconstat.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Pyr_Disconnected.png").getObject()));
 };
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="lblUnit1.Text = UDPmodul.Unit1";
mostCurrent._lblunit1.setText((Object)(mostCurrent._udpmodul._unit1));
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="If UDPmodul.ConnectionStatus= True Then";
if (mostCurrent._udpmodul._connectionstatus==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
mostCurrent._lblunit2.setText((Object)(mostCurrent._udpmodul._unit2));
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="lblUnit2.TextColor = green";
mostCurrent._lblunit2.setTextColor(_green);
 }else {
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="lblUnit2.TextColor = red";
mostCurrent._lblunit2.setTextColor(_red);
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="lblUnit2.Text = UDPmodul.Unit2";
mostCurrent._lblunit2.setText((Object)(mostCurrent._udpmodul._unit2));
 };
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="lblUnit3.Text = UDPmodul.unit3";
mostCurrent._lblunit3.setText((Object)(mostCurrent._udpmodul._unit3));
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="lblUnit4.Text = UDPmodul.unit4";
mostCurrent._lblunit4.setText((Object)(mostCurrent._udpmodul._unit4));
RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="StartService(UDPmodul)";
anywheresoftware.b4a.keywords.Common.StartService(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()));
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _btnmanual_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub btnManual_click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="If txtManIP.Visible=False Then";
if (mostCurrent._txtmanip.getVisible()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Panel1.Visible=True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="txtManIP.Visible=True";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="btnOK.Visible=True";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="txtManIP.Visible=False";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="End Sub";
return "";
}
public static String  _btnmute_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub btnMute_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If btnMute.Text=\"Mute\" Then";
if ((mostCurrent._btnmute.getText()).equals("Mute")) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="btnMute.text=\"Listen\"";
mostCurrent._btnmute.setText((Object)("Listen"));
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="mute = True";
_mute = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="CallSub(UDPmodul, \"astream_stop\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()),"astream_stop");
 }else {
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="btnMute.text=\"Mute\"";
mostCurrent._btnmute.setText((Object)("Mute"));
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="mute = False";
_mute = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="End Sub";
return "";
}
public static String  _btnok_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub btnOK_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="IME.HideKeyboard";
mostCurrent._ime.HideKeyboard(mostCurrent.activityBA);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="ManualIP = txtManIP.Text";
mostCurrent._manualip = mostCurrent._txtmanip.getText();
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="If ManualIP <> \"\" Then";
if ((mostCurrent._manualip).equals("") == false) { 
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="CallSub(UDPmodul, \"BtnSync\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()),"BtnSync");
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="txtManIP.Visible=False";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="Msgbox(\"Enter a valid IPaddress.\", \"AHE\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Enter a valid IPaddress.","AHE",mostCurrent.activityBA);
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="txtManIP.Visible=False";
mostCurrent._txtmanip.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="End Sub";
return "";
}
public static String  _btnsync_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub btnSync_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="CallSub(UDPmodul, \"BtnSync\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()),"BtnSync");
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
public static String  _txtmanip_enterpressed() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub txtManIP_EnterPressed";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="ManualIP = txtManIP.Text";
mostCurrent._manualip = mostCurrent._txtmanip.getText();
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="If ManualIP <> \"\" Then";
if ((mostCurrent._manualip).equals("") == false) { 
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="CallSub(UDPmodul, \"BtnSync\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(mostCurrent.activityBA,(Object)(mostCurrent._udpmodul.getObject()),"BtnSync");
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
 }else {
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Msgbox(\"Enter a valid IPaddress.\", \"AHE\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Enter a valid IPaddress.","AHE",mostCurrent.activityBA);
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="ManualIP=\"\"";
mostCurrent._manualip = "";
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="txtManIP.Text =\"\"";
mostCurrent._txtmanip.setText((Object)(""));
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="btnOK.Visible=False";
mostCurrent._btnok.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="End Sub";
return "";
}
}