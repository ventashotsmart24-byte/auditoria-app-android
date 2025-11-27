package k6;

import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.y;
import i6.z;
import io.reactivex.disposables.Disposable;
import java.util.List;
import ma.m;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.GetFavoriteDate;
import mobile.com.requestframe.utils.response.GetFavoriteResult;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import s9.l;
import t9.i;
import t9.j;

public final class g1 implements y {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17715a;

    /* renamed from: b  reason: collision with root package name */
    public final z f17716b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f17717c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f17718d;

    /* renamed from: e  reason: collision with root package name */
    public List f17719e;

    /* renamed from: f  reason: collision with root package name */
    public List f17720f;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g1 f17721a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17722b;

        /* renamed from: k6.g1$a$a  reason: collision with other inner class name */
        public static final class C0242a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17723a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0242a(String str) {
                super(1);
                this.f17723a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17723a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(g1 g1Var, String str) {
            this.f17721a = g1Var;
            this.f17722b = str;
        }

        /* renamed from: f */
        public void onNext(PwdCheckResult pwdCheckResult) {
            i.g(pwdCheckResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = m.e(this.f17722b);
            i.f(e10, "md5(password)");
            memberInfo.putPassword(e10, false);
            this.f17721a.o().y(false);
            this.f17721a.o().I();
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17721a.o().y(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17721a.o().y(false);
            if (b0.T(str, "aaa100012")) {
                f1.f12517a.w(R.string.pwd_wrong);
            } else if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                f1.f12517a.w(R.string.pi_connect_timeout);
            } else {
                x.f12622a.w(this.f17721a.l(), new C0242a(str));
            }
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17724a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final GetFavoriteDate invoke(GetFavoriteResult getFavoriteResult) {
            i.g(getFavoriteResult, "it");
            return getFavoriteResult.getData();
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g1 f17726b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17727a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17727a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17727a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(boolean z10, g1 g1Var) {
            this.f17725a = z10;
            this.f17726b = g1Var;
        }

        /* renamed from: f */
        public void onNext(GetFavoriteDate getFavoriteDate) {
            i.g(getFavoriteDate, "t");
            if (this.f17725a) {
                this.f17726b.q(getFavoriteDate.getFavoriteList());
            } else {
                this.f17726b.r(getFavoriteDate.getFavoriteList());
            }
            if (b0.I(getFavoriteDate.getFavoriteList())) {
                z o10 = this.f17726b.o();
                List<Favorite> favoriteList = getFavoriteDate.getFavoriteList();
                i.d(favoriteList);
                o10.H0(favoriteList, this.f17725a);
                return;
            }
            this.f17726b.o().a0(this.f17725a);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            if (this.f17725a) {
                this.f17726b.f17718d = disposable;
            } else {
                this.f17726b.f17717c = disposable;
            }
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17726b.o().e1(str, this.f17725a);
            x.f12622a.w(this.f17726b.l(), new a(str));
        }
    }

    public g1(f5.c cVar, z zVar) {
        i.g(cVar, f.X);
        i.g(zVar, "view");
        this.f17715a = cVar;
        this.f17716b = zVar;
    }

    public static final GetFavoriteDate p(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (GetFavoriteDate) lVar.invoke(obj);
    }

    public void d(boolean z10) {
        boolean z11;
        String str;
        Disposable disposable;
        Disposable disposable2;
        Disposable disposable3 = this.f17717c;
        boolean z12 = true;
        if (disposable3 == null || disposable3.isDisposed()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && (disposable2 = this.f17717c) != null) {
            disposable2.dispose();
        }
        Disposable disposable4 = this.f17718d;
        if (disposable4 == null || disposable4.isDisposed()) {
            z12 = false;
        }
        if (z12 && (disposable = this.f17718d) != null) {
            disposable.dispose();
        }
        if (z10) {
            str = "1";
        } else {
            str = "0";
        }
        w6.i.f9510g.b().u1("vod", str).compose(this.f17715a.O1()).map(new f1(b.f17724a)).subscribe(new c(z10, this));
    }

    public void e() {
        boolean z10;
        if (w6.i.f9510g.I().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            y.a.a(this, false, 1, (Object) null);
        }
    }

    public void g() {
    }

    public void k(String str) {
        i.g(str, "password");
        w6.i b10 = w6.i.f9510g.b();
        String e10 = m.e(str);
        i.f(e10, "md5(password)");
        b10.d2(e10).compose(this.f17715a.O1()).subscribe(new a(this, str));
    }

    public final f5.c l() {
        return this.f17715a;
    }

    public final List m() {
        return this.f17720f;
    }

    public final List n() {
        return this.f17719e;
    }

    public final z o() {
        return this.f17716b;
    }

    public final void q(List list) {
        this.f17720f = list;
    }

    public final void r(List list) {
        this.f17719e = list;
    }
}
