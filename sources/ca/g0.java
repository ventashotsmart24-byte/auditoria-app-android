package ca;

import h9.l;
import h9.m;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.f;

public abstract class g0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation continuation) {
        Object obj;
        if (continuation instanceof f) {
            return continuation.toString();
        }
        try {
            l.a aVar = l.f17317a;
            obj = l.a(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            l.a aVar2 = l.f17317a;
            obj = l.a(m.a(th));
        }
        Throwable b10 = l.b(obj);
        String str = obj;
        if (b10 != null) {
            str = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) str;
    }
}
