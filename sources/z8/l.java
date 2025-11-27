package z8;

import com.google.common.base.Preconditions;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import y8.b;
import y8.c;
import y8.f;
import y8.k;
import y8.k1;
import y8.m;
import y8.v0;
import y8.w0;
import z8.m1;
import z8.t;

public final class l implements t {

    /* renamed from: a  reason: collision with root package name */
    public final t f20737a;

    /* renamed from: b  reason: collision with root package name */
    public final b f20738b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f20739c;

    public class a extends j0 {

        /* renamed from: a  reason: collision with root package name */
        public final v f20740a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20741b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f20742c = new AtomicInteger(ParamsMap.MirrorParams.CAPTRUESOURCE_FLAG_MIUI);

        /* renamed from: d  reason: collision with root package name */
        public volatile k1 f20743d;

        /* renamed from: e  reason: collision with root package name */
        public k1 f20744e;

        /* renamed from: f  reason: collision with root package name */
        public k1 f20745f;

        /* renamed from: g  reason: collision with root package name */
        public final m1.a f20746g = new C0304a();

        /* renamed from: z8.l$a$a  reason: collision with other inner class name */
        public class C0304a implements m1.a {
            public C0304a() {
            }

            public void onComplete() {
                if (a.this.f20742c.decrementAndGet() == 0) {
                    a.this.j();
                }
            }
        }

        public class b extends b.C0295b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ w0 f20749a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f20750b;

            public b(w0 w0Var, c cVar) {
                this.f20749a = w0Var;
                this.f20750b = cVar;
            }
        }

        public a(v vVar, String str) {
            this.f20740a = (v) Preconditions.checkNotNull(vVar, "delegate");
            this.f20741b = (String) Preconditions.checkNotNull(str, "authority");
        }

        public v a() {
            return this.f20740a;
        }

        public q b(w0 w0Var, v0 v0Var, c cVar, k[] kVarArr) {
            y8.b c10 = cVar.c();
            if (c10 == null) {
                c10 = l.this.f20738b;
            } else if (l.this.f20738b != null) {
                c10 = new m(l.this.f20738b, c10);
            }
            if (c10 != null) {
                m1 m1Var = new m1(this.f20740a, w0Var, v0Var, cVar, this.f20746g, kVarArr);
                if (this.f20742c.incrementAndGet() > 0) {
                    this.f20746g.onComplete();
                    return new f0(this.f20743d, kVarArr);
                }
                try {
                    c10.a(new b(w0Var, cVar), l.this.f20739c, m1Var);
                } catch (Throwable th) {
                    m1Var.a(k1.f20049n.r("Credentials should use fail() instead of throwing exceptions").q(th));
                }
                return m1Var.c();
            } else if (this.f20742c.get() >= 0) {
                return new f0(this.f20743d, kVarArr);
            } else {
                return this.f20740a.b(w0Var, v0Var, cVar, kVarArr);
            }
        }

        public void c(k1 k1Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            synchronized (this) {
                if (this.f20742c.get() < 0) {
                    this.f20743d = k1Var;
                    this.f20742c.addAndGet(Integer.MAX_VALUE);
                    if (this.f20742c.get() != 0) {
                        this.f20744e = k1Var;
                    } else {
                        super.c(k1Var);
                    }
                }
            }
        }

        public void g(k1 k1Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            synchronized (this) {
                if (this.f20742c.get() < 0) {
                    this.f20743d = k1Var;
                    this.f20742c.addAndGet(Integer.MAX_VALUE);
                } else if (this.f20745f != null) {
                    return;
                }
                if (this.f20742c.get() != 0) {
                    this.f20745f = k1Var;
                } else {
                    super.g(k1Var);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            super.g(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r0 == null) goto L_0x001a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            super.c(r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void j() {
            /*
                r3 = this;
                monitor-enter(r3)
                java.util.concurrent.atomic.AtomicInteger r0 = r3.f20742c     // Catch:{ all -> 0x0020 }
                int r0 = r0.get()     // Catch:{ all -> 0x0020 }
                if (r0 == 0) goto L_0x000b
                monitor-exit(r3)     // Catch:{ all -> 0x0020 }
                return
            L_0x000b:
                y8.k1 r0 = r3.f20744e     // Catch:{ all -> 0x0020 }
                y8.k1 r1 = r3.f20745f     // Catch:{ all -> 0x0020 }
                r2 = 0
                r3.f20744e = r2     // Catch:{ all -> 0x0020 }
                r3.f20745f = r2     // Catch:{ all -> 0x0020 }
                monitor-exit(r3)     // Catch:{ all -> 0x0020 }
                if (r0 == 0) goto L_0x001a
                super.c(r0)
            L_0x001a:
                if (r1 == 0) goto L_0x001f
                super.g(r1)
            L_0x001f:
                return
            L_0x0020:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0020 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.l.a.j():void");
        }
    }

    public l(t tVar, b bVar, Executor executor) {
        this.f20737a = (t) Preconditions.checkNotNull(tVar, "delegate");
        this.f20738b = bVar;
        this.f20739c = (Executor) Preconditions.checkNotNull(executor, "appExecutor");
    }

    public v J(SocketAddress socketAddress, t.a aVar, f fVar) {
        return new a(this.f20737a.J(socketAddress, aVar, fVar), aVar.a());
    }

    public void close() {
        this.f20737a.close();
    }

    public ScheduledExecutorService p() {
        return this.f20737a.p();
    }
}
