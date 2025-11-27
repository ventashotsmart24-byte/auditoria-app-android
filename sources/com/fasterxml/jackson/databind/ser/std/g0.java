package com.fasterxml.jackson.databind.ser.std;

import b4.k;
import c3.h;
import d4.l;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import k3.a0;
import k3.b0;
import k3.c0;
import k3.j;
import k3.o;
import u3.f;

public abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final o f5761a = new f0();

    /* renamed from: b  reason: collision with root package name */
    public static final o f5762b = new d();

    public static class a extends i0 {

        /* renamed from: a  reason: collision with root package name */
        public final int f5763a;

        public a(int i10, Class cls) {
            super(cls, false);
            this.f5763a = i10;
        }

        public void serialize(Object obj, h hVar, c0 c0Var) {
            String str;
            switch (this.f5763a) {
                case 1:
                    c0Var.C((Date) obj, hVar);
                    return;
                case 2:
                    c0Var.B(((Calendar) obj).getTimeInMillis(), hVar);
                    return;
                case 3:
                    hVar.Z(((Class) obj).getName());
                    return;
                case 4:
                    if (c0Var.m0(b0.WRITE_ENUMS_USING_TO_STRING)) {
                        str = obj.toString();
                    } else {
                        Enum enumR = (Enum) obj;
                        if (c0Var.m0(b0.WRITE_ENUM_KEYS_USING_INDEX)) {
                            str = String.valueOf(enumR.ordinal());
                        } else {
                            str = enumR.name();
                        }
                    }
                    hVar.Z(str);
                    return;
                case 5:
                case 6:
                    hVar.X(((Number) obj).longValue());
                    return;
                case 7:
                    hVar.Z(c0Var.k().h().h((byte[]) obj));
                    return;
                default:
                    hVar.Z(obj.toString());
                    return;
            }
        }
    }

    public static class b extends i0 {

        /* renamed from: a  reason: collision with root package name */
        public transient k f5764a = k.c();

        public b() {
            super(String.class, false);
        }

        public void acceptJsonFormatVisitor(f fVar, j jVar) {
            visitStringFormat(fVar, jVar);
        }

        public o c(k kVar, Class cls, c0 c0Var) {
            if (cls == Object.class) {
                a aVar = new a(8, cls);
                this.f5764a = kVar.i(cls, aVar);
                return aVar;
            }
            k.d d10 = kVar.d(cls, c0Var, (k3.d) null);
            k kVar2 = d10.f4357b;
            if (kVar != kVar2) {
                this.f5764a = kVar2;
            }
            return d10.f4356a;
        }

        public void serialize(Object obj, h hVar, c0 c0Var) {
            Class<?> cls = obj.getClass();
            k kVar = this.f5764a;
            o j10 = kVar.j(cls);
            if (j10 == null) {
                j10 = c(kVar, cls, c0Var);
            }
            j10.serialize(obj, hVar, c0Var);
        }
    }

    public static class c extends i0 {

        /* renamed from: a  reason: collision with root package name */
        public final l f5765a;

        public c(Class cls, l lVar) {
            super(cls, false);
            this.f5765a = lVar;
        }

        public static c c(Class cls, l lVar) {
            return new c(cls, lVar);
        }

        public void serialize(Object obj, h hVar, c0 c0Var) {
            if (c0Var.m0(b0.WRITE_ENUMS_USING_TO_STRING)) {
                hVar.Z(obj.toString());
                return;
            }
            Enum enumR = (Enum) obj;
            if (c0Var.m0(b0.WRITE_ENUM_KEYS_USING_INDEX)) {
                hVar.Z(String.valueOf(enumR.ordinal()));
            } else {
                hVar.Y(this.f5765a.d(enumR));
            }
        }
    }

    public static class d extends i0 {
        public d() {
            super(String.class, false);
        }

        public void serialize(Object obj, h hVar, c0 c0Var) {
            hVar.Z((String) obj);
        }
    }

    public static o a(a0 a0Var, Class cls) {
        if (cls != null) {
            if (cls == Enum.class) {
                return new b();
            }
            if (d4.h.L(cls)) {
                return c.c(cls, l.b(a0Var, cls));
            }
        }
        return new a(8, cls);
    }

    public static o b(a0 a0Var, Class<byte[]> cls, boolean z10) {
        if (cls == null || cls == Object.class) {
            return new b();
        }
        if (cls == String.class) {
            return f5762b;
        }
        if (cls.isPrimitive()) {
            cls = d4.h.o0(cls);
        }
        if (cls == Integer.class) {
            return new a(5, cls);
        }
        if (cls == Long.class) {
            return new a(6, cls);
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
            return new a(8, cls);
        }
        if (cls == Class.class) {
            return new a(3, cls);
        }
        if (Date.class.isAssignableFrom(cls)) {
            return new a(1, cls);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            return new a(2, cls);
        }
        if (cls == UUID.class) {
            return new a(8, cls);
        }
        if (cls == byte[].class) {
            return new a(7, cls);
        }
        if (z10) {
            return new a(8, cls);
        }
        return null;
    }
}
