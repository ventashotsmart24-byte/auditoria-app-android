package q0;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import t0.c;
import t0.f;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public volatile t0.b f8863a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f8864b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f8865c;

    /* renamed from: d  reason: collision with root package name */
    public t0.c f8866d;

    /* renamed from: e  reason: collision with root package name */
    public final androidx.room.c f8867e = e();

    /* renamed from: f  reason: collision with root package name */
    public boolean f8868f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8869g;

    /* renamed from: h  reason: collision with root package name */
    public List f8870h;

    /* renamed from: i  reason: collision with root package name */
    public final ReentrantReadWriteLock f8871i = new ReentrantReadWriteLock();

    /* renamed from: j  reason: collision with root package name */
    public final ThreadLocal f8872j = new ThreadLocal();

    /* renamed from: k  reason: collision with root package name */
    public final Map f8873k = new ConcurrentHashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Class f8874a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8875b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f8876c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList f8877d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f8878e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f8879f;

        /* renamed from: g  reason: collision with root package name */
        public c.C0123c f8880g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8881h;

        /* renamed from: i  reason: collision with root package name */
        public c f8882i = c.AUTOMATIC;

        /* renamed from: j  reason: collision with root package name */
        public boolean f8883j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f8884k = true;

        /* renamed from: l  reason: collision with root package name */
        public boolean f8885l;

        /* renamed from: m  reason: collision with root package name */
        public final d f8886m = new d();

        /* renamed from: n  reason: collision with root package name */
        public Set f8887n;

        /* renamed from: o  reason: collision with root package name */
        public Set f8888o;

        /* renamed from: p  reason: collision with root package name */
        public String f8889p;

        /* renamed from: q  reason: collision with root package name */
        public File f8890q;

        public a(Context context, Class cls, String str) {
            this.f8876c = context;
            this.f8874a = cls;
            this.f8875b = str;
        }

        public a a(b bVar) {
            if (this.f8877d == null) {
                this.f8877d = new ArrayList();
            }
            this.f8877d.add(bVar);
            return this;
        }

        public a b(r0.a... aVarArr) {
            if (this.f8888o == null) {
                this.f8888o = new HashSet();
            }
            for (r0.a aVar : aVarArr) {
                this.f8888o.add(Integer.valueOf(aVar.f8973a));
                this.f8888o.add(Integer.valueOf(aVar.f8974b));
            }
            this.f8886m.b(aVarArr);
            return this;
        }

        public a c() {
            this.f8881h = true;
            return this;
        }

        public e d() {
            Executor executor;
            if (this.f8876c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f8874a != null) {
                Executor executor2 = this.f8878e;
                if (executor2 == null && this.f8879f == null) {
                    Executor d10 = h.a.d();
                    this.f8879f = d10;
                    this.f8878e = d10;
                } else if (executor2 != null && this.f8879f == null) {
                    this.f8879f = executor2;
                } else if (executor2 == null && (executor = this.f8879f) != null) {
                    this.f8878e = executor;
                }
                Set<Integer> set = this.f8888o;
                if (!(set == null || this.f8887n == null)) {
                    for (Integer num : set) {
                        if (this.f8887n.contains(num)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                        }
                    }
                }
                if (this.f8880g == null) {
                    this.f8880g = new u0.d();
                }
                String str = this.f8889p;
                if (!(str == null && this.f8890q == null)) {
                    if (this.f8875b == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    } else if (str == null || this.f8890q == null) {
                        this.f8880g = new j(str, this.f8890q, this.f8880g);
                    } else {
                        throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                    }
                }
                Context context = this.f8876c;
                String str2 = this.f8875b;
                c.C0123c cVar = this.f8880g;
                d dVar = this.f8886m;
                ArrayList arrayList = this.f8877d;
                boolean z10 = this.f8881h;
                c b10 = this.f8882i.b(context);
                Executor executor3 = this.f8878e;
                Executor executor4 = this.f8879f;
                boolean z11 = this.f8883j;
                boolean z12 = this.f8884k;
                boolean z13 = this.f8885l;
                boolean z14 = z12;
                boolean z15 = z13;
                a aVar = new a(context, str2, cVar, dVar, arrayList, z10, b10, executor3, executor4, z11, z14, z15, this.f8887n, this.f8889p, this.f8890q);
                e eVar = (e) d.b(this.f8874a, "_Impl");
                eVar.l(aVar);
                return eVar;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        public a e() {
            this.f8884k = false;
            this.f8885l = true;
            return this;
        }

        public a f(c.C0123c cVar) {
            this.f8880g = cVar;
            return this;
        }

        public a g(Executor executor) {
            this.f8878e = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(t0.b bVar) {
        }

        public void b(t0.b bVar) {
        }

        public void c(t0.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        public static boolean a(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        public c b(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || a(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HashMap f8895a = new HashMap();

        public final void a(r0.a aVar) {
            int i10 = aVar.f8973a;
            int i11 = aVar.f8974b;
            TreeMap treeMap = (TreeMap) this.f8895a.get(Integer.valueOf(i10));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.f8895a.put(Integer.valueOf(i10), treeMap);
            }
            r0.a aVar2 = (r0.a) treeMap.get(Integer.valueOf(i11));
            if (aVar2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Overriding migration ");
                sb.append(aVar2);
                sb.append(" with ");
                sb.append(aVar);
            }
            treeMap.put(Integer.valueOf(i11), aVar);
        }

        public void b(r0.a... aVarArr) {
            for (r0.a a10 : aVarArr) {
                a(a10);
            }
        }

        public List c(int i10, int i11) {
            boolean z10;
            if (i10 == i11) {
                return Collections.emptyList();
            }
            if (i11 > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            return d(new ArrayList(), z10, i10, i11);
        }

        public final List d(List list, boolean z10, int i10, int i11) {
            Set set;
            boolean z11;
            do {
                if (z10) {
                    if (i10 >= i11) {
                        return list;
                    }
                } else if (i10 <= i11) {
                    return list;
                }
                TreeMap treeMap = (TreeMap) this.f8895a.get(Integer.valueOf(i10));
                if (treeMap != null) {
                    if (z10) {
                        set = treeMap.descendingKeySet();
                    } else {
                        set = treeMap.keySet();
                    }
                    Iterator it = set.iterator();
                    while (true) {
                        z11 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        int intValue = ((Integer) it.next()).intValue();
                        if (!z10 ? !(intValue < i11 || intValue >= i10) : !(intValue > i11 || intValue <= i10)) {
                            z11 = true;
                            continue;
                        }
                        if (z11) {
                            list.add(treeMap.get(Integer.valueOf(intValue)));
                            i10 = intValue;
                            z11 = true;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z11);
            return null;
        }
    }

    public static boolean n() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public void a() {
        if (!this.f8868f && n()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b() {
        if (!k() && this.f8872j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void c() {
        a();
        t0.b A = this.f8866d.A();
        this.f8867e.m(A);
        A.beginTransaction();
    }

    public f d(String str) {
        a();
        b();
        return this.f8866d.A().compileStatement(str);
    }

    public abstract androidx.room.c e();

    public abstract t0.c f(a aVar);

    public void g() {
        this.f8866d.A().endTransaction();
        if (!k()) {
            this.f8867e.f();
        }
    }

    public Lock h() {
        return this.f8871i.readLock();
    }

    public t0.c i() {
        return this.f8866d;
    }

    public Executor j() {
        return this.f8864b;
    }

    public boolean k() {
        return this.f8866d.A().G();
    }

    public void l(a aVar) {
        boolean z10;
        t0.c f10 = f(aVar);
        this.f8866d = f10;
        if (f10 instanceof i) {
            ((i) f10).b(aVar);
        }
        if (aVar.f8852g == c.WRITE_AHEAD_LOGGING) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f8866d.setWriteAheadLoggingEnabled(z10);
        this.f8870h = aVar.f8850e;
        this.f8864b = aVar.f8853h;
        this.f8865c = new l(aVar.f8854i);
        this.f8868f = aVar.f8851f;
        this.f8869g = z10;
        if (aVar.f8855j) {
            this.f8867e.i(aVar.f8847b, aVar.f8848c);
        }
    }

    public void m(t0.b bVar) {
        this.f8867e.d(bVar);
    }

    public boolean o() {
        t0.b bVar = this.f8863a;
        if (bVar == null || !bVar.isOpen()) {
            return false;
        }
        return true;
    }

    public Cursor p(t0.e eVar) {
        return q(eVar, (CancellationSignal) null);
    }

    public Cursor q(t0.e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        if (cancellationSignal != null) {
            return this.f8866d.A().k(eVar, cancellationSignal);
        }
        return this.f8866d.A().w(eVar);
    }

    public void r() {
        this.f8866d.A().setTransactionSuccessful();
    }
}
