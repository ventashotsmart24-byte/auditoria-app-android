package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.e0;
import b4.k;
import c3.n;
import i3.b;
import java.lang.reflect.Type;
import k3.c0;
import k3.d;
import k3.j;
import k3.l;
import k3.m;
import k3.o;
import k3.q;
import k3.z;
import u3.f;
import v3.c;
import w3.h;

public class s extends i0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final r3.i f5777a;

    /* renamed from: b  reason: collision with root package name */
    public final h f5778b;

    /* renamed from: c  reason: collision with root package name */
    public final o f5779c;

    /* renamed from: d  reason: collision with root package name */
    public final d f5780d;

    /* renamed from: e  reason: collision with root package name */
    public final j f5781e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5782f;

    /* renamed from: g  reason: collision with root package name */
    public transient k f5783g;

    public static class a extends h {

        /* renamed from: a  reason: collision with root package name */
        public final h f5784a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f5785b;

        public a(h hVar, Object obj) {
            this.f5784a = hVar;
            this.f5785b = obj;
        }

        public h a(d dVar) {
            throw new UnsupportedOperationException();
        }

        public String b() {
            return this.f5784a.b();
        }

        public e0.a c() {
            return this.f5784a.c();
        }

        public b g(c3.h hVar, b bVar) {
            bVar.f7030a = this.f5785b;
            return this.f5784a.g(hVar, bVar);
        }

        public b h(c3.h hVar, b bVar) {
            return this.f5784a.h(hVar, bVar);
        }
    }

    public s(r3.i iVar, h hVar, o oVar) {
        super(iVar.f());
        this.f5777a = iVar;
        this.f5781e = iVar.f();
        this.f5778b = hVar;
        this.f5779c = oVar;
        this.f5780d = null;
        this.f5782f = true;
        this.f5783g = k.c();
    }

    public static final Class e(Class cls) {
        if (cls == null) {
            return Object.class;
        }
        return cls;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        Class k10 = this.f5777a.k();
        if (k10 == null || !d4.h.L(k10) || !c(fVar, jVar, k10)) {
            o oVar = this.f5779c;
            if (oVar == null && (oVar = fVar.getProvider().Q(this.f5781e, false, this.f5780d)) == null) {
                fVar.c(jVar);
            } else {
                oVar.acceptJsonFormatVisitor(fVar, this.f5781e);
            }
        }
    }

    public o b(c0 c0Var, d dVar) {
        h hVar = this.f5778b;
        if (hVar != null) {
            hVar = hVar.a(dVar);
        }
        o oVar = this.f5779c;
        if (oVar != null) {
            return g(dVar, hVar, c0Var.h0(oVar, dVar), this.f5782f);
        }
        if (c0Var.l0(q.USE_STATIC_TYPING) || this.f5781e.G()) {
            o O = c0Var.O(this.f5781e, dVar);
            return g(dVar, hVar, O, f(this.f5781e.q(), O));
        } else if (dVar != this.f5780d) {
            return g(dVar, hVar, oVar, this.f5782f);
        } else {
            return this;
        }
    }

    public boolean c(f fVar, j jVar, Class cls) {
        fVar.a(jVar);
        return true;
    }

    public o d(c0 c0Var, Class cls) {
        o j10 = this.f5783g.j(cls);
        if (j10 != null) {
            return j10;
        }
        if (this.f5781e.w()) {
            j A = c0Var.A(this.f5781e, cls);
            o O = c0Var.O(A, this.f5780d);
            this.f5783g = this.f5783g.b(A, O).f4357b;
            return O;
        }
        o N = c0Var.N(cls, this.f5780d);
        this.f5783g = this.f5783g.a(cls, N).f4357b;
        return N;
    }

    public boolean f(Class cls, o oVar) {
        if (cls.isPrimitive()) {
            if (!(cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE)) {
                return false;
            }
        } else if (!(cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class)) {
            return false;
        }
        return isDefaultSerializer(oVar);
    }

    public s g(d dVar, h hVar, o oVar, boolean z10) {
        if (this.f5780d == dVar && this.f5778b == hVar && this.f5779c == oVar && z10 == this.f5782f) {
            return this;
        }
        return new s(this, dVar, hVar, oVar, z10);
    }

    public m getSchema(c0 c0Var, Type type) {
        o oVar = this.f5779c;
        if (oVar instanceof c) {
            return ((c) oVar).getSchema(c0Var, (Type) null);
        }
        return v3.a.a();
    }

    public boolean isEmpty(c0 c0Var, Object obj) {
        Object n10 = this.f5777a.n(obj);
        if (n10 == null) {
            return true;
        }
        o oVar = this.f5779c;
        if (oVar == null) {
            try {
                oVar = d(c0Var, n10.getClass());
            } catch (l e10) {
                throw new z(e10);
            }
        }
        return oVar.isEmpty(c0Var, n10);
    }

    public void serialize(Object obj, c3.h hVar, c0 c0Var) {
        Object obj2;
        try {
            obj2 = this.f5777a.n(obj);
        } catch (Exception e10) {
            wrapAndThrow(c0Var, (Throwable) e10, obj, this.f5777a.d() + "()");
            obj2 = null;
        }
        if (obj2 == null) {
            c0Var.E(hVar);
            return;
        }
        o oVar = this.f5779c;
        if (oVar == null) {
            oVar = d(c0Var, obj2.getClass());
        }
        h hVar2 = this.f5778b;
        if (hVar2 != null) {
            oVar.serializeWithType(obj2, hVar, c0Var, hVar2);
        } else {
            oVar.serialize(obj2, hVar, c0Var);
        }
    }

    public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, h hVar2) {
        Object obj2;
        try {
            obj2 = this.f5777a.n(obj);
        } catch (Exception e10) {
            wrapAndThrow(c0Var, (Throwable) e10, obj, this.f5777a.d() + "()");
            obj2 = null;
        }
        if (obj2 == null) {
            c0Var.E(hVar);
            return;
        }
        o oVar = this.f5779c;
        if (oVar == null) {
            oVar = d(c0Var, obj2.getClass());
        } else if (this.f5782f) {
            b g10 = hVar2.g(hVar, hVar2.d(obj, n.VALUE_STRING));
            oVar.serialize(obj2, hVar, c0Var);
            hVar2.h(hVar, g10);
            return;
        }
        oVar.serializeWithType(obj2, hVar, c0Var, new a(hVar2, obj));
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this.f5777a.k() + "#" + this.f5777a.d() + ")";
    }

    public s(s sVar, d dVar, h hVar, o oVar, boolean z10) {
        super(e(sVar.handledType()));
        this.f5777a = sVar.f5777a;
        this.f5781e = sVar.f5781e;
        this.f5778b = hVar;
        this.f5779c = oVar;
        this.f5780d = dVar;
        this.f5782f = z10;
        this.f5783g = k.c();
    }
}
