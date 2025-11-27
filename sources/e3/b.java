package e3;

import c3.k;
import c3.l;

public abstract class b extends l {

    /* renamed from: b  reason: collision with root package name */
    public transient k f6472b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(k kVar, String str) {
        super(str, kVar == null ? null : kVar.z());
        this.f6472b = kVar;
    }

    /* renamed from: e */
    public k d() {
        return this.f6472b;
    }

    public String getMessage() {
        return super.getMessage();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(k kVar, String str, Throwable th) {
        super(str, kVar == null ? null : kVar.z(), th);
        this.f6472b = kVar;
    }
}
