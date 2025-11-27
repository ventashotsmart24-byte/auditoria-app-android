package k9;

import k9.f;
import kotlin.coroutines.Continuation;
import t9.i;

public interface d extends f.b {

    /* renamed from: e0  reason: collision with root package name */
    public static final b f18228e0 = b.f18229a;

    public static final class a {
        public static f.b a(d dVar, f.c cVar) {
            i.g(cVar, "key");
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                if (!bVar.a(dVar.getKey())) {
                    return null;
                }
                f.b b10 = bVar.b(dVar);
                if (b10 instanceof f.b) {
                    return b10;
                }
                return null;
            } else if (d.f18228e0 != cVar) {
                return null;
            } else {
                i.e(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return dVar;
            }
        }

        public static f b(d dVar, f.c cVar) {
            i.g(cVar, "key");
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                if (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) {
                    return dVar;
                }
                return g.f18231a;
            } else if (d.f18228e0 == cVar) {
                return g.f18231a;
            } else {
                return dVar;
            }
        }
    }

    public static final class b implements f.c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ b f18229a = new b();
    }

    void b(Continuation continuation);

    Continuation c(Continuation continuation);
}
