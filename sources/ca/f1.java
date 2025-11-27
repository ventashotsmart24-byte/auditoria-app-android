package ca;

import java.util.concurrent.CancellationException;
import k9.f;
import s9.l;
import s9.p;

public interface f1 extends f.b {

    /* renamed from: a0  reason: collision with root package name */
    public static final b f11497a0 = b.f11498a;

    public static final class a {
        public static /* synthetic */ void a(f1 f1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    cancellationException = null;
                }
                f1Var.q(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static Object b(f1 f1Var, Object obj, p pVar) {
            return f.b.a.a(f1Var, obj, pVar);
        }

        public static f.b c(f1 f1Var, f.c cVar) {
            return f.b.a.b(f1Var, cVar);
        }

        public static /* synthetic */ o0 d(f1 f1Var, boolean z10, boolean z11, l lVar, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    z10 = false;
                }
                if ((i10 & 2) != 0) {
                    z11 = true;
                }
                return f1Var.u(z10, z11, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static f e(f1 f1Var, f.c cVar) {
            return f.b.a.c(f1Var, cVar);
        }

        public static f f(f1 f1Var, f fVar) {
            return f.b.a.d(f1Var, fVar);
        }
    }

    public static final class b implements f.c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ b f11498a = new b();
    }

    o0 e(l lVar);

    CancellationException f();

    boolean isActive();

    void q(CancellationException cancellationException);

    boolean start();

    o0 u(boolean z10, boolean z11, l lVar);

    n x(p pVar);
}
