package k6;

import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.h0;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import h9.t;
import i6.e0;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BindPhoneResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.VerificationResult;
import na.f;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

public final class n1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f17956a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f17957b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n1 f17958a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17959b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17960c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17961d;

        /* renamed from: k6.n1$a$a  reason: collision with other inner class name */
        public static final class C0246a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w f17962a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0246a(w wVar) {
                super(1);
                this.f17962a = wVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d((String) this.f17962a.f19600a));
            }
        }

        public a(n1 n1Var, String str, String str2, String str3) {
            this.f17958a = n1Var;
            this.f17959b = str;
            this.f17960c = str2;
            this.f17961d = str3;
        }

        /* renamed from: f */
        public void onNext(BindPhoneResult bindPhoneResult) {
            i.g(bindPhoneResult, "t");
            this.f17958a.m().showLoading(false);
            i.c cVar = w6.i.f9510g;
            cVar.j0(this.f17959b);
            cVar.A0(this.f17960c);
            cVar.R(this.f17961d);
            f.k(this.f17958a.k(), "login_area_code", this.f17961d);
            this.f17958a.m().H();
            if (d6.b.f6366a.r()) {
                n0.f12601a.l(this.f17958a.k(), new String[]{"first_bind_mobile", "first_bind_area_code"}, new String[]{this.f17959b, this.f17961d});
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17958a.m().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17958a.m().showLoading(false);
            w wVar = new w();
            wVar.f19600a = y.f12639a.c(str);
            x.f12622a.w(this.f17958a.k(), new C0246a(wVar));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n1 f17963a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17965c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17966d;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w f17967a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(w wVar) {
                super(1);
                this.f17967a = wVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.f12639a.d((String) this.f17967a.f19600a));
            }
        }

        public b(n1 n1Var, String str, String str2, String str3) {
            this.f17963a = n1Var;
            this.f17964b = str;
            this.f17965c = str2;
            this.f17966d = str3;
        }

        /* renamed from: f */
        public void onNext(CheckVerificationResult checkVerificationResult) {
            t9.i.g(checkVerificationResult, "t");
            i.c cVar = w6.i.f9510g;
            cVar.A0(this.f17964b);
            cVar.R(this.f17965c);
            cVar.j0(this.f17966d);
            this.f17963a.m().showLoading(false);
            this.f17963a.m().X0();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17963a.m().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17963a.m().showLoading(false);
            w wVar = new w();
            wVar.f19600a = y.f12639a.c(str);
            x.f12622a.w(this.f17963a.k(), new a(wVar));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n1 f17968a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17969a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17969a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17969a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(n1 n1Var) {
            this.f17968a = n1Var;
        }

        /* renamed from: f */
        public void onNext(AreaCodeResult areaCodeResult) {
            String str;
            t9.i.g(areaCodeResult, "t");
            AreaCodeData data = areaCodeResult.getData();
            if (data == null || (str = data.getAreaCode()) == null) {
                str = "";
            }
            e0 m10 = this.f17968a.m();
            String a10 = h0.a(this.f17968a.k(), str);
            t9.i.f(a10, "getCountryByCode(context, areaCode)");
            m10.v(str, a10);
        }

        public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "fetch area code fail: " + str);
            y.f12639a.c(str);
            x.f12622a.w(this.f17968a.k(), new a(str));
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n1 f17970a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w f17971a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f17972b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ n1 f17973c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(w wVar, String str, n1 n1Var) {
                super(1);
                this.f17971a = wVar;
                this.f17972b = str;
                this.f17973c = n1Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                String d10 = y.f12639a.d((String) this.f17971a.f19600a);
                if (t9.i.b(this.f17971a.f19600a, "no_report_type") && t9.i.b(this.f17972b, "portal100060")) {
                    d10 = this.f17973c.k().getResources().getString(R.string.frequent_operation);
                    t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                }
                f1.f12517a.x(d10);
            }
        }

        public d(n1 n1Var) {
            this.f17970a = n1Var;
        }

        /* renamed from: f */
        public void onNext(VerificationResult verificationResult) {
            t9.i.g(verificationResult, "t");
            this.f17970a.m().showLoading(false);
            this.f17970a.m().P();
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17970a.m().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17970a.m().showLoading(false);
            this.f17970a.m().i2();
            w wVar = new w();
            wVar.f19600a = y.f12639a.c(str);
            x.f12622a.w(this.f17970a.k(), new a(wVar, str, this.f17970a));
        }
    }

    public n1(f5.c cVar, e0 e0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(e0Var, "view");
        this.f17956a = cVar;
        this.f17957b = e0Var;
    }

    public void e() {
        j();
    }

    public void g() {
    }

    public void h(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        w6.i.f9510g.b().c2(str, str2, str3, str4).compose(this.f17956a.O1()).subscribe(new a(this, str, str3, str2));
    }

    public void i(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "type");
        w6.i.f9510g.b().W0(str, str2, str3, str4).compose(this.f17956a.O1()).subscribe(new b(this, str3, str2, str));
    }

    public final void j() {
        w6.i.f9510g.b().O0().compose(this.f17956a.O1()).subscribe(new c(this));
    }

    public final f5.c k() {
        return this.f17956a;
    }

    public void l(String str, String str2, String str3) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "type");
        w6.i.f9510g.b().U1(str, str2, str3).compose(this.f17956a.O1()).subscribe(new d(this));
    }

    public final e0 m() {
        return this.f17957b;
    }
}
