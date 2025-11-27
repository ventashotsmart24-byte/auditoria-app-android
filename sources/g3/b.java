package g3;

import c3.h;
import c3.o;
import c3.q;
import d3.a;
import f3.c;
import j3.e;
import j3.i;

public abstract class b extends a {

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f6768p = f3.a.e();

    /* renamed from: q  reason: collision with root package name */
    public static final i f6769q = h.f4715c;

    /* renamed from: k  reason: collision with root package name */
    public final c f6770k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f6771l = f6768p;

    /* renamed from: m  reason: collision with root package name */
    public int f6772m;

    /* renamed from: n  reason: collision with root package name */
    public q f6773n = e.f7154h;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6774o;

    public b(c cVar, int i10, o oVar) {
        super(i10, oVar);
        this.f6770k = cVar;
        if (h.b.ESCAPE_NON_ASCII.c(i10)) {
            this.f6772m = 127;
        }
        this.f6774o = !h.b.QUOTE_FIELD_NAMES.c(i10);
    }

    public h E(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        this.f6772m = i10;
        return this;
    }

    public void G0(int i10, int i11) {
        super.G0(i10, i11);
        this.f6774o = !h.b.QUOTE_FIELD_NAMES.c(i10);
    }

    public void J0(String str) {
        a(String.format("Can not %s, expecting field name (context: %s)", new Object[]{str, this.f6210h.j()}));
    }

    public void K0(String str, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                this.f4717a.g(this);
            } else if (i10 == 2) {
                this.f4717a.h(this);
            } else if (i10 == 3) {
                this.f4717a.j(this);
            } else if (i10 != 5) {
                b();
            } else {
                J0(str);
            }
        } else if (this.f6210h.f()) {
            this.f4717a.c(this);
        } else if (this.f6210h.g()) {
            this.f4717a.k(this);
        }
    }

    public h L(q qVar) {
        this.f6773n = qVar;
        return this;
    }

    public h q(h.b bVar) {
        super.q(bVar);
        if (bVar == h.b.QUOTE_FIELD_NAMES) {
            this.f6774o = true;
        }
        return this;
    }
}
