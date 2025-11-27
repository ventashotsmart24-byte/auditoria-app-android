package d4;

import c3.h;
import c3.i;
import c3.k;
import c3.m;
import c3.n;
import c3.o;
import c3.q;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import g3.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import k3.g;

public class y extends h {

    /* renamed from: t  reason: collision with root package name */
    public static final int f6329t = h.b.a();

    /* renamed from: e  reason: collision with root package name */
    public o f6330e;

    /* renamed from: f  reason: collision with root package name */
    public m f6331f;

    /* renamed from: g  reason: collision with root package name */
    public int f6332g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6333h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6334i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6335j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6336k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6337l;

    /* renamed from: m  reason: collision with root package name */
    public c f6338m;

    /* renamed from: n  reason: collision with root package name */
    public c f6339n;

    /* renamed from: o  reason: collision with root package name */
    public int f6340o;

    /* renamed from: p  reason: collision with root package name */
    public Object f6341p;

    /* renamed from: q  reason: collision with root package name */
    public Object f6342q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f6343r;

    /* renamed from: s  reason: collision with root package name */
    public e f6344s;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6345a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f6346b;

        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00bd */
        static {
            /*
                c3.k$b[] r0 = c3.k.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6346b = r0
                r1 = 1
                c3.k$b r2 = c3.k.b.INT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f6346b     // Catch:{ NoSuchFieldError -> 0x001d }
                c3.k$b r3 = c3.k.b.BIG_INTEGER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f6346b     // Catch:{ NoSuchFieldError -> 0x0028 }
                c3.k$b r4 = c3.k.b.BIG_DECIMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f6346b     // Catch:{ NoSuchFieldError -> 0x0033 }
                c3.k$b r5 = c3.k.b.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f6346b     // Catch:{ NoSuchFieldError -> 0x003e }
                c3.k$b r6 = c3.k.b.LONG     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                c3.n[] r5 = c3.n.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f6345a = r5
                c3.n r6 = c3.n.START_OBJECT     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f6345a     // Catch:{ NoSuchFieldError -> 0x0059 }
                c3.n r5 = c3.n.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x0063 }
                c3.n r1 = c3.n.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x006d }
                c3.n r1 = c3.n.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x0077 }
                c3.n r1 = c3.n.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x0082 }
                c3.n r1 = c3.n.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x008d }
                c3.n r1 = c3.n.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x0099 }
                c3.n r1 = c3.n.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x00a5 }
                c3.n r1 = c3.n.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x00a5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x00b1 }
                c3.n r1 = c3.n.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x00bd }
                c3.n r1 = c3.n.VALUE_NULL     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                int[] r0 = f6345a     // Catch:{ NoSuchFieldError -> 0x00c9 }
                c3.n r1 = c3.n.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d4.y.a.<clinit>():void");
        }
    }

    public static final class b extends d3.c {

        /* renamed from: o  reason: collision with root package name */
        public o f6347o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f6348p;

        /* renamed from: q  reason: collision with root package name */
        public final boolean f6349q;

        /* renamed from: r  reason: collision with root package name */
        public final boolean f6350r;

        /* renamed from: s  reason: collision with root package name */
        public c f6351s;

        /* renamed from: t  reason: collision with root package name */
        public int f6352t;

        /* renamed from: u  reason: collision with root package name */
        public z f6353u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f6354v;

        /* renamed from: w  reason: collision with root package name */
        public transient j3.c f6355w;

        /* renamed from: x  reason: collision with root package name */
        public i f6356x = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, o oVar, boolean z10, boolean z11, m mVar) {
            super(0);
            boolean z12 = false;
            this.f6351s = cVar;
            this.f6352t = -1;
            this.f6347o = oVar;
            this.f6353u = z.m(mVar);
            this.f6348p = z10;
            this.f6349q = z11;
            this.f6350r = (z10 || z11) ? true : z12;
        }

        public String E() {
            return m();
        }

