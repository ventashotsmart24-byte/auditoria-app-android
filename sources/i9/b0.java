package i9;

import java.util.Set;
import t9.i;

public abstract class b0 extends a0 {
    public static final Set b() {
        return v.f17414a;
    }

    public static final Set c(Set set) {
        i.g(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return b();
        }
        if (size != 1) {
            return set;
        }
        return a0.a(set.iterator().next());
    }
}
