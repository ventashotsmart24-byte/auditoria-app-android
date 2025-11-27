package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class ca {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14021a = "HttpClient";

    /* renamed from: f  reason: collision with root package name */
    private static HostnameVerifier f14022f;

    /* renamed from: b  reason: collision with root package name */
    private String f14023b;

    /* renamed from: c  reason: collision with root package name */
    private a f14024c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f14025d;

    /* renamed from: e  reason: collision with root package name */
    private cb f14026e;

    public enum a {
        POST,
        GET
    }

    public ca(String str, a aVar, Map<String, String> map, cb cbVar) {
        this.f14023b = str;
        this.f14024c = aVar;
        this.f14025d = map;
        this.f14026e = cbVar;
    }

    private static HostnameVerifier a() {
        if (f14022f == null) {
            f14022f = new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str) || !by.f13998a.equalsIgnoreCase(str)) {
                        return false;
                    }
                    return true;
                }
            };
        }
        return f14022f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d6, code lost:
        if (r1 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00db, code lost:
        if (r1 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e0, code lost:
        if (r1 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e5, code lost:
        if (r1 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ea, code lost:
        if (r1 != null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
        if (r1 != null) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(int r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00ed, SocketTimeoutException -> 0x00e8, UnknownHostException -> 0x00e3, SSLHandshakeException -> 0x00de, IOException -> 0x00d9, all -> 0x00d4 }
            java.lang.String r2 = r5.f14023b     // Catch:{ MalformedURLException -> 0x00ed, SocketTimeoutException -> 0x00e8, UnknownHostException -> 0x00e3, SSLHandshakeException -> 0x00de, IOException -> 0x00d9, all -> 0x00d4 }
            r1.<init>(r2)     // Catch:{ MalformedURLException -> 0x00ed, SocketTimeoutException -> 0x00e8, UnknownHostException -> 0x00e3, SSLHandshakeException -> 0x00de, IOException -> 0x00d9, all -> 0x00d4 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ MalformedURLException -> 0x00ed, SocketTimeoutException -> 0x00e8, UnknownHostException -> 0x00e3, SSLHandshakeException -> 0x00de, IOException -> 0x00d9, all -> 0x00d4 }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ MalformedURLException -> 0x00ed, SocketTimeoutException -> 0x00e8, UnknownHostException -> 0x00e3, SSLHandshakeException -> 0x00de, IOException -> 0x00d9, all -> 0x00d4 }
            java.lang.String r2 = "TLS"
            javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r2.init(r0, r0, r3)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            javax.net.ssl.SSLSocketFactory r2 = r2.getSocketFactory()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.setSSLSocketFactory(r2)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            javax.net.ssl.HostnameVerifier r2 = a()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.setHostnameVerifier(r2)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.f14025d     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            if (r2 == 0) goto L_0x005c
            boolean r2 = r2.isEmpty()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            if (r2 != 0) goto L_0x005c
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.f14025d     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.util.Set r2 = r2.keySet()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
        L_0x003e:
            boolean r3 = r2.hasNext()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r2.next()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            if (r4 != 0) goto L_0x003e
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.f14025d     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.setRequestProperty(r3, r4)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            goto L_0x003e
        L_0x005c:
            r1.setConnectTimeout(r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.setReadTimeout(r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            com.umeng.analytics.pro.ca$a r6 = r5.f14024c     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            com.umeng.analytics.pro.ca$a r2 = com.umeng.analytics.pro.ca.a.POST     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r3 = 1
            if (r6 != r2) goto L_0x0094
            java.lang.String r6 = "POST"
            r1.setRequestMethod(r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.setDoOutput(r3)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.setDoInput(r3)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r6 = 0
            r1.setDefaultUseCaches(r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r7)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            if (r6 != 0) goto L_0x0090
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r6.<init>(r2)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r6.write(r7)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r6.flush()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r6.close()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
        L_0x0090:
            r1.connect()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            goto L_0x0099
        L_0x0094:
            java.lang.String r6 = "GET"
            r1.setRequestMethod(r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
        L_0x0099:
            int r6 = r1.getResponseCode()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L_0x00f1
            java.io.InputStream r6 = r1.getInputStream()     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            byte[] r7 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            java.lang.String r2 = ""
            if (r7 == 0) goto L_0x00b5
            int r4 = r7.length     // Catch:{ all -> 0x00c3 }
            if (r4 <= r3) goto L_0x00b5
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x00c3 }
            r2.<init>(r7)     // Catch:{ all -> 0x00c3 }
        L_0x00b5:
            com.umeng.analytics.pro.cb r7 = r5.f14026e     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x00bc
            r7.a((java.lang.String) r2)     // Catch:{ all -> 0x00c3 }
        L_0x00bc:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            r1.disconnect()
            return r2
        L_0x00c3:
            r7 = move-exception
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r6)     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
            throw r7     // Catch:{ MalformedURLException -> 0x00d2, SocketTimeoutException -> 0x00d0, UnknownHostException -> 0x00ce, SSLHandshakeException -> 0x00cc, IOException -> 0x00ca, all -> 0x00c8 }
        L_0x00c8:
            goto L_0x00d6
        L_0x00ca:
            goto L_0x00db
        L_0x00cc:
            goto L_0x00e0
        L_0x00ce:
            goto L_0x00e5
        L_0x00d0:
            goto L_0x00ea
        L_0x00d2:
            goto L_0x00ef
        L_0x00d4:
            r1 = r0
        L_0x00d6:
            if (r1 == 0) goto L_0x00f4
            goto L_0x00f1
        L_0x00d9:
            r1 = r0
        L_0x00db:
            if (r1 == 0) goto L_0x00f4
            goto L_0x00f1
        L_0x00de:
            r1 = r0
        L_0x00e0:
            if (r1 == 0) goto L_0x00f4
            goto L_0x00f1
        L_0x00e3:
            r1 = r0
        L_0x00e5:
            if (r1 == 0) goto L_0x00f4
            goto L_0x00f1
        L_0x00e8:
            r1 = r0
        L_0x00ea:
            if (r1 == 0) goto L_0x00f4
            goto L_0x00f1
        L_0x00ed:
            r1 = r0
        L_0x00ef:
            if (r1 == 0) goto L_0x00f4
        L_0x00f1:
            r1.disconnect()
        L_0x00f4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ca.a(int, java.lang.String):java.lang.String");
    }
}
