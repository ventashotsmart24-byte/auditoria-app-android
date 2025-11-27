package k3;

import a4.n;
import d4.h;
import d4.q;
import java.util.Iterator;
import u3.f;

public abstract class o {

    public static abstract class a extends o {
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.c(jVar);
    }

    public o getDelegatee() {
        return null;
    }

    public abstract Class handledType();

    public boolean isEmpty(c0 c0Var, Object obj) {
        return obj == null;
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public Iterator<n> properties() {
        return h.n();
    }

    public o replaceDelegatee(o oVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void serialize(Object obj, c3.h hVar, c0 c0Var);

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        Class<?> handledType = handledType();
        if (handledType == null) {
            handledType = obj.getClass();
        }
        c0Var.p(handledType, String.format("Type id handling not implemented for type %s (by serializer of type %s)", new Object[]{handledType.getName(), getClass().getName()}));
    }

    public o unwrappingSerializer(q qVar) {
        return this;
    }

    public boolean usesObjectId() {
        return false;
    }

    public o withFilterId(Object obj) {
        return this;
    }

    @Deprecated
    public boolean isEmpty(Object obj) {
        return isEmpty((c0) null, obj);
    }
}
