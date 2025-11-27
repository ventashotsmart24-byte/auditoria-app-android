package o3;

import c3.k;
import c3.n;
import d4.h;
import java.lang.reflect.Constructor;
import k3.g;
import n3.t;
import w3.e;

public final class j extends t.a {

    /* renamed from: p  reason: collision with root package name */
    public final transient Constructor f8505p;

    public j(t tVar, Constructor constructor) {
        super(tVar);
        this.f8505p = constructor;
    }

    public t N(t tVar) {
        if (tVar == this.f8303o) {
            return this;
        }
        return new j(tVar, this.f8505p);
    }

    public void l(k kVar, g gVar, Object obj) {
        Object obj2;
        Object obj3;
        if (kVar.n() == n.VALUE_NULL) {
            obj2 = this.f8296g.getNullValue(gVar);
        } else {
            e eVar = this.f8297h;
            if (eVar != null) {
                obj2 = this.f8296g.deserializeWithType(kVar, gVar, eVar);
            } else {
                try {
                    obj3 = this.f8505p.newInstance(new Object[]{obj});
                } catch (Exception e10) {
                    h.m0(e10, String.format("Failed to instantiate class %s, problem: %s", new Object[]{this.f8505p.getDeclaringClass().getName(), e10.getMessage()}));
                    obj3 = null;
                }
                this.f8296g.deserialize(kVar, gVar, obj3);
                obj2 = obj3;
            }
        }
        C(obj, obj2);
    }

    public Object m(k kVar, g gVar, Object obj) {
        return D(obj, k(kVar, gVar));
    }
}
