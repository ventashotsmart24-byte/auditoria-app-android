package z3;

import c3.h;
import c3.k;
import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

public class c extends q {

    /* renamed from: b  reason: collision with root package name */
    public static final BigInteger f9935b = BigInteger.valueOf(-2147483648L);

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f9936c = BigInteger.valueOf(TTL.MAX_VALUE);

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f9937d = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f9938e = BigInteger.valueOf(Long.MAX_VALUE);

    /* renamed from: a  reason: collision with root package name */
    public final BigInteger f9939a;

    public c(BigInteger bigInteger) {
        this.f9939a = bigInteger;
    }

    public static c A(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    public k.b a() {
        return k.b.BIG_INTEGER;
    }

    public n b() {
        return n.VALUE_NUMBER_INT;
    }

    public final void d(h hVar, c0 c0Var) {
        hVar.h0(this.f9939a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof c)) {
            return ((c) obj).f9939a.equals(this.f9939a);
        }
        return false;
    }

    public String g() {
        return this.f9939a.toString();
    }

    public BigInteger h() {
        return this.f9939a;
    }

    public int hashCode() {
        return this.f9939a.hashCode();
    }

    public BigDecimal j() {
        return new BigDecimal(this.f9939a);
    }

    public double k() {
        return this.f9939a.doubleValue();
    }

    public Number t() {
        return this.f9939a;
    }

    public boolean v() {
        if (this.f9939a.compareTo(f9935b) < 0 || this.f9939a.compareTo(f9936c) > 0) {
            return false;
        }
        return true;
    }

    public boolean w() {
        if (this.f9939a.compareTo(f9937d) < 0 || this.f9939a.compareTo(f9938e) > 0) {
            return false;
        }
        return true;
    }

    public int x() {
        return this.f9939a.intValue();
    }

    public long z() {
        return this.f9939a.longValue();
    }
}
