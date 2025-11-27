package xa;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final i f9722a = new i();

    /* renamed from: b  reason: collision with root package name */
    public final c f9723b;

    public a(c cVar) {
        this.f9723b = cVar;
    }

    public void a(n nVar, Object obj) {
        this.f9722a.a(h.a(nVar, obj));
        this.f9723b.d().execute(this);
    }

    public void run() {
        h b10 = this.f9722a.b();
        if (b10 != null) {
            this.f9723b.f(b10);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
