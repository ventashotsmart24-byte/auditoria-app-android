package t9;

import z9.b;
import z9.c;
import z9.d;
import z9.e;
import z9.f;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    public static final y f9394a;

    /* renamed from: b  reason: collision with root package name */
    public static final b[] f9395b = new b[0];

    static {
        y yVar = null;
        try {
            yVar = (y) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (yVar == null) {
            yVar = new y();
        }
        f9394a = yVar;
    }

    public static b a(Class cls) {
        return f9394a.a(cls);
    }

    public static c b(Class cls) {
        return f9394a.b(cls, "");
    }

    public static d c(k kVar) {
        return f9394a.c(kVar);
    }

    public static e d(o oVar) {
        return f9394a.d(oVar);
    }

    public static f e(q qVar) {
        return f9394a.e(qVar);
    }

    public static String f(h hVar) {
        return f9394a.f(hVar);
    }

    public static String g(j jVar) {
        return f9394a.g(jVar);
    }
}
