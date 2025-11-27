package a9;

import a9.q;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.raizlabs.android.dbflow.sql.language.Operator;
import g9.c;
import g9.d;
import java.util.List;
import okio.Buffer;
import y8.k1;
import y8.v0;
import y8.w0;
import z8.a;
import z8.g2;
import z8.n2;
import z8.r;
import z8.t0;

public class h extends z8.a {

    /* renamed from: p  reason: collision with root package name */
    public static final Buffer f10801p = new Buffer();

    /* renamed from: h  reason: collision with root package name */
    public final w0 f10802h;

    /* renamed from: i  reason: collision with root package name */
    public final String f10803i;

    /* renamed from: j  reason: collision with root package name */
    public final g2 f10804j;

    /* renamed from: k  reason: collision with root package name */
    public String f10805k;

    /* renamed from: l  reason: collision with root package name */
    public final b f10806l;

    /* renamed from: m  reason: collision with root package name */
    public final a f10807m;

    /* renamed from: n  reason: collision with root package name */
    public final y8.a f10808n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f10809o;

    public class a implements a.b {
        public a() {
        }

        public void e(k1 k1Var) {
            c.f("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (h.this.f10806l.f10812z) {
                    h.this.f10806l.a0(k1Var, true, (v0) null);
                }
                c.h("OkHttpClientStream$Sink.cancel");
            } catch (Throwable th) {
                c.h("OkHttpClientStream$Sink.cancel");
                throw th;
            }
        }

        public void f(v0 v0Var, byte[] bArr) {
            c.f("OkHttpClientStream$Sink.writeHeaders");
            String str = Operator.Operation.DIVISION + h.this.f10802h.c();
            if (bArr != null) {
                boolean unused = h.this.f10809o = true;
                str = str + Operator.Operation.EMPTY_PARAM + BaseEncoding.base64().encode(bArr);
            }
            try {
                synchronized (h.this.f10806l.f10812z) {
                    h.this.f10806l.g0(v0Var, str);
                }
                c.h("OkHttpClientStream$Sink.writeHeaders");
            } catch (Throwable th) {
                c.h("OkHttpClientStream$Sink.writeHeaders");
                throw th;
            }
        }

