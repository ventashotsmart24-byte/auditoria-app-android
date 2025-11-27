package kotlinx.coroutines.internal;

import h9.l;
import h9.m;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f18272a = false;

    static {
        Object obj;
        try {
            l.a aVar = l.f17317a;
            obj = l.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            l.a aVar2 = l.f17317a;
            obj = l.a(m.a(th));
        }
        l.d(obj);
    }

    public static final boolean a() {
        return f18272a;
    }
}
