package y3;

import a4.r;
import c4.a;
import c4.b;
import c4.d;
import c4.e;
import c4.g;
import java.io.Serializable;
import java.util.HashMap;
import k3.a0;
import k3.j;
import k3.o;
import w3.h;

public class c extends r.a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f9878a = null;

    /* renamed from: b  reason: collision with root package name */
    public HashMap f9879b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9880c = false;

    public o a(a0 a0Var, e eVar, k3.c cVar, h hVar, o oVar) {
        return c(a0Var, eVar, cVar);
    }

    public o b(a0 a0Var, a aVar, k3.c cVar, h hVar, o oVar) {
        return c(a0Var, aVar, cVar);
    }

    public o c(a0 a0Var, j jVar, k3.c cVar) {
        o i10;
        o oVar;
        Class q10 = jVar.q();
        b bVar = new b(q10);
        if (q10.isInterface()) {
            HashMap hashMap = this.f9879b;
            if (!(hashMap == null || (oVar = (o) hashMap.get(bVar)) == null)) {
                return oVar;
            }
        } else {
            HashMap hashMap2 = this.f9878a;
            if (hashMap2 != null) {
                o oVar2 = (o) hashMap2.get(bVar);
                if (oVar2 != null) {
                    return oVar2;
                }
                if (this.f9880c && jVar.F()) {
                    bVar.b(Enum.class);
                    o oVar3 = (o) this.f9878a.get(bVar);
                    if (oVar3 != null) {
                        return oVar3;
                    }
                }
                for (Class cls = q10; cls != null; cls = cls.getSuperclass()) {
                    bVar.b(cls);
                    o oVar4 = (o) this.f9878a.get(bVar);
                    if (oVar4 != null) {
                        return oVar4;
                    }
                }
            }
        }
        if (this.f9879b == null) {
            return null;
        }
        o i11 = i(q10, bVar);
        if (i11 != null) {
            return i11;
        }
        if (q10.isInterface()) {
            return null;
        }
        do {
            q10 = q10.getSuperclass();
            if (q10 == null) {
                return null;
            }
            i10 = i(q10, bVar);
        } while (i10 == null);
        return i10;
    }

    public o e(a0 a0Var, c4.h hVar, k3.c cVar, o oVar, h hVar2, o oVar2) {
        return c(a0Var, hVar, cVar);
    }

    public o f(a0 a0Var, d dVar, k3.c cVar, h hVar, o oVar) {
        return c(a0Var, dVar, cVar);
    }

    public o g(a0 a0Var, g gVar, k3.c cVar, o oVar, h hVar, o oVar2) {
        return c(a0Var, gVar, cVar);
    }

    public void h(Class cls, o oVar) {
        b bVar = new b(cls);
        if (cls.isInterface()) {
            if (this.f9879b == null) {
                this.f9879b = new HashMap();
            }
            this.f9879b.put(bVar, oVar);
            return;
        }
        if (this.f9878a == null) {
            this.f9878a = new HashMap();
        }
        this.f9878a.put(bVar, oVar);
        if (cls == Enum.class) {
            this.f9880c = true;
        }
    }

    public o i(Class cls, b bVar) {
        for (Class cls2 : cls.getInterfaces()) {
            bVar.b(cls2);
            o oVar = (o) this.f9879b.get(bVar);
            if (oVar != null) {
                return oVar;
            }
            o i10 = i(cls2, bVar);
            if (i10 != null) {
                return i10;
            }
        }
        return null;
    }

    public void j(o oVar) {
        Class<Object> handledType = oVar.handledType();
        if (handledType == null || handledType == Object.class) {
            throw new IllegalArgumentException("JsonSerializer of type " + oVar.getClass().getName() + " does not define valid handledType() -- must either register with method that takes type argument  or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'");
        }
        h(handledType, oVar);
    }
}
