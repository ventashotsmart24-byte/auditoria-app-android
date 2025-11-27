package y9;

import t9.g;

public final class c extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f20257e = new a((g) null);

    /* renamed from: f  reason: collision with root package name */
    public static final c f20258f = new c(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            return c.f20258f;
        }
    }

    public c(int i10, int i11) {
        super(i10, i11, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && b() == cVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i10) {
        if (a() > i10 || i10 > b()) {
            return false;
        }
        return true;
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public boolean isEmpty() {
        if (a() > b()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return a() + ".." + b();
    }
}
