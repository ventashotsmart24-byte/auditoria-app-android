package z8;

import com.google.common.base.Preconditions;
import com.taobao.accs.common.Constants;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import y8.a1;
import y8.c0;
import y8.d1;
import y8.e;
import y8.o;
import y8.r0;
import y8.s0;
import y8.v;
import y8.y0;
import z8.e0;

public final class g1 extends s0 {
    public static final Logger H = Logger.getLogger(g1.class.getName());
    public static final long I = TimeUnit.MINUTES.toMillis(30);
    public static final long J = TimeUnit.SECONDS.toMillis(1);
    public static final o1 K = e2.c(q0.f20892u);
    public static final v L = v.c();
    public static final o M = o.a();
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final c F;
    public final b G;

    /* renamed from: a  reason: collision with root package name */
    public o1 f20638a;

    /* renamed from: b  reason: collision with root package name */
    public o1 f20639b;

    /* renamed from: c  reason: collision with root package name */
    public final List f20640c;

    /* renamed from: d  reason: collision with root package name */
    public final a1 f20641d;

    /* renamed from: e  reason: collision with root package name */
    public y0.c f20642e;

    /* renamed from: f  reason: collision with root package name */
    public final String f20643f;

    /* renamed from: g  reason: collision with root package name */
    public final y8.b f20644g;

    /* renamed from: h  reason: collision with root package name */
    public final SocketAddress f20645h;

    /* renamed from: i  reason: collision with root package name */
    public String f20646i;

    /* renamed from: j  reason: collision with root package name */
    public String f20647j;

    /* renamed from: k  reason: collision with root package name */
    public String f20648k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f20649l;

    /* renamed from: m  reason: collision with root package name */
    public v f20650m;

    /* renamed from: n  reason: collision with root package name */
    public o f20651n;

    /* renamed from: o  reason: collision with root package name */
    public long f20652o;

    /* renamed from: p  reason: collision with root package name */
    public int f20653p;

    /* renamed from: q  reason: collision with root package name */
    public int f20654q;

    /* renamed from: r  reason: collision with root package name */
    public long f20655r;

    /* renamed from: s  reason: collision with root package name */
    public long f20656s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f20657t;

    /* renamed from: u  reason: collision with root package name */
    public c0 f20658u;

    /* renamed from: v  reason: collision with root package name */
    public int f20659v;

    /* renamed from: w  reason: collision with root package name */
    public Map f20660w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f20661x;

    /* renamed from: y  reason: collision with root package name */
    public d1 f20662y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f20663z;

    public interface b {
        int a();
    }

    public interface c {
        t a();
    }

    public static final class d implements b {
        public d() {
        }

        public int a() {
            return Constants.PORT;
        }
    }

    public g1(String str, c cVar, b bVar) {
        this(str, (e) null, (y8.b) null, cVar, bVar);
    }

    public r0 a() {
        return new h1(new f1(this, this.F.a(), new e0.a(), e2.c(q0.f20892u), q0.f20894w, d(), j2.f20705a));
    }

