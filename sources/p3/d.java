package p3;

import d4.h;
import k3.g;
import k3.j;
import k3.x;

public class d extends f {

    /* renamed from: e  reason: collision with root package name */
    public final x f8809e;

    public d(g gVar, String str, x xVar) {
        super(gVar.S(), str);
        this.f8809e = xVar;
    }

    public static d v(g gVar, x xVar, j jVar) {
        d dVar = new d(gVar, String.format("Invalid `null` value encountered for property %s", new Object[]{h.c0(xVar, "<UNKNOWN>")}), xVar);
        if (jVar != null) {
            dVar.u(jVar);
        }
        return dVar;
    }
}
