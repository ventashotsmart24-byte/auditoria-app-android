package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.d.b;
import com.google.android.gms.cast.framework.media.NotificationOptions;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static volatile t f5037a;

    /* renamed from: h  reason: collision with root package name */
    private long f5038h = 0;
    private String hostName = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5039k = true;

    private t() {
    }

    public static t a() {
        if (f5037a == null) {
            synchronized (t.class) {
                if (f5037a == null) {
                    f5037a = new t();
                }
            }
        }
        return f5037a;
    }

    private boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f5038h;
        if (j10 != 0 && currentTimeMillis - j10 < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            return false;
        }
        this.f5038h = currentTimeMillis;
        return true;
    }

    public synchronized void c(boolean z10) {
        this.f5039k = z10;
    }

    public synchronized void g() {
        this.f5038h = 0;
    }

    private void a(String str, String str2) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                a10.a(str, u.a(s.SNIFF_HOST), str2);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028 A[Catch:{ Exception -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a A[Catch:{ Exception -> 0x0061 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void g(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x0005
            r5.hostName = r6     // Catch:{ Exception -> 0x0061 }
        L_0x0005:
            boolean r0 = r5.f5039k     // Catch:{ Exception -> 0x0061 }
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "sniffer is turned off"
        L_0x000d:
            r3 = r0
            r0 = 0
            goto L_0x0026
        L_0x0010:
            boolean r0 = r5.d()     // Catch:{ Exception -> 0x0061 }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "sniff too often"
            goto L_0x000d
        L_0x0019:
            java.lang.String r0 = r5.hostName     // Catch:{ Exception -> 0x0061 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0061 }
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = "hostname is null"
            goto L_0x000d
        L_0x0024:
            r0 = 1
            r3 = r1
        L_0x0026:
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = "launch a sniff task"
            com.alibaba.sdk.android.httpdns.i.d(r0)     // Catch:{ Exception -> 0x0061 }
            com.alibaba.sdk.android.httpdns.q r0 = new com.alibaba.sdk.android.httpdns.q     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = r5.hostName     // Catch:{ Exception -> 0x0061 }
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.SNIFF_HOST     // Catch:{ Exception -> 0x0061 }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0061 }
            r0.a(r2)     // Catch:{ Exception -> 0x0061 }
            java.util.concurrent.ExecutorService r2 = com.alibaba.sdk.android.httpdns.c.a()     // Catch:{ Exception -> 0x0061 }
            r2.submit(r0)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.u.a((com.alibaba.sdk.android.httpdns.s) r4)     // Catch:{ Exception -> 0x0061 }
            r5.a(r6, r0)     // Catch:{ Exception -> 0x0061 }
            r5.hostName = r1     // Catch:{ Exception -> 0x0061 }
            goto L_0x0065
        L_0x004a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r6.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r0 = "launch sniffer failed due to "
            r6.append(r0)     // Catch:{ Exception -> 0x0061 }
            r6.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0061 }
            com.alibaba.sdk.android.httpdns.i.d(r6)     // Catch:{ Exception -> 0x0061 }
            goto L_0x0065
        L_0x005f:
            r6 = move-exception
            goto L_0x0067
        L_0x0061:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x005f }
        L_0x0065:
            monitor-exit(r5)
            return
        L_0x0067:
            monitor-exit(r5)
            goto L_0x006a
        L_0x0069:
            throw r6
        L_0x006a:
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.t.g(java.lang.String):void");
    }
}
