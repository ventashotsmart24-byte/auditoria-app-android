package y8;

public class l1 extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final k1 f20088a;

    /* renamed from: b  reason: collision with root package name */
    public final v0 f20089b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f20090c;

    public l1(k1 k1Var) {
        this(k1Var, (v0) null);
    }

    public final k1 a() {
        return this.f20088a;
    }

    public final v0 b() {
        return this.f20089b;
    }

    public synchronized Throwable fillInStackTrace() {
        Throwable th;
        if (this.f20090c) {
            th = super.fillInStackTrace();
        } else {
            th = this;
        }
        return th;
    }

    public l1(k1 k1Var, v0 v0Var) {
        this(k1Var, v0Var, true);
    }

    public l1(k1 k1Var, v0 v0Var, boolean z10) {
        super(k1.h(k1Var), k1Var.m());
        this.f20088a = k1Var;
        this.f20089b = v0Var;
        this.f20090c = z10;
        fillInStackTrace();
    }
}
