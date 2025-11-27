package r3;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class l implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public Map f9133a;

    public l() {
    }

    public l(Map map) {
        this.f9133a = map;
    }

    public j a(String str, Class[] clsArr) {
        Map map = this.f9133a;
        if (map == null) {
            return null;
        }
        return (j) map.get(new y(str, clsArr));
    }

    public Iterator iterator() {
        Map map = this.f9133a;
        if (map == null) {
            return Collections.emptyIterator();
        }
        return map.values().iterator();
    }
}
