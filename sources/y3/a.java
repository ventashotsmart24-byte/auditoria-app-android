package y3;

import c4.b;
import c4.d;
import c4.g;
import c4.h;
import java.io.Serializable;
import java.util.HashMap;
import k3.c;
import k3.f;
import k3.j;
import k3.k;
import k3.p;
import n3.o;
import w3.e;

public class a extends o.a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f9869a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9870b = false;

    public k a(j jVar, f fVar, c cVar) {
        return j(jVar);
    }

    public k b(c4.j jVar, f fVar, c cVar, e eVar, k kVar) {
        return j(jVar);
    }

    public k c(h hVar, f fVar, c cVar, p pVar, e eVar, k kVar) {
        return j(hVar);
    }

    public k d(Class cls, f fVar, c cVar) {
        HashMap hashMap = this.f9869a;
        if (hashMap == null) {
            return null;
        }
        k kVar = (k) hashMap.get(new b(cls));
        if (kVar != null || !this.f9870b || !cls.isEnum()) {
            return kVar;
        }
        return (k) this.f9869a.get(new b(Enum.class));
    }

    public k e(d dVar, f fVar, c cVar, e eVar, k kVar) {
        return j(dVar);
    }

    public k f(Class cls, f fVar, c cVar) {
        HashMap hashMap = this.f9869a;
        if (hashMap == null) {
            return null;
        }
        return (k) hashMap.get(new b(cls));
    }

    public k g(c4.a aVar, f fVar, c cVar, e eVar, k kVar) {
        return j(aVar);
    }

    public k h(c4.e eVar, f fVar, c cVar, e eVar2, k kVar) {
        return j(eVar);
    }

    public k i(g gVar, f fVar, c cVar, p pVar, e eVar, k kVar) {
        return j(gVar);
    }

    public final k j(j jVar) {
        HashMap hashMap = this.f9869a;
        if (hashMap == null) {
            return null;
        }
        return (k) hashMap.get(new b(jVar.q()));
    }

    public void k(Class cls, k kVar) {
        b bVar = new b(cls);
        if (this.f9869a == null) {
            this.f9869a = new HashMap();
        }
        this.f9869a.put(bVar, kVar);
        if (cls == Enum.class) {
            this.f9870b = true;
        }
    }
}
