package a9;

import a9.b;
import a9.f;
import a9.h;
import a9.j;
import a9.q;
import c9.b;
import c9.g;
import c9.j;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.SettableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import d9.a;
import d9.b;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import y8.a;
import y8.a0;
import y8.b0;
import y8.c0;
import y8.e1;
import y8.i0;
import y8.k;
import y8.k1;
import y8.l1;
import y8.w0;
import z8.b1;
import z8.b2;
import z8.g2;
import z8.j1;
import z8.m2;
import z8.p0;
import z8.q0;
import z8.r;
import z8.u0;
import z8.v;
import z8.v0;

public class i implements v, b.a, q.d {
    public static final Map W = Q();
    public static final Logger X = Logger.getLogger(i.class.getName());
    public final SocketFactory A;
    public SSLSocketFactory B;
    public HostnameVerifier C;
    public Socket D;
    public int E;
    public final Deque F;
    public final b9.b G;
    public b1 H;
    public boolean I;
    public long J;
    public long K;
    public boolean L;
    public final Runnable M;
    public final int N;
    public final boolean O;
    public final m2 P;
    public final v0 Q;
    public c0.b R;
    public final b0 S;
    public int T;
    public Runnable U;
    public SettableFuture V;

    /* renamed from: a  reason: collision with root package name */
    public final InetSocketAddress f10813a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10814b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10815c;

    /* renamed from: d  reason: collision with root package name */
    public final Random f10816d;

    /* renamed from: e  reason: collision with root package name */
    public final Supplier f10817e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10818f;

    /* renamed from: g  reason: collision with root package name */
    public final j f10819g;

    /* renamed from: h  reason: collision with root package name */
    public j1.a f10820h;

    /* renamed from: i  reason: collision with root package name */
    public b f10821i;

    /* renamed from: j  reason: collision with root package name */
    public q f10822j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f10823k;

    /* renamed from: l  reason: collision with root package name */
    public final i0 f10824l;

    /* renamed from: m  reason: collision with root package name */
    public int f10825m;

    /* renamed from: n  reason: collision with root package name */
    public final Map f10826n;

    /* renamed from: o  reason: collision with root package name */
    public final Executor f10827o;

    /* renamed from: p  reason: collision with root package name */
    public final b2 f10828p;

    /* renamed from: q  reason: collision with root package name */
    public final ScheduledExecutorService f10829q;

    /* renamed from: r  reason: collision with root package name */
    public final int f10830r;

    /* renamed from: s  reason: collision with root package name */
    public int f10831s;

    /* renamed from: t  reason: collision with root package name */
    public e f10832t;

    /* renamed from: u  reason: collision with root package name */
    public y8.a f10833u;

    /* renamed from: v  reason: collision with root package name */
    public k1 f10834v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10835w;

    /* renamed from: x  reason: collision with root package name */
    public u0 f10836x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f10837y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f10838z;

    public class a extends v0 {
        public a() {
        }

        public void b() {
            i.this.f10820h.b(true);
        }

        public void c() {
            i.this.f10820h.b(false);
        }
    }

    public class b implements m2.c {
        public b() {
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f10841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f10842b;

        public class a implements Source {
            public a() {
            }

            public void close() {
            }

            public long read(Buffer buffer, long j10) {
                return -1;
            }

            public Timeout timeout() {
                return Timeout.NONE;
            }
        }

        public c(CountDownLatch countDownLatch, a aVar) {
            this.f10841a = countDownLatch;
            this.f10842b = aVar;
        }

        public void run() {
            i iVar;
            e eVar;
            Socket M;
            SSLSocket sSLSocket;
            SSLSession sSLSession;
            e1 e1Var;
            try {
                this.f10841a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            BufferedSource buffer = Okio.buffer((Source) new a());
            try {
                i iVar2 = i.this;
                b0 b0Var = iVar2.S;
                if (b0Var == null) {
                    M = iVar2.A.createSocket(i.this.f10813a.getAddress(), i.this.f10813a.getPort());
                } else if (b0Var.b() instanceof InetSocketAddress) {
                    i iVar3 = i.this;
                    M = iVar3.S(iVar3.S.c(), (InetSocketAddress) i.this.S.b(), i.this.S.d(), i.this.S.a());
                } else {
                    k1 k1Var = k1.f20055t;
                    throw k1Var.r("Unsupported SocketAddress implementation " + i.this.S.b().getClass()).c();
                }
                Socket socket = M;
                if (i.this.B != null) {
                    SSLSocket b10 = n.b(i.this.B, i.this.C, socket, i.this.W(), i.this.X(), i.this.G);
                    sSLSession = b10.getSession();
                    sSLSocket = b10;
                } else {
                    sSLSession = null;
                    sSLSocket = socket;
                }
                sSLSocket.setTcpNoDelay(true);
                BufferedSource buffer2 = Okio.buffer(Okio.source(sSLSocket));
                this.f10842b.v(Okio.sink(sSLSocket), sSLSocket);
                i iVar4 = i.this;
                a.b d10 = iVar4.f10833u.d().d(a0.f19928a, sSLSocket.getRemoteSocketAddress()).d(a0.f19929b, sSLSocket.getLocalSocketAddress()).d(a0.f19930c, sSLSession);
                a.c cVar = p0.f20860a;
                if (sSLSession == null) {
                    e1Var = e1.NONE;
                } else {
                    e1Var = e1.PRIVACY_AND_INTEGRITY;
                }
                y8.a unused2 = iVar4.f10833u = d10.d(cVar, e1Var).a();
                i iVar5 = i.this;
                e unused3 = iVar5.f10832t = new e(iVar5.f10819g.a(buffer2, true));
                synchronized (i.this.f10823k) {
                    Socket unused4 = i.this.D = (Socket) Preconditions.checkNotNull(sSLSocket, "socket");
                    if (sSLSession != null) {
                        c0.b unused5 = i.this.R = new c0.b(new c0.c(sSLSession));
                    }
                }
                return;
            } catch (l1 e10) {
                i.this.k0(0, c9.a.INTERNAL_ERROR, e10.a());
                iVar = i.this;
                eVar = new e(iVar.f10819g.a(buffer, true));
            } catch (Exception e11) {
                i.this.h(e11);
                iVar = i.this;
                eVar = new e(iVar.f10819g.a(buffer, true));
            } catch (Throwable th) {
                i iVar6 = i.this;
                e unused6 = iVar6.f10832t = new e(iVar6.f10819g.a(buffer, true));
                throw th;
            }
            e unused7 = iVar.f10832t = eVar;
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            Runnable runnable = i.this.U;
            if (runnable != null) {
                runnable.run();
            }
            i.this.f10827o.execute(i.this.f10832t);
            synchronized (i.this.f10823k) {
                int unused = i.this.E = Integer.MAX_VALUE;
                boolean unused2 = i.this.l0();
            }
            SettableFuture settableFuture = i.this.V;
            if (settableFuture != null) {
                settableFuture.set(null);
            }
        }
    }

    public class e implements b.a, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final j f10846a = new j(Level.FINE, i.class);

        /* renamed from: b  reason: collision with root package name */
        public c9.b f10847b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10848c = true;

        public e(c9.b bVar) {
            this.f10847b = bVar;
        }

        public final int a(List list) {
            long j10 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                c9.d dVar = (c9.d) list.get(i10);
                j10 += (long) (dVar.f11420a.size() + 32 + dVar.f11421b.size());
            }
            return (int) Math.min(j10, TTL.MAX_VALUE);
        }

