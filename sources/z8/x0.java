package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import y8.b0;
import y8.c0;
import y8.f;
import y8.h0;
import y8.i0;
import y8.k1;
import y8.o1;
import y8.p;
import y8.q;
import y8.v0;
import y8.w0;
import y8.x;
import z8.j1;
import z8.k;
import z8.r;
import z8.t;

public final class x0 implements h0, l2 {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f21018a;

    /* renamed from: b  reason: collision with root package name */
    public final String f21019b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21020c;

    /* renamed from: d  reason: collision with root package name */
    public final k.a f21021d;

    /* renamed from: e  reason: collision with root package name */
    public final j f21022e;

    /* renamed from: f  reason: collision with root package name */
    public final t f21023f;

    /* renamed from: g  reason: collision with root package name */
    public final ScheduledExecutorService f21024g;

    /* renamed from: h  reason: collision with root package name */
    public final c0 f21025h;

    /* renamed from: i  reason: collision with root package name */
    public final m f21026i;

    /* renamed from: j  reason: collision with root package name */
    public final o f21027j;

    /* renamed from: k  reason: collision with root package name */
    public final y8.f f21028k;

    /* renamed from: l  reason: collision with root package name */
    public final o1 f21029l;

    /* renamed from: m  reason: collision with root package name */
    public final k f21030m;

    /* renamed from: n  reason: collision with root package name */
    public volatile List f21031n;

    /* renamed from: o  reason: collision with root package name */
    public k f21032o;

    /* renamed from: p  reason: collision with root package name */
    public final Stopwatch f21033p;

    /* renamed from: q  reason: collision with root package name */
    public o1.d f21034q;

    /* renamed from: r  reason: collision with root package name */
    public o1.d f21035r;

    /* renamed from: s  reason: collision with root package name */
    public j1 f21036s;

    /* renamed from: t  reason: collision with root package name */
    public final Collection f21037t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    public final v0 f21038u = new a();

    /* renamed from: v  reason: collision with root package name */
    public v f21039v;

    /* renamed from: w  reason: collision with root package name */
    public volatile j1 f21040w;

    /* renamed from: x  reason: collision with root package name */
    public volatile q f21041x = q.a(p.IDLE);

    /* renamed from: y  reason: collision with root package name */
    public k1 f21042y;

    public class a extends v0 {
        public a() {
        }

        public void b() {
            x0.this.f21022e.a(x0.this);
        }

        public void c() {
            x0.this.f21022e.b(x0.this);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            o1.d unused = x0.this.f21034q = null;
            x0.this.f21028k.a(f.a.INFO, "CONNECTING after backoff");
            x0.this.M(p.CONNECTING);
            x0.this.S();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            if (x0.this.f21041x.c() == p.IDLE) {
                x0.this.f21028k.a(f.a.INFO, "CONNECTING as requested");
                x0.this.M(p.CONNECTING);
                x0.this.S();
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f21046a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                j1 p10 = x0.this.f21036s;
                o1.d unused = x0.this.f21035r = null;
                j1 unused2 = x0.this.f21036s = null;
                p10.c(k1.f20056u.r("InternalSubchannel closed transport due to address change"));
            }
        }

