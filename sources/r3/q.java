package r3;

import b3.h;
import b3.k;
import b3.r;
import d4.h;
import d4.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.b;
import k3.c;
import k3.j;
import k3.x;
import l3.e;
import m3.m;

public class q extends c {

    /* renamed from: j  reason: collision with root package name */
    public static final Class[] f9151j = new Class[0];

    /* renamed from: b  reason: collision with root package name */
    public final c0 f9152b;

    /* renamed from: c  reason: collision with root package name */
    public final m f9153c;

    /* renamed from: d  reason: collision with root package name */
    public final b f9154d;

    /* renamed from: e  reason: collision with root package name */
    public final c f9155e;

    /* renamed from: f  reason: collision with root package name */
    public Class[] f9156f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9157g;

    /* renamed from: h  reason: collision with root package name */
    public List f9158h;

    /* renamed from: i  reason: collision with root package name */
    public b0 f9159i;

    public q(c0 c0Var, j jVar, c cVar) {
        super(jVar);
        this.f9152b = c0Var;
        m B = c0Var.B();
        this.f9153c = B;
        if (B == null) {
            this.f9154d = null;
        } else {
            this.f9154d = B.g();
        }
        this.f9155e = cVar;
    }

    public static q H(c0 c0Var) {
        return new q(c0Var);
    }

    public static q I(m mVar, j jVar, c cVar) {
        return new q(mVar, jVar, cVar, Collections.emptyList());
    }

    public static q J(c0 c0Var) {
        return new q(c0Var);
    }

    public boolean A() {
        return this.f9155e.s();
    }

