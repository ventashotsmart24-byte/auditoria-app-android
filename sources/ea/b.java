package ea;

import h9.l;
import h9.m;
import k9.f;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.c0;
import l9.c;
import m9.g;
import s9.p;
import t9.a0;

public abstract class b {
    public static final void a(p pVar, Object obj, Continuation continuation) {
        f context;
        Object c10;
        Continuation a10 = g.a(continuation);
        try {
            context = continuation.getContext();
            c10 = c0.c(context, (Object) null);
            Object invoke = ((p) a0.c(pVar, 2)).invoke(obj, a10);
            c0.a(context, c10);
            if (invoke != c.c()) {
                a10.resumeWith(l.a(invoke));
            }
        } catch (Throwable th) {
            l.a aVar = l.f17317a;
            a10.resumeWith(l.a(m.a(th)));
        }
    }
}
