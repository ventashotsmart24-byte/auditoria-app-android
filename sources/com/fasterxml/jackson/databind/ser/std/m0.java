package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import c3.n;
import i3.b;
import java.lang.reflect.Type;
import k3.c0;
import k3.j;
import k3.m;
import u3.f;

public abstract class m0 extends i0 {
    public m0(Class cls) {
        super(cls, false);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        visitStringFormat(fVar, jVar);
    }

    public abstract String c(Object obj);

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("string", true);
    }

    public boolean isEmpty(c0 c0Var, Object obj) {
        return c(obj).isEmpty();
    }

    public void serialize(Object obj, h hVar, c0 c0Var) {
        hVar.z0(c(obj));
    }

    public void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(obj, n.VALUE_STRING));
        serialize(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
