package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import k3.c0;
import k3.j;
import k3.n;
import u3.f;

public class a0 extends i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f5729a = new a0();

    public a0() {
        super(n.class);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.c(jVar);
    }

    /* renamed from: c */
    public boolean isEmpty(c0 c0Var, n nVar) {
        if (nVar instanceof n.a) {
            return ((n.a) nVar).f(c0Var);
        }
        return false;
    }

    /* renamed from: d */
    public void serialize(n nVar, h hVar, c0 c0Var) {
        nVar.d(hVar, c0Var);
    }

    /* renamed from: e */
    public final void serializeWithType(n nVar, h hVar, c0 c0Var, w3.h hVar2) {
        nVar.e(hVar, c0Var, hVar2);
    }
}
