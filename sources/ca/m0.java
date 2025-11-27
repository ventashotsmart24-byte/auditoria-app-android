package ca;

import h9.l;
import h9.m;
import h9.t;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.f;

public abstract class m0 {
    public static final void a(l0 l0Var, int i10) {
        boolean z10;
        Continuation b10 = l0Var.b();
        if (i10 == 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || !(b10 instanceof f) || b(i10) != b(l0Var.f11512c)) {
            d(l0Var, b10, z10);
            return;
        }
        y yVar = ((f) b10).f18261d;
        k9.f context = b10.getContext();
        if (yVar.M(context)) {
            yVar.L(context, l0Var);
        } else {
            e(l0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final void d(l0 l0Var, Continuation continuation, boolean z10) {
        Object obj;
        Object f10 = l0Var.f();
        Throwable c10 = l0Var.c(f10);
        if (c10 != null) {
            l.a aVar = l.f17317a;
            obj = m.a(c10);
        } else {
            l.a aVar2 = l.f17317a;
            obj = l0Var.d(f10);
        }
        Object a10 = l.a(obj);
        if (z10) {
            f fVar = (f) continuation;
            Continuation continuation2 = fVar.f18262e;
            Object obj2 = fVar.f18264g;
            k9.f context = continuation2.getContext();
            Object c11 = c0.c(context, obj2);
            if (c11 != c0.f18251a) {
                x.f(continuation2, context, c11);
            }
            try {
                fVar.f18262e.resumeWith(a10);
                t tVar = t.f17319a;
            } finally {
                c0.a(context, c11);
            }
        } else {
            continuation.resumeWith(a10);
        }
    }

    public static final void e(l0 l0Var) {
        q0 a10 = w1.f11556a.a();
        if (a10.U()) {
            a10.Q(l0Var);
            return;
        }
        a10.S(true);
        try {
            d(l0Var, l0Var.b(), true);
            do {
            } while (a10.W());
        } catch (Throwable th) {
            a10.O(true);
            throw th;
        }
        a10.O(true);
    }
}
