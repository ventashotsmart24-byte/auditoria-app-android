package y8;

import com.google.common.base.Preconditions;
import com.umeng.analytics.pro.bt;
import f9.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.j1;
import z8.q1;

public final class q0 {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f20148c = Logger.getLogger(q0.class.getName());

    /* renamed from: d  reason: collision with root package name */
    public static q0 f20149d;

    /* renamed from: e  reason: collision with root package name */
    public static final Iterable f20150e = c();

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f20151a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f20152b = new LinkedHashMap();

    public static final class a implements j1.b {
        /* renamed from: c */
        public int b(p0 p0Var) {
            return p0Var.c();
        }

        /* renamed from: d */
        public boolean a(p0 p0Var) {
            return p0Var.d();
        }
    }

    public static synchronized q0 b() {
        q0 q0Var;
        synchronized (q0.class) {
            if (f20149d == null) {
                List<p0> e10 = j1.e(p0.class, f20150e, p0.class.getClassLoader(), new a());
                f20149d = new q0();
                for (p0 p0Var : e10) {
                    Logger logger = f20148c;
                    logger.fine("Service loader found " + p0Var);
                    f20149d.a(p0Var);
                }
                f20149d.e();
            }
            q0Var = f20149d;
        }
        return q0Var;
    }

    public static List c() {
        ArrayList arrayList = new ArrayList();
        Class<q1> cls = q1.class;
        try {
            int i10 = q1.f20915b;
            arrayList.add(cls);
        } catch (ClassNotFoundException e10) {
            f20148c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", e10);
        }
        Class<i> cls2 = i.class;
        try {
            int i11 = i.f16848b;
            arrayList.add(cls2);
        } catch (ClassNotFoundException e11) {
            f20148c.log(Level.FINE, "Unable to find round-robin LoadBalancer", e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(p0 p0Var) {
        Preconditions.checkArgument(p0Var.d(), "isAvailable() returned false");
        this.f20151a.add(p0Var);
    }

    public synchronized p0 d(String str) {
        return (p0) this.f20152b.get(Preconditions.checkNotNull(str, bt.by));
    }

    public final synchronized void e() {
        this.f20152b.clear();
        Iterator it = this.f20151a.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            String b10 = p0Var.b();
            p0 p0Var2 = (p0) this.f20152b.get(b10);
            if (p0Var2 == null || p0Var2.c() < p0Var.c()) {
                this.f20152b.put(b10, p0Var);
            }
        }
    }
}
