package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.util.StringUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.Vector;

public class HTTPPacket {
    private static final String TAG = "Cyber-HTTPPacket";
    private byte[] content = new byte[0];
    private InputStream contentInput = null;
    private String firstLine = "";
    private Vector httpHeaderList = new Vector();
    private String version;

    public HTTPPacket() {
        setVersion("1.1");
        setContentInputStream((InputStream) null);
    }

    private String readLine(BufferedInputStream bufferedInputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1];
        try {
            int read = bufferedInputStream.read(bArr);
            while (true) {
                if (read <= 0) {
                    break;
                }
                byte b10 = bArr[0];
                if (b10 == 10) {
                    break;
                }
                if (b10 != 13) {
                    byteArrayOutputStream.write(b10);
                }
                read = bufferedInputStream.read(bArr);
            }
        } catch (InterruptedIOException unused) {
        } catch (IOException e10) {
            CLog.d(TAG, (String) null, e10);
        }
        return byteArrayOutputStream.toString();
    }

    private void setFirstLine(String str) {
        this.firstLine = str;
    }

    public void addHeader(HTTPHeader hTTPHeader) {
        this.httpHeaderList.add(hTTPHeader);
    }

    public void clearHeaders() {
        this.httpHeaderList.clear();
        this.httpHeaderList = new Vector();
    }

    public String getCacheControl() {
        return getHeaderValue("Cache-Control");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.toLowerCase();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCharSet() {
        /*
            r6 = this;
            java.lang.String r0 = r6.getContentType()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r2 = "charset"
            int r2 = r0.indexOf(r2)
            if (r2 >= 0) goto L_0x0016
            return r1
        L_0x0016:
            int r2 = r2 + 7
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r4 = new java.lang.String
            byte[] r5 = r0.getBytes()
            int r0 = r0.length()
            int r0 = r0 - r2
            r4.<init>(r5, r2, r0)
            int r0 = r4.length()
            if (r0 >= 0) goto L_0x002f
            return r1
        L_0x002f:
            r0 = 0
            char r2 = r4.charAt(r0)
            r5 = 34
            if (r2 != r5) goto L_0x0041
            int r2 = r4.length()
            int r2 = r2 - r3
            java.lang.String r4 = r4.substring(r3, r2)
        L_0x0041:
            int r2 = r4.length()
            if (r2 >= 0) goto L_0x0048
            return r1
        L_0x0048:
            int r1 = r4.length()
            int r1 = r1 - r3
            char r1 = r4.charAt(r1)
            if (r1 != r5) goto L_0x005c
            int r1 = r4.length()
            int r1 = r1 - r3
            java.lang.String r4 = r4.substring(r0, r1)
        L_0x005c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.http.HTTPPacket.getCharSet():java.lang.String");
    }

    public String getConnection() {
        return getHeaderValue("Connection");
    }

    public byte[] getContent() {
        return this.content;
    }

    public InputStream getContentInputStream() {
        return this.contentInput;
    }

    public String getContentLanguage() {
        return getHeaderValue("Content-Language");
    }

    public long getContentLength() {
        return getLongHeaderValue("Content-Length");
    }

    public long[] getContentRange() {
        long[] jArr = {0, 0, 0};
        if (!hasContentRange()) {
            return jArr;
        }
        String headerValue = getHeaderValue("Content-Range");
        if (headerValue.length() <= 0) {
            headerValue = getHeaderValue("Range");
        }
        if (headerValue.length() <= 0) {
            return jArr;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(headerValue, " =");
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        stringTokenizer.nextToken(" ");
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        try {
            jArr[0] = Long.parseLong(stringTokenizer.nextToken(" -"));
        } catch (NumberFormatException unused) {
        }
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        try {
            jArr[1] = Long.parseLong(stringTokenizer.nextToken("-/"));
        } catch (NumberFormatException unused2) {
        }
        if (!stringTokenizer.hasMoreTokens()) {
            return jArr;
        }
        try {
            jArr[2] = Long.parseLong(stringTokenizer.nextToken(Operator.Operation.DIVISION));
        } catch (NumberFormatException unused3) {
        }
        return jArr;
    }

    public long getContentRangeFirstPosition() {
        return getContentRange()[0];
    }

    public long getContentRangeInstanceLength() {
        return getContentRange()[2];
    }

    public long getContentRangeLastPosition() {
        return getContentRange()[1];
    }

    public String getContentString() {
        String charSet = getCharSet();
        if (charSet == null || charSet.length() <= 0) {
            return new String(this.content);
        }
        try {
            return new String(this.content, charSet);
        } catch (Exception e10) {
            CLog.d(TAG, (String) null, e10);
            return new String(this.content);
        }
    }

    public String getContentType() {
        return getHeaderValue("Content-Type");
    }

    public String getDate() {
        return getHeaderValue("Date");
    }

    public String getFirstLine() {
        return this.firstLine;
    }

    public String getFirstLineToken(int i10) {
        StringTokenizer stringTokenizer = new StringTokenizer(this.firstLine, " ");
        String str = "";
        for (int i11 = 0; i11 <= i10; i11++) {
            if (!stringTokenizer.hasMoreTokens()) {
                return "";
            }
            str = stringTokenizer.nextToken();
        }
        return str;
    }

    public HTTPHeader getHeader(int i10) {
        return (HTTPHeader) this.httpHeaderList.get(i10);
    }

    public String getHeaderString() {
        StringBuffer stringBuffer = new StringBuffer();
        int nHeaders = getNHeaders();
        for (int i10 = 0; i10 < nHeaders; i10++) {
            HTTPHeader header = getHeader(i10);
            stringBuffer.append(header.getName() + ": " + header.getValue() + "\r\n");
        }
        return stringBuffer.toString();
    }

    public String getHeaderValue(String str) {
        HTTPHeader header = getHeader(str);
        if (header == null) {
            return "";
        }
        return header.getValue();
    }

    public String getHost() {
        return getHeaderValue(HTTP.HOST);
    }

    public int getIntegerHeaderValue(String str) {
        HTTPHeader header = getHeader(str);
        if (header == null) {
            return 0;
        }
        return StringUtil.toInteger(header.getValue());
    }

    public long getLongHeaderValue(String str) {
        HTTPHeader header = getHeader(str);
        if (header == null) {
            return 0;
        }
        return StringUtil.toLong(header.getValue());
    }

    public int getNHeaders() {
        return this.httpHeaderList.size();
    }

    public String getServer() {
        return getHeaderValue("Server");
    }

    public String getStringHeaderValue(String str, String str2, String str3) {
        String headerValue = getHeaderValue(str);
        if (headerValue.startsWith(str2)) {
            headerValue = headerValue.substring(1, headerValue.length());
        }
        return headerValue.endsWith(str3) ? headerValue.substring(0, headerValue.length() - 1) : headerValue;
    }

    public String getTransferEncoding() {
        return getHeaderValue("Transfer-Encoding");
    }

    public String getVersion() {
        return this.version;
    }

    public boolean hasConnection() {
        return hasHeader("Connection");
    }

    public boolean hasContent() {
        if (this.content.length > 0) {
            return true;
        }
        return false;
    }

    public boolean hasContentInputStream() {
        if (this.contentInput != null) {
            return true;
        }
        return false;
    }

    public boolean hasContentRange() {
        if (hasHeader("Content-Range") || hasHeader("Range")) {
            return true;
        }
        return false;
    }

    public boolean hasFirstLine() {
        if (this.firstLine.length() > 0) {
            return true;
        }
        return false;
    }

    public boolean hasHeader(String str) {
        if (getHeader(str) != null) {
            return true;
        }
        return false;
    }

    public boolean hasTransferEncoding() {
        return hasHeader("Transfer-Encoding");
    }

    public void init() {
        setFirstLine("");
        clearHeaders();
        setContent(new byte[0], false);
        setContentInputStream((InputStream) null);
    }

    public boolean isChunked() {
        String transferEncoding;
        if (hasTransferEncoding() && (transferEncoding = getTransferEncoding()) != null) {
            return transferEncoding.equalsIgnoreCase(HTTP.CHUNKED);
        }
        return false;
    }

    public boolean isCloseConnection() {
        String connection;
        if (hasConnection() && (connection = getConnection()) != null) {
            return connection.equalsIgnoreCase(HTTP.CLOSE);
        }
        return false;
    }

    public boolean isKeepAliveConnection() {
        String connection;
        if (hasConnection() && (connection = getConnection()) != null) {
            return connection.equalsIgnoreCase("Keep-Alive");
        }
        return false;
    }

    public boolean read(HTTPSocket hTTPSocket) {
        init();
        return set(hTTPSocket);
    }

    public boolean set(InputStream inputStream, boolean z10) {
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            String readLine = readLine(bufferedInputStream);
            if (readLine != null) {
                if (readLine.length() > 0) {
                    setFirstLine(readLine);
                    boolean z11 = true;
                    if (new HTTPStatus(readLine).getStatusCode() == 100) {
                        String readLine2 = readLine(bufferedInputStream);
                        while (readLine2 != null && readLine2.length() > 0) {
                            HTTPHeader hTTPHeader = new HTTPHeader(readLine2);
                            if (hTTPHeader.hasName()) {
                                setHeader(hTTPHeader);
                            }
                            readLine2 = readLine(bufferedInputStream);
                        }
                        String readLine3 = readLine(bufferedInputStream);
                        if (readLine3 == null || readLine3.length() <= 0) {
                            return true;
                        }
                        setFirstLine(readLine3);
                    }
                    String readLine4 = readLine(bufferedInputStream);
                    while (readLine4 != null && readLine4.length() > 0) {
                        HTTPHeader hTTPHeader2 = new HTTPHeader(readLine4);
                        if (hTTPHeader2.hasName()) {
                            setHeader(hTTPHeader2);
                        }
                        readLine4 = readLine(bufferedInputStream);
                    }
                    if (z10) {
                        setContent("", false);
                        return true;
                    }
                    boolean isChunked = isChunked();
                    long j15 = 0;
                    if (isChunked) {
                        try {
                            String readLine5 = readLine(bufferedInputStream);
                            if (readLine5 != null) {
                                j10 = Long.parseLong(readLine5.trim(), 16);
                            }
                        } catch (Exception unused) {
                        }
                        j10 = 0;
                    } else {
                        j10 = getContentLength();
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (j15 < j10) {
                        long chunkSize = (long) HTTP.getChunkSize();
                        byte[] bArr = new byte[((int) (j10 > chunkSize ? chunkSize : j10))];
                        long j16 = 0;
                        while (true) {
                            if (j16 >= j10) {
                                break;
                            }
                            long j17 = j10 - j16;
                            long j18 = j16;
                            try {
                                int read = bufferedInputStream.read(bArr, 0, (int) (chunkSize < j17 ? chunkSize : j17));
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                j16 = j18 + ((long) read);
                                z11 = true;
                            } catch (Exception e10) {
                                CLog.d(TAG, (String) null, e10);
                            }
                        }
                        z11 = true;
                        if (isChunked == z11) {
                            long j19 = 0;
                            do {
                                j13 = (long) 2;
                                long skip = bufferedInputStream.skip(j13 - j19);
                                j11 = 0;
                                if (skip < 0) {
                                    break;
                                }
                                j19 += skip;
                                break;
                                break;
                            } while (j19 < j13);
                            try {
                                break;
                                String readLine6 = readLine(bufferedInputStream);
                                try {
                                    j14 = Long.parseLong(new String(readLine6.getBytes(), 0, readLine6.length() - 2), 16);
                                } catch (Exception unused2) {
                                    j14 = 0;
                                    j12 = j14;
                                    j15 = j11;
                                    z11 = true;
                                }
                            } catch (Exception unused3) {
                                j14 = 0;
                                j12 = j14;
                                j15 = j11;
                                z11 = true;
                            }
                            j12 = j14;
                        } else {
                            j11 = 0;
                            j12 = 0;
                        }
                        j15 = j11;
                        z11 = true;
                    }
                    setContent(byteArrayOutputStream.toByteArray(), false);
                    return true;
                }
            }
            return false;
        } catch (Exception e11) {
            CLog.d(TAG, (String) null, e11);
            return false;
        }
    }

    public void setCacheControl(String str) {
        setHeader("Cache-Control", str);
    }

    public void setConnection(String str) {
        setHeader("Connection", str);
        setHeader("Cache-Control", HTTP.NO_CACHE);
    }

    public void setContent(byte[] bArr, boolean z10) {
        this.content = bArr;
        if (z10) {
            setContentLength((long) bArr.length);
        }
    }

    public void setContentInputStream(InputStream inputStream) {
        this.contentInput = inputStream;
    }

    public void setContentLanguage(String str) {
        setHeader("Content-Language", str);
    }

    public void setContentLength(long j10) {
        setLongHeader("Content-Length", j10);
    }

    public void setContentRange(long j10, long j11, long j12) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append((("" + "bytes ") + Long.toString(j10) + Operator.Operation.MINUS) + Long.toString(j11) + Operator.Operation.DIVISION);
        if (0 < j12) {
            str = Long.toString(j12);
        } else {
            str = Operator.Operation.MULTIPLY;
        }
        sb.append(str);
        setHeader("Content-Range", sb.toString());
    }

    public void setContentType(String str) {
        setHeader("Content-Type", str);
    }

    public void setDate(Calendar calendar) {
        setHeader("Date", new Date(calendar).getDateString());
    }

    public void setHeader(String str, String str2) {
        HTTPHeader header = getHeader(str);
        if (header != null) {
            header.setValue(str2);
        } else {
            addHeader(str, str2);
        }
    }

    public void setHost(String str, int i10) {
        if (HostInterface.isIPv6Address(str)) {
            str = "[" + str + "]";
        }
        setHeader(HTTP.HOST, str + SOAP.DELIM + Integer.toString(i10));
    }

    public void setIntegerHeader(String str, int i10) {
        setHeader(str, Integer.toString(i10));
    }

    public void setLongHeader(String str, long j10) {
        setHeader(str, Long.toString(j10));
    }

    public void setServer(String str) {
        setHeader("Server", str);
    }

    public void setStringHeader(String str, String str2, String str3, String str4) {
        if (!str2.startsWith(str3)) {
            str2 = str3 + str2;
        }
        if (!str2.endsWith(str4)) {
            str2 = str2 + str4;
        }
        setHeader(str, str2);
    }

    public void setTransferEncoding(String str) {
        setHeader("Transfer-Encoding", str);
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void addHeader(String str, String str2) {
        this.httpHeaderList.add(new HTTPHeader(str, str2));
    }

    public HTTPHeader getHeader(String str) {
        int nHeaders = getNHeaders();
        for (int i10 = 0; i10 < nHeaders; i10++) {
            HTTPHeader header = getHeader(i10);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public void setCacheControl(String str, int i10) {
        setHeader("Cache-Control", str + Operator.Operation.EQUALS + Integer.toString(i10));
    }

    public void setContent(byte[] bArr) {
        setContent(bArr, true);
    }

    public void setCacheControl(int i10) {
        setCacheControl(HTTP.MAX_AGE, i10);
    }

    public void setContent(String str, boolean z10) {
        if (str != null) {
            setContent(str.getBytes(), z10);
        }
    }

    public void setHeader(String str, int i10) {
        setHeader(str, Integer.toString(i10));
    }

    public void setHost(String str) {
        if (HostInterface.isIPv6Address(str)) {
            str = "[" + str + "]";
        }
        setHeader(HTTP.HOST, str);
    }

    public void setContent(String str) {
        setContent(str, true);
    }

    public void setHeader(String str, long j10) {
        setHeader(str, Long.toString(j10));
    }

    public String getStringHeaderValue(String str) {
        return getStringHeaderValue(str, "\"", "\"");
    }

    public void setHeader(HTTPHeader hTTPHeader) {
        setHeader(hTTPHeader.getName(), hTTPHeader.getValue());
    }

    public void setStringHeader(String str, String str2) {
        setStringHeader(str, str2, "\"", "\"");
    }

    public HTTPPacket(HTTPPacket hTTPPacket) {
        setVersion("1.1");
        set(hTTPPacket);
        setContentInputStream((InputStream) null);
    }

    public HTTPPacket(InputStream inputStream) {
        setVersion("1.1");
        set(inputStream);
        setContentInputStream((InputStream) null);
    }

    public boolean set(InputStream inputStream) {
        return set(inputStream, false);
    }

    public boolean set(HTTPSocket hTTPSocket) {
        return set(hTTPSocket.getInputStream());
    }

    public void set(HTTPPacket hTTPPacket) {
        setFirstLine(hTTPPacket.getFirstLine());
        clearHeaders();
        int nHeaders = hTTPPacket.getNHeaders();
        for (int i10 = 0; i10 < nHeaders; i10++) {
            addHeader(hTTPPacket.getHeader(i10));
        }
        setContent(hTTPPacket.getContent());
    }
}
