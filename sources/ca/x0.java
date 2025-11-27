package ca;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import k9.f;
import kotlinx.coroutines.internal.d;

public final class x0 extends w0 implements j0 {

    /* renamed from: d  reason: collision with root package name */
    public final Executor f11562d;

    public x0(Executor executor) {
        this.f11562d = executor;
        d.a(P());
    }

    public void L(f fVar, Runnable runnable) {
        try {
            Executor P = P();
            c.a();
            P.execute(runnable);
        } catch (RejectedExecutionException e10) {
            c.a();
            O(fVar, e10);
            n0.b().L(fVar, runnable);
        }
    }

    public final void O(f fVar, RejectedExecutionException rejectedExecutionException) {
        j1.c(fVar, v0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor P() {
        return this.f11562d;
    }

    public void close() {
        ExecutorService executorService;
        Executor P = P();
        if (P instanceof ExecutorService) {
            executorService = (ExecutorService) P;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x0) || ((x0) obj).P() != P()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(P());
    }

    public String toString() {
        return P().toString();
    }
}
