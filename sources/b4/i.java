package b4;

import b3.k0;
import c3.q;
import k3.j;
import k3.o;
import k3.x;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final j f4342a;

    /* renamed from: b  reason: collision with root package name */
    public final q f4343b;

    /* renamed from: c  reason: collision with root package name */
    public final k0 f4344c;

    /* renamed from: d  reason: collision with root package name */
    public final o f4345d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4346e;

    public i(j jVar, q qVar, k0 k0Var, o oVar, boolean z10) {
        this.f4342a = jVar;
        this.f4343b = qVar;
        this.f4344c = k0Var;
        this.f4345d = oVar;
        this.f4346e = z10;
    }

    public static i a(j jVar, x xVar, k0 k0Var, boolean z10) {
        String str;
        f3.i iVar = null;
        if (xVar == null) {
            str = null;
        } else {
            str = xVar.c();
        }
        if (str != null) {
            iVar = new f3.i(str);
        }
        return new i(jVar, iVar, k0Var, (o) null, z10);
    }

    public i b(boolean z10) {
        if (z10 == this.f4346e) {
            return this;
        }
        return new i(this.f4342a, this.f4343b, this.f4344c, this.f4345d, z10);
    }

    public i c(o oVar) {
        return new i(this.f4342a, this.f4343b, this.f4344c, oVar, this.f4346e);
    }
}
