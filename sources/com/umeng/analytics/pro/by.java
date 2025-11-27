package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.net.URL;
import java.util.Map;

public class by {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13998a = "resolve.umeng.com";

    /* renamed from: b  reason: collision with root package name */
    public static final int f13999b = 15000;

    /* renamed from: c  reason: collision with root package name */
    private static cc f14000c = null;

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f14001d = -1;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final by f14002a = new by();

        private a() {
        }
    }

    public static by a() {
        return a.f14002a;
    }

    private String c() {
        if (f14000c == null) {
            f14000c = cc.b();
        }
        ca caVar = new ca("https://resolve.umeng.com/resolve", ca.a.GET, (Map<String, String>) null, f14000c);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return caVar.a(f13999b, "");
    }

    public synchronized boolean b() {
        if (f14001d < 0) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "cj_domain", "0");
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + imprintProperty);
            if ("1".equalsIgnoreCase(imprintProperty)) {
                f14001d = 1;
            } else {
                f14001d = 0;
            }
        }
        return f14001d <= 0;
    }

    private by() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String a(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r3)
            return r0
        L_0x000b:
            r3.c()     // Catch:{ all -> 0x0037 }
            com.umeng.analytics.pro.cc r1 = com.umeng.analytics.pro.cc.b()     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r1.c()     // Catch:{ all -> 0x0037 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0037 }
            if (r2 != 0) goto L_0x0035
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r0.<init>()     // Catch:{ all -> 0x0037 }
            java.lang.String r2 = "https://"
            r0.append(r2)     // Catch:{ all -> 0x0037 }
            r0.append(r1)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "/"
            r0.append(r1)     // Catch:{ all -> 0x0037 }
            r0.append(r4)     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0037 }
        L_0x0035:
            monitor-exit(r3)
            return r0
        L_0x0037:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.by.a(java.lang.String):java.lang.String");
    }

    private static String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return "https://" + str + Operator.Operation.DIVISION + str2;
    }

    public static String b(String str) {
        try {
            String c10 = c(str);
            return str.substring(str.indexOf(c10) + c10.length() + 1);
        } catch (Throwable unused) {
            return "";
        }
    }
}
