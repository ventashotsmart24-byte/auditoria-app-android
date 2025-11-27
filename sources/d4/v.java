package d4;

import c4.b;
import java.io.Serializable;
import k3.j;
import k3.x;
import m3.m;

public class v implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public transient n f6309a = new n(20, 200);

    public x a(Class cls, m mVar) {
        b bVar = new b(cls);
        x xVar = (x) this.f6309a.get(bVar);
        if (xVar != null) {
            return xVar;
        }
        x S = mVar.g().S(mVar.A(cls).u());
        if (S == null || !S.e()) {
            S = x.a(cls.getSimpleName());
        }
        this.f6309a.a(bVar, S);
        return S;
    }

    public x b(j jVar, m mVar) {
        return a(jVar.q(), mVar);
    }
}
