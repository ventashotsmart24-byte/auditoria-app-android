package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.g;
import y8.k1;
import y8.r;
import y8.t;
import y8.v0;

public abstract class z extends y8.g {

    /* renamed from: j  reason: collision with root package name */
    public static final Logger f21186j = Logger.getLogger(z.class.getName());

    /* renamed from: k  reason: collision with root package name */
    public static final y8.g f21187k = new i();

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledFuture f21188a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f21189b;

    /* renamed from: c  reason: collision with root package name */
    public final r f21190c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f21191d;

    /* renamed from: e  reason: collision with root package name */
    public g.a f21192e;

    /* renamed from: f  reason: collision with root package name */
    public y8.g f21193f;

    /* renamed from: g  reason: collision with root package name */
    public k1 f21194g;

    /* renamed from: h  reason: collision with root package name */
    public List f21195h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public k f21196i;

    public class a extends x {
        public a(r rVar) {
            super(rVar);
        }

        public void a() {
            z.this.m();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f21198a;

        public b(StringBuilder sb) {
            this.f21198a = sb;
        }

        public void run() {
            z.this.k(k1.f20045j.r(this.f21198a.toString()), true);
        }
    }

    public class c extends x {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f21200b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(z.this.f21190c);
            this.f21200b = kVar;
        }

