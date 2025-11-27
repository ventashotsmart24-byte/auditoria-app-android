package z3;

import c3.h;
import c3.k;
import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

public class g extends q {

    /* renamed from: b  reason: collision with root package name */
    public static final g f9946b = new g(BigDecimal.ZERO);

    /* renamed from: c  reason: collision with root package name */
    public static final BigDecimal f9947c = BigDecimal.valueOf(-2147483648L);

    /* renamed from: d  reason: collision with root package name */
    public static final BigDecimal f9948d = BigDecimal.valueOf(TTL.MAX_VALUE);

    /* renamed from: e  reason: collision with root package name */
    public static final BigDecimal f9949e = BigDecimal.valueOf(Long.MIN_VALUE);

    /* renamed from: f  reason: collision with root package name */
    public static final BigDecimal f9950f = BigDecimal.valueOf(Long.MAX_VALUE);

    /* renamed from: a  reason: collision with root package name */
    public final BigDecimal f9951a;

    public g(BigDecimal bigDecimal) {
        this.f9951a = bigDecimal;
    }

    public static g A(BigDecimal bigDecimal) {
        return new g(bigDecimal);
    }

    public k.b a() {
        return k.b.BIG_DECIMAL;
    }

    public n b() {
        return n.VALUE_NUMBER_FLOAT;
    }

    public final void d(h hVar, c0 c0Var) {
        hVar.g0(this.f9951a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof g) && ((g) obj).f9951a.compareTo(this.f9951a) == 0) {
            return true;
        }
        return false;
    }

    public String g() {
        return this.f9951a.toString();
    }

    public BigInteger h() {
        return this.f9951a.toBigInteger();
    }

    public int hashCode() {
        return Double.valueOf(k()).hashCode();
    }

    public BigDecimal j() {
        return this.f9951a;
    }

    public double k() {
        return this.f9951a.doubleValue();
    }

    public Number t() {
        return this.f9951a;
    }

    public boolean v() {
        if (this.f9951a.compareTo(f9947c) < 0 || this.f9951a.compareTo(f9948d) > 0) {
            return false;
        }
        return true;
    }

    public boolean w() {
        if (this.f9951a.compareTo(f9949e) < 0 || this.f9951a.compareTo(f9950f) > 0) {
            return false;
        }
        return true;
    }

    public int x() {
        return this.f9951a.intValue();
    }

    public long z() {
        return this.f9951a.longValue();
    }
}
