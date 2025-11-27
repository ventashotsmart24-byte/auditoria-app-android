package g1;

import a1.k;
import android.content.Context;
import android.os.Build;
import f1.b;
import h1.l;
import j1.p;
import m1.a;

public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f6759e = k.f("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(l.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        if (pVar.f7098j.b() == a1.l.METERED) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public boolean c(b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            k.c().a(f6759e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !bVar.a();
        } else if (!bVar.a() || !bVar.b()) {
            return true;
        } else {
            return false;
        }
    }
}
