package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Long f13246a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Integer f13247b;

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        return true;
    }

    public static long d() {
        if (f13247b == null) {
            f13247b = 10000;
            ALog.d("OrangeAdapter", "getConnectTimeout", "result", f13247b);
        }
        return (long) f13247b.intValue();
    }

    public static boolean e() {
        return true;
    }

    public static long a(Context context) {
        if (f13246a == null) {
            try {
                f13246a = Long.valueOf(context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getLong(Constants.SP_KEY_LAST_LAUNCH_TIME, 0));
            } catch (Throwable th) {
                ALog.e("OrangeAdapter", "getLastActiveTime", th, new Object[0]);
            }
            ALog.d("OrangeAdapter", "getLastActiveTime", "result", f13246a);
        }
        return f13246a.longValue();
    }

    public static void a(Context context, long j10) {
        try {
            f13246a = Long.valueOf(j10);
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putLong(Constants.SP_KEY_LAST_LAUNCH_TIME, j10);
            edit.apply();
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "saveLastActiveTime fail:", th, "lastLaunchTime", Long.valueOf(j10));
        }
    }

    public static void a(Context context, String str, int i10) {
        if (context == null) {
            try {
                ALog.e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            } catch (Exception e10) {
                ALog.e("OrangeAdapter", "saveConfigToSP fail:", e10, "key", str, "value", Integer.valueOf(i10));
            }
        } else {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(str, i10);
            edit.apply();
            ALog.i("OrangeAdapter", "saveConfigToSP", "key", str, "value", Integer.valueOf(i10));
        }
    }
}
