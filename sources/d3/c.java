package d3;

import c3.a;
import c3.j;
import c3.k;
import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import com.raizlabs.android.dbflow.sql.language.Operator;
import f3.d;
import f3.f;
import j3.q;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class c extends k {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f6224e = new byte[0];

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f6225f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f6226g;

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f6227h;

    /* renamed from: i  reason: collision with root package name */
    public static final BigInteger f6228i;

    /* renamed from: j  reason: collision with root package name */
    public static final BigInteger f6229j;

    /* renamed from: k  reason: collision with root package name */
    public static final BigDecimal f6230k;

    /* renamed from: l  reason: collision with root package name */
    public static final BigDecimal f6231l;

    /* renamed from: m  reason: collision with root package name */
    public static final BigDecimal f6232m;

    /* renamed from: n  reason: collision with root package name */
    public static final BigDecimal f6233n;

    /* renamed from: c  reason: collision with root package name */
    public n f6234c;

    /* renamed from: d  reason: collision with root package name */
    public n f6235d;

    static {
        BigInteger valueOf = BigInteger.valueOf(-2147483648L);
        f6226g = valueOf;
        BigInteger valueOf2 = BigInteger.valueOf(TTL.MAX_VALUE);
        f6227h = valueOf2;
        BigInteger valueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        f6228i = valueOf3;
        BigInteger valueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        f6229j = valueOf4;
        f6230k = new BigDecimal(valueOf3);
        f6231l = new BigDecimal(valueOf4);
        f6232m = new BigDecimal(valueOf);
        f6233n = new BigDecimal(valueOf2);
    }

    public c(int i10) {
        super(i10);
    }

    public static final String G0(int i10) {
        char c10 = (char) i10;
        if (Character.isISOControl(c10)) {
            return "(CTRL-CHAR, code " + i10 + ")";
        } else if (i10 > 255) {
            return "'" + c10 + "' (code " + i10 + " / 0x" + Integer.toHexString(i10) + ")";
        } else {
            return "'" + c10 + "' (code " + i10 + ")";
        }
    }

    public k D0() {
        n nVar = this.f6234c;
        if (nVar != n.START_OBJECT && nVar != n.START_ARRAY) {
            return this;
        }
        int i10 = 1;
        while (true) {
            n s02 = s0();
            if (s02 == null) {
                H0();
                return this;
            } else if (s02.g()) {
                i10++;
            } else if (s02.f()) {
                i10--;
                if (i10 == 0) {
                    return this;
                }
            } else if (s02 == n.NOT_AVAILABLE) {
                M0("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", getClass().getName());
            }
        }
    }

    public abstract String E();

    public final j E0(String str, Throwable th) {
        return new j(this, str, th);
    }

    public void F0(String str, j3.c cVar, a aVar) {
        try {
            aVar.e(str, cVar);
        } catch (IllegalArgumentException e10) {
            L0(e10.getMessage());
        }
    }

    public abstract void H0();

    public n I() {
        return this.f6234c;
    }

    public boolean I0(String str) {
        return "null".equals(str);
    }

    public String J0(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith(Operator.Operation.MINUS)) {
            length--;
        }
        return String.format("[Integer with %d digits]", new Object[]{Integer.valueOf(length)});
    }

    public String K0(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith(Operator.Operation.MINUS)) {
            length--;
        }
        return String.format("[number with %d characters]", new Object[]{Integer.valueOf(length)});
    }

    public final void L0(String str) {
        throw b(str);
    }

    public final void M0(String str, Object obj) {
        throw b(String.format(str, new Object[]{obj}));
    }

    public final void N0(String str, Object obj, Object obj2) {
        throw b(String.format(str, new Object[]{obj, obj2}));
    }

    public void O0(String str, n nVar, Class cls) {
        throw new e3.a(this, str, nVar, cls);
    }

    public void P0() {
        Q0(" in " + this.f6234c, this.f6234c);
    }

    public void Q0(String str, n nVar) {
        throw new d(this, nVar, "Unexpected end-of-input" + str);
    }

    public void R0(n nVar) {
        String str;
        if (nVar == n.VALUE_STRING) {
            str = " in a String value";
        } else if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            str = " in a Number value";
        } else {
            str = " in a value";
        }
        Q0(str, nVar);
    }

    public void S0(int i10) {
        T0(i10, "Expected space separating root-level values");
    }

    public void T0(int i10, String str) {
        if (i10 < 0) {
            P0();
        }
        String format = String.format("Unexpected character (%s)", new Object[]{G0(i10)});
        if (str != null) {
            format = format + ": " + str;
        }
        L0(format);
    }

    public final void U0() {
        q.a();
    }

    public void V0(int i10) {
        L0("Illegal character (" + G0((char) i10) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    public final void W0(String str, Throwable th) {
        throw E0(str, th);
    }

    public int X0(int i10) {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            return P();
        }
        if (nVar == null) {
            return i10;
        }
        int c10 = nVar.c();
        if (c10 != 6) {
            switch (c10) {
                case 9:
                    return 1;
                case 10:
                case 11:
                    return 0;
                case 12:
                    Object N = N();
                    if (N instanceof Number) {
                        return ((Number) N).intValue();
                    }
                    return i10;
                default:
                    return i10;
            }
        } else {
            String Y = Y();
            if (I0(Y)) {
                return 0;
            }
            return f.d(Y, i10);
        }
    }

    public abstract String Y();

    public long Y0(long j10) {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            return Q();
        }
        if (nVar == null) {
            return j10;
        }
        int c10 = nVar.c();
        if (c10 != 6) {
            switch (c10) {
                case 9:
                    return 1;
                case 10:
                case 11:
                    return 0;
                case 12:
                    Object N = N();
                    if (N instanceof Number) {
                        return ((Number) N).longValue();
                    }
                    return j10;
                default:
                    return j10;
            }
        } else {
            String Y = Y();
            if (I0(Y)) {
                return 0;
            }
            return f.e(Y, j10);
        }
    }

    public String Z0(String str) {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_STRING) {
            return Y();
        }
        if (nVar == n.FIELD_NAME) {
            return E();
        }
        if (nVar == null || nVar == n.VALUE_NULL || !nVar.e()) {
            return str;
        }
        return Y();
    }

    public void a1(String str) {
        L0("Invalid numeric value: " + str);
    }

    public void b1() {
        c1(Y());
    }

    public void c1(String str) {
        d1(str, n());
    }

    public void d1(String str, n nVar) {
        O0(String.format("Numeric value (%s) out of range of int (%d - %s)", new Object[]{J0(str), Integer.MIN_VALUE, Integer.MAX_VALUE}), nVar, Integer.TYPE);
    }

    public int e0() {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            return P();
        }
        return X0(0);
    }

    public void e1() {
        f1(Y());
    }

    public void f() {
        n nVar = this.f6234c;
        if (nVar != null) {
            this.f6235d = nVar;
            this.f6234c = null;
        }
    }

    public long f0() {
        n nVar = this.f6234c;
        if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            return Q();
        }
        return Y0(0);
    }

    public void f1(String str) {
        g1(str, n());
    }

    public String g0() {
        return Z0((String) null);
    }

    public void g1(String str, n nVar) {
        O0(String.format("Numeric value (%s) out of range of long (%d - %s)", new Object[]{J0(str), Long.MIN_VALUE, Long.MAX_VALUE}), nVar, Long.TYPE);
    }

    public boolean h0() {
        if (this.f6234c != null) {
            return true;
        }
        return false;
    }

    public void h1(int i10, String str) {
        String format = String.format("Unexpected character (%s) in numeric value", new Object[]{G0(i10)});
        if (str != null) {
            format = format + ": " + str;
        }
        L0(format);
    }

    public boolean j0(n nVar) {
        if (this.f6234c == nVar) {
            return true;
        }
        return false;
    }

    public boolean k0(int i10) {
        n nVar = this.f6234c;
        if (nVar == null) {
            if (i10 == 0) {
                return true;
            }
            return false;
        } else if (nVar.c() == i10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean m0() {
        if (this.f6234c == n.VALUE_NUMBER_INT) {
            return true;
        }
        return false;
    }

    public n n() {
        return this.f6234c;
    }

    public boolean n0() {
        if (this.f6234c == n.START_ARRAY) {
            return true;
        }
        return false;
    }

    public boolean o0() {
        if (this.f6234c == n.START_OBJECT) {
            return true;
        }
        return false;
    }

    public int q() {
        n nVar = this.f6234c;
        if (nVar == null) {
            return 0;
        }
        return nVar.c();
    }

    public abstract n s0();

    public n t0() {
        n s02 = s0();
        if (s02 == n.FIELD_NAME) {
            return s0();
        }
        return s02;
    }
}
