package com.alibaba.sdk.android.httpdns.probe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private CountDownLatch f5022a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f5023b;

    /* renamed from: o  reason: collision with root package name */
    private String f5024o;
    private int port;

    public g(String str, int i10, CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.f5024o = str;
        this.port = i10;
        this.f5022a = countDownLatch;
        this.f5023b = concurrentHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c A[SYNTHETIC, Splitter:B:18:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081 A[SYNTHETIC, Splitter:B:29:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "socket close failed:"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            java.net.Socket r6 = new java.net.Socket     // Catch:{ IOException -> 0x0041 }
            r6.<init>()     // Catch:{ IOException -> 0x0041 }
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch:{ IOException -> 0x003c, all -> 0x0039 }
            r3.<init>(r8, r9)     // Catch:{ IOException -> 0x003c, all -> 0x0039 }
            r8 = 5000(0x1388, float:7.006E-42)
            r6.connect(r3, r8)     // Catch:{ IOException -> 0x003c, all -> 0x0039 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x003c, all -> 0x0039 }
            r6.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0078
        L_0x0021:
            r3 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = r3.toString()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.alibaba.sdk.android.httpdns.i.f(r0)
            goto L_0x0078
        L_0x0039:
            r8 = move-exception
            r3 = r6
            goto L_0x007f
        L_0x003c:
            r8 = move-exception
            r3 = r6
            goto L_0x0042
        L_0x003f:
            r8 = move-exception
            goto L_0x007f
        L_0x0041:
            r8 = move-exception
        L_0x0042:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r9.<init>()     // Catch:{ all -> 0x003f }
            java.lang.String r6 = "connect failed:"
            r9.append(r6)     // Catch:{ all -> 0x003f }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x003f }
            r9.append(r8)     // Catch:{ all -> 0x003f }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x003f }
            com.alibaba.sdk.android.httpdns.i.f(r8)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0077
        L_0x0060:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.alibaba.sdk.android.httpdns.i.f(r8)
        L_0x0077:
            r8 = r4
        L_0x0078:
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x007d
            return r4
        L_0x007d:
            long r8 = r8 - r1
            return r8
        L_0x007f:
            if (r3 == 0) goto L_0x009c
            r3.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x009c
        L_0x0085:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.alibaba.sdk.android.httpdns.i.f(r9)
        L_0x009c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.g.a(java.lang.String, int):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a A[Catch:{ Exception -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f5024o     // Catch:{ Exception -> 0x004e }
            if (r0 == 0) goto L_0x0041
            int r0 = r4.port     // Catch:{ Exception -> 0x004e }
            boolean r0 = r4.a(r0)     // Catch:{ Exception -> 0x004e }
            if (r0 != 0) goto L_0x000d
            goto L_0x0041
        L_0x000d:
            java.lang.String r0 = r4.f5024o     // Catch:{ Exception -> 0x004e }
            int r1 = r4.port     // Catch:{ Exception -> 0x004e }
            long r0 = r4.a(r0, r1)     // Catch:{ Exception -> 0x004e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004e }
            r2.<init>()     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = "connect cost for ip:"
            r2.append(r3)     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = r4.f5024o     // Catch:{ Exception -> 0x004e }
            r2.append(r3)     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = " is "
            r2.append(r3)     // Catch:{ Exception -> 0x004e }
            r2.append(r0)     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004e }
            com.alibaba.sdk.android.httpdns.i.d(r2)     // Catch:{ Exception -> 0x004e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r2 = r4.f5023b     // Catch:{ Exception -> 0x004e }
            if (r2 == 0) goto L_0x0046
            java.lang.String r3 = r4.f5024o     // Catch:{ Exception -> 0x004e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x004e }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x004e }
            goto L_0x0046
        L_0x0041:
            java.lang.String r0 = "invalid params, give up"
            com.alibaba.sdk.android.httpdns.i.f(r0)     // Catch:{ Exception -> 0x004e }
        L_0x0046:
            java.util.concurrent.CountDownLatch r0 = r4.f5022a     // Catch:{ Exception -> 0x004e }
            if (r0 == 0) goto L_0x0052
            r0.countDown()     // Catch:{ Exception -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.g.run():void");
    }

    private boolean a(int i10) {
        return i10 >= 1 && i10 <= 65535;
    }
}
