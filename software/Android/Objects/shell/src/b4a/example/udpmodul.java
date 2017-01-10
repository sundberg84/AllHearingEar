
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class udpmodul implements IRemote{
	public static udpmodul mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public udpmodul() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4a.example.udpmodul", "b4a.example.udpmodul");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("b4a.example.udpmodul");
		pcBA = new PCBA(this, udpmodul.class);
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _udpsocket1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
public static RemoteObject _udpsocket2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
public static RemoteObject _udpsocket3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
public static RemoteObject _timer1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _streamer = RemoteObject.declareNull("anywheresoftware.b4a.audio.AudioStreamer");
public static RemoteObject _ticks = RemoteObject.createImmutable(0);
public static RemoteObject _connectionstatus = RemoteObject.createImmutable(false);
public static RemoteObject _aheip = RemoteObject.createImmutable("");
public static RemoteObject _unit1 = RemoteObject.createImmutable("");
public static RemoteObject _unit2 = RemoteObject.createImmutable("");
public static RemoteObject _unit3 = RemoteObject.createImmutable("");
public static RemoteObject _unit4 = RemoteObject.createImmutable("");
public static RemoteObject _notis = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
public static b4a.example.main _main = null;
  public Object[] GetGlobals() {
		return new Object[] {"AHEIP",udpmodul._aheip,"ConnectionStatus",udpmodul._connectionstatus,"Main",Debug.moduleToString(b4a.example.main.class),"notis",udpmodul._notis,"Service",udpmodul.mostCurrent._service,"streamer",udpmodul._streamer,"Ticks",udpmodul._ticks,"Timer1",udpmodul._timer1,"UDPsocket1",udpmodul._udpsocket1,"UDPsocket2",udpmodul._udpsocket2,"UDPsocket3",udpmodul._udpsocket3,"Unit1",udpmodul._unit1,"Unit2",udpmodul._unit2,"Unit3",udpmodul._unit3,"Unit4",udpmodul._unit4};
}
}