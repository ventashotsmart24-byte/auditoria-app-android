package x3;

import com.fasterxml.jackson.databind.deser.std.u;
import d4.h;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.d;
import k3.g;
import k3.j;
import k3.k;
import w3.e;
import w3.f;

public abstract class q extends e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final f f9706a;

    /* renamed from: b  reason: collision with root package name */
    public final j f9707b;

    /* renamed from: c  reason: collision with root package name */
    public final d f9708c;

    /* renamed from: d  reason: collision with root package name */
    public final j f9709d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9710e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f9711f;

    /* renamed from: g  reason: collision with root package name */
    public final Map f9712g;

    /* renamed from: h  reason: collision with root package name */
    public k f9713h;

    public q(j jVar, f fVar, String str, boolean z10, j jVar2) {
        this.f9707b = jVar;
        this.f9706a = fVar;
        this.f9710e = h.Z(str);
        this.f9711f = z10;
        this.f9712g = new ConcurrentHashMap(16, 0.75f, 2);
        this.f9709d = jVar2;
        this.f9708c = null;
    }

    public Class h() {
        return h.d0(this.f9709d);
    }

    public final String i() {
        return this.f9710e;
    }

    public f j() {
        return this.f9706a;
    }

    public boolean l() {
        if (this.f9709d != null) {
            return true;
        }
        return false;
    }

    public Object m(c3.k kVar, g gVar, Object obj) {
        k kVar2;
        String str;
        if (obj == null) {
            kVar2 = n(gVar);
            if (kVar2 == null) {
                return gVar.y0(r(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
            }
        } else {
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = String.valueOf(obj);
            }
            kVar2 = o(gVar, str);
        }
        return kVar2.deserialize(kVar, gVar);
    }

    public final k n(g gVar) {
        k kVar;
        j jVar = this.f9709d;
        if (jVar == null) {
            if (!gVar.n0(k3.h.FAIL_ON_INVALID_SUBTYPE)) {
                return u.f5687a;
            }
            return null;
        } else if (h.J(jVar.q())) {
            return u.f5687a;
        } else {
            synchronized (this.f9709d) {
                if (this.f9713h == null) {
                    this.f9713h = gVar.D(this.f9709d, this.f9708c);
                }
                kVar = this.f9713h;
            }
            return kVar;
        }
    }

    public final k o(g gVar, String str) {
        k kVar;
        k kVar2 = (k) this.f9712g.get(str);
        if (kVar2 == null) {
            j f10 = this.f9706a.f(gVar, str);
            if (f10 == null) {
                kVar2 = n(gVar);
                if (kVar2 == null) {
                    j q10 = q(gVar, str);
                    if (q10 == null) {
                        return u.f5687a;
                    }
                    kVar = gVar.D(q10, this.f9708c);
                }
                this.f9712g.put(str, kVar2);
            } else {
                j jVar = this.f9707b;
                if (jVar != null && jVar.getClass() == f10.getClass() && !f10.w()) {
                    try {
                        f10 = gVar.w(this.f9707b, f10.q());
                    } catch (IllegalArgumentException e10) {
                        throw gVar.m(this.f9707b, str, e10.getMessage());
                    }
                }
                kVar = gVar.D(f10, this.f9708c);
            }
            kVar2 = kVar;
            this.f9712g.put(str, kVar2);
        }
        return kVar2;
    }

    public j p(g gVar, String str) {
        return gVar.X(this.f9707b, this.f9706a, str);
    }

    public j q(g gVar, String str) {
        String str2;
        String b10 = this.f9706a.b();
        if (b10 == null) {
            str2 = "type ids are not statically known";
        } else {
            str2 = "known type ids = " + b10;
        }
        d dVar = this.f9708c;
        if (dVar != null) {
            str2 = String.format("%s (for POJO property '%s')", new Object[]{str2, dVar.getName()});
        }
        return gVar.f0(this.f9707b, str, this.f9706a, str2);
    }

    public j r() {
        return this.f9707b;
    }

    public String s() {
        return this.f9707b.q().getName();
    }

    public String toString() {
        return '[' + getClass().getName() + "; base-type:" + this.f9707b + "; id-resolver: " + this.f9706a + ']';
    }

    public q(q qVar, d dVar) {
        this.f9707b = qVar.f9707b;
        this.f9706a = qVar.f9706a;
        this.f9710e = qVar.f9710e;
        this.f9711f = qVar.f9711f;
        this.f9712g = qVar.f9712g;
        this.f9709d = qVar.f9709d;
        this.f9713h = qVar.f9713h;
        this.f9708c = dVar;
    }
}
