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
import t9.i;
import t9.j;

public final class o implements a {

    /* renamed from: a  reason: collision with root package name */
    public s5.b f19537a;

    /* renamed from: b  reason: collision with root package name */
    public a f19538b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f19539a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(o oVar) {
            super(1);
            this.f19539a = oVar;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(this.f19539a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f19540a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(o oVar) {
            super(1);
            this.f19540a = oVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f19540a, "增加账号记录失败！");
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f19541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u8.a f19542b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19543c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f19544a = new a();

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
            public final /* synthetic */ String f19545a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f19545a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f19545a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(o oVar, u8.a aVar, e eVar) {
            this.f19541a = oVar;
            this.f19542b = aVar;
            this.f19543c = eVar;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String a10;
            i.g(loginResult, "t");
            this.f19541a.c(this.f19542b, this.f19543c);
            UserData data = loginResult.getData();
            String str10 = null;
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
                bVar.E(this.f19542b, this.f19543c.h());
                u8.a aVar = this.f19542b;
                UserData data3 = loginResult.getData();
                i.d(data3);
                String h10 = this.f19543c.h();
                x7.a f10 = this.f19543c.f();
                if (f10 == null || (a10 = f10.a()) == null) {
                    str = "";
                } else {
                    str = a10;
                }
                d6.b.G(bVar, aVar, data3, "", "", h10, str, (String) null, false, 192, (Object) null);
                if (!TextUtils.isEmpty(this.f19543c.h())) {
                    UserData data4 = loginResult.getData();
                    if (data4 != null) {
                        str9 = data4.getPwdTip();
                    } else {
                        str9 = null;
                    }
                    if (i.b(str9, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (data5 != null) {
                            str10 = data5.getHasPwd();
                        }
                        if (i.b(str10, "1")) {
                            this.f19542b.startActivity(new Intent(this.f19542b, ForceChangePwdAty.class));
                            s5.b h11 = this.f19541a.f19537a;
                            if (h11 != null) {
                                h11.q0("4");
                                return;
                            }
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                switchAccountBean.setAccountType("google");
                UserData data6 = loginResult.getData();
                if (data6 == null || (str2 = data6.getGoogleEmail()) == null) {
                    str2 = "";
                }
                switchAccountBean.setUserName(str2);
                UserData data7 = loginResult.getData();
                if (data7 == null || (str3 = data7.getEmail()) == null) {
                    str3 = "";
                }
                switchAccountBean.setEmail(str3);
                UserData data8 = loginResult.getData();
                if (data8 == null || (str4 = data8.getMobile()) == null) {
                    str4 = "";
                }
                switchAccountBean.setPhone(str4);
                UserData data9 = loginResult.getData();
                if (data9 == null || (str5 = data9.getUserId()) == null) {
                    str5 = "";
                }
                switchAccountBean.setUserId(str5);
                UserData data10 = loginResult.getData();
                if (data10 == null || (str6 = data10.getGoogleNickName()) == null) {
                    str6 = "";
                }
                switchAccountBean.setNickName(str6);
                x7.a f11 = this.f19543c.f();
                if (f11 == null || (str7 = f11.a()) == null) {
                    str7 = "";
                }
                switchAccountBean.setAuthCode(str7);
                UserData data11 = loginResult.getData();
                if (data11 == null || (str8 = data11.getAreaCode()) == null) {
                    str8 = "";
                }
                switchAccountBean.setAreaCode(str8);
                switchAccountBean.setLogged(true);
                this.f19541a.j(this.f19542b, switchAccountBean);
                s5.b h12 = this.f19541a.f19537a;
                if (h12 != null) {
                    h12.q0("0");
                    return;
                }
                return;
            }
            x.f12622a.w(this.f19542b, a.f19544a);
            s5.b h13 = this.f19541a.f19537a;
            if (h13 != null) {
                h13.q0("1");
            }
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (i.b("aaa100094", str)) {
                s5.b h10 = this.f19541a.f19537a;
                if (h10 != null) {
                    h10.q0("2");
                }
            } else if (i.b("aaa100028", str) || i.b("aaa100027", str)) {
                s5.b h11 = this.f19541a.f19537a;
                if (h11 != null) {
                    h11.q0("3");
                }
            } else {
                y.f12639a.c(str);
                x.f12622a.w(this.f19542b, new b(str));
                s5.b h12 = this.f19541a.f19537a;
                if (h12 != null) {
                    h12.q0("1");
                }
            }
        }
    }

    public static final void k(u8.a aVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        i.g(aVar, "$activity");
        i.g(switchAccountBean, "$account");
        i.g(observableEmitter, "it");
        Context applicationContext = aVar.getApplicationContext();
        i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void l(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void a(u8.a aVar, e eVar) {
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f19537a;
        if (bVar != null) {
            bVar.f1();
        }
        n(aVar, eVar);
    }

    public void b(a aVar) {
        i.g(aVar, "logOutMethod");
        this.f19538b = aVar;
    }

    public void c(u8.a aVar, e eVar) {
        a aVar2;
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        if (eVar.d() && (aVar2 = this.f19538b) != null) {
            aVar2.c(aVar, eVar);
        }
    }

    public void d(s5.b bVar) {
        i.g(bVar, "callback");
        this.f19537a = bVar;
    }

    public final void j(u8.a aVar, SwitchAccountBean switchAccountBean) {
        Observable.create(new l(aVar, switchAccountBean)).compose(q.b()).subscribe(new m(new a(this)), new n(new b(this)));
    }

    public final void n(u8.a aVar, e eVar) {
        String str;
        w6.i b10 = w6.i.f9510g.b();
        String h10 = eVar.h();
        x7.a f10 = eVar.f();
        if (f10 == null || (str = f10.a()) == null) {
            str = "";
        }
        b10.Z1(new LoginThirdPartBean(h10, str, eVar.b(), eVar.j(), eVar.i())).compose(aVar.O1()).subscribe(new c(this, aVar, eVar));
    }
}
