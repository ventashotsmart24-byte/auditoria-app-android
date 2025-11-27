package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;

final class f {
    public static long a(Debug.MemoryInfo memoryInfo) {
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        String a10 = memoryInfo.getMemoryStat("summary.graphics");
        try {
            if (!TextUtils.isEmpty(a10)) {
                return Long.parseLong(a10);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3 A[SYNTHETIC, Splitter:B:36:0x00a3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a() {
        /*
            r0 = -1
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00a0 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ all -> 0x00a0 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            java.lang.String r6 = "/proc/"
            r5.<init>(r6)     // Catch:{ all -> 0x00a0 }
            int r6 = android.os.Process.myPid()     // Catch:{ all -> 0x00a0 }
            r5.append(r6)     // Catch:{ all -> 0x00a0 }
            java.lang.String r6 = "/status"
            r5.append(r6)     // Catch:{ all -> 0x00a0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00a0 }
            r4.<init>(r5)     // Catch:{ all -> 0x00a0 }
            r3.<init>(r4)     // Catch:{ all -> 0x00a0 }
            r2.<init>(r3)     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            r3.<init>()     // Catch:{ all -> 0x009e }
        L_0x002d:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x003c
            r3.append(r4)     // Catch:{ all -> 0x009e }
            r4 = 10
            r3.append(r4)     // Catch:{ all -> 0x009e }
            goto L_0x002d
        L_0x003c:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "\n"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x009e }
            int r4 = r3.length     // Catch:{ all -> 0x009e }
            int r5 = r3.length     // Catch:{ all -> 0x009e }
            r6 = 0
        L_0x004d:
            java.lang.String r7 = "\\d+"
            if (r6 >= r5) goto L_0x0075
            r8 = r3[r6]     // Catch:{ all -> 0x009e }
            java.lang.String r9 = "VmSize"
            boolean r9 = r8.startsWith(r9)     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x0072
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r7)     // Catch:{ all -> 0x009e }
            java.util.regex.Matcher r8 = r9.matcher(r8)     // Catch:{ all -> 0x009e }
            boolean r9 = r8.find()     // Catch:{ all -> 0x009e }
            if (r9 == 0) goto L_0x0072
            java.lang.String r5 = r8.group()     // Catch:{ all -> 0x009e }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ all -> 0x009e }
            goto L_0x0076
        L_0x0072:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x0075:
            r5 = r0
        L_0x0076:
            int r8 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x009a
            r0 = 12
            if (r4 <= r0) goto L_0x009a
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r7)     // Catch:{ all -> 0x0097 }
            r0 = r3[r0]     // Catch:{ all -> 0x0097 }
            java.util.regex.Matcher r0 = r1.matcher(r0)     // Catch:{ all -> 0x0097 }
            boolean r1 = r0.find()     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x009a
            java.lang.String r0 = r0.group()     // Catch:{ all -> 0x0097 }
            long r5 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x0097 }
            goto L_0x009a
        L_0x0097:
            r0 = r5
            goto L_0x00a1
        L_0x009a:
            r2.close()     // Catch:{ all -> 0x00a7 }
            goto L_0x00a7
        L_0x009e:
            goto L_0x00a1
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            if (r2 == 0) goto L_0x00a6
            r2.close()     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r5 = r0
        L_0x00a7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.memoryinfo.f.a():long");
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
