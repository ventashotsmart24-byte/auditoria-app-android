package z8;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import y8.r0;

public final class h1 extends l0 {

    /* renamed from: c  reason: collision with root package name */
    public static final ReferenceQueue f20672c = new ReferenceQueue();

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentMap f20673d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f20674e = Logger.getLogger(h1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public final a f20675b;

    public static final class a extends WeakReference {

        /* renamed from: f  reason: collision with root package name */
        public static final boolean f20676f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* renamed from: g  reason: collision with root package name */
        public static final RuntimeException f20677g = c();

        /* renamed from: a  reason: collision with root package name */
        public final ReferenceQueue f20678a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentMap f20679b;

        /* renamed from: c  reason: collision with root package name */
        public final String f20680c;

        /* renamed from: d  reason: collision with root package name */
        public final Reference f20681d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f20682e = new AtomicBoolean();

        public a(h1 h1Var, r0 r0Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
            super(h1Var, referenceQueue);
            RuntimeException runtimeException;
            if (f20676f) {
                runtimeException = new RuntimeException("ManagedChannel allocation site");
            } else {
                runtimeException = f20677g;
            }
            this.f20681d = new SoftReference(runtimeException);
            this.f20680c = r0Var.toString();
            this.f20678a = referenceQueue;
            this.f20679b = concurrentMap;
            concurrentMap.put(this, this);
            a(referenceQueue);
        }

        public static int a(ReferenceQueue referenceQueue) {
            int i10 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i10;
                }
                RuntimeException runtimeException = (RuntimeException) aVar.f20681d.get();
                aVar.b();
                if (!aVar.f20682e.get()) {
                    i10++;
                    Level level = Level.SEVERE;
                    if (h1.f20674e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        logRecord.setLoggerName(h1.f20674e.getName());
                        logRecord.setParameters(new Object[]{aVar.f20680c});
                        logRecord.setThrown(runtimeException);
                        h1.f20674e.log(logRecord);
                    }
                }
            }
        }

        public static RuntimeException c() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void b() {
            super.clear();
            this.f20679b.remove(this);
            this.f20681d.clear();
        }

        public void clear() {
            b();
            a(this.f20678a);
        }
    }

    public h1(r0 r0Var) {
        this(r0Var, f20672c, f20673d);
    }

    public h1(r0 r0Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(r0Var);
        this.f20675b = new a(this, r0Var, referenceQueue, concurrentMap);
    }
}
