package com.fasterxml.jackson.databind.deser.std;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.f;
import k3.g;
import k3.j;
import k3.l;
import n3.t;
import n3.w;
import r3.n;

public class f0 extends w implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f5587a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f5588b;

    /* renamed from: c  reason: collision with root package name */
    public n f5589c;

    /* renamed from: d  reason: collision with root package name */
    public n f5590d;

    /* renamed from: e  reason: collision with root package name */
    public t[] f5591e;

    /* renamed from: f  reason: collision with root package name */
    public j f5592f;

    /* renamed from: g  reason: collision with root package name */
    public n f5593g;

    /* renamed from: h  reason: collision with root package name */
    public t[] f5594h;

    /* renamed from: i  reason: collision with root package name */
    public j f5595i;

    /* renamed from: j  reason: collision with root package name */
    public n f5596j;

    /* renamed from: k  reason: collision with root package name */
    public t[] f5597k;

    /* renamed from: l  reason: collision with root package name */
    public n f5598l;

    /* renamed from: m  reason: collision with root package name */
    public n f5599m;

    /* renamed from: n  reason: collision with root package name */
    public n f5600n;

    /* renamed from: o  reason: collision with root package name */
    public n f5601o;

    /* renamed from: p  reason: collision with root package name */
    public n f5602p;

    /* renamed from: q  reason: collision with root package name */
    public n f5603q;

    /* renamed from: r  reason: collision with root package name */
    public n f5604r;

    public f0(f fVar, j jVar) {
        String str;
        Class<Object> cls;
        if (jVar == null) {
            str = "UNKNOWN TYPE";
        } else {
            str = jVar.toString();
        }
        this.f5587a = str;
        if (jVar == null) {
            cls = Object.class;
        } else {
            cls = jVar.q();
        }
        this.f5588b = cls;
    }

    public static Double S(BigDecimal bigDecimal) {
        double doubleValue = bigDecimal.doubleValue();
        if (Double.isInfinite(doubleValue)) {
            return null;
        }
        return Double.valueOf(doubleValue);
    }

    public j A(f fVar) {
        return this.f5595i;
    }

    public n B() {
        return this.f5589c;
    }

    public n C() {
        return this.f5593g;
    }

    public j D(f fVar) {
        return this.f5592f;
    }

    public t[] E(f fVar) {
        return this.f5591e;
    }

    public Class F() {
        return this.f5588b;
    }

    public final Object G(n nVar, t[] tVarArr, g gVar, Object obj) {
        if (nVar == null) {
            throw new IllegalStateException("No delegate constructor for " + Q());
        } else if (tVarArr == null) {
            try {
                return nVar.s(obj);
            } catch (Throwable th) {
                throw R(gVar, th);
            }
        } else {
            int length = tVarArr.length;
            Object[] objArr = new Object[length];
            for (int i10 = 0; i10 < length; i10++) {
                t tVar = tVarArr[i10];
                if (tVar == null) {
                    objArr[i10] = obj;
                } else {
                    objArr[i10] = gVar.E(tVar.q(), tVar, (Object) null);
                }
            }
            return nVar.r(objArr);
        }
    }

    public void H(n nVar, j jVar, t[] tVarArr) {
        this.f5596j = nVar;
        this.f5595i = jVar;
        this.f5597k = tVarArr;
    }

    public void I(n nVar) {
        this.f5603q = nVar;
    }

    public void J(n nVar) {
        this.f5601o = nVar;
    }

    public void K(n nVar) {
        this.f5604r = nVar;
    }

    public void L(n nVar) {
        this.f5602p = nVar;
    }

    public void M(n nVar) {
        this.f5599m = nVar;
    }

    public void N(n nVar) {
        this.f5600n = nVar;
    }

    public void O(n nVar, n nVar2, j jVar, t[] tVarArr, n nVar3, t[] tVarArr2) {
        this.f5589c = nVar;
        this.f5593g = nVar2;
        this.f5592f = jVar;
        this.f5594h = tVarArr;
        this.f5590d = nVar3;
        this.f5591e = tVarArr2;
    }

    public void P(n nVar) {
        this.f5598l = nVar;
    }

    public String Q() {
        return this.f5587a;
    }

    public l R(g gVar, Throwable th) {
        Throwable cause;
        if (((th instanceof ExceptionInInitializerError) || (th instanceof InvocationTargetException)) && (cause = th.getCause()) != null) {
            th = cause;
        }
        return T(gVar, th);
    }

    public l T(g gVar, Throwable th) {
        if (th instanceof l) {
            return (l) th;
        }
        return gVar.l0(F(), th);
    }

    public boolean a() {
        if (this.f5603q != null) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f5601o != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f5604r != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f5602p != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f5599m != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f5600n != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f5590d != null) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f5598l != null) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if (this.f5595i != null) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f5589c != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if (this.f5592f != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (j() || k() || i() || g() || h() || e() || f() || d() || c()) {
            return true;
        }
        return false;
    }

    public Object n(g gVar, BigDecimal bigDecimal) {
        Double S;
        n nVar = this.f5603q;
        if (nVar != null) {
            try {
                return nVar.s(bigDecimal);
            } catch (Throwable th) {
                return gVar.V(this.f5603q.k(), bigDecimal, R(gVar, th));
            }
        } else if (this.f5602p == null || (S = S(bigDecimal)) == null) {
            return super.n(gVar, bigDecimal);
        } else {
            try {
                return this.f5602p.s(S);
            } catch (Throwable th2) {
                return gVar.V(this.f5602p.k(), S, R(gVar, th2));
            }
        }
    }

    public Object o(g gVar, BigInteger bigInteger) {
        n nVar = this.f5601o;
        if (nVar == null) {
            return super.o(gVar, bigInteger);
        }
        try {
            return nVar.s(bigInteger);
        } catch (Throwable th) {
            return gVar.V(this.f5601o.k(), bigInteger, R(gVar, th));
        }
    }

    public Object p(g gVar, boolean z10) {
        if (this.f5604r == null) {
            return super.p(gVar, z10);
        }
        Boolean valueOf = Boolean.valueOf(z10);
        try {
            return this.f5604r.s(valueOf);
        } catch (Throwable th) {
            return gVar.V(this.f5604r.k(), valueOf, R(gVar, th));
        }
    }

    public Object q(g gVar, double d10) {
        if (this.f5602p != null) {
            Double valueOf = Double.valueOf(d10);
            try {
                return this.f5602p.s(valueOf);
            } catch (Throwable th) {
                return gVar.V(this.f5602p.k(), valueOf, R(gVar, th));
            }
        } else if (this.f5603q == null) {
            return super.q(gVar, d10);
        } else {
            BigDecimal valueOf2 = BigDecimal.valueOf(d10);
            try {
                return this.f5603q.s(valueOf2);
            } catch (Throwable th2) {
                return gVar.V(this.f5603q.k(), valueOf2, R(gVar, th2));
            }
        }
    }

    public Object r(g gVar, int i10) {
        if (this.f5599m != null) {
            Integer valueOf = Integer.valueOf(i10);
            try {
                return this.f5599m.s(valueOf);
            } catch (Throwable th) {
                return gVar.V(this.f5599m.k(), valueOf, R(gVar, th));
            }
        } else if (this.f5600n != null) {
            Long valueOf2 = Long.valueOf((long) i10);
            try {
                return this.f5600n.s(valueOf2);
            } catch (Throwable th2) {
                return gVar.V(this.f5600n.k(), valueOf2, R(gVar, th2));
            }
        } else if (this.f5601o == null) {
            return super.r(gVar, i10);
        } else {
            BigInteger valueOf3 = BigInteger.valueOf((long) i10);
            try {
                return this.f5601o.s(valueOf3);
            } catch (Throwable th3) {
                return gVar.V(this.f5601o.k(), valueOf3, R(gVar, th3));
            }
        }
    }

    public Object s(g gVar, long j10) {
        if (this.f5600n != null) {
            Long valueOf = Long.valueOf(j10);
            try {
                return this.f5600n.s(valueOf);
            } catch (Throwable th) {
                return gVar.V(this.f5600n.k(), valueOf, R(gVar, th));
            }
        } else if (this.f5601o == null) {
            return super.s(gVar, j10);
        } else {
            BigInteger valueOf2 = BigInteger.valueOf(j10);
            try {
                return this.f5601o.s(valueOf2);
            } catch (Throwable th2) {
                return gVar.V(this.f5601o.k(), valueOf2, R(gVar, th2));
            }
        }
    }

    public Object t(g gVar, Object[] objArr) {
        n nVar = this.f5590d;
        if (nVar == null) {
            return super.t(gVar, objArr);
        }
        try {
            return nVar.r(objArr);
        } catch (Exception e10) {
            return gVar.V(this.f5588b, objArr, R(gVar, e10));
        }
    }

    public Object v(g gVar, String str) {
        n nVar = this.f5598l;
        if (nVar == null) {
            return super.v(gVar, str);
        }
        try {
            return nVar.s(str);
        } catch (Throwable th) {
            return gVar.V(this.f5598l.k(), str, R(gVar, th));
        }
    }

    public Object w(g gVar, Object obj) {
        n nVar = this.f5596j;
        if (nVar != null || this.f5593g == null) {
            return G(nVar, this.f5597k, gVar, obj);
        }
        return y(gVar, obj);
    }

    public Object x(g gVar) {
        n nVar = this.f5589c;
        if (nVar == null) {
            return super.x(gVar);
        }
        try {
            return nVar.q();
        } catch (Exception e10) {
            return gVar.V(this.f5588b, (Object) null, R(gVar, e10));
        }
    }

    public Object y(g gVar, Object obj) {
        n nVar;
        n nVar2 = this.f5593g;
        if (nVar2 != null || (nVar = this.f5596j) == null) {
            return G(nVar2, this.f5594h, gVar, obj);
        }
        return G(nVar, this.f5597k, gVar, obj);
    }

    public n z() {
        return this.f5596j;
    }
}
