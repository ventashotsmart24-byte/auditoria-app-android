package i9;

import java.util.Collection;
import java.util.Iterator;
import t9.b;
import t9.f;
import t9.i;
import u9.a;

public final class c implements Collection, a {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f17407a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f17408b;

    public c(Object[] objArr, boolean z10) {
        i.g(objArr, "values");
        this.f17407a = objArr;
        this.f17408b = z10;
    }

    public int a() {
        return this.f17407a.length;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return g.e(this.f17407a, obj);
    }

    public boolean containsAll(Collection collection) {
        i.g(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        if (this.f17407a.length == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return b.a(this.f17407a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return a();
    }

    public Object[] toArray(Object[] objArr) {
        i.g(objArr, "array");
        return f.b(this, objArr);
    }

    public final Object[] toArray() {
        return i.a(this.f17407a, this.f17408b);
    }
}
