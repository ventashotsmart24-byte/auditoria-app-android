package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import c4.f;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.g;

public class b extends e0 {
    public b() {
        super(AtomicBoolean.class);
    }

    /* renamed from: a */
    public AtomicBoolean deserialize(k kVar, g gVar) {
        n n10 = kVar.n();
        if (n10 == n.VALUE_TRUE) {
            return new AtomicBoolean(true);
        }
        if (n10 == n.VALUE_FALSE) {
            return new AtomicBoolean(false);
        }
        Boolean _parseBoolean = _parseBoolean(kVar, gVar, AtomicBoolean.class);
        if (_parseBoolean == null) {
            return null;
        }
        return new AtomicBoolean(_parseBoolean.booleanValue());
    }

    public Object getEmptyValue(g gVar) {
        return new AtomicBoolean(false);
    }

    public f logicalType() {
        return f.Boolean;
    }
}
