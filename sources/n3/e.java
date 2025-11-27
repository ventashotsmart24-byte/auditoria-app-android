package n3;

import b3.k;
import d4.h;
import d4.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.b;
import k3.c;
import k3.f;
import k3.g;
import k3.q;
import k3.w;
import k3.x;
import l3.e;
import o3.e0;
import o3.s;
import o3.u;
import r3.i;
import r3.j;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final f f8252a;

    /* renamed from: b  reason: collision with root package name */
    public final g f8253b;

    /* renamed from: c  reason: collision with root package name */
    public final c f8254c;

    /* renamed from: d  reason: collision with root package name */
    public final Map f8255d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    public List f8256e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap f8257f;

    /* renamed from: g  reason: collision with root package name */
    public HashSet f8258g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet f8259h;

    /* renamed from: i  reason: collision with root package name */
    public w f8260i;

    /* renamed from: j  reason: collision with root package name */
    public s f8261j;

    /* renamed from: k  reason: collision with root package name */
    public s f8262k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f8263l;

    /* renamed from: m  reason: collision with root package name */
    public j f8264m;

    /* renamed from: n  reason: collision with root package name */
    public e.a f8265n;

    public e(c cVar, g gVar) {
        this.f8254c = cVar;
        this.f8253b = gVar;
        this.f8252a = gVar.k();
    }

    public Map a(Collection collection) {
        b g10 = this.f8252a.g();
        HashMap hashMap = null;
        if (g10 != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                List G = g10.G(tVar.d());
                if (G != null && !G.isEmpty()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(tVar.getName(), G);
                }
            }
        }
        if (hashMap == null) {
            return Collections.emptyMap();
        }
        return hashMap;
    }

    public boolean b() {
        Boolean e10 = this.f8254c.g((k.d) null).e(k.a.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        if (e10 == null) {
            return this.f8252a.D(q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        }
        return e10.booleanValue();
    }

    public void c(Collection collection) {
        if (this.f8252a.b()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                ((t) it.next()).o(this.f8252a);
            }
        }
        s sVar = this.f8262k;
        if (sVar != null) {
            sVar.d(this.f8252a);
        }
        j jVar = this.f8264m;
        if (jVar != null) {
            jVar.i(this.f8252a.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
    }

    public void d(String str, t tVar) {
        if (this.f8257f == null) {
            this.f8257f = new HashMap(4);
        }
        if (this.f8252a.b()) {
            tVar.o(this.f8252a);
        }
        this.f8257f.put(str, tVar);
    }

    public void e(t tVar) {
        j(tVar);
    }

    public void f(String str) {
        if (this.f8258g == null) {
            this.f8258g = new HashSet();
        }
        this.f8258g.add(str);
    }

    public void g(String str) {
        if (this.f8259h == null) {
            this.f8259h = new HashSet();
        }
        this.f8259h.add(str);
    }

    public void h(x xVar, k3.j jVar, d4.b bVar, i iVar, Object obj) {
        if (this.f8256e == null) {
            this.f8256e = new ArrayList();
        }
        if (this.f8252a.b()) {
            iVar.i(this.f8252a.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        this.f8256e.add(new e0(xVar, jVar, iVar, obj));
    }

    public void i(t tVar, boolean z10) {
        this.f8255d.put(tVar.getName(), tVar);
    }

    public void j(t tVar) {
        t tVar2 = (t) this.f8255d.put(tVar.getName(), tVar);
        if (tVar2 != null && tVar2 != tVar) {
            throw new IllegalArgumentException("Duplicate property '" + tVar.getName() + "' for " + this.f8254c.z());
        }
    }

    public k3.k k() {
        boolean z10;
        Collection values = this.f8255d.values();
        c(values);
        o3.c j10 = o3.c.j(this.f8252a, values, a(values), b());
        j10.i();
        boolean z11 = !this.f8252a.D(q.DEFAULT_VIEW_INCLUSION);
        if (!z11) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((t) it.next()).y()) {
                        z10 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z10 = z11;
        if (this.f8261j != null) {
            j10 = j10.u(new u(this.f8261j, w.f7485h));
        }
        return new c(this, this.f8254c, j10, this.f8257f, this.f8258g, this.f8263l, this.f8259h, z10);
    }

    public a l() {
        return new a(this, this.f8254c, this.f8257f, this.f8255d);
    }

    public k3.k m(k3.j jVar, String str) {
        j jVar2 = this.f8264m;
        boolean z10 = true;
        if (jVar2 != null) {
            Class D = jVar2.D();
            Class q10 = jVar.q();
            if (D != q10 && !D.isAssignableFrom(q10) && !q10.isAssignableFrom(D)) {
                this.f8253b.q(this.f8254c.z(), String.format("Build method `%s` has wrong return type (%s), not compatible with POJO type (%s)", new Object[]{this.f8264m.l(), h.y(D), h.G(jVar)}));
            }
        } else if (!str.isEmpty()) {
            this.f8253b.q(this.f8254c.z(), String.format("Builder class %s does not have build method (name: '%s')", new Object[]{h.G(this.f8254c.z()), str}));
        }
        Collection values = this.f8255d.values();
        c(values);
        o3.c j10 = o3.c.j(this.f8252a, values, a(values), b());
        j10.i();
        boolean z11 = !this.f8252a.D(q.DEFAULT_VIEW_INCLUSION);
        if (!z11) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((t) it.next()).y()) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z10 = z11;
        if (this.f8261j != null) {
            j10 = j10.u(new u(this.f8261j, w.f7485h));
        }
        return n(jVar, j10, z10);
    }

    public k3.k n(k3.j jVar, o3.c cVar, boolean z10) {
        return new h(this, this.f8254c, jVar, cVar, this.f8257f, this.f8258g, this.f8263l, this.f8259h, z10);
    }

    public t o(x xVar) {
        return (t) this.f8255d.get(xVar.c());
    }

    public s p() {
        return this.f8262k;
    }

    public j q() {
        return this.f8264m;
    }

    public List r() {
        return this.f8256e;
    }

    public s s() {
        return this.f8261j;
    }

    public w t() {
        return this.f8260i;
    }

    public boolean u(String str) {
        return m.c(str, this.f8258g, this.f8259h);
    }

    public void v(s sVar) {
        if (this.f8262k == null || sVar == null) {
            this.f8262k = sVar;
            return;
        }
        throw new IllegalStateException("_anySetter already set to non-null");
    }

    public void w(boolean z10) {
        this.f8263l = z10;
    }

    public void x(s sVar) {
        this.f8261j = sVar;
    }

    public void y(j jVar, e.a aVar) {
        this.f8264m = jVar;
        this.f8265n = aVar;
    }

    public void z(w wVar) {
        this.f8260i = wVar;
    }
}
