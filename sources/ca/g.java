package ca;

import k9.f;
import s9.p;

public abstract /* synthetic */ class g {
    public static final f1 a(c0 c0Var, f fVar, e0 e0Var, p pVar) {
        a aVar;
        f d10 = x.d(c0Var, fVar);
        if (e0Var.c()) {
            aVar = new o1(d10, pVar);
        } else {
            aVar = new u1(d10, true);
        }
        aVar.v0(e0Var, aVar, pVar);
        return aVar;
    }

    public static /* synthetic */ f1 b(c0 c0Var, f fVar, e0 e0Var, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fVar = k9.g.f18231a;
        }
        if ((i10 & 2) != 0) {
            e0Var = e0.DEFAULT;
        }
        return f.a(c0Var, fVar, e0Var, pVar);
    }
}
