package a0;

public class d {
    public final Object first;
    public final Object second;

    public d(Object obj, Object obj2) {
        this.first = obj;
        this.second = obj2;
    }

    public static <A, B> d create(A a10, B b10) {
        return new d(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.first, this.first) || !c.a(dVar.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Object obj = this.first;
        int i11 = 0;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        Object obj2 = this.second;
        if (obj2 != null) {
            i11 = obj2.hashCode();
        }
        return i10 ^ i11;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
