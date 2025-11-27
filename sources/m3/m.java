package m3;

import b3.b0;
import b3.k;
import b3.r;
import c4.o;
import d4.h;
import f3.i;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import k3.c;
import k3.j;
import k3.q;
import k3.y;
import r3.a;
import r3.a0;
import r3.b;
import r3.h0;
import r3.t;
import w3.f;
import w3.g;
import x3.l;

public abstract class m implements t.a, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final r.b f7884c = r.b.c();

    /* renamed from: d  reason: collision with root package name */
    public static final k.d f7885d = k.d.b();

    /* renamed from: a  reason: collision with root package name */
    public final int f7886a;

    /* renamed from: b  reason: collision with root package name */
    public final a f7887b;

    public m(a aVar, int i10) {
        this.f7887b = aVar;
        this.f7886a = i10;
    }

    public static int c(Class cls) {
        int i10 = 0;
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            f fVar = (f) enumR;
            if (fVar.a()) {
                i10 |= fVar.b();
            }
        }
        return i10;
    }

    public c A(Class cls) {
        return B(e(cls));
    }

    public c B(j jVar) {
        return i().a(this, jVar, this);
    }

    public final boolean C() {
        return D(q.USE_ANNOTATIONS);
    }

    public final boolean D(q qVar) {
        return qVar.c(this.f7886a);
    }

    public final boolean E() {
        return D(q.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public f F(b bVar, Class cls) {
        u();
        return (f) h.l(cls, b());
    }

    public g G(b bVar, Class cls) {
        u();
        return (g) h.l(cls, b());
    }

    public final boolean b() {
        return D(q.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public c3.q d(String str) {
        return new i(str);
    }

    public final j e(Class cls) {
        return z().H(cls);
    }

    public final a.C0120a f() {
        return this.f7887b.a();
    }

    public k3.b g() {
        if (D(q.USE_ANNOTATIONS)) {
            return this.f7887b.b();
        }
        return a0.f9015a;
    }

    public c3.a h() {
        return this.f7887b.c();
    }

    public t i() {
        return this.f7887b.d();
    }

    public abstract g j(Class cls);

    public final DateFormat k() {
        return this.f7887b.e();
    }

    public abstract r.b l(Class cls, Class cls2);

    public r.b m(Class cls, Class cls2, r.b bVar) {
        return r.b.j(bVar, j(cls).d(), j(cls2).e());
    }

    public abstract Boolean n();

    public abstract k.d o(Class cls);

    public abstract r.b p(Class cls);

    public r.b q(Class cls, r.b bVar) {
        r.b d10 = j(cls).d();
        if (d10 != null) {
            return d10;
        }
        return bVar;
    }

    public abstract b0.a r();

    public final g s(j jVar) {
        return this.f7887b.l();
    }

    public abstract h0 t(Class cls, r3.c cVar);

    public final l u() {
        this.f7887b.f();
        return null;
    }

    public final Locale v() {
        return this.f7887b.g();
    }

    public w3.c w() {
        w3.c h10 = this.f7887b.h();
        if (h10 != l.f9691a || !D(q.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES)) {
            return h10;
        }
        return new w3.a();
    }

    public final y x() {
        this.f7887b.i();
        return null;
    }

    public final TimeZone y() {
        return this.f7887b.j();
    }

    public final o z() {
        return this.f7887b.k();
    }

    public m(m mVar, int i10) {
        this.f7887b = mVar.f7887b;
        this.f7886a = i10;
    }
}
