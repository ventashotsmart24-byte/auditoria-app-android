package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.hpplay.component.protocol.push.IPushHandler;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.analytics.vshelper.b;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static String f14335a;

    /* renamed from: d  reason: collision with root package name */
    static String f14336d = null;

    /* renamed from: e  reason: collision with root package name */
    static int f14337e = -1;

    /* renamed from: i  reason: collision with root package name */
    private static JSONArray f14338i = new JSONArray();

    /* renamed from: j  reason: collision with root package name */
    private static Object f14339j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static Application f14340k = null;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static boolean f14341o = true;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static Object f14342p = new Object();
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static cd f14343q = new b();

    /* renamed from: b  reason: collision with root package name */
    boolean f14344b;

    /* renamed from: c  reason: collision with root package name */
    boolean f14345c;

    /* renamed from: f  reason: collision with root package name */
    com.umeng.analytics.vshelper.a f14346f;

    /* renamed from: g  reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f14347g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Long> f14348h;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14349l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f14350m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f14351n;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final n f14353a = new n();

        private a() {
        }
    }

    public static /* synthetic */ int a(n nVar) {
        int i10 = nVar.f14351n;
        nVar.f14351n = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int b(n nVar) {
        int i10 = nVar.f14350m;
        nVar.f14350m = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int e(n nVar) {
        int i10 = nVar.f14351n;
        nVar.f14351n = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int f(n nVar) {
        int i10 = nVar.f14350m;
        nVar.f14350m = i10 + 1;
        return i10;
    }

    private void g() {
        if (!this.f14349l) {
            this.f14349l = true;
            if (f14340k != null) {
                f14340k.registerActivityLifecycleCallbacks(this.f14347g);
            }
        }
    }

    private n() {
        this.f14348h = new HashMap();
        this.f14349l = false;
        this.f14344b = false;
        this.f14345c = false;
        this.f14350m = 0;
        this.f14351n = 0;
        this.f14346f = PageNameMonitor.getInstance();
        this.f14347g = new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                n.f14343q.a(activity, bundle);
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (n.f14342p) {
                        if (n.f14341o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    n.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    n.this.f14344b = false;
                    n.f14343q.d(activity);
                } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            }

            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (n.f14342p) {
                        if (n.f14341o) {
                            boolean unused = n.f14341o = false;
                        }
                    }
                    n.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    n.this.a(activity);
                }
                n.f14343q.c(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (n.this.f14350m <= 0) {
                        if (n.f14336d == null) {
                            n.f14336d = UUID.randomUUID().toString();
                        }
                        if (n.f14337e == -1) {
                            n.f14337e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (n.f14337e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                            if (a10 != null) {
                                a10.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            n.f14337e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, l.ar);
                            }
                        } else if (n.f14337e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", n.f14336d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (n.this.f14351n < 0) {
                        n.e(n.this);
                    } else {
                        n.f(n.this);
                    }
                }
            }

            public void onActivityStopped(Activity activity) {
                UMLog uMLog = UMConfigure.umDebugLog;
                MobclickAgent.PageMode pageMode = MobclickAgent.PageMode.AUTO;
                if (activity == null) {
                    return;
                }
                if (activity.isChangingConfigurations()) {
                    n.a(n.this);
                    return;
                }
                n.b(n.this);
                if (n.this.f14350m > 0) {
                    return;
                }
                if (n.f14337e != 0 || !UMUtils.isMainProgress(activity)) {
                    int i10 = n.f14337e;
                    if (i10 == 1 || (i10 == 0 && !UMUtils.isMainProgress(activity))) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("pairUUID", n.f14336d);
                        hashMap.put(IPushHandler.REASON, "Normal");
                        hashMap.put("pid", Integer.valueOf(Process.myPid()));
                        hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                        hashMap.put("activityName", activity.toString());
                        com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                        if (a10 != null) {
                            a10.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                        }
                        if (n.f14336d != null) {
                            n.f14336d = null;
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f14340k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r0 = r5.getLocalClassName();
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + r0);
        a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getGlobleActivity(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        if (r5 != null) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r0 = f14342p
            monitor-enter(r0)
            boolean r1 = f14341o     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0037
            r1 = 0
            f14341o = r1     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            android.app.Activity r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getGlobleActivity(r5)
            if (r5 != 0) goto L_0x0019
            java.lang.String r5 = "MobclickRT"
            java.lang.String r0 = "--->>> init触发onResume: 无前台Activity，直接退出。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r0)
            return
        L_0x0019:
            java.lang.String r0 = r5.getLocalClassName()
            java.lang.String r1 = "MobclickRT"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "--->>> init触发onResume: 补救成功，前台Activity名："
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.umeng.commonsdk.debug.UMRTLog.e(r1, r0)
            r4.a((android.app.Activity) r5)
            return
        L_0x0037:
            java.lang.String r5 = "MobclickRT"
            java.lang.String r1 = "--->>> init触发onResume: firstResumeCall = false，直接返回。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r1)     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return
        L_0x0040:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.n.b(android.content.Context):void");
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f14339j) {
                    jSONArray = f14338i.toString();
                    f14338i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(g.d.a.f14257c, new JSONArray(jSONArray));
                    k.a(context).a(w.a().c(), jSONObject, k.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f14349l;
    }

    public static synchronized n a(Context context) {
        n a10;
        synchronized (n.class) {
            if (f14340k == null && context != null) {
                if (context instanceof Activity) {
                    f14340k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    f14340k = (Application) context;
                }
            }
            a10 = a.f14353a;
        }
        return a10;
    }

    public static void a(Context context, String str) {
        if (f14337e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f14336d);
            hashMap.put(IPushHandler.REASON, str);
            if (f14336d != null) {
                f14336d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.f14349l = false;
        if (f14340k != null) {
            f14340k.unregisterActivityLifecycleCallbacks(this.f14347g);
            f14340k = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x007c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.app.Activity r8) {
        /*
            r7 = this;
            java.util.Map<java.lang.String, java.lang.Long> r0 = r7.f14348h     // Catch:{ all -> 0x0084 }
            monitor-enter(r0)     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = f14335a     // Catch:{ all -> 0x0081 }
            if (r1 != 0) goto L_0x0027
            if (r8 == 0) goto L_0x0027
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r1.<init>()     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = r8.getPackageName()     // Catch:{ all -> 0x0081 }
            r1.append(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "."
            r1.append(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r8 = r8.getLocalClassName()     // Catch:{ all -> 0x0081 }
            r1.append(r8)     // Catch:{ all -> 0x0081 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0081 }
            f14335a = r8     // Catch:{ all -> 0x0081 }
        L_0x0027:
            java.lang.String r8 = f14335a     // Catch:{ all -> 0x0081 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0081 }
            if (r8 != 0) goto L_0x0054
            java.util.Map<java.lang.String, java.lang.Long> r8 = r7.f14348h     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = f14335a     // Catch:{ all -> 0x0081 }
            boolean r8 = r8.containsKey(r1)     // Catch:{ all -> 0x0081 }
            if (r8 == 0) goto L_0x0054
            java.util.Map<java.lang.String, java.lang.Long> r8 = r7.f14348h     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = f14335a     // Catch:{ all -> 0x0081 }
            java.lang.Object r8 = r8.get(r1)     // Catch:{ all -> 0x0081 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0081 }
            long r1 = r8.longValue()     // Catch:{ all -> 0x0081 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0081 }
            long r3 = r3 - r1
            java.util.Map<java.lang.String, java.lang.Long> r8 = r7.f14348h     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = f14335a     // Catch:{ all -> 0x0081 }
            r8.remove(r5)     // Catch:{ all -> 0x0081 }
            goto L_0x0057
        L_0x0054:
            r1 = 0
            r3 = r1
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            java.lang.Object r8 = f14339j     // Catch:{ all -> 0x0084 }
            monitor-enter(r8)     // Catch:{ all -> 0x0084 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x007c }
            r0.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "page_name"
            java.lang.String r6 = f14335a     // Catch:{ all -> 0x007c }
            r0.put(r5, r6)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "duration"
            r0.put(r5, r3)     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "page_start"
            r0.put(r3, r1)     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "type"
            r2 = 0
            r0.put(r1, r2)     // Catch:{ all -> 0x007c }
            org.json.JSONArray r1 = f14338i     // Catch:{ all -> 0x007c }
            r1.put(r0)     // Catch:{ all -> 0x007c }
        L_0x007c:
            monitor-exit(r8)     // Catch:{ all -> 0x007e }
            goto L_0x0084
        L_0x007e:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x007e }
            throw r0     // Catch:{ all -> 0x0084 }
        L_0x0081:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            throw r8     // Catch:{ all -> 0x0084 }
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.n.c(android.app.Activity):void");
    }

    private void b(Activity activity) {
        f14335a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f14348h) {
            this.f14348h.put(f14335a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f14342p) {
                    com.umeng.analytics.b.a().h();
                }
            }
        } else if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f14346f.activityResume(str);
            if (this.f14344b) {
                this.f14344b = false;
                if (TextUtils.isEmpty(f14335a)) {
                    f14335a = str;
                } else if (!f14335a.equals(str)) {
                    b(activity);
                    synchronized (f14342p) {
                        com.umeng.analytics.b.a().h();
                    }
                }
            } else {
                b(activity);
                synchronized (f14342p) {
                    com.umeng.analytics.b.a().h();
                }
            }
        }
    }
}
