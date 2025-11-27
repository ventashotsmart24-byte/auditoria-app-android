package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class ProcessUtil {

    /* renamed from: a  reason: collision with root package name */
    private static String f5295a = null;

    /* renamed from: b  reason: collision with root package name */
    private static List<Integer> f5296b = null;

    /* renamed from: c  reason: collision with root package name */
    private static long f5297c = -1;

    public static String getCurrentProcessName() {
        String str = f5295a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String processName = getProcessName(Process.myPid());
        f5295a = processName;
        return processName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[SYNTHETIC, Splitter:B:20:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getProcessName(int r6) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0046 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0046 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = "/proc/"
            r4.<init>(r5)     // Catch:{ all -> 0x0046 }
            r4.append(r6)     // Catch:{ all -> 0x0046 }
            java.lang.String r6 = "/cmdline"
            r4.append(r6)     // Catch:{ all -> 0x0046 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0046 }
            r3.<init>(r6)     // Catch:{ all -> 0x0046 }
            r2.<init>(r3)     // Catch:{ all -> 0x0046 }
            r1.<init>(r2)     // Catch:{ all -> 0x0046 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r6.<init>()     // Catch:{ all -> 0x0043 }
        L_0x0028:
            int r0 = r1.read()     // Catch:{ all -> 0x0043 }
            if (r0 <= 0) goto L_0x0033
            char r0 = (char) r0     // Catch:{ all -> 0x0043 }
            r6.append(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x0028
        L_0x0033:
            r6.trimToSize()     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0043 }
            r1.close()     // Catch:{ all -> 0x003e }
            goto L_0x005a
        L_0x003e:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x005a
        L_0x0043:
            r6 = move-exception
            r0 = r1
            goto L_0x0047
        L_0x0046:
            r6 = move-exception
        L_0x0047:
            java.lang.String r1 = "efs.base"
            java.lang.String r2 = "get process name error"
            com.efs.sdk.base.core.util.Log.e(r1, r2, r6)     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0058:
            java.lang.String r6 = ""
        L_0x005a:
            return r6
        L_0x005b:
            r6 = move-exception
            if (r0 == 0) goto L_0x0066
            r0.close()     // Catch:{ all -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0066:
            goto L_0x0068
        L_0x0067:
            throw r6
        L_0x0068:
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.util.ProcessUtil.getProcessName(int):java.lang.String");
    }

    public static boolean isProcessExist(Context context, String str) {
        try {
            int parseInt = Integer.parseInt(str);
            List<Integer> list = f5296b;
            boolean z10 = false;
            if (list != null) {
                if (!list.isEmpty()) {
                    if (f5297c > 0) {
                        if (System.currentTimeMillis() - f5297c <= 600000) {
                            z10 = true;
                        }
                    }
                }
            }
            if (!z10) {
                List<Integer> list2 = f5296b;
                if (list2 != null) {
                    list2.clear();
                } else {
                    f5296b = new ArrayList();
                }
                if (!TextUtils.isEmpty(getProcessName(Process.myPid()))) {
                    f5296b.add(Integer.valueOf(Process.myPid()));
                }
                if (!TextUtils.isEmpty(getProcessName(parseInt))) {
                    f5296b.add(Integer.valueOf(parseInt));
                }
                f5297c = System.currentTimeMillis();
            }
            return f5296b.contains(Integer.valueOf(parseInt));
        } catch (Throwable th) {
            Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }

    public static int myPid() {
        return Process.myPid();
    }
}
