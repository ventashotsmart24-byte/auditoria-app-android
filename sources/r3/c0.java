package r3;

import b3.b;
import b3.h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import k3.b;
import k3.j;
import k3.q;
import k3.x;
import k3.y;
import m3.m;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final m f9040a;

    /* renamed from: b  reason: collision with root package name */
    public final a f9041b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9042c;

    /* renamed from: d  reason: collision with root package name */
    public final j f9043d;

    /* renamed from: e  reason: collision with root package name */
    public final c f9044e;

    /* renamed from: f  reason: collision with root package name */
    public final h0 f9045f;

    /* renamed from: g  reason: collision with root package name */
    public final b f9046g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f9047h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9048i;

    /* renamed from: j  reason: collision with root package name */
    public LinkedHashMap f9049j;

    /* renamed from: k  reason: collision with root package name */
    public LinkedList f9050k;

    /* renamed from: l  reason: collision with root package name */
    public Map f9051l;

    /* renamed from: m  reason: collision with root package name */
    public LinkedList f9052m;

    /* renamed from: n  reason: collision with root package name */
    public LinkedList f9053n;

    /* renamed from: o  reason: collision with root package name */
    public LinkedList f9054o;

    /* renamed from: p  reason: collision with root package name */
    public LinkedList f9055p;

    /* renamed from: q  reason: collision with root package name */
    public LinkedList f9056q;

    /* renamed from: r  reason: collision with root package name */
    public LinkedList f9057r;

    /* renamed from: s  reason: collision with root package name */
    public HashSet f9058s;

    /* renamed from: t  reason: collision with root package name */
    public LinkedHashMap f9059t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f9060u;

    /* renamed from: v  reason: collision with root package name */
    public String f9061v = "set";

    public c0(m mVar, boolean z10, j jVar, c cVar, a aVar) {
        this.f9040a = mVar;
        this.f9042c = z10;
        this.f9043d = jVar;
        this.f9044e = cVar;
        if (mVar.C()) {
            this.f9047h = true;
            this.f9046g = mVar.g();
        } else {
            this.f9047h = false;
            this.f9046g = b.t0();
        }
        this.f9045f = mVar.t(jVar.q(), cVar);
        this.f9041b = aVar;
        this.f9060u = mVar.D(q.USE_STD_BEAN_NAMING);
    }

    public c A() {
        return this.f9044e;
    }

    public m B() {
        return this.f9040a;
    }

    public Set C() {
        return this.f9058s;
    }

    public Map D() {
        if (!this.f9048i) {
            v();
        }
        return this.f9059t;
    }

    public i E() {
        if (!this.f9048i) {
            v();
        }
        LinkedList linkedList = this.f9056q;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'as-key' properties defined (%s vs %s)", this.f9056q.get(0), this.f9056q.get(1));
        }
        return (i) this.f9056q.get(0);
    }

    public i F() {
        if (!this.f9048i) {
            v();
        }
        LinkedList linkedList = this.f9057r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'as-value' properties defined (%s vs %s)", this.f9057r.get(0), this.f9057r.get(1));
        }
        return (i) this.f9057r.get(0);
    }

    public b0 G() {
        b0 B = this.f9046g.B(this.f9044e);
        if (B != null) {
            return this.f9046g.C(this.f9044e, B);
        }
        return B;
    }

    public List H() {
        return new ArrayList(I().values());
    }

    public Map I() {
        if (!this.f9048i) {
            v();
        }
        return this.f9049j;
    }

    public j J() {
        return this.f9043d;
    }

    public void K(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.f9044e + ": " + str);
    }

    public void a(Map map, m mVar) {
        boolean z10;
        d0 d0Var;
        h.a h10;
        String r10 = this.f9046g.r(mVar);
        if (r10 == null) {
            r10 = "";
        }
        x x10 = this.f9046g.x(mVar);
        if (x10 == null || x10.h()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            if (!r10.isEmpty() && (h10 = this.f9046g.h(this.f9040a, mVar.r())) != null && h10 != h.a.DISABLED) {
                x10 = x.a(r10);
            } else {
                return;
            }
        }
        x xVar = x10;
        String i10 = i(r10);
        if (!z10 || !i10.isEmpty()) {
            d0Var = n(map, i10);
        } else {
            d0Var = o(map, xVar);
        }
        d0Var.V(mVar, xVar, z10, true, false);
        this.f9050k.add(d0Var);
    }

    public void b(Map map) {
        if (this.f9047h) {
            Iterator it = this.f9044e.p().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e eVar = (e) it.next();
                if (this.f9050k == null) {
                    this.f9050k = new LinkedList();
                }
                int v10 = eVar.v();
                for (int i10 = 0; i10 < v10; i10++) {
                    a(map, eVar.t(i10));
                }
            }
            for (j jVar : this.f9044e.r()) {
                if (this.f9050k == null) {
                    this.f9050k = new LinkedList();
                }
                int v11 = jVar.v();
                for (int i11 = 0; i11 < v11; i11++) {
                    a(map, jVar.t(i11));
                }
            }
        }
    }

    public void c(Map map) {
        boolean z10;
        x xVar;
        boolean z11;
        boolean z12;
        x xVar2;
        boolean z13;
        boolean z14;
        boolean z15;
        b bVar = this.f9046g;
        if (this.f9042c || this.f9040a.D(q.ALLOW_FINAL_FIELDS_AS_MUTATORS)) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean D = this.f9040a.D(q.PROPAGATE_TRANSIENT_MARKER);
        for (g gVar : this.f9044e.l()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(bVar.k0(this.f9040a, gVar))) {
                if (this.f9056q == null) {
                    this.f9056q = new LinkedList();
                }
                this.f9056q.add(gVar);
            }
            if (bool.equals(bVar.l0(gVar))) {
                if (this.f9057r == null) {
                    this.f9057r = new LinkedList();
                }
                this.f9057r.add(gVar);
            } else {
                boolean equals = bool.equals(bVar.h0(gVar));
                boolean equals2 = bool.equals(bVar.j0(gVar));
                if (equals || equals2) {
                    if (equals) {
                        if (this.f9053n == null) {
                            this.f9053n = new LinkedList();
                        }
                        this.f9053n.add(gVar);
                    }
                    if (equals2) {
                        if (this.f9055p == null) {
                            this.f9055p = new LinkedList();
                        }
                        this.f9055p.add(gVar);
                    }
                } else {
                    String r10 = bVar.r(gVar);
                    if (r10 == null) {
                        r10 = gVar.d();
                    }
                    String d10 = this.f9041b.d(gVar, r10);
                    if (d10 != null) {
                        x m10 = m(d10);
                        x R = bVar.R(this.f9040a, gVar, m10);
                        if (R != null && !R.equals(m10)) {
                            if (this.f9051l == null) {
                                this.f9051l = new HashMap();
                            }
                            this.f9051l.put(R, m10);
                        }
                        if (this.f9042c) {
                            xVar = bVar.y(gVar);
                        } else {
                            xVar = bVar.x(gVar);
                        }
                        if (xVar != null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11 || !xVar.h()) {
                            xVar2 = xVar;
                            z12 = z11;
                        } else {
                            xVar2 = m(d10);
                            z12 = false;
                        }
                        if (xVar2 != null) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (!z13) {
                            z13 = this.f9045f.e(gVar);
                        }
                        boolean o02 = bVar.o0(gVar);
                        if (!gVar.s() || z11) {
                            z14 = o02;
                            z15 = z13;
                        } else if (D) {
                            z15 = false;
                            z14 = true;
                        } else {
                            z14 = o02;
                            z15 = false;
                        }
                        if (!z10 || xVar2 != null || z14 || !Modifier.isFinal(gVar.r())) {
                            n(map, d10).W(gVar, xVar2, z12, z15, z14);
                        }
                    }
                }
            }
        }
    }

    public void d(Map map, j jVar, b bVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        x xVar;
        String str;
        boolean z13;
        Class<Void> D = jVar.D();
        if (D == Void.TYPE) {
            return;
        }
        if (D != Void.class || this.f9040a.D(q.ALLOW_VOID_VALUED_PROPERTIES)) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(bVar.h0(jVar))) {
                if (this.f9052m == null) {
                    this.f9052m = new LinkedList();
                }
                this.f9052m.add(jVar);
            } else if (bool.equals(bVar.k0(this.f9040a, jVar))) {
                if (this.f9056q == null) {
                    this.f9056q = new LinkedList();
                }
                this.f9056q.add(jVar);
            } else if (bool.equals(bVar.l0(jVar))) {
                if (this.f9057r == null) {
                    this.f9057r = new LinkedList();
                }
                this.f9057r.add(jVar);
            } else {
                x y10 = bVar.y(jVar);
                boolean z14 = false;
                if (y10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    str = bVar.r(jVar);
                    if (str == null) {
                        str = this.f9041b.c(jVar, jVar.d());
                    }
                    if (str == null) {
                        str = this.f9041b.a(jVar, jVar.d());
                        if (str != null) {
                            z13 = this.f9045f.d(jVar);
                        } else {
                            return;
                        }
                    } else {
                        z13 = this.f9045f.g(jVar);
                    }
                    xVar = y10;
                    z11 = z13;
                    z12 = z10;
                } else {
                    String r10 = bVar.r(jVar);
                    if (r10 == null && (r10 = this.f9041b.c(jVar, jVar.d())) == null) {
                        r10 = this.f9041b.a(jVar, jVar.d());
                    }
                    if (r10 == null) {
                        r10 = jVar.d();
                    }
                    if (y10.h()) {
                        y10 = m(r10);
                    } else {
                        z14 = z10;
                    }
                    xVar = y10;
                    z12 = z14;
                    str = r10;
                    z11 = true;
                }
                String i10 = i(str);
                n(map, i10).X(jVar, xVar, z12, z11, bVar.o0(jVar));
            }
        }
    }

    public void e(Map map) {
        for (g gVar : this.f9044e.l()) {
            k(this.f9046g.s(gVar), gVar);
        }
        for (j jVar : this.f9044e.u()) {
            if (jVar.v() == 1) {
                k(this.f9046g.s(jVar), jVar);
            }
        }
    }

    public void f(Map map) {
        for (j jVar : this.f9044e.u()) {
            int v10 = jVar.v();
            if (v10 == 0) {
                d(map, jVar, this.f9046g);
            } else if (v10 == 1) {
                g(map, jVar, this.f9046g);
            } else if (v10 == 2 && Boolean.TRUE.equals(this.f9046g.j0(jVar))) {
                if (this.f9054o == null) {
                    this.f9054o = new LinkedList();
                }
                this.f9054o.add(jVar);
            }
        }
    }

    public void g(Map map, j jVar, b bVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        x xVar;
        String str;
        x x10 = bVar.x(jVar);
        boolean z13 = false;
        if (x10 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            str = bVar.r(jVar);
            if (str == null) {
                str = this.f9041b.b(jVar, jVar.d());
            }
            if (str != null) {
                xVar = x10;
                z11 = this.f9045f.f(jVar);
                z12 = z10;
            } else {
                return;
            }
        } else {
            String r10 = bVar.r(jVar);
            if (r10 == null) {
                r10 = this.f9041b.b(jVar, jVar.d());
            }
            if (r10 == null) {
                r10 = jVar.d();
            }
            if (x10.h()) {
                x10 = m(r10);
            } else {
                z13 = z10;
            }
            xVar = x10;
            z12 = z13;
            str = r10;
            z11 = true;
        }
        String i10 = i(str);
        n(map, i10).Y(jVar, xVar, z12, z11, bVar.o0(jVar));
    }

    public final boolean h(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((d0) it.next()).getMetadata().f()) {
                return true;
            }
        }
        return false;
    }

    public final String i(String str) {
        x xVar;
        Map map = this.f9051l;
        if (map == null || (xVar = (x) map.get(m(str))) == null) {
            return str;
        }
        return xVar.c();
    }

    public void j(String str) {
        if (!this.f9042c && str != null) {
            if (this.f9058s == null) {
                this.f9058s = new HashSet();
            }
            this.f9058s.add(str);
        }
    }

    public void k(b.a aVar, i iVar) {
        if (aVar != null) {
            Object e10 = aVar.e();
            if (this.f9059t == null) {
                this.f9059t = new LinkedHashMap();
            }
            i iVar2 = (i) this.f9059t.put(e10, iVar);
            if (iVar2 != null && iVar2.getClass() == iVar.getClass()) {
                String name = e10.getClass().getName();
                throw new IllegalArgumentException("Duplicate injectable value with id '" + e10 + "' (of type " + name + ")");
            }
        }
    }

    public final y l() {
        Object z10 = this.f9046g.z(this.f9044e);
        if (z10 == null) {
            this.f9040a.x();
            return null;
        } else if (z10 instanceof Class) {
            Class<y> cls = (Class) z10;
            Class<y> cls2 = y.class;
            if (cls == cls2) {
                return null;
            }
            if (cls2.isAssignableFrom(cls)) {
                this.f9040a.u();
                androidx.appcompat.app.m.a(d4.h.l(cls, this.f9040a.b()));
                return null;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + z10.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        }
    }

    public final x m(String str) {
        return x.b(str, (String) null);
    }

    public d0 n(Map map, String str) {
        d0 d0Var = (d0) map.get(str);
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0(this.f9040a, this.f9046g, this.f9042c, x.a(str));
        map.put(str, d0Var2);
        return d0Var2;
    }

    public d0 o(Map map, x xVar) {
        String c10 = xVar.c();
        d0 d0Var = (d0) map.get(c10);
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0(this.f9040a, this.f9046g, this.f9042c, xVar);
        map.put(c10, d0Var2);
        return d0Var2;
    }

    public void p(Map map) {
        c0 c0Var;
        boolean D = this.f9040a.D(q.INFER_PROPERTY_MUTATORS);
        for (d0 d0Var : map.values()) {
            if (this.f9042c) {
                c0Var = null;
            } else {
                c0Var = this;
            }
            d0Var.n0(D, c0Var);
        }
    }

    public void q(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            if (!d0Var.a0()) {
                it.remove();
            } else if (d0Var.Z()) {
                if (!d0Var.B()) {
                    it.remove();
                    j(d0Var.getName());
                } else {
                    d0Var.m0();
                    if (!d0Var.e()) {
                        j(d0Var.getName());
                    }
                }
            }
        }
    }

    public void r(Map map) {
        HashSet hashSet;
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            d0 d0Var = (d0) ((Map.Entry) it.next()).getValue();
            Set e02 = d0Var.e0();
            if (!e02.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (e02.size() == 1) {
                    linkedList.add(d0Var.p0((x) e02.iterator().next()));
                } else {
                    linkedList.addAll(d0Var.c0(e02));
                }
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                d0 d0Var2 = (d0) it2.next();
                String name = d0Var2.getName();
                d0 d0Var3 = (d0) map.get(name);
                if (d0Var3 == null) {
                    map.put(name, d0Var2);
                } else {
                    d0Var3.U(d0Var2);
                }
                if (t(d0Var2, this.f9050k) && (hashSet = this.f9058s) != null) {
                    hashSet.remove(name);
                }
            }
        }
    }

    public void s(Map map) {
        x g02;
        Iterator it = map.entrySet().iterator();
        LinkedList linkedList = null;
        while (it.hasNext()) {
            d0 d0Var = (d0) ((Map.Entry) it.next()).getValue();
            i s10 = d0Var.s();
            if (s10 != null && (g02 = this.f9046g.g0(s10)) != null && g02.e() && !g02.equals(d0Var.c())) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(d0Var.p0(g02));
                it.remove();
            }
        }
        if (linkedList != null) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                d0 d0Var2 = (d0) it2.next();
                String name = d0Var2.getName();
                d0 d0Var3 = (d0) map.get(name);
                if (d0Var3 == null) {
                    map.put(name, d0Var2);
                } else {
                    d0Var3.U(d0Var2);
                }
            }
        }
    }

    public boolean t(d0 d0Var, List list) {
        if (list != null) {
            String h02 = d0Var.h0();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((d0) list.get(i10)).h0().equals(h02)) {
                    list.set(i10, d0Var);
                    return true;
                }
            }
        }
        return false;
    }

    public void u(Map map) {
        boolean z10;
        Map map2;
        Collection<d0> collection;
        k3.b bVar = this.f9046g;
        Boolean W = bVar.W(this.f9044e);
        if (W == null) {
            z10 = this.f9040a.E();
        } else {
            z10 = W.booleanValue();
        }
        boolean h10 = h(map.values());
        String[] V = bVar.V(this.f9044e);
        if (z10 || h10 || this.f9050k != null || V != null) {
            int size = map.size();
            if (z10) {
                map2 = new TreeMap();
            } else {
                map2 = new LinkedHashMap(size + size);
            }
            for (d0 d0Var : map.values()) {
                map2.put(d0Var.getName(), d0Var);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size + size);
            if (V != null) {
                for (String str : V) {
                    d0 d0Var2 = (d0) map2.remove(str);
                    if (d0Var2 == null) {
                        Iterator it = map.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            d0 d0Var3 = (d0) it.next();
                            if (str.equals(d0Var3.h0())) {
                                str = d0Var3.getName();
                                d0Var2 = d0Var3;
                                break;
                            }
                        }
                    }
                    if (d0Var2 != null) {
                        linkedHashMap.put(str, d0Var2);
                    }
                }
            }
            if (h10) {
                TreeMap treeMap = new TreeMap();
                Iterator it2 = map2.entrySet().iterator();
                while (it2.hasNext()) {
                    d0 d0Var4 = (d0) ((Map.Entry) it2.next()).getValue();
                    Integer c10 = d0Var4.getMetadata().c();
                    if (c10 != null) {
                        treeMap.put(c10, d0Var4);
                        it2.remove();
                    }
                }
                for (d0 d0Var5 : treeMap.values()) {
                    linkedHashMap.put(d0Var5.getName(), d0Var5);
                }
            }
            if (this.f9050k != null && (!z10 || this.f9040a.D(q.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (z10) {
                    TreeMap treeMap2 = new TreeMap();
                    Iterator it3 = this.f9050k.iterator();
                    while (it3.hasNext()) {
                        d0 d0Var6 = (d0) it3.next();
                        treeMap2.put(d0Var6.getName(), d0Var6);
                    }
                    collection = treeMap2.values();
                } else {
                    collection = this.f9050k;
                }
                for (d0 d0Var7 : collection) {
                    String name = d0Var7.getName();
                    if (map2.containsKey(name)) {
                        linkedHashMap.put(name, d0Var7);
                    }
                }
            }
            linkedHashMap.putAll(map2);
            map.clear();
            map.putAll(linkedHashMap);
        }
    }

    public void v() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c(linkedHashMap);
        f(linkedHashMap);
        if (!this.f9044e.t()) {
            b(linkedHashMap);
        }
        q(linkedHashMap);
        p(linkedHashMap);
        r(linkedHashMap);
        e(linkedHashMap);
        for (d0 k02 : linkedHashMap.values()) {
            k02.k0(this.f9042c);
        }
        for (d0 o02 : linkedHashMap.values()) {
            o02.o0();
        }
        l();
        if (this.f9040a.D(q.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            s(linkedHashMap);
        }
        u(linkedHashMap);
        this.f9049j = linkedHashMap;
        this.f9048i = true;
    }

    public i w() {
        if (!this.f9048i) {
            v();
        }
        LinkedList linkedList = this.f9053n;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-getter' fields defined (%s vs %s)", this.f9053n.get(0), this.f9053n.get(1));
        }
        return (i) this.f9053n.getFirst();
    }

    public i x() {
        if (!this.f9048i) {
            v();
        }
        LinkedList linkedList = this.f9052m;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-getter' methods defined (%s vs %s)", this.f9052m.get(0), this.f9052m.get(1));
        }
        return (i) this.f9052m.getFirst();
    }

    public i y() {
        if (!this.f9048i) {
            v();
        }
        LinkedList linkedList = this.f9055p;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-setter' fields defined (%s vs %s)", this.f9055p.get(0), this.f9055p.get(1));
        }
        return (i) this.f9055p.getFirst();
    }

    public j z() {
        if (!this.f9048i) {
            v();
        }
        LinkedList linkedList = this.f9054o;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            K("Multiple 'any-setter' methods defined (%s vs %s)", this.f9054o.get(0), this.f9054o.get(1));
        }
        return (j) this.f9054o.getFirst();
    }
}