    public Object B(boolean z10) {
        e q10 = this.f9155e.q();
        if (q10 == null) {
            return null;
        }
        if (z10) {
            q10.i(this.f9153c.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        try {
            return q10.b().newInstance(new Object[0]);
        } catch (Exception e10) {
            e = e10;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            h.h0(e);
            h.j0(e);
            throw new IllegalArgumentException("Failed to instantiate bean of type " + this.f9155e.n().getName() + ": (" + e.getClass().getName() + ") " + h.o(e), e);
        }
    }

    public d4.j D(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof d4.j) {
            return (d4.j) obj;
        }
        if (obj instanceof Class) {
            Class<j.a> cls = (Class) obj;
            if (cls == j.a.class || h.J(cls)) {
                return null;
            }
            if (d4.j.class.isAssignableFrom(cls)) {
                this.f9153c.u();
                return (d4.j) h.l(cls, this.f9153c.b());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }

    public List E() {
        if (this.f9158h == null) {
            this.f9158h = this.f9152b.H();
        }
        return this.f9158h;
    }

    public boolean F(s sVar) {
        if (K(sVar.c())) {
            return false;
        }
        E().add(sVar);
        return true;
    }

    public s G(x xVar) {
        for (s sVar : E()) {
            if (sVar.z(xVar)) {
                return sVar;
            }
        }
        return null;
    }

    public boolean K(x xVar) {
        if (G(xVar) != null) {
            return true;
        }
        return false;
    }

    public boolean L(j jVar) {
        Class<String> x10;
        if (!s().isAssignableFrom(jVar.D())) {
            return false;
        }
        h.a h10 = this.f9154d.h(this.f9153c, jVar);
        if (h10 != null && h10 != h.a.DISABLED) {
            return true;
        }
        String d10 = jVar.d();
        if ("valueOf".equals(d10) && jVar.v() == 1) {
            return true;
        }
        if (!"fromString".equals(d10) || jVar.v() != 1 || ((x10 = jVar.x(0)) != String.class && !CharSequence.class.isAssignableFrom(x10))) {
            return false;
        }
        return true;
    }

    public boolean M(String str) {
        Iterator it = E().iterator();
        while (it.hasNext()) {
            if (((s) it.next()).getName().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public i a() {
        c0 c0Var = this.f9152b;
        if (c0Var == null) {
            return null;
        }
        i x10 = c0Var.x();
        Class<Map> cls = Map.class;
        if (x10 == null) {
            i w10 = this.f9152b.w();
            if (w10 == null) {
                return null;
            }
            if (cls.isAssignableFrom(w10.e())) {
                return w10;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", new Object[]{w10.d()}));
        } else if (cls.isAssignableFrom(x10.e())) {
            return x10;
        } else {
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", new Object[]{x10.d()}));
        }
    }

    public i b() {
        c0 c0Var = this.f9152b;
        if (c0Var == null) {
            return null;
        }
        j z10 = c0Var.z();
        if (z10 != null) {
            Class<Object> x10 = z10.x(0);
            if (x10 == String.class || x10 == Object.class) {
                return z10;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on method '%s()': first argument not of type String or Object, but %s", new Object[]{z10.d(), x10.getName()}));
        }
        i y10 = this.f9152b.y();
        if (y10 == null) {
            return null;
        }
        if (Map.class.isAssignableFrom(y10.e())) {
            return y10;
        }
        throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on field '%s': type is not instance of java.util.Map", new Object[]{y10.d()}));
    }

    public List c() {
        ArrayList arrayList = null;
        HashSet hashSet = null;
        for (s sVar : E()) {
            b.a j10 = sVar.j();
            if (j10 != null && j10.c()) {
                String b10 = j10.b();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashSet = new HashSet();
                    hashSet.add(b10);
                } else if (!hashSet.add(b10)) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name " + d4.h.U(b10));
                }
                arrayList.add(sVar);
            }
        }
        return arrayList;
    }

    public e d() {
        return this.f9155e.q();
    }

    public Class[] e() {
        Class[] clsArr;
        if (!this.f9157g) {
            this.f9157g = true;
            b bVar = this.f9154d;
            if (bVar == null) {
                clsArr = null;
            } else {
                clsArr = bVar.f0(this.f9155e);
            }
            if (clsArr == null && !this.f9153c.D(k3.q.DEFAULT_VIEW_INCLUSION)) {
                clsArr = f9151j;
            }
            this.f9156f = clsArr;
        }
        return this.f9156f;
    }

    public d4.j f() {
        b bVar = this.f9154d;
        if (bVar == null) {
            return null;
        }
        return D(bVar.l(this.f9155e));
    }

    public k.d g(k.d dVar) {
        k.d q10;
        b bVar = this.f9154d;
        if (!(bVar == null || (q10 = bVar.q(this.f9155e)) == null)) {
            if (dVar == null) {
                dVar = q10;
            } else {
                dVar = dVar.r(q10);
            }
        }
        k.d o10 = this.f9153c.o(this.f9155e.e());
        if (o10 == null) {
            return dVar;
        }
        if (dVar == null) {
            return o10;
        }
        return dVar.r(o10);
    }

    public Method h(Class... clsArr) {
        for (j jVar : this.f9155e.r()) {
            if (L(jVar) && jVar.v() == 1) {
                Class x10 = jVar.x(0);
                for (Class isAssignableFrom : clsArr) {
                    if (x10.isAssignableFrom(isAssignableFrom)) {
                        return jVar.b();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public Map i() {
        c0 c0Var = this.f9152b;
        if (c0Var != null) {
            return c0Var.D();
        }
        return Collections.emptyMap();
    }

    public i j() {
        c0 c0Var = this.f9152b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.E();
    }

    public i k() {
        c0 c0Var = this.f9152b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.F();
    }

    public j l(String str, Class[] clsArr) {
        return this.f9155e.m(str, clsArr);
    }

    public Class m() {
        b bVar = this.f9154d;
        if (bVar == null) {
            return null;
        }
        return bVar.D(this.f9155e);
    }

    public e.a n() {
        b bVar = this.f9154d;
        if (bVar == null) {
            return null;
        }
        return bVar.E(this.f9155e);
    }

    public List o() {
        return E();
    }

    public r.b p(r.b bVar) {
        r.b M;
        b bVar2 = this.f9154d;
        if (bVar2 == null || (M = bVar2.M(this.f9155e)) == null) {
            return bVar;
        }
        if (bVar == null) {
            return M;
        }
        return bVar.m(M);
    }

    public d4.j q() {
        b bVar = this.f9154d;
        if (bVar == null) {
            return null;
        }
        return D(bVar.U(this.f9155e));
    }

    public Constructor r(Class... clsArr) {
        for (e eVar : this.f9155e.p()) {
            if (eVar.v() == 1) {
                Class x10 = eVar.x(0);
                for (Class cls : clsArr) {
                    if (cls == x10) {
                        return eVar.b();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public d4.b t() {
        return this.f9155e.o();
    }

    public c u() {
        return this.f9155e;
    }

    public List v() {
        return this.f9155e.p();
    }

    public List w() {
        List<j> r10 = this.f9155e.r();
        if (r10.isEmpty()) {
            return r10;
        }
        ArrayList arrayList = null;
        for (j jVar : r10) {
            if (L(jVar)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(jVar);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }

    public Set x() {
        Set set;
        c0 c0Var = this.f9152b;
        if (c0Var == null) {
            set = null;
        } else {
            set = c0Var.C();
        }
        if (set == null) {
            return Collections.emptySet();
        }
        return set;
    }

    public b0 y() {
        return this.f9159i;
    }

    public q(m mVar, k3.j jVar, c cVar, List list) {
        super(jVar);
        this.f9152b = null;
        this.f9153c = mVar;
        if (mVar == null) {
            this.f9154d = null;
        } else {
            this.f9154d = mVar.g();
        }
        this.f9155e = cVar;
        this.f9158h = list;
    }

    public q(c0 c0Var) {
        this(c0Var, c0Var.J(), c0Var.A());
        this.f9159i = c0Var.G();
    }
}
