package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14834a = bd.b().b(bd.f13859s);

    /* renamed from: b  reason: collision with root package name */
    public static final String f14835b = "_dsk_s";

    /* renamed from: c  reason: collision with root package name */
    public static final String f14836c = "_thm_z";

    /* renamed from: d  reason: collision with root package name */
    public static final String f14837d = "_gdf_r";

    /* renamed from: e  reason: collision with root package name */
    private static Object f14838e = new Object();

    public static void b(final Context context) {
        if (!c(context)) {
            final String[] strArr = {"unknown", "unknown", "unknown"};
            new Thread() {
                public void run() {
                    super.run();
                    try {
                        strArr[0] = k.c();
                        strArr[1] = k.a();
                        strArr[2] = k.b();
                        ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                        k.b(context, strArr);
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(context, th);
                    }
                }
            }.start();
        }
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f14834a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f14835b, ""))) {
            return false;
        }
        return true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f14834a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f14838e) {
                jSONObject.put(f14835b, sharedPreferences.getString(f14835b, ""));
                jSONObject.put(f14836c, sharedPreferences.getString(f14836c, ""));
                jSONObject.put(f14837d, sharedPreferences.getString(f14837d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences(f14834a, 0)) != null) {
            synchronized (f14838e) {
                sharedPreferences.edit().putString(f14835b, strArr[0]).putString(f14836c, strArr[1]).putString(f14837d, strArr[2]).commit();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[SYNTHETIC, Splitter:B:20:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "mtd"
            java.lang.String r1 = "sda"
            java.lang.String r2 = "mmcblk"
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0034 }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = "/proc/diskstats"
            r5.<init>(r6)     // Catch:{ all -> 0x0034 }
            r4.<init>(r5)     // Catch:{ all -> 0x0034 }
        L_0x0013:
            java.lang.String r3 = r4.readLine()     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0030
            boolean r5 = r3.contains(r2)     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x0021
            r0 = r2
            goto L_0x0037
        L_0x0021:
            boolean r5 = r3.contains(r1)     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x0029
            r0 = r1
            goto L_0x0037
        L_0x0029:
            boolean r3 = r3.contains(r0)     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0013
            goto L_0x0037
        L_0x0030:
            java.lang.String r0 = "unknown"
            goto L_0x0037
        L_0x0033:
            r3 = r4
        L_0x0034:
            java.lang.String r0 = "noper"
            r4 = r3
        L_0x0037:
            if (r4 == 0) goto L_0x003c
            r4.close()     // Catch:{ all -> 0x003c }
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int i10;
        try {
            i10 = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i10 = -1;
        }
        if (i10 > 0) {
            return "goldfish";
        }
        return i10 < 0 ? "noper" : "unknown";
    }

    public static int a(String str, String str2) {
        int i10;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (readLine.contains(str2)) {
                    i10 = 1;
                    break;
                }
            } else {
                i10 = -1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i10;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i10;
        try {
            i10 = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i10 = -1;
        }
        if (i10 > 0) {
            return "thermal_zone";
        }
        return i10 < 0 ? "noper" : "unknown";
    }
}
