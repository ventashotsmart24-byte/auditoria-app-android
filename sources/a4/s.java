package a4;

import b3.r;
import b4.k;
import d4.b;
import k3.c0;
import k3.j;
import k3.o;
import m3.m;
import r3.c;
import w3.h;

public abstract class s extends c {
    public s(r3.s sVar, b bVar, j jVar, o oVar, h hVar, j jVar2, r.b bVar2, Class[] clsArr) {
        super(sVar, sVar.s(), bVar, jVar, oVar, hVar, jVar2, F(bVar2), G(bVar2), clsArr);
    }

    public static boolean F(r.b bVar) {
        r.a h10;
        if (bVar == null || (h10 = bVar.h()) == r.a.ALWAYS || h10 == r.a.USE_DEFAULTS) {
            return false;
        }
        return true;
    }

    public static Object G(r.b bVar) {
        if (bVar == null) {
            return Boolean.FALSE;
        }
        r.a h10 = bVar.h();
        if (h10 == r.a.ALWAYS || h10 == r.a.NON_NULL || h10 == r.a.USE_DEFAULTS) {
            return null;
        }
        return c.f184t;
    }

    public abstract Object H(Object obj, c3.h hVar, c0 c0Var);

    public abstract s I(m mVar, c cVar, r3.s sVar, j jVar);

    public void x(Object obj, c3.h hVar, c0 c0Var) {
        Object H = H(obj, hVar, c0Var);
        if (H == null) {
            o oVar = this.f195m;
            if (oVar != null) {
                oVar.serialize((Object) null, hVar, c0Var);
            } else {
                hVar.a0();
            }
        } else {
            o oVar2 = this.f194l;
            if (oVar2 == null) {
                Class<?> cls = H.getClass();
                k kVar = this.f197o;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar2 = h(kVar, cls, c0Var);
                } else {
                    oVar2 = j10;
                }
            }
            Object obj2 = this.f199q;
            if (obj2 != null) {
                if (c.f184t == obj2) {
                    if (oVar2.isEmpty(c0Var, H)) {
                        A(obj, hVar, c0Var);
                        return;
                    }
                } else if (obj2.equals(H)) {
                    A(obj, hVar, c0Var);
                    return;
                }
            }
            if (H != obj || !i(obj, hVar, c0Var, oVar2)) {
                h hVar2 = this.f196n;
                if (hVar2 == null) {
                    oVar2.serialize(H, hVar, c0Var);
                } else {
                    oVar2.serializeWithType(H, hVar, c0Var, hVar2);
                }
            }
        }
    }

    public void y(Object obj, c3.h hVar, c0 c0Var) {
        Object H = H(obj, hVar, c0Var);
        if (H != null) {
            o oVar = this.f194l;
            if (oVar == null) {
                Class<?> cls = H.getClass();
                k kVar = this.f197o;
                o j10 = kVar.j(cls);
                if (j10 == null) {
                    oVar = h(kVar, cls, c0Var);
                } else {
                    oVar = j10;
                }
            }
            Object obj2 = this.f199q;
            if (obj2 != null) {
                if (c.f184t == obj2) {
                    if (oVar.isEmpty(c0Var, H)) {
                        return;
                    }
                } else if (obj2.equals(H)) {
                    return;
                }
            }
            if (H != obj || !i(obj, hVar, c0Var, oVar)) {
                hVar.Y(this.f185c);
                h hVar2 = this.f196n;
                if (hVar2 == null) {
                    oVar.serialize(H, hVar, c0Var);
                } else {
                    oVar.serializeWithType(H, hVar, c0Var, hVar2);
                }
            }
        } else if (this.f195m != null) {
            hVar.Y(this.f185c);
            this.f195m.serialize((Object) null, hVar, c0Var);
        }
    }
}
