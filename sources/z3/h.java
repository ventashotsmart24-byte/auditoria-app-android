package z3;

import c3.k;
import c3.n;
import f3.g;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

public class h extends q {

    /* renamed from: a  reason: collision with root package name */
    public final double f9952a;

    public h(double d10) {
        this.f9952a = d10;
    }

    public static h A(double d10) {
        return new h(d10);
    }

    public k.b a() {
        return k.b.DOUBLE;
    }

    public n b() {
        return n.VALUE_NUMBER_FLOAT;
    }

    public final void d(c3.h hVar, c0 c0Var) {
        hVar.b0(this.f9952a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        if (Double.compare(this.f9952a, ((h) obj).f9952a) == 0) {
            return true;
        }
        return false;
    }

    public String g() {
        return g.u(this.f9952a);
    }

    public BigInteger h() {
        return j().toBigInteger();
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f9952a);
        return ((int) doubleToLongBits) ^ ((int) (doubleToLongBits >> 32));
    }

    public BigDecimal j() {
        return BigDecimal.valueOf(this.f9952a);
    }

    public double k() {
        return this.f9952a;
    }

    public Number t() {
        return Double.valueOf(this.f9952a);
    }

    public boolean v() {
        double d10 = this.f9952a;
        if (d10 < -2.147483648E9d || d10 > 2.147483647E9d) {
            return false;
        }
        return true;
    }

    public boolean w() {
        double d10 = this.f9952a;
        if (d10 < -9.223372036854776E18d || d10 > 9.223372036854776E18d) {
            return false;
        }
        return true;
    }

    public int x() {
        return (int) this.f9952a;
    }

    public boolean y() {
        if (Double.isNaN(this.f9952a) || Double.isInfinite(this.f9952a)) {
            return true;
        }
        return false;
    }

    public long z() {
        return (long) this.f9952a;
    }
}
