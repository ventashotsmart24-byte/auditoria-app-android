package k3;

import c3.c;
import c3.f;
import c3.h;
import c3.k;
import c3.n;
import c3.o;
import c3.v;
import com.umeng.analytics.pro.bt;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import n3.l;

public class u extends o implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final f f7462a;

    /* renamed from: b  reason: collision with root package name */
    public final l f7463b;

    /* renamed from: c  reason: collision with root package name */
    public final f f7464c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f7465d;

    /* renamed from: e  reason: collision with root package name */
    public final j f7466e;

    /* renamed from: f  reason: collision with root package name */
    public final k f7467f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f7468g;

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentHashMap f7469h;

    /* renamed from: i  reason: collision with root package name */
    public transient j f7470i;

    public u(t tVar, f fVar, j jVar, Object obj, c cVar, i iVar) {
        this.f7462a = fVar;
        this.f7463b = tVar.f7458k;
        this.f7469h = tVar.f7460m;
        this.f7464c = tVar.f7448a;
        this.f7466e = jVar;
        this.f7468g = obj;
        this.f7465d = fVar.k0();
        this.f7467f = l(jVar);
    }

    public v a(k kVar) {
        d(bt.aD, kVar);
        return f(kVar);
    }

    public Object b(k kVar, Class cls) {
        d(bt.aD, kVar);
        return p(cls).s(kVar);
    }

    public void c(h hVar, Object obj) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", new Object[]{str}));
        }
    }

    public Object e(k kVar, Object obj) {
        l n10 = n(kVar);
        n i10 = i(n10, kVar);
        if (i10 == n.VALUE_NULL) {
            if (obj == null) {
                obj = g(n10).getNullValue(n10);
            }
        } else if (!(i10 == n.END_ARRAY || i10 == n.END_OBJECT)) {
            obj = n10.T0(kVar, this.f7466e, g(n10), this.f7468g);
        }
        kVar.f();
        if (this.f7462a.j0(h.FAIL_ON_TRAILING_TOKENS)) {
            m(kVar, n10, this.f7466e);
        }
        return obj;
    }

    public final m f(k kVar) {
        m mVar;
        this.f7462a.e0(kVar);
        n n10 = kVar.n();
        if (n10 == null && (n10 = kVar.s0()) == null) {
            return null;
        }
        l n11 = n(kVar);
        if (n10 == n.VALUE_NULL) {
            mVar = this.f7462a.c0().d();
        } else {
            mVar = (m) n11.T0(kVar, j(), h(n11), (Object) null);
        }
        if (this.f7462a.j0(h.FAIL_ON_TRAILING_TOKENS)) {
            m(kVar, n11, j());
        }
        return mVar;
    }

    public k g(g gVar) {
        k kVar = this.f7467f;
        if (kVar != null) {
            return kVar;
        }
        j jVar = this.f7466e;
        if (jVar == null) {
            gVar.q((j) null, "No value type configured for ObjectReader");
        }
        k kVar2 = (k) this.f7469h.get(jVar);
        if (kVar2 != null) {
            return kVar2;
        }
        k I = gVar.I(jVar);
        if (I == null) {
            gVar.q(jVar, "Cannot find a deserializer for type " + jVar);
        }
        this.f7469h.put(jVar, I);
        return I;
    }

    public k h(g gVar) {
        j j10 = j();
        k kVar = (k) this.f7469h.get(j10);
        if (kVar == null) {
            kVar = gVar.I(j10);
            if (kVar == null) {
                gVar.q(j10, "Cannot find a deserializer for type " + j10);
            }
            this.f7469h.put(j10, kVar);
        }
        return kVar;
    }

    public n i(g gVar, k kVar) {
        this.f7462a.f0(kVar, (c) null);
        n n10 = kVar.n();
        if (n10 == null && (n10 = kVar.s0()) == null) {
            gVar.y0(this.f7466e, "No content to map due to end-of-input", new Object[0]);
        }
        return n10;
    }

    public final j j() {
        j jVar = this.f7470i;
        if (jVar != null) {
            return jVar;
        }
        j H = r().H(m.class);
        this.f7470i = H;
        return H;
    }

    public u k(u uVar, f fVar, j jVar, k kVar, Object obj, c cVar, i iVar, n3.k kVar2) {
        return new u(uVar, fVar, jVar, kVar, obj, cVar, iVar, kVar2);
    }

    public k l(j jVar) {
        if (jVar == null || !this.f7462a.j0(h.EAGER_DESERIALIZER_FETCH)) {
            return null;
        }
        k kVar = (k) this.f7469h.get(jVar);
        if (kVar == null) {
            try {
                kVar = o().I(jVar);
                if (kVar != null) {
                    this.f7469h.put(jVar, kVar);
                }
            } catch (c3.l unused) {
            }
        }
        return kVar;
    }

    public final void m(k kVar, g gVar, j jVar) {
        Object obj;
        n s02 = kVar.s0();
        if (s02 != null) {
            Class<?> d02 = d4.h.d0(jVar);
            if (d02 == null && (obj = this.f7468g) != null) {
                d02 = obj.getClass();
            }
            gVar.C0(d02, kVar, s02);
        }
    }

    public l n(k kVar) {
        return this.f7463b.R0(this.f7462a, kVar, (i) null);
    }

    public l o() {
        return this.f7463b.Q0(this.f7462a);
    }

    public u p(Class cls) {
        return q(this.f7462a.e(cls));
    }

    public u q(j jVar) {
        if (jVar != null && jVar.equals(this.f7466e)) {
            return this;
        }
        return k(this, this.f7462a, jVar, l(jVar), this.f7468g, (c) null, (i) null, (n3.k) null);
    }

    public c4.o r() {
        return this.f7462a.z();
    }

    public Object s(k kVar) {
        d(bt.aD, kVar);
        return e(kVar, this.f7468g);
    }

    public u(u uVar, f fVar, j jVar, k kVar, Object obj, c cVar, i iVar, n3.k kVar2) {
        this.f7462a = fVar;
        this.f7463b = uVar.f7463b;
        this.f7469h = uVar.f7469h;
        this.f7464c = uVar.f7464c;
        this.f7466e = jVar;
        this.f7467f = kVar;
        this.f7468g = obj;
        this.f7465d = fVar.k0();
    }
}
