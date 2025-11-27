package k3;

import c3.v;
import d4.h;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import k3.n;

public abstract class m extends n.a implements v, Iterable {
    public abstract String g();

    public BigInteger h() {
        return BigInteger.ZERO;
    }

    public byte[] i() {
        return null;
    }

    public final Iterator iterator() {
        return l();
    }

    public BigDecimal j() {
        return BigDecimal.ZERO;
    }

    public double k() {
        return 0.0d;
    }

    public Iterator l() {
        return h.n();
    }

    public Iterator m() {
        return h.n();
    }

    public abstract m n(String str);

    public abstract z3.m o();

    public boolean p() {
        return false;
    }

    public final boolean q() {
        if (o() == z3.m.BINARY) {
            return true;
        }
        return false;
    }

    public final boolean r() {
        if (o() == z3.m.NUMBER) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        if (o() == z3.m.POJO) {
            return true;
        }
        return false;
    }

    public Number t() {
        return null;
    }

    public String u() {
        return null;
    }
}
