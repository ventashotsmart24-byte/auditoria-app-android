package g1;

import android.content.Context;
import android.os.Build;
import f1.b;
import h1.l;
import j1.p;
import m1.a;

public class d extends c {
    public d(Context context, a aVar) {
        super(l.c(context, aVar).d());
    }

    public boolean b(p pVar) {
        if (pVar.f7098j.b() == a1.l.CONNECTED) {
            return true;
        }
        return false;
    }

    /* renamed from: i */
    public boolean c(b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return !bVar.a();
        }
        if (!bVar.a() || !bVar.d()) {
            return true;
        }
        return false;
    }
}
