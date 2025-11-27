package z8;

public final class m {

    /* renamed from: f  reason: collision with root package name */
    public static final b f20770f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final j2 f20771a;

    /* renamed from: b  reason: collision with root package name */
    public final d1 f20772b = e1.a();

    /* renamed from: c  reason: collision with root package name */
    public final d1 f20773c = e1.a();

    /* renamed from: d  reason: collision with root package name */
    public final d1 f20774d = e1.a();

    /* renamed from: e  reason: collision with root package name */
    public volatile long f20775e;

    public class a implements b {
        public m create() {
            return new m(j2.f20705a);
        }
    }

    public interface b {
        m create();
    }

    public m(j2 j2Var) {
        this.f20771a = j2Var;
    }

    public void a(boolean z10) {
        if (z10) {
            this.f20773c.add(1);
        } else {
            this.f20774d.add(1);
        }
    }

    public void b() {
        this.f20772b.add(1);
        this.f20775e = this.f20771a.a();
    }
}