        public d(List list) {
            this.f21046a = list;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                z8.x0 r0 = z8.x0.this
                z8.x0$k r0 = r0.f21030m
                java.net.SocketAddress r0 = r0.a()
                z8.x0 r1 = z8.x0.this
                z8.x0$k r1 = r1.f21030m
                java.util.List r2 = r7.f21046a
                r1.h(r2)
                z8.x0 r1 = z8.x0.this
                java.util.List r2 = r7.f21046a
                java.util.List unused = r1.f21031n = r2
                z8.x0 r1 = z8.x0.this
                y8.q r1 = r1.f21041x
                y8.p r1 = r1.c()
                y8.p r2 = y8.p.READY
                r3 = 0
                if (r1 == r2) goto L_0x0039
                z8.x0 r1 = z8.x0.this
                y8.q r1 = r1.f21041x
                y8.p r1 = r1.c()
                y8.p r4 = y8.p.CONNECTING
                if (r1 != r4) goto L_0x0091
            L_0x0039:
                z8.x0 r1 = z8.x0.this
                z8.x0$k r1 = r1.f21030m
                boolean r0 = r1.g(r0)
                if (r0 != 0) goto L_0x0091
                z8.x0 r0 = z8.x0.this
                y8.q r0 = r0.f21041x
                y8.p r0 = r0.c()
                if (r0 != r2) goto L_0x006d
                z8.x0 r0 = z8.x0.this
                z8.j1 r0 = r0.f21040w
                z8.x0 r1 = z8.x0.this
                z8.j1 unused = r1.f21040w = r3
                z8.x0 r1 = z8.x0.this
                z8.x0$k r1 = r1.f21030m
                r1.f()
                z8.x0 r1 = z8.x0.this
                y8.p r2 = y8.p.IDLE
                r1.M(r2)
                goto L_0x0092
            L_0x006d:
                z8.x0 r0 = z8.x0.this
                z8.v r0 = r0.f21039v
                y8.k1 r1 = y8.k1.f20056u
                java.lang.String r2 = "InternalSubchannel closed pending transport due to address change"
                y8.k1 r1 = r1.r(r2)
                r0.c(r1)
                z8.x0 r0 = z8.x0.this
                z8.v unused = r0.f21039v = r3
                z8.x0 r0 = z8.x0.this
                z8.x0$k r0 = r0.f21030m
                r0.f()
                z8.x0 r0 = z8.x0.this
                r0.S()
            L_0x0091:
                r0 = r3
            L_0x0092:
                if (r0 == 0) goto L_0x00e1
                z8.x0 r1 = z8.x0.this
                y8.o1$d r1 = r1.f21035r
                if (r1 == 0) goto L_0x00c0
                z8.x0 r1 = z8.x0.this
                z8.j1 r1 = r1.f21036s
                y8.k1 r2 = y8.k1.f20056u
                java.lang.String r4 = "InternalSubchannel closed transport early due to address change"
                y8.k1 r2 = r2.r(r4)
                r1.c(r2)
                z8.x0 r1 = z8.x0.this
                y8.o1$d r1 = r1.f21035r
                r1.a()
                z8.x0 r1 = z8.x0.this
                y8.o1.d unused = r1.f21035r = r3
                z8.x0 r1 = z8.x0.this
                z8.j1 unused = r1.f21036s = r3
            L_0x00c0:
                z8.x0 r1 = z8.x0.this
                z8.j1 unused = r1.f21036s = r0
                z8.x0 r0 = z8.x0.this
                y8.o1 r1 = r0.f21029l
                z8.x0$d$a r2 = new z8.x0$d$a
                r2.<init>()
                r3 = 5
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
                z8.x0 r6 = z8.x0.this
                java.util.concurrent.ScheduledExecutorService r6 = r6.f21024g
                y8.o1$d r1 = r1.c(r2, r3, r5, r6)
                y8.o1.d unused = r0.f21035r = r1
            L_0x00e1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z8.x0.d.run():void");
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k1 f21049a;

        public e(k1 k1Var) {
            this.f21049a = k1Var;
        }

        public void run() {
            p c10 = x0.this.f21041x.c();
            p pVar = p.SHUTDOWN;
            if (c10 != pVar) {
                k1 unused = x0.this.f21042y = this.f21049a;
                j1 j10 = x0.this.f21040w;
                v l10 = x0.this.f21039v;
                j1 unused2 = x0.this.f21040w = null;
                v unused3 = x0.this.f21039v = null;
                x0.this.M(pVar);
                x0.this.f21030m.f();
                if (x0.this.f21037t.isEmpty()) {
                    x0.this.O();
                }
                x0.this.K();
                if (x0.this.f21035r != null) {
                    x0.this.f21035r.a();
                    x0.this.f21036s.c(this.f21049a);
                    o1.d unused4 = x0.this.f21035r = null;
                    j1 unused5 = x0.this.f21036s = null;
                }
                if (j10 != null) {
                    j10.c(this.f21049a);
                }
                if (l10 != null) {
                    l10.c(this.f21049a);
                }
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            x0.this.f21028k.a(f.a.INFO, "Terminated");
            x0.this.f21022e.d(x0.this);
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f21052a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21053b;

        public g(v vVar, boolean z10) {
            this.f21052a = vVar;
            this.f21053b = z10;
        }

        public void run() {
            x0.this.f21038u.e(this.f21052a, this.f21053b);
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k1 f21055a;

        public h(k1 k1Var) {
            this.f21055a = k1Var;
        }

        public void run() {
            for (j1 g10 : new ArrayList(x0.this.f21037t)) {
                g10.g(this.f21055a);
            }
        }
    }

    public static final class i extends j0 {

        /* renamed from: a  reason: collision with root package name */
        public final v f21057a;

        /* renamed from: b  reason: collision with root package name */
        public final m f21058b;

        public class a extends h0 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ q f21059a;

            /* renamed from: z8.x0$i$a$a  reason: collision with other inner class name */
            public class C0306a extends i0 {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ r f21061a;

                public C0306a(r rVar) {
                    this.f21061a = rVar;
                }

                public void c(k1 k1Var, r.a aVar, v0 v0Var) {
                    i.this.f21058b.a(k1Var.p());
                    super.c(k1Var, aVar, v0Var);
                }

                public r e() {
                    return this.f21061a;
                }
            }

            public a(q qVar) {
                this.f21059a = qVar;
            }

            public q f() {
                return this.f21059a;
            }

            public void g(r rVar) {
                i.this.f21058b.b();
                super.g(new C0306a(rVar));
            }
        }

        public /* synthetic */ i(v vVar, m mVar, a aVar) {
            this(vVar, mVar);
        }

        public v a() {
            return this.f21057a;
        }

        public q b(w0 w0Var, v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
            return new a(super.b(w0Var, v0Var, cVar, kVarArr));
        }

        public i(v vVar, m mVar) {
            this.f21057a = vVar;
            this.f21058b = mVar;
        }
    }

    public static abstract class j {
        public abstract void a(x0 x0Var);

        public abstract void b(x0 x0Var);

        public abstract void c(x0 x0Var, q qVar);

        public abstract void d(x0 x0Var);
    }

    public static final class k {

        /* renamed from: a  reason: collision with root package name */
        public List f21063a;

        /* renamed from: b  reason: collision with root package name */
        public int f21064b;

        /* renamed from: c  reason: collision with root package name */
        public int f21065c;

        public k(List list) {
            this.f21063a = list;
        }

        public SocketAddress a() {
            return (SocketAddress) ((x) this.f21063a.get(this.f21064b)).a().get(this.f21065c);
        }

        public y8.a b() {
            return ((x) this.f21063a.get(this.f21064b)).b();
        }

        public void c() {
            int i10 = this.f21065c + 1;
            this.f21065c = i10;
            if (i10 >= ((x) this.f21063a.get(this.f21064b)).a().size()) {
                this.f21064b++;
                this.f21065c = 0;
            }
        }

        public boolean d() {
            if (this.f21064b == 0 && this.f21065c == 0) {
                return true;
            }
            return false;
        }

        public boolean e() {
            if (this.f21064b < this.f21063a.size()) {
                return true;
            }
            return false;
        }

        public void f() {
            this.f21064b = 0;
            this.f21065c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            int i10 = 0;
            while (i10 < this.f21063a.size()) {
                int indexOf = ((x) this.f21063a.get(i10)).a().indexOf(socketAddress);
                if (indexOf == -1) {
                    i10++;
                } else {
                    this.f21064b = i10;
                    this.f21065c = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List list) {
            this.f21063a = list;
            f();
        }
    }

    public class l implements j1.a {

        /* renamed from: a  reason: collision with root package name */
        public final v f21066a;

        /* renamed from: b  reason: collision with root package name */
        public final SocketAddress f21067b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f21068c = false;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                boolean z10;
                k unused = x0.this.f21032o = null;
                if (x0.this.f21042y != null) {
                    if (x0.this.f21040w == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkState(z10, "Unexpected non-null activeTransport");
                    l lVar = l.this;
                    lVar.f21066a.c(x0.this.f21042y);
                    return;
                }
                v l10 = x0.this.f21039v;
                l lVar2 = l.this;
                v vVar = lVar2.f21066a;
                if (l10 == vVar) {
                    j1 unused2 = x0.this.f21040w = vVar;
                    v unused3 = x0.this.f21039v = null;
                    x0.this.M(p.READY);
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k1 f21071a;

            public b(k1 k1Var) {
                this.f21071a = k1Var;
            }

            public void run() {
                boolean z10;
                if (x0.this.f21041x.c() != p.SHUTDOWN) {
                    j1 j10 = x0.this.f21040w;
                    l lVar = l.this;
                    if (j10 == lVar.f21066a) {
                        j1 unused = x0.this.f21040w = null;
                        x0.this.f21030m.f();
                        x0.this.M(p.IDLE);
                        return;
                    }
                    v l10 = x0.this.f21039v;
                    l lVar2 = l.this;
                    if (l10 == lVar2.f21066a) {
                        if (x0.this.f21041x.c() == p.CONNECTING) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        Preconditions.checkState(z10, "Expected state is CONNECTING, actual state is %s", (Object) x0.this.f21041x.c());
                        x0.this.f21030m.c();
                        if (!x0.this.f21030m.e()) {
                            v unused2 = x0.this.f21039v = null;
                            x0.this.f21030m.f();
                            x0.this.R(this.f21071a);
                            return;
                        }
                        x0.this.S();
                    }
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                x0.this.f21037t.remove(l.this.f21066a);
                if (x0.this.f21041x.c() == p.SHUTDOWN && x0.this.f21037t.isEmpty()) {
                    x0.this.O();
                }
            }
        }

        public l(v vVar, SocketAddress socketAddress) {
            this.f21066a = vVar;
            this.f21067b = socketAddress;
        }

        public void a() {
            x0.this.f21028k.a(f.a.INFO, "READY");
            x0.this.f21029l.execute(new a());
        }

        public void b(boolean z10) {
            x0.this.P(this.f21066a, z10);
        }

        public void c(k1 k1Var) {
            x0.this.f21028k.b(f.a.INFO, "{0} SHUTDOWN with {1}", this.f21066a.d(), x0.this.Q(k1Var));
            this.f21068c = true;
            x0.this.f21029l.execute(new b(k1Var));
        }

        public void d() {
            Preconditions.checkState(this.f21068c, "transportShutdown() must be called before transportTerminated().");
            x0.this.f21028k.b(f.a.INFO, "{0} Terminated", this.f21066a.d());
            x0.this.f21025h.i(this.f21066a);
            x0.this.P(this.f21066a, false);
            x0.this.f21029l.execute(new c());
        }
    }

    public static final class m extends y8.f {

        /* renamed from: a  reason: collision with root package name */
        public i0 f21074a;

        public void a(f.a aVar, String str) {
            n.d(this.f21074a, aVar, str);
        }

        public void b(f.a aVar, String str, Object... objArr) {
            n.e(this.f21074a, aVar, str, objArr);
        }
    }

    public x0(List list, String str, String str2, k.a aVar, t tVar, ScheduledExecutorService scheduledExecutorService, Supplier supplier, o1 o1Var, j jVar, c0 c0Var, m mVar, o oVar, i0 i0Var, y8.f fVar) {
        List list2 = list;
        Preconditions.checkNotNull(list, "addressGroups");
        Preconditions.checkArgument(!list.isEmpty(), "addressGroups is empty");
        L(list, "addressGroups contains null entry");
        List unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f21031n = unmodifiableList;
        this.f21030m = new k(unmodifiableList);
        this.f21019b = str;
        this.f21020c = str2;
        this.f21021d = aVar;
        this.f21023f = tVar;
        this.f21024g = scheduledExecutorService;
        this.f21033p = (Stopwatch) supplier.get();
        this.f21029l = o1Var;
        this.f21022e = jVar;
        this.f21025h = c0Var;
        this.f21026i = mVar;
        this.f21027j = (o) Preconditions.checkNotNull(oVar, "channelTracer");
        this.f21018a = (i0) Preconditions.checkNotNull(i0Var, "logId");
        this.f21028k = (y8.f) Preconditions.checkNotNull(fVar, "channelLogger");
    }

    public static void L(List list, String str) {
        for (Object checkNotNull : list) {
            Preconditions.checkNotNull(checkNotNull, str);
        }
    }

    public final void K() {
        this.f21029l.e();
        o1.d dVar = this.f21034q;
        if (dVar != null) {
            dVar.a();
            this.f21034q = null;
            this.f21032o = null;
        }
    }

    public final void M(p pVar) {
        this.f21029l.e();
        N(q.a(pVar));
    }

    public final void N(q qVar) {
        boolean z10;
        this.f21029l.e();
        if (this.f21041x.c() != qVar.c()) {
            if (this.f21041x.c() != p.SHUTDOWN) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Cannot transition out of SHUTDOWN to " + qVar);
            this.f21041x = qVar;
            this.f21022e.c(this, qVar);
        }
    }

    public final void O() {
        this.f21029l.execute(new f());
    }

    public final void P(v vVar, boolean z10) {
        this.f21029l.execute(new g(vVar, z10));
    }

    public final String Q(k1 k1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(k1Var.n());
        if (k1Var.o() != null) {
            sb.append("(");
            sb.append(k1Var.o());
            sb.append(")");
        }
        if (k1Var.m() != null) {
            sb.append("[");
            sb.append(k1Var.m());
            sb.append("]");
        }
        return sb.toString();
    }

    public final void R(k1 k1Var) {
        this.f21029l.e();
        N(q.b(k1Var));
        if (this.f21032o == null) {
            this.f21032o = this.f21021d.get();
        }
        long a10 = this.f21032o.a();
        Stopwatch stopwatch = this.f21033p;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long elapsed = a10 - stopwatch.elapsed(timeUnit);
        boolean z10 = false;
        this.f21028k.b(f.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", Q(k1Var), Long.valueOf(elapsed));
        if (this.f21034q == null) {
            z10 = true;
        }
        Preconditions.checkState(z10, "previous reconnectTask is not done");
        this.f21034q = this.f21029l.c(new b(), elapsed, timeUnit, this.f21024g);
    }

    public final void S() {
        boolean z10;
        SocketAddress socketAddress;
        b0 b0Var;
        this.f21029l.e();
        if (this.f21034q == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Should have no reconnectTask scheduled");
        if (this.f21030m.d()) {
            this.f21033p.reset().start();
        }
        SocketAddress a10 = this.f21030m.a();
        if (a10 instanceof b0) {
            b0Var = (b0) a10;
            socketAddress = b0Var.c();
        } else {
            socketAddress = a10;
            b0Var = null;
        }
        y8.a b10 = this.f21030m.b();
        String str = (String) b10.b(x.f20218d);
        t.a aVar = new t.a();
        if (str == null) {
            str = this.f21019b;
        }
        t.a g10 = aVar.e(str).f(b10).h(this.f21020c).g(b0Var);
        m mVar = new m();
        mVar.f21074a = d();
        i iVar = new i(this.f21023f.J(socketAddress, g10, mVar), this.f21026i, (a) null);
        mVar.f21074a = iVar.d();
        this.f21025h.c(iVar);
        this.f21039v = iVar;
        this.f21037t.add(iVar);
        Runnable e10 = iVar.e(new l(iVar, socketAddress));
        if (e10 != null) {
            this.f21029l.b(e10);
        }
        this.f21028k.b(f.a.INFO, "Started transport {0}", mVar.f21074a);
    }

    public void T(List list) {
        Preconditions.checkNotNull(list, "newAddressGroups");
        L(list, "newAddressGroups contains null entry");
        Preconditions.checkArgument(!list.isEmpty(), "newAddressGroups is empty");
        this.f21029l.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    public s a() {
        j1 j1Var = this.f21040w;
        if (j1Var != null) {
            return j1Var;
        }
        this.f21029l.execute(new c());
        return null;
    }

    public void c(k1 k1Var) {
        this.f21029l.execute(new e(k1Var));
    }

    public i0 d() {
        return this.f21018a;
    }

    public void g(k1 k1Var) {
        c(k1Var);
        this.f21029l.execute(new h(k1Var));
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.f21018a.d()).add("addressGroups", (Object) this.f21031n).toString();
    }
}