        public void a() {
            this.f21200b.g();
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f21202a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v0 f21203b;

        public d(g.a aVar, v0 v0Var) {
            this.f21202a = aVar;
            this.f21203b = v0Var;
        }

        public void run() {
            z.this.f21193f.e(this.f21202a, this.f21203b);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k1 f21205a;

        public e(k1 k1Var) {
            this.f21205a = k1Var;
        }

        public void run() {
            z.this.f21193f.a(this.f21205a.o(), this.f21205a.m());
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f21207a;

        public f(Object obj) {
            this.f21207a = obj;
        }

        public void run() {
            z.this.f21193f.d(this.f21207a);
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f21209a;

        public g(int i10) {
            this.f21209a = i10;
        }

        public void run() {
            z.this.f21193f.c(this.f21209a);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            z.this.f21193f.b();
        }
    }

    public class i extends y8.g {
        public void a(String str, Throwable th) {
        }

        public void b() {
        }

        public void c(int i10) {
        }

        public void d(Object obj) {
        }

        public void e(g.a aVar, v0 v0Var) {
        }
    }

    public final class j extends x {

        /* renamed from: b  reason: collision with root package name */
        public final g.a f21212b;

        /* renamed from: c  reason: collision with root package name */
        public final k1 f21213c;

        public j(g.a aVar, k1 k1Var) {
            super(z.this.f21190c);
            this.f21212b = aVar;
            this.f21213c = k1Var;
        }

        public void a() {
            this.f21212b.a(this.f21213c, new v0());
        }
    }

    public static final class k extends g.a {

        /* renamed from: a  reason: collision with root package name */
        public final g.a f21215a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f21216b;

        /* renamed from: c  reason: collision with root package name */
        public List f21217c = new ArrayList();

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v0 f21218a;

            public a(v0 v0Var) {
                this.f21218a = v0Var;
            }

            public void run() {
                k.this.f21215a.b(this.f21218a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f21220a;

            public b(Object obj) {
                this.f21220a = obj;
            }

            public void run() {
                k.this.f21215a.c(this.f21220a);
            }
        }

        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k1 f21222a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ v0 f21223b;

            public c(k1 k1Var, v0 v0Var) {
                this.f21222a = k1Var;
                this.f21223b = v0Var;
            }

            public void run() {
                k.this.f21215a.a(this.f21222a, this.f21223b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                k.this.f21215a.d();
            }
        }

        public k(g.a aVar) {
            this.f21215a = aVar;
        }

        public void a(k1 k1Var, v0 v0Var) {
            f(new c(k1Var, v0Var));
        }

        public void b(v0 v0Var) {
            if (this.f21216b) {
                this.f21215a.b(v0Var);
            } else {
                f(new a(v0Var));
            }
        }

        public void c(Object obj) {
            if (this.f21216b) {
                this.f21215a.c(obj);
            } else {
                f(new b(obj));
            }
        }

        public void d() {
            if (this.f21216b) {
                this.f21215a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (!this.f21216b) {
                    this.f21217c.add(runnable);
                } else {
                    runnable.run();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
            if (r0.hasNext() == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            ((java.lang.Runnable) r0.next()).run();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g() {
            /*
                r3 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
            L_0x0005:
                monitor-enter(r3)
                java.util.List r1 = r3.f21217c     // Catch:{ all -> 0x0034 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0016
                r0 = 0
                r3.f21217c = r0     // Catch:{ all -> 0x0034 }
                r0 = 1
                r3.f21216b = r0     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0016:
                java.util.List r1 = r3.f21217c     // Catch:{ all -> 0x0034 }
                r3.f21217c = r0     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                java.util.Iterator r0 = r1.iterator()
            L_0x001f:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x002f
                java.lang.Object r2 = r0.next()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                r2.run()
                goto L_0x001f
            L_0x002f:
                r1.clear()
                r0 = r1
                goto L_0x0005
            L_0x0034:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                goto L_0x0038
            L_0x0037:
                throw r0
            L_0x0038:
                goto L_0x0037
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.z.k.g():void");
        }
    }

    public z(Executor executor, ScheduledExecutorService scheduledExecutorService, t tVar) {
        this.f21189b = (Executor) Preconditions.checkNotNull(executor, "callExecutor");
        Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.f21190c = r.e();
        this.f21188a = o(scheduledExecutorService, tVar);
    }

    public final void a(String str, Throwable th) {
        k1 k1Var;
        k1 k1Var2 = k1.f20042g;
        if (str != null) {
            k1Var = k1Var2.r(str);
        } else {
            k1Var = k1Var2.r("Call cancelled without message");
        }
        if (th != null) {
            k1Var = k1Var.q(th);
        }
        k(k1Var, false);
    }

    public final void b() {
        l(new h());
    }

    public final void c(int i10) {
        if (this.f21191d) {
            this.f21193f.c(i10);
        } else {
            l(new g(i10));
        }
    }

    public final void d(Object obj) {
        if (this.f21191d) {
            this.f21193f.d(obj);
        } else {
            l(new f(obj));
        }
    }

    public final void e(g.a aVar, v0 v0Var) {
        boolean z10;
        k1 k1Var;
        boolean z11;
        if (this.f21192e == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "already started");
        synchronized (this) {
            this.f21192e = (g.a) Preconditions.checkNotNull(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            k1Var = this.f21194g;
            z11 = this.f21191d;
            if (!z11) {
                k kVar = new k(aVar);
                this.f21196i = kVar;
                aVar = kVar;
            }
        }
        if (k1Var != null) {
            this.f21189b.execute(new j(aVar, k1Var));
        } else if (z11) {
            this.f21193f.e(aVar, v0Var);
        } else {
            l(new d(aVar, v0Var));
        }
    }

    public void j() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r0 == false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        l(new z8.z.e(r2, r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r4 == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r2.f21189b.execute(new z8.z.j(r2, r4, r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(y8.k1 r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            y8.g r0 = r2.f21193f     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0010
            y8.g r4 = f21187k     // Catch:{ all -> 0x0035 }
            r2.q(r4)     // Catch:{ all -> 0x0035 }
            y8.g$a r4 = r2.f21192e     // Catch:{ all -> 0x0035 }
            r2.f21194g = r3     // Catch:{ all -> 0x0035 }
            r0 = 0
            goto L_0x0016
        L_0x0010:
            if (r4 == 0) goto L_0x0014
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            return
        L_0x0014:
            r0 = 1
            r4 = 0
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0022
            z8.z$e r4 = new z8.z$e
            r4.<init>(r3)
            r2.l(r4)
            goto L_0x0031
        L_0x0022:
            if (r4 == 0) goto L_0x002e
            java.util.concurrent.Executor r0 = r2.f21189b
            z8.z$j r1 = new z8.z$j
            r1.<init>(r4, r3)
            r0.execute(r1)
        L_0x002e:
            r2.m()
        L_0x0031:
            r2.j()
            return
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0035 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.z.k(y8.k1, boolean):void");
    }

    public final void l(Runnable runnable) {
        synchronized (this) {
            if (!this.f21191d) {
                this.f21195h.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r0.hasNext() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r3.f21189b.execute(new z8.z.c(r3, r0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            monitor-enter(r3)
            java.util.List r1 = r3.f21195h     // Catch:{ all -> 0x0042 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0024
            r0 = 0
            r3.f21195h = r0     // Catch:{ all -> 0x0042 }
            r0 = 1
            r3.f21191d = r0     // Catch:{ all -> 0x0042 }
            z8.z$k r0 = r3.f21196i     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0023
            java.util.concurrent.Executor r1 = r3.f21189b
            z8.z$c r2 = new z8.z$c
            r2.<init>(r0)
            r1.execute(r2)
        L_0x0023:
            return
        L_0x0024:
            java.util.List r1 = r3.f21195h     // Catch:{ all -> 0x0042 }
            r3.f21195h = r0     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)     // Catch:{ all -> 0x0042 }
            java.util.Iterator r0 = r1.iterator()
        L_0x002d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L_0x002d
        L_0x003d:
            r1.clear()
            r0 = r1
            goto L_0x0005
        L_0x0042:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x0045:
            throw r0
        L_0x0046:
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.z.m():void");
    }

    public final boolean n(t tVar, t tVar2) {
        if (tVar2 == null) {
            return true;
        }
        if (tVar == null) {
            return false;
        }
        return tVar.f(tVar2);
    }

    public final ScheduledFuture o(ScheduledExecutorService scheduledExecutorService, t tVar) {
        long j10;
        String str;
        t g10 = this.f21190c.g();
        if (tVar == null && g10 == null) {
            return null;
        }
        if (tVar != null) {
            j10 = tVar.i(TimeUnit.NANOSECONDS);
        } else {
            j10 = Long.MAX_VALUE;
        }
        if (g10 != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (g10.i(timeUnit) < j10) {
                j10 = g10.i(timeUnit);
                Logger logger = f21186j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", new Object[]{Long.valueOf(j10)}));
                    if (tVar == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", new Object[]{Long.valueOf(tVar.i(timeUnit))}));
                    }
                    logger.fine(sb.toString());
                }
            }
        }
        long abs = Math.abs(j10);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = abs / timeUnit2.toNanos(1);
        long abs2 = Math.abs(j10) % timeUnit2.toNanos(1);
        StringBuilder sb2 = new StringBuilder();
        if (n(g10, tVar)) {
            str = "Context";
        } else {
            str = "CallOptions";
        }
        if (j10 < 0) {
            sb2.append("ClientCall started after ");
            sb2.append(str);
            sb2.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb2.append("Deadline ");
            sb2.append(str);
            sb2.append(" will be exceeded in ");
        }
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", new Object[]{Long.valueOf(abs2)}));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new b(sb2), j10, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(y8.g gVar) {
        synchronized (this) {
            if (this.f21193f != null) {
                return null;
            }
            q((y8.g) Preconditions.checkNotNull(gVar, "call"));
            return new a(this.f21190c);
        }
    }

    public final void q(y8.g gVar) {
        boolean z10;
        y8.g gVar2 = this.f21193f;
        if (gVar2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "realCall already set to %s", (Object) gVar2);
        ScheduledFuture scheduledFuture = this.f21188a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f21193f = gVar;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("realCall", (Object) this.f21193f).toString();
    }
}
