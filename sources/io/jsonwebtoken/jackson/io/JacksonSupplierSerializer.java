package io.jsonwebtoken.jackson.io;

import c3.h;
import com.fasterxml.jackson.databind.ser.std.i0;
import io.jsonwebtoken.lang.Supplier;
import k3.c0;
import k3.d;

final class JacksonSupplierSerializer extends i0 {
    static final JacksonSupplierSerializer INSTANCE = new JacksonSupplierSerializer();

    public JacksonSupplierSerializer() {
        super(Supplier.class, false);
    }

    public void serialize(Supplier<?> supplier, h hVar, c0 c0Var) {
        Object obj = supplier.get();
        if (obj == null) {
            c0Var.E(hVar);
        } else {
            c0Var.P(obj.getClass(), true, (d) null).serialize(obj, hVar, c0Var);
        }
    }
}
