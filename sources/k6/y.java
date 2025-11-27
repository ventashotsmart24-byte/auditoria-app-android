package k6;

import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.n;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class y implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18190a;

    /* renamed from: b  reason: collision with root package name */
    public final n f18191b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f18192a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18193b;

        /* renamed from: k6.y$a$a  reason: collision with other inner class name */
        public static final class C0254a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18194a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0254a(String str) {
                super(1);
                this.f18194a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.f12639a.d(this.f18194a));
            }
        }

        public a(y yVar, String str) {
            this.f18192a = yVar;
            this.f18193b = str;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18192a.n().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                this.f18192a.n().d(R.string.verification_invalid);
                return;
            }
            x.f12622a.w(this.f18192a.k(), new C0254a(com.mobile.brasiltv.utils.y.f12639a.c(str)));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f18192a.n().showLoading(false);
            i.c cVar = w6.i.f9510g;
            cVar.T("1");
            cVar.b0(this.f18193b);
            this.f18192a.n().B();
            if (d6.b.f6366a.r()) {
                n0.f12601a.j(this.f18192a.k(), "first_bind_email", this.f18193b);
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f18195a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18196b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18197a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18197a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.f12639a.d(this.f18197a));
            }
        }

        public b(y yVar, String str) {
            this.f18195a = yVar;
            this.f18196b = str;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18195a.n().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18195a.n().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                this.f18195a.n().d(R.string.verification_invalid);
            } else if (t9.i.b(str, "aaa100077")) {
                this.f18195a.n().j();
            } else {
                x.f12622a.w(this.f18195a.k(), new a(com.mobile.brasiltv.utils.y.f12639a.c(str)));
            }
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            if (d6.b.f6366a.a()) {
                this.f18195a.i(this.f18196b);
                return;
            }
            this.f18195a.n().showLoading(false);
            this.f18195a.n().K();
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f18198a;

        public c(y yVar) {
            this.f18198a = yVar;
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
                this.f18198a.n().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, (Object) null));
            }
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y f18199a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18200a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f18201b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ y f18202c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, y yVar) {
                super(1);
                this.f18200a = str;
                this.f18201b = str2;
                this.f18202c = yVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                String d10 = com.mobile.brasiltv.utils.y.f12639a.d(this.f18200a);
                if (t9.i.b(this.f18200a, "no_report_type")) {
                    if (t9.i.b(this.f18201b, "portal100060")) {
                        d10 = this.f18202c.k().getResources().getString(R.string.frequent_operation);
                        t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                    } else if (t9.i.b(this.f18201b, "portal400001")) {
                        d10 = this.f18202c.k().getResources().getString(R.string.account_not_suport_email);
                        t9.i.f(d10, "context.resources.getStr…account_not_suport_email)");
                    }
                } else if (t9.i.b(this.f18201b, "aaa100077")) {
                    this.f18202c.n().j();
                    return;
                }
                f1.f12517a.x(d10);
            }
        }

        public d(y yVar) {
            this.f18199a = yVar;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18199a.n().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18199a.n().showLoading(false);
            x.f12622a.w(this.f18199a.k(), new a(com.mobile.brasiltv.utils.y.f12639a.c(str), str, this.f18199a));
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            this.f18199a.n().showLoading(false);
            this.f18199a.n().i();
        }
    }

    public y(f5.c cVar, n nVar) {
        t9.i.g(cVar, f.X);
        t9.i.g(nVar, "view");
        this.f18190a = cVar;
        this.f18191b = nVar;
    }

    public void e() {
        l();
    }

    public void g() {
    }

    public final void i(String str) {
        i.c cVar = w6.i.f9510g;
        cVar.b().Q0(new BindEmailV2Bean(str, "1", "", cVar.J(), cVar.H())).compose(this.f18190a.O1()).subscribe(new a(this, str));
    }

    public void j(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verifyCode");
        if (!j1.i(str)) {
            this.f18191b.d(R.string.email_incorrect);
            return;
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().T0(new CheckVerifyCodeBean(str, "1", str2, cVar.J(), cVar.H())).compose(this.f18190a.O1()).subscribe(new b(this, str));
    }

    public final f5.c k() {
        return this.f18190a;
    }

    public final void l() {
        w6.i.f9510g.b().q1().compose(this.f18190a.O1()).subscribe(new c(this));
    }

    public String m() {
        String e10 = na.f.e(this.f18190a, "lastest_input_bind_email");
        t9.i.f(e10, "getStrings(context, Cons…LASTEST_INPUT_BIND_EMAIL)");
        return e10;
    }

    public final n n() {
        return this.f18191b;
    }

    public void o(String str) {
        t9.i.g(str, Scopes.EMAIL);
        na.f.k(this.f18190a, "lastest_input_bind_email", str);
    }

    public void p(String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (!j1.i(str)) {
            this.f18191b.d(R.string.email_incorrect);
            return;
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().j2(new EmailVerifyCodeBean(str, "1", cVar.J(), cVar.H())).compose(this.f18190a.O1()).subscribe(new d(this));
    }
}
