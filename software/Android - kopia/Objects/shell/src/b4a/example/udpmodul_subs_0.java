package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class udpmodul_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,10);
if (RapidSub.canDelegate("service_create")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","service_create");
 BA.debugLineNum = 10;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(512);
 BA.debugLineNum = 12;BA.debugLine="End Sub";
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
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,18);
if (RapidSub.canDelegate("service_destroy")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","service_destroy");
 BA.debugLineNum = 18;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Service_Start (udpmodul) ","udpmodul",1,udpmodul.processBA,udpmodul.mostCurrent,14);
if (RapidSub.canDelegate("service_start")) return udpmodul.remoteMe.runUserSub(false, "udpmodul","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 16;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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