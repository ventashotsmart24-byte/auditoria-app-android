package g1;

import a1.k;
import android.content.Context;
import android.os.Build;
import f1.b;
import h1.l;
import j1.p;
import m1.a;

public class f extends c {

    /* renamed from: e  reason: collision with root package name */
    public static final String f6760e = k.f("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(l.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        if (pVar.f7098j.b() == a1.l.NOT_ROAMING) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public boolean c(b bVar) {
        if (Build.VERSION.SDK_INT < 24) {
            k.c().a(f6760e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar.a();
        } else if (!bVar.a() || !bVar.c()) {
            return true;
        } else {
            return false;
        }
    }
}
