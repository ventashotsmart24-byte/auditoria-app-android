package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.q;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.i;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class c implements UMLogDataProtocol {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14779a = bd.b().b(bd.f13857q);

    /* renamed from: b  reason: collision with root package name */
    public static final String f14780b = "preInitInvokedFlag";

    /* renamed from: c  reason: collision with root package name */
    public static final String f14781c = "policyGrantInvokedFlag";

    /* renamed from: d  reason: collision with root package name */
    public static final String f14782d = "policyGrantResult";

    /* renamed from: f  reason: collision with root package name */
    private static int f14783f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static Class<?> f14784g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Method f14785h = null;

    /* renamed from: i  reason: collision with root package name */
    private static Method f14786i = null;

    /* renamed from: j  reason: collision with root package name */
    private static Method f14787j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile String f14788k = "";

    /* renamed from: l  reason: collision with root package name */
    private static volatile String f14789l = "";

    /* renamed from: m  reason: collision with root package name */
    private static boolean f14790m = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f14791e;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f14791e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f14789l)) {
            return f14789l;
        }
        Class<?> cls = f14784g;
        if (cls == null || (method = f14785h) == null || f14787j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f14787j.invoke(invoke, new Object[0]);
            try {
                f14789l = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void c() {
        Class<ZIDManager> cls = ZIDManager.class;
        try {
            f14784g = cls;
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null) {
                f14785h = declaredMethod;
            }
            Method declaredMethod2 = f14784g.getDeclaredMethod("getZID", new Class[]{Context.class});
            if (declaredMethod2 != null) {
                f14786i = declaredMethod2;
            }
            Method declaredMethod3 = f14784g.getDeclaredMethod("getSDKVersion", new Class[0]);
            if (declaredMethod3 != null) {
                f14787j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bv a10 = bv.a(this.f14791e);
        bw a11 = a10.a(bx.f13987c);
        if (a11 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a11.f13979a;
                String str2 = a11.f13980b;
                JSONObject a12 = new b().a(this.f14791e.getApplicationContext(), new JSONObject(a11.f13981c), new JSONObject(a11.f13982d), a11.f13983e, str2, a11.f13984f);
                if (a12 == null || !a12.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a10.a(bx.f13987c, str);
                a10.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (!f14790m) {
            if (FieldManager.allow(d.G)) {
                f14790m = true;
                a(this.f14791e, (OnGetOaidListener) new OnGetOaidListener() {
                    public void onGetOaid(String str) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                        if (TextUtils.isEmpty(str)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                            return;
                        }
                        try {
                            SharedPreferences sharedPreferences = c.this.f14791e.getSharedPreferences(i.f14965a, 0);
                            if (sharedPreferences != null) {
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString(i.f14966b, str);
                                edit.commit();
                            }
                        } catch (Throwable unused) {
                        }
                        UMWorkDispatch.sendEvent(c.this.f14791e, a.f14772w, b.a(c.this.f14791e).a(), (Object) null);
                    }
                });
            }
        } else if (!FieldManager.allow(d.G)) {
            f14790m = false;
        }
    }

    private void f() {
        if (FieldManager.allow(d.G)) {
            f14790m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f14791e);
            f14783f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() {
                public void onMessageSend() {
                    if (c.this.f14791e != null) {
                        UMWorkDispatch.sendEvent(c.this.f14791e, a.f14773x, b.a(c.this.f14791e).a(), (Object) null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f14791e, true);
        }
    }

    private void g() {
        if (f14783f <= 0) {
            h();
            e(this.f14791e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f14791e)) {
            f(this.f14791e);
            UMInnerManager.sendInnerPackage(this.f14791e);
            if (!FieldManager.allow(d.at) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f14791e)) {
                Context context = this.f14791e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), (Object) null, 5000);
            }
            Context context2 = this.f14791e;
            UMWorkDispatch.sendEvent(context2, q.a.f14413z, CoreProtocol.getInstance(context2), (Object) null);
            Context context3 = this.f14791e;
            UMWorkDispatch.sendEvent(context3, a.f14769t, b.a(context3).a(), (Object) null);
        }
    }

    public void removeCacheData(Object obj) {
    }

    public JSONObject setupReportData(long j10) {
        return null;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02d7 A[Catch:{  }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02be A[Catch:{  }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void workEvent(java.lang.Object r13, int r14) {
        /*
            r12 = this;
            java.lang.String r0 = "cl_count"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "[internal] workEvent"
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "walle"
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r3, (java.lang.Object[]) r2)
            boolean r2 = com.umeng.commonsdk.utils.c.a()
            java.lang.String r5 = "MobclickRT"
            if (r2 == 0) goto L_0x0072
            r13 = 32802(0x8022, float:4.5965E-41)
            if (r13 != r14) goto L_0x0071
            java.lang.String r13 = "--->>> 静默模式：进入心跳处理逻辑!"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            long r13 = java.lang.System.currentTimeMillis()
            android.content.Context r0 = r12.f14791e
            long r0 = com.umeng.commonsdk.utils.c.b(r0)
            android.content.Context r2 = r12.f14791e
            boolean r2 = com.umeng.commonsdk.utils.c.e(r2)
            android.content.Context r3 = r12.f14791e
            int r3 = com.umeng.commonsdk.utils.c.a((android.content.Context) r3)
            boolean r13 = com.umeng.commonsdk.utils.c.a(r0, r13, r3)
            if (r13 == 0) goto L_0x005c
            android.content.Context r13 = r12.f14791e
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r14 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_Silent
            boolean r13 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r13, r14)
            if (r13 != 0) goto L_0x0052
            java.lang.String r13 = "--->>> 构建静默心跳信封."
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            android.content.Context r13 = r12.f14791e
            r12.b(r13)
            goto L_0x0057
        L_0x0052:
            java.lang.String r13 = "--->>> 静默心跳信封文件已存在，尝试发送之!"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
        L_0x0057:
            android.content.Context r13 = r12.f14791e
            com.umeng.commonsdk.framework.UMEnvelopeBuild.registerNetReceiver(r13)
        L_0x005c:
            if (r2 != 0) goto L_0x0071
            java.lang.String r13 = "--->>> send REBUILD_DB msg in silent mode."
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r13)
            android.content.Context r6 = r12.f14791e
            r7 = 4357(0x1105, float:6.105E-42)
            com.umeng.analytics.CoreProtocol r8 = com.umeng.analytics.CoreProtocol.getInstance(r6)
            r9 = 0
            r10 = 2000(0x7d0, double:9.88E-321)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r6, r7, r8, r9, r10)
        L_0x0071:
            return
        L_0x0072:
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.lang.String r6 = "[internal] workEvent send envelope"
            java.lang.String r7 = "policyGrantResult"
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r9 = 2
            switch(r14) {
                case 32769: goto L_0x0416;
                case 32770: goto L_0x007e;
                case 32771: goto L_0x03ad;
                case 32772: goto L_0x007e;
                case 32773: goto L_0x007e;
                case 32774: goto L_0x007e;
                case 32775: goto L_0x0390;
                case 32776: goto L_0x007e;
                case 32777: goto L_0x0353;
                case 32778: goto L_0x007e;
                case 32779: goto L_0x034a;
                case 32780: goto L_0x007e;
                case 32781: goto L_0x032d;
                case 32782: goto L_0x007e;
                case 32783: goto L_0x007e;
                case 32784: goto L_0x0318;
                case 32785: goto L_0x02e5;
                case 32786: goto L_0x02de;
                case 32787: goto L_0x027a;
                case 32788: goto L_0x0234;
                case 32789: goto L_0x007e;
                case 32790: goto L_0x0225;
                case 32791: goto L_0x01ea;
                case 32792: goto L_0x01c0;
                case 32793: goto L_0x014b;
                case 32794: goto L_0x007e;
                case 32795: goto L_0x007e;
                case 32796: goto L_0x007e;
                case 32797: goto L_0x007e;
                case 32798: goto L_0x007e;
                case 32799: goto L_0x007e;
                case 32800: goto L_0x011b;
                case 32801: goto L_0x0114;
                case 32802: goto L_0x007e;
                case 32803: goto L_0x00c0;
                case 32804: goto L_0x00b9;
                case 32805: goto L_0x0080;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0432
        L_0x0080:
            java.lang.String r13 = "recv CLOUD_CONFIG_TRIGGER msg."
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r13)
            com.umeng.commonsdk.internal.c$6 r13 = new com.umeng.commonsdk.internal.c$6
            r13.<init>()
            com.umeng.ccg.CcgAgent.registerConfigListener(r13)
            android.content.Context r13 = r12.f14791e     // Catch:{  }
            android.content.SharedPreferences r13 = com.umeng.analytics.pro.au.a(r13)     // Catch:{  }
            if (r13 == 0) goto L_0x00b2
            r1 = 0
            long r1 = r13.getLong(r0, r1)     // Catch:{  }
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 >= 0) goto L_0x00a7
            r3 = 1
            long r1 = r1 + r3
        L_0x00a7:
            android.content.SharedPreferences$Editor r13 = r13.edit()     // Catch:{  }
            android.content.SharedPreferences$Editor r13 = r13.putLong(r0, r1)     // Catch:{  }
            r13.commit()     // Catch:{  }
        L_0x00b2:
            android.content.Context r13 = r12.f14791e     // Catch:{  }
            com.umeng.ccg.CcgAgent.init(r13)     // Catch:{  }
            goto L_0x0432
        L_0x00b9:
            android.content.Context r13 = r12.f14791e
            r12.d(r13)
            goto L_0x0432
        L_0x00c0:
            android.content.Context r13 = r12.f14791e
            java.lang.String r14 = "connectivity"
            java.lang.Object r13 = r13.getSystemService(r14)
            android.net.ConnectivityManager r13 = (android.net.ConnectivityManager) r13
            if (r13 == 0) goto L_0x0107
            android.net.NetworkInfo r13 = r13.getActiveNetworkInfo()     // Catch:{ all -> 0x00ff }
            if (r13 == 0) goto L_0x00f2
            boolean r13 = r13.isAvailable()     // Catch:{ all -> 0x00ff }
            if (r13 == 0) goto L_0x00e5
            java.lang.String r13 = "--->>> network state changed: Available"
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r13)     // Catch:{ all -> 0x00ff }
            com.umeng.commonsdk.framework.a.a((boolean) r1)     // Catch:{ all -> 0x00ff }
            com.umeng.commonsdk.stateless.b.a((boolean) r1)     // Catch:{ all -> 0x00ff }
            goto L_0x0432
        L_0x00e5:
            java.lang.String r13 = "--->>> network state changed: unAvailable"
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r13)     // Catch:{ all -> 0x00ff }
            com.umeng.commonsdk.framework.a.a((boolean) r4)     // Catch:{ all -> 0x00ff }
            com.umeng.commonsdk.stateless.b.a((boolean) r4)     // Catch:{ all -> 0x00ff }
            goto L_0x0432
        L_0x00f2:
            java.lang.String r13 = "--->>> NetworkInfo is null!"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)     // Catch:{ all -> 0x00ff }
            com.umeng.commonsdk.framework.a.a((boolean) r4)     // Catch:{ all -> 0x00ff }
            com.umeng.commonsdk.stateless.b.a((boolean) r4)     // Catch:{ all -> 0x00ff }
            goto L_0x0432
        L_0x00ff:
            com.umeng.commonsdk.framework.a.a((boolean) r4)
            com.umeng.commonsdk.stateless.b.a((boolean) r4)
            goto L_0x0432
        L_0x0107:
            java.lang.String r13 = "--->>> ConnectivityManager is null!"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            com.umeng.commonsdk.framework.a.a((boolean) r4)
            com.umeng.commonsdk.stateless.b.a((boolean) r4)
            goto L_0x0432
        L_0x0114:
            android.content.Context r13 = r12.f14791e     // Catch:{  }
            com.umeng.commonsdk.debug.SelfChecker.doCheck(r13)     // Catch:{  }
            goto L_0x0432
        L_0x011b:
            android.content.Context r13 = r12.f14791e
            java.io.File r13 = r13.getFilesDir()
            java.io.File r14 = new java.io.File
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r13 = r13.getAbsolutePath()
            r0.append(r13)
            java.lang.String r13 = java.io.File.separator
            r0.append(r13)
            java.lang.String r13 = com.umeng.analytics.pro.bx.f13997m
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            boolean r13 = r14.exists()
            if (r13 == 0) goto L_0x0432
            r14.delete()     // Catch:{  }
            goto L_0x0432
        L_0x014b:
            java.lang.String r14 = "--->>> 保存preInit执行结果及授权API是否调用结果."
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r14)
            boolean r14 = r13 instanceof org.json.JSONObject
            if (r14 == 0) goto L_0x0432
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            java.lang.String r14 = "preInitInvoked"
            boolean r0 = r13.has(r14)
            if (r0 == 0) goto L_0x0432
            int r14 = r13.getInt(r14)     // Catch:{  }
            java.lang.String r0 = "policyGrantInvoked"
            int r0 = r13.getInt(r0)     // Catch:{  }
            int r13 = r13.getInt(r7)     // Catch:{  }
            android.content.Context r1 = r12.f14791e     // Catch:{  }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{  }
            java.lang.String r2 = f14779a     // Catch:{  }
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r4)     // Catch:{  }
            if (r1 == 0) goto L_0x0190
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{  }
            if (r1 == 0) goto L_0x0190
            java.lang.String r2 = "preInitInvokedFlag"
            r1.putInt(r2, r14)     // Catch:{  }
            java.lang.String r14 = "policyGrantInvokedFlag"
            r1.putInt(r14, r0)     // Catch:{  }
            r1.putInt(r7, r13)     // Catch:{  }
            r1.commit()     // Catch:{  }
        L_0x0190:
            android.content.Context r13 = r12.f14791e     // Catch:{  }
            java.io.File r13 = r13.getFilesDir()     // Catch:{  }
            java.io.File r14 = new java.io.File     // Catch:{  }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{  }
            r0.<init>()     // Catch:{  }
            java.lang.String r13 = r13.getAbsolutePath()     // Catch:{  }
            r0.append(r13)     // Catch:{  }
            java.lang.String r13 = java.io.File.separator     // Catch:{  }
            r0.append(r13)     // Catch:{  }
            java.lang.String r13 = com.umeng.analytics.pro.bx.f13997m     // Catch:{  }
            r0.append(r13)     // Catch:{  }
            java.lang.String r13 = r0.toString()     // Catch:{  }
            r14.<init>(r13)     // Catch:{  }
            boolean r13 = r14.exists()     // Catch:{  }
            if (r13 != 0) goto L_0x0432
            r14.createNewFile()     // Catch:{  }
            goto L_0x0432
        L_0x01c0:
            java.lang.String r14 = "--->>> 保存隐私授权结果."
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r14)
            boolean r14 = r13 instanceof java.lang.Integer     // Catch:{  }
            if (r14 == 0) goto L_0x0432
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{  }
            int r13 = r13.intValue()     // Catch:{  }
            android.content.Context r14 = r12.f14791e     // Catch:{  }
            android.content.Context r14 = r14.getApplicationContext()     // Catch:{  }
            java.lang.String r0 = f14779a     // Catch:{  }
            android.content.SharedPreferences r14 = r14.getSharedPreferences(r0, r4)     // Catch:{  }
            if (r14 == 0) goto L_0x0432
            android.content.SharedPreferences$Editor r14 = r14.edit()     // Catch:{  }
            android.content.SharedPreferences$Editor r13 = r14.putInt(r7, r13)     // Catch:{  }
            r13.commit()     // Catch:{  }
            goto L_0x0432
        L_0x01ea:
            java.lang.String r13 = "--->>> 正常冷启动流程，接收到云控配置加载成功通知。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            android.content.Context r13 = r12.f14791e
            com.umeng.commonsdk.UMInnerManager.sendInnerPackage(r13)
            java.lang.String r13 = "ccg_switch"
            boolean r13 = com.umeng.commonsdk.config.FieldManager.allow(r13)
            if (r13 != 0) goto L_0x021b
            int r13 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE
            if (r13 != 0) goto L_0x021b
            android.content.Context r13 = r12.f14791e
            boolean r13 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r13)
            if (r13 == 0) goto L_0x021b
            android.content.Context r0 = r12.f14791e
            r1 = 32805(0x8025, float:4.597E-41)
            com.umeng.commonsdk.internal.b r13 = com.umeng.commonsdk.internal.b.a(r0)
            com.umeng.commonsdk.internal.c r2 = r13.a()
            r3 = 0
            r4 = 5000(0x1388, double:2.4703E-320)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r0, r1, r2, r3, r4)
        L_0x021b:
            android.content.Context r13 = r12.f14791e
            r12.e(r13)
            com.umeng.commonsdk.utils.UMUtils.saveSDKComponent()
            goto L_0x0432
        L_0x0225:
            java.lang.String r13 = "--->>> 成功接收到(OAID)读取结束通知。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            int r13 = f14783f
            int r13 = r13 - r1
            f14783f = r13
            r12.g()
            goto L_0x0432
        L_0x0234:
            java.lang.String r13 = "--->>> 云控下发参数更新，触发 伪冷启动。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            com.umeng.commonsdk.statistics.b.a()
            r12.e()
            java.lang.String r13 = "header_foreground_count"
            boolean r13 = com.umeng.commonsdk.config.FieldManager.allow(r13)
            if (r13 == 0) goto L_0x0260
            boolean r13 = com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist()
            if (r13 != 0) goto L_0x0260
            java.lang.String r13 = "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            android.content.Context r6 = r12.f14791e
            r7 = 8213(0x2015, float:1.1509E-41)
            com.umeng.analytics.CoreProtocol r8 = com.umeng.analytics.CoreProtocol.getInstance(r6)
            r9 = 0
            r10 = 5000(0x1388, double:2.4703E-320)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEventEx(r6, r7, r8, r9, r10)
        L_0x0260:
            java.lang.String r13 = "header_first_resume"
            boolean r13 = com.umeng.commonsdk.config.FieldManager.allow(r13)
            if (r13 == 0) goto L_0x0432
            java.lang.String r13 = "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            android.content.Context r13 = r12.f14791e
            com.umeng.analytics.pro.n r13 = com.umeng.analytics.pro.n.a((android.content.Context) r13)
            android.content.Context r14 = r12.f14791e
            r13.b((android.content.Context) r14)
            goto L_0x0432
        L_0x027a:
            java.lang.String r13 = "--->>> 触发2号仓遗留信封检查动作。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)     // Catch:{  }
            android.content.Context r13 = r12.f14791e     // Catch:{  }
            java.lang.String r13 = com.umeng.commonsdk.stateless.d.a((android.content.Context) r13, (boolean) r4)     // Catch:{  }
            android.content.Context r14 = r12.f14791e     // Catch:{  }
            java.lang.String r14 = com.umeng.commonsdk.stateless.d.a((android.content.Context) r14, (boolean) r1)     // Catch:{  }
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{  }
            if (r0 != 0) goto L_0x02a3
            java.io.File r0 = new java.io.File     // Catch:{  }
            r0.<init>(r13)     // Catch:{  }
            boolean r13 = r0.exists()     // Catch:{  }
            if (r13 == 0) goto L_0x02a3
            boolean r13 = r0.isDirectory()     // Catch:{  }
            if (r13 == 0) goto L_0x02a3
            r4 = 1
        L_0x02a3:
            boolean r13 = android.text.TextUtils.isEmpty(r14)     // Catch:{  }
            if (r13 != 0) goto L_0x02bb
            java.io.File r13 = new java.io.File     // Catch:{  }
            r13.<init>(r14)     // Catch:{  }
            boolean r14 = r13.exists()     // Catch:{  }
            if (r14 == 0) goto L_0x02bb
            boolean r13 = r13.isDirectory()     // Catch:{  }
            if (r13 == 0) goto L_0x02bb
            goto L_0x02bc
        L_0x02bb:
            r1 = r4
        L_0x02bc:
            if (r1 == 0) goto L_0x02d7
            boolean r13 = com.umeng.commonsdk.stateless.b.a()     // Catch:{  }
            if (r13 != 0) goto L_0x02d0
            com.umeng.commonsdk.stateless.b r13 = new com.umeng.commonsdk.stateless.b     // Catch:{  }
            android.content.Context r14 = r12.f14791e     // Catch:{  }
            r13.<init>(r14)     // Catch:{  }
            com.umeng.commonsdk.stateless.b.b()     // Catch:{  }
            goto L_0x0432
        L_0x02d0:
            java.lang.String r13 = "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)     // Catch:{  }
            goto L_0x0432
        L_0x02d7:
            java.lang.String r13 = "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)     // Catch:{  }
            goto L_0x0432
        L_0x02de:
            android.content.Context r14 = r12.f14791e
            com.umeng.commonsdk.internal.crash.UMCrashManager.buildEnvelope(r14, r13)
            goto L_0x0432
        L_0x02e5:
            java.lang.String r13 = "--->>> [有状态]接收到消费二级缓存数据通知."
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            android.content.Context r13 = r12.f14791e
            com.umeng.analytics.pro.bv r13 = com.umeng.analytics.pro.bv.a((android.content.Context) r13)
            boolean r13 = r13.c()
            if (r13 == 0) goto L_0x02fc
            java.lang.String r13 = "--->>> [有状态]已消费完毕,二级缓存数据库为空."
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            return
        L_0x02fc:
            r12.d()
            r13 = 32785(0x8011, float:4.5942E-41)
            boolean r14 = com.umeng.commonsdk.framework.UMWorkDispatch.eventHasExist(r13)
            if (r14 != 0) goto L_0x0432
            android.content.Context r14 = r12.f14791e
            com.umeng.commonsdk.internal.b r0 = com.umeng.commonsdk.internal.b.a(r14)
            com.umeng.commonsdk.internal.c r0 = r0.a()
            r1 = 0
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r14, r13, r0, r1)
            goto L_0x0432
        L_0x0318:
            java.lang.String r13 = "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            r12.f()
            int r13 = f14783f
            int r13 = r13 - r1
            f14783f = r13
            r12.g()
            com.umeng.commonsdk.utils.UMUtils.saveSDKComponent()
            goto L_0x0432
        L_0x032d:
            android.content.Context r13 = r12.f14791e
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r14 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_ZeroEnv
            boolean r13 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r13, r14)
            if (r13 != 0) goto L_0x0343
            java.lang.String r13 = "--->>> 构建零号报文"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            android.content.Context r13 = r12.f14791e
            r12.a((android.content.Context) r13)
            goto L_0x0432
        L_0x0343:
            java.lang.String r13 = "--->>> 零号报文信封文件已存在，尝试发送之!"
            com.umeng.commonsdk.debug.UMRTLog.e(r5, r13)
            goto L_0x0432
        L_0x034a:
            com.umeng.commonsdk.vchannel.b r13 = (com.umeng.commonsdk.vchannel.b) r13
            android.content.Context r14 = r12.f14791e
            com.umeng.commonsdk.vchannel.Sender.handleEvent(r14, r13)
            goto L_0x0432
        L_0x0353:
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{  }
            r13[r4] = r6     // Catch:{  }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r3, (java.lang.Object[]) r13)     // Catch:{  }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{  }
            r13.<init>()     // Catch:{  }
            java.lang.String r14 = "i_sdk_v"
            java.lang.String r0 = "1.2.0"
            r13.put(r14, r0)     // Catch:{  }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{  }
            r14.<init>()     // Catch:{  }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{  }
            r0.<init>()     // Catch:{  }
            java.lang.String r2 = "inner"
            r14.put(r2, r0)     // Catch:{  }
            android.content.Context r0 = r12.f14791e     // Catch:{  }
            org.json.JSONObject r13 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r0, r13, r14)     // Catch:{  }
            if (r13 == 0) goto L_0x0432
            java.lang.String r14 = "exception"
            boolean r13 = r13.has(r14)     // Catch:{  }
            if (r13 != 0) goto L_0x0432
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{  }
            java.lang.String r14 = "[internal] workEvent send envelope back, result is ok"
            r13[r4] = r14     // Catch:{  }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r3, (java.lang.Object[]) r13)     // Catch:{  }
            goto L_0x0432
        L_0x0390:
            java.lang.Class<com.umeng.commonsdk.internal.utils.InfoPreferenceAgent> r14 = com.umeng.commonsdk.internal.utils.InfoPreferenceAgent.class
            java.lang.String r0 = "saveUA"
            java.lang.Class[] r3 = new java.lang.Class[r9]     // Catch:{ all -> 0x0432 }
            r3[r4] = r8     // Catch:{ all -> 0x0432 }
            r3[r1] = r2     // Catch:{ all -> 0x0432 }
            java.lang.reflect.Method r0 = r14.getMethod(r0, r3)     // Catch:{ all -> 0x0432 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0432 }
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ all -> 0x0432 }
            android.content.Context r3 = r12.f14791e     // Catch:{ all -> 0x0432 }
            r2[r4] = r3     // Catch:{ all -> 0x0432 }
            r2[r1] = r13     // Catch:{ all -> 0x0432 }
            r0.invoke(r14, r2)     // Catch:{ all -> 0x0432 }
            goto L_0x0432
        L_0x03ad:
            if (r13 == 0) goto L_0x0432
            boolean r14 = r13 instanceof com.umeng.commonsdk.internal.utils.b
            if (r14 == 0) goto L_0x0432
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            com.umeng.commonsdk.internal.utils.b r13 = (com.umeng.commonsdk.internal.utils.b) r13
            java.lang.String r0 = "le"
            int r3 = r13.f14802a     // Catch:{ all -> 0x03e4 }
            r14.put(r0, r3)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "vol"
            int r3 = r13.f14803b     // Catch:{ all -> 0x03e4 }
            r14.put(r0, r3)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "temp"
            int r3 = r13.f14804c     // Catch:{ all -> 0x03e4 }
            r14.put(r0, r3)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "st"
            int r3 = r13.f14805d     // Catch:{ all -> 0x03e4 }
            r14.put(r0, r3)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "ct"
            int r3 = r13.f14806e     // Catch:{ all -> 0x03e4 }
            r14.put(r0, r3)     // Catch:{ all -> 0x03e4 }
            java.lang.String r0 = "ts"
            long r6 = r13.f14807f     // Catch:{ all -> 0x03e4 }
            r14.put(r0, r6)     // Catch:{ all -> 0x03e4 }
        L_0x03e4:
            java.lang.String r13 = r14.toString()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "battery info: "
            r14.append(r0)
            r14.append(r13)
            java.lang.String r14 = r14.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r14)
            java.lang.Class<com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent> r14 = com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent.class
            java.lang.String r0 = "saveBattery"
            java.lang.Class[] r3 = new java.lang.Class[r9]     // Catch:{ all -> 0x0432 }
            r3[r4] = r8     // Catch:{ all -> 0x0432 }
            r3[r1] = r2     // Catch:{ all -> 0x0432 }
            java.lang.reflect.Method r0 = r14.getMethod(r0, r3)     // Catch:{ all -> 0x0432 }
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ all -> 0x0432 }
            android.content.Context r3 = r12.f14791e     // Catch:{ all -> 0x0432 }
            r2[r4] = r3     // Catch:{ all -> 0x0432 }
            r2[r1] = r13     // Catch:{ all -> 0x0432 }
            r0.invoke(r14, r2)     // Catch:{ all -> 0x0432 }
            goto L_0x0432
        L_0x0416:
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{  }
            r13[r4] = r6     // Catch:{  }
            com.umeng.commonsdk.statistics.common.ULog.i((java.lang.String) r3, (java.lang.Object[]) r13)     // Catch:{  }
            java.lang.Class<com.umeng.commonsdk.internal.UMInternalManagerAgent> r13 = com.umeng.commonsdk.internal.UMInternalManagerAgent.class
            java.lang.String r14 = "sendInternalEnvelopeByStateful2"
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ all -> 0x0432 }
            r0[r4] = r8     // Catch:{ all -> 0x0432 }
            java.lang.reflect.Method r14 = r13.getMethod(r14, r0)     // Catch:{ all -> 0x0432 }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0432 }
            android.content.Context r1 = r12.f14791e     // Catch:{ all -> 0x0432 }
            r0[r4] = r1     // Catch:{ all -> 0x0432 }
            r14.invoke(r13, r0)     // Catch:{ all -> 0x0432 }
        L_0x0432:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f14788k)) {
            return f14788k;
        }
        Class<?> cls = f14784g;
        if (cls == null || (method = f14785h) == null || f14786i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            if (invoke == null) {
                return "";
            }
            String str = (String) f14786i.invoke(invoke, new Object[]{this.f14791e});
            try {
                f14788k = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bt.f13913g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(b.a(bt.f13913g), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, (JSONObject) null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null) {
                if (buildSilentEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
                    return;
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(b.a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, (JSONObject) null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null) {
                if (buildZeroEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
                    return;
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a10 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a10.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 != null && (invoke = declaredMethod2.invoke(a10, new Object[0])) != null && (declaredMethod = a10.getDeclaredMethod("init", new Class[]{Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback")})) != null) {
                declaredMethod.invoke(invoke, new Object[]{applicationContext, appkey, null});
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow(d.G)) {
            a(context, (OnGetOaidListener) new OnGetOaidListener() {
                public void onGetOaid(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            SharedPreferences sharedPreferences = context.getSharedPreferences(i.f14965a, 0);
                            if (sharedPreferences != null && !sharedPreferences.getString(i.f14966b, "").equalsIgnoreCase(str)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString(i.f14966b, str);
                                edit.commit();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + bx.f13996l);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(final Context context, final boolean z10) {
        new Thread(new Runnable() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r9 = this;
                    android.content.Context r0 = r2     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r1 = com.umeng.commonsdk.statistics.idtracking.i.f14965a     // Catch:{ Exception -> 0x0066 }
                    r2 = 0
                    android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch:{ Exception -> 0x0066 }
                    long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0066 }
                    android.content.Context r3 = r2     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r3 = com.umeng.analytics.pro.bf.a(r3)     // Catch:{ Exception -> 0x0066 }
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0066 }
                    boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0066 }
                    if (r6 != 0) goto L_0x003d
                    if (r0 == 0) goto L_0x003d
                    android.content.SharedPreferences$Editor r6 = r0.edit()     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r7 = "key_umeng_sp_oaid_required_time"
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
                    r8.<init>()     // Catch:{ Exception -> 0x0066 }
                    long r4 = r4 - r1
                    r8.append(r4)     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r1 = ""
                    r8.append(r1)     // Catch:{ Exception -> 0x0066 }
                    java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x0066 }
                    r6.putString(r7, r1)     // Catch:{ Exception -> 0x0066 }
                    r6.commit()     // Catch:{ Exception -> 0x0066 }
                L_0x003d:
                    if (r0 == 0) goto L_0x004b
                    android.content.SharedPreferences$Editor r1 = r0.edit()     // Catch:{  }
                    java.lang.String r2 = "key_umeng_sp_oaid"
                    r1.putString(r2, r3)     // Catch:{  }
                    r1.commit()     // Catch:{  }
                L_0x004b:
                    boolean r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.isHonorDevice()     // Catch:{  }
                    if (r1 == 0) goto L_0x005f
                    if (r0 == 0) goto L_0x005f
                    android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{  }
                    java.lang.String r1 = "key_umeng_sp_honor_oaid"
                    r0.putString(r1, r3)     // Catch:{  }
                    r0.commit()     // Catch:{  }
                L_0x005f:
                    boolean r0 = r3     // Catch:{  }
                    if (r0 == 0) goto L_0x0066
                    com.umeng.commonsdk.UMConfigureImpl.removeInterruptFlag()     // Catch:{  }
                L_0x0066:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.AnonymousClass1.run():void");
            }
        }).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[SYNTHETIC, Splitter:B:12:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.b.a(r11, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0092
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.b.a(r11, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r0 = com.umeng.common.b.a(r11, r0, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L_0x002f
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x002e }
            long r3 = r3.longValue()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x002e:
        L_0x002f:
            r3 = r5
        L_0x0030:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x0040
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x003f }
            long r7 = r0.longValue()     // Catch:{ all -> 0x003f }
            goto L_0x0041
        L_0x003f:
        L_0x0040:
            r7 = r5
        L_0x0041:
            java.lang.String r0 = "MobclickRT"
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0088
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x004c
            goto L_0x0088
        L_0x004c:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            r3 = 60
            long r7 = r7 * r3
            r3 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a((android.content.Context) r11, (java.lang.String) r0)
            boolean r11 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r11 == 0) goto L_0x0092
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L_0x0092
        L_0x0071:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r11.put(r1, r2)
            boolean r1 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r1 != 0) goto L_0x0092
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L_0x0092
        L_0x0088:
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a((android.content.Context) r11, (java.lang.String) r0)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            new Thread(new Runnable() {
                public void run() {
                    String a10 = bf.a(applicationContext);
                    OnGetOaidListener onGetOaidListener = onGetOaidListener;
                    if (onGetOaidListener != null) {
                        onGetOaidListener.onGetOaid(a10);
                    }
                }
            }).start();
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
