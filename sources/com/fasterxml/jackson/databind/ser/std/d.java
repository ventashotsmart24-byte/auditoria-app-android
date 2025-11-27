package com.fasterxml.jackson.databind.ser.std;

import a4.c;
import a4.e;
import a4.i;
import a4.o;
import b3.k;
import b3.k0;
import b3.n0;
import b4.t;
import c3.n;
import d4.q;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k3.a0;
import k3.b;
import k3.c0;
import k3.j;
import k3.l;
import k3.m;
import k3.x;
import r3.b0;
import u3.f;
import w3.h;
import z3.r;

public abstract class d extends i0 implements i, o {

    /* renamed from: i  reason: collision with root package name */
    public static final x f5745i = new x("#object-ref");

    /* renamed from: j  reason: collision with root package name */
    public static final c[] f5746j = new c[0];

    /* renamed from: a  reason: collision with root package name */
    public final j f5747a;

    /* renamed from: b  reason: collision with root package name */
    public final c[] f5748b;

    /* renamed from: c  reason: collision with root package name */
    public final c[] f5749c;

    /* renamed from: d  reason: collision with root package name */
    public final a4.a f5750d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f5751e;

    /* renamed from: f  reason: collision with root package name */
    public final r3.i f5752f;

    /* renamed from: g  reason: collision with root package name */
    public final b4.i f5753g;

