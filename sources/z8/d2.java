package z8;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class d2 {

    /* renamed from: d  reason: collision with root package name */
    public static final d2 f20463d = new d2(new a());

    /* renamed from: a  reason: collision with root package name */
    public final IdentityHashMap f20464a = new IdentityHashMap();

    /* renamed from: b  reason: collision with root package name */
    public final e f20465b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledExecutorService f20466c;

    public class a implements e {
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(q0.i("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20468b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f20469c;

        public b(c cVar, d dVar, Object obj) {
            this.f20467a = cVar;
            this.f20468b = dVar;
            this.f20469c = obj;
        }

        /* JADX INFO: finally extract failed */
        public void run() {
            synchronized (d2.this) {
                if (this.f20467a.f20472b == 0) {
                    try {
                        this.f20468b.close(this.f20469c);
                        d2.this.f20464a.remove(this.f20468b);
                        if (d2.this.f20464a.isEmpty()) {
                            d2.this.f20466c.shutdown();
                            ScheduledExecutorService unused = d2.this.f20466c = null;
                        }
                    } catch (Throwable th) {
                        d2.this.f20464a.remove(this.f20468b);
                        if (d2.this.f20464a.isEmpty()) {
                            d2.this.f20466c.shutdown();
                            ScheduledExecutorService unused2 = d2.this.f20466c = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f20471a;

        /* renamed from: b  reason: collision with root package name */
        public int f20472b;

        /* renamed from: c  reason: collision with root package name */
        public ScheduledFuture f20473c;

        public c(Object obj) {
            this.f20471a = obj;
        }
    }

    public interface d {
        void close(Object obj);

        Object create();
    }

    public interface e {
        ScheduledExecutorService a();
    }

    public d2(e eVar) {
        this.f20465b = eVar;
    }

    public static Object d(d dVar) {
        return f20463d.e(dVar);
    }

    public static Object f(d dVar, Object obj) {
        return f20463d.g(dVar, obj);
    }

    public synchronized Object e(d dVar) {
        c cVar;
        cVar = (c) this.f20464a.get(dVar);
        if (cVar == null) {
            cVar = new c(dVar.create());
            this.f20464a.put(dVar, cVar);
        }
        ScheduledFuture scheduledFuture = cVar.f20473c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            cVar.f20473c = null;
        }
        cVar.f20472b++;
        return cVar.f20471a;
    }

    public synchronized Object g(d dVar, Object obj) {
        boolean z10;
        boolean z11;
        c cVar = (c) this.f20464a.get(dVar);
        if (cVar != null) {
            boolean z12 = false;
            if (obj == cVar.f20471a) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "Releasing the wrong instance");
            if (cVar.f20472b > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Refcount has already reached zero");
            int i10 = cVar.f20472b - 1;
            cVar.f20472b = i10;
            if (i10 == 0) {
                if (cVar.f20473c == null) {
                    z12 = true;
                }
                Preconditions.checkState(z12, "Destroy task already scheduled");
                if (this.f20466c == null) {
                    this.f20466c = this.f20465b.a();
                }
                cVar.f20473c = this.f20466c.schedule(new c1(new b(cVar, dVar, obj)), 1, TimeUnit.SECONDS);
            }
        } else {
            throw new IllegalArgumentException("No cached instance found for " + dVar);
        }
        return null;
    }
}
