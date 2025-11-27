package k6;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.RefreshAccountEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.h0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.utils.z0;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import i6.s;
import i6.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import ma.q;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import mobile.com.requestframe.utils.response.VerificationResult;
import t9.w;

public final class j0 implements s {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17845a;

    /* renamed from: b  reason: collision with root package name */
    public final t f17846b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f17847c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f17848d;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f17849e;

    /* renamed from: f  reason: collision with root package name */
    public Disposable f17850f;

    /* renamed from: g  reason: collision with root package name */
    public final h9.g f17851g = h9.h.b(new j(this));

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f17852h = new ArrayList();

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17853a;

        /* renamed from: k6.j0$a$a  reason: collision with other inner class name */
        public static final class C0244a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17854a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0244a(String str) {
                super(1);
                this.f17854a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17854a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(j0 j0Var) {
            this.f17853a = j0Var;
        }

        /* renamed from: f */
        public void onNext(AreaCodeResult areaCodeResult) {
            String str;
            t9.i.g(areaCodeResult, "t");
            AreaCodeData data = areaCodeResult.getData();
            if (data == null || (str = data.getAreaCode()) == null) {
                str = "";
            }
            t H = this.f17853a.H();
            String a10 = h0.a(this.f17853a.D(), str);
            t9.i.f(a10, "getCountryByCode(context, areaCode)");
            H.h1(str, a10);
        }

        public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            y.f12639a.c(str);
            x.f12622a.w(this.f17853a.D(), new C0244a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17855a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17856a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f17857b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ j0 f17858c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, j0 j0Var) {
                super(1);
                this.f17856a = str;
                this.f17857b = str2;
                this.f17858c = j0Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                String d10 = y.f12639a.d(this.f17856a);
                if (t9.i.b(this.f17856a, "no_report_type") && t9.i.b(this.f17857b, "portal100060")) {
                    d10 = this.f17858c.D().getResources().getString(R.string.frequent_operation);
                    t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                }
                f1.f12517a.x(d10);
            }
        }

        public b(j0 j0Var) {
            this.f17855a = j0Var;
        }

