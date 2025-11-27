package y8;

public class m1 extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public final k1 f20098a;

    /* renamed from: b  reason: collision with root package name */
    public final v0 f20099b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f20100c;

    public m1(k1 k1Var) {
        this(k1Var, (v0) null);
    }

    public final k1 a() {
        return this.f20098a;
    }

    public final v0 b() {
        return this.f20099b;
    }

    public synchronized Throwable fillInStackTrace() {
        Throwable th;
        if (this.f20100c) {
            th = super.fillInStackTrace();
        } else {
            th = this;
        }
        return th;
    }

    public m1(k1 k1Var, v0 v0Var) {
        this(k1Var, v0Var, true);
    }

    public m1(k1 k1Var, v0 v0Var, boolean z10) {
        super(k1.h(k1Var), k1Var.m());
        this.f20098a = k1Var;
        this.f20099b = v0Var;
        this.f20100c = z10;
        fillInStackTrace();
    }
}
