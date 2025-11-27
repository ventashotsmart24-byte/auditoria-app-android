package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.k;
import c3.h;
import c3.k;
import c3.q;
import d4.l;
import java.lang.reflect.Type;
import java.util.Objects;
import k3.a0;
import k3.b0;
import k3.c;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import u3.f;
import z3.a;
import z3.r;

public class m extends h0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final l f5772a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f5773b;

    public m(l lVar, Boolean bool) {
        super(lVar.c(), false);
        this.f5772a = lVar;
        this.f5773b = bool;
    }

    public static Boolean c(Class cls, k.d dVar, boolean z10, Boolean bool) {
        k.c cVar;
        String str;
        if (dVar == null) {
            cVar = null;
        } else {
            cVar = dVar.i();
        }
        if (cVar == null || cVar == k.c.ANY || cVar == k.c.SCALAR) {
            return bool;
        }
        if (cVar == k.c.STRING || cVar == k.c.NATURAL) {
            return Boolean.FALSE;
        }
        if (cVar.a() || cVar == k.c.ARRAY) {
            return Boolean.TRUE;
        }
        Object[] objArr = new Object[3];
        objArr[0] = cVar;
        objArr[1] = cls.getName();
        if (z10) {
            str = Name.LABEL;
        } else {
            str = "property";
        }
        objArr[2] = str;
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", objArr));
    }

    public static m e(Class cls, a0 a0Var, c cVar, k.d dVar) {
        return new m(l.b(a0Var, cls), c(cls, dVar, true, (Boolean) null));
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        if (d(fVar.getProvider())) {
            visitIntFormat(fVar, jVar, k.b.INT);
        } else {
            fVar.a(jVar);
        }
    }

    public o b(c0 c0Var, d dVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides != null) {
            Boolean c10 = c(handledType(), findFormatOverrides, false, this.f5773b);
            if (!Objects.equals(c10, this.f5773b)) {
                return new m(this.f5772a, c10);
            }
        }
        return this;
    }

    public final boolean d(c0 c0Var) {
        Boolean bool = this.f5773b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return c0Var.m0(b0.WRITE_ENUMS_USING_INDEX);
    }

    /* renamed from: f */
    public final void serialize(Enum enumR, h hVar, c0 c0Var) {
        if (d(c0Var)) {
            hVar.d0(enumR.ordinal());
        } else if (c0Var.m0(b0.WRITE_ENUMS_USING_TO_STRING)) {
            hVar.z0(enumR.toString());
        } else {
            hVar.y0(this.f5772a.d(enumR));
        }
    }

    public k3.m getSchema(c0 c0Var, Type type) {
        if (d(c0Var)) {
            return createSchemaNode("integer", true);
        }
        r createSchemaNode = createSchemaNode("string", true);
        if (type != null && c0Var.i(type).F()) {
            a E = createSchemaNode.E("enum");
            for (q value : this.f5772a.e()) {
                E.B(value.getValue());
            }
        }
        return createSchemaNode;
    }
}
