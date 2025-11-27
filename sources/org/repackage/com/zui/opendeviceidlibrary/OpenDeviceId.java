package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

public class OpenDeviceId {

    /* renamed from: c  reason: collision with root package name */
    private static String f8743c = "OpenDeviceId library";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8744d = false;

    /* renamed from: a  reason: collision with root package name */
    private Context f8745a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IDeviceidInterface f8746b;

    /* renamed from: e  reason: collision with root package name */
    private ServiceConnection f8747e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CallBack f8748f = null;

    public interface CallBack<T> {
        void a(T t10, OpenDeviceId openDeviceId);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
    }

    public String b() {
        if (this.f8745a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f8746b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.b();
                }
                return null;
            } catch (RemoteException e10) {
                b("getUDID error, RemoteException!");
                e10.printStackTrace();
                return null;
            } catch (Exception e11) {
                b("getUDID error, Exception!");
                e11.printStackTrace();
                return null;
            }
        } else {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public boolean c() {
        try {
            if (this.f8746b == null) {
                return false;
            }
            a("Device support opendeviceid");
            return this.f8746b.c();
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.f8745a;
        if (context != null) {
            String packageName = context.getPackageName();
            a("liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                a("input package is null!");
                return null;
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.f8746b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a(packageName);
                }
                return null;
            } catch (RemoteException e10) {
                b("getVAID error, RemoteException!");
                e10.printStackTrace();
                return null;
            }
        } else {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String e() {
        Context context = this.f8745a;
        if (context != null) {
            String packageName = context.getPackageName();
            a("liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                a("input package is null!");
                return null;
            }
            try {
                IDeviceidInterface iDeviceidInterface = this.f8746b;
                if (iDeviceidInterface == null) {
                    return null;
                }
                String b10 = iDeviceidInterface.b(packageName);
                if ((b10 == null || "".equals(b10)) && this.f8746b.c(packageName)) {
                    return this.f8746b.b(packageName);
                }
                return b10;
            } catch (RemoteException unused) {
                b("getAAID error, RemoteException!");
                return null;
            }
        } else {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public void f() {
        try {
            this.f8745a.unbindService(this.f8747e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.f8746b = null;
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.f8745a = context;
            this.f8748f = callBack;
            this.f8747e = new ServiceConnection() {
                public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    IDeviceidInterface unused = OpenDeviceId.this.f8746b = IDeviceidInterface.Stub.a(iBinder);
                    if (OpenDeviceId.this.f8748f != null) {
                        OpenDeviceId.this.f8748f.a("Deviceid Service Connected", OpenDeviceId.this);
                    }
                    OpenDeviceId.this.a("Service onServiceConnected");
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    IDeviceidInterface unused = OpenDeviceId.this.f8746b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f8745a.bindService(intent, this.f8747e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    private void b(String str) {
        if (f8744d) {
            Log.e(f8743c, str);
        }
    }

    public String a() {
        if (this.f8745a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.f8746b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e10) {
                b("getOAID error, RemoteException!");
                e10.printStackTrace();
                return null;
            }
        } else {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public void a(boolean z10) {
        f8744d = z10;
    }
}
