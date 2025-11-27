package k3;

import b3.k;
import b3.k0;
import b3.o0;
import c3.k;
import c3.r;
import d4.c;
import d4.h;
import d4.o;
import d4.s;
import j3.i;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import m3.b;
import m3.e;
import m3.j;
import n3.m;
import n3.n;
import n3.w;
import o3.b0;
import o3.z;
import p3.f;
import z3.l;

public abstract class g extends e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final m f7370a;

    /* renamed from: b  reason: collision with root package name */
    public final n f7371b;

    /* renamed from: c  reason: collision with root package name */
    public final f f7372c;

    /* renamed from: d  reason: collision with root package name */
    public final int f7373d;

    /* renamed from: e  reason: collision with root package name */
    public final i f7374e;

    /* renamed from: f  reason: collision with root package name */
    public final Class f7375f;

    /* renamed from: g  reason: collision with root package name */
    public transient k f7376g;

    /* renamed from: h  reason: collision with root package name */
    public transient c f7377h;

    /* renamed from: i  reason: collision with root package name */
    public transient s f7378i;

    /* renamed from: j  reason: collision with root package name */
    public transient DateFormat f7379j;

    /* renamed from: k  reason: collision with root package name */
    public transient j f7380k;

    /* renamed from: l  reason: collision with root package name */
    public o f7381l;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7382a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                c3.n[] r0 = c3.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7382a = r0
                c3.n r1 = c3.n.START_OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x001d }
                c3.n r1 = c3.n.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0028 }
                c3.n r1 = c3.n.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0033 }
                c3.n r1 = c3.n.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x003e }
                c3.n r1 = c3.n.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0049 }
                c3.n r1 = c3.n.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0054 }
                c3.n r1 = c3.n.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0060 }
                c3.n r1 = c3.n.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x006c }
                c3.n r1 = c3.n.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0078 }
                c3.n r1 = c3.n.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0084 }
                c3.n r1 = c3.n.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x0090 }
                c3.n r1 = c3.n.VALUE_NULL     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f7382a     // Catch:{ NoSuchFieldError -> 0x009c }
                c3.n r1 = c3.n.NOT_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k3.g.a.<clinit>():void");
        }
    }

    public g(n nVar, m mVar) {
        if (nVar != null) {
            this.f7371b = nVar;
            this.f7370a = mVar == null ? new m() : mVar;
            this.f7373d = 0;
            this.f7374e = null;
            this.f7372c = null;
            this.f7375f = null;
            this.f7380k = null;
            return;
        }
        throw new NullPointerException("Cannot pass null DeserializerFactory");
    }

    public Class A(String str) {
        return l().J(str);
    }

    public Object A0(Class cls, String str, String str2, Object... objArr) {
        f s10 = f.s(S(), cls, b(str2, objArr));
        if (str != null) {
            s10.n(cls, str);
        }
        throw s10;
    }

    public b B(c4.f fVar, Class cls, e eVar) {
        return this.f7372c.X(fVar, cls, eVar);
    }

    public Object B0(j jVar, String str, String str2, Object... objArr) {
        return A0(jVar.q(), str, str2, objArr);
    }

    public b C(c4.f fVar, Class cls, b bVar) {
        return this.f7372c.Y(fVar, cls, bVar);
    }

    public Object C0(Class cls, k kVar, c3.n nVar) {
        throw f.s(kVar, cls, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", new Object[]{nVar, h.X(cls)}));
    }

    public final k D(j jVar, d dVar) {
        k n10 = this.f7370a.n(this, this.f7371b, jVar);
        if (n10 != null) {
            return Z(n10, dVar, jVar);
        }
        return n10;
    }

    public Object D0(o3.s sVar, Object obj) {
        return x0(sVar.f8538e, String.format("No Object Id found for an instance of %s, to assign to property '%s'", new Object[]{h.h(obj), sVar.f8535b}), new Object[0]);
    }

    public final Object E(Object obj, d dVar, Object obj2) {
        p(h.i(obj), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", new Object[]{obj}));
        throw null;
    }

    public void E0(Class cls, c3.n nVar, String str, Object... objArr) {
        throw M0(S(), cls, nVar, b(str, objArr));
    }

    public final p F(j jVar, d dVar) {
        return this.f7370a.m(this, this.f7371b, jVar);
    }

    public void F0(j jVar, c3.n nVar, String str, Object... objArr) {
        throw N0(S(), jVar, nVar, b(str, objArr));
    }

    public final k G(j jVar) {
        return this.f7370a.n(this, this.f7371b, jVar);
    }

    public void G0(k kVar, c3.n nVar, String str, Object... objArr) {
        throw M0(S(), kVar.handledType(), nVar, b(str, objArr));
    }

    public abstract z H(Object obj, k0 k0Var, o0 o0Var);

    public final void H0(s sVar) {
        if (this.f7378i == null || sVar.h() >= this.f7378i.h()) {
            this.f7378i = sVar;
        }
    }

    public final k I(j jVar) {
        k n10 = this.f7370a.n(this, this.f7371b, jVar);
        if (n10 == null) {
            return null;
        }
        k Z = Z(n10, (d) null, jVar);
        w3.e l10 = this.f7371b.l(this.f7372c, jVar);
        if (l10 != null) {
            return new b0(l10.g((d) null), Z);
        }
        return Z;
    }

    public l I0(Class cls, String str, String str2) {
        return p3.c.v(this.f7376g, String.format("Cannot deserialize Map key of type %s from String %s: %s", new Object[]{h.X(cls), c(str), str2}), str, cls);
    }

    public final Class J() {
        return this.f7375f;
    }

    public l J0(Object obj, Class cls) {
        return p3.c.v(this.f7376g, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", new Object[]{h.X(cls), h.h(obj)}), obj, cls);
    }

    public final b K() {
        return this.f7372c.g();
    }

    public l K0(Number number, Class cls, String str) {
        return p3.c.v(this.f7376g, String.format("Cannot deserialize value of type %s from number %s: %s", new Object[]{h.X(cls), String.valueOf(number), str}), number, cls);
    }

    public final c L() {
        if (this.f7377h == null) {
            this.f7377h = new c();
        }
        return this.f7377h;
    }

    public l L0(String str, Class cls, String str2) {
        return p3.c.v(this.f7376g, String.format("Cannot deserialize value of type %s from String %s: %s", new Object[]{h.X(cls), c(str), str2}), str, cls);
    }

    public final c3.a M() {
        return this.f7372c.h();
    }

    public l M0(k kVar, Class cls, c3.n nVar, String str) {
        return f.s(kVar, cls, a(String.format("Unexpected token (%s), expected %s", new Object[]{kVar.n(), nVar}), str));
    }

    /* renamed from: N */
    public f k() {
        return this.f7372c;
    }

    public l N0(k kVar, j jVar, c3.n nVar, String str) {
        return f.t(kVar, jVar, a(String.format("Unexpected token (%s), expected %s", new Object[]{kVar.n(), nVar}), str));
    }

    public final k.d O(Class cls) {
        return this.f7372c.o(cls);
    }

    public final int P() {
        return this.f7373d;
    }

    public Locale Q() {
        return this.f7372c.v();
    }

    public final l R() {
        return this.f7372c.c0();
    }

    public final c3.k S() {
        return this.f7376g;
    }

    public TimeZone T() {
        return this.f7372c.y();
    }

    public void U(k kVar) {
        if (!o0(q.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            j x10 = x(kVar.handledType());
            throw p3.b.v(S(), String.format("Invalid configuration: values of type %s cannot be merged", new Object[]{h.G(x10)}), x10);
        }
    }

    public Object V(Class cls, Object obj, Throwable th) {
        o d02 = this.f7372c.d0();
        if (d02 == null) {
            h.i0(th);
            if (!n0(h.WRAP_EXCEPTIONS)) {
                h.j0(th);
            }
            throw l0(cls, th);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public Object W(Class cls, w wVar, c3.k kVar, String str, Object... objArr) {
        if (kVar == null) {
            S();
        }
        String b10 = b(str, objArr);
        o d02 = this.f7372c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        } else if (wVar == null) {
            return p(cls, String.format("Cannot construct instance of %s: %s", new Object[]{h.X(cls), b10}));
        } else if (!wVar.l()) {
            return p(cls, String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", new Object[]{h.X(cls), b10}));
        } else {
            return w0(cls, String.format("Cannot construct instance of %s (although at least one Creator exists): %s", new Object[]{h.X(cls), b10}), new Object[0]);
        }
    }

    public j X(j jVar, w3.f fVar, String str) {
        o d02 = this.f7372c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        throw r0(jVar, str);
    }

    public k Y(k kVar, d dVar, j jVar) {
        if (kVar instanceof n3.i) {
            this.f7381l = new o(jVar, this.f7381l);
            try {
                kVar = ((n3.i) kVar).createContextual(this, dVar);
            } finally {
                this.f7381l = this.f7381l.b();
            }
        }
        return kVar;
    }

    public k Z(k kVar, d dVar, j jVar) {
        if (kVar instanceof n3.i) {
            this.f7381l = new o(jVar, this.f7381l);
            try {
                kVar = ((n3.i) kVar).createContextual(this, dVar);
            } finally {
                this.f7381l = this.f7381l.b();
            }
        }
        return kVar;
    }

    public Object a0(Class cls, c3.k kVar) {
        return d0(x(cls), kVar.n(), kVar, (String) null, new Object[0]);
    }

    public Object b0(Class cls, c3.n nVar, c3.k kVar, String str, Object... objArr) {
        return d0(x(cls), nVar, kVar, str, objArr);
    }

    public Object c0(j jVar, c3.k kVar) {
        return d0(jVar, kVar.n(), kVar, (String) null, new Object[0]);
    }

    public Object d0(j jVar, c3.n nVar, c3.k kVar, String str, Object... objArr) {
        String b10 = b(str, objArr);
        o d02 = this.f7372c.d0();
        if (d02 == null) {
            if (b10 == null) {
                String G = h.G(jVar);
                if (nVar == null) {
                    b10 = String.format("Unexpected end-of-input when trying read value of type %s", new Object[]{G});
                } else {
                    b10 = String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", new Object[]{G, t(nVar), nVar});
                }
            }
            if (nVar != null && nVar.e()) {
                kVar.Y();
            }
            y0(jVar, b10, new Object[0]);
            return null;
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public boolean e0(c3.k kVar, k kVar2, Object obj, String str) {
        o d02 = this.f7372c.d0();
        Collection<Object> collection = null;
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        } else if (!n0(h.FAIL_ON_UNKNOWN_PROPERTIES)) {
            kVar.D0();
            return true;
        } else {
            if (kVar2 != null) {
                collection = kVar2.getKnownPropertyNames();
            }
            throw p3.h.v(this.f7376g, obj, str, collection);
        }
    }

    public j f0(j jVar, String str, w3.f fVar, String str2) {
        o d02 = this.f7372c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        } else if (!n0(h.FAIL_ON_INVALID_SUBTYPE)) {
            return null;
        } else {
            throw m(jVar, str, str2);
        }
    }

    public Object g0(Class cls, String str, String str2, Object... objArr) {
        String b10 = b(str2, objArr);
        o d02 = this.f7372c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        throw I0(cls, str, b10);
    }

    public Object h0(j jVar, Object obj, c3.k kVar) {
        o d02 = this.f7372c.d0();
        Class q10 = jVar.q();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        throw J0(obj, q10);
    }

    public Object i0(Class cls, Number number, String str, Object... objArr) {
        String b10 = b(str, objArr);
        o d02 = this.f7372c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        throw K0(number, cls, b10);
    }

    public Object j0(Class cls, String str, String str2, Object... objArr) {
        String b10 = b(str2, objArr);
        o d02 = this.f7372c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        throw L0(str, cls, b10);
    }

    public final boolean k0(int i10) {
        if ((i10 & this.f7373d) != 0) {
            return true;
        }
        return false;
    }

    public final c4.o l() {
        return this.f7372c.z();
    }

    public l l0(Class cls, Throwable th) {
        String str;
        if (th == null) {
            str = "N/A";
        } else {
            str = h.o(th);
            if (str == null) {
                str = h.X(th.getClass());
            }
        }
        return p3.i.s(this.f7376g, String.format("Cannot construct instance of %s, problem: %s", new Object[]{h.X(cls), str}), x(cls), th);
    }

    public l m(j jVar, String str, String str2) {
        return p3.e.v(this.f7376g, a(String.format("Could not resolve type id '%s' as a subtype of %s", new Object[]{str, h.G(jVar)}), str2), jVar, str);
    }

    public final boolean m0(r rVar) {
        return this.f7374e.b(rVar);
    }

    public final boolean n0(h hVar) {
        if ((hVar.b() & this.f7373d) != 0) {
            return true;
        }
        return false;
    }

    public final boolean o0(q qVar) {
        return this.f7372c.D(qVar);
    }

    public abstract p p0(r3.b bVar, Object obj);

    public Object q(j jVar, String str) {
        throw p3.b.v(this.f7376g, str, jVar);
    }

    public final s q0() {
        s sVar = this.f7378i;
        if (sVar == null) {
            return new s();
        }
        this.f7378i = null;
        return sVar;
    }

    public l r0(j jVar, String str) {
        return p3.e.v(this.f7376g, a(String.format("Could not resolve subtype of %s", new Object[]{jVar}), str), jVar, (String) null);
    }

    public DateFormat s() {
        DateFormat dateFormat = this.f7379j;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f7372c.k().clone();
        this.f7379j = dateFormat2;
        return dateFormat2;
    }

    public Date s0(String str) {
        try {
            return s().parse(str);
        } catch (ParseException e10) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[]{str, h.o(e10)}));
        }
    }

    public String t(c3.n nVar) {
        if (nVar == null) {
            return "<end of input>";
        }
        switch (a.f7382a[nVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "Object value";
            case 4:
            case 5:
                return "Array value";
            case 6:
            case 7:
                return "Boolean value";
            case 8:
                return "Embedded Object";
            case 9:
                return "Floating-point value";
            case 10:
                return "Integer value";
            case 11:
                return "String value";
            case 12:
                return "Null value";
            default:
                return "[Unavailable value]";
        }
    }

    public Object t0(k kVar, Class cls, Object obj, String str, Object... objArr) {
        throw p3.c.v(S(), b(str, objArr), obj, cls);
    }

    public final boolean u() {
        return this.f7372c.b();
    }

    public Object u0(c cVar, r3.s sVar, String str, Object... objArr) {
        String b10 = b(str, objArr);
        throw p3.b.u(this.f7376g, String.format("Invalid definition for property %s (of type %s): %s", new Object[]{h.W(sVar), h.X(cVar.s()), b10}), cVar, sVar);
    }

    public Calendar v(Date date) {
        Calendar instance = Calendar.getInstance(T());
        instance.setTime(date);
        return instance;
    }

    public Object v0(c cVar, String str, Object... objArr) {
        throw p3.b.u(this.f7376g, String.format("Invalid type definition for type %s: %s", new Object[]{h.X(cVar.s()), b(str, objArr)}), cVar, (r3.s) null);
    }

    public j w(j jVar, Class cls) {
        if (jVar.y(cls)) {
            return jVar;
        }
        return k().z().G(jVar, cls, false);
    }

    public Object w0(Class cls, String str, Object... objArr) {
        throw f.s(S(), cls, b(str, objArr));
    }

    public final j x(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.f7372c.e(cls);
    }

    public Object x0(d dVar, String str, Object... objArr) {
        j jVar;
        r3.i d10;
        String b10 = b(str, objArr);
        if (dVar == null) {
            jVar = null;
        } else {
            jVar = dVar.getType();
        }
        f t10 = f.t(S(), jVar, b10);
        if (!(dVar == null || (d10 = dVar.d()) == null)) {
            t10.n(d10.k(), dVar.getName());
        }
        throw t10;
    }

    public abstract k y(r3.b bVar, Object obj);

    public Object y0(j jVar, String str, Object... objArr) {
        throw f.t(S(), jVar, b(str, objArr));
    }

    public String z(c3.k kVar, k kVar2, Class cls) {
        return (String) a0(cls, kVar);
    }

    public Object z0(k kVar, String str, Object... objArr) {
        throw f.s(S(), kVar.handledType(), b(str, objArr));
    }

    public g(g gVar, n nVar) {
        this.f7370a = gVar.f7370a;
        this.f7371b = nVar;
        this.f7372c = gVar.f7372c;
        this.f7373d = gVar.f7373d;
        this.f7374e = gVar.f7374e;
        this.f7375f = gVar.f7375f;
        this.f7376g = gVar.f7376g;
        this.f7380k = gVar.f7380k;
    }

    public g(g gVar, f fVar, c3.k kVar, i iVar) {
        i iVar2;
        this.f7370a = gVar.f7370a;
        this.f7371b = gVar.f7371b;
        if (kVar == null) {
            iVar2 = null;
        } else {
            iVar2 = kVar.W();
        }
        this.f7374e = iVar2;
        this.f7372c = fVar;
        this.f7373d = fVar.b0();
        this.f7375f = fVar.K();
        this.f7376g = kVar;
        this.f7380k = fVar.L();
    }

    public g(g gVar, f fVar) {
        this.f7370a = gVar.f7370a;
        this.f7371b = gVar.f7371b;
        this.f7374e = null;
        this.f7372c = fVar;
        this.f7373d = fVar.b0();
        this.f7375f = null;
        this.f7376g = null;
        this.f7380k = null;
    }
}
