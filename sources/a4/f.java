package a4;

import androidx.appcompat.app.m;
import b3.e0;
import b3.k0;
import b3.n0;
import b3.p;
import b3.s;
import b4.q;
import com.fasterxml.jackson.databind.ser.std.d0;
import com.fasterxml.jackson.databind.ser.std.t;
import d4.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.a0;
import k3.b;
import k3.c;
import k3.c0;
import k3.d;
import k3.j;
import k3.l;
import k3.o;
import k3.w;
import k3.x;
import m3.p;
import r3.b0;
import r3.g;
import r3.i;
import r3.s;
import w3.h;

public class f extends b {

    /* renamed from: d  reason: collision with root package name */
    public static final f f211d = new f((p) null);

    public f(p pVar) {
        super(pVar);
    }

    public q I(p pVar) {
        if (this.f181a == pVar) {
            return this;
        }
        if (getClass() == f.class) {
            return new f(pVar);
        }
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': cannot instantiate subtype with additional serializer definitions");
    }

    public c J(c0 c0Var, s sVar, l lVar, boolean z10, i iVar) {
        h hVar;
        c0 c0Var2 = c0Var;
        i iVar2 = iVar;
        x c10 = sVar.c();
        j f10 = iVar.f();
        d.a aVar = new d.a(c10, f10, sVar.w(), iVar, sVar.getMetadata());
        o F = F(c0Var, iVar2);
        if (F instanceof o) {
            ((o) F).a(c0Var);
        }
        o h02 = c0Var.h0(F, aVar);
        if (f10.D() || f10.b()) {
            hVar = V(f10, c0Var.k(), iVar2);
        } else {
            hVar = null;
        }
        h hVar2 = hVar;
        return lVar.c(c0Var, sVar, f10, h02, W(f10, c0Var.k(), iVar2), hVar2, iVar, z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f A[LOOP:0: B:11:0x002f->B:14:0x003f, LOOP_START, PHI: r3 
      PHI: (r3v1 k3.o) = (r3v0 k3.o), (r3v5 k3.o) binds: [B:10:0x0026, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o K(k3.c0 r6, k3.j r7, k3.c r8, boolean r9) {
        /*
            r5 = this;
            k3.a0 r0 = r6.k()
            boolean r1 = r7.D()
            r2 = 0
            if (r1 == 0) goto L_0x0018
            if (r9 != 0) goto L_0x0011
            boolean r9 = r5.H(r0, r8, r2)
        L_0x0011:
            k3.o r1 = r5.n(r6, r7, r8, r9)
            if (r1 == 0) goto L_0x0048
            return r1
        L_0x0018:
            boolean r1 = r7.b()
            if (r1 == 0) goto L_0x0026
            r1 = r7
            c4.j r1 = (c4.j) r1
            k3.o r1 = r5.A(r6, r1, r8, r9)
            goto L_0x0042
        L_0x0026:
            java.lang.Iterable r1 = r5.v()
            java.util.Iterator r1 = r1.iterator()
            r3 = r2
        L_0x002f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0041
            java.lang.Object r3 = r1.next()
            a4.r r3 = (a4.r) r3
            k3.o r3 = r3.c(r0, r7, r8)
            if (r3 == 0) goto L_0x002f
        L_0x0041:
            r1 = r3
        L_0x0042:
            if (r1 != 0) goto L_0x0048
            k3.o r1 = r5.C(r6, r7, r8)
        L_0x0048:
            if (r1 != 0) goto L_0x0064
            k3.o r1 = r5.D(r7, r0, r8, r9)
            if (r1 != 0) goto L_0x0064
            k3.o r1 = r5.E(r6, r7, r8, r9)
            if (r1 != 0) goto L_0x0064
            k3.o r1 = r5.T(r6, r7, r8, r9)
            if (r1 != 0) goto L_0x0064
            java.lang.Class r7 = r8.s()
            k3.o r1 = r6.g0(r7)
        L_0x0064:
            if (r1 == 0) goto L_0x0087
            m3.p r6 = r5.f181a
            boolean r6 = r6.b()
            if (r6 == 0) goto L_0x0087
            m3.p r6 = r5.f181a
            java.lang.Iterable r6 = r6.d()
            java.util.Iterator r6 = r6.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x007f
            goto L_0x0087
        L_0x007f:
            java.lang.Object r6 = r6.next()
            androidx.appcompat.app.m.a(r6)
            throw r2
        L_0x0087:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.f.K(k3.c0, k3.j, k3.c, boolean):k3.o");
    }

    public o L(c0 c0Var, j jVar, c cVar) {
        String a10 = e.a(jVar);
        if (a10 == null || c0Var.k().a(jVar.q()) != null) {
            return null;
        }
        return new q(jVar, a10);
    }

    public o M(c0 c0Var, j jVar, c cVar, boolean z10) {
        List list;
        c0 c0Var2 = c0Var;
        c cVar2 = cVar;
        Class<Object> cls = Object.class;
        if (cVar.s() == cls) {
            return c0Var2.g0(cls);
        }
        o L = L(c0Var, jVar, cVar);
        if (L != null) {
            return L;
        }
        a0 Y = c0Var.k();
        e N = N(cVar2);
        N.j(Y);
        List U = U(c0Var2, cVar2, N);
        if (U == null) {
            list = new ArrayList();
        } else {
            list = a0(c0Var2, cVar2, N, U);
        }
        c0Var.W().d(Y, cVar.u(), list);
        if (this.f181a.b()) {
            Iterator it = this.f181a.d().iterator();
            if (it.hasNext()) {
                m.a(it.next());
                throw null;
            }
        }
        List R = R(Y, cVar2, S(Y, cVar2, list));
        if (this.f181a.b()) {
            Iterator it2 = this.f181a.d().iterator();
            if (it2.hasNext()) {
                m.a(it2.next());
                throw null;
            }
        }
        N.m(P(c0Var2, cVar2, R));
        N.n(R);
        N.k(y(Y, cVar2));
        i a10 = cVar.a();
        if (a10 != null) {
            j f10 = a10.f();
            j k10 = f10.k();
            h c10 = c(Y, k10);
            o F = F(c0Var2, a10);
            if (F == null) {
                F = t.n((Set) null, f10, Y.D(k3.q.USE_STATIC_TYPING), c10, (o) null, (o) null, (Object) null);
            }
            N.i(new a(new d.a(x.a(a10.d()), k10, (x) null, a10, w.f7486i), a10, F));
        }
        Y(Y, N);
        if (this.f181a.b()) {
            Iterator it3 = this.f181a.d().iterator();
            if (it3.hasNext()) {
                m.a(it3.next());
                throw null;
            }
        }
        try {
            o a11 = N.a();
            if (a11 == null) {
                if (jVar.L()) {
                    return N.b();
                }
                a11 = B(Y, jVar, cVar2, z10);
                if (a11 == null && cVar.A()) {
                    return N.b();
                }
            }
            return a11;
        } catch (RuntimeException e10) {
            RuntimeException runtimeException = e10;
            return (o) c0Var2.q0(cVar2, "Failed to construct BeanSerializer for %s: (%s) %s", cVar.z(), runtimeException.getClass().getName(), runtimeException.getMessage());
        }
    }

    public e N(c cVar) {
        return new e(cVar);
    }

    public c O(c cVar, Class[] clsArr) {
        return b4.d.a(cVar, clsArr);
    }

    public b4.i P(c0 c0Var, c cVar, List list) {
        b0 y10 = cVar.y();
        if (y10 == null) {
            return null;
        }
        Class<n0> c10 = y10.c();
        if (c10 == n0.class) {
            String c11 = y10.d().c();
            int size = list.size();
            for (int i10 = 0; i10 != size; i10++) {
                c cVar2 = (c) list.get(i10);
                if (c11.equals(cVar2.getName())) {
                    if (i10 > 0) {
                        list.remove(i10);
                        list.add(0, cVar2);
                    }
                    return b4.i.a(cVar2.getType(), (x) null, new b4.j(y10, cVar2), y10.b());
                }
            }
            throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{d4.h.G(cVar.z()), d4.h.U(c11)}));
        }
        return b4.i.a(c0Var.l().K(c0Var.i(c10), k0.class)[0], y10.d(), c0Var.n(cVar.u(), y10), y10.b());
    }

    public l Q(a0 a0Var, c cVar) {
        return new l(a0Var, cVar);
    }

    public List R(a0 a0Var, c cVar, List list) {
        Set set;
        p.a O = a0Var.O(cVar.s(), cVar.u());
        Set set2 = null;
        if (O != null) {
            set = O.h();
        } else {
            set = null;
        }
        s.a Q = a0Var.Q(cVar.s(), cVar.u());
        if (Q != null) {
            set2 = Q.e();
        }
        if (set2 != null || (set != null && !set.isEmpty())) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (d4.m.c(((c) it.next()).getName(), set, set2)) {
                    it.remove();
                }
            }
        }
        return list;
    }

    public List S(a0 a0Var, c cVar, List list) {
        j z10 = cVar.z();
        Class<CharSequence> cls = CharSequence.class;
        if (z10.N(cls)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i d10 = ((c) it.next()).d();
                if ((d10 instanceof r3.j) && "isEmpty".equals(d10.d()) && d10.k() == cls) {
                    it.remove();
                }
            }
        }
        return list;
    }

    public o T(c0 c0Var, j jVar, c cVar, boolean z10) {
        if (X(jVar.q()) || d4.h.L(jVar.q())) {
            return M(c0Var, jVar, cVar, z10);
        }
        return null;
    }

    public List U(c0 c0Var, c cVar, e eVar) {
        List<r3.s> o10 = cVar.o();
        a0 Y = c0Var.k();
        Z(Y, cVar, o10);
        if (Y.D(k3.q.REQUIRE_SETTERS_FOR_GETTERS)) {
            b0(Y, cVar, o10);
        }
        if (o10.isEmpty()) {
            return null;
        }
        boolean H = H(Y, cVar, (h) null);
        l Q = Q(Y, cVar);
        ArrayList arrayList = new ArrayList(o10.size());
        for (r3.s sVar : o10) {
            i l10 = sVar.l();
            if (!sVar.D()) {
                b.a j10 = sVar.j();
                if (j10 == null || !j10.c()) {
                    if (l10 instanceof r3.j) {
                        arrayList.add(J(c0Var, sVar, Q, H, (r3.j) l10));
                    } else {
                        arrayList.add(J(c0Var, sVar, Q, H, (g) l10));
                    }
                }
            } else if (l10 != null) {
                eVar.o(l10);
            }
        }
        return arrayList;
    }

    public h V(j jVar, a0 a0Var, i iVar) {
        j k10 = jVar.k();
        w3.g H = a0Var.g().H(a0Var, iVar, jVar);
        if (H == null) {
            return c(a0Var, k10);
        }
        return H.b(a0Var, k10, a0Var.T().b(a0Var, iVar, k10));
    }

    public h W(j jVar, a0 a0Var, i iVar) {
        w3.g P = a0Var.g().P(a0Var, iVar, jVar);
        if (P == null) {
            return c(a0Var, jVar);
        }
        return P.b(a0Var, jVar, a0Var.T().b(a0Var, iVar, jVar));
    }

    public boolean X(Class cls) {
        if (d4.h.f(cls) != null || d4.h.S(cls)) {
            return false;
        }
        return true;
    }

    public void Y(a0 a0Var, e eVar) {
        List g10 = eVar.g();
        boolean D = a0Var.D(k3.q.DEFAULT_VIEW_INCLUSION);
        int size = g10.size();
        c[] cVarArr = new c[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) g10.get(i11);
            Class[] t10 = cVar.t();
            if (t10 != null && t10.length != 0) {
                i10++;
                cVarArr[i11] = O(cVar, t10);
            } else if (D) {
                cVarArr[i11] = cVar;
            }
        }
        if (!D || i10 != 0) {
            eVar.l(cVarArr);
        }
    }

    public void Z(a0 a0Var, c cVar, List list) {
        b g10 = a0Var.g();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r3.s sVar = (r3.s) it.next();
            if (sVar.l() == null) {
                it.remove();
            } else {
                Class u10 = sVar.u();
                Boolean bool = (Boolean) hashMap.get(u10);
                if (bool == null) {
                    bool = a0Var.j(u10).f();
                    if (bool == null && (bool = g10.r0(a0Var.A(u10).u())) == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(u10, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    public List a0(c0 c0Var, c cVar, e eVar, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar2 = (c) list.get(i10);
            h s10 = cVar2.s();
            if (s10 != null && s10.c() == e0.a.EXTERNAL_PROPERTY) {
                x a10 = x.a(s10.b());
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        c cVar3 = (c) it.next();
                        if (cVar3 != cVar2 && cVar3.E(a10)) {
                            cVar2.m((h) null);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return list;
    }

    public o b(c0 c0Var, j jVar) {
        j jVar2;
        a0 Y = c0Var.k();
        c b02 = Y.b0(jVar);
        o F = F(c0Var, b02.u());
        if (F != null) {
            return F;
        }
        b g10 = Y.g();
        boolean z10 = false;
        if (g10 == null) {
            jVar2 = jVar;
        } else {
            try {
                jVar2 = g10.v0(Y, b02.u(), jVar);
            } catch (l e10) {
                return (o) c0Var.q0(b02, e10.getMessage(), new Object[0]);
            }
        }
        if (jVar2 != jVar) {
            if (!jVar2.y(jVar.q())) {
                b02 = Y.b0(jVar2);
            }
            z10 = true;
        }
        d4.j q10 = b02.q();
        if (q10 == null) {
            return K(c0Var, jVar2, b02, z10);
        }
        j a10 = q10.a(c0Var.l());
        if (!a10.y(jVar2.q())) {
            b02 = Y.b0(a10);
            F = F(c0Var, b02.u());
        }
        if (F == null && !a10.I()) {
            F = K(c0Var, a10, b02, true);
        }
        return new d0(q10, a10, F);
    }

    public void b0(a0 a0Var, c cVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r3.s sVar = (r3.s) it.next();
            if (!sVar.e() && !sVar.B()) {
                it.remove();
            }
        }
    }

    public Iterable v() {
        return this.f181a.e();
    }
}
