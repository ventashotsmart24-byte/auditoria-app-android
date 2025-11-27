package i9;

import com.google.firebase.analytics.FirebaseAnalytics;
import h9.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import t9.i;

public abstract class z extends y {
    public static final Map d() {
        u uVar = u.f17413a;
        i.e(uVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return uVar;
    }

    public static final Map e(Map map) {
        i.g(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return map;
        }
        return y.c(map);
    }

    public static final void f(Map map, Iterable iterable) {
        i.g(map, "<this>");
        i.g(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            map.put(kVar.a(), kVar.b());
        }
    }

    public static final Map g(Iterable iterable) {
        Object obj;
        i.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return h(iterable, new LinkedHashMap(y.a(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return y.b((k) obj);
    }

    public static final Map h(Iterable iterable, Map map) {
        i.g(iterable, "<this>");
        i.g(map, FirebaseAnalytics.Param.DESTINATION);
        f(map, iterable);
        return map;
    }
}
