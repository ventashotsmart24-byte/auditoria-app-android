package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.t;

public abstract class g {

    /* renamed from: b  reason: collision with root package name */
    protected static volatile g f13051b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f13052c = {270, 360, 480};

    /* renamed from: a  reason: collision with root package name */
    protected Context f13053a;

    /* renamed from: d  reason: collision with root package name */
    private int f13054d;

    /* renamed from: e  reason: collision with root package name */
    private long f13055e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13056f = false;

    /* renamed from: g  reason: collision with root package name */
    private int[] f13057g = {0, 0, 0};

    /* renamed from: h  reason: collision with root package name */
    private boolean f13058h = true;

    public g(Context context) {
        try {
            this.f13053a = context;
            this.f13054d = 0;
            this.f13055e = System.currentTimeMillis();
            this.f13058h = t.a();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static g a(Context context) {
        if (f13051b == null) {
            synchronized (g.class) {
                if (f13051b == null) {
                    if (!GlobalConfig.isJobHeartbeatEnable() || Build.VERSION.SDK_INT < 21 || !b(context)) {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        f13051b = new e(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        f13051b = new f(context);
                    }
                }
            }
        }
        return f13051b;
    }

    private static boolean b(Context context) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0);
            if (serviceInfo == null || !serviceInfo.isEnabled()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public abstract void a(int i10);

    public void c() {
        int i10;
        this.f13055e = -1;
        if (this.f13056f) {
            int[] iArr = this.f13057g;
            int i11 = this.f13054d;
            iArr[i11] = iArr[i11] + 1;
        }
        int i12 = this.f13054d;
        if (i12 > 0) {
            i10 = i12 - 1;
        } else {
            i10 = 0;
        }
        this.f13054d = i10;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void d() {
        this.f13055e = -1;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f13055e > 7199000) {
            int i10 = this.f13054d;
            if (i10 < f13052c.length - 1 && this.f13057g[i10] <= 2) {
                ALog.d("HeartbeatManager", "upgrade", new Object[0]);
                this.f13054d++;
                this.f13056f = true;
                this.f13055e = System.currentTimeMillis();
                return;
            }
            return;
        }
        this.f13056f = false;
        this.f13057g[this.f13054d] = 0;
    }

    public void f() {
        this.f13054d = 0;
        this.f13055e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i10 = this.f13058h ? f13052c[this.f13054d] : 270;
        this.f13058h = t.a();
        return i10;
    }

    public synchronized void a() {
        try {
            if (this.f13055e < 0) {
                this.f13055e = System.currentTimeMillis();
            }
            int b10 = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + b10, new Object[0]);
            }
            a(b10);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
        return;
    }
}