        public void ackSettings() {
        }

        public void d(int i10, c9.a aVar) {
            boolean z10;
            r.a aVar2;
            this.f10846a.h(j.a.INBOUND, i10, aVar);
            k1 f10 = i.p0(aVar).f("Rst Stream");
            if (f10.n() == k1.b.CANCELLED || f10.n() == k1.b.DEADLINE_EXCEEDED) {
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (i.this.f10823k) {
                h hVar = (h) i.this.f10826n.get(Integer.valueOf(i10));
                if (hVar != null) {
                    g9.c.c("OkHttpClientTransport$ClientFrameHandler.rstStream", hVar.y().h0());
                    i iVar = i.this;
                    if (aVar == c9.a.REFUSED_STREAM) {
                        aVar2 = r.a.REFUSED;
                    } else {
                        aVar2 = r.a.PROCESSED;
                    }
                    iVar.U(i10, f10, aVar2, z10, (c9.a) null, (y8.v0) null);
                }
            }
        }

        public void data(boolean z10, int i10, BufferedSource bufferedSource, int i11) {
            this.f10846a.b(j.a.INBOUND, i10, bufferedSource.getBuffer(), i11, z10);
            h Z = i.this.Z(i10);
            if (Z != null) {
                long j10 = (long) i11;
                bufferedSource.require(j10);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.getBuffer(), j10);
                g9.c.c("OkHttpClientTransport$ClientFrameHandler.data", Z.y().h0());
                synchronized (i.this.f10823k) {
                    Z.y().i0(buffer, z10);
                }
            } else if (i.this.c0(i10)) {
                synchronized (i.this.f10823k) {
                    i.this.f10821i.d(i10, c9.a.STREAM_CLOSED);
                }
                bufferedSource.skip((long) i11);
            } else {
                i iVar = i.this;
                c9.a aVar = c9.a.PROTOCOL_ERROR;
                iVar.f0(aVar, "Received data for unknown stream: " + i10);
                return;
            }
            i.D(i.this, i11);
            if (((float) i.this.f10831s) >= ((float) i.this.f10818f) * 0.5f) {
                synchronized (i.this.f10823k) {
                    i.this.f10821i.windowUpdate(0, (long) i.this.f10831s);
                }
                int unused = i.this.f10831s = 0;
            }
        }

