package d4;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class n implements p, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final transient int f6286a;

    /* renamed from: b  reason: collision with root package name */
    public final transient ConcurrentHashMap f6287b;

    public n(int i10, int i11) {
        this.f6287b = new ConcurrentHashMap(i10, 0.8f, 4);
        this.f6286a = i11;
    }

    public Object a(Object obj, Object obj2) {
        if (this.f6287b.size() >= this.f6286a) {
            synchronized (this) {
                if (this.f6287b.size() >= this.f6286a) {
                    clear();
                }
            }
        }
        return this.f6287b.put(obj, obj2);
    }

    public void clear() {
        this.f6287b.clear();
    }

    public Object get(Object obj) {
        return this.f6287b.get(obj);
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        if (this.f6287b.size() >= this.f6286a) {
            synchronized (this) {
                if (this.f6287b.size() >= this.f6286a) {
                    clear();
                }
            }
        }
        return this.f6287b.putIfAbsent(obj, obj2);
    }
}
