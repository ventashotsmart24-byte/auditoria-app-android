package kotlinx.coroutines.internal;

import ca.f1;
import ca.q0;
import ca.w;
import ca.w1;
import ca.x;
import h9.l;
import h9.m;
import h9.t;
import java.util.concurrent.CancellationException;
import k9.f;
import kotlin.coroutines.Continuation;
import s9.l;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final y f18269a = new y("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final y f18270b = new y("REUSABLE_CLAIMED");

    public static final void b(Continuation continuation, Object obj, l lVar) {
        boolean z10;
        f context;
        Object c10;
        if (continuation instanceof f) {
            f fVar = (f) continuation;
            Object b10 = w.b(obj, lVar);
            if (fVar.f18261d.M(fVar.getContext())) {
                fVar.f18263f = b10;
                fVar.f11512c = 1;
                fVar.f18261d.L(fVar.getContext(), fVar);
                return;
            }
            q0 a10 = w1.f11556a.a();
            if (a10.U()) {
                fVar.f18263f = b10;
                fVar.f11512c = 1;
                a10.Q(fVar);
                return;
            }
            a10.S(true);
            try {
                f1 f1Var = (f1) fVar.getContext().a(f1.f11497a0);
                if (f1Var == null || f1Var.isActive()) {
                    z10 = false;
                } else {
                    CancellationException f10 = f1Var.f();
                    fVar.a(b10, f10);
                    l.a aVar = h9.l.f17317a;
                    fVar.resumeWith(h9.l.a(m.a(f10)));
                    z10 = true;
                }
                if (!z10) {
                    Continuation continuation2 = fVar.f18262e;
                    Object obj2 = fVar.f18264g;
                    context = continuation2.getContext();
                    c10 = c0.c(context, obj2);
                    if (c10 != c0.f18251a) {
                        x.f(continuation2, context, c10);
                    }
                    fVar.f18262e.resumeWith(obj);
                    t tVar = t.f17319a;
                    c0.a(context, c10);
                }
                do {
                } while (a10.W());
            } catch (Throwable th) {
                try {
                    fVar.e(th, (Throwable) null);
                } catch (Throwable th2) {
                    a10.O(true);
                    throw th2;
                }
            }
            a10.O(true);
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, s9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(continuation, obj, lVar);
    }
}
