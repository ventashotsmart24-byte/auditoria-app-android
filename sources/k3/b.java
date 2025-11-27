package k3;

import b3.b;
import b3.b0;
import b3.h;
import b3.k;
import b3.p;
import b3.r;
import b3.s;
import b3.w;
import d4.q;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import l3.e;
import l3.f;
import m3.m;
import r3.a0;
import r3.b0;
import r3.c;
import r3.h0;
import r3.i;
import r3.j;
import w3.g;

public abstract class b implements Serializable {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final C0096a f7307a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7308b;

        /* renamed from: k3.b$a$a  reason: collision with other inner class name */
        public enum C0096a {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public a(C0096a aVar, String str) {
            this.f7307a = aVar;
            this.f7308b = str;
        }

        public static a a(String str) {
            return new a(C0096a.BACK_REFERENCE, str);
        }

        public static a e(String str) {
            return new a(C0096a.MANAGED_REFERENCE, str);
        }

        public String b() {
            return this.f7308b;
        }

        public boolean c() {
            if (this.f7307a == C0096a.BACK_REFERENCE) {
                return true;
            }
            return false;
        }

        public boolean d() {
            if (this.f7307a == C0096a.MANAGED_REFERENCE) {
                return true;
            }
            return false;
        }
    }

    public static b t0() {
        return a0.f9015a;
    }

    public Object A(r3.b bVar) {
        return null;
    }

    public b0 B(r3.b bVar) {
        return null;
    }

    public b0 C(r3.b bVar, b0 b0Var) {
        return b0Var;
    }

    public Class D(c cVar) {
        return null;
    }

    public e.a E(c cVar) {
        return null;
    }

    public w.a F(r3.b bVar) {
        return null;
    }

    public List G(r3.b bVar) {
        return null;
    }

    public g H(m mVar, i iVar, j jVar) {
        return null;
    }

    public String I(r3.b bVar) {
        return null;
    }

    public String J(r3.b bVar) {
        return null;
    }

    public p.a K(m mVar, r3.b bVar) {
        return L(bVar);
    }

    public p.a L(r3.b bVar) {
        return p.a.f();
    }

    public r.b M(r3.b bVar) {
        return r.b.c();
    }

    public s.a N(m mVar, r3.b bVar) {
        return s.a.c();
    }

    public Integer O(r3.b bVar) {
        return null;
    }

    public g P(m mVar, i iVar, j jVar) {
        return null;
    }

    public a Q(i iVar) {
        return null;
    }

    public x R(m mVar, r3.g gVar, x xVar) {
        return null;
    }

    public x S(c cVar) {
        return null;
    }

    public Object T(i iVar) {
        return null;
    }

    public Object U(r3.b bVar) {
        return null;
    }

    public String[] V(c cVar) {
        return null;
    }

    public Boolean W(r3.b bVar) {
        return null;
    }

    public f.b X(r3.b bVar) {
        return null;
    }

    public Object Y(r3.b bVar) {
        return null;
    }

    public b0.a Z(r3.b bVar) {
        return b0.a.c();
    }

    public Annotation a(r3.b bVar, Class cls) {
        return bVar.c(cls);
    }

    public List a0(r3.b bVar) {
        return null;
    }

    public boolean b(r3.b bVar, Class cls) {
        return bVar.g(cls);
    }

    public String b0(c cVar) {
        return null;
    }

    public boolean c(r3.b bVar, Class[] clsArr) {
        return bVar.h(clsArr);
    }

    public g c0(m mVar, c cVar, j jVar) {
        return null;
    }

    public void d(m mVar, c cVar, List list) {
    }

    public q d0(i iVar) {
        return null;
    }

    public h0 e(c cVar, h0 h0Var) {
        return h0Var;
    }

    public Object e0(c cVar) {
        return null;
    }

    public Object f(r3.b bVar) {
        return null;
    }

    public Class[] f0(r3.b bVar) {
        return null;
    }

    public Object g(r3.b bVar) {
        return null;
    }

    public x g0(r3.b bVar) {
        return null;
    }

    public h.a h(m mVar, r3.b bVar) {
        if (!n0(bVar)) {
            return null;
        }
        h.a i10 = i(bVar);
        if (i10 == null) {
            return h.a.DEFAULT;
        }
        return i10;
    }

    public Boolean h0(r3.b bVar) {
        if (!(bVar instanceof j) || !i0((j) bVar)) {
            return null;
        }
        return Boolean.TRUE;
    }

    public h.a i(r3.b bVar) {
        return null;
    }

    public boolean i0(j jVar) {
        return false;
    }

    public Enum j(Class cls) {
        return null;
    }

    public Boolean j0(r3.b bVar) {
        return null;
    }

    public Object k(i iVar) {
        return null;
    }

    public Boolean k0(m mVar, r3.b bVar) {
        return null;
    }

    public Object l(r3.b bVar) {
        return null;
    }

    public Boolean l0(r3.b bVar) {
        if (!(bVar instanceof j) || !m0((j) bVar)) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Object m(r3.b bVar) {
        return null;
    }

    public boolean m0(j jVar) {
        return false;
    }

    public void n(Class cls, Enum[] enumArr, String[][] strArr) {
    }

    public boolean n0(r3.b bVar) {
        return false;
    }

    public String[] o(Class cls, Enum[] enumArr, String[] strArr) {
        return strArr;
    }

    public boolean o0(i iVar) {
        return false;
    }

    public Object p(r3.b bVar) {
        return null;
    }

    public Boolean p0(i iVar) {
        return null;
    }

    public k.d q(r3.b bVar) {
        return k.d.b();
    }

    public boolean q0(Annotation annotation) {
        return false;
    }

    public String r(i iVar) {
        return null;
    }

    public Boolean r0(c cVar) {
        return null;
    }

    public b.a s(i iVar) {
        Object t10 = t(iVar);
        if (t10 != null) {
            return b.a.c(t10);
        }
        return null;
    }

    public Boolean s0(i iVar) {
        return null;
    }

    public Object t(i iVar) {
        return null;
    }

    public Object u(r3.b bVar) {
        return null;
    }

    public j u0(m mVar, r3.b bVar, j jVar) {
        return jVar;
    }

    public Object v(r3.b bVar) {
        return null;
    }

    public j v0(m mVar, r3.b bVar, j jVar) {
        return jVar;
    }

    public Boolean w(r3.b bVar) {
        return null;
    }

    public j w0(m mVar, j jVar, j jVar2) {
        return null;
    }

    public x x(r3.b bVar) {
        return null;
    }

    public x y(r3.b bVar) {
        return null;
    }

    public Object z(c cVar) {
        return null;
    }
}
