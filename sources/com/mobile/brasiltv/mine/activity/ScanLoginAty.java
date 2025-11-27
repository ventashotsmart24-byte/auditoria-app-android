package com.mobile.brasiltv.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.ExitScanPageEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.titans.entity.CdnType;
import e6.a1;
import e6.b1;
import e6.c1;
import e6.d1;
import e6.x0;
import e6.y0;
import e6.z0;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ma.q;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetQrData;
import mobile.com.requestframe.utils.response.GetQrResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s9.l;
import t9.i;
import t9.j;
import t9.z;
import w6.i;

public final class ScanLoginAty extends f5.c {

    /* renamed from: o  reason: collision with root package name */
    public static final a f12382o = new a((t9.g) null);

    /* renamed from: p  reason: collision with root package name */
    public static final String f12383p = "qr_token";

    /* renamed from: q  reason: collision with root package name */
    public static final String f12384q = "user_id";

    /* renamed from: k  reason: collision with root package name */
    public final h9.g f12385k = h9.h.b(new b(this));

    /* renamed from: l  reason: collision with root package name */
    public final h9.g f12386l = h9.h.b(new h(this));

    /* renamed from: m  reason: collision with root package name */
    public Disposable f12387m;

    /* renamed from: n  reason: collision with root package name */
    public Map f12388n = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return ScanLoginAty.f12383p;
        }

        public final String b() {
            return ScanLoginAty.f12384q;
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12389a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ScanLoginAty scanLoginAty) {
            super(0);
            this.f12389a = scanLoginAty;
        }

        public final String invoke() {
            String stringExtra = this.f12389a.getIntent().getStringExtra(ScanLoginAty.f12382o.a());
            return stringExtra == null ? "" : stringExtra;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12390a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ScanLoginAty scanLoginAty) {
            super(1);
            this.f12390a = scanLoginAty;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(this.f12390a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f17319a;
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12391a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ScanLoginAty scanLoginAty) {
            super(1);
            this.f12391a = scanLoginAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(this.f12391a, "增加账号记录失败！");
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12392a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ScanLoginAty scanLoginAty) {
            super(1);
            this.f12392a = scanLoginAty;
        }

        /* renamed from: b */
        public final ObservableSource invoke(Long l10) {
            i.g(l10, "it");
            String b32 = this.f12392a.b3();
            if (b32 != null) {
                return w6.i.f9510g.b().e2(b32);
            }
            return null;
        }
    }

    public static final class f extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12393a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f12394a = new a();

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
            public final /* synthetic */ String f12395a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f12395a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12395a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public f(ScanLoginAty scanLoginAty) {
            this.f12393a = scanLoginAty;
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
                            this.f12393a.o3();
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
                                    ScanLoginAty scanLoginAty = this.f12393a;
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
                                    scanLoginAty.i3(userInfo2, qrAuthCodeToken);
                                    xa.c.c().j(new UserIdentityChangeEvent());
                                    ((ProgressBar) this.f12393a.Y2(R$id.mPbLoading)).setVisibility(8);
                                    return;
                                }
                            }
                            x.f12622a.w(this.f12393a.Q1(), a.f12394a);
                            ((ProgressBar) this.f12393a.Y2(R$id.mPbLoading)).setVisibility(8);
                            return;
                        }
                        break;
                    case 52:
                        if (str.equals("4")) {
                            ((ProgressBar) this.f12393a.Y2(R$id.mPbLoading)).setVisibility(8);
                            f1.f12517a.w(R.string.scan_login_failed);
                            return;
                        }
                        break;
                    case 53:
                        if (str.equals(CdnType.DIGITAL_TYPE_PCDN)) {
                            ((ProgressBar) this.f12393a.Y2(R$id.mPbLoading)).setVisibility(8);
                            f1.f12517a.w(R.string.scan_qr_expired);
                            return;
                        }
                        break;
                }
            }
            ((ProgressBar) this.f12393a.Y2(R$id.mPbLoading)).setVisibility(8);
            f1.f12517a.w(R.string.scan_login_failed);
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12393a.n3(disposable);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f12393a.Q1()).show();
            } else {
                x.f12622a.w(this.f12393a.Q1(), new b(str));
            }
        }
    }

    public static final class g extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12396a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12397a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12397a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12397a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public g(ScanLoginAty scanLoginAty) {
            this.f12396a = scanLoginAty;
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            ((ProgressBar) this.f12396a.Y2(R$id.mPbLoading)).setVisibility(0);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            ((ProgressBar) this.f12396a.Y2(R$id.mPbLoading)).setVisibility(8);
            x.f12622a.w(this.f12396a.Q1(), new a(str));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f12396a.o3();
        }
    }

    public static final class h extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanLoginAty f12398a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ScanLoginAty scanLoginAty) {
            super(0);
            this.f12398a = scanLoginAty;
        }

        public final String invoke() {
            return this.f12398a.getIntent().getStringExtra(ScanLoginAty.f12382o.b());
        }
    }

    public static final void e3(ScanLoginAty scanLoginAty, View view) {
        i.g(scanLoginAty, "this$0");
        b0.c0(scanLoginAty, MainAty.class);
    }

    public static final void f3(ScanLoginAty scanLoginAty, View view) {
        i.g(scanLoginAty, "this$0");
        scanLoginAty.q3();
    }

    public static final void g3(ScanLoginAty scanLoginAty, View view) {
        i.g(scanLoginAty, "this$0");
        if (d6.b.f6366a.u(scanLoginAty)) {
            scanLoginAty.finish();
            xa.c.c().j(new ExitScanPageEvent());
            return;
        }
        b0.c0(scanLoginAty, MainAty.class);
    }

    public static final void k3(ScanLoginAty scanLoginAty, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        i.g(scanLoginAty, "this$0");
        i.g(switchAccountBean, "$account");
        i.g(observableEmitter, "it");
        Context applicationContext = scanLoginAty.Q1().getApplicationContext();
        i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void l3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource p3(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public View Y2(int i10) {
        Map map = this.f12388n;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final String b3() {
        return (String) this.f12385k.getValue();
    }

    public final String c3() {
        return (String) this.f12386l.getValue();
    }

    public final void d3() {
        ((TitleView) Y2(R$id.title_view)).setXClickListener(new x0(this));
        ((TextView) Y2(R$id.mTextConfirm)).setOnClickListener(new y0(this));
        ((TextView) Y2(R$id.mTextCancel)).setOnClickListener(new z0(this));
    }

    public final void h3() {
        ((TitleView) Y2(R$id.title_view)).setXVisible(0);
        z zVar = z.f19601a;
        String string = getResources().getString(R.string.try_to_login);
        i.f(string, "resources.getString(R.string.try_to_login)");
        String format = String.format(string, Arrays.copyOf(new Object[]{c3()}, 1));
        i.f(format, "format(format, *args)");
        ((TextView) Y2(R$id.mTextNotify)).setText(format);
    }

    public final void i3(UserData userData, String str) {
        UserData userData2 = userData;
        String str2 = str;
        i.g(userData2, Constants.KEY_USER_ID);
        i.g(str2, "qrAuthCode");
        k7.f.e("扫码登录成功 " + userData2, new Object[0]);
        d6.b bVar = d6.b.f6366a;
        bVar.E(this, "7");
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.A(), "") && !t9.i.b(userData.getRestrictedStatus(), cVar.A())) {
            xa.c.c().m(new UpdateRestrictEvent(userData.getRestrictedStatus(), false, 2, (t9.g) null));
        }
        String str3 = "";
        d6.b.G(bVar, this, userData, "", "", (String) null, (String) null, str, false, 176, (Object) null);
        if (TextUtils.isEmpty("7") || !t9.i.b(userData.getPwdTip(), "yes") || !t9.i.b(userData.getHasPwd(), "1")) {
            xa.c.c().j(new LoginSuccessEvent((String) null, 1, (t9.g) null));
            xa.c.c().m(new UpdateMineViewEvent());
            xa.c.c().m(new RequestAuthAndSlbEvent(false, (UserData) null, 3, (t9.g) null));
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
            j3(switchAccountBean);
            b0.c0(this, MainAty.class);
            return;
        }
        startActivity(new Intent(this, ForceChangePwdAty.class));
    }

    public final void j3(SwitchAccountBean switchAccountBean) {
        Observable.create(new b1(this, switchAccountBean)).compose(q.b()).subscribe(new c1(new c(this)), new d1(new d(this)));
    }

    public void k2() {
        n2();
    }

    public final void n3(Disposable disposable) {
        this.f12387m = disposable;
    }

    public final void o3() {
        Disposable disposable = this.f12387m;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable.timer(1, TimeUnit.SECONDS).flatMap(new a1(new e(this))).compose(O1()).subscribe(new f(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scan_login_confirm);
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        h3();
        d3();
    }

    public void onDestroy() {
        super.onDestroy();
        ((ProgressBar) Y2(R$id.mPbLoading)).setVisibility(8);
    }

    public final void q3() {
        String b32 = b3();
        if (b32 != null) {
            w6.i.f9510g.b().t2(b32).compose(O1()).subscribe(new g(this));
        }
    }
}
