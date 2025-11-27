package z8;

import com.google.common.base.Preconditions;
import y8.k;
import y8.k1;
import y8.v0;
import z8.r;

public final class f0 extends n1 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f20497b;

    /* renamed from: c  reason: collision with root package name */
    public final k1 f20498c;

    /* renamed from: d  reason: collision with root package name */
    public final r.a f20499d;

    /* renamed from: e  reason: collision with root package name */
    public final k[] f20500e;

    public f0(k1 k1Var, k[] kVarArr) {
        this(k1Var, r.a.PROCESSED, kVarArr);
    }

    public void g(r rVar) {
        Preconditions.checkState(!this.f20497b, "already started");
        this.f20497b = true;
        for (k i10 : this.f20500e) {
            i10.i(this.f20498c);
        }
        rVar.c(this.f20498c, this.f20499d, new v0());
    }

    public void p(w0 w0Var) {
        w0Var.b("error", this.f20498c).b("progress", this.f20499d);
    }

    public f0(k1 k1Var, r.a aVar, k[] kVarArr) {
        Preconditions.checkArgument(!k1Var.p(), "error must not be OK");
        this.f20498c = k1Var;
        this.f20499d = aVar;
        this.f20500e = kVarArr;
    }
}
