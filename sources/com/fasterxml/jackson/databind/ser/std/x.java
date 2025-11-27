package com.fasterxml.jackson.databind.ser.std;

import b4.k;
import java.util.Objects;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import u3.f;
import w3.h;

public class x extends a {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5816c;

    /* renamed from: d  reason: collision with root package name */
    public final j f5817d;

    /* renamed from: e  reason: collision with root package name */
    public final h f5818e;

    /* renamed from: f  reason: collision with root package name */
    public o f5819f;

    /* renamed from: g  reason: collision with root package name */
    public k f5820g = k.c();

    public x(j jVar, boolean z10, h hVar, o oVar) {
        super(Object[].class);
        this.f5817d = jVar;
        this.f5816c = z10;
        this.f5818e = hVar;
        this.f5819f = oVar;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.g(jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r6, k3.d r7) {
        /*
            r5 = this;
            w3.h r0 = r5.f5818e
            if (r0 == 0) goto L_0x0008
            w3.h r0 = r0.a(r7)
        L_0x0008:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            r3.i r2 = r7.d()
            k3.b r3 = r6.W()
            if (r2 == 0) goto L_0x0020
            java.lang.Object r3 = r3.g(r2)
            if (r3 == 0) goto L_0x0020
            k3.o r2 = r6.t0(r2, r3)
            goto L_0x0021
        L_0x0020:
            r2 = r1
        L_0x0021:
            java.lang.Class r3 = r5.handledType()
            b3.k$d r3 = r5.findFormatOverrides(r6, r7, r3)
            if (r3 == 0) goto L_0x0031
            b3.k$a r1 = b3.k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r1 = r3.e(r1)
        L_0x0031:
            if (r2 != 0) goto L_0x0035
            k3.o r2 = r5.f5819f
        L_0x0035:
            k3.o r2 = r5.findContextualConvertingSerializer(r6, r7, r2)
            if (r2 != 0) goto L_0x004f
            k3.j r3 = r5.f5817d
            if (r3 == 0) goto L_0x004f
            boolean r4 = r5.f5816c
            if (r4 == 0) goto L_0x004f
            boolean r3 = r3.I()
            if (r3 != 0) goto L_0x004f
            k3.j r2 = r5.f5817d
            k3.o r2 = r6.H(r2, r7)
        L_0x004f:
            com.fasterxml.jackson.databind.ser.std.x r6 = r5.o(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.x.b(k3.c0, k3.d):k3.o");
    }

    public a4.h c(h hVar) {
        return new x(this.f5817d, this.f5816c, hVar, this.f5819f);
    }

    public o f(d dVar, Boolean bool) {
        return new x(this, dVar, this.f5818e, this.f5819f, bool);
    }

    public final o h(k kVar, Class cls, c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f5727a);
        k kVar2 = g10.f4357b;
        if (kVar != kVar2) {
            this.f5820g = kVar2;
        }
        return g10.f4356a;
    }

    public final o i(k kVar, j jVar, c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f5727a);
        k kVar2 = h10.f4357b;
        if (kVar != kVar2) {
            this.f5820g = kVar2;
        }
        return h10.f4356a;
    }

    /* renamed from: j */
    public boolean isEmpty(c0 c0Var, Object[] objArr) {
        if (objArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    public final void serialize(Object[] objArr, c3.h hVar, c0 c0Var) {
        int length = objArr.length;
        if (length != 1 || ((this.f5728b != null || !c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5728b != Boolean.TRUE)) {
            hVar.u0(objArr, length);
            g(objArr, hVar, c0Var);
            hVar.V();
            return;
        }
        g(objArr, hVar, c0Var);
    }

    /* renamed from: l */
    public void g(Object[] objArr, c3.h hVar, c0 c0Var) {
        if (r0 != 0) {
            o oVar = this.f5819f;
            if (oVar != null) {
                m(objArr, hVar, c0Var, oVar);
            } else if (this.f5818e != null) {
                n(objArr, hVar, c0Var);
            } else {
                try {
                    k kVar = this.f5820g;
                    for (Object obj : objArr) {
                        if (obj == null) {
                            c0Var.E(hVar);
                        } else {
                            Class<?> cls = obj.getClass();
                            o j10 = kVar.j(cls);
                            if (j10 == null) {
                                if (this.f5817d.w()) {
                                    j10 = i(kVar, c0Var.A(this.f5817d, cls), c0Var);
                                } else {
                                    j10 = h(kVar, cls, c0Var);
                                }
                            }
                            j10.serialize(obj, hVar, c0Var);
                        }
                    }
                } catch (Exception e10) {
                    wrapAndThrow(c0Var, (Throwable) e10, (Object) null, 0);
                }
            }
        }
    }

    public void m(Object[] objArr, c3.h hVar, c0 c0Var, o oVar) {
        int length = objArr.length;
        h hVar2 = this.f5818e;
        int i10 = 0;
        Object obj = null;
        while (i10 < length) {
            try {
                obj = objArr[i10];
                if (obj == null) {
                    c0Var.E(hVar);
                } else if (hVar2 == null) {
                    oVar.serialize(obj, hVar, c0Var);
                } else {
                    oVar.serializeWithType(obj, hVar, c0Var, hVar2);
                }
                i10++;
            } catch (Exception e10) {
                wrapAndThrow(c0Var, (Throwable) e10, obj, i10);
                return;
            }
        }
    }

    public void n(Object[] objArr, c3.h hVar, c0 c0Var) {
        h hVar2 = this.f5818e;
        try {
            k kVar = this.f5820g;
            for (Object obj : objArr) {
                if (obj == null) {
                    c0Var.E(hVar);
                } else {
                    Class<?> cls = obj.getClass();
                    o j10 = kVar.j(cls);
                    if (j10 == null) {
                        j10 = h(kVar, cls, c0Var);
                    }
                    j10.serializeWithType(obj, hVar, c0Var, hVar2);
                }
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, (Throwable) e10, (Object) null, 0);
        }
    }

    public x o(d dVar, h hVar, o oVar, Boolean bool) {
        if (this.f5727a == dVar && oVar == this.f5819f && this.f5818e == hVar && Objects.equals(this.f5728b, bool)) {
            return this;
        }
        return new x(this, dVar, hVar, oVar, bool);
    }

    public x(x xVar, d dVar, h hVar, o oVar, Boolean bool) {
        super(xVar, dVar, bool);
        this.f5817d = xVar.f5817d;
        this.f5818e = hVar;
        this.f5816c = xVar.f5816c;
        this.f5819f = oVar;
    }
}
