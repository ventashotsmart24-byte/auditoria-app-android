package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.common.Constants;

public class v {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a  reason: collision with root package name */
    static int f13249a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f13250b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static int f13251c = -1;

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (f13251c == -1) {
            f13251c = context.getApplicationInfo().targetSdkVersion;
        }
        if (f13251c < 26 || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(android.content.Context r4) {
        /*
            int r0 = f13249a
            r1 = -1
            if (r0 == r1) goto L_0x0006
            return r0
        L_0x0006:
            r0 = 0
            byte[] r1 = f13250b     // Catch:{ all -> 0x0020 }
            monitor-enter(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = "ACCS_SDK"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r2, r0)     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "debug_mode"
            int r4 = r4.getInt(r2, r0)     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            goto L_0x002b
        L_0x0018:
            r2 = move-exception
            r4 = 0
        L_0x001a:
            monitor-exit(r1)     // Catch:{ all -> 0x001e }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r1 = move-exception
            goto L_0x0022
        L_0x001e:
            r2 = move-exception
            goto L_0x001a
        L_0x0020:
            r1 = move-exception
            r4 = 0
        L_0x0022:
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "getMode"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.taobao.accs.utl.ALog.e(r2, r3, r1, r0)
        L_0x002b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.v.b(android.content.Context):int");
    }

    public static void c(Context context) {
        try {
            synchronized (f13250b) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "clearAllSharePreferences", th, new Object[0]);
        }
    }

    public static void d(Context context) {
        try {
            UtilityImpl.killService(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killService", th, new Object[0]);
        }
    }

    public static boolean e(Context context) {
        boolean z10;
        try {
            z10 = UtilityImpl.isMainProcess(context);
        } catch (Throwable th) {
            ALog.e("Utils", "killservice", th, new Object[0]);
            th.printStackTrace();
            z10 = true;
        }
        ALog.i("Utils", "isMainProcess", "result", Boolean.valueOf(z10));
        return z10;
    }

    public static void f(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("AGOO_BIND", 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e10) {
            ALog.e("Utils", "clearAgooBindCache", e10, new Object[0]);
        }
    }

    public static void a(Context context, int i10) {
        try {
            synchronized (f13250b) {
                f13249a = i10;
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putInt(Constants.SP_KEY_DEBUG_MODE, i10);
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("Utils", "setMode", th, new Object[0]);
        }
    }

    @Deprecated
    public static void a() {
        try {
            AccsConfig.build();
        } catch (Throwable th) {
            ALog.e("Utils", "initConfig", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static String a(Context context, String str, String str2) {
        String str3 = null;
        try {
            synchronized (f13250b) {
                str3 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(str, (String) null);
            }
            ALog.i("Utils", "getSpValue", "value", str3);
            if (TextUtils.isEmpty(str3)) {
                ALog.e("Utils", "getSpValue use default!", new Object[0]);
                return str2;
            }
        } catch (Throwable th) {
            ALog.e("Utils", "getSpValue fail", th, new Object[0]);
        }
        return str3;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
