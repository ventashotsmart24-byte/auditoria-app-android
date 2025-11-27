package i;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public c f6980a;

    /* renamed from: b  reason: collision with root package name */
    public c f6981b;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap f6982c = new WeakHashMap();

    /* renamed from: d  reason: collision with root package name */
    public int f6983d = 0;

    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        public c b(c cVar) {
            return cVar.f6987d;
        }

        public c c(c cVar) {
            return cVar.f6986c;
        }
    }

    /* renamed from: i.b$b  reason: collision with other inner class name */
    public static class C0089b extends e {
        public C0089b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        public c b(c cVar) {
            return cVar.f6986c;
        }

        public c c(c cVar) {
            return cVar.f6987d;
        }
    }

    public static class c implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6984a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f6985b;

        /* renamed from: c  reason: collision with root package name */
        public c f6986c;

        /* renamed from: d  reason: collision with root package name */
        public c f6987d;

        public c(Object obj, Object obj2) {
            this.f6984a = obj;
            this.f6985b = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f6984a.equals(cVar.f6984a) || !this.f6985b.equals(cVar.f6985b)) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return this.f6984a;
        }

        public Object getValue() {
            return this.f6985b;
        }

        public int hashCode() {
            return this.f6984a.hashCode() ^ this.f6985b.hashCode();
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f6984a + Operator.Operation.EQUALS + this.f6985b;
        }
    }

    public class d implements Iterator, f {

        /* renamed from: a  reason: collision with root package name */
        public c f6988a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6989b = true;

        public d() {
        }

        public void a(c cVar) {
            boolean z10;
            c cVar2 = this.f6988a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f6987d;
                this.f6988a = cVar3;
                if (cVar3 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f6989b = z10;
            }
        }

        /* renamed from: b */
        public Map.Entry next() {
            c cVar;
            if (this.f6989b) {
                this.f6989b = false;
                this.f6988a = b.this.f6980a;
            } else {
                c cVar2 = this.f6988a;
                if (cVar2 != null) {
                    cVar = cVar2.f6986c;
                } else {
                    cVar = null;
                }
                this.f6988a = cVar;
            }
            return this.f6988a;
        }

        public boolean hasNext() {
            if (!this.f6989b) {
                c cVar = this.f6988a;
                if (cVar == null || cVar.f6986c == null) {
                    return false;
                }
                return true;
            } else if (b.this.f6980a != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static abstract class e implements Iterator, f {

        /* renamed from: a  reason: collision with root package name */
        public c f6991a;

        /* renamed from: b  reason: collision with root package name */
        public c f6992b;

        public e(c cVar, c cVar2) {
            this.f6991a = cVar2;
            this.f6992b = cVar;
        }

        public void a(c cVar) {
            if (this.f6991a == cVar && cVar == this.f6992b) {
                this.f6992b = null;
                this.f6991a = null;
            }
            c cVar2 = this.f6991a;
            if (cVar2 == cVar) {
                this.f6991a = b(cVar2);
            }
            if (this.f6992b == cVar) {
                this.f6992b = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        /* renamed from: d */
        public Map.Entry next() {
            c cVar = this.f6992b;
            this.f6992b = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.f6992b;
            c cVar2 = this.f6991a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        public boolean hasNext() {
            if (this.f6992b != null) {
                return true;
            }
            return false;
        }
    }

    public interface f {
        void a(c cVar);
    }

    public Map.Entry a() {
        return this.f6980a;
    }

    public c b(Object obj) {
        c cVar = this.f6980a;
        while (cVar != null && !cVar.f6984a.equals(obj)) {
            cVar = cVar.f6986c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f6982c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry d() {
        return this.f6981b;
    }

    public Iterator descendingIterator() {
        C0089b bVar = new C0089b(this.f6981b, this.f6980a);
        this.f6982c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public c e(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f6983d++;
        c cVar2 = this.f6981b;
        if (cVar2 == null) {
            this.f6980a = cVar;
            this.f6981b = cVar;
            return cVar;
        }
        cVar2.f6986c = cVar;
        cVar.f6987d = cVar2;
        this.f6981b = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public Object f(Object obj, Object obj2) {
        c b10 = b(obj);
        if (b10 != null) {
            return b10.f6985b;
        }
        e(obj, obj2);
        return null;
    }

    public Object g(Object obj) {
        c b10 = b(obj);
        if (b10 == null) {
            return null;
        }
        this.f6983d--;
        if (!this.f6982c.isEmpty()) {
            for (f a10 : this.f6982c.keySet()) {
                a10.a(b10);
            }
        }
        c cVar = b10.f6987d;
        if (cVar != null) {
            cVar.f6986c = b10.f6986c;
        } else {
            this.f6980a = b10.f6986c;
        }
        c cVar2 = b10.f6986c;
        if (cVar2 != null) {
            cVar2.f6987d = cVar;
        } else {
            this.f6981b = cVar;
        }
        b10.f6986c = null;
        b10.f6987d = null;
        return b10.f6985b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Map.Entry) it.next()).hashCode();
        }
        return i10;
    }

    public Iterator iterator() {
        a aVar = new a(this.f6980a, this.f6981b);
        this.f6982c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f6983d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
