package com.fasterxml.jackson.databind.deser.std;

import b3.p;
import b3.s;
import c3.n;
import d4.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.d;
import k3.f;
import k3.g;
import k3.j;
import k3.k;
import k3.p;
import n3.i;
import n3.q;
import n3.r;
import n3.t;
import n3.u;
import n3.w;
import o3.v;
import o3.y;
import o3.z;
import w3.e;

public class s extends i implements i, r {

    /* renamed from: e  reason: collision with root package name */
    public final p f5667e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5668f;

    /* renamed from: g  reason: collision with root package name */
    public final k f5669g;

    /* renamed from: h  reason: collision with root package name */
    public final e f5670h;

    /* renamed from: i  reason: collision with root package name */
    public final w f5671i;

    /* renamed from: j  reason: collision with root package name */
    public k f5672j;

    /* renamed from: k  reason: collision with root package name */
    public v f5673k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f5674l;

    /* renamed from: m  reason: collision with root package name */
    public Set f5675m;

    /* renamed from: n  reason: collision with root package name */
    public Set f5676n;

    /* renamed from: o  reason: collision with root package name */
    public m.a f5677o;

    public static class a extends z.a {

        /* renamed from: c  reason: collision with root package name */
        public final b f5678c;

        /* renamed from: d  reason: collision with root package name */
        public final Map f5679d = new LinkedHashMap();

        /* renamed from: e  reason: collision with root package name */
        public final Object f5680e;

        public a(b bVar, u uVar, Class cls, Object obj) {
            super(uVar, cls);
            this.f5678c = bVar;
            this.f5680e = obj;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class f5681a;

        /* renamed from: b  reason: collision with root package name */
        public Map f5682b;

        /* renamed from: c  reason: collision with root package name */
        public List f5683c = new ArrayList();

        public b(Class cls, Map map) {
            this.f5681a = cls;
            this.f5682b = map;
        }

        public z.a a(u uVar, Object obj) {
            a aVar = new a(this, uVar, this.f5681a, obj);
            this.f5683c.add(aVar);
            return aVar;
        }

        public void b(Object obj, Object obj2) {
            if (this.f5683c.isEmpty()) {
                this.f5682b.put(obj, obj2);
                return;
            }
            List list = this.f5683c;
            ((a) list.get(list.size() - 1)).f5679d.put(obj, obj2);
        }
    }

    public s(j jVar, w wVar, p pVar, k kVar, e eVar) {
        super(jVar, (q) null, (Boolean) null);
        this.f5667e = pVar;
        this.f5669g = kVar;
        this.f5670h = eVar;
        this.f5671i = wVar;
        this.f5674l = wVar.j();
        this.f5672j = null;
        this.f5673k = null;
        this.f5668f = d(jVar, pVar);
        this.f5677o = null;
    }

    public k a() {
        return this.f5669g;
    }

    public Map c(c3.k kVar, g gVar) {
        String str;
        Object obj;
        v vVar = this.f5673k;
        y e10 = vVar.e(kVar, gVar, (o3.s) null);
        k kVar2 = this.f5669g;
        e eVar = this.f5670h;
        if (kVar.o0()) {
            str = kVar.q0();
        } else if (kVar.j0(n.FIELD_NAME)) {
            str = kVar.m();
        } else {
            str = null;
        }
        while (str != null) {
            n s02 = kVar.s0();
            m.a aVar = this.f5677o;
            if (aVar == null || !aVar.b(str)) {
                t d10 = vVar.d(str);
                if (d10 == null) {
                    Object a10 = this.f5667e.a(str, gVar);
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
                        e10.d(a10, obj);
                    } catch (Exception e11) {
                        b(gVar, e11, this.f5623a.q(), str);
                        return null;
                    }
                } else if (e10.b(d10, d10.k(kVar, gVar))) {
                    kVar.s0();
                    try {
                        Map map = (Map) vVar.a(gVar, e10);
                        e(kVar, gVar, map);
                        return map;
                    } catch (Exception e12) {
                        return (Map) b(gVar, e12, this.f5623a.q(), str);
                    }
                }
            } else {
                kVar.D0();
            }
            str = kVar.q0();
        }
        try {
            return (Map) vVar.a(gVar, e10);
        } catch (Exception e13) {
            b(gVar, e13, this.f5623a.q(), str);
            return null;
        }
    }

