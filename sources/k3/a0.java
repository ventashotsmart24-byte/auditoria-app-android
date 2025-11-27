package k3;

import a4.k;
import c3.h;
import c3.p;
import d4.v;
import j3.e;
import j3.f;
import m3.a;
import m3.h;
import m3.m;
import m3.n;
import r3.e0;
import w3.d;

public final class a0 extends n {

    /* renamed from: u  reason: collision with root package name */
    public static final p f7299u = new e();

    /* renamed from: v  reason: collision with root package name */
    public static final int f7300v = m.c(b0.class);

    /* renamed from: o  reason: collision with root package name */
    public final p f7301o;

    /* renamed from: p  reason: collision with root package name */
    public final int f7302p;

    /* renamed from: q  reason: collision with root package name */
    public final int f7303q;

    /* renamed from: r  reason: collision with root package name */
    public final int f7304r;

    /* renamed from: s  reason: collision with root package name */
    public final int f7305s;

    /* renamed from: t  reason: collision with root package name */
    public final int f7306t;

    public a0(a aVar, d dVar, e0 e0Var, v vVar, h hVar) {
        super(aVar, dVar, e0Var, vVar, hVar);
        this.f7302p = f7300v;
        this.f7301o = f7299u;
        this.f7303q = 0;
        this.f7304r = 0;
        this.f7305s = 0;
        this.f7306t = 0;
    }

    /* renamed from: W */
    public final a0 H(int i10) {
        return new a0(this, i10, this.f7302p, this.f7303q, this.f7304r, this.f7305s, this.f7306t);
    }

    public p X() {
        p pVar = this.f7301o;
        if (pVar instanceof f) {
            return (p) ((f) pVar).f();
        }
        return pVar;
    }

    public p Y() {
        return this.f7301o;
    }

    public k Z() {
        return null;
    }

    public void a0(c3.h hVar) {
        p X;
        if (b0.INDENT_OUTPUT.c(this.f7302p) && hVar.u() == null && (X = X()) != null) {
            hVar.I(X);
        }
        boolean c10 = b0.WRITE_BIGDECIMAL_AS_PLAIN.c(this.f7302p);
        int i10 = this.f7304r;
        if (i10 != 0 || c10) {
            int i11 = this.f7303q;
            if (c10) {
                int d10 = h.b.WRITE_BIGDECIMAL_AS_PLAIN.d();
                i11 |= d10;
                i10 |= d10;
            }
            hVar.y(i11, i10);
        }
        int i12 = this.f7306t;
        if (i12 != 0) {
            hVar.x(this.f7305s, i12);
        }
    }

    public c b0(j jVar) {
        return i().e(this, jVar, this);
    }

    public final boolean c0(b0 b0Var) {
        if ((b0Var.b() & this.f7302p) != 0) {
            return true;
        }
        return false;
    }

    public a0 d0(h.b bVar) {
        int d10 = this.f7303q & (bVar.d() ^ -1);
        int d11 = this.f7304r | bVar.d();
        if (this.f7303q == d10 && this.f7304r == d11) {
            return this;
        }
        return new a0(this, this.f7886a, this.f7302p, d10, d11, this.f7305s, this.f7306t);
    }

    public a0(a0 a0Var, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(a0Var, i10);
        this.f7302p = i11;
        a0Var.getClass();
        this.f7301o = a0Var.f7301o;
        this.f7303q = i12;
        this.f7304r = i13;
        this.f7305s = i14;
        this.f7306t = i15;
    }
}
