package c2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bigbee.db.EventDbModel;
import com.dcs.bean.DomainInfo;
import com.google.android.gms.cast.MediaTrack;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.taobao.accs.utl.BaseMonitor;
import h9.t;
import i2.d;
import i2.j;
import io.reactivex.Observable;
import okhttp3.Dns;
import okhttp3.Interceptor;
import s9.l;
import t9.j;

public final class i {

    /* renamed from: q  reason: collision with root package name */
    public static final b f4633q = new b((t9.g) null);

    /* renamed from: r  reason: collision with root package name */
    public static final h9.g f4634r = h9.h.a(h9.i.SYNCHRONIZED, a.f4651a);

    /* renamed from: a  reason: collision with root package name */
    public String f4635a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4636b;

    /* renamed from: c  reason: collision with root package name */
    public a2.b f4637c;

    /* renamed from: d  reason: collision with root package name */
    public d2.c f4638d;

    /* renamed from: e  reason: collision with root package name */
    public h2.a f4639e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4640f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4641g;

    /* renamed from: h  reason: collision with root package name */
    public Activity f4642h;

    /* renamed from: i  reason: collision with root package name */
    public long f4643i;

    /* renamed from: j  reason: collision with root package name */
    public long f4644j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4645k;

    /* renamed from: l  reason: collision with root package name */
    public Dns f4646l;

    /* renamed from: m  reason: collision with root package name */
    public Interceptor f4647m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4648n;

    /* renamed from: o  reason: collision with root package name */
    public final d f4649o;

    /* renamed from: p  reason: collision with root package name */
    public c f4650p;

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4651a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final i invoke() {
            return new i((t9.g) null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final i a() {
            return (i) i.f4634r.getValue();
        }
    }

    public final class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public String f4652a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i f4654a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(i iVar) {
                super(1);
                this.f4654a = iVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if ((elapsedRealtime - this.f4654a.f4644j) / ((long) 1000) >= i2.a.f6993a.d()) {
                    this.f4654a.f4644j = elapsedRealtime;
                    d dVar = d.f4594a;
                    dVar.i();
                    d.l(dVar, 0, 1, (Object) null);
                }
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f4655a = new b();

            public b() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return t.f17319a;
            }

            public final void invoke(Throwable th) {
                th.printStackTrace();
            }
        }

        public c() {
        }

