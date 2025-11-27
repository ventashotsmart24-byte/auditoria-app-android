package b4;

import a4.i;
import k3.c0;
import k3.d;
import w3.h;

public final class o extends k3.o implements i {

    /* renamed from: a  reason: collision with root package name */
    public final h f4374a;

    /* renamed from: b  reason: collision with root package name */
    public final k3.o f4375b;

    public o(h hVar, k3.o oVar) {
        this.f4374a = hVar;
        this.f4375b = oVar;
    }

    public k3.o b(c0 c0Var, d dVar) {
        k3.o oVar = this.f4375b;
        if (oVar instanceof i) {
            oVar = c0Var.i0(oVar, dVar);
        }
        if (oVar == this.f4375b) {
            return this;
        }
        return new o(this.f4374a, oVar);
    }

    public Class handledType() {
        return Object.class;
    }

    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        this.f4375b.serializeWithType(obj, hVar, c0Var, this.f4374a);
    }

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, h hVar2) {
        this.f4375b.serializeWithType(obj, hVar, c0Var, hVar2);
    }
}
