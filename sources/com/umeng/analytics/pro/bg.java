package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class bg implements be {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13871a = "Coolpad";

    /* renamed from: b  reason: collision with root package name */
    private static final String f13872b = "com.coolpad.deviceidsupport";

    /* renamed from: c  reason: collision with root package name */
    private static final String f13873c = "com.coolpad.deviceidsupport.DeviceIdService";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static a f13874d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f13875e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f13876f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Context f13877g;

    /* renamed from: h  reason: collision with root package name */
    private final ServiceConnection f13878h = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = bg.f13874d = a.b.a(iBinder);
                String unused2 = bg.this.f13875e = bg.f13874d.b(bg.this.f13877g.getPackageName());
                StringBuilder sb = new StringBuilder();
                sb.append("onServiceConnected: oaid = ");
                sb.append(bg.this.f13875e);
            } catch (RemoteException | NullPointerException e10) {
                Log.e(bg.f13871a, "onServiceConnected failed e=" + e10.getMessage());
            }
            bg.this.f13876f.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            a unused = bg.f13874d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(f13872b, f13873c));
            if (!context.bindService(intent, this.f13878h, 1)) {
                Log.e(f13871a, "bindService return false");
            }
        } catch (Throwable th) {
            Log.e(f13871a, "bindService failed. e=" + th.getMessage());
            this.f13876f.countDown();
        }
    }

    private void c(Context context) {
        try {
            context.unbindService(this.f13878h);
        } catch (Throwable th) {
            Log.e(f13871a, "unbindService failed. e=" + th.getMessage());
        }
    }

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f13877g = context.getApplicationContext();
        this.f13876f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f13876f.await(500, TimeUnit.MILLISECONDS)) {
                Log.e(f13871a, "getOAID time-out");
            }
            return this.f13875e;
        } catch (InterruptedException e10) {
            Log.e(f13871a, "getOAID interrupted. e=" + e10.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
