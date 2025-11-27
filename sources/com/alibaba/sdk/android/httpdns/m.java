package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.Callable;

public class m implements Callable<String[]> {

    /* renamed from: a  reason: collision with root package name */
    private static m f4986a;

    /* renamed from: d  reason: collision with root package name */
    private int f4987d;

    /* renamed from: d  reason: collision with other field name */
    private long f23d = 0;

    public static m a() {
        if (f4986a == null) {
            f4986a = new m();
        }
        return f4986a;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public void a(int i10) {
        this.f4987d = i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0168 A[Catch:{ IOException -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127 A[Catch:{ Exception -> 0x013d, all -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143 A[SYNTHETIC, Splitter:B:77:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0148 A[SYNTHETIC, Splitter:B:80:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0150 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x015b A[SYNTHETIC, Splitter:B:93:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0160 A[SYNTHETIC, Splitter:B:96:0x0160] */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String[] m15a() {
        /*
            r10 = this;
            monitor-enter(r10)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0170 }
            r10.f23d = r0     // Catch:{ all -> 0x0170 }
            r0 = 0
            com.alibaba.sdk.android.httpdns.n r1 = com.alibaba.sdk.android.httpdns.n.a()     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            java.lang.String r1 = r1.d()     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            if (r1 == 0) goto L_0x00f7
            java.lang.String r2 = "StartIp call start"
            com.alibaba.sdk.android.httpdns.i.d(r2)     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0115, all -> 0x0110 }
            r3 = 15000(0x3a98, float:2.102E-41)
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            boolean r3 = r2 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            if (r3 == 0) goto L_0x0039
            r3 = r2
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            com.alibaba.sdk.android.httpdns.m$1 r4 = new com.alibaba.sdk.android.httpdns.m$1     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r4.<init>(r1)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r3.setHostnameVerifier(r4)     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
        L_0x0039:
            int r1 = r2.getResponseCode()     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 == r3) goto L_0x009f
            java.io.InputStream r1 = r2.getErrorStream()     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r1, r5)     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r0.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
        L_0x0056:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            if (r4 == 0) goto L_0x0060
            r0.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            goto L_0x0056
        L_0x0060:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r4.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r5 = "StartIp response code is "
            r4.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            int r5 = r2.getResponseCode()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r4.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r5 = " expect 200. response body is "
            r4.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r4.append(r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            com.alibaba.sdk.android.httpdns.i.f(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            com.alibaba.sdk.android.httpdns.g r4 = new com.alibaba.sdk.android.httpdns.g     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            int r5 = r2.getResponseCode()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r4.<init>(r5, r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            com.alibaba.sdk.android.httpdns.h r0 = new com.alibaba.sdk.android.httpdns.h     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            int r5 = r4.getErrorCode()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r0.<init>(r5, r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            throw r0     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
        L_0x009f:
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ Exception -> 0x00f3, all -> 0x00ef }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r1, r5)     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r0.<init>()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
        L_0x00b4:
            java.lang.String r4 = r3.readLine()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            if (r4 == 0) goto L_0x00be
            r0.append(r4)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            goto L_0x00b4
        L_0x00be:
            com.alibaba.sdk.android.httpdns.o r4 = new com.alibaba.sdk.android.httpdns.o     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            com.alibaba.sdk.android.httpdns.n r0 = com.alibaba.sdk.android.httpdns.n.a()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            long r7 = r10.f23d     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            long r5 = r5 - r7
            r0.a((com.alibaba.sdk.android.httpdns.o) r4, (long) r5)     // Catch:{ Exception -> 0x00dd, all -> 0x00d7 }
            r0 = r2
            goto L_0x00f9
        L_0x00d7:
            r0 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
            goto L_0x0159
        L_0x00dd:
            r0 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
            goto L_0x0119
        L_0x00e2:
            r3 = move-exception
            r9 = r3
            r3 = r0
            r0 = r2
            r2 = r9
            goto L_0x0159
        L_0x00e9:
            r3 = move-exception
            r9 = r3
            r3 = r0
            r0 = r2
            r2 = r9
            goto L_0x0119
        L_0x00ef:
            r1 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x0112
        L_0x00f3:
            r1 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x0117
        L_0x00f7:
            r1 = r0
            r3 = r1
        L_0x00f9:
            if (r0 == 0) goto L_0x00fe
            r0.disconnect()     // Catch:{ all -> 0x0170 }
        L_0x00fe:
            if (r1 == 0) goto L_0x0106
            r1.close()     // Catch:{ IOException -> 0x0104 }
            goto L_0x0106
        L_0x0104:
            r0 = move-exception
            goto L_0x010c
        L_0x0106:
            if (r3 == 0) goto L_0x0153
            r3.close()     // Catch:{ IOException -> 0x0104 }
            goto L_0x0153
        L_0x010c:
            com.alibaba.sdk.android.httpdns.i.a(r0)     // Catch:{ all -> 0x0170 }
            goto L_0x0153
        L_0x0110:
            r1 = move-exception
            r3 = r0
        L_0x0112:
            r2 = r1
            r1 = r3
            goto L_0x0159
        L_0x0115:
            r1 = move-exception
            r3 = r0
        L_0x0117:
            r2 = r1
            r1 = r3
        L_0x0119:
            com.alibaba.sdk.android.httpdns.i.a(r2)     // Catch:{ all -> 0x0158 }
            com.alibaba.sdk.android.httpdns.n r4 = com.alibaba.sdk.android.httpdns.n.a()     // Catch:{ all -> 0x0158 }
            r4.c(r2)     // Catch:{ all -> 0x0158 }
            int r2 = r10.f4987d     // Catch:{ all -> 0x0158 }
            if (r2 <= 0) goto L_0x0141
            int r2 = r2 + -1
            r10.f4987d = r2     // Catch:{ all -> 0x0158 }
            java.util.concurrent.ScheduledExecutorService r2 = com.alibaba.sdk.android.httpdns.j.a()     // Catch:{ Exception -> 0x013d }
            com.alibaba.sdk.android.httpdns.m$2 r4 = new com.alibaba.sdk.android.httpdns.m$2     // Catch:{ Exception -> 0x013d }
            r4.<init>()     // Catch:{ Exception -> 0x013d }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x013d }
            r6 = 300000(0x493e0, double:1.482197E-318)
            r2.schedule(r4, r6, r5)     // Catch:{ Exception -> 0x013d }
            goto L_0x0141
        L_0x013d:
            r2 = move-exception
            com.alibaba.sdk.android.httpdns.i.a(r2)     // Catch:{ all -> 0x0158 }
        L_0x0141:
            if (r0 == 0) goto L_0x0146
            r0.disconnect()     // Catch:{ all -> 0x0170 }
        L_0x0146:
            if (r1 == 0) goto L_0x014e
            r1.close()     // Catch:{ IOException -> 0x014c }
            goto L_0x014e
        L_0x014c:
            r0 = move-exception
            goto L_0x010c
        L_0x014e:
            if (r3 == 0) goto L_0x0153
            r3.close()     // Catch:{ IOException -> 0x014c }
        L_0x0153:
            r0 = 0
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ all -> 0x0170 }
            monitor-exit(r10)
            return r0
        L_0x0158:
            r2 = move-exception
        L_0x0159:
            if (r0 == 0) goto L_0x015e
            r0.disconnect()     // Catch:{ all -> 0x0170 }
        L_0x015e:
            if (r1 == 0) goto L_0x0166
            r1.close()     // Catch:{ IOException -> 0x0164 }
            goto L_0x0166
        L_0x0164:
            r0 = move-exception
            goto L_0x016c
        L_0x0166:
            if (r3 == 0) goto L_0x016f
            r3.close()     // Catch:{ IOException -> 0x0164 }
            goto L_0x016f
        L_0x016c:
            com.alibaba.sdk.android.httpdns.i.a(r0)     // Catch:{ all -> 0x0170 }
        L_0x016f:
            throw r2     // Catch:{ all -> 0x0170 }
        L_0x0170:
            r0 = move-exception
            monitor-exit(r10)
            goto L_0x0174
        L_0x0173:
            throw r0
        L_0x0174:
            goto L_0x0173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.m.m15a():java.lang.String[]");
    }
}
