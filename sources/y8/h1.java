package y8;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    public final i1 f20012a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f20013b;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f20014a;

        /* renamed from: b  reason: collision with root package name */
        public final i1 f20015b;

        /* renamed from: c  reason: collision with root package name */
        public final Map f20016c;

        public b a(w0 w0Var, f1 f1Var) {
            return b(g1.a((w0) Preconditions.checkNotNull(w0Var, "method must not be null"), (f1) Preconditions.checkNotNull(f1Var, "handler must not be null")));
        }

        public b b(g1 g1Var) {
            w0 b10 = g1Var.b();
            Preconditions.checkArgument(this.f20014a.equals(b10.d()), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", (Object) this.f20014a, (Object) b10.c());
            String c10 = b10.c();
            Preconditions.checkState(!this.f20016c.containsKey(c10), "Method by same name already registered: %s", (Object) c10);
            this.f20016c.put(c10, g1Var);
            return this;
        }

        public h1 c() {
            i1 i1Var = this.f20015b;
            if (i1Var == null) {
                ArrayList arrayList = new ArrayList(this.f20016c.size());
                for (g1 b10 : this.f20016c.values()) {
                    arrayList.add(b10.b());
                }
                i1Var = new i1(this.f20014a, (Collection) arrayList);
            }
            HashMap hashMap = new HashMap(this.f20016c);
            for (w0 w0Var : i1Var.a()) {
                g1 g1Var = (g1) hashMap.remove(w0Var.c());
                if (g1Var == null) {
                    throw new IllegalStateException("No method bound for descriptor entry " + w0Var.c());
                } else if (g1Var.b() != w0Var) {
                    throw new IllegalStateException("Bound method for " + w0Var.c() + " not same instance as method in service descriptor");
                }
            }
            if (hashMap.size() <= 0) {
                return new h1(i1Var, this.f20016c);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((g1) hashMap.values().iterator().next()).b().c());
        }

        public b(i1 i1Var) {
            this.f20016c = new HashMap();
            this.f20015b = (i1) Preconditions.checkNotNull(i1Var, "serviceDescriptor");
            this.f20014a = i1Var.b();
        }
    }

    public static b a(i1 i1Var) {
        return new b(i1Var);
    }

    public h1(i1 i1Var, Map map) {
        this.f20012a = (i1) Preconditions.checkNotNull(i1Var, "serviceDescriptor");
        this.f20013b = Collections.unmodifiableMap(new HashMap(map));
    }
}
