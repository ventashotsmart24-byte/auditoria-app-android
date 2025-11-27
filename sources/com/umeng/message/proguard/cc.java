package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hpplay.cybergarage.xml.XML;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.proguard.df;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cc {

    public interface a {
        void a(Bitmap bitmap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078 A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0134 A[SYNTHETIC, Splitter:B:56:0x0134] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(org.json.JSONObject r12, java.lang.String r13, java.lang.String r14) {
        /*
            java.lang.String r12 = r12.toString()
            byte[] r0 = r14.getBytes()
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            byte[] r2 = r12.getBytes()
            r3 = 0
            r4 = 1
            r5 = 0
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0022 }
            r6.<init>(r1)     // Catch:{ all -> 0x0022 }
            r6.write(r2)     // Catch:{ all -> 0x0020 }
        L_0x001c:
            com.umeng.message.proguard.eb.a(r6)
            goto L_0x0032
        L_0x0020:
            r2 = move-exception
            goto L_0x0024
        L_0x0022:
            r2 = move-exception
            r6 = r5
        L_0x0024:
            java.lang.String r7 = "zip"
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x0138 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0138 }
            r8[r3] = r2     // Catch:{ all -> 0x0138 }
            com.umeng.message.proguard.ce.d(r7, r8)     // Catch:{ all -> 0x0138 }
            goto L_0x001c
        L_0x0032:
            byte[] r2 = r1.toByteArray()
            byte[] r2 = com.umeng.message.proguard.dz.a(r2, r0)
            long r6 = android.os.SystemClock.elapsedRealtime()
            java.net.URL r8 = new java.net.URL     // Catch:{ all -> 0x0129 }
            r8.<init>(r13)     // Catch:{ all -> 0x0129 }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ all -> 0x0129 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ all -> 0x0129 }
            java.lang.String r9 = "POST"
            r8.setRequestMethod(r9)     // Catch:{ all -> 0x0126 }
            r9 = 30000(0x7530, float:4.2039E-41)
            r8.setReadTimeout(r9)     // Catch:{ all -> 0x0126 }
            r8.setConnectTimeout(r9)     // Catch:{ all -> 0x0126 }
            java.lang.String r9 = "Content-Type"
            java.lang.String r10 = "application/octet-stream"
            r8.addRequestProperty(r9, r10)     // Catch:{ all -> 0x0126 }
            java.lang.String r9 = "appkey"
            r8.addRequestProperty(r9, r14)     // Catch:{ all -> 0x0126 }
            int r14 = r2.length     // Catch:{ all -> 0x0126 }
            r8.setFixedLengthStreamingMode(r14)     // Catch:{ all -> 0x0126 }
            r8.setDoOutput(r4)     // Catch:{ all -> 0x0126 }
            java.io.OutputStream r14 = r8.getOutputStream()     // Catch:{ all -> 0x0126 }
            r14.write(r2)     // Catch:{ all -> 0x0122 }
            int r2 = r8.getResponseCode()     // Catch:{ all -> 0x0122 }
            r9 = 400(0x190, float:5.6E-43)
            if (r2 >= r9) goto L_0x007d
            java.io.InputStream r5 = r8.getInputStream()     // Catch:{ all -> 0x0122 }
            goto L_0x0081
        L_0x007d:
            java.io.InputStream r5 = r8.getErrorStream()     // Catch:{ all -> 0x0122 }
        L_0x0081:
            r1.reset()     // Catch:{ all -> 0x0122 }
            if (r5 == 0) goto L_0x0095
            r9 = 8192(0x2000, float:1.14794E-41)
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0122 }
        L_0x008a:
            int r10 = r5.read(r9)     // Catch:{ all -> 0x0122 }
            r11 = -1
            if (r10 == r11) goto L_0x0095
            r1.write(r9, r3, r10)     // Catch:{ all -> 0x0122 }
            goto L_0x008a
        L_0x0095:
            com.umeng.message.proguard.eb.a(r14)
            com.umeng.message.proguard.eb.a(r5)
            r8.disconnect()     // Catch:{ all -> 0x009f }
            goto L_0x00a0
        L_0x009f:
        L_0x00a0:
            r14 = 200(0xc8, float:2.8E-43)
            if (r2 != r14) goto L_0x00b2
            byte[] r5 = r1.toByteArray()
            byte[] r0 = com.umeng.message.proguard.dz.a(r5, r0)
            r1.reset()
            com.umeng.message.proguard.ee.a(r0, r1)
        L_0x00b2:
            java.lang.String r0 = r1.toString()
            com.umeng.message.proguard.q r1 = com.umeng.message.proguard.q.a()
            boolean r1 = r1.f16014a
            if (r1 == 0) goto L_0x010a
            r1 = 4
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r8 = "req: "
            r5[r3] = r8
            r5[r4] = r13
            java.lang.String r13 = "\n"
            r8 = 2
            r5[r8] = r13
            r13 = 3
            r5[r13] = r12
            java.lang.String r12 = "Net"
            com.umeng.message.proguard.ce.a(r12, r5)
            if (r2 != r14) goto L_0x00ef
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r0)
            java.lang.String r9 = "imp"
            r5.remove(r9)
            java.lang.String r9 = "clk"
            r5.remove(r9)
            java.lang.String r9 = "al"
            r5.remove(r9)
            java.lang.String r5 = r5.toString()
            goto L_0x00f0
        L_0x00ef:
            r5 = r0
        L_0x00f0:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r9 = "resp:\n"
            r1[r3] = r9
            r1[r4] = r5
            java.lang.String r3 = "\nconsume:"
            r1[r8] = r3
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r3 = r3 - r6
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r1[r13] = r3
            com.umeng.message.proguard.ce.a(r12, r1)
        L_0x010a:
            if (r2 != r14) goto L_0x0112
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>(r0)
            return r12
        L_0x0112:
            java.lang.Exception r12 = new java.lang.Exception
            java.lang.String r13 = "response code "
            java.lang.String r14 = java.lang.String.valueOf(r2)
            java.lang.String r13 = r13.concat(r14)
            r12.<init>(r13)
            throw r12
        L_0x0122:
            r12 = move-exception
            r13 = r5
            r5 = r14
            goto L_0x012c
        L_0x0126:
            r12 = move-exception
            r13 = r5
            goto L_0x012c
        L_0x0129:
            r12 = move-exception
            r13 = r5
            r8 = r13
        L_0x012c:
            com.umeng.message.proguard.eb.a(r5)
            com.umeng.message.proguard.eb.a(r13)
            if (r8 == 0) goto L_0x0137
            r8.disconnect()     // Catch:{ all -> 0x0137 }
        L_0x0137:
            throw r12
        L_0x0138:
            r12 = move-exception
            com.umeng.message.proguard.eb.a(r6)
            goto L_0x013e
        L_0x013d:
            throw r12
        L_0x013e:
            goto L_0x013d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cc.a(org.json.JSONObject, java.lang.String, java.lang.String):org.json.JSONObject");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(2:8|9)(1:10)|11|12|13|14|15|(2:(1:18)|19)(2:(2:21|30)|31)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005a */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(int r20, com.umeng.message.proguard.ck r21, java.lang.String r22) {
        /*
            r1 = r20
            r2 = r21
            java.lang.String r3 = " consume:"
            java.lang.String r4 = " host:"
            java.lang.String r5 = "Net"
            boolean r0 = android.text.TextUtils.isEmpty(r22)
            r6 = 1
            if (r0 == 0) goto L_0x0012
            return r6
        L_0x0012:
            long r7 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r9 = "unknown"
            r12 = 3
            r13 = 2
            r14 = 6
            r15 = 0
            r17 = -1
            r0 = r22
            java.lang.String r0 = com.umeng.message.proguard.dy.a((java.lang.String) r0, (com.umeng.message.proguard.ck) r2)     // Catch:{ all -> 0x00a1 }
            java.net.URL r10 = new java.net.URL     // Catch:{ all -> 0x00a1 }
            r10.<init>(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.String r9 = r10.getHost()     // Catch:{ all -> 0x00a1 }
            java.net.URLConnection r0 = r10.openConnection()     // Catch:{ all -> 0x00a1 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00a1 }
            java.lang.String r10 = "GET"
            r0.setRequestMethod(r10)     // Catch:{ all -> 0x00a1 }
            r10 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r10)     // Catch:{ all -> 0x00a1 }
            r0.setReadTimeout(r10)     // Catch:{ all -> 0x00a1 }
            int r10 = r0.getResponseCode()     // Catch:{ all -> 0x00a1 }
            r11 = 400(0x190, float:5.6E-43)
            if (r10 >= r11) goto L_0x0050
            java.io.InputStream r11 = r0.getInputStream()     // Catch:{ all -> 0x009f }
            com.umeng.message.proguard.eb.a(r11)     // Catch:{ all -> 0x009f }
            goto L_0x0057
        L_0x0050:
            java.io.InputStream r11 = r0.getErrorStream()     // Catch:{ all -> 0x009f }
            com.umeng.message.proguard.eb.a(r11)     // Catch:{ all -> 0x009f }
        L_0x0057:
            r0.disconnect()     // Catch:{ all -> 0x005a }
        L_0x005a:
            java.lang.Object[] r0 = new java.lang.Object[r14]     // Catch:{ all -> 0x009f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x009f }
            r0[r15] = r11     // Catch:{ all -> 0x009f }
            java.lang.String r11 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x009f }
            java.lang.String r11 = r4.concat(r11)     // Catch:{ all -> 0x009f }
            r0[r6] = r11     // Catch:{ all -> 0x009f }
            java.lang.String r11 = " code:"
            r0[r13] = r11     // Catch:{ all -> 0x009f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x009f }
            r0[r12] = r11     // Catch:{ all -> 0x009f }
            r11 = 4
            r0[r11] = r3     // Catch:{ all -> 0x009f }
            long r18 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x009f }
            long r18 = r18 - r7
            java.lang.Long r11 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x009f }
            r16 = 5
            r0[r16] = r11     // Catch:{ all -> 0x009f }
            com.umeng.message.proguard.ce.a(r5, r0)     // Catch:{ all -> 0x009f }
            r3 = 200(0xc8, float:2.8E-43)
            if (r10 != r3) goto L_0x0098
            if (r10 == r3) goto L_0x0097
            com.umeng.message.proguard.cq r0 = com.umeng.message.proguard.cr.a()
            r0.a(r2, r1, r10, r9)
        L_0x0097:
            return r6
        L_0x0098:
            if (r10 == r3) goto L_0x00dc
            com.umeng.message.proguard.cq r0 = com.umeng.message.proguard.cr.a()
            goto L_0x00d9
        L_0x009f:
            r0 = move-exception
            goto L_0x00a3
        L_0x00a1:
            r0 = move-exception
            r10 = -1
        L_0x00a3:
            java.lang.Object[] r11 = new java.lang.Object[r14]     // Catch:{ all -> 0x00dd }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x00dd }
            r11[r15] = r14     // Catch:{ all -> 0x00dd }
            java.lang.String r14 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = r4.concat(r14)     // Catch:{ all -> 0x00dd }
            r11[r6] = r4     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = " error:"
            r11[r13] = r4     // Catch:{ all -> 0x00dd }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00dd }
            r11[r12] = r0     // Catch:{ all -> 0x00dd }
            r4 = 4
            r11[r4] = r3     // Catch:{ all -> 0x00dd }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00dd }
            long r3 = r3 - r7
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00dd }
            r3 = 5
            r11[r3] = r0     // Catch:{ all -> 0x00dd }
            com.umeng.message.proguard.ce.a(r5, r11)     // Catch:{ all -> 0x00dd }
            r3 = 200(0xc8, float:2.8E-43)
            if (r10 == r3) goto L_0x00dc
            com.umeng.message.proguard.cq r0 = com.umeng.message.proguard.cr.a()
        L_0x00d9:
            r0.a(r2, r1, r10, r9)
        L_0x00dc:
            return r15
        L_0x00dd:
            r0 = move-exception
            r3 = 200(0xc8, float:2.8E-43)
            if (r10 == r3) goto L_0x00e9
            com.umeng.message.proguard.cq r3 = com.umeng.message.proguard.cr.a()
            r3.a(r2, r1, r10, r9)
        L_0x00e9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cc.a(int, com.umeng.message.proguard.ck, java.lang.String):boolean");
    }

    public static boolean a(String str) {
        boolean z10;
        OutputStream outputStream;
        boolean z11;
        String optString;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = "unknown";
        try {
            URL url = new URL(str);
            str2 = url.getHost();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            httpURLConnection.setDoOutput(true);
            JSONObject jSONObject = new JSONObject();
            Context a10 = de.a();
            try {
                jSONObject.put("oaid", ca.c(a10));
                jSONObject.put("idfa", ca.a(a10));
            } catch (Throwable unused) {
            }
            jSONObject.put("imei_md5", ca.f(a10));
            jSONObject.put("android_id", ca.b(a10));
            jSONObject.put("device_token", UMUtils.getDeviceToken(a10));
            jSONObject.put(bt.al, UMUtils.getZid(a10));
            String jSONObject2 = jSONObject.toString();
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(jSONObject2.getBytes(XML.CHARSET_UTF8));
            eb.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[512];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    eb.a(byteArrayOutputStream);
                    String str3 = new String(byteArray);
                    ce.b("Net", "pre check host:", str2, " resp:\n", str3);
                    JSONObject optJSONObject = new JSONObject(str3).optJSONObject("data");
                    if (optJSONObject != null) {
                        z11 = optJSONObject.optBoolean("allow", true);
                        try {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("activity_deny");
                            if (optJSONArray != null) {
                                int length = optJSONArray.length();
                                ArrayList arrayList = new ArrayList(length);
                                for (int i10 = 0; i10 < length; i10++) {
                                    optString = optJSONArray.optString(i10);
                                    if (!TextUtils.isEmpty(optString)) {
                                        arrayList.add(Class.forName(optString));
                                    }
                                }
                                df unused2 = df.a.f15749a;
                                dt.a().a((List<Class<? extends Activity>>) arrayList);
                            }
                        } catch (Throwable th) {
                            th = th;
                            eb.a(inputStream);
                            throw th;
                        }
                    } else {
                        z11 = true;
                    }
                    eb.a(inputStream);
                    z10 = z11;
                } catch (Throwable th2) {
                    th = th2;
                    z10 = z11;
                    ce.b("Net", "pre check host:".concat(String.valueOf(str2)), " error:", th.getMessage(), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    return z10;
                }
            } else {
                z10 = true;
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
            try {
                ce.b("Net", "pre check host:".concat(String.valueOf(str2)), " code:", Integer.valueOf(responseCode), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            z10 = true;
            ce.b("Net", "pre check host:".concat(String.valueOf(str2)), " error:", th.getMessage(), " consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            return z10;
        }
        return z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b A[SYNTHETIC, Splitter:B:31:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.Context r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "image download consume:"
            java.lang.String r1 = "Net"
            long r2 = android.os.SystemClock.elapsedRealtime()
            r4 = 0
            r5 = 2
            r6 = 1
            r7 = 0
            java.net.URL r8 = new java.net.URL     // Catch:{ all -> 0x0074 }
            r8.<init>(r13)     // Catch:{ all -> 0x0074 }
            java.net.URLConnection r13 = r8.openConnection()     // Catch:{ all -> 0x0074 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ all -> 0x0074 }
            r8 = 30000(0x7530, float:4.2039E-41)
            r13.setConnectTimeout(r8)     // Catch:{ all -> 0x0071 }
            r13.setReadTimeout(r8)     // Catch:{ all -> 0x0071 }
            java.io.InputStream r8 = r13.getInputStream()     // Catch:{ all -> 0x0071 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r8)     // Catch:{ all -> 0x006f }
            if (r9 == 0) goto L_0x0056
            android.graphics.Point r12 = com.umeng.message.proguard.ed.a((android.content.Context) r12)     // Catch:{ all -> 0x006f }
            int r10 = r12.x     // Catch:{ all -> 0x006f }
            int r12 = r12.y     // Catch:{ all -> 0x006f }
            int r12 = java.lang.Math.min(r10, r12)     // Catch:{ all -> 0x006f }
            int r10 = r9.getWidth()     // Catch:{ all -> 0x006f }
            if (r10 <= r12) goto L_0x0055
            int r10 = r9.getHeight()     // Catch:{ all -> 0x006f }
            if (r10 <= 0) goto L_0x0055
            int r10 = r9.getHeight()     // Catch:{ all -> 0x006f }
            int r10 = r10 * r12
            int r11 = r9.getWidth()     // Catch:{ all -> 0x006f }
            int r10 = r10 / r11
            android.graphics.Bitmap r12 = android.graphics.Bitmap.createScaledBitmap(r9, r12, r10, r6)     // Catch:{ all -> 0x006f }
            r9.recycle()     // Catch:{ all -> 0x006f }
            r7 = r12
            goto L_0x0056
        L_0x0055:
            r7 = r9
        L_0x0056:
            com.umeng.message.proguard.eb.a(r8)
            r13.disconnect()     // Catch:{ all -> 0x005c }
        L_0x005c:
            java.lang.Object[] r12 = new java.lang.Object[r5]
            r12[r4] = r0
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r4 - r2
            java.lang.Long r13 = java.lang.Long.valueOf(r4)
            r12[r6] = r13
            com.umeng.message.proguard.ce.b(r1, r12)
            return r7
        L_0x006f:
            r12 = move-exception
            goto L_0x0077
        L_0x0071:
            r12 = move-exception
            r8 = r7
            goto L_0x0077
        L_0x0074:
            r12 = move-exception
            r13 = r7
            r8 = r13
        L_0x0077:
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x00a1 }
            java.lang.String r10 = "image download error:"
            r9[r4] = r10     // Catch:{ all -> 0x00a1 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x00a1 }
            r9[r6] = r12     // Catch:{ all -> 0x00a1 }
            com.umeng.message.proguard.ce.d(r1, r9)     // Catch:{ all -> 0x00a1 }
            com.umeng.message.proguard.eb.a(r8)
            if (r13 == 0) goto L_0x008e
            r13.disconnect()     // Catch:{ all -> 0x008e }
        L_0x008e:
            java.lang.Object[] r12 = new java.lang.Object[r5]
            r12[r4] = r0
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r4 - r2
            java.lang.Long r13 = java.lang.Long.valueOf(r4)
            r12[r6] = r13
            com.umeng.message.proguard.ce.b(r1, r12)
            return r7
        L_0x00a1:
            r12 = move-exception
            com.umeng.message.proguard.eb.a(r8)
            if (r13 == 0) goto L_0x00aa
            r13.disconnect()     // Catch:{ all -> 0x00aa }
        L_0x00aa:
            java.lang.Object[] r13 = new java.lang.Object[r5]
            r13[r4] = r0
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r4 = r4 - r2
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            r13[r6] = r0
            com.umeng.message.proguard.ce.b(r1, r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cc.a(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }
}
