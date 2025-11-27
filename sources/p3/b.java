package p3;

import c3.h;
import c3.k;
import k3.c;
import k3.j;
import k3.l;
import r3.s;

public class b extends l {

    /* renamed from: d  reason: collision with root package name */
    public final j f8805d;

    /* renamed from: e  reason: collision with root package name */
    public transient c f8806e;

    /* renamed from: f  reason: collision with root package name */
    public transient s f8807f;

    public b(k kVar, String str, j jVar) {
        super(kVar, str);
        this.f8805d = jVar;
        this.f8806e = null;
        this.f8807f = null;
    }

    public static b s(h hVar, String str, c cVar, s sVar) {
        return new b(hVar, str, cVar, sVar);
    }

    public static b t(h hVar, String str, j jVar) {
        return new b(hVar, str, jVar);
    }

    public static b u(k kVar, String str, c cVar, s sVar) {
        return new b(kVar, str, cVar, sVar);
    }

    public static b v(k kVar, String str, j jVar) {
        return new b(kVar, str, jVar);
    }

    public b(h hVar, String str, j jVar) {
        super(hVar, str);
        this.f8805d = jVar;
        this.f8806e = null;
        this.f8807f = null;
    }

    public b(k kVar, String str, c cVar, s sVar) {
        super(kVar, str);
        j jVar;
        if (cVar == null) {
            jVar = null;
        } else {
            jVar = cVar.z();
        }
        this.f8805d = jVar;
        this.f8806e = cVar;
        this.f8807f = sVar;
    }

    public b(h hVar, String str, c cVar, s sVar) {
        super(hVar, str);
        j jVar;
        if (cVar == null) {
            jVar = null;
        } else {
            jVar = cVar.z();
        }
        this.f8805d = jVar;
        this.f8806e = cVar;
        this.f8807f = sVar;
    }
}