        public static final void c(l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void d(l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public void onReceive(Context context, Intent intent) {
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            t9.i.g(intent, "intent");
            String action = intent.getAction();
            this.f4652a = action;
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -2128145023) {
                    if (hashCode == -1454123155) {
                        action.equals("android.intent.action.SCREEN_ON");
                    } else if (hashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                        Observable.just("ioSchedulers").compose(s2.c.b()).subscribe(new j(new a(i.this)), new k(b.f4655a));
                    }
                } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                    i.this.f4644j = SystemClock.elapsedRealtime();
                }
            }
        }
    }

    public static final class d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f4656a;

        public d(i iVar) {
            this.f4656a = iVar;
        }

        public void onReceive(Context context, Intent intent) {
            h2.a e10;
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            t9.i.g(intent, "intent");
            intent.getAction();
            if (t9.i.b(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                t9.i.e(parcelableExtra, "null cannot be cast to non-null type android.net.NetworkInfo");
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                if (NetworkInfo.State.CONNECTED == networkInfo.getState() && networkInfo.isAvailable() && (e10 = this.f4656a.f4639e) != null) {
                    e10.a();
                }
            }
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f4657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f4658b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(i iVar, Activity activity) {
            super(1);
            this.f4657a = iVar;
            this.f4658b = activity;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            this.f4657a.v(this.f4658b);
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f4659a = new f();

        public f() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class g implements j.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f4660a;

        public g(i iVar) {
            this.f4660a = iVar;
        }

        public void a() {
            i.y(this.f4660a, true, false, 2, (Object) null);
        }
    }

    public static final class h implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f4661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4663c;

        public h(i iVar, String str, String str2) {
            this.f4661a = iVar;
            this.f4662b = str;
            this.f4663c = str2;
        }

        public void a() {
            i.y(this.f4661a, false, false, 2, (Object) null);
            this.f4661a.t();
            l.f4666a.f(this.f4662b, this.f4663c);
            d.l(d.f4594a, 0, 1, (Object) null);
        }
    }

    public /* synthetic */ i(t9.g gVar) {
        this();
    }

    public static /* synthetic */ void A(i iVar, boolean z10, DomainInfo domainInfo, String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11, int i11, Object obj) {
        boolean z12;
        boolean z13;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            z12 = false;
        } else {
            z12 = z10;
        }
        if ((i12 & 1024) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        iVar.z(z12, domainInfo, str, i10, str2, str3, str4, str5, str6, str7, z13);
    }

    public static /* synthetic */ void l(i iVar, Context context, boolean z10, h2.a aVar, d2.c cVar, Dns dns, Interceptor interceptor, int i10, Object obj) {
        h2.a aVar2;
        d2.c cVar2;
        if ((i10 & 4) != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        if ((i10 & 8) != 0) {
            cVar2 = null;
        } else {
            cVar2 = cVar;
        }
        iVar.k(context, z10, aVar2, cVar2, dns, interceptor);
    }

    public static final void q(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void y(i iVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        iVar.x(z10, z11);
    }

    public final void B(DomainInfo domainInfo) {
        t9.i.g(domainInfo, "domainInfo");
        b2.a.f4202d = domainInfo;
        b2.a.f4203e = domainInfo.getFirst();
        b2.a.f4204f = domainInfo.getSecond();
    }

    public final void C() {
        if (this.f4648n && !this.f4645k) {
            this.f4650p = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            Context context = this.f4636b;
            if (context != null) {
                context.registerReceiver(this.f4650p, intentFilter);
            }
            this.f4641g = true;
        }
    }

    public final void D() {
        Context context;
        if (this.f4648n && this.f4641g && !this.f4645k && (context = this.f4636b) != null) {
            context.unregisterReceiver(this.f4650p);
        }
        this.f4641g = false;
    }

    public final void E(String str, String str2) {
        t9.i.g(str, "uName");
        i2.d.f7007c.a().f(new h(this, str, str2));
    }

    public final void F() {
        Context context;
        if (this.f4648n && this.f4640f && (context = this.f4636b) != null) {
            context.unregisterReceiver(this.f4649o);
        }
        this.f4640f = false;
    }

    public final void G(EventDbModel eventDbModel) {
        t9.i.g(eventDbModel, "dbModel");
        d2.c cVar = this.f4638d;
        if (cVar != null) {
            cVar.b(eventDbModel);
        }
    }

    public final void h() {
        i2.j.f7023c.a().c();
        i2.d.f7007c.a().e();
        y(this, false, false, 2, (Object) null);
        F();
        D();
    }

    public final void i(String str) {
        long j10;
        i2.a aVar = i2.a.f6993a;
        aVar.k(false);
        aVar.m(SystemClock.elapsedRealtime());
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            i2.h hVar = i2.h.f7019a;
            if (str != null) {
                j10 = Long.parseLong(str);
            } else {
                j10 = 0;
            }
            hVar.b(j10);
        }
        if (this.f4648n) {
            d.f4594a.m(i2.h.f7019a.a() - (aVar.g() - aVar.f()));
        }
    }

    public final Context j() {
        return this.f4636b;
    }

    public final void k(Context context, boolean z10, h2.a aVar, d2.c cVar, Dns dns, Interceptor interceptor) {
        t9.i.g(context, "ctx");
        t9.i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f4645k = z10;
        m(context, cVar, dns, interceptor);
        if (aVar == null) {
            d2.c cVar2 = this.f4638d;
            t9.i.d(cVar2);
            aVar = new h2.d(cVar2, 0, 2, (t9.g) null);
        }
        this.f4639e = aVar;
    }

    public final void m(Context context, d2.c cVar, Dns dns, Interceptor interceptor) {
        t9.i.g(context, "ctx");
        t9.i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f4636b = context;
        i2.a aVar = i2.a.f6993a;
        aVar.l(SystemClock.elapsedRealtime());
        aVar.m(aVar.f());
        this.f4644j = aVar.f();
        FlowManager.init(context);
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.E);
        this.f4646l = dns;
        this.f4647m = interceptor;
        a2.a aVar2 = new a2.a();
        this.f4637c = aVar2;
        if (cVar == null) {
            t9.i.d(aVar2);
            cVar = new d2.a(aVar2, dns, interceptor);
        }
        this.f4638d = cVar;
    }

    public final void n() {
        this.f4642h = null;
    }

    public final void o(Activity activity) {
        t9.i.g(activity, "aty");
        this.f4643i = SystemClock.elapsedRealtime();
        Activity activity2 = this.f4642h;
        if (activity2 != null && t9.i.b(activity2, activity)) {
            d.f4594a.f();
            i2.j.f7023c.a().c();
        }
        this.f4642h = activity;
    }

    public final void p(Activity activity) {
        t9.i.g(activity, "aty");
        if (this.f4643i != 0) {
            if (t9.i.b(Thread.currentThread().getName(), MediaTrack.ROLE_MAIN)) {
                Observable.just("ioSchedulers").compose(s2.c.b()).subscribe(new g(new e(this, activity)), new h(f.f4659a));
            } else {
                v(activity);
            }
        }
        j.b bVar = i2.j.f7023c;
        bVar.a().c();
        i2.j a10 = bVar.a();
        i2.a aVar = i2.a.f6993a;
        a10.d(aVar.e(), aVar.e(), new g(this));
    }

    public final void s() {
        if (this.f4648n) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            Context context = this.f4636b;
            if (context != null) {
                context.registerReceiver(this.f4649o, intentFilter);
            }
            this.f4640f = true;
        }
    }

    public final void t() {
        h2.a aVar = this.f4639e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void u() {
        i2.e.f7014b.a().c("server_time", 0L);
    }

    public final void v(Activity activity) {
        if (t9.i.b(activity, this.f4642h)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f4644j = elapsedRealtime;
            if ((elapsedRealtime - this.f4643i) / ((long) 1000) >= i2.a.f6993a.d()) {
                d dVar = d.f4594a;
                dVar.i();
                d.l(dVar, 0, 1, (Object) null);
                this.f4643i = 0;
            }
        }
    }

    public final void w(EventDbModel eventDbModel) {
        t9.i.g(eventDbModel, "dbModel");
        d2.c cVar = this.f4638d;
        if (cVar != null) {
            cVar.a(eventDbModel);
        }
    }

    public final void x(boolean z10, boolean z11) {
        if (this.f4648n && z11) {
            d.r(d.f4594a, z10, false, 2, (Object) null);
        }
    }

    public final void z(boolean z10, DomainInfo domainInfo, String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11) {
        DomainInfo domainInfo2 = domainInfo;
        t9.i.g(domainInfo, "domainInfo");
        t9.i.g(str, "appId");
        t9.i.g(str2, "sysVer");
        t9.i.g(str3, "macAddr");
        t9.i.g(str4, "reserve1");
        t9.i.g(str5, "sn");
        t9.i.g(str6, "userId");
        t9.i.g(str7, "userName");
        B(domainInfo);
        if (z10) {
            i2.b.f7005a = 6;
        }
        l lVar = l.f4666a;
        String valueOf = String.valueOf(i10);
        String str8 = Build.MODEL;
        t9.i.f(str8, "MODEL");
        lVar.d(str, valueOf, str2, str8, str3, str4, str5, str6, str7);
        i2.f fVar = i2.f.f7018a;
        Context context = this.f4636b;
        t9.i.d(context);
        if (fVar.c(context)) {
            if (z11) {
                new z1.a().a(this.f4646l, this.f4647m);
            }
            h2.a aVar = this.f4639e;
            if (aVar != null) {
                aVar.a();
            }
        } else {
            s();
        }
        C();
    }

    public i() {
        this.f4635a = i.class.getSimpleName();
        this.f4645k = true;
        Dns dns = Dns.SYSTEM;
        t9.i.f(dns, "SYSTEM");
        this.f4646l = dns;
        this.f4648n = true;
        this.f4649o = new d(this);
    }
}
