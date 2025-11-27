package k3;

import a4.i;
import a4.q;
import b3.k;
import b3.k0;
import b3.r;
import b4.c;
import b4.l;
import b4.o;
import b4.p;
import b4.t;
import c3.h;
import com.fasterxml.jackson.databind.ser.std.u;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import m3.j;
import p3.b;
import p3.e;
import r3.s;

public abstract class c0 extends e {

    /* renamed from: m  reason: collision with root package name */
    public static final o f7339m = new c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");

    /* renamed from: n  reason: collision with root package name */
    public static final o f7340n = new p();

    /* renamed from: a  reason: collision with root package name */
    public final a0 f7341a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f7342b;

    /* renamed from: c  reason: collision with root package name */
    public final q f7343c;

    /* renamed from: d  reason: collision with root package name */
    public final a4.p f7344d;

    /* renamed from: e  reason: collision with root package name */
    public transient j f7345e;

    /* renamed from: f  reason: collision with root package name */
    public o f7346f;

    /* renamed from: g  reason: collision with root package name */
    public o f7347g;

    /* renamed from: h  reason: collision with root package name */
    public o f7348h;

    /* renamed from: i  reason: collision with root package name */
    public o f7349i;

    /* renamed from: j  reason: collision with root package name */
    public final l f7350j;

    /* renamed from: k  reason: collision with root package name */
    public DateFormat f7351k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f7352l;

    public c0() {
        this.f7346f = f7340n;
        this.f7348h = u.f5804a;
        this.f7349i = f7339m;
        this.f7341a = null;
        this.f7343c = null;
        this.f7344d = new a4.p();
        this.f7350j = null;
        this.f7342b = null;
        this.f7345e = null;
        this.f7352l = true;
    }

    public j A(j jVar, Class cls) {
        if (jVar.y(cls)) {
            return jVar;
        }
        return k().z().G(jVar, cls, true);
    }

