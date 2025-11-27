package i9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import t9.i;
import y9.c;

public abstract class j extends i {
    public static final ArrayList c(Object... objArr) {
        i.g(objArr, "elements");
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new c(objArr, true));
    }

    public static final List d() {
        return t.f17412a;
    }

    public static final c e(Collection collection) {
        i.g(collection, "<this>");
        return new c(0, collection.size() - 1);
    }

    public static final int f(List list) {
        i.g(list, "<this>");
        return list.size() - 1;
    }

    public static final List g(Object... objArr) {
        i.g(objArr, "elements");
        if (objArr.length > 0) {
            return f.a(objArr);
        }
        return d();
    }

    public static final List h(Object... objArr) {
        i.g(objArr, "elements");
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new c(objArr, true));
    }

    public static final List i(List list) {
        i.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return list;
        }
        return i.b(list.get(0));
    }

    public static final void j() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
