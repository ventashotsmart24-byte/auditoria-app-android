package m;

import java.util.ArrayList;
import l.c;
import m.e;

public class f {

    /* renamed from: u0  reason: collision with root package name */
    public static float f7699u0 = 0.5f;
    public e A = new e(this, e.d.CENTER_Y);
    public e B;
    public e[] C;
    public ArrayList D;
    public b[] E;
    public f F;
    public int G;
    public int H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public float Z;

    /* renamed from: a  reason: collision with root package name */
    public int f7700a = -1;

    /* renamed from: a0  reason: collision with root package name */
    public float f7701a0;

    /* renamed from: b  reason: collision with root package name */
    public int f7702b = -1;

    /* renamed from: b0  reason: collision with root package name */
    public Object f7703b0;

    /* renamed from: c  reason: collision with root package name */
    public n f7704c;

    /* renamed from: c0  reason: collision with root package name */
    public int f7705c0;

    /* renamed from: d  reason: collision with root package name */
    public n f7706d;

    /* renamed from: d0  reason: collision with root package name */
    public int f7707d0;

    /* renamed from: e  reason: collision with root package name */
    public int f7708e = 0;

    /* renamed from: e0  reason: collision with root package name */
    public String f7709e0;

    /* renamed from: f  reason: collision with root package name */
    public int f7710f = 0;

    /* renamed from: f0  reason: collision with root package name */
    public String f7711f0;

    /* renamed from: g  reason: collision with root package name */
    public int[] f7712g = new int[2];

    /* renamed from: g0  reason: collision with root package name */
    public boolean f7713g0;

    /* renamed from: h  reason: collision with root package name */
    public int f7714h = 0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f7715h0;

    /* renamed from: i  reason: collision with root package name */
    public int f7716i = 0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f7717i0;

    /* renamed from: j  reason: collision with root package name */
    public float f7718j = 1.0f;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f7719j0;

    /* renamed from: k  reason: collision with root package name */
    public int f7720k = 0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f7721k0;

    /* renamed from: l  reason: collision with root package name */
    public int f7722l = 0;

    /* renamed from: l0  reason: collision with root package name */
    public int f7723l0;

    /* renamed from: m  reason: collision with root package name */
    public float f7724m = 1.0f;

    /* renamed from: m0  reason: collision with root package name */
    public int f7725m0;

    /* renamed from: n  reason: collision with root package name */
    public boolean f7726n;

    /* renamed from: n0  reason: collision with root package name */
    public boolean f7727n0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7728o;

    /* renamed from: o0  reason: collision with root package name */
    public boolean f7729o0;

    /* renamed from: p  reason: collision with root package name */
    public int f7730p = -1;

    /* renamed from: p0  reason: collision with root package name */
    public float[] f7731p0;

    /* renamed from: q  reason: collision with root package name */
    public float f7732q = 1.0f;

    /* renamed from: q0  reason: collision with root package name */
    public f[] f7733q0;

    /* renamed from: r  reason: collision with root package name */
    public h f7734r = null;

    /* renamed from: r0  reason: collision with root package name */
    public f[] f7735r0;

    /* renamed from: s  reason: collision with root package name */
    public int[] f7736s = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: s0  reason: collision with root package name */
    public f f7737s0;

    /* renamed from: t  reason: collision with root package name */
    public float f7738t = 0.0f;

    /* renamed from: t0  reason: collision with root package name */
    public f f7739t0;

    /* renamed from: u  reason: collision with root package name */
    public e f7740u = new e(this, e.d.LEFT);

    /* renamed from: v  reason: collision with root package name */
    public e f7741v = new e(this, e.d.TOP);

    /* renamed from: w  reason: collision with root package name */
    public e f7742w = new e(this, e.d.RIGHT);

    /* renamed from: x  reason: collision with root package name */
    public e f7743x = new e(this, e.d.BOTTOM);

    /* renamed from: y  reason: collision with root package name */
    public e f7744y = new e(this, e.d.BASELINE);

