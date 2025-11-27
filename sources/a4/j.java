package a4;

import b3.k0;
import b4.t;
import c3.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import k3.a0;
import k3.b0;
import k3.c0;
import k3.d;
import k3.l;
import k3.o;
import k3.x;
import r3.s;

public abstract class j extends c0 implements Serializable {

    /* renamed from: o  reason: collision with root package name */
    public transient Map f212o;

    /* renamed from: p  reason: collision with root package name */
    public transient ArrayList f213p;

    /* renamed from: q  reason: collision with root package name */
    public transient h f214q;

    public static final class a extends j {
        public a() {
        }

        /* renamed from: F0 */
        public a A0(a0 a0Var, q qVar) {
            return new a(this, a0Var, qVar);
        }

        public a(c0 c0Var, a0 a0Var, q qVar) {
            super(c0Var, a0Var, qVar);
        }
    }

    public j() {
    }

    public abstract j A0(a0 a0Var, q qVar);

    public void B0(h hVar, Object obj, k3.j jVar, o oVar, w3.h hVar2) {
        boolean z10;
        this.f214q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        if (jVar != null && !jVar.q().isAssignableFrom(obj.getClass())) {
            y(obj, jVar);
        }
        if (oVar == null) {
            if (jVar == null || !jVar.D()) {
                oVar = S(obj.getClass(), (d) null);
            } else {
                oVar = U(jVar, (d) null);
            }
        }
        x S = this.f7341a.S();
        if (S == null) {
            z10 = this.f7341a.c0(b0.WRAP_ROOT_VALUE);
            if (z10) {
                hVar.v0();
                hVar.Y(this.f7341a.I(obj.getClass()).i(this.f7341a));
            }
        } else if (S.h()) {
            z10 = false;
        } else {
            hVar.v0();
            hVar.Z(S.c());
            z10 = true;
        }
        try {
            oVar.serializeWithType(obj, hVar, this, hVar2);
            if (z10) {
                hVar.W();
            }
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public void C0(h hVar, Object obj) {
        this.f214q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        Class<?> cls = obj.getClass();
        o P = P(cls, true, (d) null);
        x S = this.f7341a.S();
        if (S == null) {
            if (this.f7341a.c0(b0.WRAP_ROOT_VALUE)) {
                x0(hVar, obj, P, this.f7341a.I(cls));
                return;
            }
        } else if (!S.h()) {
            x0(hVar, obj, P, S);
            return;
        }
        w0(hVar, obj, P);
    }

    public void D0(h hVar, Object obj, k3.j jVar) {
        this.f214q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        if (!jVar.q().isAssignableFrom(obj.getClass())) {
            y(obj, jVar);
        }
        o Q = Q(jVar, true, (d) null);
        x S = this.f7341a.S();
        if (S == null) {
            if (this.f7341a.c0(b0.WRAP_ROOT_VALUE)) {
                x0(hVar, obj, Q, this.f7341a.J(jVar));
                return;
            }
        } else if (!S.h()) {
            x0(hVar, obj, Q, S);
            return;
        }
        w0(hVar, obj, Q);
    }

    public void E0(h hVar, Object obj, k3.j jVar, o oVar) {
        x xVar;
        this.f214q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        if (jVar != null && !jVar.q().isAssignableFrom(obj.getClass())) {
            y(obj, jVar);
        }
        if (oVar == null) {
            oVar = Q(jVar, true, (d) null);
        }
        x S = this.f7341a.S();
        if (S == null) {
            if (this.f7341a.c0(b0.WRAP_ROOT_VALUE)) {
                if (jVar == null) {
                    xVar = this.f7341a.I(obj.getClass());
                } else {
                    xVar = this.f7341a.J(jVar);
                }
                x0(hVar, obj, oVar, xVar);
                return;
            }
        } else if (!S.h()) {
            x0(hVar, obj, oVar, S);
            return;
        }
        w0(hVar, obj, oVar);
    }

    public t M(Object obj, k0 k0Var) {
        k0 k0Var2;
        Map map = this.f212o;
        if (map == null) {
            this.f212o = v0();
        } else {
            t tVar = (t) map.get(obj);
            if (tVar != null) {
                return tVar;
            }
        }
        ArrayList arrayList = this.f213p;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                k0Var2 = (k0) this.f213p.get(i10);
                if (k0Var2.a(k0Var)) {
                    break;
                }
                i10++;
            }
        } else {
            this.f213p = new ArrayList(8);
        }
        k0Var2 = null;
        if (k0Var2 == null) {
            k0Var2 = k0Var.h(this);
            this.f213p.add(k0Var2);
        }
        t tVar2 = new t(k0Var2);
        this.f212o.put(obj, tVar2);
        return tVar2;
    }

