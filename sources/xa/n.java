package xa;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Object f9800a;

    /* renamed from: b  reason: collision with root package name */
    public final l f9801b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f9802c = true;

    public n(Object obj, l lVar) {
        this.f9800a = obj;
        this.f9801b = lVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f9800a != nVar.f9800a || !this.f9801b.equals(nVar.f9801b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f9800a.hashCode() + this.f9801b.f9787f.hashCode();
    }
}
