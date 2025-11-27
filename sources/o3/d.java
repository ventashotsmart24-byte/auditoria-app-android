package o3;

import b3.b;
import k3.b;
import k3.x;
import r3.m;
import r3.n;
import r3.s;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f8469a;

    /* renamed from: b  reason: collision with root package name */
    public final n f8470b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8471c;

    /* renamed from: d  reason: collision with root package name */
    public final a[] f8472d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final m f8473a;

        /* renamed from: b  reason: collision with root package name */
        public final s f8474b;

        /* renamed from: c  reason: collision with root package name */
        public final b.a f8475c;

        public a(m mVar, s sVar, b.a aVar) {
            this.f8473a = mVar;
            this.f8474b = sVar;
            this.f8475c = aVar;
        }
    }

    public d(k3.b bVar, n nVar, a[] aVarArr, int i10) {
        this.f8469a = bVar;
        this.f8470b = nVar;
        this.f8472d = aVarArr;
        this.f8471c = i10;
    }

    public static d a(k3.b bVar, n nVar, s[] sVarArr) {
        s sVar;
        int v10 = nVar.v();
        a[] aVarArr = new a[v10];
        for (int i10 = 0; i10 < v10; i10++) {
            m t10 = nVar.t(i10);
            b.a s10 = bVar.s(t10);
            if (sVarArr == null) {
                sVar = null;
            } else {
                sVar = sVarArr[i10];
            }
            aVarArr[i10] = new a(t10, sVar, s10);
        }
        return new d(bVar, nVar, aVarArr, v10);
    }

    public n b() {
        return this.f8470b;
    }

    public x c(int i10) {
        s sVar = this.f8472d[i10].f8474b;
        if (sVar == null || !sVar.C()) {
            return null;
        }
        return sVar.c();
    }

    public x d(int i10) {
        String r10 = this.f8469a.r(this.f8472d[i10].f8473a);
        if (r10 == null || r10.isEmpty()) {
            return null;
        }
        return x.a(r10);
    }

    public int e() {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f8471c; i11++) {
            if (this.f8472d[i11].f8475c == null) {
                if (i10 >= 0) {
                    return -1;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public b.a f(int i10) {
        return this.f8472d[i10].f8475c;
    }

    public int g() {
        return this.f8471c;
    }

    public x h(int i10) {
        s sVar = this.f8472d[i10].f8474b;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public m i(int i10) {
        return this.f8472d[i10].f8473a;
    }

    public s j(int i10) {
        return this.f8472d[i10].f8474b;
    }

    public String toString() {
        return this.f8470b.toString();
    }
}
