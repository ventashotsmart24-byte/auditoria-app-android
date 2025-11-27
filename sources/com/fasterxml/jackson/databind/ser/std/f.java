package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import c3.n;
import i3.b;
import java.lang.reflect.Type;
import k3.c0;
import k3.j;
import k3.m;

public class f extends i0 {
    public f() {
        super(byte[].class);
    }

    public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
        fVar.g(jVar);
    }

    /* renamed from: c */
    public boolean isEmpty(c0 c0Var, byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public void serialize(byte[] bArr, h hVar, c0 c0Var) {
        hVar.R(c0Var.k().h(), bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public void serializeWithType(byte[] bArr, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(bArr, n.VALUE_EMBEDDED_OBJECT));
        hVar.R(c0Var.k().h(), bArr, 0, bArr.length);
        hVar2.h(hVar, g10);
    }

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("array", true).G("items", createSchemaNode("byte"));
    }
}
