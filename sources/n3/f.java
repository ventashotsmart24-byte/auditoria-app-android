package n3;

import androidx.appcompat.app.m;
import b3.k0;
import b3.n0;
import b3.o0;
import com.fasterxml.jackson.databind.deser.std.j0;
import d4.e;
import d4.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.c;
import k3.d;
import k3.g;
import k3.j;
import k3.q;
import k3.x;
import l3.e;
import m3.k;
import o3.a0;
import o3.c0;
import o3.w;
import p3.b;
import r3.b0;
import r3.i;
import r3.s;
import x3.p;

public class f extends b {

    /* renamed from: j  reason: collision with root package name */
    public static final Class[] f8266j = {Throwable.class};

    /* renamed from: k  reason: collision with root package name */
    public static final f f8267k = new f(new k());

    public f(k kVar) {
        super(kVar);
    }

    public k3.k b(g gVar, j jVar, c cVar) {
        j z02;
        k3.f N = gVar.k();
        k3.k C = C(jVar, N, cVar);
        if (C != null) {
            if (this.f8210b.e()) {
                Iterator it = this.f8210b.b().iterator();
                if (it.hasNext()) {
                    m.a(it.next());
                    gVar.k();
                    throw null;
                }
            }
            return C;
        } else if (jVar.M()) {
            return q0(gVar, jVar, cVar);
        } else {
            if (jVar.z() && !jVar.K() && !jVar.F() && (z02 = z0(gVar, jVar, cVar)) != null) {
                return o0(gVar, z02, N.g0(z02));
            }
            k3.k w02 = w0(gVar, jVar, cVar);
            if (w02 != null) {
                return w02;
            }
            if (!y0(jVar.q())) {
                return null;
            }
            j0(gVar, jVar, cVar);
            k3.k h02 = h0(gVar, jVar, cVar);
            if (h02 != null) {
                return h02;
            }
            return o0(gVar, jVar, cVar);
        }
    }

    public k3.k c(g gVar, j jVar, c cVar, Class cls) {
        j jVar2;
        if (gVar.o0(q.INFER_BUILDER_TYPE_BINDINGS)) {
            jVar2 = gVar.l().E(cls, jVar.j());
        } else {
            jVar2 = gVar.x(cls);
        }
        return p0(gVar, jVar, gVar.k().h0(jVar2, cVar));
    }

    public n g0(k kVar) {
        if (this.f8210b == kVar) {
            return this;
        }
        h.n0(f.class, this, "withConfig");
        return new f(kVar);
    }

    public k3.k h0(g gVar, j jVar, c cVar) {
        String a10 = e.a(jVar);
        if (a10 == null || gVar.k().a(jVar.q()) != null) {
            return null;
        }
        return new c0(jVar, a10);
    }

