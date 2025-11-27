package com.fasterxml.jackson.databind.ser.std;

import c4.j;
import d4.q;
import java.util.concurrent.atomic.AtomicReference;
import k3.d;
import k3.o;
import w3.h;

public class c extends z {
    public c(j jVar, boolean z10, h hVar, o oVar) {
        super(jVar, z10, hVar, oVar);
    }

    public z i(Object obj, boolean z10) {
        return new c(this, this.f5823b, this.f5824c, this.f5825d, this.f5826e, obj, z10);
    }

    public z j(d dVar, h hVar, o oVar, q qVar) {
        return new c(this, dVar, hVar, oVar, qVar, this.f5828g, this.f5829h);
    }

    /* renamed from: k */
    public Object e(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    /* renamed from: l */
    public Object f(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    /* renamed from: m */
    public boolean g(AtomicReference atomicReference) {
        if (atomicReference.get() != null) {
            return true;
        }
        return false;
    }

    public c(c cVar, d dVar, h hVar, o oVar, q qVar, Object obj, boolean z10) {
        super(cVar, dVar, hVar, oVar, qVar, obj, z10);
    }
}
