package ca;

import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.z;

public abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11502a = z.e("kotlinx.coroutines.main.delay", false);

    /* renamed from: b  reason: collision with root package name */
    public static final j0 f11503b = b();

    public static final j0 a() {
        return f11503b;
    }

    public static final j0 b() {
        if (!f11502a) {
            return h0.f11500h;
        }
        p1 c10 = n0.c();
        if (s.c(c10) || !(c10 instanceof j0)) {
            return h0.f11500h;
        }
        return (j0) c10;
    }
}
