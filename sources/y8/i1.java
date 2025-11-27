package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f20021a;

    /* renamed from: b  reason: collision with root package name */
    public final Collection f20022b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f20023c;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f20024a;

        /* renamed from: b  reason: collision with root package name */
        public List f20025b;

        /* renamed from: c  reason: collision with root package name */
        public Object f20026c;

        public final b e(Collection collection) {
            this.f20025b.addAll(collection);
            return this;
        }

        public b f(w0 w0Var) {
            this.f20025b.add((w0) Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD));
            return this;
        }

        public i1 g() {
            return new i1(this);
        }

        public b h(String str) {
            this.f20024a = (String) Preconditions.checkNotNull(str, "name");
            return this;
        }

        public b(String str) {
            this.f20025b = new ArrayList();
            h(str);
        }
    }

    public static b c(String str) {
        return new b(str);
    }

    public static void d(String str, Collection collection) {
        HashSet hashSet = new HashSet(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            w0 w0Var = (w0) it.next();
            Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD);
            String d10 = w0Var.d();
            Preconditions.checkArgument(str.equals(d10), "service names %s != %s", (Object) d10, (Object) str);
            Preconditions.checkArgument(hashSet.add(w0Var.c()), "duplicate name %s", (Object) w0Var.c());
        }
    }

    public Collection a() {
        return this.f20022b;
    }

    public String b() {
        return this.f20021a;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("name", (Object) this.f20021a).add("schemaDescriptor", this.f20023c).add("methods", (Object) this.f20022b).omitNullValues().toString();
    }

    public i1(String str, Collection collection) {
        this(c(str).e((Collection) Preconditions.checkNotNull(collection, "methods")));
    }

    public i1(b bVar) {
        String b10 = bVar.f20024a;
        this.f20021a = b10;
        d(b10, bVar.f20025b);
        this.f20022b = Collections.unmodifiableList(new ArrayList(bVar.f20025b));
        this.f20023c = bVar.f20026c;
    }
}
