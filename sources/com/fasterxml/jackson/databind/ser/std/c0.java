package com.fasterxml.jackson.databind.ser.std;

import c3.n;
import c4.o;
import java.lang.reflect.Type;
import java.util.HashMap;
import k3.b0;
import k3.j;
import k3.m;
import z3.r;

public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f5738a;

    public static class a extends a {

        /* renamed from: c  reason: collision with root package name */
        public static final j f5739c = o.I().N(Boolean.class);

        public a() {
            super(boolean[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.BOOLEAN);
        }

        public a4.h c(w3.h hVar) {
            return this;
        }

        public k3.o f(k3.d dVar, Boolean bool) {
            return new a(this, dVar, bool);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            r createSchemaNode = createSchemaNode("array", true);
            createSchemaNode.G("items", createSchemaNode("boolean"));
            return createSchemaNode;
        }

        /* renamed from: h */
        public boolean isEmpty(k3.c0 c0Var, boolean[] zArr) {
            if (zArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void serialize(boolean[] zArr, c3.h hVar, k3.c0 c0Var) {
            int length = zArr.length;
            if (length != 1 || !e(c0Var)) {
                hVar.u0(zArr, length);
                g(zArr, hVar, c0Var);
                hVar.V();
                return;
            }
            g(zArr, hVar, c0Var);
        }

        /* renamed from: j */
        public void g(boolean[] zArr, c3.h hVar, k3.c0 c0Var) {
            for (boolean U : zArr) {
                hVar.U(U);
            }
        }

        public a(a aVar, k3.d dVar, Boolean bool) {
            super(aVar, dVar, bool);
        }
    }

    public static class b extends i0 {
        public b() {
            super(char[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.STRING);
        }

        public final void c(c3.h hVar, char[] cArr) {
            int length = cArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                hVar.A0(cArr, i10, 1);
            }
        }

        /* renamed from: d */
        public boolean isEmpty(k3.c0 c0Var, char[] cArr) {
            if (cArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: e */
        public void serialize(char[] cArr, c3.h hVar, k3.c0 c0Var) {
            if (c0Var.m0(b0.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                hVar.u0(cArr, cArr.length);
                c(hVar, cArr);
                hVar.V();
                return;
            }
            hVar.A0(cArr, 0, cArr.length);
        }

        /* renamed from: f */
        public void serializeWithType(char[] cArr, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
            i3.b bVar;
            if (c0Var.m0(b0.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                bVar = hVar2.g(hVar, hVar2.d(cArr, n.START_ARRAY));
                c(hVar, cArr);
            } else {
                bVar = hVar2.g(hVar, hVar2.d(cArr, n.VALUE_STRING));
                hVar.A0(cArr, 0, cArr.length);
            }
            hVar2.h(hVar, bVar);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            r createSchemaNode = createSchemaNode("array", true);
            r createSchemaNode2 = createSchemaNode("string");
            createSchemaNode2.C("type", "string");
            return createSchemaNode.G("items", createSchemaNode2);
        }
    }

    public static class c extends a {

        /* renamed from: c  reason: collision with root package name */
        public static final j f5740c = o.I().N(Double.TYPE);

        public c() {
            super(double[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.NUMBER);
        }

        public a4.h c(w3.h hVar) {
            return this;
        }

        public k3.o f(k3.d dVar, Boolean bool) {
            return new c(this, dVar, bool);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("number"));
        }

        /* renamed from: h */
        public boolean isEmpty(k3.c0 c0Var, double[] dArr) {
            if (dArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void serialize(double[] dArr, c3.h hVar, k3.c0 c0Var) {
            if (dArr.length != 1 || !e(c0Var)) {
                hVar.M(dArr, 0, dArr.length);
            } else {
                g(dArr, hVar, c0Var);
            }
        }

        /* renamed from: j */
        public void g(double[] dArr, c3.h hVar, k3.c0 c0Var) {
            for (double b02 : dArr) {
                hVar.b0(b02);
            }
        }

        public c(c cVar, k3.d dVar, Boolean bool) {
            super(cVar, dVar, bool);
        }
    }

    public static class d extends h {

        /* renamed from: c  reason: collision with root package name */
        public static final j f5741c = o.I().N(Float.TYPE);

        public d() {
            super(float[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.NUMBER);
        }

        public k3.o f(k3.d dVar, Boolean bool) {
            return new d(this, dVar, bool);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("number"));
        }

        /* renamed from: h */
        public boolean isEmpty(k3.c0 c0Var, float[] fArr) {
            if (fArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void serialize(float[] fArr, c3.h hVar, k3.c0 c0Var) {
            int length = fArr.length;
            if (length != 1 || !e(c0Var)) {
                hVar.u0(fArr, length);
                g(fArr, hVar, c0Var);
                hVar.V();
                return;
            }
            g(fArr, hVar, c0Var);
        }

        /* renamed from: j */
        public void g(float[] fArr, c3.h hVar, k3.c0 c0Var) {
            for (float c02 : fArr) {
                hVar.c0(c02);
            }
        }

        public d(d dVar, k3.d dVar2, Boolean bool) {
            super(dVar, dVar2, bool);
        }
    }

    public static class e extends a {

        /* renamed from: c  reason: collision with root package name */
        public static final j f5742c = o.I().N(Integer.TYPE);

        public e() {
            super(int[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.INTEGER);
        }

        public a4.h c(w3.h hVar) {
            return this;
        }

        public k3.o f(k3.d dVar, Boolean bool) {
            return new e(this, dVar, bool);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("integer"));
        }

        /* renamed from: h */
        public boolean isEmpty(k3.c0 c0Var, int[] iArr) {
            if (iArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void serialize(int[] iArr, c3.h hVar, k3.c0 c0Var) {
            if (iArr.length != 1 || !e(c0Var)) {
                hVar.N(iArr, 0, iArr.length);
            } else {
                g(iArr, hVar, c0Var);
            }
        }

        /* renamed from: j */
        public void g(int[] iArr, c3.h hVar, k3.c0 c0Var) {
            for (int d02 : iArr) {
                hVar.d0(d02);
            }
        }

        public e(e eVar, k3.d dVar, Boolean bool) {
            super(eVar, dVar, bool);
        }
    }

    public static class f extends h {

        /* renamed from: c  reason: collision with root package name */
        public static final j f5743c = o.I().N(Long.TYPE);

        public f() {
            super(long[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.NUMBER);
        }

        public k3.o f(k3.d dVar, Boolean bool) {
            return new f(this, dVar, bool);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("number", true));
        }

        /* renamed from: h */
        public boolean isEmpty(k3.c0 c0Var, long[] jArr) {
            if (jArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void serialize(long[] jArr, c3.h hVar, k3.c0 c0Var) {
            if (jArr.length != 1 || !e(c0Var)) {
                hVar.O(jArr, 0, jArr.length);
            } else {
                g(jArr, hVar, c0Var);
            }
        }

        /* renamed from: j */
        public void g(long[] jArr, c3.h hVar, k3.c0 c0Var) {
            for (long e02 : jArr) {
                hVar.e0(e02);
            }
        }

        public f(f fVar, k3.d dVar, Boolean bool) {
            super(fVar, dVar, bool);
        }
    }

    public static class g extends h {

        /* renamed from: c  reason: collision with root package name */
        public static final j f5744c = o.I().N(Short.TYPE);

        public g() {
            super(short[].class);
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            visitArrayFormat(fVar, jVar, u3.d.INTEGER);
        }

        public k3.o f(k3.d dVar, Boolean bool) {
            return new g(this, dVar, bool);
        }

        public m getSchema(k3.c0 c0Var, Type type) {
            return createSchemaNode("array", true).G("items", createSchemaNode("integer"));
        }

        /* renamed from: h */
        public boolean isEmpty(k3.c0 c0Var, short[] sArr) {
            if (sArr.length == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: i */
        public final void serialize(short[] sArr, c3.h hVar, k3.c0 c0Var) {
            int length = sArr.length;
            if (length != 1 || !e(c0Var)) {
                hVar.u0(sArr, length);
                g(sArr, hVar, c0Var);
                hVar.V();
                return;
            }
            g(sArr, hVar, c0Var);
        }

        /* renamed from: j */
        public void g(short[] sArr, c3.h hVar, k3.c0 c0Var) {
            for (short d02 : sArr) {
                hVar.d0(d02);
            }
        }

        public g(g gVar, k3.d dVar, Boolean bool) {
            super(gVar, dVar, bool);
        }
    }

    public static abstract class h extends a {
        public h(Class cls) {
            super(cls);
        }

        public final a4.h c(w3.h hVar) {
            return this;
        }

        public h(h hVar, k3.d dVar, Boolean bool) {
            super(hVar, dVar, bool);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f5738a = hashMap;
        hashMap.put(boolean[].class.getName(), new a());
        hashMap.put(byte[].class.getName(), new f());
        hashMap.put(char[].class.getName(), new b());
        hashMap.put(short[].class.getName(), new g());
        hashMap.put(int[].class.getName(), new e());
        hashMap.put(long[].class.getName(), new f());
        hashMap.put(float[].class.getName(), new d());
        hashMap.put(double[].class.getName(), new c());
    }

    public static k3.o a(Class cls) {
        return (k3.o) f5738a.get(cls.getName());
    }
}
