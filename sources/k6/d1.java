package k6;

import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import i6.w;
import mobile.com.requestframe.utils.response.BaseResult;
import s9.l;
import t9.i;
import t9.j;
import v5.g;
import w5.m;

public final class d1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f17669a;

    /* renamed from: b  reason: collision with root package name */
    public final w f17670b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d1 f17671a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17672b;

        /* renamed from: k6.d1$a$a  reason: collision with other inner class name */
        public static final class C0239a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17673a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0239a(String str) {
                super(1);
                this.f17673a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f17673a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(d1 d1Var, String str) {
            this.f17671a = d1Var;
            this.f17672b = str;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f17671a.j().showLoading(false);
            x.f12622a.w(this.f17671a.i(), new C0239a(str));
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            this.f17671a.j().showLoading(false);
            String str = this.f17672b;
            m mVar = m.f19701a;
            if (i.b(str, mVar.J())) {
                g.f19670a.w(0);
            } else if (i.b(this.f17672b, mVar.D())) {
                g.f19670a.q(0);
            }
            this.f17671a.j().J1(this.f17672b);
        }
    }

    public d1(c cVar, w wVar) {
        i.g(cVar, f.X);
        i.g(wVar, "view");
        this.f17669a = cVar;
        this.f17670b = wVar;
    }

    public void e() {
    }

    public void g() {
    }

    public void h(String str) {
        i.g(str, "messageType");
        this.f17670b.showLoading(true);
        w6.i.f9510g.b().Y0(str).compose(this.f17669a.O1()).subscribe(new a(this, str));
    }

    public final c i() {
        return this.f17669a;
    }

    public final w j() {
        return this.f17670b;
    }
}
