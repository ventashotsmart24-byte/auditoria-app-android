package m3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class j {
    public static j b() {
        return a.b();
    }

    public abstract Object a(Object obj);

    public abstract j c(Object obj, Object obj2);

    public static class a extends j implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f7870c = new a(Collections.emptyMap());

        /* renamed from: d  reason: collision with root package name */
        public static final Object f7871d = new Object();

        /* renamed from: a  reason: collision with root package name */
        public final Map f7872a;

        /* renamed from: b  reason: collision with root package name */
        public transient Map f7873b;

        public a(Map map) {
            this.f7872a = map;
            this.f7873b = null;
        }

        public static j b() {
            return f7870c;
        }

        public Object a(Object obj) {
            Object obj2;
            Map map = this.f7873b;
            if (map == null || (obj2 = map.get(obj)) == null) {
                return this.f7872a.get(obj);
            }
            if (obj2 == f7871d) {
                return null;
            }
            return obj2;
        }

        public j c(Object obj, Object obj2) {
            if (obj2 == null) {
                if (this.f7872a.containsKey(obj)) {
                    obj2 = f7871d;
                } else {
                    Map map = this.f7873b;
                    if (map != null && map.containsKey(obj)) {
                        this.f7873b.remove(obj);
                    }
                    return this;
                }
            }
            Map map2 = this.f7873b;
            if (map2 == null) {
                return d(obj, obj2);
            }
            map2.put(obj, obj2);
            return this;
        }

        public j d(Object obj, Object obj2) {
            HashMap hashMap = new HashMap();
            if (obj2 == null) {
                obj2 = f7871d;
            }
            hashMap.put(obj, obj2);
            return new a(this.f7872a, hashMap);
        }

        public a(Map map, Map map2) {
            this.f7872a = map;
            this.f7873b = map2;
        }
    }
}