        public void H0() {
            U0();
        }

        public BigDecimal L() {
            Number S = S();
            if (S instanceof BigDecimal) {
                return (BigDecimal) S;
            }
            int i10 = a.f6346b[R().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return new BigDecimal((BigInteger) S);
                }
                if (i10 != 5) {
                    return BigDecimal.valueOf(S.doubleValue());
                }
            }
            return BigDecimal.valueOf(S.longValue());
        }

        public double M() {
            return S().doubleValue();
        }

        public Object N() {
            if (this.f6234c == n.VALUE_EMBEDDED_OBJECT) {
                return l1();
            }
            return null;
        }

        public float O() {
            return S().floatValue();
        }

        public int P() {
            Number number;
            if (this.f6234c == n.VALUE_NUMBER_INT) {
                number = (Number) l1();
            } else {
                number = S();
            }
            if ((number instanceof Integer) || m1(number)) {
                return number.intValue();
            }
            return j1(number);
        }

        public long Q() {
            Number number;
            if (this.f6234c == n.VALUE_NUMBER_INT) {
                number = (Number) l1();
            } else {
                number = S();
            }
            if ((number instanceof Long) || n1(number)) {
                return number.longValue();
            }
            return k1(number);
        }

        public k.b R() {
            Number S = S();
            if (S instanceof Integer) {
                return k.b.INT;
            }
            if (S instanceof Long) {
                return k.b.LONG;
            }
            if (S instanceof Double) {
                return k.b.DOUBLE;
            }
            if (S instanceof BigDecimal) {
                return k.b.BIG_DECIMAL;
            }
            if (S instanceof BigInteger) {
                return k.b.BIG_INTEGER;
            }
            if (S instanceof Float) {
                return k.b.FLOAT;
            }
            if (S instanceof Short) {
                return k.b.INT;
            }
            return null;
        }

        public final Number S() {
            i1();
            Object l12 = l1();
            if (l12 instanceof Number) {
                return (Number) l12;
            }
            if (l12 instanceof String) {
                String str = (String) l12;
                if (str.indexOf(46) >= 0) {
                    return Double.valueOf(Double.parseDouble(str));
                }
                return Long.valueOf(Long.parseLong(str));
            } else if (l12 == null) {
                return null;
            } else {
                throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + l12.getClass().getName());
            }
        }

        public Object U() {
            return this.f6351s.h(this.f6352t);
        }

        public m V() {
            return this.f6353u;
        }

        public j3.i W() {
            return k.f4738b;
        }

        public String Y() {
            n nVar = this.f6234c;
            if (nVar == n.VALUE_STRING || nVar == n.FIELD_NAME) {
                Object l12 = l1();
                if (l12 instanceof String) {
                    return (String) l12;
                }
                return h.a0(l12);
            } else if (nVar == null) {
                return null;
            } else {
                int i10 = a.f6345a[nVar.ordinal()];
                if (i10 == 7 || i10 == 8) {
                    return h.a0(l1());
                }
                return this.f6234c.b();
            }
        }

        public char[] Z() {
            String Y = Y();
            if (Y == null) {
                return null;
            }
            return Y.toCharArray();
        }

        public int a0() {
            String Y = Y();
            if (Y == null) {
                return 0;
            }
            return Y.length();
        }

        public int b0() {
            return 0;
        }

        public boolean c() {
            return this.f6349q;
        }

        public i c0() {
            return z();
        }

        public void close() {
            if (!this.f6354v) {
                this.f6354v = true;
            }
        }

        public Object d0() {
            return this.f6351s.i(this.f6352t);
        }

        public boolean e() {
            return this.f6348p;
        }

        public boolean i0() {
            return false;
        }

        public final void i1() {
            n nVar = this.f6234c;
            if (nVar == null || !nVar.d()) {
                throw b("Current token (" + this.f6234c + ") not numeric, cannot use numeric value accessors");
            }
        }

        public int j1(Number number) {
            if (number instanceof Long) {
                long longValue = number.longValue();
                int i10 = (int) longValue;
                if (((long) i10) != longValue) {
                    b1();
                }
                return i10;
            }
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (d3.c.f6226g.compareTo(bigInteger) > 0 || d3.c.f6227h.compareTo(bigInteger) < 0) {
                    b1();
                }
            } else if ((number instanceof Double) || (number instanceof Float)) {
                double doubleValue = number.doubleValue();
                if (doubleValue < -2.147483648E9d || doubleValue > 2.147483647E9d) {
                    b1();
                }
                return (int) doubleValue;
            } else if (number instanceof BigDecimal) {
                BigDecimal bigDecimal = (BigDecimal) number;
                if (d3.c.f6232m.compareTo(bigDecimal) > 0 || d3.c.f6233n.compareTo(bigDecimal) < 0) {
                    b1();
                }
            } else {
                U0();
            }
            return number.intValue();
        }

        public long k1(Number number) {
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (d3.c.f6228i.compareTo(bigInteger) > 0 || d3.c.f6229j.compareTo(bigInteger) < 0) {
                    e1();
                }
            } else if ((number instanceof Double) || (number instanceof Float)) {
                double doubleValue = number.doubleValue();
                if (doubleValue < -9.223372036854776E18d || doubleValue > 9.223372036854776E18d) {
                    e1();
                }
                return (long) doubleValue;
            } else if (number instanceof BigDecimal) {
                BigDecimal bigDecimal = (BigDecimal) number;
                if (d3.c.f6230k.compareTo(bigDecimal) > 0 || d3.c.f6231l.compareTo(bigDecimal) < 0) {
                    e1();
                }
            } else {
                U0();
            }
            return number.longValue();
        }

        public final Object l1() {
            return this.f6351s.j(this.f6352t);
        }

        public String m() {
            n nVar = this.f6234c;
            if (nVar == n.START_OBJECT || nVar == n.START_ARRAY) {
                return this.f6353u.e().b();
            }
            return this.f6353u.b();
        }

        public final boolean m1(Number number) {
            if ((number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
            return false;
        }

        public final boolean n1(Number number) {
            if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
            return false;
        }

        public void o1(i iVar) {
            this.f6356x = iVar;
        }

        public boolean p0() {
            if (this.f6234c != n.VALUE_NUMBER_FLOAT) {
                return false;
            }
            Object l12 = l1();
            if (l12 instanceof Double) {
                Double d10 = (Double) l12;
                if (d10.isNaN() || d10.isInfinite()) {
                    return true;
                }
                return false;
            } else if (!(l12 instanceof Float)) {
                return false;
            } else {
                Float f10 = (Float) l12;
                if (f10.isNaN() || f10.isInfinite()) {
                    return true;
                }
                return false;
            }
        }

        public String q0() {
            c cVar;
            n nVar;
            String str;
            if (this.f6354v || (cVar = this.f6351s) == null) {
                return null;
            }
            int i10 = this.f6352t + 1;
            if (i10 < 16 && cVar.p(i10) == (nVar = n.FIELD_NAME)) {
                this.f6352t = i10;
                this.f6234c = nVar;
                Object j10 = this.f6351s.j(i10);
                if (j10 instanceof String) {
                    str = (String) j10;
                } else {
                    str = j10.toString();
                }
                this.f6353u.o(str);
                return str;
            } else if (s0() == n.FIELD_NAME) {
                return m();
            } else {
                return null;
            }
        }

        public BigInteger s() {
            Number S = S();
            if (S instanceof BigInteger) {
                return (BigInteger) S;
            }
            if (R() == k.b.BIG_DECIMAL) {
                return ((BigDecimal) S).toBigInteger();
            }
            return BigInteger.valueOf(S.longValue());
        }

        public n s0() {
            c cVar;
            String str;
            if (this.f6354v || (cVar = this.f6351s) == null) {
                return null;
            }
            int i10 = this.f6352t + 1;
            this.f6352t = i10;
            if (i10 >= 16) {
                this.f6352t = 0;
                c k10 = cVar.k();
                this.f6351s = k10;
                if (k10 == null) {
                    return null;
                }
            }
            n p10 = this.f6351s.p(this.f6352t);
            this.f6234c = p10;
            if (p10 == n.FIELD_NAME) {
                Object l12 = l1();
                if (l12 instanceof String) {
                    str = (String) l12;
                } else {
                    str = l12.toString();
                }
                this.f6353u.o(str);
            } else if (p10 == n.START_OBJECT) {
                this.f6353u = this.f6353u.l();
            } else if (p10 == n.START_ARRAY) {
                this.f6353u = this.f6353u.k();
            } else if (p10 == n.END_OBJECT || p10 == n.END_ARRAY) {
                this.f6353u = this.f6353u.n();
            } else {
                this.f6353u.p();
            }
            return this.f6234c;
        }

        public byte[] v(c3.a aVar) {
            if (this.f6234c == n.VALUE_EMBEDDED_OBJECT) {
                Object l12 = l1();
                if (l12 instanceof byte[]) {
                    return (byte[]) l12;
                }
            }
            if (this.f6234c == n.VALUE_STRING) {
                String Y = Y();
                if (Y == null) {
                    return null;
                }
                j3.c cVar = this.f6355w;
                if (cVar == null) {
                    cVar = new j3.c(100);
                    this.f6355w = cVar;
                } else {
                    cVar.reset();
                }
                F0(Y, cVar, aVar);
                return cVar.v();
            }
            throw b("Current token (" + this.f6234c + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
        }

        public int w0(c3.a aVar, OutputStream outputStream) {
            byte[] v10 = v(aVar);
            if (v10 == null) {
                return 0;
            }
            outputStream.write(v10, 0, v10.length);
            return v10.length;
        }

        public o y() {
            return this.f6347o;
        }

        public i z() {
            i iVar = this.f6356x;
            if (iVar == null) {
                return i.f4732f;
            }
            return iVar;
        }
    }

    public static final class c {

        /* renamed from: e  reason: collision with root package name */
        public static final n[] f6357e;

        /* renamed from: a  reason: collision with root package name */
        public c f6358a;

        /* renamed from: b  reason: collision with root package name */
        public long f6359b;

        /* renamed from: c  reason: collision with root package name */
        public final Object[] f6360c = new Object[16];

        /* renamed from: d  reason: collision with root package name */
        public TreeMap f6361d;

        static {
            n[] nVarArr = new n[16];
            f6357e = nVarArr;
            n[] values = n.values();
            System.arraycopy(values, 1, nVarArr, 1, Math.min(15, values.length - 1));
        }

        public final int a(int i10) {
            return i10 + i10 + 1;
        }

        public final int b(int i10) {
            return i10 + i10;
        }

        public c c(int i10, n nVar) {
            if (i10 < 16) {
                l(i10, nVar);
                return null;
            }
            c cVar = new c();
            this.f6358a = cVar;
            cVar.l(0, nVar);
            return this.f6358a;
        }

        public c d(int i10, n nVar, Object obj) {
            if (i10 < 16) {
                m(i10, nVar, obj);
                return null;
            }
            c cVar = new c();
            this.f6358a = cVar;
            cVar.m(0, nVar, obj);
            return this.f6358a;
        }

        public c e(int i10, n nVar, Object obj, Object obj2) {
            if (i10 < 16) {
                n(i10, nVar, obj, obj2);
                return null;
            }
            c cVar = new c();
            this.f6358a = cVar;
            cVar.n(0, nVar, obj, obj2);
            return this.f6358a;
        }

        public c f(int i10, n nVar, Object obj, Object obj2, Object obj3) {
            if (i10 < 16) {
                o(i10, nVar, obj, obj2, obj3);
                return null;
            }
            c cVar = new c();
            this.f6358a = cVar;
            cVar.o(0, nVar, obj, obj2, obj3);
            return this.f6358a;
        }

        public final void g(int i10, Object obj, Object obj2) {
            if (this.f6361d == null) {
                this.f6361d = new TreeMap();
            }
            if (obj != null) {
                this.f6361d.put(Integer.valueOf(a(i10)), obj);
            }
            if (obj2 != null) {
                this.f6361d.put(Integer.valueOf(b(i10)), obj2);
            }
        }

        public Object h(int i10) {
            TreeMap treeMap = this.f6361d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(a(i10)));
        }

        public Object i(int i10) {
            TreeMap treeMap = this.f6361d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(b(i10)));
        }

        public Object j(int i10) {
            return this.f6360c[i10];
        }

        public c k() {
            return this.f6358a;
        }

        public final void l(int i10, n nVar) {
            long ordinal = (long) nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f6359b |= ordinal;
        }

        public final void m(int i10, n nVar, Object obj) {
            this.f6360c[i10] = obj;
            long ordinal = (long) nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f6359b = ordinal | this.f6359b;
        }

        public final void n(int i10, n nVar, Object obj, Object obj2) {
            long ordinal = (long) nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f6359b = ordinal | this.f6359b;
            g(i10, obj, obj2);
        }

        public final void o(int i10, n nVar, Object obj, Object obj2, Object obj3) {
            this.f6360c[i10] = obj;
            long ordinal = (long) nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f6359b = ordinal | this.f6359b;
            g(i10, obj2, obj3);
        }

        public n p(int i10) {
            long j10 = this.f6359b;
            if (i10 > 0) {
                j10 >>= i10 << 2;
            }
            return f6357e[((int) j10) & 15];
        }
    }

    public y(o oVar, boolean z10) {
        boolean z11 = false;
        this.f6343r = false;
        this.f6330e = oVar;
        this.f6332g = f6329t;
        this.f6344s = e.q((g3.a) null);
        c cVar = new c();
        this.f6339n = cVar;
        this.f6338m = cVar;
        this.f6340o = 0;
        this.f6334i = z10;
        this.f6335j = z10;
        this.f6336k = (z10 || z10) ? true : z11;
    }

    public static y Q0(k kVar) {
        y yVar = new y(kVar);
        yVar.V0(kVar);
        return yVar;
    }

    public void A0(char[] cArr, int i10, int i11) {
        z0(new String(cArr, i10, i11));
    }

    public void C0(Object obj) {
        this.f6341p = obj;
        this.f6343r = true;
    }

    public final void F0(n nVar) {
        c c10 = this.f6339n.c(this.f6340o, nVar);
        if (c10 == null) {
            this.f6340o++;
            return;
        }
        this.f6339n = c10;
        this.f6340o = 1;
    }

    public final void G0(Object obj) {
        c cVar;
        if (this.f6343r) {
            cVar = this.f6339n.f(this.f6340o, n.FIELD_NAME, obj, this.f6342q, this.f6341p);
        } else {
            cVar = this.f6339n.d(this.f6340o, n.FIELD_NAME, obj);
        }
        if (cVar == null) {
            this.f6340o++;
            return;
        }
        this.f6339n = cVar;
        this.f6340o = 1;
    }

    public final void H0(StringBuilder sb) {
        Object h10 = this.f6339n.h(this.f6340o - 1);
        if (h10 != null) {
            sb.append("[objectId=");
            sb.append(String.valueOf(h10));
            sb.append(']');
        }
        Object i10 = this.f6339n.i(this.f6340o - 1);
        if (i10 != null) {
            sb.append("[typeId=");
            sb.append(String.valueOf(i10));
            sb.append(']');
        }
    }

    public final void I0(n nVar) {
        c cVar;
        if (this.f6343r) {
            cVar = this.f6339n.e(this.f6340o, nVar, this.f6342q, this.f6341p);
        } else {
            cVar = this.f6339n.c(this.f6340o, nVar);
        }
        if (cVar == null) {
            this.f6340o++;
            return;
        }
        this.f6339n = cVar;
        this.f6340o = 1;
    }

    public final void J0(n nVar) {
        c cVar;
        this.f6344s.x();
        if (this.f6343r) {
            cVar = this.f6339n.e(this.f6340o, nVar, this.f6342q, this.f6341p);
        } else {
            cVar = this.f6339n.c(this.f6340o, nVar);
        }
        if (cVar == null) {
            this.f6340o++;
            return;
        }
        this.f6339n = cVar;
        this.f6340o = 1;
    }

    public final void K0(n nVar, Object obj) {
        c cVar;
        this.f6344s.x();
        if (this.f6343r) {
            cVar = this.f6339n.f(this.f6340o, nVar, obj, this.f6342q, this.f6341p);
        } else {
            cVar = this.f6339n.d(this.f6340o, nVar, obj);
        }
        if (cVar == null) {
            this.f6340o++;
            return;
        }
        this.f6339n = cVar;
        this.f6340o = 1;
    }

    public final void L0(k kVar) {
        Object d02 = kVar.d0();
        this.f6341p = d02;
        if (d02 != null) {
            this.f6343r = true;
        }
        Object U = kVar.U();
        this.f6342q = U;
        if (U != null) {
            this.f6343r = true;
        }
    }

    public void M0(k kVar) {
        int i10 = 1;
        while (true) {
            n s02 = kVar.s0();
            if (s02 != null) {
                int i11 = a.f6345a[s02.ordinal()];
                if (i11 == 1) {
                    if (this.f6336k) {
                        L0(kVar);
                    }
                    v0();
                } else if (i11 == 2) {
                    W();
                    i10--;
                    if (i10 == 0) {
                        return;
                    }
                } else if (i11 == 3) {
                    if (this.f6336k) {
                        L0(kVar);
                    }
                    s0();
                } else if (i11 == 4) {
                    V();
                    i10--;
                    if (i10 == 0) {
                        return;
                    }
                } else if (i11 != 5) {
                    N0(kVar, s02);
                } else {
                    if (this.f6336k) {
                        L0(kVar);
                    }
                    Z(kVar.m());
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public final void N0(k kVar, n nVar) {
        if (this.f6336k) {
            L0(kVar);
        }
        switch (a.f6345a[nVar.ordinal()]) {
            case 6:
                if (kVar.i0()) {
                    A0(kVar.Z(), kVar.b0(), kVar.a0());
                    return;
                } else {
                    z0(kVar.Y());
                    return;
                }
            case 7:
                int i10 = a.f6346b[kVar.R().ordinal()];
                if (i10 == 1) {
                    d0(kVar.P());
                    return;
                } else if (i10 != 2) {
                    e0(kVar.Q());
                    return;
                } else {
                    h0(kVar.s());
                    return;
                }
            case 8:
                if (this.f6337l) {
                    g0(kVar.L());
                    return;
                }
                K0(n.VALUE_NUMBER_FLOAT, kVar.T());
                return;
            case 9:
                U(true);
                return;
            case 10:
                U(false);
                return;
            case 11:
                a0();
                return;
            case 12:
                a1(kVar.N());
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + nVar);
        }
    }

    public void O0() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    public int P(c3.a aVar, InputStream inputStream, int i10) {
        throw new UnsupportedOperationException();
    }

    public y P0(y yVar) {
        boolean z10;
        if (!this.f6334i) {
            this.f6334i = yVar.n();
        }
        if (!this.f6335j) {
            this.f6335j = yVar.m();
        }
        if (this.f6334i || this.f6335j) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f6336k = z10;
        k R0 = yVar.R0();
        while (R0.s0() != null) {
            V0(R0);
        }
        return this;
    }

    public void R(c3.a aVar, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        a1(bArr2);
    }

    public k R0() {
        return T0(this.f6330e);
    }

    public k S0(k kVar) {
        b bVar = new b(this.f6338m, kVar.y(), this.f6334i, this.f6335j, this.f6331f);
        bVar.o1(kVar.c0());
        return bVar;
    }

    public k T0(o oVar) {
        return new b(this.f6338m, oVar, this.f6334i, this.f6335j, this.f6331f);
    }

    public void U(boolean z10) {
        n nVar;
        if (z10) {
            nVar = n.VALUE_TRUE;
        } else {
            nVar = n.VALUE_FALSE;
        }
        J0(nVar);
    }

    public k U0() {
        k T0 = T0(this.f6330e);
        T0.s0();
        return T0;
    }

    public final void V() {
        F0(n.END_ARRAY);
        e s10 = this.f6344s.e();
        if (s10 != null) {
            this.f6344s = s10;
        }
    }

    public void V0(k kVar) {
        n n10 = kVar.n();
        if (n10 == n.FIELD_NAME) {
            if (this.f6336k) {
                L0(kVar);
            }
            Z(kVar.m());
            n10 = kVar.s0();
        } else if (n10 == null) {
            throw new IllegalStateException("No token available from argument `JsonParser`");
        }
        int i10 = a.f6345a[n10.ordinal()];
        if (i10 == 1) {
            if (this.f6336k) {
                L0(kVar);
            }
            v0();
            M0(kVar);
        } else if (i10 == 2) {
            W();
        } else if (i10 == 3) {
            if (this.f6336k) {
                L0(kVar);
            }
            s0();
            M0(kVar);
        } else if (i10 != 4) {
            N0(kVar, n10);
        } else {
            V();
        }
    }

    public final void W() {
        F0(n.END_OBJECT);
        e s10 = this.f6344s.e();
        if (s10 != null) {
            this.f6344s = s10;
        }
    }

    public y W0(k kVar, g gVar) {
        n s02;
        if (!kVar.j0(n.FIELD_NAME)) {
            V0(kVar);
            return this;
        }
        v0();
        do {
            V0(kVar);
            s02 = kVar.s0();
        } while (s02 == n.FIELD_NAME);
        n nVar = n.END_OBJECT;
        if (s02 != nVar) {
            gVar.E0(y.class, nVar, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + s02, new Object[0]);
        }
        W();
        return this;
    }

    public n X0() {
        return this.f6338m.p(0);
    }

    public void Y(q qVar) {
        this.f6344s.w(qVar.getValue());
        G0(qVar);
    }

    public int Y0() {
        return this.f6332g;
    }

    public final void Z(String str) {
        this.f6344s.w(str);
        G0(str);
    }

    /* renamed from: Z0 */
    public final e s() {
        return this.f6344s;
    }

    public void a0() {
        J0(n.VALUE_NULL);
    }

    public void a1(Object obj) {
        if (obj == null) {
            a0();
        } else if (obj.getClass() == byte[].class || (obj instanceof u)) {
            K0(n.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            o oVar = this.f6330e;
            if (oVar == null) {
                K0(n.VALUE_EMBEDDED_OBJECT, obj);
            } else {
                oVar.c(this, obj);
            }
        }
    }

    public void b0(double d10) {
        K0(n.VALUE_NUMBER_FLOAT, Double.valueOf(d10));
    }

    public void c0(float f10) {
        K0(n.VALUE_NUMBER_FLOAT, Float.valueOf(f10));
    }

    public void close() {
        this.f6333h = true;
    }

    public void d0(int i10) {
        K0(n.VALUE_NUMBER_INT, Integer.valueOf(i10));
    }

    public void e0(long j10) {
        K0(n.VALUE_NUMBER_INT, Long.valueOf(j10));
    }

    public boolean f() {
        return true;
    }

    public void f0(String str) {
        K0(n.VALUE_NUMBER_FLOAT, str);
    }

    public void flush() {
    }

    public void g0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            a0();
        } else {
            K0(n.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    public void h0(BigInteger bigInteger) {
        if (bigInteger == null) {
            a0();
        } else {
            K0(n.VALUE_NUMBER_INT, bigInteger);
        }
    }

    public void i0(short s10) {
        K0(n.VALUE_NUMBER_INT, Short.valueOf(s10));
    }

    public void j0(Object obj) {
        this.f6342q = obj;
        this.f6343r = true;
    }

    public boolean m() {
        return this.f6335j;
    }

    public void m0(char c10) {
        O0();
    }

    public boolean n() {
        return this.f6334i;
    }

    public void n0(q qVar) {
        O0();
    }

    public void o0(String str) {
        O0();
    }

    public void p0(char[] cArr, int i10, int i11) {
        O0();
    }

    public h q(h.b bVar) {
        this.f6332g = (bVar.d() ^ -1) & this.f6332g;
        return this;
    }

    public void r0(String str) {
        K0(n.VALUE_EMBEDDED_OBJECT, new u(str));
    }

    public final void s0() {
        this.f6344s.x();
        I0(n.START_ARRAY);
        this.f6344s = this.f6344s.m();
    }

    public void t0(Object obj) {
        this.f6344s.x();
        I0(n.START_ARRAY);
        this.f6344s = this.f6344s.n(obj);
    }

    public String toString() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        k R0 = R0();
        int i10 = 0;
        if (this.f6334i || this.f6335j) {
            z10 = true;
        } else {
            z10 = false;
        }
        while (true) {
            try {
                n s02 = R0.s0();
                if (s02 == null) {
                    break;
                }
                if (z10) {
                    H0(sb);
                }
                if (i10 < 100) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    sb.append(s02.toString());
                    if (s02 == n.FIELD_NAME) {
                        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
                        sb.append(R0.m());
                        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
                    }
                }
                i10++;
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
        if (i10 >= 100) {
            sb.append(" ... (truncated ");
            sb.append(i10 - 100);
            sb.append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    public void u0(Object obj, int i10) {
        this.f6344s.x();
        I0(n.START_ARRAY);
        this.f6344s = this.f6344s.n(obj);
    }

    public boolean v(h.b bVar) {
        if ((bVar.d() & this.f6332g) != 0) {
            return true;
        }
        return false;
    }

    public final void v0() {
        this.f6344s.x();
        I0(n.START_OBJECT);
        this.f6344s = this.f6344s.o();
    }

    public void w0(Object obj) {
        this.f6344s.x();
        I0(n.START_OBJECT);
        this.f6344s = this.f6344s.p(obj);
    }

    public void x0(Object obj, int i10) {
        this.f6344s.x();
        I0(n.START_OBJECT);
        this.f6344s = this.f6344s.p(obj);
    }

    public h y(int i10, int i11) {
        this.f6332g = (i10 & i11) | (Y0() & (i11 ^ -1));
        return this;
    }

    public void y0(q qVar) {
        if (qVar == null) {
            a0();
        } else {
            K0(n.VALUE_STRING, qVar);
        }
    }

    public void z0(String str) {
        if (str == null) {
            a0();
        } else {
            K0(n.VALUE_STRING, str);
        }
    }

    public y(k kVar) {
        this(kVar, (g) null);
    }

    public y(k kVar, g gVar) {
        boolean z10 = false;
        this.f6343r = false;
        this.f6330e = kVar.y();
        this.f6331f = kVar.V();
        this.f6332g = f6329t;
        this.f6344s = e.q((g3.a) null);
        c cVar = new c();
        this.f6339n = cVar;
        this.f6338m = cVar;
        this.f6340o = 0;
        this.f6334i = kVar.e();
        boolean c10 = kVar.c();
        this.f6335j = c10;
        this.f6336k = this.f6334i || c10;
        this.f6337l = gVar != null ? gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) : z10;
    }
}
