package i9;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import t9.g;
import t9.i;

public abstract class b extends a implements List {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17400a = new a((g) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            } else if (i10 > i11) {
                throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
            }
        }

        public final boolean d(Collection collection, Collection collection2) {
            i.g(collection, bt.aL);
            i.g(collection2, DispatchConstants.OTHER);
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            for (Object b10 : collection) {
                if (!i.b(b10, it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection collection) {
            int i10;
            i.g(collection, bt.aL);
            int i11 = 1;
            for (Object next : collection) {
                int i12 = i11 * 31;
                if (next != null) {
                    i10 = next.hashCode();
                } else {
                    i10 = 0;
                }
                i11 = i12 + i10;
            }
            return i11;
        }
    }

    /* renamed from: i9.b$b  reason: collision with other inner class name */
    public class C0229b implements Iterator, u9.a {

        /* renamed from: a  reason: collision with root package name */
        public int f17401a;

        public C0229b() {
        }

        public final int a() {
            return this.f17401a;
        }

        public final void b(int i10) {
            this.f17401a = i10;
        }

        public boolean hasNext() {
            if (this.f17401a < b.this.size()) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                b bVar = b.this;
                int i10 = this.f17401a;
                this.f17401a = i10 + 1;
                return bVar.get(i10);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends C0229b implements ListIterator {
        public c(int i10) {
            super();
            b.f17400a.b(i10, b.this.size());
            b(i10);
        }

        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean hasPrevious() {
            if (a() > 0) {
                return true;
            }
            return false;
        }

        public int nextIndex() {
            return a();
        }

        public Object previous() {
            if (hasPrevious()) {
                b bVar = b.this;
                b(a() - 1);
                return bVar.get(a());
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return a() - 1;
        }

        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d extends b implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        public final b f17404b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17405c;

        /* renamed from: d  reason: collision with root package name */
        public int f17406d;

        public d(b bVar, int i10, int i11) {
            i.g(bVar, "list");
            this.f17404b = bVar;
            this.f17405c = i10;
            b.f17400a.c(i10, i11, bVar.size());
            this.f17406d = i11 - i10;
        }

        public int a() {
            return this.f17406d;
        }

        public Object get(int i10) {
            b.f17400a.a(i10, this.f17406d);
            return this.f17404b.get(this.f17405c + i10);
        }
    }

    public void add(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f17400a.d(this, (Collection) obj);
    }

    public abstract Object get(int i10);

    public int hashCode() {
        return f17400a.e(this);
    }

    public int indexOf(Object obj) {
        int i10 = 0;
        for (Object b10 : this) {
            if (i.b(b10, obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public Iterator iterator() {
        return new C0229b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (i.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return new c(0);
    }

    public Object remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    public ListIterator listIterator(int i10) {
        return new c(i10);
    }
}
