package kotlinx.coroutines.internal;

import ca.g0;

public abstract class u {
    public abstract c a();

    public final boolean b(u uVar) {
        c a10;
        c a11 = a();
        if (a11 == null || (a10 = uVar.a()) == null || a11.f() >= a10.f()) {
            return false;
        }
        return true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return g0.a(this) + '@' + g0.b(this);
    }
}
