package z3;

import java.io.IOException;
import k3.m;
import k3.u;
import k3.v;
import t3.a;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final a f9956a;

    /* renamed from: b  reason: collision with root package name */
    public static final v f9957b;

    /* renamed from: c  reason: collision with root package name */
    public static final v f9958c;

    /* renamed from: d  reason: collision with root package name */
    public static final u f9959d;

    static {
        a aVar = new a();
        f9956a = aVar;
        f9957b = aVar.D();
        f9958c = aVar.D().k();
        f9959d = aVar.A(m.class);
    }

    public static String a(m mVar) {
        try {
            return f9957b.n(mVar);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
