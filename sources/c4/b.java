package c4;

import java.io.Serializable;

public final class b implements Comparable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4811a;

    /* renamed from: b  reason: collision with root package name */
    public Class f4812b;

    /* renamed from: c  reason: collision with root package name */
    public int f4813c;

    public b(Class cls) {
        this.f4812b = cls;
        String name = cls.getName();
        this.f4811a = name;
        this.f4813c = name.hashCode();
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.f4811a.compareTo(bVar.f4811a);
    }

    public void b(Class cls) {
        this.f4812b = cls;
        String name = cls.getName();
        this.f4811a = name;
        this.f4813c = name.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == b.class && ((b) obj).f4812b == this.f4812b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f4813c;
    }

    public String toString() {
        return this.f4811a;
    }
}
