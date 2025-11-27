package a4;

import b4.b;
import b4.i;
import b4.s;
import c3.h;
import d4.q;
import java.util.Set;
import k3.c0;
import k3.j;
import k3.o;

public class d extends com.fasterxml.jackson.databind.ser.std.d {
    public d(j jVar, e eVar, c[] cVarArr, c[] cVarArr2) {
        super(jVar, eVar, cVarArr, cVarArr2);
    }

    public static d p(j jVar, e eVar) {
        return new d(jVar, eVar, com.fasterxml.jackson.databind.ser.std.d.f5746j, (c[]) null);
    }

    public com.fasterxml.jackson.databind.ser.std.d g() {
        if (this.f5753g == null && this.f5750d == null && this.f5751e == null) {
            return new b(this);
        }
        return this;
    }

    public com.fasterxml.jackson.databind.ser.std.d l(Set set, Set set2) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, set, set2);
    }

    /* renamed from: m */
    public com.fasterxml.jackson.databind.ser.std.d withFilterId(Object obj) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, this.f5753g, obj);
    }

    public com.fasterxml.jackson.databind.ser.std.d n(i iVar) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, iVar, this.f5751e);
    }

    public com.fasterxml.jackson.databind.ser.std.d o(c[] cVarArr, c[] cVarArr2) {
        return new d((com.fasterxml.jackson.databind.ser.std.d) this, cVarArr, cVarArr2);
    }

    public final void serialize(Object obj, h hVar, c0 c0Var) {
        if (this.f5753g != null) {
            hVar.z(obj);
            e(obj, hVar, c0Var, true);
            return;
        }
        hVar.w0(obj);
        if (this.f5751e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        hVar.W();
    }

    public String toString() {
        return "BeanSerializer for " + handledType().getName();
    }

    public o unwrappingSerializer(q qVar) {
        return new s((com.fasterxml.jackson.databind.ser.std.d) this, qVar);
    }

    public d(com.fasterxml.jackson.databind.ser.std.d dVar, i iVar, Object obj) {
        super(dVar, iVar, obj);
    }

    public d(com.fasterxml.jackson.databind.ser.std.d dVar, Set set, Set set2) {
        super(dVar, set, set2);
    }

    public d(com.fasterxml.jackson.databind.ser.std.d dVar, c[] cVarArr, c[] cVarArr2) {
        super(dVar, cVarArr, cVarArr2);
    }
}
