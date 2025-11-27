package androidx.collection;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public b f1549a;

    /* renamed from: b  reason: collision with root package name */
    public c f1550b;

    /* renamed from: c  reason: collision with root package name */
    public e f1551c;

    public final class a implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        public final int f1552a;

        /* renamed from: b  reason: collision with root package name */
        public int f1553b;

        /* renamed from: c  reason: collision with root package name */
        public int f1554c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1555d = false;

        public a(int i10) {
            this.f1552a = i10;
            this.f1553b = f.this.d();
        }

        public boolean hasNext() {
            if (this.f1554c < this.f1553b) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                Object b10 = f.this.b(this.f1554c, this.f1552a);
                this.f1554c++;
                this.f1555d = true;
                return b10;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1555d) {
                int i10 = this.f1554c - 1;
                this.f1554c = i10;
                this.f1553b--;
                this.f1555d = false;
                f.this.h(i10);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final class b implements Set {
        public b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            int d10 = f.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                f.this.g(entry.getKey(), entry.getValue());
            }
            if (d10 != f.this.d()) {
                return true;
            }
            return false;
        }

        public void clear() {
            f.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e10 = f.this.e(entry.getKey());
            if (e10 < 0) {
                return false;
            }
            return c.c(f.this.b(e10, 1), entry.getValue());
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12 = 0;
            for (int d10 = f.this.d() - 1; d10 >= 0; d10--) {
                Object b10 = f.this.b(d10, 0);
                Object b11 = f.this.b(d10, 1);
                if (b10 == null) {
                    i10 = 0;
                } else {
                    i10 = b10.hashCode();
                }
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                i12 += i10 ^ i11;
            }
            return i12;
        }

        public boolean isEmpty() {
            if (f.this.d() == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return f.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c implements Set {
        public c() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.a();
        }

        public boolean contains(Object obj) {
            if (f.this.e(obj) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection collection) {
            return f.j(f.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return f.k(this, obj);
        }

        public int hashCode() {
            int i10;
            int i11 = 0;
            for (int d10 = f.this.d() - 1; d10 >= 0; d10--) {
                Object b10 = f.this.b(d10, 0);
                if (b10 == null) {
                    i10 = 0;
                } else {
                    i10 = b10.hashCode();
                }
                i11 += i10;
            }
            return i11;
        }

        public boolean isEmpty() {
            if (f.this.d() == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int e10 = f.this.e(obj);
            if (e10 < 0) {
                return false;
            }
            f.this.h(e10);
            return true;
        }

        public boolean removeAll(Collection collection) {
            return f.o(f.this.c(), collection);
        }

        public boolean retainAll(Collection collection) {
            return f.p(f.this.c(), collection);
        }

        public int size() {
            return f.this.d();
        }

        public Object[] toArray() {
            return f.this.q(0);
        }

        public Object[] toArray(Object[] objArr) {
            return f.this.r(objArr, 0);
        }
    }

    public final class d implements Iterator, Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        public int f1559a;

        /* renamed from: b  reason: collision with root package name */
        public int f1560b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1561c = false;

        public d() {
            this.f1559a = f.this.d() - 1;
            this.f1560b = -1;
        }

        /* renamed from: a */
        public Map.Entry next() {
            if (hasNext()) {
                this.f1560b++;
                this.f1561c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f1561c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!c.c(entry.getKey(), f.this.b(this.f1560b, 0)) || !c.c(entry.getValue(), f.this.b(this.f1560b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public Object getKey() {
            if (this.f1561c) {
                return f.this.b(this.f1560b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if (this.f1561c) {
                return f.this.b(this.f1560b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            if (this.f1560b < this.f1559a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            if (this.f1561c) {
                int i11 = 0;
                Object b10 = f.this.b(this.f1560b, 0);
                Object b11 = f.this.b(this.f1560b, 1);
                if (b10 == null) {
                    i10 = 0;
                } else {
                    i10 = b10.hashCode();
                }
                if (b11 != null) {
                    i11 = b11.hashCode();
                }
                return i10 ^ i11;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f1561c) {
                f.this.h(this.f1560b);
                this.f1560b--;
                this.f1559a--;
                this.f1561c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public Object setValue(Object obj) {
            if (this.f1561c) {
                return f.this.i(this.f1560b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + Operator.Operation.EQUALS + getValue();
        }
    }

    public final class e implements Collection {
        public e() {
        }

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            f.this.a();
        }

        public boolean contains(Object obj) {
            if (f.this.f(obj) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            if (f.this.d() == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int f10 = f.this.f(obj);
            if (f10 < 0) {
                return false;
            }
            f.this.h(f10);
            return true;
        }

        public boolean removeAll(Collection collection) {
            int d10 = f.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < d10) {
                if (collection.contains(f.this.b(i10, 1))) {
                    f.this.h(i10);
                    i10--;
                    d10--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        public boolean retainAll(Collection collection) {
            int d10 = f.this.d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < d10) {
                if (!collection.contains(f.this.b(i10, 1))) {
                    f.this.h(i10);
                    i10--;
                    d10--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        public int size() {
            return f.this.d();
        }

        public Object[] toArray() {
            return f.this.q(1);
        }

        public Object[] toArray(Object[] objArr) {
            return f.this.r(objArr, 1);
        }
    }

    public static boolean j(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public abstract void a();

    public abstract Object b(int i10, int i11);

    public abstract Map c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(Object obj, Object obj2);

    public abstract void h(int i10);

    public abstract Object i(int i10, Object obj);

    public Set l() {
        if (this.f1549a == null) {
            this.f1549a = new b();
        }
        return this.f1549a;
    }

    public Set m() {
        if (this.f1550b == null) {
            this.f1550b = new c();
        }
        return this.f1550b;
    }

    public Collection n() {
        if (this.f1551c == null) {
            this.f1551c = new e();
        }
        return this.f1551c;
    }

    public Object[] q(int i10) {
        int d10 = d();
        Object[] objArr = new Object[d10];
        for (int i11 = 0; i11 < d10; i11++) {
            objArr[i11] = b(i11, i10);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i10) {
        int d10 = d();
        if (objArr.length < d10) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d10);
        }
        for (int i11 = 0; i11 < d10; i11++) {
            objArr[i11] = b(i11, i10);
        }
        if (objArr.length > d10) {
            objArr[d10] = null;
        }
        return objArr;
    }
}
