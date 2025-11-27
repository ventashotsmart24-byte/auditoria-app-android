package i9;

import java.util.Collection;
import t9.i;

public abstract class o extends n {
    public static final boolean n(Collection collection, Iterable iterable) {
        i.g(collection, "<this>");
        i.g(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z10 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z10 = true;
            }
        }
        return z10;
    }
}
