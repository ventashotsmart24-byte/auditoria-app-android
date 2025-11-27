package b1;

import a1.e;
import a1.k;
import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b1.k;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import k1.n;

public class d implements b, i1.a {

    /* renamed from: l  reason: collision with root package name */
    public static final String f4123l = k.f("Processor");

    /* renamed from: a  reason: collision with root package name */
    public PowerManager.WakeLock f4124a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4125b;

    /* renamed from: c  reason: collision with root package name */
    public androidx.work.a f4126c;

    /* renamed from: d  reason: collision with root package name */
    public m1.a f4127d;

    /* renamed from: e  reason: collision with root package name */
    public WorkDatabase f4128e;

    /* renamed from: f  reason: collision with root package name */
    public Map f4129f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map f4130g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public List f4131h;

    /* renamed from: i  reason: collision with root package name */
    public Set f4132i;

    /* renamed from: j  reason: collision with root package name */
    public final List f4133j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f4134k;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public b f4135a;

        /* renamed from: b  reason: collision with root package name */
        public String f4136b;

        /* renamed from: c  reason: collision with root package name */
        public ListenableFuture f4137c;

        public a(b bVar, String str, ListenableFuture listenableFuture) {
            this.f4135a = bVar;
            this.f4136b = str;
            this.f4137c = listenableFuture;
        }

        public void run() {
            boolean z10;
            try {
                z10 = ((Boolean) this.f4137c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z10 = true;
            }
            this.f4135a.c(this.f4136b, z10);
        }
    }

    public d(Context context, androidx.work.a aVar, m1.a aVar2, WorkDatabase workDatabase, List list) {
        this.f4125b = context;
        this.f4126c = aVar;
        this.f4127d = aVar2;
        this.f4128e = workDatabase;
        this.f4131h = list;
        this.f4132i = new HashSet();
        this.f4133j = new ArrayList();
        this.f4124a = null;
        this.f4134k = new Object();
    }

    public static boolean e(String str, k kVar) {
        if (kVar != null) {
            kVar.d();
            k.c().a(f4123l, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
            return true;
        }
        k.c().a(f4123l, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
        return false;
    }

    public void a(String str) {
        synchronized (this.f4134k) {
            this.f4129f.remove(str);
            m();
        }
    }

    public void b(String str, e eVar) {
        synchronized (this.f4134k) {
            k.c().d(f4123l, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
            k kVar = (k) this.f4130g.remove(str);
            if (kVar != null) {
                if (this.f4124a == null) {
                    PowerManager.WakeLock b10 = n.b(this.f4125b, "ProcessorForegroundLck");
                    this.f4124a = b10;
                    b10.acquire();
                }
                this.f4129f.put(str, kVar);
                p.a.startForegroundService(this.f4125b, androidx.work.impl.foreground.a.e(this.f4125b, str, eVar));
            }
        }
    }

    public void c(String str, boolean z10) {
        synchronized (this.f4134k) {
            this.f4130g.remove(str);
            k.c().a(f4123l, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z10)}), new Throwable[0]);
            for (b c10 : this.f4133j) {
                c10.c(str, z10);
            }
        }
    }

    public void d(b bVar) {
        synchronized (this.f4134k) {
            this.f4133j.add(bVar);
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.f4134k) {
            contains = this.f4132i.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z10;
        synchronized (this.f4134k) {
            if (!this.f4130g.containsKey(str)) {
                if (!this.f4129f.containsKey(str)) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.f4134k) {
            containsKey = this.f4129f.containsKey(str);
        }
        return containsKey;
    }

    public void i(b bVar) {
        synchronized (this.f4134k) {
            this.f4133j.remove(bVar);
        }
    }

    public boolean j(String str) {
        return k(str, (WorkerParameters.a) null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.f4134k) {
            if (g(str)) {
                k.c().a(f4123l, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                return false;
            }
            k a10 = new k.c(this.f4125b, this.f4126c, this.f4127d, this, this.f4128e, str).c(this.f4131h).b(aVar).a();
            ListenableFuture b10 = a10.b();
            b10.addListener(new a(this, str, b10), this.f4127d.a());
            this.f4130g.put(str, a10);
            this.f4127d.c().execute(a10);
            a1.k.c().a(f4123l, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
            return true;
        }
    }

    public boolean l(String str) {
        boolean e10;
        synchronized (this.f4134k) {
            boolean z10 = true;
            a1.k.c().a(f4123l, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
            this.f4132i.add(str);
            k kVar = (k) this.f4129f.remove(str);
            if (kVar == null) {
                z10 = false;
            }
            if (kVar == null) {
                kVar = (k) this.f4130g.remove(str);
            }
            e10 = e(str, kVar);
            if (z10) {
                m();
            }
        }
        return e10;
    }

    public final void m() {
        synchronized (this.f4134k) {
            if (!(!this.f4129f.isEmpty())) {
                try {
                    this.f4125b.startService(androidx.work.impl.foreground.a.f(this.f4125b));
                } catch (Throwable th) {
                    a1.k.c().b(f4123l, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.f4124a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f4124a = null;
                }
            }
        }
    }

    public boolean n(String str) {
        boolean e10;
        synchronized (this.f4134k) {
            a1.k.c().a(f4123l, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            e10 = e(str, (k) this.f4129f.remove(str));
        }
        return e10;
    }

    public boolean o(String str) {
        boolean e10;
        synchronized (this.f4134k) {
            a1.k.c().a(f4123l, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            e10 = e(str, (k) this.f4130g.remove(str));
        }
        return e10;
    }
}
