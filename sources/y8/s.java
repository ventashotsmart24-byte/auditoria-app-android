package y8;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeoutException;
import y8.k1;

public abstract class s {
    public static k1 a(r rVar) {
        Preconditions.checkNotNull(rVar, "context must not be null");
        if (!rVar.h()) {
            return null;
        }
        Throwable c10 = rVar.c();
        if (c10 == null) {
            return k1.f20042g.r("io.grpc.Context was cancelled without error");
        }
        if (c10 instanceof TimeoutException) {
            return k1.f20045j.r(c10.getMessage()).q(c10);
        }
        k1 l10 = k1.l(c10);
        if (!k1.b.UNKNOWN.equals(l10.n()) || l10.m() != c10) {
            return l10.q(c10);
        }
        return k1.f20042g.r("Context cancelled").q(c10);
    }
}
