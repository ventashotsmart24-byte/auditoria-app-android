package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.k;
import c3.h;
import c3.k;
import java.lang.reflect.Type;
import k3.c0;
import k3.d;
import k3.j;
import k3.m;
import k3.o;
import u3.f;

public final class e extends h0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5759a;

    public static final class a extends h0 implements i {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f5760a;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(boolean r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L_0x0005
                java.lang.Class r0 = java.lang.Boolean.TYPE
                goto L_0x0007
            L_0x0005:
                java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            L_0x0007:
                r1 = 0
                r2.<init>(r0, r1)
                r2.f5760a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.e.a.<init>(boolean):void");
        }

        public void acceptJsonFormatVisitor(f fVar, j jVar) {
            visitIntFormat(fVar, jVar, k.b.INT);
        }

        public o b(c0 c0Var, d dVar) {
            k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, Boolean.class);
            if (findFormatOverrides == null || findFormatOverrides.i().a()) {
                return this;
            }
            return new e(this.f5760a);
        }

        public void serialize(Object obj, h hVar, c0 c0Var) {
            hVar.d0(Boolean.FALSE.equals(obj) ^ true ? 1 : 0);
        }

        public final void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
            hVar.U(Boolean.TRUE.equals(obj));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0005
            java.lang.Class r0 = java.lang.Boolean.TYPE
            goto L_0x0007
        L_0x0005:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
        L_0x0007:
            r1 = 0
            r2.<init>(r0, r1)
            r2.f5759a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.e.<init>(boolean):void");
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.d(jVar);
    }

    public o b(c0 c0Var, d dVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, Boolean.class);
        if (findFormatOverrides == null || !findFormatOverrides.i().a()) {
            return this;
        }
        return new a(this.f5759a);
    }

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("boolean", !this.f5759a);
    }

    public void serialize(Object obj, h hVar, c0 c0Var) {
        hVar.U(Boolean.TRUE.equals(obj));
    }

    public final void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        hVar.U(Boolean.TRUE.equals(obj));
    }
}
