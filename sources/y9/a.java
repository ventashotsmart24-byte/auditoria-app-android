package y9;

import i9.w;
import n9.c;
import t9.g;

public class a implements Iterable, u9.a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0298a f20249d = new C0298a((g) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f20250a;

    /* renamed from: b  reason: collision with root package name */
    public final int f20251b;

    /* renamed from: c  reason: collision with root package name */
    public final int f20252c;

    /* renamed from: y9.a$a  reason: collision with other inner class name */
    public static final class C0298a {
        public C0298a() {
        }

        public /* synthetic */ C0298a(g gVar) {
            this();
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i12 != Integer.MIN_VALUE) {
            this.f20250a = i10;
            this.f20251b = c.b(i10, i11, i12);
            this.f20252c = i12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f20250a;
    }

    public final int b() {
        return this.f20251b;
    }

    public final int c() {
        return this.f20252c;
    }

    /* renamed from: d */
    public w iterator() {
        return new b(this.f20250a, this.f20251b, this.f20252c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.f20250a == aVar.f20250a && this.f20251b == aVar.f20251b && this.f20252c == aVar.f20252c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f20250a * 31) + this.f20251b) * 31) + this.f20252c;
    }

    public boolean isEmpty() {
        if (this.f20252c > 0) {
            if (this.f20250a > this.f20251b) {
                return true;
            }
        } else if (this.f20250a < this.f20251b) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i10;
        StringBuilder sb;
        if (this.f20252c > 0) {
            sb = new StringBuilder();
            sb.append(this.f20250a);
            sb.append("..");
            sb.append(this.f20251b);
            sb.append(" step ");
            i10 = this.f20252c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f20250a);
            sb.append(" downTo ");
            sb.append(this.f20251b);
            sb.append(" step ");
            i10 = -this.f20252c;
        }
        sb.append(i10);
        return sb.toString();
    }
}
