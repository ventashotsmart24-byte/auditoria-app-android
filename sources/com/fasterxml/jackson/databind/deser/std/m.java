package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import c3.n;
import c4.f;
import d4.a;
import java.util.EnumSet;
import java.util.Objects;
import k3.d;
import k3.g;
import k3.h;
import k3.j;
import k3.k;
import k3.l;
import n3.i;
import n3.q;
import w3.e;

public class m extends b0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final j f5648a;

    /* renamed from: b  reason: collision with root package name */
    public k f5649b;

    /* renamed from: c  reason: collision with root package name */
    public final q f5650c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5651d;

    /* renamed from: e  reason: collision with root package name */
    public final Boolean f5652e;

    public m(j jVar, k kVar) {
        super(EnumSet.class);
        this.f5648a = jVar;
        if (jVar.F()) {
            this.f5649b = kVar;
            this.f5652e = null;
            this.f5650c = null;
            this.f5651d = false;
            return;
        }
        throw new IllegalArgumentException("Type " + jVar + " not Java Enum type");
    }

    public final EnumSet a(c3.k kVar, g gVar, EnumSet enumSet) {
        Enum enumR;
        while (true) {
            try {
                n s02 = kVar.s0();
                if (s02 == n.END_ARRAY) {
                    return enumSet;
                }
                if (s02 != n.VALUE_NULL) {
                    enumR = (Enum) this.f5649b.deserialize(kVar, gVar);
                } else if (!this.f5651d) {
                    enumR = (Enum) this.f5650c.getNullValue(gVar);
                }
                if (enumR != null) {
                    enumSet.add(enumR);
                }
            } catch (Exception e10) {
                throw l.p(e10, enumSet, enumSet.size());
            }
        }
    }

    public final EnumSet b() {
        return EnumSet.noneOf(this.f5648a.q());
    }

    /* renamed from: c */
    public EnumSet deserialize(c3.k kVar, g gVar) {
        EnumSet b10 = b();
        if (!kVar.n0()) {
            return e(kVar, gVar, b10);
        }
        return a(kVar, gVar, b10);
    }

    public k createContextual(g gVar, d dVar) {
        k kVar;
        Boolean findFormatFeature = findFormatFeature(gVar, dVar, EnumSet.class, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        k3.k kVar2 = this.f5649b;
        if (kVar2 == null) {
            kVar = gVar.D(this.f5648a, dVar);
        } else {
            kVar = gVar.Z(kVar2, dVar, this.f5648a);
        }
        return f(kVar, findContentNullProvider(gVar, dVar, kVar), findFormatFeature);
    }

    /* renamed from: d */
    public EnumSet deserialize(c3.k kVar, g gVar, EnumSet enumSet) {
        if (!kVar.n0()) {
            return e(kVar, gVar, enumSet);
        }
        return a(kVar, gVar, enumSet);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.d(kVar, gVar);
    }

    public EnumSet e(c3.k kVar, g gVar, EnumSet enumSet) {
        boolean z10;
        Boolean bool = this.f5652e;
        if (bool == Boolean.TRUE || (bool == null && gVar.n0(h.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return (EnumSet) gVar.a0(EnumSet.class, kVar);
        }
        if (kVar.j0(n.VALUE_NULL)) {
            return (EnumSet) gVar.c0(this.f5648a, kVar);
        }
        try {
            Enum enumR = (Enum) this.f5649b.deserialize(kVar, gVar);
            if (enumR != null) {
                enumSet.add(enumR);
            }
            return enumSet;
        } catch (Exception e10) {
            throw l.p(e10, enumSet, enumSet.size());
        }
    }

    public m f(k3.k kVar, q qVar, Boolean bool) {
        if (Objects.equals(this.f5652e, bool) && this.f5649b == kVar && this.f5650c == kVar) {
            return this;
        }
        return new m(this, kVar, qVar, bool);
    }

    public a getEmptyAccessPattern() {
        return a.DYNAMIC;
    }

    public Object getEmptyValue(g gVar) {
        return b();
    }

    public boolean isCachable() {
        if (this.f5648a.u() != null) {
            return false;
        }
        return true;
    }

    public f logicalType() {
        return f.Collection;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.TRUE;
    }

    public m(m mVar, k3.k kVar, q qVar, Boolean bool) {
        super((b0) mVar);
        this.f5648a = mVar.f5648a;
        this.f5649b = kVar;
        this.f5650c = qVar;
        this.f5651d = o3.q.b(qVar);
        this.f5652e = bool;
    }
}
