package a1;

import android.os.Build;

public final class b {

    /* renamed from: i  reason: collision with root package name */
    public static final b f83i = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public l f84a = l.NOT_REQUIRED;

    /* renamed from: b  reason: collision with root package name */
    public boolean f85b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f86c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f87d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f88e;

    /* renamed from: f  reason: collision with root package name */
    public long f89f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f90g = -1;

    /* renamed from: h  reason: collision with root package name */
    public c f91h = new c();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f92a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f93b = false;

        /* renamed from: c  reason: collision with root package name */
        public l f94c = l.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        public boolean f95d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f96e = false;

        /* renamed from: f  reason: collision with root package name */
        public long f97f = -1;

        /* renamed from: g  reason: collision with root package name */
        public long f98g = -1;

        /* renamed from: h  reason: collision with root package name */
        public c f99h = new c();

        public b a() {
            return new b(this);
        }
    }

    public b() {
    }

    public c a() {
        return this.f91h;
    }

    public l b() {
        return this.f84a;
    }

    public long c() {
        return this.f89f;
    }

    public long d() {
        return this.f90g;
    }

    public boolean e() {
        if (this.f91h.c() > 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f85b == bVar.f85b && this.f86c == bVar.f86c && this.f87d == bVar.f87d && this.f88e == bVar.f88e && this.f89f == bVar.f89f && this.f90g == bVar.f90g && this.f84a == bVar.f84a) {
            return this.f91h.equals(bVar.f91h);
        }
        return false;
    }

    public boolean f() {
        return this.f87d;
    }

    public boolean g() {
        return this.f85b;
    }

    public boolean h() {
        return this.f86c;
    }

    public int hashCode() {
        long j10 = this.f89f;
        long j11 = this.f90g;
        return (((((((((((((this.f84a.hashCode() * 31) + (this.f85b ? 1 : 0)) * 31) + (this.f86c ? 1 : 0)) * 31) + (this.f87d ? 1 : 0)) * 31) + (this.f88e ? 1 : 0)) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f91h.hashCode();
    }

    public boolean i() {
        return this.f88e;
    }

    public void j(c cVar) {
        this.f91h = cVar;
    }

    public void k(l lVar) {
        this.f84a = lVar;
    }

    public void l(boolean z10) {
        this.f87d = z10;
    }

    public void m(boolean z10) {
        this.f85b = z10;
    }

    public void n(boolean z10) {
        this.f86c = z10;
    }

    public void o(boolean z10) {
        this.f88e = z10;
    }

    public void p(long j10) {
        this.f89f = j10;
    }

    public void q(long j10) {
        this.f90g = j10;
    }

    public b(a aVar) {
        this.f85b = aVar.f92a;
        int i10 = Build.VERSION.SDK_INT;
        this.f86c = i10 >= 23 && aVar.f93b;
        this.f84a = aVar.f94c;
        this.f87d = aVar.f95d;
        this.f88e = aVar.f96e;
        if (i10 >= 24) {
            this.f91h = aVar.f99h;
            this.f89f = aVar.f97f;
            this.f90g = aVar.f98g;
        }
    }

    public b(b bVar) {
        this.f85b = bVar.f85b;
        this.f86c = bVar.f86c;
        this.f84a = bVar.f84a;
        this.f87d = bVar.f87d;
        this.f88e = bVar.f88e;
        this.f91h = bVar.f91h;
    }
}
