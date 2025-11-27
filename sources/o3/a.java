package o3;

import c3.k;
import c3.n;
import d4.q;
import java.util.Set;
import k3.f;
import k3.g;
import k3.h;
import n3.d;
import n3.t;
import r3.j;

public class a extends d {

    /* renamed from: v  reason: collision with root package name */
    public final d f8448v;

    /* renamed from: w  reason: collision with root package name */
    public final t[] f8449w;

    /* renamed from: x  reason: collision with root package name */
    public final j f8450x;

    /* renamed from: y  reason: collision with root package name */
    public final k3.j f8451y;

    public a(d dVar, k3.j jVar, t[] tVarArr, j jVar2) {
        super(dVar);
        this.f8448v = dVar;
        this.f8451y = jVar;
        this.f8449w = tVarArr;
        this.f8450x = jVar2;
    }

    public d G(c cVar) {
        return new a(this.f8448v.G(cVar), this.f8451y, this.f8449w, this.f8450x);
    }

    public d H(Set set, Set set2) {
        return new a(this.f8448v.H(set, set2), this.f8451y, this.f8449w, this.f8450x);
    }

    public d I(boolean z10) {
        return new a(this.f8448v.I(z10), this.f8451y, this.f8449w, this.f8450x);
    }

    public d J(s sVar) {
        return new a(this.f8448v.J(sVar), this.f8451y, this.f8449w, this.f8450x);
    }

    public Object M(k kVar, g gVar) {
        return gVar.d0(getValueType(gVar), kVar.n(), kVar, "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", this.f8232a.q().getName(), kVar.n());
    }

    public Object N(k kVar, g gVar) {
        Class cls;
        if (this.f8238g) {
            return u(kVar, gVar);
        }
        Object x10 = this.f8234c.x(gVar);
        if (this.f8241j != null) {
            E(gVar, x10);
        }
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        t[] tVarArr = this.f8449w;
        int length = tVarArr.length;
        int i10 = 0;
        while (true) {
            n s02 = kVar.s0();
            n nVar = n.END_ARRAY;
            if (s02 == nVar) {
                return x10;
            }
            if (i10 == length) {
                if (!this.f8245n && gVar.n0(h.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    gVar.G0(this, nVar, "Unexpected JSON value(s); expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                }
                while (kVar.s0() != n.END_ARRAY) {
                    kVar.D0();
                }
                return x10;
            }
            t tVar = tVarArr[i10];
            i10++;
            if (tVar == null || (cls != null && !tVar.H(cls))) {
                kVar.D0();
            } else {
                try {
                    tVar.m(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, tVar.getName(), gVar);
                }
            }
        }
    }

    public final Object O(g gVar, Object obj) {
        try {
            return this.f8450x.m().invoke(obj, (Object[]) null);
        } catch (Exception e10) {
            return L(e10, gVar);
        }
    }

    public final Object c(k kVar, g gVar) {
        Class cls;
        t tVar;
        v vVar = this.f8237f;
        y e10 = vVar.e(kVar, gVar, this.f8251t);
        t[] tVarArr = this.f8449w;
        int length = tVarArr.length;
        if (this.f8246o) {
            cls = gVar.J();
        } else {
            cls = null;
        }
        Object obj = null;
        int i10 = 0;
        while (kVar.s0() != n.END_ARRAY) {
            if (i10 < length) {
                tVar = tVarArr[i10];
            } else {
                tVar = null;
            }
            if (tVar == null) {
                kVar.D0();
            } else if (cls != null && !tVar.H(cls)) {
                kVar.D0();
            } else if (obj != null) {
                try {
                    obj = tVar.m(kVar, gVar, obj);
                } catch (Exception e11) {
                    K(e11, obj, tVar.getName(), gVar);
                }
            } else {
                String name = tVar.getName();
                t d10 = vVar.d(name);
                if (!e10.i(name) || d10 != null) {
                    if (d10 == null) {
                        e10.e(tVar, tVar.k(kVar, gVar));
                    } else if (e10.b(d10, d10.k(kVar, gVar))) {
                        try {
                            obj = vVar.a(gVar, e10);
                            if (obj.getClass() != this.f8232a.q()) {
                                k3.j jVar = this.f8232a;
                                return gVar.q(jVar, String.format("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type %s, actual type %s", new Object[]{d4.h.G(jVar), obj.getClass().getName()}));
                            }
                        } catch (Exception e12) {
                            K(e12, this.f8232a.q(), name, gVar);
                        }
                    } else {
                        continue;
                    }
                }
            }
            i10++;
        }
        if (obj != null) {
            return obj;
        }
        try {
            return vVar.a(gVar, e10);
        } catch (Exception e13) {
            return L(e13, gVar);
        }
    }

    public Object deserialize(k kVar, g gVar) {
        if (!kVar.n0()) {
            return O(gVar, M(kVar, gVar));
        }
        if (!this.f8239h) {
            return O(gVar, N(kVar, gVar));
        }
        Object x10 = this.f8234c.x(gVar);
        t[] tVarArr = this.f8449w;
        int length = tVarArr.length;
        int i10 = 0;
        while (kVar.s0() != n.END_ARRAY) {
            if (i10 == length) {
                if (!this.f8245n && gVar.n0(h.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    gVar.w0(handledType(), "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                }
                while (kVar.s0() != n.END_ARRAY) {
                    kVar.D0();
                }
                return O(gVar, x10);
            }
            t tVar = tVarArr[i10];
            if (tVar != null) {
                try {
                    x10 = tVar.m(kVar, gVar, x10);
                } catch (Exception e10) {
                    K(e10, x10, tVar.getName(), gVar);
                }
            } else {
                kVar.D0();
            }
            i10++;
        }
        return O(gVar, x10);
    }

    public d n() {
        return this;
    }

    public Object s(k kVar, g gVar) {
        return M(kVar, gVar);
    }

    public Boolean supportsUpdate(f fVar) {
        return Boolean.FALSE;
    }

    public k3.k unwrappingDeserializer(q qVar) {
        return this.f8448v.unwrappingDeserializer(qVar);
    }

    public Object deserialize(k kVar, g gVar, Object obj) {
        return this.f8448v.deserialize(kVar, gVar, obj);
    }
}
