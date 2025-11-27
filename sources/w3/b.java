package w3;

import java.io.Serializable;
import java.util.Objects;

public final class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Class f9501a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9502b;

    /* renamed from: c  reason: collision with root package name */
    public String f9503c;

    public b(Class cls) {
        this(cls, (String) null);
    }

    public String a() {
        return this.f9503c;
    }

    public Class b() {
        return this.f9501a;
    }

    public boolean c() {
        if (this.f9503c != null) {
            return true;
        }
        return false;
    }

    public void d(String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        this.f9503c = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f9501a != bVar.f9501a || !Objects.equals(this.f9503c, bVar.f9503c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f9502b;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[NamedType, class ");
        sb.append(this.f9501a.getName());
        sb.append(", name: ");
        if (this.f9503c == null) {
            str = "null";
        } else {
            str = "'" + this.f9503c + "'";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public b(Class cls, String str) {
        this.f9501a = cls;
        this.f9502b = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        d(str);
    }
}
