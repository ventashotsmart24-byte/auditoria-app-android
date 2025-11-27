package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class ap {

    /* renamed from: a  reason: collision with root package name */
    private static HostnameVerifier f13758a;

    private static HostnameVerifier a() {
        if (f13758a == null) {
            f13758a = new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    if ("pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str) || "ulogs.umeng.com".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str) || "cnlogs.umeng.com".equalsIgnoreCase(str)) {
                        return true;
                    }
                    return false;
                }
            };
        }
        return f13758a;
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        InputStream inputStream;
        byte[] readStreamToByteArray;
        byte[] bArr2 = null;
        try {
            HttpsURLConnection a10 = a(str, "ak", ax.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (a10 != null && a10.getResponseCode() == 200) {
                inputStream = a10.getInputStream();
                try {
                    readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    String headerField = a10.getHeaderField("ak");
                    if (!TextUtils.isEmpty(headerField)) {
                        bArr2 = ax.a(readStreamToByteArray, headerField.getBytes());
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                    }
                    HelperUtils.safeClose(inputStream);
                } catch (Throwable th) {
                    th = th;
                    HelperUtils.safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return bArr2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r3, byte[] r4, java.lang.String r5) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x004d }
            r1.<init>()     // Catch:{ all -> 0x004d }
            com.umeng.analytics.pro.ax.a((byte[]) r4, (java.io.OutputStream) r1)     // Catch:{ all -> 0x0018 }
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = com.umeng.commonsdk.UMConfigure.sAppkey     // Catch:{ all -> 0x0018 }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x0018 }
            byte[] r4 = com.umeng.analytics.pro.ax.a((byte[]) r4, (byte[]) r1)     // Catch:{ all -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r4 = r0
        L_0x0019:
            java.lang.String r1 = "appkey"
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r5 = r1
        L_0x0023:
            javax.net.ssl.HttpsURLConnection r0 = a((java.lang.String) r3, (java.lang.String) r5, (byte[]) r4)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0047
            int r3 = r0.getResponseCode()     // Catch:{ all -> 0x004d }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == r4) goto L_0x0047
            java.lang.String r4 = "MobclickRT"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r5.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r1 = "SC/ActUp/EkvError event report error, http error code: "
            r5.append(r1)     // Catch:{ all -> 0x004d }
            r5.append(r3)     // Catch:{ all -> 0x004d }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x004d }
            com.umeng.commonsdk.debug.UMRTLog.e(r4, r3)     // Catch:{ all -> 0x004d }
        L_0x0047:
            if (r0 == 0) goto L_0x0054
        L_0x0049:
            r0.disconnect()     // Catch:{ all -> 0x0054 }
            goto L_0x0054
        L_0x004d:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0054
            goto L_0x0049
        L_0x0054:
            return
        L_0x0055:
            r3 = move-exception
            if (r0 == 0) goto L_0x005b
            r0.disconnect()     // Catch:{ all -> 0x005b }
        L_0x005b:
            goto L_0x005d
        L_0x005c:
            throw r3
        L_0x005d:
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ap.a(java.lang.String, byte[], java.lang.String):void");
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection = null;
        try {
            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, new SecureRandom());
                httpsURLConnection2.setSSLSocketFactory(instance.getSocketFactory());
                httpsURLConnection2.setHostnameVerifier(a());
                httpsURLConnection2.setRequestMethod("POST");
                httpsURLConnection2.setConnectTimeout(by.f13999b);
                httpsURLConnection2.setDoOutput(true);
                httpsURLConnection2.setDoInput(true);
                httpsURLConnection2.setReadTimeout(by.f13999b);
                httpsURLConnection2.addRequestProperty("Content-Type", "application/octet-stream");
                httpsURLConnection2.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection2.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                httpsURLConnection2.connect();
                OutputStream outputStream = httpsURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection2;
            } catch (Exception e10) {
                e = e10;
                httpsURLConnection = httpsURLConnection2;
            }
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            return httpsURLConnection;
        }
    }
}
