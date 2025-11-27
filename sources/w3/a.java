package w3;

import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import k3.j;
import m3.m;
import w3.c;

public class a extends c {

    /* renamed from: w3.a$a  reason: collision with other inner class name */
    public static final class C0128a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0128a f9499b = new C0128a();

        /* renamed from: a  reason: collision with root package name */
        public final Set f9500a;

        public C0128a() {
            HashSet hashSet = new HashSet();
            this.f9500a = hashSet;
            hashSet.add(Object.class.getName());
            hashSet.add(Closeable.class.getName());
            hashSet.add(Serializable.class.getName());
            hashSet.add(AutoCloseable.class.getName());
            hashSet.add(Cloneable.class.getName());
            hashSet.add("java.util.logging.Handler");
            hashSet.add("javax.naming.Referenceable");
            hashSet.add("javax.sql.DataSource");
        }

        public boolean a(Class cls) {
            return this.f9500a.contains(cls.getName());
        }
    }

    public c.b a(m mVar, j jVar) {
        if (e(mVar, jVar)) {
            return c.b.DENIED;
        }
        return c.b.INDETERMINATE;
    }

    public c.b b(m mVar, j jVar, String str) {
        return c.b.INDETERMINATE;
    }

    public c.b c(m mVar, j jVar, j jVar2) {
        if (d(mVar, jVar, jVar2)) {
            return c.b.ALLOWED;
        }
        return c.b.DENIED;
    }

    public boolean d(m mVar, j jVar, j jVar2) {
        return true;
    }

    public boolean e(m mVar, j jVar) {
        return C0128a.f9499b.a(jVar.q());
    }
}
