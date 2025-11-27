package t9;

public final class n implements d {

    /* renamed from: a  reason: collision with root package name */
    public final Class f19595a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19596b;

    public n(Class cls, String str) {
        i.g(cls, "jClass");
        i.g(str, "moduleName");
        this.f19595a = cls;
        this.f19596b = str;
    }

    public Class a() {
        return this.f19595a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n) || !i.b(a(), ((n) obj).a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
