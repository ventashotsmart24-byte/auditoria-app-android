package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import c4.f;
import java.io.IOException;
import java.util.EnumMap;
import k3.d;
import k3.g;
import k3.h;
import k3.j;
import k3.k;
import k3.p;
import n3.i;
import n3.q;
import n3.r;
import n3.t;
import n3.w;
import o3.s;
import o3.v;
import o3.y;
import w3.e;

public class l extends i implements i, r {

    /* renamed from: e  reason: collision with root package name */
    public final Class f5640e;

    /* renamed from: f  reason: collision with root package name */
    public p f5641f;

    /* renamed from: g  reason: collision with root package name */
    public k f5642g;

    /* renamed from: h  reason: collision with root package name */
    public final e f5643h;

    /* renamed from: i  reason: collision with root package name */
    public final w f5644i;

    /* renamed from: j  reason: collision with root package name */
    public k f5645j;

    /* renamed from: k  reason: collision with root package name */
    public v f5646k;

    public l(j jVar, w wVar, p pVar, k kVar, e eVar, q qVar) {
        super(jVar, qVar, (Boolean) null);
        this.f5640e = jVar.p().q();
        this.f5641f = pVar;
        this.f5642g = kVar;
        this.f5643h = eVar;
        this.f5644i = wVar;
    }

    public k a() {
        return this.f5642g;
    }

