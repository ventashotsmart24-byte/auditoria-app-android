package kotlinx.coroutines.internal;

import androidx.concurrent.futures.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18285a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public o(boolean z10) {
        this._cur = new p(8, z10);
    }

    public final boolean a(Object obj) {
        while (true) {
            p pVar = (p) this._cur;
            int a10 = pVar.a(obj);
            if (a10 == 0) {
                return true;
            }
            if (a10 == 1) {
                b.a(f18285a, this, pVar, pVar.i());
            } else if (a10 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            p pVar = (p) this._cur;
            if (!pVar.d()) {
                b.a(f18285a, this, pVar, pVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((p) this._cur).f();
    }

    public final Object d() {
        while (true) {
            p pVar = (p) this._cur;
            Object j10 = pVar.j();
            if (j10 != p.f18289h) {
                return j10;
            }
            b.a(f18285a, this, pVar, pVar.i());
        }
    }
}