        public void e(boolean z10, boolean z11, int i10, int i11, List list, c9.e eVar) {
            k1 k1Var;
            int a10;
            String str;
            this.f10846a.d(j.a.INBOUND, i10, list, z11);
            boolean z12 = true;
            if (i.this.N == Integer.MAX_VALUE || (a10 = a(list)) <= i.this.N) {
                k1Var = null;
            } else {
                k1 k1Var2 = k1.f20050o;
                Locale locale = Locale.US;
                Object[] objArr = new Object[3];
                if (z11) {
                    str = "trailer";
                } else {
                    str = "header";
                }
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i.this.N);
                objArr[2] = Integer.valueOf(a10);
                k1Var = k1Var2.r(String.format(locale, "Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (i.this.f10823k) {
                h hVar = (h) i.this.f10826n.get(Integer.valueOf(i10));
                if (hVar == null) {
                    if (i.this.c0(i10)) {
                        i.this.f10821i.d(i10, c9.a.STREAM_CLOSED);
                    }
                } else if (k1Var == null) {
                    g9.c.c("OkHttpClientTransport$ClientFrameHandler.headers", hVar.y().h0());
                    hVar.y().j0(list, z11);
                } else {
                    if (!z11) {
                        i.this.f10821i.d(i10, c9.a.CANCEL);
                    }
                    hVar.y().N(k1Var, false, new y8.v0());
                }
                z12 = false;
            }
            if (z12) {
                i iVar = i.this;
                c9.a aVar = c9.a.PROTOCOL_ERROR;
                iVar.f0(aVar, "Received header for unknown stream: " + i10);
            }
        }

        public void f(int i10, c9.a aVar, ByteString byteString) {
            this.f10846a.c(j.a.INBOUND, i10, aVar, byteString);
            if (aVar == c9.a.ENHANCE_YOUR_CALM) {
                String utf8 = byteString.utf8();
                i.X.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", new Object[]{this, utf8}));
                if ("too_many_pings".equals(utf8)) {
                    i.this.M.run();
                }
            }
            k1 f10 = q0.h.e((long) aVar.f11410a).f("Received Goaway");
            if (byteString.size() > 0) {
                f10 = f10.f(byteString.utf8());
            }
            i.this.k0(i10, (c9.a) null, f10);
        }

        public void g(boolean z10, c9.i iVar) {
            boolean z11;
            this.f10846a.i(j.a.INBOUND, iVar);
            synchronized (i.this.f10823k) {
                if (m.b(iVar, 4)) {
                    int unused = i.this.E = m.a(iVar, 4);
                }
                if (m.b(iVar, 7)) {
                    z11 = i.this.f10822j.f(m.a(iVar, 7));
                } else {
                    z11 = false;
                }
                if (this.f10848c) {
                    i.this.f10820h.a();
                    this.f10848c = false;
                }
                i.this.f10821i.g(iVar);
                if (z11) {
                    i.this.f10822j.h();
                }
                boolean unused2 = i.this.l0();
            }
        }

        public void ping(boolean z10, int i10, int i11) {
            u0 u0Var;
            long j10 = (((long) i10) << 32) | (((long) i11) & 4294967295L);
            this.f10846a.e(j.a.INBOUND, j10);
            if (!z10) {
                synchronized (i.this.f10823k) {
                    i.this.f10821i.ping(true, i10, i11);
                }
                return;
            }
            synchronized (i.this.f10823k) {
                u0Var = null;
                if (i.this.f10836x == null) {
                    i.X.warning("Received unexpected ping ack. No ping outstanding");
                } else if (i.this.f10836x.h() == j10) {
                    u0 G = i.this.f10836x;
                    u0 unused = i.this.f10836x = null;
                    u0Var = G;
                } else {
                    i.X.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", new Object[]{Long.valueOf(i.this.f10836x.h()), Long.valueOf(j10)}));
                }
            }
            if (u0Var != null) {
                u0Var.d();
            }
        }

        public void priority(int i10, int i11, int i12, boolean z10) {
        }

        public void pushPromise(int i10, int i11, List list) {
            this.f10846a.g(j.a.INBOUND, i10, i11, list);
            synchronized (i.this.f10823k) {
                i.this.f10821i.d(i10, c9.a.PROTOCOL_ERROR);
            }
        }

        public void run() {
            String str;
            k1 x10;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f10847b.t(this)) {
                try {
                    if (i.this.H != null) {
                        i.this.H.l();
                    }
                } catch (Throwable th) {
                    try {
                        i.this.k0(0, c9.a.PROTOCOL_ERROR, k1.f20055t.r("error in frame handler").q(th));
                    } finally {
                        try {
                            this.f10847b.close();
                        } catch (IOException e10) {
                            str = "Exception closing frame reader";
                            i.X.log(Level.INFO, str, e10);
                        }
                        i.this.f10820h.d();
                        Thread.currentThread().setName(name);
                    }
                }
            }
            synchronized (i.this.f10823k) {
                x10 = i.this.f10834v;
            }
            if (x10 == null) {
                x10 = k1.f20056u.r("End of stream or IOException");
            }
            i.this.k0(0, c9.a.INTERNAL_ERROR, x10);
            try {
                this.f10847b.close();
            } catch (IOException e11) {
                e = e11;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
            if (r9 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
            r9 = r7.f10849d;
            r10 = c9.a.PROTOCOL_ERROR;
            a9.i.A(r9, r10, "Received window_update for unknown stream: " + r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void windowUpdate(int r8, long r9) {
            /*
                r7 = this;
                a9.j r0 = r7.f10846a
                a9.j$a r1 = a9.j.a.INBOUND
                r0.k(r1, r8, r9)
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 != 0) goto L_0x002c
                java.lang.String r9 = "Received 0 flow control window increment."
                if (r8 != 0) goto L_0x0019
                a9.i r8 = a9.i.this
                c9.a r10 = c9.a.PROTOCOL_ERROR
                r8.f0(r10, r9)
                goto L_0x002b
            L_0x0019:
                a9.i r0 = a9.i.this
                y8.k1 r10 = y8.k1.f20055t
                y8.k1 r2 = r10.r(r9)
                z8.r$a r3 = z8.r.a.PROCESSED
                r4 = 0
                c9.a r5 = c9.a.PROTOCOL_ERROR
                r6 = 0
                r1 = r8
                r0.U(r1, r2, r3, r4, r5, r6)
            L_0x002b:
                return
            L_0x002c:
                a9.i r0 = a9.i.this
                java.lang.Object r0 = r0.f10823k
                monitor-enter(r0)
                if (r8 != 0) goto L_0x0042
                a9.i r8 = a9.i.this     // Catch:{ all -> 0x008e }
                a9.q r8 = r8.f10822j     // Catch:{ all -> 0x008e }
                r1 = 0
                int r10 = (int) r9     // Catch:{ all -> 0x008e }
                r8.g(r1, r10)     // Catch:{ all -> 0x008e }
                monitor-exit(r0)     // Catch:{ all -> 0x008e }
                return
            L_0x0042:
                a9.i r1 = a9.i.this     // Catch:{ all -> 0x008e }
                java.util.Map r1 = r1.f10826n     // Catch:{ all -> 0x008e }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x008e }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x008e }
                a9.h r1 = (a9.h) r1     // Catch:{ all -> 0x008e }
                if (r1 == 0) goto L_0x0067
                a9.i r2 = a9.i.this     // Catch:{ all -> 0x008e }
                a9.q r2 = r2.f10822j     // Catch:{ all -> 0x008e }
                a9.h$b r1 = r1.y()     // Catch:{ all -> 0x008e }
                a9.q$c r1 = r1.b0()     // Catch:{ all -> 0x008e }
                int r10 = (int) r9     // Catch:{ all -> 0x008e }
                r2.g(r1, r10)     // Catch:{ all -> 0x008e }
                goto L_0x0071
            L_0x0067:
                a9.i r9 = a9.i.this     // Catch:{ all -> 0x008e }
                boolean r9 = r9.c0(r8)     // Catch:{ all -> 0x008e }
                if (r9 != 0) goto L_0x0071
                r9 = 1
                goto L_0x0072
            L_0x0071:
                r9 = 0
            L_0x0072:
                monitor-exit(r0)     // Catch:{ all -> 0x008e }
                if (r9 == 0) goto L_0x008d
                a9.i r9 = a9.i.this
                c9.a r10 = c9.a.PROTOCOL_ERROR
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Received window_update for unknown stream: "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                r9.f0(r10, r8)
            L_0x008d:
                return
            L_0x008e:
                r8 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x008e }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: a9.i.e.windowUpdate(int, long):void");
        }
    }

    public i(f.C0143f fVar, InetSocketAddress inetSocketAddress, String str, String str2, y8.a aVar, b0 b0Var, Runnable runnable) {
        this(fVar, inetSocketAddress, str, str2, aVar, q0.f20894w, new g(), b0Var, runnable);
    }

    public static /* synthetic */ int D(i iVar, int i10) {
        int i11 = iVar.f10831s + i10;
        iVar.f10831s = i11;
        return i11;
    }

    public static Map Q() {
        EnumMap enumMap = new EnumMap(c9.a.class);
        c9.a aVar = c9.a.NO_ERROR;
        k1 k1Var = k1.f20055t;
        enumMap.put(aVar, k1Var.r("No error: A GRPC status of OK should have been sent"));
        enumMap.put(c9.a.PROTOCOL_ERROR, k1Var.r("Protocol error"));
        enumMap.put(c9.a.INTERNAL_ERROR, k1Var.r("Internal error"));
        enumMap.put(c9.a.FLOW_CONTROL_ERROR, k1Var.r("Flow control error"));
        enumMap.put(c9.a.STREAM_CLOSED, k1Var.r("Stream closed"));
        enumMap.put(c9.a.FRAME_TOO_LARGE, k1Var.r("Frame too large"));
        enumMap.put(c9.a.REFUSED_STREAM, k1.f20056u.r("Refused stream"));
        enumMap.put(c9.a.CANCEL, k1.f20042g.r("Cancelled"));
        enumMap.put(c9.a.COMPRESSION_ERROR, k1Var.r("Compression error"));
        enumMap.put(c9.a.CONNECT_ERROR, k1Var.r("Connect error"));
        enumMap.put(c9.a.ENHANCE_YOUR_CALM, k1.f20050o.r("Enhance your calm"));
        enumMap.put(c9.a.INADEQUATE_SECURITY, k1.f20048m.r("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    public static String g0(Source source) {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    public static k1 p0(c9.a aVar) {
        k1 k1Var = (k1) W.get(aVar);
        if (k1Var != null) {
            return k1Var;
        }
        k1 k1Var2 = k1.f20043h;
        return k1Var2.r("Unknown http2 error code: " + aVar.f11410a);
    }

    public final d9.b R(InetSocketAddress inetSocketAddress, String str, String str2) {
        d9.a a10 = new a.b().k("https").h(inetSocketAddress.getHostName()).j(inetSocketAddress.getPort()).a();
        b.C0218b e10 = new b.C0218b().e(a10);
        b.C0218b d10 = e10.d("Host", a10.c() + SOAP.DELIM + a10.f()).d("User-Agent", this.f10815c);
        if (!(str == null || str2 == null)) {
            d10.d(HttpHeaders.PROXY_AUTHORIZATION, b9.c.a(str, str2));
        }
        return d10.c();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:19|(2:20|21)|25|26|27|28|29) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00e9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.Socket S(java.net.InetSocketAddress r10, java.net.InetSocketAddress r11, java.lang.String r12, java.lang.String r13) {
        /*
            r9 = this;
            java.lang.String r0 = "\r\n"
            r1 = 0
            java.net.InetAddress r2 = r11.getAddress()     // Catch:{ IOException -> 0x0111 }
            if (r2 == 0) goto L_0x0018
            javax.net.SocketFactory r2 = r9.A     // Catch:{ IOException -> 0x0111 }
            java.net.InetAddress r3 = r11.getAddress()     // Catch:{ IOException -> 0x0111 }
            int r11 = r11.getPort()     // Catch:{ IOException -> 0x0111 }
            java.net.Socket r11 = r2.createSocket(r3, r11)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0026
        L_0x0018:
            javax.net.SocketFactory r2 = r9.A     // Catch:{ IOException -> 0x0111 }
            java.lang.String r3 = r11.getHostName()     // Catch:{ IOException -> 0x0111 }
            int r11 = r11.getPort()     // Catch:{ IOException -> 0x0111 }
            java.net.Socket r11 = r2.createSocket(r3, r11)     // Catch:{ IOException -> 0x0111 }
        L_0x0026:
            r1 = r11
            r11 = 1
            r1.setTcpNoDelay(r11)     // Catch:{ IOException -> 0x0111 }
            int r2 = r9.T     // Catch:{ IOException -> 0x0111 }
            r1.setSoTimeout(r2)     // Catch:{ IOException -> 0x0111 }
            okio.Source r2 = okio.Okio.source((java.net.Socket) r1)     // Catch:{ IOException -> 0x0111 }
            okio.Sink r3 = okio.Okio.sink((java.net.Socket) r1)     // Catch:{ IOException -> 0x0111 }
            okio.BufferedSink r3 = okio.Okio.buffer((okio.Sink) r3)     // Catch:{ IOException -> 0x0111 }
            d9.b r10 = r9.R(r10, r12, r13)     // Catch:{ IOException -> 0x0111 }
            d9.a r12 = r10.b()     // Catch:{ IOException -> 0x0111 }
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ IOException -> 0x0111 }
            java.lang.String r4 = "CONNECT %s:%d HTTP/1.1"
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0111 }
            java.lang.String r7 = r12.c()     // Catch:{ IOException -> 0x0111 }
            r8 = 0
            r6[r8] = r7     // Catch:{ IOException -> 0x0111 }
            int r12 = r12.f()     // Catch:{ IOException -> 0x0111 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x0111 }
            r6[r11] = r12     // Catch:{ IOException -> 0x0111 }
            java.lang.String r12 = java.lang.String.format(r13, r4, r6)     // Catch:{ IOException -> 0x0111 }
            okio.BufferedSink r12 = r3.writeUtf8(r12)     // Catch:{ IOException -> 0x0111 }
            r12.writeUtf8(r0)     // Catch:{ IOException -> 0x0111 }
            b9.e r12 = r10.a()     // Catch:{ IOException -> 0x0111 }
            int r12 = r12.b()     // Catch:{ IOException -> 0x0111 }
            r13 = 0
        L_0x0070:
            if (r13 >= r12) goto L_0x0096
            b9.e r4 = r10.a()     // Catch:{ IOException -> 0x0111 }
            java.lang.String r4 = r4.a(r13)     // Catch:{ IOException -> 0x0111 }
            okio.BufferedSink r4 = r3.writeUtf8(r4)     // Catch:{ IOException -> 0x0111 }
            java.lang.String r6 = ": "
            okio.BufferedSink r4 = r4.writeUtf8(r6)     // Catch:{ IOException -> 0x0111 }
            b9.e r6 = r10.a()     // Catch:{ IOException -> 0x0111 }
            java.lang.String r6 = r6.c(r13)     // Catch:{ IOException -> 0x0111 }
            okio.BufferedSink r4 = r4.writeUtf8(r6)     // Catch:{ IOException -> 0x0111 }
            r4.writeUtf8(r0)     // Catch:{ IOException -> 0x0111 }
            int r13 = r13 + 1
            goto L_0x0070
        L_0x0096:
            r3.writeUtf8(r0)     // Catch:{ IOException -> 0x0111 }
            r3.flush()     // Catch:{ IOException -> 0x0111 }
            java.lang.String r10 = g0(r2)     // Catch:{ IOException -> 0x0111 }
            b9.j r10 = b9.j.a(r10)     // Catch:{ IOException -> 0x0111 }
        L_0x00a4:
            java.lang.String r12 = g0(r2)     // Catch:{ IOException -> 0x0111 }
            java.lang.String r13 = ""
            boolean r12 = r12.equals(r13)     // Catch:{ IOException -> 0x0111 }
            if (r12 != 0) goto L_0x00b1
            goto L_0x00a4
        L_0x00b1:
            int r12 = r10.f11319b     // Catch:{ IOException -> 0x0111 }
            r13 = 200(0xc8, float:2.8E-43)
            if (r12 < r13) goto L_0x00bf
            r13 = 300(0x12c, float:4.2E-43)
            if (r12 >= r13) goto L_0x00bf
            r1.setSoTimeout(r8)     // Catch:{ IOException -> 0x0111 }
            return r1
        L_0x00bf:
            okio.Buffer r12 = new okio.Buffer     // Catch:{ IOException -> 0x0111 }
            r12.<init>()     // Catch:{ IOException -> 0x0111 }
            r1.shutdownOutput()     // Catch:{ IOException -> 0x00cd }
            r3 = 1024(0x400, double:5.06E-321)
            r2.read(r12, r3)     // Catch:{ IOException -> 0x00cd }
            goto L_0x00e6
        L_0x00cd:
            r13 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0111 }
            r0.<init>()     // Catch:{ IOException -> 0x0111 }
            java.lang.String r2 = "Unable to read body: "
            r0.append(r2)     // Catch:{ IOException -> 0x0111 }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x0111 }
            r0.append(r13)     // Catch:{ IOException -> 0x0111 }
            java.lang.String r13 = r0.toString()     // Catch:{ IOException -> 0x0111 }
            r12.writeUtf8((java.lang.String) r13)     // Catch:{ IOException -> 0x0111 }
        L_0x00e6:
            r1.close()     // Catch:{ IOException -> 0x00e9 }
        L_0x00e9:
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ IOException -> 0x0111 }
            java.lang.String r0 = "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0111 }
            int r3 = r10.f11319b     // Catch:{ IOException -> 0x0111 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0111 }
            r2[r8] = r3     // Catch:{ IOException -> 0x0111 }
            java.lang.String r10 = r10.f11320c     // Catch:{ IOException -> 0x0111 }
            r2[r11] = r10     // Catch:{ IOException -> 0x0111 }
            java.lang.String r10 = r12.readUtf8()     // Catch:{ IOException -> 0x0111 }
            r2[r5] = r10     // Catch:{ IOException -> 0x0111 }
            java.lang.String r10 = java.lang.String.format(r13, r0, r2)     // Catch:{ IOException -> 0x0111 }
            y8.k1 r11 = y8.k1.f20056u     // Catch:{ IOException -> 0x0111 }
            y8.k1 r10 = r11.r(r10)     // Catch:{ IOException -> 0x0111 }
            y8.l1 r10 = r10.c()     // Catch:{ IOException -> 0x0111 }
            throw r10     // Catch:{ IOException -> 0x0111 }
        L_0x0111:
            r10 = move-exception
            if (r1 == 0) goto L_0x0117
            z8.q0.d(r1)
        L_0x0117:
            y8.k1 r11 = y8.k1.f20056u
            java.lang.String r12 = "Failed trying to connect with proxy"
            y8.k1 r11 = r11.r(r12)
            y8.k1 r10 = r11.q(r10)
            y8.l1 r10 = r10.c()
            goto L_0x0129
        L_0x0128:
            throw r10
        L_0x0129:
            goto L_0x0128
        */
        throw new UnsupportedOperationException("Method not decompiled: a9.i.S(java.net.InetSocketAddress, java.net.InetSocketAddress, java.lang.String, java.lang.String):java.net.Socket");
    }

    public void T(boolean z10, long j10, long j11, boolean z11) {
        this.I = z10;
        this.J = j10;
        this.K = j11;
        this.L = z11;
    }

    public void U(int i10, k1 k1Var, r.a aVar, boolean z10, c9.a aVar2, y8.v0 v0Var) {
        synchronized (this.f10823k) {
            h hVar = (h) this.f10826n.remove(Integer.valueOf(i10));
            if (hVar != null) {
                if (aVar2 != null) {
                    this.f10821i.d(i10, c9.a.CANCEL);
                }
                if (k1Var != null) {
                    h.b M2 = hVar.y();
                    if (v0Var == null) {
                        v0Var = new y8.v0();
                    }
                    M2.M(k1Var, aVar, z10, v0Var);
                }
                if (!l0()) {
                    n0();
                    d0(hVar);
                }
            }
        }
    }

    public y8.a V() {
        return this.f10833u;
    }

    public String W() {
        URI b10 = q0.b(this.f10814b);
        if (b10.getHost() != null) {
            return b10.getHost();
        }
        return this.f10814b;
    }

    public int X() {
        URI b10 = q0.b(this.f10814b);
        if (b10.getPort() != -1) {
            return b10.getPort();
        }
        return this.f10813a.getPort();
    }

    public final Throwable Y() {
        synchronized (this.f10823k) {
            k1 k1Var = this.f10834v;
            if (k1Var != null) {
                l1 c10 = k1Var.c();
                return c10;
            }
            l1 c11 = k1.f20056u.r("Connection closed").c();
            return c11;
        }
    }

    public h Z(int i10) {
        h hVar;
        synchronized (this.f10823k) {
            hVar = (h) this.f10826n.get(Integer.valueOf(i10));
        }
        return hVar;
    }

    public q.c[] a() {
        q.c[] cVarArr;
        synchronized (this.f10823k) {
            cVarArr = new q.c[this.f10826n.size()];
            int i10 = 0;
            for (h M2 : this.f10826n.values()) {
                cVarArr[i10] = M2.y().b0();
                i10++;
            }
        }
        return cVarArr;
    }

    public final void a0() {
        synchronized (this.f10823k) {
            this.P.g(new b());
        }
    }

    public boolean b0() {
        if (this.B == null) {
            return true;
        }
        return false;
    }

    public void c(k1 k1Var) {
        synchronized (this.f10823k) {
            if (this.f10834v == null) {
                this.f10834v = k1Var;
                this.f10820h.c(k1Var);
                n0();
            }
        }
    }

    public boolean c0(int i10) {
        boolean z10;
        synchronized (this.f10823k) {
            if (i10 < this.f10825m) {
                z10 = true;
                if ((i10 & 1) == 1) {
                }
            }
            z10 = false;
        }
        return z10;
    }

    public i0 d() {
        return this.f10824l;
    }

    public final void d0(h hVar) {
        if (this.f10838z && this.F.isEmpty() && this.f10826n.isEmpty()) {
            this.f10838z = false;
            b1 b1Var = this.H;
            if (b1Var != null) {
                b1Var.n();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, false);
        }
    }

    /* JADX INFO: finally extract failed */
    public Runnable e(j1.a aVar) {
        this.f10820h = (j1.a) Preconditions.checkNotNull(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.I) {
            b1 b1Var = new b1(new b1.c(this), this.f10829q, this.J, this.K, this.L);
            this.H = b1Var;
            b1Var.o();
        }
        a y10 = a.y(this.f10828p, this, 10000);
        c9.c x10 = y10.x(this.f10819g.b(Okio.buffer((Sink) y10), true));
        synchronized (this.f10823k) {
            b bVar = new b(this, x10);
            this.f10821i = bVar;
            this.f10822j = new q(this, bVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f10828p.execute(new c(countDownLatch, y10));
        try {
            i0();
            countDownLatch.countDown();
            this.f10828p.execute(new d());
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    /* renamed from: e0 */
    public h b(w0 w0Var, y8.v0 v0Var, y8.c cVar, k[] kVarArr) {
        Object obj;
        y8.v0 v0Var2 = v0Var;
        Preconditions.checkNotNull(w0Var, FirebaseAnalytics.Param.METHOD);
        Preconditions.checkNotNull(v0Var2, "headers");
        g2 h10 = g2.h(kVarArr, V(), v0Var2);
        Object obj2 = this.f10823k;
        synchronized (obj2) {
            try {
                obj = obj2;
                h hVar = new h(w0Var, v0Var, this.f10821i, this, this.f10822j, this.f10823k, this.f10830r, this.f10818f, this.f10814b, this.f10815c, h10, this.P, cVar, this.O);
                return hVar;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1.a(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(z8.s.a r9, java.util.concurrent.Executor r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f10823k
            monitor-enter(r0)
            a9.b r1 = r8.f10821i     // Catch:{ all -> 0x0054 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            com.google.common.base.Preconditions.checkState(r1)     // Catch:{ all -> 0x0054 }
            boolean r1 = r8.f10837y     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x001c
            java.lang.Throwable r1 = r8.Y()     // Catch:{ all -> 0x0054 }
            z8.u0.g(r9, r10, r1)     // Catch:{ all -> 0x0054 }
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x001c:
            z8.u0 r1 = r8.f10836x     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0024
            r4 = 0
            r2 = 0
            goto L_0x0042
        L_0x0024:
            java.util.Random r1 = r8.f10816d     // Catch:{ all -> 0x0054 }
            long r4 = r1.nextLong()     // Catch:{ all -> 0x0054 }
            com.google.common.base.Supplier r1 = r8.f10817e     // Catch:{ all -> 0x0054 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0054 }
            com.google.common.base.Stopwatch r1 = (com.google.common.base.Stopwatch) r1     // Catch:{ all -> 0x0054 }
            r1.start()     // Catch:{ all -> 0x0054 }
            z8.u0 r6 = new z8.u0     // Catch:{ all -> 0x0054 }
            r6.<init>(r4, r1)     // Catch:{ all -> 0x0054 }
            r8.f10836x = r6     // Catch:{ all -> 0x0054 }
            z8.m2 r1 = r8.P     // Catch:{ all -> 0x0054 }
            r1.b()     // Catch:{ all -> 0x0054 }
            r1 = r6
        L_0x0042:
            if (r2 == 0) goto L_0x004f
            a9.b r2 = r8.f10821i     // Catch:{ all -> 0x0054 }
            r6 = 32
            long r6 = r4 >>> r6
            int r7 = (int) r6     // Catch:{ all -> 0x0054 }
            int r5 = (int) r4     // Catch:{ all -> 0x0054 }
            r2.ping(r3, r7, r5)     // Catch:{ all -> 0x0054 }
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            r1.a(r9, r10)
            return
        L_0x0054:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a9.i.f(z8.s$a, java.util.concurrent.Executor):void");
    }

    public final void f0(c9.a aVar, String str) {
        k0(0, aVar, p0(aVar).f(str));
    }

    public void g(k1 k1Var) {
        c(k1Var);
        synchronized (this.f10823k) {
            Iterator it = this.f10826n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                it.remove();
                ((h) entry.getValue()).y().N(k1Var, false, new y8.v0());
                d0((h) entry.getValue());
            }
            for (h hVar : this.F) {
                hVar.y().M(k1Var, r.a.MISCARRIED, true, new y8.v0());
                d0(hVar);
            }
            this.F.clear();
            n0();
        }
    }

    public void h(Throwable th) {
        Preconditions.checkNotNull(th, "failureCause");
        k0(0, c9.a.INTERNAL_ERROR, k1.f20056u.q(th));
    }

    public void h0(h hVar) {
        this.F.remove(hVar);
        d0(hVar);
    }

    public final void i0() {
        synchronized (this.f10823k) {
            this.f10821i.connectionPreface();
            c9.i iVar = new c9.i();
            m.c(iVar, 7, this.f10818f);
            this.f10821i.F(iVar);
            int i10 = this.f10818f;
            if (i10 > 65535) {
                this.f10821i.windowUpdate(0, (long) (i10 - Message.MAXLENGTH));
            }
        }
    }

    public final void j0(h hVar) {
        if (!this.f10838z) {
            this.f10838z = true;
            b1 b1Var = this.H;
            if (b1Var != null) {
                b1Var.m();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, true);
        }
    }

    public final void k0(int i10, c9.a aVar, k1 k1Var) {
        synchronized (this.f10823k) {
            if (this.f10834v == null) {
                this.f10834v = k1Var;
                this.f10820h.c(k1Var);
            }
            if (aVar != null && !this.f10835w) {
                this.f10835w = true;
                this.f10821i.o(0, aVar, new byte[0]);
            }
            Iterator it = this.f10826n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Integer) entry.getKey()).intValue() > i10) {
                    it.remove();
                    ((h) entry.getValue()).y().M(k1Var, r.a.REFUSED, false, new y8.v0());
                    d0((h) entry.getValue());
                }
            }
            for (h hVar : this.F) {
                hVar.y().M(k1Var, r.a.MISCARRIED, true, new y8.v0());
                d0(hVar);
            }
            this.F.clear();
            n0();
        }
    }

    public final boolean l0() {
        boolean z10 = false;
        while (!this.F.isEmpty() && this.f10826n.size() < this.E) {
            m0((h) this.F.poll());
            z10 = true;
        }
        return z10;
    }

    public final void m0(h hVar) {
        boolean z10;
        if (hVar.y().c0() == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "StreamId already assigned");
        this.f10826n.put(Integer.valueOf(this.f10825m), hVar);
        j0(hVar);
        hVar.y().f0(this.f10825m);
        if (!(hVar.L() == w0.d.UNARY || hVar.L() == w0.d.SERVER_STREAMING) || hVar.N()) {
            this.f10821i.flush();
        }
        int i10 = this.f10825m;
        if (i10 >= 2147483645) {
            this.f10825m = Integer.MAX_VALUE;
            k0(Integer.MAX_VALUE, c9.a.NO_ERROR, k1.f20056u.r("Stream ids exhausted"));
            return;
        }
        this.f10825m = i10 + 2;
    }

    public final void n0() {
        if (this.f10834v != null && this.f10826n.isEmpty() && this.F.isEmpty() && !this.f10837y) {
            this.f10837y = true;
            b1 b1Var = this.H;
            if (b1Var != null) {
                b1Var.p();
            }
            u0 u0Var = this.f10836x;
            if (u0Var != null) {
                u0Var.f(Y());
                this.f10836x = null;
            }
            if (!this.f10835w) {
                this.f10835w = true;
                this.f10821i.o(0, c9.a.NO_ERROR, new byte[0]);
            }
            this.f10821i.close();
        }
    }

    public void o0(h hVar) {
        if (this.f10834v != null) {
            hVar.y().M(this.f10834v, r.a.MISCARRIED, true, new y8.v0());
        } else if (this.f10826n.size() >= this.E) {
            this.F.add(hVar);
            j0(hVar);
        } else {
            m0(hVar);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.f10824l.d()).add("address", (Object) this.f10813a).toString();
    }

    public i(f.C0143f fVar, InetSocketAddress inetSocketAddress, String str, String str2, y8.a aVar, Supplier supplier, c9.j jVar, b0 b0Var, Runnable runnable) {
        this.f10816d = new Random();
        this.f10823k = new Object();
        this.f10826n = new HashMap();
        this.E = 0;
        this.F = new LinkedList();
        this.Q = new a();
        this.T = 30000;
        this.f10813a = (InetSocketAddress) Preconditions.checkNotNull(inetSocketAddress, "address");
        this.f10814b = str;
        this.f10830r = fVar.f10789j;
        this.f10818f = fVar.f10794o;
        this.f10827o = (Executor) Preconditions.checkNotNull(fVar.f10781b, "executor");
        this.f10828p = new b2(fVar.f10781b);
        this.f10829q = (ScheduledExecutorService) Preconditions.checkNotNull(fVar.f10783d, "scheduledExecutorService");
        this.f10825m = 3;
        SocketFactory socketFactory = fVar.f10785f;
        this.A = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.B = fVar.f10786g;
        this.C = fVar.f10787h;
        this.G = (b9.b) Preconditions.checkNotNull(fVar.f10788i, "connectionSpec");
        this.f10817e = (Supplier) Preconditions.checkNotNull(supplier, "stopwatchFactory");
        this.f10819g = (c9.j) Preconditions.checkNotNull(jVar, "variant");
        this.f10815c = q0.g("okhttp", str2);
        this.S = b0Var;
        this.M = (Runnable) Preconditions.checkNotNull(runnable, "tooManyPingsRunnable");
        this.N = fVar.f10796q;
        this.P = fVar.f10784e.a();
        this.f10824l = i0.a(getClass(), inetSocketAddress.toString());
        this.f10833u = y8.a.c().d(p0.f20861b, aVar).a();
        this.O = fVar.f10797r;
        a0();
    }
}
