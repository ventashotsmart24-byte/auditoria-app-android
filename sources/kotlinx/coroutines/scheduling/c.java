package kotlinx.coroutines.scheduling;

public final class c extends f {

    /* renamed from: i  reason: collision with root package name */
    public static final c f18332i = new c();

    public c() {
        super(l.f18344b, l.f18345c, l.f18346d, "DefaultDispatcher");
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