    public EnumMap c(c3.k kVar, g gVar) {
        String str;
        Object obj;
        v vVar = this.f5646k;
        y e10 = vVar.e(kVar, gVar, (s) null);
        if (kVar.o0()) {
            str = kVar.q0();
        } else if (kVar.j0(n.FIELD_NAME)) {
            str = kVar.m();
        } else {
            str = null;
        }
        while (str != null) {
            n s02 = kVar.s0();
            t d10 = vVar.d(str);
            if (d10 == null) {
                Enum enumR = (Enum) this.f5641f.a(str, gVar);
                if (enumR != null) {
                    try {
                        if (s02 != n.VALUE_NULL) {
                            e eVar = this.f5643h;
                            if (eVar == null) {
                                obj = this.f5642g.deserialize(kVar, gVar);
                            } else {
                                obj = this.f5642g.deserializeWithType(kVar, gVar, eVar);
                            }
                        } else if (!this.f5625c) {
                            obj = this.f5624b.getNullValue(gVar);
                        }
                        e10.d(enumR, obj);
                    } catch (Exception e11) {
                        b(gVar, e11, this.f5623a.q(), str);
                        return null;
                    }
                } else if (!gVar.n0(h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    return (EnumMap) gVar.j0(this.f5640e, str, "value not one of declared Enum instance names for %s", this.f5623a.p());
                } else {
                    kVar.s0();
                    kVar.D0();
                }
            } else if (e10.b(d10, d10.k(kVar, gVar))) {
                kVar.s0();
                try {
                    return deserialize(kVar, gVar, (EnumMap) vVar.a(gVar, e10));
                } catch (Exception e12) {
                    return (EnumMap) b(gVar, e12, this.f5623a.q(), str);
                }
            }
            str = kVar.q0();
        }
        try {
            return (EnumMap) vVar.a(gVar, e10);
        } catch (Exception e13) {
            b(gVar, e13, this.f5623a.q(), str);
            return null;
        }
    }

    public k createContextual(g gVar, d dVar) {
        k kVar;
        p pVar = this.f5641f;
        if (pVar == null) {
            pVar = gVar.F(this.f5623a.p(), dVar);
        }
        k kVar2 = this.f5642g;
        j k10 = this.f5623a.k();
        if (kVar2 == null) {
            kVar = gVar.D(k10, dVar);
        } else {
            kVar = gVar.Z(kVar2, dVar, k10);
        }
        e eVar = this.f5643h;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        return g(pVar, kVar, eVar, findContentNullProvider(gVar, dVar, kVar));
    }

    public EnumMap d(g gVar) {
        w wVar = this.f5644i;
        if (wVar == null) {
            return new EnumMap(this.f5640e);
        }
        try {
            if (wVar.j()) {
                return (EnumMap) this.f5644i.x(gVar);
            }
            return (EnumMap) gVar.W(handledType(), getValueInstantiator(), (c3.k) null, "no default constructor found", new Object[0]);
        } catch (IOException e10) {
            return (EnumMap) d4.h.g0(gVar, e10);
        }
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.e(kVar, gVar);
    }

    /* renamed from: e */
    public EnumMap deserialize(c3.k kVar, g gVar) {
        if (this.f5646k != null) {
            return c(kVar, gVar);
        }
        k kVar2 = this.f5645j;
        if (kVar2 != null) {
            return (EnumMap) this.f5644i.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        int q10 = kVar.q();
        if (!(q10 == 1 || q10 == 2)) {
            if (q10 == 3) {
                return (EnumMap) _deserializeFromArray(kVar, gVar);
            }
            if (q10 != 5) {
                if (q10 != 6) {
                    return (EnumMap) gVar.c0(getValueType(gVar), kVar);
                }
                return (EnumMap) _deserializeFromString(kVar, gVar);
            }
        }
        return deserialize(kVar, gVar, d(gVar));
    }

    /* renamed from: f */
    public EnumMap deserialize(c3.k kVar, g gVar, EnumMap enumMap) {
        String str;
        Object obj;
        kVar.A0(enumMap);
        k kVar2 = this.f5642g;
        e eVar = this.f5643h;
        if (kVar.o0()) {
            str = kVar.q0();
        } else {
            n n10 = kVar.n();
            n nVar = n.FIELD_NAME;
            if (n10 != nVar) {
                if (n10 == n.END_OBJECT) {
                    return enumMap;
                }
                gVar.G0(this, nVar, (String) null, new Object[0]);
            }
            str = kVar.m();
        }
        while (str != null) {
            Enum enumR = (Enum) this.f5641f.a(str, gVar);
            n s02 = kVar.s0();
            if (enumR != null) {
                try {
                    if (s02 == n.VALUE_NULL) {
                        if (!this.f5625c) {
                            obj = this.f5624b.getNullValue(gVar);
                        }
                    } else if (eVar == null) {
                        obj = kVar2.deserialize(kVar, gVar);
                    } else {
                        obj = kVar2.deserializeWithType(kVar, gVar, eVar);
                    }
                    enumMap.put(enumR, obj);
                } catch (Exception e10) {
                    return (EnumMap) b(gVar, e10, enumMap, str);
                }
            } else if (!gVar.n0(h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return (EnumMap) gVar.j0(this.f5640e, str, "value not one of declared Enum instance names for %s", this.f5623a.p());
            } else {
                kVar.D0();
            }
            str = kVar.q0();
        }
        return enumMap;
    }

    public l g(p pVar, k kVar, e eVar, q qVar) {
        if (pVar == this.f5641f && qVar == this.f5624b && kVar == this.f5642g && eVar == this.f5643h) {
            return this;
        }
        return new l(this, pVar, kVar, eVar, qVar);
    }

    public Object getEmptyValue(g gVar) {
        return d(gVar);
    }

    public w getValueInstantiator() {
        return this.f5644i;
    }

    public boolean isCachable() {
        if (this.f5642g == null && this.f5641f == null && this.f5643h == null) {
            return true;
        }
        return false;
    }

    public f logicalType() {
        return f.Map;
    }

    public void resolve(g gVar) {
        w wVar = this.f5644i;
        if (wVar == null) {
            return;
        }
        if (wVar.k()) {
            j D = this.f5644i.D(gVar.k());
            if (D == null) {
                j jVar = this.f5623a;
                gVar.q(jVar, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{jVar, this.f5644i.getClass().getName()}));
            }
            this.f5645j = findDeserializer(gVar, D, (d) null);
        } else if (this.f5644i.i()) {
            j A = this.f5644i.A(gVar.k());
            if (A == null) {
                j jVar2 = this.f5623a;
                gVar.q(jVar2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{jVar2, this.f5644i.getClass().getName()}));
            }
            this.f5645j = findDeserializer(gVar, A, (d) null);
        } else if (this.f5644i.g()) {
            this.f5646k = v.c(gVar, this.f5644i, this.f5644i.E(gVar.k()), gVar.o0(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
    }

    public l(l lVar, p pVar, k kVar, e eVar, q qVar) {
        super((i) lVar, qVar, lVar.f5626d);
        this.f5640e = lVar.f5640e;
        this.f5641f = pVar;
        this.f5642g = kVar;
        this.f5643h = eVar;
        this.f5644i = lVar.f5644i;
        this.f5645j = lVar.f5645j;
        this.f5646k = lVar.f5646k;
    }
}
