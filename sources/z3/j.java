package z3;

import c3.h;
import c3.k;
import c3.n;
import f3.g;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

public class j extends q {

    /* renamed from: b  reason: collision with root package name */
    public static final j[] f9954b = new j[12];

    /* renamed from: a  reason: collision with root package name */
    public final int f9955a;

    static {
        for (int i10 = 0; i10 < 12; i10++) {
            f9954b[i10] = new j(i10 - 1);
        }
    }

    public j(int i10) {
        this.f9955a = i10;
    }

    public static j A(int i10) {
        if (i10 > 10 || i10 < -1) {
            return new j(i10);
        }
        return f9954b[i10 - -1];
    }

    public k.b a() {
        return k.b.INT;
    }

    public n b() {
        return n.VALUE_NUMBER_INT;
    }

    public final void d(h hVar, c0 c0Var) {
        hVar.d0(this.f9955a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof j) && ((j) obj).f9955a == this.f9955a) {
            return true;
        }
        return false;
    }

    public String g() {
        return g.w(this.f9955a);
    }

    public BigInteger h() {
        return BigInteger.valueOf((long) this.f9955a);
    }

    public int hashCode() {
        return this.f9955a;
    }

    public BigDecimal j() {
        return BigDecimal.valueOf((long) this.f9955a);
    }

    public double k() {
        return (double) this.f9955a;
    }

    public Number t() {
        return Integer.valueOf(this.f9955a);
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return true;
    }

    public int x() {
        return this.f9955a;
    }

    public long z() {
        return (long) this.f9955a;
    }
}
