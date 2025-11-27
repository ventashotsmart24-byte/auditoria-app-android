package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c4.f;
import java.util.concurrent.atomic.AtomicLong;
import k3.g;

public class d extends e0 {
    public d() {
        super(AtomicLong.class);
    }

    /* renamed from: a */
    public AtomicLong deserialize(k kVar, g gVar) {
        if (kVar.m0()) {
            return new AtomicLong(kVar.Q());
        }
        Long _parseLong = _parseLong(kVar, gVar, AtomicLong.class);
        if (_parseLong == null) {
            return null;
        }
        return new AtomicLong((long) _parseLong.intValue());
    }

    public Object getEmptyValue(g gVar) {
        return new AtomicLong();
    }

    public f logicalType() {
        return f.Integer;
    }
}
