package com.fasterxml.jackson.databind.ser.std;

import a4.h;
import a4.i;
import b4.k;
import c3.n;
import java.lang.reflect.Type;
import k3.c0;
import k3.d;
import k3.j;
import k3.m;
import k3.o;
import u3.f;
import v3.a;
import v3.c;
import z3.r;

public abstract class b extends h implements i {

    /* renamed from: a  reason: collision with root package name */
    public final j f5730a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5731b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5732c;

    /* renamed from: d  reason: collision with root package name */
    public final Boolean f5733d;

    /* renamed from: e  reason: collision with root package name */
    public final w3.h f5734e;

    /* renamed from: f  reason: collision with root package name */
    public final o f5735f;

    /* renamed from: g  reason: collision with root package name */
    public k f5736g;

    public b(Class cls, j jVar, boolean z10, w3.h hVar, o oVar) {
        this(cls, jVar, z10, hVar, (d) null, oVar, (Boolean) null);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        o oVar = this.f5735f;
        if (oVar == null && this.f5730a != null) {
            oVar = fVar.getProvider().H(this.f5730a, this.f5731b);
        }
        visitArrayFormat(fVar, jVar, oVar, this.f5730a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r6, k3.d r7) {
        /*
            r5 = this;
            w3.h r0 = r5.f5734e
            if (r0 == 0) goto L_0x0008
            w3.h r0 = r0.a(r7)
        L_0x0008:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            k3.b r2 = r6.W()
            r3.i r3 = r7.d()
            if (r3 == 0) goto L_0x0020
            java.lang.Object r2 = r2.g(r3)
            if (r2 == 0) goto L_0x0020
            k3.o r2 = r6.t0(r3, r2)
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
            k3.o r2 = r5.f5735f
        L_0x0035:
            k3.o r2 = r5.findContextualConvertingSerializer(r6, r7, r2)
            if (r2 != 0) goto L_0x004f
            k3.j r3 = r5.f5730a
            if (r3 == 0) goto L_0x004f
            boolean r4 = r5.f5732c
            if (r4 == 0) goto L_0x004f
            boolean r3 = r3.I()
            if (r3 != 0) goto L_0x004f
            k3.j r2 = r5.f5730a
            k3.o r2 = r6.H(r2, r7)
        L_0x004f:
            k3.o r6 = r5.f5735f
            if (r2 != r6) goto L_0x0065
            k3.d r6 = r5.f5731b
            if (r7 != r6) goto L_0x0065
            w3.h r6 = r5.f5734e
            if (r6 != r0) goto L_0x0065
            java.lang.Boolean r6 = r5.f5733d
            boolean r6 = java.util.Objects.equals(r6, r1)
            if (r6 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            return r5
        L_0x0065:
            com.fasterxml.jackson.databind.ser.std.b r6 = r5.h(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.b.b(k3.c0, k3.d):k3.o");
    }

    public final o e(k kVar, Class cls, c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f5731b);
        k kVar2 = g10.f4357b;
        if (kVar != kVar2) {
            this.f5736g = kVar2;
        }
        return g10.f4356a;
    }

    public final o f(k kVar, j jVar, c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f5731b);
        k kVar2 = h10.f4357b;
        if (kVar != kVar2) {
            this.f5736g = kVar2;
        }
        return h10.f4356a;
    }

    public abstract void g(Object obj, c3.h hVar, c0 c0Var);

    public m getSchema(c0 c0Var, Type type) {
        r createSchemaNode = createSchemaNode("array", true);
        o oVar = this.f5735f;
        if (oVar != null) {
            m mVar = null;
            if (oVar instanceof c) {
                mVar = ((c) oVar).getSchema(c0Var, (Type) null);
            }
            if (mVar == null) {
                mVar = a.a();
            }
            createSchemaNode.G("items", mVar);
        }
        return createSchemaNode;
    }

    public abstract b h(d dVar, w3.h hVar, o oVar, Boolean bool);

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(obj, n.START_ARRAY));
        hVar.z(obj);
        g(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Class cls, j jVar, boolean z10, w3.h hVar, d dVar, o oVar, Boolean bool) {
        super(cls, false);
        boolean z11 = false;
        this.f5730a = jVar;
        if (z10 || (jVar != null && jVar.G())) {
            z11 = true;
        }
        this.f5732c = z11;
        this.f5734e = hVar;
        this.f5731b = dVar;
        this.f5735f = oVar;
        this.f5736g = k.c();
        this.f5733d = bool;
    }

    public b(b bVar, d dVar, w3.h hVar, o oVar, Boolean bool) {
        super((h) bVar);
        this.f5730a = bVar.f5730a;
        this.f5732c = bVar.f5732c;
        this.f5734e = hVar;
        this.f5731b = dVar;
        this.f5735f = oVar;
        this.f5736g = k.c();
        this.f5733d = bool;
    }
}
