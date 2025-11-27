package com.fasterxml.jackson.databind.ser.std;

import java.util.Iterator;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import w3.h;

public class r extends b {
    public r(j jVar, boolean z10, h hVar) {
        super(Iterable.class, jVar, z10, hVar, (o) null);
    }

    public a4.h c(h hVar) {
        return new r(this, this.f5731b, hVar, this.f5735f, this.f5733d);
    }

    public boolean i(Iterable iterable) {
        if (iterable == null) {
            return false;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        if (!it.hasNext()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public boolean isEmpty(c0 c0Var, Iterable iterable) {
        return !iterable.iterator().hasNext();
    }

    /* renamed from: k */
    public final void serialize(Iterable iterable, c3.h hVar, c0 c0Var) {
        if (((this.f5733d != null || !c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5733d != Boolean.TRUE) || !i(iterable)) {
            hVar.t0(iterable);
            g(iterable, hVar, c0Var);
            hVar.V();
            return;
        }
        g(iterable, hVar, c0Var);
    }

    /* renamed from: l */
    public void g(Iterable iterable, c3.h hVar, c0 c0Var) {
        o oVar;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            h hVar2 = this.f5734e;
            Class<?> cls = null;
            o oVar2 = null;
            do {
                Object next = it.next();
                if (next == null) {
                    c0Var.E(hVar);
                } else {
                    o oVar3 = this.f5735f;
                    if (oVar3 == null) {
                        Class<?> cls2 = next.getClass();
                        if (cls2 != cls) {
                            oVar2 = c0Var.S(cls2, this.f5731b);
                            cls = cls2;
                        }
                        oVar = oVar2;
                    } else {
                        o oVar4 = oVar3;
                        oVar = oVar2;
                        oVar2 = oVar4;
                    }
                    if (hVar2 == null) {
                        oVar2.serialize(next, hVar, c0Var);
                    } else {
                        oVar2.serializeWithType(next, hVar, c0Var, hVar2);
                    }
                    oVar2 = oVar;
                }
            } while (it.hasNext());
        }
    }

    /* renamed from: m */
    public r h(d dVar, h hVar, o oVar, Boolean bool) {
        return new r(this, dVar, hVar, oVar, bool);
    }

    public r(r rVar, d dVar, h hVar, o oVar, Boolean bool) {
        super((b) rVar, dVar, hVar, oVar, bool);
    }
}
