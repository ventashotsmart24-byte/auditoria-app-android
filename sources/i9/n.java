package i9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import t9.i;

public abstract class n extends m {
    public static final void l(List list) {
        i.g(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final void m(List list, Comparator comparator) {
        i.g(list, "<this>");
        i.g(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
