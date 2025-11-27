package k6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import h9.t;
import i6.d0;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.List;
import k7.f;
import ma.q;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s5.e;
import s9.l;
import t9.i;
import t9.j;

public final class m1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17938a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f17939b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f17940a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17941b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17942c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17943d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f17945f;

        /* renamed from: k6.m1$a$a  reason: collision with other inner class name */
        public static final class C0245a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0245a f17946a = new C0245a();

            public C0245a() {
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
            public final /* synthetic */ String f17947a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17947a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17947a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class c extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final c f17948a = new c();

            public c() {
                super(1);
            }

            /* renamed from: b */
            public final Intent invoke(Intent intent) {
                i.g(intent, "it");
                intent.putExtra("can_back", false);
                Intent putExtra = intent.putExtra("success_to_main", true);
                i.f(putExtra, "it.putExtra(LoginAty.SUCCESS_TO_MAIN, true)");
                return putExtra;
            }
        }

        public a(m1 m1Var, String str, String str2, String str3, String str4, String str5) {
            this.f17940a = m1Var;
            this.f17941b = str;
            this.f17942c = str2;
            this.f17943d = str3;
            this.f17944e = str4;
            this.f17945f = str5;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            String str3;
            String str4;
            String areaCode;
            String str5;
            i.g(loginResult, "t");
            UserData data = loginResult.getData();
            String str6 = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (b0.I(list)) {
                f.e("登录成功 " + loginResult, new Object[0]);
                d6.b bVar = d6.b.f6366a;
                UserData data2 = loginResult.getData();
                i.d(data2);
                bVar.H(data2);
                bVar.E(this.f17940a.l(), this.f17941b);
                f5.c l10 = this.f17940a.l();
                UserData data3 = loginResult.getData();
                i.d(data3);
                d6.b.G(bVar, l10, data3, this.f17942c, this.f17943d, (String) null, (String) null, (String) null, false, 240, (Object) null);
                String str7 = "";
                if (!TextUtils.isEmpty(this.f17941b)) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str5 = data4.getPwdTip();
                    } else {
                        str5 = null;
                    }
                    if (i.b(str5, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str6 = data5.getHasPwd();
                        }
                        if (i.b(str6, "1")) {
                            b0.c0(this.f17940a.l(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType(this.f17941b);
                            String str8 = this.f17944e;
                            if (str8 != null) {
                                str7 = str8;
                            }
                            switchAccountBean.setAreaCode(str7);
                            switchAccountBean.setUserName(this.f17942c);
                            switchAccountBean.setPassword(this.f17943d);
                            e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, this.f17945f);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                SwitchAccountBean switchAccountBean2 = new SwitchAccountBean();
                switchAccountBean2.setUserName(this.f17942c);
                switchAccountBean2.setPassword(this.f17943d);
                UserData data6 = loginResult.getData();
                if (data6 == null || (str = data6.getUserId()) == null) {
                    str = str7;
                }
                switchAccountBean2.setUserId(str);
                switchAccountBean2.setAccountType(this.f17941b);
                String str9 = this.f17944e;
                if (str9 == null) {
                    str9 = str7;
                }
                switchAccountBean2.setAreaCode(str9);
                UserData data7 = loginResult.getData();
                if (data7 == null || (str2 = data7.getVerificationToken()) == null) {
                    str2 = str7;
                }
                switchAccountBean2.setVerificationToken(str2);
                UserData data8 = loginResult.getData();
                if (data8 == null || (str3 = data8.getEmail()) == null) {
                    str3 = str7;
                }
                switchAccountBean2.setEmail(str3);
                UserData data9 = loginResult.getData();
                if (data9 == null || (str4 = data9.getMobile()) == null) {
                    str4 = str7;
                }
                switchAccountBean2.setPhone(str4);
                UserData data10 = loginResult.getData();
                if (!(data10 == null || (areaCode = data10.getAreaCode()) == null)) {
                    str7 = areaCode;
                }
                switchAccountBean2.setAreaCode(str7);
                this.f17940a.n(switchAccountBean2);
                xa.c.c().j(new CloseForcePageEvent());
                b0.c0(this.f17940a.l(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17940a.l(), C0245a.f17946a);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17940a.l().Q1()).show();
                return;
            }
            x.f12622a.w(this.f17940a.l(), new b(str));
            b0.d0(this.f17940a.l(), LoginAty.class, c.f17948a);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f17949a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m1 m1Var) {
            super(1);
            this.f17949a = m1Var;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f17950a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(m1 m1Var) {
            super(1);
            this.f17950a = m1Var;
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public m1(f5.c cVar, d0 d0Var) {
        i.g(cVar, "activity");
        i.g(d0Var, "view");
        this.f17938a = cVar;
        this.f17939b = d0Var;
    }

    public static final void o(m1 m1Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        i.g(m1Var, "this$0");
        i.g(switchAccountBean, "$account");
        i.g(observableEmitter, "it");
        Context applicationContext = m1Var.f17938a.getApplicationContext();
        i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void p(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void q(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public final f5.c l() {
        return this.f17938a;
    }

    public void m(String str, String str2, String str3, String str4, String str5, boolean z10) {
        String str6 = str;
        i.g(str, "userName");
        i.g(str2, "password");
        i.g(str3, "accountTypes");
        String str7 = str;
        String str8 = str2;
        w6.i.X1(w6.i.f9510g.b(), str3, str4, str7, str8, str5, (String) null, (String) null, 64, (Object) null).compose(this.f17938a.O1()).subscribe(new a(this, str3, str7, str8, str4, str5));
    }

    public final void n(SwitchAccountBean switchAccountBean) {
        Observable.create(new j1(this, switchAccountBean)).compose(q.b()).subscribe(new k1(new b(this)), new l1(new c(this)));
    }
}
