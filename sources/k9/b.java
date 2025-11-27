package k9;

import k9.f;
import s9.l;
import t9.i;

public abstract class b implements f.c {

    /* renamed from: a  reason: collision with root package name */
    public final l f18223a;

    /* renamed from: b  reason: collision with root package name */
    public final f.c f18224b;

    public b(f.c cVar, l lVar) {
        i.g(cVar, "baseKey");
        i.g(lVar, "safeCast");
        this.f18223a = lVar;
        this.f18224b = cVar instanceof b ? ((b) cVar).f18224b : cVar;
    }

    public final boolean a(f.c cVar) {
        i.g(cVar, "key");
        if (cVar == this || this.f18224b == cVar) {
            return true;
        }
        return false;
    }

    public final f.b b(f.b bVar) {
        i.g(bVar, "element");
        return (f.b) this.f18223a.invoke(bVar);
    }
}
