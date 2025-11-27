package com.efs.sdk.pa.a;

import android.util.Log;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.b;
import java.io.BufferedOutputStream;

final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    PAMsgListener f5556a;

    /* renamed from: b  reason: collision with root package name */
    boolean f5557b;

    /* renamed from: c  reason: collision with root package name */
    String f5558c;

    /* renamed from: d  reason: collision with root package name */
    BufferedOutputStream f5559d;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[SYNTHETIC, Splitter:B:17:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.efs.sdk.pa.b b(java.lang.String r9, long r10, long r12) {
        /*
            java.lang.String r0 = ")"
            java.lang.String r1 = "{"
            java.lang.String r2 = "("
            r3 = 0
            if (r9 != 0) goto L_0x000a
            return r3
        L_0x000a:
            com.efs.sdk.pa.b r4 = new com.efs.sdk.pa.b
            r4.<init>()
            java.lang.String r5 = ":"
            int r5 = r9.indexOf(r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r6 = ""
            r7 = -1
            if (r5 == r7) goto L_0x002b
            int r5 = r5 + 2
            int r8 = r9.length()     // Catch:{ Exception -> 0x00ac }
            if (r5 >= r8) goto L_0x002b
            int r8 = r9.length()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r5 = r9.substring(r5, r8)     // Catch:{ Exception -> 0x00ac }
            goto L_0x002c
        L_0x002b:
            r5 = r6
        L_0x002c:
            r4.f5563a = r5     // Catch:{ Exception -> 0x00ac }
            boolean r5 = r9.contains(r2)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r8 = "}"
            if (r5 == 0) goto L_0x0057
            boolean r5 = r9.contains(r0)     // Catch:{ Exception -> 0x00ac }
            if (r5 == 0) goto L_0x0057
            int r1 = r9.indexOf(r2)     // Catch:{ Exception -> 0x00ac }
            int r0 = r9.indexOf(r0)     // Catch:{ Exception -> 0x00ac }
            if (r1 == r7) goto L_0x007e
            if (r0 == r7) goto L_0x007e
            int r1 = r1 + 1
            int r2 = r9.length()     // Catch:{ Exception -> 0x00ac }
            if (r1 >= r2) goto L_0x007e
            if (r0 <= r1) goto L_0x007e
            java.lang.String r0 = r9.substring(r1, r0)     // Catch:{ Exception -> 0x00ac }
            goto L_0x007f
        L_0x0057:
            boolean r0 = r9.contains(r1)     // Catch:{ Exception -> 0x00ac }
            if (r0 == 0) goto L_0x007e
            boolean r0 = r9.contains(r8)     // Catch:{ Exception -> 0x00ac }
            if (r0 == 0) goto L_0x007e
            int r0 = r9.indexOf(r1)     // Catch:{ Exception -> 0x00ac }
            int r1 = r9.indexOf(r8)     // Catch:{ Exception -> 0x00ac }
            if (r0 == r7) goto L_0x007e
            if (r1 == r7) goto L_0x007e
            int r0 = r0 + 1
            int r2 = r9.length()     // Catch:{ Exception -> 0x00ac }
            if (r0 >= r2) goto L_0x007e
            if (r1 <= r0) goto L_0x007e
            java.lang.String r0 = r9.substring(r0, r1)     // Catch:{ Exception -> 0x00ac }
            goto L_0x007f
        L_0x007e:
            r0 = r6
        L_0x007f:
            r4.f5564b = r0     // Catch:{ Exception -> 0x00ac }
            java.lang.String r0 = "null"
            boolean r0 = r9.contains(r0)     // Catch:{ Exception -> 0x00ac }
            if (r0 != 0) goto L_0x00a5
            boolean r0 = r9.contains(r8)     // Catch:{ Exception -> 0x00ac }
            if (r0 == 0) goto L_0x00a5
            int r0 = r9.lastIndexOf(r8)     // Catch:{ Exception -> 0x00ac }
            if (r0 == r7) goto L_0x00a5
            int r0 = r0 + 1
            int r1 = r9.length()     // Catch:{ Exception -> 0x00ac }
            if (r0 >= r1) goto L_0x00a5
            int r1 = r9.length()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r6 = r9.substring(r0, r1)     // Catch:{ Exception -> 0x00ac }
        L_0x00a5:
            r4.f5565c = r6     // Catch:{ Exception -> 0x00ac }
            r4.f5566d = r10
            r4.f5567e = r12
            return r4
        L_0x00ac:
            r9 = move-exception
            r9.printStackTrace()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.pa.a.f.b(java.lang.String, long, long):com.efs.sdk.pa.b");
    }

    public final void a(String str, long j10, long j11) {
        b b10 = b(str, j10, j11);
        if (b10 != null) {
            if (this.f5557b) {
                Log.e("PerformanceAnalyze", b10.toString());
            }
            if (this.f5558c != null) {
                try {
                    BufferedOutputStream bufferedOutputStream = this.f5559d;
                    bufferedOutputStream.write((b10.toString() + "\n").getBytes());
                } catch (Exception unused) {
                }
            }
            this.f5556a.msg(b10);
        }
    }
}