    public k createContextual(g gVar, d dVar) {
        k kVar;
        HashSet hashSet;
        Set set;
        r3.i d10;
        Set<String> e10;
        p pVar = this.f5667e;
        if (pVar == null) {
            pVar = gVar.F(this.f5623a.p(), dVar);
        }
        p pVar2 = pVar;
        k kVar2 = this.f5669g;
        if (dVar != null) {
            kVar2 = findConvertingContentDeserializer(gVar, dVar, kVar2);
        }
        j k10 = this.f5623a.k();
        if (kVar2 == null) {
            kVar = gVar.D(k10, dVar);
        } else {
            kVar = gVar.Z(kVar2, dVar, k10);
        }
        k kVar3 = kVar;
        e eVar = this.f5670h;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        e eVar2 = eVar;
        Set set2 = this.f5675m;
        Set set3 = this.f5676n;
        k3.b K = gVar.K();
        if (b0._neitherNull(K, dVar) && (d10 = dVar.d()) != null) {
            f N = gVar.k();
            p.a K2 = K.K(N, d10);
            if (K2 != null) {
                Set<String> g10 = K2.g();
                if (!g10.isEmpty()) {
                    if (set2 == null) {
                        set2 = new HashSet();
                    } else {
                        set2 = new HashSet(set2);
                    }
                    for (String add : g10) {
                        set2.add(add);
                    }
                }
            }
            s.a N2 = K.N(N, d10);
            if (!(N2 == null || (e10 = N2.e()) == null)) {
                HashSet hashSet2 = new HashSet();
                if (set3 == null) {
                    hashSet2 = new HashSet(e10);
                } else {
                    for (String str : e10) {
                        if (set3.contains(str)) {
                            hashSet2.add(str);
                        }
                    }
                }
                hashSet = hashSet2;
                set = set2;
                return o(pVar2, eVar2, kVar3, findContentNullProvider(gVar, dVar, kVar3), set, hashSet);
            }
        }
        set = set2;
        hashSet = set3;
        return o(pVar2, eVar2, kVar3, findContentNullProvider(gVar, dVar, kVar3), set, hashSet);
    }

    public final boolean d(j jVar, k3.p pVar) {
        j p10;
        if (pVar == null || (p10 = jVar.p()) == null) {
            return true;
        }
        Class<Object> q10 = p10.q();
        if ((q10 == String.class || q10 == Object.class) && isDefaultKeyDeserializer(pVar)) {
            return true;
        }
        return false;
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.e(kVar, gVar);
    }

