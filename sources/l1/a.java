package l1;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a implements ListenableFuture {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7590d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f7591e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f7592f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f7593g = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Object f7594a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f7595b;

    /* renamed from: c  reason: collision with root package name */
    public volatile i f7596c;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f7597c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f7598d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f7599a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f7600b;

        static {
            if (a.f7590d) {
                f7598d = null;
                f7597c = null;
                return;
            }
            f7598d = new c(false, (Throwable) null);
            f7597c = new c(true, (Throwable) null);
        }

        public c(boolean z10, Throwable th) {
            this.f7599a = z10;
            this.f7600b = th;
        }
    }

    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        public static final d f7601b = new d(new C0098a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f7602a;

        /* renamed from: l1.a$d$a  reason: collision with other inner class name */
        public class C0098a extends Throwable {
            public C0098a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f7602a = (Throwable) a.d(th);
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f7603d = new e((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f7604a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f7605b;

        /* renamed from: c  reason: collision with root package name */
        public e f7606c;

        public e(Runnable runnable, Executor executor) {
            this.f7604a = runnable;
            this.f7605b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f7607a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f7608b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f7609c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f7610d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f7611e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f7607a = atomicReferenceFieldUpdater;
            this.f7608b = atomicReferenceFieldUpdater2;
            this.f7609c = atomicReferenceFieldUpdater3;
            this.f7610d = atomicReferenceFieldUpdater4;
            this.f7611e = atomicReferenceFieldUpdater5;
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f7610d, aVar, eVar, eVar2);
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f7611e, aVar, obj, obj2);
        }

        public boolean c(a aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f7609c, aVar, iVar, iVar2);
        }

        public void d(i iVar, i iVar2) {
            this.f7608b.lazySet(iVar, iVar2);
        }

        public void e(i iVar, Thread thread) {
            this.f7607a.lazySet(iVar, thread);
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final a f7612a;

        /* renamed from: b  reason: collision with root package name */
        public final ListenableFuture f7613b;

        public g(a aVar, ListenableFuture listenableFuture) {
            this.f7612a = aVar;
            this.f7613b = listenableFuture;
        }

        public void run() {
            if (this.f7612a.f7594a == this) {
                if (a.f7592f.b(this.f7612a, this, a.i(this.f7613b))) {
                    a.f(this.f7612a);
                }
            }
        }
    }

    public static final class h extends b {
        public h() {
            super();
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f7595b != eVar) {
                    return false;
                }
                aVar.f7595b = eVar2;
                return true;
            }
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f7594a != obj) {
                    return false;
                }
                aVar.f7594a = obj2;
                return true;
            }
        }

        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f7596c != iVar) {
                    return false;
                }
                aVar.f7596c = iVar2;
                return true;
            }
        }

        public void d(i iVar, i iVar2) {
            iVar.f7616b = iVar2;
        }

        public void e(i iVar, Thread thread) {
            iVar.f7615a = thread;
        }
    }

    public static final class i {

        /* renamed from: c  reason: collision with root package name */
        public static final i f7614c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f7615a;

        /* renamed from: b  reason: collision with root package name */
        public volatile i f7616b;

        public i(boolean z10) {
        }

        public void a(i iVar) {
            a.f7592f.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f7615a;
            if (thread != null) {
                this.f7615a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            a.f7592f.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: l1.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: l1.a$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: l1.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: l1.a$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<l1.a$i> r0 = l1.a.i.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f7590d = r1
            java.lang.Class<l1.a> r1 = l1.a.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            f7591e = r2
            l1.a$f r2 = new l1.a$f     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<l1.a$e> r0 = l1.a.e.class
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            l1.a$h r2 = new l1.a$h
            r2.<init>()
        L_0x004e:
            f7592f = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = f7591e
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f7593g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.a.<clinit>():void");
    }

    public static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void f(a aVar) {
        e eVar = null;
        while (true) {
            aVar.m();
            aVar.b();
            e e10 = aVar.e(eVar);
            while (true) {
                if (e10 != null) {
                    eVar = e10.f7606c;
                    Runnable runnable = e10.f7604a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        aVar = gVar.f7612a;
                        if (aVar.f7594a == gVar) {
                            if (f7592f.b(aVar, gVar, i(gVar.f7613b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        g(runnable, e10.f7605b);
                    }
                    e10 = eVar;
                } else {
                    return;
                }
            }
        }
    }

    public static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = f7591e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    public static Object i(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof a) {
            Object obj = ((a) listenableFuture).f7594a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f7599a) {
                return obj;
            }
            if (cVar.f7600b != null) {
                return new c(false, cVar.f7600b);
            }
            return c.f7598d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f7590d) && isCancelled) {
            return c.f7598d;
        }
        try {
            Object j10 = j(listenableFuture);
            if (j10 == null) {
                return f7593g;
            }
            return j10;
        } catch (ExecutionException e10) {
            return new d(e10.getCause());
        } catch (CancellationException e11) {
            if (isCancelled) {
                return new c(false, e11);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e11));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static Object j(Future future) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object j10 = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(r(j10));
            sb.append("]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e11) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e11.getClass());
            sb.append(" thrown from get()]");
        }
    }

    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        e eVar = this.f7595b;
        if (eVar != e.f7603d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f7606c = eVar;
                if (!f7592f.a(this, eVar, eVar2)) {
                    eVar = this.f7595b;
                } else {
                    return;
                }
            } while (eVar != e.f7603d);
        }
        g(runnable, executor);
    }

    public void b() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f7594a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof l1.a.g
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f7590d
            if (r3 == 0) goto L_0x001f
            l1.a$c r3 = new l1.a$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            l1.a$c r3 = l1.a.c.f7597c
            goto L_0x0026
        L_0x0024:
            l1.a$c r3 = l1.a.c.f7598d
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            l1.a$b r6 = f7592f
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.k()
        L_0x0035:
            f(r4)
            boolean r4 = r0 instanceof l1.a.g
            if (r4 == 0) goto L_0x0062
            l1.a$g r0 = (l1.a.g) r0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.f7613b
            boolean r4 = r0 instanceof l1.a
            if (r4 == 0) goto L_0x0055
            r4 = r0
            l1.a r4 = (l1.a) r4
            java.lang.Object r0 = r4.f7594a
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof l1.a.g
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f7594a
            boolean r6 = r0 instanceof l1.a.g
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.a.cancel(boolean):boolean");
    }

    public final e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f7595b;
        } while (!f7592f.a(this, eVar2, e.f7603d));
        e eVar3 = eVar2;
        e eVar4 = eVar;
        e eVar5 = eVar3;
        while (eVar5 != null) {
            e eVar6 = eVar5.f7606c;
            eVar5.f7606c = eVar4;
            eVar4 = eVar5;
            eVar5 = eVar6;
        }
        return eVar4;
    }

    public final Object get(long j10, TimeUnit timeUnit) {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.f7594a;
            if ((obj != null) && (!(obj instanceof g))) {
                return h(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.f7596c;
                if (iVar != i.f7614c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (f7592f.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f7594a;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return h(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(iVar2);
                        } else {
                            iVar = this.f7596c;
                        }
                    } while (iVar != i.f7614c);
                }
                return h(this.f7594a);
            }
            while (nanos > 0) {
                Object obj3 = this.f7594a;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return h(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j12 = -nanos;
                long convert = timeUnit2.convert(j12, TimeUnit.NANOSECONDS);
                long nanos2 = j12 - timeUnit2.toNanos(convert);
                boolean z10 = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    public final Object h(Object obj) {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f7600b);
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f7602a);
        } else if (obj == f7593g) {
            return null;
        } else {
            return obj;
        }
    }

    public final boolean isCancelled() {
        return this.f7594a instanceof c;
    }

    public final boolean isDone() {
        boolean z10;
        Object obj = this.f7594a;
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(obj instanceof g)) & z10;
    }

    public void k() {
    }

    public String l() {
        Object obj = this.f7594a;
        if (obj instanceof g) {
            return "setFuture=[" + r(((g) obj).f7613b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public final void m() {
        i iVar;
        do {
            iVar = this.f7596c;
        } while (!f7592f.c(this, iVar, i.f7614c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f7616b;
        }
    }

    public final void n(i iVar) {
        iVar.f7615a = null;
        while (true) {
            i iVar2 = this.f7596c;
            if (iVar2 != i.f7614c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f7616b;
                    if (iVar2.f7615a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f7616b = iVar4;
                        if (iVar3.f7615a == null) {
                        }
                    } else if (!f7592f.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public boolean o(Object obj) {
        if (obj == null) {
            obj = f7593g;
        }
        if (!f7592f.b(this, (Object) null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean p(Throwable th) {
        if (!f7592f.b(this, (Object) null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean q(ListenableFuture listenableFuture) {
        g gVar;
        d dVar;
        d(listenableFuture);
        Object obj = this.f7594a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f7592f.b(this, (Object) null, i(listenableFuture))) {
                    return false;
                }
                f(this);
                return true;
            }
            gVar = new g(this, listenableFuture);
            if (f7592f.b(this, (Object) null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, b.INSTANCE);
                } catch (Throwable unused) {
                    dVar = d.f7601b;
                }
                return true;
            }
            obj = this.f7594a;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f7599a);
        }
        return false;
        f7592f.b(this, gVar, dVar);
        return true;
    }

    public final String r(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = l();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f7594a;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return h(obj2);
            }
            i iVar = this.f7596c;
            if (iVar != i.f7614c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f7592f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f7594a;
                            } else {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return h(obj);
                    }
                    iVar = this.f7596c;
                } while (iVar != i.f7614c);
            }
            return h(this.f7594a);
        }
        throw new InterruptedException();
    }
}
