package o3;

import com.fasterxml.jackson.databind.deser.std.f0;
import com.taobao.accs.AccsClientConfig;
import d4.h;
import java.lang.reflect.Member;
import java.util.HashMap;
import k3.b;
import k3.c;
import k3.f;
import k3.g;
import k3.j;
import k3.q;
import m3.m;
import n3.t;
import n3.w;
import r3.i;
import r3.n;

public class e {

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f8477j = {AccsClientConfig.DEFAULT_CONFIGTAG, "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};

    /* renamed from: a  reason: collision with root package name */
    public final c f8478a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f8479b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8480c;

    /* renamed from: d  reason: collision with root package name */
    public final n[] f8481d = new n[11];

    /* renamed from: e  reason: collision with root package name */
    public int f8482e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8483f = false;

    /* renamed from: g  reason: collision with root package name */
    public t[] f8484g;

    /* renamed from: h  reason: collision with root package name */
    public t[] f8485h;

    /* renamed from: i  reason: collision with root package name */
    public t[] f8486i;

    public e(c cVar, m mVar) {
        this.f8478a = cVar;
        this.f8479b = mVar.b();
        this.f8480c = mVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    public final j a(g gVar, n nVar, t[] tVarArr) {
        if (!this.f8483f || nVar == null) {
            return null;
        }
        int i10 = 0;
        if (tVarArr != null) {
            int length = tVarArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (tVarArr[i11] == null) {
                    i10 = i11;
                    break;
                } else {
                    i11++;
                }
            }
        }
        f N = gVar.k();
        j w10 = nVar.w(i10);
        b g10 = N.g();
        if (g10 == null) {
            return w10;
        }
        r3.m t10 = nVar.t(i10);
        Object m10 = g10.m(t10);
        if (m10 != null) {
            return w10.X(gVar.y(t10, m10));
        }
        return g10.u0(N, t10, w10);
    }

    public final i b(i iVar) {
        if (iVar != null && this.f8479b) {
            h.g((Member) iVar.b(), this.f8480c);
        }
        return iVar;
    }

    public boolean c(n nVar) {
        if (!h.L(nVar.k()) || !"valueOf".equals(nVar.d())) {
            return false;
        }
        return true;
    }

    public void d(int i10, boolean z10, n nVar, n nVar2) {
        String str;
        Object[] objArr = new Object[4];
        objArr[0] = f8477j[i10];
        if (z10) {
            str = "explicitly marked";
        } else {
            str = "implicitly discovered";
        }
        objArr[1] = str;
        objArr[2] = nVar;
        objArr[3] = nVar2;
        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", objArr));
    }

    public void e(n nVar, boolean z10) {
        s(nVar, 6, z10);
    }

    public void f(n nVar, boolean z10) {
        s(nVar, 4, z10);
    }

    public void g(n nVar, boolean z10) {
        s(nVar, 7, z10);
    }

    public void h(n nVar, boolean z10, t[] tVarArr, int i10) {
        if (nVar.w(i10).B()) {
            if (s(nVar, 10, z10)) {
                this.f8485h = tVarArr;
            }
        } else if (s(nVar, 8, z10)) {
            this.f8484g = tVarArr;
        }
    }

    public void i(n nVar, boolean z10) {
        s(nVar, 5, z10);
    }

    public void j(n nVar, boolean z10) {
        s(nVar, 2, z10);
    }

    public void k(n nVar, boolean z10) {
        s(nVar, 3, z10);
    }

    public void l(n nVar, boolean z10, t[] tVarArr) {
        Integer num;
        if (s(nVar, 9, z10)) {
            if (tVarArr.length > 1) {
                HashMap hashMap = new HashMap();
                int length = tVarArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    String name = tVarArr[i10].getName();
                    if ((!name.isEmpty() || tVarArr[i10].q() == null) && (num = (Integer) hashMap.put(name, Integer.valueOf(i10))) != null) {
                        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", new Object[]{name, num, Integer.valueOf(i10), h.X(this.f8478a.s())}));
                    }
                }
            }
            this.f8486i = tVarArr;
        }
    }

    public void m(n nVar, boolean z10) {
        s(nVar, 1, z10);
    }

    public w n(g gVar) {
        f N = gVar.k();
        j a10 = a(gVar, this.f8481d[8], this.f8484g);
        j a11 = a(gVar, this.f8481d[10], this.f8485h);
        f0 f0Var = new f0(N, this.f8478a.z());
        n[] nVarArr = this.f8481d;
        f0Var.O(nVarArr[0], nVarArr[8], a10, this.f8484g, nVarArr[9], this.f8486i);
        f0Var.H(this.f8481d[10], a11, this.f8485h);
        f0Var.P(this.f8481d[1]);
        f0Var.M(this.f8481d[2]);
        f0Var.N(this.f8481d[3]);
        f0Var.J(this.f8481d[4]);
        f0Var.L(this.f8481d[5]);
        f0Var.I(this.f8481d[6]);
        f0Var.K(this.f8481d[7]);
        return f0Var;
    }

    public boolean o() {
        if (this.f8481d[0] != null) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f8481d[8] != null) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (this.f8481d[9] != null) {
            return true;
        }
        return false;
    }

    public void r(n nVar) {
        this.f8481d[0] = (n) b(nVar);
    }

    public boolean s(n nVar, int i10, boolean z10) {
        boolean z11;
        int i11 = 1 << i10;
        this.f8483f = true;
        n nVar2 = this.f8481d[i10];
        if (nVar2 != null) {
            if ((this.f8482e & i11) == 0) {
                z11 = !z10;
            } else if (!z10) {
                return false;
            } else {
                z11 = true;
            }
            if (z11 && nVar2.getClass() == nVar.getClass()) {
                Class x10 = nVar2.x(0);
                Class x11 = nVar.x(0);
                if (x10 == x11) {
                    if (c(nVar)) {
                        return false;
                    }
                    if (!c(nVar2)) {
                        d(i10, z10, nVar2, nVar);
                    }
                } else if (x11.isAssignableFrom(x10)) {
                    return false;
                } else {
                    if (!x10.isAssignableFrom(x11)) {
                        if (x10.isPrimitive() == x11.isPrimitive()) {
                            d(i10, z10, nVar2, nVar);
                        } else if (x10.isPrimitive()) {
                            return false;
                        }
                    }
                }
            }
        }
        if (z10) {
            this.f8482e |= i11;
        }
        this.f8481d[i10] = (n) b(nVar);
        return true;
    }
}
