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

public class a extends q {
    public a(j jVar, f fVar, String str, boolean z10, j jVar2) {
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
        return new a(this, dVar);
    }

    public e0.a k() {
        return e0.a.WRAPPER_ARRAY;
    }

    public Object t(k kVar, g gVar) {
        n nVar;
        Object d02;
        if (kVar.e() && (d02 = kVar.d0()) != null) {
            return m(kVar, gVar, d02);
        }
        boolean n02 = kVar.n0();
        String u10 = u(kVar, gVar);
        k3.k o10 = o(gVar, u10);
        if (this.f9711f && !v() && kVar.j0(n.START_OBJECT)) {
            y yVar = new y((o) null, false);
            yVar.v0();
            yVar.Z(this.f9710e);
            yVar.z0(u10);
            kVar.f();
            kVar = j3.k.F0(false, yVar.S0(kVar), kVar);
            kVar.s0();
        }
        if (n02 && kVar.n() == n.END_ARRAY) {
            return o10.getNullValue(gVar);
        }
        Object deserialize = o10.deserialize(kVar, gVar);
        if (n02 && kVar.s0() != (nVar = n.END_ARRAY)) {
            gVar.F0(r(), nVar, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
        }
        return deserialize;
    }

    public String u(k kVar, g gVar) {
        if (kVar.n0()) {
            n s02 = kVar.s0();
            n nVar = n.VALUE_STRING;
            if (s02 == nVar) {
                String Y = kVar.Y();
                kVar.s0();
                return Y;
            }
            gVar.F0(r(), nVar, "need JSON String that contains type id (for subtype of %s)", s());
            return null;
        } else if (this.f9709d != null) {
            return this.f9706a.e();
        } else {
            j r10 = r();
            n nVar2 = n.START_ARRAY;
            gVar.F0(r10, nVar2, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + s(), new Object[0]);
            return null;
        }
    }

    public boolean v() {
        return false;
    }

    public a(a aVar, d dVar) {
        super(aVar, dVar);
    }
}
