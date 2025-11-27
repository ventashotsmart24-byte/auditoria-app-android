package k6;

import ba.t;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.utils.e;
import com.mobile.brasiltv.view.MineUpgradeDialog;
import com.mobile.brasiltv.view.dialog.SimpleDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.g;
import h9.h;
import i6.v0;
import t9.i;
import t9.j;
import w6.i;

public final class y3 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f7516a;

    /* renamed from: b  reason: collision with root package name */
    public final v0 f7517b;

    /* renamed from: c  reason: collision with root package name */
    public final g f7518c = h.b(b.f18207a);

    public static final class a implements h7.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y3 f18206a;

        public a(y3 y3Var) {
            this.f18206a = y3Var;
        }

        /* renamed from: a */
        public void onOver(UpdateBean updateBean) {
            i.g(updateBean, "result");
            this.f18206a.l().showLoading(false);
            new MineUpgradeDialog(this.f18206a.j(), updateBean).show();
            this.f18206a.l().R0(true);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th) {
            this.f18206a.l().showLoading(false);
            if (th instanceof NullPointerException) {
                String message = ((NullPointerException) th).getMessage();
                i.d(message);
                if (t.o(message, "Null is not a valid element", false, 2, (Object) null)) {
                    SimpleDialog simpleDialog = new SimpleDialog(this.f18206a.j());
                    simpleDialog.setMessage(R.string.no_update);
                    simpleDialog.show();
                    this.f18206a.l().R0(false);
                }
            }
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18207a = new b();

        public b() {
            super(0);
        }

        /* renamed from: b */
        public final c5.a invoke() {
            return new c5.a(new ja.c(".update"), new la.a(".update"));
        }
    }

    public y3(c cVar, v0 v0Var) {
        i.g(cVar, f.X);
        i.g(v0Var, "view");
        this.f7516a = cVar;
        this.f7517b = v0Var;
    }

    public void e() {
        v0 v0Var = this.f7517b;
        v0Var.J('V' + e.b(this.f7516a));
        xa.c.c().o(this);
    }

    public void g() {
        k().f();
        xa.c.c().r(this);
    }

    public void h() {
        String str;
        if (q5.i.f19305a.j(this.f7516a)) {
            str = this.f7516a.getString(R.string.msg_notify_on);
        } else {
            str = this.f7516a.getString(R.string.msg_notify_off);
        }
        i.f(str, "if (NotificationHelper.i…msg_notify_off)\n        }");
        this.f7517b.m0(str);
    }

    public void i() {
        this.f7517b.showLoading(true);
        k().f();
        c5.a k10 = k();
        c cVar = this.f7516a;
        i.c cVar2 = w6.i.f9510g;
        k10.g(cVar, cVar2.E(), cVar2.l(), new a(this));
    }

    public final c j() {
        return this.f7516a;
    }

    public final c5.a k() {
        return (c5.a) this.f7518c.getValue();
    }

    public final v0 l() {
        return this.f7517b;
    }

    @xa.j(sticky = true)
    public final void showUpdateNew(HasNewUpdateEvent hasNewUpdateEvent) {
        t9.i.g(hasNewUpdateEvent, "event");
        this.f7517b.R0(hasNewUpdateEvent.getHas());
    }
}
