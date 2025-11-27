package k6;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import i6.r0;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.EmailResetPwdResult;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

public final class u3 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f18111a;

    /* renamed from: b  reason: collision with root package name */
    public final r0 f18112b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u3 f18113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18115c;

        /* renamed from: k6.u3$a$a  reason: collision with other inner class name */
        public static final class C0249a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18116a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ u3 f18117b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0249a(String str, u3 u3Var) {
                super(1);
                this.f18116a = str;
                this.f18117b = u3Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f18116a, (String) null, (String) null, 6, (Object) null);
                if (i.b(yVar.c(this.f18116a), "no_report_type") && i.b(this.f18116a, "portal100060")) {
                    p10 = this.f18117b.i().getResources().getString(R.string.frequent_operation);
                    i.f(p10, "context.resources.getStr…tring.frequent_operation)");
                }
                f1.f12517a.x(p10);
            }
        }

        public a(u3 u3Var, int i10, String str) {
            this.f18113a = u3Var;
            this.f18114b = i10;
            this.f18115c = str;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18113a.j().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18113a.j().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                String string = this.f18113a.i().getResources().getString(R.string.verification_invalid);
                i.f(string, "context.resources.getStr…ing.verification_invalid)");
                f1.f12517a.x(string);
                return;
            }
            if (TextUtils.equals("aaa100077", str)) {
                this.f18113a.j().j();
            }
            x.f12622a.w(this.f18113a.i(), new C0249a(str, this.f18113a));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            b0.U(this, "绑定或者换绑邮箱成功 type：" + this.f18114b);
            this.f18113a.j().showLoading(false);
            this.f18113a.j().g2();
            if (d6.b.f6366a.r()) {
                n0.f12601a.j(this.f18113a.i(), "first_bind_email", this.f18115c);
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u3 f18118a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18119a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18119a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18119a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(u3 u3Var) {
            this.f18118a = u3Var;
        }

        /* renamed from: f */
        public void onNext(EmailResetPwdResult emailResetPwdResult) {
            i.g(emailResetPwdResult, "t");
            b0.U(this, "忘记密码发送重置邮件成功");
            this.f18118a.j().showLoading(false);
            this.f18118a.j().g2();
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18118a.j().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18118a.j().showLoading(false);
            b0.U(this, "忘记密码发送重置邮件失败 returnCode:" + str);
            x.f12622a.w(this.f18118a.i(), new a(str));
        }
    }

    public u3(c cVar, r0 r0Var) {
        i.g(cVar, f.X);
        i.g(r0Var, "view");
        this.f18111a = cVar;
        this.f18112b = r0Var;
    }

    public void e() {
    }

    public void g() {
    }

    public void h(String str, int i10) {
        i.g(str, Scopes.EMAIL);
        i.c cVar = w6.i.f9510g;
        w6.i b10 = cVar.b();
        b10.Q0(new BindEmailV2Bean(str, "" + i10, "", cVar.J(), cVar.H())).compose(this.f18111a.O1()).subscribe(new a(this, i10, str));
    }

    public final c i() {
        return this.f18111a;
    }

    public final r0 j() {
        return this.f18112b;
    }

    public void k(String str) {
        t9.i.g(str, Scopes.EMAIL);
        w6.i.f9510g.b().Z0(str).compose(this.f18111a.O1()).subscribe(new b(this));
    }
}
