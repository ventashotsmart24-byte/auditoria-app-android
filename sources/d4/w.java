package d4;

import b3.r;
import c4.o;
import java.util.Collections;
import java.util.Iterator;
import k3.b;
import k3.x;
import m3.m;
import r3.g;
import r3.i;
import r3.j;
import r3.s;

public class w extends s {

    /* renamed from: b  reason: collision with root package name */
    public final b f6310b;

    /* renamed from: c  reason: collision with root package name */
    public final i f6311c;

    /* renamed from: d  reason: collision with root package name */
    public final k3.w f6312d;

    /* renamed from: e  reason: collision with root package name */
    public final x f6313e;

    /* renamed from: f  reason: collision with root package name */
    public final r.b f6314f;

    public w(b bVar, i iVar, x xVar, k3.w wVar, r.b bVar2) {
        this.f6310b = bVar;
        this.f6311c = iVar;
        this.f6313e = xVar;
        this.f6312d = wVar == null ? k3.w.f7486i : wVar;
        this.f6314f = bVar2;
    }

    public static w E(m mVar, i iVar, x xVar) {
        return G(mVar, iVar, xVar, (k3.w) null, s.f9168a);
    }

    public static w F(m mVar, i iVar, x xVar, k3.w wVar, r.a aVar) {
        r.b bVar;
        if (aVar == null || aVar == r.a.USE_DEFAULTS) {
            bVar = s.f9168a;
        } else {
            bVar = r.b.a(aVar, (r.a) null);
        }
        return new w(mVar.g(), iVar, xVar, wVar, bVar);
    }

    public static w G(m mVar, i iVar, x xVar, k3.w wVar, r.b bVar) {
        return new w(mVar.g(), iVar, xVar, wVar, bVar);
    }

    public boolean A() {
        if (v() != null) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return false;
    }

    public boolean C() {
        return false;
    }

    public x c() {
        return this.f6313e;
    }

    public r.b g() {
        return this.f6314f;
    }

    public k3.w getMetadata() {
        return this.f6312d;
    }

    public String getName() {
        return this.f6313e.c();
    }

    public r3.m m() {
        i iVar = this.f6311c;
        if (iVar instanceof r3.m) {
            return (r3.m) iVar;
        }
        return null;
    }

    public Iterator n() {
        r3.m m10 = m();
        if (m10 == null) {
            return h.n();
        }
        return Collections.singleton(m10).iterator();
    }

    public g o() {
        i iVar = this.f6311c;
        if (iVar instanceof g) {
            return (g) iVar;
        }
        return null;
    }

    public j p() {
        i iVar = this.f6311c;
        if (!(iVar instanceof j) || ((j) iVar).v() != 0) {
            return null;
        }
        return (j) this.f6311c;
    }

    public i s() {
        return this.f6311c;
    }

    public k3.j t() {
        i iVar = this.f6311c;
        if (iVar == null) {
            return o.O();
        }
        return iVar.f();
    }

    public Class u() {
        i iVar = this.f6311c;
        if (iVar == null) {
            return Object.class;
        }
        return iVar.e();
    }

    public j v() {
        i iVar = this.f6311c;
        if (!(iVar instanceof j) || ((j) iVar).v() != 1) {
            return null;
        }
        return (j) this.f6311c;
    }

    public x w() {
        i iVar;
        b bVar = this.f6310b;
        if (bVar == null || (iVar = this.f6311c) == null) {
            return null;
        }
        return bVar.g0(iVar);
    }

    public boolean x() {
        return this.f6311c instanceof r3.m;
    }

    public boolean y() {
        return this.f6311c instanceof g;
    }

    public boolean z(x xVar) {
        return this.f6313e.equals(xVar);
    }
}