    /* renamed from: z  reason: collision with root package name */
    public e f7745z = new e(this, e.d.CENTER_X);

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7746a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f7747b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                m.f$b[] r0 = m.f.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7747b = r0
                r1 = 1
                m.f$b r2 = m.f.b.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f7747b     // Catch:{ NoSuchFieldError -> 0x001d }
                m.f$b r3 = m.f.b.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f7747b     // Catch:{ NoSuchFieldError -> 0x0028 }
                m.f$b r4 = m.f.b.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f7747b     // Catch:{ NoSuchFieldError -> 0x0033 }
                m.f$b r5 = m.f.b.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                m.e$d[] r4 = m.e.d.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f7746a = r4
                m.e$d r5 = m.e.d.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f7746a     // Catch:{ NoSuchFieldError -> 0x004e }
                m.e$d r4 = m.e.d.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x0058 }
                m.e$d r1 = m.e.d.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x0062 }
                m.e$d r1 = m.e.d.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x006d }
                m.e$d r1 = m.e.d.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x0078 }
                m.e$d r1 = m.e.d.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x0083 }
                m.e$d r1 = m.e.d.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x008f }
                m.e$d r1 = m.e.d.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f7746a     // Catch:{ NoSuchFieldError -> 0x009b }
                m.e$d r1 = m.e.d.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m.f.a.<clinit>():void");
        }
    }

    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public f() {
        e eVar = new e(this, e.d.CENTER);
        this.B = eVar;
        this.C = new e[]{this.f7740u, this.f7742w, this.f7741v, this.f7743x, this.f7744y, eVar};
        this.D = new ArrayList();
        b bVar = b.FIXED;
        this.E = new b[]{bVar, bVar};
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f10 = f7699u0;
        this.Z = f10;
        this.f7701a0 = f10;
        this.f7705c0 = 0;
        this.f7707d0 = 0;
        this.f7709e0 = null;
        this.f7711f0 = null;
        this.f7717i0 = false;
        this.f7719j0 = false;
        this.f7721k0 = false;
        this.f7723l0 = 0;
        this.f7725m0 = 0;
        this.f7731p0 = new float[]{-1.0f, -1.0f};
        this.f7733q0 = new f[]{null, null};
        this.f7735r0 = new f[]{null, null};
        this.f7737s0 = null;
        this.f7739t0 = null;
        a();
    }

    public int A() {
        return this.L + this.T;
    }

    public void A0(int i10) {
        this.Y = i10;
    }

    public b B() {
        return this.E[1];
    }

    public void B0(int i10) {
        this.X = i10;
    }

    public int C() {
        return this.f7707d0;
    }

    public void C0(int i10) {
        this.K = i10;
    }

    public int D() {
        if (this.f7707d0 == 8) {
            return 0;
        }
        return this.G;
    }

    public void D0(int i10) {
        this.L = i10;
    }

    public int E() {
        return this.Y;
    }

    public void E0(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.f7730p == -1) {
            if (z12 && !z13) {
                this.f7730p = 0;
            } else if (!z12 && z13) {
                this.f7730p = 1;
                if (this.J == -1) {
                    this.f7732q = 1.0f / this.f7732q;
                }
            }
        }
        if (this.f7730p == 0 && (!this.f7741v.k() || !this.f7743x.k())) {
            this.f7730p = 1;
        } else if (this.f7730p == 1 && (!this.f7740u.k() || !this.f7742w.k())) {
            this.f7730p = 0;
        }
        if (this.f7730p == -1 && (!this.f7741v.k() || !this.f7743x.k() || !this.f7740u.k() || !this.f7742w.k())) {
            if (this.f7741v.k() && this.f7743x.k()) {
                this.f7730p = 0;
            } else if (this.f7740u.k() && this.f7742w.k()) {
                this.f7732q = 1.0f / this.f7732q;
                this.f7730p = 1;
            }
        }
        if (this.f7730p == -1) {
            if (z10 && !z11) {
                this.f7730p = 0;
            } else if (!z10 && z11) {
                this.f7732q = 1.0f / this.f7732q;
                this.f7730p = 1;
            }
        }
        if (this.f7730p == -1) {
            int i10 = this.f7714h;
            if (i10 > 0 && this.f7720k == 0) {
                this.f7730p = 0;
            } else if (i10 == 0 && this.f7720k > 0) {
                this.f7732q = 1.0f / this.f7732q;
                this.f7730p = 1;
            }
        }
        if (this.f7730p == -1 && z10 && z11) {
            this.f7732q = 1.0f / this.f7732q;
            this.f7730p = 1;
        }
    }

    public int F() {
        return this.X;
    }

    public void F0() {
        int i10 = this.K;
        int i11 = this.L;
        this.O = i10;
        this.P = i11;
        this.Q = (this.G + i10) - i10;
        this.R = (this.H + i11) - i11;
    }

    public int G() {
        return this.K;
    }

    public void G0(l.e eVar) {
        int y10 = eVar.y(this.f7740u);
        int y11 = eVar.y(this.f7741v);
        int y12 = eVar.y(this.f7742w);
        int y13 = eVar.y(this.f7743x);
        int i10 = y13 - y11;
        if (y12 - y10 < 0 || i10 < 0 || y10 == Integer.MIN_VALUE || y10 == Integer.MAX_VALUE || y11 == Integer.MIN_VALUE || y11 == Integer.MAX_VALUE || y12 == Integer.MIN_VALUE || y12 == Integer.MAX_VALUE || y13 == Integer.MIN_VALUE || y13 == Integer.MAX_VALUE) {
            y10 = 0;
            y13 = 0;
            y11 = 0;
            y12 = 0;
        }
        a0(y10, y11, y12, y13);
    }

    public int H() {
        return this.L;
    }

    public void H0() {
        for (int i10 = 0; i10 < 6; i10++) {
            this.C[i10].f().q();
        }
    }

    public boolean I() {
        if (this.U > 0) {
            return true;
        }
        return false;
    }

    public void J(e.d dVar, f fVar, e.d dVar2, int i10, int i11) {
        h(dVar).a(fVar.h(dVar2), i10, i11, e.c.STRONG, 0, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean K(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            m.e[] r0 = r3.C
            r1 = r0[r4]
            m.e r2 = r1.f7674d
            if (r2 == 0) goto L_0x001b
            m.e r2 = r2.f7674d
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            m.e r0 = r4.f7674d
            if (r0 == 0) goto L_0x001b
            m.e r0 = r0.f7674d
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.K(int):boolean");
    }

    public boolean L() {
        if (this.f7740u.f().f7792b == 1 && this.f7742w.f().f7792b == 1 && this.f7741v.f().f7792b == 1 && this.f7743x.f().f7792b == 1) {
            return true;
        }
        return false;
    }

    public boolean M() {
        e eVar = this.f7740u;
        e eVar2 = eVar.f7674d;
        if (eVar2 != null && eVar2.f7674d == eVar) {
            return true;
        }
        e eVar3 = this.f7742w;
        e eVar4 = eVar3.f7674d;
        if (eVar4 == null || eVar4.f7674d != eVar3) {
            return false;
        }
        return true;
    }

    public boolean N() {
        e eVar = this.f7741v;
        e eVar2 = eVar.f7674d;
        if (eVar2 != null && eVar2.f7674d == eVar) {
            return true;
        }
        e eVar3 = this.f7743x;
        e eVar4 = eVar3.f7674d;
        if (eVar4 == null || eVar4.f7674d != eVar3) {
            return false;
        }
        return true;
    }

    public boolean O() {
        if (this.f7710f == 0 && this.I == 0.0f && this.f7720k == 0 && this.f7722l == 0 && this.E[1] == b.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean P() {
        if (this.f7708e == 0 && this.I == 0.0f && this.f7714h == 0 && this.f7716i == 0 && this.E[0] == b.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public void Q() {
        this.f7740u.m();
        this.f7741v.m();
        this.f7742w.m();
        this.f7743x.m();
        this.f7744y.m();
        this.f7745z.m();
        this.A.m();
        this.B.m();
        this.F = null;
        this.f7738t = 0.0f;
        this.G = 0;
        this.H = 0;
        this.I = 0.0f;
        this.J = -1;
        this.K = 0;
        this.L = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        float f10 = f7699u0;
        this.Z = f10;
        this.f7701a0 = f10;
        b[] bVarArr = this.E;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.f7703b0 = null;
        this.f7705c0 = 0;
        this.f7707d0 = 0;
        this.f7711f0 = null;
        this.f7713g0 = false;
        this.f7715h0 = false;
        this.f7723l0 = 0;
        this.f7725m0 = 0;
        this.f7727n0 = false;
        this.f7729o0 = false;
        float[] fArr = this.f7731p0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f7700a = -1;
        this.f7702b = -1;
        int[] iArr = this.f7736s;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f7708e = 0;
        this.f7710f = 0;
        this.f7718j = 1.0f;
        this.f7724m = 1.0f;
        this.f7716i = Integer.MAX_VALUE;
        this.f7722l = Integer.MAX_VALUE;
        this.f7714h = 0;
        this.f7720k = 0;
        this.f7730p = -1;
        this.f7732q = 1.0f;
        n nVar = this.f7704c;
        if (nVar != null) {
            nVar.e();
        }
        n nVar2 = this.f7706d;
        if (nVar2 != null) {
            nVar2.e();
        }
        this.f7734r = null;
        this.f7717i0 = false;
        this.f7719j0 = false;
        this.f7721k0 = false;
    }

    public void R() {
        f u10 = u();
        if (u10 == null || !(u10 instanceof g) || !((g) u()).S0()) {
            int size = this.D.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((e) this.D.get(i10)).m();
            }
        }
    }

    public void S() {
        for (int i10 = 0; i10 < 6; i10++) {
            this.C[i10].f().e();
        }
    }

    public void T(c cVar) {
        this.f7740u.n(cVar);
        this.f7741v.n(cVar);
        this.f7742w.n(cVar);
        this.f7743x.n(cVar);
        this.f7744y.n(cVar);
        this.B.n(cVar);
        this.f7745z.n(cVar);
        this.A.n(cVar);
    }

    public void U() {
    }

    public void V(int i10) {
        this.U = i10;
    }

    public void W(Object obj) {
        this.f7703b0 = obj;
    }

    public void X(String str) {
        this.f7709e0 = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Y(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0091
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0091
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = 1
            goto L_0x0036
        L_0x0035:
            r3 = -1
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0087
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0087
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0087
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0087
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0087
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0086:
        L_0x0087:
            r9 = 0
        L_0x0088:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0090
            r8.I = r9
            r8.J = r5
        L_0x0090:
            return
        L_0x0091:
            r8.I = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.Y(java.lang.String):void");
    }

    public void Z(int i10, int i11, int i12) {
        if (i12 == 0) {
            f0(i10, i11);
        } else if (i12 == 1) {
            t0(i10, i11);
        }
        this.f7719j0 = true;
    }

    public final void a() {
        this.D.add(this.f7740u);
        this.D.add(this.f7741v);
        this.D.add(this.f7742w);
        this.D.add(this.f7743x);
        this.D.add(this.f7745z);
        this.D.add(this.A);
        this.D.add(this.B);
        this.D.add(this.f7744y);
    }

    public void a0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.K = i10;
        this.L = i11;
        if (this.f7707d0 == 8) {
            this.G = 0;
            this.H = 0;
            return;
        }
        b[] bVarArr = this.E;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i16 < (i15 = this.G)) {
            i16 = i15;
        }
        if (bVarArr[1] == bVar2 && i17 < (i14 = this.H)) {
            i17 = i14;
        }
        this.G = i16;
        this.H = i17;
        int i18 = this.W;
        if (i17 < i18) {
            this.H = i18;
        }
        int i19 = this.V;
        if (i16 < i19) {
            this.G = i19;
        }
        this.f7719j0 = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x021b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(l.e r42) {
        /*
            r41 = this;
            r15 = r41
            r14 = r42
            m.e r0 = r15.f7740u
            l.i r21 = r14.r(r0)
            m.e r0 = r15.f7742w
            l.i r10 = r14.r(r0)
            m.e r0 = r15.f7741v
            l.i r6 = r14.r(r0)
            m.e r0 = r15.f7743x
            l.i r4 = r14.r(r0)
            m.e r0 = r15.f7744y
            l.i r3 = r14.r(r0)
            m.f r0 = r15.F
            r1 = 8
            r2 = 1
            r13 = 0
            if (r0 == 0) goto L_0x00af
            if (r0 == 0) goto L_0x0036
            m.f$b[] r5 = r0.E
            r5 = r5[r13]
            m.f$b r7 = m.f.b.WRAP_CONTENT
            if (r5 != r7) goto L_0x0036
            r5 = 1
            goto L_0x0037
        L_0x0036:
            r5 = 0
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            m.f$b[] r0 = r0.E
            r0 = r0[r2]
            m.f$b r7 = m.f.b.WRAP_CONTENT
            if (r0 != r7) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            boolean r7 = r15.K(r13)
            if (r7 == 0) goto L_0x0053
            m.f r7 = r15.F
            m.g r7 = (m.g) r7
            r7.N0(r15, r13)
            r7 = 1
            goto L_0x0057
        L_0x0053:
            boolean r7 = r41.M()
        L_0x0057:
            boolean r8 = r15.K(r2)
            if (r8 == 0) goto L_0x0066
            m.f r8 = r15.F
            m.g r8 = (m.g) r8
            r8.N0(r15, r2)
            r8 = 1
            goto L_0x006a
        L_0x0066:
            boolean r8 = r41.N()
        L_0x006a:
            if (r5 == 0) goto L_0x0087
            int r9 = r15.f7707d0
            if (r9 == r1) goto L_0x0087
            m.e r9 = r15.f7740u
            m.e r9 = r9.f7674d
            if (r9 != 0) goto L_0x0087
            m.e r9 = r15.f7742w
            m.e r9 = r9.f7674d
            if (r9 != 0) goto L_0x0087
            m.f r9 = r15.F
            m.e r9 = r9.f7742w
            l.i r9 = r14.r(r9)
            r14.i(r9, r10, r13, r2)
        L_0x0087:
            if (r0 == 0) goto L_0x00a8
            int r9 = r15.f7707d0
            if (r9 == r1) goto L_0x00a8
            m.e r9 = r15.f7741v
            m.e r9 = r9.f7674d
            if (r9 != 0) goto L_0x00a8
            m.e r9 = r15.f7743x
            m.e r9 = r9.f7674d
            if (r9 != 0) goto L_0x00a8
            m.e r9 = r15.f7744y
            if (r9 != 0) goto L_0x00a8
            m.f r9 = r15.F
            m.e r9 = r9.f7743x
            l.i r9 = r14.r(r9)
            r14.i(r9, r4, r13, r2)
        L_0x00a8:
            r12 = r0
            r0 = r5
            r16 = r7
            r22 = r8
            goto L_0x00b5
        L_0x00af:
            r0 = 0
            r12 = 0
            r16 = 0
            r22 = 0
        L_0x00b5:
            int r5 = r15.G
            int r7 = r15.V
            if (r5 >= r7) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r7 = r5
        L_0x00bd:
            int r8 = r15.H
            int r9 = r15.W
            if (r8 >= r9) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r9 = r8
        L_0x00c5:
            m.f$b[] r11 = r15.E
            r1 = r11[r13]
            m.f$b r13 = m.f.b.MATCH_CONSTRAINT
            r20 = r3
            if (r1 == r13) goto L_0x00d1
            r3 = 1
            goto L_0x00d2
        L_0x00d1:
            r3 = 0
        L_0x00d2:
            r11 = r11[r2]
            r24 = r4
            if (r11 == r13) goto L_0x00d9
            goto L_0x00da
        L_0x00d9:
            r2 = 0
        L_0x00da:
            int r4 = r15.J
            r15.f7730p = r4
            r25 = r6
            float r6 = r15.I
            r15.f7732q = r6
            r19 = r7
            int r7 = r15.f7708e
            r26 = r9
            int r9 = r15.f7710f
            r27 = 0
            r28 = r10
            int r27 = (r6 > r27 ? 1 : (r6 == r27 ? 0 : -1))
            if (r27 <= 0) goto L_0x0160
            int r10 = r15.f7707d0
            r14 = 8
            if (r10 == r14) goto L_0x0160
            r10 = 3
            if (r1 != r13) goto L_0x0100
            if (r7 != 0) goto L_0x0100
            r7 = 3
        L_0x0100:
            if (r11 != r13) goto L_0x0105
            if (r9 != 0) goto L_0x0105
            r9 = 3
        L_0x0105:
            if (r1 != r13) goto L_0x0111
            if (r11 != r13) goto L_0x0111
            if (r7 != r10) goto L_0x0111
            if (r9 != r10) goto L_0x0111
            r15.E0(r0, r12, r3, r2)
            goto L_0x0155
        L_0x0111:
            r2 = 4
            if (r1 != r13) goto L_0x012e
            if (r7 != r10) goto L_0x012e
            r3 = 0
            r15.f7730p = r3
            float r1 = (float) r8
            float r6 = r6 * r1
            int r1 = (int) r6
            r10 = r1
            if (r11 == r13) goto L_0x0129
            r31 = r9
            r29 = r26
            r26 = 0
            r30 = 4
            goto L_0x016a
        L_0x0129:
            r30 = r7
            r31 = r9
            goto L_0x015b
        L_0x012e:
            if (r11 != r13) goto L_0x0155
            if (r9 != r10) goto L_0x0155
            r3 = 1
            r15.f7730p = r3
            r3 = -1
            if (r4 != r3) goto L_0x013d
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 / r6
            r15.f7732q = r3
        L_0x013d:
            float r3 = r15.f7732q
            float r4 = (float) r5
            float r3 = r3 * r4
            int r3 = (int) r3
            r29 = r3
            r30 = r7
            if (r1 == r13) goto L_0x0150
            r10 = r19
            r26 = 0
            r31 = 4
            goto L_0x016a
        L_0x0150:
            r31 = r9
            r10 = r19
            goto L_0x015d
        L_0x0155:
            r30 = r7
            r31 = r9
            r10 = r19
        L_0x015b:
            r29 = r26
        L_0x015d:
            r26 = 1
            goto L_0x016a
        L_0x0160:
            r30 = r7
            r31 = r9
            r10 = r19
            r29 = r26
            r26 = 0
        L_0x016a:
            int[] r1 = r15.f7712g
            r2 = 0
            r1[r2] = r30
            r2 = 1
            r1[r2] = r31
            if (r26 == 0) goto L_0x017e
            int r1 = r15.f7730p
            r14 = -1
            if (r1 == 0) goto L_0x017b
            if (r1 != r14) goto L_0x017f
        L_0x017b:
            r27 = 1
            goto L_0x0181
        L_0x017e:
            r14 = -1
        L_0x017f:
            r27 = 0
        L_0x0181:
            m.f$b[] r1 = r15.E
            r2 = 0
            r1 = r1[r2]
            m.f$b r6 = m.f.b.WRAP_CONTENT
            if (r1 != r6) goto L_0x0191
            boolean r1 = r15 instanceof m.g
            if (r1 == 0) goto L_0x0191
            r32 = 1
            goto L_0x0193
        L_0x0191:
            r32 = 0
        L_0x0193:
            m.e r1 = r15.B
            boolean r1 = r1.k()
            r2 = 1
            r23 = r1 ^ 1
            int r1 = r15.f7700a
            r4 = 2
            r33 = 0
            if (r1 == r4) goto L_0x020a
            m.f r1 = r15.F
            if (r1 == 0) goto L_0x01b2
            m.e r1 = r1.f7742w
            r3 = r42
            l.i r1 = r3.r(r1)
            r34 = r1
            goto L_0x01b6
        L_0x01b2:
            r3 = r42
            r34 = r33
        L_0x01b6:
            m.f r1 = r15.F
            if (r1 == 0) goto L_0x01c3
            m.e r1 = r1.f7740u
            l.i r1 = r3.r(r1)
            r35 = r1
            goto L_0x01c5
        L_0x01c3:
            r35 = r33
        L_0x01c5:
            m.f$b[] r1 = r15.E
            r13 = 0
            r5 = r1[r13]
            m.e r7 = r15.f7740u
            m.e r8 = r15.f7742w
            int r9 = r15.K
            int r11 = r15.V
            int[] r1 = r15.f7736s
            r1 = r1[r13]
            r36 = r12
            r12 = r1
            float r1 = r15.Z
            r13 = r1
            int r1 = r15.f7714h
            r17 = r1
            int r1 = r15.f7716i
            r18 = r1
            float r1 = r15.f7718j
            r19 = r1
            r37 = r0
            r0 = r41
            r1 = r42
            r2 = r37
            r38 = r20
            r3 = r35
            r4 = r34
            r40 = r6
            r39 = r25
            r6 = r32
            r25 = r28
            r14 = r27
            r15 = r16
            r16 = r30
            r20 = r23
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0214
        L_0x020a:
            r40 = r6
            r36 = r12
            r38 = r20
            r39 = r25
            r25 = r28
        L_0x0214:
            r15 = r41
            int r0 = r15.f7702b
            r1 = 2
            if (r0 != r1) goto L_0x021c
            return
        L_0x021c:
            m.f$b[] r0 = r15.E
            r14 = 1
            r0 = r0[r14]
            r1 = r40
            if (r0 != r1) goto L_0x022b
            boolean r0 = r15 instanceof m.g
            if (r0 == 0) goto L_0x022b
            r6 = 1
            goto L_0x022c
        L_0x022b:
            r6 = 0
        L_0x022c:
            if (r26 == 0) goto L_0x0238
            int r0 = r15.f7730p
            if (r0 == r14) goto L_0x0235
            r1 = -1
            if (r0 != r1) goto L_0x0238
        L_0x0235:
            r16 = 1
            goto L_0x023a
        L_0x0238:
            r16 = 0
        L_0x023a:
            int r0 = r15.U
            if (r0 <= 0) goto L_0x0273
            m.e r0 = r15.f7744y
            m.m r0 = r0.f()
            int r0 = r0.f7792b
            if (r0 != r14) goto L_0x0254
            m.e r0 = r15.f7744y
            m.m r0 = r0.f()
            r10 = r42
            r0.g(r10)
            goto L_0x0275
        L_0x0254:
            r10 = r42
            int r0 = r41.j()
            r1 = 6
            r2 = r38
            r4 = r39
            r10.e(r2, r4, r0, r1)
            m.e r0 = r15.f7744y
            m.e r0 = r0.f7674d
            if (r0 == 0) goto L_0x0277
            l.i r0 = r10.r(r0)
            r3 = 0
            r10.e(r2, r0, r3, r1)
            r20 = 0
            goto L_0x0279
        L_0x0273:
            r10 = r42
        L_0x0275:
            r4 = r39
        L_0x0277:
            r20 = r23
        L_0x0279:
            m.f r0 = r15.F
            if (r0 == 0) goto L_0x0286
            m.e r0 = r0.f7743x
            l.i r0 = r10.r(r0)
            r23 = r0
            goto L_0x0288
        L_0x0286:
            r23 = r33
        L_0x0288:
            m.f r0 = r15.F
            if (r0 == 0) goto L_0x0294
            m.e r0 = r0.f7741v
            l.i r0 = r10.r(r0)
            r3 = r0
            goto L_0x0296
        L_0x0294:
            r3 = r33
        L_0x0296:
            m.f$b[] r0 = r15.E
            r5 = r0[r14]
            m.e r7 = r15.f7741v
            m.e r8 = r15.f7743x
            int r9 = r15.L
            int r11 = r15.W
            int[] r0 = r15.f7736s
            r12 = r0[r14]
            float r13 = r15.f7701a0
            int r0 = r15.f7720k
            r17 = r0
            int r0 = r15.f7722l
            r18 = r0
            float r0 = r15.f7724m
            r19 = r0
            r0 = r41
            r1 = r42
            r2 = r36
            r27 = r4
            r4 = r23
            r10 = r29
            r14 = r16
            r15 = r22
            r16 = r31
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r26 == 0) goto L_0x02f4
            r6 = 6
            r7 = r41
            int r0 = r7.f7730p
            r1 = 1
            if (r0 != r1) goto L_0x02e3
            float r5 = r7.f7732q
            r0 = r42
            r1 = r24
            r2 = r27
            r3 = r25
            r4 = r21
            r0.l(r1, r2, r3, r4, r5, r6)
            goto L_0x02f6
        L_0x02e3:
            float r5 = r7.f7732q
            r6 = 6
            r0 = r42
            r1 = r25
            r2 = r21
            r3 = r24
            r4 = r27
            r0.l(r1, r2, r3, r4, r5, r6)
            goto L_0x02f6
        L_0x02f4:
            r7 = r41
        L_0x02f6:
            m.e r0 = r7.B
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x031e
            m.e r0 = r7.B
            m.e r0 = r0.i()
            m.f r0 = r0.e()
            float r1 = r7.f7738t
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            m.e r2 = r7.B
            int r2 = r2.d()
            r3 = r42
            r3.b(r7, r0, r1, r2)
        L_0x031e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.b(l.e):void");
    }

    public void b0(int i10) {
        this.H = i10;
        int i11 = this.W;
        if (i10 < i11) {
            this.H = i11;
        }
    }

    public boolean c() {
        if (this.f7707d0 != 8) {
            return true;
        }
        return false;
    }

    public void c0(boolean z10) {
        this.f7728o = z10;
    }

    public void d(int i10) {
        k.a(i10, this);
    }

    public void d0(float f10) {
        this.Z = f10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:146:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ab A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(l.e r26, boolean r27, l.i r28, l.i r29, m.f.b r30, boolean r31, m.e r32, m.e r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            r25 = this;
            r0 = r25
            r10 = r26
            r11 = r28
            r12 = r29
            r13 = r32
            r14 = r33
            r1 = r36
            r2 = r37
            l.i r15 = r10.r(r13)
            l.i r9 = r10.r(r14)
            m.e r3 = r32.i()
            l.i r8 = r10.r(r3)
            m.e r3 = r33.i()
            l.i r7 = r10.r(r3)
            boolean r3 = r10.f7557g
            r6 = 1
            r5 = 0
            r4 = 6
            if (r3 == 0) goto L_0x0058
            m.m r3 = r32.f()
            int r3 = r3.f7792b
            if (r3 != r6) goto L_0x0058
            m.m r3 = r33.f()
            int r3 = r3.f7792b
            if (r3 != r6) goto L_0x0058
            l.e.x()
            m.m r1 = r32.f()
            r1.g(r10)
            m.m r1 = r33.f()
            r1.g(r10)
            if (r40 != 0) goto L_0x0057
            if (r27 == 0) goto L_0x0057
            r10.i(r12, r9, r5, r4)
        L_0x0057:
            return
        L_0x0058:
            l.e.x()
            boolean r16 = r32.k()
            boolean r17 = r33.k()
            m.e r3 = r0.B
            boolean r18 = r3.k()
            if (r17 == 0) goto L_0x006e
            int r3 = r16 + 1
            goto L_0x0070
        L_0x006e:
            r3 = r16
        L_0x0070:
            if (r18 == 0) goto L_0x0074
            int r3 = r3 + 1
        L_0x0074:
            if (r39 == 0) goto L_0x0078
            r4 = 3
            goto L_0x007a
        L_0x0078:
            r4 = r41
        L_0x007a:
            int[] r21 = m.f.a.f7747b
            int r22 = r30.ordinal()
            r5 = r21[r22]
            r14 = 2
            r13 = 4
            if (r5 == r6) goto L_0x008d
            if (r5 == r14) goto L_0x008d
            r14 = 3
            if (r5 == r14) goto L_0x008d
            if (r5 == r13) goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0093
        L_0x008f:
            if (r4 != r13) goto L_0x0092
            goto L_0x008d
        L_0x0092:
            r5 = 1
        L_0x0093:
            int r14 = r0.f7707d0
            r13 = 8
            if (r14 != r13) goto L_0x009c
            r5 = 0
            r13 = 0
            goto L_0x009f
        L_0x009c:
            r13 = r5
            r5 = r35
        L_0x009f:
            if (r45 == 0) goto L_0x00ba
            if (r16 != 0) goto L_0x00ad
            if (r17 != 0) goto L_0x00ad
            if (r18 != 0) goto L_0x00ad
            r14 = r34
            r10.f(r15, r14)
            goto L_0x00ba
        L_0x00ad:
            if (r16 == 0) goto L_0x00ba
            if (r17 != 0) goto L_0x00ba
            int r14 = r32.d()
            r6 = 6
            r10.e(r15, r8, r14, r6)
            goto L_0x00bb
        L_0x00ba:
            r6 = 6
        L_0x00bb:
            if (r13 != 0) goto L_0x00e7
            if (r31 == 0) goto L_0x00d4
            r6 = 0
            r14 = 3
            r10.e(r9, r15, r6, r14)
            r5 = 6
            if (r1 <= 0) goto L_0x00ca
            r10.i(r9, r15, r1, r5)
        L_0x00ca:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r6) goto L_0x00d2
            r10.k(r9, r15, r2, r5)
        L_0x00d2:
            r6 = 6
            goto L_0x00d8
        L_0x00d4:
            r14 = 3
            r10.e(r9, r15, r5, r6)
        L_0x00d8:
            r14 = r42
            r0 = r3
            r24 = r4
            r1 = r7
            r22 = r8
            r19 = r13
            r2 = 2
            r13 = r43
            goto L_0x01c2
        L_0x00e7:
            r14 = 3
            r2 = -2
            r14 = r42
            r6 = r43
            if (r14 != r2) goto L_0x00f0
            r14 = r5
        L_0x00f0:
            if (r6 != r2) goto L_0x00f3
            r6 = r5
        L_0x00f3:
            r2 = 6
            if (r14 <= 0) goto L_0x00fd
            r10.i(r9, r15, r14, r2)
            int r5 = java.lang.Math.max(r5, r14)
        L_0x00fd:
            if (r6 <= 0) goto L_0x0106
            r10.k(r9, r15, r6, r2)
            int r5 = java.lang.Math.min(r5, r6)
        L_0x0106:
            r2 = 1
            if (r4 != r2) goto L_0x012f
            if (r27 == 0) goto L_0x011b
            r2 = 6
            r10.e(r9, r15, r5, r2)
            r0 = r3
            r24 = r4
            r1 = r7
            r22 = r8
            r35 = r13
            r8 = r5
            r13 = r6
            goto L_0x01a6
        L_0x011b:
            r2 = 6
            if (r40 == 0) goto L_0x0126
            r35 = r13
            r13 = 4
            r10.e(r9, r15, r5, r13)
            goto L_0x019e
        L_0x0126:
            r35 = r13
            r2 = 1
            r13 = 4
            r10.e(r9, r15, r5, r2)
            goto L_0x019e
        L_0x012f:
            r35 = r13
            r2 = 2
            r13 = 4
            if (r4 != r2) goto L_0x019e
            m.e$d r2 = r32.j()
            m.e$d r13 = m.e.d.TOP
            if (r2 == r13) goto L_0x0161
            m.e$d r2 = r32.j()
            r22 = r3
            m.e$d r3 = m.e.d.BOTTOM
            if (r2 != r3) goto L_0x0148
            goto L_0x0163
        L_0x0148:
            m.f r2 = r0.F
            m.e$d r3 = m.e.d.LEFT
            m.e r2 = r2.h(r3)
            l.i r2 = r10.r(r2)
            m.f r3 = r0.F
            m.e$d r13 = m.e.d.RIGHT
            m.e r3 = r3.h(r13)
            l.i r3 = r10.r(r3)
            goto L_0x0179
        L_0x0161:
            r22 = r3
        L_0x0163:
            m.f r2 = r0.F
            m.e r2 = r2.h(r13)
            l.i r2 = r10.r(r2)
            m.f r3 = r0.F
            m.e$d r13 = m.e.d.BOTTOM
            m.e r3 = r3.h(r13)
            l.i r3 = r10.r(r3)
        L_0x0179:
            r23 = r2
            r13 = r3
            l.b r2 = r26.s()
            r20 = 1
            r21 = 6
            r0 = r22
            r3 = r9
            r24 = r4
            r22 = r8
            r8 = 6
            r4 = r15
            r8 = r5
            r5 = r13
            r13 = r6
            r6 = r23
            r1 = r7
            r7 = r44
            l.b r2 = r2.j(r3, r4, r5, r6, r7)
            r10.d(r2)
            r5 = 0
            goto L_0x01a8
        L_0x019e:
            r0 = r3
            r24 = r4
            r13 = r6
            r1 = r7
            r22 = r8
            r8 = r5
        L_0x01a6:
            r5 = r35
        L_0x01a8:
            r2 = 2
            if (r5 == 0) goto L_0x01c0
            if (r0 == r2) goto L_0x01c0
            if (r39 != 0) goto L_0x01c0
            int r3 = java.lang.Math.max(r14, r8)
            if (r13 <= 0) goto L_0x01b9
            int r3 = java.lang.Math.min(r13, r3)
        L_0x01b9:
            r4 = 6
            r10.e(r9, r15, r3, r4)
            r19 = 0
            goto L_0x01c2
        L_0x01c0:
            r19 = r5
        L_0x01c2:
            if (r45 == 0) goto L_0x02f6
            if (r40 == 0) goto L_0x01c8
            goto L_0x02f6
        L_0x01c8:
            r0 = 5
            if (r16 != 0) goto L_0x01d7
            if (r17 != 0) goto L_0x01d7
            if (r18 != 0) goto L_0x01d7
            if (r27 == 0) goto L_0x02ea
            r8 = 0
            r10.i(r12, r9, r8, r0)
            goto L_0x02ea
        L_0x01d7:
            r8 = 0
            if (r16 == 0) goto L_0x01e3
            if (r17 != 0) goto L_0x01e3
            if (r27 == 0) goto L_0x02ea
            r10.i(r12, r9, r8, r0)
            goto L_0x02ea
        L_0x01e3:
            if (r16 != 0) goto L_0x01f7
            if (r17 == 0) goto L_0x01f7
            int r2 = r33.d()
            int r2 = -r2
            r3 = 6
            r10.e(r9, r1, r2, r3)
            if (r27 == 0) goto L_0x02ea
            r10.i(r15, r11, r8, r0)
            goto L_0x02ea
        L_0x01f7:
            if (r16 == 0) goto L_0x02ea
            if (r17 == 0) goto L_0x02ea
            if (r19 == 0) goto L_0x0265
            r7 = r1
            r6 = 6
            if (r27 == 0) goto L_0x0206
            if (r36 != 0) goto L_0x0206
            r10.i(r9, r15, r8, r6)
        L_0x0206:
            r5 = r24
            if (r5 != 0) goto L_0x0232
            if (r13 > 0) goto L_0x0212
            if (r14 <= 0) goto L_0x020f
            goto L_0x0212
        L_0x020f:
            r1 = 0
            r4 = 6
            goto L_0x0214
        L_0x0212:
            r1 = 1
            r4 = 4
        L_0x0214:
            int r2 = r32.d()
            r3 = r22
            r10.e(r15, r3, r2, r4)
            int r2 = r33.d()
            int r2 = -r2
            r10.e(r9, r7, r2, r4)
            if (r13 > 0) goto L_0x022c
            if (r14 <= 0) goto L_0x022a
            goto L_0x022c
        L_0x022a:
            r2 = 0
            goto L_0x022d
        L_0x022c:
            r2 = 1
        L_0x022d:
            r5 = r25
            r13 = r1
            r14 = 1
            goto L_0x026e
        L_0x0232:
            r3 = r22
            r14 = 1
            if (r5 != r14) goto L_0x023e
            r2 = 1
            r13 = 1
            r16 = 6
            r5 = r25
            goto L_0x0270
        L_0x023e:
            r1 = 3
            if (r5 != r1) goto L_0x0261
            r5 = r25
            if (r39 != 0) goto L_0x024e
            int r1 = r5.f7730p
            r2 = -1
            if (r1 == r2) goto L_0x024e
            if (r13 > 0) goto L_0x024e
            r4 = 6
            goto L_0x024f
        L_0x024e:
            r4 = 4
        L_0x024f:
            int r1 = r32.d()
            r10.e(r15, r3, r1, r4)
            int r1 = r33.d()
            int r1 = -r1
            r10.e(r9, r7, r1, r4)
            r2 = 1
            r13 = 1
            goto L_0x026e
        L_0x0261:
            r5 = r25
            r2 = 0
            goto L_0x026d
        L_0x0265:
            r5 = r25
            r7 = r1
            r3 = r22
            r6 = 6
            r14 = 1
            r2 = 1
        L_0x026d:
            r13 = 0
        L_0x026e:
            r16 = 5
        L_0x0270:
            if (r2 == 0) goto L_0x02b6
            int r4 = r32.d()
            int r17 = r33.d()
            r1 = r26
            r2 = r15
            r18 = r3
            r5 = r38
            r20 = 6
            r6 = r7
            r0 = r7
            r7 = r9
            r14 = r18
            r12 = 0
            r8 = r17
            r12 = r9
            r9 = r16
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r32
            m.e r2 = r1.f7674d
            m.f r2 = r2.f7672b
            boolean r2 = r2 instanceof m.b
            r3 = r33
            m.e r4 = r3.f7674d
            m.f r4 = r4.f7672b
            boolean r4 = r4 instanceof m.b
            if (r2 == 0) goto L_0x02ac
            if (r4 != 0) goto L_0x02ac
            r6 = r27
            r2 = 6
            r4 = 5
            r21 = 1
            goto L_0x02c3
        L_0x02ac:
            if (r2 != 0) goto L_0x02bd
            if (r4 == 0) goto L_0x02bd
            r21 = r27
            r2 = 5
            r4 = 6
            r6 = 1
            goto L_0x02c3
        L_0x02b6:
            r1 = r32
            r14 = r3
            r0 = r7
            r12 = r9
            r3 = r33
        L_0x02bd:
            r6 = r27
            r21 = r6
            r2 = 5
            r4 = 5
        L_0x02c3:
            if (r13 == 0) goto L_0x02c7
            r2 = 6
            r4 = 6
        L_0x02c7:
            if (r19 != 0) goto L_0x02cb
            if (r6 != 0) goto L_0x02cd
        L_0x02cb:
            if (r13 == 0) goto L_0x02d4
        L_0x02cd:
            int r1 = r32.d()
            r10.i(r15, r14, r1, r4)
        L_0x02d4:
            if (r19 != 0) goto L_0x02d8
            if (r21 != 0) goto L_0x02da
        L_0x02d8:
            if (r13 == 0) goto L_0x02e2
        L_0x02da:
            int r1 = r33.d()
            int r1 = -r1
            r10.k(r12, r0, r1, r2)
        L_0x02e2:
            r0 = 0
            r1 = 6
            if (r27 == 0) goto L_0x02ed
            r10.i(r15, r11, r0, r1)
            goto L_0x02ed
        L_0x02ea:
            r12 = r9
            r0 = 0
            r1 = 6
        L_0x02ed:
            if (r27 == 0) goto L_0x02f5
            r0 = r29
            r2 = 0
            r10.i(r0, r12, r2, r1)
        L_0x02f5:
            return
        L_0x02f6:
            r3 = r0
            r0 = r12
            r1 = 6
            r2 = 0
            r4 = 2
            r12 = r9
            if (r3 >= r4) goto L_0x0306
            if (r27 == 0) goto L_0x0306
            r10.i(r15, r11, r2, r1)
            r10.i(r0, r12, r2, r1)
        L_0x0306:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.f.e(l.e, boolean, l.i, l.i, m.f$b, boolean, m.e, m.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    public void e0(int i10) {
        this.f7723l0 = i10;
    }

    public void f(f fVar, float f10, int i10) {
        e.d dVar = e.d.CENTER;
        J(dVar, fVar, dVar, i10, 0);
        this.f7738t = f10;
    }

    public void f0(int i10, int i11) {
        this.K = i10;
        int i12 = i11 - i10;
        this.G = i12;
        int i13 = this.V;
        if (i12 < i13) {
            this.G = i13;
        }
    }

    public void g(l.e eVar) {
        eVar.r(this.f7740u);
        eVar.r(this.f7741v);
        eVar.r(this.f7742w);
        eVar.r(this.f7743x);
        if (this.U > 0) {
            eVar.r(this.f7744y);
        }
    }

    public void g0(b bVar) {
        this.E[0] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            y0(this.X);
        }
    }

    public e h(e.d dVar) {
        switch (a.f7746a[dVar.ordinal()]) {
            case 1:
                return this.f7740u;
            case 2:
                return this.f7741v;
            case 3:
                return this.f7742w;
            case 4:
                return this.f7743x;
            case 5:
                return this.f7744y;
            case 6:
                return this.B;
            case 7:
                return this.f7745z;
            case 8:
                return this.A;
            case 9:
                return null;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public void h0(int i10, int i11, int i12, float f10) {
        this.f7708e = i10;
        this.f7714h = i11;
        this.f7716i = i12;
        this.f7718j = f10;
        if (f10 < 1.0f && i10 == 0) {
            this.f7708e = 2;
        }
    }

    public ArrayList i() {
        return this.D;
    }

    public void i0(float f10) {
        this.f7731p0[0] = f10;
    }

    public int j() {
        return this.U;
    }

    public void j0(int i10) {
        this.f7736s[1] = i10;
    }

    public float k(int i10) {
        if (i10 == 0) {
            return this.Z;
        }
        if (i10 == 1) {
            return this.f7701a0;
        }
        return -1.0f;
    }

    public void k0(int i10) {
        this.f7736s[0] = i10;
    }

    public int l() {
        return H() + this.H;
    }

    public void l0(int i10) {
        if (i10 < 0) {
            this.W = 0;
        } else {
            this.W = i10;
        }
    }

    public Object m() {
        return this.f7703b0;
    }

    public void m0(int i10) {
        if (i10 < 0) {
            this.V = 0;
        } else {
            this.V = i10;
        }
    }

    public String n() {
        return this.f7709e0;
    }

    public void n0(int i10, int i11) {
        this.S = i10;
        this.T = i11;
    }

    public b o(int i10) {
        if (i10 == 0) {
            return s();
        }
        if (i10 == 1) {
            return B();
        }
        return null;
    }

    public void o0(int i10, int i11) {
        this.K = i10;
        this.L = i11;
    }

    public int p() {
        return this.O + this.S;
    }

    public void p0(f fVar) {
        this.F = fVar;
    }

    public int q() {
        return this.P + this.T;
    }

    public void q0(int i10, int i11) {
        if (i11 == 0) {
            this.M = i10;
        } else if (i11 == 1) {
            this.N = i10;
        }
    }

    public int r() {
        if (this.f7707d0 == 8) {
            return 0;
        }
        return this.H;
    }

    public void r0(float f10) {
        this.f7701a0 = f10;
    }

    public b s() {
        return this.E[0];
    }

    public void s0(int i10) {
        this.f7725m0 = i10;
    }

    public int t(int i10) {
        if (i10 == 0) {
            return D();
        }
        if (i10 == 1) {
            return r();
        }
        return 0;
    }

    public void t0(int i10, int i11) {
        this.L = i10;
        int i12 = i11 - i10;
        this.H = i12;
        int i13 = this.W;
        if (i12 < i13) {
            this.H = i13;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f7711f0 != null) {
            str = "type: " + this.f7711f0 + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.f7709e0 != null) {
            str2 = "id: " + this.f7709e0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.K);
        sb.append(", ");
        sb.append(this.L);
        sb.append(") - (");
        sb.append(this.G);
        sb.append(" x ");
        sb.append(this.H);
        sb.append(") wrap: (");
        sb.append(this.X);
        sb.append(" x ");
        sb.append(this.Y);
        sb.append(")");
        return sb.toString();
    }

    public f u() {
        return this.F;
    }

    public void u0(b bVar) {
        this.E[1] = bVar;
        if (bVar == b.WRAP_CONTENT) {
            b0(this.Y);
        }
    }

    public int v(int i10) {
        if (i10 == 0) {
            return this.M;
        }
        if (i10 == 1) {
            return this.N;
        }
        return 0;
    }

    public void v0(int i10, int i11, int i12, float f10) {
        this.f7710f = i10;
        this.f7720k = i11;
        this.f7722l = i12;
        this.f7724m = f10;
        if (f10 < 1.0f && i10 == 0) {
            this.f7710f = 2;
        }
    }

    public n w() {
        if (this.f7706d == null) {
            this.f7706d = new n();
        }
        return this.f7706d;
    }

    public void w0(float f10) {
        this.f7731p0[1] = f10;
    }

    public n x() {
        if (this.f7704c == null) {
            this.f7704c = new n();
        }
        return this.f7704c;
    }

    public void x0(int i10) {
        this.f7707d0 = i10;
    }

    public int y() {
        return G() + this.G;
    }

    public void y0(int i10) {
        this.G = i10;
        int i11 = this.V;
        if (i10 < i11) {
            this.G = i11;
        }
    }

    public int z() {
        return this.K + this.S;
    }

    public void z0(boolean z10) {
        this.f7726n = z10;
    }
}
