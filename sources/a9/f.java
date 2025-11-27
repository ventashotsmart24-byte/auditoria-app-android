package a9;

import b9.b;
import b9.k;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.UPushNotificationChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import y8.q1;
import y8.s0;
import z8.d2;
import z8.e2;
import z8.g1;
import z8.h;
import z8.m2;
import z8.o1;
import z8.q0;
import z8.t;
import z8.v;

public final class f extends z8.b {

    /* renamed from: r  reason: collision with root package name */
    public static final Logger f10751r = Logger.getLogger(f.class.getName());

    /* renamed from: s  reason: collision with root package name */
    public static final b9.b f10752s = new b.C0149b(b9.b.f11262f).f(b9.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, b9.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, b9.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, b9.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).i(k.TLS_1_2).h(true).e();

    /* renamed from: t  reason: collision with root package name */
    public static final long f10753t = TimeUnit.DAYS.toNanos(1000);

    /* renamed from: u  reason: collision with root package name */
    public static final d2.d f10754u;

    /* renamed from: v  reason: collision with root package name */
    public static final o1 f10755v;

    /* renamed from: w  reason: collision with root package name */
    public static final EnumSet f10756w = EnumSet.of(q1.MTLS, q1.CUSTOM_MANAGERS);

    /* renamed from: b  reason: collision with root package name */
    public final g1 f10757b;

    /* renamed from: c  reason: collision with root package name */
    public m2.b f10758c = m2.a();

    /* renamed from: d  reason: collision with root package name */
    public o1 f10759d = f10755v;

    /* renamed from: e  reason: collision with root package name */
    public o1 f10760e = e2.c(q0.f20893v);

    /* renamed from: f  reason: collision with root package name */
    public SocketFactory f10761f;

    /* renamed from: g  reason: collision with root package name */
    public SSLSocketFactory f10762g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f10763h;

    /* renamed from: i  reason: collision with root package name */
    public HostnameVerifier f10764i;

    /* renamed from: j  reason: collision with root package name */
    public b9.b f10765j = f10752s;

    /* renamed from: k  reason: collision with root package name */
    public c f10766k = c.TLS;

    /* renamed from: l  reason: collision with root package name */
    public long f10767l = Long.MAX_VALUE;

    /* renamed from: m  reason: collision with root package name */
    public long f10768m = q0.f20885n;

    /* renamed from: n  reason: collision with root package name */
    public int f10769n = Message.MAXLENGTH;

    /* renamed from: o  reason: collision with root package name */
    public boolean f10770o;

    /* renamed from: p  reason: collision with root package name */
    public int f10771p = Integer.MAX_VALUE;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f10772q = false;

    public class a implements d2.d {
        /* renamed from: a */
        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        /* renamed from: b */
        public Executor create() {
            return Executors.newCachedThreadPool(q0.i("grpc-okhttp-%d", true));
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10773a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f10774b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                a9.f$c[] r0 = a9.f.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10774b = r0
                r1 = 1
                a9.f$c r2 = a9.f.c.PLAINTEXT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10774b     // Catch:{ NoSuchFieldError -> 0x001d }
                a9.f$c r3 = a9.f.c.TLS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                a9.e[] r2 = a9.e.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f10773a = r2
                a9.e r3 = a9.e.TLS     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f10773a     // Catch:{ NoSuchFieldError -> 0x0038 }
                a9.e r2 = a9.e.PLAINTEXT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a9.f.b.<clinit>():void");
        }
    }

    public enum c {
        TLS,
        PLAINTEXT
    }

    public final class d implements g1.b {
        public d() {
        }

