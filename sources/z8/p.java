package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.e0;
import y8.f0;
import y8.g;
import y8.k;
import y8.k1;
import y8.l;
import y8.n;
import y8.o;
import y8.r;
import y8.s;
import y8.t;
import y8.v;
import y8.v0;
import y8.w0;
import z8.i1;
import z8.i2;
import z8.r;

public final class p extends y8.g {

    /* renamed from: t  reason: collision with root package name */
    public static final Logger f20815t = Logger.getLogger(p.class.getName());

    /* renamed from: u  reason: collision with root package name */
    public static final byte[] f20816u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* renamed from: v  reason: collision with root package name */
    public static final double f20817v;

    /* renamed from: a  reason: collision with root package name */
    public final w0 f20818a;

    /* renamed from: b  reason: collision with root package name */
    public final g9.d f20819b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f20820c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f20821d;

    /* renamed from: e  reason: collision with root package name */
    public final m f20822e;

    /* renamed from: f  reason: collision with root package name */
    public final r f20823f;

    /* renamed from: g  reason: collision with root package name */
    public volatile ScheduledFuture f20824g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f20825h;

    /* renamed from: i  reason: collision with root package name */
    public y8.c f20826i;

    /* renamed from: j  reason: collision with root package name */
    public q f20827j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f20828k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f20829l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f20830m;

    /* renamed from: n  reason: collision with root package name */
    public final e f20831n;

    /* renamed from: o  reason: collision with root package name */
    public final f f20832o = new f();

    /* renamed from: p  reason: collision with root package name */
    public final ScheduledExecutorService f20833p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f20834q;

    /* renamed from: r  reason: collision with root package name */
    public v f20835r = v.c();

    /* renamed from: s  reason: collision with root package name */
    public o f20836s = o.a();

    public class b extends x {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.a f20837b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g.a aVar) {
            super(p.this.f20823f);
            this.f20837b = aVar;
        }

