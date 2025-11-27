package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a extends g implements Map {
    f mCollections;

    /* renamed from: androidx.collection.a$a  reason: collision with other inner class name */
    public class C0019a extends f {
        public C0019a() {
        }

        public void a() {
            a.this.clear();
        }

        public Object b(int i10, int i11) {
            return a.this.mArray[(i10 << 1) + i11];
        }

        public Map c() {
            return a.this;
        }

        public int d() {
            return a.this.mSize;
        }

        public int e(Object obj) {
            return a.this.indexOfKey(obj);
        }

        public int f(Object obj) {
            return a.this.indexOfValue(obj);
        }

        public void g(Object obj, Object obj2) {
            a.this.put(obj, obj2);
        }

        public void h(int i10) {
            a.this.removeAt(i10);
        }

        public Object i(int i10, Object obj) {
            return a.this.setValueAt(i10, obj);
        }
    }

    public a() {
    }

    public boolean containsAll(Collection<?> collection) {
        return f.j(this, collection);
    }

    public final f d() {
        if (this.mCollections == null) {
            this.mCollections = new C0019a();
        }
        return this.mCollections;
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return d().l();
    }

    public Set<Object> keySet() {
        return d().m();
    }

    public void putAll(Map<Object, Object> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return f.o(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return f.p(this, collection);
    }

    public Collection<Object> values() {
        return d().n();
    }

    public a(int i10) {
        super(i10);
    }

    public a(g gVar) {
        super(gVar);
    }
}