    public final boolean i0(Class cls) {
        if (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public void j0(g gVar, j jVar, c cVar) {
        p.a().b(gVar, jVar, cVar);
    }

    public void k0(g gVar, c cVar, e eVar) {
        List<s> c10 = cVar.c();
        if (c10 != null) {
            for (s sVar : c10) {
                eVar.d(sVar.i(), t0(gVar, cVar, sVar, sVar.t()));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v24, types: [n3.t[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l0(k3.g r18, k3.c r19, n3.e r20) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            k3.j r0 = r19.z()
            boolean r0 = r0.z()
            r11 = 1
            r0 = r0 ^ r11
            r12 = 0
            if (r0 == 0) goto L_0x0023
            n3.w r0 = r20.t()
            k3.f r1 = r18.k()
            n3.t[] r0 = r0.E(r1)
            r13 = r0
            goto L_0x0024
        L_0x0023:
            r13 = r12
        L_0x0024:
            r14 = 0
            if (r13 == 0) goto L_0x0029
            r15 = 1
            goto L_0x002a
        L_0x0029:
            r15 = 0
        L_0x002a:
            k3.f r0 = r18.k()
            java.lang.Class r1 = r19.s()
            r3.c r2 = r19.u()
            b3.p$a r0 = r0.O(r1, r2)
            if (r0 == 0) goto L_0x005b
            boolean r1 = r0.j()
            r10.w(r1)
            java.util.Set r0 = r0.g()
            java.util.Iterator r1 = r0.iterator()
        L_0x004b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r10.f(r2)
            goto L_0x004b
        L_0x005b:
            java.util.Set r0 = java.util.Collections.emptySet()
        L_0x005f:
            r5 = r0
            k3.f r0 = r18.k()
            java.lang.Class r1 = r19.s()
            r3.c r2 = r19.u()
            b3.s$a r0 = r0.Q(r1, r2)
            if (r0 == 0) goto L_0x008e
            java.util.Set r0 = r0.e()
            if (r0 == 0) goto L_0x008c
            java.util.Iterator r1 = r0.iterator()
        L_0x007c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008c
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r10.g(r2)
            goto L_0x007c
        L_0x008c:
            r6 = r0
            goto L_0x008f
        L_0x008e:
            r6 = r12
        L_0x008f:
            r3.i r0 = r19.b()
            if (r0 == 0) goto L_0x009d
            n3.s r0 = r7.r0(r8, r9, r0)
            r10.v(r0)
            goto L_0x00b7
        L_0x009d:
            java.util.Set r0 = r19.x()
            if (r0 == 0) goto L_0x00b7
            java.util.Iterator r0 = r0.iterator()
        L_0x00a7:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b7
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r10.f(r1)
            goto L_0x00a7
        L_0x00b7:
            k3.q r0 = k3.q.USE_GETTERS_AS_SETTERS
            boolean r0 = r8.o0(r0)
            if (r0 == 0) goto L_0x00ca
            k3.q r0 = k3.q.AUTO_DETECT_GETTERS
            boolean r0 = r8.o0(r0)
            if (r0 == 0) goto L_0x00ca
            r16 = 1
            goto L_0x00cc
        L_0x00ca:
            r16 = 0
        L_0x00cc:
            java.util.List r4 = r19.o()
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.util.List r0 = r0.v0(r1, r2, r3, r4, r5, r6)
            m3.k r1 = r7.f8210b
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0100
            m3.k r1 = r7.f8210b
            java.lang.Iterable r1 = r1.b()
            java.util.Iterator r1 = r1.iterator()
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x00f5
            goto L_0x0100
        L_0x00f5:
            java.lang.Object r0 = r1.next()
            androidx.appcompat.app.m.a(r0)
            r18.k()
            throw r12
        L_0x0100:
            java.util.Iterator r0 = r0.iterator()
        L_0x0104:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01e9
            java.lang.Object r1 = r0.next()
            r3.s r1 = (r3.s) r1
            boolean r2 = r1.A()
            if (r2 == 0) goto L_0x0123
            r3.j r2 = r1.v()
            k3.j r2 = r2.w(r14)
            n3.t r2 = r7.t0(r8, r9, r1, r2)
            goto L_0x016e
        L_0x0123:
            boolean r2 = r1.y()
            if (r2 == 0) goto L_0x0136
            r3.g r2 = r1.o()
            k3.j r2 = r2.f()
            n3.t r2 = r7.t0(r8, r9, r1, r2)
            goto L_0x016e
        L_0x0136:
            r3.j r2 = r1.p()
            if (r2 == 0) goto L_0x016d
            if (r16 == 0) goto L_0x0158
            java.lang.Class r2 = r2.e()
            boolean r2 = r7.i0(r2)
            if (r2 == 0) goto L_0x0158
            java.lang.String r2 = r1.getName()
            boolean r2 = r10.u(r2)
            if (r2 == 0) goto L_0x0153
            goto L_0x016d
        L_0x0153:
            n3.t r2 = r7.u0(r8, r9, r1)
            goto L_0x016e
        L_0x0158:
            boolean r2 = r1.x()
            if (r2 != 0) goto L_0x016d
            k3.w r2 = r1.getMetadata()
            k3.w$a r2 = r2.d()
            if (r2 == 0) goto L_0x016d
            n3.t r2 = r7.u0(r8, r9, r1)
            goto L_0x016e
        L_0x016d:
            r2 = r12
        L_0x016e:
            if (r15 == 0) goto L_0x01d4
            boolean r3 = r1.x()
            if (r3 == 0) goto L_0x01d4
            java.lang.String r3 = r1.getName()
            int r4 = r13.length
            r5 = 0
        L_0x017c:
            if (r5 >= r4) goto L_0x0195
            r6 = r13[r5]
            java.lang.String r12 = r6.getName()
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0191
            boolean r12 = r6 instanceof n3.j
            if (r12 == 0) goto L_0x0191
            n3.j r6 = (n3.j) r6
            goto L_0x0196
        L_0x0191:
            int r5 = r5 + 1
            r12 = 0
            goto L_0x017c
        L_0x0195:
            r6 = 0
        L_0x0196:
            if (r6 != 0) goto L_0x01be
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r4 = r13.length
            r5 = 0
        L_0x019f:
            if (r5 >= r4) goto L_0x01ad
            r6 = r13[r5]
            java.lang.String r6 = r6.getName()
            r2.add(r6)
            int r5 = r5 + 1
            goto L_0x019f
        L_0x01ad:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r3 = d4.h.U(r3)
            r4[r14] = r3
            r4[r11] = r2
            java.lang.String r2 = "Could not find creator property with name %s (known Creator properties: %s)"
            r8.u0(r9, r1, r2, r4)
            goto L_0x01e6
        L_0x01be:
            if (r2 == 0) goto L_0x01c3
            r6.P(r2)
        L_0x01c3:
            java.lang.Class[] r1 = r1.k()
            if (r1 != 0) goto L_0x01cd
            java.lang.Class[] r1 = r19.e()
        L_0x01cd:
            r6.G(r1)
            r10.e(r6)
            goto L_0x01e6
        L_0x01d4:
            if (r2 == 0) goto L_0x01e6
            java.lang.Class[] r1 = r1.k()
            if (r1 != 0) goto L_0x01e0
            java.lang.Class[] r1 = r19.e()
        L_0x01e0:
            r2.G(r1)
            r10.j(r2)
        L_0x01e6:
            r12 = 0
            goto L_0x0104
        L_0x01e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.f.l0(k3.g, k3.c, n3.e):void");
    }

    public void m0(g gVar, c cVar, e eVar) {
        Map i10 = cVar.i();
        if (i10 != null) {
            for (Map.Entry entry : i10.entrySet()) {
                i iVar = (i) entry.getValue();
                eVar.h(x.a(iVar.d()), iVar.f(), cVar.t(), iVar, entry.getKey());
            }
        }
    }

    public void n0(g gVar, c cVar, e eVar) {
        w wVar;
        j jVar;
        t tVar;
        b0 y10 = cVar.y();
        if (y10 != null) {
            Class<n0> c10 = y10.c();
            gVar.o(cVar.u(), y10);
            if (c10 == n0.class) {
                x d10 = y10.d();
                tVar = eVar.o(d10);
                if (tVar != null) {
                    j type = tVar.getType();
                    jVar = type;
                    wVar = new w(y10.f());
                } else {
                    throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{h.G(cVar.z()), h.V(d10)}));
                }
            } else {
                j jVar2 = gVar.l().K(gVar.x(c10), k0.class)[0];
                tVar = null;
                wVar = gVar.n(cVar.u(), y10);
                jVar = jVar2;
            }
            k3.k I = gVar.I(jVar);
            eVar.x(o3.s.a(jVar, y10.d(), wVar, I, tVar, (o0) null));
        }
    }

    public k3.k o0(g gVar, j jVar, c cVar) {
        k3.k kVar;
        try {
            w e02 = e0(gVar, cVar);
            e s02 = s0(gVar, cVar);
            s02.z(e02);
            l0(gVar, cVar, s02);
            n0(gVar, cVar, s02);
            k0(gVar, cVar, s02);
            m0(gVar, cVar, s02);
            gVar.k();
            if (this.f8210b.e()) {
                Iterator it = this.f8210b.b().iterator();
                if (it.hasNext()) {
                    m.a(it.next());
                    throw null;
                }
            }
            if (!jVar.z() || e02.l()) {
                kVar = s02.k();
            } else {
                kVar = s02.l();
            }
            if (this.f8210b.e()) {
                Iterator it2 = this.f8210b.b().iterator();
                if (it2.hasNext()) {
                    m.a(it2.next());
                    throw null;
                }
            }
            return kVar;
        } catch (NoClassDefFoundError e10) {
            return new o3.f(e10);
        } catch (IllegalArgumentException e11) {
            b u10 = b.u(gVar.S(), h.o(e11), cVar, (s) null);
            u10.initCause(e11);
            throw u10;
        }
    }

    public k3.k p0(g gVar, j jVar, c cVar) {
        String str;
        try {
            w e02 = e0(gVar, cVar);
            k3.f N = gVar.k();
            e s02 = s0(gVar, cVar);
            s02.z(e02);
            l0(gVar, cVar, s02);
            n0(gVar, cVar, s02);
            k0(gVar, cVar, s02);
            m0(gVar, cVar, s02);
            e.a n10 = cVar.n();
            if (n10 == null) {
                str = "build";
            } else {
                str = n10.f7619a;
            }
            r3.j l10 = cVar.l(str, (Class[]) null);
            if (l10 != null && N.b()) {
                h.g(l10.m(), N.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            s02.y(l10, n10);
            if (this.f8210b.e()) {
                Iterator it = this.f8210b.b().iterator();
                if (it.hasNext()) {
                    m.a(it.next());
                    throw null;
                }
            }
            k3.k m10 = s02.m(jVar, str);
            if (this.f8210b.e()) {
                Iterator it2 = this.f8210b.b().iterator();
                if (it2.hasNext()) {
                    m.a(it2.next());
                    throw null;
                }
            }
            return m10;
        } catch (NoClassDefFoundError e10) {
            return new o3.f(e10);
        } catch (IllegalArgumentException e11) {
            throw b.u(gVar.S(), h.o(e11), cVar, (s) null);
        }
    }

    public k3.k q0(g gVar, j jVar, c cVar) {
        t t02;
        gVar.k();
        e s02 = s0(gVar, cVar);
        s02.z(e0(gVar, cVar));
        l0(gVar, cVar, s02);
        r3.j l10 = cVar.l("initCause", f8266j);
        if (!(l10 == null || (t02 = t0(gVar, cVar, d4.w.E(gVar.k(), l10, new x("cause")), l10.w(0))) == null)) {
            s02.i(t02, true);
        }
        s02.f("localizedMessage");
        s02.f("suppressed");
        if (this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                m.a(it.next());
                throw null;
            }
        }
        k3.k k10 = s02.k();
        if (k10 instanceof c) {
            k10 = new j0((c) k10);
        }
        if (this.f8210b.e()) {
            Iterator it2 = this.f8210b.b().iterator();
            if (it2.hasNext()) {
                m.a(it2.next());
                throw null;
            }
        }
        return k10;
    }

    public s r0(g gVar, c cVar, i iVar) {
        j jVar;
        j jVar2;
        d.a aVar;
        k3.k kVar;
        if (iVar instanceof r3.j) {
            r3.j jVar3 = (r3.j) iVar;
            jVar = jVar3.w(0);
            jVar2 = f0(gVar, iVar, jVar3.w(1));
            aVar = new d.a(x.a(iVar.d()), jVar2, (x) null, iVar, k3.w.f7486i);
        } else if (iVar instanceof r3.g) {
            j f02 = f0(gVar, iVar, ((r3.g) iVar).f());
            jVar = f02.p();
            j k10 = f02.k();
            aVar = new d.a(x.a(iVar.d()), f02, (x) null, iVar, k3.w.f7486i);
            jVar2 = k10;
        } else {
            return (s) gVar.q(cVar.z(), String.format("Unrecognized mutator type for any setter: %s", new Object[]{iVar.getClass()}));
        }
        k3.p a02 = a0(gVar, iVar);
        if (a02 == null) {
            a02 = (k3.p) jVar.u();
        }
        if (a02 == null) {
            a02 = gVar.F(jVar, aVar);
        }
        k3.p pVar = a02;
        k3.k X = X(gVar, iVar);
        if (X == null) {
            X = (k3.k) jVar2.u();
        }
        if (X != null) {
            kVar = gVar.Y(X, aVar, jVar2);
        } else {
            kVar = X;
        }
        return new s(aVar, iVar, jVar2, pVar, kVar, (w3.e) jVar2.t());
    }

    public e s0(g gVar, c cVar) {
        return new e(cVar, gVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: n3.t} */
    /* JADX WARNING: type inference failed for: r1v2, types: [n3.t, k3.d] */
    /* JADX WARNING: type inference failed for: r1v3, types: [n3.t] */
    /* JADX WARNING: type inference failed for: r3v2, types: [o3.i] */
    /* JADX WARNING: type inference failed for: r3v3, types: [o3.o] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n3.t t0(k3.g r10, k3.c r11, r3.s r12, k3.j r13) {
        /*
            r9 = this;
            r3.i r0 = r12.r()
            if (r0 != 0) goto L_0x000e
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "No non-constructor mutator available"
            r10.u0(r11, r12, r2, r1)
        L_0x000e:
            k3.j r13 = r9.f0(r10, r0, r13)
            java.lang.Object r1 = r13.t()
            r6 = r1
            w3.e r6 = (w3.e) r6
            boolean r1 = r0 instanceof r3.j
            if (r1 == 0) goto L_0x002d
            o3.o r1 = new o3.o
            d4.b r7 = r11.t()
            r8 = r0
            r3.j r8 = (r3.j) r8
            r3 = r1
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x003c
        L_0x002d:
            o3.i r1 = new o3.i
            d4.b r7 = r11.t()
            r8 = r0
            r3.g r8 = (r3.g) r8
            r3 = r1
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8)
        L_0x003c:
            k3.k r11 = r9.Z(r10, r0)
            if (r11 != 0) goto L_0x0048
            java.lang.Object r11 = r13.u()
            k3.k r11 = (k3.k) r11
        L_0x0048:
            if (r11 == 0) goto L_0x0052
            k3.k r10 = r10.Y(r11, r1, r13)
            n3.t r1 = r1.L(r10)
        L_0x0052:
            k3.b$a r10 = r12.j()
            if (r10 == 0) goto L_0x0065
            boolean r11 = r10.d()
            if (r11 == 0) goto L_0x0065
            java.lang.String r10 = r10.b()
            r1.E(r10)
        L_0x0065:
            r3.b0 r10 = r12.h()
            if (r10 == 0) goto L_0x006e
            r1.F(r10)
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.f.t0(k3.g, k3.c, r3.s, k3.j):n3.t");
    }

    public t u0(g gVar, c cVar, s sVar) {
        r3.j p10 = sVar.p();
        j f02 = f0(gVar, p10, p10.f());
        a0 a0Var = new a0(sVar, f02, (w3.e) f02.t(), cVar.t(), p10);
        k3.k Z = Z(gVar, p10);
        if (Z == null) {
            Z = (k3.k) f02.u();
        }
        if (Z != null) {
            return a0Var.L(gVar.Y(Z, a0Var, f02));
        }
        return a0Var;
    }

    public List v0(g gVar, c cVar, e eVar, List list, Set set, Set set2) {
        Class u10;
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            String name = sVar.getName();
            if (!d4.m.c(name, set, set2)) {
                if (sVar.x() || (u10 = sVar.u()) == null || !x0(gVar.k(), sVar, u10, hashMap)) {
                    arrayList.add(sVar);
                } else {
                    eVar.f(name);
                }
            }
        }
        return arrayList;
    }

    public k3.k w0(g gVar, j jVar, c cVar) {
        k3.k Y = Y(gVar, jVar, cVar);
        if (Y != null && this.f8210b.e()) {
            Iterator it = this.f8210b.b().iterator();
            if (it.hasNext()) {
                m.a(it.next());
                gVar.k();
                throw null;
            }
        }
        return Y;
    }

    public boolean x0(k3.f fVar, s sVar, Class cls, Map map) {
        Boolean bool;
        Boolean bool2 = (Boolean) map.get(cls);
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (cls == String.class || cls.isPrimitive()) {
            bool = Boolean.FALSE;
        } else {
            bool = fVar.j(cls).f();
            if (bool == null) {
                bool = fVar.g().r0(fVar.A(cls).u());
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
            }
        }
        map.put(cls, bool);
        return bool.booleanValue();
    }

    public boolean y0(Class cls) {
        String f10 = h.f(cls);
        if (f10 != null) {
            throw new IllegalArgumentException("Cannot deserialize Class " + cls.getName() + " (of type " + f10 + ") as a Bean");
        } else if (!h.S(cls)) {
            String P = h.P(cls, true);
            if (P == null) {
                return true;
            }
            throw new IllegalArgumentException("Cannot deserialize Class " + cls.getName() + " (of type " + P + ") as a Bean");
        } else {
            throw new IllegalArgumentException("Cannot deserialize Proxy class " + cls.getName() + " as a Bean");
        }
    }

    public j z0(g gVar, j jVar, c cVar) {
        Iterator it = this.f8210b.a().iterator();
        if (!it.hasNext()) {
            return null;
        }
        m.a(it.next());
        gVar.k();
        throw null;
    }
}
