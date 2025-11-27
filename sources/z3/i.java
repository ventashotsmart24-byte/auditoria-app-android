package z3;

import c3.h;
import c3.k;
import c3.n;
import f3.g;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

public class i extends q {

    /* renamed from: a  reason: collision with root package name */
    public final float f9953a;

    public i(float f10) {
        this.f9953a = f10;
    }

    public static i A(float f10) {
        return new i(f10);
    }

    public k.b a() {
        return k.b.FLOAT;
    }

    public n b() {
        return n.VALUE_NUMBER_FLOAT;
    }

    public final void d(h hVar, c0 c0Var) {
        hVar.c0(this.f9953a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        if (Float.compare(this.f9953a, ((i) obj).f9953a) == 0) {
            return true;
        }
        return false;
    }

    public String g() {
        return g.v(this.f9953a);
    }

    public BigInteger h() {
        return j().toBigInteger();
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f9953a);
    }

    public BigDecimal j() {
        return BigDecimal.valueOf((double) this.f9953a);
    }

    public double k() {
        return (double) this.f9953a;
    }

    public Number t() {
        return Float.valueOf(this.f9953a);
    }

    public boolean v() {
        float f10 = this.f9953a;
        if (f10 < -2.14748365E9f || f10 > 2.14748365E9f) {
            return false;
        }
        return true;
    }

    public boolean w() {
        float f10 = this.f9953a;
        if (f10 < -9.223372E18f || f10 > 9.223372E18f) {
            return false;
        }
        return true;
    }

    public int x() {
        return (int) this.f9953a;
    }

    public boolean y() {
        if (Float.isNaN(this.f9953a) || Float.isInfinite(this.f9953a)) {
            return true;
        }
        return false;
    }

    public long z() {
        return (long) this.f9953a;
    }
}
