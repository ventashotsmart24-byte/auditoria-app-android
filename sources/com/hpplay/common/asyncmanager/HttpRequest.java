package com.hpplay.common.asyncmanager;

import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpRequest {
    private final String TAG = "HttpRequest";
    private int count = 0;
    private AsyncHttpJob mHttpJob;
    private AsyncHttpParameter.In parameter;

    public HttpRequest(AsyncHttpParameter.In in, AsyncHttpJob asyncHttpJob) {
        this.parameter = in;
        this.mHttpJob = asyncHttpJob;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e1, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        com.hpplay.common.log.LeLog.w("HttpRequest", "Exception when doGet retry sleep " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f7, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f8, code lost:
        com.hpplay.common.log.LeLog.w("HttpRequest", (java.lang.Throwable) r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f7 A[ExcHandler: Error (r4v6 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:9:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.common.asyncmanager.HttpResult doGet() {
        /*
            r9 = this;
            java.lang.String r0 = "HttpRequest"
            com.hpplay.common.asyncmanager.HttpResult r1 = new com.hpplay.common.asyncmanager.HttpResult
            r1.<init>()
            r2 = 0
            r9.count = r2
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r3 = r9.parameter
            java.lang.String r4 = r3.requestUrl
            java.lang.String r3 = r3.params
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0050
            java.lang.String r3 = "?"
            boolean r4 = r4.endsWith(r3)
            if (r4 == 0) goto L_0x0036
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r4 = r9.parameter
            java.lang.String r4 = r4.requestUrl
            r3.append(r4)
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r4 = r9.parameter
            java.lang.String r4 = r4.params
            r3.append(r4)
            java.lang.String r4 = r3.toString()
            goto L_0x0050
        L_0x0036:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r9.parameter
            java.lang.String r5 = r5.requestUrl
            r4.append(r5)
            r4.append(r3)
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r3 = r9.parameter
            java.lang.String r3 = r3.params
            r4.append(r3)
            java.lang.String r4 = r4.toString()
        L_0x0050:
            java.lang.String r3 = " "
            java.lang.String r5 = "%20"
            java.lang.String r3 = r4.replaceAll(r3, r5)
        L_0x0058:
            int r4 = r9.count
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r9.parameter
            int r5 = r5.tryCount
            r6 = 1
            if (r4 >= r5) goto L_0x0107
            java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.net.HttpURLConnection r4 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r4)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r9.parameter     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r5 = r5.connectTimeout     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r9.parameter     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r5 = r5.readTimeout     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.setDoInput(r6)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.setUseCaches(r2)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.lang.String r5 = "GET"
            r4.setRequestMethod(r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r9.parameter     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.requestHeaders     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            boolean r5 = r9.setHeaders(r4, r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.connect()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.asyncmanager.AsyncHttpJob r7 = r9.mHttpJob     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            if (r7 == 0) goto L_0x0095
            r7.cancelTimeOut()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
        L_0x0095:
            int r7 = r4.getResponseCode()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r1.responseCode = r7     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 != r8) goto L_0x00b3
            java.lang.String r5 = r9.readHttpResult(r4, r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r1.resultType = r2     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r1.result = r5     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.util.Map r4 = r4.getHeaderFields()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r1.headers = r4     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r4 = r9.count     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r4 = r4 + r6
            r9.count = r4     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            return r1
        L_0x00b3:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.<init>()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.lang.String r5 = "doGet"
            r4.append(r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.append(r3)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.lang.String r5 = " responseCode:"
            r4.append(r5)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r4.append(r7)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r4 = r9.count     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r9.parameter     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r7 = r5.tryCount     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            int r7 = r7 - r6
            if (r4 >= r7) goto L_0x0100
            int r4 = r5.trySpace     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            if (r4 <= 0) goto L_0x0100
            long r4 = (long) r4
            java.lang.Thread.sleep(r4)     // Catch:{ Exception -> 0x00e1, Error -> 0x00f7 }
            goto L_0x0100
        L_0x00e1:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r5.<init>()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.lang.String r7 = "Exception when doGet retry sleep "
            r5.append(r7)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            r5.append(r4)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x00fc, Error -> 0x00f7 }
            goto L_0x0100
        L_0x00f7:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
            goto L_0x0100
        L_0x00fc:
            r4 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x0100:
            int r4 = r9.count
            int r4 = r4 + r6
            r9.count = r4
            goto L_0x0058
        L_0x0107:
            r1.resultType = r6
            r0 = 0
            r1.result = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.asyncmanager.HttpRequest.doGet():com.hpplay.common.asyncmanager.HttpResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00db, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00dc, code lost:
        com.hpplay.common.log.LeLog.w("HttpRequest", (java.lang.Throwable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e0, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e1, code lost:
        com.hpplay.common.log.LeLog.w("HttpRequest", (java.lang.Throwable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e5, code lost:
        com.hpplay.common.log.LeLog.w("HttpRequest", "doPost InterruptedIOException");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00db A[ExcHandler: Error (r3v5 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:3:0x0013] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.common.asyncmanager.HttpResult doPost() {
        /*
            r10 = this;
            java.lang.String r0 = "HttpRequest"
            com.hpplay.common.asyncmanager.HttpResult r1 = new com.hpplay.common.asyncmanager.HttpResult
            r1.<init>()
            r2 = 0
            r10.count = r2
        L_0x000a:
            int r3 = r10.count
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r4 = r10.parameter
            int r5 = r4.tryCount
            r6 = 1
            if (r3 >= r5) goto L_0x00f1
            java.lang.String r3 = r4.requestUrl     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.net.URL r4 = new java.net.URL     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.<init>(r3)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.net.HttpURLConnection r4 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r4)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r10.parameter     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r5 = r5.connectTimeout     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.setConnectTimeout(r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r10.parameter     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r5 = r5.readTimeout     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.setReadTimeout(r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.setDoInput(r6)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.setDoOutput(r6)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r5 = "POST"
            r4.setRequestMethod(r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.setUseCaches(r2)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.setInstanceFollowRedirects(r6)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r5 = "Content-Type"
            java.lang.String r7 = "application/json"
            r4.setRequestProperty(r5, r7)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r5 = r10.parameter     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.util.Map<java.lang.String, java.lang.String> r5 = r5.requestHeaders     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            boolean r5 = r10.setHeaders(r4, r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.connect()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.asyncmanager.AsyncHttpJob r7 = r10.mHttpJob     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            if (r7 == 0) goto L_0x0056
            r7.cancelTimeOut()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
        L_0x0056:
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r7 = r10.parameter     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r7 = r7.params     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            if (r7 != 0) goto L_0x0079
            java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.io.OutputStream r8 = r4.getOutputStream()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r7.<init>(r8)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r8 = r10.parameter     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r8 = r8.params     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r9 = "UTF-8"
            byte[] r8 = r8.getBytes(r9)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r7.write(r8)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r7.flush()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
        L_0x0079:
            int r7 = r4.getResponseCode()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r1.responseCode = r7     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r8 = 200(0xc8, float:2.8E-43)
            if (r7 != r8) goto L_0x0097
            java.lang.String r3 = r10.readHttpResult(r4, r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r1.resultType = r2     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r1.result = r3     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.util.Map r3 = r4.getHeaderFields()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r1.headers = r3     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r3 = r10.count     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r3 = r3 + r6
            r10.count = r3     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            return r1
        L_0x0097:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.<init>()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r5 = "doPost"
            r4.append(r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.append(r3)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r3 = " responseCode:"
            r4.append(r3)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.append(r7)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r3 = r4.toString()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r3 = r10.count     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.asyncmanager.AsyncHttpParameter$In r4 = r10.parameter     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r5 = r4.tryCount     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            int r5 = r5 - r6
            if (r3 >= r5) goto L_0x00ea
            int r3 = r4.trySpace     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            if (r3 <= 0) goto L_0x00ea
            long r3 = (long) r3
            java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x00c5, Error -> 0x00db }
            goto L_0x00ea
        L_0x00c5:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.<init>()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r5 = "Exception when doPost retry sleep "
            r4.append(r5)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            r4.append(r3)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            java.lang.String r3 = r4.toString()     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ InterruptedIOException -> 0x00e5, Exception -> 0x00e0, Error -> 0x00db }
            goto L_0x00ea
        L_0x00db:
            r3 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r3)
            goto L_0x00ea
        L_0x00e0:
            r3 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r3)
            goto L_0x00ea
        L_0x00e5:
            java.lang.String r3 = "doPost InterruptedIOException"
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r3)
        L_0x00ea:
            int r3 = r10.count
            int r3 = r3 + r6
            r10.count = r3
            goto L_0x000a
        L_0x00f1:
            r1.resultType = r6
            r0 = 0
            r1.result = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.asyncmanager.HttpRequest.doPost():com.hpplay.common.asyncmanager.HttpResult");
    }

    public int getCount() {
        return this.count;
    }

    public String readHttpResult(URLConnection uRLConnection, boolean z10) {
        InputStream inputStream;
        StringBuffer stringBuffer;
        if (z10) {
            inputStream = new GZIPInputStream(uRLConnection.getInputStream());
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        String str = null;
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            stringBuffer = new StringBuffer();
            for (int read = inputStreamReader.read(); read != -1; read = inputStreamReader.read()) {
                stringBuffer.append((char) read);
            }
            inputStream.close();
            inputStreamReader.close();
        } else {
            stringBuffer = null;
        }
        if (stringBuffer != null) {
            str = stringBuffer.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public boolean setHeaders(URLConnection uRLConnection, Map<String, String> map) {
        boolean z10 = false;
        if (map != null && map.size() > 0) {
            for (String obj : map.keySet()) {
                String obj2 = obj.toString();
                String str = map.get(obj2);
                if ("gzip".equals(str)) {
                    z10 = true;
                }
                uRLConnection.setRequestProperty(obj2, str);
            }
        }
        return z10;
    }
}
