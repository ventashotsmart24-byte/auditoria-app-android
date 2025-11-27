package y8;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.j1;
import y8.y0;
import z8.d0;

public final class a1 {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f19931e = Logger.getLogger(a1.class.getName());

    /* renamed from: f  reason: collision with root package name */
    public static a1 f19932f;

    /* renamed from: a  reason: collision with root package name */
    public final y0.c f19933a = new b();

    /* renamed from: b  reason: collision with root package name */
    public String f19934b = "unknown";

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashSet f19935c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    public ImmutableMap f19936d = ImmutableMap.of();

    public final class b extends y0.c {
        public b() {
        }

        public String a() {
            String a10;
            synchronized (a1.this) {
                a10 = a1.this.f19934b;
            }
            return a10;
        }

        public y0 b(URI uri, y0.a aVar) {
            z0 z0Var = (z0) a1.this.f().get(uri.getScheme());
            if (z0Var == null) {
                return null;
            }
            return z0Var.b(uri, aVar);
        }
    }

    public static final class c implements j1.b {
        public c() {
        }

        /* renamed from: c */
        public int b(z0 z0Var) {
            return z0Var.e();
        }

        /* renamed from: d */
        public boolean a(z0 z0Var) {
            return z0Var.d();
        }
    }

    public static synchronized a1 d() {
        a1 a1Var;
        synchronized (a1.class) {
            if (f19932f == null) {
                List<z0> e10 = j1.e(z0.class, e(), z0.class.getClassLoader(), new c());
                if (e10.isEmpty()) {
                    f19931e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                f19932f = new a1();
                for (z0 z0Var : e10) {
                    Logger logger = f19931e;
                    logger.fine("Service loader found " + z0Var);
                    f19932f.b(z0Var);
                }
                f19932f.g();
            }
            a1Var = f19932f;
        }
        return a1Var;
    }

    public static List e() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(d0.class);
        } catch (ClassNotFoundException e10) {
            f19931e.log(Level.FINE, "Unable to find DNS NameResolver", e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void b(z0 z0Var) {
        Preconditions.checkArgument(z0Var.d(), "isAvailable() returned false");
        this.f19935c.add(z0Var);
    }

    public y0.c c() {
        return this.f19933a;
    }

    public synchronized Map f() {
        return this.f19936d;
    }

    public final synchronized void g() {
        HashMap hashMap = new HashMap();
        String str = "unknown";
        Iterator it = this.f19935c.iterator();
        int i10 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            z0 z0Var = (z0) it.next();
            String c10 = z0Var.c();
            z0 z0Var2 = (z0) hashMap.get(c10);
            if (z0Var2 == null || z0Var2.e() < z0Var.e()) {
                hashMap.put(c10, z0Var);
            }
            if (i10 < z0Var.e()) {
                int e10 = z0Var.e();
                i10 = e10;
                str = z0Var.c();
            }
        }
        this.f19936d = ImmutableMap.copyOf(hashMap);
        this.f19934b = str;
    }
}
