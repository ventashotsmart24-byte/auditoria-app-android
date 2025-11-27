package q0;

import t0.f;

public abstract class b extends k {
    public b(e eVar) {
        super(eVar);
    }

    public abstract void g(f fVar, Object obj);

    public final void h(Object obj) {
        f a10 = a();
        try {
            g(a10, obj);
            a10.executeInsert();
        } finally {
            f(a10);
        }
    }
}
