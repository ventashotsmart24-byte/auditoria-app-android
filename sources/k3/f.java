package k3;

import c3.k;
import d4.o;
import d4.v;
import java.util.Collection;
import m3.a;
import m3.b;
import m3.d;
import m3.e;
import m3.h;
import m3.i;
import m3.m;
import m3.n;
import r3.c;
import r3.e0;
import w3.g;
import z3.l;

public final class f extends n {

    /* renamed from: x  reason: collision with root package name */
    public static final int f7360x = m.c(h.class);

    /* renamed from: o  reason: collision with root package name */
    public final o f7361o;

    /* renamed from: p  reason: collision with root package name */
    public final l f7362p;

    /* renamed from: q  reason: collision with root package name */
    public final d f7363q;

    /* renamed from: r  reason: collision with root package name */
    public final i f7364r;

    /* renamed from: s  reason: collision with root package name */
    public final int f7365s;

    /* renamed from: t  reason: collision with root package name */
    public final int f7366t;

    /* renamed from: u  reason: collision with root package name */
    public final int f7367u;

    /* renamed from: v  reason: collision with root package name */
    public final int f7368v;

    /* renamed from: w  reason: collision with root package name */
    public final int f7369w;

    public f(a aVar, w3.d dVar, e0 e0Var, v vVar, h hVar, d dVar2) {
        super(aVar, dVar, e0Var, vVar, hVar);
        this.f7365s = f7360x;
        this.f7361o = null;
        this.f7362p = l.f9962d;
        this.f7364r = null;
        this.f7363q = dVar2;
        this.f7366t = 0;
        this.f7367u = 0;
        this.f7368v = 0;
        this.f7369w = 0;
    }

    /* renamed from: W */
    public final f H(int i10) {
        return new f(this, i10, this.f7365s, this.f7366t, this.f7367u, this.f7368v, this.f7369w);
    }

    public b X(c4.f fVar, Class cls, e eVar) {
        return this.f7363q.a(this, fVar, cls, eVar);
    }

    public b Y(c4.f fVar, Class cls, b bVar) {
        return this.f7363q.b(this, fVar, cls, bVar);
    }

    public w3.e Z(j jVar) {
        Collection collection;
        c u10 = A(jVar.q()).u();
        g c02 = g().c0(this, u10, jVar);
        if (c02 == null) {
            c02 = s(jVar);
            collection = null;
            if (c02 == null) {
                return null;
            }
        } else {
            collection = T().c(this, u10);
        }
        return c02.e(this, jVar, collection);
    }

    public i a0() {
        i iVar = this.f7364r;
        if (iVar == null) {
            return i.f7858d;
        }
        return iVar;
    }

    public final int b0() {
        return this.f7365s;
    }

    public final l c0() {
        return this.f7362p;
    }

    public o d0() {
        return this.f7361o;
    }

    public k e0(k kVar) {
        int i10 = this.f7367u;
        if (i10 != 0) {
            kVar.v0(this.f7366t, i10);
        }
        int i11 = this.f7369w;
        if (i11 != 0) {
            kVar.u0(this.f7368v, i11);
        }
        return kVar;
    }

    public k f0(k kVar, c3.c cVar) {
        int i10 = this.f7367u;
        if (i10 != 0) {
            kVar.v0(this.f7366t, i10);
        }
        int i11 = this.f7369w;
        if (i11 != 0) {
            kVar.u0(this.f7368v, i11);
        }
        if (cVar != null) {
            kVar.C0(cVar);
        }
        return kVar;
    }

    public c g0(j jVar) {
        return i().c(this, jVar, this);
    }

    public c h0(j jVar, c cVar) {
        return i().d(this, jVar, this, cVar);
    }

    public c i0(j jVar) {
        return i().b(this, jVar, this);
    }

    public final boolean j0(h hVar) {
        if ((hVar.b() & this.f7365s) != 0) {
            return true;
        }
        return false;
    }

    public boolean k0() {
        x xVar = this.f7893g;
        if (xVar != null) {
            return !xVar.h();
        }
        return j0(h.UNWRAP_ROOT_VALUE);
    }

    public f l0(h hVar) {
        int b10 = this.f7365s | hVar.b();
        if (b10 == this.f7365s) {
            return this;
        }
        return new f(this, this.f7886a, b10, this.f7366t, this.f7367u, this.f7368v, this.f7369w);
    }

    public f m0(h hVar) {
        int b10 = this.f7365s & (hVar.b() ^ -1);
        if (b10 == this.f7365s) {
            return this;
        }
        return new f(this, this.f7886a, b10, this.f7366t, this.f7367u, this.f7368v, this.f7369w);
    }

    public f(f fVar, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(fVar, i10);
        this.f7365s = i11;
        this.f7361o = fVar.f7361o;
        this.f7362p = fVar.f7362p;
        this.f7363q = fVar.f7363q;
        this.f7364r = fVar.f7364r;
        this.f7366t = i12;
        this.f7367u = i13;
        this.f7368v = i14;
        this.f7369w = i15;
    }
}