        public void a() {
            p pVar = p.this;
            pVar.r(this.f20837b, s.a(pVar.f20823f), new v0());
        }
    }

    public class c extends x {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.a f20839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20840c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g.a aVar, String str) {
            super(p.this.f20823f);
            this.f20839b = aVar;
            this.f20840c = str;
        }

        public void a() {
            p.this.r(this.f20839b, k1.f20055t.r(String.format("Unable to find compressor by name %s", new Object[]{this.f20840c})), new v0());
        }
    }

    public class d implements r {

        /* renamed from: a  reason: collision with root package name */
        public final g.a f20842a;

        /* renamed from: b  reason: collision with root package name */
        public k1 f20843b;

        public final class a extends x {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g9.b f20845b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ v0 f20846c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(g9.b bVar, v0 v0Var) {
                super(p.this.f20823f);
                this.f20845b = bVar;
                this.f20846c = v0Var;
            }

            public void a() {
                g9.c.g("ClientCall$Listener.headersRead", p.this.f20819b);
                g9.c.d(this.f20845b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.headersRead", p.this.f20819b);
                }
            }

            public final void b() {
                if (d.this.f20843b == null) {
                    try {
                        d.this.f20842a.b(this.f20846c);
                    } catch (Throwable th) {
                        d.this.i(k1.f20042g.q(th).r("Failed to read headers"));
                    }
                }
            }
        }

        public final class b extends x {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g9.b f20848b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ i2.a f20849c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(g9.b bVar, i2.a aVar) {
                super(p.this.f20823f);
                this.f20848b = bVar;
                this.f20849c = aVar;
            }

            public void a() {
                g9.c.g("ClientCall$Listener.messagesAvailable", p.this.f20819b);
                g9.c.d(this.f20848b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.messagesAvailable", p.this.f20819b);
                }
            }

            public final void b() {
                InputStream next;
                if (d.this.f20843b != null) {
                    q0.e(this.f20849c);
                    return;
                }
                while (true) {
                    try {
                        next = this.f20849c.next();
                        if (next != null) {
                            d.this.f20842a.c(p.this.f20818a.i(next));
                            next.close();
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        q0.e(this.f20849c);
                        d.this.i(k1.f20042g.q(th).r("Failed to read message."));
                        return;
                    }
                }
            }
        }

        public final class c extends x {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g9.b f20851b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ k1 f20852c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ v0 f20853d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(g9.b bVar, k1 k1Var, v0 v0Var) {
                super(p.this.f20823f);
                this.f20851b = bVar;
                this.f20852c = k1Var;
                this.f20853d = v0Var;
            }

            public void a() {
                g9.c.g("ClientCall$Listener.onClose", p.this.f20819b);
                g9.c.d(this.f20851b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.onClose", p.this.f20819b);
                }
            }

            public final void b() {
                k1 k1Var = this.f20852c;
                v0 v0Var = this.f20853d;
                if (d.this.f20843b != null) {
                    k1Var = d.this.f20843b;
                    v0Var = new v0();
                }
                boolean unused = p.this.f20828k = true;
                try {
                    d dVar = d.this;
                    p.this.r(dVar.f20842a, k1Var, v0Var);
                } finally {
                    p.this.y();
                    p.this.f20822e.a(k1Var.p());
                }
            }
        }

        /* renamed from: z8.p$d$d  reason: collision with other inner class name */
        public final class C0305d extends x {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g9.b f20855b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0305d(g9.b bVar) {
                super(p.this.f20823f);
                this.f20855b = bVar;
            }

            public void a() {
                g9.c.g("ClientCall$Listener.onReady", p.this.f20819b);
                g9.c.d(this.f20855b);
                try {
                    b();
                } finally {
                    g9.c.i("ClientCall$Listener.onReady", p.this.f20819b);
                }
            }

            public final void b() {
                if (d.this.f20843b == null) {
                    try {
                        d.this.f20842a.d();
                    } catch (Throwable th) {
                        d.this.i(k1.f20042g.q(th).r("Failed to call onReady."));
                    }
                }
            }
        }

        public d(g.a aVar) {
            this.f20842a = (g.a) Preconditions.checkNotNull(aVar, "observer");
        }

        public void a(i2.a aVar) {
            g9.c.g("ClientStreamListener.messagesAvailable", p.this.f20819b);
            try {
                p.this.f20820c.execute(new b(g9.c.e(), aVar));
            } finally {
                g9.c.i("ClientStreamListener.messagesAvailable", p.this.f20819b);
            }
        }

        public void b(v0 v0Var) {
            g9.c.g("ClientStreamListener.headersRead", p.this.f20819b);
            try {
                p.this.f20820c.execute(new a(g9.c.e(), v0Var));
            } finally {
                g9.c.i("ClientStreamListener.headersRead", p.this.f20819b);
            }
        }

        public void c(k1 k1Var, r.a aVar, v0 v0Var) {
            g9.c.g("ClientStreamListener.closed", p.this.f20819b);
            try {
                h(k1Var, aVar, v0Var);
            } finally {
                g9.c.i("ClientStreamListener.closed", p.this.f20819b);
            }
        }

        public void d() {
            if (!p.this.f20818a.e().a()) {
                g9.c.g("ClientStreamListener.onReady", p.this.f20819b);
                try {
                    p.this.f20820c.execute(new C0305d(g9.c.e()));
                } finally {
                    g9.c.i("ClientStreamListener.onReady", p.this.f20819b);
                }
            }
        }

        public final void h(k1 k1Var, r.a aVar, v0 v0Var) {
            t g10 = p.this.s();
            if (k1Var.n() == k1.b.CANCELLED && g10 != null && g10.g()) {
                w0 w0Var = new w0();
                p.this.f20827j.p(w0Var);
                k1 k1Var2 = k1.f20045j;
                k1Var = k1Var2.f("ClientCall was cancelled at or after deadline. " + w0Var);
                v0Var = new v0();
            }
            p.this.f20820c.execute(new c(g9.c.e(), k1Var, v0Var));
        }

        public final void i(k1 k1Var) {
            this.f20843b = k1Var;
            p.this.f20827j.e(k1Var);
        }
    }

    public interface e {
        q a(w0 w0Var, y8.c cVar, v0 v0Var, y8.r rVar);
    }

    public final class f implements r.a {
        public f() {
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final long f20858a;

        public g(long j10) {
            this.f20858a = j10;
        }

        public void run() {
            w0 w0Var = new w0();
            p.this.f20827j.p(w0Var);
            long abs = Math.abs(this.f20858a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = abs / timeUnit.toNanos(1);
            long abs2 = Math.abs(this.f20858a) % timeUnit.toNanos(1);
            StringBuilder sb = new StringBuilder();
            sb.append("deadline exceeded after ");
            if (this.f20858a < 0) {
                sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            }
            sb.append(nanos);
            sb.append(String.format(Locale.US, ".%09d", new Object[]{Long.valueOf(abs2)}));
            sb.append("s. ");
            sb.append(w0Var);
            p.this.f20827j.e(k1.f20045j.f(sb.toString()));
        }
    }

    static {
        double nanos = (double) TimeUnit.SECONDS.toNanos(1);
        Double.isNaN(nanos);
        f20817v = nanos * 1.0d;
    }

    public p(w0 w0Var, Executor executor, y8.c cVar, e eVar, ScheduledExecutorService scheduledExecutorService, m mVar, e0 e0Var) {
        this.f20818a = w0Var;
        g9.d b10 = g9.c.b(w0Var.c(), (long) System.identityHashCode(this));
        this.f20819b = b10;
        boolean z10 = true;
        if (executor == MoreExecutors.directExecutor()) {
            this.f20820c = new a2();
            this.f20821d = true;
        } else {
            this.f20820c = new b2(executor);
            this.f20821d = false;
        }
        this.f20822e = mVar;
        this.f20823f = y8.r.e();
        if (!(w0Var.e() == w0.d.UNARY || w0Var.e() == w0.d.SERVER_STREAMING)) {
            z10 = false;
        }
        this.f20825h = z10;
        this.f20826i = cVar;
        this.f20831n = eVar;
        this.f20833p = scheduledExecutorService;
        g9.c.c("ClientCall.<init>", b10);
    }

    public static boolean u(t tVar, t tVar2) {
        if (tVar == null) {
            return false;
        }
        if (tVar2 == null) {
            return true;
        }
        return tVar.f(tVar2);
    }

    public static void v(t tVar, t tVar2, t tVar3) {
        Logger logger = f20815t;
        if (logger.isLoggable(Level.FINE) && tVar != null && tVar.equals(tVar2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long max = Math.max(0, tVar.i(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", new Object[]{Long.valueOf(max)}));
            if (tVar3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", new Object[]{Long.valueOf(tVar3.i(timeUnit))}));
            }
            logger.fine(sb.toString());
        }
    }

    public static t w(t tVar, t tVar2) {
        if (tVar == null) {
            return tVar2;
        }
        if (tVar2 == null) {
            return tVar;
        }
        return tVar.h(tVar2);
    }

    public static void x(v0 v0Var, v vVar, n nVar, boolean z10) {
        v0Var.e(q0.f20880i);
        v0.g gVar = q0.f20876e;
        v0Var.e(gVar);
        if (nVar != l.b.f20085a) {
            v0Var.o(gVar, nVar.a());
        }
        v0.g gVar2 = q0.f20877f;
        v0Var.e(gVar2);
        byte[] a10 = f0.a(vVar);
        if (a10.length != 0) {
            v0Var.o(gVar2, a10);
        }
        v0Var.e(q0.f20878g);
        v0.g gVar3 = q0.f20879h;
        v0Var.e(gVar3);
        if (z10) {
            v0Var.o(gVar3, f20816u);
        }
    }

    public p A(o oVar) {
        this.f20836s = oVar;
        return this;
    }

    public p B(v vVar) {
        this.f20835r = vVar;
        return this;
    }

    public p C(boolean z10) {
        this.f20834q = z10;
        return this;
    }

    public final ScheduledFuture D(t tVar) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long i10 = tVar.i(timeUnit);
        return this.f20833p.schedule(new c1(new g(i10)), i10, timeUnit);
    }

    public final void E(g.a aVar, v0 v0Var) {
        boolean z10;
        n nVar;
        boolean z11;
        String str;
        if (this.f20827j == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Already started");
        Preconditions.checkState(!this.f20829l, "call was cancelled");
        Preconditions.checkNotNull(aVar, "observer");
        Preconditions.checkNotNull(v0Var, "headers");
        if (this.f20823f.h()) {
            this.f20827j = n1.f20805a;
            this.f20820c.execute(new b(aVar));
            return;
        }
        p();
        String b10 = this.f20826i.b();
        if (b10 != null) {
            nVar = this.f20836s.b(b10);
            if (nVar == null) {
                this.f20827j = n1.f20805a;
                this.f20820c.execute(new c(aVar, b10));
                return;
            }
        } else {
            nVar = l.b.f20085a;
        }
        x(v0Var, this.f20835r, nVar, this.f20834q);
        t s10 = s();
        if (s10 == null || !s10.g()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            v(s10, this.f20823f.g(), this.f20826i.d());
            this.f20827j = this.f20831n.a(this.f20818a, this.f20826i, v0Var, this.f20823f);
        } else {
            k[] f10 = q0.f(this.f20826i, v0Var, 0, false);
            if (u(this.f20826i.d(), this.f20823f.g())) {
                str = "CallOptions";
            } else {
                str = "Context";
            }
            double i10 = (double) s10.i(TimeUnit.NANOSECONDS);
            double d10 = f20817v;
            Double.isNaN(i10);
            this.f20827j = new f0(k1.f20045j.r(String.format("ClientCall started after %s deadline was exceeded .9%f seconds ago", new Object[]{str, Double.valueOf(i10 / d10)})), f10);
        }
        if (this.f20821d) {
            this.f20827j.i();
        }
        if (this.f20826i.a() != null) {
            this.f20827j.n(this.f20826i.a());
        }
        if (this.f20826i.f() != null) {
            this.f20827j.c(this.f20826i.f().intValue());
        }
        if (this.f20826i.g() != null) {
            this.f20827j.d(this.f20826i.g().intValue());
        }
        if (s10 != null) {
            this.f20827j.k(s10);
        }
        this.f20827j.a(nVar);
        boolean z12 = this.f20834q;
        if (z12) {
            this.f20827j.j(z12);
        }
        this.f20827j.l(this.f20835r);
        this.f20822e.b();
        this.f20827j.g(new d(aVar));
        this.f20823f.a(this.f20832o, MoreExecutors.directExecutor());
        if (!(s10 == null || s10.equals(this.f20823f.g()) || this.f20833p == null)) {
            this.f20824g = D(s10);
        }
        if (this.f20828k) {
            y();
        }
    }

    public void a(String str, Throwable th) {
        g9.c.g("ClientCall.cancel", this.f20819b);
        try {
            q(str, th);
        } finally {
            g9.c.i("ClientCall.cancel", this.f20819b);
        }
    }

    public void b() {
        g9.c.g("ClientCall.halfClose", this.f20819b);
        try {
            t();
        } finally {
            g9.c.i("ClientCall.halfClose", this.f20819b);
        }
    }

    public void c(int i10) {
        boolean z10;
        g9.c.g("ClientCall.request", this.f20819b);
        try {
            boolean z11 = true;
            if (this.f20827j != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "Not started");
            if (i10 < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Number requested must be non-negative");
            this.f20827j.b(i10);
        } finally {
            g9.c.i("ClientCall.request", this.f20819b);
        }
    }

    public void d(Object obj) {
        g9.c.g("ClientCall.sendMessage", this.f20819b);
        try {
            z(obj);
        } finally {
            g9.c.i("ClientCall.sendMessage", this.f20819b);
        }
    }

    public void e(g.a aVar, v0 v0Var) {
        g9.c.g("ClientCall.start", this.f20819b);
        try {
            E(aVar, v0Var);
        } finally {
            g9.c.i("ClientCall.start", this.f20819b);
        }
    }

    public final void p() {
        y8.c cVar;
        i1.b bVar = (i1.b) this.f20826i.h(i1.b.f20690g);
        if (bVar != null) {
            Long l10 = bVar.f20691a;
            if (l10 != null) {
                t a10 = t.a(l10.longValue(), TimeUnit.NANOSECONDS);
                t d10 = this.f20826i.d();
                if (d10 == null || a10.compareTo(d10) < 0) {
                    this.f20826i = this.f20826i.n(a10);
                }
            }
            Boolean bool = bVar.f20692b;
            if (bool != null) {
                if (bool.booleanValue()) {
                    cVar = this.f20826i.u();
                } else {
                    cVar = this.f20826i.v();
                }
                this.f20826i = cVar;
            }
            if (bVar.f20693c != null) {
                Integer f10 = this.f20826i.f();
                if (f10 != null) {
                    this.f20826i = this.f20826i.q(Math.min(f10.intValue(), bVar.f20693c.intValue()));
                } else {
                    this.f20826i = this.f20826i.q(bVar.f20693c.intValue());
                }
            }
            if (bVar.f20694d != null) {
                Integer g10 = this.f20826i.g();
                if (g10 != null) {
                    this.f20826i = this.f20826i.r(Math.min(g10.intValue(), bVar.f20694d.intValue()));
                } else {
                    this.f20826i = this.f20826i.r(bVar.f20694d.intValue());
                }
            }
        }
    }

    public final void q(String str, Throwable th) {
        k1 k1Var;
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f20815t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (!this.f20829l) {
            this.f20829l = true;
            try {
                if (this.f20827j != null) {
                    k1 k1Var2 = k1.f20042g;
                    if (str != null) {
                        k1Var = k1Var2.r(str);
                    } else {
                        k1Var = k1Var2.r("Call cancelled without message");
                    }
                    if (th != null) {
                        k1Var = k1Var.q(th);
                    }
                    this.f20827j.e(k1Var);
                }
            } finally {
                y();
            }
        }
    }

    public final void r(g.a aVar, k1 k1Var, v0 v0Var) {
        aVar.a(k1Var, v0Var);
    }

    public final t s() {
        return w(this.f20826i.d(), this.f20823f.g());
    }

    public final void t() {
        boolean z10;
        if (this.f20827j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Not started");
        Preconditions.checkState(!this.f20829l, "call was cancelled");
        Preconditions.checkState(!this.f20830m, "call already half-closed");
        this.f20830m = true;
        this.f20827j.o();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(FirebaseAnalytics.Param.METHOD, (Object) this.f20818a).toString();
    }

    public final void y() {
        this.f20823f.i(this.f20832o);
        ScheduledFuture scheduledFuture = this.f20824g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void z(Object obj) {
        boolean z10;
        if (this.f20827j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Not started");
        Preconditions.checkState(!this.f20829l, "call was cancelled");
        Preconditions.checkState(!this.f20830m, "call was half-closed");
        try {
            q qVar = this.f20827j;
            if (qVar instanceof x1) {
                ((x1) qVar).n0(obj);
            } else {
                qVar.h(this.f20818a.j(obj));
            }
            if (!this.f20825h) {
                this.f20827j.flush();
            }
        } catch (RuntimeException e10) {
            this.f20827j.e(k1.f20042g.q(e10).r("Failed to stream message"));
        } catch (Error e11) {
            this.f20827j.e(k1.f20042g.r("Client sendMessage() failed with Error"));
            throw e11;
        }
    }
}
