package d1;

import a1.k;
import android.content.Context;
import androidx.work.impl.background.systemalarm.a;
import b1.e;
import j1.p;

public class b implements e {

    /* renamed from: b  reason: collision with root package name */
    public static final String f6196b = k.f("SystemAlarmScheduler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f6197a;

    public b(Context context) {
        this.f6197a = context.getApplicationContext();
    }

    public boolean a() {
        return true;
    }

    public final void b(p pVar) {
        k.c().a(f6196b, String.format("Scheduling work with workSpecId %s", new Object[]{pVar.f7089a}), new Throwable[0]);
        this.f6197a.startService(a.f(this.f6197a, pVar.f7089a));
    }

    public void cancel(String str) {
        this.f6197a.startService(a.g(this.f6197a, str));
    }

    public void e(p... pVarArr) {
        for (p b10 : pVarArr) {
            b(b10);
        }
    }
}
