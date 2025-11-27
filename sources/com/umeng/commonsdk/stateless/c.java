package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f14867a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    private int f14868b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f14869c;

    public c(Context context) {
        this.f14869c = context;
    }

    public void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f14869c, "sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f14851h = DataHelper.assembleStatelessURL(imprintProperty);
        }
    }

    public void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f14869c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f14869c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f14850g = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f14853j = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f14851h = a.f14853j;
        if (TextUtils.isEmpty(b.f14877b)) {
            return;
        }
        if (b.f14877b.startsWith("460") || b.f14877b.startsWith("461")) {
            a.f14851h = a.f14850g;
        }
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) {
        String str4 = str2 + Operator.Operation.DIVISION + str;
        if (SdkVersion.SDK_TYPE == 1) {
            return a(bArr, str4, str3);
        }
        if (!by.a().b()) {
            return a(bArr, str4, str3);
        }
        String replace = str4.replace("ulogs", "cnlogs");
        String c10 = cc.b().c();
        if (!TextUtils.isEmpty(c10)) {
            replace = by.a(c10, str);
        }
        boolean a10 = a(bArr, replace, str3);
        if (!a10) {
            String a11 = by.a().a(str);
            if (!TextUtils.isEmpty(a11) && !replace.equalsIgnoreCase(a11)) {
                return a(bArr, a11, str3);
            }
        }
        return a10;
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.OutputStream, javax.net.ssl.TrustManager[], javax.net.ssl.KeyManager[]] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0119, code lost:
        if (r5 != null) goto L_0x00c7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00c7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ec A[SYNTHETIC, Splitter:B:24:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f3 A[SYNTHETIC, Splitter:B:28:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0114 A[SYNTHETIC, Splitter:B:36:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0122 A[SYNTHETIC, Splitter:B:45:0x0122] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0129 A[SYNTHETIC, Splitter:B:49:0x0129] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(byte[] r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r0 = "--->>> stateless: disconnect connection."
            r1 = 0
            r2 = 1
            if (r10 == 0) goto L_0x0130
            boolean r3 = android.text.TextUtils.isEmpty(r11)
            if (r3 == 0) goto L_0x000e
            goto L_0x0130
        L_0x000e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[无状态] 上报url："
            r3.append(r4)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "MobclickRT"
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r3)
            r3 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ SSLHandshakeException -> 0x00fc, all -> 0x00d4 }
            r5.<init>(r11)     // Catch:{ SSLHandshakeException -> 0x00fc, all -> 0x00d4 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ SSLHandshakeException -> 0x00fc, all -> 0x00d4 }
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ SSLHandshakeException -> 0x00fc, all -> 0x00d4 }
            org.apache.http.conn.ssl.X509HostnameVerifier r6 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setHostnameVerifier(r6)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r6 = "TLS"
            javax.net.ssl.SSLContext r6 = javax.net.ssl.SSLContext.getInstance(r6)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.security.SecureRandom r7 = new java.security.SecureRandom     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r7.<init>()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r6.init(r3, r3, r7)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            javax.net.ssl.SSLSocketFactory r6 = r6.getSocketFactory()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setSSLSocketFactory(r6)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r6 = "X-Umeng-UTC"
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setRequestProperty(r6, r7)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r6 = "Msg-Type"
            java.lang.String r7 = "envelope/json"
            r5.setRequestProperty(r6, r7)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r6 = "Content-Type"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r7.<init>()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r8 = "ut/"
            r7.append(r8)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r7.append(r12)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r12 = r7.toString()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setRequestProperty(r6, r12)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r12 = "SM-IMP"
            java.lang.String r6 = "1"
            r5.setRequestProperty(r12, r6)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r12 = "User-Agent"
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.getCustomAgt()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setRequestProperty(r12, r6)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r12 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r12)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setReadTimeout(r12)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r12 = "POST"
            r5.setRequestMethod(r12)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setDoOutput(r2)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setDoInput(r2)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.setUseCaches(r1)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.io.OutputStream r3 = r5.getOutputStream()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r3.write(r10)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r3.flush()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r5.connect()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            int r10 = r5.getResponseCode()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r12 = 200(0xc8, float:2.8E-43)
            if (r10 != r12) goto L_0x00c4
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r10.<init>()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r12 = "--->>> send stateless message success : "
            r10.append(r12)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r10.append(r11)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            java.lang.String r10 = r10.toString()     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r10)     // Catch:{ SSLHandshakeException -> 0x00d2, all -> 0x00ce }
            r1 = 1
        L_0x00c4:
            r3.close()     // Catch:{ Exception -> 0x00c7 }
        L_0x00c7:
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r0)     // Catch:{ all -> 0x011c }
            r5.disconnect()     // Catch:{ all -> 0x011c }
            goto L_0x011c
        L_0x00ce:
            r10 = move-exception
            r11 = r3
            r3 = r5
            goto L_0x00d6
        L_0x00d2:
            r10 = move-exception
            goto L_0x00fe
        L_0x00d4:
            r10 = move-exception
            r11 = r3
        L_0x00d6:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r12.<init>()     // Catch:{ all -> 0x00fa }
            java.lang.String r2 = "Exception,Failed to send message.\n"
            r12.append(r2)     // Catch:{ all -> 0x00fa }
            r12.append(r10)     // Catch:{ all -> 0x00fa }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00fa }
            com.umeng.commonsdk.debug.UMRTLog.e(r4, r10)     // Catch:{ all -> 0x00fa }
            if (r11 == 0) goto L_0x00f1
            r11.close()     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f1
        L_0x00f0:
        L_0x00f1:
            if (r3 == 0) goto L_0x011c
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r0)     // Catch:{ all -> 0x011c }
            r3.disconnect()     // Catch:{ all -> 0x011c }
            goto L_0x011c
        L_0x00fa:
            r10 = move-exception
            goto L_0x0120
        L_0x00fc:
            r10 = move-exception
            r5 = r3
        L_0x00fe:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x011d }
            r11.<init>()     // Catch:{ all -> 0x011d }
            java.lang.String r12 = "SSLHandshakeException, Failed to send message.\n"
            r11.append(r12)     // Catch:{ all -> 0x011d }
            r11.append(r10)     // Catch:{ all -> 0x011d }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x011d }
            com.umeng.commonsdk.debug.UMRTLog.e(r4, r10)     // Catch:{ all -> 0x011d }
            if (r3 == 0) goto L_0x0119
            r3.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x0119
        L_0x0118:
        L_0x0119:
            if (r5 == 0) goto L_0x011c
            goto L_0x00c7
        L_0x011c:
            return r1
        L_0x011d:
            r10 = move-exception
            r11 = r3
            r3 = r5
        L_0x0120:
            if (r11 == 0) goto L_0x0127
            r11.close()     // Catch:{ Exception -> 0x0126 }
            goto L_0x0127
        L_0x0126:
        L_0x0127:
            if (r3 == 0) goto L_0x012f
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r0)     // Catch:{ all -> 0x012f }
            r3.disconnect()     // Catch:{ all -> 0x012f }
        L_0x012f:
            throw r10
        L_0x0130:
            java.lang.Object[] r10 = new java.lang.Object[r2]
            java.lang.String r11 = "[stateless] sendMessage, envelopeByte == null || url is empty "
            r10[r1] = r11
            java.lang.String r11 = "walle"
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r11, (java.lang.Object[]) r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }
}
