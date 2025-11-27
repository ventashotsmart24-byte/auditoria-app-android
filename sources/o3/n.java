package o3;

import c3.k;
import k3.g;
import n3.t;
import r3.i;

public class n extends t.a {

    /* renamed from: p  reason: collision with root package name */
    public final i f8523p;

    public n(t tVar, i iVar) {
        super(tVar);
        this.f8523p = iVar;
    }

    public static n O(t tVar, i iVar) {
        return new n(tVar, iVar);
    }

    public void C(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f8303o.C(obj, obj2);
        }
    }

    public Object D(Object obj, Object obj2) {
        if (obj2 != null) {
            return this.f8303o.D(obj, obj2);
        }
        return obj;
    }

    public t N(t tVar) {
        return new n(tVar, this.f8523p);
    }

    public void l(k kVar, g gVar, Object obj) {
        Object obj2;
        Object n10 = this.f8523p.n(obj);
        if (n10 == null) {
            obj2 = this.f8303o.k(kVar, gVar);
        } else {
            obj2 = this.f8303o.n(kVar, gVar, n10);
        }
        if (obj2 != n10) {
            this.f8303o.C(obj, obj2);
        }
    }

    public Object m(k kVar, g gVar, Object obj) {
        Object obj2;
        Object n10 = this.f8523p.n(obj);
        if (n10 == null) {
            obj2 = this.f8303o.k(kVar, gVar);
        } else {
            obj2 = this.f8303o.n(kVar, gVar, n10);
        }
        if (obj2 == n10 || obj2 == null) {
            return obj;
        }
        return this.f8303o.D(obj, obj2);
    }
}
