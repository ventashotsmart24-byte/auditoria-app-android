package z8;

import com.google.common.base.Preconditions;
import java.util.Map;
import y8.k1;
import y8.y0;

public final class z1 extends y0.f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f21228a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21229b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21230c;

    /* renamed from: d  reason: collision with root package name */
    public final j f21231d;

    public z1(boolean z10, int i10, int i11, j jVar) {
        this.f21228a = z10;
        this.f21229b = i10;
        this.f21230c = i11;
        this.f21231d = (j) Preconditions.checkNotNull(jVar, "autoLoadBalancerFactory");
    }

    public y0.b a(Map map) {
        Object obj;
        try {
            y0.b f10 = this.f21231d.f(map);
            if (f10 == null) {
                obj = null;
            } else if (f10.d() != null) {
                return y0.b.b(f10.d());
            } else {
                obj = f10.c();
            }
            return y0.b.a(i1.b(map, this.f21228a, this.f21229b, this.f21230c, obj));
        } catch (RuntimeException e10) {
            return y0.b.b(k1.f20043h.r("failed to parse service config").q(e10));
        }
    }
}
