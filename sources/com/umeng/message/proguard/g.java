package com.umeng.message.proguard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.hpplay.cybergarage.http.HTTP;
import com.umeng.message.common.UPLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

public final class g {
    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (UPLog.isEnable() && z10) {
                UPLog.i("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (UPLog.isEnable() && z10) {
                UPLog.i("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6 A[SYNTHETIC, Splitter:B:34:0x00b6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(org.json.JSONObject r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r6 = r6.toString()
            byte[] r0 = r8.getBytes()
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            byte[] r6 = r6.getBytes()
            com.umeng.message.proguard.bq.a(r6, r1)
            byte[] r6 = r1.toByteArray()
            byte[] r6 = com.umeng.message.proguard.bl.a(r6, r0)
            android.os.SystemClock.elapsedRealtime()
            r0 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x00ab }
            r2.<init>(r7)     // Catch:{ all -> 0x00ab }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ all -> 0x00ab }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch:{ all -> 0x00a7 }
            r2 = 60000(0xea60, float:8.4078E-41)
            r7.setReadTimeout(r2)     // Catch:{ all -> 0x00a7 }
            r7.setConnectTimeout(r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r7.addRequestProperty(r2, r3)     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "close"
            r7.addRequestProperty(r2, r3)     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = "appkey"
            r7.addRequestProperty(r2, r8)     // Catch:{ all -> 0x00a7 }
            int r8 = r6.length     // Catch:{ all -> 0x00a7 }
            r7.setFixedLengthStreamingMode(r8)     // Catch:{ all -> 0x00a7 }
            r8 = 1
            r7.setDoOutput(r8)     // Catch:{ all -> 0x00a7 }
            java.io.OutputStream r8 = r7.getOutputStream()     // Catch:{ all -> 0x00a7 }
            r8.write(r6)     // Catch:{ all -> 0x00a1 }
            int r6 = r7.getResponseCode()     // Catch:{ all -> 0x00a1 }
            r2 = 400(0x190, float:5.6E-43)
            if (r6 >= r2) goto L_0x0068
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ all -> 0x00a1 }
            goto L_0x006c
        L_0x0068:
            java.io.InputStream r0 = r7.getErrorStream()     // Catch:{ all -> 0x00a1 }
        L_0x006c:
            r1.reset()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0081
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x00a1 }
        L_0x0075:
            int r3 = r0.read(r2)     // Catch:{ all -> 0x00a1 }
            r4 = -1
            if (r3 == r4) goto L_0x0081
            r4 = 0
            r1.write(r2, r4, r3)     // Catch:{ all -> 0x00a1 }
            goto L_0x0075
        L_0x0081:
            com.umeng.message.proguard.f.a((java.io.Closeable) r8)
            com.umeng.message.proguard.f.a((java.io.Closeable) r0)
            r7.disconnect()     // Catch:{ all -> 0x008b }
            goto L_0x008c
        L_0x008b:
        L_0x008c:
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L_0x0091
            return
        L_0x0091:
            java.lang.Exception r7 = new java.lang.Exception
            java.lang.String r8 = "response code:"
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r6 = r8.concat(r6)
            r7.<init>(r6)
            throw r7
        L_0x00a1:
            r6 = move-exception
            r5 = r8
            r8 = r7
            r7 = r0
            r0 = r5
            goto L_0x00ae
        L_0x00a7:
            r6 = move-exception
            r8 = r7
            r7 = r0
            goto L_0x00ae
        L_0x00ab:
            r6 = move-exception
            r7 = r0
            r8 = r7
        L_0x00ae:
            com.umeng.message.proguard.f.a((java.io.Closeable) r0)
            com.umeng.message.proguard.f.a((java.io.Closeable) r7)
            if (r8 == 0) goto L_0x00b9
            r8.disconnect()     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            goto L_0x00bb
        L_0x00ba:
            throw r6
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.g.b(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2) {
        long elapsedRealtime;
        URL url;
        JSONObject jSONObject2 = jSONObject;
        String str3 = str;
        String str4 = str2;
        try {
            return a(jSONObject2, str3, str4, true);
        } catch (UnknownHostException unused) {
            elapsedRealtime = SystemClock.elapsedRealtime();
            String host = new URL(str3).getHost();
            String a10 = bh.a("174658", host);
            if (a10 == null) {
                return null;
            }
            url = new URL(str3.replaceFirst(host, a10));
            String jSONObject3 = jSONObject.toString();
            final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Host", host);
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
                    public final boolean verify(String str, SSLSession sSLSession) {
                        String requestProperty = httpURLConnection.getRequestProperty("Host");
                        if (requestProperty == null) {
                            requestProperty = httpURLConnection.getURL().getHost();
                        }
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
                    }
                });
            }
            JSONObject jSONObject4 = new JSONObject(a(jSONObject3, httpURLConnection, str4));
            if (UPLog.isEnable()) {
                UPLog.i("Net", "req:", url, "\n", jSONObject2, "\nresp:\n", jSONObject4, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject4;
        } catch (Throwable th) {
            if (UPLog.isEnable()) {
                UPLog.i("Net", "req:", url, "\n", jSONObject2, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bq.a(str.getBytes(), byteArrayOutputStream);
        byte[] a10 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("Connection", HTTP.CLOSE);
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a10.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(a10);
                f.a((Closeable) outputStream);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 400) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }
                byteArrayOutputStream.reset();
                if (inputStream != null) {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } finally {
                            f.a((Closeable) inputStream);
                        }
                    }
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
                if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                    byte[] a11 = bl.a(byteArrayOutputStream.toByteArray(), bytes);
                    byteArrayOutputStream.reset();
                    bq.b(a11, byteArrayOutputStream);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                if (responseCode == 200) {
                    return byteArrayOutputStream2;
                }
                throw new IOException("code:" + responseCode + "msg:" + byteArrayOutputStream2);
            } catch (Throwable th) {
                th = th;
                f.a((Closeable) outputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            f.a((Closeable) outputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b9 A[SYNTHETIC, Splitter:B:52:0x01b9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18, java.io.File r19) {
        /*
            r0 = r17
            java.lang.String r1 = r16.toString()
            byte[] r2 = r18.getBytes()
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            byte[] r4 = r1.getBytes()
            com.umeng.message.proguard.bq.a(r4, r3)
            byte[] r4 = r3.toByteArray()
            byte[] r4 = com.umeng.message.proguard.bl.a(r4, r2)
            long r5 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r7 = "--"
            byte[] r7 = r7.getBytes()
            java.lang.String r8 = "\r\n"
            byte[] r8 = r8.getBytes()
            java.net.URL r10 = new java.net.URL     // Catch:{ all -> 0x01ac }
            r10.<init>(r0)     // Catch:{ all -> 0x01ac }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ all -> 0x01ac }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ all -> 0x01ac }
            java.lang.String r11 = "POST"
            r10.setRequestMethod(r11)     // Catch:{ all -> 0x01a7 }
            r11 = 60000(0xea60, float:8.4078E-41)
            r10.setReadTimeout(r11)     // Catch:{ all -> 0x01a7 }
            r10.setConnectTimeout(r11)     // Catch:{ all -> 0x01a7 }
            r11 = 0
            r10.setUseCaches(r11)     // Catch:{ all -> 0x01a7 }
            java.lang.String r12 = "Content-Type"
            java.lang.String r13 = "multipart/form-data;boundary="
            java.lang.String r14 = "----WebKitFormBoundary7MA4YWxkTrZu0gW"
            java.lang.String r13 = r13.concat(r14)     // Catch:{ all -> 0x01a7 }
            r10.addRequestProperty(r12, r13)     // Catch:{ all -> 0x01a7 }
            java.lang.String r12 = "appkey"
            r13 = r18
            r10.addRequestProperty(r12, r13)     // Catch:{ all -> 0x01a7 }
            java.lang.String r12 = "Connection"
            java.lang.String r13 = "close"
            r10.addRequestProperty(r12, r13)     // Catch:{ all -> 0x01a7 }
            r12 = 1
            r10.setDoOutput(r12)     // Catch:{ all -> 0x01a7 }
            java.io.OutputStream r13 = r10.getOutputStream()     // Catch:{ all -> 0x01a7 }
            r13.write(r7)     // Catch:{ all -> 0x01a2 }
            byte[] r15 = r14.getBytes()     // Catch:{ all -> 0x01a2 }
            r13.write(r15)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            java.lang.String r15 = "Content-Disposition: form-data; name=\"msg\""
            byte[] r15 = r15.getBytes()     // Catch:{ all -> 0x01a2 }
            r13.write(r15)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            byte[] r4 = com.umeng.message.proguard.bf.b((byte[]) r4)     // Catch:{ all -> 0x01a2 }
            r13.write(r4)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            r13.write(r7)     // Catch:{ all -> 0x01a2 }
            byte[] r4 = r14.getBytes()     // Catch:{ all -> 0x01a2 }
            r13.write(r4)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a2 }
            java.lang.String r15 = "Content-Disposition: form-data; name=\"file\"; filename=\""
            r4.<init>(r15)     // Catch:{ all -> 0x01a2 }
            java.lang.String r15 = r19.getName()     // Catch:{ all -> 0x01a2 }
            r4.append(r15)     // Catch:{ all -> 0x01a2 }
            java.lang.String r15 = "\""
            r4.append(r15)     // Catch:{ all -> 0x01a2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01a2 }
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x01a2 }
            r13.write(r4)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            java.lang.String r4 = "Content-Type: application/octet-stream"
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x01a2 }
            r13.write(r4)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x01a2 }
            r15 = r19
            r4.<init>(r15)     // Catch:{ all -> 0x01a2 }
            r15 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r15]     // Catch:{ all -> 0x01a2 }
        L_0x00dc:
            int r9 = r4.read(r15)     // Catch:{ all -> 0x01a2 }
            r12 = -1
            if (r9 == r12) goto L_0x00e8
            r13.write(r15, r11, r9)     // Catch:{ all -> 0x01a2 }
            r12 = 1
            goto L_0x00dc
        L_0x00e8:
            r4.close()     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            r13.write(r7)     // Catch:{ all -> 0x01a2 }
            byte[] r4 = r14.getBytes()     // Catch:{ all -> 0x01a2 }
            r13.write(r4)     // Catch:{ all -> 0x01a2 }
            r13.write(r7)     // Catch:{ all -> 0x01a2 }
            r13.write(r8)     // Catch:{ all -> 0x01a2 }
            int r4 = r10.getResponseCode()     // Catch:{ all -> 0x01a2 }
            r7 = 400(0x190, float:5.6E-43)
            if (r4 >= r7) goto L_0x010b
            java.io.InputStream r7 = r10.getInputStream()     // Catch:{ all -> 0x01a2 }
            goto L_0x010f
        L_0x010b:
            java.io.InputStream r7 = r10.getErrorStream()     // Catch:{ all -> 0x01a2 }
        L_0x010f:
            r9 = r7
            r3.reset()     // Catch:{ all -> 0x019d }
            if (r9 == 0) goto L_0x011f
        L_0x0115:
            int r7 = r9.read(r15)     // Catch:{ all -> 0x019d }
            if (r7 == r12) goto L_0x011f
            r3.write(r15, r11, r7)     // Catch:{ all -> 0x019d }
            goto L_0x0115
        L_0x011f:
            com.umeng.message.proguard.f.a((java.io.Closeable) r13)
            com.umeng.message.proguard.f.a((java.io.Closeable) r9)
            r10.disconnect()     // Catch:{ all -> 0x0129 }
            goto L_0x012a
        L_0x0129:
        L_0x012a:
            r7 = 200(0xc8, float:2.8E-43)
            if (r4 != r7) goto L_0x014a
            java.lang.String r8 = "Content-Encoding"
            java.lang.String r8 = r10.getHeaderField(r8)
            java.lang.String r9 = "xgzip"
            boolean r8 = android.text.TextUtils.equals(r9, r8)
            if (r8 == 0) goto L_0x014a
            byte[] r8 = r3.toByteArray()
            byte[] r2 = com.umeng.message.proguard.bl.a(r8, r2)
            r3.reset()
            com.umeng.message.proguard.bq.b(r2, r3)
        L_0x014a:
            java.lang.String r2 = r3.toString()
            boolean r3 = com.umeng.message.common.UPLog.isEnable()
            if (r3 == 0) goto L_0x0185
            r3 = 8
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r8 = "req:"
            r3[r11] = r8
            r8 = 1
            r3[r8] = r0
            r0 = 2
            java.lang.String r8 = "\n"
            r3[r0] = r8
            r0 = 3
            r3[r0] = r1
            r0 = 4
            java.lang.String r1 = "\nresp:\n"
            r3[r0] = r1
            r0 = 5
            r3[r0] = r2
            r0 = 6
            java.lang.String r1 = "\nconsume:"
            r3[r0] = r1
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r0 = r0 - r5
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r1 = 7
            r3[r1] = r0
            java.lang.String r0 = "Net"
            com.umeng.message.common.UPLog.i(r0, r3)
        L_0x0185:
            if (r4 != r7) goto L_0x018d
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r2)
            return r0
        L_0x018d:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "response code:"
            java.lang.String r2 = java.lang.String.valueOf(r4)
            java.lang.String r1 = r1.concat(r2)
            r0.<init>(r1)
            throw r0
        L_0x019d:
            r0 = move-exception
            r1 = r0
            r0 = r9
            r9 = r13
            goto L_0x01b1
        L_0x01a2:
            r0 = move-exception
            r1 = r0
            r9 = r13
            r0 = 0
            goto L_0x01b1
        L_0x01a7:
            r0 = move-exception
            r1 = r0
            r0 = 0
            r9 = 0
            goto L_0x01b1
        L_0x01ac:
            r0 = move-exception
            r1 = r0
            r0 = 0
            r9 = 0
            r10 = 0
        L_0x01b1:
            com.umeng.message.proguard.f.a((java.io.Closeable) r9)
            com.umeng.message.proguard.f.a((java.io.Closeable) r0)
            if (r10 == 0) goto L_0x01bc
            r10.disconnect()     // Catch:{ all -> 0x01bc }
        L_0x01bc:
            goto L_0x01be
        L_0x01bd:
            throw r1
        L_0x01be:
            goto L_0x01bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.g.a(org.json.JSONObject, java.lang.String, java.lang.String, java.io.File):org.json.JSONObject");
    }
}
