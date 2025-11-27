package f1;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6534a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6535b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6536c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6537d;

    public b(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f6534a = z10;
        this.f6535b = z11;
        this.f6536c = z12;
        this.f6537d = z13;
    }

    public boolean a() {
        return this.f6534a;
    }

    public boolean b() {
        return this.f6536c;
    }

    public boolean c() {
        return this.f6537d;
    }

    public boolean d() {
        return this.f6535b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f6534a == bVar.f6534a && this.f6535b == bVar.f6535b && this.f6536c == bVar.f6536c && this.f6537d == bVar.f6537d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f6534a;
        if (this.f6535b) {
            i10 += 16;
        }
        if (this.f6536c) {
            i10 += 256;
        }
        if (this.f6537d) {
            return i10 + 4096;
        }
        return i10;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.f6534a), Boolean.valueOf(this.f6535b), Boolean.valueOf(this.f6536c), Boolean.valueOf(this.f6537d)});
    }
}
