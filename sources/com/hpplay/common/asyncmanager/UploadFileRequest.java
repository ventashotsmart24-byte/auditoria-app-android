package com.hpplay.common.asyncmanager;

import java.util.Map;

public class UploadFileRequest {
    private final String TAG = "UploadFileRequest";
    private HttpMethod httpMethod;
    private Map<String, String> mHeadParameter;
    private String[] mLocalPath;
    private String mURL;

    public UploadFileRequest(String str, String[] strArr, Map<String, String> map, HttpMethod httpMethod2) {
        this.mLocalPath = strArr;
        this.mURL = str;
        this.mHeadParameter = map;
        this.httpMethod = httpMethod2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0234 A[SYNTHETIC, Splitter:B:128:0x0234] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x023f A[SYNTHETIC, Splitter:B:133:0x023f] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x024a A[SYNTHETIC, Splitter:B:138:0x024a] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0255 A[SYNTHETIC, Splitter:B:143:0x0255] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0260 A[SYNTHETIC, Splitter:B:148:0x0260] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0271 A[SYNTHETIC, Splitter:B:156:0x0271] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x027c A[SYNTHETIC, Splitter:B:161:0x027c] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0287 A[SYNTHETIC, Splitter:B:166:0x0287] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0292 A[SYNTHETIC, Splitter:B:171:0x0292] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x029d A[SYNTHETIC, Splitter:B:176:0x029d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String uploadFile() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "UploadFileRequest"
            java.lang.String r0 = "--"
            java.lang.String r3 = "*****"
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r7 = r1.mURL     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.net.HttpURLConnection r6 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r6)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r7 = 1
            r6.setDoInput(r7)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r6.setDoOutput(r7)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r8 = 0
            r6.setUseCaches(r8)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r9 = "POST"
            r6.setRequestMethod(r9)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            com.hpplay.common.asyncmanager.HttpMethod r9 = r1.httpMethod     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            if (r9 == 0) goto L_0x0033
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r6.setRequestMethod(r9)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
        L_0x0033:
            java.lang.String r9 = "Connection"
            java.lang.String r10 = "Keep-Alive"
            r6.setRequestProperty(r9, r10)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r9 = "Charset"
            java.lang.String r10 = "UTF-8"
            r6.setRequestProperty(r9, r10)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r9 = "Content-Type"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r10.<init>()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r11 = "multipart/form-data;boundary="
            r10.append(r11)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r10.append(r3)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r6.setRequestProperty(r9, r10)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.util.Map<java.lang.String, java.lang.String> r9 = r1.mHeadParameter     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            if (r9 == 0) goto L_0x0087
            int r9 = r9.size()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            if (r9 <= 0) goto L_0x0087
            java.util.Map<java.lang.String, java.lang.String> r9 = r1.mHeadParameter     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
        L_0x006b:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            if (r10 == 0) goto L_0x0087
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r6.setRequestProperty(r11, r10)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            goto L_0x006b
        L_0x0087:
            java.io.DataOutputStream r9 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            java.io.OutputStream r10 = r6.getOutputStream()     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0228, all -> 0x0220 }
            r10 = 0
            r11 = 0
        L_0x0092:
            java.lang.String[] r12 = r1.mLocalPath     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            int r13 = r12.length     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            if (r10 >= r13) goto L_0x010a
            r12 = r12[r10]     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r13 = "//"
            int r13 = r12.lastIndexOf(r13)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            int r13 = r13 + r7
            java.lang.String r13 = r12.substring(r13)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r14 = "\r\n"
            if (r10 <= 0) goto L_0x00e4
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.<init>()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.append(r0)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.append(r3)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.append(r14)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r9.writeBytes(r15)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.<init>()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r5 = "Content-Disposition: form-data; name=\"file"
            r15.append(r5)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.append(r10)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r5 = "\";filename=\""
            r15.append(r5)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.append(r13)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r5 = "\""
            r15.append(r5)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r15.append(r14)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r5 = r15.toString()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r9.writeBytes(r5)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r9.writeBytes(r14)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
        L_0x00e4:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r11 = 1024(0x400, float:1.435E-42)
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
        L_0x00ed:
            int r12 = r5.read(r11)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            r13 = -1
            if (r12 == r13) goto L_0x00f8
            r9.write(r11, r8, r12)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            goto L_0x00ed
        L_0x00f8:
            r9.writeBytes(r14)     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            r5.close()     // Catch:{ Exception -> 0x0106, all -> 0x0102 }
            int r10 = r10 + 1
            r11 = r5
            goto L_0x0092
        L_0x0102:
            r11 = r5
            goto L_0x0217
        L_0x0106:
            r0 = move-exception
            r11 = r5
            goto L_0x021c
        L_0x010a:
            r9.flush()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            int r0 = r6.getResponseCode()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r3 = 300(0x12c, float:4.2E-43)
            if (r0 < r3) goto L_0x0154
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r3.<init>()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r5 = "HTTP Request is not success, Response code is "
            r3.append(r5)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            int r5 = r6.getResponseCode()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r3.append(r5)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            r3.<init>()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            r4.<init>()     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            java.lang.String r5 = "code"
            r4.put(r5, r0)     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            java.lang.String r5 = "msg"
            java.lang.String r7 = ""
            r4.put(r5, r7)     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            r3.append(r4)     // Catch:{ Exception -> 0x0150, all -> 0x014c }
            r4 = r3
            goto L_0x0154
        L_0x014c:
            r4 = r3
            goto L_0x0217
        L_0x0150:
            r0 = move-exception
            r4 = r3
            goto L_0x021c
        L_0x0154:
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x01af
            java.io.InputStream r3 = r6.getInputStream()     // Catch:{ Exception -> 0x021b, all -> 0x0216 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x01a9, all -> 0x01a3 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x01a9, all -> 0x01a3 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x019d, all -> 0x0197 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x019d, all -> 0x0197 }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0190, all -> 0x0189 }
            r7.<init>()     // Catch:{ Exception -> 0x0190, all -> 0x0189 }
        L_0x016b:
            java.lang.String r0 = r6.readLine()     // Catch:{ Exception -> 0x0184, all -> 0x017f }
            if (r0 == 0) goto L_0x017a
            r7.append(r0)     // Catch:{ Exception -> 0x0184, all -> 0x017f }
            java.lang.String r0 = "\n"
            r7.append(r0)     // Catch:{ Exception -> 0x0184, all -> 0x017f }
            goto L_0x016b
        L_0x017a:
            r16 = r5
            r5 = r6
            r4 = r7
            goto L_0x01b3
        L_0x017f:
            r16 = r6
            r4 = r7
            goto L_0x018c
        L_0x0184:
            r0 = move-exception
            r16 = r6
            r4 = r7
            goto L_0x0193
        L_0x0189:
            r16 = r6
        L_0x018c:
            r6 = r3
            r3 = r5
            goto L_0x020b
        L_0x0190:
            r0 = move-exception
            r16 = r6
        L_0x0193:
            r6 = r3
            r3 = r5
            goto L_0x0214
        L_0x0197:
            r6 = r3
            r3 = r5
            r5 = r9
            goto L_0x0225
        L_0x019d:
            r0 = move-exception
            r6 = r3
            r3 = r5
            r5 = r9
            goto L_0x022d
        L_0x01a3:
            r6 = r3
            r5 = r9
            r3 = 0
            goto L_0x0225
        L_0x01a9:
            r0 = move-exception
            r6 = r3
            r5 = r9
            r3 = 0
            goto L_0x022d
        L_0x01af:
            r3 = 0
            r5 = 0
            r16 = 0
        L_0x01b3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            r0.<init>()     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            java.lang.String r6 = "resultBuffer ="
            r0.append(r6)     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            r0.append(r6)     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x020e, all -> 0x0205 }
            r9.close()     // Catch:{ Exception -> 0x01cf }
            goto L_0x01d4
        L_0x01cf:
            r0 = move-exception
            r6 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r6)
        L_0x01d4:
            if (r5 == 0) goto L_0x01df
            r5.close()     // Catch:{ IOException -> 0x01da }
            goto L_0x01df
        L_0x01da:
            r0 = move-exception
            r5 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x01df:
            if (r16 == 0) goto L_0x01ea
            r16.close()     // Catch:{ IOException -> 0x01e5 }
            goto L_0x01ea
        L_0x01e5:
            r0 = move-exception
            r5 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x01ea:
            if (r3 == 0) goto L_0x01f5
            r3.close()     // Catch:{ IOException -> 0x01f0 }
            goto L_0x01f5
        L_0x01f0:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x01f5:
            if (r11 == 0) goto L_0x0200
            r11.close()     // Catch:{ Exception -> 0x01fb }
            goto L_0x0200
        L_0x01fb:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x0200:
            java.lang.String r0 = r4.toString()
            return r0
        L_0x0205:
            r6 = r3
            r3 = r16
            r16 = r5
        L_0x020b:
            r5 = r9
            goto L_0x026f
        L_0x020e:
            r0 = move-exception
            r6 = r3
            r3 = r16
            r16 = r5
        L_0x0214:
            r5 = r9
            goto L_0x022f
        L_0x0216:
        L_0x0217:
            r5 = r9
            r3 = 0
            r6 = 0
            goto L_0x0225
        L_0x021b:
            r0 = move-exception
        L_0x021c:
            r5 = r9
            r3 = 0
            r6 = 0
            goto L_0x022d
        L_0x0220:
            r3 = 0
            r5 = 0
            r6 = 0
            r11 = 0
        L_0x0225:
            r16 = 0
            goto L_0x026f
        L_0x0228:
            r0 = move-exception
            r3 = 0
            r5 = 0
            r6 = 0
            r11 = 0
        L_0x022d:
            r16 = 0
        L_0x022f:
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x026e }
            if (r5 == 0) goto L_0x023d
            r5.close()     // Catch:{ Exception -> 0x0238 }
            goto L_0x023d
        L_0x0238:
            r0 = move-exception
            r5 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x023d:
            if (r16 == 0) goto L_0x0248
            r16.close()     // Catch:{ IOException -> 0x0243 }
            goto L_0x0248
        L_0x0243:
            r0 = move-exception
            r5 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x0248:
            if (r3 == 0) goto L_0x0253
            r3.close()     // Catch:{ IOException -> 0x024e }
            goto L_0x0253
        L_0x024e:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x0253:
            if (r6 == 0) goto L_0x025e
            r6.close()     // Catch:{ IOException -> 0x0259 }
            goto L_0x025e
        L_0x0259:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x025e:
            if (r11 == 0) goto L_0x0269
            r11.close()     // Catch:{ Exception -> 0x0264 }
            goto L_0x0269
        L_0x0264:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x0269:
            java.lang.String r0 = r4.toString()
            return r0
        L_0x026e:
        L_0x026f:
            if (r5 == 0) goto L_0x027a
            r5.close()     // Catch:{ Exception -> 0x0275 }
            goto L_0x027a
        L_0x0275:
            r0 = move-exception
            r5 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x027a:
            if (r16 == 0) goto L_0x0285
            r16.close()     // Catch:{ IOException -> 0x0280 }
            goto L_0x0285
        L_0x0280:
            r0 = move-exception
            r5 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x0285:
            if (r3 == 0) goto L_0x0290
            r3.close()     // Catch:{ IOException -> 0x028b }
            goto L_0x0290
        L_0x028b:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x0290:
            if (r6 == 0) goto L_0x029b
            r6.close()     // Catch:{ IOException -> 0x0296 }
            goto L_0x029b
        L_0x0296:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x029b:
            if (r11 == 0) goto L_0x02a6
            r11.close()     // Catch:{ Exception -> 0x02a1 }
            goto L_0x02a6
        L_0x02a1:
            r0 = move-exception
            r3 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r2, (java.lang.Throwable) r3)
        L_0x02a6:
            java.lang.String r0 = r4.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.asyncmanager.UploadFileRequest.uploadFile():java.lang.String");
    }
}
