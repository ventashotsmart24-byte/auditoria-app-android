package ca;

import h9.l;
import t9.g;

public abstract class w {
    public static final Object a(Object obj, j jVar) {
        Throwable b10 = l.b(obj);
        if (b10 == null) {
            return obj;
        }
        return new s(b10, false, 2, (g) null);
    }

    public static final Object b(Object obj, s9.l lVar) {
        Throwable b10 = l.b(obj);
        if (b10 != null) {
            return new s(b10, false, 2, (g) null);
        }
        if (lVar != null) {
            return new t(obj, lVar);
        }
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, s9.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
