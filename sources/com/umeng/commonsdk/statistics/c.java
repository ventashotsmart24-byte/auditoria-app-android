package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cz;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.f;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.a;
import com.umeng.commonsdk.statistics.internal.b;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import io.jsonwebtoken.Claims;
import java.io.File;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static final int f14888b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14889c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14890d = 3;

    /* renamed from: o  reason: collision with root package name */
    private static final String f14891o = "thtstart";

    /* renamed from: p  reason: collision with root package name */
    private static final String f14892p = "gkvc";

    /* renamed from: q  reason: collision with root package name */
    private static final String f14893q = "ekvc";

    /* renamed from: a  reason: collision with root package name */
    String f14894a = null;

    /* renamed from: e  reason: collision with root package name */
    private final int f14895e = 1;

    /* renamed from: f  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f14896f;

    /* renamed from: g  reason: collision with root package name */
    private ImprintHandler f14897g;

    /* renamed from: h  reason: collision with root package name */
    private f f14898h = null;

    /* renamed from: i  reason: collision with root package name */
    private ImprintHandler.a f14899i = null;

    /* renamed from: j  reason: collision with root package name */
    private ABTest f14900j = null;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Defcon f14901k = null;

    /* renamed from: l  reason: collision with root package name */
    private long f14902l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f14903m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f14904n = 0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public Context f14905r;

    public c(Context context) {
        this.f14905r = context;
        this.f14899i = ImprintHandler.getImprintService(context).c();
        this.f14901k = Defcon.getService(this.f14905r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f14905r);
        this.f14902l = sharedPreferences.getLong(f14891o, 0);
        this.f14903m = sharedPreferences.getInt(f14892p, 0);
        this.f14904n = sharedPreferences.getInt(f14893q, 0);
        this.f14894a = UMEnvelopeBuild.imprintProperty(this.f14905r, "track_list", (String) null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f14905r);
        this.f14897g = imprintService;
        imprintService.a((d) new d() {
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f14901k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f14894a = UMEnvelopeBuild.imprintProperty(cVar.f14905r, "track_list", (String) null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f14905r)) {
            this.f14898h = f.a(this.f14905r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.f14905r);
        this.f14896f = cVar;
        cVar.a((b) StatTracer.getInstance(this.f14905r));
    }

    public boolean a(File file) {
        String str;
        int i10;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            a a10 = a.a(this.f14905r);
            a10.e(name);
            boolean a11 = a10.a(name);
            boolean b10 = a10.b(name);
            boolean c10 = a10.c(name);
            boolean d10 = a10.d(name);
            String d11 = com.umeng.commonsdk.stateless.d.d(name);
            if (!TextUtils.isEmpty(d11)) {
                str = com.umeng.commonsdk.stateless.d.c(d11);
            } else if (d10) {
                str = UMServerURL.SILENT_HEART_BEAT;
            } else if (c10) {
                str = UMServerURL.ZCFG_PATH;
            } else {
                str = UMServerURL.PATH_ANALYTICS;
            }
            byte[] a12 = this.f14896f.a(byteArray, a11, c10, str);
            if (a12 == null) {
                i10 = 1;
            } else {
                i10 = a(a12);
            }
            if (UMConfigure.isDebugLog()) {
                if (d10 && i10 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c10 && i10 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b10 && i10 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a11 && i10 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (i10 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (i10 == 2) {
                f fVar = this.f14898h;
                if (fVar != null) {
                    fVar.e();
                }
                StatTracer.getInstance(this.f14905r).saveSate();
                if (d10) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f14905r, Claims.ISSUER, "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.f14905r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.f14905r, 0);
                            com.umeng.commonsdk.utils.c.d(this.f14905r);
                        }
                    }
                }
            } else if (i10 == 3) {
                StatTracer.getInstance(this.f14905r).saveSate();
                if (c10) {
                    FieldManager.a().a(this.f14905r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.f14905r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f14768s, com.umeng.commonsdk.internal.b.a(context).a(), (Object) null);
                    return true;
                }
            }
            if (i10 == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f14905r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ck(new cz.a()).a((ch) response, bArr);
            if (response.resp_code == 1) {
                this.f14897g.b(response.getImprint());
                this.f14897g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f14905r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
