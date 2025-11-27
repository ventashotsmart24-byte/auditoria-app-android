package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c4.f;
import d4.a;
import k3.g;
import w3.e;

public abstract class e0 extends b0 {
    public e0(Class cls) {
        super(cls);
    }

    public Object deserialize(k kVar, g gVar, Object obj) {
        gVar.U(this);
        return deserialize(kVar, gVar);
    }

    public Object deserializeWithType(k kVar, g gVar, e eVar) {
        return eVar.f(kVar, gVar);
    }

    public a getEmptyAccessPattern() {
        return a.CONSTANT;
    }

    public a getNullAccessPattern() {
        return a.ALWAYS_NULL;
    }

    public f logicalType() {
        return f.OtherScalar;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.FALSE;
    }

    public e0(e0 e0Var) {
        super((b0) e0Var);
    }
}
