package k6;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import h9.t;
import i9.n;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import ma.q;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s9.l;
import t9.j;
import t9.w;

public final class o implements i6.f {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17977a;

    /* renamed from: b  reason: collision with root package name */
    public final i6.g f17978b;

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f17979c = h9.h.b(new e(this));

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f17980d = new ArrayList();

    public static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17981a;

        public a(o oVar) {
            this.f17981a = oVar;
        }

        /* renamed from: a */
        public void onNext(ArrayList arrayList) {
            t9.i.g(arrayList, "list");
            this.f17981a.f17980d.clear();
            this.f17981a.f17980d.addAll(arrayList);
            this.f17981a.u().B1();
            if (!this.f17981a.f17980d.isEmpty()) {
                this.f17981a.u().Z1(this.f17981a.f17980d);
                return;
            }
            k7.f.c("无账号记录", new Object[0]);
            this.f17981a.u().Z1(this.f17981a.f17980d);
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
            k7.f.d("查询账号记录失败!", new Object[0]);
            this.f17981a.u().B1();
            th.printStackTrace();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            this.f17981a.u().h();
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f17983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ w f17984c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ w f17985d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17986e;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17987a = new a();

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

        public b(o oVar, SwitchAccountBean switchAccountBean, w wVar, w wVar2, String str) {
            this.f17982a = oVar;
            this.f17983b = switchAccountBean;
            this.f17984c = wVar;
            this.f17985d = wVar2;
            this.f17986e = str;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            t9.i.g(loginResult, "t");
            this.f17982a.B();
            this.f17982a.u().B1();
            this.f17982a.f17980d.add(0, this.f17983b);
            for (SwitchAccountBean logged : this.f17982a.f17980d) {
                logged.setLogged(false);
            }
            this.f17983b.setLogged(true);
            this.f17982a.u().V1();
            UserData data = loginResult.getData();
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
                bVar.E(this.f17982a.s(), (String) this.f17984c.f19600a);
                f5.c s10 = this.f17982a.s();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, s10, data3, (String) this.f17985d.f19600a, this.f17986e, (String) null, (String) null, (String) null, false, 240, (Object) null);
                if (!TextUtils.isEmpty((CharSequence) this.f17984c.f19600a)) {
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
                        } else {
                            str2 = null;
                        }
                        if (t9.i.b(str2, "1")) {
                            b0.c0(this.f17982a.s(), ForceChangePwdAty.class);
                            s5.e.f19464a.n(s5.c.QUICK_LOGIN, this.f17983b, (String) null);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                this.f17982a.G(this.f17983b);
                xa.c.c().j(new CloseForcePageEvent());
                b0.c0(this.f17982a.s(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17982a.s(), a.f17987a);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17982a.u().h();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17982a.u().B1();
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17982a.s()).show();
            } else {
                this.f17982a.u().o(str);
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17988a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f17989b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17990c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17991d;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17992a = new a();

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

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17993a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17993a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17993a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(o oVar, SwitchAccountBean switchAccountBean, String str, String str2) {
            this.f17988a = oVar;
            this.f17989b = switchAccountBean;
            this.f17990c = str;
            this.f17991d = str2;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String googleNickName;
            String str2;
            t9.i.g(loginResult, "t");
            this.f17988a.B();
            this.f17988a.u().B1();
            this.f17988a.f17980d.add(0, this.f17989b);
            for (SwitchAccountBean logged : this.f17988a.f17980d) {
                logged.setLogged(false);
            }
            this.f17989b.setLogged(true);
            this.f17988a.u().V1();
            UserData data = loginResult.getData();
            String str3 = null;
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
                bVar.E(this.f17988a.s(), this.f17990c);
                f5.c s10 = this.f17988a.s();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, s10, data3, "", "", this.f17990c, this.f17991d, (String) null, false, 192, (Object) null);
                if (!TextUtils.isEmpty(this.f17990c)) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str2 = data4.getPwdTip();
                    } else {
                        str2 = null;
                    }
                    if (t9.i.b(str2, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str3 = data5.getHasPwd();
                        }
                        if (t9.i.b(str3, "1")) {
                            b0.c0(this.f17988a.s(), ForceChangePwdAty.class);
                            x7.a aVar = new x7.a();
                            aVar.b(this.f17991d);
                            s5.e.f19464a.o(s5.c.THIRD_PART_LOGIN, this.f17990c, aVar, "0", "1", (String) null);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                SwitchAccountBean switchAccountBean = this.f17989b;
                UserData data6 = loginResult.getData();
                String str4 = "";
                if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                    str = str4;
                }
                switchAccountBean.setUserName(str);
                SwitchAccountBean switchAccountBean2 = this.f17989b;
                UserData data7 = loginResult.getData();
                if (!(data7 == null || (googleNickName = data7.getGoogleNickName()) == null)) {
                    str4 = googleNickName;
                }
                switchAccountBean2.setNickName(str4);
                this.f17988a.G(this.f17989b);
                xa.c.c().j(new CloseForcePageEvent());
                b0.c0(this.f17988a.s(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17988a.s(), a.f17992a);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17988a.u().h();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17988a.u().B1();
            if (t9.i.b("aaa100094", str)) {
                f1.f12517a.w(R.string.number_limit_tips);
                return;
            }
            this.f17988a.u().o(str);
            x.f12622a.w(this.f17988a.s(), new b(str));
        }
    }

    public static final class d extends ha.a {
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }

        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            k7.f.e("登出成功", new Object[0]);
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17994a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(o oVar) {
            super(0);
            this.f17994a = oVar;
        }

        /* renamed from: b */
        public final MobileDao invoke() {
            Context applicationContext = this.f17994a.s().getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17995a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(o oVar) {
            super(1);
            this.f17995a = oVar;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            this.f17995a.f17980d.remove(switchAccountBean);
            this.f17995a.u().Z1(this.f17995a.f17980d);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17996a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(o oVar) {
            super(1);
            this.f17996a = oVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除账号失败!", new Object[0]);
            this.f17996a.u().B1();
            th.printStackTrace();
        }
    }

    public static final class h extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17997a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(o oVar) {
            super(1);
            this.f17997a = oVar;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(this.f17997a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class i extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f17998a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(o oVar) {
            super(1);
            this.f17998a = oVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f17998a, "增加账号记录失败！");
        }
    }

    public o(f5.c cVar, i6.g gVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(gVar, "view");
        this.f17977a = cVar;
        this.f17978b = gVar;
        gVar.Y0(this);
    }

    public static final void D(o oVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(oVar, "this$0");
        t9.i.g(switchAccountBean, "$bean");
        t9.i.g(observableEmitter, "it");
        oVar.t().deleteAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void E(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(o oVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(oVar, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = oVar.f17977a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void I(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void J(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w(o oVar, ObservableEmitter observableEmitter) {
        t9.i.g(oVar, "this$0");
        t9.i.g(observableEmitter, "it");
        List<SwitchAccountBean> queryAllAccount = oVar.t().queryAllAccount();
        t9.i.e(queryAllAccount, "null cannot be cast to non-null type java.util.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean> }");
        ArrayList<SwitchAccountBean> arrayList = (ArrayList) queryAllAccount;
        if (!arrayList.isEmpty()) {
            for (SwitchAccountBean switchAccountBean : arrayList) {
                switchAccountBean.setLogged(t9.i.b(switchAccountBean.getUserId(), w6.i.f9510g.H()));
            }
            n.m(arrayList, new h());
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public static final int x(SwitchAccountBean switchAccountBean, SwitchAccountBean switchAccountBean2) {
        if (switchAccountBean.isLogged()) {
            return -1;
        }
        return switchAccountBean2.getId() - switchAccountBean.getId();
    }

    public final void A(SwitchAccountBean switchAccountBean) {
        String accountType = switchAccountBean.getAccountType();
        String authCode = switchAccountBean.getAuthCode();
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(accountType, authCode, "0", "1", (String) null, 16, (t9.g) null)).compose(this.f17977a.O1()).subscribe(new c(this, switchAccountBean, accountType, authCode));
    }

    public final void B() {
        b0.U(this, "tp type logout");
        w6.i.f9510g.b().b2().compose(this.f17977a.O1()).subscribe(new d());
    }

    public void C(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "bean");
        Observable.create(new l(this, switchAccountBean)).compose(this.f17977a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(new f(this)), new n(new g(this)));
    }

    public final void G(SwitchAccountBean switchAccountBean) {
        Observable.create(new i(this, switchAccountBean)).compose(q.b()).subscribe(new j(new h(this)), new k(new i(this)));
    }

    public void e() {
    }

    public void g() {
    }

    public final f5.c s() {
        return this.f17977a;
    }

    public final MobileDao t() {
        return (MobileDao) this.f17979c.getValue();
    }

    public final i6.g u() {
        return this.f17978b;
    }

    public void v() {
        Observable.create(new g(this)).compose(this.f17977a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
    }

    public final void y(SwitchAccountBean switchAccountBean) {
        w wVar = new w();
        wVar.f19600a = switchAccountBean.getAccountType();
        boolean z10 = false;
        k7.f.e("loginType:" + ((String) wVar.f19600a), new Object[0]);
        w wVar2 = new w();
        wVar2.f19600a = switchAccountBean.getUserName();
        String password = switchAccountBean.getPassword();
        String areaCode = switchAccountBean.getAreaCode();
        String qrAuthCode = switchAccountBean.getQrAuthCode();
        String verificationToken = switchAccountBean.getVerificationToken();
        if (TextUtils.equals((CharSequence) wVar.f19600a, "4")) {
            wVar.f19600a = CdnType.DIGITAL_TYPE_PCDN;
        }
        if (t9.i.b(wVar.f19600a, "7")) {
            if (qrAuthCode.length() > 0) {
                z10 = true;
            }
            if (z10) {
                wVar2.f19600a = qrAuthCode;
            }
        }
        w6.i.f9510g.b().W1((String) wVar.f19600a, areaCode, (String) wVar2.f19600a, password, (String) null, (String) null, verificationToken).compose(this.f17977a.O1()).subscribe(new b(this, switchAccountBean, wVar, wVar2, password));
    }

    public void z(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "bean");
        if (t9.i.b(switchAccountBean.getAccountType(), "google") || t9.i.b(switchAccountBean.getAccountType(), "facebook")) {
            A(switchAccountBean);
        } else {
            y(switchAccountBean);
        }
    }
}
