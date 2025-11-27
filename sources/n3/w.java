package n3;

import c3.k;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c;
import k3.f;
import k3.g;
import k3.j;
import o3.y;
import r3.n;

public abstract class w {
    public j A(f fVar) {
        return null;
    }

    public n B() {
        return null;
    }

    public n C() {
        return null;
    }

    public j D(f fVar) {
        return null;
    }

    public t[] E(f fVar) {
        return null;
    }

    public abstract Class F();

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        if (B() != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        if (j() || k() || i() || g() || h() || e() || f() || d() || c()) {
            return true;
        }
        return false;
    }

    public w m(g gVar, c cVar) {
        return this;
    }

    public Object n(g gVar, BigDecimal bigDecimal) {
        return gVar.W(F(), this, (k) null, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", bigDecimal);
    }

    public Object o(g gVar, BigInteger bigInteger) {
        return gVar.W(F(), this, (k) null, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", bigInteger);
    }

    public Object p(g gVar, boolean z10) {
        return gVar.W(F(), this, (k) null, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", Boolean.valueOf(z10));
    }

    public Object q(g gVar, double d10) {
        return gVar.W(F(), this, (k) null, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", Double.valueOf(d10));
    }

    public Object r(g gVar, int i10) {
        return gVar.W(F(), this, (k) null, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", Integer.valueOf(i10));
    }

    public Object s(g gVar, long j10) {
        return gVar.W(F(), this, (k) null, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", Long.valueOf(j10));
    }

    public Object t(g gVar, Object[] objArr) {
        return gVar.W(F(), this, (k) null, "no creator with arguments specified", new Object[0]);
    }

    public Object u(g gVar, t[] tVarArr, y yVar) {
        return t(gVar, yVar.g(tVarArr));
    }

    public Object v(g gVar, String str) {
        return gVar.W(F(), this, gVar.S(), "no String-argument constructor/factory method to deserialize from String value ('%s')", str);
    }

    public Object w(g gVar, Object obj) {
        return gVar.W(F(), this, (k) null, "no array delegate creator specified", new Object[0]);
    }

    public Object x(g gVar) {
        return gVar.W(F(), this, (k) null, "no default no-arguments constructor found", new Object[0]);
    }

    public Object y(g gVar, Object obj) {
        return gVar.W(F(), this, (k) null, "no delegate creator specified", new Object[0]);
    }

    public n z() {
        return null;
    }

    public static class a extends w implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Class f8309a;

        public a(Class cls) {
            this.f8309a = cls;
        }

        public Class F() {
            return this.f8309a;
        }

        public a(j jVar) {
            this.f8309a = jVar.q();
        }
    }
}
