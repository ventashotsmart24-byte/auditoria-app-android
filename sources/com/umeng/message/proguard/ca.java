package com.umeng.message.proguard;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;

public final class ca {

    /* renamed from: a  reason: collision with root package name */
    public static String f15562a;

    /* renamed from: b  reason: collision with root package name */
    public static String f15563b;

    /* renamed from: c  reason: collision with root package name */
    public static String f15564c;

    /* renamed from: d  reason: collision with root package name */
    private static String f15565d;

    private static String a(String str) {
        try {
            return (String) ec.a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{str});
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        return DeviceConfig.getAndroidId(context);
    }

    public static String c(Context context) {
        return DeviceConfig.getOaid(context);
    }

    public static String d(Context context) {
        String uMId = UMUtils.getUMId(context);
        if (uMId == null) {
            return "";
        }
        return uMId;
    }

    public static String e(Context context) {
        return DeviceConfig.getImeiNew(context);
    }

    public static String f(Context context) {
        String imeiNew = DeviceConfig.getImeiNew(context);
        if (TextUtils.isEmpty(imeiNew)) {
            return null;
        }
        return UMUtils.MD5(imeiNew);
    }

    public static String a() {
        String str = f15565d;
        if (str != null) {
            return str;
        }
        try {
            if (!"vivo".equalsIgnoreCase(c())) {
                f15565d = "";
                return "";
            }
            String a10 = a("ro.vivo.os.build.display.id");
            f15565d = a10;
            if (!TextUtils.isEmpty(a10)) {
                return f15565d;
            }
            String a11 = a("ro.iqoo.os.build.display.id");
            f15565d = a11;
            if (!TextUtils.isEmpty(a11)) {
                return f15565d;
            }
            f15565d = "";
            return "";
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f15562a)) {
            f15562a = Build.MODEL;
        }
        return f15562a;
    }

    public static String c() {
        if (TextUtils.isEmpty(f15563b)) {
            String str = Build.BRAND;
            f15563b = str;
            if (TextUtils.isEmpty(str)) {
                f15563b = Build.MANUFACTURER;
            }
        }
        return f15563b;
    }

    public static String a(Context context) {
        return DeviceConfig.getIdfa(context);
    }
}
