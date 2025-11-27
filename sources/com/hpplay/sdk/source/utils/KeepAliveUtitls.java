package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class KeepAliveUtitls {
    private static final long CONNECT_TIMEOUT = TimeUnit.SECONDS.toMillis(5);
    private static final String TAG = "KeepAliveUtitls";

    public static class HTTPInfoBean {
        public String appID;
        public String dsn;
        public String uid;
    }

    private static String findValidLocalIP(String str) {
        try {
            String substring = str.substring(0, str.lastIndexOf("."));
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            String hostAddress = nextElement.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                if (TextUtils.equals(substring, hostAddress.substring(0, hostAddress.lastIndexOf(".")))) {
                                    return hostAddress;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        return null;
    }

    public static String getSinkServerInfo(SinkParameterBean sinkParameterBean) {
        if (sinkParameterBean == null) {
            SourceLog.w(TAG, "getSinkServerInfo,value is invalid");
            return null;
        }
        HTTPInfoBean hTTPInfoBean = new HTTPInfoBean();
        hTTPInfoBean.appID = sinkParameterBean.appID;
        hTTPInfoBean.uid = sinkParameterBean.uid;
        hTTPInfoBean.dsn = sinkParameterBean.dsn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(hTTPInfoBean);
        if (sinkParameterBean.createType == SinkParameterBean.CREATE_BY_SINK_DSN) {
            return httpPostCheckDeviceStateByDsn(arrayList);
        }
        return httpPostCheckTvStateByUID(arrayList);
    }

    public static String getSinkServerInfoList(List<SinkParameterBean> list) {
        if (list == null || list.size() <= 0) {
            SourceLog.w(TAG, "getSinkServerInfoList,value is invalid");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SinkParameterBean next : list) {
            HTTPInfoBean hTTPInfoBean = new HTTPInfoBean();
            hTTPInfoBean.appID = next.appID;
            hTTPInfoBean.uid = next.uid;
            hTTPInfoBean.dsn = next.dsn;
            arrayList.add(hTTPInfoBean);
        }
        if (list.get(0).createType == SinkParameterBean.CREATE_BY_SINK_DSN) {
            return httpPostCheckDeviceStateByDsn(arrayList);
        }
        return httpPostCheckTvStateByUID(arrayList);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01e0 A[SYNTHETIC, Splitter:B:101:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ea A[SYNTHETIC, Splitter:B:106:0x01ea] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a1 A[SYNTHETIC, Splitter:B:69:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ab A[SYNTHETIC, Splitter:B:74:0x01ab] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b5 A[SYNTHETIC, Splitter:B:79:0x01b5] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01bf A[SYNTHETIC, Splitter:B:84:0x01bf] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01cc A[SYNTHETIC, Splitter:B:91:0x01cc] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d6 A[SYNTHETIC, Splitter:B:96:0x01d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpPostCheckDeviceStateByDsn(java.util.List<com.hpplay.sdk.source.utils.KeepAliveUtitls.HTTPInfoBean> r11) {
        /*
            java.lang.String r0 = "utf-8"
            java.lang.String r1 = "httpPostCheckTvState parameter:"
            r2 = 0
            java.lang.String r3 = "KeepAliveUtitls"
            if (r11 == 0) goto L_0x01f3
            boolean r4 = r11.isEmpty()
            if (r4 == 0) goto L_0x0011
            goto L_0x01f3
        L_0x0011:
            java.lang.String r4 = "httpPostCheckDeviceStateByDsn"
            com.hpplay.sdk.source.log.SourceLog.i(r3, r4)
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "uid"
            com.hpplay.sdk.source.common.store.Session r6 = com.hpplay.sdk.source.common.store.Session.getInstance()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r6 = r6.getUID()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "appid"
            com.hpplay.sdk.source.common.store.Session r6 = com.hpplay.sdk.source.common.store.Session.getInstance()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r6 = r6.appKey     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "token"
            java.lang.String r6 = com.hpplay.sdk.source.c.a.a()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "ver"
            java.lang.String r6 = "1.0"
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r5.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
        L_0x004c:
            boolean r6 = r11.hasNext()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            if (r6 == 0) goto L_0x006f
            java.lang.Object r6 = r11.next()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            com.hpplay.sdk.source.utils.KeepAliveUtitls$HTTPInfoBean r6 = (com.hpplay.sdk.source.utils.KeepAliveUtitls.HTTPInfoBean) r6     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r7.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r8 = "ra"
            java.lang.String r9 = r6.appID     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r7.put(r8, r9)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r8 = "dsn"
            java.lang.String r6 = r6.dsn     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r7.put(r8, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r5.put(r7)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            goto L_0x004c
        L_0x006f:
            java.lang.String r11 = "tvList"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r11, r5)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = com.hpplay.sdk.source.business.cloud.CloudAPI.sGetDeviceStatusByDsn     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r5)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            com.hpplay.sdk.source.log.SourceLog.i(r3, r11)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            com.hpplay.sdk.source.log.SourceLog.i(r3, r11)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.net.URL r11 = new java.net.URL     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r1 = com.hpplay.sdk.source.business.cloud.CloudAPI.sGetDeviceStatusByDsn     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.net.HttpURLConnection r11 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r11)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            long r5 = CONNECT_TIMEOUT     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            int r1 = (int) r5     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.setConnectTimeout(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            int r1 = (int) r5     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.setReadTimeout(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r1 = 1
            r11.setDoOutput(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.setDoInput(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r1 = 0
            r11.setUseCaches(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "POST"
            r11.setRequestMethod(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "Content-type"
            java.lang.String r5 = "text/html"
            r11.setRequestProperty(r1, r5)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "Accept-Charset"
            r11.setRequestProperty(r1, r0)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "contentType"
            r11.setRequestProperty(r1, r0)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.connect()     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            r0.write(r1)     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            r0.flush()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            int r1 = r11.getResponseCode()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 != r1) goto L_0x0151
            java.io.InputStream r1 = r11.getInputStream()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r1, r6)     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r5.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
        L_0x010a:
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            if (r6 == 0) goto L_0x0119
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r6 = "\r\n"
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            goto L_0x010a
        L_0x0119:
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r5.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r6 = "httpPostCheckTvState result:"
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r5.append(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            com.hpplay.sdk.source.log.SourceLog.i(r3, r5)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r10 = r4
            r4 = r2
            r2 = r10
            goto L_0x0153
        L_0x0135:
            r2 = move-exception
            r10 = r4
            r4 = r11
            r11 = r2
            r2 = r10
            goto L_0x01ca
        L_0x013c:
            r5 = move-exception
            r10 = r4
            r4 = r11
            r11 = r5
            r5 = r2
            r2 = r10
            goto L_0x019c
        L_0x0144:
            r4 = move-exception
            r10 = r4
            r4 = r11
            r11 = r10
            goto L_0x01ca
        L_0x014a:
            r4 = move-exception
            r5 = r2
            r10 = r4
            r4 = r11
            r11 = r10
            goto L_0x019c
        L_0x0151:
            r1 = r2
            r4 = r1
        L_0x0153:
            if (r2 == 0) goto L_0x015d
            r2.close()     // Catch:{ Exception -> 0x0159 }
            goto L_0x015d
        L_0x0159:
            r2 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r2)
        L_0x015d:
            r0.close()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0165
        L_0x0161:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x0165:
            if (r1 == 0) goto L_0x016f
            r1.close()     // Catch:{ Exception -> 0x016b }
            goto L_0x016f
        L_0x016b:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x016f:
            r11.disconnect()     // Catch:{ Exception -> 0x0174 }
            goto L_0x01c8
        L_0x0174:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
            goto L_0x01c8
        L_0x017a:
            r1 = move-exception
            r4 = r11
            r11 = r1
            r1 = r2
            goto L_0x01ca
        L_0x0180:
            r1 = move-exception
            r4 = r11
            r11 = r1
            r1 = r2
            goto L_0x0190
        L_0x0185:
            r0 = move-exception
            r4 = r11
            r11 = r0
            r0 = r2
            r1 = r0
            goto L_0x01ca
        L_0x018b:
            r0 = move-exception
            r4 = r11
            r11 = r0
            r0 = r2
            r1 = r0
        L_0x0190:
            r5 = r1
            goto L_0x019c
        L_0x0192:
            r11 = move-exception
            r0 = r2
            r1 = r0
            r4 = r1
            goto L_0x01ca
        L_0x0197:
            r11 = move-exception
            r0 = r2
            r1 = r0
            r4 = r1
            r5 = r4
        L_0x019c:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x01c9 }
            if (r2 == 0) goto L_0x01a9
            r2.close()     // Catch:{ Exception -> 0x01a5 }
            goto L_0x01a9
        L_0x01a5:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01a9:
            if (r0 == 0) goto L_0x01b3
            r0.close()     // Catch:{ Exception -> 0x01af }
            goto L_0x01b3
        L_0x01af:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01b3:
            if (r1 == 0) goto L_0x01bd
            r1.close()     // Catch:{ Exception -> 0x01b9 }
            goto L_0x01bd
        L_0x01b9:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01bd:
            if (r4 == 0) goto L_0x01c7
            r4.disconnect()     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01c7
        L_0x01c3:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01c7:
            r4 = r5
        L_0x01c8:
            return r4
        L_0x01c9:
            r11 = move-exception
        L_0x01ca:
            if (r2 == 0) goto L_0x01d4
            r2.close()     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01d4
        L_0x01d0:
            r2 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r2)
        L_0x01d4:
            if (r0 == 0) goto L_0x01de
            r0.close()     // Catch:{ Exception -> 0x01da }
            goto L_0x01de
        L_0x01da:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01de:
            if (r1 == 0) goto L_0x01e8
            r1.close()     // Catch:{ Exception -> 0x01e4 }
            goto L_0x01e8
        L_0x01e4:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01e8:
            if (r4 == 0) goto L_0x01f2
            r4.disconnect()     // Catch:{ Exception -> 0x01ee }
            goto L_0x01f2
        L_0x01ee:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01f2:
            throw r11
        L_0x01f3:
            java.lang.String r11 = "httpPostCheckDeviceStateByDsn,value is invalid"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.String) r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.utils.KeepAliveUtitls.httpPostCheckDeviceStateByDsn(java.util.List):java.lang.String");
    }

    public static String httpPostCheckTvState(List<BrowserInfo> list) {
        String str;
        String str2;
        if (list == null || list.isEmpty()) {
            SourceLog.i(TAG, "httpPostCheckTvState is empty");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BrowserInfo next : list) {
            HTTPInfoBean hTTPInfoBean = new HTTPInfoBean();
            hTTPInfoBean.uid = next.getUid();
            try {
                hTTPInfoBean.appID = next.getExtras().get("a");
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            arrayList.add(hTTPInfoBean);
        }
        String httpPostCheckTvStateByUID = httpPostCheckTvStateByUID(arrayList);
        if (TextUtils.isEmpty(httpPostCheckTvStateByUID)) {
            for (BrowserInfo onLine : list) {
                onLine.setOnLine(false);
            }
            return null;
        }
        try {
            if (httpPostCheckTvStateByUID.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
                JSONObject jSONObject = new JSONObject(httpPostCheckTvStateByUID);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                jSONObject.optJSONObject("capblity");
                JSONArray optJSONArray = optJSONObject.optJSONArray("tvList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    HashMap hashMap = new HashMap();
                    int length = optJSONArray.length();
                    int i10 = 0;
                    while (true) {
                        str = "uk";
                        str2 = "0";
                        if (i10 >= length) {
                            break;
                        }
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                        optJSONObject2.optString("ra");
                        String optString = optJSONObject2.optString("u");
                        String optString2 = optJSONObject2.optString(BrowserInfo.KEY_POL);
                        boolean optBoolean = optJSONObject2.optBoolean("online");
                        String optString3 = optJSONObject2.optString("pt");
                        if (!TextUtils.isEmpty(optString2)) {
                            str2 = optString2;
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            str = optString3;
                        }
                        hashMap.put(optString, String.valueOf(optBoolean) + "@" + str2 + "@" + str);
                        i10++;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("doCheck httpCheck:");
                    sb.append("\r\n");
                    Boolean bool = null;
                    for (BrowserInfo next2 : list) {
                        String str3 = (String) hashMap.get(next2.getUid());
                        if (!TextUtils.isEmpty(str3)) {
                            String[] split = str3.split("@");
                            bool = Boolean.valueOf(split[0]);
                            str2 = split[1];
                            str = split[2];
                        }
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        next2.setLocalWifi(false);
                        next2.setOnLine(bool.booleanValue());
                        if (next2.getExtras() != null) {
                            next2.getExtras().put(BrowserInfo.KEY_POL, str2);
                            next2.getExtras().put("pt", str);
                        }
                        sb.append("name:");
                        sb.append(next2.getName());
                        sb.append(" alive state:");
                        sb.append(next2.isOnLine());
                        sb.append("\r\n");
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
        }
        return httpPostCheckTvStateByUID;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01e0 A[SYNTHETIC, Splitter:B:101:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ea A[SYNTHETIC, Splitter:B:106:0x01ea] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a1 A[SYNTHETIC, Splitter:B:69:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ab A[SYNTHETIC, Splitter:B:74:0x01ab] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b5 A[SYNTHETIC, Splitter:B:79:0x01b5] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01bf A[SYNTHETIC, Splitter:B:84:0x01bf] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01cc A[SYNTHETIC, Splitter:B:91:0x01cc] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d6 A[SYNTHETIC, Splitter:B:96:0x01d6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String httpPostCheckTvStateByUID(java.util.List<com.hpplay.sdk.source.utils.KeepAliveUtitls.HTTPInfoBean> r11) {
        /*
            java.lang.String r0 = "utf-8"
            java.lang.String r1 = "httpPostCheckTvState parameter:"
            r2 = 0
            java.lang.String r3 = "KeepAliveUtitls"
            if (r11 == 0) goto L_0x01f3
            boolean r4 = r11.isEmpty()
            if (r4 == 0) goto L_0x0011
            goto L_0x01f3
        L_0x0011:
            java.lang.String r4 = "httpPostCheckTvStateByUID"
            com.hpplay.sdk.source.log.SourceLog.i(r3, r4)
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "uid"
            com.hpplay.sdk.source.common.store.Session r6 = com.hpplay.sdk.source.common.store.Session.getInstance()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r6 = r6.getUID()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "appid"
            com.hpplay.sdk.source.common.store.Session r6 = com.hpplay.sdk.source.common.store.Session.getInstance()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r6 = r6.appKey     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "token"
            java.lang.String r6 = com.hpplay.sdk.source.c.a.a()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = "ver"
            java.lang.String r6 = "2.1"
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r5.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
        L_0x004c:
            boolean r6 = r11.hasNext()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            if (r6 == 0) goto L_0x006f
            java.lang.Object r6 = r11.next()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            com.hpplay.sdk.source.utils.KeepAliveUtitls$HTTPInfoBean r6 = (com.hpplay.sdk.source.utils.KeepAliveUtitls.HTTPInfoBean) r6     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r7.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r8 = "u"
            java.lang.String r9 = r6.uid     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r7.put(r8, r9)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r8 = "ra"
            java.lang.String r6 = r6.appID     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r7.put(r8, r6)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r5.put(r7)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            goto L_0x004c
        L_0x006f:
            java.lang.String r11 = "tvList"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r4.put(r11, r5)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r5 = com.hpplay.sdk.source.business.cloud.CloudAPI.sGetTVListStatus     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r5)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            com.hpplay.sdk.source.log.SourceLog.i(r3, r11)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.<init>()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.append(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            com.hpplay.sdk.source.log.SourceLog.i(r3, r11)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.net.URL r11 = new java.net.URL     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.lang.String r1 = com.hpplay.sdk.source.business.cloud.CloudAPI.sGetTVListStatus     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            java.net.HttpURLConnection r11 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r11)     // Catch:{ Exception -> 0x0197, all -> 0x0192 }
            long r5 = CONNECT_TIMEOUT     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            int r1 = (int) r5     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.setConnectTimeout(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            int r1 = (int) r5     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.setReadTimeout(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r1 = 1
            r11.setDoOutput(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.setDoInput(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r1 = 0
            r11.setUseCaches(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "POST"
            r11.setRequestMethod(r1)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "Content-type"
            java.lang.String r5 = "text/html"
            r11.setRequestProperty(r1, r5)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "Accept-Charset"
            r11.setRequestProperty(r1, r0)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = "contentType"
            r11.setRequestProperty(r1, r0)     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            r11.connect()     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ Exception -> 0x018b, all -> 0x0185 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            r0.write(r1)     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            r0.flush()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            int r1 = r11.getResponseCode()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            r4 = 200(0xc8, float:2.8E-43)
            if (r4 != r1) goto L_0x0151
            java.io.InputStream r1 = r11.getInputStream()     // Catch:{ Exception -> 0x0180, all -> 0x017a }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r1, r6)     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x014a, all -> 0x0144 }
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r5.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
        L_0x010a:
            java.lang.String r6 = r4.readLine()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            if (r6 == 0) goto L_0x0119
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r6 = "\r\n"
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            goto L_0x010a
        L_0x0119:
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r5.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r6 = "httpPostCheckTvState result:"
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r5.append(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            com.hpplay.sdk.source.log.SourceLog.i(r3, r5)     // Catch:{ Exception -> 0x013c, all -> 0x0135 }
            r10 = r4
            r4 = r2
            r2 = r10
            goto L_0x0153
        L_0x0135:
            r2 = move-exception
            r10 = r4
            r4 = r11
            r11 = r2
            r2 = r10
            goto L_0x01ca
        L_0x013c:
            r5 = move-exception
            r10 = r4
            r4 = r11
            r11 = r5
            r5 = r2
            r2 = r10
            goto L_0x019c
        L_0x0144:
            r4 = move-exception
            r10 = r4
            r4 = r11
            r11 = r10
            goto L_0x01ca
        L_0x014a:
            r4 = move-exception
            r5 = r2
            r10 = r4
            r4 = r11
            r11 = r10
            goto L_0x019c
        L_0x0151:
            r1 = r2
            r4 = r1
        L_0x0153:
            if (r2 == 0) goto L_0x015d
            r2.close()     // Catch:{ Exception -> 0x0159 }
            goto L_0x015d
        L_0x0159:
            r2 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r2)
        L_0x015d:
            r0.close()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0165
        L_0x0161:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x0165:
            if (r1 == 0) goto L_0x016f
            r1.close()     // Catch:{ Exception -> 0x016b }
            goto L_0x016f
        L_0x016b:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x016f:
            r11.disconnect()     // Catch:{ Exception -> 0x0174 }
            goto L_0x01c8
        L_0x0174:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
            goto L_0x01c8
        L_0x017a:
            r1 = move-exception
            r4 = r11
            r11 = r1
            r1 = r2
            goto L_0x01ca
        L_0x0180:
            r1 = move-exception
            r4 = r11
            r11 = r1
            r1 = r2
            goto L_0x0190
        L_0x0185:
            r0 = move-exception
            r4 = r11
            r11 = r0
            r0 = r2
            r1 = r0
            goto L_0x01ca
        L_0x018b:
            r0 = move-exception
            r4 = r11
            r11 = r0
            r0 = r2
            r1 = r0
        L_0x0190:
            r5 = r1
            goto L_0x019c
        L_0x0192:
            r11 = move-exception
            r0 = r2
            r1 = r0
            r4 = r1
            goto L_0x01ca
        L_0x0197:
            r11 = move-exception
            r0 = r2
            r1 = r0
            r4 = r1
            r5 = r4
        L_0x019c:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)     // Catch:{ all -> 0x01c9 }
            if (r2 == 0) goto L_0x01a9
            r2.close()     // Catch:{ Exception -> 0x01a5 }
            goto L_0x01a9
        L_0x01a5:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01a9:
            if (r0 == 0) goto L_0x01b3
            r0.close()     // Catch:{ Exception -> 0x01af }
            goto L_0x01b3
        L_0x01af:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01b3:
            if (r1 == 0) goto L_0x01bd
            r1.close()     // Catch:{ Exception -> 0x01b9 }
            goto L_0x01bd
        L_0x01b9:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01bd:
            if (r4 == 0) goto L_0x01c7
            r4.disconnect()     // Catch:{ Exception -> 0x01c3 }
            goto L_0x01c7
        L_0x01c3:
            r11 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r11)
        L_0x01c7:
            r4 = r5
        L_0x01c8:
            return r4
        L_0x01c9:
            r11 = move-exception
        L_0x01ca:
            if (r2 == 0) goto L_0x01d4
            r2.close()     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01d4
        L_0x01d0:
            r2 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r2)
        L_0x01d4:
            if (r0 == 0) goto L_0x01de
            r0.close()     // Catch:{ Exception -> 0x01da }
            goto L_0x01de
        L_0x01da:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01de:
            if (r1 == 0) goto L_0x01e8
            r1.close()     // Catch:{ Exception -> 0x01e4 }
            goto L_0x01e8
        L_0x01e4:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01e8:
            if (r4 == 0) goto L_0x01f2
            r4.disconnect()     // Catch:{ Exception -> 0x01ee }
            goto L_0x01f2
        L_0x01ee:
            r0 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x01f2:
            throw r11
        L_0x01f3:
            java.lang.String r11 = "httpPostCheckTvStateByUID,value is invalid"
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r3, (java.lang.String) r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.utils.KeepAliveUtitls.httpPostCheckTvStateByUID(java.util.List):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        com.hpplay.sdk.source.log.SourceLog.w(TAG, (java.lang.Throwable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A[SYNTHETIC, Splitter:B:22:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A[SYNTHETIC, Splitter:B:27:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean tcpCheckTvState(java.lang.String r6, java.lang.String r7, int r8, int r9) {
        /*
            java.lang.String r0 = "KeepAliveUtitls"
            r1 = 0
            r2 = 0
            java.net.Socket r3 = new java.net.Socket     // Catch:{ Exception -> 0x003b }
            r3.<init>()     // Catch:{ Exception -> 0x003b }
            r2 = 1
            r3.setReuseAddress(r2)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r3.setSoTimeout(r9)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            java.lang.String r4 = findValidLocalIP(r7)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            if (r5 != 0) goto L_0x0022
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r5.<init>(r4, r1)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r3.bind(r5)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
        L_0x0022:
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r4.<init>(r7, r8)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r3.connect(r4, r9)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r3.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r6 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r6)
        L_0x0032:
            r1 = 1
            goto L_0x005c
        L_0x0034:
            r6 = move-exception
            r2 = r3
            goto L_0x005d
        L_0x0037:
            r2 = r3
            goto L_0x003b
        L_0x0039:
            r6 = move-exception
            goto L_0x005d
        L_0x003b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r8.<init>()     // Catch:{ all -> 0x0039 }
            r8.append(r6)     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = " +++++++++++ is offline ++++++++++++++"
            r8.append(r6)     // Catch:{ all -> 0x0039 }
            r8.append(r7)     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0039 }
            com.hpplay.sdk.source.log.SourceLog.i(r0, r6)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r6 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r6)
        L_0x005c:
            return r1
        L_0x005d:
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r7 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r7)
        L_0x0067:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.utils.KeepAliveUtitls.tcpCheckTvState(java.lang.String, java.lang.String, int, int):boolean");
    }

    public static boolean tcpCheckTvState(String str, String str2, int i10) {
        return tcpCheckTvState(str, str2, i10, (int) CONNECT_TIMEOUT);
    }
}
