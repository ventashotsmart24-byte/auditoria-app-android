package com.mobile.brasiltv.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.OpenNotifyDialog;
import com.mobile.brasiltv.view.dialog.StandardDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.c5;
import f5.d5;
import f5.e5;
import f5.f5;
import f5.g5;
import f5.h5;
import f5.i5;
import f5.j5;
import f5.k5;
import h9.t;
import i6.x0;
import i6.y0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k6.k4;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import t9.j;
import w6.l;

public final class SplashAty extends f5.d implements y0, OpenNotifyDialog.NotificationListener {

    /* renamed from: s  reason: collision with root package name */
    public static final a f12202s = new a((t9.g) null);

    /* renamed from: t  reason: collision with root package name */
    public static boolean f12203t;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f12204u;

    /* renamed from: v  reason: collision with root package name */
    public static String f12205v = "";

    /* renamed from: l  reason: collision with root package name */
    public StandardDialog f12206l;

    /* renamed from: m  reason: collision with root package name */
    public k4 f12207m;

    /* renamed from: n  reason: collision with root package name */
    public final long f12208n = 5;

    /* renamed from: o  reason: collision with root package name */
    public Disposable f12209o;

    /* renamed from: p  reason: collision with root package name */
    public Disposable f12210p;

    /* renamed from: q  reason: collision with root package name */
    public String f12211q = "";

    /* renamed from: r  reason: collision with root package name */
    public Map f12212r = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final boolean a() {
            return SplashAty.f12203t;
        }

        public final void b(boolean z10) {
            SplashAty.f12203t = z10;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAty f12213a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f12214a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return t.f17319a;
            }

