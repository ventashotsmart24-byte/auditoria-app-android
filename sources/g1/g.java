package g1;

import android.content.Context;
import android.os.Build;
import f1.b;
import h1.l;
import j1.p;
import m1.a;

public class g extends c {
    public g(Context context, a aVar) {
        super(l.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        if (pVar.f7098j.b() == a1.l.UNMETERED || (Build.VERSION.SDK_INT >= 30 && pVar.f7098j.b() == a1.l.TEMPORARILY_UNMETERED)) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public boolean c(b bVar) {
        if (!bVar.a() || bVar.b()) {
            return true;
        }
        return false;
    }
}
