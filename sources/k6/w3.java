package k6;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import i6.t0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import ma.m;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s5.e;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

public final class w3 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f18155a;

    /* renamed from: b  reason: collision with root package name */
    public final t0 f18156b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w3 f18157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18158b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18159c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18160d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f18161e;

        /* renamed from: k6.w3$a$a  reason: collision with other inner class name */
        public static final class C0251a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0251a f18162a = new C0251a();

            public C0251a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18163a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f18163a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18163a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(w3 w3Var, String str, String str2, String str3, boolean z10) {
            this.f18157a = w3Var;
            this.f18158b = str;
            this.f18159c = str2;
            this.f18160d = str3;
            this.f18161e = z10;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            i.g(loginResult, "t");
            this.f18157a.k().showLoading(false);
            UserData data = loginResult.getData();
            String str2 = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (b0.I(list)) {
                d6.b bVar = d6.b.f6366a;
                bVar.E(this.f18157a.j(), this.f18158b);
                c j10 = this.f18157a.j();
                UserData data2 = loginResult.getData();
                i.d(data2);
                d6.b.G(bVar, j10, data2, this.f18159c, this.f18160d, "", "", (String) null, false, 192, (Object) null);
                xa.c.c().j(new CloseForcePageEvent());
                if (!TextUtils.isEmpty(this.f18158b)) {
                    UserData data3 = loginResult.getData();
                    if (data3 != null) {
                        str = data3.getPwdTip();
                    } else {
                        str = null;
                    }
                    if (i.b(str, "yes")) {
                        UserData data4 = loginResult.getData();
                        if (data4 != null) {
                            str2 = data4.getHasPwd();
                        }
                        if (i.b(str2, "1")) {
                            b0.c0(this.f18157a.j(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType(this.f18158b);
                            switchAccountBean.setUserName(this.f18159c);
                            switchAccountBean.setPassword(this.f18160d);
                            e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                this.f18157a.k().E1(this.f18161e);
                return;
            }
            x.f12622a.w(this.f18157a.j(), C0251a.f18162a);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18157a.k().showLoading(false);
            if (i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f18157a.j()).show();
            } else {
                x.f12622a.w(this.f18157a.j(), new b(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w3 f18164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18165b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18166c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18167a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18167a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f18167a));
            }
        }

        public b(w3 w3Var, String str, String str2) {
            this.f18164a = w3Var;
            this.f18165b = str;
            this.f18166c = str2;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18164a.k().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18164a.k().showLoading(false);
            if (b0.T(str, "portal100072") || b0.T(str, "portal100073")) {
                String string = this.f18164a.j().getResources().getString(R.string.verification_invalid);
                i.f(string, "context.resources.getStr…ing.verification_invalid)");
                f1.f12517a.x(string);
                return;
            }
            x.f12622a.w(this.f18164a.j(), new a(y.f12639a.c(str)));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String str = this.f18165b;
            i.f(str, "password");
            memberInfo.putPassword(str, false);
            i.c cVar = w6.i.f9510g;
            cVar.h0("1");
            cVar.T("1");
            cVar.b0(this.f18166c);
            cVar.q0("1");
            xa.c.c().m(new UpdateRestrictEvent("1", false, 2, (g) null));
            xa.c.c().j(new CloseForceBindEvent());
            w3 w3Var = this.f18164a;
            String str2 = this.f18166c;
            String lastPassword = memberInfo.getLastPassword();
            d6.b bVar = d6.b.f6366a;
            w3Var.i(str2, lastPassword, !bVar.y());
            if (bVar.r()) {
                n0.f12601a.j(this.f18164a.j(), "first_bind_email", this.f18166c);
            }
        }
    }

    public w3(c cVar, t0 t0Var) {
        t9.i.g(cVar, f.X);
        t9.i.g(t0Var, "view");
        this.f18155a = cVar;
        this.f18156b = t0Var;
    }

    public void e() {
    }

    public void g() {
    }

    public final void i(String str, String str2, boolean z10) {
        String str3 = str;
        String str4 = str2;
        w6.i.X1(w6.i.f9510g.b(), "2", "", str3, str4, "", (String) null, (String) null, 64, (Object) null).compose(this.f18155a.O1()).subscribe(new a(this, "2", str3, str4, z10));
    }

    public final c j() {
        return this.f18155a;
    }

    public final t0 k() {
        return this.f18156b;
    }

    public void l(String str, String str2, String str3) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "pwd");
        t9.i.g(str3, "repeatPwd");
        if (!j1.g(str2)) {
            this.f18156b.d(R.string.password_format_error_tips);
        } else if (!j1.g(str3)) {
            this.f18156b.d(R.string.password_error_tips);
        } else if (!b0.T(str2, str3)) {
            this.f18156b.d(R.string.not_match_password);
        } else {
            String e10 = m.e(str2);
            i.c cVar = w6.i.f9510g;
            w6.i b10 = cVar.b();
            t9.i.f(e10, "password");
            b10.Q0(new BindEmailV2Bean(str, "1", e10, cVar.J(), cVar.H())).compose(this.f18155a.O1()).subscribe(new b(this, e10, str));
        }
    }
}
