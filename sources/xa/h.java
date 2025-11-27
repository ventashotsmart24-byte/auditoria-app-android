package xa;

import java.util.ArrayList;
import java.util.List;

public final class h {

    /* renamed from: d  reason: collision with root package name */
    public static final List f9772d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Object f9773a;

    /* renamed from: b  reason: collision with root package name */
    public n f9774b;

    /* renamed from: c  reason: collision with root package name */
    public h f9775c;

    public h(Object obj, n nVar) {
        this.f9773a = obj;
        this.f9774b = nVar;
    }

    public static h a(n nVar, Object obj) {
        List list = f9772d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new h(obj, nVar);
            }
            h hVar = (h) list.remove(size - 1);
            hVar.f9773a = obj;
            hVar.f9774b = nVar;
            hVar.f9775c = null;
            return hVar;
        }
    }

    public static void b(h hVar) {
        hVar.f9773a = null;
        hVar.f9774b = null;
        hVar.f9775c = null;
        List list = f9772d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(hVar);
            }
        }
    }
}
