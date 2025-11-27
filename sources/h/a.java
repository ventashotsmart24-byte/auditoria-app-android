package h;

import java.util.concurrent.Executor;

public class a extends d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f6840c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f6841d = new C0086a();

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f6842e = new b();

    /* renamed from: a  reason: collision with root package name */
    public d f6843a;

    /* renamed from: b  reason: collision with root package name */
    public d f6844b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    public static class C0086a implements Executor {
        public void execute(Runnable runnable) {
            a.e().c(runnable);
        }
    }

    public static class b implements Executor {
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }

    public a() {
        c cVar = new c();
        this.f6844b = cVar;
        this.f6843a = cVar;
    }

    public static Executor d() {
        return f6842e;
    }

    public static a e() {
        if (f6840c != null) {
            return f6840c;
        }
        synchronized (a.class) {
            if (f6840c == null) {
                f6840c = new a();
            }
        }
        return f6840c;
    }

    public void a(Runnable runnable) {
        this.f6843a.a(runnable);
    }

    public boolean b() {
        return this.f6843a.b();
    }

    public void c(Runnable runnable) {
        this.f6843a.c(runnable);
    }
}
