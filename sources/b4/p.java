package b4;

import c3.h;
import c3.n;
import com.fasterxml.jackson.databind.ser.std.i0;
import java.lang.reflect.Type;
import k3.b0;
import k3.c0;
import k3.j;
import k3.m;
import u3.f;

public class p extends i0 {
    public p() {
        super(Object.class);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.c(jVar);
    }

    public void c(c0 c0Var, Object obj) {
        c0Var.p(handledType(), String.format("No serializer found for class %s and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)", new Object[]{obj.getClass().getName()}));
    }

    public m getSchema(c0 c0Var, Type type) {
        return null;
    }

    public boolean isEmpty(c0 c0Var, Object obj) {
        return true;
    }

    public void serialize(Object obj, h hVar, c0 c0Var) {
        if (c0Var.m0(b0.FAIL_ON_EMPTY_BEANS)) {
            c(c0Var, obj);
        }
        hVar.x0(obj, 0);
        hVar.W();
    }

    public final void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        if (c0Var.m0(b0.FAIL_ON_EMPTY_BEANS)) {
            c(c0Var, obj);
        }
        hVar2.h(hVar, hVar2.g(hVar, hVar2.d(obj, n.START_OBJECT)));
    }

    public p(Class cls) {
        super(cls, false);
    }
}
