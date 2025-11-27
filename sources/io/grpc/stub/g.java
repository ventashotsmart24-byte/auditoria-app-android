package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.c;
import y8.g;
import y8.k1;
import y8.l1;
import y8.m1;
import y8.v0;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f17435a = Logger.getLogger(g.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static boolean f17436b;

    /* renamed from: c  reason: collision with root package name */
    public static final c.C0296c f17437c = c.C0296c.b("internal-stub-type");

    public static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        public boolean f17438a;

        /* renamed from: b  reason: collision with root package name */
        public final y8.g f17439b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f17440c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f17441d;

        /* renamed from: e  reason: collision with root package name */
        public int f17442e = 1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17443f = true;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17444g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17445h = false;

        public b(y8.g gVar, boolean z10) {
            this.f17439b = gVar;
            this.f17440c = z10;
        }

        public final void f() {
            this.f17438a = true;
        }

        public void g(int i10) {
            if (this.f17440c || i10 != 1) {
                this.f17439b.c(i10);
            } else {
                this.f17439b.c(2);
            }
        }

        public void onCompleted() {
            this.f17439b.b();
            this.f17445h = true;
        }

        public void onError(Throwable th) {
            this.f17439b.a("Cancelled by client with StreamObserver.onError()", th);
            this.f17444g = true;
        }

        public void onNext(Object obj) {
            Preconditions.checkState(!this.f17444g, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.f17445h, "Stream is already completed, no further calls are allowed");
            this.f17439b.d(obj);
        }
    }

    public static final class c extends AbstractFuture {

        /* renamed from: a  reason: collision with root package name */
        public final y8.g f17446a;

        public c(y8.g gVar) {
            this.f17446a = gVar;
        }

        public void interruptTask() {
            this.f17446a.a("GrpcFuture was cancelled", (Throwable) null);
        }

        public String pendingToString() {
            return MoreObjects.toStringHelper((Object) this).add("clientCall", (Object) this.f17446a).toString();
        }

        public boolean set(Object obj) {
            return super.set(obj);
        }

        public boolean setException(Throwable th) {
            return super.setException(th);
        }
    }

    public static abstract class d extends g.a {
        public d() {
        }

        public abstract void e();
    }

    public static final class e extends d {

        /* renamed from: a  reason: collision with root package name */
        public final j f17447a;

        /* renamed from: b  reason: collision with root package name */
        public final b f17448b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17449c;

        public e(j jVar, b bVar) {
            super();
            this.f17447a = jVar;
            this.f17448b = bVar;
            bVar.f();
        }

        public void a(k1 k1Var, v0 v0Var) {
            if (k1Var.p()) {
                this.f17447a.onCompleted();
            } else {
                this.f17447a.onError(k1Var.e(v0Var));
            }
        }

        public void b(v0 v0Var) {
        }

        public void c(Object obj) {
            if (!this.f17449c || this.f17448b.f17440c) {
                this.f17449c = true;
                this.f17447a.onNext(obj);
                if (this.f17448b.f17440c && this.f17448b.f17443f) {
                    this.f17448b.g(1);
                    return;
                }
                return;
            }
            throw k1.f20055t.r("More than one responses received for unary or client-streaming call").d();
        }

        public void d() {
            if (this.f17448b.f17441d != null) {
                this.f17448b.f17441d.run();
            }
        }

        public void e() {
            if (this.f17448b.f17442e > 0) {
                b bVar = this.f17448b;
                bVar.g(bVar.f17442e);
            }
        }
    }

    public enum f {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    /* renamed from: io.grpc.stub.g$g  reason: collision with other inner class name */
    public static final class C0230g extends ConcurrentLinkedQueue implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public static final Logger f17454b = Logger.getLogger(C0230g.class.getName());

        /* renamed from: c  reason: collision with root package name */
        public static final Object f17455c = new Object();

        /* renamed from: a  reason: collision with root package name */
        public volatile Object f17456a;

        public static void a(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th) {
                f17454b.log(Level.WARNING, "Runnable threw exception", th);
            }
        }

        public static void b() {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        /* JADX INFO: finally extract failed */
        public void c() {
            Runnable runnable;
            b();
            Runnable runnable2 = (Runnable) poll();
            if (runnable2 == null) {
                this.f17456a = Thread.currentThread();
                while (true) {
                    try {
                        runnable = (Runnable) poll();
                        if (runnable != null) {
                            break;
                        }
                        LockSupport.park(this);
                        b();
                    } catch (Throwable th) {
                        this.f17456a = null;
                        throw th;
                    }
                }
                this.f17456a = null;
                runnable2 = runnable;
            }
            do {
                a(runnable2);
                runnable2 = (Runnable) poll();
            } while (runnable2 != null);
        }

        public void execute(Runnable runnable) {
            add(runnable);
            Object obj = this.f17456a;
            if (obj != f17455c) {
                LockSupport.unpark((Thread) obj);
            } else if (remove(runnable) && g.f17436b) {
                throw new RejectedExecutionException();
            }
        }

        public void shutdown() {
            this.f17456a = f17455c;
            while (true) {
                Runnable runnable = (Runnable) poll();
                if (runnable != null) {
                    a(runnable);
                } else {
                    return;
                }
            }
        }
    }

    public static final class h extends d {

        /* renamed from: a  reason: collision with root package name */
        public final c f17457a;

        /* renamed from: b  reason: collision with root package name */
        public Object f17458b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17459c = false;

        public h(c cVar) {
            super();
            this.f17457a = cVar;
        }

        public void a(k1 k1Var, v0 v0Var) {
            if (k1Var.p()) {
                if (!this.f17459c) {
                    this.f17457a.setException(k1.f20055t.r("No value received for unary call").e(v0Var));
                }
                this.f17457a.set(this.f17458b);
                return;
            }
            this.f17457a.setException(k1Var.e(v0Var));
        }

        public void b(v0 v0Var) {
        }

        public void c(Object obj) {
            if (!this.f17459c) {
                this.f17458b = obj;
                this.f17459c = true;
                return;
            }
            throw k1.f20055t.r("More than one value received for unary call").d();
        }

        public void e() {
            this.f17457a.f17446a.c(2);
        }
    }

    static {
        boolean z10;
        if (Strings.isNullOrEmpty(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) || !Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"))) {
            z10 = false;
        } else {
            z10 = true;
        }
        f17436b = z10;
    }

    public static void a(y8.g gVar, Object obj, j jVar) {
        c(gVar, obj, jVar, false);
    }

    public static void b(y8.g gVar, Object obj, d dVar) {
        h(gVar, dVar);
        try {
            gVar.d(obj);
            gVar.b();
        } catch (RuntimeException e10) {
            throw e(gVar, e10);
        } catch (Error e11) {
            throw e(gVar, e11);
        }
    }

    public static void c(y8.g gVar, Object obj, j jVar, boolean z10) {
        b(gVar, obj, new e(jVar, new b(gVar, z10)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object d(y8.d r3, y8.w0 r4, y8.c r5, java.lang.Object r6) {
        /*
            io.grpc.stub.g$g r0 = new io.grpc.stub.g$g
            r0.<init>()
            y8.c$c r1 = f17437c
            io.grpc.stub.g$f r2 = io.grpc.stub.g.f.BLOCKING
            y8.c r5 = r5.s(r1, r2)
            y8.c r5 = r5.p(r0)
            y8.g r3 = r3.h(r4, r5)
            r4 = 0
            com.google.common.util.concurrent.ListenableFuture r5 = f(r3, r6)     // Catch:{ RuntimeException -> 0x004f, Error -> 0x0049 }
        L_0x001a:
            boolean r6 = r5.isDone()     // Catch:{ RuntimeException -> 0x004f, Error -> 0x0049 }
            if (r6 != 0) goto L_0x0036
            r0.c()     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x001a
        L_0x0024:
            r4 = move-exception
            r6 = 1
            java.lang.String r1 = "Thread interrupted"
            r3.a(r1, r4)     // Catch:{ RuntimeException -> 0x0033, Error -> 0x0030, all -> 0x002d }
            r4 = 1
            goto L_0x001a
        L_0x002d:
            r3 = move-exception
            r4 = 1
            goto L_0x0055
        L_0x0030:
            r5 = move-exception
            r4 = 1
            goto L_0x004a
        L_0x0033:
            r5 = move-exception
            r4 = 1
            goto L_0x0050
        L_0x0036:
            r0.shutdown()     // Catch:{ RuntimeException -> 0x004f, Error -> 0x0049 }
            java.lang.Object r3 = g(r5)     // Catch:{ RuntimeException -> 0x004f, Error -> 0x0049 }
            if (r4 == 0) goto L_0x0046
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x0046:
            return r3
        L_0x0047:
            r3 = move-exception
            goto L_0x0055
        L_0x0049:
            r5 = move-exception
        L_0x004a:
            java.lang.RuntimeException r3 = e(r3, r5)     // Catch:{ all -> 0x0047 }
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x004f:
            r5 = move-exception
        L_0x0050:
            java.lang.RuntimeException r3 = e(r3, r5)     // Catch:{ all -> 0x0047 }
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x0055:
            if (r4 == 0) goto L_0x005e
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x005e:
            goto L_0x0060
        L_0x005f:
            throw r3
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.stub.g.d(y8.d, y8.w0, y8.c, java.lang.Object):java.lang.Object");
    }

    public static RuntimeException e(y8.g gVar, Throwable th) {
        try {
            gVar.a((String) null, th);
        } catch (Throwable th2) {
            f17435a.log(Level.SEVERE, "RuntimeException encountered while closing call", th2);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else {
            throw new AssertionError(th);
        }
    }

    public static ListenableFuture f(y8.g gVar, Object obj) {
        c cVar = new c(gVar);
        b(gVar, obj, new h(cVar));
        return cVar;
    }

    public static Object g(Future future) {
        try {
            return future.get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw k1.f20042g.r("Thread interrupted").q(e10).d();
        } catch (ExecutionException e11) {
            throw i(e11.getCause());
        }
    }

    public static void h(y8.g gVar, d dVar) {
        gVar.e(dVar, new v0());
        dVar.e();
    }

    public static m1 i(Throwable th) {
        Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t");
        while (th2 != null) {
            if (th2 instanceof l1) {
                l1 l1Var = (l1) th2;
                return new m1(l1Var.a(), l1Var.b());
            } else if (th2 instanceof m1) {
                m1 m1Var = (m1) th2;
                return new m1(m1Var.a(), m1Var.b());
            } else {
                th2 = th2.getCause();
            }
        }
        return k1.f20043h.r("unexpected exception").q(th).d();
    }
}
