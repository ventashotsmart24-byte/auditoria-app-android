package k6;

import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.h0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import h9.t;
import i6.k0;
import io.reactivex.disposables.Disposable;
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

public final class r2 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18038a;

    /* renamed from: b  reason: collision with root package name */
    public k0 f18039b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r2 f18040a;

        /* renamed from: k6.r2$a$a  reason: collision with other inner class name */
        public static final class C0247a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18041a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0247a(String str) {
                super(1);
                this.f18041a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18041a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(r2 r2Var) {
            this.f18040a = r2Var;
        }

        /* renamed from: f */
        public void onNext(AreaCodeResult areaCodeResult) {
            String str;
            i.g(areaCodeResult, "t");
            AreaCodeData data = areaCodeResult.getData();
            if (data == null || (str = data.getAreaCode()) == null) {
                str = "";
            }
            k0 m10 = this.f18040a.m();
            String a10 = h0.a(this.f18040a.j(), str);
            i.f(a10, "getCountryByCode(context, areaCode)");
            m10.L(str, a10);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            x.f12622a.w(this.f18040a.j(), new C0247a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r2 f18042a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18043b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18044c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18045a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18045a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f18045a));
            }
        }

        public b(r2 r2Var, String str, String str2) {
            this.f18042a = r2Var;
            this.f18043b = str;
            this.f18044c = str2;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18042a.m().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18042a.m().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                this.f18042a.m().u(R.string.verification_invalid);
                return;
            }
            x.f12622a.w(this.f18042a.j(), new a(y.f12639a.c(str)));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f18042a.m().showLoading(false);
            this.f18042a.m().W1(this.f18043b, this.f18044c);
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r2 f18046a;

        public c(r2 r2Var) {
            this.f18046a = r2Var;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
        }

        public void onNext(GetEmailSuffixResult getEmailSuffixResult) {
            i.g(getEmailSuffixResult, "t");
            super.onNext(getEmailSuffixResult);
            GetEmailSuffix data = getEmailSuffixResult.getData();
            if (b0.K(data != null ? data.getEmailSuffixStr() : null)) {
                GetEmailSuffix data2 = getEmailSuffixResult.getData();
                i.d(data2);
                String emailSuffixStr = data2.getEmailSuffixStr();
                i.d(emailSuffixStr);
                this.f18046a.m().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, (Object) null));
            }
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r2 f18047a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18048a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18048a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f18048a));
            }
        }

        public d(r2 r2Var) {
            this.f18047a = r2Var;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18047a.m().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18047a.m().showLoading(false);
            String c10 = y.f12639a.c(str);
            this.f18047a.m().j2();
            if (i.b(c10, "no_report_type")) {
                if (i.b(str, "portal100060")) {
                    this.f18047a.m().u(R.string.frequent_operation);
                    return;
                } else if (i.b(str, "portal400001")) {
                    k0 m10 = this.f18047a.m();
                    String string = this.f18047a.j().getResources().getString(R.string.account_not_suport_email);
                    i.f(string, "context.resources.getStr…account_not_suport_email)");
                    m10.o(string);
                    return;
                }
            }
            x.f12622a.w(this.f18047a.j(), new a(c10));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f18047a.m().showLoading(false);
            this.f18047a.m().A0();
        }
    }

    public r2(f5.c cVar, k0 k0Var) {
        i.g(cVar, f.X);
        i.g(k0Var, "view");
        this.f18038a = cVar;
        this.f18039b = k0Var;
    }

    public void e() {
        k();
    }

    public void g() {
    }

    public void h() {
        w6.i.f9510g.b().O0().compose(this.f18038a.O1()).subscribe(new a(this));
    }

    public void i(String str, String str2) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "verificationCode");
        w6.i.f9510g.b().T0(new CheckVerifyCodeBean(str, "3", str2, (String) null, (String) null)).compose(this.f18038a.O1()).subscribe(new b(this, str, str2));
    }

    public final f5.c j() {
        return this.f18038a;
    }

    public final void k() {
        w6.i.f9510g.b().q1().compose(this.f18038a.O1()).subscribe(new c(this));
    }

    public void l(String str) {
        i.g(str, Scopes.EMAIL);
        w6.i.f9510g.b().j2(new EmailVerifyCodeBean(str, "3", (String) null, (String) null)).compose(this.f18038a.O1()).subscribe(new d(this));
    }

    public final k0 m() {
        return this.f18039b;
    }
}
