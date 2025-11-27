package z8;

import com.google.common.base.MoreObjects;
import y8.c;
import y8.g;
import y8.r0;
import y8.w0;

public abstract class l0 extends r0 {

    /* renamed from: a  reason: collision with root package name */
    public final r0 f20752a;

    public l0(r0 r0Var) {
        this.f20752a = r0Var;
    }

    public String a() {
        return this.f20752a.a();
    }

    public g h(w0 w0Var, c cVar) {
        return this.f20752a.h(w0Var, cVar);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) this.f20752a).toString();
    }
}
