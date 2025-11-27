package anet.channel.strategy.dispatch;

import android.util.Base64InputStream;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.c;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.common.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;

class b {

    /* renamed from: a  reason: collision with root package name */
    static AtomicInteger f3932a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    static HostnameVerifier f3933b = new c();

    /* renamed from: c  reason: collision with root package name */
    static Random f3934c = new Random();

    public static List<IConnStrategy> a(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.isProxy()) {
            list = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!listIterator.next().getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    public static void a(Map map) {
        String str;
        IConnStrategy iConnStrategy;
        String str2;
        String str3;
        if (map != null) {
            if (AmdcRuntimeInfo.isForceHttps()) {
                str = "https";
            } else {
                str = StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
            }
            List<IConnStrategy> a10 = a(str);
            int i10 = 0;
            while (i10 < 3) {
                HashMap hashMap = new HashMap(map);
                if (i10 != 2) {
                    iConnStrategy = !a10.isEmpty() ? a10.remove(0) : null;
                    if (iConnStrategy != null) {
                        str2 = a(str, iConnStrategy.getIp(), iConnStrategy.getPort(), (Map<String, String>) hashMap, i10);
                    } else {
                        str2 = a(str, (String) null, 0, (Map<String, String>) hashMap, i10);
                    }
                } else {
                    String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                    if (amdcServerFixIp == null || amdcServerFixIp.length <= 0) {
                        str3 = a(str, (String) null, 0, (Map<String, String>) hashMap, i10);
                    } else {
                        str3 = a(str, amdcServerFixIp[f3934c.nextInt(amdcServerFixIp.length)], 0, (Map<String, String>) hashMap, i10);
                    }
                    String str4 = str3;
                    iConnStrategy = null;
                    str2 = str4;
                }
                int a11 = a(str2, (Map) hashMap, i10);
                if (iConnStrategy != null) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = a11 == 0;
                    StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategy, connEvent);
                }
                if (a11 != 0 && a11 != 2) {
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    private static String a(String str, String str2, int i10, Map<String, String> map, int i11) {
        StringBuilder sb = new StringBuilder(64);
        if (!AmdcRuntimeInfo.isForceHttps() && i11 == 2 && "https".equalsIgnoreCase(str) && f3934c.nextBoolean()) {
            str = HttpConstant.HTTP;
        }
        sb.append(str);
        sb.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (c.a() && d.a(str2)) {
                try {
                    str2 = c.a(str2);
                } catch (Exception unused) {
                }
            }
            if (d.b(str2)) {
                sb.append('[');
                sb.append(str2);
                sb.append(']');
            } else {
                sb.append(str2);
            }
            if (i10 == 0) {
                i10 = "https".equalsIgnoreCase(str) ? Constants.PORT : 80;
            }
            sb.append(SOAP.DELIM);
            sb.append(i10);
        } else {
            sb.append(DispatchConstants.getAmdcServerDomain());
        }
        sb.append(DispatchConstants.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put(DispatchConstants.PLATFORM, map.remove(DispatchConstants.PLATFORM));
        sb.append('?');
        sb.append(d.a(treeMap, XML.CHARSET_UTF8));
        return sb.toString();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:108|109|(2:110|111)|114) */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        anet.channel.strategy.dispatch.HttpDispatcher.getInstance().a(new anet.channel.strategy.dispatch.DispatchEvent(0, (java.lang.Object) null));
        anet.channel.util.ALog.e(r10, "resolve amdc anser failed", r5, new java.lang.Object[0]);
        a("-1004", "resolve answer failed", r14, r2, 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r15.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0287, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0288, code lost:
        anet.channel.util.ALog.e(r10, "http disconnect failed", (java.lang.String) null, r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0290, code lost:
        return 1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x0267 */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02a5 A[Catch:{ all -> 0x02e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02b1 A[SYNTHETIC, Splitter:B:129:0x02b1] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02d3 A[SYNTHETIC, Splitter:B:140:0x02d3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r18, java.util.Map r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "gzip"
            java.lang.String r4 = "http disconnect failed"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "AMDC"
            r5.append(r6)
            java.util.concurrent.atomic.AtomicInteger r6 = f3932a
            int r6 = r6.incrementAndGet()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = 4
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.String r8 = "url"
            r9 = 0
            r7[r9] = r8
            r8 = 1
            r7[r8] = r0
            java.lang.String r10 = "\nhost"
            r11 = 2
            r7[r11] = r10
            java.lang.String r10 = "domain"
            java.lang.Object r10 = r1.get(r10)
            java.lang.String r10 = r10.toString()
            r12 = 3
            r7[r12] = r10
            java.lang.String r10 = "awcn.DispatchCore"
            java.lang.String r13 = "send amdc request"
            anet.channel.util.ALog.i(r10, r13, r5, r7)
            java.lang.String r7 = "Env"
            java.lang.Object r7 = r1.remove(r7)
            anet.channel.entity.ENV r7 = (anet.channel.entity.ENV) r7
            java.net.URL r14 = new java.net.URL     // Catch:{ all -> 0x0298 }
            r14.<init>(r0)     // Catch:{ all -> 0x0298 }
            java.net.URLConnection r15 = r14.openConnection()     // Catch:{ all -> 0x0296 }
            java.net.HttpURLConnection r15 = (java.net.HttpURLConnection) r15     // Catch:{ all -> 0x0296 }
            r12 = 20000(0x4e20, float:2.8026E-41)
            r15.setConnectTimeout(r12)     // Catch:{ all -> 0x0294 }
            r15.setReadTimeout(r12)     // Catch:{ all -> 0x0294 }
            java.lang.String r12 = "POST"
            r15.setRequestMethod(r12)     // Catch:{ all -> 0x0294 }
            r15.setDoOutput(r8)     // Catch:{ all -> 0x0294 }
            r15.setDoInput(r8)     // Catch:{ all -> 0x0294 }
            java.lang.String r12 = "Connection"
            java.lang.String r6 = "close"
            r15.addRequestProperty(r12, r6)     // Catch:{ all -> 0x0294 }
            java.lang.String r6 = "Accept-Encoding"
            r15.addRequestProperty(r6, r3)     // Catch:{ all -> 0x0294 }
            java.lang.String r6 = "Host"
            java.lang.String r12 = anet.channel.strategy.dispatch.DispatchConstants.getAmdcServerDomain()     // Catch:{ all -> 0x0294 }
            r15.addRequestProperty(r6, r12)     // Catch:{ all -> 0x0294 }
            r15.setInstanceFollowRedirects(r9)     // Catch:{ all -> 0x0294 }
            java.lang.String r6 = r14.getProtocol()     // Catch:{ all -> 0x0294 }
            java.lang.String r12 = "https"
            boolean r6 = r6.equals(r12)     // Catch:{ all -> 0x0294 }
            if (r6 == 0) goto L_0x00b0
            r6 = r15
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ all -> 0x0294 }
            javax.net.ssl.HostnameVerifier r12 = f3933b     // Catch:{ all -> 0x0294 }
            r6.setHostnameVerifier(r12)     // Catch:{ all -> 0x0294 }
            boolean r6 = anet.channel.AwcnConfig.isHttpsSniEnable()     // Catch:{ all -> 0x0294 }
            if (r6 == 0) goto L_0x00b0
            r6 = r15
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ all -> 0x0294 }
            anet.channel.util.j r12 = new anet.channel.util.j     // Catch:{ all -> 0x0294 }
            java.lang.String r13 = anet.channel.strategy.dispatch.DispatchConstants.getAmdcServerDomain()     // Catch:{ all -> 0x0294 }
            r12.<init>(r13)     // Catch:{ all -> 0x0294 }
            r6.setSSLSocketFactory(r12)     // Catch:{ all -> 0x0294 }
        L_0x00b0:
            boolean r6 = anet.channel.util.ALog.isPrintLog(r8)     // Catch:{ all -> 0x0294 }
            if (r6 == 0) goto L_0x00cb
            java.lang.String r6 = "amdc request."
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ all -> 0x0294 }
            java.lang.String r13 = "headers"
            r12[r9] = r13     // Catch:{ all -> 0x0294 }
            java.util.Map r13 = r15.getRequestProperties()     // Catch:{ all -> 0x0294 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0294 }
            r12[r8] = r13     // Catch:{ all -> 0x0294 }
            anet.channel.util.ALog.d(r10, r6, r5, r12)     // Catch:{ all -> 0x0294 }
        L_0x00cb:
            java.io.OutputStream r6 = r15.getOutputStream()     // Catch:{ all -> 0x0294 }
            java.lang.String r12 = "utf-8"
            java.lang.String r1 = anet.channel.strategy.utils.d.a(r1, r12)     // Catch:{ all -> 0x0294 }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x0294 }
            r6.write(r1)     // Catch:{ all -> 0x0294 }
            int r6 = r15.getResponseCode()     // Catch:{ all -> 0x0294 }
            boolean r12 = anet.channel.util.ALog.isPrintLog(r8)     // Catch:{ all -> 0x0294 }
            if (r12 == 0) goto L_0x0106
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r12.<init>()     // Catch:{ all -> 0x0294 }
            java.lang.String r13 = "amdc response. code: "
            r12.append(r13)     // Catch:{ all -> 0x0294 }
            r12.append(r6)     // Catch:{ all -> 0x0294 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0294 }
            java.lang.Object[] r13 = new java.lang.Object[r11]     // Catch:{ all -> 0x0294 }
            java.lang.String r16 = "\nheaders"
            r13[r9] = r16     // Catch:{ all -> 0x0294 }
            java.util.Map r16 = r15.getHeaderFields()     // Catch:{ all -> 0x0294 }
            r13[r8] = r16     // Catch:{ all -> 0x0294 }
            anet.channel.util.ALog.d(r10, r12, r5, r13)     // Catch:{ all -> 0x0294 }
        L_0x0106:
            r12 = 200(0xc8, float:2.8E-43)
            if (r6 == r12) goto L_0x012c
            r0 = 302(0x12e, float:4.23E-43)
            if (r6 == r0) goto L_0x0115
            r0 = 307(0x133, float:4.3E-43)
            if (r6 != r0) goto L_0x0113
            goto L_0x0115
        L_0x0113:
            r1 = 1
            goto L_0x0116
        L_0x0115:
            r1 = 2
        L_0x0116:
            java.lang.String r0 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0294 }
            java.lang.String r3 = "response code not 200"
            a((java.lang.String) r0, (java.lang.String) r3, (java.net.URL) r14, (int) r2, (int) r1)     // Catch:{ all -> 0x0294 }
            r15.disconnect()     // Catch:{ Exception -> 0x0123 }
            goto L_0x012b
        L_0x0123:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r3 = 0
            anet.channel.util.ALog.e(r10, r4, r3, r2, r0)
        L_0x012b:
            return r1
        L_0x012c:
            java.lang.String r6 = "x-am-code"
            java.lang.String r6 = r15.getHeaderField(r6)     // Catch:{ all -> 0x0294 }
            java.lang.String r12 = "1000"
            boolean r12 = r12.equals(r6)     // Catch:{ all -> 0x0294 }
            if (r12 != 0) goto L_0x016f
            java.lang.String r0 = "1007"
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x0294 }
            if (r0 != 0) goto L_0x014d
            java.lang.String r0 = "1008"
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            r1 = 1
            goto L_0x014e
        L_0x014d:
            r1 = 2
        L_0x014e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r0.<init>()     // Catch:{ all -> 0x0294 }
            java.lang.String r3 = "return code: "
            r0.append(r3)     // Catch:{ all -> 0x0294 }
            r0.append(r6)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0294 }
            a((java.lang.String) r6, (java.lang.String) r0, (java.net.URL) r14, (int) r2, (int) r1)     // Catch:{ all -> 0x0294 }
            r15.disconnect()     // Catch:{ Exception -> 0x0166 }
            goto L_0x016e
        L_0x0166:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r3 = 0
            anet.channel.util.ALog.e(r10, r4, r3, r2, r0)
        L_0x016e:
            return r1
        L_0x016f:
            java.lang.String r12 = "x-am-sign"
            java.lang.String r12 = r15.getHeaderField(r12)     // Catch:{ all -> 0x0294 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0294 }
            if (r13 == 0) goto L_0x018f
            java.lang.String r0 = "-1001"
            java.lang.String r1 = "response sign is empty"
            a((java.lang.String) r0, (java.lang.String) r1, (java.net.URL) r14, (int) r2, (int) r8)     // Catch:{ all -> 0x0294 }
            r15.disconnect()     // Catch:{ Exception -> 0x0186 }
            goto L_0x018e
        L_0x0186:
            r0 = move-exception
            r1 = r0
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r2 = 0
            anet.channel.util.ALog.e(r10, r4, r2, r1, r0)
        L_0x018e:
            return r8
        L_0x018f:
            java.io.InputStream r13 = r15.getInputStream()     // Catch:{ all -> 0x0294 }
            java.lang.String r9 = r15.getContentEncoding()     // Catch:{ all -> 0x0294 }
            boolean r3 = r3.equalsIgnoreCase(r9)     // Catch:{ all -> 0x0294 }
            java.lang.String r3 = a(r13, r3)     // Catch:{ all -> 0x0294 }
            boolean r9 = anet.channel.util.ALog.isPrintLog(r8)     // Catch:{ all -> 0x0294 }
            if (r9 == 0) goto L_0x01b4
            java.lang.String r9 = "amdc response body"
            java.lang.Object[] r13 = new java.lang.Object[r11]     // Catch:{ all -> 0x0294 }
            java.lang.String r17 = "\nbody"
            r16 = 0
            r13[r16] = r17     // Catch:{ all -> 0x0294 }
            r13[r8] = r3     // Catch:{ all -> 0x0294 }
            anet.channel.util.ALog.d(r10, r9, r5, r13)     // Catch:{ all -> 0x0294 }
        L_0x01b4:
            int r1 = r1.length     // Catch:{ all -> 0x0294 }
            r19 = r12
            long r11 = (long) r1     // Catch:{ all -> 0x0294 }
            int r1 = r15.getContentLength()     // Catch:{ all -> 0x0294 }
            r13 = r10
            long r9 = (long) r1
            a((java.lang.String) r0, (long) r11, (long) r9)     // Catch:{ all -> 0x0291 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0291 }
            if (r0 == 0) goto L_0x01dd
            java.lang.String r0 = "-1002"
            java.lang.String r1 = "read answer error"
            a((java.lang.String) r0, (java.lang.String) r1, (java.net.URL) r14, (int) r2, (int) r8)     // Catch:{ all -> 0x0291 }
            r15.disconnect()     // Catch:{ Exception -> 0x01d2 }
            goto L_0x01dc
        L_0x01d2:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r10 = r13
            r2 = 0
            anet.channel.util.ALog.e(r10, r4, r2, r1, r0)
        L_0x01dc:
            return r8
        L_0x01dd:
            r10 = r13
            anet.channel.strategy.dispatch.IAmdcSign r0 = anet.channel.strategy.dispatch.AmdcRuntimeInfo.getSign()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x01eb
            java.lang.String r0 = r0.sign(r3)     // Catch:{ all -> 0x0294 }
            r1 = r19
            goto L_0x01ee
        L_0x01eb:
            r1 = r19
            r0 = 0
        L_0x01ee:
            boolean r9 = r0.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0294 }
            if (r9 != 0) goto L_0x0220
            java.lang.String r3 = "check ret sign failed"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0294 }
            java.lang.String r7 = "retSign"
            r9 = 0
            r6[r9] = r7     // Catch:{ all -> 0x0294 }
            r6[r8] = r1     // Catch:{ all -> 0x0294 }
            java.lang.String r1 = "checkSign"
            r7 = 2
            r6[r7] = r1     // Catch:{ all -> 0x0294 }
            r1 = 3
            r6[r1] = r0     // Catch:{ all -> 0x0294 }
            anet.channel.util.ALog.e(r10, r3, r5, r6)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = "-1003"
            java.lang.String r1 = "check sign failed"
            a((java.lang.String) r0, (java.lang.String) r1, (java.net.URL) r14, (int) r2, (int) r8)     // Catch:{ all -> 0x0294 }
            r15.disconnect()     // Catch:{ Exception -> 0x0216 }
            goto L_0x021f
        L_0x0216:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r2 = 0
            anet.channel.util.ALog.e(r10, r4, r2, r1, r0)
        L_0x021f:
            return r8
        L_0x0220:
            org.json.JSONTokener r0 = new org.json.JSONTokener     // Catch:{ JSONException -> 0x0267 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0267 }
            java.lang.Object r0 = r0.nextValue()     // Catch:{ JSONException -> 0x0267 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0267 }
            anet.channel.entity.ENV r1 = anet.channel.GlobalAppRuntimeInfo.getEnv()     // Catch:{ JSONException -> 0x0267 }
            if (r1 == r7) goto L_0x0248
            java.lang.String r0 = "env change, do not notify result"
            r1 = 0
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x0267 }
            anet.channel.util.ALog.w(r10, r0, r5, r3)     // Catch:{ JSONException -> 0x0267 }
            r15.disconnect()     // Catch:{ Exception -> 0x023e }
            r2 = 0
            goto L_0x0247
        L_0x023e:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r3 = 0
            anet.channel.util.ALog.e(r10, r4, r3, r1, r0)
        L_0x0247:
            return r2
        L_0x0248:
            anet.channel.strategy.dispatch.HttpDispatcher r1 = anet.channel.strategy.dispatch.HttpDispatcher.getInstance()     // Catch:{ JSONException -> 0x0267 }
            anet.channel.strategy.dispatch.DispatchEvent r3 = new anet.channel.strategy.dispatch.DispatchEvent     // Catch:{ JSONException -> 0x0267 }
            r3.<init>(r8, r0)     // Catch:{ JSONException -> 0x0267 }
            r1.a(r3)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r0 = "request success"
            r1 = 0
            a((java.lang.String) r6, (java.lang.String) r0, (java.net.URL) r14, (int) r2, (int) r1)     // Catch:{ all -> 0x0294 }
            r15.disconnect()     // Catch:{ Exception -> 0x025e }
            goto L_0x0266
        L_0x025e:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r3 = 0
            anet.channel.util.ALog.e(r10, r4, r3, r2, r0)
        L_0x0266:
            return r1
        L_0x0267:
            anet.channel.strategy.dispatch.HttpDispatcher r0 = anet.channel.strategy.dispatch.HttpDispatcher.getInstance()     // Catch:{ all -> 0x0294 }
            anet.channel.strategy.dispatch.DispatchEvent r1 = new anet.channel.strategy.dispatch.DispatchEvent     // Catch:{ all -> 0x0294 }
            r3 = 0
            r6 = 0
            r1.<init>(r3, r6)     // Catch:{ all -> 0x0294 }
            r0.a(r1)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = "resolve amdc anser failed"
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x0294 }
            anet.channel.util.ALog.e(r10, r0, r5, r1)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = "-1004"
            java.lang.String r1 = "resolve answer failed"
            a((java.lang.String) r0, (java.lang.String) r1, (java.net.URL) r14, (int) r2, (int) r8)     // Catch:{ all -> 0x0294 }
            r15.disconnect()     // Catch:{ Exception -> 0x0287 }
            goto L_0x0290
        L_0x0287:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r2 = 0
            anet.channel.util.ALog.e(r10, r4, r2, r1, r0)
        L_0x0290:
            return r8
        L_0x0291:
            r0 = move-exception
            r10 = r13
            goto L_0x029b
        L_0x0294:
            r0 = move-exception
            goto L_0x029b
        L_0x0296:
            r0 = move-exception
            goto L_0x029a
        L_0x0298:
            r0 = move-exception
            r14 = 0
        L_0x029a:
            r15 = 0
        L_0x029b:
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x02e1 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x02e1 }
            if (r3 == 0) goto L_0x02a9
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x02e1 }
        L_0x02a9:
            boolean r3 = anet.channel.strategy.dispatch.AmdcRuntimeInfo.isTimeoutRetryEnable()     // Catch:{ all -> 0x02e1 }
            java.lang.String r6 = "-1000"
            if (r3 != 0) goto L_0x02c3
            boolean r3 = r0 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x02e1 }
            if (r3 != 0) goto L_0x02bd
            boolean r3 = r0 instanceof java.net.ConnectException     // Catch:{ all -> 0x02e1 }
            if (r3 != 0) goto L_0x02bd
            boolean r3 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x02e1 }
            if (r3 == 0) goto L_0x02c3
        L_0x02bd:
            r3 = 2
            a((java.lang.String) r6, (java.lang.String) r1, (java.net.URL) r14, (int) r2, (int) r3)     // Catch:{ all -> 0x02e1 }
            r11 = 2
            goto L_0x02c7
        L_0x02c3:
            a((java.lang.String) r6, (java.lang.String) r1, (java.net.URL) r14, (int) r2, (int) r8)     // Catch:{ all -> 0x02e1 }
            r11 = 1
        L_0x02c7:
            java.lang.String r1 = "amdc request fail"
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x02e1 }
            r3 = 0
            r2[r3] = r0     // Catch:{ all -> 0x02e1 }
            anet.channel.util.ALog.i(r10, r1, r5, r2)     // Catch:{ all -> 0x02e1 }
            if (r15 == 0) goto L_0x02e0
            r15.disconnect()     // Catch:{ Exception -> 0x02d7 }
            goto L_0x02e0
        L_0x02d7:
            r0 = move-exception
            r1 = r0
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r2 = 0
            anet.channel.util.ALog.e(r10, r4, r2, r1, r0)
        L_0x02e0:
            return r11
        L_0x02e1:
            r0 = move-exception
            r1 = r0
            if (r15 == 0) goto L_0x02f2
            r15.disconnect()     // Catch:{ Exception -> 0x02e9 }
            goto L_0x02f2
        L_0x02e9:
            r0 = move-exception
            r2 = r0
            r3 = 0
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r3 = 0
            anet.channel.util.ALog.e(r10, r4, r3, r2, r0)
        L_0x02f2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.b.a(java.lang.String, java.util.Map, int):int");
    }

    public static String a(InputStream inputStream, boolean z10) {
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (z10) {
            try {
                bufferedInputStream = new GZIPInputStream(bufferedInputStream);
            } catch (IOException e10) {
                e = e10;
                try {
                    ALog.e("awcn.DispatchCore", "", (String) null, e, new Object[0]);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            }
        }
        FilterInputStream base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), XML.CHARSET_UTF8);
            try {
                base64InputStream.close();
            } catch (IOException unused3) {
            }
            return str;
        } catch (IOException e11) {
            e = e11;
            bufferedInputStream = base64InputStream;
            ALog.e("awcn.DispatchCore", "", (String) null, e, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = base64InputStream;
            bufferedInputStream.close();
            throw th;
        }
    }

    public static void a(String str, String str2, URL url, int i10, int i11) {
        if ((i11 != 1 || i10 == 2) && GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i10;
                AppMonitor.getInstance().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str, long j10, long j11) {
        try {
            FlowStat flowStat = new FlowStat();
            flowStat.refer = "amdc";
            flowStat.protocoltype = HttpConstant.HTTP;
            flowStat.req_identifier = str;
            flowStat.upstream = j10;
            flowStat.downstream = j11;
            NetworkAnalysis.getInstance().commitFlow(flowStat);
        } catch (Exception e10) {
            ALog.e("awcn.DispatchCore", "commit flow info failed!", (String) null, e10, new Object[0]);
        }
    }
}
