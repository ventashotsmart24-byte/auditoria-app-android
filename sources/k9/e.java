package k9;

import h9.l;
import h9.t;
import kotlin.coroutines.Continuation;
import l9.b;
import s9.p;
import t9.i;

public abstract class e {
    public static final void a(p pVar, Object obj, Continuation continuation) {
        i.g(pVar, "<this>");
        i.g(continuation, "completion");
        Continuation b10 = b.b(b.a(pVar, obj, continuation));
        l.a aVar = l.f17317a;
        b10.resumeWith(l.a(t.f17319a));
    }
}
