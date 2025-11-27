package d3;

import c3.k;
import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import f3.f;
import g3.a;
import j3.c;
import j3.i;
import j3.o;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class b extends c {
    public static final i Q = k.f4738b;
    public final o A;
    public char[] B;
    public boolean C;
    public c D;
    public byte[] E;
    public int F = 0;
    public int G;
    public long H;
    public double I;
    public BigInteger J;
    public BigDecimal K;
    public boolean L;
    public int M;
    public int N;
    public int O;

    /* renamed from: o  reason: collision with root package name */
    public final f3.c f6212o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6213p;

    /* renamed from: q  reason: collision with root package name */
    public int f6214q;

    /* renamed from: r  reason: collision with root package name */
    public int f6215r;

    /* renamed from: s  reason: collision with root package name */
    public long f6216s;

    /* renamed from: t  reason: collision with root package name */
    public int f6217t = 1;

    /* renamed from: u  reason: collision with root package name */
    public int f6218u;

    /* renamed from: v  reason: collision with root package name */
    public long f6219v;

    /* renamed from: w  reason: collision with root package name */
    public int f6220w = 1;

    /* renamed from: x  reason: collision with root package name */
    public int f6221x;

    /* renamed from: y  reason: collision with root package name */
    public g3.c f6222y;

    /* renamed from: z  reason: collision with root package name */
    public n f6223z;

    public b(f3.c cVar, int i10) {
        super(i10);
        a aVar;
        this.f6212o = cVar;
        this.A = cVar.i();
        if (k.a.STRICT_DUPLICATE_DETECTION.c(i10)) {
            aVar = a.f(this);
        } else {
            aVar = null;
        }
        this.f6222y = g3.c.o(aVar);
    }

    public void A0(Object obj) {
        this.f6222y.i(obj);
    }

    public String A1() {
        if (l0(k.a.ALLOW_NON_NUMERIC_NUMBERS)) {
            return "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')";
        }
        return "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    public k B0(int i10) {
        int i11 = this.f4739a ^ i10;
        if (i11 != 0) {
            this.f4739a = i10;
            i1(i10, i11);
        }
        return this;
    }

    public void B1() {
        int i10 = this.F;
        if ((i10 & 8) != 0) {
            this.K = f.f(Y());
        } else if ((i10 & 4) != 0) {
            this.K = new BigDecimal(this.J);
        } else if ((i10 & 2) != 0) {
            this.K = BigDecimal.valueOf(this.H);
        } else if ((i10 & 1) != 0) {
            this.K = BigDecimal.valueOf((long) this.G);
        } else {
            U0();
        }
        this.F |= 16;
    }

    public void C1() {
        int i10 = this.F;
        if ((i10 & 16) != 0) {
            this.J = this.K.toBigInteger();
        } else if ((i10 & 2) != 0) {
            this.J = BigInteger.valueOf(this.H);
        } else if ((i10 & 1) != 0) {
            this.J = BigInteger.valueOf((long) this.G);
        } else if ((i10 & 8) != 0) {
            this.J = BigDecimal.valueOf(this.I).toBigInteger();
        } else {
            U0();
        }
        this.F |= 4;
    }

    public void D1() {
        int i10 = this.F;
        if ((i10 & 16) != 0) {
            this.I = this.K.doubleValue();
        } else if ((i10 & 4) != 0) {
            this.I = this.J.doubleValue();
        } else if ((i10 & 2) != 0) {
            this.I = (double) this.H;
        } else if ((i10 & 1) != 0) {
            this.I = (double) this.G;
        } else {
            U0();
        }
        this.F |= 8;
    }

    public String E() {
        g3.c r10;
        n nVar = this.f6234c;
        if ((nVar == n.START_OBJECT || nVar == n.START_ARRAY) && (r10 = this.f6222y.e()) != null) {
            return r10.b();
        }
        return this.f6222y.b();
    }

    public void E1() {
        int i10 = this.F;
        if ((i10 & 2) != 0) {
            long j10 = this.H;
            int i11 = (int) j10;
            if (((long) i11) != j10) {
                d1(Y(), n());
            }
            this.G = i11;
        } else if ((i10 & 4) != 0) {
            if (c.f6226g.compareTo(this.J) > 0 || c.f6227h.compareTo(this.J) < 0) {
                b1();
            }
            this.G = this.J.intValue();
        } else if ((i10 & 8) != 0) {
            double d10 = this.I;
            if (d10 < -2.147483648E9d || d10 > 2.147483647E9d) {
                b1();
            }
            this.G = (int) this.I;
        } else if ((i10 & 16) != 0) {
            if (c.f6232m.compareTo(this.K) > 0 || c.f6233n.compareTo(this.K) < 0) {
                b1();
            }
            this.G = this.K.intValue();
        } else {
            U0();
        }
        this.F |= 1;
    }

    public void F1() {
        int i10 = this.F;
        if ((i10 & 1) != 0) {
            this.H = (long) this.G;
        } else if ((i10 & 4) != 0) {
            if (c.f6228i.compareTo(this.J) > 0 || c.f6229j.compareTo(this.J) < 0) {
                e1();
            }
            this.H = this.J.longValue();
        } else if ((i10 & 8) != 0) {
            double d10 = this.I;
            if (d10 < -9.223372036854776E18d || d10 > 9.223372036854776E18d) {
                e1();
            }
            this.H = (long) this.I;
        } else if ((i10 & 16) != 0) {
            if (c.f6230k.compareTo(this.K) > 0 || c.f6231l.compareTo(this.K) < 0) {
                e1();
            }
            this.H = this.K.longValue();
        } else {
            U0();
        }
        this.F |= 2;
    }

    /* renamed from: G1 */
    public g3.c V() {
        return this.f6222y;
    }

    public void H0() {
        String str;
        if (!this.f6222y.h()) {
            if (this.f6222y.f()) {
                str = "Array";
            } else {
                str = "Object";
            }
            Q0(String.format(": expected close marker for %s (start marker at %s)", new Object[]{str, this.f6222y.s(o1())}), (n) null);
        }
    }

    public IllegalArgumentException H1(c3.a aVar, int i10, int i11) {
        return I1(aVar, i10, i11, (String) null);
    }

    public IllegalArgumentException I1(c3.a aVar, int i10, int i11, String str) {
        String str2;
        if (i10 <= 32) {
            str2 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", new Object[]{Integer.toHexString(i10), Integer.valueOf(i11 + 1)});
        } else if (aVar.x(i10)) {
            str2 = "Unexpected padding character ('" + aVar.r() + "') as character #" + (i11 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i10) || Character.isISOControl(i10)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i10) + "' (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    public final n J1(boolean z10, int i10, int i11, int i12) {
        if (i11 >= 1 || i12 >= 1) {
            return L1(z10, i10, i11, i12);
        }
        return M1(z10, i10);
    }

    public final n K1(String str, double d10) {
        this.A.x(str);
        this.I = d10;
        this.F = 8;
        return n.VALUE_NUMBER_FLOAT;
    }

    public BigDecimal L() {
        int i10 = this.F;
        if ((i10 & 16) == 0) {
            if (i10 == 0) {
                s1(16);
            }
            if ((this.F & 16) == 0) {
                B1();
            }
        }
        return this.K;
    }

    public final n L1(boolean z10, int i10, int i11, int i12) {
        this.L = z10;
        this.M = i10;
        this.N = i11;
        this.O = i12;
        this.F = 0;
        return n.VALUE_NUMBER_FLOAT;
    }

    public double M() {
        int i10 = this.F;
        if ((i10 & 8) == 0) {
            if (i10 == 0) {
                s1(8);
            }
            if ((this.F & 8) == 0) {
                D1();
            }
        }
        return this.I;
    }

    public final n M1(boolean z10, int i10) {
        this.L = z10;
        this.M = i10;
        this.N = 0;
        this.O = 0;
        this.F = 0;
        return n.VALUE_NUMBER_INT;
    }

    public float O() {
        return (float) M();
    }

    public int P() {
        int i10 = this.F;
        if ((i10 & 1) == 0) {
            if (i10 == 0) {
                return r1();
            }
            if ((i10 & 1) == 0) {
                E1();
            }
        }
        return this.G;
    }

    public long Q() {
        int i10 = this.F;
        if ((i10 & 2) == 0) {
            if (i10 == 0) {
                s1(2);
            }
            if ((this.F & 2) == 0) {
                F1();
            }
        }
        return this.H;
    }

    public k.b R() {
        if (this.F == 0) {
            s1(0);
        }
        if (this.f6234c == n.VALUE_NUMBER_INT) {
            int i10 = this.F;
            if ((i10 & 1) != 0) {
                return k.b.INT;
            }
            if ((i10 & 2) != 0) {
                return k.b.LONG;
            }
            return k.b.BIG_INTEGER;
        } else if ((this.F & 16) != 0) {
            return k.b.BIG_DECIMAL;
        } else {
            return k.b.DOUBLE;
        }
    }

    public Number S() {
        if (this.F == 0) {
            s1(0);
        }
        if (this.f6234c == n.VALUE_NUMBER_INT) {
            int i10 = this.F;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this.G);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this.H);
            }
            if ((i10 & 4) != 0) {
                return this.J;
            }
            U0();
        }
        int i11 = this.F;
        if ((i11 & 16) != 0) {
            return this.K;
        }
        if ((i11 & 8) == 0) {
            U0();
        }
        return Double.valueOf(this.I);
    }

    public Number T() {
        if (this.f6234c == n.VALUE_NUMBER_INT) {
            if (this.F == 0) {
                s1(0);
            }
            int i10 = this.F;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this.G);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this.H);
            }
            if ((i10 & 4) != 0) {
                return this.J;
            }
            U0();
        }
        if (this.F == 0) {
            s1(16);
        }
        int i11 = this.F;
        if ((i11 & 16) != 0) {
            return this.K;
        }
        if ((i11 & 8) == 0) {
            U0();
        }
        return Double.valueOf(this.I);
    }

    public void close() {
        if (!this.f6213p) {
            this.f6214q = Math.max(this.f6214q, this.f6215r);
            this.f6213p = true;
            try {
                j1();
            } finally {
                v1();
            }
        }
    }

    public boolean i0() {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_STRING) {
            return true;
        }
        if (nVar == n.FIELD_NAME) {
            return this.C;
        }
        return false;
    }

    public void i1(int i10, int i11) {
        int d10 = k.a.STRICT_DUPLICATE_DETECTION.d();
        if ((i11 & d10) != 0 && (i10 & d10) != 0) {
            if (this.f6222y.q() == null) {
                this.f6222y = this.f6222y.v(a.f(this));
            } else {
                this.f6222y = this.f6222y.v((a) null);
            }
        }
    }

    public abstract void j1();

    public final int k1(c3.a aVar, char c10, int i10) {
        if (c10 == '\\') {
            char l12 = l1();
            if (l12 <= ' ' && i10 == 0) {
                return -1;
            }
            int g10 = aVar.g(l12);
            if (g10 >= 0 || (g10 == -2 && i10 >= 2)) {
                return g10;
            }
            throw H1(aVar, l12, i10);
        }
        throw H1(aVar, c10, i10);
    }

    public abstract char l1();

    public final int m1() {
        H0();
        return -1;
    }

    public c n1() {
        c cVar = this.D;
        if (cVar == null) {
            this.D = new c();
        } else {
            cVar.reset();
        }
        return this.D;
    }

    public Object o1() {
        if (k.a.INCLUDE_SOURCE_IN_LOCATION.c(this.f4739a)) {
            return this.f6212o.j();
        }
        return null;
    }

    public boolean p0() {
        if (this.f6234c != n.VALUE_NUMBER_FLOAT || (this.F & 8) == 0) {
            return false;
        }
        double d10 = this.I;
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            return true;
        }
        return false;
    }

    public void p1(c3.a aVar) {
        L0(aVar.s());
    }

    public char q1(char c10) {
        if (l0(k.a.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c10;
        }
        if (c10 == '\'' && l0(k.a.ALLOW_SINGLE_QUOTES)) {
            return c10;
        }
        L0("Unrecognized character escape " + c.G0(c10));
        return c10;
    }

    public int r1() {
        if (this.f6213p) {
            L0("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this.f6234c != n.VALUE_NUMBER_INT || this.M > 9) {
            s1(1);
            if ((this.F & 1) == 0) {
                E1();
            }
            return this.G;
        }
        int j10 = this.A.j(this.L);
        this.G = j10;
        this.F = 1;
        return j10;
    }

    public BigInteger s() {
        int i10 = this.F;
        if ((i10 & 4) == 0) {
            if (i10 == 0) {
                s1(4);
            }
            if ((this.F & 4) == 0) {
                C1();
            }
        }
        return this.J;
    }

    public void s1(int i10) {
        if (this.f6213p) {
            L0("Internal error: _parseNumericValue called when parser instance closed");
        }
        n nVar = this.f6234c;
        if (nVar == n.VALUE_NUMBER_INT) {
            int i11 = this.M;
            if (i11 <= 9) {
                this.G = this.A.j(this.L);
                this.F = 1;
            } else if (i11 <= 18) {
                long k10 = this.A.k(this.L);
                if (i11 == 10) {
                    if (this.L) {
                        if (k10 >= -2147483648L) {
                            this.G = (int) k10;
                            this.F = 1;
                            return;
                        }
                    } else if (k10 <= TTL.MAX_VALUE) {
                        this.G = (int) k10;
                        this.F = 1;
                        return;
                    }
                }
                this.H = k10;
                this.F = 2;
            } else {
                u1(i10);
            }
        } else if (nVar == n.VALUE_NUMBER_FLOAT) {
            t1(i10);
        } else {
            M0("Current token (%s) not numeric, can not use numeric value accessors", nVar);
        }
    }

    public final void t1(int i10) {
        if (i10 == 16) {
            try {
                this.K = this.A.h();
                this.F = 16;
            } catch (NumberFormatException e10) {
                W0("Malformed numeric value (" + K0(this.A.l()) + ")", e10);
            }
        } else {
            this.I = this.A.i();
            this.F = 8;
        }
    }

    public final void u1(int i10) {
        String l10 = this.A.l();
        try {
            int i11 = this.M;
            char[] s10 = this.A.s();
            int t10 = this.A.t();
            boolean z10 = this.L;
            if (z10) {
                t10++;
            }
            if (f.c(s10, t10, i11, z10)) {
                this.H = Long.parseLong(l10);
                this.F = 2;
                return;
            }
            if (i10 == 1 || i10 == 2) {
                x1(i10, l10);
            }
            if (i10 != 8) {
                if (i10 != 32) {
                    this.J = new BigInteger(l10);
                    this.F = 4;
                    return;
                }
            }
            this.I = f.i(l10);
            this.F = 8;
        } catch (NumberFormatException e10) {
            W0("Malformed numeric value (" + K0(l10) + ")", e10);
        }
    }

    public k v0(int i10, int i11) {
        int i12 = this.f4739a;
        int i13 = (i10 & i11) | ((i11 ^ -1) & i12);
        int i14 = i12 ^ i13;
        if (i14 != 0) {
            this.f4739a = i13;
            i1(i13, i14);
        }
        return this;
    }

    public void v1() {
        this.A.u();
        char[] cArr = this.B;
        if (cArr != null) {
            this.B = null;
            this.f6212o.n(cArr);
        }
    }

    public void w1(int i10, char c10) {
        g3.c G1 = V();
        L0(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", new Object[]{Character.valueOf((char) i10), Character.valueOf(c10), G1.j(), G1.s(o1())}));
    }

    public void x1(int i10, String str) {
        if (i10 == 1) {
            c1(str);
        } else {
            f1(str);
        }
    }

    public void y1(int i10, String str) {
        if (!l0(k.a.ALLOW_UNQUOTED_CONTROL_CHARS) || i10 > 32) {
            L0("Illegal unquoted character (" + c.G0((char) i10) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    public String z1() {
        return A1();
    }
}
