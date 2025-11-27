package j1;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f7068a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7069b;

    public g(String str, int i10) {
        this.f7068a = str;
        this.f7069b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f7069b != gVar.f7069b) {
            return false;
        }
        return this.f7068a.equals(gVar.f7068a);
    }

    public int hashCode() {
        return (this.f7068a.hashCode() * 31) + this.f7069b;
    }
}
