package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import c4.f;
import k3.g;
import k3.m;
import w3.e;

public class r extends f {

    /* renamed from: b  reason: collision with root package name */
    public static final r f5664b = new r();

    public static final class a extends f {

        /* renamed from: b  reason: collision with root package name */
        public static final a f5665b = new a();

        public a() {
            super(z3.a.class, Boolean.TRUE);
        }

        public static a m() {
            return f5665b;
        }

        /* renamed from: k */
        public z3.a deserialize(k kVar, g gVar) {
            if (kVar.n0()) {
                return f(kVar, gVar, gVar.R());
            }
            return (z3.a) gVar.a0(z3.a.class, kVar);
        }

        /* renamed from: l */
        public z3.a deserialize(k kVar, g gVar, z3.a aVar) {
            if (kVar.n0()) {
                return (z3.a) i(kVar, gVar, aVar);
            }
            return (z3.a) gVar.a0(z3.a.class, kVar);
        }
    }

    public static final class b extends f {

        /* renamed from: b  reason: collision with root package name */
        public static final b f5666b = new b();

        public b() {
            super(z3.r.class, Boolean.TRUE);
        }

        public static b m() {
            return f5666b;
        }

        /* renamed from: k */
        public z3.r deserialize(k kVar, g gVar) {
            if (kVar.o0()) {
                return g(kVar, gVar, gVar.R());
            }
            if (kVar.j0(n.FIELD_NAME)) {
                return h(kVar, gVar, gVar.R());
            }
            if (kVar.j0(n.END_OBJECT)) {
                return gVar.R().k();
            }
            return (z3.r) gVar.a0(z3.r.class, kVar);
        }

        /* renamed from: l */
        public z3.r deserialize(k kVar, g gVar, z3.r rVar) {
            if (kVar.o0() || kVar.j0(n.FIELD_NAME)) {
                return (z3.r) j(kVar, gVar, rVar);
            }
            return (z3.r) gVar.a0(z3.r.class, kVar);
        }
    }

    public r() {
        super(m.class, (Boolean) null);
    }

    public static k3.k l(Class cls) {
        if (cls == z3.r.class) {
            return b.m();
        }
        if (cls == z3.a.class) {
            return a.m();
        }
        return f5664b;
    }

    public /* bridge */ /* synthetic */ Object deserializeWithType(k kVar, g gVar, e eVar) {
        return super.deserializeWithType(kVar, gVar, eVar);
    }

    public /* bridge */ /* synthetic */ boolean isCachable() {
        return super.isCachable();
    }

    /* renamed from: k */
    public m deserialize(k kVar, g gVar) {
        int q10 = kVar.q();
        if (q10 == 1) {
            return g(kVar, gVar, gVar.R());
        }
        if (q10 != 3) {
            return e(kVar, gVar, gVar.R());
        }
        return f(kVar, gVar, gVar.R());
    }

    public /* bridge */ /* synthetic */ f logicalType() {
        return super.logicalType();
    }

    /* renamed from: m */
    public m getNullValue(g gVar) {
        return gVar.R().d();
    }

    public /* bridge */ /* synthetic */ Boolean supportsUpdate(k3.f fVar) {
        return super.supportsUpdate(fVar);
    }
}
