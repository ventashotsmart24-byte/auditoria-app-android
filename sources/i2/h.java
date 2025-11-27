package i2;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f7019a = new h();

    /* renamed from: b  reason: collision with root package name */
    public static final String f7020b = "BBVariable";

    /* renamed from: c  reason: collision with root package name */
    public static long f7021c;

    public final long a() {
        if (f7021c == 0) {
            f7021c = i.f7022a.a();
            long longValue = ((Number) e.f7014b.a().b("server_time", 0L)).longValue();
            if (f7021c < longValue) {
                f7021c = longValue;
            }
        }
        return f7021c;
    }

    public final void b(long j10) {
        f7021c = j10;
    }
}
