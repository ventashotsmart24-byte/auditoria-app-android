package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import anet.channel.util.g;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class b {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3838a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f3839b;

        /* renamed from: c  reason: collision with root package name */
        public Map<String, List<String>> f3840c;

        /* renamed from: d  reason: collision with root package name */
        public int f3841d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3842e;
    }

    private b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02a1, code lost:
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02a9, code lost:
        if (r7.contains("not verified") != false) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02ab, code lost:
        anet.channel.strategy.c.a.f3918a.b(r12.getHost());
        a(r12, r10, r1, anet.channel.util.ErrorConstant.ERROR_HOST_NOT_VERIFY_ERROR, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02ba, code lost:
        a(r12, r10, r1, -101, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02bf, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "HTTP Exception", r12.getSeq(), r2, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02cb, code lost:
        if (r13 != null) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02d3, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02dd, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        a(r12, r10, r1, -404, r2);
        anet.channel.util.ALog.e("awcn.HttpConnector", "IO Exception", r12.getSeq(), com.taobao.accs.common.Constants.KEY_HOST, r12.getHost(), r2);
        anet.channel.status.NetworkStatusHelper.printNetworkDetail();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02ff, code lost:
        if (r13 != null) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0306, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0307, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0311, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0312, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        a(r12, r10, r1, -204, r2);
        anet.channel.util.ALog.e("awcn.HttpConnector", "HTTP Request Cancel", r12.getSeq(), r2, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0324, code lost:
        if (r13 != null) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x032b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x032c, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0335, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0336, code lost:
        r19 = r3;
        r18 = r4;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0367, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", r11, r12.getSeq(), r18, ((javax.net.ssl.HttpsURLConnection) r13).getSSLSocketFactory(), r19, ((javax.net.ssl.HttpsURLConnection) r13).getHostnameVerifier());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0392, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0393, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x039d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x039e, code lost:
        r19 = r3;
        r18 = r4;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03cf, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", r11, r12.getSeq(), r18, ((javax.net.ssl.HttpsURLConnection) r13).getSSLSocketFactory(), r19, ((javax.net.ssl.HttpsURLConnection) r13).getHostnameVerifier());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03fb, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0405, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0406, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        a(r12, r10, r1, anet.channel.util.ErrorConstant.ERROR_CONNECT_EXCEPTION, r2);
        anet.channel.util.ALog.e("awcn.HttpConnector", "HTTP Connect Exception", r12.getSeq(), r2, new java.lang.Object[0]);
        anet.channel.status.NetworkStatusHelper.printNetworkDetail();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x041b, code lost:
        if (r13 != null) goto L_0x041d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008c, code lost:
        r2 = r0;
        r20 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0422, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0423, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x042d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x042e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:?, code lost:
        a(r12, r10, r1, anet.channel.util.ErrorConstant.ERROR_CONN_TIME_OUT, r2);
        anet.channel.util.ALog.e("awcn.HttpConnector", "HTTP Connect Timeout", r12.getSeq(), r2, new java.lang.Object[0]);
        anet.channel.status.NetworkStatusHelper.printNetworkDetail();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0443, code lost:
        if (r13 != null) goto L_0x0445;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0449, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0091, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x044a, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0453, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0454, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        a(r12, r10, r1, anet.channel.util.ErrorConstant.ERROR_SOCKET_TIME_OUT, r2);
        anet.channel.util.ALog.e("awcn.HttpConnector", "HTTP Socket Timeout", r12.getSeq(), r2, new java.lang.Object[0]);
        anet.channel.status.NetworkStatusHelper.printNetworkDetail();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0469, code lost:
        if (r13 != null) goto L_0x046b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x046f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0470, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0092, code lost:
        r2 = r0;
        r19 = r3;
        r18 = r4;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0479, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x047a, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:?, code lost:
        a(r12, r10, r1, anet.channel.util.ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, r2);
        anet.channel.util.ALog.e("awcn.HttpConnector", "Unknown Host Exception", r12.getSeq(), com.taobao.accs.common.Constants.KEY_HOST, r12.getHost(), r2);
        anet.channel.status.NetworkStatusHelper.printNetworkDetail();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x049c, code lost:
        if (r13 != null) goto L_0x049e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04a3, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04ac, code lost:
        if (r13 != null) goto L_0x04ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:?, code lost:
        r13.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04b3, code lost:
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04bb, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009b, code lost:
        r2 = r0;
        r19 = r3;
        r18 = r4;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0276, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0278, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x027b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x027e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0280, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x028e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x028f, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0292, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0293, code lost:
        r20 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0295, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x029a, code lost:
        if (r2.getMessage() != null) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x029c, code lost:
        r7 = r2.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02a1 A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02ab A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ba A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02cd A[SYNTHETIC, Splitter:B:107:0x02cd] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02dc A[ExcHandler: IOException (r0v16 'e' java.io.IOException A[CUSTOM_DECLARE]), PHI: r12 r13 
      PHI: (r12v12 anet.channel.request.Request) = (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v18 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v13 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0311 A[ExcHandler: CancellationException (r0v14 'e' java.util.concurrent.CancellationException A[CUSTOM_DECLARE]), PHI: r12 r13 
      PHI: (r12v11 anet.channel.request.Request) = (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v18 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v12 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0367 A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x038d A[SYNTHETIC, Splitter:B:137:0x038d] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03cf A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03f5 A[SYNTHETIC, Splitter:B:149:0x03f5] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0405 A[ExcHandler: ConnectException (r0v6 'e' java.net.ConnectException A[CUSTOM_DECLARE]), PHI: r12 r13 
      PHI: (r12v6 anet.channel.request.Request) = (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v18 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v5 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x042d A[ExcHandler: ConnectTimeoutException (r0v4 'e' org.apache.http.conn.ConnectTimeoutException A[CUSTOM_DECLARE]), PHI: r12 r13 
      PHI: (r12v5 anet.channel.request.Request) = (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v18 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v4 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0453 A[ExcHandler: SocketTimeoutException (r0v2 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), PHI: r12 r13 
      PHI: (r12v4 anet.channel.request.Request) = (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v18 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v3 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0479 A[ExcHandler: UnknownHostException (r0v0 'e' java.net.UnknownHostException A[CUSTOM_DECLARE]), PHI: r12 r13 
      PHI: (r12v3 anet.channel.request.Request) = (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v18 anet.channel.request.Request), (r12v2 anet.channel.request.Request), (r12v2 anet.channel.request.Request) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r13v2 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7, B:72:0x0246, B:46:0x0198, B:38:0x0132, B:39:?, B:12:0x003d, B:13:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0246 A[SYNTHETIC, Splitter:B:72:0x0246] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x025f A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0292 A[ExcHandler: Exception (e java.lang.Exception), PHI: r13 
      PHI: (r13v16 java.net.HttpURLConnection) = (r13v1 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection), (r13v18 java.net.HttpURLConnection) binds: [B:9:0x0033, B:20:0x00a3, B:21:?, B:23:0x00a8, B:24:?, B:26:0x00b1, B:27:?, B:29:0x00b7] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x029c A[Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276, all -> 0x028e }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:144:0x03a4=Splitter:B:144:0x03a4, B:96:0x0296=Splitter:B:96:0x0296, B:132:0x033c=Splitter:B:132:0x033c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static anet.channel.session.b.a a(anet.channel.request.Request r21, anet.channel.RequestCb r22) {
        /*
            r1 = r22
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "hostnameVerifier"
            java.lang.String r4 = "sslSocketFactory"
            java.lang.String r5 = "SSL Error Info."
            java.lang.String r6 = "host"
            java.lang.String r7 = ""
            java.lang.String r8 = "http disconnect"
            java.lang.String r9 = "awcn.HttpConnector"
            anet.channel.session.b$a r10 = new anet.channel.session.b$a
            r10.<init>()
            r11 = 0
            if (r21 == 0) goto L_0x04bc
            java.net.URL r12 = r21.getUrl()
            if (r12 != 0) goto L_0x0022
            goto L_0x04bc
        L_0x0022:
            r12 = r21
            r13 = r11
        L_0x0025:
            boolean r14 = anet.channel.status.NetworkStatusHelper.isConnected()
            if (r14 != 0) goto L_0x0032
            r2 = -200(0xffffffffffffff38, float:NaN)
            a(r12, r10, r1, r2, r11)
            goto L_0x04ab
        L_0x0032:
            r15 = 2
            java.net.HttpURLConnection r13 = a(r12)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x039d, SSLException -> 0x0335, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            boolean r16 = anet.channel.util.ALog.isPrintLog(r15)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x039d, SSLException -> 0x0335, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            if (r16 == 0) goto L_0x00a3
            java.lang.String r14 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.Object[] r11 = new java.lang.Object[r15]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r18 = "request URL"
            r17 = 0
            r11[r17] = r18     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.net.URL r18 = r13.getURL()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r18 = r18.toString()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            r16 = 1
            r11[r16] = r18     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            anet.channel.util.ALog.i(r9, r7, r14, r11)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r11 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.Object[] r14 = new java.lang.Object[r15]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r18 = "request Method"
            r17 = 0
            r14[r17] = r18     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r18 = r13.getRequestMethod()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            r16 = 1
            r14[r16] = r18     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            anet.channel.util.ALog.i(r9, r7, r11, r14)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r11 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.Object[] r14 = new java.lang.Object[r15]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r18 = "request headers"
            r17 = 0
            r14[r17] = r18     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.util.Map r18 = r13.getRequestProperties()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            java.lang.String r18 = r18.toString()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            r16 = 1
            r14[r16] = r18     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            anet.channel.util.ALog.i(r9, r7, r11, r14)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x009a, SSLException -> 0x0091, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x008b }
            goto L_0x00a3
        L_0x008b:
            r0 = move-exception
            r2 = r0
            r20 = r7
            goto L_0x0296
        L_0x0091:
            r0 = move-exception
            r2 = r0
            r19 = r3
            r18 = r4
            r11 = r5
            goto L_0x033c
        L_0x009a:
            r0 = move-exception
            r2 = r0
            r19 = r3
            r18 = r4
            r11 = r5
            goto L_0x03a4
        L_0x00a3:
            anet.channel.statist.RequestStatistic r11 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x039d, SSLException -> 0x0335, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r14 = r3
            r18 = r4
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x0288, SSLException -> 0x0282, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r11.sendStart = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x0288, SSLException -> 0x0282, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.statist.RequestStatistic r3 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x0288, SSLException -> 0x0282, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r11 = r5
            long r4 = r3.sendStart     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x0280, SSLException -> 0x027e, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.statist.RequestStatistic r15 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x0280, SSLException -> 0x027e, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r19 = r14
            long r14 = r15.start     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            long r4 = r4 - r14
            r3.processTime = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r13.connect()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            a((java.net.HttpURLConnection) r13, (anet.channel.request.Request) r12)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.statist.RequestStatistic r3 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r3.sendEnd = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.statist.RequestStatistic r3 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            long r4 = r3.sendEnd     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.statist.RequestStatistic r14 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            long r14 = r14.sendStart     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            long r4 = r4 - r14
            r3.sendDataTime = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            int r3 = r13.getResponseCode()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r10.f3838a = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.util.Map r3 = r13.getHeaderFields()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.util.Map r3 = anet.channel.util.HttpHelper.cloneMap(r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r10.f3840c = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.lang.String r3 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.lang.String r4 = "response code"
            r14 = 0
            r5[r14] = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            int r4 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r14 = 1
            r5[r14] = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.util.ALog.i(r9, r7, r3, r5)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.lang.String r3 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.lang.String r4 = "response headers"
            r14 = 0
            r5[r14] = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r14 = 1
            r5[r14] = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            anet.channel.util.ALog.i(r9, r7, r3, r5)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            int r3 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            boolean r3 = anet.channel.util.HttpHelper.checkRedirect(r12, r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            if (r3 == 0) goto L_0x01ab
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            java.lang.String r4 = "Location"
            java.lang.String r3 = anet.channel.util.HttpHelper.getSingleHeaderFieldByKey(r3, r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            if (r3 == 0) goto L_0x01ab
            anet.channel.util.HttpUrl r4 = anet.channel.util.HttpUrl.parse(r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            if (r4 == 0) goto L_0x0194
            java.lang.String r5 = "redirect"
            java.lang.String r14 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0292 }
            r20 = r7
            r15 = 2
            java.lang.Object[] r7 = new java.lang.Object[r15]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r15 = "to url"
            r17 = 0
            r7[r17] = r15     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r15 = r4.toString()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r16 = 1
            r7[r16] = r15     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.util.ALog.i(r9, r5, r14, r7)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.request.Request$Builder r5 = r12.newBuilder()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r7 = "GET"
            anet.channel.request.Request$Builder r5 = r5.setMethod(r7)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r7 = 0
            anet.channel.request.Request$Builder r5 = r5.setBody(r7)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.request.Request$Builder r5 = r5.setUrl((anet.channel.util.HttpUrl) r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            int r14 = r12.getRedirectTimes()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r15 = 1
            int r14 = r14 + r15
            anet.channel.request.Request$Builder r5 = r5.setRedirectTimes(r14)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.request.Request$Builder r5 = r5.setSslSocketFactory(r7)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.request.Request$Builder r5 = r5.setHostnameVerifier(r7)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.request.Request r12 = r5.build()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r5 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            int r7 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r4 = r4.simpleUrlString()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r5.recordRedirect(r7, r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r4 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r4.locationUrl = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r13.disconnect()     // Catch:{ Exception -> 0x0181 }
            goto L_0x018a
        L_0x0181:
            r0 = move-exception
            r3 = r0
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            anet.channel.util.ALog.e(r9, r8, r5, r3, r4)
        L_0x018a:
            r5 = r11
            r4 = r18
            r3 = r19
            r7 = r20
            r11 = 0
            goto L_0x0025
        L_0x0194:
            r20 = r7
            java.lang.String r4 = "redirect url is invalid!"
            java.lang.String r5 = r12.getSeq()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r7 = 2
            java.lang.Object[] r14 = new java.lang.Object[r7]     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r7 = "redirect url"
            r15 = 0
            r14[r15] = r7     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r7 = 1
            r14[r7] = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.util.ALog.e(r9, r4, r5, r14)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            goto L_0x01ad
        L_0x01ab:
            r20 = r7
        L_0x01ad:
            anet.channel.statist.RequestStatistic r3 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r4 = anet.channel.util.HttpHelper.getSingleHeaderFieldByKey(r4, r2)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r3.contentEncoding = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r3 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r5 = "Content-Type"
            java.lang.String r4 = anet.channel.util.HttpHelper.getSingleHeaderFieldByKey(r4, r5)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r3.contentType = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r3 = "HEAD"
            java.lang.String r4 = r12.getMethod()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            boolean r3 = r3.equals(r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            if (r3 != 0) goto L_0x021e
            int r3 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r4 = 304(0x130, float:4.26E-43)
            if (r3 == r4) goto L_0x021e
            r4 = 204(0xcc, float:2.86E-43)
            if (r3 == r4) goto L_0x021e
            r4 = 100
            if (r3 < r4) goto L_0x01e2
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 >= r4) goto L_0x01e2
            goto L_0x021e
        L_0x01e2:
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            int r3 = anet.channel.util.HttpHelper.parseContentLength(r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r10.f3841d = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r4 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r14 = (long) r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r4.contentLength = r14     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r3 = "gzip"
            anet.channel.statist.RequestStatistic r4 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r4 = r4.contentEncoding     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r10.f3842e = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            if (r3 == 0) goto L_0x0209
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r3.remove(r2)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r3 = "Content-Length"
            r2.remove(r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
        L_0x0209:
            if (r1 == 0) goto L_0x0212
            int r2 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r1.onResponseCode(r2, r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
        L_0x0212:
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r2.rspStart = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            a(r13, r12, r10, r1)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            goto L_0x022f
        L_0x021e:
            if (r1 == 0) goto L_0x0227
            int r2 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3 = r10.f3840c     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r1.onResponseCode(r2, r3)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
        L_0x0227:
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r2.rspStart = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
        L_0x022f:
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r3 = r2.rspStart     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r5 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r14 = r5.sendEnd     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r3 = r3 - r14
            r2.firstDataTime = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.isDone     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            boolean r2 = r2.get()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            java.lang.String r3 = "SUCCESS"
            if (r2 != 0) goto L_0x025d
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r4 = 1
            r2.ret = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            int r4 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r2.statusCode = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r2.msg = r3     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r2 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r2.rspEnd = r4     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
        L_0x025d:
            if (r1 == 0) goto L_0x0266
            int r2 = r10.f3838a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            anet.channel.statist.RequestStatistic r4 = r12.f3782a     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
            r1.onFinish(r2, r3, r4)     // Catch:{ UnknownHostException -> 0x0479, SocketTimeoutException -> 0x0453, ConnectTimeoutException -> 0x042d, ConnectException -> 0x0405, SSLHandshakeException -> 0x027b, SSLException -> 0x0278, CancellationException -> 0x0311, IOException -> 0x02dc, Exception -> 0x0276 }
        L_0x0266:
            r13.disconnect()     // Catch:{ Exception -> 0x026b }
            goto L_0x04ab
        L_0x026b:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x0276:
            r0 = move-exception
            goto L_0x0295
        L_0x0278:
            r0 = move-exception
            goto L_0x033b
        L_0x027b:
            r0 = move-exception
            goto L_0x03a3
        L_0x027e:
            r0 = move-exception
            goto L_0x0284
        L_0x0280:
            r0 = move-exception
            goto L_0x028a
        L_0x0282:
            r0 = move-exception
            r11 = r5
        L_0x0284:
            r19 = r14
            goto L_0x033b
        L_0x0288:
            r0 = move-exception
            r11 = r5
        L_0x028a:
            r19 = r14
            goto L_0x03a3
        L_0x028e:
            r0 = move-exception
            r1 = r0
            goto L_0x04ac
        L_0x0292:
            r0 = move-exception
            r20 = r7
        L_0x0295:
            r2 = r0
        L_0x0296:
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x028e }
            if (r3 == 0) goto L_0x02a1
            java.lang.String r7 = r2.getMessage()     // Catch:{ all -> 0x028e }
            goto L_0x02a3
        L_0x02a1:
            r7 = r20
        L_0x02a3:
            java.lang.String r3 = "not verified"
            boolean r3 = r7.contains(r3)     // Catch:{ all -> 0x028e }
            if (r3 == 0) goto L_0x02ba
            anet.channel.strategy.c r3 = anet.channel.strategy.c.a.f3918a     // Catch:{ all -> 0x028e }
            java.lang.String r4 = r12.getHost()     // Catch:{ all -> 0x028e }
            r3.b(r4)     // Catch:{ all -> 0x028e }
            r3 = -403(0xfffffffffffffe6d, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            goto L_0x02bf
        L_0x02ba:
            r3 = -101(0xffffffffffffff9b, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
        L_0x02bf:
            java.lang.String r1 = "HTTP Exception"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r2, r5)     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x02d2 }
            goto L_0x04ab
        L_0x02d2:
            r0 = move-exception
            r1 = r0
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x02dc:
            r0 = move-exception
            r2 = r0
            r3 = -404(0xfffffffffffffe6c, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "IO Exception"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            r5 = 0
            r4[r5] = r6     // Catch:{ all -> 0x028e }
            java.lang.String r5 = r12.getHost()     // Catch:{ all -> 0x028e }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x028e }
            r5 = 2
            r4[r5] = r2     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r4)     // Catch:{ all -> 0x028e }
            anet.channel.status.NetworkStatusHelper.printNetworkDetail()     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x0306 }
            goto L_0x04ab
        L_0x0306:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x0311:
            r0 = move-exception
            r2 = r0
            r3 = -204(0xffffffffffffff34, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "HTTP Request Cancel"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r2, r5)     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x032b }
            goto L_0x04ab
        L_0x032b:
            r0 = move-exception
            r1 = r0
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x0335:
            r0 = move-exception
            r19 = r3
            r18 = r4
            r11 = r5
        L_0x033b:
            r2 = r0
        L_0x033c:
            anet.channel.strategy.c r3 = anet.channel.strategy.c.a.f3918a     // Catch:{ all -> 0x028e }
            java.lang.String r4 = r12.getHost()     // Catch:{ all -> 0x028e }
            r3.b(r4)     // Catch:{ all -> 0x028e }
            r3 = -402(0xfffffffffffffe6e, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "connect SSLException"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 3
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            r4 = 0
            r5[r4] = r6     // Catch:{ all -> 0x028e }
            java.lang.String r4 = r12.getHost()     // Catch:{ all -> 0x028e }
            r6 = 1
            r5[r6] = r4     // Catch:{ all -> 0x028e }
            r4 = 2
            r5[r4] = r2     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r5)     // Catch:{ all -> 0x028e }
            boolean r1 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x028e }
            if (r1 == 0) goto L_0x038b
            r1 = r13
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x028e }
            javax.net.ssl.SSLSocketFactory r1 = r1.getSSLSocketFactory()     // Catch:{ all -> 0x028e }
            r2 = r13
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ all -> 0x028e }
            javax.net.ssl.HostnameVerifier r2 = r2.getHostnameVerifier()     // Catch:{ all -> 0x028e }
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            r5 = 0
            r4[r5] = r18     // Catch:{ all -> 0x028e }
            r5 = 1
            r4[r5] = r1     // Catch:{ all -> 0x028e }
            r1 = 2
            r4[r1] = r19     // Catch:{ all -> 0x028e }
            r1 = 3
            r4[r1] = r2     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r11, r3, r4)     // Catch:{ all -> 0x028e }
        L_0x038b:
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x0392 }
            goto L_0x04ab
        L_0x0392:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x039d:
            r0 = move-exception
            r19 = r3
            r18 = r4
            r11 = r5
        L_0x03a3:
            r2 = r0
        L_0x03a4:
            anet.channel.strategy.c r3 = anet.channel.strategy.c.a.f3918a     // Catch:{ all -> 0x028e }
            java.lang.String r4 = r12.getHost()     // Catch:{ all -> 0x028e }
            r3.b(r4)     // Catch:{ all -> 0x028e }
            r3 = -402(0xfffffffffffffe6e, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "HTTP Connect SSLHandshakeException"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 3
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            r4 = 0
            r5[r4] = r6     // Catch:{ all -> 0x028e }
            java.lang.String r4 = r12.getHost()     // Catch:{ all -> 0x028e }
            r6 = 1
            r5[r6] = r4     // Catch:{ all -> 0x028e }
            r4 = 2
            r5[r4] = r2     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r5)     // Catch:{ all -> 0x028e }
            boolean r1 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x028e }
            if (r1 == 0) goto L_0x03f3
            r1 = r13
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x028e }
            javax.net.ssl.SSLSocketFactory r1 = r1.getSSLSocketFactory()     // Catch:{ all -> 0x028e }
            r2 = r13
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ all -> 0x028e }
            javax.net.ssl.HostnameVerifier r2 = r2.getHostnameVerifier()     // Catch:{ all -> 0x028e }
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            r5 = 0
            r4[r5] = r18     // Catch:{ all -> 0x028e }
            r5 = 1
            r4[r5] = r1     // Catch:{ all -> 0x028e }
            r1 = 2
            r4[r1] = r19     // Catch:{ all -> 0x028e }
            r1 = 3
            r4[r1] = r2     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r11, r3, r4)     // Catch:{ all -> 0x028e }
        L_0x03f3:
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x03fa }
            goto L_0x04ab
        L_0x03fa:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x0405:
            r0 = move-exception
            r2 = r0
            r3 = -406(0xfffffffffffffe6a, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "HTTP Connect Exception"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r2, r5)     // Catch:{ all -> 0x028e }
            anet.channel.status.NetworkStatusHelper.printNetworkDetail()     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x0422 }
            goto L_0x04ab
        L_0x0422:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x042d:
            r0 = move-exception
            r2 = r0
            r3 = -400(0xfffffffffffffe70, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "HTTP Connect Timeout"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r2, r5)     // Catch:{ all -> 0x028e }
            anet.channel.status.NetworkStatusHelper.printNetworkDetail()     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x0449 }
            goto L_0x04ab
        L_0x0449:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x0453:
            r0 = move-exception
            r2 = r0
            r3 = -401(0xfffffffffffffe6f, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "HTTP Socket Timeout"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r2, r5)     // Catch:{ all -> 0x028e }
            anet.channel.status.NetworkStatusHelper.printNetworkDetail()     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x046f }
            goto L_0x04ab
        L_0x046f:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
            goto L_0x04ab
        L_0x0479:
            r0 = move-exception
            r2 = r0
            r3 = -405(0xfffffffffffffe6b, float:NaN)
            a(r12, r10, r1, r3, r2)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = "Unknown Host Exception"
            java.lang.String r3 = r12.getSeq()     // Catch:{ all -> 0x028e }
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x028e }
            r5 = 0
            r4[r5] = r6     // Catch:{ all -> 0x028e }
            java.lang.String r5 = r12.getHost()     // Catch:{ all -> 0x028e }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x028e }
            r5 = 2
            r4[r5] = r2     // Catch:{ all -> 0x028e }
            anet.channel.util.ALog.e(r9, r1, r3, r4)     // Catch:{ all -> 0x028e }
            anet.channel.status.NetworkStatusHelper.printNetworkDetail()     // Catch:{ all -> 0x028e }
            if (r13 == 0) goto L_0x04ab
            r13.disconnect()     // Catch:{ Exception -> 0x04a2 }
            goto L_0x04ab
        L_0x04a2:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r9, r8, r3, r1, r2)
        L_0x04ab:
            return r10
        L_0x04ac:
            if (r13 == 0) goto L_0x04bb
            r13.disconnect()     // Catch:{ Exception -> 0x04b2 }
            goto L_0x04bb
        L_0x04b2:
            r0 = move-exception
            r2 = r0
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            anet.channel.util.ALog.e(r9, r8, r4, r2, r3)
        L_0x04bb:
            throw r1
        L_0x04bc:
            r4 = r11
            if (r1 == 0) goto L_0x04cd
            r2 = -102(0xffffffffffffff9a, float:NaN)
            java.lang.String r3 = anet.channel.util.ErrorConstant.getErrMsg(r2)
            anet.channel.statist.RequestStatistic r5 = new anet.channel.statist.RequestStatistic
            r5.<init>(r4, r4)
            r1.onFinish(r2, r3, r5)
        L_0x04cd:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.session.b$a");
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i10, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i10);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), "errorCode", Integer.valueOf(i10), "errMsg", errMsg, "url", request.getUrlString(), Constants.KEY_HOST, request.getHost());
        if (aVar != null) {
            aVar.f3838a = i10;
        }
        if (!request.f3782a.isDone.get()) {
            request.f3782a.statusCode = i10;
            request.f3782a.msg = errMsg;
            request.f3782a.rspEnd = System.currentTimeMillis();
            if (i10 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i10, errMsg, request.f3782a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i10, errMsg, request.f3782a);
        }
    }

    private static HttpURLConnection a(Request request) {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        g a10 = g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && a10 != null) {
            proxy = a10.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry next : headers.entrySet()) {
            httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        String str = headers.get("Host");
        if (str == null) {
            str = request.getHost();
        }
        String concatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(str, SOAP.DELIM, String.valueOf(request.getHttpUrl().getPort())) : str;
        httpURLConnection.setRequestProperty("Host", concatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, concatString);
        }
        if (!headers.containsKey("Accept-Encoding")) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (a10 != null) {
            httpURLConnection.setRequestProperty("Authorization", a10.c());
        }
        if (url.getProtocol().equalsIgnoreCase("https")) {
            a(httpURLConnection, request, str);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.f4007a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.f4007a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.f4008b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.f4008b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) {
        int i10 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                int postBody = request.postBody(outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.flush();
                        outputStream2.close();
                    } catch (IOException e10) {
                        ALog.e("awcn.HttpConnector", com.hpplay.a.a.a.b.f10433a, request.getSeq(), e10, new Object[0]);
                    }
                }
                i10 = postBody;
            } catch (Exception e11) {
                ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e11, new Object[0]);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e12) {
                        ALog.e("awcn.HttpConnector", com.hpplay.a.a.a.b.f10433a, request.getSeq(), e12, new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e13) {
                        ALog.e("awcn.HttpConnector", com.hpplay.a.a.a.b.f10433a, request.getSeq(), e13, new Object[0]);
                    }
                }
                throw th;
            }
            long j10 = (long) i10;
            request.f3782a.reqBodyInflateSize = j10;
            request.f3782a.reqBodyDeflateSize = j10;
            request.f3782a.sendDataSize = j10;
        }
        return i10;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        httpURLConnection.getURL().toString();
        anet.channel.util.a aVar2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e10) {
            if (e10 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                inputStream = httpURLConnection.getErrorStream();
            } catch (Exception e11) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e11, new Object[0]);
                inputStream = null;
            }
        }
        if (inputStream == null) {
            a(request, aVar, requestCb, -404, (Throwable) null);
            return;
        }
        if (requestCb == null) {
            int i10 = aVar.f3841d;
            if (i10 <= 0) {
                i10 = 1024;
            } else if (aVar.f3842e) {
                i10 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i10);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            anet.channel.util.a aVar3 = new anet.channel.util.a(inputStream);
            try {
                inputStream = aVar.f3842e ? new GZIPInputStream(aVar3) : aVar3;
                ByteArray byteArray = null;
                while (!Thread.currentThread().isInterrupted()) {
                    if (byteArray == null) {
                        byteArray = a.C0060a.f3631a.a(2048);
                    }
                    int readFrom = byteArray.readFrom(inputStream);
                    if (readFrom != -1) {
                        if (byteArrayOutputStream != null) {
                            byteArray.writeTo(byteArrayOutputStream);
                        } else {
                            requestCb.onDataReceive(byteArray, false);
                            byteArray = null;
                        }
                        long j10 = (long) readFrom;
                        request.f3782a.recDataSize += j10;
                        request.f3782a.rspBodyInflateSize += j10;
                    } else {
                        if (byteArrayOutputStream != null) {
                            byteArray.recycle();
                        } else {
                            requestCb.onDataReceive(byteArray, true);
                        }
                        if (byteArrayOutputStream != null) {
                            aVar.f3839b = byteArrayOutputStream.toByteArray();
                        }
                        request.f3782a.recDataTime = System.currentTimeMillis() - request.f3782a.rspStart;
                        request.f3782a.rspBodyDeflateSize = aVar3.a();
                        try {
                            inputStream.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                }
                throw new CancellationException("task cancelled");
            } catch (Throwable th) {
                th = th;
                aVar2 = aVar3;
                request.f3782a.recDataTime = System.currentTimeMillis() - request.f3782a.rspStart;
                request.f3782a.rspBodyDeflateSize = aVar2.a();
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            request.f3782a.recDataTime = System.currentTimeMillis() - request.f3782a.rspStart;
            request.f3782a.rspBodyDeflateSize = aVar2.a();
            inputStream.close();
            throw th;
        }
    }
}
