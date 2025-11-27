package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import java.lang.reflect.Type;
import k3.c0;
import k3.j;
import k3.m;
import u3.f;

public final class j0 extends h0 {
    public j0() {
        super(String.class, false);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        visitStringFormat(fVar, jVar);
    }

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("string", true);
    }

    public boolean isEmpty(c0 c0Var, Object obj) {
        return ((String) obj).isEmpty();
    }

    public void serialize(Object obj, h hVar, c0 c0Var) {
        hVar.z0((String) obj);
    }

    public final void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        hVar.z0((String) obj);
    }
}
