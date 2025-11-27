package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import java.lang.reflect.Type;
import java.util.Collection;
import k3.c0;
import k3.d;
import k3.j;
import k3.m;
import k3.o;
import u3.f;

public abstract class b0 extends i0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f5737a;

    public b0(Class cls) {
        super(cls, false);
        this.f5737a = null;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.g(jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.o b(k3.c0 r6, k3.d r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0018
            k3.b r1 = r6.W()
            r3.i r2 = r7.d()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r1 = r1.g(r2)
            if (r1 == 0) goto L_0x0018
            k3.o r1 = r6.t0(r2, r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.Class r2 = r5.handledType()
            b3.k$d r2 = r5.findFormatOverrides(r6, r7, r2)
            if (r2 == 0) goto L_0x002a
            b3.k$a r3 = b3.k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r2.e(r3)
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            k3.o r1 = r5.findContextualConvertingSerializer(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L_0x0037
            k3.o r1 = r6.G(r3, r7)
        L_0x0037:
            boolean r4 = r5.isDefaultSerializer(r1)
            if (r4 == 0) goto L_0x004b
            java.lang.Boolean r6 = r5.f5737a
            boolean r6 = java.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L_0x0046
            return r5
        L_0x0046:
            k3.o r6 = r5.c(r7, r2)
            return r6
        L_0x004b:
            com.fasterxml.jackson.databind.ser.std.j r7 = new com.fasterxml.jackson.databind.ser.std.j
            k3.j r6 = r6.i(r3)
            r2 = 1
            r7.<init>(r6, r2, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.b0.b(k3.c0, k3.d):k3.o");
    }

    public abstract o c(d dVar, Boolean bool);

    public abstract m d();

    /* renamed from: e */
    public boolean isEmpty(c0 c0Var, Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("array", true).G("items", d());
    }

    public b0(b0 b0Var, Boolean bool) {
        super((i0) b0Var);
        this.f5737a = bool;
    }
}
