package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.sdk.android.httpdns.d.b;
import com.alibaba.sdk.android.httpdns.d.c;
import com.hpplay.sdk.source.common.global.Constant;
import java.net.SocketTimeoutException;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f5040a = null;

    /* renamed from: a  reason: collision with other field name */
    private static a f39a = a.ENABLE;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f5041d = false;

    /* renamed from: e  reason: collision with root package name */
    private static long f5042e = 0;

    /* renamed from: g  reason: collision with root package name */
    private static volatile int f5043g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static volatile int f5044h = 0;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f5045l = false;

    public enum a {
        ENABLE,
        PRE_DISABLE,
        DISABLE
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(com.alibaba.sdk.android.httpdns.s r5) {
        /*
            java.lang.Class<com.alibaba.sdk.android.httpdns.u> r0 = com.alibaba.sdk.android.httpdns.u.class
            monitor-enter(r0)
            r1 = 0
            com.alibaba.sdk.android.httpdns.s r2 = com.alibaba.sdk.android.httpdns.s.QUERY_HOST     // Catch:{ Exception -> 0x003d }
            if (r5 == r2) goto L_0x001a
            com.alibaba.sdk.android.httpdns.s r3 = com.alibaba.sdk.android.httpdns.s.SNIFF_HOST     // Catch:{ Exception -> 0x003d }
            if (r5 != r3) goto L_0x000d
            goto L_0x001a
        L_0x000d:
            com.alibaba.sdk.android.httpdns.s r2 = com.alibaba.sdk.android.httpdns.s.QUERY_SCHEDULE_CENTER     // Catch:{ Exception -> 0x003d }
            if (r5 == r2) goto L_0x0018
            com.alibaba.sdk.android.httpdns.s r2 = com.alibaba.sdk.android.httpdns.s.SNIFF_SCHEDULE_CENTER     // Catch:{ Exception -> 0x003d }
            if (r5 != r2) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            monitor-exit(r0)
            return r1
        L_0x0018:
            monitor-exit(r0)
            return r1
        L_0x001a:
            com.alibaba.sdk.android.httpdns.u$a r3 = f39a     // Catch:{ Exception -> 0x003d }
            com.alibaba.sdk.android.httpdns.u$a r4 = com.alibaba.sdk.android.httpdns.u.a.ENABLE     // Catch:{ Exception -> 0x003d }
            if (r3 == r4) goto L_0x0033
            com.alibaba.sdk.android.httpdns.u$a r3 = f39a     // Catch:{ Exception -> 0x003d }
            com.alibaba.sdk.android.httpdns.u$a r4 = com.alibaba.sdk.android.httpdns.u.a.PRE_DISABLE     // Catch:{ Exception -> 0x003d }
            if (r3 != r4) goto L_0x0027
            goto L_0x0033
        L_0x0027:
            if (r5 != r2) goto L_0x002b
            monitor-exit(r0)
            return r1
        L_0x002b:
            java.lang.String[] r5 = com.alibaba.sdk.android.httpdns.f.f19a     // Catch:{ Exception -> 0x003d }
            int r2 = f5043g     // Catch:{ Exception -> 0x003d }
            r5 = r5[r2]     // Catch:{ Exception -> 0x003d }
            monitor-exit(r0)
            return r5
        L_0x0033:
            java.lang.String[] r5 = com.alibaba.sdk.android.httpdns.f.f19a     // Catch:{ Exception -> 0x003d }
            int r2 = f5043g     // Catch:{ Exception -> 0x003d }
            r5 = r5[r2]     // Catch:{ Exception -> 0x003d }
            monitor-exit(r0)
            return r5
        L_0x003b:
            r5 = move-exception
            goto L_0x0043
        L_0x003d:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x003b }
            monitor-exit(r0)
            return r1
        L_0x0043:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.u.a(com.alibaba.sdk.android.httpdns.s):java.lang.String");
    }

    public static void b(int i10) {
        if (f5040a != null && i10 >= 0 && i10 < f.f19a.length) {
            f5043g = i10;
            SharedPreferences.Editor edit = f5040a.edit();
            edit.putInt("activiate_ip_index", i10);
            edit.putLong("activiated_ip_index_modified_time", System.currentTimeMillis());
            edit.commit();
        }
    }

    public static synchronized void d(boolean z10) {
        synchronized (u.class) {
            if (f5045l != z10) {
                f5045l = z10;
                SharedPreferences sharedPreferences = f5040a;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(Constant.KEY_STATUS, f5045l);
                    edit.putLong("disable_modified_time", System.currentTimeMillis());
                    edit.commit();
                }
            }
        }
    }

    public static synchronized boolean e() {
        boolean z10;
        synchronized (u.class) {
            z10 = f5045l;
        }
        return z10;
    }

    private static void h() {
        f5043g = f5043g == f.f19a.length + -1 ? 0 : f5043g + 1;
        b(f5043g);
    }

    public static void i() {
        b(0);
        f5044h = f5043g;
        t.a().c(true);
    }

    public static void j() {
        t.a().c(true);
    }

    public static void reportHttpDnsSuccess(String str, int i10) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                a10.a(str, i10, c.a(), com.alibaba.sdk.android.httpdns.b.b.a() != null ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (u.class) {
            if (!f5041d) {
                synchronized (u.class) {
                    if (!f5041d) {
                        if (context != null) {
                            f5040a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        f5045l = f5040a.getBoolean(Constant.KEY_STATUS, false);
                        f5043g = f5040a.getInt("activiate_ip_index", 0);
                        f5044h = f5043g;
                        f5042e = f5040a.getLong("disable_modified_time", 0);
                        if (System.currentTimeMillis() - f5042e >= 86400000) {
                            d(false);
                        }
                        f39a = f5045l ? a.DISABLE : a.ENABLE;
                        f5041d = true;
                    }
                }
            }
        }
    }

    private static void b(String str, String str2, long j10) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                a10.b(str2, j10, c.a());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static void h(String str) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                String d10 = n.a().d();
                int i10 = f5043g;
                if (i10 == 0) {
                    i10 = f.f19a.length;
                }
                int i11 = i10 - 1;
                int length = i11 == 0 ? f.f19a.length - 1 : i11 - 1;
                if (i11 >= 0) {
                    String[] strArr = f.f19a;
                    if (i11 < strArr.length && length >= 0 && length < strArr.length) {
                        String str2 = strArr[i11];
                        a10.b(str, d10, strArr[length] + "," + str2);
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static synchronized void a(String str, String str2, long j10) {
        synchronized (u.class) {
            try {
                b(str, str2, j10);
                reportHttpDnsSuccess(str, 1);
                a aVar = f39a;
                a aVar2 = a.ENABLE;
                if (!(aVar == aVar2 || str2 == null || !str2.equals(f.f19a[f5043g]))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(f39a == a.DISABLE ? "Disable " : "Pre_disable ");
                    sb.append("mode finished. Enter enable mode.");
                    i.f(sb.toString());
                    f39a = aVar2;
                    d(false);
                    t.a().g();
                    f5044h = f5043g;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return;
    }

    public static synchronized void a(String str, String str2, Throwable th) {
        synchronized (u.class) {
            try {
                a(str2, th);
                if (a(th) && str2 != null && str2.equals(f.f19a[f5043g])) {
                    h();
                    if (f5044h == f5043g) {
                        t.a().c(false);
                        n.a().c();
                    }
                    if (f39a == a.ENABLE) {
                        f39a = a.PRE_DISABLE;
                        i.f("enter pre_disable mode");
                    } else if (f39a == a.PRE_DISABLE) {
                        f39a = a.DISABLE;
                        i.f("enter disable mode");
                        d(true);
                        h(str);
                        t.a().g(str);
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return;
    }

    private static void a(String str, Throwable th) {
        try {
            b a10 = b.a();
            if (a10 != null) {
                int a11 = c.a(th);
                a10.a(str, String.valueOf(a11), c.a(th), c.a(), com.alibaba.sdk.android.httpdns.net64.a.a().i() ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static boolean a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        if (th instanceof h) {
            h hVar = (h) th;
            return hVar.getErrorCode() == 403 && hVar.getMessage().equals("ServiceLevelDeny");
        }
    }
}
