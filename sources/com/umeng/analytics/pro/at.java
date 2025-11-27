package com.umeng.analytics.pro;

import android.text.TextUtils;

public class at {

    /* renamed from: a  reason: collision with root package name */
    private static String f13769a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f13770b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f13771c = "hw_sc.build.platform.version";

    /* renamed from: d  reason: collision with root package name */
    private static final String f13772d = "ro.build.version.emui";

    /* renamed from: e  reason: collision with root package name */
    private static final String f13773e = "ro.build.version.magic";

    /* renamed from: f  reason: collision with root package name */
    private static final String f13774f = "ro.miui.ui.version.name";

    /* renamed from: g  reason: collision with root package name */
    private static final String f13775g = "ro.build.version.opporom";

    /* renamed from: h  reason: collision with root package name */
    private static final String f13776h = "ro.vivo.os.name";

    /* renamed from: i  reason: collision with root package name */
    private static final String f13777i = "ro.vivo.os.version";

    /* renamed from: j  reason: collision with root package name */
    private static final String f13778j = "ro.build.version.oplusrom";

    /* renamed from: k  reason: collision with root package name */
    private static final String f13779k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(f13769a)) {
            e(str);
        }
        return f13770b;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(java.lang.String r4) {
        /*
            java.lang.String r0 = "ro.build.version.magic"
            java.lang.String r4 = c(r4)     // Catch:{ all -> 0x00ec }
            int r1 = r4.hashCode()     // Catch:{ all -> 0x00ec }
            switch(r1) {
                case -1881642058: goto L_0x0054;
                case -1706170181: goto L_0x004a;
                case -602397472: goto L_0x0040;
                case 2432928: goto L_0x0036;
                case 2634924: goto L_0x002c;
                case 68924490: goto L_0x0022;
                case 77852109: goto L_0x0018;
                case 2141820391: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ all -> 0x00ec }
        L_0x000d:
            goto L_0x005e
        L_0x000e:
            java.lang.String r1 = "HUAWEI"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 0
            goto L_0x005f
        L_0x0018:
            java.lang.String r1 = "REDMI"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 3
            goto L_0x005f
        L_0x0022:
            java.lang.String r1 = "HONOR"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 1
            goto L_0x005f
        L_0x002c:
            java.lang.String r1 = "VIVO"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 6
            goto L_0x005f
        L_0x0036:
            java.lang.String r1 = "OPPO"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 5
            goto L_0x005f
        L_0x0040:
            java.lang.String r1 = "ONEPLUS"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 7
            goto L_0x005f
        L_0x004a:
            java.lang.String r1 = "XIAOMI"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 2
            goto L_0x005f
        L_0x0054:
            java.lang.String r1 = "REALME"
            boolean r4 = r4.equals(r1)     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x005e
            r4 = 4
            goto L_0x005f
        L_0x005e:
            r4 = -1
        L_0x005f:
            java.lang.String r1 = "ro.build.version.emui"
            java.lang.String r2 = "EMUI"
            java.lang.String r3 = "ColorOS"
            switch(r4) {
                case 0: goto L_0x00ca;
                case 1: goto L_0x00ac;
                case 2: goto L_0x009f;
                case 3: goto L_0x009f;
                case 4: goto L_0x0094;
                case 5: goto L_0x0094;
                case 6: goto L_0x0087;
                case 7: goto L_0x006c;
                default: goto L_0x0068;
            }
        L_0x0068:
            java.lang.String r4 = "Android"
            goto L_0x00e6
        L_0x006c:
            java.lang.String r4 = "HydrogenOS"
            f13769a = r4     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "ro.rom.version"
            java.lang.String r4 = d(r4)     // Catch:{ all -> 0x00ec }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00ec }
            if (r0 == 0) goto L_0x0084
            f13769a = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "ro.build.version.oplusrom"
            java.lang.String r4 = d(r4)     // Catch:{ all -> 0x00ec }
        L_0x0084:
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x0087:
            java.lang.String r4 = "Funtouch"
            f13769a = r4     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "ro.vivo.os.version"
            java.lang.String r4 = d(r4)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x0094:
            f13769a = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "ro.build.version.opporom"
            java.lang.String r4 = d(r4)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x009f:
            java.lang.String r4 = "MIUI"
            f13769a = r4     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "ro.miui.ui.version.name"
            java.lang.String r4 = d(r4)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x00ac:
            java.lang.String r4 = d(r0)     // Catch:{ all -> 0x00ec }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x00c1
            java.lang.String r4 = "MagicUI"
            f13769a = r4     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = d(r0)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x00c1:
            f13769a = r2     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = d(r1)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x00ca:
            boolean r4 = a()     // Catch:{ all -> 0x00ec }
            if (r4 == 0) goto L_0x00dd
            java.lang.String r4 = "hw_sc.build.platform.version"
            java.lang.String r4 = d(r4)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = "HarmonyOS"
            f13769a = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x00dd:
            f13769a = r2     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = d(r1)     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
            goto L_0x00ec
        L_0x00e6:
            f13769a = r4     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x00ec }
            f13770b = r4     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.at.e(java.lang.String):void");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(f13769a)) {
            e(str);
        }
        return f13769a;
    }
}
