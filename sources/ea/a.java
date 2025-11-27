package ea;

import h9.l;
import h9.m;
import h9.t;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.g;
import l9.b;
import s9.p;

public abstract class a {
    public static final void a(Continuation continuation, Throwable th) {
        l.a aVar = l.f17317a;
        continuation.resumeWith(l.a(m.a(th)));
        throw th;
    }

    public static final void b(Continuation continuation, Continuation continuation2) {
        try {
            Continuation b10 = b.b(continuation);
            l.a aVar = l.f17317a;
            g.c(b10, l.a(t.f17319a), (s9.l) null, 2, (Object) null);
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final void c(p pVar, Object obj, Continuation continuation, s9.l lVar) {
        try {
            Continuation b10 = b.b(b.a(pVar, obj, continuation));
            l.a aVar = l.f17317a;
            g.b(b10, l.a(t.f17319a), lVar);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, Continuation continuation, s9.l lVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, continuation, lVar);
    }
}
