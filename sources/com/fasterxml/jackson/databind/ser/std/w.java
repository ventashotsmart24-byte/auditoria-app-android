package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.k;
import c3.k;
import c3.n;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;
import k3.c0;
import k3.j;
import k3.m;
import k3.o;

public abstract class w {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5809a;

        static {
            int[] iArr = new int[k.c.values().length];
            f5809a = iArr;
            try {
                iArr[k.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static abstract class b extends h0 implements i {

        /* renamed from: a  reason: collision with root package name */
        public final k.b f5810a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5811b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5812c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Class cls, k.b bVar, String str) {
            super(cls, false);
            boolean z10 = false;
            this.f5810a = bVar;
            this.f5811b = str;
            this.f5812c = (bVar == k.b.INT || bVar == k.b.LONG || bVar == k.b.BIG_INTEGER) ? true : z10;
        }

        public void acceptJsonFormatVisitor(u3.f fVar, j jVar) {
            if (this.f5812c) {
                visitIntFormat(fVar, jVar, this.f5810a);
            } else {
                visitFloatFormat(fVar, jVar, this.f5810a);
            }
        }

        public o b(c0 c0Var, k3.d dVar) {
            k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
            if (findFormatOverrides == null || a.f5809a[findFormatOverrides.i().ordinal()] != 1) {
                return this;
            }
            if (handledType() == BigDecimal.class) {
                return v.c();
            }
            return l0.f5771a;
        }

        public m getSchema(c0 c0Var, Type type) {
            return createSchemaNode(this.f5811b, true);
        }
    }

    public static class c extends b {
        public c(Class cls) {
            super(cls, k.b.DOUBLE, "number");
        }

        public static boolean c(double d10) {
            if (Double.isNaN(d10) || Double.isInfinite(d10)) {
                return true;
            }
            return false;
        }

        public void serialize(Object obj, c3.h hVar, c0 c0Var) {
            hVar.b0(((Double) obj).doubleValue());
        }

        public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
            Double d10 = (Double) obj;
            if (c(d10.doubleValue())) {
                i3.b g10 = hVar2.g(hVar, hVar2.d(obj, n.VALUE_NUMBER_FLOAT));
                hVar.b0(d10.doubleValue());
                hVar2.h(hVar, g10);
                return;
            }
            hVar.b0(d10.doubleValue());
        }
    }

    public static class d extends b {

        /* renamed from: d  reason: collision with root package name */
        public static final d f5813d = new d();

        public d() {
            super(Float.class, k.b.FLOAT, "number");
        }

        public void serialize(Object obj, c3.h hVar, c0 c0Var) {
            hVar.c0(((Float) obj).floatValue());
        }
    }

    public static class e extends b {

        /* renamed from: d  reason: collision with root package name */
        public static final e f5814d = new e();

        public e() {
            super(Number.class, k.b.INT, "integer");
        }

        public void serialize(Object obj, c3.h hVar, c0 c0Var) {
            hVar.d0(((Number) obj).intValue());
        }
    }

    public static class f extends b {
        public f(Class cls) {
            super(cls, k.b.INT, "integer");
        }

        public void serialize(Object obj, c3.h hVar, c0 c0Var) {
            hVar.d0(((Integer) obj).intValue());
        }

        public void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
            serialize(obj, hVar, c0Var);
        }
    }

    public static class g extends b {
        public g(Class cls) {
            super(cls, k.b.LONG, "number");
        }

        public void serialize(Object obj, c3.h hVar, c0 c0Var) {
            hVar.e0(((Long) obj).longValue());
        }
    }

    public static class h extends b {

        /* renamed from: d  reason: collision with root package name */
        public static final h f5815d = new h();

        public h() {
            super(Short.class, k.b.INT, "number");
        }

        public void serialize(Object obj, c3.h hVar, c0 c0Var) {
            hVar.i0(((Short) obj).shortValue());
        }
    }

    public static void a(Map map) {
        Class<Integer> cls = Integer.class;
        map.put(cls.getName(), new f(cls));
        Class cls2 = Integer.TYPE;
        map.put(cls2.getName(), new f(cls2));
        Class<Long> cls3 = Long.class;
        map.put(cls3.getName(), new g(cls3));
        Class cls4 = Long.TYPE;
        map.put(cls4.getName(), new g(cls4));
        String name = Byte.class.getName();
        e eVar = e.f5814d;
        map.put(name, eVar);
        map.put(Byte.TYPE.getName(), eVar);
        String name2 = Short.class.getName();
        h hVar = h.f5815d;
        map.put(name2, hVar);
        map.put(Short.TYPE.getName(), hVar);
        Class<Double> cls5 = Double.class;
        map.put(cls5.getName(), new c(cls5));
        map.put(Double.TYPE.getName(), new c(Double.TYPE));
        String name3 = Float.class.getName();
        d dVar = d.f5813d;
        map.put(name3, dVar);
        map.put(Float.TYPE.getName(), dVar);
    }
}
