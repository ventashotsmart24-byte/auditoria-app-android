package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.l;
import com.umeng.common.b;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_SP_FILE = bd.b().b(bd.A);
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a  reason: collision with root package name */
    static double[] f13623a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f13624b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f13625c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f13626d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f13627e = 0;
    public static boolean enable = true;

    /* renamed from: f  reason: collision with root package name */
    private static Object f13628f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static boolean f13629g = false;

    /* renamed from: h  reason: collision with root package name */
    private static String f13630h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    public static void a(String str) {
        f13625c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f13623a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f13628f) {
            str = f13630h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f13626d)) {
            f13626d = b.a(context).c();
        }
        return f13626d;
    }

    public static int getVerticalType(Context context) {
        if (f13627e == 0) {
            f13627e = b.a(context).d();
        }
        return f13627e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z10;
        synchronized (f13628f) {
            z10 = f13629g;
        }
        return z10;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f13628f) {
            f13629g = false;
            f13630h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f13628f) {
            f13629g = true;
            if (map != null && map.containsKey("debugkey")) {
                f13630h = map.get("debugkey");
            }
        }
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f13626d = str;
            b.a(context).a(f13626d);
            return;
        }
        UMLog.aq(l.A, 0, "\\|");
    }

    public static void a(Context context, int i10) {
        f13627e = i10;
        b.a(context).a(f13627e);
    }
}
