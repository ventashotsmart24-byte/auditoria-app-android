package c3;

import i3.b;
import j3.i;
import j3.q;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class h implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    public static final i f4714b;

    /* renamed from: c  reason: collision with root package name */
    public static final i f4715c;

    /* renamed from: d  reason: collision with root package name */
    public static final i f4716d;

    /* renamed from: a  reason: collision with root package name */
    public p f4717a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4718a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                i3.b$a[] r0 = i3.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4718a = r0
                i3.b$a r1 = i3.b.a.PARENT_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4718a     // Catch:{ NoSuchFieldError -> 0x001d }
                i3.b$a r1 = i3.b.a.PAYLOAD_PROPERTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4718a     // Catch:{ NoSuchFieldError -> 0x0028 }
                i3.b$a r1 = i3.b.a.METADATA_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4718a     // Catch:{ NoSuchFieldError -> 0x0033 }
                i3.b$a r1 = i3.b.a.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4718a     // Catch:{ NoSuchFieldError -> 0x003e }
                i3.b$a r1 = i3.b.a.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c3.h.a.<clinit>():void");
        }
    }

    public enum b {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);
        

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4730a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4731b;

        /* access modifiers changed from: public */
        b(boolean z10) {
            this.f4730a = z10;
            this.f4731b = 1 << ordinal();
        }

        public static int a() {
            int i10 = 0;
            for (b bVar : values()) {
                if (bVar.b()) {
                    i10 |= bVar.d();
                }
            }
            return i10;
        }

        public boolean b() {
            return this.f4730a;
        }

        public boolean c(int i10) {
            if ((i10 & this.f4731b) != 0) {
                return true;
            }
            return false;
        }

        public int d() {
            return this.f4731b;
        }
    }

    static {
        i a10 = i.a(s.values());
        f4714b = a10;
        f4715c = a10.c(s.CAN_WRITE_FORMATTED_NUMBERS);
        f4716d = a10.c(s.CAN_WRITE_BINARY_NATIVELY);
    }

    public abstract void A0(char[] cArr, int i10, int i11);

    public void B0(String str, String str2) {
        Z(str);
        z0(str2);
    }

    public void C0(Object obj) {
        throw new g("No native support for writing Type Ids", this);
    }

    public i3.b D0(i3.b bVar) {
        String str;
        Object obj = bVar.f7032c;
        n nVar = bVar.f7035f;
        if (n()) {
            bVar.f7036g = false;
            C0(obj);
        } else {
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = String.valueOf(obj);
            }
            bVar.f7036g = true;
            b.a aVar = bVar.f7034e;
            if (nVar != n.START_OBJECT && aVar.a()) {
                aVar = b.a.WRAPPER_ARRAY;
                bVar.f7034e = aVar;
            }
            int i10 = a.f4718a[aVar.ordinal()];
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    w0(bVar.f7030a);
                    B0(bVar.f7033d, str);
                    return bVar;
                } else if (i10 != 4) {
                    s0();
                    z0(str);
                } else {
                    v0();
                    Z(str);
                }
            }
        }
        if (nVar == n.START_OBJECT) {
            w0(bVar.f7030a);
        } else if (nVar == n.START_ARRAY) {
            s0();
        }
        return bVar;
    }

    public abstract h E(int i10);

    public i3.b E0(i3.b bVar) {
        String str;
        n nVar = bVar.f7035f;
        if (nVar == n.START_OBJECT) {
            W();
        } else if (nVar == n.START_ARRAY) {
            V();
        }
        if (bVar.f7036g) {
            int i10 = a.f4718a[bVar.f7034e.ordinal()];
            if (i10 == 1) {
                Object obj = bVar.f7032c;
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = String.valueOf(obj);
                }
                B0(bVar.f7033d, str);
            } else if (!(i10 == 2 || i10 == 3)) {
                if (i10 != 5) {
                    W();
                } else {
                    V();
                }
            }
        }
        return bVar;
    }

    public h I(p pVar) {
        this.f4717a = pVar;
        return this;
    }

    public h L(q qVar) {
        throw new UnsupportedOperationException();
    }

    public void M(double[] dArr, int i10, int i11) {
        if (dArr != null) {
            c(dArr.length, i10, i11);
            u0(dArr, i11);
            int i12 = i11 + i10;
            while (i10 < i12) {
                b0(dArr[i10]);
                i10++;
            }
            V();
            return;
        }
        throw new IllegalArgumentException("null array");
    }

    public void N(int[] iArr, int i10, int i11) {
        if (iArr != null) {
            c(iArr.length, i10, i11);
            u0(iArr, i11);
            int i12 = i11 + i10;
            while (i10 < i12) {
                d0(iArr[i10]);
                i10++;
            }
            V();
            return;
        }
        throw new IllegalArgumentException("null array");
    }

    public void O(long[] jArr, int i10, int i11) {
        if (jArr != null) {
            c(jArr.length, i10, i11);
            u0(jArr, i11);
            int i12 = i11 + i10;
            while (i10 < i12) {
                e0(jArr[i10]);
                i10++;
            }
            V();
            return;
        }
        throw new IllegalArgumentException("null array");
    }

    public abstract int P(a aVar, InputStream inputStream, int i10);

    public int Q(InputStream inputStream, int i10) {
        return P(b.a(), inputStream, i10);
    }

    public abstract void R(a aVar, byte[] bArr, int i10, int i11);

    public void S(byte[] bArr) {
        R(b.a(), bArr, 0, bArr.length);
    }

    public void T(byte[] bArr, int i10, int i11) {
        R(b.a(), bArr, i10, i11);
    }

    public abstract void U(boolean z10);

    public abstract void V();

    public abstract void W();

    public void X(long j10) {
        Z(Long.toString(j10));
    }

    public abstract void Y(q qVar);

    public abstract void Z(String str);

    public void a(String str) {
        throw new g(str, this);
    }

    public abstract void a0();

    public final void b() {
        q.a();
    }

    public abstract void b0(double d10);

    public final void c(int i10, int i11, int i12) {
        if (i11 < 0 || i11 + i12 > i10) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i10)}));
        }
    }

    public abstract void c0(float f10);

    public abstract void close();

    public abstract void d0(int i10);

    public boolean e() {
        return true;
    }

    public abstract void e0(long j10);

    public boolean f() {
        return false;
    }

    public abstract void f0(String str);

    public abstract void flush();

    public abstract void g0(BigDecimal bigDecimal);

    public abstract void h0(BigInteger bigInteger);

    public abstract void i0(short s10);

    public void j0(Object obj) {
        throw new g("No native support for writing Object Ids", this);
    }

    public void k0(Object obj) {
        throw new g("No native support for writing Object Ids", this);
    }

    public void l0(String str) {
    }

    public boolean m() {
        return false;
    }

    public abstract void m0(char c10);

    public boolean n() {
        return false;
    }

    public abstract void n0(q qVar);

    public abstract void o0(String str);

    public abstract void p0(char[] cArr, int i10, int i11);

    public abstract h q(b bVar);

    public void q0(q qVar) {
        r0(qVar.getValue());
    }

    public abstract void r0(String str);

    public abstract m s();

    public abstract void s0();

    public abstract void t0(Object obj);

    public p u() {
        return this.f4717a;
    }

    public abstract void u0(Object obj, int i10);

    public abstract boolean v(b bVar);

    public abstract void v0();

    public abstract void w0(Object obj);

    public h x(int i10, int i11) {
        return this;
    }

    public void x0(Object obj, int i10) {
        v0();
        z(obj);
    }

    public abstract h y(int i10, int i11);

    public abstract void y0(q qVar);

    public void z(Object obj) {
        m s10 = s();
        if (s10 != null) {
            s10.i(obj);
        }
    }

    public abstract void z0(String str);
}
