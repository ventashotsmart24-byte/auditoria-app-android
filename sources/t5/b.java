package t5;

import k7.f;
import mobile.com.requestframe.utils.response.BaseResult;
import s5.e;
import t9.i;
import w6.i;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public s5.b f19490a;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f19491a;

        public a(b bVar) {
            this.f19491a = bVar;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            s5.b e10 = this.f19491a.f19490a;
            if (e10 != null) {
                e10.q0("1");
            }
        }

        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
            f.e("登出成功", new Object[0]);
            s5.b e10 = this.f19491a.f19490a;
            if (e10 != null) {
                e10.q0("0");
            }
        }
    }

    public void a(u8.a aVar, e eVar) {
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f19490a;
        if (bVar != null) {
            bVar.f1();
        }
        s5.b bVar2 = this.f19490a;
        if (bVar2 != null) {
            bVar2.q0("1");
        }
    }

    public void b(a aVar) {
        i.g(aVar, "logOutMethod");
    }

    public void c(u8.a aVar, e eVar) {
        boolean z10;
        i.g(aVar, "activity");
        i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f19490a;
        if (bVar != null) {
            bVar.f1();
        }
        i.c cVar = w6.i.f9510g;
        boolean z11 = true;
        if (cVar.H().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (cVar.J().length() != 0) {
                z11 = false;
            }
            if (!z11) {
                cVar.b().b2().compose(aVar.O1()).subscribe(new a(this));
                return;
            }
        }
        s5.b bVar2 = this.f19490a;
        if (bVar2 != null) {
            bVar2.q0("0");
        }
    }

    public void d(s5.b bVar) {
        t9.i.g(bVar, "callback");
        this.f19490a = bVar;
    }
}
