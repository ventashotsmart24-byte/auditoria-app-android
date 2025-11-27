package m;

import java.util.ArrayList;
import m.e;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public int f7793a;

    /* renamed from: b  reason: collision with root package name */
    public int f7794b;

    /* renamed from: c  reason: collision with root package name */
    public int f7795c;

    /* renamed from: d  reason: collision with root package name */
    public int f7796d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f7797e = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public e f7798a;

        /* renamed from: b  reason: collision with root package name */
        public e f7799b;

        /* renamed from: c  reason: collision with root package name */
        public int f7800c;

        /* renamed from: d  reason: collision with root package name */
        public e.c f7801d;

        /* renamed from: e  reason: collision with root package name */
        public int f7802e;

        public a(e eVar) {
            this.f7798a = eVar;
            this.f7799b = eVar.i();
            this.f7800c = eVar.d();
            this.f7801d = eVar.h();
            this.f7802e = eVar.c();
        }

        public void a(f fVar) {
            fVar.h(this.f7798a.j()).b(this.f7799b, this.f7800c, this.f7801d, this.f7802e);
        }

        public void b(f fVar) {
            e h10 = fVar.h(this.f7798a.j());
            this.f7798a = h10;
            if (h10 != null) {
                this.f7799b = h10.i();
                this.f7800c = this.f7798a.d();
                this.f7801d = this.f7798a.h();
                this.f7802e = this.f7798a.c();
                return;
            }
            this.f7799b = null;
            this.f7800c = 0;
            this.f7801d = e.c.STRONG;
            this.f7802e = 0;
        }
    }

    public p(f fVar) {
        this.f7793a = fVar.G();
        this.f7794b = fVar.H();
        this.f7795c = fVar.D();
        this.f7796d = fVar.r();
        ArrayList i10 = fVar.i();
        int size = i10.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f7797e.add(new a((e) i10.get(i11)));
        }
    }

    public void a(f fVar) {
        fVar.C0(this.f7793a);
        fVar.D0(this.f7794b);
        fVar.y0(this.f7795c);
        fVar.b0(this.f7796d);
        int size = this.f7797e.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((a) this.f7797e.get(i10)).a(fVar);
        }
    }

    public void b(f fVar) {
        this.f7793a = fVar.G();
        this.f7794b = fVar.H();
        this.f7795c = fVar.D();
        this.f7796d = fVar.r();
        int size = this.f7797e.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((a) this.f7797e.get(i10)).b(fVar);
        }
    }
}
