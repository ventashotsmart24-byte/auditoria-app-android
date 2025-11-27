package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.http.IHttpUtil;
import com.hpplay.cybergarage.http.HTTP;
import com.umeng.analytics.pro.by;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;

public final class a implements IHttpUtil {

    /* renamed from: com.efs.sdk.base.core.util.a.a$a  reason: collision with other inner class name */
    public static class C0076a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f5300a = new a((byte) 0);
    }

    private a() {
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a a() {
        return C0076a.f5300a;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                FileUtil.safeClose(httpURLConnection.getInputStream());
            } catch (Throwable unused) {
            }
        }
    }

    public final HttpResponse get(String str, Map<String, String> map) {
        HttpResponse httpResponse = new HttpResponse();
        int i10 = 0;
        while (true) {
            if (i10 >= 3) {
                break;
            }
            try {
                HttpURLConnection a10 = a(str, map);
                a10.setRequestMethod("GET");
                a10.setInstanceFollowRedirects(true);
                a10.setRequestProperty("Connection", HTTP.CLOSE);
                a10.connect();
                httpResponse = a(a10);
                b(a10);
                break;
            } catch (UnknownHostException e10) {
                httpResponse.setHttpCode(-2);
                Log.e("efs.util.http", "get request '" + str + "' error， maybe network is disconnect", e10);
            } catch (SocketTimeoutException e11) {
                httpResponse.setHttpCode(-3);
                Log.e("efs.util.http", "post file '" + str + "' error", e11);
            } catch (Throwable th) {
                b((HttpURLConnection) null);
                throw th;
            }
            i10++;
            b((HttpURLConnection) null);
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    public final HttpResponse post(String str, Map<String, String> map, File file) {
        return a(str, map, file, (byte[]) null);
    }

    public final HttpResponse postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return a(str, map, (File) null, bArr);
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(by.f13999b);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry next : map.entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        return httpURLConnection;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.efs.sdk.base.http.HttpResponse post(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, byte[] r9) {
        /*
            r6 = this;
            java.lang.String r0 = "' error"
            java.lang.String r1 = "efs.util.http"
            com.efs.sdk.base.http.HttpResponse r2 = new com.efs.sdk.base.http.HttpResponse
            r2.<init>()
            r3 = 0
            java.net.HttpURLConnection r8 = a(r7, r8)     // Catch:{ UnknownHostException -> 0x0064, SocketTimeoutException -> 0x0049, all -> 0x0032 }
            java.lang.String r4 = "POST"
            r8.setRequestMethod(r4)     // Catch:{ UnknownHostException -> 0x0030, SocketTimeoutException -> 0x002e, all -> 0x002c }
            java.lang.String r4 = "Connection"
            java.lang.String r5 = "close"
            r8.setRequestProperty(r4, r5)     // Catch:{ UnknownHostException -> 0x0030, SocketTimeoutException -> 0x002e, all -> 0x002c }
            java.io.OutputStream r3 = r8.getOutputStream()     // Catch:{ UnknownHostException -> 0x0030, SocketTimeoutException -> 0x002e, all -> 0x002c }
            r3.write(r9)     // Catch:{ UnknownHostException -> 0x0030, SocketTimeoutException -> 0x002e, all -> 0x002c }
            com.efs.sdk.base.http.HttpResponse r2 = a(r8)     // Catch:{ UnknownHostException -> 0x0030, SocketTimeoutException -> 0x002e, all -> 0x002c }
        L_0x0025:
            com.efs.sdk.base.core.util.FileUtil.safeClose(r3)
            b(r8)
            goto L_0x0081
        L_0x002c:
            r9 = move-exception
            goto L_0x0034
        L_0x002e:
            r9 = move-exception
            goto L_0x004b
        L_0x0030:
            r9 = move-exception
            goto L_0x0066
        L_0x0032:
            r9 = move-exception
            r8 = r3
        L_0x0034:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            java.lang.String r5 = "post data '"
            r4.<init>(r5)     // Catch:{ all -> 0x0085 }
            r4.append(r7)     // Catch:{ all -> 0x0085 }
            r4.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0085 }
            com.efs.sdk.base.core.util.Log.e(r1, r0, r9)     // Catch:{ all -> 0x0085 }
            goto L_0x0025
        L_0x0049:
            r9 = move-exception
            r8 = r3
        L_0x004b:
            r4 = -3
            r2.setHttpCode(r4)     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            java.lang.String r5 = "post file '"
            r4.<init>(r5)     // Catch:{ all -> 0x0085 }
            r4.append(r7)     // Catch:{ all -> 0x0085 }
            r4.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0085 }
            com.efs.sdk.base.core.util.Log.e(r1, r0, r9)     // Catch:{ all -> 0x0085 }
            goto L_0x0025
        L_0x0064:
            r9 = move-exception
            r8 = r3
        L_0x0066:
            r0 = -2
            r2.setHttpCode(r0)     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = "post data to '"
            r0.<init>(r4)     // Catch:{ all -> 0x0085 }
            r0.append(r7)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = "' error， maybe network is disconnect"
            r0.append(r4)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0085 }
            com.efs.sdk.base.core.util.Log.e(r1, r0, r9)     // Catch:{ all -> 0x0085 }
            goto L_0x0025
        L_0x0081:
            r2.setReqUrl(r7)
            return r2
        L_0x0085:
            r7 = move-exception
            com.efs.sdk.base.core.util.FileUtil.safeClose(r3)
            b(r8)
            goto L_0x008e
        L_0x008d:
            throw r7
        L_0x008e:
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.util.a.a.post(java.lang.String, java.util.Map, byte[]):com.efs.sdk.base.http.HttpResponse");
    }

    private static HttpResponse a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        HttpResponse httpResponse = new HttpResponse();
        if (httpURLConnection == null) {
            return httpResponse;
        }
        try {
            httpResponse.setHttpCode(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            Log.e("efs.util.http", "get response error", th);
                            FileUtil.safeClose(inputStream);
                            FileUtil.safeClose(byteArrayOutputStream);
                            return httpResponse;
                        } catch (Throwable th3) {
                            FileUtil.safeClose(inputStream);
                            FileUtil.safeClose(byteArrayOutputStream);
                            throw th3;
                        }
                    }
                }
                httpResponse.data = byteArrayOutputStream.toString();
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                Log.e("efs.util.http", "get response error", th);
                FileUtil.safeClose(inputStream);
                FileUtil.safeClose(byteArrayOutputStream);
                return httpResponse;
            }
        } catch (Throwable th5) {
            byteArrayOutputStream = null;
            th = th5;
            inputStream = null;
            Log.e("efs.util.http", "get response error", th);
            FileUtil.safeClose(inputStream);
            FileUtil.safeClose(byteArrayOutputStream);
            return httpResponse;
        }
        FileUtil.safeClose(inputStream);
        FileUtil.safeClose(byteArrayOutputStream);
        return httpResponse;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r13v25 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.efs.sdk.base.http.HttpResponse a(java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, java.io.File r12, byte[] r13) {
        /*
            java.lang.String r0 = "' error"
            java.lang.String r1 = "post file '"
            java.lang.String r2 = "efs.util.http"
            com.efs.sdk.base.http.HttpResponse r3 = new com.efs.sdk.base.http.HttpResponse
            r3.<init>()
            r4 = 0
            java.net.HttpURLConnection r11 = a(r10, r11)     // Catch:{ UnknownHostException -> 0x0112, SocketTimeoutException -> 0x00f7, all -> 0x00d4 }
            java.lang.String r5 = "POST"
            r11.setRequestMethod(r5)     // Catch:{ UnknownHostException -> 0x00ce, SocketTimeoutException -> 0x00c8, all -> 0x00c2 }
            java.lang.String r5 = "Connection"
            java.lang.String r6 = "close"
            r11.setRequestProperty(r5, r6)     // Catch:{ UnknownHostException -> 0x00ce, SocketTimeoutException -> 0x00c8, all -> 0x00c2 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb"
            r11.setRequestProperty(r5, r6)     // Catch:{ UnknownHostException -> 0x00ce, SocketTimeoutException -> 0x00c8, all -> 0x00c2 }
            java.io.OutputStream r5 = r11.getOutputStream()     // Catch:{ UnknownHostException -> 0x00ce, SocketTimeoutException -> 0x00c8, all -> 0x00c2 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ UnknownHostException -> 0x00be, SocketTimeoutException -> 0x00ba, all -> 0x00b6 }
            r6.<init>(r5)     // Catch:{ UnknownHostException -> 0x00be, SocketTimeoutException -> 0x00ba, all -> 0x00b6 }
            java.lang.String r7 = "------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n"
            r6.writeBytes(r7)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r7 = 0
            java.lang.String r8 = "\r\n"
            if (r13 != 0) goto L_0x0087
            if (r12 == 0) goto L_0x007a
            boolean r13 = r12.exists()     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            if (r13 != 0) goto L_0x003f
            goto L_0x007a
        L_0x003f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            java.lang.String r9 = "Content-Disposition: form-data;name=\"file\";filename=\""
            r13.<init>(r9)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            java.lang.String r9 = r12.getName()     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r13.append(r9)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            java.lang.String r9 = "\"\r\n"
            r13.append(r9)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            java.lang.String r13 = r13.toString()     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r6.writeBytes(r13)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r6.writeBytes(r8)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r13.<init>(r12)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r12 = 4096(0x1000, float:5.74E-42)
            byte[] r12 = new byte[r12]     // Catch:{ UnknownHostException -> 0x0077, SocketTimeoutException -> 0x0074, all -> 0x0072 }
        L_0x0065:
            int r4 = r13.read(r12)     // Catch:{ UnknownHostException -> 0x0077, SocketTimeoutException -> 0x0074, all -> 0x0072 }
            r9 = -1
            if (r4 == r9) goto L_0x0070
            r6.write(r12, r7, r4)     // Catch:{ UnknownHostException -> 0x0077, SocketTimeoutException -> 0x0074, all -> 0x0072 }
            goto L_0x0065
        L_0x0070:
            r4 = r13
            goto L_0x0093
        L_0x0072:
            r12 = move-exception
            goto L_0x00c6
        L_0x0074:
            r12 = move-exception
            goto L_0x00cc
        L_0x0077:
            r12 = move-exception
            goto L_0x00d2
        L_0x007a:
            b(r11)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r5)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r6)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r4)
            return r3
        L_0x0087:
            java.lang.String r12 = "Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n"
            r6.writeBytes(r12)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r6.writeBytes(r8)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            int r12 = r13.length     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            r6.write(r13, r7, r12)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
        L_0x0093:
            r6.writeBytes(r8)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            java.lang.String r12 = "------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n"
            r6.writeBytes(r12)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            com.efs.sdk.base.http.HttpResponse r3 = a(r11)     // Catch:{ UnknownHostException -> 0x00b3, SocketTimeoutException -> 0x00b0, all -> 0x00ad }
            b(r11)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r5)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r6)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r4)
            goto L_0x012f
        L_0x00ad:
            r12 = move-exception
            r13 = r4
            goto L_0x00c6
        L_0x00b0:
            r12 = move-exception
            r13 = r4
            goto L_0x00cc
        L_0x00b3:
            r12 = move-exception
            r13 = r4
            goto L_0x00d2
        L_0x00b6:
            r12 = move-exception
            r13 = r4
            r6 = r13
            goto L_0x00c6
        L_0x00ba:
            r12 = move-exception
            r13 = r4
            r6 = r13
            goto L_0x00cc
        L_0x00be:
            r12 = move-exception
            r13 = r4
            r6 = r13
            goto L_0x00d2
        L_0x00c2:
            r12 = move-exception
            r13 = r4
            r5 = r13
            r6 = r5
        L_0x00c6:
            r4 = r11
            goto L_0x00d8
        L_0x00c8:
            r12 = move-exception
            r13 = r4
            r5 = r13
            r6 = r5
        L_0x00cc:
            r4 = r11
            goto L_0x00fb
        L_0x00ce:
            r12 = move-exception
            r13 = r4
            r5 = r13
            r6 = r5
        L_0x00d2:
            r4 = r11
            goto L_0x0116
        L_0x00d4:
            r12 = move-exception
            r13 = r4
            r5 = r13
            r6 = r5
        L_0x00d8:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r11.<init>(r1)     // Catch:{ all -> 0x0133 }
            r11.append(r10)     // Catch:{ all -> 0x0133 }
            r11.append(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0133 }
            com.efs.sdk.base.core.util.Log.e(r2, r11, r12)     // Catch:{ all -> 0x0133 }
        L_0x00ea:
            b(r4)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r5)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r6)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r13)
            goto L_0x012f
        L_0x00f7:
            r12 = move-exception
            r13 = r4
            r5 = r13
            r6 = r5
        L_0x00fb:
            r11 = -3
            r3.setHttpCode(r11)     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r11.<init>(r1)     // Catch:{ all -> 0x0133 }
            r11.append(r10)     // Catch:{ all -> 0x0133 }
            r11.append(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0133 }
            com.efs.sdk.base.core.util.Log.e(r2, r11, r12)     // Catch:{ all -> 0x0133 }
            goto L_0x00ea
        L_0x0112:
            r12 = move-exception
            r13 = r4
            r5 = r13
            r6 = r5
        L_0x0116:
            r11 = -2
            r3.setHttpCode(r11)     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r11.<init>(r1)     // Catch:{ all -> 0x0133 }
            r11.append(r10)     // Catch:{ all -> 0x0133 }
            java.lang.String r0 = "' error， maybe network is disconnect"
            r11.append(r0)     // Catch:{ all -> 0x0133 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0133 }
            com.efs.sdk.base.core.util.Log.e(r2, r11, r12)     // Catch:{ all -> 0x0133 }
            goto L_0x00ea
        L_0x012f:
            r3.setReqUrl(r10)
            return r3
        L_0x0133:
            r10 = move-exception
            b(r4)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r5)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r6)
            com.efs.sdk.base.core.util.FileUtil.safeClose(r13)
            goto L_0x0142
        L_0x0141:
            throw r10
        L_0x0142:
            goto L_0x0141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.util.a.a.a(java.lang.String, java.util.Map, java.io.File, byte[]):com.efs.sdk.base.http.HttpResponse");
    }
}
