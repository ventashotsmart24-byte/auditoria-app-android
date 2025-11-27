package kotlinx.coroutines.internal;

import aa.e;
import aa.g;
import ca.p1;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f18295a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f18296b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final p1 f18297c;

    static {
        r rVar = new r();
        f18295a = rVar;
        z.e("kotlinx.coroutines.fast.service.loader", true);
        f18297c = rVar.a();
    }

    public final p1 a() {
        List list;
        Object obj;
        p1 e10;
        Class<q> cls = q.class;
        try {
            if (f18296b) {
                list = h.f18271a.c();
            } else {
                list = g.f(e.a(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            }
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int c10 = ((q) obj).c();
                    do {
                        Object next = it.next();
                        int c11 = ((q) next).c();
                        if (c10 < c11) {
                            obj = next;
                            c10 = c11;
                        }
                    } while (it.hasNext());
                }
            }
            q qVar = (q) obj;
            if (qVar == null || (e10 = s.e(qVar, list)) == null) {
                return s.b((Throwable) null, (String) null, 3, (Object) null);
            }
            return e10;
        } catch (Throwable th) {
            return s.b(th, (String) null, 2, (Object) null);
        }
    }
}
