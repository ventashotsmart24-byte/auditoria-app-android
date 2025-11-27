package x3;

import b3.e0;
import c3.k;
import c3.n;
import d4.y;
import k3.d;
import k3.h;
import k3.j;
import k3.q;
import w3.e;
import w3.f;

public class g extends a {

    /* renamed from: i  reason: collision with root package name */
    public final e0.a f9687i;

    /* renamed from: j  reason: collision with root package name */
    public final String f9688j;

    public g(j jVar, f fVar, String str, boolean z10, j jVar2, e0.a aVar) {
        super(jVar, fVar, str, z10, jVar2);
        String str2;
        d dVar = this.f9708c;
        if (dVar == null) {
            str2 = String.format("missing type id property '%s'", new Object[]{this.f9710e});
        } else {
            str2 = String.format("missing type id property '%s' (for POJO property '%s')", new Object[]{this.f9710e, dVar.getName()});
        }
        this.f9688j = str2;
        this.f9687i = aVar;
    }

    public Object c(k kVar, k3.g gVar) {
        if (kVar.j0(n.START_ARRAY)) {
            return super.d(kVar, gVar);
        }
        return e(kVar, gVar);
    }

    public Object e(k kVar, k3.g gVar) {
        Object d02;
        if (kVar.e() && (d02 = kVar.d0()) != null) {
            return m(kVar, gVar, d02);
        }
        n n10 = kVar.n();
        y yVar = null;
        if (n10 == n.START_OBJECT) {
            n10 = kVar.s0();
        } else if (n10 != n.FIELD_NAME) {
            return x(kVar, gVar, (y) null, this.f9688j);
        }
        boolean o02 = gVar.o0(q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (n10 == n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            if (m10.equals(this.f9710e) || (o02 && m10.equalsIgnoreCase(this.f9710e))) {
                return w(kVar, gVar, yVar, kVar.Y());
            }
            if (yVar == null) {
                yVar = new y(kVar, gVar);
            }
            yVar.Z(m10);
            yVar.V0(kVar);
            n10 = kVar.s0();
        }
        return x(kVar, gVar, yVar, this.f9688j);
    }

    public e g(d dVar) {
        if (dVar == this.f9708c) {
            return this;
        }
        return new g(this, dVar);
    }

    public e0.a k() {
        return this.f9687i;
    }

    public Object w(k kVar, k3.g gVar, y yVar, String str) {
        k3.k o10 = o(gVar, str);
        if (this.f9711f) {
            if (yVar == null) {
                yVar = new y(kVar, gVar);
            }
            yVar.Z(kVar.m());
            yVar.z0(str);
        }
        if (yVar != null) {
            kVar.f();
            kVar = j3.k.F0(false, yVar.S0(kVar), kVar);
        }
        if (kVar.n() != n.END_OBJECT) {
            kVar.s0();
        }
        return o10.deserialize(kVar, gVar);
    }

    public Object x(k kVar, k3.g gVar, y yVar, String str) {
        if (!l()) {
            Object b10 = e.b(kVar, gVar, this.f9707b);
            if (b10 != null) {
                return b10;
            }
            if (kVar.n0()) {
                return super.c(kVar, gVar);
            }
            if (kVar.j0(n.VALUE_STRING) && gVar.n0(h.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && kVar.Y().trim().isEmpty()) {
                return null;
            }
        }
        k3.k n10 = n(gVar);
        if (n10 == null) {
            j p10 = p(gVar, str);
            if (p10 == null) {
                return null;
            }
            n10 = gVar.D(p10, this.f9708c);
        }
        if (yVar != null) {
            yVar.W();
            kVar = yVar.S0(kVar);
            kVar.s0();
        }
        return n10.deserialize(kVar, gVar);
    }

    public g(g gVar, d dVar) {
        super(gVar, dVar);
        String str;
        d dVar2 = this.f9708c;
        if (dVar2 == null) {
            str = String.format("missing type id property '%s'", new Object[]{this.f9710e});
        } else {
            str = String.format("missing type id property '%s' (for POJO property '%s')", new Object[]{this.f9710e, dVar2.getName()});
        }
        this.f9688j = str;
        this.f9687i = gVar.f9687i;
    }
}
