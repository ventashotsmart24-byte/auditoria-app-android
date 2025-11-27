package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;
import com.umeng.message.api.UPushThirdTokenCallback;

@Deprecated
public class br {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13899a = "ro.build.version.emui";

    /* renamed from: b  reason: collision with root package name */
    private static final String f13900b = "hw_sc.build.platform.version";

    public static boolean a() {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{"ro.build.flyme.version", ""}));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        if (!d() || g()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean c() {
        if (!d() || !g()) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase(UPushThirdTokenCallback.TYPE_HONOR) && !str.equalsIgnoreCase("华为")) {
            String a10 = a(f13899a);
            String a11 = a(f13900b);
            if (!TextUtils.isEmpty(a10) || !TextUtils.isEmpty(a11)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean f() {
        if (!TextUtils.isEmpty(a("ro.coolos.version"))) {
            return true;
        }
        return false;
    }

    private static boolean g() {
        if (!TextUtils.isEmpty(a(f13899a))) {
            return true;
        }
        return false;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable unused) {
            return "";
        }
    }
}
