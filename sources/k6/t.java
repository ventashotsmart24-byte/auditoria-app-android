package k6;

import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.umeng.message.common.inter.ITagManager;
import i6.k;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mobile.com.requestframe.utils.bean.ChangeBindEmailBean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class t implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f18085a;

    /* renamed from: b  reason: collision with root package name */
    public final k f18086b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f18087a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18088b;

        /* renamed from: k6.t$a$a  reason: collision with other inner class name */
        public static final class C0248a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18089a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0248a(String str) {
                super(1);
                this.f18089a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f18089a));
            }
        }

        public a(t tVar, String str) {
            this.f18087a = tVar;
            this.f18088b = str;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18087a.q().showLoading(false);
            x.f12622a.w(this.f18087a.o(), new C0248a(y.f12639a.c(str)));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f18087a.q().showLoading(false);
            i.c cVar = w6.i.f9510g;
            String m10 = cVar.m();
            cVar.b0(this.f18088b);
            this.f18087a.s(m10, this.f18088b);
            if (d6.b.f6366a.r()) {
                n0.f12601a.j(this.f18087a.o(), "first_bind_email", this.f18088b);
            }
            this.f18087a.q().b2();
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f18090a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18091b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18092c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18093a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18093a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f18093a));
            }
        }

        public b(t tVar, String str, String str2) {
            this.f18090a = tVar;
            this.f18091b = str;
            this.f18092c = str2;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18090a.q().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18090a.q().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                this.f18090a.q().d(R.string.verification_invalid);
            } else if (t9.i.b(str, "aaa100077")) {
                this.f18090a.q().j();
            } else {
                x.f12622a.w(this.f18090a.o(), new a(y.f12639a.c(str)));
            }
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            this.f18090a.m(this.f18091b, this.f18092c);
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f18094a;

        public c(t tVar) {
            this.f18094a = tVar;
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
                this.f18094a.q().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, (Object) null));
            }
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f18095a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18096a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f18097b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ t f18098c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, t tVar) {
                super(1);
                this.f18096a = str;
                this.f18097b = str2;
                this.f18098c = tVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                String d10 = y.f12639a.d(this.f18096a);
                if (t9.i.b(this.f18096a, "no_report_type")) {
                    if (t9.i.b(this.f18097b, "portal100060")) {
                        d10 = this.f18098c.o().getResources().getString(R.string.frequent_operation);
                        t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                    } else if (t9.i.b(this.f18097b, "portal400001")) {
                        d10 = this.f18098c.o().getResources().getString(R.string.account_not_suport_email);
                        t9.i.f(d10, "context.resources.getStr…account_not_suport_email)");
                    }
                } else if (t9.i.b(this.f18097b, "aaa100077")) {
                    this.f18098c.q().j();
                    return;
                }
                f1.f12517a.x(d10);
            }
        }

        public d(t tVar) {
            this.f18095a = tVar;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18095a.q().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18095a.q().showLoading(false);
            x.f12622a.w(this.f18095a.o(), new a(y.f12639a.c(str), str, this.f18095a));
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            this.f18095a.q().showLoading(false);
            this.f18095a.q().i();
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f18099a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(1);
            this.f18099a = str;
        }

        /* renamed from: b */
        public final Boolean invoke(String str) {
            t9.i.g(str, "it");
            return Boolean.valueOf(App.f6050e.a().i().updateAccountEmail(w6.i.f9510g.H(), str, this.f18099a));
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18100a = new f();

        public f() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Boolean bool) {
            StringBuilder sb = new StringBuilder();
            sb.append("update switch account ");
            String str = "success";
            t9.i.f(bool, str);
            if (!bool.booleanValue()) {
                str = ITagManager.FAIL;
            }
            sb.append(str);
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f18101a = new g();

        public g() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public t(f5.c cVar, k kVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(kVar, "view");
        this.f18085a = cVar;
        this.f18086b = kVar;
    }

    public static final Boolean t(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Boolean) lVar.invoke(obj);
    }

    public static final void u(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void v(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
        p();
    }

    public void g() {
    }

    public final void m(String str, String str2) {
        i.c cVar = w6.i.f9510g;
        cVar.b().S0(new ChangeBindEmailBean(str, "2", str2, cVar.J(), cVar.H())).compose(this.f18085a.O1()).subscribe(new a(this, str));
    }

    public void n(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verifyCode");
        if (!j1.i(str)) {
            this.f18086b.d(R.string.email_incorrect);
            return;
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().T0(new CheckVerifyCodeBean(str, "2", str2, cVar.J(), cVar.H())).compose(this.f18085a.O1()).subscribe(new b(this, str, str2));
    }

    public final f5.c o() {
        return this.f18085a;
    }

    public final void p() {
        w6.i.f9510g.b().q1().compose(this.f18085a.O1()).subscribe(new c(this));
    }

    public final k q() {
        return this.f18086b;
    }

    public void r(String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (!j1.i(str)) {
            this.f18086b.d(R.string.email_incorrect);
            return;
        }
        i.c cVar = w6.i.f9510g;
        cVar.b().j2(new EmailVerifyCodeBean(str, "2", cVar.J(), cVar.H())).compose(this.f18085a.O1()).subscribe(new d(this));
    }

    public final void s(String str, String str2) {
        Observable.just(str).map(new q(new e(str2))).subscribeOn(Schedulers.io()).subscribe(new r(f.f18100a), new s(g.f18101a));
    }
}
