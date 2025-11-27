package ca;

public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    public static final w1 f11556a = new w1();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f11557b = new ThreadLocal();

    public final q0 a() {
        ThreadLocal threadLocal = f11557b;
        q0 q0Var = (q0) threadLocal.get();
        if (q0Var != null) {
            return q0Var;
        }
        q0 a10 = t0.a();
        threadLocal.set(a10);
        return a10;
    }

    public final void b() {
        f11557b.set((Object) null);
    }

    public final void c(q0 q0Var) {
        f11557b.set(q0Var);
    }
}