    public h d0() {
        return this.f214q;
    }

    public Object j0(s sVar, Class cls) {
        if (cls == null) {
            return null;
        }
        this.f7341a.u();
        return d4.h.l(cls, this.f7341a.b());
    }

    public boolean k0(Object obj) {
        if (obj == null) {
            return true;
        }
        try {
            return obj.equals((Object) null);
        } catch (Throwable th) {
            o0(obj.getClass(), String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", new Object[]{obj.getClass().getName(), th.getClass().getName(), d4.h.o(th)}), th);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: k3.o} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o t0(r3.b r5, java.lang.Object r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof k3.o
            if (r1 == 0) goto L_0x000b
            k3.o r6 = (k3.o) r6
            goto L_0x007c
        L_0x000b:
            boolean r1 = r6 instanceof java.lang.Class
            if (r1 != 0) goto L_0x0034
            k3.j r1 = r5.f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AnnotationIntrospector returned serializer definition of type "
            r2.append(r3)
            java.lang.Class r3 = r6.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = "; expected type JsonSerializer or Class<JsonSerializer> instead"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r4.q(r1, r2)
        L_0x0034:
            java.lang.Class r6 = (java.lang.Class) r6
            java.lang.Class<k3.o$a> r1 = k3.o.a.class
            if (r6 == r1) goto L_0x0081
            boolean r1 = d4.h.J(r6)
            if (r1 == 0) goto L_0x0041
            goto L_0x0081
        L_0x0041:
            java.lang.Class<k3.o> r0 = k3.o.class
            boolean r0 = r0.isAssignableFrom(r6)
            if (r0 != 0) goto L_0x006a
            k3.j r5 = r5.f()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned Class "
            r0.append(r1)
            java.lang.String r1 = r6.getName()
            r0.append(r1)
            java.lang.String r1 = "; expected Class<JsonSerializer>"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.q(r5, r0)
        L_0x006a:
            k3.a0 r5 = r4.f7341a
            r5.u()
            k3.a0 r5 = r4.f7341a
            boolean r5 = r5.b()
            java.lang.Object r5 = d4.h.l(r6, r5)
            r6 = r5
            k3.o r6 = (k3.o) r6
        L_0x007c:
            k3.o r5 = r4.x(r6)
            return r5
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.j.t0(r3.b, java.lang.Object):k3.o");
    }

    public Map v0() {
        if (m0(b0.USE_EQUALITY_FOR_OBJECT_ID)) {
            return new HashMap();
        }
        return new IdentityHashMap();
    }

    public final void w0(h hVar, Object obj, o oVar) {
        try {
            oVar.serialize(obj, hVar, this);
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public final void x0(h hVar, Object obj, o oVar, x xVar) {
        try {
            hVar.v0();
            hVar.Y(xVar.i(this.f7341a));
            oVar.serialize(obj, hVar, this);
            hVar.W();
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public void y0(h hVar) {
        try {
            Z().serialize((Object) null, hVar, this);
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public final IOException z0(h hVar, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String o10 = d4.h.o(exc);
        if (o10 == null) {
            o10 = "[no message for " + exc.getClass().getName() + "]";
        }
        return new l((Closeable) hVar, o10, (Throwable) exc);
    }

    public j(c0 c0Var, a0 a0Var, q qVar) {
        super(c0Var, a0Var, qVar);
    }
}