        public void g(n2 n2Var, boolean z10, boolean z11, int i10) {
            Buffer buffer;
            c.f("OkHttpClientStream$Sink.writeFrame");
            if (n2Var == null) {
                buffer = h.f10801p;
            } else {
                buffer = ((o) n2Var).c();
                int size = (int) buffer.size();
                if (size > 0) {
                    h.this.s(size);
                }
            }
            try {
                synchronized (h.this.f10806l.f10812z) {
                    h.this.f10806l.e0(buffer, z10, z11);
                    h.this.w().e(i10);
                }
                c.h("OkHttpClientStream$Sink.writeFrame");
            } catch (Throwable th) {
                c.h("OkHttpClientStream$Sink.writeFrame");
                throw th;
            }
        }
    }

    public class b extends t0 implements q.b {
        public List A;
        public Buffer B = new Buffer();
        public boolean C = false;
        public boolean D = false;
        public boolean E = false;
        public int F;
        public int G;
        public final b H;
        public final q I;
        public final i J;
        public boolean K = true;
        public final d L;
        public q.c M;
        public int N = -1;

        /* renamed from: y  reason: collision with root package name */
        public final int f10811y;

        /* renamed from: z  reason: collision with root package name */
        public final Object f10812z;

        public b(int i10, g2 g2Var, Object obj, b bVar, q qVar, i iVar, int i11, String str) {
            super(i10, g2Var, h.this.w());
            this.f10812z = Preconditions.checkNotNull(obj, "lock");
            this.H = bVar;
            this.I = qVar;
            this.J = iVar;
            this.F = i11;
            this.G = i11;
            this.f10811y = i11;
            this.L = c.a(str);
        }

        public void P(k1 k1Var, boolean z10, v0 v0Var) {
            a0(k1Var, z10, v0Var);
        }

        public final void a0(k1 k1Var, boolean z10, v0 v0Var) {
            if (!this.E) {
                this.E = true;
                if (this.K) {
                    this.J.h0(h.this);
                    this.A = null;
                    this.B.clear();
                    this.K = false;
                    if (v0Var == null) {
                        v0Var = new v0();
                    }
                    N(k1Var, true, v0Var);
                    return;
                }
                this.J.U(c0(), k1Var, r.a.PROCESSED, z10, c9.a.CANCEL, v0Var);
            }
        }

        public q.c b0() {
            q.c cVar;
            synchronized (this.f10812z) {
                cVar = this.M;
            }
            return cVar;
        }

        public void c(int i10) {
            int i11 = this.G - i10;
            this.G = i11;
            int i12 = this.f10811y;
            if (((float) i11) <= ((float) i12) * 0.5f) {
                int i13 = i12 - i11;
                this.F += i13;
                this.G = i11 + i13;
                this.H.windowUpdate(c0(), (long) i13);
            }
        }

        public int c0() {
            return this.N;
        }

        public void d(Throwable th) {
            P(k1.l(th), true, new v0());
        }

        public final void d0() {
            if (!G()) {
                this.J.U(c0(), (k1) null, r.a.PROCESSED, false, c9.a.CANCEL, (v0) null);
            } else {
                this.J.U(c0(), (k1) null, r.a.PROCESSED, false, (c9.a) null, (v0) null);
            }
        }

        public void e(boolean z10) {
            d0();
            super.e(z10);
        }

        public final void e0(Buffer buffer, boolean z10, boolean z11) {
            boolean z12;
            if (!this.E) {
                if (this.K) {
                    this.B.write(buffer, (long) ((int) buffer.size()));
                    this.C |= z10;
                    this.D |= z11;
                    return;
                }
                if (c0() != -1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                Preconditions.checkState(z12, "streamId should be set");
                this.I.d(z10, this.M, buffer, z11);
            }
        }

        public void f(Runnable runnable) {
            synchronized (this.f10812z) {
                runnable.run();
            }
        }

        public void f0(int i10) {
            boolean z10;
            if (this.N == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "the stream has been started with id %s", i10);
            this.N = i10;
            this.M = this.I.c(this, i10);
            h.this.f10806l.r();
            if (this.K) {
                this.H.K(h.this.f10809o, false, this.N, 0, this.A);
                h.this.f10804j.c();
                this.A = null;
                if (this.B.size() > 0) {
                    this.I.d(this.C, this.M, this.B, this.D);
                }
                this.K = false;
            }
        }

        public final void g0(v0 v0Var, String str) {
            this.A = d.b(v0Var, str, h.this.f10805k, h.this.f10803i, h.this.f10809o, this.J.b0());
            this.J.o0(h.this);
        }

        public d h0() {
            return this.L;
        }

        public void i0(Buffer buffer, boolean z10) {
            int size = this.F - ((int) buffer.size());
            this.F = size;
            if (size < 0) {
                this.H.d(c0(), c9.a.FLOW_CONTROL_ERROR);
                this.J.U(c0(), k1.f20055t.r("Received data size exceeded our receiving window size"), r.a.PROCESSED, false, (c9.a) null, (v0) null);
                return;
            }
            super.S(new l(buffer), z10);
        }

        public void j0(List list, boolean z10) {
            if (z10) {
                U(r.c(list));
            } else {
                T(r.a(list));
            }
        }

        public void r() {
            super.r();
            m().c();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(y8.w0 r13, y8.v0 r14, a9.b r15, a9.i r16, a9.q r17, java.lang.Object r18, int r19, int r20, java.lang.String r21, java.lang.String r22, z8.g2 r23, z8.m2 r24, y8.c r25, boolean r26) {
        /*
            r12 = this;
            r10 = r12
            a9.p r1 = new a9.p
            r1.<init>()
            r7 = 0
            if (r26 == 0) goto L_0x0012
            boolean r0 = r13.f()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            r6 = 1
            goto L_0x0013
        L_0x0012:
            r6 = 0
        L_0x0013:
            r0 = r12
            r2 = r23
            r3 = r24
            r4 = r14
            r5 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6)
            a9.h$a r0 = new a9.h$a
            r0.<init>()
            r10.f10807m = r0
            r10.f10809o = r7
            java.lang.String r0 = "statsTraceCtx"
            r3 = r23
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r3, r0)
            z8.g2 r0 = (z8.g2) r0
            r10.f10804j = r0
            r0 = r13
            r10.f10802h = r0
            r1 = r21
            r10.f10805k = r1
            r1 = r22
            r10.f10803i = r1
            y8.a r1 = r16.V()
            r10.f10808n = r1
            a9.h$b r11 = new a9.h$b
            java.lang.String r9 = r13.c()
            r0 = r11
            r1 = r12
            r2 = r19
            r4 = r18
            r5 = r15
            r6 = r17
            r7 = r16
            r8 = r20
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f10806l = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a9.h.<init>(y8.w0, y8.v0, a9.b, a9.i, a9.q, java.lang.Object, int, int, java.lang.String, java.lang.String, z8.g2, z8.m2, y8.c, boolean):void");
    }

    public w0.d L() {
        return this.f10802h.e();
    }

    /* renamed from: M */
    public b y() {
        return this.f10806l;
    }

    public boolean N() {
        return this.f10809o;
    }

    public y8.a getAttributes() {
        return this.f10808n;
    }

    public void n(String str) {
        this.f10805k = (String) Preconditions.checkNotNull(str, "authority");
    }

    /* renamed from: z */
    public a u() {
        return this.f10807m;
    }
}
