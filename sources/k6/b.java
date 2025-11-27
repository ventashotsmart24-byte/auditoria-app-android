package k6;

import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import io.reactivex.disposables.Disposable;
import java.util.List;
import mobile.com.requestframe.utils.bean.BindBean;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.BindThirdPart;
import mobile.com.requestframe.utils.response.BindThirdPartResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import s5.e;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

public final class b implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f17573a;

    /* renamed from: b  reason: collision with root package name */
    public final i6.c f17574b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17575a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17576b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x7.a f17577c;

        /* renamed from: k6.b$a$a  reason: collision with other inner class name */
        public static final class C0235a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0235a f17578a = new C0235a();

            public C0235a() {
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

        /* renamed from: k6.b$a$b  reason: collision with other inner class name */
        public static final class C0236b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17579a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0236b(String str) {
                super(1);
                this.f17579a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17579a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(b bVar, String str, x7.a aVar) {
            this.f17575a = bVar;
            this.f17576b = str;
            this.f17577c = aVar;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            i.g(loginResult, "t");
            this.f17575a.l().showLoading(false);
            this.f17575a.l().q();
            this.f17575a.l().t(false);
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
                bVar.E(this.f17575a.k(), this.f17576b);
                c k10 = this.f17575a.k();
                UserData data3 = loginResult.getData();
                i.d(data3);
                d6.b.G(bVar, k10, data3, "", "", this.f17576b, this.f17577c.a(), (String) null, false, 192, (Object) null);
                if (!TextUtils.isEmpty(this.f17576b)) {
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
                            b0.c0(this.f17575a.k(), ForceChangePwdAty.class);
                            e.f19464a.o(s5.c.THIRD_PART_LOGIN, this.f17576b, this.f17577c, "0", "2", (String) null);
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
                xa.c.c().j(new CloseForcePageEvent());
                xa.c.c().j(new GotoHomeTabEvent(0));
                b0.c0(this.f17575a.k(), MainAty.class);
                return;
            }
            x.f12622a.w(this.f17575a.k(), C0235a.f17578a);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17575a.l().showLoading(false);
            this.f17575a.l().q();
            this.f17575a.l().t(false);
            if (i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17575a.k()).show();
            } else {
                x.f12622a.w(this.f17575a.k(), new C0236b(str));
            }
        }
    }

    /* renamed from: k6.b$b  reason: collision with other inner class name */
    public static final class C0237b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17580a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17581b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x7.a f17582c;

        /* renamed from: k6.b$b$a */
        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17583a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17583a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17583a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public C0237b(b bVar, String str, x7.a aVar) {
            this.f17580a = bVar;
            this.f17581b = str;
            this.f17582c = aVar;
        }

        /* renamed from: f */
        public void onNext(BindThirdPartResult bindThirdPartResult) {
            String str;
            String googlePhotoUrl;
            i.g(bindThirdPartResult, "t");
            if (d6.b.f6366a.t()) {
                this.f17580a.i(this.f17581b, this.f17582c);
                return;
            }
            this.f17580a.l().showLoading(false);
            this.f17580a.l().q();
            this.f17580a.l().t(false);
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
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17580a.l().showLoading(true);
            this.f17580a.l().t(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17580a.l().showLoading(false);
            this.f17580a.l().q();
            this.f17580a.l().t(false);
            if (b0.T(str, "portal100076")) {
                this.f17580a.l().n(R.string.am_google_been_bound);
            } else {
                x.f12622a.w(this.f17580a.k(), new a(str));
            }
        }
    }

    public b(c cVar, i6.c cVar2) {
        t9.i.g(cVar, f.X);
        t9.i.g(cVar2, "view");
        this.f17573a = cVar;
        this.f17574b = cVar2;
    }

    public void e() {
    }

    public void g() {
    }

    public final void i(String str, x7.a aVar) {
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(str, aVar.a(), "0", "2", (String) null, 16, (g) null)).compose(this.f17573a.O1()).subscribe(new a(this, str, aVar));
    }

    public void j(String str, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(aVar, "socialInfo");
        i.c cVar = w6.i.f9510g;
        cVar.b().R0(new BindBean(cVar.H(), cVar.J(), cVar.v(), str, aVar.a())).compose(this.f17573a.O1()).subscribe(new C0237b(this, str, aVar));
    }

    public final c k() {
        return this.f17573a;
    }

    public final i6.c l() {
        return this.f17574b;
    }
}
