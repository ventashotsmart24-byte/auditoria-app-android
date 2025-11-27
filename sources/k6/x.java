package k6;

import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import i6.o;
import io.reactivex.disposables.Disposable;
import ma.m;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import s9.l;
import t9.i;
import t9.j;

public final class x implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f18168a;

    /* renamed from: b  reason: collision with root package name */
    public final o f18169b;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f18170a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18171b;

        /* renamed from: k6.x$a$a  reason: collision with other inner class name */
        public static final class C0252a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18172a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0252a(String str) {
                super(1);
                this.f18172a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18172a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(x xVar, String str) {
            this.f18170a = xVar;
            this.f18171b = str;
        }

        /* renamed from: f */
        public void onNext(PwdCheckResult pwdCheckResult) {
            i.g(pwdCheckResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = m.e(this.f18171b);
            i.f(e10, "md5(pwd)");
            memberInfo.putPassword(e10, false);
            this.f18170a.j().showLoading(false);
            this.f18170a.j().O0();
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18170a.j().showLoading(true);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18170a.j().showLoading(false);
            if (b0.T(str, "aaa100012")) {
                this.f18170a.j().R(R.string.pwd_wrong);
            } else if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                this.f18170a.j().R(R.string.pi_connect_timeout);
            } else {
                com.mobile.brasiltv.utils.x.f12622a.w(this.f18170a.i(), new C0252a(str));
            }
        }
    }

    public x(c cVar, o oVar) {
        i.g(cVar, f.X);
        i.g(oVar, "view");
        this.f18168a = cVar;
        this.f18169b = oVar;
    }

    public void e() {
    }

    public void g() {
    }

    public void h(String str) {
        i.g(str, "pwd");
        w6.i b10 = w6.i.f9510g.b();
        String e10 = m.e(str);
        i.f(e10, "md5(pwd)");
        b10.d2(e10).compose(this.f18168a.O1()).subscribe(new a(this, str));
    }

    public final c i() {
        return this.f18168a;
    }

    public final o j() {
        return this.f18169b;
    }
}
