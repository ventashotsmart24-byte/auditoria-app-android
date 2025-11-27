package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.hpplay.sdk.source.common.global.Constant;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.a0;
import y8.k1;
import y8.n;
import y8.t;
import y8.v;
import y8.v0;
import z8.d;
import z8.l1;
import z8.r;

public abstract class a extends d implements q, l1.d {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f20280g = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final m2 f20281a;

    /* renamed from: b  reason: collision with root package name */
    public final o0 f20282b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20283c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20284d;

    /* renamed from: e  reason: collision with root package name */
    public v0 f20285e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f20286f;

    /* renamed from: z8.a$a  reason: collision with other inner class name */
    public class C0300a implements o0 {

        /* renamed from: a  reason: collision with root package name */
        public v0 f20287a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20288b;

        /* renamed from: c  reason: collision with root package name */
        public final g2 f20289c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f20290d;

        public C0300a(v0 v0Var, g2 g2Var) {
            this.f20287a = (v0) Preconditions.checkNotNull(v0Var, "headers");
            this.f20289c = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        }

        public o0 a(n nVar) {
            return this;
        }

        public void b(InputStream inputStream) {
            boolean z10;
            if (this.f20290d == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "writePayload should not be called multiple times");
            try {
                this.f20290d = ByteStreams.toByteArray(inputStream);
                this.f20289c.i(0);
                g2 g2Var = this.f20289c;
                byte[] bArr = this.f20290d;
                g2Var.j(0, (long) bArr.length, (long) bArr.length);
                this.f20289c.k((long) this.f20290d.length);
                this.f20289c.l((long) this.f20290d.length);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        public void close() {
            boolean z10 = true;
            this.f20288b = true;
            if (this.f20290d == null) {
                z10 = false;
            }
            Preconditions.checkState(z10, "Lack of request message. GET request is only supported for unary requests");
            a.this.u().f(this.f20287a, this.f20290d);
            this.f20290d = null;
            this.f20287a = null;
        }

        public void d(int i10) {
        }

        public void flush() {
        }

        public boolean isClosed() {
            return this.f20288b;
        }
    }

    public interface b {
        void e(k1 k1Var);

        void f(v0 v0Var, byte[] bArr);

        void g(n2 n2Var, boolean z10, boolean z11, int i10);
    }

    public static abstract class c extends d.a {

        /* renamed from: i  reason: collision with root package name */
        public final g2 f20292i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f20293j;

        /* renamed from: k  reason: collision with root package name */
        public r f20294k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f20295l;

        /* renamed from: m  reason: collision with root package name */
        public v f20296m = v.c();

        /* renamed from: n  reason: collision with root package name */
        public boolean f20297n = false;

        /* renamed from: o  reason: collision with root package name */
        public Runnable f20298o;

        /* renamed from: p  reason: collision with root package name */
        public volatile boolean f20299p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f20300q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f20301r;

        /* renamed from: z8.a$c$a  reason: collision with other inner class name */
        public class C0301a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k1 f20302a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ r.a f20303b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ v0 f20304c;

            public C0301a(k1 k1Var, r.a aVar, v0 v0Var) {
                this.f20302a = k1Var;
                this.f20303b = aVar;
                this.f20304c = v0Var;
            }

            public void run() {
                c.this.C(this.f20302a, this.f20303b, this.f20304c);
            }
        }

        public c(int i10, g2 g2Var, m2 m2Var) {
            super(i10, g2Var, m2Var);
            this.f20292i = (g2) Preconditions.checkNotNull(g2Var, "statsTraceCtx");
        }

        public final void C(k1 k1Var, r.a aVar, v0 v0Var) {
            if (!this.f20293j) {
                this.f20293j = true;
                this.f20292i.m(k1Var);
                o().c(k1Var, aVar, v0Var);
                if (m() != null) {
                    m().f(k1Var.p());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void D(z8.t1 r5) {
            /*
                r4 = this;
                java.lang.String r0 = "frame"
                com.google.common.base.Preconditions.checkNotNull(r5, r0)
                r0 = 1
                boolean r1 = r4.f20300q     // Catch:{ all -> 0x0020 }
                if (r1 == 0) goto L_0x0019
                java.util.logging.Logger r1 = z8.a.f20280g     // Catch:{ all -> 0x0020 }
                java.util.logging.Level r2 = java.util.logging.Level.INFO     // Catch:{ all -> 0x0020 }
                java.lang.String r3 = "Received data on closed stream"
                r1.log(r2, r3)     // Catch:{ all -> 0x0020 }
                r5.close()
                return
            L_0x0019:
                r4.l(r5)     // Catch:{ all -> 0x001d }
                return
            L_0x001d:
                r1 = move-exception
                r0 = 0
                goto L_0x0021
            L_0x0020:
                r1 = move-exception
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r5.close()
            L_0x0026:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.a.c.D(z8.t1):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void E(y8.v0 r6) {
            /*
                r5 = this;
                boolean r0 = r5.f20300q
                r1 = 1
                r0 = r0 ^ r1
                java.lang.String r2 = "Received headers on closed stream"
                com.google.common.base.Preconditions.checkState(r0, r2)
                z8.g2 r0 = r5.f20292i
                r0.a()
                y8.v0$g r0 = z8.q0.f20878g
                java.lang.Object r0 = r6.g(r0)
                java.lang.String r0 = (java.lang.String) r0
                boolean r2 = r5.f20295l
                r3 = 0
                if (r2 == 0) goto L_0x004f
                if (r0 == 0) goto L_0x004f
                java.lang.String r2 = "gzip"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 == 0) goto L_0x002f
                z8.r0 r0 = new z8.r0
                r0.<init>()
                r5.w(r0)
                r0 = 1
                goto L_0x0050
            L_0x002f:
                java.lang.String r2 = "identity"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 != 0) goto L_0x004f
                y8.k1 r6 = y8.k1.f20055t
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r3] = r0
                java.lang.String r0 = "Can't find full stream decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r0, r1)
                y8.k1 r6 = r6.r(r0)
                y8.m1 r6 = r6.d()
                r5.d(r6)
                return
            L_0x004f:
                r0 = 0
            L_0x0050:
                y8.v0$g r2 = z8.q0.f20876e
                java.lang.Object r2 = r6.g(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L_0x0093
                y8.v r4 = r5.f20296m
                y8.u r4 = r4.e(r2)
                if (r4 != 0) goto L_0x007a
                y8.k1 r6 = y8.k1.f20055t
                java.lang.Object[] r0 = new java.lang.Object[r1]
                r0[r3] = r2
                java.lang.String r1 = "Can't find decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                y8.k1 r6 = r6.r(r0)
                y8.m1 r6 = r6.d()
                r5.d(r6)
                return
            L_0x007a:
                y8.l r1 = y8.l.b.f20085a
                if (r4 == r1) goto L_0x0093
                if (r0 == 0) goto L_0x0090
                y8.k1 r6 = y8.k1.f20055t
                java.lang.String r0 = "Full stream and gRPC message encoding cannot both be set"
                y8.k1 r6 = r6.r(r0)
                y8.m1 r6 = r6.d()
                r5.d(r6)
                return
            L_0x0090:
                r5.v(r4)
            L_0x0093:
                z8.r r0 = r5.o()
                r0.b(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.a.c.E(y8.v0):void");
        }

        public void F(v0 v0Var, k1 k1Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            Preconditions.checkNotNull(v0Var, "trailers");
            if (this.f20300q) {
                a.f20280g.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{k1Var, v0Var});
                return;
            }
            this.f20292i.b(v0Var);
            N(k1Var, false, v0Var);
        }

        public final boolean G() {
            return this.f20299p;
        }

        /* renamed from: H */
        public final r o() {
            return this.f20294k;
        }

        public final void I(v vVar) {
            boolean z10;
            if (this.f20294k == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Already called start");
            this.f20296m = (v) Preconditions.checkNotNull(vVar, "decompressorRegistry");
        }

        public final void J(boolean z10) {
            this.f20295l = z10;
        }

        public final void K(r rVar) {
            boolean z10;
            if (this.f20294k == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Already called setListener");
            this.f20294k = (r) Preconditions.checkNotNull(rVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public final void L() {
            this.f20299p = true;
        }

        public final void M(k1 k1Var, r.a aVar, boolean z10, v0 v0Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            Preconditions.checkNotNull(v0Var, "trailers");
            if (!this.f20300q || z10) {
                this.f20300q = true;
                this.f20301r = k1Var.p();
                s();
                if (this.f20297n) {
                    this.f20298o = null;
                    C(k1Var, aVar, v0Var);
                    return;
                }
                this.f20298o = new C0301a(k1Var, aVar, v0Var);
                k(z10);
            }
        }

        public final void N(k1 k1Var, boolean z10, v0 v0Var) {
            M(k1Var, r.a.PROCESSED, z10, v0Var);
        }

        public void e(boolean z10) {
            Preconditions.checkState(this.f20300q, "status should have been reported on deframer closed");
            this.f20297n = true;
            if (this.f20301r && z10) {
                N(k1.f20055t.r("Encountered end-of-stream mid-frame"), true, new v0());
            }
            Runnable runnable = this.f20298o;
            if (runnable != null) {
                runnable.run();
                this.f20298o = null;
            }
        }
    }

    public a(o2 o2Var, g2 g2Var, m2 m2Var, v0 v0Var, y8.c cVar, boolean z10) {
        Preconditions.checkNotNull(v0Var, "headers");
        this.f20281a = (m2) Preconditions.checkNotNull(m2Var, "transportTracer");
        this.f20283c = q0.o(cVar);
        this.f20284d = z10;
        if (!z10) {
            this.f20282b = new l1(this, o2Var, g2Var);
            this.f20285e = v0Var;
            return;
        }
        this.f20282b = new C0300a(v0Var, g2Var);
    }

    public void c(int i10) {
        y().x(i10);
    }

    public void d(int i10) {
        this.f20282b.d(i10);
    }

    public final void e(k1 k1Var) {
        Preconditions.checkArgument(!k1Var.p(), "Should not cancel with OK status");
        this.f20286f = true;
        u().e(k1Var);
    }

    public final void f(n2 n2Var, boolean z10, boolean z11, int i10) {
        boolean z12;
        if (n2Var != null || z10) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "null frame before EOS");
        u().g(n2Var, z10, z11, i10);
    }

    public final void g(r rVar) {
        y().K(rVar);
        if (!this.f20284d) {
            u().f(this.f20285e, (byte[]) null);
            this.f20285e = null;
        }
    }

    public final void j(boolean z10) {
        y().J(z10);
    }

    public void k(t tVar) {
        v0 v0Var = this.f20285e;
        v0.g gVar = q0.f20875d;
        v0Var.e(gVar);
        this.f20285e.o(gVar, Long.valueOf(Math.max(0, tVar.i(TimeUnit.NANOSECONDS))));
    }

    public final void l(v vVar) {
        y().I(vVar);
    }

    public final boolean m() {
        if (!super.m() || this.f20286f) {
            return false;
        }
        return true;
    }

    public final void o() {
        if (!y().G()) {
            y().L();
            q();
        }
    }

    public final void p(w0 w0Var) {
        w0Var.b("remote_addr", getAttributes().b(a0.f19928a));
    }

    public final o0 r() {
        return this.f20282b;
    }

    public abstract b u();

    public m2 w() {
        return this.f20281a;
    }

    public final boolean x() {
        return this.f20283c;
    }

    public abstract c y();
}
