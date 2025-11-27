package r3;

import c4.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import r3.t;

public class e0 implements t.a, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final t.a f9101a;

    /* renamed from: b  reason: collision with root package name */
    public Map f9102b;

    public e0(t.a aVar) {
        this.f9101a = aVar;
    }

    public Class a(Class cls) {
        Class cls2;
        Map map;
        t.a aVar = this.f9101a;
        if (aVar == null) {
            cls2 = null;
        } else {
            cls2 = aVar.a(cls);
        }
        if (cls2 != null || (map = this.f9102b) == null) {
            return cls2;
        }
        return (Class) map.get(new b(cls));
    }

    public void b(Class cls, Class cls2) {
        if (this.f9102b == null) {
            this.f9102b = new HashMap();
        }
        this.f9102b.put(new b(cls), cls2);
    }

    public boolean c() {
        if (this.f9102b != null) {
            return true;
        }
        t.a aVar = this.f9101a;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof e0) {
            return ((e0) aVar).c();
        }
        return true;
    }
}
