package kotlinx.coroutines.scheduling;

import ca.w0;
import ca.y;
import java.util.concurrent.Executor;
import k9.f;
import k9.g;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;
import y9.e;

public final class b extends w0 implements Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final b f18330d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final y f18331e = m.f18350c.N(b0.d("kotlinx.coroutines.io.parallelism", e.a(64, z.a()), 0, 0, 12, (Object) null));

    public void L(f fVar, Runnable runnable) {
        f18331e.L(fVar, runnable);
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void execute(Runnable runnable) {
        L(g.f18231a, runnable);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
