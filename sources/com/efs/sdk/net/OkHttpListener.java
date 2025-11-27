package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class OkHttpListener extends EventListener {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f5436a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private String f5437b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5438c;

    /* renamed from: d  reason: collision with root package name */
    private List f5439d = new ArrayList();

    private void a(String str) {
        Map<String, Long> map;
        try {
            d c10 = a.a().c(this.f5437b);
            if (c10 != null && (map = c10.E) != null) {
                map.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x0260 A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0273 A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0286 A[Catch:{ all -> 0x02fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r11 = this;
            java.lang.String r0 = "NetTrace-Listener"
            com.efs.sdk.net.a.a r1 = com.efs.sdk.net.a.a.a()     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = r11.f5437b     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.a.d r1 = r1.c(r2)     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.a.a r2 = com.efs.sdk.net.a.a.a()     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = r11.f5437b     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.a.c r2 = r2.a(r3)     // Catch:{ all -> 0x02fd }
            if (r1 == 0) goto L_0x02fc
            if (r2 == 0) goto L_0x02fc
            java.util.Map<java.lang.String, java.lang.Long> r3 = r1.E     // Catch:{ all -> 0x02fd }
            java.util.Map<java.lang.String, java.lang.Long> r4 = r1.F     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x02fd }
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = r1.B     // Catch:{ all -> 0x02fd }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x02fd }
            if (r5 != 0) goto L_0x02f7
            com.efs.sdk.base.protocol.record.EfsJSONLog r0 = new com.efs.sdk.base.protocol.record.EfsJSONLog     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "netperf"
            r0.<init>(r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = com.efs.sdk.net.a.d.f5481d     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0047
            java.lang.String r5 = "wd_dns"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5481d     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x0047:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5482e     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x005a
            java.lang.String r5 = "wd_dnstm"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5482e     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x005a:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5497t     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x006d
            java.lang.String r5 = "wl_dns"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5497t     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x006d:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5483f     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0080
            java.lang.String r5 = "wd_tcp"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5483f     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x0080:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5486i     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0093
            java.lang.String r5 = "wd_tcptm"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5486i     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x0093:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5499v     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x00a6
            java.lang.String r5 = "wl_tcp"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5499v     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x00a6:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5484g     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x00b9
            java.lang.String r5 = "wd_ssl"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5484g     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x00b9:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5485h     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x00cc
            java.lang.String r5 = "wd_ssltm"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5485h     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x00cc:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5498u     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x00df
            java.lang.String r5 = "wl_ssl"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5498u     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x00df:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5488k     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x00f2
            java.lang.String r5 = "wd_ds"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5488k     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x00f2:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5491n     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0105
            java.lang.String r5 = "wd_dstm"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5491n     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x0105:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5500w     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0137
            java.lang.String r5 = com.efs.sdk.net.a.d.f5501x     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0137
            java.lang.String r5 = "wl_ds"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5500w     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x02fd }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x02fd }
            long r6 = r6.longValue()     // Catch:{ all -> 0x02fd }
            java.lang.String r8 = com.efs.sdk.net.a.d.f5501x     // Catch:{ all -> 0x02fd }
            java.lang.Object r8 = r4.get(r8)     // Catch:{ all -> 0x02fd }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x02fd }
            long r8 = r8.longValue()     // Catch:{ all -> 0x02fd }
            long r6 = r6 + r8
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x0137:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x014a
            java.lang.String r5 = "wd_srt"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x014a:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5495r     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x015d
            java.lang.String r5 = "wd_srttm"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5495r     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x015d:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5502y     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x018f
            java.lang.String r5 = com.efs.sdk.net.a.d.f5503z     // Catch:{ all -> 0x02fd }
            boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x018f
            java.lang.String r5 = "wl_srt"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5502y     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r4.get(r6)     // Catch:{ all -> 0x02fd }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x02fd }
            long r6 = r6.longValue()     // Catch:{ all -> 0x02fd }
            java.lang.String r8 = com.efs.sdk.net.a.d.f5503z     // Catch:{ all -> 0x02fd }
            java.lang.Object r8 = r4.get(r8)     // Catch:{ all -> 0x02fd }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x02fd }
            long r8 = r8.longValue()     // Catch:{ all -> 0x02fd }
            long r6 = r6 + r8
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x018f:
            java.lang.String r5 = r1.B     // Catch:{ all -> 0x02fd }
            java.lang.String r6 = "\\?"
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ all -> 0x02fd }
            r6 = 0
            if (r5 == 0) goto L_0x019d
            r5 = r5[r6]     // Catch:{ all -> 0x02fd }
            goto L_0x019e
        L_0x019d:
            r5 = 0
        L_0x019e:
            java.util.List r7 = r11.f5439d     // Catch:{ all -> 0x02fd }
            java.lang.String r8 = "wd_ttfbtm"
            java.lang.String r9 = "wl_ttfb"
            java.lang.String r10 = "wd_ttfb"
            if (r7 == 0) goto L_0x0243
            if (r5 == 0) goto L_0x0243
            boolean r7 = r7.contains(r5)     // Catch:{ all -> 0x02fd }
            if (r7 != 0) goto L_0x0243
            java.util.List r6 = r11.f5439d     // Catch:{ all -> 0x02fd }
            r6.add(r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = com.efs.sdk.net.a.d.f5491n     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x01c7
            java.lang.String r5 = com.efs.sdk.net.a.d.f5491n     // Catch:{ all -> 0x02fd }
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x02fd }
            r0.put(r10, r5)     // Catch:{ all -> 0x02fd }
            goto L_0x01d8
        L_0x01c7:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5489l     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x01d8
            java.lang.String r5 = com.efs.sdk.net.a.d.f5489l     // Catch:{ all -> 0x02fd }
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x02fd }
            r0.put(r10, r5)     // Catch:{ all -> 0x02fd }
        L_0x01d8:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x01e9
            java.lang.String r5 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x02fd }
            r0.put(r8, r5)     // Catch:{ all -> 0x02fd }
        L_0x01e9:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0258
            java.lang.String r5 = com.efs.sdk.net.a.d.f5491n     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x021a
            java.lang.String r5 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x02fd }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x02fd }
            long r5 = r5.longValue()     // Catch:{ all -> 0x02fd }
            java.lang.String r7 = com.efs.sdk.net.a.d.f5491n     // Catch:{ all -> 0x02fd }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x02fd }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x02fd }
            long r7 = r7.longValue()     // Catch:{ all -> 0x02fd }
            long r5 = r5 - r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x02fd }
            r0.put(r9, r5)     // Catch:{ all -> 0x02fd }
            goto L_0x0258
        L_0x021a:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5489l     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x0258
            java.lang.String r5 = com.efs.sdk.net.a.d.f5492o     // Catch:{ all -> 0x02fd }
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x02fd }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x02fd }
            long r5 = r5.longValue()     // Catch:{ all -> 0x02fd }
            java.lang.String r7 = com.efs.sdk.net.a.d.f5489l     // Catch:{ all -> 0x02fd }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x02fd }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x02fd }
            long r7 = r7.longValue()     // Catch:{ all -> 0x02fd }
            long r5 = r5 - r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x02fd }
            r0.put(r9, r5)     // Catch:{ all -> 0x02fd }
            goto L_0x0258
        L_0x0243:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r10, r5)     // Catch:{ all -> 0x02fd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r8, r5)     // Catch:{ all -> 0x02fd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r9, r5)     // Catch:{ all -> 0x02fd }
        L_0x0258:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5478a     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x026b
            java.lang.String r5 = "wd_rt"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5478a     // Catch:{ all -> 0x02fd }
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r6)     // Catch:{ all -> 0x02fd }
        L_0x026b:
            java.lang.String r5 = com.efs.sdk.net.a.d.f5479b     // Catch:{ all -> 0x02fd }
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x027e
            java.lang.String r5 = "wd_rttm"
            java.lang.String r6 = com.efs.sdk.net.a.d.f5479b     // Catch:{ all -> 0x02fd }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ all -> 0x02fd }
            r0.put(r5, r3)     // Catch:{ all -> 0x02fd }
        L_0x027e:
            java.lang.String r3 = com.efs.sdk.net.a.d.f5496s     // Catch:{ all -> 0x02fd }
            boolean r3 = r4.containsKey(r3)     // Catch:{ all -> 0x02fd }
            if (r3 == 0) goto L_0x0291
            java.lang.String r3 = "wl_rt"
            java.lang.String r5 = com.efs.sdk.net.a.d.f5496s     // Catch:{ all -> 0x02fd }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
        L_0x0291:
            java.lang.String r3 = "wk_res"
            java.lang.String r4 = r2.f5470c     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wk_res_ori"
            java.lang.String r4 = r1.B     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wk_ip"
            java.lang.String r4 = r1.C     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wk_method"
            java.lang.String r4 = r2.f5472e     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wk_rc"
            int r4 = r2.f5475h     // Catch:{ all -> 0x02fd }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wl_up"
            long r4 = r2.f5473f     // Catch:{ all -> 0x02fd }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wl_down"
            long r4 = r2.f5477j     // Catch:{ all -> 0x02fd }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = "wl_total"
            long r4 = r2.f5473f     // Catch:{ all -> 0x02fd }
            long r6 = r2.f5477j     // Catch:{ all -> 0x02fd }
            long r4 = r4 + r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x02fd }
            r0.put(r3, r4)     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.OkHttpListener$2 r3 = new com.efs.sdk.net.OkHttpListener$2     // Catch:{ all -> 0x02fd }
            r3.<init>(r2, r1, r0)     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.a.b.a(r3)     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.a.a r0 = com.efs.sdk.net.a.a.a()     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = r11.f5437b     // Catch:{ all -> 0x02fd }
            r0.d(r1)     // Catch:{ all -> 0x02fd }
            com.efs.sdk.net.a.a r0 = com.efs.sdk.net.a.a.a()     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = r11.f5437b     // Catch:{ all -> 0x02fd }
            r0.b(r1)     // Catch:{ all -> 0x02fd }
            return
        L_0x02f7:
            java.lang.String r1 = "url is null."
            com.efs.sdk.base.core.util.Log.d((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x02fd }
        L_0x02fc:
            return
        L_0x02fd:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.OkHttpListener.b():void");
    }

    public static EventListener.Factory get() {
        return new EventListener.Factory() {
            public final EventListener create(Call call) {
                return new OkHttpListener();
            }
        };
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "callEnd net enable false.");
                    return;
                }
            }
            a(d.f5479b);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "callFailed net enable false.");
                    return;
                }
            }
            a(d.f5480c);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void callStart(Call call) {
        super.callStart(call);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.f5438c = true;
            }
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "callStart net enable false.");
                    return;
                }
            }
            this.f5437b = String.valueOf(f5436a.getAndIncrement());
            Log.i("NetTrace-Listener", "requestId is" + this.f5437b);
            a(d.f5478a);
            String httpUrl = call.request().url().toString();
            d c10 = a.a().c(this.f5437b);
            if (c10 != null) {
                c10.B = httpUrl;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "connectEnd net enable false.");
                    return;
                }
            }
            a(d.f5486i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "connectFailed net enable false.");
                    return;
                }
            }
            a(d.f5487j);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "connectStart net enable false.");
                    return;
                }
            }
            a(d.f5483f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        try {
            Log.d("NetTrace-Listener", "connectionAcquired");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "callStart net enable false.");
                    return;
                }
            }
            InetAddress inetAddress = connection.socket().getInetAddress();
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                d c10 = a.a().c(this.f5437b);
                if (c10 != null) {
                    c10.C = hostAddress;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                    return;
                }
            }
            a(d.f5482e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "dnsStart net enable false.");
                    return;
                }
            }
            a(d.f5481d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestBodyEnd(Call call, long j10) {
        super.requestBodyEnd(call, j10);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            call.request().body();
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                    return;
                }
            }
            a(d.f5491n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                    return;
                }
            }
            a(d.f5490m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                    return;
                }
            }
            a(d.f5489l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                    return;
                }
            }
            a(d.f5488k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseBodyEnd(Call call, long j10) {
        super.responseBodyEnd(call, j10);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                    return;
                }
            }
            a(d.f5495r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                    return;
                }
            }
            a(d.f5494q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                    return;
                }
            }
            a(d.f5493p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                    return;
                }
            }
            a(d.f5492o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                    return;
                }
            }
            a(d.f5485h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.f5438c) {
                if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                    Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                    return;
                }
            }
            a(d.f5484g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        try {
            d c10 = a.a().c(this.f5437b);
            if (c10 != null) {
                Map<String, Long> map = c10.E;
                Map<String, Long> map2 = c10.F;
                map2.put(d.f5496s, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5478a, d.f5479b)));
                map2.put(d.f5497t, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5481d, d.f5482e)));
                map2.put(d.f5498u, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5484g, d.f5485h)));
                map2.put(d.f5499v, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5483f, d.f5486i)));
                map2.put(d.f5500w, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5488k, d.f5489l)));
                map2.put(d.f5501x, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5490m, d.f5491n)));
                map2.put(d.f5502y, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5492o, d.f5493p)));
                map2.put(d.f5503z, Long.valueOf(com.efs.sdk.net.b.a.a(map, d.f5494q, d.f5495r)));
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(EfsJSONLog efsJSONLog) {
        try {
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                if (!SamplingWhiteListUtil.isHitWL()) {
                    Context context = ControllerCenter.getGlobalEnvStruct().mAppContext;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("net_launch" + ProcessUtil.getCurrentProcessName(), 0);
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
                    if (sharedPreferences != null) {
                        int i10 = sharedPreferences.getInt(format, 0);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        if (edit != null) {
                            edit.putInt(format, i10 + 1);
                            edit.apply();
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static String a(Map<String, String> map, boolean z10, boolean z11) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!SamplingWhiteListUtil.isHitWL()) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append("|");
            sb.append(NetManager.getNetConfigManager().getExtraRateFlag());
            if (map.size() == 0) {
                sb.append("|0");
            } else if (z10) {
                sb.append("|0");
            } else if (z11) {
                sb.append("|1");
            } else {
                sb.append("|0");
            }
            sb.append("|");
            sb.append(new JSONObject(map).toString());
            return com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(sb.toString().getBytes(), ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012b, code lost:
        if (java.util.regex.Pattern.matches(r12, r0.B) != false) goto L_0x012d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015f A[Catch:{ all -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0174 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.efs.sdk.net.a.d r16, com.efs.sdk.net.a.c r17, com.efs.sdk.base.protocol.record.EfsJSONLog r18) {
        /*
            r0 = r16
            r1 = -1
            r2 = 0
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()     // Catch:{ all -> 0x0057 }
            android.content.Context r3 = r3.mAppContext     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = "net_launch"
            r4.<init>(r5)     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName()     // Catch:{ all -> 0x0057 }
            r4.append(r5)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0057 }
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r2)     // Catch:{ all -> 0x0057 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = "yyyy-MM-dd"
            java.util.Locale r6 = java.util.Locale.CHINA     // Catch:{ all -> 0x0057 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0057 }
            java.util.Date r5 = new java.util.Date     // Catch:{ all -> 0x0057 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0057 }
            r5.<init>(r6)     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.format(r5)     // Catch:{ all -> 0x0057 }
            if (r3 == 0) goto L_0x0058
            int r3 = r3.getInt(r4, r2)     // Catch:{ all -> 0x0057 }
            boolean r4 = com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()     // Catch:{ all -> 0x0057 }
            if (r4 != 0) goto L_0x0058
            com.efs.sdk.net.NetConfigManager r4 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0057 }
            int r4 = r4.getDayLimit()     // Catch:{ all -> 0x0057 }
            if (r4 == r1) goto L_0x0058
            com.efs.sdk.net.NetConfigManager r4 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0057 }
            int r4 = r4.getDayLimit()     // Catch:{ all -> 0x0057 }
            if (r3 < r4) goto L_0x0058
            return
        L_0x0057:
        L_0x0058:
            com.efs.sdk.base.EfsReporter r3 = com.efs.sdk.net.NetManager.getReporter()
            java.util.Map r3 = r3.getStrategyMap()
            com.efs.sdk.net.NetConfigManager r4 = com.efs.sdk.net.NetManager.getNetConfigManager()
            int r4 = r4.getDataRate()
            boolean r4 = com.efs.sdk.net.b.a.a((int) r4)
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x0192
            int r6 = r3.size()
            r7 = 2
            if (r6 == r7) goto L_0x0079
            goto L_0x0192
        L_0x0079:
            java.lang.String r6 = "rate"
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x018b }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x018b }
            int r6 = r6.intValue()     // Catch:{ all -> 0x018b }
            boolean r6 = com.efs.sdk.net.b.a.a((int) r6)     // Catch:{ all -> 0x018b }
            if (r4 != 0) goto L_0x0094
            if (r6 != 0) goto L_0x0094
            boolean r8 = com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()     // Catch:{ all -> 0x0189 }
            if (r8 != 0) goto L_0x0094
            return
        L_0x0094:
            java.lang.String r8 = "stra"
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0189 }
            org.json.JSONArray r3 = (org.json.JSONArray) r3     // Catch:{ all -> 0x0189 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x0189 }
            r8.<init>()     // Catch:{ all -> 0x0189 }
            r9 = 1
            if (r3 == 0) goto L_0x0179
            int r10 = r3.length()     // Catch:{ all -> 0x0189 }
            if (r10 <= 0) goto L_0x0179
            r10 = 0
        L_0x00ab:
            int r11 = r3.length()     // Catch:{ all -> 0x0189 }
            if (r10 >= r11) goto L_0x0179
            org.json.JSONObject r11 = r3.optJSONObject(r10)     // Catch:{ all -> 0x0189 }
            java.lang.String r12 = r0.B     // Catch:{ all -> 0x0189 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0189 }
            if (r12 != 0) goto L_0x015a
            java.lang.String r12 = "u"
            java.lang.String r12 = r11.optString(r12)     // Catch:{ all -> 0x0189 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0189 }
            if (r13 != 0) goto L_0x015a
            java.lang.String r13 = "^"
            boolean r13 = r12.startsWith(r13)     // Catch:{ all -> 0x0189 }
            r13 = r13 ^ r9
            if (r13 == 0) goto L_0x0125
            java.lang.String r13 = r0.B     // Catch:{ all -> 0x0189 }
            android.net.Uri r13 = android.net.Uri.parse(r13)     // Catch:{ all -> 0x0189 }
            int r14 = r13.getPort()     // Catch:{ all -> 0x0189 }
            if (r14 < 0) goto L_0x0103
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 > r15) goto L_0x0103
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
            r15.<init>()     // Catch:{ all -> 0x0189 }
            java.lang.String r9 = r13.getHost()     // Catch:{ all -> 0x0189 }
            r15.append(r9)     // Catch:{ all -> 0x0189 }
            java.lang.String r9 = ":"
            r15.append(r9)     // Catch:{ all -> 0x0189 }
            r15.append(r14)     // Catch:{ all -> 0x0189 }
            java.lang.String r9 = r13.getPath()     // Catch:{ all -> 0x0189 }
            r15.append(r9)     // Catch:{ all -> 0x0189 }
            java.lang.String r9 = r15.toString()     // Catch:{ all -> 0x0189 }
            goto L_0x011a
        L_0x0103:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
            r9.<init>()     // Catch:{ all -> 0x0189 }
            java.lang.String r14 = r13.getHost()     // Catch:{ all -> 0x0189 }
            r9.append(r14)     // Catch:{ all -> 0x0189 }
            java.lang.String r13 = r13.getPath()     // Catch:{ all -> 0x0189 }
            r9.append(r13)     // Catch:{ all -> 0x0189 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0189 }
        L_0x011a:
            java.lang.String r9 = com.efs.sdk.net.b.a.a((java.lang.String) r9)     // Catch:{ all -> 0x0189 }
            boolean r9 = r9.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0189 }
            if (r9 == 0) goto L_0x015a
            goto L_0x012d
        L_0x0125:
            java.lang.String r9 = r0.B     // Catch:{ all -> 0x0189 }
            boolean r9 = java.util.regex.Pattern.matches(r12, r9)     // Catch:{ all -> 0x0189 }
            if (r9 == 0) goto L_0x015a
        L_0x012d:
            java.lang.String r9 = "v"
            int r9 = r11.optInt(r9, r1)     // Catch:{ all -> 0x0189 }
            if (r9 == r1) goto L_0x015a
            if (r9 > r7) goto L_0x015a
            java.lang.String r9 = "s"
            int r9 = r11.optInt(r9, r1)     // Catch:{ all -> 0x0189 }
            if (r9 != 0) goto L_0x0143
            r9 = r17
        L_0x0141:
            r12 = 1
            goto L_0x015d
        L_0x0143:
            if (r9 != r7) goto L_0x015a
            com.efs.sdk.net.NetConfigManager r9 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0189 }
            boolean r9 = r9.getNetRequestBodyCollectState()     // Catch:{ all -> 0x0189 }
            if (r9 == 0) goto L_0x015a
            r9 = r17
            java.lang.String r12 = r9.f5474g     // Catch:{ all -> 0x0189 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0189 }
            if (r12 != 0) goto L_0x015c
            goto L_0x0141
        L_0x015a:
            r9 = r17
        L_0x015c:
            r12 = 0
        L_0x015d:
            if (r12 == 0) goto L_0x0174
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0189 }
            r12.<init>()     // Catch:{ all -> 0x0189 }
            java.lang.String r13 = "i"
            int r11 = r11.optInt(r13)     // Catch:{ all -> 0x0189 }
            r12.append(r11)     // Catch:{ all -> 0x0189 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0189 }
            r8.put(r11, r5)     // Catch:{ all -> 0x0189 }
        L_0x0174:
            int r10 = r10 + 1
            r9 = 1
            goto L_0x00ab
        L_0x0179:
            int r0 = r8.size()     // Catch:{ all -> 0x0189 }
            if (r0 == 0) goto L_0x0181
            r9 = 1
            goto L_0x0182
        L_0x0181:
            r9 = 0
        L_0x0182:
            java.lang.String r5 = a((java.util.Map<java.lang.String, java.lang.String>) r8, (boolean) r4, (boolean) r6)     // Catch:{ all -> 0x0187 }
            goto L_0x0194
        L_0x0187:
            r0 = move-exception
            goto L_0x018e
        L_0x0189:
            r0 = move-exception
            goto L_0x018d
        L_0x018b:
            r0 = move-exception
            r6 = 0
        L_0x018d:
            r9 = 0
        L_0x018e:
            r0.printStackTrace()
            goto L_0x0194
        L_0x0192:
            r6 = 0
            r9 = 0
        L_0x0194:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x01a3
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r5 = a((java.util.Map<java.lang.String, java.lang.String>) r0, (boolean) r4, (boolean) r2)
        L_0x01a3:
            java.lang.String r0 = "dx"
            r1 = r18
            r1.put(r0, r5)
            boolean r0 = com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()
            if (r0 == 0) goto L_0x01b4
            a((com.efs.sdk.base.protocol.record.EfsJSONLog) r18)
            return
        L_0x01b4:
            if (r9 == 0) goto L_0x01be
            if (r4 != 0) goto L_0x01ba
            if (r6 == 0) goto L_0x01c3
        L_0x01ba:
            a((com.efs.sdk.base.protocol.record.EfsJSONLog) r18)
            return
        L_0x01be:
            if (r4 == 0) goto L_0x01c3
            a((com.efs.sdk.base.protocol.record.EfsJSONLog) r18)
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.OkHttpListener.a(com.efs.sdk.net.a.d, com.efs.sdk.net.a.c, com.efs.sdk.base.protocol.record.EfsJSONLog):void");
    }
}
