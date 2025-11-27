package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class HTTPRequest extends HTTPPacket {
    public static final int DEFAULT_TIMEOUT = 10000;
    private static final String NO_HOST = "No route to host";
    private static final String TAG = "HTTPRequest";
    private HTTPSocket httpSocket;
    private String method;
    private Socket postSocket;
    private String requestHost;
    private int requestPort;
    private String uri;

    public HTTPRequest() {
        this.method = null;
        this.uri = null;
        this.requestHost = "";
        this.requestPort = -1;
        this.httpSocket = null;
        this.postSocket = null;
        setVersion("1.1");
    }

    public String getFirstLineString() {
        return getMethod() + " " + getURI() + " " + getHTTPVersion() + "\r\n";
    }

    public String getHTTPVersion() {
        if (hasFirstLine()) {
            return getFirstLineToken(2);
        }
        return "HTTP/" + super.getVersion();
    }

    public String getHeader() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getFirstLineString());
        stringBuffer.append(getHeaderString());
        return stringBuffer.toString();
    }

    public String getLocalAddress() {
        return getSocket().getLocalAddress();
    }

    public int getLocalPort() {
        return getSocket().getLocalPort();
    }

    public String getMethod() {
        String str = this.method;
        if (str != null) {
            return str;
        }
        return getFirstLineToken(0);
    }

    public ParameterList getParameterList() {
        int indexOf;
        int i10;
        ParameterList parameterList = new ParameterList();
        String uri2 = getURI();
        if (uri2 == null || (indexOf = uri2.indexOf(63)) < 0) {
            return parameterList;
        }
        while (indexOf > 0) {
            int i11 = indexOf + 1;
            int indexOf2 = uri2.indexOf(61, i11);
            String substring = uri2.substring(i11, indexOf2);
            int i12 = indexOf2 + 1;
            int indexOf3 = uri2.indexOf(38, i12);
            if (indexOf3 > 0) {
                i10 = indexOf3;
            } else {
                i10 = uri2.length();
            }
            parameterList.add(new Parameter(substring, uri2.substring(i12, i10)));
            indexOf = indexOf3;
        }
        return parameterList;
    }

    public String getParameterValue(String str) {
        return getParameterList().getValue(str);
    }

    public String getRequestHost() {
        return this.requestHost;
    }

    public int getRequestPort() {
        return this.requestPort;
    }

    public HTTPSocket getSocket() {
        return this.httpSocket;
    }

    public String getURI() {
        String str = this.uri;
        if (str != null) {
            return str;
        }
        return getFirstLineToken(1);
    }

    public boolean isGetRequest() {
        return isMethod("GET");
    }

    public boolean isHeadRequest() {
        return isMethod("HEAD");
    }

    public boolean isKeepAlive() {
        boolean z10;
        if (isCloseConnection()) {
            return false;
        }
        if (isKeepAliveConnection()) {
            return true;
        }
        if (getHTTPVersion().indexOf("1.0") > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return false;
        }
        return true;
    }

    public boolean isMethod(String str) {
        String method2 = getMethod();
        if (method2 == null) {
            return false;
        }
        return method2.equalsIgnoreCase(str);
    }

    public boolean isNotifyRequest() {
        return isMethod(HTTP.NOTIFY);
    }

    public boolean isPostRequest() {
        return isMethod("POST");
    }

    public boolean isSOAPAction() {
        return hasHeader(HTTP.SOAP_ACTION);
    }

    public boolean isSubscribeRequest() {
        return isMethod("SUBSCRIBE");
    }

    public boolean isUnsubscribeRequest() {
        return isMethod("UNSUBSCRIBE");
    }

    public boolean parseRequestLine(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        setMethod(stringTokenizer.nextToken());
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        setURI(stringTokenizer.nextToken());
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        setVersion(stringTokenizer.nextToken());
        return true;
    }

    public boolean post(HTTPResponse hTTPResponse) {
        long j10;
        HTTPSocket socket = getSocket();
        long contentLength = hTTPResponse.getContentLength();
        long j11 = 0;
        if (hasContentRange()) {
            long contentRangeFirstPosition = getContentRangeFirstPosition();
            long contentRangeLastPosition = getContentRangeLastPosition();
            if (contentRangeLastPosition <= 0) {
                contentRangeLastPosition = contentLength - 1;
            }
            long j12 = contentRangeLastPosition;
            if (contentRangeFirstPosition > contentLength || j12 > contentLength) {
                return returnResponse(416);
            }
            j11 = contentRangeFirstPosition;
            hTTPResponse.setContentRange(j11, j12, contentLength);
            hTTPResponse.setStatusCode(206);
            j10 = (j12 - contentRangeFirstPosition) + 1;
        } else {
            j10 = contentLength;
        }
        return socket.post(hTTPResponse, j11, j10, isHeadRequest());
    }

    public void print() {
        CLog.d(TAG, toString());
    }

    public boolean read() {
        return super.read(getSocket());
    }

    public boolean returnBadRequest() {
        return returnResponse(400);
    }

    public boolean returnOK() {
        return returnResponse(200);
    }

    public boolean returnResponse(int i10) {
        HTTPResponse hTTPResponse = new HTTPResponse();
        hTTPResponse.setStatusCode(i10);
        hTTPResponse.setContentLength(0);
        return post(hTTPResponse);
    }

    public void set(HTTPRequest hTTPRequest) {
        set((HTTPPacket) hTTPRequest);
        setSocket(hTTPRequest.getSocket());
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRequestHost(String str) {
        this.requestHost = str;
    }

    public void setRequestPort(int i10) {
        this.requestPort = i10;
    }

    public void setSocket(HTTPSocket hTTPSocket) {
        this.httpSocket = hTTPSocket;
    }

    public void setURI(String str, boolean z10) {
        this.uri = str;
        if (z10) {
            this.uri = HTTP.toRelativeURL(str);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getHeader());
        stringBuffer.append("\r\n");
        stringBuffer.append(getContentString());
        return stringBuffer.toString();
    }

    public void setURI(String str) {
        setURI(str, false);
    }

    public HTTPRequest(InputStream inputStream) {
        super(inputStream);
        this.method = null;
        this.uri = null;
        this.requestHost = "";
        this.requestPort = -1;
        this.httpSocket = null;
        this.postSocket = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00de, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00df, code lost:
        r12 = null;
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f9, code lost:
        if (r0 != null) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0100, code lost:
        if (r12 != null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r11 = r10.postSocket;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r10.postSocket.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r12 = null;
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f4 A[SYNTHETIC, Splitter:B:60:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010d A[SYNTHETIC, Splitter:B:76:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0114 A[SYNTHETIC, Splitter:B:80:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011b A[SYNTHETIC, Splitter:B:84:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.cybergarage.http.HTTPResponse post(java.lang.String r11, int r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r0 = "\r\n"
            com.hpplay.cybergarage.http.HTTPResponse r1 = new com.hpplay.cybergarage.http.HTTPResponse
            r1.<init>()
            r10.setHost(r11)
            if (r13 == 0) goto L_0x000f
            java.lang.String r2 = "Keep-Alive"
            goto L_0x0011
        L_0x000f:
            java.lang.String r2 = "close"
        L_0x0011:
            r10.setConnection(r2)
            boolean r2 = r10.isHeadRequest()
            r3 = 0
            r4 = 0
            java.net.Socket r5 = new java.net.Socket     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r5.<init>()     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r10.postSocket = r5     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r6.<init>(r11, r12)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r11 = 10000(0x2710, float:1.4013E-41)
            r5.connect(r6, r11)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r11 = 1
            goto L_0x0052
        L_0x002d:
            r11 = move-exception
            r12 = r4
            r0 = r12
            goto L_0x010b
        L_0x0032:
            r11 = move-exception
            java.lang.String r12 = r11.toString()     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            java.lang.String r5 = "No route to host"
            boolean r12 = r12.contains(r5)     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            if (r12 == 0) goto L_0x0045
            r12 = 600(0x258, float:8.41E-43)
            r1.setStatusCode(r12)     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            goto L_0x004a
        L_0x0045:
            r12 = 510(0x1fe, float:7.15E-43)
            r1.setStatusCode(r12)     // Catch:{ Exception -> 0x00de, all -> 0x002d }
        L_0x004a:
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            r1.setContent((java.lang.String) r11)     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            r11 = 0
        L_0x0052:
            if (r11 == 0) goto L_0x00c9
            java.net.Socket r11 = r10.postSocket     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            java.io.OutputStream r11 = r11.getOutputStream()     // Catch:{ Exception -> 0x00de, all -> 0x002d }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r12.<init>()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            java.lang.String r5 = r10.getHeader()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r12.append(r5)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r12.append(r0)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            boolean r5 = r10.isChunked()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            java.lang.String r6 = r10.getContentString()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            if (r6 == 0) goto L_0x0077
            int r3 = r6.length()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
        L_0x0077:
            if (r3 <= 0) goto L_0x008e
            if (r5 == 0) goto L_0x0086
            long r7 = (long) r3     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            java.lang.String r3 = java.lang.Long.toHexString(r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r12.append(r3)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r12.append(r0)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
        L_0x0086:
            r12.append(r6)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            if (r5 == 0) goto L_0x008e
            r12.append(r0)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
        L_0x008e:
            if (r5 == 0) goto L_0x0098
            java.lang.String r3 = "0"
            r12.append(r3)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r12.append(r0)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
        L_0x0098:
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            byte[] r12 = r12.getBytes()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r11.write(r12)     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r11.flush()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            java.net.Socket r12 = r10.postSocket     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            java.io.InputStream r12 = r12.getInputStream()     // Catch:{ Exception -> 0x00c3, all -> 0x00bd }
            r1.set(r12, r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b0 }
            goto L_0x00cb
        L_0x00b0:
            r0 = move-exception
            r9 = r12
            r12 = r11
            r11 = r0
            r0 = r9
            goto L_0x010b
        L_0x00b7:
            r0 = move-exception
            r9 = r12
            r12 = r11
            r11 = r0
            r0 = r9
            goto L_0x00e1
        L_0x00bd:
            r12 = move-exception
            r0 = r4
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x010b
        L_0x00c3:
            r12 = move-exception
            r0 = r4
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00e1
        L_0x00c9:
            r11 = r4
            r12 = r11
        L_0x00cb:
            if (r13 != 0) goto L_0x0109
            r12.close()     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00d2
        L_0x00d1:
        L_0x00d2:
            if (r12 == 0) goto L_0x00d9
            r11.close()     // Catch:{ Exception -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r11 == 0) goto L_0x0107
            java.net.Socket r11 = r10.postSocket     // Catch:{ Exception -> 0x0107 }
            goto L_0x0104
        L_0x00de:
            r11 = move-exception
            r12 = r4
            r0 = r12
        L_0x00e1:
            r2 = 7000(0x1b58, float:9.809E-42)
            r1.setStatusCode(r2)     // Catch:{ all -> 0x010a }
            java.lang.String r2 = r11.toString()     // Catch:{ all -> 0x010a }
            r1.setContent((java.lang.String) r2)     // Catch:{ all -> 0x010a }
            java.lang.String r2 = "HTTPRequest"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r11)     // Catch:{ all -> 0x010a }
            if (r13 != 0) goto L_0x0109
            r0.close()     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00f9
        L_0x00f8:
        L_0x00f9:
            if (r0 == 0) goto L_0x0100
            r12.close()     // Catch:{ Exception -> 0x00ff }
            goto L_0x0100
        L_0x00ff:
        L_0x0100:
            if (r12 == 0) goto L_0x0107
            java.net.Socket r11 = r10.postSocket     // Catch:{ Exception -> 0x0107 }
        L_0x0104:
            r11.close()     // Catch:{ Exception -> 0x0107 }
        L_0x0107:
            r10.postSocket = r4
        L_0x0109:
            return r1
        L_0x010a:
            r11 = move-exception
        L_0x010b:
            if (r13 != 0) goto L_0x0122
            r0.close()     // Catch:{ Exception -> 0x0111 }
            goto L_0x0112
        L_0x0111:
        L_0x0112:
            if (r0 == 0) goto L_0x0119
            r12.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x0119
        L_0x0118:
        L_0x0119:
            if (r12 == 0) goto L_0x0120
            java.net.Socket r12 = r10.postSocket     // Catch:{ Exception -> 0x0120 }
            r12.close()     // Catch:{ Exception -> 0x0120 }
        L_0x0120:
            r10.postSocket = r4
        L_0x0122:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.http.HTTPRequest.post(java.lang.String, int, boolean):com.hpplay.cybergarage.http.HTTPResponse");
    }

    public HTTPRequest(HTTPSocket hTTPSocket) {
        this(hTTPSocket.getInputStream());
        setSocket(hTTPSocket);
    }

    public HTTPResponse post(String str, int i10) {
        return post(str, i10, false);
    }
}
