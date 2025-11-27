package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.f;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.pro.r;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.w;
import com.umeng.analytics.pro.x;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements p, v {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a  reason: collision with root package name */
    private static Context f13645a = null;

    /* renamed from: h  reason: collision with root package name */
    private static final String f13646h = "sp_uapp";

    /* renamed from: i  reason: collision with root package name */
    private static final String f13647i = "prepp_uapp";

    /* renamed from: o  reason: collision with root package name */
    private static final int f13648o = 128;

    /* renamed from: p  reason: collision with root package name */
    private static final int f13649p = 256;

    /* renamed from: q  reason: collision with root package name */
    private static String f13650q = "";

    /* renamed from: r  reason: collision with root package name */
    private static String f13651r = "";

    /* renamed from: s  reason: collision with root package name */
    private static final String f13652s = f.ar;

    /* renamed from: t  reason: collision with root package name */
    private static final String f13653t = "ekv_bl_ver";

    /* renamed from: v  reason: collision with root package name */
    private static final String f13654v = f.as;

    /* renamed from: w  reason: collision with root package name */
    private static final String f13655w = "ekv_wl_ver";

    /* renamed from: z  reason: collision with root package name */
    private static final String f13656z = "umsp_1";

    /* renamed from: b  reason: collision with root package name */
    private ISysListener f13657b;

    /* renamed from: c  reason: collision with root package name */
    private r f13658c;

    /* renamed from: d  reason: collision with root package name */
    private x f13659d;

    /* renamed from: e  reason: collision with root package name */
    private m f13660e;

    /* renamed from: f  reason: collision with root package name */
    private w f13661f;

    /* renamed from: g  reason: collision with root package name */
    private n f13662g;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13663j;

    /* renamed from: k  reason: collision with root package name */
    private volatile JSONObject f13664k;

    /* renamed from: l  reason: collision with root package name */
    private volatile JSONObject f13665l;

    /* renamed from: m  reason: collision with root package name */
    private volatile JSONObject f13666m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13667n;

    /* renamed from: u  reason: collision with root package name */
    private com.umeng.analytics.filter.a f13668u;

    /* renamed from: x  reason: collision with root package name */
    private com.umeng.analytics.filter.b f13669x;

    /* renamed from: y  reason: collision with root package name */
    private o f13670y;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final b f13671a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f13645a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.f13671a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:5|(1:7)|8|(1:10)|11|(1:13)|14|(2:16|17)|18|19|(2:21|23)(1:25)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[Catch:{ all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0008
            java.lang.String r3 = "unexpected null context in getNativeSuperProperties"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r3)     // Catch:{ all -> 0x004b }
            return
        L_0x0008:
            android.content.Context r0 = f13645a     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0012
            android.content.Context r0 = r3.getApplicationContext()     // Catch:{ all -> 0x004b }
            f13645a = r0     // Catch:{ all -> 0x004b }
        L_0x0012:
            android.content.SharedPreferences r3 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r3)     // Catch:{ all -> 0x004b }
            org.json.JSONObject r0 = r2.f13664k     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0021
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            r2.f13664k = r0     // Catch:{ all -> 0x004b }
        L_0x0021:
            org.json.JSONObject r0 = r2.f13665l     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x002c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            r2.f13665l = r0     // Catch:{ all -> 0x004b }
        L_0x002c:
            java.lang.String r0 = "prepp_uapp"
            r1 = 0
            java.lang.String r3 = r3.getString(r0, r1)     // Catch:{ all -> 0x004b }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0040
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0040 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0040 }
            r2.f13666m = r0     // Catch:{ JSONException -> 0x0040 }
        L_0x0040:
            org.json.JSONObject r3 = r2.f13666m     // Catch:{ all -> 0x004b }
            if (r3 != 0) goto L_0x004b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x004b }
            r3.<init>()     // Catch:{ all -> 0x004b }
            r2.f13666m = r3     // Catch:{ all -> 0x004b }
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.i(android.content.Context):void");
    }

    public JSONObject b() {
        return this.f13664k;
    }

    public JSONObject c() {
        return this.f13666m;
    }

    public JSONObject d() {
        return this.f13665l;
    }

    public void e() {
        this.f13665l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f13645a)) {
            return f13650q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(f13645a)) {
            return f13651r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = f13645a;
                UMWorkDispatch.sendEvent(context2, 4352, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = f13645a;
                UMWorkDispatch.sendEvent(context3, q.a.f14394g, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.f13657b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    public void j() {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onProfileSignOff can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", currentTimeMillis);
                Context context2 = f13645a;
                UMWorkDispatch.sendEvent(context2, q.a.f14393f, CoreProtocol.getInstance(context2), jSONObject);
                Context context3 = f13645a;
                UMWorkDispatch.sendEvent(context3, q.a.f14402o, CoreProtocol.getInstance(context3), jSONObject);
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
                } else if (this.f13664k != null) {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f13645a).edit();
                    edit.putString(f13646h, this.f13664k.toString());
                    edit.commit();
                } else {
                    this.f13664k = new JSONObject();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONObject l() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = f13645a     // Catch:{ all -> 0x0020 }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r2)
            return r1
        L_0x0008:
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0)     // Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = "getSuperPropertiesJSONObject can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r0)     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)
            return r1
        L_0x0015:
            org.json.JSONObject r0 = r2.f13664k     // Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x0020
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0020 }
            r0.<init>()     // Catch:{ all -> 0x0020 }
            r2.f13664k = r0     // Catch:{ all -> 0x0020 }
        L_0x0020:
            org.json.JSONObject r0 = r2.f13664k     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return r0
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.l():org.json.JSONObject");
    }

    public synchronized void m() {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                    return;
                }
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f13645a).edit();
                edit.remove(f13646h);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else if (!UMWorkDispatch.eventHasExist(q.a.B)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f13645a;
                UMWorkDispatch.sendEvent(context, q.a.B, CoreProtocol.getInstance(context), (Object) null);
            }
        }
    }

    private b() {
        this.f13658c = new r();
        this.f13659d = new x();
        this.f13660e = new m();
        this.f13661f = w.a();
        this.f13662g = null;
        this.f13663j = false;
        this.f13664k = null;
        this.f13665l = null;
        this.f13666m = null;
        this.f13667n = false;
        this.f13668u = null;
        this.f13669x = null;
        this.f13670y = null;
        this.f13658c.a((v) this);
    }

    private boolean e(String str) {
        if (this.f13668u.enabled() && this.f13668u.matchHit(str)) {
            return true;
        }
        if (!this.f13669x.enabled()) {
            return false;
        }
        if (!this.f13669x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:19|20|(5:22|(1:24)|25|26|27)|28|29) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072 A[Catch:{ all -> 0x0088 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.Context r0 = f13645a     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x000d
            android.content.Context r0 = r4.getApplicationContext()     // Catch:{ all -> 0x0088 }
            f13645a = r0     // Catch:{ all -> 0x0088 }
        L_0x000d:
            com.umeng.analytics.filter.a r0 = r3.f13668u     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0021
            com.umeng.analytics.filter.a r0 = new com.umeng.analytics.filter.a     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = f13652s     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "ekv_bl_ver"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0088 }
            r3.f13668u = r0     // Catch:{ all -> 0x0088 }
            android.content.Context r1 = f13645a     // Catch:{ all -> 0x0088 }
            r0.register(r1)     // Catch:{ all -> 0x0088 }
        L_0x0021:
            com.umeng.analytics.filter.b r0 = r3.f13669x     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x0035
            com.umeng.analytics.filter.b r0 = new com.umeng.analytics.filter.b     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = f13654v     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "ekv_wl_ver"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0088 }
            r3.f13669x = r0     // Catch:{ all -> 0x0088 }
            android.content.Context r1 = f13645a     // Catch:{ all -> 0x0088 }
            r0.register(r1)     // Catch:{ all -> 0x0088 }
        L_0x0035:
            android.content.Context r0 = f13645a     // Catch:{ all -> 0x0088 }
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0)     // Catch:{ all -> 0x0088 }
            if (r0 != 0) goto L_0x003e
            return
        L_0x003e:
            boolean r0 = r3.f13663j     // Catch:{ all -> 0x0088 }
            r1 = 1
            if (r0 != 0) goto L_0x004a
            r3.f13663j = r1     // Catch:{ all -> 0x0088 }
            android.content.Context r0 = f13645a     // Catch:{ all -> 0x0088 }
            r3.i(r0)     // Catch:{ all -> 0x0088 }
        L_0x004a:
            monitor-enter(r3)     // Catch:{ all -> 0x0088 }
            boolean r0 = r3.f13667n     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x006b
            com.umeng.analytics.pro.n r0 = com.umeng.analytics.pro.n.a((android.content.Context) r4)     // Catch:{ all -> 0x0085 }
            r3.f13662g = r0     // Catch:{ all -> 0x0085 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x005d
            r3.f13667n = r1     // Catch:{ all -> 0x0085 }
        L_0x005d:
            com.umeng.analytics.pro.o r0 = com.umeng.analytics.pro.o.a()     // Catch:{ all -> 0x0085 }
            r3.f13670y = r0     // Catch:{ all -> 0x0085 }
            com.umeng.analytics.pro.o.a((android.content.Context) r4)     // Catch:{ all -> 0x006b }
            com.umeng.analytics.pro.o r4 = r3.f13670y     // Catch:{ all -> 0x006b }
            r4.a((com.umeng.analytics.pro.p) r3)     // Catch:{ all -> 0x006b }
        L_0x006b:
            monitor-exit(r3)     // Catch:{ all -> 0x0085 }
            boolean r4 = com.umeng.commonsdk.UMConfigure.isDebugLog()     // Catch:{ all -> 0x0088 }
            if (r4 == 0) goto L_0x007b
            java.lang.String r4 = "统计SDK常见问题索引贴 详见链接 http://developer.umeng.com/docs/66650/cate/66650"
            java.lang.String r0 = ""
            r1 = 0
            r2 = 3
            com.umeng.commonsdk.debug.UMLog.mutlInfo(r4, r2, r0, r1, r1)     // Catch:{ all -> 0x0088 }
        L_0x007b:
            android.content.Context r4 = f13645a     // Catch:{ all -> 0x0088 }
            com.umeng.analytics.CoreProtocol r4 = com.umeng.analytics.CoreProtocol.getInstance(r4)     // Catch:{ all -> 0x0088 }
            com.umeng.commonsdk.framework.UMWorkDispatch.registerConnStateObserver(r4)     // Catch:{ all -> 0x0088 }
            goto L_0x0088
        L_0x0085:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0085 }
            throw r4     // Catch:{ all -> 0x0088 }
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.a(android.content.Context):void");
    }

    public void b(String str) {
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f13659d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context) {
        if (context == null) {
            UMLog.aq(l.f14324p, 0, "\\|");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("onPause can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.aq(l.f14325q, 2, "\\|");
            }
            try {
                if (!this.f13663j || !this.f13667n) {
                    a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f13660e.b(context.getClass().getName());
                }
                i();
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e("Exception occurred in Mobclick.onRause(). ", th);
                }
            }
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f13651r = context.getClass().getName();
            }
        }
    }

    public void d(Context context) {
        if (context != null) {
            try {
                if (f13645a == null) {
                    f13645a = context.getApplicationContext();
                }
                if (!UMUtils.isMainProgress(f13645a)) {
                    MLog.e("onKillProcess can not be called in child process");
                    return;
                }
                n nVar = this.f13662g;
                if (nVar != null) {
                    nVar.c();
                }
                n.a(context, "onKillProcess");
                m mVar = this.f13660e;
                if (mVar != null) {
                    mVar.b();
                }
                x xVar = this.f13659d;
                if (xVar != null) {
                    xVar.b();
                }
                Context context2 = f13645a;
                if (context2 != null) {
                    w wVar = this.f13661f;
                    if (wVar != null) {
                        wVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                    }
                    q.a(f13645a).d();
                    x.a(f13645a);
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                        n.c(f13645a);
                    }
                    PreferenceWrapper.getDefault(f13645a).edit().commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(l.ah, 0, "\\|");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f13663j || !this.f13667n) {
            a(f13645a);
        }
        this.f13664k = new JSONObject();
        Context context2 = f13645a;
        UMWorkDispatch.sendEvent(context2, q.a.f14408u, CoreProtocol.getInstance(context2), (Object) null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(l.ap, 0, "\\|");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f13663j || !this.f13667n) {
            a(f13645a);
        }
        if (this.f13666m.length() > 0) {
            Context context2 = f13645a;
            UMWorkDispatch.sendEvent(context2, q.a.f14412y, CoreProtocol.getInstance(context2), (Object) null);
        }
        this.f13666m = new JSONObject();
    }

    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("onResume can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.aq(l.f14323o, 2, "\\|");
            }
            try {
                if (!this.f13663j || !this.f13667n) {
                    a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f13660e.a(context.getClass().getName());
                }
                h();
                if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                    f13650q = context.getClass().getName();
                }
            } catch (Throwable th) {
                MLog.e("Exception occurred in Mobclick.onResume(). ", th);
            }
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            try {
                UMLog.aq(l.ai, 0, "\\|");
                return null;
            } catch (Throwable unused) {
            }
        } else {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("getSuperProperty can not be called in child process");
                return null;
            } else if (TextUtils.isEmpty(str)) {
                UMLog.aq(l.ag, 0, "\\|");
                return null;
            } else if (!str.equals(f13656z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("please check key or value, must be correct!");
                return null;
            } else if (this.f13664k == null) {
                this.f13664k = new JSONObject();
            } else if (this.f13664k.has(str)) {
                return this.f13664k.opt(str);
            }
        }
        return null;
    }

    public synchronized JSONObject h(Context context) {
        JSONObject jSONObject;
        if (context == null) {
            UMLog.aq(l.aq, 0, "\\|");
            return null;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f13663j || !this.f13667n) {
            a(f13645a);
        }
        if (this.f13666m == null) {
            this.f13666m = new JSONObject();
        }
        jSONObject = new JSONObject();
        if (this.f13666m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f13666m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f13645a;
                UMWorkDispatch.sendEvent(context2, q.a.f14395h, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f13645a;
                UMWorkDispatch.sendEvent(context3, q.a.f14391d, CoreProtocol.getInstance(context3), (Object) null);
                Context context4 = f13645a;
                UMWorkDispatch.sendEvent(context4, q.a.f14390c, CoreProtocol.getInstance(context4), (Object) null);
                Context context5 = f13645a;
                UMWorkDispatch.sendEvent(context5, q.a.f14396i, CoreProtocol.getInstance(context5), (Object) null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f13657b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void f(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            if (r3 != 0) goto L_0x000d
            java.lang.String r3 = com.umeng.analytics.pro.l.an     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r3, (int) r0, (java.lang.String) r4)     // Catch:{ all -> 0x007c }
            monitor-exit(r2)
            return
        L_0x000d:
            android.content.Context r1 = f13645a     // Catch:{ all -> 0x007c }
            if (r1 != 0) goto L_0x0017
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x007c }
            f13645a = r3     // Catch:{ all -> 0x007c }
        L_0x0017:
            android.content.Context r3 = f13645a     // Catch:{ all -> 0x007c }
            boolean r3 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r3)     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "unregisterPreProperty can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r3)     // Catch:{ all -> 0x007c }
            monitor-exit(r2)
            return
        L_0x0026:
            boolean r3 = r2.f13663j     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x002e
            boolean r3 = r2.f13667n     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x0033
        L_0x002e:
            android.content.Context r3 = f13645a     // Catch:{ all -> 0x007c }
            r2.a((android.content.Context) r3)     // Catch:{ all -> 0x007c }
        L_0x0033:
            org.json.JSONObject r3 = r2.f13666m     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x003e
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x007c }
            r3.<init>()     // Catch:{ all -> 0x007c }
            r2.f13666m = r3     // Catch:{ all -> 0x007c }
        L_0x003e:
            if (r4 == 0) goto L_0x0075
            int r3 = r4.length()     // Catch:{ all -> 0x007c }
            if (r3 > 0) goto L_0x0047
            goto L_0x0075
        L_0x0047:
            org.json.JSONObject r3 = r2.f13666m     // Catch:{ all -> 0x007c }
            boolean r3 = r3.has(r4)     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0066
            org.json.JSONObject r3 = r2.f13666m     // Catch:{ all -> 0x007c }
            r3.remove(r4)     // Catch:{ all -> 0x007c }
            android.content.Context r3 = f13645a     // Catch:{ all -> 0x007c }
            com.umeng.analytics.CoreProtocol r4 = com.umeng.analytics.CoreProtocol.getInstance(r3)     // Catch:{ all -> 0x007c }
            org.json.JSONObject r0 = r2.f13666m     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007c }
            r1 = 8200(0x2008, float:1.149E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r3, r1, r4, r0)     // Catch:{ all -> 0x007c }
            goto L_0x0073
        L_0x0066:
            boolean r3 = com.umeng.commonsdk.UMConfigure.isDebugLog()     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = com.umeng.analytics.pro.l.ao     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r3, (int) r0, (java.lang.String) r4)     // Catch:{ all -> 0x007c }
        L_0x0073:
            monitor-exit(r2)
            return
        L_0x0075:
            java.lang.String r3 = "please check propertics, property is null!"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r3)     // Catch:{ all -> 0x007c }
            monitor-exit(r2)
            return
        L_0x007c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.f(android.content.Context, java.lang.String):void");
    }

    private boolean g(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f14334z, 0, "\\|");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f13663j || !this.f13667n) {
            a(f13645a);
        }
        AnalyticsConfig.a(f13645a, str);
    }

    public synchronized void d(Context context, String str) {
        if (context == null) {
            try {
                UMLog.aq(l.ah, 0, "\\|");
                return;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("unregisterSuperProperty can not be called in child process");
                return;
            }
            if (!this.f13663j || !this.f13667n) {
                a(f13645a);
            }
            if (TextUtils.isEmpty(str)) {
                UMLog.aq(l.ag, 0, "\\|");
                return;
            } else if (str.equals(f13656z) || str.equals(A) || str.equals(B) || str.equals(C) || str.equals(D)) {
                if (this.f13664k == null) {
                    this.f13664k = new JSONObject();
                }
                if (this.f13664k.has(str)) {
                    this.f13664k.remove(str);
                    Context context2 = f13645a;
                    UMWorkDispatch.sendEvent(context2, q.a.f14409v, CoreProtocol.getInstance(context2), str);
                }
            } else {
                MLog.e("please check key or value, must be correct!");
                return;
            }
        }
        return;
    }

    public void b(Context context, String str) {
        if (context == null) {
            try {
                UMLog.aq(l.N, 0, "\\|");
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        } else {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f13663j || !this.f13667n) {
                a(f13645a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(f.aK, str);
                a(f13645a, f.aJ, (Map<String, Object>) hashMap, -1, false);
                return;
            }
            UMLog.aq(l.O, 0, "\\|");
        }
    }

    public void a(String str) {
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f13659d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str, Object obj) {
        int i10;
        try {
            if (TextUtils.isEmpty(str)) {
                MLog.e("key is " + str + ", please check key, illegal");
                return false;
            }
            try {
                i10 = str.getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException unused) {
                i10 = 0;
            }
            if (i10 > 128) {
                MLog.e("key length is " + i10 + ", please check key, illegal");
                return false;
            } else if (obj instanceof String) {
                if (((String) obj).getBytes("UTF-8").length <= 256) {
                    return true;
                }
                MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
                return false;
            } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
                return true;
            } else {
                MLog.e("value is " + obj + ", please check value, type illegal");
                return false;
            }
        } catch (Throwable unused2) {
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            try {
                UMLog.aq(l.ai, 0, "\\|");
                return null;
            } catch (Throwable unused) {
            }
        } else {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("getSuperProperties can not be called in child process");
                return null;
            } else if (this.f13664k != null) {
                return this.f13664k.toString();
            } else {
                this.f13664k = new JSONObject();
            }
        }
        return null;
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f13657b = iSysListener;
        }
    }

    public void a(Context context, int i10) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f13663j || !this.f13667n) {
            a(f13645a);
        }
        AnalyticsConfig.a(f13645a, i10);
    }

    private void b(String str, Object obj) {
        try {
            if (this.f13664k == null) {
                this.f13664k = new JSONObject();
            }
            int i10 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length <= 10) {
                        JSONArray jSONArray = new JSONArray();
                        while (i10 < strArr.length) {
                            String str2 = strArr[i10];
                            if (str2 != null && !HelperUtils.checkStrLen(str2, 256)) {
                                jSONArray.put(strArr[i10]);
                            }
                            i10++;
                        }
                        this.f13664k.put(str, jSONArray);
                    }
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i10 < jArr.length) {
                        jSONArray2.put(jArr[i10]);
                        i10++;
                    }
                    this.f13664k.put(str, jSONArray2);
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i10 < iArr.length) {
                        jSONArray3.put(iArr[i10]);
                        i10++;
                    }
                    this.f13664k.put(str, jSONArray3);
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i10 < fArr.length) {
                        jSONArray4.put((double) fArr[i10]);
                        i10++;
                    }
                    this.f13664k.put(str, jSONArray4);
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i10 < dArr.length) {
                        jSONArray5.put(dArr[i10]);
                        i10++;
                    }
                    this.f13664k.put(str, jSONArray5);
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i10 < sArr.length) {
                        jSONArray6.put(sArr[i10]);
                        i10++;
                    }
                    this.f13664k.put(str, jSONArray6);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i10 < list.size()) {
                    Object obj2 = list.get(i10);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i10));
                    }
                    i10++;
                }
                this.f13664k.put(str, jSONArray7);
            } else if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f13664k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean f(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    public void c(String str) {
        if (g(str)) {
            a(f.O, (Object) str);
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context != null) {
            try {
                if (f13645a == null) {
                    f13645a = context.getApplicationContext();
                }
                if (!UMUtils.isMainProgress(f13645a)) {
                    MLog.e("onGKVEvent can not be called in child process");
                    return;
                }
                if (!this.f13663j || !this.f13667n) {
                    a(f13645a);
                }
                String str2 = "";
                if (this.f13664k == null) {
                    this.f13664k = new JSONObject();
                } else {
                    str2 = this.f13664k.toString();
                }
                u.a(f13645a).a(str, hashMap, str2);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        }
    }

    public void d(String str) {
        if (g(str)) {
            a(f.P, (Object) str);
        }
    }

    public void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f14331w, 0, "\\|");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("reportError can not be called in child process");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                if (!this.f13663j || !this.f13667n) {
                    a(f13645a);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(f.W, 2);
                jSONObject.put(f.X, str);
                jSONObject.put("__ii", this.f13661f.c());
                Context context2 = f13645a;
                UMWorkDispatch.sendEvent(context2, q.a.f14397j, CoreProtocol.getInstance(context2), jSONObject);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        } else if (UMConfigure.isDebugLog()) {
            UMLog.aq(l.f14332x, 0, "\\|");
        }
    }

    public void a(Context context, Throwable th) {
        if (context == null || th == null) {
            UMLog.aq(l.f14333y, 0, "\\|");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        try {
            if (!this.f13663j || !this.f13667n) {
                a(f13645a);
            }
            a(f13645a, DataHelper.convertExceptionToString(th));
        } catch (Exception e10) {
            if (MLog.DEBUG) {
                MLog.e((Throwable) e10);
            }
        }
    }

    public void a(Context context, String str, String str2, long j10, int i10) {
        if (context != null) {
            try {
                if (f13645a == null) {
                    f13645a = context.getApplicationContext();
                }
                if (!this.f13663j || !this.f13667n) {
                    a(f13645a);
                }
                if (e(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                    return;
                }
                String str3 = "";
                if (this.f13664k == null) {
                    this.f13664k = new JSONObject();
                } else {
                    str3 = this.f13664k.toString();
                }
                u.a(f13645a).a(str, str2, j10, i10, str3);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        }
    }

    public synchronized void b(Object obj) {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
                    return;
                }
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f13645a).edit();
                if (obj != null) {
                    String str = (String) obj;
                    if (edit != null && !TextUtils.isEmpty(str)) {
                        edit.putString(f13647i, str).commit();
                    }
                } else if (edit != null) {
                    edit.remove(f13647i).commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, String str, Map<String, Object> map, long j10) {
        try {
            if (TextUtils.isEmpty(str)) {
                UMLog.aq(l.f14311c, 0, "\\|");
            } else if (Arrays.asList(f.aL).contains(str)) {
                UMLog.aq(l.f14310b, 0, "\\|");
            } else if (map.isEmpty()) {
                UMLog.aq(l.f14312d, 0, "\\|");
            } else {
                for (Map.Entry<String, Object> key : map.entrySet()) {
                    if (Arrays.asList(f.aL).contains(key.getKey())) {
                        UMLog.aq(l.f14313e, 0, "\\|");
                        return;
                    }
                }
                a(context, str, map, j10, false);
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j10, boolean z10) {
        if (context == null) {
            try {
                MLog.e("context is null in onEventNoCheck, please check!");
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        } else {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!this.f13663j || !this.f13667n) {
                a(f13645a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f13664k == null) {
                this.f13664k = new JSONObject();
            } else {
                str2 = this.f13664k.toString();
            }
            u.a(f13645a).a(str, map, j10, str2, z10);
        }
    }

    public void a(Throwable th) {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onAppCrash can not be called in child process");
                } else if (AnalyticsConfig.enable) {
                    x xVar = this.f13659d;
                    if (xVar != null) {
                        xVar.b();
                    }
                    n.a(f13645a, "onAppCrash");
                    m mVar = this.f13660e;
                    if (mVar != null) {
                        mVar.b();
                    }
                    n nVar = this.f13662g;
                    if (nVar != null) {
                        nVar.c();
                    }
                    w wVar = this.f13661f;
                    if (wVar != null) {
                        wVar.c(f13645a, Long.valueOf(System.currentTimeMillis()));
                    }
                    if (th != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONObject.put(f.W, 1);
                        jSONObject.put(f.X, DataHelper.convertExceptionToString(th));
                        k.a(f13645a).a(this.f13661f.c(), jSONObject.toString(), 1);
                    }
                    q.a(f13645a).d();
                    x.a(f13645a);
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                        n.c(f13645a);
                    }
                    PreferenceWrapper.getDefault(f13645a).edit().commit();
                }
            }
        } catch (Exception e10) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", (Throwable) e10);
            }
        }
    }

    public void a(String str, String str2) {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onProfileSignIn can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f.M, str);
                jSONObject.put(ParamsMap.DeviceParams.KEY_UID, str2);
                jSONObject.put("ts", currentTimeMillis);
                Context context2 = f13645a;
                UMWorkDispatch.sendEvent(context2, q.a.f14392e, CoreProtocol.getInstance(context2), jSONObject);
                Context context3 = f13645a;
                UMWorkDispatch.sendEvent(context3, q.a.f14402o, CoreProtocol.getInstance(context3), jSONObject);
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    public void a(boolean z10) {
        Context context = f13645a;
        if (context != null) {
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("setCatchUncaughtExceptions can not be called in child process");
            } else if (!AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                AnalyticsConfig.CATCH_EXCEPTION = z10;
            }
        }
    }

    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    public void a(double d10, double d11) {
        Context context = f13645a;
        if (context != null) {
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("setLocation can not be called in child process");
                return;
            }
            if (AnalyticsConfig.f13623a == null) {
                AnalyticsConfig.f13623a = new double[2];
            }
            double[] dArr = AnalyticsConfig.f13623a;
            dArr[0] = d10;
            dArr[1] = d11;
        }
    }

    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f13645a == null) {
            f13645a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f13645a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f13645a, eScenarioType.toValue());
        }
        if (!this.f13663j || !this.f13667n) {
            a(f13645a);
        }
    }

    public void a(long j10) {
        Context context = f13645a;
        if (context != null) {
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("setSessionContinueMillis can not be called in child process");
                return;
            }
            AnalyticsConfig.kContinueSessionMillis = j10;
            aa.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:169:0x029d, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:162:0x0281 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.content.Context r4, java.lang.String r5, java.lang.Object r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            if (r4 != 0) goto L_0x000d
            java.lang.String r4 = com.umeng.analytics.pro.l.af     // Catch:{ all -> 0x029c }
            java.lang.String r5 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r4, (int) r0, (java.lang.String) r5)     // Catch:{ all -> 0x029c }
            monitor-exit(r3)
            return
        L_0x000d:
            android.content.Context r1 = f13645a     // Catch:{ all -> 0x029c }
            if (r1 != 0) goto L_0x0017
            android.content.Context r4 = r4.getApplicationContext()     // Catch:{ all -> 0x029c }
            f13645a = r4     // Catch:{ all -> 0x029c }
        L_0x0017:
            android.content.Context r4 = f13645a     // Catch:{ all -> 0x029c }
            boolean r4 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r4)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0026
            java.lang.String r4 = "registerSuperProperty can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x029c }
            monitor-exit(r3)
            return
        L_0x0026:
            boolean r4 = r3.f13663j     // Catch:{ all -> 0x029c }
            if (r4 == 0) goto L_0x002e
            boolean r4 = r3.f13667n     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0033
        L_0x002e:
            android.content.Context r4 = f13645a     // Catch:{ all -> 0x029c }
            r3.a((android.content.Context) r4)     // Catch:{ all -> 0x029c }
        L_0x0033:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0293
            if (r6 != 0) goto L_0x003d
            goto L_0x0293
        L_0x003d:
            java.lang.String r4 = "umsp_1"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0080
            java.lang.String r4 = "umsp_2"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0080
            java.lang.String r4 = "umsp_3"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0080
            java.lang.String r4 = "umsp_4"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0080
            java.lang.String r4 = "umsp_5"
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x0080
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x029c }
            r4.<init>()     // Catch:{ all -> 0x029c }
            java.lang.String r6 = "property name is "
            r4.append(r6)     // Catch:{ all -> 0x029c }
            r4.append(r5)     // Catch:{ all -> 0x029c }
            java.lang.String r5 = ", please check key, must be correct!"
            r4.append(r5)     // Catch:{ all -> 0x029c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x029c }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x029c }
            monitor-exit(r3)
            return
        L_0x0080:
            boolean r4 = r6 instanceof java.lang.String     // Catch:{ all -> 0x029c }
            r1 = 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x00ab
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x029c }
            boolean r4 = com.umeng.commonsdk.statistics.common.HelperUtils.checkStrLen(r4, r1)     // Catch:{ all -> 0x029c }
            if (r4 != 0) goto L_0x00ab
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x029c }
            r4.<init>()     // Catch:{ all -> 0x029c }
            java.lang.String r5 = "property value is "
            r4.append(r5)     // Catch:{ all -> 0x029c }
            r4.append(r6)     // Catch:{ all -> 0x029c }
            java.lang.String r5 = ", please check value, lawless!"
            r4.append(r5)     // Catch:{ all -> 0x029c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x029c }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x029c }
            monitor-exit(r3)
            return
        L_0x00ab:
            org.json.JSONObject r4 = r3.f13664k     // Catch:{ all -> 0x0281 }
            if (r4 != 0) goto L_0x00b6
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            r3.f13664k = r4     // Catch:{ all -> 0x0281 }
        L_0x00b6:
            java.lang.Class r4 = r6.getClass()     // Catch:{ all -> 0x0281 }
            boolean r4 = r4.isArray()     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x025c
            boolean r4 = r6 instanceof java.lang.String[]     // Catch:{ all -> 0x0281 }
            r2 = 10
            if (r4 == 0) goto L_0x012a
            java.lang.String[] r6 = (java.lang.String[]) r6     // Catch:{ all -> 0x0281 }
            int r4 = r6.length     // Catch:{ all -> 0x0281 }
            if (r4 <= r2) goto L_0x00e7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, size is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            int r5 = r6.length     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overstep 10!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x00e7:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
        L_0x00ec:
            int r2 = r6.length     // Catch:{ all -> 0x0281 }
            if (r0 >= r2) goto L_0x0123
            r2 = r6[r0]     // Catch:{ all -> 0x0281 }
            if (r2 == 0) goto L_0x0102
            boolean r2 = com.umeng.commonsdk.statistics.common.HelperUtils.checkStrLen(r2, r1)     // Catch:{ all -> 0x0281 }
            if (r2 != 0) goto L_0x00fa
            goto L_0x0102
        L_0x00fa:
            r2 = r6[r0]     // Catch:{ all -> 0x0281 }
            r4.put(r2)     // Catch:{ all -> 0x0281 }
            int r0 = r0 + 1
            goto L_0x00ec
        L_0x0102:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, length is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            r5 = r6[r0]     // Catch:{ all -> 0x0281 }
            int r5 = r5.length()     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overlength 256!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x0123:
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r6.put(r5, r4)     // Catch:{ all -> 0x0281 }
            goto L_0x0281
        L_0x012a:
            boolean r4 = r6 instanceof long[]     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x0166
            long[] r6 = (long[]) r6     // Catch:{ all -> 0x0281 }
            int r4 = r6.length     // Catch:{ all -> 0x0281 }
            if (r4 <= r2) goto L_0x014f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, size is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            int r5 = r6.length     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overstep 10!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x014f:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
        L_0x0154:
            int r1 = r6.length     // Catch:{ all -> 0x0281 }
            if (r0 >= r1) goto L_0x015f
            r1 = r6[r0]     // Catch:{ all -> 0x0281 }
            r4.put(r1)     // Catch:{ all -> 0x0281 }
            int r0 = r0 + 1
            goto L_0x0154
        L_0x015f:
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r6.put(r5, r4)     // Catch:{ all -> 0x0281 }
            goto L_0x0281
        L_0x0166:
            boolean r4 = r6 instanceof int[]     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x01a2
            int[] r6 = (int[]) r6     // Catch:{ all -> 0x0281 }
            int r4 = r6.length     // Catch:{ all -> 0x0281 }
            if (r4 <= r2) goto L_0x018b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, size is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            int r5 = r6.length     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overstep 10!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x018b:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
        L_0x0190:
            int r1 = r6.length     // Catch:{ all -> 0x0281 }
            if (r0 >= r1) goto L_0x019b
            r1 = r6[r0]     // Catch:{ all -> 0x0281 }
            r4.put(r1)     // Catch:{ all -> 0x0281 }
            int r0 = r0 + 1
            goto L_0x0190
        L_0x019b:
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r6.put(r5, r4)     // Catch:{ all -> 0x0281 }
            goto L_0x0281
        L_0x01a2:
            boolean r4 = r6 instanceof float[]     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x01df
            float[] r6 = (float[]) r6     // Catch:{ all -> 0x0281 }
            int r4 = r6.length     // Catch:{ all -> 0x0281 }
            if (r4 <= r2) goto L_0x01c7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, size is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            int r5 = r6.length     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overstep 10!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x01c7:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
        L_0x01cc:
            int r1 = r6.length     // Catch:{ all -> 0x0281 }
            if (r0 >= r1) goto L_0x01d8
            r1 = r6[r0]     // Catch:{ all -> 0x0281 }
            double r1 = (double) r1     // Catch:{ all -> 0x0281 }
            r4.put(r1)     // Catch:{ all -> 0x0281 }
            int r0 = r0 + 1
            goto L_0x01cc
        L_0x01d8:
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r6.put(r5, r4)     // Catch:{ all -> 0x0281 }
            goto L_0x0281
        L_0x01df:
            boolean r4 = r6 instanceof double[]     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x021a
            double[] r6 = (double[]) r6     // Catch:{ all -> 0x0281 }
            int r4 = r6.length     // Catch:{ all -> 0x0281 }
            if (r4 <= r2) goto L_0x0204
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, size is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            int r5 = r6.length     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overstep 10!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x0204:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
        L_0x0209:
            int r1 = r6.length     // Catch:{ all -> 0x0281 }
            if (r0 >= r1) goto L_0x0214
            r1 = r6[r0]     // Catch:{ all -> 0x0281 }
            r4.put(r1)     // Catch:{ all -> 0x0281 }
            int r0 = r0 + 1
            goto L_0x0209
        L_0x0214:
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r6.put(r5, r4)     // Catch:{ all -> 0x0281 }
            goto L_0x0281
        L_0x021a:
            boolean r4 = r6 instanceof short[]     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x0255
            short[] r6 = (short[]) r6     // Catch:{ all -> 0x0281 }
            int r4 = r6.length     // Catch:{ all -> 0x0281 }
            if (r4 <= r2) goto L_0x023f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = "please check value, size is "
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            int r5 = r6.length     // Catch:{ all -> 0x0281 }
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r5 = ", overstep 10!"
            r4.append(r5)     // Catch:{ all -> 0x0281 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0281 }
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x023f:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x0281 }
            r4.<init>()     // Catch:{ all -> 0x0281 }
        L_0x0244:
            int r1 = r6.length     // Catch:{ all -> 0x0281 }
            if (r0 >= r1) goto L_0x024f
            short r1 = r6[r0]     // Catch:{ all -> 0x0281 }
            r4.put(r1)     // Catch:{ all -> 0x0281 }
            int r0 = r0 + 1
            goto L_0x0244
        L_0x024f:
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r6.put(r5, r4)     // Catch:{ all -> 0x0281 }
            goto L_0x0281
        L_0x0255:
            java.lang.String r4 = "please check value, illegal type!"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x025c:
            boolean r4 = r6 instanceof java.lang.String     // Catch:{ all -> 0x0281 }
            if (r4 != 0) goto L_0x027c
            boolean r4 = r6 instanceof java.lang.Long     // Catch:{ all -> 0x0281 }
            if (r4 != 0) goto L_0x027c
            boolean r4 = r6 instanceof java.lang.Integer     // Catch:{ all -> 0x0281 }
            if (r4 != 0) goto L_0x027c
            boolean r4 = r6 instanceof java.lang.Float     // Catch:{ all -> 0x0281 }
            if (r4 != 0) goto L_0x027c
            boolean r4 = r6 instanceof java.lang.Double     // Catch:{ all -> 0x0281 }
            if (r4 != 0) goto L_0x027c
            boolean r4 = r6 instanceof java.lang.Short     // Catch:{ all -> 0x0281 }
            if (r4 == 0) goto L_0x0275
            goto L_0x027c
        L_0x0275:
            java.lang.String r4 = "please check value, illegal type!"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r4)     // Catch:{ all -> 0x0281 }
            monitor-exit(r3)
            return
        L_0x027c:
            org.json.JSONObject r4 = r3.f13664k     // Catch:{ all -> 0x0281 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0281 }
        L_0x0281:
            android.content.Context r4 = f13645a     // Catch:{ all -> 0x029c }
            com.umeng.analytics.CoreProtocol r5 = com.umeng.analytics.CoreProtocol.getInstance(r4)     // Catch:{ all -> 0x029c }
            org.json.JSONObject r6 = r3.f13664k     // Catch:{ all -> 0x029c }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x029c }
            r0 = 8195(0x2003, float:1.1484E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r4, r0, r5, r6)     // Catch:{ all -> 0x029c }
            goto L_0x029c
        L_0x0293:
            java.lang.String r4 = com.umeng.analytics.pro.l.ag     // Catch:{ all -> 0x029c }
            java.lang.String r5 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r4, (int) r0, (java.lang.String) r5)     // Catch:{ all -> 0x029c }
            monitor-exit(r3)
            return
        L_0x029c:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.a(android.content.Context, java.lang.String, java.lang.Object):void");
    }

    public synchronized void a(Object obj) {
        try {
            Context context = f13645a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
                } else if (obj != null) {
                    String str = (String) obj;
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f13645a).edit();
                    if (edit != null && !TextUtils.isEmpty(str)) {
                        edit.putString(f13646h, this.f13664k.toString()).commit();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Context context, List<String> list) {
        if (context == null) {
            try {
                UMLog.aq(l.aj, 0, "\\|");
                return;
            } catch (Throwable th) {
                MLog.e(th);
            }
        } else {
            if (f13645a == null) {
                f13645a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f13645a)) {
                MLog.e("setFirstLaunchEvent can not be called in child process");
                return;
            }
            if (!this.f13663j || !this.f13667n) {
                a(f13645a);
            }
            u.a(f13645a).a(list);
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a9, code lost:
        return;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x00aa=Splitter:B:57:0x00aa, B:51:0x008d=Splitter:B:51:0x008d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(android.content.Context r5, org.json.JSONObject r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L_0x000d
            java.lang.String r5 = com.umeng.analytics.pro.l.al     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r5, (int) r0, (java.lang.String) r6)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r4)
            return
        L_0x000d:
            android.content.Context r1 = f13645a     // Catch:{ all -> 0x00b3 }
            if (r1 != 0) goto L_0x0017
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x00b3 }
            f13645a = r5     // Catch:{ all -> 0x00b3 }
        L_0x0017:
            android.content.Context r5 = f13645a     // Catch:{ all -> 0x00b3 }
            boolean r5 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r5)     // Catch:{ all -> 0x00b3 }
            if (r5 != 0) goto L_0x0026
            java.lang.String r5 = "registerPreProperties can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r5)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r4)
            return
        L_0x0026:
            boolean r5 = r4.f13663j     // Catch:{ all -> 0x00b3 }
            if (r5 == 0) goto L_0x002e
            boolean r5 = r4.f13667n     // Catch:{ all -> 0x00b3 }
            if (r5 != 0) goto L_0x0033
        L_0x002e:
            android.content.Context r5 = f13645a     // Catch:{ all -> 0x00b3 }
            r4.a((android.content.Context) r5)     // Catch:{ all -> 0x00b3 }
        L_0x0033:
            org.json.JSONObject r5 = r4.f13666m     // Catch:{ all -> 0x00b3 }
            if (r5 != 0) goto L_0x003e
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00b3 }
            r5.<init>()     // Catch:{ all -> 0x00b3 }
            r4.f13666m = r5     // Catch:{ all -> 0x00b3 }
        L_0x003e:
            if (r6 == 0) goto L_0x00aa
            int r5 = r6.length()     // Catch:{ all -> 0x00b3 }
            if (r5 > 0) goto L_0x0047
            goto L_0x00aa
        L_0x0047:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0053 }
            org.json.JSONObject r0 = r4.f13666m     // Catch:{ Exception -> 0x0053 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0053 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            if (r5 != 0) goto L_0x005b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x00b3 }
            r5.<init>()     // Catch:{ all -> 0x00b3 }
        L_0x005b:
            java.util.Iterator r0 = r6.keys()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x008d
        L_0x0061:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00b3 }
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0061 }
            java.lang.Object r2 = r6.get(r1)     // Catch:{ Exception -> 0x0061 }
            boolean r3 = r4.c((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0061 }
            if (r3 != 0) goto L_0x007b
            monitor-exit(r4)
            return
        L_0x007b:
            r5.put(r1, r2)     // Catch:{ Exception -> 0x0061 }
            int r1 = r5.length()     // Catch:{ Exception -> 0x0061 }
            r2 = 10
            if (r1 <= r2) goto L_0x0061
            java.lang.String r1 = "please check propertics, size overlength!"
            com.umeng.commonsdk.statistics.common.MLog.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0061 }
            monitor-exit(r4)
            return
        L_0x008d:
            r4.f13666m = r5     // Catch:{ all -> 0x00b3 }
            org.json.JSONObject r5 = r4.f13666m     // Catch:{ all -> 0x00b3 }
            int r5 = r5.length()     // Catch:{ all -> 0x00b3 }
            if (r5 <= 0) goto L_0x00a8
            android.content.Context r5 = f13645a     // Catch:{ all -> 0x00b3 }
            com.umeng.analytics.CoreProtocol r6 = com.umeng.analytics.CoreProtocol.getInstance(r5)     // Catch:{ all -> 0x00b3 }
            org.json.JSONObject r0 = r4.f13666m     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b3 }
            r1 = 8199(0x2007, float:1.1489E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r5, r1, r6, r0)     // Catch:{ all -> 0x00b3 }
        L_0x00a8:
            monitor-exit(r4)
            return
        L_0x00aa:
            java.lang.String r5 = com.umeng.analytics.pro.l.am     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq((java.lang.String) r5, (int) r0, (java.lang.String) r6)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r4)
            return
        L_0x00b3:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x00b7
        L_0x00b6:
            throw r5
        L_0x00b7:
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.a(android.content.Context, org.json.JSONObject):void");
    }

    public void a(String str, Object obj) {
        if (f(str)) {
            if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Float) || (obj instanceof Double)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(f.S, str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (str2.length() > 0) {
                            str2 = str2.trim();
                        }
                        if (g(str2)) {
                            jSONObject.put(f.T, str2);
                        } else {
                            return;
                        }
                    } else {
                        jSONObject.put(f.T, obj);
                    }
                    Context context = f13645a;
                    UMWorkDispatch.sendEvent(context, q.a.f14404q, CoreProtocol.getInstance(context), jSONObject);
                } catch (Throwable unused) {
                }
            } else {
                MLog.e("userProfile: Invalid value type, please check!");
            }
        }
    }
}
