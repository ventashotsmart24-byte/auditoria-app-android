package com.uyumao;

import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class k {

    public static class a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ("yumao.puata.info".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00db, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<com.uyumao.k> r0 = com.uyumao.k.class
            monitor-enter(r0)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00de }
            r2.<init>(r7)     // Catch:{ Exception -> 0x00de }
            java.net.URLConnection r7 = r2.openConnection()     // Catch:{ Exception -> 0x00de }
            javax.net.ssl.HttpsURLConnection r7 = (javax.net.ssl.HttpsURLConnection) r7     // Catch:{ Exception -> 0x00de }
            com.uyumao.k$a r2 = new com.uyumao.k$a     // Catch:{ Exception -> 0x00de }
            r2.<init>()     // Catch:{ Exception -> 0x00de }
            r7.setHostnameVerifier(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "TLS"
            javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ Exception -> 0x00de }
            java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ Exception -> 0x00de }
            r3.<init>()     // Catch:{ Exception -> 0x00de }
            r2.init(r1, r1, r3)     // Catch:{ Exception -> 0x00de }
            javax.net.ssl.SSLSocketFactory r2 = r2.getSocketFactory()     // Catch:{ Exception -> 0x00de }
            r7.setSSLSocketFactory(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "appkey"
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r6)     // Catch:{ Exception -> 0x00de }
            r7.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r7.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00de }
            r2 = 30000(0x7530, float:4.2039E-41)
            r7.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00de }
            r7.setReadTimeout(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "POST"
            r7.setRequestMethod(r2)     // Catch:{ Exception -> 0x00de }
            r2 = 1
            r7.setDoOutput(r2)     // Catch:{ Exception -> 0x00de }
            r7.setDoInput(r2)     // Catch:{ Exception -> 0x00de }
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch:{ Exception -> 0x00de }
            byte[] r8 = r8.getBytes()     // Catch:{ Exception -> 0x00de }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0073 }
            r3.<init>()     // Catch:{ Exception -> 0x0073 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0073 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0073 }
            r4.write(r8)     // Catch:{ Exception -> 0x0073 }
            r4.close()     // Catch:{ Exception -> 0x0073 }
            byte[] r8 = r3.toByteArray()     // Catch:{ Exception -> 0x0073 }
            r3.flush()     // Catch:{ Exception -> 0x0073 }
            r3.close()     // Catch:{ Exception -> 0x0073 }
            goto L_0x0078
        L_0x0073:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ Exception -> 0x00de }
            r8 = r1
        L_0x0078:
            java.lang.String r3 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r6)     // Catch:{ Exception -> 0x00de }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x00de }
            byte[] r8 = a(r8, r3)     // Catch:{ Exception -> 0x00de }
            r2.write(r8)     // Catch:{ Exception -> 0x00de }
            r2.flush()     // Catch:{ Exception -> 0x00de }
            r2.close()     // Catch:{ Exception -> 0x00de }
            int r8 = r7.getResponseCode()     // Catch:{ Exception -> 0x00de }
            r2 = 200(0xc8, float:2.8E-43)
            if (r8 != r2) goto L_0x00e2
            java.io.InputStream r8 = r7.getInputStream()     // Catch:{ Exception -> 0x00de }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00de }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00de }
            r3.<init>()     // Catch:{ Exception -> 0x00de }
        L_0x00a2:
            int r4 = r8.read(r2)     // Catch:{ Exception -> 0x00de }
            r5 = -1
            if (r4 == r5) goto L_0x00ae
            r5 = 0
            r3.write(r2, r5, r4)     // Catch:{ Exception -> 0x00de }
            goto L_0x00a2
        L_0x00ae:
            java.lang.String r8 = "none"
            java.lang.String r7 = r7.getContentEncoding()     // Catch:{ Exception -> 0x00de }
            boolean r7 = r8.equals(r7)     // Catch:{ Exception -> 0x00de }
            if (r7 == 0) goto L_0x00c4
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x00de }
            byte[] r7 = r3.toByteArray()     // Catch:{ Exception -> 0x00de }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00de }
            goto L_0x00da
        L_0x00c4:
            byte[] r7 = r3.toByteArray()     // Catch:{ Exception -> 0x00de }
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r6)     // Catch:{ Exception -> 0x00de }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x00de }
            byte[] r6 = a(r7, r6)     // Catch:{ Exception -> 0x00de }
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x00de }
            r7.<init>(r6)     // Catch:{ Exception -> 0x00de }
            r6 = r7
        L_0x00da:
            monitor-exit(r0)
            return r6
        L_0x00dc:
            r6 = move-exception
            goto L_0x00e4
        L_0x00de:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00dc }
        L_0x00e2:
            monitor-exit(r0)
            return r1
        L_0x00e4:
            monitor-exit(r0)
            goto L_0x00e7
        L_0x00e6:
            throw r6
        L_0x00e7:
            goto L_0x00e6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.k.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0)) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] ^ bArr2[i10 % bArr2.length]) ^ (i10 & UnsignedBytes.MAX_VALUE));
            }
        }
        return bArr;
    }
}
