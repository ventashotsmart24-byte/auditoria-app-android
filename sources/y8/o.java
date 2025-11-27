package y8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import y8.l;

public final class o {

    /* renamed from: b  reason: collision with root package name */
    public static final o f20101b = new o(new l.a(), l.b.f20085a);

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap f20102a = new ConcurrentHashMap();

    public o(n... nVarArr) {
        for (n nVar : nVarArr) {
            this.f20102a.put(nVar.a(), nVar);
        }
    }

    public static o a() {
        return f20101b;
    }

    public n b(String str) {
        return (n) this.f20102a.get(str);
    }
}
