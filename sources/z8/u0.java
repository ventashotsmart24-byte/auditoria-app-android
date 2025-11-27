package z8;

import com.google.common.base.Stopwatch;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import z8.s;

public class u0 {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f20980g = Logger.getLogger(u0.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final long f20981a;

    /* renamed from: b  reason: collision with root package name */
    public final Stopwatch f20982b;

    /* renamed from: c  reason: collision with root package name */
    public Map f20983c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public boolean f20984d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f20985e;

    /* renamed from: f  reason: collision with root package name */
    public long f20986f;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s.a f20987a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f20988b;

        public a(s.a aVar, long j10) {
            this.f20987a = aVar;
            this.f20988b = j10;
        }

        public void run() {
            this.f20987a.a(this.f20988b);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s.a f20989a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Throwable f20990b;

        public b(s.a aVar, Throwable th) {
            this.f20989a = aVar;
            this.f20990b = th;
        }

        public void run() {
            this.f20989a.onFailure(this.f20990b);
        }
    }

    public u0(long j10, Stopwatch stopwatch) {
        this.f20981a = j10;
        this.f20982b = stopwatch;
    }

    public static Runnable b(s.a aVar, long j10) {
        return new a(aVar, j10);
    }

    public static Runnable c(s.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f20980g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(s.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        e(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(z8.s.a r3, java.util.concurrent.Executor r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f20984d     // Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x000c
            java.util.Map r0 = r2.f20983c     // Catch:{ all -> 0x0020 }
            r0.put(r3, r4)     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            return
        L_0x000c:
            java.lang.Throwable r0 = r2.f20985e     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0015
            java.lang.Runnable r3 = c(r3, r0)     // Catch:{ all -> 0x0020 }
            goto L_0x001b
        L_0x0015:
            long r0 = r2.f20986f     // Catch:{ all -> 0x0020 }
            java.lang.Runnable r3 = b(r3, r0)     // Catch:{ all -> 0x0020 }
        L_0x001b:
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            e(r4, r3)
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.u0.a(z8.s$a, java.util.concurrent.Executor):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r3.hasNext() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        r4 = (java.util.Map.Entry) r3.next();
        e((java.util.concurrent.Executor) r4.getValue(), b((z8.s.a) r4.getKey(), r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r3 = r3.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f20984d     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0008
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            r0 = 0
            return r0
        L_0x0008:
            r0 = 1
            r6.f20984d = r0     // Catch:{ all -> 0x0044 }
            com.google.common.base.Stopwatch r1 = r6.f20982b     // Catch:{ all -> 0x0044 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x0044 }
            long r1 = r1.elapsed(r2)     // Catch:{ all -> 0x0044 }
            r6.f20986f = r1     // Catch:{ all -> 0x0044 }
            java.util.Map r3 = r6.f20983c     // Catch:{ all -> 0x0044 }
            r4 = 0
            r6.f20983c = r4     // Catch:{ all -> 0x0044 }
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0023:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0043
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            java.util.concurrent.Executor r5 = (java.util.concurrent.Executor) r5
            java.lang.Object r4 = r4.getKey()
            z8.s$a r4 = (z8.s.a) r4
            java.lang.Runnable r4 = b(r4, r1)
            e(r5, r4)
            goto L_0x0023
        L_0x0043:
            return r0
        L_0x0044:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0047:
            throw r0
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.u0.d():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r0.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r1 = (java.util.Map.Entry) r0.next();
        g((z8.s.a) r1.getKey(), (java.util.concurrent.Executor) r1.getValue(), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r0 = r0.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.lang.Throwable r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f20984d     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            return
        L_0x0007:
            r0 = 1
            r3.f20984d = r0     // Catch:{ all -> 0x0037 }
            r3.f20985e = r4     // Catch:{ all -> 0x0037 }
            java.util.Map r0 = r3.f20983c     // Catch:{ all -> 0x0037 }
            r1 = 0
            r3.f20983c = r1     // Catch:{ all -> 0x0037 }
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            z8.s$a r2 = (z8.s.a) r2
            java.lang.Object r1 = r1.getValue()
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            g(r2, r1, r4)
            goto L_0x001a
        L_0x0036:
            return
        L_0x0037:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x003a:
            throw r4
        L_0x003b:
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.u0.f(java.lang.Throwable):void");
    }

    public long h() {
        return this.f20981a;
    }
}
