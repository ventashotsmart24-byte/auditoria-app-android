package ca;

import ea.b;
import h9.j;
import k9.e;
import kotlin.coroutines.Continuation;
import s9.l;
import s9.p;

public enum e0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11495a = null;

        static {
            int[] iArr = new int[e0.values().length];
            iArr[e0.DEFAULT.ordinal()] = 1;
            iArr[e0.ATOMIC.ordinal()] = 2;
            iArr[e0.UNDISPATCHED.ordinal()] = 3;
            iArr[e0.LAZY.ordinal()] = 4;
            f11495a = iArr;
        }
    }

    public final void b(p pVar, Object obj, Continuation continuation) {
        int i10 = a.f11495a[ordinal()];
        if (i10 == 1) {
            ea.a.d(pVar, obj, continuation, (l) null, 4, (Object) null);
        } else if (i10 == 2) {
            e.a(pVar, obj, continuation);
        } else if (i10 == 3) {
            b.a(pVar, obj, continuation);
        } else if (i10 != 4) {
            throw new j();
        }
    }

    public final boolean c() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }
}
