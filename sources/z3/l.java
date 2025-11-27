package z3;

import d4.u;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class l implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final l f9960b;

    /* renamed from: c  reason: collision with root package name */
    public static final l f9961c = new l(true);

    /* renamed from: d  reason: collision with root package name */
    public static final l f9962d;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9963a;

    static {
        l lVar = new l(false);
        f9960b = lVar;
        f9962d = lVar;
    }

    public l(boolean z10) {
        this.f9963a = z10;
    }

    public a a() {
        return new a(this);
    }

    public d b(byte[] bArr) {
        return d.v(bArr);
    }

    public e c(boolean z10) {
        if (z10) {
            return e.w();
        }
        return e.v();
    }

    public p d() {
        return p.v();
    }

    public q e(double d10) {
        return h.A(d10);
    }

    public q f(float f10) {
        return i.A(f10);
    }

    public q g(int i10) {
        return j.A(i10);
    }

    public q h(long j10) {
        return n.A(j10);
    }

    public v i(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return d();
        }
        if (this.f9963a) {
            return g.A(bigDecimal);
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return g.f9946b;
        }
        return g.A(bigDecimal.stripTrailingZeros());
    }

    public v j(BigInteger bigInteger) {
        if (bigInteger == null) {
            return d();
        }
        return c.A(bigInteger);
    }

    public r k() {
        return new r(this);
    }

    public v l(Object obj) {
        return new s(obj);
    }

    public v m(u uVar) {
        return new s(uVar);
    }

    public t n(String str) {
        return t.w(str);
    }
}