        /* renamed from: f */
        public void onNext(VerificationResult verificationResult) {
            t9.i.g(verificationResult, "t");
            this.f17855a.H().showLoading(false);
            this.f17855a.H().i();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17855a.f17848d = disposable;
            this.f17855a.H().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17855a.H().showLoading(false);
            this.f17855a.H().Q();
            x.f12622a.w(this.f17855a.D(), new a(y.f12639a.c(str), str, this.f17855a));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17859a;

        public c(j0 j0Var) {
            this.f17859a = j0Var;
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
                this.f17859a.H().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, (Object) null));
            }
        }
    }

    public static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17860a;

        public d(j0 j0Var) {
            this.f17860a = j0Var;
        }

        /* renamed from: a */
        public void onNext(ArrayList arrayList) {
            t9.i.g(arrayList, "list");
            this.f17860a.G().clear();
            this.f17860a.G().addAll(arrayList);
            if (!this.f17860a.G().isEmpty()) {
                this.f17860a.H().v0(this.f17860a.G());
                return;
            }
            k7.f.c("无账号记录", new Object[0]);
            this.f17860a.H().v0(this.f17860a.G());
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            t9.i.g(th, "e");
            k7.f.d("查询账号记录失败!", new Object[0]);
            th.printStackTrace();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public static final class e extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17861a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17862b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17863c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17864d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f17866f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f17867g;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17868a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17869a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17869a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f17869a, yVar.i(), (String) null, 4, (Object) null));
            }
        }

        public e(j0 j0Var, String str, String str2, String str3, String str4, String str5, boolean z10) {
            this.f17861a = j0Var;
            this.f17862b = str;
            this.f17863c = str2;
            this.f17864d = str3;
            this.f17865e = str4;
            this.f17866f = str5;
            this.f17867g = z10;
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
            t9.i.g(loginResult, "t");
            this.f17861a.H().r0();
            this.f17861a.H().showLoading(false);
            UserData data = loginResult.getData();
            String str6 = null;
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
                bVar.E(this.f17861a.D(), this.f17862b);
                f5.c D = this.f17861a.D();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, D, data3, this.f17863c, this.f17864d, (String) null, (String) null, (String) null, false, 240, (Object) null);
                String str7 = "";
                if (!TextUtils.isEmpty(this.f17862b)) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str5 = data4.getPwdTip();
                    } else {
                        str5 = null;
                    }
                    if (t9.i.b(str5, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str6 = data5.getHasPwd();
                        }
                        if (t9.i.b(str6, "1")) {
                            b0.c0(this.f17861a.D(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType(this.f17862b);
                            String str8 = this.f17865e;
                            if (str8 != null) {
                                str7 = str8;
                            }
                            switchAccountBean.setAreaCode(str7);
                            switchAccountBean.setUserName(this.f17863c);
                            switchAccountBean.setPassword(this.f17864d);
                            s5.e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, this.f17866f);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                SwitchAccountBean switchAccountBean2 = new SwitchAccountBean();
                switchAccountBean2.setUserName(this.f17863c);
                switchAccountBean2.setPassword(this.f17864d);
                UserData data6 = loginResult.getData();
                if (data6 == null || (str = data6.getUserId()) == null) {
                    str = str7;
                }
                switchAccountBean2.setUserId(str);
                switchAccountBean2.setAccountType(this.f17862b);
                String str9 = this.f17865e;
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
                this.f17861a.X(switchAccountBean2);
                xa.c.c().j(new CloseForceBindEvent());
                xa.c.c().j(new CloseForcePageEvent());
                if (this.f17867g) {
                    b0.c0(this.f17861a.D(), MainAty.class);
                    return;
                }
                xa.c.c().j(new RefreshAccountEvent());
                this.f17861a.D().finish();
                return;
            }
            x.f12622a.w(this.f17861a.D(), a.f17868a);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17861a.f17847c = disposable;
            this.f17861a.H().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "login fail: " + str);
            this.f17861a.H().showLoading(false);
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17861a.D()).show();
            } else {
                x.f12622a.w(this.f17861a.D(), new b(str));
            }
        }
    }

    public static final class f extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f17871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ w f17872c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ w f17873d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17874e;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17875a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public f(j0 j0Var, SwitchAccountBean switchAccountBean, w wVar, w wVar2, String str) {
            this.f17870a = j0Var;
            this.f17871b = switchAccountBean;
            this.f17872c = wVar;
            this.f17873d = wVar2;
            this.f17874e = str;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            t9.i.g(loginResult, "t");
            this.f17870a.H().r0();
            this.f17870a.H().showLoading(false);
            this.f17870a.G().add(0, this.f17871b);
            for (SwitchAccountBean logged : this.f17870a.G()) {
                logged.setLogged(false);
            }
            this.f17871b.setLogged(true);
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
                bVar.E(this.f17870a.D(), (String) this.f17872c.f19600a);
                f5.c D = this.f17870a.D();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, D, data3, (String) this.f17873d.f19600a, this.f17874e, (String) null, (String) null, (String) null, false, 240, (Object) null);
                if (!TextUtils.isEmpty((CharSequence) this.f17872c.f19600a)) {
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
                            b0.c0(this.f17870a.D(), ForceChangePwdAty.class);
                            s5.e.f19464a.n(s5.c.QUICK_LOGIN, this.f17871b, (String) null);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                this.f17870a.X(this.f17871b);
                xa.c.c().j(new CloseForcePageEvent());
                b0.c0(this.f17870a.D(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17870a.D(), a.f17875a);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17870a.f17847c = disposable;
            this.f17870a.H().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "login fail: " + str);
            this.f17870a.H().showLoading(false);
            this.f17870a.H().c0(str);
            y yVar = y.f12639a;
            y.p(yVar, str, yVar.i(), (String) null, 4, (Object) null);
        }
    }

    public static final class g extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17877b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17878c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17879d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x7.a f17880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ w f17881f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f17882g;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17883a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17884a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17884a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f17884a, yVar.j(), (String) null, 4, (Object) null));
            }
        }

        public g(j0 j0Var, String str, String str2, String str3, x7.a aVar, w wVar, boolean z10) {
            this.f17876a = j0Var;
            this.f17877b = str;
            this.f17878c = str2;
            this.f17879d = str3;
            this.f17880e = aVar;
            this.f17881f = wVar;
            this.f17882g = z10;
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
            t9.i.g(loginResult, "t");
            this.f17876a.H().r0();
            this.f17876a.H().showLoading(false);
            if (t9.i.b(this.f17879d, "2")) {
                this.f17876a.H().q();
            }
            UserData data = loginResult.getData();
            String str8 = null;
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
                bVar.E(this.f17876a.D(), this.f17878c);
                f5.c D = this.f17876a.D();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, D, data3, "", "", this.f17878c, this.f17880e.a(), (String) null, false, 192, (Object) null);
                String str9 = "";
                if (!TextUtils.isEmpty(this.f17878c)) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str6 = data4.getPwdTip();
                    } else {
                        str6 = null;
                    }
                    if (t9.i.b(str6, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str8 = data5.getHasPwd();
                        }
                        if (t9.i.b(str8, "1")) {
                            b0.c0(this.f17876a.D(), ForceChangePwdAty.class);
                            s5.e eVar = s5.e.f19464a;
                            s5.c cVar = s5.c.THIRD_PART_LOGIN;
                            String str10 = this.f17878c;
                            x7.a aVar = this.f17880e;
                            String str11 = this.f17877b;
                            String str12 = this.f17879d;
                            String str13 = (String) this.f17881f.f19600a;
                            if (str13 == null) {
                                str7 = str9;
                            } else {
                                str7 = str13;
                            }
                            eVar.o(cVar, str10, aVar, str11, str12, str7);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                switchAccountBean.setAccountType("google");
                UserData data6 = loginResult.getData();
                if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                    str = str9;
                }
                switchAccountBean.setUserName(str);
                UserData data7 = loginResult.getData();
                if (data7 == null || (str2 = data7.getEmail()) == null) {
                    str2 = str9;
                }
                switchAccountBean.setEmail(str2);
                UserData data8 = loginResult.getData();
                if (data8 == null || (str3 = data8.getMobile()) == null) {
                    str3 = str9;
                }
                switchAccountBean.setPhone(str3);
                UserData data9 = loginResult.getData();
                if (data9 == null || (str4 = data9.getUserId()) == null) {
                    str4 = str9;
                }
                switchAccountBean.setUserId(str4);
                UserData data10 = loginResult.getData();
                if (data10 == null || (str5 = data10.getGoogleNickName()) == null) {
                    str5 = str9;
                }
                switchAccountBean.setNickName(str5);
                switchAccountBean.setAuthCode(this.f17880e.a());
                UserData data11 = loginResult.getData();
                if (!(data11 == null || (areaCode = data11.getAreaCode()) == null)) {
                    str9 = areaCode;
                }
                switchAccountBean.setAreaCode(str9);
                this.f17876a.X(switchAccountBean);
                xa.c.c().j(new CloseForcePageEvent());
                Class<MainAty> cls = MainAty.class;
                if (!t9.i.b(this.f17877b, "0")) {
                    xa.c.c().j(new GotoHomeTabEvent(0));
                    b0.c0(this.f17876a.D(), cls);
                } else if (this.f17882g) {
                    b0.c0(this.f17876a.D(), cls);
                } else {
                    xa.c.c().j(new RefreshAccountEvent());
                    this.f17876a.D().finish();
                }
            } else {
                x.f12622a.w(this.f17876a.D(), a.f17883a);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleGoogleAccountNotBind(java.lang.String r5, java.lang.String r6) {
            /*
                r4 = this;
                java.lang.String r5 = ""
                java.lang.String r0 = r4.f17877b
                java.lang.String r1 = "0"
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r0, r1)
                if (r0 != 0) goto L_0x000d
                return
            L_0x000d:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0044 }
                r0.<init>(r6)     // Catch:{ Exception -> 0x0044 }
                java.lang.String r2 = "localUserIdentity"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x0044 }
                java.lang.String r2 = "JSONObject(errorData).ge…ring(\"localUserIdentity\")"
                t9.i.f(r0, r2)     // Catch:{ Exception -> 0x0044 }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0041 }
                r2.<init>(r6)     // Catch:{ Exception -> 0x0041 }
                java.lang.String r3 = "bindGoogleEmail"
                java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0041 }
                java.lang.String r3 = "JSONObject(errorData).getString(\"bindGoogleEmail\")"
                t9.i.f(r2, r3)     // Catch:{ Exception -> 0x0041 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x003f }
                r3.<init>(r6)     // Catch:{ Exception -> 0x003f }
                java.lang.String r6 = "googleEmail"
                java.lang.String r6 = r3.getString(r6)     // Catch:{ Exception -> 0x003f }
                java.lang.String r3 = "JSONObject(errorData).getString(\"googleEmail\")"
                t9.i.f(r6, r3)     // Catch:{ Exception -> 0x003f }
                r5 = r6
                goto L_0x004a
            L_0x003f:
                r6 = move-exception
                goto L_0x0047
            L_0x0041:
                r6 = move-exception
                r2 = r5
                goto L_0x0047
            L_0x0044:
                r6 = move-exception
                r0 = r5
                r2 = r0
            L_0x0047:
                r6.printStackTrace()
            L_0x004a:
                boolean r6 = com.mobile.brasiltv.utils.b0.J(r0)
                if (r6 == 0) goto L_0x005a
                k6.j0 r5 = r4.f17876a
                i6.t r5 = r5.H()
                r5.q()
                return
            L_0x005a:
                java.lang.String r6 = "1"
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r0, r6)
                if (r0 != 0) goto L_0x007e
                d6.b r0 = d6.b.f6366a
                boolean r0 = r0.t()
                if (r0 == 0) goto L_0x006b
                goto L_0x007e
            L_0x006b:
                k6.j0 r5 = r4.f17876a
                i6.t r5 = r5.H()
                r5.q()
                k6.j0 r5 = r4.f17876a
                i6.t r5 = r5.H()
                r5.U1()
                goto L_0x00a5
            L_0x007e:
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r2, r1)
                if (r0 == 0) goto L_0x0092
                k6.j0 r5 = r4.f17876a
                i6.t r5 = r5.H()
                java.lang.String r0 = r4.f17878c
                x7.a r1 = r4.f17880e
                r5.S(r0, r6, r1)
                goto L_0x00a5
            L_0x0092:
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r2, r6)
                if (r0 == 0) goto L_0x00a5
                k6.j0 r0 = r4.f17876a
                i6.t r0 = r0.H()
                java.lang.String r1 = r4.f17878c
                x7.a r2 = r4.f17880e
                r0.F2(r5, r1, r6, r2)
            L_0x00a5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k6.j0.g.handleGoogleAccountNotBind(java.lang.String, java.lang.String):void");
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17876a.f17850f = disposable;
            this.f17876a.H().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17876a.H().showLoading(false);
            if (b0.T(this.f17877b, "0")) {
                if (!b0.T(str, "portal100071")) {
                    if (b0.T(str, "portal100075")) {
                        d6.b.f6366a.I(this.f17876a.D(), "", "");
                        this.f17876a.H().M1(this.f17878c);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (t9.i.b(this.f17879d, "2")) {
                this.f17876a.H().q();
            }
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17876a.D()).show();
            } else {
                x.f12622a.w(this.f17876a.D(), new b(str));
            }
        }
    }

    public static final class h extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17885a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f17886b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17887c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17888d;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17889a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public h(j0 j0Var, SwitchAccountBean switchAccountBean, String str, String str2) {
            this.f17885a = j0Var;
            this.f17886b = switchAccountBean;
            this.f17887c = str;
            this.f17888d = str2;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String googleNickName;
            String str2;
            t9.i.g(loginResult, "t");
            this.f17885a.H().r0();
            this.f17885a.H().showLoading(false);
            this.f17885a.G().add(0, this.f17886b);
            for (SwitchAccountBean logged : this.f17885a.G()) {
                logged.setLogged(false);
            }
            this.f17886b.setLogged(true);
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
                bVar.E(this.f17885a.D(), this.f17887c);
                f5.c D = this.f17885a.D();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                d6.b.G(bVar, D, data3, "", "", this.f17887c, this.f17888d, (String) null, false, 192, (Object) null);
                if (!TextUtils.isEmpty(this.f17887c)) {
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
                            b0.c0(this.f17885a.D(), ForceChangePwdAty.class);
                            x7.a aVar = new x7.a();
                            aVar.b(this.f17888d);
                            s5.e.f19464a.o(s5.c.THIRD_PART_LOGIN, this.f17887c, aVar, "0", "1", (String) null);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                SwitchAccountBean switchAccountBean = this.f17886b;
                UserData data6 = loginResult.getData();
                String str4 = "";
                if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                    str = str4;
                }
                switchAccountBean.setUserName(str);
                SwitchAccountBean switchAccountBean2 = this.f17886b;
                UserData data7 = loginResult.getData();
                if (!(data7 == null || (googleNickName = data7.getGoogleNickName()) == null)) {
                    str4 = googleNickName;
                }
                switchAccountBean2.setNickName(str4);
                this.f17885a.X(this.f17886b);
                xa.c.c().j(new CloseForcePageEvent());
                b0.c0(this.f17885a.D(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17885a.D(), a.f17889a);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17885a.f17850f = disposable;
            this.f17885a.H().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17885a.H().showLoading(false);
            this.f17885a.H().c0(str);
            y yVar = y.f12639a;
            y.p(yVar, str, yVar.j(), (String) null, 4, (Object) null);
        }
    }

    public static final class i extends ha.a {
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

    public static final class j extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17890a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(j0 j0Var) {
            super(0);
            this.f17890a = j0Var;
        }

        /* renamed from: b */
        public final MobileDao invoke() {
            Context applicationContext = this.f17890a.D().getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17891a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(j0 j0Var) {
            super(1);
            this.f17891a = j0Var;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            this.f17891a.G().remove(switchAccountBean);
            this.f17891a.H().v0(this.f17891a.G());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final l f17892a = new l();

        public l() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除账号失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17893a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(j0 j0Var) {
            super(1);
            this.f17893a = j0Var;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(this.f17893a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class n extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17894a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(j0 j0Var) {
            super(1);
            this.f17894a = j0Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f17894a, "增加账号记录失败！");
        }
    }

    public static final class o extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j0 f17895a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17896b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17897c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17898d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f17899e;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17900a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17900a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d(this.f17900a));
            }
        }

        public o(j0 j0Var, String str, String str2, String str3, boolean z10) {
            this.f17895a = j0Var;
            this.f17896b = str;
            this.f17897c = str2;
            this.f17898d = str3;
            this.f17899e = z10;
        }

        /* renamed from: f */
        public void onNext(CheckVerificationResult checkVerificationResult) {
            t9.i.g(checkVerificationResult, "t");
            this.f17895a.M(this.f17896b, "", "4", this.f17897c, this.f17898d, this.f17899e);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17895a.f17849e = disposable;
            this.f17895a.H().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "verify code fail: " + str);
            this.f17895a.H().showLoading(false);
            x.f12622a.w(this.f17895a.D(), new a(y.f12639a.c(str)));
        }
    }

    public j0(f5.c cVar, t tVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(tVar, "view");
        this.f17845a = cVar;
        this.f17846b = tVar;
    }

    public static final void J(j0 j0Var, ObservableEmitter observableEmitter) {
        t9.i.g(j0Var, "this$0");
        t9.i.g(observableEmitter, "it");
        List<SwitchAccountBean> queryAllAccount = j0Var.F().queryAllAccount();
        t9.i.e(queryAllAccount, "null cannot be cast to non-null type java.util.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean> }");
        ArrayList<SwitchAccountBean> arrayList = (ArrayList) queryAllAccount;
        if (!arrayList.isEmpty()) {
            for (SwitchAccountBean switchAccountBean : arrayList) {
                switchAccountBean.setLogged(t9.i.b(switchAccountBean.getUserId(), w6.i.f9510g.H()));
            }
            i9.n.m(arrayList, new i0());
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public static final int K(SwitchAccountBean switchAccountBean, SwitchAccountBean switchAccountBean2) {
        if (switchAccountBean.isLogged()) {
            return -1;
        }
        return switchAccountBean2.getId() - switchAccountBean.getId();
    }

    public static final void N(j0 j0Var) {
        t9.i.g(j0Var, "this$0");
        j0Var.f17846b.q();
    }

    public static final void U(j0 j0Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(j0Var, "this$0");
        t9.i.g(switchAccountBean, "$bean");
        t9.i.g(observableEmitter, "it");
        j0Var.F().deleteAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void V(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void W(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Y(j0 j0Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(j0Var, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = j0Var.f17845a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void Z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void a0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void A() {
        Disposable disposable = this.f17850f;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f17850f;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f17850f = null;
        }
    }

    public final void B() {
        w6.i.f9510g.b().O0().compose(this.f17845a.O1()).subscribe(new a(this));
    }

    public void C(String str, String str2, String str3) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "area");
        t9.i.g(str3, "areaCode");
        if (b0.J(str)) {
            this.f17846b.d(R.string.empty_phone);
        } else if (!z0.a(str, str2)) {
            this.f17846b.d(R.string.invalid_phone_number);
        } else {
            this.f17846b.hideErrorHint(0);
            y();
            w6.i.f9510g.b().U1(str, str3, "4").compose(this.f17845a.O1()).subscribe(new b(this));
        }
    }

    public final f5.c D() {
        return this.f17845a;
    }

    public final void E() {
        w6.i.f9510g.b().q1().compose(this.f17845a.O1()).subscribe(new c(this));
    }

    public final MobileDao F() {
        return (MobileDao) this.f17851g.getValue();
    }

    public final ArrayList G() {
        return this.f17852h;
    }

    public final t H() {
        return this.f17846b;
    }

    public final void I() {
        Observable.create(new h0(this)).compose(this.f17845a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
    }

    public final void L(SwitchAccountBean switchAccountBean) {
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
        w6.i.f9510g.b().W1((String) wVar.f19600a, areaCode, (String) wVar2.f19600a, password, (String) null, (String) null, verificationToken).compose(this.f17845a.O1()).subscribe(new f(this, switchAccountBean, wVar, wVar2, password));
    }

    public void M(String str, String str2, String str3, String str4, String str5, boolean z10) {
        String str6 = str;
        t9.i.g(str, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "accountTypes");
        z();
        String str7 = str;
        String str8 = str2;
        w6.i.X1(w6.i.f9510g.b(), str3, str4, str7, str8, str5, (String) null, (String) null, 64, (Object) null).compose(this.f17845a.O1()).subscribe(new e(this, str3, str7, str8, str4, str5, z10));
    }

    public boolean O(String str, boolean z10) {
        t9.i.g(str, "thirdPartType");
        String e10 = na.f.e(this.f17845a, "tp_google_auth_code");
        if (b0.J(e10)) {
            return false;
        }
        x7.a aVar = new x7.a();
        t9.i.f(e10, "authCode");
        aVar.b(e10);
        s.a.a(this, str, aVar, "0", "1", z10, (String) null, 32, (Object) null);
        return true;
    }

    public final void P(SwitchAccountBean switchAccountBean) {
        String accountType = switchAccountBean.getAccountType();
        String authCode = switchAccountBean.getAuthCode();
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(accountType, authCode, "0", "1", (String) null, 16, (t9.g) null)).compose(this.f17845a.O1()).subscribe(new h(this, switchAccountBean, accountType, authCode));
    }

    public final void Q() {
        b0.U(this, "tp type logout");
        w6.i.f9510g.b().b2().compose(this.f17845a.O1()).subscribe(new i());
    }

    public void R(String str, String str2, String str3, String str4, boolean z10) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "password");
        t9.i.g(str3, "area");
        t9.i.g(str4, "areaCode");
        if (b0.J(str)) {
            this.f17846b.n(R.string.empty_phone);
        } else if (b0.J(str2)) {
            this.f17846b.n(R.string.wrong_pohone_number_or_pwd);
        } else if (!z0.a(str, str3)) {
            this.f17846b.d(R.string.invalid_phone_number);
        } else {
            this.f17846b.hideErrorHint(0);
            String e10 = ma.m.e(str2);
            t9.i.f(e10, "md5(password)");
            M(str, e10, "3", str4, "", z10);
        }
    }

    public final void S(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        if (t9.i.b(switchAccountBean.getAccountType(), "google") || t9.i.b(switchAccountBean.getAccountType(), "facebook")) {
            P(switchAccountBean);
        } else {
            L(switchAccountBean);
        }
    }

    public final void T(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "bean");
        Observable.create(new d0(this, switchAccountBean)).compose(this.f17845a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e0(new k(this)), new f0(l.f17892a));
    }

    public final void X(SwitchAccountBean switchAccountBean) {
        Observable.create(new a0(this, switchAccountBean)).compose(q.b()).subscribe(new b0(new m(this)), new c0(new n(this)));
    }

    public void b0(String str, String str2, String str3, String str4, boolean z10) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "verifyCode");
        t9.i.g(str3, "area");
        t9.i.g(str4, "areaCode");
        if (b0.J(str)) {
            this.f17846b.d(R.string.empty_phone);
        } else if (b0.J(str2)) {
            this.f17846b.d(R.string.empty_verification_code);
        } else if (!z0.a(str, str3)) {
            this.f17846b.d(R.string.invalid_phone_number);
        } else if (str2.length() != 6) {
            this.f17846b.d(R.string.verification_invalid);
        } else {
            this.f17846b.hideErrorHint(0);
            w();
            w6.i.f9510g.b().W0(str, str4, str2, "4").compose(this.f17845a.O1()).subscribe(new o(this, str, str4, str2, z10));
        }
    }

    public void c(String str, x7.a aVar, String str2, String str3, boolean z10, String str4) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(aVar, "socialInfo");
        t9.i.g(str2, "createType");
        t9.i.g(str3, "tpSource");
        A();
        w wVar = new w();
        wVar.f19600a = str4;
        if (str4 != null) {
            wVar.f19600a = ma.m.e(str4);
        }
        String str5 = str2;
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(str, aVar.a(), str5, str3, (String) wVar.f19600a)).compose(this.f17845a.O1()).doOnDispose(new g0(this)).subscribe(new g(this, str5, str, str3, aVar, wVar, z10));
    }

    public void e() {
        B();
        I();
        E();
    }

    public void g() {
    }

    public void v(String str, String str2, boolean z10) {
        String str3;
        t9.i.g(str, "account");
        t9.i.g(str2, "password");
        if (b0.J(str)) {
            this.f17846b.n(R.string.enter_account_hint);
        } else if (b0.J(str2)) {
            this.f17846b.n(R.string.enter_password_hint);
        } else if (!j1.f(str2)) {
            this.f17846b.n(R.string.password_format_incorrect);
        } else {
            if (j1.e(str)) {
                str3 = "1";
            } else if (ba.t.o(str, "@", false, 2, (Object) null)) {
                str3 = "2";
            } else {
                str3 = CdnType.DIGITAL_TYPE_PEERSTAR;
            }
            String str4 = str3;
            String e10 = ma.m.e(str2);
            t9.i.f(e10, "md5(password)");
            M(str, e10, str4, "", "", z10);
        }
    }

    public final void w() {
        Disposable disposable = this.f17849e;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f17849e;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f17849e = null;
        }
    }

    public void x() {
        z();
        y();
        w();
        A();
    }

    public final void y() {
        Disposable disposable = this.f17848d;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f17848d;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f17848d = null;
        }
    }

    public final void z() {
        Disposable disposable = this.f17847c;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f17847c;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f17847c = null;
        }
    }
}
