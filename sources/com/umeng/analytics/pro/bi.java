package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.analytics.pro.b;
import com.umeng.analytics.pro.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class bi implements be {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f13880a = "";

    public static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f13881a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f13882b;

        public IBinder a() {
            if (!this.f13881a) {
                this.f13881a = true;
                return this.f13882b.poll(5, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f13882b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f13881a = false;
            this.f13882b = new LinkedBlockingQueue<>();
        }
    }

    public static final class b extends b.C0195b {
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
        }

        private b() {
        }

        public void a(int i10, Bundle bundle) {
            if (i10 == 0 && bundle != null) {
                String string = bundle.getString(c.f13884b);
                if (bi.c(string)) {
                    String unused = bi.f13880a = string;
                }
            }
        }
    }

    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final int f13883a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final String f13884b = "oa_id_flag";
    }

    /* access modifiers changed from: private */
    public static boolean c(String str) {
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("00000000-0000-0000-0000-000000000000")) {
            return false;
        }
        return true;
    }

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Boolean.parseBoolean(Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state"))) {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid");
                if (c(string)) {
                    f13880a = string;
                    return string;
                }
            }
        } catch (Throwable unused) {
        }
        a aVar = new a();
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, aVar, 1)) {
            try {
                c.b.a(aVar.a()).a(new b());
                return f13880a;
            } catch (Exception unused2) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
