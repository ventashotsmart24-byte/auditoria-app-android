package z3;

import c3.h;
import c3.k;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import f3.g;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

public class n extends q {

    /* renamed from: a  reason: collision with root package name */
    public final long f9974a;

    public n(long j10) {
        this.f9974a = j10;
    }

    public static n A(long j10) {
        return new n(j10);
    }

    public k.b a() {
        return k.b.LONG;
    }

    public c3.n b() {
        return c3.n.VALUE_NUMBER_INT;
    }

    public final void d(h hVar, c0 c0Var) {
        hVar.e0(this.f9974a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof n) && ((n) obj).f9974a == this.f9974a) {
            return true;
        }
        return false;
    }

    public String g() {
        return g.x(this.f9974a);
    }

    public BigInteger h() {
        return BigInteger.valueOf(this.f9974a);
    }

    public int hashCode() {
        long j10 = this.f9974a;
        return ((int) j10) ^ ((int) (j10 >> 32));
    }

    public BigDecimal j() {
        return BigDecimal.valueOf(this.f9974a);
    }

    public double k() {
        return (double) this.f9974a;
    }

    public Number t() {
        return Long.valueOf(this.f9974a);
    }

    public boolean v() {
        long j10 = this.f9974a;
        if (j10 < -2147483648L || j10 > TTL.MAX_VALUE) {
            return false;
        }
        return true;
    }

    public boolean w() {
        return true;
    }

    public int x() {
        return (int) this.f9974a;
    }

    public long z() {
        return this.f9974a;
    }
}