    public void B(long j10, h hVar) {
        if (m0(b0.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            hVar.Z(String.valueOf(j10));
        } else {
            hVar.Z(v().format(new Date(j10)));
        }
    }

    public void C(Date date, h hVar) {
        if (m0(b0.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            hVar.Z(String.valueOf(date.getTime()));
        } else {
            hVar.Z(v().format(date));
        }
    }

    public final void D(Date date, h hVar) {
        if (m0(b0.WRITE_DATES_AS_TIMESTAMPS)) {
            hVar.e0(date.getTime());
        } else {
            hVar.z0(v().format(date));
        }
    }

    public final void E(h hVar) {
        if (this.f7352l) {
            hVar.a0();
        } else {
            this.f7348h.serialize((Object) null, hVar, this);
        }
    }

    public final void F(Object obj, h hVar) {
        if (obj != null) {
            P(obj.getClass(), true, (d) null).serialize(obj, hVar, this);
        } else if (this.f7352l) {
            hVar.a0();
        } else {
            this.f7348h.serialize((Object) null, hVar, this);
        }
    }

    public o G(Class cls, d dVar) {
        o e10 = this.f7350j.e(cls);
        if (e10 == null && (e10 = this.f7344d.i(cls)) == null && (e10 = this.f7344d.j(this.f7341a.e(cls))) == null && (e10 = s(cls)) == null) {
            return g0(cls);
        }
        return i0(e10, dVar);
    }

    public o H(j jVar, d dVar) {
        o f10 = this.f7350j.f(jVar);
        if (f10 == null && (f10 = this.f7344d.j(jVar)) == null && (f10 = t(jVar)) == null) {
            return g0(jVar.q());
        }
        return i0(f10, dVar);
    }

    public o I(Class cls, d dVar) {
        return J(this.f7341a.e(cls), dVar);
    }

    public o J(j jVar, d dVar) {
        return w(this.f7343c.a(this, jVar, this.f7347g), dVar);
    }

    public o K(j jVar, d dVar) {
        return this.f7349i;
    }

    public o L(d dVar) {
        return this.f7348h;
    }

    public abstract t M(Object obj, k0 k0Var);

    public o N(Class cls, d dVar) {
        o e10 = this.f7350j.e(cls);
        if (e10 == null && (e10 = this.f7344d.i(cls)) == null && (e10 = this.f7344d.j(this.f7341a.e(cls))) == null && (e10 = s(cls)) == null) {
            return g0(cls);
        }
        return h0(e10, dVar);
    }

    public o O(j jVar, d dVar) {
        o f10 = this.f7350j.f(jVar);
        if (f10 == null && (f10 = this.f7344d.j(jVar)) == null && (f10 = t(jVar)) == null) {
            return g0(jVar.q());
        }
        return h0(f10, dVar);
    }

    public o P(Class cls, boolean z10, d dVar) {
        o c10 = this.f7350j.c(cls);
        if (c10 != null) {
            return c10;
        }
        o g10 = this.f7344d.g(cls);
        if (g10 != null) {
            return g10;
        }
        o S = S(cls, dVar);
        q qVar = this.f7343c;
        a0 a0Var = this.f7341a;
        w3.h c11 = qVar.c(a0Var, a0Var.e(cls));
        if (c11 != null) {
            S = new o(c11.a(dVar), S);
        }
        if (z10) {
            this.f7344d.d(cls, S);
        }
        return S;
    }

    public o Q(j jVar, boolean z10, d dVar) {
        o d10 = this.f7350j.d(jVar);
        if (d10 != null) {
            return d10;
        }
        o h10 = this.f7344d.h(jVar);
        if (h10 != null) {
            return h10;
        }
        o U = U(jVar, dVar);
        w3.h c10 = this.f7343c.c(this.f7341a, jVar);
        if (c10 != null) {
            U = new o(c10.a(dVar), U);
        }
        if (z10) {
            this.f7344d.e(jVar, U);
        }
        return U;
    }

    public o R(Class cls) {
        o e10 = this.f7350j.e(cls);
        if (e10 != null) {
            return e10;
        }
        o i10 = this.f7344d.i(cls);
        if (i10 != null) {
            return i10;
        }
        o j10 = this.f7344d.j(this.f7341a.e(cls));
        if (j10 != null) {
            return j10;
        }
        o s10 = s(cls);
        if (s10 == null) {
            return g0(cls);
        }
        return s10;
    }

    public o S(Class cls, d dVar) {
        o e10 = this.f7350j.e(cls);
        if (e10 == null && (e10 = this.f7344d.i(cls)) == null && (e10 = this.f7344d.j(this.f7341a.e(cls))) == null && (e10 = s(cls)) == null) {
            return g0(cls);
        }
        return i0(e10, dVar);
    }

    public o T(j jVar) {
        o f10 = this.f7350j.f(jVar);
        if (f10 != null) {
            return f10;
        }
        o j10 = this.f7344d.j(jVar);
        if (j10 != null) {
            return j10;
        }
        o t10 = t(jVar);
        if (t10 == null) {
            return g0(jVar.q());
        }
        return t10;
    }

    public o U(j jVar, d dVar) {
        if (jVar == null) {
            r0("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        }
        o f10 = this.f7350j.f(jVar);
        if (f10 == null && (f10 = this.f7344d.j(jVar)) == null && (f10 = t(jVar)) == null) {
            return g0(jVar.q());
        }
        return i0(f10, dVar);
    }

    public final Class V() {
        return this.f7342b;
    }

    public final b W() {
        return this.f7341a.g();
    }

    public Object X(Object obj) {
        return this.f7345e.a(obj);
    }

    /* renamed from: Y */
    public final a0 k() {
        return this.f7341a;
    }

    public o Z() {
        return this.f7348h;
    }

    public final k.d a0(Class cls) {
        return this.f7341a.o(cls);
    }

    public final r.b b0(Class cls) {
        return this.f7341a.p(cls);
    }

    public final a4.k c0() {
        this.f7341a.Z();
        return null;
    }

    public abstract h d0();

    public Locale e0() {
        return this.f7341a.v();
    }

    public TimeZone f0() {
        return this.f7341a.y();
    }

    public o g0(Class cls) {
        if (cls == Object.class) {
            return this.f7346f;
        }
        return new p(cls);
    }

    public o h0(o oVar, d dVar) {
        if (oVar == null || !(oVar instanceof i)) {
            return oVar;
        }
        return ((i) oVar).b(this, dVar);
    }

    public o i0(o oVar, d dVar) {
        if (oVar == null || !(oVar instanceof i)) {
            return oVar;
        }
        return ((i) oVar).b(this, dVar);
    }

    public abstract Object j0(s sVar, Class cls);

    public abstract boolean k0(Object obj);

    public final c4.o l() {
        return this.f7341a.z();
    }

    public final boolean l0(q qVar) {
        return this.f7341a.D(qVar);
    }

    public l m(j jVar, String str, String str2) {
        return e.v((c3.k) null, a(String.format("Could not resolve type id '%s' as a subtype of %s", new Object[]{str, d4.h.G(jVar)}), str2), jVar, str);
    }

    public final boolean m0(b0 b0Var) {
        return this.f7341a.c0(b0Var);
    }

    public l n0(String str, Object... objArr) {
        return l.g(d0(), b(str, objArr));
    }

    public Object o0(Class cls, String str, Throwable th) {
        b t10 = b.t(d0(), str, i(cls));
        t10.initCause(th);
        throw t10;
    }

    public Object p0(c cVar, s sVar, String str, Object... objArr) {
        String str2;
        String b10 = b(str, objArr);
        String str3 = "N/A";
        if (sVar != null) {
            str2 = c(sVar.getName());
        } else {
            str2 = str3;
        }
        if (cVar != null) {
            str3 = d4.h.X(cVar.s());
        }
        throw b.s(d0(), String.format("Invalid definition for property %s (of type %s): %s", new Object[]{str2, str3, b10}), cVar, sVar);
    }

    public Object q(j jVar, String str) {
        throw b.t(d0(), str, jVar);
    }

    public Object q0(c cVar, String str, Object... objArr) {
        String str2;
        if (cVar != null) {
            str2 = d4.h.X(cVar.s());
        } else {
            str2 = "N/A";
        }
        throw b.s(d0(), String.format("Invalid type definition for type %s: %s", new Object[]{str2, b(str, objArr)}), cVar, (s) null);
    }

    public void r0(String str, Object... objArr) {
        throw n0(str, objArr);
    }

    public o s(Class cls) {
        o oVar;
        j e10 = this.f7341a.e(cls);
        try {
            oVar = u(e10);
        } catch (IllegalArgumentException e11) {
            s0(e11, d4.h.o(e11), new Object[0]);
            oVar = null;
        }
        if (oVar != null) {
            this.f7344d.b(cls, e10, oVar, this);
        }
        return oVar;
    }

    public void s0(Throwable th, String str, Object... objArr) {
        throw l.h(d0(), b(str, objArr), th);
    }

    public o t(j jVar) {
        o oVar;
        try {
            oVar = u(jVar);
        } catch (IllegalArgumentException e10) {
            s0(e10, d4.h.o(e10), new Object[0]);
            oVar = null;
        }
        if (oVar != null) {
            this.f7344d.c(jVar, oVar, this);
        }
        return oVar;
    }

    public abstract o t0(r3.b bVar, Object obj);

    public o u(j jVar) {
        return this.f7343c.b(this, jVar);
    }

    public c0 u0(Object obj, Object obj2) {
        this.f7345e = this.f7345e.c(obj, obj2);
        return this;
    }

    public final DateFormat v() {
        DateFormat dateFormat = this.f7351k;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f7341a.k().clone();
        this.f7351k = dateFormat2;
        return dateFormat2;
    }

    public o w(o oVar, d dVar) {
        if (oVar instanceof a4.o) {
            ((a4.o) oVar).a(this);
        }
        return i0(oVar, dVar);
    }

    public o x(o oVar) {
        if (oVar instanceof a4.o) {
            ((a4.o) oVar).a(this);
        }
        return oVar;
    }

    public void y(Object obj, j jVar) {
        if (!jVar.K() || !d4.h.o0(jVar.q()).isAssignableFrom(obj.getClass())) {
            q(jVar, String.format("Incompatible types: declared root type (%s) vs %s", new Object[]{jVar, d4.h.h(obj)}));
        }
    }

    public final boolean z() {
        return this.f7341a.b();
    }

    public c0(c0 c0Var, a0 a0Var, q qVar) {
        this.f7346f = f7340n;
        this.f7348h = u.f5804a;
        o oVar = f7339m;
        this.f7349i = oVar;
        this.f7343c = qVar;
        this.f7341a = a0Var;
        a4.p pVar = c0Var.f7344d;
        this.f7344d = pVar;
        this.f7346f = c0Var.f7346f;
        this.f7347g = c0Var.f7347g;
        o oVar2 = c0Var.f7348h;
        this.f7348h = oVar2;
        this.f7349i = c0Var.f7349i;
        this.f7352l = oVar2 == oVar;
        this.f7342b = a0Var.K();
        this.f7345e = a0Var.L();
        this.f7350j = pVar.f();
    }
}