    public int c() {
        return this.G.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List d() {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r1 = r13.f20640c
            r0.<init>(r1)
            java.util.List r1 = y8.g0.a()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0014
            r0.addAll(r1)
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            java.lang.String r4 = "getClientInterceptor"
            r5 = 0
            java.lang.String r6 = "Unable to apply census stats"
            if (r1 != 0) goto L_0x008b
            boolean r7 = r13.f20663z
            if (r7 == 0) goto L_0x008b
            java.lang.String r7 = "io.grpc.census.InternalCensusStatsAccessor"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r8 = 4
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r9[r3] = r10     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r9[r2] = r10     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r11 = 2
            r9[r11] = r10     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r12 = 3
            r9[r12] = r10     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r4, r9)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            boolean r9 = r13.A     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            boolean r9 = r13.B     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r8[r2] = r9     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            boolean r2 = r13.C     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r8[r11] = r2     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            boolean r2 = r13.D     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            r8[r12] = r2     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            java.lang.Object r2 = r7.invoke(r5, r8)     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            y8.h r2 = (y8.h) r2     // Catch:{ ClassNotFoundException -> 0x007d, NoSuchMethodException -> 0x0074, IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0062 }
            goto L_0x0086
        L_0x0062:
            r2 = move-exception
            java.util.logging.Logger r7 = H
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            r7.log(r8, r6, r2)
            goto L_0x0085
        L_0x006b:
            r2 = move-exception
            java.util.logging.Logger r7 = H
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            r7.log(r8, r6, r2)
            goto L_0x0085
        L_0x0074:
            r2 = move-exception
            java.util.logging.Logger r7 = H
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            r7.log(r8, r6, r2)
            goto L_0x0085
        L_0x007d:
            r2 = move-exception
            java.util.logging.Logger r7 = H
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            r7.log(r8, r6, r2)
        L_0x0085:
            r2 = r5
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r0.add(r3, r2)
        L_0x008b:
            if (r1 != 0) goto L_0x00cf
            boolean r1 = r13.E
            if (r1 == 0) goto L_0x00cf
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00c2, NoSuchMethodException -> 0x00b9, IllegalAccessException -> 0x00b0, InvocationTargetException -> 0x00a7 }
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00c2, NoSuchMethodException -> 0x00b9, IllegalAccessException -> 0x00b0, InvocationTargetException -> 0x00a7 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r2)     // Catch:{ ClassNotFoundException -> 0x00c2, NoSuchMethodException -> 0x00b9, IllegalAccessException -> 0x00b0, InvocationTargetException -> 0x00a7 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00c2, NoSuchMethodException -> 0x00b9, IllegalAccessException -> 0x00b0, InvocationTargetException -> 0x00a7 }
            java.lang.Object r1 = r1.invoke(r5, r2)     // Catch:{ ClassNotFoundException -> 0x00c2, NoSuchMethodException -> 0x00b9, IllegalAccessException -> 0x00b0, InvocationTargetException -> 0x00a7 }
            y8.h r1 = (y8.h) r1     // Catch:{ ClassNotFoundException -> 0x00c2, NoSuchMethodException -> 0x00b9, IllegalAccessException -> 0x00b0, InvocationTargetException -> 0x00a7 }
            r5 = r1
            goto L_0x00ca
        L_0x00a7:
            r1 = move-exception
            java.util.logging.Logger r2 = H
            java.util.logging.Level r4 = java.util.logging.Level.FINE
            r2.log(r4, r6, r1)
            goto L_0x00ca
        L_0x00b0:
            r1 = move-exception
            java.util.logging.Logger r2 = H
            java.util.logging.Level r4 = java.util.logging.Level.FINE
            r2.log(r4, r6, r1)
            goto L_0x00ca
        L_0x00b9:
            r1 = move-exception
            java.util.logging.Logger r2 = H
            java.util.logging.Level r4 = java.util.logging.Level.FINE
            r2.log(r4, r6, r1)
            goto L_0x00ca
        L_0x00c2:
            r1 = move-exception
            java.util.logging.Logger r2 = H
            java.util.logging.Level r4 = java.util.logging.Level.FINE
            r2.log(r4, r6, r1)
        L_0x00ca:
            if (r5 == 0) goto L_0x00cf
            r0.add(r3, r5)
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.g1.d():java.util.List");
    }

    public g1(String str, e eVar, y8.b bVar, c cVar, b bVar2) {
        o1 o1Var = K;
        this.f20638a = o1Var;
        this.f20639b = o1Var;
        this.f20640c = new ArrayList();
        a1 d10 = a1.d();
        this.f20641d = d10;
        this.f20642e = d10.c();
        this.f20648k = "pick_first";
        this.f20650m = L;
        this.f20651n = M;
        this.f20652o = I;
        this.f20653p = 5;
        this.f20654q = 5;
        this.f20655r = 16777216;
        this.f20656s = 1048576;
        this.f20657t = true;
        this.f20658u = c0.g();
        this.f20661x = true;
        this.f20663z = true;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.f20643f = (String) Preconditions.checkNotNull(str, "target");
        this.f20644g = bVar;
        this.F = (c) Preconditions.checkNotNull(cVar, "clientTransportFactoryBuilder");
        this.f20645h = null;
        if (bVar2 != null) {
            this.G = bVar2;
        } else {
            this.G = new d();
        }
    }
}
