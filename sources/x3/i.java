package x3;

import b3.e0;
import c3.k;
import c3.n;
import c3.o;
import d4.y;
import k3.d;
import k3.g;
import k3.j;
import w3.e;
import w3.f;

public class i extends q {
    public i(j jVar, f fVar, String str, boolean z10, j jVar2) {
        super(jVar, fVar, str, z10, jVar2);
    }

    public Object c(k kVar, g gVar) {
        return t(kVar, gVar);
    }

    public Object d(k kVar, g gVar) {
        return t(kVar, gVar);
    }

    public Object e(k kVar, g gVar) {
        return t(kVar, gVar);
    }

    public Object f(k kVar, g gVar) {
        return t(kVar, gVar);
    }

    public e g(d dVar) {
        if (dVar == this.f9708c) {
            return this;
        }
        return new i(this, dVar);
    }

    public e0.a k() {
        return e0.a.WRAPPER_OBJECT;
    }

    public Object t(k kVar, g gVar) {
        Object d02;
        if (kVar.e() && (d02 = kVar.d0()) != null) {
            return m(kVar, gVar, d02);
        }
        n n10 = kVar.n();
        n nVar = n.START_OBJECT;
        if (n10 == nVar) {
            n s02 = kVar.s0();
            n nVar2 = n.FIELD_NAME;
            if (s02 != nVar2) {
                j r10 = r();
                gVar.F0(r10, nVar2, "need JSON String that contains type id (for subtype of " + s() + ")", new Object[0]);
            }
        } else if (n10 != n.FIELD_NAME) {
            j r11 = r();
            gVar.F0(r11, nVar, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + s(), new Object[0]);
        }
        String Y = kVar.Y();
        k3.k o10 = o(gVar, Y);
        kVar.s0();
        if (this.f9711f && kVar.j0(nVar)) {
            y yVar = new y((o) null, false);
            yVar.v0();
            yVar.Z(this.f9710e);
            yVar.z0(Y);
            kVar.f();
            kVar = j3.k.F0(false, yVar.S0(kVar), kVar);
            kVar.s0();
        }
        Object deserialize = o10.deserialize(kVar, gVar);
        n s03 = kVar.s0();
        n nVar3 = n.END_OBJECT;
        if (s03 != nVar3) {
            gVar.F0(r(), nVar3, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        }
        return deserialize;
    }

    public i(i iVar, d dVar) {
        super(iVar, dVar);
    }
}
