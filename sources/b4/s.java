package b4;

import a4.c;
import c3.h;
import com.fasterxml.jackson.databind.ser.std.d;
import d4.q;
import java.util.Set;
import k3.b0;
import k3.c0;
import k3.o;

public class s extends d {

    /* renamed from: k  reason: collision with root package name */
    public final q f4379k;

    public s(d dVar, q qVar) {
        super(dVar, qVar);
        this.f4379k = qVar;
    }

    public d g() {
        return this;
    }

    public boolean isUnwrappingSerializer() {
        return true;
    }

    public d l(Set set, Set set2) {
        return new s(this, set, set2);
    }

    /* renamed from: m */
    public d withFilterId(Object obj) {
        return new s(this, this.f5753g, obj);
    }

    public d n(i iVar) {
        return new s(this, iVar);
    }

    public d o(c[] cVarArr, c[] cVarArr2) {
        return new s(this, cVarArr, cVarArr2);
    }

    public final void serialize(Object obj, h hVar, c0 c0Var) {
        hVar.z(obj);
        if (this.f5753g != null) {
            e(obj, hVar, c0Var, false);
        } else if (this.f5751e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
    }

    public void serializeWithType(Object obj, h hVar, c0 c0Var, w3.h hVar2) {
        if (c0Var.m0(b0.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            c0Var.p(handledType(), "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        hVar.z(obj);
        if (this.f5753g != null) {
            d(obj, hVar, c0Var, hVar2);
        } else if (this.f5751e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
    }

    public String toString() {
        return "UnwrappingBeanSerializer for " + handledType().getName();
    }

    public o unwrappingSerializer(q qVar) {
        return new s((d) this, qVar);
    }

    public s(s sVar, i iVar) {
        super((d) sVar, iVar);
        this.f4379k = sVar.f4379k;
    }

    public s(s sVar, i iVar, Object obj) {
        super((d) sVar, iVar, obj);
        this.f4379k = sVar.f4379k;
    }

    public s(s sVar, Set set, Set set2) {
        super((d) sVar, set, set2);
        this.f4379k = sVar.f4379k;
    }

    public s(s sVar, c[] cVarArr, c[] cVarArr2) {
        super((d) sVar, cVarArr, cVarArr2);
        this.f4379k = sVar.f4379k;
    }
}
