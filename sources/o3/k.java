package o3;

import c3.i;
import com.fasterxml.jackson.databind.deser.std.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.f;
import k3.g;
import n3.w;

public abstract class k {

    public static class a extends w.a {

        /* renamed from: b  reason: collision with root package name */
        public static final a f8506b = new a();

        public a() {
            super(ArrayList.class);
        }

        public boolean j() {
            return true;
        }

        public boolean l() {
            return true;
        }

        public Object x(g gVar) {
            return new ArrayList();
        }
    }

    public static class b extends w.a {

        /* renamed from: b  reason: collision with root package name */
        public final Object f8507b;

        public b(Object obj) {
            super((Class) obj.getClass());
            this.f8507b = obj;
        }

        public boolean j() {
            return true;
        }

        public boolean l() {
            return true;
        }

        public Object x(g gVar) {
            return this.f8507b;
        }
    }

    public static class c extends w.a {

        /* renamed from: b  reason: collision with root package name */
        public static final c f8508b = new c();

        public c() {
            super(HashMap.class);
        }

        public boolean j() {
            return true;
        }

        public boolean l() {
            return true;
        }

        public Object x(g gVar) {
            return new HashMap();
        }
    }

    public static class d extends w.a {

        /* renamed from: b  reason: collision with root package name */
        public static final d f8509b = new d();

        public d() {
            super(LinkedHashMap.class);
        }

        public boolean j() {
            return true;
        }

        public boolean l() {
            return true;
        }

        public Object x(g gVar) {
            return new LinkedHashMap();
        }
    }

    public static w a(f fVar, Class cls) {
        if (cls == i.class) {
            return new q();
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (cls == ArrayList.class) {
                return a.f8506b;
            }
            Set set = Collections.EMPTY_SET;
            if (set.getClass() == cls) {
                return new b(set);
            }
            List list = Collections.EMPTY_LIST;
            if (list.getClass() == cls) {
                return new b(list);
            }
            return null;
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (cls == LinkedHashMap.class) {
                return d.f8509b;
            }
            if (cls == HashMap.class) {
                return c.f8508b;
            }
            if (Collections.EMPTY_MAP.getClass() == cls) {
                return new b(Collections.EMPTY_MAP);
            }
            return null;
        }
    }
}
