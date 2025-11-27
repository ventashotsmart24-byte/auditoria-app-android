package o3;

import java.io.Serializable;
import k3.d;
import k3.g;
import k3.j;
import k3.x;
import n3.q;

public class r implements q, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final x f8532a;

    /* renamed from: b  reason: collision with root package name */
    public final j f8533b;

    public r(x xVar, j jVar) {
        this.f8532a = xVar;
        this.f8533b = jVar;
    }

    public static r a(d dVar) {
        return b(dVar, dVar.getType());
    }

    public static r b(d dVar, j jVar) {
        return new r(dVar.c(), jVar);
    }

    public static r c(j jVar) {
        return new r((x) null, jVar);
    }

    public Object getNullValue(g gVar) {
        throw p3.d.v(gVar, this.f8532a, this.f8533b);
    }
}
