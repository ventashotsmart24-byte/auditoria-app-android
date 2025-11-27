package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.f;
import com.umeng.common.b;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONStringer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13672a = 20;

    /* renamed from: b  reason: collision with root package name */
    private static final String f13673b = "umeng_pcp";

    /* renamed from: c  reason: collision with root package name */
    private static final String f13674c = "mob";

    /* renamed from: d  reason: collision with root package name */
    private static final String f13675d = "em";

    /* renamed from: e  reason: collision with root package name */
    private static final String f13676e = "cp";

    /* renamed from: f  reason: collision with root package name */
    private static final String f13677f = "pk";

    /* renamed from: g  reason: collision with root package name */
    private static final String f13678g = "pv";

    /* renamed from: h  reason: collision with root package name */
    private static String[] f13679h = new String[2];

    /* renamed from: i  reason: collision with root package name */
    private static Object f13680i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static Map<String, Object> f13681j = new HashMap();

    public static void a(Context context, String str, String str2) {
        String[] strArr = f13679h;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f13679h;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            b.a(context).b();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> c(android.content.Context r8) {
        /*
            java.lang.String r0 = "umeng_pcp"
            r1 = 0
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r0, r1)
            java.lang.String r0 = "cp"
            java.lang.String r2 = ""
            java.lang.String r3 = r8.getString(r0, r2)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L_0x0068
            byte[] r3 = android.util.Base64.decode(r3, r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = com.umeng.commonsdk.UMConfigure.sAppkey     // Catch:{ all -> 0x0068 }
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x0068 }
            byte[] r3 = com.umeng.analytics.pro.ax.a((byte[]) r3, (byte[]) r4)     // Catch:{ all -> 0x0068 }
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0068 }
            r4.<init>(r3)     // Catch:{ all -> 0x0068 }
            int r3 = r4.length()     // Catch:{ all -> 0x0068 }
            if (r3 <= 0) goto L_0x0068
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0068 }
            r3.<init>()     // Catch:{ all -> 0x0068 }
            org.json.JSONTokener r5 = new org.json.JSONTokener     // Catch:{  }
            r5.<init>(r4)     // Catch:{  }
            java.lang.Object r4 = r5.nextValue()     // Catch:{ all -> 0x0067 }
            org.json.JSONArray r4 = (org.json.JSONArray) r4     // Catch:{ all -> 0x0067 }
        L_0x003f:
            int r5 = r4.length()     // Catch:{ all -> 0x0067 }
            if (r1 >= r5) goto L_0x005b
            org.json.JSONObject r5 = r4.getJSONObject(r1)     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "pk"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = "pv"
            java.lang.Object r5 = r5.get(r7)     // Catch:{ all -> 0x0067 }
            r3.put(r6, r5)     // Catch:{ all -> 0x0067 }
            int r1 = r1 + 1
            goto L_0x003f
        L_0x005b:
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ all -> 0x0067 }
            android.content.SharedPreferences$Editor r8 = r8.putString(r0, r2)     // Catch:{ all -> 0x0067 }
            r8.apply()     // Catch:{ all -> 0x0067 }
            return r3
        L_0x0067:
            r5 = r3
        L_0x0068:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.c.c(android.content.Context):java.util.Map");
    }

    public static String[] a(Context context) {
        String[] a10;
        if (!TextUtils.isEmpty(f13679h[0]) && !TextUtils.isEmpty(f13679h[1])) {
            return f13679h;
        }
        if (context == null || (a10 = b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f13679h;
        strArr[0] = a10[0];
        strArr[1] = a10[1];
        return strArr;
    }

    public static void b(String str) {
        String str2;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f13673b, 0);
                byte[] a10 = ax.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                if (a10.length == 0) {
                    str2 = f.Q;
                } else {
                    str2 = Base64.encodeToString(a10, 0);
                }
                sharedPreferences.edit().putString(f13675d, str2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        String str2;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            try {
                SharedPreferences sharedPreferences = appContext.getSharedPreferences(f13673b, 0);
                byte[] a10 = ax.a(str.getBytes(), UMConfigure.sAppkey.getBytes());
                if (a10.length == 0) {
                    str2 = f.Q;
                } else {
                    str2 = Base64.encodeToString(a10, 0);
                }
                sharedPreferences.edit().putString(f13674c, str2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(f13673b, 0);
            String string = sharedPreferences.getString(f13675d, "");
            if (f.Q.equals(string)) {
                sharedPreferences.edit().putString(f13675d, "").apply();
                return "";
            } else if (TextUtils.isEmpty(string)) {
                return null;
            } else {
                sharedPreferences.edit().putString(f13675d, "").apply();
                return new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a() {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = appContext.getSharedPreferences(f13673b, 0);
            String string = sharedPreferences.getString(f13674c, "");
            if (f.Q.equals(string)) {
                sharedPreferences.edit().putString(f13674c, "").apply();
                return "";
            } else if (TextUtils.isEmpty(string)) {
                return null;
            } else {
                sharedPreferences.edit().putString(f13674c, "").apply();
                return new String(ax.a(Base64.decode(string, 0), UMConfigure.sAppkey.getBytes()));
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, Map<String, Object> map) {
        if (map != null) {
            JSONStringer jSONStringer = new JSONStringer();
            try {
                synchronized (f13680i) {
                    jSONStringer.array();
                    for (String next : map.keySet()) {
                        jSONStringer.object();
                        jSONStringer.key("pk");
                        jSONStringer.value(next);
                        jSONStringer.key("pv");
                        jSONStringer.value(map.get(next));
                        jSONStringer.endObject();
                    }
                    jSONStringer.endArray();
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences(f13673b, 0);
                sharedPreferences.edit().putString(f13676e, Base64.encodeToString(ax.a(jSONStringer.toString().getBytes(), UMConfigure.sAppkey.getBytes()), 0)).apply();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r4, java.lang.Object r5) {
        /*
            java.lang.Object r0 = f13680i
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Object> r1 = f13681j     // Catch:{ all -> 0x007e }
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0038
            java.lang.String r1 = "MobclickRT"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r2.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "更新账号自定义KV: key="
            r2.append(r3)     // Catch:{ all -> 0x007e }
            r2.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "; val="
            r2.append(r3)     // Catch:{ all -> 0x007e }
            r2.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007e }
            com.umeng.commonsdk.debug.UMRTLog.i(r1, r2)     // Catch:{ all -> 0x007e }
            java.util.Map<java.lang.String, java.lang.Object> r1 = f13681j     // Catch:{ all -> 0x007e }
            r1.put(r4, r5)     // Catch:{ all -> 0x007e }
            android.content.Context r4 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x007e }
            java.util.Map<java.lang.String, java.lang.Object> r5 = f13681j     // Catch:{ all -> 0x007e }
            a((android.content.Context) r4, (java.util.Map<java.lang.String, java.lang.Object>) r5)     // Catch:{ all -> 0x007e }
            goto L_0x007c
        L_0x0038:
            java.util.Map<java.lang.String, java.lang.Object> r1 = f13681j     // Catch:{ all -> 0x007e }
            int r1 = r1.size()     // Catch:{ all -> 0x007e }
            r2 = 20
            if (r1 < r2) goto L_0x0050
            java.lang.String r4 = "MobclickRT"
            java.lang.String r5 = "设置账号自定义KV: 已经设置20个KV键值对，忽略设置请求。"
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r5)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = "userProfile: Only 20 user-defined key-value pairs can be configured, please check!"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x007e }
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return
        L_0x0050:
            java.lang.String r1 = "MobclickRT"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r2.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "设置账号自定义KV: key="
            r2.append(r3)     // Catch:{ all -> 0x007e }
            r2.append(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "; val="
            r2.append(r3)     // Catch:{ all -> 0x007e }
            r2.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x007e }
            com.umeng.commonsdk.debug.UMRTLog.i(r1, r2)     // Catch:{ all -> 0x007e }
            java.util.Map<java.lang.String, java.lang.Object> r1 = f13681j     // Catch:{ all -> 0x007e }
            r1.put(r4, r5)     // Catch:{ all -> 0x007e }
            android.content.Context r4 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch:{ all -> 0x007e }
            java.util.Map<java.lang.String, java.lang.Object> r5 = f13681j     // Catch:{ all -> 0x007e }
            a((android.content.Context) r4, (java.util.Map<java.lang.String, java.lang.Object>) r5)     // Catch:{ all -> 0x007e }
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return
        L_0x007e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.c.a(java.lang.String, java.lang.Object):void");
    }
}
