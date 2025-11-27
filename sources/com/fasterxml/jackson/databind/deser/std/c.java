package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c4.f;
import java.util.concurrent.atomic.AtomicInteger;
import k3.g;

public class c extends e0 {
    public c() {
        super(AtomicInteger.class);
    }

    /* renamed from: a */
    public AtomicInteger deserialize(k kVar, g gVar) {
        if (kVar.m0()) {
            return new AtomicInteger(kVar.P());
        }
        Integer _parseInteger = _parseInteger(kVar, gVar, AtomicInteger.class);
        if (_parseInteger == null) {
            return null;
        }
        return new AtomicInteger(_parseInteger.intValue());
    }

    public Object getEmptyValue(g gVar) {
        return new AtomicInteger();
    }

    public f logicalType() {
        return f.Integer;
    }
}
