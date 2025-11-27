package g3;

import c3.i;
import c3.j;
import c3.k;
import c3.m;

public final class c extends m {

    /* renamed from: c  reason: collision with root package name */
    public final c f6775c;

    /* renamed from: d  reason: collision with root package name */
    public a f6776d;

    /* renamed from: e  reason: collision with root package name */
    public c f6777e;

    /* renamed from: f  reason: collision with root package name */
    public String f6778f;

    /* renamed from: g  reason: collision with root package name */
    public Object f6779g;

    /* renamed from: h  reason: collision with root package name */
    public int f6780h;

    /* renamed from: i  reason: collision with root package name */
    public int f6781i;

    public c(c cVar, a aVar, int i10, int i11, int i12) {
        this.f6775c = cVar;
        this.f6776d = aVar;
        this.f4766a = i10;
        this.f6780h = i11;
        this.f6781i = i12;
        this.f4767b = -1;
    }

    public static c o(a aVar) {
        return new c((c) null, aVar, 0, 1, 0);
    }

    public String b() {
        return this.f6778f;
    }

    public Object c() {
        return this.f6779g;
    }

    public void i(Object obj) {
        this.f6779g = obj;
    }

    public final void k(a aVar, String str) {
        k kVar;
        if (aVar.c(str)) {
            Object b10 = aVar.b();
            if (b10 instanceof k) {
                kVar = (k) b10;
            } else {
                kVar = null;
            }
            throw new j(kVar, "Duplicate field '" + str + "'");
        }
    }

    public c l() {
        this.f6779g = null;
        return this.f6775c;
    }

    public c m(int i10, int i11) {
        a aVar;
        c cVar = this.f6777e;
        if (cVar == null) {
            a aVar2 = this.f6776d;
            if (aVar2 == null) {
                aVar = null;
            } else {
                aVar = aVar2.a();
            }
            cVar = new c(this, aVar, 1, i10, i11);
            this.f6777e = cVar;
        } else {
            cVar.t(1, i10, i11);
        }
        return cVar;
    }

    public c n(int i10, int i11) {
        a aVar;
        c cVar = this.f6777e;
        if (cVar == null) {
            a aVar2 = this.f6776d;
            if (aVar2 == null) {
                aVar = null;
            } else {
                aVar = aVar2.a();
            }
            c cVar2 = new c(this, aVar, 2, i10, i11);
            this.f6777e = cVar2;
            return cVar2;
        }
        cVar.t(2, i10, i11);
        return cVar;
    }

    public boolean p() {
        int i10 = this.f4767b + 1;
        this.f4767b = i10;
        if (this.f4766a == 0 || i10 <= 0) {
            return false;
        }
        return true;
    }

    public a q() {
        return this.f6776d;
    }

    /* renamed from: r */
    public c e() {
        return this.f6775c;
    }

    public i s(Object obj) {
        return new i(obj, -1, this.f6780h, this.f6781i);
    }

    public void t(int i10, int i11, int i12) {
        this.f4766a = i10;
        this.f4767b = -1;
        this.f6780h = i11;
        this.f6781i = i12;
        this.f6778f = null;
        this.f6779g = null;
        a aVar = this.f6776d;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void u(String str) {
        this.f6778f = str;
        a aVar = this.f6776d;
        if (aVar != null) {
            k(aVar, str);
        }
    }

    public c v(a aVar) {
        this.f6776d = aVar;
        return this;
    }
}