        public int a() {
            return f.this.g();
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    public final class e implements g1.c {
        public e() {
        }

        public t a() {
            return f.this.d();
        }

        public /* synthetic */ e(f fVar, a aVar) {
            this();
        }
    }

    /* renamed from: a9.f$f  reason: collision with other inner class name */
    public static final class C0143f implements t {

        /* renamed from: a  reason: collision with root package name */
        public final o1 f10780a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f10781b;

        /* renamed from: c  reason: collision with root package name */
        public final o1 f10782c;

        /* renamed from: d  reason: collision with root package name */
        public final ScheduledExecutorService f10783d;

        /* renamed from: e  reason: collision with root package name */
        public final m2.b f10784e;

        /* renamed from: f  reason: collision with root package name */
        public final SocketFactory f10785f;

        /* renamed from: g  reason: collision with root package name */
        public final SSLSocketFactory f10786g;

        /* renamed from: h  reason: collision with root package name */
        public final HostnameVerifier f10787h;

        /* renamed from: i  reason: collision with root package name */
        public final b9.b f10788i;

        /* renamed from: j  reason: collision with root package name */
        public final int f10789j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f10790k;

        /* renamed from: l  reason: collision with root package name */
        public final long f10791l;

        /* renamed from: m  reason: collision with root package name */
        public final h f10792m;

        /* renamed from: n  reason: collision with root package name */
        public final long f10793n;

        /* renamed from: o  reason: collision with root package name */
        public final int f10794o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f10795p;

        /* renamed from: q  reason: collision with root package name */
        public final int f10796q;

        /* renamed from: r  reason: collision with root package name */
        public final boolean f10797r;

        /* renamed from: s  reason: collision with root package name */
        public boolean f10798s;

        /* renamed from: a9.f$f$a */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h.b f10799a;

            public a(h.b bVar) {
                this.f10799a = bVar;
            }

            public void run() {
                this.f10799a.a();
            }
        }

        public /* synthetic */ C0143f(o1 o1Var, o1 o1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, b9.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, m2.b bVar2, boolean z12, a aVar) {
            this(o1Var, o1Var2, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i10, z10, j10, j11, i11, z11, i12, bVar2, z12);
        }

        public v J(SocketAddress socketAddress, t.a aVar, y8.f fVar) {
            if (!this.f10798s) {
                h.b d10 = this.f10792m.d();
                i iVar = new i(this, (InetSocketAddress) socketAddress, aVar.a(), aVar.d(), aVar.b(), aVar.c(), new a(d10));
                if (this.f10790k) {
                    iVar.T(true, d10.b(), this.f10793n, this.f10795p);
                }
                return iVar;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        public void close() {
            if (!this.f10798s) {
                this.f10798s = true;
                this.f10780a.b(this.f10781b);
                this.f10782c.b(this.f10783d);
            }
        }

        public ScheduledExecutorService p() {
            return this.f10783d;
        }

        public C0143f(o1 o1Var, o1 o1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, b9.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, m2.b bVar2, boolean z12) {
            this.f10780a = o1Var;
            this.f10781b = (Executor) o1Var.a();
            this.f10782c = o1Var2;
            this.f10783d = (ScheduledExecutorService) o1Var2.a();
            this.f10785f = socketFactory;
            this.f10786g = sSLSocketFactory;
            this.f10787h = hostnameVerifier;
            this.f10788i = bVar;
            this.f10789j = i10;
            this.f10790k = z10;
            this.f10791l = j10;
            this.f10792m = new h("keepalive time nanos", j10);
            this.f10793n = j11;
            this.f10794o = i11;
            this.f10795p = z11;
            this.f10796q = i12;
            this.f10797r = z12;
            this.f10784e = (m2.b) Preconditions.checkNotNull(bVar2, "transportTracerFactory");
        }
    }

    static {
        a aVar = new a();
        f10754u = aVar;
        f10755v = e2.c(aVar);
    }

    public f(String str) {
        this.f10757b = new g1(str, new e(this, (a) null), new d(this, (a) null));
        this.f10763h = false;
    }

    public static f f(String str) {
        return new f(str);
    }

    public s0 c() {
        return this.f10757b;
    }

    public C0143f d() {
        boolean z10;
        if (this.f10767l != Long.MAX_VALUE) {
            z10 = true;
        } else {
            z10 = false;
        }
        C0143f fVar = r2;
        C0143f fVar2 = new C0143f(this.f10759d, this.f10760e, this.f10761f, e(), this.f10764i, this.f10765j, this.f20334a, z10, this.f10767l, this.f10768m, this.f10769n, this.f10770o, this.f10771p, this.f10758c, false, (a) null);
        return fVar;
    }

    public SSLSocketFactory e() {
        int i10 = b.f10774b[this.f10766k.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 == 2) {
            try {
                if (this.f10762g == null) {
                    this.f10762g = SSLContext.getInstance(UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME, b9.h.e().g()).getSocketFactory();
                }
                return this.f10762g;
            } catch (GeneralSecurityException e10) {
                throw new RuntimeException("TLS Provider failure", e10);
            }
        } else {
            throw new RuntimeException("Unknown negotiation type: " + this.f10766k);
        }
    }

    public int g() {
        int i10 = b.f10774b[this.f10766k.ordinal()];
        if (i10 == 1) {
            return 80;
        }
        if (i10 == 2) {
            return Constants.PORT;
        }
        throw new AssertionError(this.f10766k + " not handled");
    }
}
