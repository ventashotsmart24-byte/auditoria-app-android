package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.c;
import y8.c1;
import y8.d1;
import y8.i0;
import y8.j0;
import y8.k;
import y8.k1;
import y8.o0;
import y8.v0;
import y8.w0;
import z8.d2;
import z8.i2;
import z8.r;

public abstract class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f20872a = Logger.getLogger(q0.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Set f20873b = Collections.unmodifiableSet(EnumSet.of(k1.b.OK, new k1.b[]{k1.b.INVALID_ARGUMENT, k1.b.NOT_FOUND, k1.b.ALREADY_EXISTS, k1.b.FAILED_PRECONDITION, k1.b.ABORTED, k1.b.OUT_OF_RANGE, k1.b.DATA_LOSS}));

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f20874c = Charset.forName("US-ASCII");

    /* renamed from: d  reason: collision with root package name */
    public static final v0.g f20875d = v0.g.e("grpc-timeout", new i());

    /* renamed from: e  reason: collision with root package name */
    public static final v0.g f20876e;

    /* renamed from: f  reason: collision with root package name */
    public static final v0.g f20877f = j0.b("grpc-accept-encoding", new g((a) null));

    /* renamed from: g  reason: collision with root package name */
    public static final v0.g f20878g;

    /* renamed from: h  reason: collision with root package name */
    public static final v0.g f20879h = j0.b("accept-encoding", new g((a) null));

    /* renamed from: i  reason: collision with root package name */
    public static final v0.g f20880i;

    /* renamed from: j  reason: collision with root package name */
    public static final v0.g f20881j;

    /* renamed from: k  reason: collision with root package name */
    public static final v0.g f20882k;

    /* renamed from: l  reason: collision with root package name */
    public static final v0.g f20883l;

    /* renamed from: m  reason: collision with root package name */
    public static final Splitter f20884m = Splitter.on((char) ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN).trimResults();

    /* renamed from: n  reason: collision with root package name */
    public static final long f20885n;

    /* renamed from: o  reason: collision with root package name */
    public static final long f20886o = TimeUnit.HOURS.toNanos(2);

    /* renamed from: p  reason: collision with root package name */
    public static final long f20887p;

    /* renamed from: q  reason: collision with root package name */
    public static final d1 f20888q = new s1();

    /* renamed from: r  reason: collision with root package name */
    public static final d1 f20889r = new a();

    /* renamed from: s  reason: collision with root package name */
    public static final c.C0296c f20890s = c.C0296c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");

    /* renamed from: t  reason: collision with root package name */
    public static final k f20891t = new b();

    /* renamed from: u  reason: collision with root package name */
    public static final d2.d f20892u = new c();

    /* renamed from: v  reason: collision with root package name */
    public static final d2.d f20893v = new d();

    /* renamed from: w  reason: collision with root package name */
    public static final Supplier f20894w = new e();

    public class a implements d1 {
        public c1 a(SocketAddress socketAddress) {
            return null;
        }
    }

    public class b extends k {
    }

    public class c implements d2.d {
        /* renamed from: a */
        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        /* renamed from: b */
        public Executor create() {
            return Executors.newCachedThreadPool(q0.i("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    public class d implements d2.d {
        /* renamed from: a */
        public void close(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        /* renamed from: b */
        public ScheduledExecutorService create() {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, q0.i("grpc-timer-%d", true));
            try {
                newScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE}).invoke(newScheduledThreadPool, new Object[]{Boolean.TRUE});
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
            return Executors.unconfigurableScheduledExecutorService(newScheduledThreadPool);
        }
    }

    public class e implements Supplier {
        /* renamed from: a */
        public Stopwatch get() {
            return Stopwatch.createUnstarted();
        }
    }

    public class f implements s {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k.a f20895a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f20896b;

        public f(k.a aVar, s sVar) {
            this.f20895a = aVar;
            this.f20896b = sVar;
        }

        public q b(w0 w0Var, v0 v0Var, y8.c cVar, k[] kVarArr) {
            boolean z10;
            k a10 = this.f20895a.a(k.b.a().b(cVar).a(), v0Var);
            if (kVarArr[kVarArr.length - 1] == q0.f20891t) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "lb tracer already assigned");
            kVarArr[kVarArr.length - 1] = a10;
            return this.f20896b.b(w0Var, v0Var, cVar, kVarArr);
        }

        public i0 d() {
            return this.f20896b.d();
        }
    }

    public static final class g implements j0.a {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        /* renamed from: c */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        /* renamed from: d */
        public byte[] a(byte[] bArr) {
            return bArr;
        }
    }

    public enum h {
        NO_ERROR(0, r1),
        PROTOCOL_ERROR(1, r4),
        INTERNAL_ERROR(2, r4),
        FLOW_CONTROL_ERROR(3, r4),
        SETTINGS_TIMEOUT(4, r4),
        STREAM_CLOSED(5, r4),
        FRAME_SIZE_ERROR(6, r4),
        REFUSED_STREAM(7, r1),
        CANCEL(8, k1.f20042g),
        COMPRESSION_ERROR(9, r4),
        CONNECT_ERROR(10, r4),
        ENHANCE_YOUR_CALM(11, k1.f20050o.r("Bandwidth exhausted")),
        INADEQUATE_SECURITY(12, k1.f20048m.r("Permission denied as protocol is not secure enough to call")),
        HTTP_1_1_REQUIRED(13, k1.f20043h);
        

        /* renamed from: q  reason: collision with root package name */
        public static final h[] f20911q = null;

        /* renamed from: a  reason: collision with root package name */
        public final int f20913a;

        /* renamed from: b  reason: collision with root package name */
        public final k1 f20914b;

        /* access modifiers changed from: public */
        static {
            f20911q = a();
        }

        /* access modifiers changed from: public */
        h(int i10, k1 k1Var) {
            this.f20913a = i10;
            String str = "HTTP/2 error code: " + name();
            if (k1Var.o() != null) {
                str = str + " (" + k1Var.o() + ")";
            }
            this.f20914b = k1Var.r(str);
        }

        public static h[] a() {
            h[] values = values();
            h[] hVarArr = new h[(((int) values[values.length - 1].b()) + 1)];
            for (h hVar : values) {
                hVarArr[(int) hVar.b()] = hVar;
            }
            return hVarArr;
        }

        public static h c(long j10) {
            h[] hVarArr = f20911q;
            if (j10 >= ((long) hVarArr.length) || j10 < 0) {
                return null;
            }
            return hVarArr[(int) j10];
        }

        public static k1 e(long j10) {
            h c10 = c(j10);
            if (c10 != null) {
                return c10.d();
            }
            k1 i10 = k1.i(INTERNAL_ERROR.d().n().c());
            return i10.r("Unrecognized HTTP/2 error code: " + j10);
        }

        public long b() {
            return (long) this.f20913a;
        }

        public k1 d() {
            return this.f20914b;
        }
    }

    public static class i implements v0.d {
        /* renamed from: c */
        public Long b(String str) {
            boolean z10;
            boolean z11;
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "empty timeout");
            if (str.length() <= 9) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "bad timeout format");
            long parseLong = Long.parseLong(str.substring(0, str.length() - 1));
            char charAt = str.charAt(str.length() - 1);
            if (charAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(parseLong));
            }
            if (charAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(parseLong));
            }
            if (charAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(parseLong));
            }
            if (charAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(parseLong));
            }
            if (charAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(parseLong));
            }
            if (charAt == 'n') {
                return Long.valueOf(parseLong);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", new Object[]{Character.valueOf(charAt)}));
        }

        /* renamed from: d */
        public String a(Long l10) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l10.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            } else if (l10.longValue() < 100000000) {
                return l10 + "n";
            } else if (l10.longValue() < 100000000000L) {
                return timeUnit.toMicros(l10.longValue()) + "u";
            } else if (l10.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l10.longValue()) + "m";
            } else if (l10.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l10.longValue()) + "S";
            } else if (l10.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l10.longValue()) + "M";
            } else {
                return timeUnit.toHours(l10.longValue()) + "H";
            }
        }
    }

    static {
        v0.d dVar = v0.f20181e;
        f20876e = v0.g.e("grpc-encoding", dVar);
        f20878g = v0.g.e("content-encoding", dVar);
        f20880i = v0.g.e("content-length", dVar);
        f20881j = v0.g.e("content-type", dVar);
        f20882k = v0.g.e("te", dVar);
        f20883l = v0.g.e("user-agent", dVar);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f20885n = timeUnit.toNanos(20);
        f20887p = timeUnit.toNanos(20);
    }

    public static URI b(String str) {
        Preconditions.checkNotNull(str, "authority");
        try {
            return new URI((String) null, str, (String) null, (String) null, (String) null);
        } catch (URISyntaxException e10) {
            throw new IllegalArgumentException("Invalid authority: " + str, e10);
        }
    }

    public static String c(String str) {
        boolean z10;
        URI b10 = b(str);
        boolean z11 = true;
        if (b10.getHost() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "No host in authority '%s'", (Object) str);
        if (b10.getUserInfo() != null) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Userinfo must not be present on authority: '%s'", (Object) str);
        return str;
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                f20872a.log(Level.WARNING, "exception caught in closeQuietly", e10);
            }
        }
    }

    public static void e(i2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next != null) {
                d(next);
            } else {
                return;
            }
        }
    }

    public static k[] f(y8.c cVar, v0 v0Var, int i10, boolean z10) {
        List i11 = cVar.i();
        int size = i11.size() + 1;
        k[] kVarArr = new k[size];
        k.b a10 = k.b.a().b(cVar).d(i10).c(z10).a();
        for (int i12 = 0; i12 < i11.size(); i12++) {
            kVarArr[i12] = ((k.a) i11.get(i12)).a(a10, v0Var);
        }
        kVarArr[size - 1] = f20891t;
        return kVarArr;
    }

    public static String g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append('/');
        sb.append("1.52.1");
        return sb.toString();
    }

    public static String h(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory i(String str, boolean z10) {
        return new ThreadFactoryBuilder().setDaemon(z10).setNameFormat(str).build();
    }

    public static s j(o0.e eVar, boolean z10) {
        s sVar;
        o0.h c10 = eVar.c();
        if (c10 != null) {
            sVar = ((l2) c10.d()).a();
        } else {
            sVar = null;
        }
        if (sVar != null) {
            k.a b10 = eVar.b();
            if (b10 == null) {
                return sVar;
            }
            return new f(b10, sVar);
        }
        if (!eVar.a().p()) {
            if (eVar.d()) {
                return new g0(n(eVar.a()), r.a.DROPPED);
            }
            if (!z10) {
                return new g0(n(eVar.a()), r.a.PROCESSED);
            }
        }
        return null;
    }

    public static k1.b k(int i10) {
        if (i10 >= 100 && i10 < 200) {
            return k1.b.INTERNAL;
        }
        if (i10 != 400) {
            if (i10 == 401) {
                return k1.b.UNAUTHENTICATED;
            }
            if (i10 == 403) {
                return k1.b.PERMISSION_DENIED;
            }
            if (i10 == 404) {
                return k1.b.UNIMPLEMENTED;
            }
            if (i10 != 429) {
                if (i10 != 431) {
                    switch (i10) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return k1.b.UNKNOWN;
                    }
                }
            }
            return k1.b.UNAVAILABLE;
        }
        return k1.b.INTERNAL;
    }

    public static k1 l(int i10) {
        k1 b10 = k(i10).b();
        return b10.r("HTTP status code " + i10);
    }

    public static boolean m(String str) {
        char charAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("application/grpc")) {
            return false;
        }
        if (lowerCase.length() == 16 || (charAt = lowerCase.charAt(16)) == '+' || charAt == ';') {
            return true;
        }
        return false;
    }

    public static k1 n(k1 k1Var) {
        boolean z10;
        if (k1Var != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        if (!f20873b.contains(k1Var.n())) {
            return k1Var;
        }
        k1 k1Var2 = k1.f20055t;
        return k1Var2.r("Inappropriate status code from control plane: " + k1Var.n() + " " + k1Var.o()).q(k1Var.m());
    }

    public static boolean o(y8.c cVar) {
        return !Boolean.TRUE.equals(cVar.h(f20890s));
    }
}
