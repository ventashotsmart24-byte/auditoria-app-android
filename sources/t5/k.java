package t5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.taobao.accs.common.Constants;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ma.q;
import mobile.com.requestframe.utils.response.GetQrData;
import mobile.com.requestframe.utils.response.GetQrResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s5.e;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

public final class k implements a {

    /* renamed from: a  reason: collision with root package name */
    public Disposable f19522a;

    /* renamed from: b  reason: collision with root package name */
    public s5.b f19523b;

    /* renamed from: c  reason: collision with root package name */
    public a f19524c;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19525a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar) {
            super(1);
            this.f19525a = kVar;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(this.f19525a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19526a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k kVar) {
            super(1);
            this.f19526a = kVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f19526a, "增加账号记录失败！");
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f19527a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(1);
            this.f19527a = eVar;
        }

        /* renamed from: b */
        public final ObservableSource invoke(Long l10) {
            i.g(l10, "it");
            return w6.i.f9510g.b().e2(this.f19527a.e());
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f19528a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u8.a f19529b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19530c;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f19531a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.u(y.p(y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f19532a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f19532a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String p10 = y.p(yVar, this.f19532a, (String) null, (String) null, 6, (Object) null);
                yVar.c(this.f19532a);
                f1.f12517a.x(p10);
            }
        }

        public d(k kVar, u8.a aVar, e eVar) {
            this.f19528a = kVar;
            this.f19529b = aVar;
            this.f19530c = eVar;
        }

        /* renamed from: f */
        public void onNext(GetQrResult getQrResult) {
            String str;
            boolean z10;
            i.g(getQrResult, "t");
            GetQrData data = getQrResult.getData();
            if (data != null) {
                str = data.getStatus();
            } else {
                str = null;
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case 49:
                        if (str.equals("1")) {
                            return;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            this.f19528a.q(this.f19529b, this.f19530c);
                            return;
                        }
                        break;
                    case 51:
                        if (str.equals("3")) {
                            GetQrData data2 = getQrResult.getData();
                            i.d(data2);
                            if (data2.getUserInfo() != null) {
                                GetQrData data3 = getQrResult.getData();
                                i.d(data3);
                                UserData userInfo = data3.getUserInfo();
                                i.d(userInfo);
                                List<PortalCodeList> portalCodeList = userInfo.getPortalCodeList();
                                if (portalCodeList == null || portalCodeList.isEmpty()) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (!z10) {
                                    this.f19528a.c(this.f19529b, this.f19530c);
                                    k kVar = this.f19528a;
                                    u8.a aVar = this.f19529b;
                                    GetQrData data4 = getQrResult.getData();
                                    i.d(data4);
                                    UserData userInfo2 = data4.getUserInfo();
                                    i.d(userInfo2);
                                    GetQrData data5 = getQrResult.getData();
                                    i.d(data5);
                                    String qrAuthCodeToken = data5.getQrAuthCodeToken();
                                    if (qrAuthCodeToken == null) {
                                        qrAuthCodeToken = "";
                                    }
                                    kVar.l(aVar, userInfo2, qrAuthCodeToken);
                                    xa.c.c().j(new UserIdentityChangeEvent());
                                    s5.b i10 = this.f19528a.f19523b;
                                    if (i10 != null) {
                                        i10.q0("0");
                                        return;
                                    }
                                    return;
                                }
                            }
                            x.f12622a.w(this.f19529b, a.f19531a);
                            return;
                        }
                        break;
                }
            }
            s5.b i11 = this.f19528a.f19523b;
            if (i11 != null) {
                i11.q0("1");
            }
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f19528a.f19522a = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (i.b("aaa100094", str)) {
                s5.b i10 = this.f19528a.f19523b;
                if (i10 != null) {
                    i10.q0("2");
                }
            } else if (i.b("aaa100028", str) || i.b("aaa100027", str)) {
                s5.b i11 = this.f19528a.f19523b;
                if (i11 != null) {
                    i11.q0("3");
                }
            } else {
                x.f12622a.w(this.f19529b, new b(str));
                s5.b i12 = this.f19528a.f19523b;
                if (i12 != null) {
                    i12.q0("1");
                }
            }
        }
    }

    public static final void n(u8.a aVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        i.g(aVar, "$activity");
        i.g(switchAccountBean, "$account");
        i.g(observableEmitter, "it");
        Context applicationContext = aVar.getApplicationContext();
        i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void o(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void p(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource r(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public void a(u8.a aVar, e eVar) {
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f19523b;
        if (bVar != null) {
            bVar.f1();
        }
        q(aVar, eVar);
    }

    public void b(a aVar) {
        i.g(aVar, "logOutMethod");
        this.f19524c = aVar;
    }

    public void c(u8.a aVar, e eVar) {
        a aVar2;
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        if (eVar.d() && (aVar2 = this.f19524c) != null) {
            aVar2.c(aVar, eVar);
        }
    }

    public void d(s5.b bVar) {
        i.g(bVar, "callback");
        this.f19523b = bVar;
    }

    public final void l(u8.a aVar, UserData userData, String str) {
        u8.a aVar2 = aVar;
        String str2 = str;
        i.g(aVar2, "activity");
        i.g(userData, Constants.KEY_USER_ID);
        i.g(str2, "qrAuthCode");
        d6.b bVar = d6.b.f6366a;
        bVar.E(aVar2, "7");
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.A(), "") && !t9.i.b(userData.getRestrictedStatus(), cVar.A())) {
            xa.c.c().m(new UpdateRestrictEvent(userData.getRestrictedStatus(), false, 2, (g) null));
        }
        String str3 = "";
        d6.b.G(bVar, aVar, userData, "", "", (String) null, (String) null, str, false, 176, (Object) null);
        if (TextUtils.isEmpty("7") || !t9.i.b(userData.getPwdTip(), "yes") || !t9.i.b(userData.getHasPwd(), "1")) {
            xa.c.c().j(new LoginSuccessEvent((String) null, 1, (g) null));
            xa.c.c().m(new UpdateMineViewEvent());
            xa.c.c().m(new RequestAuthAndSlbEvent(false, (UserData) null, 3, (g) null));
            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
            switchAccountBean.setUserName(userData.getUserId());
            switchAccountBean.setUserId(userData.getUserId());
            switchAccountBean.setQrAuthCode(str2);
            switchAccountBean.setAccountType("7");
            String areaCode = userData.getAreaCode();
            if (areaCode == null) {
                areaCode = str3;
            }
            switchAccountBean.setAreaCode(areaCode);
            String email = userData.getEmail();
            if (email == null) {
                email = str3;
            }
            switchAccountBean.setEmail(email);
            String mobile2 = userData.getMobile();
            if (mobile2 == null) {
                mobile2 = str3;
            }
            switchAccountBean.setPhone(mobile2);
            switchAccountBean.setLogged(true);
            m(aVar2, switchAccountBean);
            return;
        }
        aVar2.startActivity(new Intent(aVar2, ForceChangePwdAty.class));
        s5.b bVar2 = this.f19523b;
        if (bVar2 != null) {
            bVar2.q0("4");
        }
    }

    public final void m(u8.a aVar, SwitchAccountBean switchAccountBean) {
        Observable.create(new h(aVar, switchAccountBean)).compose(q.b()).subscribe(new i(new a(this)), new j(new b(this)));
    }

    public final void q(u8.a aVar, e eVar) {
        Disposable disposable = this.f19522a;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable.timer(1, TimeUnit.SECONDS).flatMap(new g(new c(eVar))).compose(aVar.O1()).subscribe(new d(this, aVar, eVar));
    }
}
