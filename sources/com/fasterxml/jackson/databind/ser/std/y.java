package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import c3.n;
import i3.b;
import java.lang.reflect.Type;
import k3.c0;
import k3.j;
import k3.m;
import u3.f;

public class y extends i0 {
    public y(Class cls) {
        super(cls, false);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        visitStringFormat(fVar, jVar);
    }

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("string", true);
    }

    public void serialize(Object obj, h hVar, c0 c0Var) {
        hVar.r0(obj.toString());
    }

    public void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(obj, n.VALUE_EMBEDDED_OBJECT));
        serialize(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
