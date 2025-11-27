package k6;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.p0;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.x0;
import i6.y0;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import t9.j;

public final class k4 implements x0 {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17912a;

    /* renamed from: b  reason: collision with root package name */
    public final y0 f17913b;

    /* renamed from: c  reason: collision with root package name */
    public final String f17914c = "SplashPresenter";

    /* renamed from: d  reason: collision with root package name */
    public boolean f17915d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f17916e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f17917f = "";

    /* renamed from: g  reason: collision with root package name */
    public Disposable f17918g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17919h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f17920i;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k4 f17921a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k4 k4Var) {
            super(1);
            this.f17921a = k4Var;
        }

        public final void b(Void voidR) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Void) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17922a = new b();

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

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k4 f17923a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k4 f17924a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(k4 k4Var) {
                super(1);
                this.f17924a = k4Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return t.f17319a;
            }

            public final void invoke(Boolean bool) {
                i.f(bool, "granted");
                if (bool.booleanValue()) {
                    this.f17924a.z().B0();
                    this.f17924a.F();
                    return;
                }
                this.f17924a.z().V(new String[]{"android.permission.READ_MEDIA_IMAGES"});
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(k4 k4Var) {
            super(1);
            this.f17923a = k4Var;
        }

        public static final void c(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            this.f17923a.M(bool);
            this.f17923a.N(false);
            i.f(bool, "readFinished");
            if (bool.booleanValue()) {
                this.f17923a.z().B0();
                this.f17923a.A();
                return;
            }
            new c8.b(this.f17923a.x()).o("android.permission.READ_MEDIA_IMAGES").subscribe(new l4(new a(this.f17923a)));
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f17925a = new d();

        public d() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k4 f17926a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f17927b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(k4 k4Var, String[] strArr) {
            super(1);
            this.f17926a = k4Var;
            this.f17927b = strArr;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            i.f(bool, "granted");
            if (bool.booleanValue()) {
                this.f17926a.z().B0();
                this.f17926a.F();
                return;
            }
            this.f17926a.z().V(this.f17927b);
        }
    }

    public k4(f5.c cVar, y0 y0Var) {
        i.g(cVar, f.X);
        i.g(y0Var, "view");
        this.f17912a = cVar;
        this.f17913b = y0Var;
        y0Var.Y0(this);
    }

    public static final void G(k4 k4Var, ObservableEmitter observableEmitter) {
        i.g(k4Var, "this$0");
        i.g(observableEmitter, "it");
        if (i.b(k4Var.f17920i, Boolean.FALSE)) {
            com.mobile.brasiltv.utils.y0 y0Var = com.mobile.brasiltv.utils.y0.f12657a;
            f5.c cVar = k4Var.f17912a;
            i.d(cVar);
            observableEmitter.onNext(Boolean.valueOf(y0Var.F(cVar)));
        } else {
            com.mobile.brasiltv.utils.y0 y0Var2 = com.mobile.brasiltv.utils.y0.f12657a;
            f5.c cVar2 = k4Var.f17912a;
            i.d(cVar2);
            observableEmitter.onNext(Boolean.valueOf(y0Var2.G(cVar2)));
        }
        observableEmitter.onComplete();
    }

    public static final void H(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void I(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void K(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void s(k4 k4Var, ObservableEmitter observableEmitter) {
        i.g(k4Var, "this$0");
        i.g(observableEmitter, "it");
        com.mobile.brasiltv.utils.i iVar = com.mobile.brasiltv.utils.i.f12585a;
        if (iVar.a(k4Var.f17912a, "key_copy_ca_version", 0) != 60201) {
            String str = k4Var.f17912a.getFilesDir().getAbsolutePath() + File.separator + "cacert.pem";
            boolean a10 = z6.a.a(k4Var.f17912a, "cacert.pem", str);
            new File(str).setExecutable(true, true);
            if (a10) {
                iVar.b(k4Var.f17912a, "key_copy_ca_version", 60201);
            }
        }
    }

    public static final void t(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w(k4 k4Var) {
        i.g(k4Var, "this$0");
        k4Var.r();
    }

    public final void A() {
        AdInfo K = m.f9270a.K(this.f17912a, "picture");
        if (K != null) {
            this.f17913b.f2(K);
        } else {
            this.f17913b.A1();
        }
    }

    public void B(AdInfo adInfo) {
        i.g(adInfo, "adInfo");
        String action = adInfo.getAction();
        if (i.b(adInfo.getAction_type(), "1")) {
            boolean z10 = false;
            if (action != null && action.length() > 0) {
                z10 = true;
            }
            if (z10) {
                Disposable disposable = this.f17918g;
                if (disposable != null) {
                    disposable.dispose();
                }
                i1.e(this.f17912a, "EVENT_AD_CLICK_SPLASH");
                q qVar = q.f9311a;
                f5.c cVar = this.f17912a;
                qVar.h(cVar, d6.b.f6366a.m(cVar), a6.a.f10646a.b(), adInfo);
                b0.j0(this.f17912a, action, true, true, false, false, 24, (Object) null);
                this.f17912a.finish();
                return;
            }
        }
        if (i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            b0.m(this.f17912a);
        }
    }

    public final void C() {
        int i10 = 0;
        SharedPreferences sharedPreferences = this.f17912a.getSharedPreferences("show_introduce", 0);
        if (!sharedPreferences.getAll().isEmpty()) {
            App.a aVar = App.f6050e;
            if (aVar.a().j().h()) {
                aVar.a().j().n(false);
                Map<String, ?> all = sharedPreferences.getAll();
                i.f(all, "oldIntroSp.all");
                for (Map.Entry next : all.entrySet()) {
                    if (next.getValue() instanceof Boolean) {
                        try {
                            Object key = next.getKey();
                            i.e(key, "null cannot be cast to non-null type kotlin.String");
                            i10 = Integer.parseInt((String) key);
                        } catch (NumberFormatException e10) {
                            e10.printStackTrace();
                        }
                    }
                }
                App.f6050e.a().j().m(String.valueOf(i10));
            }
        }
    }

    public final void D() {
        if (!this.f17915d && !TextUtils.equals(this.f17916e, this.f17917f)) {
            App.f6050e.a().j().p(this.f17917f);
        }
    }

    public final void E() {
        C();
        L();
        D();
    }

    public final void F() {
        if (!i.b(this.f17920i, Boolean.TRUE) && !this.f17919h) {
            this.f17919h = true;
            Observable.create(new h4(this)).compose(p0.b()).subscribe(new i4(new c(this)), new j4(d.f17925a));
        }
    }

    public void J() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_AUDIO"};
        } else {
            strArr = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        }
        f5.c cVar = this.f17912a;
        i.d(cVar);
        new c8.b(cVar).o((String[]) Arrays.copyOf(strArr, strArr.length)).subscribe(new d4(new e(this, strArr)));
    }

    public final void L() {
        String a10 = com.mobile.brasiltv.utils.e.a(this.f17912a);
        i.f(a10, "getAppVersionCode(context)");
        this.f17917f = a10;
        App.a aVar = App.f6050e;
        this.f17915d = aVar.a().j().h();
        this.f17916e = aVar.a().j().d();
    }

    public final void M(Boolean bool) {
        this.f17920i = bool;
    }

    public final void N(boolean z10) {
        this.f17919h = z10;
    }

    public final void O() {
        this.f17912a.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        P();
        b0.c0(this.f17912a, MainAty.class);
        this.f17912a.finish();
    }

    public final void P() {
        App.f6050e.a().j().m(this.f17917f);
    }

    public void e() {
        v();
    }

    public void g() {
    }

    public final void r() {
        Observable.create(new e4(this)).subscribe(new f4(new a(this)), new g4(b.f17922a));
    }

    public final void v() {
        Uri data = this.f17912a.getIntent().getData();
        if (data == null || !TextUtils.equals("sxl", data.getScheme()) || !TextUtils.equals(s6.a.f9335a.a().h(), data.getHost()) || !MainAty.A.h()) {
            E();
            if ((this.f17915d || !TextUtils.equals(this.f17916e, this.f17917f)) && !q5.i.f19305a.j(this.f17912a)) {
                MainAty.A.q(true);
            }
            J();
            new Thread(new c4(this)).start();
            return;
        }
        b0.c0(this.f17912a, MainAty.class);
        this.f17912a.finish();
    }

    public final f5.c x() {
        return this.f17912a;
    }

    public final Boolean y() {
        return this.f17920i;
    }

    public final y0 z() {
        return this.f17913b;
    }
}
