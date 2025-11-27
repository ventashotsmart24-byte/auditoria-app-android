package r3;

import c4.n;
import c4.o;
import d4.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import k3.b;
import k3.j;
import r3.t;

public final class c extends b implements f0 {

    /* renamed from: o  reason: collision with root package name */
    public static final a f9022o = new a((e) null, Collections.emptyList(), Collections.emptyList());

    /* renamed from: a  reason: collision with root package name */
    public final j f9023a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f9024b;

    /* renamed from: c  reason: collision with root package name */
    public final n f9025c;

    /* renamed from: d  reason: collision with root package name */
    public final List f9026d;

    /* renamed from: e  reason: collision with root package name */
    public final b f9027e;

    /* renamed from: f  reason: collision with root package name */
    public final o f9028f;

    /* renamed from: g  reason: collision with root package name */
    public final t.a f9029g;

    /* renamed from: h  reason: collision with root package name */
    public final Class f9030h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f9031i;

    /* renamed from: j  reason: collision with root package name */
    public final d4.b f9032j;

    /* renamed from: k  reason: collision with root package name */
    public a f9033k;

    /* renamed from: l  reason: collision with root package name */
    public l f9034l;

    /* renamed from: m  reason: collision with root package name */
    public List f9035m;

    /* renamed from: n  reason: collision with root package name */
    public transient Boolean f9036n;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final e f9037a;

        /* renamed from: b  reason: collision with root package name */
        public final List f9038b;

        /* renamed from: c  reason: collision with root package name */
        public final List f9039c;

        public a(e eVar, List list, List list2) {
            this.f9037a = eVar;
            this.f9038b = list;
            this.f9039c = list2;
        }
    }

    public c(j jVar, Class cls, List list, Class cls2, d4.b bVar, n nVar, b bVar2, t.a aVar, o oVar, boolean z10) {
        this.f9023a = jVar;
        this.f9024b = cls;
        this.f9026d = list;
        this.f9030h = cls2;
        this.f9032j = bVar;
        this.f9025c = nVar;
        this.f9027e = bVar2;
        this.f9029g = aVar;
        this.f9028f = oVar;
        this.f9031i = z10;
    }

    public j a(Type type) {
        return this.f9028f.M(type, this.f9025c);
    }

    public Annotation c(Class cls) {
        return this.f9032j.get(cls);
    }

    public String d() {
        return this.f9024b.getName();
    }

    public Class e() {
        return this.f9024b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (h.H(obj, c.class) && ((c) obj).f9024b == this.f9024b) {
            return true;
        }
        return false;
    }

    public j f() {
        return this.f9023a;
    }

    public boolean g(Class cls) {
        return this.f9032j.a(cls);
    }

    public boolean h(Class[] clsArr) {
        return this.f9032j.b(clsArr);
    }

    public int hashCode() {
        return this.f9024b.getName().hashCode();
    }

    public final a i() {
        a aVar = this.f9033k;
        if (aVar == null) {
            j jVar = this.f9023a;
            if (jVar == null) {
                aVar = f9022o;
            } else {
                aVar = f.p(this.f9027e, this.f9028f, this, jVar, this.f9030h, this.f9031i);
            }
            this.f9033k = aVar;
        }
        return aVar;
    }

    public final List j() {
        List list = this.f9035m;
        if (list == null) {
            j jVar = this.f9023a;
            if (jVar == null) {
                list = Collections.emptyList();
            } else {
                list = h.m(this.f9027e, this, this.f9029g, this.f9028f, jVar, this.f9031i);
            }
            this.f9035m = list;
        }
        return list;
    }

    public final l k() {
        l lVar = this.f9034l;
        if (lVar == null) {
            j jVar = this.f9023a;
            if (jVar == null) {
                lVar = new l();
            } else {
                lVar = k.m(this.f9027e, this, this.f9029g, this.f9028f, jVar, this.f9026d, this.f9030h, this.f9031i);
            }
            this.f9034l = lVar;
        }
        return lVar;
    }

    public Iterable l() {
        return j();
    }

    public j m(String str, Class[] clsArr) {
        return k().a(str, clsArr);
    }

    public Class n() {
        return this.f9024b;
    }

    public d4.b o() {
        return this.f9032j;
    }

    public List p() {
        return i().f9038b;
    }

    public e q() {
        return i().f9037a;
    }

    public List r() {
        return i().f9039c;
    }

    public boolean s() {
        if (this.f9032j.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean t() {
        Boolean bool = this.f9036n;
        if (bool == null) {
            bool = Boolean.valueOf(h.Q(this.f9024b));
            this.f9036n = bool;
        }
        return bool.booleanValue();
    }

    public String toString() {
        return "[AnnotedClass " + this.f9024b.getName() + "]";
    }

    public Iterable u() {
        return k();
    }

    public c(Class cls) {
        this.f9023a = null;
        this.f9024b = cls;
        this.f9026d = Collections.emptyList();
        this.f9030h = null;
        this.f9032j = o.d();
        this.f9025c = n.i();
        this.f9027e = null;
        this.f9029g = null;
        this.f9028f = null;
        this.f9031i = false;
    }
}
