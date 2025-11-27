package com.hpplay.sdk.source.da;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.da.a.a;
import com.hpplay.sdk.source.da.a.b;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11789a = "DaProcessor";

    /* renamed from: b  reason: collision with root package name */
    private static final int f11790b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private static f f11791c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f11792d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f11793e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f11794f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Context f11795g;

    /* renamed from: h  reason: collision with root package name */
    private i f11796h = new i();

    /* renamed from: i  reason: collision with root package name */
    private b f11797i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public a.C0162a f11798j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public m f11799k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public OutParameter f11800l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public OutParameter f11801m;

    /* renamed from: n  reason: collision with root package name */
    private Handler f11802n = new Handler(Looper.getMainLooper());

    /* renamed from: o  reason: collision with root package name */
    private Runnable f11803o = new Runnable() {
        public void run() {
            if (f.this.f11793e < f.this.f11792d) {
                f.this.f();
                return;
            }
            SourceLog.w(f.f11789a, "request da timeout");
            f.this.e();
            f fVar = f.this;
            fVar.a(fVar.f11800l, "0", 0, false, ErrorCode.DA_REQUEST_TIMEOUT);
            if (f.this.f11799k != null) {
                f.this.f11799k.onDaResult(true, (String) null);
            }
        }
    };

    private f() {
    }

    public static void b() {
        f11791c = null;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.f11796h == null) {
            SourceLog.i(f11789a, "toRequestVideoAD,value is valid");
            return;
        }
        SourceLog.i(f11789a, "toRequestVideoAD mCurrentRetryTime=" + this.f11793e);
        if (this.f11793e < this.f11792d && this.f11797i != null) {
            this.f11796h.c();
            int i10 = this.f11794f + 1;
            this.f11794f = i10;
            this.f11797i.f11775i = i10;
            SourceLog.i(f11789a, "toRequestVideoAD mRequestID: " + this.f11794f);
            this.f11796h.a(this.f11795g, this.f11797i);
            if (this.f11802n != null) {
                int i11 = Preference.getInstance().get(Preference.KEY_DA_CONNECT_TIMEOUT, 0);
                int i12 = i11 <= 0 ? 2000 : i11;
                SourceLog.i(f11789a, "cacheRetryCount cacheConnectTimeout=" + i11 + " connectTimeout=" + i12);
                this.f11802n.postDelayed(this.f11803o, (long) i12);
            }
            this.f11793e++;
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        SourceLog.i(f11789a, "cancelTimeoutCheck");
        Handler handler = this.f11802n;
        if (handler != null) {
            handler.removeCallbacks(this.f11803o);
        }
    }

    public void c() {
        this.f11796h.a();
    }

    public void d() {
        if (this.f11801m != null) {
            SourceLog.i(f11789a, "interruptRequest report interrupt");
            a(this.f11801m, "0", 0, false, ErrorCode.DA_REQUEST_INTERRUPT);
        }
        e();
    }

    public void e() {
        SourceLog.i(f11789a, "cancelRequest");
        this.f11801m = null;
        this.f11798j = null;
        this.f11794f++;
        g();
        i iVar = this.f11796h;
        if (iVar != null) {
            iVar.b();
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f11791c == null) {
                f11791c = new f();
            }
            fVar = f11791c;
        }
        return fVar;
    }

    public void a(Context context, OutParameter outParameter, m mVar) {
        this.f11794f = 0;
        this.f11795g = context;
        this.f11793e = 0;
        this.f11799k = mVar;
        this.f11800l = outParameter;
        this.f11801m = outParameter;
        b bVar = new b();
        int i10 = 1;
        bVar.f11767a = String.valueOf(1);
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        if (lelinkServiceInfo != null) {
            bVar.f11768b = String.valueOf(lelinkServiceInfo.getAppId());
            bVar.f11770d = outParameter.serviceInfo.getUid();
            bVar.f11771e = outParameter.serviceInfo.getUdnUuid();
        }
        bVar.f11772f = outParameter.getPlayUrl();
        bVar.f11773g = outParameter.session;
        bVar.f11774h = outParameter.urlID;
        this.f11797i = bVar;
        int i11 = Preference.getInstance().get(Preference.KEY_DA_RETRY_COUNT, 0);
        if (i11 > 0) {
            i10 = i11;
        }
        this.f11792d = i10;
        SourceLog.i(f11789a, "requestVideoPatchDA mRetryCount=" + this.f11792d + "  cacheRetryCount=" + i11);
        this.f11796h.a((l) new l() {
            public void a(String str, String str2, a aVar) {
                boolean z10;
                String str3;
                a.C0162a aVar2;
                if (!TextUtils.equals(f.this.f11794f + "", str2)) {
                    SourceLog.w(f.f11789a, "requestVideoPatchDA ignore, different requestId," + str2 + Operator.Operation.DIVISION + f.this.f11794f);
                    return;
                }
                String str4 = null;
                OutParameter unused = f.this.f11801m = null;
                f.this.g();
                if (aVar != null && aVar.f11756a == 200 && (aVar2 = aVar.f11757b) != null) {
                    a.C0162a unused2 = f.this.f11798j = aVar2;
                    Preference.getInstance().put(Preference.KEY_DA_CONNECT_TIMEOUT, aVar.f11759d);
                    Preference.getInstance().put(Preference.KEY_DA_RETRY_COUNT, aVar.f11758c);
                    z10 = true;
                } else if (f.this.f11793e < f.this.f11792d) {
                    f.this.f();
                    return;
                } else {
                    z10 = false;
                }
                if (f.this.f11799k != null) {
                    m e10 = f.this.f11799k;
                    if (z10) {
                        str3 = aVar.f11757b.f11766g;
                    } else {
                        str3 = null;
                    }
                    e10.onDaResult(true, str3);
                }
                if (!z10) {
                    if (aVar == null) {
                        str4 = ErrorCode.DA_REQUEST_FAILED;
                    } else if (aVar.f11756a != 200) {
                        str4 = ErrorCode.DA_REQUEST_RESULT_ERROR;
                    }
                }
                String str5 = str4;
                if (!TextUtils.isEmpty(str5)) {
                    f fVar = f.this;
                    fVar.a(fVar.f11800l, "0", 0, false, str5);
                } else if (aVar == null || aVar.f11757b == null) {
                    f fVar2 = f.this;
                    fVar2.a(fVar2.f11800l, "0", 0, true, "");
                } else {
                    f fVar3 = f.this;
                    OutParameter d10 = fVar3.f11800l;
                    a.C0162a aVar3 = aVar.f11757b;
                    fVar3.a(d10, aVar3.f11762c, aVar3.f11763d, true, "");
                }
            }
        });
        f();
    }

    public a.C0162a a(String str) {
        OutParameter outParameter = this.f11800l;
        if (outParameter != null && str != null && str.equals(outParameter.session)) {
            return this.f11798j;
        }
        SourceLog.i(f11789a, "getDaData fail, session check fail :" + str);
        return null;
    }

    /* access modifiers changed from: private */
    public void a(OutParameter outParameter, String str, int i10, boolean z10, String str2) {
        g.a().a(outParameter, str, String.valueOf(1), i10, z10, str2);
    }
}
