package n3;

import androidx.appcompat.app.m;
import b3.k0;
import b3.o0;
import c3.k;
import c3.n;
import d4.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.f;
import k3.g;
import k3.i;
import k3.j;
import o3.z;

public abstract class l extends g {

    /* renamed from: m  reason: collision with root package name */
    public transient LinkedHashMap f8276m;

    /* renamed from: n  reason: collision with root package name */
    public List f8277n;

    public static final class a extends l {
        public a(n nVar) {
            super(nVar, (m) null);
        }

        public l Q0(f fVar) {
            return new a(this, fVar);
        }

        public l R0(f fVar, k kVar, i iVar) {
            return new a(this, fVar, kVar, iVar);
        }

        public l V0(n nVar) {
            return new a(this, nVar);
        }

        public a(a aVar, f fVar, k kVar, i iVar) {
            super(aVar, fVar, kVar, iVar);
        }

        public a(a aVar, n nVar) {
            super((l) aVar, nVar);
        }

        public a(a aVar, f fVar) {
            super((l) aVar, fVar);
        }
    }

    public l(n nVar, m mVar) {
        super(nVar, mVar);
    }

    public z H(Object obj, k0 k0Var, o0 o0Var) {
        if (obj == null) {
            return null;
        }
        k0.a f10 = k0Var.f(obj);
        LinkedHashMap linkedHashMap = this.f8276m;
        if (linkedHashMap == null) {
            this.f8276m = new LinkedHashMap();
        } else {
            z zVar = (z) linkedHashMap.get(f10);
            if (zVar != null) {
                return zVar;
            }
        }
        List list = this.f8277n;
        if (list == null) {
            this.f8277n = new ArrayList(8);
        } else {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                m.a(it.next());
                throw null;
            }
        }
        o0Var.a(this);
        this.f8277n.add((Object) null);
        z S0 = S0(f10);
        S0.g((o0) null);
        this.f8276m.put(f10, S0);
        return S0;
    }

    public Object O0(k kVar, j jVar, k3.k kVar2, Object obj) {
        Object obj2;
        String c10 = this.f7372c.J(jVar).c();
        n n10 = kVar.n();
        n nVar = n.START_OBJECT;
        if (n10 != nVar) {
            F0(jVar, nVar, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", h.U(c10), kVar.n());
        }
        n s02 = kVar.s0();
        n nVar2 = n.FIELD_NAME;
        if (s02 != nVar2) {
            F0(jVar, nVar2, "Current token not FIELD_NAME (to contain expected root name %s), but %s", h.U(c10), kVar.n());
        }
        String m10 = kVar.m();
        if (!c10.equals(m10)) {
            B0(jVar, m10, "Root name (%s) does not match expected (%s) for type %s", h.U(m10), h.U(c10), h.G(jVar));
        }
        kVar.s0();
        if (obj == null) {
            obj2 = kVar2.deserialize(kVar, this);
        } else {
            obj2 = kVar2.deserialize(kVar, this, obj);
        }
        n s03 = kVar.s0();
        n nVar3 = n.END_OBJECT;
        if (s03 != nVar3) {
            F0(jVar, nVar3, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", h.U(c10), kVar.n());
        }
        return obj2;
    }

    public void P0() {
        if (this.f8276m != null && n0(k3.h.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
            u uVar = null;
            for (Map.Entry value : this.f8276m.entrySet()) {
                z zVar = (z) value.getValue();
                if (zVar.d() && !U0(zVar)) {
                    if (uVar == null) {
                        uVar = new u(S(), "Unresolved forward references for: ");
                    }
                    Object obj = zVar.c().f4280c;
                    Iterator e10 = zVar.e();
                    while (e10.hasNext()) {
                        z.a aVar = (z.a) e10.next();
                        uVar.s(obj, aVar.a(), aVar.b());
                    }
                }
            }
            if (uVar != null) {
                throw uVar;
            }
        }
    }

    public abstract l Q0(f fVar);

    public abstract l R0(f fVar, k kVar, i iVar);

    public z S0(k0.a aVar) {
        return new z(aVar);
    }

    public Object T0(k kVar, j jVar, k3.k kVar2, Object obj) {
        if (this.f7372c.k0()) {
            return O0(kVar, jVar, kVar2, obj);
        }
        if (obj == null) {
            return kVar2.deserialize(kVar, this);
        }
        return kVar2.deserialize(kVar, this, obj);
    }

    public boolean U0(z zVar) {
        return zVar.h(this);
    }

    public abstract l V0(n nVar);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: k3.p} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final k3.p p0(r3.b r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3 = 0
            if (r4 != 0) goto L_0x0004
            return r3
        L_0x0004:
            boolean r0 = r4 instanceof k3.p
            if (r0 == 0) goto L_0x000b
            k3.p r4 = (k3.p) r4
            goto L_0x0036
        L_0x000b:
            boolean r0 = r4 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0062
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Class<k3.p$a> r0 = k3.p.a.class
            if (r4 == r0) goto L_0x0061
            boolean r0 = d4.h.J(r4)
            if (r0 == 0) goto L_0x001c
            goto L_0x0061
        L_0x001c:
            java.lang.Class<k3.p> r3 = k3.p.class
            boolean r3 = r3.isAssignableFrom(r4)
            if (r3 == 0) goto L_0x0041
            k3.f r3 = r2.f7372c
            r3.u()
            k3.f r3 = r2.f7372c
            boolean r3 = r3.b()
            java.lang.Object r3 = d4.h.l(r4, r3)
            r4 = r3
            k3.p r4 = (k3.p) r4
        L_0x0036:
            boolean r3 = r4 instanceof n3.r
            if (r3 == 0) goto L_0x0040
            r3 = r4
            n3.r r3 = (n3.r) r3
            r3.resolve(r2)
        L_0x0040:
            return r4
        L_0x0041:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned Class "
            r0.append(r1)
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected Class<KeyDeserializer>"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x0061:
            return r3
        L_0x0062:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned key deserializer definition of type "
            r0.append(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected type KeyDeserializer or Class<KeyDeserializer> instead"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.l.p0(r3.b, java.lang.Object):k3.p");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: k3.k} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.k y(r3.b r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3 = 0
            if (r4 != 0) goto L_0x0004
            return r3
        L_0x0004:
            boolean r0 = r4 instanceof k3.k
            if (r0 == 0) goto L_0x000b
            k3.k r4 = (k3.k) r4
            goto L_0x0036
        L_0x000b:
            boolean r0 = r4 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0062
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Class<k3.k$a> r0 = k3.k.a.class
            if (r4 == r0) goto L_0x0061
            boolean r0 = d4.h.J(r4)
            if (r0 == 0) goto L_0x001c
            goto L_0x0061
        L_0x001c:
            java.lang.Class<k3.k> r3 = k3.k.class
            boolean r3 = r3.isAssignableFrom(r4)
            if (r3 == 0) goto L_0x0041
            k3.f r3 = r2.f7372c
            r3.u()
            k3.f r3 = r2.f7372c
            boolean r3 = r3.b()
            java.lang.Object r3 = d4.h.l(r4, r3)
            r4 = r3
            k3.k r4 = (k3.k) r4
        L_0x0036:
            boolean r3 = r4 instanceof n3.r
            if (r3 == 0) goto L_0x0040
            r3 = r4
            n3.r r3 = (n3.r) r3
            r3.resolve(r2)
        L_0x0040:
            return r4
        L_0x0041:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned Class "
            r0.append(r1)
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected Class<JsonDeserializer>"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        L_0x0061:
            return r3
        L_0x0062:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AnnotationIntrospector returned deserializer definition of type "
            r0.append(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            r0.append(r4)
            java.lang.String r4 = "; expected type JsonDeserializer or Class<JsonDeserializer> instead"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.l.y(r3.b, java.lang.Object):k3.k");
    }

    public l(l lVar, f fVar, k kVar, i iVar) {
        super(lVar, fVar, kVar, iVar);
    }

    public l(l lVar, f fVar) {
        super((g) lVar, fVar);
    }

    public l(l lVar, n nVar) {
        super((g) lVar, nVar);
    }
}