    public final void e(c3.k kVar, g gVar, Map map) {
        boolean z10;
        b bVar;
        String str;
        Object obj;
        k3.p pVar = this.f5667e;
        k kVar2 = this.f5669g;
        e eVar = this.f5670h;
        if (kVar2.getObjectIdReader() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            bVar = new b(this.f5623a.k().q(), map);
        } else {
            bVar = null;
        }
        if (kVar.o0()) {
            str = kVar.q0();
        } else {
            n n10 = kVar.n();
            n nVar = n.FIELD_NAME;
            if (n10 != nVar) {
                if (n10 != n.END_OBJECT) {
                    gVar.G0(this, nVar, (String) null, new Object[0]);
                } else {
                    return;
                }
            }
            str = kVar.m();
        }
        while (str != null) {
            Object a10 = pVar.a(str, gVar);
            n s02 = kVar.s0();
            m.a aVar = this.f5677o;
            if (aVar == null || !aVar.b(str)) {
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
                    if (z10) {
                        bVar.b(a10, obj);
                    } else {
                        map.put(a10, obj);
                    }
                } catch (u e10) {
                    l(gVar, bVar, a10, e10);
                } catch (Exception e11) {
                    b(gVar, e11, map, str);
                }
            } else {
                kVar.D0();
            }
            str = kVar.q0();
        }
    }

    public final void f(c3.k kVar, g gVar, Map map) {
        boolean z10;
        b bVar;
        String str;
        Object obj;
        k kVar2 = this.f5669g;
        e eVar = this.f5670h;
        if (kVar2.getObjectIdReader() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            bVar = new b(this.f5623a.k().q(), map);
        } else {
            bVar = null;
        }
        if (kVar.o0()) {
            str = kVar.q0();
        } else {
            n n10 = kVar.n();
            if (n10 != n.END_OBJECT) {
                n nVar = n.FIELD_NAME;
                if (n10 != nVar) {
                    gVar.G0(this, nVar, (String) null, new Object[0]);
                }
                str = kVar.m();
            } else {
                return;
            }
        }
        while (str != null) {
            n s02 = kVar.s0();
            m.a aVar = this.f5677o;
            if (aVar == null || !aVar.b(str)) {
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
                    if (z10) {
                        bVar.b(str, obj);
                    } else {
                        map.put(str, obj);
                    }
                } catch (u e10) {
                    l(gVar, bVar, str, e10);
                } catch (Exception e11) {
                    b(gVar, e11, map, str);
                }
            } else {
                kVar.D0();
            }
            str = kVar.q0();
        }
    }

    public final void g(c3.k kVar, g gVar, Map map) {
        String str;
        Object obj;
        k3.p pVar = this.f5667e;
        k kVar2 = this.f5669g;
        e eVar = this.f5670h;
        if (kVar.o0()) {
            str = kVar.q0();
        } else {
            n n10 = kVar.n();
            if (n10 != n.END_OBJECT) {
                n nVar = n.FIELD_NAME;
                if (n10 != nVar) {
                    gVar.G0(this, nVar, (String) null, new Object[0]);
                }
                str = kVar.m();
            } else {
                return;
            }
        }
        while (str != null) {
            Object a10 = pVar.a(str, gVar);
            n s02 = kVar.s0();
            m.a aVar = this.f5677o;
            if (aVar == null || !aVar.b(str)) {
                try {
                    if (s02 != n.VALUE_NULL) {
                        Object obj2 = map.get(a10);
                        if (obj2 != null) {
                            if (eVar == null) {
                                obj = kVar2.deserialize(kVar, gVar, obj2);
                            } else {
                                obj = kVar2.deserializeWithType(kVar, gVar, eVar, obj2);
                            }
                        } else if (eVar == null) {
                            obj = kVar2.deserialize(kVar, gVar);
                        } else {
                            obj = kVar2.deserializeWithType(kVar, gVar, eVar);
                        }
                        if (obj != obj2) {
                            map.put(a10, obj);
                        }
                    } else if (!this.f5625c) {
                        map.put(a10, this.f5624b.getNullValue(gVar));
                    }
                } catch (Exception e10) {
                    b(gVar, e10, map, str);
                }
            } else {
                kVar.D0();
            }
            str = kVar.q0();
        }
    }

    public w getValueInstantiator() {
        return this.f5671i;
    }

    public j getValueType() {
        return this.f5623a;
    }

    public final void h(c3.k kVar, g gVar, Map map) {
        String str;
        Object obj;
        k kVar2 = this.f5669g;
        e eVar = this.f5670h;
        if (kVar.o0()) {
            str = kVar.q0();
        } else {
            n n10 = kVar.n();
            if (n10 != n.END_OBJECT) {
                n nVar = n.FIELD_NAME;
                if (n10 != nVar) {
                    gVar.G0(this, nVar, (String) null, new Object[0]);
                }
                str = kVar.m();
            } else {
                return;
            }
        }
        while (str != null) {
            n s02 = kVar.s0();
            m.a aVar = this.f5677o;
            if (aVar == null || !aVar.b(str)) {
                try {
                    if (s02 != n.VALUE_NULL) {
                        Object obj2 = map.get(str);
                        if (obj2 != null) {
                            if (eVar == null) {
                                obj = kVar2.deserialize(kVar, gVar, obj2);
                            } else {
                                obj = kVar2.deserializeWithType(kVar, gVar, eVar, obj2);
                            }
                        } else if (eVar == null) {
                            obj = kVar2.deserialize(kVar, gVar);
                        } else {
                            obj = kVar2.deserializeWithType(kVar, gVar, eVar);
                        }
                        if (obj != obj2) {
                            map.put(str, obj);
                        }
                    } else if (!this.f5625c) {
                        map.put(str, this.f5624b.getNullValue(gVar));
                    }
                } catch (Exception e10) {
                    b(gVar, e10, map, str);
                }
            } else {
                kVar.D0();
            }
            str = kVar.q0();
        }
    }

    /* renamed from: i */
    public Map deserialize(c3.k kVar, g gVar) {
        if (this.f5673k != null) {
            return c(kVar, gVar);
        }
        k kVar2 = this.f5672j;
        if (kVar2 != null) {
            return (Map) this.f5671i.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (!this.f5674l) {
            return (Map) gVar.W(k(), getValueInstantiator(), kVar, "no default constructor found", new Object[0]);
        }
        int q10 = kVar.q();
        if (!(q10 == 1 || q10 == 2)) {
            if (q10 == 3) {
                return (Map) _deserializeFromArray(kVar, gVar);
            }
            if (q10 != 5) {
                if (q10 != 6) {
                    return (Map) gVar.c0(getValueType(gVar), kVar);
                }
                return (Map) _deserializeFromString(kVar, gVar);
            }
        }
        Map map = (Map) this.f5671i.x(gVar);
        if (this.f5668f) {
            f(kVar, gVar, map);
            return map;
        }
        e(kVar, gVar, map);
        return map;
    }

    public boolean isCachable() {
        if (this.f5669g == null && this.f5667e == null && this.f5670h == null && this.f5675m == null && this.f5676n == null) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public Map deserialize(c3.k kVar, g gVar, Map map) {
        kVar.A0(map);
        n n10 = kVar.n();
        if (n10 != n.START_OBJECT && n10 != n.FIELD_NAME) {
            return (Map) gVar.a0(k(), kVar);
        }
        if (this.f5668f) {
            h(kVar, gVar, map);
            return map;
        }
        g(kVar, gVar, map);
        return map;
    }

    public final Class k() {
        return this.f5623a.q();
    }

    public final void l(g gVar, b bVar, Object obj, u uVar) {
        if (bVar == null) {
            gVar.z0(this, "Unresolved forward reference but no identity info: " + uVar, new Object[0]);
        }
        uVar.t().a(bVar.a(uVar, obj));
    }

    public c4.f logicalType() {
        return c4.f.Map;
    }

    public void m(Set set) {
        if (set == null || set.size() == 0) {
            set = null;
        }
        this.f5675m = set;
        this.f5677o = m.a(set, this.f5676n);
    }

    public void n(Set set) {
        this.f5676n = set;
        this.f5677o = m.a(this.f5675m, set);
    }

    public s o(k3.p pVar, e eVar, k kVar, q qVar, Set set, Set set2) {
        if (this.f5667e == pVar && this.f5669g == kVar && this.f5670h == eVar && this.f5624b == qVar && this.f5675m == set && this.f5676n == set2) {
            return this;
        }
        return new s(this, pVar, kVar, eVar, qVar, set, set2);
    }

    public void resolve(g gVar) {
        if (this.f5671i.k()) {
            j D = this.f5671i.D(gVar.k());
            if (D == null) {
                j jVar = this.f5623a;
                gVar.q(jVar, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{jVar, this.f5671i.getClass().getName()}));
            }
            this.f5672j = findDeserializer(gVar, D, (d) null);
        } else if (this.f5671i.i()) {
            j A = this.f5671i.A(gVar.k());
            if (A == null) {
                j jVar2 = this.f5623a;
                gVar.q(jVar2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{jVar2, this.f5671i.getClass().getName()}));
            }
            this.f5672j = findDeserializer(gVar, A, (d) null);
        }
        if (this.f5671i.g()) {
            this.f5673k = v.c(gVar, this.f5671i, this.f5671i.E(gVar.k()), gVar.o0(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this.f5668f = d(this.f5623a, this.f5667e);
    }

    public s(s sVar, k3.p pVar, k kVar, e eVar, q qVar, Set set, Set set2) {
        super((i) sVar, qVar, sVar.f5626d);
        this.f5667e = pVar;
        this.f5669g = kVar;
        this.f5670h = eVar;
        this.f5671i = sVar.f5671i;
        this.f5673k = sVar.f5673k;
        this.f5672j = sVar.f5672j;
        this.f5674l = sVar.f5674l;
        this.f5675m = set;
        this.f5676n = set2;
        this.f5677o = m.a(set, set2);
        this.f5668f = d(this.f5623a, pVar);
    }
}
