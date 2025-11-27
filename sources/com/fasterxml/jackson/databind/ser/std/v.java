package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.k;
import c3.h;
import c3.k;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;
import k3.d;
import k3.j;
import k3.m;
import k3.o;
import u3.f;

public class v extends h0 implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final v f5805b = new v(Number.class);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5806a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5807a;

        static {
            int[] iArr = new int[k.c.values().length];
            f5807a = iArr;
            try {
                iArr[k.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static final class b extends m0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f5808a = new b();

        public b() {
            super(BigDecimal.class);
        }

        public String c(Object obj) {
            throw new IllegalStateException();
        }

        public boolean d(h hVar, BigDecimal bigDecimal) {
            int scale = bigDecimal.scale();
            if (scale < -9999 || scale > 9999) {
                return false;
            }
            return true;
        }

        public boolean isEmpty(c0 c0Var, Object obj) {
            return false;
        }

        public void serialize(Object obj, h hVar, c0 c0Var) {
            String str;
            if (hVar.v(h.b.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                if (!d(hVar, bigDecimal)) {
                    c0Var.r0(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", new Object[]{Integer.valueOf(bigDecimal.scale()), 9999, 9999}), new Object[0]);
                }
                str = bigDecimal.toPlainString();
            } else {
                str = obj.toString();
            }
            hVar.z0(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(Class cls) {
        super(cls, false);
        boolean z10 = false;
        this.f5806a = cls == BigInteger.class ? true : z10;
    }

    public static o c() {
        return b.f5808a;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        if (this.f5806a) {
            visitIntFormat(fVar, jVar, k.b.BIG_INTEGER);
        } else if (handledType() == BigDecimal.class) {
            visitFloatFormat(fVar, jVar, k.b.BIG_DECIMAL);
        } else {
            fVar.h(jVar);
        }
    }

    public o b(c0 c0Var, d dVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides == null || a.f5807a[findFormatOverrides.i().ordinal()] != 1) {
            return this;
        }
        if (handledType() == BigDecimal.class) {
            return c();
        }
        return l0.f5771a;
    }

    /* renamed from: d */
    public void serialize(Number number, h hVar, c0 c0Var) {
        if (number instanceof BigDecimal) {
            hVar.g0((BigDecimal) number);
        } else if (number instanceof BigInteger) {
            hVar.h0((BigInteger) number);
        } else if (number instanceof Long) {
            hVar.e0(number.longValue());
        } else if (number instanceof Double) {
            hVar.b0(number.doubleValue());
        } else if (number instanceof Float) {
            hVar.c0(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            hVar.d0(number.intValue());
        } else {
            hVar.f0(number.toString());
        }
    }

    public m getSchema(c0 c0Var, Type type) {
        String str;
        if (this.f5806a) {
            str = "integer";
        } else {
            str = "number";
        }
        return createSchemaNode(str, true);
    }
}
