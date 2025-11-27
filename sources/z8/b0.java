package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.push.IPushHandler;
import com.taobao.accs.common.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import y8.k1;
import y8.t;
import y8.v;
import y8.v0;
import z8.i2;
import z8.r;

public class b0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f20335a;

    /* renamed from: b  reason: collision with root package name */
    public r f20336b;

    /* renamed from: c  reason: collision with root package name */
    public q f20337c;

    /* renamed from: d  reason: collision with root package name */
    public k1 f20338d;

    /* renamed from: e  reason: collision with root package name */
    public List f20339e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public o f20340f;

    /* renamed from: g  reason: collision with root package name */
    public long f20341g;

    /* renamed from: h  reason: collision with root package name */
    public long f20342h;

    /* renamed from: i  reason: collision with root package name */
    public List f20343i = new ArrayList();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20344a;

        public a(int i10) {
            this.f20344a = i10;
        }

        public void run() {
            b0.this.f20337c.b(this.f20344a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            b0.this.f20337c.i();
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8.n f20347a;

        public c(y8.n nVar) {
            this.f20347a = nVar;
        }

        public void run() {
            b0.this.f20337c.a(this.f20347a);
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f20349a;

        public d(boolean z10) {
            this.f20349a = z10;
        }

        public void run() {
            b0.this.f20337c.j(this.f20349a);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f20351a;

        public e(v vVar) {
            this.f20351a = vVar;
        }

        public void run() {
            b0.this.f20337c.l(this.f20351a);
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20353a;

        public f(int i10) {
            this.f20353a = i10;
        }

        public void run() {
            b0.this.f20337c.c(this.f20353a);
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20355a;

        public g(int i10) {
            this.f20355a = i10;
        }

        public void run() {
            b0.this.f20337c.d(this.f20355a);
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f20357a;

        public h(t tVar) {
            this.f20357a = tVar;
        }

        public void run() {
            b0.this.f20337c.k(this.f20357a);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            b0.this.s();
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20360a;

        public j(String str) {
            this.f20360a = str;
        }

        public void run() {
            b0.this.f20337c.n(this.f20360a);
        }
    }

    public class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InputStream f20362a;

        public k(InputStream inputStream) {
            this.f20362a = inputStream;
        }

        public void run() {
            b0.this.f20337c.h(this.f20362a);
        }
    }

    public class l implements Runnable {
        public l() {
        }

        public void run() {
            b0.this.f20337c.flush();
        }
    }

    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k1 f20365a;

        public m(k1 k1Var) {
            this.f20365a = k1Var;
        }

        public void run() {
            b0.this.f20337c.e(this.f20365a);
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            b0.this.f20337c.o();
        }
    }

    public static class o implements r {

        /* renamed from: a  reason: collision with root package name */
        public final r f20368a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f20369b;

        /* renamed from: c  reason: collision with root package name */
        public List f20370c = new ArrayList();

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ i2.a f20371a;

            public a(i2.a aVar) {
                this.f20371a = aVar;
            }

            public void run() {
                o.this.f20368a.a(this.f20371a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                o.this.f20368a.d();
            }
        }

        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v0 f20374a;

            public c(v0 v0Var) {
                this.f20374a = v0Var;
            }

            public void run() {
                o.this.f20368a.b(this.f20374a);
            }
        }

        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k1 f20376a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ r.a f20377b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ v0 f20378c;

            public d(k1 k1Var, r.a aVar, v0 v0Var) {
                this.f20376a = k1Var;
                this.f20377b = aVar;
                this.f20378c = v0Var;
            }

            public void run() {
                o.this.f20368a.c(this.f20376a, this.f20377b, this.f20378c);
            }
        }

        public o(r rVar) {
            this.f20368a = rVar;
        }

        public void a(i2.a aVar) {
            if (this.f20369b) {
                this.f20368a.a(aVar);
            } else {
                f(new a(aVar));
            }
        }

        public void b(v0 v0Var) {
            f(new c(v0Var));
        }

        public void c(k1 k1Var, r.a aVar, v0 v0Var) {
            f(new d(k1Var, aVar, v0Var));
        }

        public void d() {
            if (this.f20369b) {
                this.f20368a.d();
            } else {
                f(new b());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (!this.f20369b) {
                    this.f20370c.add(runnable);
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
                java.util.List r1 = r3.f20370c     // Catch:{ all -> 0x0034 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0034 }
                if (r1 == 0) goto L_0x0016
                r0 = 0
                r3.f20370c = r0     // Catch:{ all -> 0x0034 }
                r0 = 1
                r3.f20369b = r0     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0016:
                java.util.List r1 = r3.f20370c     // Catch:{ all -> 0x0034 }
                r3.f20370c = r0     // Catch:{ all -> 0x0034 }
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
            throw new UnsupportedOperationException("Method not decompiled: z8.b0.o.g():void");
        }
    }

    public void a(y8.n nVar) {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        Preconditions.checkNotNull(nVar, "compressor");
        this.f20343i.add(new c(nVar));
    }

    public void b(int i10) {
        boolean z10;
        if (this.f20336b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called after start");
        if (this.f20335a) {
            this.f20337c.b(i10);
        } else {
            r(new a(i10));
        }
    }

    public void c(int i10) {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        this.f20343i.add(new f(i10));
    }

    public void d(int i10) {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        this.f20343i.add(new g(i10));
    }

    public void e(k1 k1Var) {
        boolean z10;
        boolean z11 = true;
        if (this.f20336b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called after start");
        Preconditions.checkNotNull(k1Var, IPushHandler.REASON);
        synchronized (this) {
            if (this.f20337c == null) {
                v(n1.f20805a);
                this.f20338d = k1Var;
                z11 = false;
            }
        }
        if (z11) {
            r(new m(k1Var));
            return;
        }
        s();
        u(k1Var);
        this.f20336b.c(k1Var, r.a.PROCESSED, new v0());
    }

    public void flush() {
        boolean z10;
        if (this.f20336b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called after start");
        if (this.f20335a) {
            this.f20337c.flush();
        } else {
            r(new l());
        }
    }

    public void g(r rVar) {
        boolean z10;
        k1 k1Var;
        boolean z11;
        Preconditions.checkNotNull(rVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "already started");
        synchronized (this) {
            k1Var = this.f20338d;
            z11 = this.f20335a;
            if (!z11) {
                o oVar = new o(rVar);
                this.f20340f = oVar;
                rVar = oVar;
            }
            this.f20336b = rVar;
            this.f20341g = System.nanoTime();
        }
        if (k1Var != null) {
            rVar.c(k1Var, r.a.PROCESSED, new v0());
        } else if (z11) {
            t(rVar);
        }
    }

    public void h(InputStream inputStream) {
        boolean z10;
        if (this.f20336b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called after start");
        Preconditions.checkNotNull(inputStream, Constants.SHARED_MESSAGE_ID_FILE);
        if (this.f20335a) {
            this.f20337c.h(inputStream);
        } else {
            r(new k(inputStream));
        }
    }

    public void i() {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        this.f20343i.add(new b());
    }

    public void j(boolean z10) {
        boolean z11;
        if (this.f20336b == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "May only be called before start");
        this.f20343i.add(new d(z10));
    }

    public void k(t tVar) {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        this.f20343i.add(new h(tVar));
    }

    public void l(v vVar) {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        Preconditions.checkNotNull(vVar, "decompressorRegistry");
        this.f20343i.add(new e(vVar));
    }

    public boolean m() {
        if (this.f20335a) {
            return this.f20337c.m();
        }
        return false;
    }

    public void n(String str) {
        boolean z10;
        if (this.f20336b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called before start");
        Preconditions.checkNotNull(str, "authority");
        this.f20343i.add(new j(str));
    }

    public void o() {
        boolean z10;
        if (this.f20336b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called after start");
        r(new n());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(z8.w0 r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            z8.r r0 = r5.f20336b     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            return
        L_0x0007:
            z8.q r0 = r5.f20337c     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x001f
            java.lang.String r0 = "buffered_nanos"
            long r1 = r5.f20342h     // Catch:{ all -> 0x0036 }
            long r3 = r5.f20341g     // Catch:{ all -> 0x0036 }
            long r1 = r1 - r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0036 }
            r6.b(r0, r1)     // Catch:{ all -> 0x0036 }
            z8.q r0 = r5.f20337c     // Catch:{ all -> 0x0036 }
            r0.p(r6)     // Catch:{ all -> 0x0036 }
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "buffered_nanos"
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0036 }
            long r3 = r5.f20341g     // Catch:{ all -> 0x0036 }
            long r1 = r1 - r3
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0036 }
            r6.b(r0, r1)     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = "waiting_for_connection"
            r6.a(r0)     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0036 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.b0.p(z8.w0):void");
    }

    public final void r(Runnable runnable) {
        boolean z10;
        if (this.f20336b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "May only be called after start");
        synchronized (this) {
            if (!this.f20335a) {
                this.f20339e.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r0.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
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
        r0.g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            monitor-enter(r3)
            java.util.List r1 = r3.f20339e     // Catch:{ all -> 0x003b }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x001d
            r0 = 0
            r3.f20339e = r0     // Catch:{ all -> 0x003b }
            r0 = 1
            r3.f20335a = r0     // Catch:{ all -> 0x003b }
            z8.b0$o r0 = r3.f20340f     // Catch:{ all -> 0x003b }
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x001c
            r0.g()
        L_0x001c:
            return
        L_0x001d:
            java.util.List r1 = r3.f20339e     // Catch:{ all -> 0x003b }
            r3.f20339e = r0     // Catch:{ all -> 0x003b }
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            java.util.Iterator r0 = r1.iterator()
        L_0x0026:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L_0x0026
        L_0x0036:
            r1.clear()
            r0 = r1
            goto L_0x0005
        L_0x003b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            goto L_0x003f
        L_0x003e:
            throw r0
        L_0x003f:
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.b0.s():void");
    }

    public final void t(r rVar) {
        for (Runnable run : this.f20343i) {
            run.run();
        }
        this.f20343i = null;
        this.f20337c.g(rVar);
    }

    public void u(k1 k1Var) {
    }

    public final void v(q qVar) {
        boolean z10;
        q qVar2 = this.f20337c;
        if (qVar2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "realStream already set to %s", (Object) qVar2);
        this.f20337c = qVar;
        this.f20342h = System.nanoTime();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r3 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        t(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return new z8.b0.i(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Runnable w(z8.q r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            z8.q r0 = r2.f20337c     // Catch:{ all -> 0x0029 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            return r1
        L_0x0008:
            java.lang.String r0 = "stream"
            java.lang.Object r3 = com.google.common.base.Preconditions.checkNotNull(r3, r0)     // Catch:{ all -> 0x0029 }
            z8.q r3 = (z8.q) r3     // Catch:{ all -> 0x0029 }
            r2.v(r3)     // Catch:{ all -> 0x0029 }
            z8.r r3 = r2.f20336b     // Catch:{ all -> 0x0029 }
            if (r3 != 0) goto L_0x001c
            r2.f20339e = r1     // Catch:{ all -> 0x0029 }
            r0 = 1
            r2.f20335a = r0     // Catch:{ all -> 0x0029 }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            if (r3 != 0) goto L_0x0020
            return r1
        L_0x0020:
            r2.t(r3)
            z8.b0$i r3 = new z8.b0$i
            r3.<init>()
            return r3
        L_0x0029:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.b0.w(z8.q):java.lang.Runnable");
    }
}
