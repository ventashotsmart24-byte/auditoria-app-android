package com.umeng.ut.a.b;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static d f16219a = null;

    /* renamed from: a  reason: collision with other field name */
    private static e f59a = null;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v21, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r10v4, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r10v6, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r3v39 */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01dc, code lost:
        r2 = r0;
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01df, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01e0, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0206, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0207, code lost:
        com.umeng.ut.a.c.e.a("", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0229 A[SYNTHETIC, Splitter:B:109:0x0229] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0239 A[SYNTHETIC, Splitter:B:115:0x0239] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01db A[ExcHandler: all (r0v27 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r10 
      PHI: (r10v5 ?) = (r10v4 ?), (r10v6 ?) binds: [B:91:0x01f6, B:71:0x01c1] A[DONT_GENERATE, DONT_INLINE], Splitter:B:71:0x01c1] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01fe A[Catch:{ Exception -> 0x021c, all -> 0x01db }, LOOP:1: B:93:0x01f8->B:95:0x01fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0202 A[EDGE_INSN: B:96:0x0202->B:97:? ?: BREAK  , SYNTHETIC, Splitter:B:96:0x0202] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umeng.ut.a.b.a a(java.lang.String r19, java.lang.String r20, boolean r21) {
        /*
            r0 = r20
            java.lang.String r1 = ""
            com.umeng.ut.a.b.a r2 = new com.umeng.ut.a.b.a
            r2.<init>()
            boolean r3 = android.text.TextUtils.isEmpty(r19)
            if (r3 == 0) goto L_0x0010
            return r2
        L_0x0010:
            com.umeng.ut.a.a r3 = com.umeng.ut.a.a.a()
            android.content.Context r3 = r3.a()
            java.lang.String r4 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r3)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0023
            return r2
        L_0x0023:
            r5 = 0
            java.net.URL r6 = new java.net.URL     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            r7 = r19
            r6.<init>(r7)     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            java.lang.String r7 = r6.getHost()     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            if (r7 == 0) goto L_0x0036
            return r2
        L_0x0036:
            java.net.URLConnection r7 = r6.openConnection()     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            boolean r8 = r7 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            if (r8 == 0) goto L_0x006e
            com.umeng.ut.a.b.e r8 = f59a     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            if (r8 != 0) goto L_0x004f
            com.umeng.ut.a.b.e r8 = new com.umeng.ut.a.b.e     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            java.lang.String r9 = r6.getHost()     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            r8.<init>(r9)     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            f59a = r8     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
        L_0x004f:
            com.umeng.ut.a.b.d r8 = f16219a     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            if (r8 != 0) goto L_0x005e
            com.umeng.ut.a.b.d r8 = new com.umeng.ut.a.b.d     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            java.lang.String r6 = r6.getHost()     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            r8.<init>(r6)     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            f16219a = r8     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
        L_0x005e:
            r6 = r7
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            com.umeng.ut.a.b.e r8 = f59a     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            r6.setSSLSocketFactory(r8)     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            r6 = r7
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            com.umeng.ut.a.b.d r8 = f16219a     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
            r6.setHostnameVerifier(r8)     // Catch:{ MalformedURLException -> 0x028d, IOException -> 0x0286, all -> 0x027f }
        L_0x006e:
            if (r7 == 0) goto L_0x027e
            r6 = 1
            r7.setDoInput(r6)
            if (r21 == 0) goto L_0x0086
            r7.setDoOutput(r6)
            java.lang.String r8 = "POST"
            r7.setRequestMethod(r8)     // Catch:{ ProtocolException -> 0x007f }
            goto L_0x008b
        L_0x007f:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.umeng.ut.a.c.e.a(r1, r0, r3)
            return r2
        L_0x0086:
            java.lang.String r8 = "GET"
            r7.setRequestMethod(r8)     // Catch:{ ProtocolException -> 0x0278 }
        L_0x008b:
            r7.setUseCaches(r5)
            r8 = 10000(0x2710, float:1.4013E-41)
            r7.setConnectTimeout(r8)
            r7.setReadTimeout(r8)
            r7.setInstanceFollowRedirects(r6)
            java.lang.String r8 = "Content-Type"
            java.lang.String r9 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r8, r9)
            java.lang.String r8 = "Charset"
            java.lang.String r9 = "UTF-8"
            r7.setRequestProperty(r8, r9)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "x-audid-appkey"
            r7.setRequestProperty(r10, r4)
            r8.append(r4)
            java.lang.String r3 = r3.getPackageName()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x00ca
            java.lang.String r4 = "x-audid-appname"
            java.lang.String r9 = java.net.URLEncoder.encode(r3, r9)     // Catch:{ Exception -> 0x00ca }
            r7.setRequestProperty(r4, r9)     // Catch:{ Exception -> 0x00ca }
            r8.append(r3)     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            java.lang.String r3 = "x-audid-sdk"
            java.lang.String r4 = "1.0.0"
            r7.setRequestProperty(r3, r4)
            r8.append(r4)
            com.umeng.ut.a.a r3 = com.umeng.ut.a.a.a()
            java.lang.String r3 = r3.a()
            java.lang.String r4 = "x-audid-timestamp"
            r7.setRequestProperty(r4, r3)
            java.lang.Object[] r9 = new java.lang.Object[r6]
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "timestamp:"
            r10.append(r11)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            r9[r5] = r10
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r9)
            r8.append(r3)
            r8.append(r0)
            java.lang.String r3 = r8.toString()
            java.lang.String r3 = com.umeng.ut.a.c.b.c(r3)
            byte[] r3 = r3.getBytes()
            r8 = 2
            java.lang.String r3 = com.umeng.ut.b.a.a.a.a((byte[]) r3, (int) r8)
            java.lang.String r8 = "signature"
            r7.setRequestProperty(r8, r3)
            long r9 = java.lang.System.currentTimeMillis()
            r3 = 0
            r7.connect()     // Catch:{ all -> 0x0247 }
            if (r0 == 0) goto L_0x0139
            int r11 = r20.length()     // Catch:{ all -> 0x0247 }
            if (r11 <= 0) goto L_0x0139
            java.io.DataOutputStream r11 = new java.io.DataOutputStream     // Catch:{ all -> 0x0247 }
            java.io.OutputStream r12 = r7.getOutputStream()     // Catch:{ all -> 0x0247 }
            r11.<init>(r12)     // Catch:{ all -> 0x0247 }
            r11.writeBytes(r0)     // Catch:{ all -> 0x0135 }
            r11.flush()     // Catch:{ all -> 0x0135 }
            goto L_0x013a
        L_0x0135:
            r0 = move-exception
            r3 = r11
            goto L_0x0248
        L_0x0139:
            r11 = r3
        L_0x013a:
            if (r11 == 0) goto L_0x0149
            r11.close()     // Catch:{ IOException -> 0x0140 }
            goto L_0x0149
        L_0x0140:
            r0 = move-exception
            r11 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r11
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x0149:
            int r0 = r7.getResponseCode()     // Catch:{ Exception -> 0x0156 }
            r2.f16217a = r0     // Catch:{ Exception -> 0x0156 }
            java.lang.String r0 = r7.getHeaderField(r8)     // Catch:{ Exception -> 0x0156 }
            r2.signature = r0     // Catch:{ Exception -> 0x0156 }
            goto L_0x015e
        L_0x0156:
            r0 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r5] = r0
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r8)
        L_0x015e:
            java.lang.String r0 = r7.getHeaderField(r4)     // Catch:{ Exception -> 0x01a9 }
            long r11 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x01a9 }
            r2.timestamp = r11     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r0 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x01a9 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r4.<init>()     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = "repsonse.timestamp:"
            r4.append(r8)     // Catch:{ Exception -> 0x01a9 }
            long r11 = r2.timestamp     // Catch:{ Exception -> 0x01a9 }
            r4.append(r11)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x01a9 }
            r0[r5] = r4     // Catch:{ Exception -> 0x01a9 }
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)     // Catch:{ Exception -> 0x01a9 }
            com.umeng.ut.a.a r0 = com.umeng.ut.a.a.a()     // Catch:{ Exception -> 0x01a9 }
            long r11 = r0.a()     // Catch:{ Exception -> 0x01a9 }
            long r13 = r2.timestamp     // Catch:{ Exception -> 0x01a9 }
            r15 = 0
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x01a9
            r15 = 1800000(0x1b7740, double:8.89318E-318)
            long r17 = r11 + r15
            int r0 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r0 > 0) goto L_0x01a0
            long r11 = r11 - r15
            int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a9
        L_0x01a0:
            com.umeng.ut.a.a r0 = com.umeng.ut.a.a.a()     // Catch:{ Exception -> 0x01a9 }
            long r11 = r2.timestamp     // Catch:{ Exception -> 0x01a9 }
            r0.a((long) r11)     // Catch:{ Exception -> 0x01a9 }
        L_0x01a9:
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 - r9
            r2.f16218b = r11
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            r8 = -1
            r9 = 2048(0x800, float:2.87E-42)
            java.io.DataInputStream r10 = new java.io.DataInputStream     // Catch:{ IOException -> 0x01e5 }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ IOException -> 0x01e5 }
            r10.<init>(r0)     // Catch:{ IOException -> 0x01e5 }
            byte[] r0 = new byte[r9]     // Catch:{ IOException -> 0x01df, all -> 0x01db }
        L_0x01c3:
            int r3 = r10.read(r0, r5, r9)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            if (r3 == r8) goto L_0x01cd
            r4.write(r0, r5, r3)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            goto L_0x01c3
        L_0x01cd:
            r10.close()     // Catch:{ Exception -> 0x01d1 }
            goto L_0x020f
        L_0x01d1:
            r0 = move-exception
            r3 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r3
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
            goto L_0x020f
        L_0x01db:
            r0 = move-exception
            r2 = r0
            r3 = r10
            goto L_0x0237
        L_0x01df:
            r0 = move-exception
            r3 = r10
            goto L_0x01e6
        L_0x01e2:
            r0 = move-exception
            r2 = r0
            goto L_0x0237
        L_0x01e5:
            r0 = move-exception
        L_0x01e6:
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x01e2 }
            r10[r5] = r0     // Catch:{ all -> 0x01e2 }
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r10)     // Catch:{ all -> 0x01e2 }
            java.io.DataInputStream r10 = new java.io.DataInputStream     // Catch:{ Exception -> 0x021f }
            java.io.InputStream r0 = r7.getErrorStream()     // Catch:{ Exception -> 0x021f }
            r10.<init>(r0)     // Catch:{ Exception -> 0x021f }
            byte[] r0 = new byte[r9]     // Catch:{ Exception -> 0x021c, all -> 0x01db }
        L_0x01f8:
            int r3 = r10.read(r0, r5, r9)     // Catch:{ Exception -> 0x021c, all -> 0x01db }
            if (r3 == r8) goto L_0x0202
            r4.write(r0, r5, r3)     // Catch:{ Exception -> 0x021c, all -> 0x01db }
            goto L_0x01f8
        L_0x0202:
            r10.close()     // Catch:{ Exception -> 0x0206 }
            goto L_0x020f
        L_0x0206:
            r0 = move-exception
            r3 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r3
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x020f:
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x027e
            byte[] r0 = r4.toByteArray()
            r2.data = r0
            goto L_0x027e
        L_0x021c:
            r0 = move-exception
            r3 = r10
            goto L_0x0220
        L_0x021f:
            r0 = move-exception
        L_0x0220:
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x01e2 }
            r4[r5] = r0     // Catch:{ all -> 0x01e2 }
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r4)     // Catch:{ all -> 0x01e2 }
            if (r3 == 0) goto L_0x0236
            r3.close()     // Catch:{ Exception -> 0x022d }
            goto L_0x0236
        L_0x022d:
            r0 = move-exception
            r3 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r3
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x0236:
            return r2
        L_0x0237:
            if (r3 == 0) goto L_0x0246
            r3.close()     // Catch:{ Exception -> 0x023d }
            goto L_0x0246
        L_0x023d:
            r0 = move-exception
            r3 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r3
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x0246:
            throw r2
        L_0x0247:
            r0 = move-exception
        L_0x0248:
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x0266 }
            r4[r5] = r0     // Catch:{ all -> 0x0266 }
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0266 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0266 }
            long r7 = r7 - r9
            r2.f16218b = r7     // Catch:{ all -> 0x0266 }
            if (r3 == 0) goto L_0x0265
            r3.close()     // Catch:{ IOException -> 0x025c }
            goto L_0x0265
        L_0x025c:
            r0 = move-exception
            r3 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r3
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x0265:
            return r2
        L_0x0266:
            r0 = move-exception
            r2 = r0
            if (r3 == 0) goto L_0x0277
            r3.close()     // Catch:{ IOException -> 0x026e }
            goto L_0x0277
        L_0x026e:
            r0 = move-exception
            r3 = r0
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r5] = r3
            com.umeng.ut.a.c.e.a((java.lang.String) r1, (java.lang.Object[]) r0)
        L_0x0277:
            throw r2
        L_0x0278:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.umeng.ut.a.c.e.a(r1, r0, r3)
        L_0x027e:
            return r2
        L_0x027f:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.umeng.ut.a.c.e.a(r1, r0, r3)
            return r2
        L_0x0286:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.umeng.ut.a.c.e.a(r1, r0, r3)
            return r2
        L_0x028d:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.umeng.ut.a.c.e.a(r1, r0, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ut.a.b.b.a(java.lang.String, java.lang.String, boolean):com.umeng.ut.a.b.a");
    }
}
