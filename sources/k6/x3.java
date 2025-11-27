package k6;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import i6.u0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import ma.m;
import mobile.com.requestframe.utils.bean.ResetPwdEmailBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s5.e;
import s9.l;
import t9.i;
import t9.j;

public final class x3 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f18176a;

    /* renamed from: b  reason: collision with root package name */
    public final u0 f18177b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f18178c;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x3 f18179a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18180b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18181c;

        /* renamed from: k6.x3$a$a  reason: collision with other inner class name */
        public static final class C0253a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0253a f18182a = new C0253a();

            public C0253a() {
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

        public a(x3 x3Var, String str, String str2) {
            this.f18179a = x3Var;
            this.f18180b = str;
            this.f18181c = str2;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            i.g(loginResult, "t");
            this.f18179a.j().showLoading(false);
            UserData data = loginResult.getData();
            String str2 = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (b0.I(list)) {
                d6.b bVar = d6.b.f6366a;
                UserData data2 = loginResult.getData();
                i.d(data2);
                bVar.H(data2);
                bVar.E(this.f18179a.i(), "2");
                c i10 = this.f18179a.i();
                UserData data3 = loginResult.getData();
                i.d(data3);
                d6.b.G(bVar, i10, data3, this.f18180b, this.f18181c, (String) null, (String) null, (String) null, false, 240, (Object) null);
                xa.c.c().j(new CloseForcePageEvent());
                if (!TextUtils.isEmpty("2")) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str = data4.getPwdTip();
                    } else {
                        str = null;
                    }
                    if (i.b(str, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str2 = data5.getHasPwd();
                        }
                        if (i.b(str2, "1")) {
                            b0.c0(this.f18179a.i(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType("2");
                            switchAccountBean.setUserName(this.f18180b);
                            switchAccountBean.setPassword(this.f18181c);
                            e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
            } else {
                x.f12622a.w(this.f18179a.i(), C0253a.f18182a);
            }
            this.f18179a.j().j1(true);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18179a.f18178c = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            b0.U(this, "login fail: " + str);
            this.f18179a.j().showLoading(false);
            if (i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f18179a.i()).show();
                this.f18179a.j().x();
                return;
            }
            this.f18179a.j().j1(false);
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x3 f18183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18184b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f18185c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18186d;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18187a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f18188b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ x3 f18189c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, x3 x3Var) {
                super(1);
                this.f18187a = str;
                this.f18188b = str2;
                this.f18189c = x3Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                String d10 = y.f12639a.d(this.f18187a);
                if (b0.T(this.f18188b, "portal100072") || b0.T(this.f18188b, "portal100073")) {
                    d10 = this.f18189c.i().getString(R.string.verification_invalid);
                    i.f(d10, "context.getString(R.string.verification_invalid)");
                }
                f1.f12517a.x(d10);
            }
        }

        public b(x3 x3Var, String str, boolean z10, String str2) {
            this.f18183a = x3Var;
            this.f18184b = str;
            this.f18185c = z10;
            this.f18186d = str2;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18183a.j().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18183a.j().showLoading(false);
            x.f12622a.w(this.f18183a.i(), new a(y.f12639a.c(str), str, this.f18183a));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String str = this.f18184b;
            i.f(str, "password");
            memberInfo.putPassword(str, false);
            if (this.f18185c) {
                this.f18183a.k(this.f18186d, memberInfo.getLastPassword());
                return;
            }
            this.f18183a.j().showLoading(false);
            this.f18183a.j().j1(true);
        }
    }

    public x3(c cVar, u0 u0Var) {
        i.g(cVar, f.X);
        i.g(u0Var, "view");
        this.f18176a = cVar;
        this.f18177b = u0Var;
    }

    public void e() {
    }

    public void g() {
    }

    public final c i() {
        return this.f18176a;
    }

    public final u0 j() {
        return this.f18177b;
    }

    public final void k(String str, String str2) {
        Disposable disposable;
        i.g(str, "userName");
        i.g(str2, "password");
        Disposable disposable2 = this.f18178c;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f18178c) != null) {
            disposable.dispose();
        }
        w6.i.X1(w6.i.f9510g.b(), "2", "", str, str2, "", (String) null, (String) null, 64, (Object) null).compose(this.f18176a.O1()).subscribe(new a(this, str, str2));
    }

    public void l(String str, String str2, String str3, String str4, boolean z10) {
        i.g(str, Scopes.EMAIL);
        i.g(str2, "pwd");
        i.g(str3, "repeatPwd");
        i.g(str4, "verifyCode");
        if (!j1.g(str2)) {
            this.f18177b.d(R.string.password_format_error_tips);
        } else if (!j1.g(str3)) {
            this.f18177b.d(R.string.password_error_tips);
        } else if (!b0.T(str2, str3)) {
            this.f18177b.d(R.string.not_match_password);
        } else {
            String e10 = m.e(str2);
            w6.i b10 = w6.i.f9510g.b();
            i.f(e10, "password");
            b10.h2(new ResetPwdEmailBean(str, e10, "3", str4)).compose(this.f18176a.O1()).subscribe(new b(this, e10, z10, str));
        }
    }
}
