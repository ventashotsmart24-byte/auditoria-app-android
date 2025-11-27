package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

class q implements Callable<String[]> {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5025a;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f36a = new Object();
    private static d hostManager = d.a();

    /* renamed from: a  reason: collision with other field name */
    private s f37a;

    /* renamed from: d  reason: collision with root package name */
    private int f5026d;

    /* renamed from: d  reason: collision with other field name */
    private long f38d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f5027e;
    private Map<String, String> extra;
    private String hostName;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5028j;

    /* renamed from: k  reason: collision with root package name */
    private String f5029k;

    /* renamed from: l  reason: collision with root package name */
    private String f5030l;

    public q(String str, s sVar) {
        this.f5026d = 1;
        this.f5029k = null;
        this.f5027e = f.f20c;
        this.f5028j = false;
        this.f5030l = null;
        this.extra = new HashMap();
        this.f38d = 0;
        this.hostName = str;
        this.f37a = sVar;
    }

    private boolean d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    private boolean e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z11 = true;
        if (map != null) {
            z10 = true;
            for (Map.Entry next : map.entrySet()) {
                sb.append("&sdns-");
                sb.append((String) next.getKey());
                sb.append(Operator.Operation.EQUALS);
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                if (!d((String) next.getKey())) {
                    i.f("设置自定义参数失败，自定义key不合法：" + ((String) next.getKey()));
                    z11 = false;
                }
                if (!e((String) next.getValue())) {
                    i.f("设置自定义参数失败，自定义value不合法：" + ((String) next.getValue()));
                    z10 = false;
                }
            }
        } else {
            z10 = true;
        }
        if (z11 && z10) {
            String sb2 = sb.toString();
            if (sb2.getBytes("UTF-8").length <= 1000) {
                return sb2;
            }
            i.f("设置自定义参数失败，自定义参数过长");
        }
        return "";
    }

    public static void setContext(Context context) {
        f5025a = context;
    }

    public void a(int i10) {
        if (i10 >= 0) {
            this.f5026d = i10;
        }
    }

    public q(String str, s sVar, Map<String, String> map, String str2) {
        this.f5026d = 1;
        this.f5029k = null;
        this.f5027e = f.f20c;
        this.f5028j = false;
        this.f5030l = null;
        HashMap hashMap = new HashMap();
        this.extra = hashMap;
        this.f38d = 0;
        this.hostName = str;
        this.f37a = sVar;
        this.f5030l = str2;
        hashMap.putAll(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v73, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: type inference failed for: r3v66 */
    /* JADX WARNING: type inference failed for: r4v39 */
    /* JADX WARNING: type inference failed for: r3v77 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x03bd A[Catch:{ all -> 0x03ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x03c4 A[Catch:{ all -> 0x03ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x03cc A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03d1 A[SYNTHETIC, Splitter:B:92:0x03d1] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x03d9 A[Catch:{ IOException -> 0x03d5 }, DONT_GENERATE] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] call() {
        /*
            r12 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r12.f38d = r0
            boolean r0 = r12.f5028j
            r1 = 1
            if (r0 != 0) goto L_0x0045
            java.lang.Object r0 = f36a
            monitor-enter(r0)
            com.alibaba.sdk.android.httpdns.d r2 = hostManager     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = r12.hostName     // Catch:{ all -> 0x0042 }
            boolean r2 = r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x0037
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r1.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "host:"
            r1.append(r2)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = r12.hostName     // Catch:{ all -> 0x0042 }
            r1.append(r2)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = " is already resolving"
            r1.append(r2)     // Catch:{ all -> 0x0042 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0042 }
            com.alibaba.sdk.android.httpdns.i.d(r1)     // Catch:{ all -> 0x0042 }
            java.lang.String[] r1 = r12.f5027e     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return r1
        L_0x0037:
            com.alibaba.sdk.android.httpdns.d r2 = hostManager     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = r12.hostName     // Catch:{ all -> 0x0042 }
            r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0042 }
            r12.f5028j = r1     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            goto L_0x0045
        L_0x0042:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r1
        L_0x0045:
            r0 = 40965(0xa005, float:5.7404E-41)
            r2 = 0
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.s r0 = r12.f37a     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.u.a((com.alibaba.sdk.android.httpdns.s) r0)     // Catch:{ all -> 0x03ac }
            r12.f5029k = r0     // Catch:{ all -> 0x03ac }
            if (r0 != 0) goto L_0x0070
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r0.<init>()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "serverIp is null, give up query for hostname:"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.hostName     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.i.d(r0)     // Catch:{ all -> 0x03ac }
            r3 = r2
            r4 = r3
            goto L_0x0383
        L_0x0070:
            com.alibaba.sdk.android.httpdns.c.a r0 = com.alibaba.sdk.android.httpdns.c.a.a()     // Catch:{ all -> 0x03ac }
            android.content.Context r3 = f5025a     // Catch:{ all -> 0x03ac }
            r0.c(r3)     // Catch:{ all -> 0x03ac }
            boolean r0 = com.alibaba.sdk.android.httpdns.a.a()     // Catch:{ all -> 0x03ac }
            if (r0 == 0) goto L_0x017c
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.a.getTimestamp()     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.c.a r3 = com.alibaba.sdk.android.httpdns.c.a.a()     // Catch:{ all -> 0x03ac }
            boolean r3 = r3.h()     // Catch:{ all -> 0x03ac }
            if (r3 == 0) goto L_0x0107
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r3.<init>()     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.f.PROTOCOL     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = r12.f5029k     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.f.f4978d     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.f.f4977c     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "/sign_d?host="
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = r12.hostName     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "&sdk=android_"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "1.3.2.3-no-bssid-ssid"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "&t="
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "&s="
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = r12.hostName     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.a.a(r4, r0)     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = "&sid="
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r0 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r0.getSessionId()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = "&net="
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r0 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r0.l()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r12.getExtra()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
        L_0x0101:
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x03ac }
            goto L_0x0248
        L_0x0107:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r3.<init>()     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.f.PROTOCOL     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = r12.f5029k     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.f.f4978d     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "/"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = com.alibaba.sdk.android.httpdns.f.f4977c     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "/sign_d?host="
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = r12.hostName     // Catch:{ all -> 0x03ac }
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "&sdk=android_"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "1.3.2.3-no-bssid-ssid"
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "&t="
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "&s="
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = r12.hostName     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.a.a(r4, r0)     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = "&sid="
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r0 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r0.getSessionId()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = "&net="
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r0 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r0.l()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r12.getExtra()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            goto L_0x0101
        L_0x017c:
            com.alibaba.sdk.android.httpdns.c.a r0 = com.alibaba.sdk.android.httpdns.c.a.a()     // Catch:{ all -> 0x03ac }
            boolean r0 = r0.h()     // Catch:{ all -> 0x03ac }
            if (r0 == 0) goto L_0x01e9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r0.<init>()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = com.alibaba.sdk.android.httpdns.f.PROTOCOL     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.f5029k     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = ":"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = com.alibaba.sdk.android.httpdns.f.f4978d     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "/"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = com.alibaba.sdk.android.httpdns.f.f4977c     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "/d?host="
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.hostName     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "&sdk=android_"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "1.3.2.3-no-bssid-ssid"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "&sid="
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r3 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r3.getSessionId()     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "&net="
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r3 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r3.l()     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.getExtra()     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
        L_0x01e4:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x03ac }
            goto L_0x0248
        L_0x01e9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r0.<init>()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = com.alibaba.sdk.android.httpdns.f.PROTOCOL     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.f5029k     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = ":"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = com.alibaba.sdk.android.httpdns.f.f4978d     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "/"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = com.alibaba.sdk.android.httpdns.f.f4977c     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "/d?host="
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.hostName     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "&sdk=android_"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "1.3.2.3-no-bssid-ssid"
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "&sid="
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r3 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r3.getSessionId()     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = "&net="
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.e.a r3 = com.alibaba.sdk.android.httpdns.e.a.a()     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r3.l()     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r12.getExtra()     // Catch:{ all -> 0x03ac }
            r0.append(r3)     // Catch:{ all -> 0x03ac }
            goto L_0x01e4
        L_0x0248:
            com.alibaba.sdk.android.httpdns.net64.a r3 = com.alibaba.sdk.android.httpdns.net64.a.a()     // Catch:{ all -> 0x03ac }
            boolean r3 = r3.a()     // Catch:{ all -> 0x03ac }
            if (r3 == 0) goto L_0x0263
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r3.<init>()     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = "&query=4,6"
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x03ac }
        L_0x0263:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ac }
            r3.<init>()     // Catch:{ all -> 0x03ac }
            java.lang.String r4 = "resolve url: "
            r3.append(r4)     // Catch:{ all -> 0x03ac }
            r3.append(r0)     // Catch:{ all -> 0x03ac }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03ac }
            com.alibaba.sdk.android.httpdns.i.f(r3)     // Catch:{ all -> 0x03ac }
            java.net.URL r3 = new java.net.URL     // Catch:{ all -> 0x03ac }
            r3.<init>(r0)     // Catch:{ all -> 0x03ac }
            java.net.URLConnection r0 = r3.openConnection()     // Catch:{ all -> 0x03ac }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x03ac }
            int r3 = com.alibaba.sdk.android.httpdns.f.f4975a     // Catch:{ all -> 0x03a6 }
            r0.setConnectTimeout(r3)     // Catch:{ all -> 0x03a6 }
            int r3 = com.alibaba.sdk.android.httpdns.f.f4975a     // Catch:{ all -> 0x03a6 }
            r0.setReadTimeout(r3)     // Catch:{ all -> 0x03a6 }
            boolean r3 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ all -> 0x03a6 }
            if (r3 == 0) goto L_0x029b
            r3 = r0
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ all -> 0x03a6 }
            com.alibaba.sdk.android.httpdns.q$1 r4 = new com.alibaba.sdk.android.httpdns.q$1     // Catch:{ all -> 0x03a6 }
            r4.<init>()     // Catch:{ all -> 0x03a6 }
            r3.setHostnameVerifier(r4)     // Catch:{ all -> 0x03a6 }
        L_0x029b:
            int r3 = r0.getResponseCode()     // Catch:{ all -> 0x03a6 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == r4) goto L_0x0301
            java.io.InputStream r3 = r0.getErrorStream()     // Catch:{ all -> 0x03a6 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x03a0 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x03a0 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r3, r6)     // Catch:{ all -> 0x03a0 }
            r4.<init>(r5)     // Catch:{ all -> 0x03a0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x039b }
            r2.<init>()     // Catch:{ all -> 0x039b }
        L_0x02b8:
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x039b }
            if (r5 == 0) goto L_0x02c2
            r2.append(r5)     // Catch:{ all -> 0x039b }
            goto L_0x02b8
        L_0x02c2:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x039b }
            r5.<init>()     // Catch:{ all -> 0x039b }
            java.lang.String r6 = "response code is "
            r5.append(r6)     // Catch:{ all -> 0x039b }
            int r6 = r0.getResponseCode()     // Catch:{ all -> 0x039b }
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r6 = " expect 200. response body is "
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x039b }
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.i.f(r5)     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.g r5 = new com.alibaba.sdk.android.httpdns.g     // Catch:{ all -> 0x039b }
            int r6 = r0.getResponseCode()     // Catch:{ all -> 0x039b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x039b }
            r5.<init>(r6, r2)     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.h r2 = new com.alibaba.sdk.android.httpdns.h     // Catch:{ all -> 0x039b }
            int r6 = r0.getResponseCode()     // Catch:{ all -> 0x039b }
            java.lang.String r5 = r5.b()     // Catch:{ all -> 0x039b }
            r2.<init>(r6, r5)     // Catch:{ all -> 0x039b }
            throw r2     // Catch:{ all -> 0x039b }
        L_0x0301:
            java.io.InputStream r3 = r0.getInputStream()     // Catch:{ all -> 0x03a6 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x03a0 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ all -> 0x03a0 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r3, r6)     // Catch:{ all -> 0x03a0 }
            r4.<init>(r5)     // Catch:{ all -> 0x03a0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x039b }
            r2.<init>()     // Catch:{ all -> 0x039b }
        L_0x0316:
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x039b }
            if (r5 == 0) goto L_0x0320
            r2.append(r5)     // Catch:{ all -> 0x039b }
            goto L_0x0316
        L_0x0320:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x039b }
            r5.<init>()     // Catch:{ all -> 0x039b }
            java.lang.String r6 = "resolve host: "
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r6 = r12.hostName     // Catch:{ all -> 0x039b }
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r6 = ", return: "
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x039b }
            r5.append(r6)     // Catch:{ all -> 0x039b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.i.d(r5)     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.e r5 = new com.alibaba.sdk.android.httpdns.e     // Catch:{ all -> 0x039b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x039b }
            r5.<init>((java.lang.String) r2)     // Catch:{ all -> 0x039b }
            java.lang.String r2 = r12.f5030l     // Catch:{ all -> 0x039b }
            r5.setCacheKey(r2)     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.d r2 = hostManager     // Catch:{ all -> 0x039b }
            int r2 = r2.count()     // Catch:{ all -> 0x039b }
            r6 = 100
            if (r2 >= r6) goto L_0x0393
            com.alibaba.sdk.android.httpdns.d r2 = hostManager     // Catch:{ all -> 0x039b }
            java.lang.String r6 = r12.hostName     // Catch:{ all -> 0x039b }
            r2.a((java.lang.String) r6, (com.alibaba.sdk.android.httpdns.e) r5)     // Catch:{ all -> 0x039b }
            java.lang.String r2 = r12.hostName     // Catch:{ all -> 0x039b }
            java.lang.String r6 = r12.f5029k     // Catch:{ all -> 0x039b }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x039b }
            long r9 = r12.f38d     // Catch:{ all -> 0x039b }
            long r7 = r7 - r9
            com.alibaba.sdk.android.httpdns.u.a((java.lang.String) r2, (java.lang.String) r6, (long) r7)     // Catch:{ all -> 0x039b }
            com.alibaba.sdk.android.httpdns.d r2 = hostManager     // Catch:{ all -> 0x039b }
            java.lang.String r6 = r12.hostName     // Catch:{ all -> 0x039b }
            r2.b(r6)     // Catch:{ all -> 0x039b }
            java.lang.String[] r2 = r5.getIps()     // Catch:{ all -> 0x039b }
            r12.f5027e = r2     // Catch:{ all -> 0x039b }
            java.util.Map r2 = r5.a()     // Catch:{ all -> 0x039b }
            r12.extra = r2     // Catch:{ all -> 0x039b }
            r2 = r0
        L_0x0383:
            if (r2 == 0) goto L_0x0388
            r2.disconnect()
        L_0x0388:
            if (r3 == 0) goto L_0x038d
            r3.close()     // Catch:{ IOException -> 0x03d5 }
        L_0x038d:
            if (r4 == 0) goto L_0x03e0
            r4.close()     // Catch:{ IOException -> 0x03d5 }
            goto L_0x03e0
        L_0x0393:
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ all -> 0x039b }
            java.lang.String r5 = "the total number of hosts is exceed 100"
            r2.<init>(r5)     // Catch:{ all -> 0x039b }
            throw r2     // Catch:{ all -> 0x039b }
        L_0x039b:
            r2 = move-exception
            r11 = r2
            r2 = r0
            r0 = r11
            goto L_0x03af
        L_0x03a0:
            r4 = move-exception
            r11 = r2
            r2 = r0
            r0 = r4
            r4 = r11
            goto L_0x03af
        L_0x03a6:
            r3 = move-exception
            r4 = r2
            r2 = r0
            r0 = r3
            r3 = r4
            goto L_0x03af
        L_0x03ac:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x03af:
            com.alibaba.sdk.android.httpdns.i.a(r0)     // Catch:{ all -> 0x03ea }
            java.lang.String r5 = r12.hostName     // Catch:{ all -> 0x03ea }
            java.lang.String r6 = r12.f5029k     // Catch:{ all -> 0x03ea }
            com.alibaba.sdk.android.httpdns.u.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.Throwable) r0)     // Catch:{ all -> 0x03ea }
            int r0 = r12.f5026d     // Catch:{ all -> 0x03ea }
            if (r0 <= 0) goto L_0x03c4
            int r0 = r0 - r1
            r12.f5026d = r0     // Catch:{ all -> 0x03ea }
            r12.call()     // Catch:{ all -> 0x03ea }
            goto L_0x03ca
        L_0x03c4:
            java.lang.String r0 = r12.hostName     // Catch:{ all -> 0x03ea }
            r1 = 0
            com.alibaba.sdk.android.httpdns.u.reportHttpDnsSuccess(r0, r1)     // Catch:{ all -> 0x03ea }
        L_0x03ca:
            if (r2 == 0) goto L_0x03cf
            r2.disconnect()
        L_0x03cf:
            if (r3 == 0) goto L_0x03d7
            r3.close()     // Catch:{ IOException -> 0x03d5 }
            goto L_0x03d7
        L_0x03d5:
            r0 = move-exception
            goto L_0x03dd
        L_0x03d7:
            if (r4 == 0) goto L_0x03e0
            r4.close()     // Catch:{ IOException -> 0x03d5 }
            goto L_0x03e0
        L_0x03dd:
            com.alibaba.sdk.android.httpdns.i.a(r0)
        L_0x03e0:
            com.alibaba.sdk.android.httpdns.d r0 = hostManager
            java.lang.String r1 = r12.hostName
            r0.b(r1)
            java.lang.String[] r0 = r12.f5027e
            return r0
        L_0x03ea:
            r0 = move-exception
            if (r2 == 0) goto L_0x03f0
            r2.disconnect()
        L_0x03f0:
            if (r3 == 0) goto L_0x03f8
            r3.close()     // Catch:{ IOException -> 0x03f6 }
            goto L_0x03f8
        L_0x03f6:
            r1 = move-exception
            goto L_0x03fe
        L_0x03f8:
            if (r4 == 0) goto L_0x0401
            r4.close()     // Catch:{ IOException -> 0x03f6 }
            goto L_0x0401
        L_0x03fe:
            com.alibaba.sdk.android.httpdns.i.a(r1)
        L_0x0401:
            goto L_0x0403
        L_0x0402:
            throw r0
        L_0x0403:
            goto L_0x0402
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.q.call():java.lang.String[]");
    }
}
