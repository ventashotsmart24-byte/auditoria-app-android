package k6;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestActiveEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import java.util.List;
import ma.m;
import ma.q;
import mobile.com.requestframe.utils.bean.BindBean;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.bean.UnbindBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.BindThirdPart;
import mobile.com.requestframe.utils.response.BindThirdPartResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserBindData;
import mobile.com.requestframe.utils.response.UserBindResult;
import mobile.com.requestframe.utils.response.UserData;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

public final class f implements i6.d {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17685a;

    /* renamed from: b  reason: collision with root package name */
    public final i6.e f17686b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17687a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17688b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x7.a f17689c;

        /* renamed from: k6.f$a$a  reason: collision with other inner class name */
        public static final class C0240a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0240a f17690a = new C0240a();

            public C0240a() {
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
            public final /* synthetic */ String f17691a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17691a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17691a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(f fVar, String str, x7.a aVar) {
            this.f17687a = fVar;
            this.f17688b = str;
            this.f17689c = aVar;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String areaCode;
            String str6;
            String str7;
            i.g(loginResult, "t");
            this.f17687a.q().showLoading(false);
            this.f17687a.q().q();
            UserData data = loginResult.getData();
            String str8 = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (b0.I(list)) {
                i.c cVar = w6.i.f9510g;
                String str9 = "";
                if (!t9.i.b(cVar.A(), str9)) {
                    UserData data2 = loginResult.getData();
                    t9.i.d(data2);
                    if (!t9.i.b(data2.getRestrictedStatus(), cVar.A())) {
                        xa.c c10 = xa.c.c();
                        UserData data3 = loginResult.getData();
                        t9.i.d(data3);
                        c10.m(new UpdateRestrictEvent(data3.getRestrictedStatus(), false, 2, (t9.g) null));
                    }
                }
                d6.b bVar = d6.b.f6366a;
                bVar.E(this.f17687a.p(), this.f17688b);
                f5.c p10 = this.f17687a.p();
                UserData data4 = loginResult.getData();
                t9.i.d(data4);
                d6.b.G(bVar, p10, data4, "", "", this.f17688b, this.f17689c.a(), (String) null, false, 192, (Object) null);
                if (!TextUtils.isEmpty(this.f17688b)) {
                    UserData data5 = loginResult.getData();
                    if (data5 != null) {
                        str6 = data5.getPwdTip();
                    } else {
                        str6 = null;
                    }
                    if (t9.i.b(str6, "yes")) {
                        UserData data6 = loginResult.getData();
                        if (data6 != null) {
                            str7 = data6.getHasPwd();
                        } else {
                            str7 = null;
                        }
                        if (t9.i.b(str7, "1")) {
                            b0.c0(this.f17687a.p(), ForceChangePwdAty.class);
                            s5.e.f19464a.o(s5.c.THIRD_PART_LOGIN, this.f17688b, this.f17689c, "0", "2", (String) null);
                            return;
                        }
                    }
                }
                xa.c c11 = xa.c.c();
                UserData data7 = loginResult.getData();
                if (data7 != null) {
                    str8 = data7.getHeartBeatTime();
                }
                c11.j(new LoginSuccessEvent(str8));
                xa.c.c().j(new UserIdentityChangeEvent());
                xa.c.c().m(new UpdateMineViewEvent());
                xa.c.c().m(new RequestAuthAndSlbEvent(false, loginResult.getData()));
                SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                switchAccountBean.setAccountType("google");
                UserData data8 = loginResult.getData();
                if (data8 == null || (str = data8.getGoogleEmail()) == null) {
                    str = str9;
                }
                switchAccountBean.setUserName(str);
                UserData data9 = loginResult.getData();
                if (data9 == null || (str2 = data9.getEmail()) == null) {
                    str2 = str9;
                }
                switchAccountBean.setEmail(str2);
                UserData data10 = loginResult.getData();
                if (data10 == null || (str3 = data10.getMobile()) == null) {
                    str3 = str9;
                }
                switchAccountBean.setPhone(str3);
                UserData data11 = loginResult.getData();
                if (data11 == null || (str4 = data11.getUserId()) == null) {
                    str4 = str9;
                }
                switchAccountBean.setUserId(str4);
                UserData data12 = loginResult.getData();
                if (data12 == null || (str5 = data12.getGoogleNickName()) == null) {
                    str5 = str9;
                }
                switchAccountBean.setNickName(str5);
                switchAccountBean.setAuthCode(this.f17689c.a());
                UserData data13 = loginResult.getData();
                if (!(data13 == null || (areaCode = data13.getAreaCode()) == null)) {
                    str9 = areaCode;
                }
                switchAccountBean.setAreaCode(str9);
                this.f17687a.u(switchAccountBean);
                xa.c.c().j(new CloseForcePageEvent());
                xa.c.c().j(new GotoHomeTabEvent(0));
                b0.c0(this.f17687a.p(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17687a.p(), C0240a.f17690a);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17687a.q().showLoading(false);
            this.f17687a.q().q();
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17687a.p()).show();
            } else {
                x.f12622a.w(this.f17687a.p(), new b(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17692a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17693b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x7.a f17694c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17695a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17695a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17695a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(f fVar, String str, x7.a aVar) {
            this.f17692a = fVar;
            this.f17693b = str;
            this.f17694c = aVar;
        }

        /* renamed from: f */
        public void onNext(BindThirdPartResult bindThirdPartResult) {
            String str;
            String googlePhotoUrl;
            t9.i.g(bindThirdPartResult, "t");
            if (d6.b.f6366a.t()) {
                this.f17692a.m(this.f17693b, this.f17694c);
                return;
            }
            this.f17692a.q().showLoading(false);
            this.f17692a.q().q();
            i.c cVar = w6.i.f9510g;
            cVar.U("2");
            BindThirdPart data = bindThirdPartResult.getData();
            String str2 = "";
            if (data == null || (str = data.getGoogleNickName()) == null) {
                str = str2;
            }
            cVar.d0(str);
            BindThirdPart data2 = bindThirdPartResult.getData();
            if (!(data2 == null || (googlePhotoUrl = data2.getGooglePhotoUrl()) == null)) {
                str2 = googlePhotoUrl;
            }
            cVar.e0(str2);
            xa.c.c().m(new UpdateMineViewEvent());
            this.f17692a.q().M();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17692a.q().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17692a.q().showLoading(false);
            this.f17692a.q().q();
            if (b0.T(str, "portal100076")) {
                this.f17692a.q().n(R.string.am_google_been_bound);
            } else {
                x.f12622a.w(this.f17692a.p(), new a(str));
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17696a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17697a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ w f17698b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ f f17699c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, w wVar, f fVar) {
                super(1);
                this.f17697a = str;
                this.f17698b = wVar;
                this.f17699c = fVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                String p10 = y.p(y.f12639a, this.f17697a, (String) null, (String) null, 6, (Object) null);
                if (t9.i.b(this.f17698b.f19600a, "no_report_type") && t9.i.b(this.f17697a, "portal100060")) {
                    p10 = this.f17699c.p().getResources().getString(R.string.frequent_operation);
                    t9.i.f(p10, "context.resources.getStr…tring.frequent_operation)");
                }
                f1.f12517a.x(p10);
            }
        }

        public c(f fVar) {
            this.f17696a = fVar;
        }

        /* renamed from: f */
        public void onNext(UserBindResult userBindResult) {
            t9.i.g(userBindResult, "t");
            this.f17696a.t(userBindResult);
            this.f17696a.q().showLoading(false);
            this.f17696a.q().X1(userBindResult);
            this.f17696a.q().u2();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17696a.q().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17696a.q().showLoading(false);
            w wVar = new w();
            wVar.f19600a = y.f12639a.c(str);
            x.f12622a.w(this.f17696a.p(), new a(str, wVar, this.f17696a));
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17700a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17701a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17701a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17701a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public d(f fVar) {
            this.f17700a = fVar;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            k7.f.e("登出成功", new Object[0]);
            this.f17700a.q().showLoading(false);
            this.f17700a.q().t(false);
            d6.b.f6366a.e(this.f17700a.p());
            xa.c.c().j(new UserIdentityChangeEvent());
            xa.c.c().j(new RequestActiveEvent());
            this.f17700a.q().U0();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17700a.q().showLoading(true);
            this.f17700a.q().t(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17700a.q().showLoading(false);
            this.f17700a.q().t(false);
            x.f12622a.w(this.f17700a.p(), new a(str));
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17702a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17703a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17703a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17703a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public e(f fVar) {
            this.f17702a = fVar;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17702a.q().showLoading(true);
            this.f17702a.q().t(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17702a.q().showLoading(false);
            this.f17702a.q().t(false);
            x.f12622a.w(this.f17702a.p(), new a(str));
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            this.f17702a.q().showLoading(false);
            this.f17702a.q().t(false);
            d6.b.f6366a.e(this.f17702a.p());
            xa.c.c().j(new UserIdentityChangeEvent());
            xa.c.c().j(new RequestActiveEvent());
            this.f17702a.q().U0();
        }
    }

    /* renamed from: k6.f$f  reason: collision with other inner class name */
    public static final class C0241f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17704a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0241f(f fVar) {
            super(1);
            this.f17704a = fVar;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17705a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(f fVar) {
            super(1);
            this.f17705a = fVar;
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final class h extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f17706a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17707a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17707a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17707a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public h(f fVar) {
            this.f17706a = fVar;
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17706a.q().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17706a.q().showLoading(false);
            if (b0.T(str, "aaa100012")) {
                this.f17706a.q().r2(R.string.pwd_wrong);
            } else if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                this.f17706a.q().r2(R.string.pi_connect_timeout);
            } else {
                x.f12622a.w(this.f17706a.p(), new a(str));
            }
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            this.f17706a.q().showLoading(false);
            d6.b bVar = d6.b.f6366a;
            if (bVar.s(this.f17706a.p(), "google")) {
                bVar.E(this.f17706a.p(), "");
                bVar.I(this.f17706a.p(), "", "");
                LoginAty.C.a(this.f17706a.p(), false, true);
                return;
            }
            i.c cVar = w6.i.f9510g;
            cVar.U("1");
            cVar.d0("");
            cVar.e0("");
            xa.c.c().m(new UpdateMineViewEvent());
            this.f17706a.q().M();
            this.f17706a.q().O();
        }
    }

    public f(f5.c cVar, i6.e eVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(eVar, "view");
        this.f17685a = cVar;
        this.f17686b = eVar;
        eVar.Y0(this);
    }

    public static final void v(f fVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(fVar, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = fVar.f17685a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void w(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
    }

    public void g() {
    }

    public final void m(String str, x7.a aVar) {
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(str, aVar.a(), "0", "2", (String) null, 16, (t9.g) null)).compose(this.f17685a.O1()).subscribe(new a(this, str, aVar));
    }

    public void n(String str, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(aVar, "socialInfo");
        i.c cVar = w6.i.f9510g;
        cVar.b().R0(new BindBean(cVar.H(), cVar.J(), cVar.v(), str, aVar.a())).compose(this.f17685a.O1()).subscribe(new b(this, str, aVar));
    }

    public void o() {
        w6.i.f9510g.b().e1().compose(this.f17685a.O1()).subscribe(new c(this));
    }

    public final f5.c p() {
        return this.f17685a;
    }

    public final i6.e q() {
        return this.f17686b;
    }

    public final void r(String str, String str2) {
        w6.i.X1(w6.i.f9510g.b(), d6.b.f6366a.j(this.f17685a), na.f.e(this.f17685a, "login_area_code"), str, str2, (String) null, "0", (String) null, 64, (Object) null).compose(this.f17685a.O1()).subscribe(new d(this));
    }

    public final void s() {
        w6.i.f9510g.b().b2().compose(this.f17685a.O1()).subscribe(new e(this));
    }

    public final void t(UserBindResult userBindResult) {
        String str;
        String str2;
        String str3;
        String str4;
        UserBindData data;
        String areaCode;
        UserBindData data2;
        UserBindData data3;
        UserBindData data4;
        UserBindData data5;
        i.c cVar = w6.i.f9510g;
        String str5 = "";
        if (userBindResult == null || (data5 = userBindResult.getData()) == null || (str = data5.getBindMail()) == null) {
            str = str5;
        }
        cVar.T(str);
        if (userBindResult == null || (data4 = userBindResult.getData()) == null || (str2 = data4.getEmail()) == null) {
            str2 = str5;
        }
        cVar.b0(str2);
        if (userBindResult == null || (data3 = userBindResult.getData()) == null || (str3 = data3.getBindMobile()) == null) {
            str3 = str5;
        }
        cVar.V(str3);
        if (userBindResult == null || (data2 = userBindResult.getData()) == null || (str4 = data2.getMobile()) == null) {
            str4 = str5;
        }
        cVar.j0(str4);
        if (!(userBindResult == null || (data = userBindResult.getData()) == null || (areaCode = data.getAreaCode()) == null)) {
            str5 = areaCode;
        }
        cVar.R(str5);
    }

    public final void u(SwitchAccountBean switchAccountBean) {
        Observable.create(new c(this, switchAccountBean)).compose(q.b()).subscribe(new d(new C0241f(this)), new e(new g(this)));
    }

    public void y(String str, String str2, String str3) {
        t9.i.g(str, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "type");
        d6.b bVar = d6.b.f6366a;
        if (bVar.u(this.f17685a)) {
            s();
        } else if (bVar.v(this.f17685a)) {
            s();
        } else {
            r(str, str2);
        }
    }

    public void z(String str) {
        t9.i.g(str, "pwd");
        i.c cVar = w6.i.f9510g;
        w6.i b10 = cVar.b();
        String e10 = m.e(str);
        t9.i.f(e10, "md5(pwd)");
        b10.n2(new UnbindBean(e10, "3", "google", cVar.J(), cVar.H())).compose(this.f17685a.O1()).subscribe(new h(this));
    }
}
