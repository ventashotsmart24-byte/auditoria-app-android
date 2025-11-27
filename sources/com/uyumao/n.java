package com.uyumao;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static String f16292a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f16293b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f16294c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f16295d = "";

    public static String a() {
        if (TextUtils.isEmpty(f16294c)) {
            f16294c = Build.BOARD;
        }
        return f16294c;
    }

    public static String b() {
        if (TextUtils.isEmpty(f16292a)) {
            String str = Build.BRAND;
            f16292a = str;
            if (TextUtils.isEmpty(str)) {
                f16292a = Build.MANUFACTURER;
            }
        }
        return f16292a;
    }

    public static String c() {
        if (TextUtils.isEmpty(f16293b)) {
            f16293b = Build.MODEL;
        }
        return f16293b;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c(Context context) {
        try {
            String b10 = b(context);
            String packageName = context.getApplicationContext().getPackageName();
            return !TextUtils.isEmpty(b10) && !TextUtils.isEmpty(packageName) && b10.equals(packageName);
        } catch (Exception unused) {
        }
    }

    public static Object a(Object obj, String str, int i10) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(f16295d)) {
            try {
                String a10 = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(a10)) {
                    int myPid = Process.myPid();
                    String a11 = a(myPid);
                    if (!TextUtils.isEmpty(a11)) {
                        f16295d = a11;
                    } else {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    f16295d = next.processName;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    f16295d = a10;
                }
            } catch (Throwable unused) {
            }
        }
        return f16295d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[SYNTHETIC, Splitter:B:15:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0035 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0035 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0035 }
            r3.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch:{ all -> 0x0035 }
            r3.append(r5)     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0035 }
            r2.<init>(r5)     // Catch:{ all -> 0x0035 }
            r1.<init>(r2)     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x0033 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x002f
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0033 }
        L_0x002f:
            r1.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            return r5
        L_0x0033:
            goto L_0x0037
        L_0x0035:
            r1 = r0
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ all -> 0x003c }
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.n.a(int):java.lang.String");
    }

    public static boolean a(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }
}
