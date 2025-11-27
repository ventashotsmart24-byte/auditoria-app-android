package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import java.lang.reflect.Type;
import k3.c0;
import k3.j;
import k3.m;
import u3.f;

public class u extends i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u f5804a = new u();

    public u() {
        super(Object.class);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.f(jVar);
    }

    public m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("null");
    }

    public void serialize(Object obj, h hVar, c0 c0Var) {
        hVar.a0();
    }

    public void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        hVar.a0();
    }
}
