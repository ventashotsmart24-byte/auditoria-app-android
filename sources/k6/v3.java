package k6;

import android.text.TextUtils;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i6.s0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import mobile.com.requestframe.utils.response.BindPhoneResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import na.f;
import s5.e;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

public final class v3 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public f5.c f18127a;

    /* renamed from: b  reason: collision with root package name */
    public s0 f18128b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f18129c;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v3 f18130a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18131b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18132c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18133d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18134e;

        /* renamed from: k6.v3$a$a  reason: collision with other inner class name */
        public static final class C0250a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18135a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0250a(String str) {
                super(1);
                this.f18135a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18135a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(v3 v3Var, String str, String str2, String str3, String str4) {
            this.f18130a = v3Var;
            this.f18131b = str;
            this.f18132c = str2;
            this.f18133d = str3;
            this.f18134e = str4;
        }

        /* renamed from: f */
        public void onNext(BindPhoneResult bindPhoneResult) {
            i.g(bindPhoneResult, "t");
            this.f18130a.k().showLoading(false);
            i.c cVar = w6.i.f9510g;
            cVar.j0(this.f18131b);
            cVar.A0(this.f18132c);
            cVar.R(this.f18133d);
            cVar.n0(this.f18134e);
            f.k(this.f18130a.j(), "login_area_code", cVar.f());
            MemberInfo.INSTANCE.putPassword(this.f18134e, false);
            this.f18130a.k().H();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18130a.k().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18130a.k().showLoading(false);
            this.f18130a.k().o(str);
            x.f12622a.w(this.f18130a.j(), new C0250a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v3 f18136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18138c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18139d;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f18140a = new a();

            public a() {
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

        public b(v3 v3Var, String str, String str2, String str3) {
            this.f18136a = v3Var;
            this.f18137b = str;
            this.f18138c = str2;
            this.f18139d = str3;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            t9.i.g(loginResult, "t");
            this.f18136a.k().showLoading(false);
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
                t9.i.d(data2);
                bVar.H(data2);
                bVar.E(this.f18136a.j(), "3");
                f5.c j10 = this.f18136a.j();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, j10, data3, this.f18137b, this.f18138c, (String) null, (String) null, (String) null, false, 240, (Object) null);
                if (!TextUtils.isEmpty("3")) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str = data4.getPwdTip();
                    } else {
                        str = null;
                    }
                    if (t9.i.b(str, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str2 = data5.getHasPwd();
                        }
                        if (t9.i.b(str2, "1")) {
                            b0.c0(this.f18136a.j(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType("3");
                            switchAccountBean.setUserName(this.f18137b);
                            switchAccountBean.setPassword(this.f18138c);
                            switchAccountBean.setAreaCode(this.f18139d);
                            switchAccountBean.setPhone(this.f18137b);
                            e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
            } else {
                x.f12622a.w(this.f18136a.j(), a.f18140a);
            }
            this.f18136a.k().w0(true);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18136a.f18129c = disposable;
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "login fail: " + str);
            this.f18136a.k().showLoading(false);
            if (t9.i.b("aaa100094", str)) {
                SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                switchAccountBean.setAccountType("3");
                switchAccountBean.setUserName(this.f18137b);
                switchAccountBean.setPassword(this.f18138c);
                switchAccountBean.setAreaCode(this.f18139d);
                switchAccountBean.setPhone(this.f18137b);
                e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
                this.f18136a.k().x();
                return;
            }
            this.f18136a.k().w0(false);
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v3 f18141a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18142b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18143c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18144d;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w f18145a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(w wVar) {
                super(1);
                this.f18145a = wVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d((String) this.f18145a.f19600a));
            }
        }

        public c(v3 v3Var, String str, String str2, String str3) {
            this.f18141a = v3Var;
            this.f18142b = str;
            this.f18143c = str2;
            this.f18144d = str3;
        }

        /* renamed from: f */
        public void onNext(CheckVerificationResult checkVerificationResult) {
            t9.i.g(checkVerificationResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            memberInfo.putPassword(this.f18142b, false);
            this.f18141a.l(this.f18143c, memberInfo.getLastPassword(), this.f18144d);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18141a.k().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18141a.k().showLoading(false);
            this.f18141a.k().o(str);
            w wVar = new w();
            wVar.f19600a = y.f12639a.c(str);
            x.f12622a.w(this.f18141a.j(), new a(wVar));
        }
    }

    public v3(f5.c cVar, s0 s0Var) {
        t9.i.g(cVar, "activity");
        t9.i.g(s0Var, "view");
        this.f18127a = cVar;
        this.f18128b = s0Var;
    }

    public void e() {
    }

    public void g() {
    }

    public void i(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "pwd");
        w6.i.f9510g.b().c2(str, str2, str3, str4).compose(this.f18127a.O1()).subscribe(new a(this, str, str3, str2, str4));
    }

    public final f5.c j() {
        return this.f18127a;
    }

    public final s0 k() {
        return this.f18128b;
    }

    public final void l(String str, String str2, String str3) {
        Disposable disposable;
        t9.i.g(str, "phone");
        t9.i.g(str2, "password");
        t9.i.g(str3, "areaCode");
        Disposable disposable2 = this.f18129c;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f18129c) != null) {
            disposable.dispose();
        }
        w6.i.X1(w6.i.f9510g.b(), "3", str3, str, str2, (String) null, "1", (String) null, 64, (Object) null).compose(this.f18127a.O1()).subscribe(new b(this, str, str2, str3));
    }

    public void m(String str, String str2, String str3, String str4, String str5) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "type");
        t9.i.g(str5, "pwd");
        w6.i.f9510g.b().k2(str, str2, str3, str4, str5).compose(this.f18127a.O1()).subscribe(new c(this, str5, str, str2));
    }
}
