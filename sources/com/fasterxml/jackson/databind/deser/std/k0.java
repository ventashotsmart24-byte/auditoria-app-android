package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c4.f;
import d4.y;
import k3.g;

public class k0 extends e0 {
    public k0() {
        super(y.class);
    }

    public y a(k kVar) {
        return new y(kVar);
    }

    /* renamed from: b */
    public y deserialize(k kVar, g gVar) {
        return a(kVar).W0(kVar, gVar);
    }

    public f logicalType() {
        return f.Untyped;
    }
}
