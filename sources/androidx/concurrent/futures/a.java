package androidx.concurrent.futures;

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
    static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    volatile e listeners;
    volatile Object value;
    volatile i waiters;

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
        public static final c f1569c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f1570d;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f1571a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f1572b;

        static {
            if (a.GENERATE_CANCELLATION_CAUSES) {
                f1570d = null;
                f1569c = null;
                return;
            }
            f1570d = new c(false, (Throwable) null);
            f1569c = new c(true, (Throwable) null);
        }

        public c(boolean z10, Throwable th) {
            this.f1571a = z10;
            this.f1572b = th;
        }
    }

    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        public static final d f1573b = new d(new C0021a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f1574a;

        /* renamed from: androidx.concurrent.futures.a$d$a  reason: collision with other inner class name */
        public class C0021a extends Throwable {
            public C0021a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f1574a = (Throwable) a.checkNotNull(th);
        }
    }

    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final e f1575d = new e((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f1576a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f1577b;

        /* renamed from: c  reason: collision with root package name */
        public e f1578c;

        public e(Runnable runnable, Executor executor) {
            this.f1576a = runnable;
            this.f1577b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1579a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1580b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1581c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1582d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1583e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f1579a = atomicReferenceFieldUpdater;
            this.f1580b = atomicReferenceFieldUpdater2;
            this.f1581c = atomicReferenceFieldUpdater3;
            this.f1582d = atomicReferenceFieldUpdater4;
            this.f1583e = atomicReferenceFieldUpdater5;
        }

        public boolean a(a aVar, e eVar, e eVar2) {
            return b.a(this.f1582d, aVar, eVar, eVar2);
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            return b.a(this.f1583e, aVar, obj, obj2);
        }

        public boolean c(a aVar, i iVar, i iVar2) {
            return b.a(this.f1581c, aVar, iVar, iVar2);
        }

        public void d(i iVar, i iVar2) {
            this.f1580b.lazySet(iVar, iVar2);
        }

        public void e(i iVar, Thread thread) {
            this.f1579a.lazySet(iVar, thread);
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final a f1584a;

        /* renamed from: b  reason: collision with root package name */
        public final ListenableFuture f1585b;

        public g(a aVar, ListenableFuture listenableFuture) {
            this.f1584a = aVar;
            this.f1585b = listenableFuture;
        }

        public void run() {
            if (this.f1584a.value == this) {
                if (a.ATOMIC_HELPER.b(this.f1584a, this, a.getFutureValue(this.f1585b))) {
                    a.complete(this.f1584a);
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
                if (aVar.listeners != eVar) {
                    return false;
                }
                aVar.listeners = eVar2;
                return true;
            }
        }

        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.value != obj) {
                    return false;
                }
                aVar.value = obj2;
                return true;
            }
        }

        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.waiters != iVar) {
                    return false;
                }
                aVar.waiters = iVar2;
                return true;
            }
        }

        public void d(i iVar, i iVar2) {
            iVar.f1588b = iVar2;
        }

        public void e(i iVar, Thread thread) {
            iVar.f1587a = thread;
        }
    }

    public static final class i {

        /* renamed from: c  reason: collision with root package name */
        public static final i f1586c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        public volatile Thread f1587a;

        /* renamed from: b  reason: collision with root package name */
        public volatile i f1588b;

        public i(boolean z10) {
        }

        public void a(i iVar) {
            a.ATOMIC_HELPER.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f1587a;
            if (thread != null) {
                this.f1587a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            a.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.concurrent.futures.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.concurrent.futures.a$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.concurrent.futures.a$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.concurrent.futures.a$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.a$i> r0 = androidx.concurrent.futures.a.i.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            GENERATE_CANCELLATION_CAUSES = r1
            java.lang.Class<androidx.concurrent.futures.a> r1 = androidx.concurrent.futures.a.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            log = r2
            androidx.concurrent.futures.a$f r2 = new androidx.concurrent.futures.a$f     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "waiters"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.concurrent.futures.a$e> r0 = androidx.concurrent.futures.a.e.class
            java.lang.String r3 = "listeners"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "value"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.concurrent.futures.a$h r2 = new androidx.concurrent.futures.a$h
            r2.<init>()
        L_0x004e:
            ATOMIC_HELPER = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = log
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            NULL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.a.<clinit>():void");
    }

    public static CancellationException b(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static void complete(a aVar) {
        e eVar = null;
        while (true) {
            aVar.f();
            aVar.afterDone();
            e c10 = aVar.c(eVar);
            while (true) {
                if (c10 != null) {
                    eVar = c10.f1578c;
                    Runnable runnable = c10.f1576a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        aVar = gVar.f1584a;
                        if (aVar.value == gVar) {
                            if (ATOMIC_HELPER.b(aVar, gVar, getFutureValue(gVar.f1585b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, c10.f1577b);
                    }
                    c10 = eVar;
                } else {
                    return;
                }
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof a) {
            Object obj = ((a) listenableFuture).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f1571a) {
                return obj;
            }
            if (cVar.f1572b != null) {
                return new c(false, cVar.f1572b);
            }
            return c.f1570d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return c.f1570d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
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

    static <V> V getUninterruptibly(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
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
        return v10;
    }

    public final void a(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(h(uninterruptibly));
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
        checkNotNull(runnable);
        checkNotNull(executor);
        e eVar = this.listeners;
        if (eVar != e.f1575d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f1578c = eVar;
                if (!ATOMIC_HELPER.a(this, eVar, eVar2)) {
                    eVar = this.listeners;
                } else {
                    return;
                }
            } while (eVar != e.f1575d);
        }
        d(runnable, executor);
    }

    public void afterDone() {
    }

    public final e c(e eVar) {
        e eVar2;
        do {
            eVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, eVar2, e.f1575d));
        e eVar3 = eVar2;
        e eVar4 = eVar;
        e eVar5 = eVar3;
        while (eVar5 != null) {
            e eVar6 = eVar5.f1578c;
            eVar5.f1578c = eVar4;
            eVar4 = eVar5;
            eVar5 = eVar6;
        }
        return eVar4;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.a.g
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.a$c r3 = new androidx.concurrent.futures.a$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.a$c r3 = androidx.concurrent.futures.a.c.f1569c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.a$c r3 = androidx.concurrent.futures.a.c.f1570d
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            androidx.concurrent.futures.a$b r6 = ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.a.g
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.a$g r0 = (androidx.concurrent.futures.a.g) r0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.f1585b
            boolean r4 = r0 instanceof androidx.concurrent.futures.a
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.a r4 = (androidx.concurrent.futures.a) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.a.g
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.concurrent.futures.a.g
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.a.cancel(boolean):boolean");
    }

    public final Object e(Object obj) {
        if (obj instanceof c) {
            throw b("Task was cancelled.", ((c) obj).f1572b);
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1574a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public final void f() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.f1586c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f1588b;
        }
    }

    public final void g(i iVar) {
        iVar.f1587a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 != i.f1586c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f1588b;
                    if (iVar2.f1587a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f1588b = iVar4;
                        if (iVar3.f1587a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    public final Object get(long j10, TimeUnit timeUnit) {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof g))) {
                return e(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                i iVar = this.waiters;
                if (iVar != i.f1586c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return e(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    g(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            g(iVar2);
                        } else {
                            iVar = this.waiters;
                        }
                    } while (iVar != i.f1586c);
                }
                return e(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return e(obj3);
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

    public final String h(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    public final boolean isDone() {
        boolean z10;
        Object obj = this.value;
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(obj instanceof g)) & z10;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(Future<?> future) {
        boolean z10;
        if (future != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof g) {
            return "setFuture=[" + h(((g) obj).f1585b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    public boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, obj)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new d((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<Object> listenableFuture) {
        g gVar;
        d dVar;
        checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            gVar = new g(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, (Object) null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, c.INSTANCE);
                } catch (Throwable unused) {
                    dVar = d.f1573b;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f1571a);
        }
        return false;
        ATOMIC_HELPER.b(this, gVar, dVar);
        return true;
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
                str = pendingToString();
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

    public final boolean wasInterrupted() {
        Object obj = this.value;
        if (!(obj instanceof c) || !((c) obj).f1571a) {
            return false;
        }
        return true;
    }

    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return e(obj2);
            }
            i iVar = this.waiters;
            if (iVar != i.f1586c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                g(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return e(obj);
                    }
                    iVar = this.waiters;
                } while (iVar != i.f1586c);
            }
            return e(this.value);
        }
        throw new InterruptedException();
    }
}
