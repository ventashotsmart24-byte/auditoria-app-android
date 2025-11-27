package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f12913a;

    /* renamed from: b  reason: collision with root package name */
    public static String f12914b;

    /* renamed from: c  reason: collision with root package name */
    public static String f12915c;

    /* renamed from: d  reason: collision with root package name */
    public static String f12916d;

    /* renamed from: e  reason: collision with root package name */
    public static IProcessName f12917e;

    /* renamed from: f  reason: collision with root package name */
    public static AtomicInteger f12918f = new AtomicInteger(-1);

    /* renamed from: g  reason: collision with root package name */
    private static volatile a f12919g;

    /* renamed from: h  reason: collision with root package name */
    private static Context f12920h;

    /* renamed from: i  reason: collision with root package name */
    private ActivityManager f12921i;

    private a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        } else if (f12920h == null) {
            f12920h = context.getApplicationContext();
        }
    }

    public static a a(Context context) {
        if (f12919g == null) {
            synchronized (a.class) {
                if (f12919g == null) {
                    f12919g = new a(context);
                }
            }
        }
        return f12919g;
    }

    public static String b() {
        String str;
        if (TextUtils.isEmpty(f12913a)) {
            str = "com.umeng.message.component.UmengIntentService";
        } else {
            str = f12913a;
        }
        ALog.d("AdapterGlobalClientInfo", "getAgooCustomServiceName", "serviceName", str);
        return str;
    }

    public static boolean c() {
        if (f12918f.intValue() == 0) {
            return true;
        }
        return false;
    }

    public ActivityManager a() {
        if (this.f12921i == null) {
            this.f12921i = (ActivityManager) f12920h.getSystemService("activity");
        }
        return this.f12921i;
    }
}
