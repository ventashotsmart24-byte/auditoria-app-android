package z8;

import com.google.common.base.Preconditions;
import y8.b;
import y8.c;
import y8.k;
import y8.k1;
import y8.r;
import y8.v0;
import y8.w0;

public final class m1 extends b.a {

    /* renamed from: a  reason: collision with root package name */
    public final s f20777a;

    /* renamed from: b  reason: collision with root package name */
    public final w0 f20778b;

    /* renamed from: c  reason: collision with root package name */
    public final v0 f20779c;

    /* renamed from: d  reason: collision with root package name */
    public final c f20780d;

    /* renamed from: e  reason: collision with root package name */
    public final r f20781e;

    /* renamed from: f  reason: collision with root package name */
    public final a f20782f;

    /* renamed from: g  reason: collision with root package name */
    public final k[] f20783g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f20784h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public q f20785i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20786j;

    /* renamed from: k  reason: collision with root package name */
    public b0 f20787k;

    public interface a {
        void onComplete();
    }

    public m1(s sVar, w0 w0Var, v0 v0Var, c cVar, a aVar, k[] kVarArr) {
        this.f20777a = sVar;
        this.f20778b = w0Var;
        this.f20779c = v0Var;
        this.f20780d = cVar;
        this.f20781e = r.e();
        this.f20782f = aVar;
        this.f20783g = kVarArr;
    }

    public void a(k1 k1Var) {
        Preconditions.checkArgument(!k1Var.p(), "Cannot fail with OK status");
        Preconditions.checkState(!this.f20786j, "apply() or fail() already called");
        b(new f0(q0.n(k1Var), this.f20783g));
    }

    public final void b(q qVar) {
        boolean z10;
        boolean z11 = true;
        Preconditions.checkState(!this.f20786j, "already finalized");
        this.f20786j = true;
        synchronized (this.f20784h) {
            if (this.f20785i == null) {
                this.f20785i = qVar;
                z10 = true;
            } else {
                z10 = false;
            }
        }
        if (z10) {
            this.f20782f.onComplete();
            return;
        }
        if (this.f20787k == null) {
            z11 = false;
        }
        Preconditions.checkState(z11, "delayedStream is null");
        Runnable w10 = this.f20787k.w(qVar);
        if (w10 != null) {
            w10.run();
        }
        this.f20782f.onComplete();
    }

    public q c() {
        synchronized (this.f20784h) {
            q qVar = this.f20785i;
            if (qVar != null) {
                return qVar;
            }
            b0 b0Var = new b0();
            this.f20787k = b0Var;
            this.f20785i = b0Var;
            return b0Var;
        }
    }
}
