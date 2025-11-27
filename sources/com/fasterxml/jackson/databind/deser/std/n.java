package com.fasterxml.jackson.databind.deser.std;

import c3.l;
import c4.f;
import d4.h;
import java.io.IOException;
import k3.d;
import k3.g;
import k3.j;
import k3.k;
import k3.q;
import n3.i;
import n3.t;
import n3.w;
import o3.s;
import o3.v;
import o3.y;
import w3.e;

public class n extends b0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final j f5655a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5656b;

    /* renamed from: c  reason: collision with root package name */
    public final r3.j f5657c;

    /* renamed from: d  reason: collision with root package name */
    public final k f5658d;

    /* renamed from: e  reason: collision with root package name */
    public final w f5659e;

    /* renamed from: f  reason: collision with root package name */
    public final t[] f5660f;

    /* renamed from: g  reason: collision with root package name */
    public transient v f5661g;

    public n(Class cls, r3.j jVar, j jVar2, w wVar, t[] tVarArr) {
        super(cls);
        this.f5657c = jVar;
        this.f5656b = true;
        this.f5655a = jVar2.y(String.class) ? null : jVar2;
        this.f5658d = null;
        this.f5659e = wVar;
        this.f5660f = tVarArr;
    }

    public final Object a(c3.k kVar, g gVar, t tVar) {
        try {
            return tVar.k(kVar, gVar);
        } catch (Exception e10) {
            return d(e10, handledType(), tVar.getName(), gVar);
        }
    }

    public Object b(c3.k kVar, g gVar, v vVar) {
        y e10 = vVar.e(kVar, gVar, (s) null);
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 != null) {
                    e10.b(d10, a(kVar, gVar, d10));
                } else {
                    kVar.D0();
                }
            }
            n10 = kVar.s0();
        }
        return vVar.a(gVar, e10);
    }

    public final Throwable c(Throwable th, g gVar) {
        boolean z10;
        Throwable F = h.F(th);
        h.h0(F);
        if (gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (F instanceof IOException) {
            if (!z10 || !(F instanceof l)) {
                throw ((IOException) F);
            }
        } else if (!z10) {
            h.j0(F);
        }
        return F;
    }

    public k createContextual(g gVar, d dVar) {
        j jVar;
        if (this.f5658d == null && (jVar = this.f5655a) != null && this.f5660f == null) {
            return new n(this, gVar.D(jVar, dVar));
        }
        return this;
    }

    public Object d(Throwable th, Object obj, String str, g gVar) {
        throw k3.l.q(c(th, gVar), obj, str);
    }

    public Object deserialize(c3.k kVar, g gVar) {
        Object obj;
        k kVar2 = this.f5658d;
        if (kVar2 != null) {
            obj = kVar2.deserialize(kVar, gVar);
        } else if (this.f5656b) {
            c3.n n10 = kVar.n();
            if (this.f5660f != null) {
                if (!kVar.o0()) {
                    j valueType = getValueType(gVar);
                    gVar.y0(valueType, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", h.G(valueType), this.f5657c, kVar.n());
                }
                if (this.f5661g == null) {
                    this.f5661g = v.c(gVar, this.f5659e, this.f5660f, gVar.o0(q.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                }
                kVar.s0();
                return b(kVar, gVar, this.f5661g);
            } else if (n10 == c3.n.VALUE_STRING || n10 == c3.n.FIELD_NAME) {
                obj = kVar.Y();
            } else if (n10 == c3.n.VALUE_NUMBER_INT) {
                obj = kVar.S();
            } else {
                obj = kVar.g0();
            }
        } else {
            kVar.D0();
            try {
                return this.f5657c.q();
            } catch (Exception e10) {
                return gVar.V(this._valueClass, (Object) null, h.k0(e10));
            }
        }
        try {
            return this.f5657c.z(this._valueClass, obj);
        } catch (Exception e11) {
            Throwable k02 = h.k0(e11);
            if (!gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL) || !(k02 instanceof IllegalArgumentException)) {
                return gVar.V(this._valueClass, obj, k02);
            }
            return null;
        }
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        if (this.f5658d == null) {
            return deserialize(kVar, gVar);
        }
        return eVar.c(kVar, gVar);
    }

    public w getValueInstantiator() {
        return this.f5659e;
    }

    public boolean isCachable() {
        return true;
    }

    public f logicalType() {
        return f.Enum;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.FALSE;
    }

    public n(Class cls, r3.j jVar) {
        super(cls);
        this.f5657c = jVar;
        this.f5656b = false;
        this.f5655a = null;
        this.f5658d = null;
        this.f5659e = null;
        this.f5660f = null;
    }

    public n(n nVar, k kVar) {
        super((Class) nVar._valueClass);
        this.f5655a = nVar.f5655a;
        this.f5657c = nVar.f5657c;
        this.f5656b = nVar.f5656b;
        this.f5659e = nVar.f5659e;
        this.f5660f = nVar.f5660f;
        this.f5658d = kVar;
    }
}
