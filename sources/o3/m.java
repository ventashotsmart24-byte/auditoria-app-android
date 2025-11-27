package o3;

import c3.k;
import java.util.Collection;
import java.util.Map;
import k3.f;
import k3.g;
import n3.t;

public final class m extends t.a {

    /* renamed from: p  reason: collision with root package name */
    public final String f8520p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f8521q;

    /* renamed from: r  reason: collision with root package name */
    public final t f8522r;

    public m(t tVar, String str, t tVar2, boolean z10) {
        super(tVar);
        this.f8520p = str;
        this.f8522r = tVar2;
        this.f8521q = z10;
    }

    public final void C(Object obj, Object obj2) {
        D(obj, obj2);
    }

    public Object D(Object obj, Object obj2) {
        if (obj2 != null) {
            if (!this.f8521q) {
                this.f8522r.C(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        this.f8522r.C(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object next : (Collection) obj2) {
                    if (next != null) {
                        this.f8522r.C(next, obj);
                    }
                }
            } else if (obj2 instanceof Map) {
                for (Object next2 : ((Map) obj2).values()) {
                    if (next2 != null) {
                        this.f8522r.C(next2, obj);
                    }
                }
            } else {
                throw new IllegalStateException("Unsupported container type (" + obj2.getClass().getName() + ") when resolving reference '" + this.f8520p + "'");
            }
        }
        return this.f8303o.D(obj, obj2);
    }

    public t N(t tVar) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    public void l(k kVar, g gVar, Object obj) {
        C(obj, this.f8303o.k(kVar, gVar));
    }

    public Object m(k kVar, g gVar, Object obj) {
        return D(obj, k(kVar, gVar));
    }

    public void o(f fVar) {
        this.f8303o.o(fVar);
        this.f8522r.o(fVar);
    }
}
