package a0;

public class g extends f {

    /* renamed from: c  reason: collision with root package name */
    public final Object f77c = new Object();

    public g(int i10) {
        super(i10);
    }

    public Object acquire() {
        Object acquire;
        synchronized (this.f77c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    public boolean release(Object obj) {
        boolean release;
        synchronized (this.f77c) {
            release = super.release(obj);
        }
        return release;
    }
}
