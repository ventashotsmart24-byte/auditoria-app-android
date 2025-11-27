package n3;

import b3.k;
import c4.a;
import c4.d;
import c4.e;
import com.fasterxml.jackson.databind.deser.std.a0;
import d4.h;
import d4.n;
import java.io.Serializable;
import java.util.HashMap;
import k3.c;
import k3.f;
import k3.g;
import k3.j;
import k3.k;
import k3.l;
import k3.p;
import r3.b;

public final class m implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final n f8278a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f8279b;

    public m() {
        this(2000);
    }

    public k a(g gVar, n nVar, j jVar) {
        boolean z10;
        try {
            k c10 = c(gVar, nVar, jVar);
            if (c10 == null) {
                return null;
            }
            if (h(jVar) || !c10.isCachable()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (c10 instanceof r) {
                this.f8279b.put(jVar, c10);
                ((r) c10).resolve(gVar);
                this.f8279b.remove(jVar);
            }
            if (z10) {
                this.f8278a.a(jVar, c10);
            }
            return c10;
        } catch (IllegalArgumentException e10) {
            throw l.k(gVar, h.o(e10), e10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.k b(k3.g r4, n3.n r5, k3.j r6) {
        /*
            r3 = this;
            java.util.HashMap r0 = r3.f8279b
            monitor-enter(r0)
            k3.k r1 = r3.e(r6)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r1
        L_0x000b:
            java.util.HashMap r1 = r3.f8279b     // Catch:{ all -> 0x0045 }
            int r1 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r1 <= 0) goto L_0x001f
            java.util.HashMap r2 = r3.f8279b     // Catch:{ all -> 0x0045 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0045 }
            k3.k r2 = (k3.k) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r2
        L_0x001f:
            k3.k r4 = r3.a(r4, r5, r6)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0032
            java.util.HashMap r5 = r3.f8279b     // Catch:{ all -> 0x0045 }
            int r5 = r5.size()     // Catch:{ all -> 0x0045 }
            if (r5 <= 0) goto L_0x0032
            java.util.HashMap r5 = r3.f8279b     // Catch:{ all -> 0x0045 }
            r5.clear()     // Catch:{ all -> 0x0045 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r4
        L_0x0034:
            r4 = move-exception
            if (r1 != 0) goto L_0x0044
            java.util.HashMap r5 = r3.f8279b     // Catch:{ all -> 0x0045 }
            int r5 = r5.size()     // Catch:{ all -> 0x0045 }
            if (r5 <= 0) goto L_0x0044
            java.util.HashMap r5 = r3.f8279b     // Catch:{ all -> 0x0045 }
            r5.clear()     // Catch:{ all -> 0x0045 }
        L_0x0044:
            throw r4     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.m.b(k3.g, n3.n, k3.j):k3.k");
    }

    public k c(g gVar, n nVar, j jVar) {
        f N = gVar.k();
        if (jVar.z() || jVar.J() || jVar.B()) {
            jVar = nVar.m(N, jVar);
        }
        c g02 = N.g0(jVar);
        k l10 = l(gVar, g02.u());
        if (l10 != null) {
            return l10;
        }
        j o10 = o(gVar, g02.u(), jVar);
        if (o10 != jVar) {
            g02 = N.g0(o10);
            jVar = o10;
        }
        Class m10 = g02.m();
        if (m10 != null) {
            return nVar.c(gVar, jVar, g02, m10);
        }
        d4.j f10 = g02.f();
        if (f10 == null) {
            return d(gVar, nVar, jVar, g02);
        }
        j b10 = f10.b(gVar.l());
        if (!b10.y(jVar.q())) {
            g02 = N.g0(b10);
        }
        return new a0(f10, b10, d(gVar, nVar, b10, g02));
    }

    public k d(g gVar, n nVar, j jVar, c cVar) {
        f N = gVar.k();
        if (jVar.F()) {
            return nVar.f(gVar, jVar, cVar);
        }
        if (jVar.D()) {
            if (jVar.A()) {
                return nVar.a(gVar, (a) jVar, cVar);
            }
            if (jVar.J() && cVar.g((k.d) null).i() != k.c.OBJECT) {
                c4.g gVar2 = (c4.g) jVar;
                if (gVar2 instanceof c4.h) {
                    return nVar.h(gVar, (c4.h) gVar2, cVar);
                }
                return nVar.i(gVar, gVar2, cVar);
            } else if (jVar.B() && cVar.g((k.d) null).i() != k.c.OBJECT) {
                d dVar = (d) jVar;
                if (dVar instanceof e) {
                    return nVar.d(gVar, (e) dVar, cVar);
                }
                return nVar.e(gVar, dVar, cVar);
            }
        }
        if (jVar.b()) {
            return nVar.j(gVar, (c4.j) jVar, cVar);
        }
        if (k3.m.class.isAssignableFrom(jVar.q())) {
            return nVar.k(N, jVar, cVar);
        }
        return nVar.b(gVar, jVar, cVar);
    }

    public k3.k e(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        } else if (h(jVar)) {
            return null;
        } else {
            return (k3.k) this.f8278a.get(jVar);
        }
    }

    public p f(g gVar, j jVar) {
        return (p) gVar.q(jVar, "Cannot find a (Map) Key deserializer for type " + jVar);
    }

    public k3.k g(g gVar, j jVar) {
        if (!h.K(jVar.q())) {
            return (k3.k) gVar.q(jVar, "Cannot find a Value deserializer for abstract type " + jVar);
        }
        return (k3.k) gVar.q(jVar, "Cannot find a Value deserializer for type " + jVar);
    }

    public final boolean h(j jVar) {
        if (!jVar.D()) {
            return false;
        }
        j k10 = jVar.k();
        if (k10 != null && (k10.u() != null || k10.t() != null)) {
            return true;
        }
        if (!jVar.J() || jVar.p().u() == null) {
            return false;
        }
        return true;
    }

    public final Class i(Object obj, String str, Class cls) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class cls2 = (Class) obj;
            if (cls2 == cls || h.J(cls2)) {
                return null;
            }
            return cls2;
        }
        throw new IllegalStateException("AnnotationIntrospector." + str + "() returned value of type " + obj.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }

    public d4.j j(g gVar, b bVar) {
        Object l10 = gVar.K().l(bVar);
        if (l10 == null) {
            return null;
        }
        return gVar.j(bVar, l10);
    }

    public k3.k k(g gVar, b bVar, k3.k kVar) {
        d4.j j10 = j(gVar, bVar);
        if (j10 == null) {
            return kVar;
        }
        return new a0(j10, j10.b(gVar.l()), kVar);
    }

    public k3.k l(g gVar, b bVar) {
        Object m10 = gVar.K().m(bVar);
        if (m10 == null) {
            return null;
        }
        return k(gVar, bVar, gVar.y(bVar, m10));
    }

    public p m(g gVar, n nVar, j jVar) {
        p g10 = nVar.g(gVar, jVar);
        if (g10 == null) {
            return f(gVar, jVar);
        }
        if (g10 instanceof r) {
            ((r) g10).resolve(gVar);
        }
        return g10;
    }

    public k3.k n(g gVar, n nVar, j jVar) {
        k3.k e10 = e(jVar);
        if (e10 != null) {
            return e10;
        }
        k3.k b10 = b(gVar, nVar, jVar);
        if (b10 == null) {
            return g(gVar, jVar);
        }
        return b10;
    }

    public final j o(g gVar, b bVar, j jVar) {
        Object f10;
        k3.k kVar;
        j p10;
        Object u10;
        p p02;
        k3.b K = gVar.K();
        if (K == null) {
            return jVar;
        }
        if (!(!jVar.J() || (p10 = jVar.p()) == null || p10.u() != null || (u10 = K.u(bVar)) == null || (p02 = gVar.p0(bVar, u10)) == null)) {
            jVar = ((c4.g) jVar).c0(p02);
        }
        j k10 = jVar.k();
        if (!(k10 == null || k10.u() != null || (f10 = K.f(bVar)) == null)) {
            if (f10 instanceof k3.k) {
                kVar = (k3.k) f10;
            } else {
                Class i10 = i(f10, "findContentDeserializer", k.a.class);
                if (i10 != null) {
                    kVar = gVar.y(bVar, i10);
                } else {
                    kVar = null;
                }
            }
            if (kVar != null) {
                jVar = jVar.T(kVar);
            }
        }
        return K.u0(gVar.k(), bVar, jVar);
    }

    public m(int i10) {
        this.f8279b = new HashMap(8);
        this.f8278a = new n(Math.min(64, i10 >> 2), i10);
    }
}
