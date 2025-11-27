package k6;

import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.h0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.c0;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class i1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17827a;

    /* renamed from: b  reason: collision with root package name */
    public c0 f17828b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i1 f17829a;

        /* renamed from: k6.i1$a$a  reason: collision with other inner class name */
        public static final class C0243a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17830a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0243a(String str) {
                super(1);
                this.f17830a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17830a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(i1 i1Var) {
            this.f17829a = i1Var;
        }

        /* renamed from: f */
        public void onNext(AreaCodeResult areaCodeResult) {
            String str;
            i.g(areaCodeResult, "t");
            AreaCodeData data = areaCodeResult.getData();
            if (data == null || (str = data.getAreaCode()) == null) {
                str = "";
            }
            c0 n10 = this.f17829a.n();
            String a10 = h0.a(this.f17829a.l(), str);
            i.f(a10, "getCountryByCode(context, areaCode)");
            n10.v(str, a10);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            x.f12622a.w(this.f17829a.l(), new C0243a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i1 f17831a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17832b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17833a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17833a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f17833a));
            }
        }

        public b(i1 i1Var, String str) {
            this.f17831a = i1Var;
            this.f17832b = str;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17831a.n().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                this.f17831a.n().d(R.string.verification_invalid);
                return;
            }
            x.f12622a.w(this.f17831a.l(), new a(y.f12639a.c(str)));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f17831a.n().showLoading(false);
            i.c cVar = w6.i.f9510g;
            cVar.T("1");
            cVar.b0(this.f17832b);
            this.f17831a.n().B();
            if (d6.b.f6366a.r()) {
                n0.f12601a.j(this.f17831a.l(), "first_bind_email", this.f17832b);
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i1 f17834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17835b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17836a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17836a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f17836a));
            }
        }

        public c(i1 i1Var, String str) {
            this.f17834a = i1Var;
            this.f17835b = str;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17834a.n().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17834a.n().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                this.f17834a.n().d(R.string.verification_invalid);
                return;
            }
            x.f12622a.w(this.f17834a.l(), new a(y.f12639a.c(str)));
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            if (d6.b.f6366a.a()) {
                this.f17834a.j(this.f17835b);
                return;
            }
            this.f17834a.n().showLoading(false);
            this.f17834a.n().K();
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i1 f17837a;

        public d(i1 i1Var) {
            this.f17837a = i1Var;
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }

        public void onNext(GetEmailSuffixResult getEmailSuffixResult) {
            t9.i.g(getEmailSuffixResult, "t");
            super.onNext(getEmailSuffixResult);
            GetEmailSuffix data = getEmailSuffixResult.getData();
            if (b0.K(data != null ? data.getEmailSuffixStr() : null)) {
                GetEmailSuffix data2 = getEmailSuffixResult.getData();
                t9.i.d(data2);
                String emailSuffixStr = data2.getEmailSuffixStr();
                t9.i.d(emailSuffixStr);
                this.f17837a.n().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, (Object) null));
            }
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i1 f17838a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17839a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f17840b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ i1 f17841c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, i1 i1Var) {
                super(1);
                this.f17839a = str;
                this.f17840b = str2;
                this.f17841c = i1Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                String d10 = y.f12639a.d(this.f17839a);
                if (t9.i.b(this.f17839a, "no_report_type")) {
                    if (t9.i.b(this.f17840b, "portal100060")) {
                        d10 = this.f17841c.l().getResources().getString(R.string.frequent_operation);
                        t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                    } else if (t9.i.b(this.f17840b, "portal400001")) {
                        d10 = this.f17841c.l().getResources().getString(R.string.account_not_suport_email);
                        t9.i.f(d10, "context.resources.getStr…account_not_suport_email)");
                    }
                }
                f1.f12517a.x(d10);
            }
        }

        public e(i1 i1Var) {
            this.f17838a = i1Var;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17838a.n().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17838a.n().showLoading(false);
            x.f12622a.w(this.f17838a.l(), new a(y.f12639a.c(str), str, this.f17838a));
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            this.f17838a.n().showLoading(false);
            this.f17838a.n().i();
        }
    }

    public i1(f5.c cVar, c0 c0Var) {
        t9.i.g(cVar, f.X);
        t9.i.g(c0Var, "view");
        this.f17827a = cVar;
        this.f17828b = c0Var;
    }

    public void e() {
        m();
    }

    public void g() {
    }

    public void i() {
        w6.i.f9510g.b().O0().compose(this.f17827a.O1()).subscribe(new a(this));
    }

    public final void j(String str) {
        i.c cVar = w6.i.f9510g;
        cVar.b().Q0(new BindEmailV2Bean(str, "1", "", cVar.J(), cVar.H())).compose(this.f17827a.O1()).subscribe(new b(this, str));
    }

    public void k(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verifyCode");
        if (!j1.i(str)) {
            this.f17828b.d(R.string.email_incorrect);
            return;
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().T0(new CheckVerifyCodeBean(str, "1", str2, cVar.J(), cVar.H())).compose(this.f17827a.O1()).subscribe(new c(this, str));
    }

    public final f5.c l() {
        return this.f17827a;
    }

    public final void m() {
        w6.i.f9510g.b().q1().compose(this.f17827a.O1()).subscribe(new d(this));
    }

    public final c0 n() {
        return this.f17828b;
    }

    public void o(String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (!j1.i(str)) {
            this.f17828b.d(R.string.email_incorrect);
            return;
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().j2(new EmailVerifyCodeBean(str, "1", cVar.J(), cVar.H())).compose(this.f17827a.O1()).subscribe(new e(this));
    }
}
