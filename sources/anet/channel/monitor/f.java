package anet.channel.monitor;

public class f {

    /* renamed from: a  reason: collision with root package name */
    boolean f3778a = false;

    /* renamed from: b  reason: collision with root package name */
    protected long f3779b;

    /* renamed from: c  reason: collision with root package name */
    private final double f3780c = 40.0d;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3781d = true;

    public int a() {
        return 0;
    }

    public final boolean b() {
        if (!this.f3781d) {
            return false;
        }
        if (System.currentTimeMillis() - this.f3779b <= ((long) (a() * 1000))) {
            return true;
        }
        this.f3781d = false;
        return false;
    }

    public boolean a(double d10) {
        return d10 < 40.0d;
    }
}
