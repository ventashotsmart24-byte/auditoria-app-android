package y8;

import a9.g;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.j1;

public final class u0 {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f20168c = Logger.getLogger(u0.class.getName());

    /* renamed from: d  reason: collision with root package name */
    public static u0 f20169d;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f20170a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public List f20171b = Collections.emptyList();

    public class a implements Comparator {
        public a() {
        }

        /* renamed from: a */
        public int compare(t0 t0Var, t0 t0Var2) {
            return t0Var.c() - t0Var2.c();
        }
    }

    public static final class b implements j1.b {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: c */
        public int b(t0 t0Var) {
            return t0Var.c();
        }

        /* renamed from: d */
        public boolean a(t0 t0Var) {
            return t0Var.b();
        }
    }

    public static synchronized u0 b() {
        u0 u0Var;
        synchronized (u0.class) {
            if (f20169d == null) {
                List<t0> e10 = j1.e(t0.class, c(), t0.class.getClassLoader(), new b((a) null));
                f20169d = new u0();
                for (t0 t0Var : e10) {
                    Logger logger = f20168c;
                    logger.fine("Service loader found " + t0Var);
                    f20169d.a(t0Var);
                }
                f20169d.f();
            }
            u0Var = f20169d;
        }
        return u0Var;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(g.class);
        } catch (ClassNotFoundException e10) {
            f20168c.log(Level.FINE, "Unable to find OkHttpChannelProvider", e10);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e11) {
            f20168c.log(Level.FINE, "Unable to find NettyChannelProvider", e11);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e12) {
            f20168c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", e12);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(t0 t0Var) {
        Preconditions.checkArgument(t0Var.b(), "isAvailable() returned false");
        this.f20170a.add(t0Var);
    }

    public t0 d() {
        List e10 = e();
        if (e10.isEmpty()) {
            return null;
        }
        return (t0) e10.get(0);
    }

    public synchronized List e() {
        return this.f20171b;
    }

    public final synchronized void f() {
        ArrayList arrayList = new ArrayList(this.f20170a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f20171b = Collections.unmodifiableList(arrayList);
    }
}
