package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.umeng.analytics.pro.by;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class f {
    static String PROTOCOL = "http://";

    /* renamed from: a  reason: collision with root package name */
    static int f4975a = by.f13999b;

    /* renamed from: a  reason: collision with other field name */
    static List<IPProbeItem> f18a = null;

    /* renamed from: a  reason: collision with other field name */
    static String[] f19a = {"203.107.1.1"};

    /* renamed from: b  reason: collision with root package name */
    static final String[] f4976b = {"203.107.1.97", "203.107.1.100", "httpdns-sc.aliyuncs.com"};

    /* renamed from: c  reason: collision with root package name */
    static String f4977c;

    /* renamed from: c  reason: collision with other field name */
    static final String[] f20c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    static String f4978d = "80";
    static Map<String, String> extra = new HashMap();

    public static synchronized void a(List<IPProbeItem> list) {
        synchronized (f.class) {
            f18a = list;
        }
    }

    public static synchronized void c(String str) {
        synchronized (f.class) {
            f4977c = str;
        }
    }

    public static synchronized void clearSdnsGlobalParams() {
        synchronized (f.class) {
            extra.clear();
        }
    }

    public static synchronized void setHTTPSRequestEnabled(boolean z10) {
        String str;
        synchronized (f.class) {
            if (z10) {
                PROTOCOL = "https://";
                str = "443";
            } else {
                PROTOCOL = "http://";
                str = "80";
            }
            f4978d = str;
        }
    }

    public static synchronized void setSdnsGlobalParams(Map<String, String> map) {
        synchronized (f.class) {
            extra.putAll(map);
        }
    }

    public static synchronized void setTimeoutInterval(int i10) {
        synchronized (f.class) {
            if (i10 > 0) {
                f4975a = i10;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(java.lang.String[] r2) {
        /*
            java.lang.Class<com.alibaba.sdk.android.httpdns.f> r0 = com.alibaba.sdk.android.httpdns.f.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x002a
            int r1 = r2.length     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x002a
            f19a = r2     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r2.<init>()     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = "serverIps:"
            r2.append(r1)     // Catch:{ all -> 0x0027 }
            java.lang.String[] r1 = f19a     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = java.util.Arrays.toString(r1)     // Catch:{ all -> 0x0027 }
            r2.append(r1)     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0027 }
            com.alibaba.sdk.android.httpdns.i.d(r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)
            r2 = 1
            return r2
        L_0x0027:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x002a:
            monitor-exit(r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.a(java.lang.String[]):boolean");
    }
}
