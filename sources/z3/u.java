package z3;

import c3.k;
import c3.n;
import c3.o;
import d3.c;
import j3.i;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.m;
import z3.o;

public class u extends c {

    /* renamed from: o  reason: collision with root package name */
    public o f9990o;

    /* renamed from: p  reason: collision with root package name */
    public o f9991p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f9992q;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9993a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                c3.n[] r0 = c3.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9993a = r0
                c3.n r1 = c3.n.START_OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x001d }
                c3.n r1 = c3.n.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x0028 }
                c3.n r1 = c3.n.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x0033 }
                c3.n r1 = c3.n.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x003e }
                c3.n r1 = c3.n.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x0049 }
                c3.n r1 = c3.n.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x0054 }
                c3.n r1 = c3.n.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x0060 }
                c3.n r1 = c3.n.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f9993a     // Catch:{ NoSuchFieldError -> 0x006c }
                c3.n r1 = c3.n.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.u.a.<clinit>():void");
        }
    }

    public u(m mVar, o oVar) {
        super(0);
        this.f9990o = oVar;
        this.f9991p = new o.c(mVar, (o) null);
    }

    public k D0() {
        n nVar = this.f6234c;
        if (nVar == n.START_OBJECT) {
            this.f9991p = this.f9991p.l();
            this.f6234c = n.END_OBJECT;
        } else if (nVar == n.START_ARRAY) {
            this.f9991p = this.f9991p.l();
            this.f6234c = n.END_ARRAY;
        }
        return this;
    }

    public String E() {
        o oVar = this.f9991p;
        n nVar = this.f6234c;
        if (nVar == n.START_OBJECT || nVar == n.START_ARRAY) {
            oVar = oVar.l();
        }
        if (oVar == null) {
            return null;
        }
        return oVar.b();
    }

    public void H0() {
        U0();
    }

    public BigDecimal L() {
        return j1().j();
    }

    public double M() {
        return j1().k();
    }

    public Object N() {
        m i12;
        if (this.f9992q || (i12 = i1()) == null) {
            return null;
        }
        if (i12.s()) {
            return ((s) i12).w();
        }
        if (i12.q()) {
            return ((d) i12).i();
        }
        return null;
    }

    public float O() {
        return (float) j1().k();
    }

    public int P() {
        q qVar = (q) j1();
        if (!qVar.v()) {
            b1();
        }
        return qVar.x();
    }

    public long Q() {
        q qVar = (q) j1();
        if (!qVar.w()) {
            e1();
        }
        return qVar.z();
    }

    public k.b R() {
        m j12 = j1();
        if (j12 == null) {
            return null;
        }
        return j12.a();
    }

    public Number S() {
        return j1().t();
    }

    public c3.m V() {
        return this.f9991p;
    }

    public i W() {
        return k.f4738b;
    }

    public String Y() {
        if (this.f9992q) {
            return null;
        }
        switch (a.f9993a[this.f6234c.ordinal()]) {
            case 5:
                return this.f9991p.b();
            case 6:
                return i1().u();
            case 7:
            case 8:
                return String.valueOf(i1().t());
            case 9:
                m i12 = i1();
                if (i12 != null && i12.q()) {
                    return i12.g();
                }
        }
        n nVar = this.f6234c;
        if (nVar == null) {
            return null;
        }
        return nVar.b();
    }

    public char[] Z() {
        return Y().toCharArray();
    }

    public int a0() {
        return Y().length();
    }

    public int b0() {
        return 0;
    }

    public c3.i c0() {
        return c3.i.f4732f;
    }

    public void close() {
        if (!this.f9992q) {
            this.f9992q = true;
            this.f9991p = null;
            this.f6234c = null;
        }
    }

    public boolean i0() {
        return false;
    }

    public m i1() {
        o oVar;
        if (this.f9992q || (oVar = this.f9991p) == null) {
            return null;
        }
        return oVar.k();
    }

    public m j1() {
        n nVar;
        m i12 = i1();
        if (i12 != null && i12.r()) {
            return i12;
        }
        if (i12 == null) {
            nVar = null;
        } else {
            nVar = i12.b();
        }
        throw b("Current token (" + nVar + ") not numeric, cannot use numeric value accessors");
    }

    public boolean p0() {
        if (this.f9992q) {
            return false;
        }
        m i12 = i1();
        if (i12 instanceof q) {
            return ((q) i12).y();
        }
        return false;
    }

    public BigInteger s() {
        return j1().h();
    }

    public n s0() {
        n m10 = this.f9991p.m();
        this.f6234c = m10;
        if (m10 == null) {
            this.f9992q = true;
            return null;
        }
        int i10 = a.f9993a[m10.ordinal()];
        if (i10 == 1) {
            this.f9991p = this.f9991p.o();
        } else if (i10 == 2) {
            this.f9991p = this.f9991p.n();
        } else if (i10 == 3 || i10 == 4) {
            this.f9991p = this.f9991p.l();
        }
        return this.f6234c;
    }

    public byte[] v(c3.a aVar) {
        m i12 = i1();
        if (i12 == null) {
            return null;
        }
        if (i12 instanceof t) {
            return ((t) i12).v(aVar);
        }
        return i12.i();
    }

    public int w0(c3.a aVar, OutputStream outputStream) {
        byte[] v10 = v(aVar);
        if (v10 == null) {
            return 0;
        }
        outputStream.write(v10, 0, v10.length);
        return v10.length;
    }

    public c3.o y() {
        return this.f9990o;
    }

    public c3.i z() {
        return c3.i.f4732f;
    }
}
