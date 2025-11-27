package t5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.titans.entity.CdnType;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.List;
import ma.q;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s5.e;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import t9.w;

public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public s5.b f19496a;

    /* renamed from: b  reason: collision with root package name */
    public a f19497b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f19498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u8.a f19499b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19500c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f19501d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f19502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ w f19503f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19504g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19505h;

        /* renamed from: t5.f$a$a  reason: collision with other inner class name */
        public static final class C0285a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0285a f19506a = new C0285a();

            public C0285a() {
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
            public final /* synthetic */ String f19507a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f19507a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                f1.f12517a.x(y.p(yVar, this.f19507a, yVar.i(), (String) null, 4, (Object) null));
            }
        }

        public a(f fVar, u8.a aVar, e eVar, SwitchAccountBean switchAccountBean, w wVar, w wVar2, String str, String str2) {
            this.f19498a = fVar;
            this.f19499b = aVar;
            this.f19500c = eVar;
            this.f19501d = switchAccountBean;
            this.f19502e = wVar;
            this.f19503f = wVar2;
            this.f19504g = str;
            this.f19505h = str2;
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
            this.f19498a.c(this.f19499b, this.f19500c);
            this.f19501d.setLogged(true);
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
                i.d(data2);
                bVar.H(data2);
                bVar.E(this.f19499b, (String) this.f19502e.f19600a);
                u8.a aVar = this.f19499b;
                UserData data3 = loginResult.getData();
                i.d(data3);
                d6.b.G(bVar, aVar, data3, (String) this.f19503f.f19600a, this.f19504g, (String) null, (String) null, (String) null, false, 240, (Object) null);
                if (!TextUtils.isEmpty((CharSequence) this.f19502e.f19600a)) {
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
                            this.f19499b.startActivity(new Intent(this.f19499b, ForceChangePwdAty.class));
                            s5.b h10 = this.f19498a.f19496a;
                            if (h10 != null) {
                                h10.q0("4");
                                return;
                            }
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                this.f19501d.setPassword(this.f19504g);
                SwitchAccountBean switchAccountBean = this.f19501d;
                UserData data6 = loginResult.getData();
                String str7 = "";
                if (data6 == null || (str = data6.getUserId()) == null) {
                    str = str7;
                }
                switchAccountBean.setUserId(str);
                this.f19501d.setAreaCode(this.f19505h);
                SwitchAccountBean switchAccountBean2 = this.f19501d;
                UserData data7 = loginResult.getData();
                if (data7 == null || (str2 = data7.getVerificationToken()) == null) {
                    str2 = str7;
                }
                switchAccountBean2.setVerificationToken(str2);
                SwitchAccountBean switchAccountBean3 = this.f19501d;
                UserData data8 = loginResult.getData();
                if (data8 == null || (str3 = data8.getEmail()) == null) {
                    str3 = str7;
                }
                switchAccountBean3.setEmail(str3);
                SwitchAccountBean switchAccountBean4 = this.f19501d;
                UserData data9 = loginResult.getData();
                if (data9 == null || (str4 = data9.getMobile()) == null) {
                    str4 = str7;
                }
                switchAccountBean4.setPhone(str4);
                SwitchAccountBean switchAccountBean5 = this.f19501d;
                UserData data10 = loginResult.getData();
                if (!(data10 == null || (areaCode = data10.getAreaCode()) == null)) {
                    str7 = areaCode;
                }
                switchAccountBean5.setAreaCode(str7);
                this.f19498a.l(this.f19499b, this.f19501d);
                s5.b h11 = this.f19498a.f19496a;
                if (h11 != null) {
                    h11.q0("0");
                    return;
                }
                return;
            }
            x.f12622a.w(this.f19499b, C0285a.f19506a);
            s5.b h12 = this.f19498a.f19496a;
            if (h12 != null) {
                h12.q0("1");
            }
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            b0.U(this, "login fail: " + str);
            if (i.b("aaa100094", str)) {
                s5.b h10 = this.f19498a.f19496a;
                if (h10 != null) {
                    h10.q0("2");
                }
            } else if (i.b("aaa100028", str) || i.b("aaa100027", str)) {
                s5.b h11 = this.f19498a.f19496a;
                if (h11 != null) {
                    h11.q0("3");
                }
            } else {
                x.f12622a.w(this.f19499b, new b(str));
                s5.b h12 = this.f19498a.f19496a;
                if (h12 != null) {
                    h12.q0("1");
                }
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f19508a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u8.a f19509b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19510c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f19511d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19513f;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f19514a = new a();

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

        public b(f fVar, u8.a aVar, e eVar, SwitchAccountBean switchAccountBean, String str, String str2) {
            this.f19508a = fVar;
            this.f19509b = aVar;
            this.f19510c = eVar;
            this.f19511d = switchAccountBean;
            this.f19512e = str;
            this.f19513f = str2;
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
            i.g(loginResult, "t");
            this.f19508a.c(this.f19509b, this.f19510c);
            this.f19511d.setLogged(true);
            UserData data = loginResult.getData();
            String str7 = null;
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
                bVar.E(this.f19509b, this.f19512e);
                u8.a aVar = this.f19509b;
                UserData data3 = loginResult.getData();
                i.d(data3);
                d6.b.G(bVar, aVar, data3, "", "", this.f19512e, this.f19513f, (String) null, false, 192, (Object) null);
                if (!TextUtils.isEmpty(this.f19512e)) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str6 = data4.getPwdTip();
                    } else {
                        str6 = null;
                    }
                    if (i.b(str6, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str7 = data5.getHasPwd();
                        }
                        if (i.b(str7, "1")) {
                            this.f19509b.startActivity(new Intent(this.f19509b, ForceChangePwdAty.class));
                            s5.b h10 = this.f19508a.f19496a;
                            if (h10 != null) {
                                h10.q0("4");
                                return;
                            }
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                this.f19511d.setAccountType(this.f19512e);
                SwitchAccountBean switchAccountBean = this.f19511d;
                UserData data6 = loginResult.getData();
                String str8 = "";
                if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                    str = str8;
                }
                switchAccountBean.setUserName(str);
                SwitchAccountBean switchAccountBean2 = this.f19511d;
                UserData data7 = loginResult.getData();
                if (data7 == null || (str2 = data7.getEmail()) == null) {
                    str2 = str8;
                }
                switchAccountBean2.setEmail(str2);
                SwitchAccountBean switchAccountBean3 = this.f19511d;
                UserData data8 = loginResult.getData();
                if (data8 == null || (str3 = data8.getMobile()) == null) {
                    str3 = str8;
                }
                switchAccountBean3.setPhone(str3);
                SwitchAccountBean switchAccountBean4 = this.f19511d;
                UserData data9 = loginResult.getData();
                if (data9 == null || (str4 = data9.getUserId()) == null) {
                    str4 = str8;
                }
                switchAccountBean4.setUserId(str4);
                SwitchAccountBean switchAccountBean5 = this.f19511d;
                UserData data10 = loginResult.getData();
                if (data10 == null || (str5 = data10.getGoogleNickName()) == null) {
                    str5 = str8;
                }
                switchAccountBean5.setNickName(str5);
                this.f19511d.setAuthCode(this.f19513f);
                SwitchAccountBean switchAccountBean6 = this.f19511d;
                UserData data11 = loginResult.getData();
                if (!(data11 == null || (areaCode = data11.getAreaCode()) == null)) {
                    str8 = areaCode;
                }
                switchAccountBean6.setAreaCode(str8);
                this.f19508a.l(this.f19509b, this.f19511d);
                s5.b h11 = this.f19508a.f19496a;
                if (h11 != null) {
                    h11.q0("0");
                    return;
                }
                return;
            }
            x.f12622a.w(this.f19509b, a.f19514a);
            s5.b h12 = this.f19508a.f19496a;
            if (h12 != null) {
                h12.q0("1");
            }
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (i.b("aaa100094", str)) {
                s5.b h10 = this.f19508a.f19496a;
                if (h10 != null) {
                    h10.q0("2");
                }
            } else if (i.b("aaa100028", str) || i.b("aaa100027", str)) {
                s5.b h11 = this.f19508a.f19496a;
                if (h11 != null) {
                    h11.q0("3");
                }
            } else {
                y.f12639a.c(str);
                s5.b h12 = this.f19508a.f19496a;
                if (h12 != null) {
                    h12.q0("1");
                }
            }
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f19515a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar) {
            super(1);
            this.f19515a = fVar;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(this.f19515a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f19516a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(f fVar) {
            super(1);
            this.f19516a = fVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f19516a, "增加账号记录失败！");
        }
    }

    public static final void m(u8.a aVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        i.g(aVar, "$activity");
        i.g(switchAccountBean, "$account");
        i.g(observableEmitter, "it");
        Context applicationContext = aVar.getApplicationContext();
        i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void n(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void a(u8.a aVar, e eVar) {
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f19496a;
        if (bVar != null) {
            bVar.f1();
        }
        SwitchAccountBean g10 = eVar.g();
        if (g10 == null) {
            s5.b bVar2 = this.f19496a;
            if (bVar2 != null) {
                bVar2.q0("1");
            }
        } else if (i.b(g10.getAccountType(), "google") || i.b(g10.getAccountType(), "facebook")) {
            k(aVar, eVar);
        } else {
            j(aVar, eVar);
        }
    }

    public void b(a aVar) {
        i.g(aVar, "logOutMethod");
        this.f19497b = aVar;
    }

    public void c(u8.a aVar, e eVar) {
        a aVar2;
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        if (eVar.d() && (aVar2 = this.f19497b) != null) {
            aVar2.c(aVar, eVar);
        }
    }

    public void d(s5.b bVar) {
        i.g(bVar, "callback");
        this.f19496a = bVar;
    }

    public final void j(u8.a aVar, e eVar) {
        SwitchAccountBean g10 = eVar.g();
        i.d(g10);
        String k10 = eVar.k();
        w wVar = new w();
        wVar.f19600a = g10.getAccountType();
        boolean z10 = false;
        k7.f.e("loginType:" + ((String) wVar.f19600a), new Object[0]);
        w wVar2 = new w();
        wVar2.f19600a = g10.getUserName();
        String password = g10.getPassword();
        String areaCode = g10.getAreaCode();
        String qrAuthCode = g10.getQrAuthCode();
        String verificationToken = g10.getVerificationToken();
        if (TextUtils.equals((CharSequence) wVar.f19600a, "4") && b0.K(verificationToken)) {
            wVar.f19600a = CdnType.DIGITAL_TYPE_PCDN;
        }
        if (i.b(wVar.f19600a, "7")) {
            if (qrAuthCode.length() > 0) {
                z10 = true;
            }
            if (z10) {
                wVar2.f19600a = qrAuthCode;
            }
        }
        w6.i.f9510g.b().W1((String) wVar.f19600a, areaCode, (String) wVar2.f19600a, password, k10, (String) null, verificationToken).compose(aVar.O1()).subscribe(new a(this, aVar, eVar, g10, wVar, wVar2, password, areaCode));
    }

    public final void k(u8.a aVar, e eVar) {
        SwitchAccountBean g10 = eVar.g();
        i.d(g10);
        String accountType = g10.getAccountType();
        String authCode = g10.getAuthCode();
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(accountType, authCode, "0", "1", (String) null, 16, (g) null)).compose(aVar.O1()).subscribe(new b(this, aVar, eVar, g10, accountType, authCode));
    }

    public final void l(u8.a aVar, SwitchAccountBean switchAccountBean) {
        Observable.create(new c(aVar, switchAccountBean)).compose(q.b()).subscribe(new d(new c(this)), new e(new d(this)));
    }
}
