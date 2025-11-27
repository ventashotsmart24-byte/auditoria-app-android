package d4;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6288a;

    /* renamed from: b  reason: collision with root package name */
    public o f6289b;

    public o(Object obj, o oVar) {
        this.f6288a = obj;
        this.f6289b = oVar;
    }

    public void a(o oVar) {
        if (this.f6289b == null) {
            this.f6289b = oVar;
            return;
        }
        throw new IllegalStateException();
    }

    public o b() {
        return this.f6289b;
    }

    public Object c() {
        return this.f6288a;
    }
}
