package i;

import i.b;
import java.util.HashMap;
import java.util.Map;

public class a extends b {

    /* renamed from: e  reason: collision with root package name */
    public HashMap f6979e = new HashMap();

    public b.c b(Object obj) {
        return (b.c) this.f6979e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f6979e.containsKey(obj);
    }

    public Object f(Object obj, Object obj2) {
        b.c b10 = b(obj);
        if (b10 != null) {
            return b10.f6985b;
        }
        this.f6979e.put(obj, e(obj, obj2));
        return null;
    }

    public Object g(Object obj) {
        Object g10 = super.g(obj);
        this.f6979e.remove(obj);
        return g10;
    }

    public Map.Entry h(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f6979e.get(obj)).f6987d;
        }
        return null;
    }
}
