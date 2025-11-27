package h9;

import h9.l;
import t9.i;

public abstract class m {
    public static final Object a(Throwable th) {
        i.g(th, "exception");
        return new l.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof l.b) {
            throw ((l.b) obj).f17318a;
        }
    }
}
