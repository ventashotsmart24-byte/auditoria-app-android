package x3;

import c4.o;
import d4.h;
import java.util.EnumMap;
import java.util.EnumSet;
import k3.e;
import k3.g;
import k3.j;
import m3.m;
import w3.c;

public class k extends r {

    /* renamed from: c  reason: collision with root package name */
    public final c f9690c;

    public k(j jVar, o oVar, c cVar) {
        super(jVar, oVar);
        this.f9690c = cVar;
    }

    public static k i(j jVar, m mVar, c cVar) {
        return new k(jVar, mVar.z(), cVar);
    }

    public String a(Object obj) {
        return g(obj, obj.getClass(), this.f9714a);
    }

    public String b() {
        return "class name used as type id";
    }

    public String d(Object obj, Class cls) {
        return g(obj, cls, this.f9714a);
    }

    public j f(e eVar, String str) {
        return h(str, eVar);
    }

    public String g(Object obj, Class cls, o oVar) {
        if (h.L(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (name.startsWith("java.util.")) {
            if (obj instanceof EnumSet) {
                return oVar.y(EnumSet.class, h.u((EnumSet) obj)).c();
            } else if (!(obj instanceof EnumMap)) {
                return name;
            } else {
                return oVar.C(EnumMap.class, h.t((EnumMap) obj), Object.class).c();
            }
        } else if (name.indexOf(36) < 0 || h.E(cls) == null || h.E(this.f9715b.q()) != null) {
            return name;
        } else {
            return this.f9715b.q().getName();
        }
    }

    public j h(String str, e eVar) {
        j r10 = eVar.r(this.f9715b, str, this.f9690c);
        if (r10 != null || !(eVar instanceof g)) {
            return r10;
        }
        return ((g) eVar).f0(this.f9715b, str, this, "no such class found");
    }
}
