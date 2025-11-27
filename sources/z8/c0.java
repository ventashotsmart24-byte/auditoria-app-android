package z8;

import androidx.appcompat.app.m;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.hpplay.cybergarage.soap.SOAP;
import com.uc.crashsdk.export.LogType;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.c1;
import y8.d1;
import y8.k1;
import y8.o1;
import y8.x;
import y8.y0;
import z8.d2;

public class c0 extends y0 {
    public static String A;

    /* renamed from: s  reason: collision with root package name */
    public static final Logger f20410s;

    /* renamed from: t  reason: collision with root package name */
    public static final Set f20411t = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"clientLanguage", "percentage", "clientHostname", "serviceConfig"})));

    /* renamed from: u  reason: collision with root package name */
    public static final String f20412u;

    /* renamed from: v  reason: collision with root package name */
    public static final String f20413v;

    /* renamed from: w  reason: collision with root package name */
    public static final String f20414w;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f20415x;

    /* renamed from: y  reason: collision with root package name */
    public static boolean f20416y;

    /* renamed from: z  reason: collision with root package name */
    public static boolean f20417z;

    /* renamed from: a  reason: collision with root package name */
    public final d1 f20418a;

    /* renamed from: b  reason: collision with root package name */
    public final Random f20419b = new Random();

    /* renamed from: c  reason: collision with root package name */
    public volatile b f20420c = d.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f20421d = new AtomicReference();

    /* renamed from: e  reason: collision with root package name */
    public final String f20422e;

    /* renamed from: f  reason: collision with root package name */
    public final String f20423f;

    /* renamed from: g  reason: collision with root package name */
    public final int f20424g;

    /* renamed from: h  reason: collision with root package name */
    public final d2.d f20425h;

    /* renamed from: i  reason: collision with root package name */
    public final long f20426i;

    /* renamed from: j  reason: collision with root package name */
    public final o1 f20427j;

    /* renamed from: k  reason: collision with root package name */
    public final Stopwatch f20428k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f20429l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f20430m;

    /* renamed from: n  reason: collision with root package name */
    public Executor f20431n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f20432o;

    /* renamed from: p  reason: collision with root package name */
    public final y0.f f20433p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f20434q;

    /* renamed from: r  reason: collision with root package name */
    public y0.d f20435r;

    public interface b {
        List a(String str);
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public k1 f20436a;

        /* renamed from: b  reason: collision with root package name */
        public List f20437b;

        /* renamed from: c  reason: collision with root package name */
        public y0.b f20438c;

        /* renamed from: d  reason: collision with root package name */
        public y8.a f20439d;

        public c() {
        }
    }

    public enum d implements b {
        INSTANCE;

        public List a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final y0.d f20442a;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f20444a;

            public a(boolean z10) {
                this.f20444a = z10;
            }

            public void run() {
                if (this.f20444a) {
                    c0 c0Var = c0.this;
                    c0Var.f20429l = true;
                    if (c0Var.f20426i > 0) {
                        c0.this.f20428k.reset().start();
                    }
                }
                boolean unused = c0.this.f20434q = false;
            }
        }

        public e(y0.d dVar) {
            this.f20442a = (y0.d) Preconditions.checkNotNull(dVar, "savedListener");
        }

        public void run() {
            o1 e10;
            a aVar;
            Logger f10 = c0.f20410s;
            Level level = Level.FINER;
            if (f10.isLoggable(level)) {
                Logger f11 = c0.f20410s;
                f11.finer("Attempting DNS resolution of " + c0.this.f20423f);
            }
            boolean z10 = true;
            c cVar = null;
            try {
                x h10 = c0.this.m();
                y0.e.a d10 = y0.e.d();
                if (h10 != null) {
                    if (c0.f20410s.isLoggable(level)) {
                        Logger f12 = c0.f20410s;
                        f12.finer("Using proxy address " + h10);
                    }
                    d10.b(Collections.singletonList(h10));
                } else {
                    cVar = c0.this.n(false);
                    if (cVar.f20436a != null) {
                        this.f20442a.a(cVar.f20436a);
                        if (cVar == null || cVar.f20436a != null) {
                            z10 = false;
                        }
                        c0.this.f20427j.execute(new a(z10));
                        return;
                    }
                    if (cVar.f20437b != null) {
                        d10.b(cVar.f20437b);
                    }
                    if (cVar.f20438c != null) {
                        d10.d(cVar.f20438c);
                    }
                    y8.a aVar2 = cVar.f20439d;
                    if (aVar2 != null) {
                        d10.c(aVar2);
                    }
                }
                this.f20442a.b(d10.a());
                if (cVar == null || cVar.f20436a != null) {
                    z10 = false;
                }
                e10 = c0.this.f20427j;
                aVar = new a(z10);
            } catch (IOException e11) {
                y0.d dVar = this.f20442a;
                k1 k1Var = k1.f20056u;
                dVar.a(k1Var.r("Unable to resolve host " + c0.this.f20423f).q(e11));
                if (cVar == null || cVar.f20436a != null) {
                    z10 = false;
                }
                e10 = c0.this.f20427j;
                aVar = new a(z10);
            } catch (Throwable th) {
                if (cVar == null || cVar.f20436a != null) {
                    z10 = false;
                }
                c0.this.f20427j.execute(new a(z10));
                throw th;
            }
            e10.execute(aVar);
        }
    }

    public interface f {
    }

    public interface g {
    }

    static {
        Class<c0> cls = c0.class;
        f20410s = Logger.getLogger(cls.getName());
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        f20412u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        f20413v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f20414w = property3;
        f20415x = Boolean.parseBoolean(property);
        f20416y = Boolean.parseBoolean(property2);
        f20417z = Boolean.parseBoolean(property3);
        u(cls.getClassLoader());
    }

    public c0(String str, String str2, y0.a aVar, d2.d dVar, Stopwatch stopwatch, boolean z10) {
        boolean z11;
        Preconditions.checkNotNull(aVar, "args");
        this.f20425h = dVar;
        URI create = URI.create("//" + ((String) Preconditions.checkNotNull(str2, "name")));
        boolean z12 = true;
        if (create.getHost() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Invalid DNS name: %s", (Object) str2);
        this.f20422e = (String) Preconditions.checkNotNull(create.getAuthority(), "nameUri (%s) doesn't have an authority", (Object) create);
        this.f20423f = create.getHost();
        if (create.getPort() == -1) {
            this.f20424g = aVar.a();
        } else {
            this.f20424g = create.getPort();
        }
        this.f20418a = (d1) Preconditions.checkNotNull(aVar.c(), "proxyDetector");
        this.f20426i = r(z10);
        this.f20428k = (Stopwatch) Preconditions.checkNotNull(stopwatch, "stopwatch");
        this.f20427j = (o1) Preconditions.checkNotNull(aVar.e(), "syncContext");
        Executor b10 = aVar.b();
        this.f20431n = b10;
        this.f20432o = b10 != null ? false : z12;
        this.f20433p = (y0.f) Preconditions.checkNotNull(aVar.d(), "serviceConfigParser");
    }

    public static boolean B(boolean z10, boolean z11, String str) {
        boolean z12;
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(SOAP.DELIM)) {
            return false;
        }
        boolean z13 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '.') {
                if (charAt < '0' || charAt > '9') {
                    z12 = false;
                } else {
                    z12 = true;
                }
                z13 &= z12;
            }
        }
        return true ^ z13;
    }

    public static final List o(Map map) {
        return a1.g(map, "clientLanguage");
    }

    public static final List p(Map map) {
        return a1.g(map, "clientHostname");
    }

    public static String q() {
        if (A == null) {
            try {
                A = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e10) {
                throw new RuntimeException(e10);
            }
        }
        return A;
    }

    public static long r(boolean z10) {
        if (z10) {
            return 0;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j10 = 30;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f20410s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        if (j10 > 0) {
            return TimeUnit.SECONDS.toNanos(j10);
        }
        return j10;
    }

    public static final Double s(Map map) {
        return a1.h(map, "percentage");
    }

    public static g u(ClassLoader classLoader) {
        try {
            try {
                try {
                    m.a(Class.forName("z8.y0", true, classLoader).asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]));
                    throw null;
                } catch (Exception e10) {
                    f20410s.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", e10);
                    return null;
                }
            } catch (Exception e11) {
                f20410s.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", e11);
                return null;
            }
        } catch (ClassNotFoundException e12) {
            f20410s.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", e12);
            return null;
        } catch (ClassCastException e13) {
            f20410s.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", e13);
            return null;
        }
    }

    public static Map v(Map map, Random random, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        for (Map.Entry entry : map.entrySet()) {
            Verify.verify(f20411t.contains(entry.getKey()), "Bad key: %s", (Object) entry);
        }
        List o10 = o(map);
        if (o10 != null && !o10.isEmpty()) {
            Iterator it = o10.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (LogType.JAVA_TYPE.equalsIgnoreCase((String) it.next())) {
                        z12 = true;
                        break;
                    }
                } else {
                    z12 = false;
                    break;
                }
            }
            if (!z12) {
                return null;
            }
        }
        Double s10 = s(map);
        if (s10 != null) {
            int intValue = s10.intValue();
            if (intValue < 0 || intValue > 100) {
                z11 = false;
            } else {
                z11 = true;
            }
            Verify.verify(z11, "Bad percentage: %s", (Object) s10);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List p10 = p(map);
        if (p10 != null && !p10.isEmpty()) {
            Iterator it2 = p10.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((String) it2.next()).equals(str)) {
                        z10 = true;
                        break;
                    }
                } else {
                    z10 = false;
                    break;
                }
            }
            if (!z10) {
                return null;
            }
        }
        Map j10 = a1.j(map, "serviceConfig");
        if (j10 != null) {
            return j10;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", new Object[]{map, "serviceConfig"}));
    }

    public static y0.b w(List list, Random random, String str) {
        try {
            Map map = null;
            for (Map v10 : x(list)) {
                try {
                    map = v(v10, random, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e10) {
                    return y0.b.b(k1.f20043h.r("failed to pick service config choice").q(e10));
                }
            }
            if (map == null) {
                return null;
            }
            return y0.b.a(map);
        } catch (IOException | RuntimeException e11) {
            return y0.b.b(k1.f20043h.r("failed to parse TXT records").q(e11));
        }
    }

    public static List x(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!str.startsWith("grpc_config=")) {
                f20410s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            } else {
                Object a10 = z0.a(str.substring(12));
                if (a10 instanceof List) {
                    arrayList.addAll(a1.a((List) a10));
                } else {
                    throw new ClassCastException("wrong type " + a10);
                }
            }
        }
        return arrayList;
    }

    public final y0.b A() {
        List emptyList = Collections.emptyList();
        t();
        if (!emptyList.isEmpty()) {
            y0.b w10 = w(emptyList, this.f20419b, q());
            if (w10 == null) {
                return null;
            }
            if (w10.d() != null) {
                return y0.b.b(w10.d());
            }
            return this.f20433p.a((Map) w10.c());
        }
        f20410s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f20423f});
        return null;
    }

    public String a() {
        return this.f20422e;
    }

    public void b() {
        boolean z10;
        if (this.f20435r != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "not started");
        y();
    }

    public void c() {
        if (!this.f20430m) {
            this.f20430m = true;
            Executor executor = this.f20431n;
            if (executor != null && this.f20432o) {
                this.f20431n = (Executor) d2.f(this.f20425h, executor);
            }
        }
    }

    public void d(y0.d dVar) {
        boolean z10;
        if (this.f20435r == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "already started");
        if (this.f20432o) {
            this.f20431n = (Executor) d2.d(this.f20425h);
        }
        this.f20435r = (y0.d) Preconditions.checkNotNull(dVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        y();
    }

    public final boolean l() {
        if (this.f20429l) {
            long j10 = this.f20426i;
            if (j10 == 0 || (j10 > 0 && this.f20428k.elapsed(TimeUnit.NANOSECONDS) > this.f20426i)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final x m() {
        c1 a10 = this.f20418a.a(InetSocketAddress.createUnresolved(this.f20423f, this.f20424g));
        if (a10 != null) {
            return new x((SocketAddress) a10);
        }
        return null;
    }

    public c n(boolean z10) {
        c cVar = new c();
        try {
            List unused = cVar.f20437b = z();
        } catch (Exception e10) {
            if (!z10) {
                k1 k1Var = k1.f20056u;
                k1 unused2 = cVar.f20436a = k1Var.r("Unable to resolve host " + this.f20423f).q(e10);
                return cVar;
            }
        }
        if (f20417z) {
            y0.b unused3 = cVar.f20438c = A();
        }
        return cVar;
    }

    public f t() {
        if (!B(f20415x, f20416y, this.f20423f)) {
            return null;
        }
        m.a(this.f20421d.get());
        return null;
    }

    public final void y() {
        if (!this.f20434q && !this.f20430m && l()) {
            this.f20434q = true;
            this.f20431n.execute(new e(this.f20435r));
        }
    }

    public final List z() {
        try {
            List<InetAddress> a10 = this.f20420c.a(this.f20423f);
            ArrayList arrayList = new ArrayList(a10.size());
            for (InetAddress inetSocketAddress : a10) {
                arrayList.add(new x((SocketAddress) new InetSocketAddress(inetSocketAddress, this.f20424g)));
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception e10) {
            Throwables.throwIfUnchecked(e10);
            throw new RuntimeException(e10);
        } catch (Throwable th) {
            if (e10 != null) {
                f20410s.log(Level.FINE, "Address resolution failure", e10);
            }
            throw th;
        }
    }
}
