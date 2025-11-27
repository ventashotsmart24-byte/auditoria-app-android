package com.fasterxml.jackson.databind.ser.std;

import java.util.EnumSet;
import java.util.Iterator;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import w3.h;

public class n extends b {
    public n(j jVar) {
        super(EnumSet.class, jVar, true, (h) null, (o) null);
    }

    /* renamed from: i */
    public n c(h hVar) {
        return this;
    }

    /* renamed from: j */
    public boolean isEmpty(c0 c0Var, EnumSet enumSet) {
        return enumSet.isEmpty();
    }

    /* renamed from: k */
    public final void serialize(EnumSet enumSet, c3.h hVar, c0 c0Var) {
        int size = enumSet.size();
        if (size != 1 || ((this.f5733d != null || !c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5733d != Boolean.TRUE)) {
            hVar.u0(enumSet, size);
            g(enumSet, hVar, c0Var);
            hVar.V();
            return;
        }
        g(enumSet, hVar, c0Var);
    }

    /* renamed from: l */
    public void g(EnumSet enumSet, c3.h hVar, c0 c0Var) {
        o oVar = this.f5735f;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (oVar == null) {
                oVar = c0Var.G(enumR.getDeclaringClass(), this.f5731b);
            }
            oVar.serialize(enumR, hVar, c0Var);
        }
    }

    /* renamed from: m */
    public n h(d dVar, h hVar, o oVar, Boolean bool) {
        return new n(this, dVar, hVar, oVar, bool);
    }

    public n(n nVar, d dVar, h hVar, o oVar, Boolean bool) {
        super((b) nVar, dVar, hVar, oVar, bool);
    }
}