    /* renamed from: h  reason: collision with root package name */
    public final k.c f5754h;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5755a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                b3.k$c[] r0 = b3.k.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5755a = r0
                b3.k$c r1 = b3.k.c.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5755a     // Catch:{ NoSuchFieldError -> 0x001d }
                b3.k$c r1 = b3.k.c.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5755a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b3.k$c r1 = b3.k.c.NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.d.a.<clinit>():void");
        }
    }

    public d(j jVar, e eVar, c[] cVarArr, c[] cVarArr2) {
        super(jVar);
        this.f5747a = jVar;
        this.f5748b = cVarArr;
        this.f5749c = cVarArr2;
        if (eVar == null) {
            this.f5752f = null;
            this.f5750d = null;
            this.f5751e = null;
            this.f5753g = null;
            this.f5754h = null;
            return;
        }
        this.f5752f = eVar.h();
        this.f5750d = eVar.c();
        this.f5751e = eVar.e();
        this.f5753g = eVar.f();
        this.f5754h = eVar.d().g((k.d) null).i();
    }

    public static final c[] i(c[] cVarArr, q qVar) {
        if (cVarArr == null || cVarArr.length == 0 || qVar == null || qVar == q.f6290a) {
            return cVarArr;
        }
        int length = cVarArr.length;
        c[] cVarArr2 = new c[length];
        for (int i10 = 0; i10 < length; i10++) {
            c cVar = cVarArr[i10];
            if (cVar != null) {
                cVarArr2[i10] = cVar.w(qVar);
            }
        }
        return cVarArr2;
    }

    public void a(c0 c0Var) {
        int i10;
        c cVar;
        h hVar;
        k3.o L;
        c cVar2;
        c[] cVarArr = this.f5749c;
        if (cVarArr == null) {
            i10 = 0;
        } else {
            i10 = cVarArr.length;
        }
        int length = this.f5748b.length;
        for (int i11 = 0; i11 < length; i11++) {
            c cVar3 = this.f5748b[i11];
            if (!cVar3.D() && !cVar3.u() && (L = c0Var.L(cVar3)) != null) {
                cVar3.k(L);
                if (i11 < i10 && (cVar2 = this.f5749c[i11]) != null) {
                    cVar2.k(L);
                }
            }
            if (!cVar3.v()) {
                k3.o h10 = h(c0Var, cVar3);
                if (h10 == null) {
                    j q10 = cVar3.q();
                    if (q10 == null) {
                        q10 = cVar3.getType();
                        if (!q10.G()) {
                            if (q10.D() || q10.g() > 0) {
                                cVar3.B(q10);
                            }
                        }
                    }
                    k3.o U = c0Var.U(q10, cVar3);
                    if (!q10.D() || (hVar = (h) q10.k().t()) == null || !(U instanceof a4.h)) {
                        h10 = U;
                    } else {
                        h10 = ((a4.h) U).d(hVar);
                    }
                }
                if (i11 >= i10 || (cVar = this.f5749c[i11]) == null) {
                    cVar3.l(h10);
                } else {
                    cVar.l(h10);
                }
            }
        }
        a4.a aVar = this.f5750d;
        if (aVar != null) {
            aVar.c(c0Var);
        }
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        if (fVar != null) {
            fVar.b(jVar);
        }
    }

    public k3.o b(c0 c0Var, k3.d dVar) {
        r3.i iVar;
        k.c cVar;
        Set set;
        c[] cVarArr;
        Set set2;
        int i10;
        Object obj;
        d dVar2;
        b4.i c10;
        Object obj2;
        c cVar2;
        b0 C;
        c0 c0Var2 = c0Var;
        k3.d dVar3 = dVar;
        b W = c0Var.W();
        if (dVar3 == null || W == null) {
            iVar = null;
        } else {
            iVar = dVar.d();
        }
        a0 Y = c0Var.k();
        k.d findFormatOverrides = findFormatOverrides(c0Var2, dVar3, this._handledType);
        int i11 = 2;
        if (findFormatOverrides == null || !findFormatOverrides.n()) {
            cVar = null;
        } else {
            cVar = findFormatOverrides.i();
            if (!(cVar == k.c.ANY || cVar == this.f5754h)) {
                if (this.f5747a.F()) {
                    int i12 = a.f5755a[cVar.ordinal()];
                    if (i12 == 1 || i12 == 2 || i12 == 3) {
                        return c0Var2.h0(m.e(this.f5747a.q(), c0Var.k(), Y.B(this.f5747a), findFormatOverrides), dVar3);
                    }
                } else if (cVar == k.c.NATURAL && (!this.f5747a.J() || !Map.class.isAssignableFrom(this._handledType))) {
                    Class<Map.Entry> cls = Map.Entry.class;
                    if (cls.isAssignableFrom(this._handledType)) {
                        j i13 = this.f5747a.i(cls);
                        return c0Var2.h0(new b4.h(this.f5747a, i13.h(0), i13.h(1), false, (h) null, dVar), dVar3);
                    }
                }
            }
        }
        b4.i iVar2 = this.f5753g;
        if (iVar != null) {
            set = W.K(Y, iVar).h();
            set2 = W.N(Y, iVar).e();
            b0 B = W.B(iVar);
            if (B == null) {
                if (!(iVar2 == null || (C = W.C(iVar, (b0) null)) == null)) {
                    iVar2 = this.f5753g.b(C.b());
                }
                cVarArr = null;
            } else {
                b0 C2 = W.C(iVar, B);
                Class<n0> c11 = C2.c();
                j jVar = c0Var.l().K(c0Var2.i(c11), k0.class)[0];
                if (c11 == n0.class) {
                    String c12 = C2.d().c();
                    int length = this.f5748b.length;
                    i10 = 0;
                    while (true) {
                        if (i10 == length) {
                            j jVar2 = this.f5747a;
                            Object[] objArr = new Object[i11];
                            objArr[0] = d4.h.X(handledType());
                            objArr[1] = d4.h.U(c12);
                            c0Var2.q(jVar2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                        }
                        cVar2 = this.f5748b[i10];
                        if (c12.equals(cVar2.getName())) {
                            break;
                        }
                        i10++;
                        i11 = 2;
                    }
                    cVarArr = null;
                    iVar2 = b4.i.a(cVar2.getType(), (x) null, new b4.j(C2, cVar2), C2.b());
                    obj = W.p(iVar);
                    if (obj == null || ((obj2 = this.f5751e) != null && obj.equals(obj2))) {
                        obj = cVarArr;
                    }
                } else {
                    cVarArr = null;
                    iVar2 = b4.i.a(jVar, C2.d(), c0Var2.n(iVar, C2), C2.b());
                }
            }
            i10 = 0;
            obj = W.p(iVar);
            obj = cVarArr;
        } else {
            cVarArr = null;
            obj = null;
            set2 = null;
            set = null;
            i10 = 0;
        }
        if (i10 > 0) {
            c[] cVarArr2 = this.f5748b;
            c[] cVarArr3 = (c[]) Arrays.copyOf(cVarArr2, cVarArr2.length);
            c cVar3 = cVarArr3[i10];
            System.arraycopy(cVarArr3, 0, cVarArr3, 1, i10);
            cVarArr3[0] = cVar3;
            c[] cVarArr4 = this.f5749c;
            if (cVarArr4 != null) {
                cVarArr = (c[]) Arrays.copyOf(cVarArr4, cVarArr4.length);
                c cVar4 = cVarArr[i10];
                System.arraycopy(cVarArr, 0, cVarArr, 1, i10);
                cVarArr[0] = cVar4;
            }
            dVar2 = o(cVarArr3, cVarArr);
        } else {
            dVar2 = this;
        }
        if (!(iVar2 == null || (c10 = iVar2.c(c0Var2.U(iVar2.f4342a, dVar3))) == this.f5753g)) {
            dVar2 = dVar2.n(c10);
        }
        if ((set != null && !set.isEmpty()) || set2 != null) {
            dVar2 = dVar2.l(set, set2);
        }
        if (obj != null) {
            dVar2 = dVar2.m(obj);
        }
        if (cVar == null) {
            cVar = this.f5754h;
        }
        if (cVar == k.c.ARRAY) {
            return dVar2.g();
        }
        return dVar2;
    }

    public void c(Object obj, c3.h hVar, c0 c0Var, h hVar2, t tVar) {
        b4.i iVar = this.f5753g;
        i3.b f10 = f(hVar2, obj, n.START_OBJECT);
        hVar2.g(hVar, f10);
        tVar.b(hVar, c0Var, iVar);
        if (this.f5751e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        hVar2.h(hVar, f10);
    }

    public final void d(Object obj, c3.h hVar, c0 c0Var, h hVar2) {
        b4.i iVar = this.f5753g;
        t M = c0Var.M(obj, iVar.f4344c);
        if (!M.c(hVar, c0Var, iVar)) {
            Object a10 = M.a(obj);
            if (iVar.f4346e) {
                iVar.f4345d.serialize(a10, hVar, c0Var);
            } else {
                c(obj, hVar, c0Var, hVar2, M);
            }
        }
    }

    public final void e(Object obj, c3.h hVar, c0 c0Var, boolean z10) {
        b4.i iVar = this.f5753g;
        t M = c0Var.M(obj, iVar.f4344c);
        if (!M.c(hVar, c0Var, iVar)) {
            Object a10 = M.a(obj);
            if (iVar.f4346e) {
                iVar.f4345d.serialize(a10, hVar, c0Var);
                return;
            }
            if (z10) {
                hVar.w0(obj);
            }
            M.b(hVar, c0Var, iVar);
            if (this.f5751e != null) {
                k(obj, hVar, c0Var);
            } else {
                j(obj, hVar, c0Var);
            }
            if (z10) {
                hVar.W();
            }
        }
    }

    public final i3.b f(h hVar, Object obj, n nVar) {
        r3.i iVar = this.f5752f;
        if (iVar == null) {
            return hVar.d(obj, nVar);
        }
        Object n10 = iVar.n(obj);
        if (n10 == null) {
            n10 = "";
        }
        return hVar.e(obj, nVar, n10);
    }

    public abstract d g();

    public m getSchema(c0 c0Var, Type type) {
        String id;
        r createSchemaNode = createSchemaNode("object", true);
        v3.b bVar = (v3.b) this._handledType.getAnnotation(v3.b.class);
        if (!(bVar == null || (id = bVar.id()) == null || id.isEmpty())) {
            createSchemaNode.C("id", id);
        }
        r y10 = createSchemaNode.y();
        Object obj = this.f5751e;
        if (obj != null) {
            findPropertyFilter(c0Var, obj, (Object) null);
        }
        int i10 = 0;
        while (true) {
            c[] cVarArr = this.f5748b;
            if (i10 < cVarArr.length) {
                cVarArr[i10].n(y10, c0Var);
                i10++;
            } else {
                createSchemaNode.G("properties", y10);
                return createSchemaNode;
            }
        }
    }

    public k3.o h(c0 c0Var, c cVar) {
        r3.i d10;
        Object U;
        b W = c0Var.W();
        k3.o oVar = null;
        if (W == null || (d10 = cVar.d()) == null || (U = W.U(d10)) == null) {
            return null;
        }
        d4.j j10 = c0Var.j(cVar.d(), U);
        j a10 = j10.a(c0Var.l());
        if (!a10.I()) {
            oVar = c0Var.U(a10, cVar);
        }
        return new d0(j10, a10, oVar);
    }

    public void j(Object obj, c3.h hVar, c0 c0Var) {
        c[] cVarArr;
        String str = "[anySetter]";
        if (this.f5749c == null || c0Var.V() == null) {
            cVarArr = this.f5748b;
        } else {
            cVarArr = this.f5749c;
        }
        try {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    cVar.y(obj, hVar, c0Var);
                }
            }
            a4.a aVar = this.f5750d;
            if (aVar != null) {
                aVar.b(obj, hVar, c0Var);
            }
        } catch (Exception e10) {
            if (0 != cVarArr.length) {
                str = cVarArr[0].getName();
            }
            wrapAndThrow(c0Var, (Throwable) e10, obj, str);
        } catch (StackOverflowError e11) {
            l lVar = new l((Closeable) hVar, "Infinite recursion (StackOverflowError)", (Throwable) e11);
            if (0 != cVarArr.length) {
                str = cVarArr[0].getName();
            }
            lVar.o(new l.a(obj, str));
            throw lVar;
        }
    }

    public void k(Object obj, c3.h hVar, c0 c0Var) {
        if (this.f5749c != null) {
            Class V = c0Var.V();
        }
        findPropertyFilter(c0Var, this.f5751e, obj);
        j(obj, hVar, c0Var);
    }

    public abstract d l(Set set, Set set2);

    public abstract d m(Object obj);

    public abstract d n(b4.i iVar);

    public abstract d o(c[] cVarArr, c[] cVarArr2);

    public Iterator properties() {
        return Arrays.asList(this.f5748b).iterator();
    }

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, h hVar2) {
        if (this.f5753g != null) {
            hVar.z(obj);
            d(obj, hVar, c0Var, hVar2);
            return;
        }
        hVar.z(obj);
        i3.b f10 = f(hVar2, obj, n.START_OBJECT);
        hVar2.g(hVar, f10);
        if (this.f5751e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        hVar2.h(hVar, f10);
    }

    public boolean usesObjectId() {
        if (this.f5753g != null) {
            return true;
        }
        return false;
    }

    public d(d dVar, c[] cVarArr, c[] cVarArr2) {
        super((Class) dVar._handledType);
        this.f5747a = dVar.f5747a;
        this.f5748b = cVarArr;
        this.f5749c = cVarArr2;
        this.f5752f = dVar.f5752f;
        this.f5750d = dVar.f5750d;
        this.f5753g = dVar.f5753g;
        this.f5751e = dVar.f5751e;
        this.f5754h = dVar.f5754h;
    }

    public d(d dVar, b4.i iVar) {
        this(dVar, iVar, dVar.f5751e);
    }

    public d(d dVar, b4.i iVar, Object obj) {
        super((Class) dVar._handledType);
        this.f5747a = dVar.f5747a;
        this.f5748b = dVar.f5748b;
        this.f5749c = dVar.f5749c;
        this.f5752f = dVar.f5752f;
        this.f5750d = dVar.f5750d;
        this.f5753g = iVar;
        this.f5751e = obj;
        this.f5754h = dVar.f5754h;
    }

    /* JADX WARNING: type inference failed for: r11v11, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(com.fasterxml.jackson.databind.ser.std.d r10, java.util.Set r11, java.util.Set r12) {
        /*
            r9 = this;
            java.lang.Class<java.lang.Object> r0 = r10._handledType
            r9.<init>((java.lang.Class) r0)
            k3.j r0 = r10.f5747a
            r9.f5747a = r0
            a4.c[] r0 = r10.f5748b
            a4.c[] r1 = r10.f5749c
            int r2 = r0.length
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r4 = 0
            if (r1 != 0) goto L_0x0018
            r5 = r4
            goto L_0x001d
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
        L_0x001d:
            r6 = 0
        L_0x001e:
            if (r6 >= r2) goto L_0x003a
            r7 = r0[r6]
            java.lang.String r8 = r7.getName()
            boolean r8 = d4.m.c(r8, r11, r12)
            if (r8 == 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r3.add(r7)
            if (r1 == 0) goto L_0x0037
            r7 = r1[r6]
            r5.add(r7)
        L_0x0037:
            int r6 = r6 + 1
            goto L_0x001e
        L_0x003a:
            int r11 = r3.size()
            a4.c[] r11 = new a4.c[r11]
            java.lang.Object[] r11 = r3.toArray(r11)
            a4.c[] r11 = (a4.c[]) r11
            r9.f5748b = r11
            if (r5 != 0) goto L_0x004b
            goto L_0x0058
        L_0x004b:
            int r11 = r5.size()
            a4.c[] r11 = new a4.c[r11]
            java.lang.Object[] r11 = r5.toArray(r11)
            r4 = r11
            a4.c[] r4 = (a4.c[]) r4
        L_0x0058:
            r9.f5749c = r4
            r3.i r11 = r10.f5752f
            r9.f5752f = r11
            a4.a r11 = r10.f5750d
            r9.f5750d = r11
            b4.i r11 = r10.f5753g
            r9.f5753g = r11
            java.lang.Object r11 = r10.f5751e
            r9.f5751e = r11
            b3.k$c r10 = r10.f5754h
            r9.f5754h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.d.<init>(com.fasterxml.jackson.databind.ser.std.d, java.util.Set, java.util.Set):void");
    }

    public d(d dVar, q qVar) {
        this(dVar, i(dVar.f5748b, qVar), i(dVar.f5749c, qVar));
    }
}
