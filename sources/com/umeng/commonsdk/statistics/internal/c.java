package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.a;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.d;
import java.io.File;

public class c {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f14978e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f14979f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f14980g = false;

    /* renamed from: a  reason: collision with root package name */
    private String f14981a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    private int f14982b = 80;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f14983c;

    /* renamed from: d  reason: collision with root package name */
    private b f14984d;

    public c(Context context) {
        this.f14983c = context;
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f14983c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f14983c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f14983c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f14983c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(b.f14877b)) {
            return;
        }
        if (b.f14877b.startsWith("460") || b.f14877b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (!f14980g) {
            ImprintHandler.getImprintService(this.f14983c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() {
                public void onImprintValueChanged(String str, String str2) {
                    if (FieldManager.b()) {
                        FieldManager.a().a(c.this.f14983c, str2);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                        UMWorkDispatch.sendEvent(c.this.f14983c, a.f14772w, com.umeng.commonsdk.internal.b.a(c.this.f14983c).a(), (Object) null);
                    }
                }
            });
            f14980g = true;
        }
    }

    private void d() {
        if (!f14979f) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
            ImprintHandler.getImprintService(this.f14983c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() {
                public boolean onPreProcessImprintKey(String str, String str2) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.a().a(c.this.f14983c);
                    UMWorkDispatch.sendEvent(c.this.f14983c, a.f14768s, com.umeng.commonsdk.internal.b.a(c.this.f14983c).a(), (Object) null);
                    ImprintHandler.getImprintService(c.this.f14983c).a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                    return true;
                }
            });
            ImprintHandler.getImprintService(this.f14983c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() {
                public void onImprintValueChanged(String str, String str2) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.a().a(c.this.f14983c, str2);
                    UMWorkDispatch.sendEvent(c.this.f14983c, a.f14768s, com.umeng.commonsdk.internal.b.a(c.this.f14983c).a(), (Object) null);
                    if (FieldManager.allow(d.E)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                        if (!UMWorkDispatch.eventHasExist()) {
                            UMWorkDispatch.sendEventEx(c.this.f14983c, q.a.E, CoreProtocol.getInstance(c.this.f14983c), (Object) null, 0);
                        }
                    }
                    if (FieldManager.allow(d.F)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                        n.a(c.this.f14983c).b(c.this.f14983c);
                    }
                    ImprintHandler.getImprintService(c.this.f14983c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
                }
            });
            f14979f = true;
        }
    }

    public void a(b bVar) {
        this.f14984d = bVar;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f14983c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f14983c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private byte[] c(byte[] bArr, String str) {
        if (by.a().b()) {
            return a(bArr, str.replace("ulogs", "cnlogs"));
        }
        return a(bArr, str);
    }

    public byte[] a(byte[] bArr, boolean z10, boolean z11, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        byte[] bArr2 = null;
        int i10 = 0;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i10 >= strArr.length) {
                break;
            }
            String str2 = strArr[i10];
            if (z11) {
                d();
            } else {
                c();
            }
            String str3 = str2 + File.separator + str;
            if (SdkVersion.SDK_TYPE != 0) {
                bArr2 = a(bArr, str3);
            } else if (i10 == 0) {
                bArr2 = b(bArr, str3);
            } else {
                bArr2 = c(bArr, str3);
            }
            if (bArr2 != null) {
                b bVar = this.f14984d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z10);
                }
            } else {
                b bVar2 = this.f14984d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i10++;
            }
        }
        return bArr2;
    }

    private byte[] b(byte[] bArr, String str) {
        if (!by.a().b()) {
            return a(bArr, str);
        }
        if (!str.contains("preulogs")) {
            str = str.replace("ulogs", "cnlogs");
        }
        String b10 = by.b(str);
        String c10 = cc.b().c();
        if (!TextUtils.isEmpty(c10)) {
            str = by.a(c10, b10);
        }
        byte[] a10 = a(bArr, str);
        if (a10 != null) {
            return a10;
        }
        String a11 = by.a().a(b10);
        if (TextUtils.isEmpty(a11) || str.equalsIgnoreCase(a11)) {
            return a10;
        }
        return a(bArr, a11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.io.OutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0175 A[SYNTHETIC, Splitter:B:100:0x0175] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0129 A[SYNTHETIC, Splitter:B:61:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0135 A[SYNTHETIC, Splitter:B:66:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149 A[SYNTHETIC, Splitter:B:78:0x0149] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0155 A[SYNTHETIC, Splitter:B:83:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0169 A[SYNTHETIC, Splitter:B:95:0x0169] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(byte[] r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "Content-Type"
            java.lang.String r1 = "\\|"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[有状态] 上报url: "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "MobclickRT"
            com.umeng.commonsdk.debug.UMRTLog.i(r3, r2)
            r2 = 2
            r3 = 0
            com.umeng.commonsdk.statistics.internal.b r4 = r8.f14984d     // Catch:{ SSLHandshakeException -> 0x0160, UnknownHostException -> 0x0140, all -> 0x0124 }
            if (r4 == 0) goto L_0x0023
            r4.onRequestStart()     // Catch:{ SSLHandshakeException -> 0x0160, UnknownHostException -> 0x0140, all -> 0x0124 }
        L_0x0023:
            java.net.URL r4 = new java.net.URL     // Catch:{ SSLHandshakeException -> 0x0160, UnknownHostException -> 0x0140, all -> 0x0124 }
            r4.<init>(r10)     // Catch:{ SSLHandshakeException -> 0x0160, UnknownHostException -> 0x0140, all -> 0x0124 }
            java.net.URLConnection r10 = r4.openConnection()     // Catch:{ SSLHandshakeException -> 0x0160, UnknownHostException -> 0x0140, all -> 0x0124 }
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ SSLHandshakeException -> 0x0160, UnknownHostException -> 0x0140, all -> 0x0124 }
            boolean r4 = f14978e     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r5 = 1
            if (r4 != 0) goto L_0x004f
            org.apache.http.conn.ssl.X509HostnameVerifier r4 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setHostnameVerifier(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "TLS"
            javax.net.ssl.SSLContext r4 = javax.net.ssl.SSLContext.getInstance(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.security.SecureRandom r6 = new java.security.SecureRandom     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r6.<init>()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r4.init(r3, r3, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            javax.net.ssl.SSLSocketFactory r4 = r4.getSocketFactory()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setSSLSocketFactory(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            f14978e = r5     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
        L_0x004f:
            java.lang.String r4 = "X-Umeng-UTC"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setRequestProperty(r4, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "X-Umeng-Sdk"
            android.content.Context r6 = r8.f14983c     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            com.umeng.commonsdk.statistics.internal.a r6 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r6 = r6.b()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setRequestProperty(r4, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            android.content.Context r4 = r8.f14983c     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            com.umeng.commonsdk.statistics.internal.a r4 = com.umeng.commonsdk.statistics.internal.a.a((android.content.Context) r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = r4.a()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setRequestProperty(r0, r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "Msg-Type"
            java.lang.String r6 = "envelope/json"
            r10.setRequestProperty(r4, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "X-Umeng-Pro-Ver"
            java.lang.String r6 = "1.0.0"
            r10.setRequestProperty(r4, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "SM-IMP"
            java.lang.String r6 = "1"
            r10.setRequestProperty(r4, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "User-Agent"
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getCustomAgt()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setRequestProperty(r4, r6)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r4 = 30000(0x7530, float:4.2039E-41)
            r10.setConnectTimeout(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setReadTimeout(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.lang.String r4 = "POST"
            r10.setRequestMethod(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setDoOutput(r5)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r10.setDoInput(r5)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r4 = 0
            r10.setUseCaches(r4)     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            java.io.OutputStream r6 = r10.getOutputStream()     // Catch:{ SSLHandshakeException -> 0x0122, UnknownHostException -> 0x0120, all -> 0x011d }
            r6.write(r9)     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            r6.flush()     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            r10.connect()     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            com.umeng.commonsdk.statistics.internal.b r9 = r8.f14984d     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            if (r9 == 0) goto L_0x00c1
            r9.onRequestEnd()     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
        L_0x00c1:
            int r9 = r10.getResponseCode()     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            java.lang.String r0 = r10.getHeaderField(r0)     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            if (r7 != 0) goto L_0x00d8
            java.lang.String r7 = "application/thrift"
            boolean r0 = r0.equalsIgnoreCase(r7)     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            if (r0 == 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r5 = 0
        L_0x00d9:
            java.lang.String r0 = com.umeng.commonsdk.statistics.AnalyticsConstants.OS     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 != r0) goto L_0x0106
            if (r5 == 0) goto L_0x0106
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r9)     // Catch:{ all -> 0x0101 }
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r9)     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            r6.close()     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f6
        L_0x00f0:
            r9 = move-exception
            android.content.Context r1 = r8.f14983c
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r9)
        L_0x00f6:
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ IOException -> 0x00fd }
            r9.close()     // Catch:{ IOException -> 0x00fd }
        L_0x00fd:
            r10.disconnect()
            return r0
        L_0x0101:
            r0 = move-exception
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r9)     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
            throw r0     // Catch:{ SSLHandshakeException -> 0x0162, UnknownHostException -> 0x0142, all -> 0x011b }
        L_0x0106:
            r6.close()     // Catch:{ Exception -> 0x010a }
            goto L_0x0110
        L_0x010a:
            r9 = move-exception
            android.content.Context r0 = r8.f14983c
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r9)
        L_0x0110:
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ IOException -> 0x0117 }
            r9.close()     // Catch:{ IOException -> 0x0117 }
        L_0x0117:
            r10.disconnect()
            return r3
        L_0x011b:
            goto L_0x0127
        L_0x011d:
            r6 = r3
            goto L_0x0127
        L_0x0120:
            r6 = r3
            goto L_0x0142
        L_0x0122:
            r6 = r3
            goto L_0x0162
        L_0x0124:
            r10 = r3
            r6 = r10
        L_0x0127:
            if (r6 == 0) goto L_0x0133
            r6.close()     // Catch:{ Exception -> 0x012d }
            goto L_0x0133
        L_0x012d:
            r9 = move-exception
            android.content.Context r0 = r8.f14983c
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r9)
        L_0x0133:
            if (r10 == 0) goto L_0x013f
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ IOException -> 0x013c }
            r9.close()     // Catch:{ IOException -> 0x013c }
        L_0x013c:
            r10.disconnect()
        L_0x013f:
            return r3
        L_0x0140:
            r10 = r3
            r6 = r10
        L_0x0142:
            java.lang.String r9 = "A_10200"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r9, (int) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0180 }
            if (r6 == 0) goto L_0x0153
            r6.close()     // Catch:{ Exception -> 0x014d }
            goto L_0x0153
        L_0x014d:
            r9 = move-exception
            android.content.Context r0 = r8.f14983c
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r9)
        L_0x0153:
            if (r10 == 0) goto L_0x015f
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ IOException -> 0x015c }
            r9.close()     // Catch:{ IOException -> 0x015c }
        L_0x015c:
            r10.disconnect()
        L_0x015f:
            return r3
        L_0x0160:
            r10 = r3
            r6 = r10
        L_0x0162:
            java.lang.String r9 = "A_10201"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r9, (int) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0180 }
            if (r6 == 0) goto L_0x0173
            r6.close()     // Catch:{ Exception -> 0x016d }
            goto L_0x0173
        L_0x016d:
            r9 = move-exception
            android.content.Context r0 = r8.f14983c
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r9)
        L_0x0173:
            if (r10 == 0) goto L_0x017f
            java.io.InputStream r9 = r10.getInputStream()     // Catch:{ IOException -> 0x017c }
            r9.close()     // Catch:{ IOException -> 0x017c }
        L_0x017c:
            r10.disconnect()
        L_0x017f:
            return r3
        L_0x0180:
            r9 = move-exception
            if (r6 == 0) goto L_0x018d
            r6.close()     // Catch:{ Exception -> 0x0187 }
            goto L_0x018d
        L_0x0187:
            r0 = move-exception
            android.content.Context r1 = r8.f14983c
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r1, r0)
        L_0x018d:
            if (r10 == 0) goto L_0x0199
            java.io.InputStream r0 = r10.getInputStream()     // Catch:{ IOException -> 0x0196 }
            r0.close()     // Catch:{ IOException -> 0x0196 }
        L_0x0196:
            r10.disconnect()
        L_0x0199:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.internal.c.a(byte[], java.lang.String):byte[]");
    }
}