            public final void invoke(Long l10) {
                ma.l.a("check");
                ma.h hVar = ma.h.f18994a;
                App.a aVar = App.f6050e;
                App a10 = aVar.a();
                String packageName = aVar.a().getPackageName();
                i.f(packageName, "App.instance.getPackageName()");
                hVar.d(a10, packageName);
            }
        }

        /* renamed from: com.mobile.brasiltv.activity.SplashAty$b$b  reason: collision with other inner class name */
        public static final class C0188b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0188b f12215a = new C0188b();

            public C0188b() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return t.f17319a;
            }

            public final void invoke(Long l10) {
                ma.l.a("check");
                ma.h hVar = ma.h.f18994a;
                App.a aVar = App.f6050e;
                App a10 = aVar.a();
                String packageName = aVar.a().getPackageName();
                i.f(packageName, "App.instance.getPackageName()");
                hVar.d(a10, packageName);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SplashAty splashAty) {
            super(1);
            this.f12213a = splashAty;
        }

        public static final void f(SplashAty splashAty) {
            i.g(splashAty, "this$0");
            f1.a aVar = f1.f12517a;
            f1.a.p(aVar, splashAty, "EA18, " + x.f12622a.y(splashAty.Q1(), R.string.contact_seller), 0, 4, (Object) null);
        }

        public static final void g(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void h(SplashAty splashAty) {
            i.g(splashAty, "this$0");
            f1.a aVar = f1.f12517a;
            f1.a.p(aVar, splashAty, "EA31 " + x.f12622a.y(splashAty.Q1(), R.string.contact_seller), 0, 4, (Object) null);
        }

        public static final void i(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
            if (t9.i.b("", "") != false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
            if (t9.i.b("", "") != false) goto L_0x002d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(java.lang.String r14) {
            /*
                r13 = this;
                ma.h r14 = ma.h.f18994a
                boolean r0 = r14.f()
                boolean r1 = r14.b()
                java.lang.String r2 = ""
                if (r0 == 0) goto L_0x001c
                com.mobile.brasiltv.activity.SplashAty r3 = r13.f12213a
                java.lang.String r4 = "4"
                r3.f12211q = r4
                boolean r3 = t9.i.b(r2, r2)
                if (r3 == 0) goto L_0x002c
                goto L_0x002d
            L_0x001c:
                if (r1 == 0) goto L_0x002c
                com.mobile.brasiltv.activity.SplashAty r3 = r13.f12213a
                java.lang.String r4 = "6"
                r3.f12211q = r4
                boolean r3 = t9.i.b(r2, r2)
                if (r3 == 0) goto L_0x002c
                goto L_0x002d
            L_0x002c:
                r4 = r2
            L_0x002d:
                if (r0 != 0) goto L_0x0050
                if (r1 == 0) goto L_0x0032
                goto L_0x0050
            L_0x0032:
                boolean r14 = r14.a()
                if (r14 == 0) goto L_0x0119
                com.mobile.brasiltv.activity.SplashAty r14 = r13.f12213a
                java.lang.String r0 = "2"
                r14.f12211q = r0
                com.mobile.brasiltv.app.App$a r14 = com.mobile.brasiltv.app.App.f6050e
                com.mobile.brasiltv.app.App r14 = r14.a()
                com.mobile.brasiltv.activity.SplashAty r0 = r13.f12213a
                java.lang.String r0 = r0.f12211q
                com.mobile.brasiltv.utils.i1.u(r14, r0)
                goto L_0x0119
            L_0x0050:
                com.mobile.brasiltv.activity.SplashAty r14 = r13.f12213a
                java.lang.String r0 = "deviceTag"
                na.f.l(r14, r0, r4)
                na.c.d()
                android.util.Pair r14 = m7.c.b()
                if (r14 == 0) goto L_0x006a
                java.lang.Object r0 = r14.first
                if (r0 == 0) goto L_0x006a
                java.lang.String r0 = r0.toString()
                if (r0 != 0) goto L_0x006c
            L_0x006a:
                java.lang.String r0 = b2.a.f4205g
            L_0x006c:
                if (r14 == 0) goto L_0x0078
                java.lang.Object r14 = r14.second
                if (r14 == 0) goto L_0x0078
                java.lang.String r14 = r14.toString()
                if (r14 != 0) goto L_0x007a
            L_0x0078:
                java.lang.String r14 = b2.a.f4205g
            L_0x007a:
                t2.a r1 = t2.a.f9350a
                java.lang.String r3 = "bbMainDomain"
                t9.i.f(r0, r3)
                java.lang.String r3 = "bbSecondDomain"
                t9.i.f(r14, r3)
                java.lang.String r3 = "key_tdc"
                com.dcs.bean.DomainInfo r14 = r1.b(r0, r14, r3)
                c2.i$b r0 = c2.i.f4633q
                c2.i r1 = r0.a()
                r1.B(r14)
                c2.l r3 = c2.l.f4666a
                java.lang.String r4 = na.a.g()
                java.lang.String r14 = "getPackageName()"
                t9.i.f(r4, r14)
                int r14 = na.a.b()
                java.lang.String r5 = java.lang.String.valueOf(r14)
                java.lang.String r6 = android.os.Build.VERSION.RELEASE
                java.lang.String r14 = "RELEASE"
                t9.i.f(r6, r14)
                java.lang.String r7 = android.os.Build.MODEL
                java.lang.String r14 = "MODEL"
                t9.i.f(r7, r14)
                com.mobile.brasiltv.utils.y0 r14 = com.mobile.brasiltv.utils.y0.f12657a
                com.mobile.brasiltv.activity.SplashAty r1 = r13.f12213a
                android.content.Context r1 = r1.Q1()
                java.lang.String r8 = r14.y(r1)
                java.lang.String r9 = na.c.f19073a
                java.lang.String r14 = "reserve1"
                t9.i.f(r9, r14)
                java.lang.String r10 = ""
                java.lang.String r11 = ""
                java.lang.String r12 = ""
                r3.d(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                c2.i r14 = r0.a()
                r14.i(r2)
                c2.d r14 = c2.d.f4594a
                com.mobile.brasiltv.activity.SplashAty r1 = r13.f12213a
                java.lang.String r1 = r1.f12211q
                r14.p(r1)
                r14.i()
                c2.i r14 = r0.a()
                r14.t()
                com.mobile.brasiltv.app.App$a r14 = com.mobile.brasiltv.app.App.f6050e
                com.mobile.brasiltv.app.App r14 = r14.a()
                com.mobile.brasiltv.activity.SplashAty r0 = r13.f12213a
                java.lang.String r0 = r0.f12211q
                com.mobile.brasiltv.utils.i1.u(r14, r0)
                com.mobile.brasiltv.activity.SplashAty r14 = r13.f12213a
                f5.l5 r0 = new f5.l5
                r0.<init>(r14)
                r14.runOnUiThread(r0)
                r0 = 3
                java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.SECONDS
                io.reactivex.Observable r14 = io.reactivex.Observable.timer(r0, r14)
                com.mobile.brasiltv.activity.SplashAty$b$a r0 = com.mobile.brasiltv.activity.SplashAty.b.a.f12214a
                f5.m5 r1 = new f5.m5
                r1.<init>(r0)
                r14.subscribe(r1)
            L_0x0119:
                com.mobile.brasiltv.app.App$a r14 = com.mobile.brasiltv.app.App.f6050e
                com.mobile.brasiltv.app.App r0 = r14.a()
                boolean r0 = com.mobile.brasiltv.utils.o.c(r0)
                if (r0 == 0) goto L_0x0158
                com.mobile.brasiltv.utils.g1 r0 = com.mobile.brasiltv.utils.g1.f12561a
                com.mobile.brasiltv.app.App r14 = r14.a()
                boolean r14 = r0.d(r14)
                if (r14 != 0) goto L_0x0158
                com.mobile.brasiltv.activity.SplashAty r14 = r13.f12213a
                android.content.Context r14 = r14.Q1()
                java.lang.String r0 = "1"
                com.mobile.brasiltv.utils.i1.M(r14, r0)
                com.mobile.brasiltv.activity.SplashAty r14 = r13.f12213a
                f5.n5 r0 = new f5.n5
                r0.<init>(r14)
                r14.runOnUiThread(r0)
                r0 = 2
                java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.SECONDS
                io.reactivex.Observable r14 = io.reactivex.Observable.timer(r0, r14)
                com.mobile.brasiltv.activity.SplashAty$b$b r0 = com.mobile.brasiltv.activity.SplashAty.b.C0188b.f12215a
                f5.o5 r1 = new f5.o5
                r1.<init>(r0)
                r14.subscribe(r1)
            L_0x0158:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.activity.SplashAty.b.invoke(java.lang.String):void");
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12216a = new c();

        public c() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAty f12217a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SplashAty splashAty) {
            super(1);
            this.f12217a = splashAty;
        }

        /* renamed from: b */
        public final Long invoke(Long l10) {
            i.g(l10, "it");
            return Long.valueOf(this.f12217a.f12208n - l10.longValue());
        }
    }

    public static final class e implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAty f12218a;

        public e(SplashAty splashAty) {
            this.f12218a = splashAty;
        }

        public void a(long j10) {
            b0.U(this, String.valueOf(j10));
            ((Button) this.f12218a.d3(R$id.skipBtn)).setText(j10 + "s skip");
            if (0 == j10) {
                this.f12218a.S2().O();
            }
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            i.g(th, "e");
            th.printStackTrace();
        }

        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            this.f12218a.r3(disposable);
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAty f12219a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(SplashAty splashAty) {
            super(1);
            this.f12219a = splashAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f17319a;
        }

        public final void invoke(Long l10) {
            this.f12219a.S2().O();
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SplashAty f12220a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SplashAty splashAty) {
            super(1);
            this.f12220a = splashAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            n0 n0Var = n0.f12601a;
            if (!n0Var.b(this.f12220a, "clear", false)) {
                n0Var.a(this.f12220a);
                n0Var.g(this.f12220a, "clear", true);
                na.f.n(this.f12220a, new String[]{"home_data", "4596", "4608", "4599", "4601", "4607", "4600", "4603", "4597", "6357", "6358", "6360", "6361", "6362"});
            }
        }
    }

    public static final class h extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f12221a = new h();

        public h() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final void k3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m3(SplashAty splashAty, View view) {
        boolean z10;
        Disposable disposable;
        i.g(splashAty, "this$0");
        Disposable disposable2 = splashAty.f12209o;
        if (disposable2 != null) {
            i.d(disposable2);
            if (disposable2.isDisposed()) {
                Disposable disposable3 = splashAty.f12209o;
                i.d(disposable3);
                disposable3.dispose();
            }
        }
        Disposable disposable4 = splashAty.f12210p;
        if (disposable4 != null) {
            z10 = disposable4.isDisposed();
        } else {
            z10 = true;
        }
        if (!z10 && (disposable = splashAty.f12210p) != null) {
            disposable.dispose();
        }
        splashAty.S2().O();
    }

    public static final void s3(SplashAty splashAty, AdInfo adInfo, View view) {
        i.g(splashAty, "this$0");
        i.g(adInfo, "$adInfo");
        splashAty.S2().B(adInfo);
    }

    public static final Long t3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (Long) lVar.invoke(obj);
    }

    public static final void u3(SplashAty splashAty, View view) {
        i.g(splashAty, "this$0");
        splashAty.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + splashAty.Q1().getPackageName())));
    }

    public static final void v3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void A1() {
        ((Button) d3(R$id.skipBtn)).setVisibility(8);
        ((AutoRelativeLayout) d3(R$id.mLayoutSplash)).setVisibility(0);
        Observable.timer(3, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).compose(P1(t8.a.DESTROY)).subscribe(new k5(new f(this)));
    }

    public void B0() {
        StandardDialog standardDialog = this.f12206l;
        if (standardDialog != null) {
            standardDialog.dismiss();
        }
    }

    public void R2() {
        p3(new k4(this, this));
        q.f9311a.g(this);
        ma.l.c();
        n3(getIntent());
        x.f12622a.t(this);
        l.a aVar = w6.l.f19757a;
        aVar.e(aVar.d() | aVar.c());
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        f12203t = true;
        ((TextView) d3(R$id.mTextVersion)).setText('V' + com.mobile.brasiltv.utils.e.b(this));
        ((Button) d3(R$id.skipBtn)).setOnClickListener(new c5(this));
        j3();
        w3();
    }

    public int T2() {
        return R.layout.aty_splash;
    }

    public void V(String[] strArr) {
        String str;
        i.g(strArr, "permissions");
        StandardDialog standardDialog = this.f12206l;
        if (standardDialog != null) {
            i.d(standardDialog);
            if (standardDialog.isShowing()) {
                return;
            }
        }
        if (i9.g.e(strArr, "android.permission.READ_MEDIA_IMAGES")) {
            str = getResources().getString(R.string.need_storage_permission) + getResources().getString(R.string.way_to_image_permission);
        } else if (i9.g.e(strArr, "android.permission.READ_MEDIA_AUDIO")) {
            str = getResources().getString(R.string.need_storage_permission) + getResources().getString(R.string.way_to_audio_permission);
        } else {
            str = getResources().getString(R.string.need_storage_permission) + getResources().getString(R.string.way_to_storage_permission);
        }
        String str2 = str;
        StandardDialog standardDialog2 = new StandardDialog(this);
        this.f12206l = standardDialog2;
        i.d(standardDialog2);
        String string = getResources().getString(R.string.grant_permission);
        i.f(string, "resources.getString(R.string.grant_permission)");
        String string2 = getResources().getString(R.string.go_to_setting);
        i.f(string2, "resources.getString(R.string.go_to_setting)");
        standardDialog2.setDialogConfig(string, str2, (String) null, string2, (View.OnClickListener) null, new h5(this));
        StandardDialog standardDialog3 = this.f12206l;
        i.d(standardDialog3);
        standardDialog3.show();
    }

    public View d3(int i10) {
        Map map = this.f12212r;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void f2(AdInfo adInfo) {
        i.g(adInfo, "adInfo");
        m mVar = m.f9270a;
        Context Q1 = Q1();
        int i10 = R$id.mImageAdvert;
        ImageView imageView = (ImageView) d3(i10);
        i.f(imageView, "mImageAdvert");
        a6.a aVar = a6.a.f10646a;
        m.h0(mVar, Q1, imageView, aVar.b(), adInfo, (Integer) null, (s9.l) null, (Integer) null, false, 0, 496, (Object) null);
        q.f9311a.j(Q1(), d6.b.f6366a.m(Q1()), aVar.b(), adInfo);
        ((ImageView) d3(i10)).setOnClickListener(new i5(this, adInfo));
        ((ImageView) d3(i10)).setVisibility(0);
        int i11 = R$id.btnVersion;
        ((Button) d3(i11)).setVisibility(0);
        ((Button) d3(i11)).setText("v: " + com.mobile.brasiltv.utils.e.b(Q1()));
        i1.e(this, "EVENT_AD_SHOW_SPLASH");
        this.f12210p = i1.p(this, "EVENT_AD_LONG_SHOW_SPLASH");
        ((Button) d3(R$id.skipBtn)).setVisibility(0);
        Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).take(this.f12208n + 1).map(new j5(new d(this))).compose(O1()).subscribe(new e(this));
    }

    public final void j3() {
        Observable.just("").observeOn(Schedulers.io()).subscribe(new d5(new b(this)), new e5(c.f12216a));
    }

    public void k2() {
        n2();
    }

    public final void n3(Intent intent) {
        Uri uri;
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        if (uri != null) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (i.b(scheme, "sxl") && i.b(host, s6.a.f9335a.a().h())) {
                String queryParameter = uri.getQueryParameter("inviteCode");
                if (queryParameter == null) {
                    queryParameter = "";
                } else {
                    i.f(queryParameter, "data.getQueryParameter(\"inviteCode\") ?: \"\"");
                }
                f12205v = queryParameter;
                b0.U(this, ">>>>浏览器启动应用>>>>  " + f12205v);
                f12204u = true;
            }
        }
    }

    /* renamed from: o3 */
    public k4 S2() {
        k4 k4Var = this.f12207m;
        if (k4Var != null) {
            return k4Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void onBackPressed() {
        super.onBackPressed();
        ma.l.a("Splash");
        Process.killProcess(Process.myPid());
    }

    public void onNewIntent(Intent intent) {
        n3(intent);
        super.onNewIntent(intent);
    }

    public void onOpen(Dialog dialog) {
        i.g(dialog, "dialog");
        S2().J();
    }

    public void onRestart() {
        super.onRestart();
        if (!i.b(S2().y(), Boolean.FALSE)) {
            S2().e();
        } else if (p.a.checkSelfPermission(Q1(), "android.permission.READ_MEDIA_IMAGES") == 0) {
            S2().J();
        }
    }

    public void p3(k4 k4Var) {
        i.g(k4Var, "<set-?>");
        this.f12207m = k4Var;
    }

    /* renamed from: q3 */
    public void Y0(x0 x0Var) {
        i.g(x0Var, "presenter");
    }

    public final void r3(Disposable disposable) {
        this.f12209o = disposable;
    }

    public void unbindService(ServiceConnection serviceConnection) {
        i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    public final void w3() {
        Observable.just("").observeOn(Schedulers.io()).subscribe(new f5(new g(this)), new g5(h.f12221a));
    }
}
