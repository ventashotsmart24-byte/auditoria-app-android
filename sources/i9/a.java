package i9;

import java.util.Collection;
import s9.l;
import t9.f;
import t9.i;
import t9.j;

public abstract class a implements Collection, u9.a {

    /* renamed from: i9.a$a  reason: collision with other inner class name */
    public static final class C0228a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17399a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0228a(a aVar) {
            super(1);
            this.f17399a = aVar;
        }

        /* renamed from: b */
        public final CharSequence invoke(Object obj) {
            if (obj == this.f17399a) {
                return "(this Collection)";
            }
            return String.valueOf(obj);
        }
    }

    public abstract int a();

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
        if (isEmpty()) {
            return false;
        }
        for (Object b10 : this) {
            if (i.b(b10, obj)) {
                return true;
            }
        }
        return false;
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
        if (size() == 0) {
            return true;
        }
        return false;
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

    public Object[] toArray() {
        return f.a(this);
    }

    public String toString() {
        return r.y(this, ", ", "[", "]", 0, (CharSequence) null, new C0228a(this), 24, (Object) null);
    }

    public Object[] toArray(Object[] objArr) {
        i.g(objArr, "array");
        return f.b(this, objArr);
    }
}
