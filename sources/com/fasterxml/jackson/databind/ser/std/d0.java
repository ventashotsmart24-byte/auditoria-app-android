package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import a4.o;
import d4.h;
import d4.j;
import java.lang.reflect.Type;
import k3.c0;
import k3.d;
import k3.m;
import u3.f;
import v3.c;

public class d0 extends i0 implements i, o {

    /* renamed from: a  reason: collision with root package name */
    public final j f5756a;

    /* renamed from: b  reason: collision with root package name */
    public final k3.j f5757b;

    /* renamed from: c  reason: collision with root package name */
    public final k3.o f5758c;

    public d0(j jVar, k3.j jVar2, k3.o oVar) {
        super(jVar2);
        this.f5756a = jVar;
        this.f5757b = jVar2;
        this.f5758c = oVar;
    }

    public void a(c0 c0Var) {
        k3.o oVar = this.f5758c;
        if (oVar != null && (oVar instanceof o)) {
            ((o) oVar).a(c0Var);
        }
    }

    public void acceptJsonFormatVisitor(f fVar, k3.j jVar) {
        k3.o oVar = this.f5758c;
        if (oVar != null) {
            oVar.acceptJsonFormatVisitor(fVar, jVar);
        }
    }

    public k3.o b(c0 c0Var, d dVar) {
        k3.o oVar = this.f5758c;
        k3.j jVar = this.f5757b;
        if (oVar == null) {
            if (jVar == null) {
                jVar = this.f5756a.a(c0Var.l());
            }
            if (!jVar.I()) {
                oVar = c0Var.T(jVar);
            }
        }
        if (oVar instanceof i) {
            oVar = c0Var.i0(oVar, dVar);
        }
        if (oVar == this.f5758c && jVar == this.f5757b) {
            return this;
        }
        return e(this.f5756a, jVar, oVar);
    }

    public k3.o c(Object obj, c0 c0Var) {
        return c0Var.R(obj.getClass());
    }

    public Object d(Object obj) {
        return this.f5756a.convert(obj);
    }

    public d0 e(j jVar, k3.j jVar2, k3.o oVar) {
        h.n0(d0.class, this, "withDelegate");
        return new d0(jVar, jVar2, oVar);
    }

    public k3.o getDelegatee() {
        return this.f5758c;
    }

    public m getSchema(c0 c0Var, Type type) {
        k3.o oVar = this.f5758c;
        if (oVar instanceof c) {
            return ((c) oVar).getSchema(c0Var, type);
        }
        return super.getSchema(c0Var, type);
    }

    public boolean isEmpty(c0 c0Var, Object obj) {
        Object d10 = d(obj);
        if (d10 == null) {
            return true;
        }
        k3.o oVar = this.f5758c;
        if (oVar != null) {
            return oVar.isEmpty(c0Var, d10);
        }
        if (obj == null) {
            return true;
        }
        return false;
    }

    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        Object d10 = d(obj);
        if (d10 == null) {
            c0Var.E(hVar);
            return;
        }
        k3.o oVar = this.f5758c;
        if (oVar == null) {
            oVar = c(d10, c0Var);
        }
        oVar.serialize(d10, hVar, c0Var);
    }

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        Object d10 = d(obj);
        k3.o oVar = this.f5758c;
        if (oVar == null) {
            oVar = c(obj, c0Var);
        }
        oVar.serializeWithType(d10, hVar, c0Var, hVar2);
    }

    public m getSchema(c0 c0Var, Type type, boolean z10) {
        k3.o oVar = this.f5758c;
        if (oVar instanceof c) {
            return ((c) oVar).getSchema(c0Var, type, z10);
        }
        return super.getSchema(c0Var, type);
    }
}
