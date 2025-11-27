package z8;

import com.google.common.base.Preconditions;
import y8.c;
import y8.i0;
import y8.k;
import y8.k1;
import y8.v0;
import y8.w0;
import z8.r;

public class g0 implements s {

    /* renamed from: a  reason: collision with root package name */
    public final k1 f20636a;

    /* renamed from: b  reason: collision with root package name */
    public final r.a f20637b;

    public g0(k1 k1Var, r.a aVar) {
        Preconditions.checkArgument(!k1Var.p(), "error must not be OK");
        this.f20636a = k1Var;
        this.f20637b = aVar;
    }

    public q b(w0 w0Var, v0 v0Var, c cVar, k[] kVarArr) {
        return new f0(this.f20636a, this.f20637b, kVarArr);
    }

    public i0 d() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
