package com.fasterxml.jackson.databind.deser.std;

import b3.j0;
import b3.k;
import c3.j;
import c3.k;
import c3.n;
import d4.c;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import k3.l;
import n3.i;
import n3.q;
import o3.r;

public abstract class x extends b0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f5718a;

    /* renamed from: b  reason: collision with root package name */
    public transient Object f5719b;

    /* renamed from: c  reason: collision with root package name */
    public final q f5720c;

    public static final class a extends x {
        public a() {
            super(boolean[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new a(this, qVar, bool);
        }

        /* renamed from: g */
        public boolean[] a(boolean[] zArr, boolean[] zArr2) {
            int length = zArr.length;
            int length2 = zArr2.length;
            boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
            System.arraycopy(zArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public boolean[] b() {
            return new boolean[0];
        }

        /* renamed from: i */
        public boolean[] deserialize(k kVar, k3.g gVar) {
            boolean z10;
            if (!kVar.n0()) {
                return (boolean[]) d(kVar, gVar);
            }
            c.b b10 = gVar.L().b();
            boolean[] zArr = (boolean[]) b10.f();
            int i10 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (boolean[]) b10.e(zArr, i10);
                    }
                    if (s02 == n.VALUE_TRUE) {
                        z10 = true;
                    } else {
                        if (s02 != n.VALUE_FALSE) {
                            if (s02 == n.VALUE_NULL) {
                                q qVar = this.f5720c;
                                if (qVar != null) {
                                    qVar.getNullValue(gVar);
                                } else {
                                    _verifyNullForPrimitive(gVar);
                                }
                            } else {
                                z10 = _parseBooleanPrimitive(kVar, gVar);
                            }
                        }
                        z10 = false;
                    }
                    if (i10 >= zArr.length) {
                        zArr = (boolean[]) b10.c(zArr, i10);
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    try {
                        zArr[i10] = z10;
                        i10 = i11;
                    } catch (Exception e10) {
                        e = e10;
                        i10 = i11;
                        throw l.p(e, zArr, b10.d() + i10);
                    }
                } catch (Exception e11) {
                    e = e11;
                    throw l.p(e, zArr, b10.d() + i10);
                }
            }
        }

        /* renamed from: j */
        public boolean[] e(k kVar, k3.g gVar) {
            return new boolean[]{_parseBooleanPrimitive(kVar, gVar)};
        }

        public a(a aVar, q qVar, Boolean bool) {
            super(aVar, qVar, bool);
        }
    }

    public static final class b extends x {
        public b() {
            super(byte[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new b(this, qVar, bool);
        }

        /* renamed from: g */
        public byte[] a(byte[] bArr, byte[] bArr2) {
            int length = bArr.length;
            int length2 = bArr2.length;
            byte[] copyOf = Arrays.copyOf(bArr, length + length2);
            System.arraycopy(bArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public byte[] b() {
            return new byte[0];
        }

        /* renamed from: i */
        public byte[] deserialize(k kVar, k3.g gVar) {
            byte b10;
            n n10 = kVar.n();
            if (n10 == n.VALUE_STRING) {
                try {
                    return kVar.v(gVar.M());
                } catch (j e10) {
                    String c10 = e10.c();
                    if (c10.contains("base64")) {
                        return (byte[]) gVar.j0(byte[].class, kVar.Y(), c10, new Object[0]);
                    }
                }
            }
            if (n10 == n.VALUE_EMBEDDED_OBJECT) {
                Object N = kVar.N();
                if (N == null) {
                    return null;
                }
                if (N instanceof byte[]) {
                    return (byte[]) N;
                }
            }
            if (!kVar.n0()) {
                return (byte[]) d(kVar, gVar);
            }
            c.C0078c c11 = gVar.L().c();
            byte[] bArr = (byte[]) c11.f();
            int i10 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (byte[]) c11.e(bArr, i10);
                    }
                    if (s02 == n.VALUE_NUMBER_INT) {
                        b10 = kVar.x();
                    } else if (s02 == n.VALUE_NULL) {
                        q qVar = this.f5720c;
                        if (qVar != null) {
                            qVar.getNullValue(gVar);
                        } else {
                            _verifyNullForPrimitive(gVar);
                            b10 = 0;
                        }
                    } else {
                        b10 = _parseBytePrimitive(kVar, gVar);
                    }
                    if (i10 >= bArr.length) {
                        bArr = (byte[]) c11.c(bArr, i10);
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    try {
                        bArr[i10] = b10;
                        i10 = i11;
                    } catch (Exception e11) {
                        e = e11;
                        i10 = i11;
                        throw l.p(e, bArr, c11.d() + i10);
                    }
                } catch (Exception e12) {
                    e = e12;
                    throw l.p(e, bArr, c11.d() + i10);
                }
            }
        }

        /* renamed from: j */
        public byte[] e(k kVar, k3.g gVar) {
            byte b10;
            n n10 = kVar.n();
            if (n10 == n.VALUE_NUMBER_INT) {
                b10 = kVar.x();
            } else if (n10 == n.VALUE_NULL) {
                q qVar = this.f5720c;
                if (qVar != null) {
                    qVar.getNullValue(gVar);
                    return (byte[]) getEmptyValue(gVar);
                }
                _verifyNullForPrimitive(gVar);
                return null;
            } else {
                b10 = ((Number) gVar.a0(this._valueClass.getComponentType(), kVar)).byteValue();
            }
            return new byte[]{b10};
        }

        public c4.f logicalType() {
            return c4.f.Binary;
        }

        public b(b bVar, q qVar, Boolean bool) {
            super(bVar, qVar, bool);
        }
    }

    public static final class c extends x {
        public c() {
            super(char[].class);
        }

        public x f(q qVar, Boolean bool) {
            return this;
        }

        /* renamed from: g */
        public char[] a(char[] cArr, char[] cArr2) {
            int length = cArr.length;
            int length2 = cArr2.length;
            char[] copyOf = Arrays.copyOf(cArr, length + length2);
            System.arraycopy(cArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public char[] b() {
            return new char[0];
        }

        /* renamed from: i */
        public char[] deserialize(k kVar, k3.g gVar) {
            String str;
            if (kVar.j0(n.VALUE_STRING)) {
                char[] Z = kVar.Z();
                int b02 = kVar.b0();
                int a02 = kVar.a0();
                char[] cArr = new char[a02];
                System.arraycopy(Z, b02, cArr, 0, a02);
                return cArr;
            } else if (kVar.n0()) {
                StringBuilder sb = new StringBuilder(64);
                while (true) {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return sb.toString().toCharArray();
                    }
                    if (s02 == n.VALUE_STRING) {
                        str = kVar.Y();
                    } else if (s02 == n.VALUE_NULL) {
                        q qVar = this.f5720c;
                        if (qVar != null) {
                            qVar.getNullValue(gVar);
                        } else {
                            _verifyNullForPrimitive(gVar);
                            str = "\u0000";
                        }
                    } else {
                        str = ((CharSequence) gVar.a0(Character.TYPE, kVar)).toString();
                    }
                    if (str.length() != 1) {
                        gVar.z0(this, "Cannot convert a JSON String of length %d into a char element of char array", Integer.valueOf(str.length()));
                    }
                    sb.append(str.charAt(0));
                }
            } else {
                if (kVar.j0(n.VALUE_EMBEDDED_OBJECT)) {
                    Object N = kVar.N();
                    if (N == null) {
                        return null;
                    }
                    if (N instanceof char[]) {
                        return (char[]) N;
                    }
                    if (N instanceof String) {
                        return ((String) N).toCharArray();
                    }
                    if (N instanceof byte[]) {
                        return c3.b.a().i((byte[]) N, false).toCharArray();
                    }
                }
                return (char[]) gVar.a0(this._valueClass, kVar);
            }
        }

        /* renamed from: j */
        public char[] e(k kVar, k3.g gVar) {
            return (char[]) gVar.a0(this._valueClass, kVar);
        }
    }

    public static final class d extends x {
        public d() {
            super(double[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new d(this, qVar, bool);
        }

        /* renamed from: g */
        public double[] a(double[] dArr, double[] dArr2) {
            int length = dArr.length;
            int length2 = dArr2.length;
            double[] copyOf = Arrays.copyOf(dArr, length + length2);
            System.arraycopy(dArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public double[] b() {
            return new double[0];
        }

        /* renamed from: i */
        public double[] deserialize(k kVar, k3.g gVar) {
            q qVar;
            if (!kVar.n0()) {
                return (double[]) d(kVar, gVar);
            }
            c.d d10 = gVar.L().d();
            double[] dArr = (double[]) d10.f();
            int i10 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (double[]) d10.e(dArr, i10);
                    }
                    if (s02 != n.VALUE_NULL || (qVar = this.f5720c) == null) {
                        double _parseDoublePrimitive = _parseDoublePrimitive(kVar, gVar);
                        if (i10 >= dArr.length) {
                            dArr = (double[]) d10.c(dArr, i10);
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        try {
                            dArr[i10] = _parseDoublePrimitive;
                            i10 = i11;
                        } catch (Exception e10) {
                            e = e10;
                            i10 = i11;
                            throw l.p(e, dArr, d10.d() + i10);
                        }
                    } else {
                        qVar.getNullValue(gVar);
                    }
                } catch (Exception e11) {
                    e = e11;
                    throw l.p(e, dArr, d10.d() + i10);
                }
            }
        }

        /* renamed from: j */
        public double[] e(k kVar, k3.g gVar) {
            return new double[]{_parseDoublePrimitive(kVar, gVar)};
        }

        public d(d dVar, q qVar, Boolean bool) {
            super(dVar, qVar, bool);
        }
    }

    public static final class e extends x {
        public e() {
            super(float[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new e(this, qVar, bool);
        }

        /* renamed from: g */
        public float[] a(float[] fArr, float[] fArr2) {
            int length = fArr.length;
            int length2 = fArr2.length;
            float[] copyOf = Arrays.copyOf(fArr, length + length2);
            System.arraycopy(fArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public float[] b() {
            return new float[0];
        }

        /* renamed from: i */
        public float[] deserialize(k kVar, k3.g gVar) {
            q qVar;
            if (!kVar.n0()) {
                return (float[]) d(kVar, gVar);
            }
            c.e e10 = gVar.L().e();
            float[] fArr = (float[]) e10.f();
            int i10 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (float[]) e10.e(fArr, i10);
                    }
                    if (s02 != n.VALUE_NULL || (qVar = this.f5720c) == null) {
                        float _parseFloatPrimitive = _parseFloatPrimitive(kVar, gVar);
                        if (i10 >= fArr.length) {
                            fArr = (float[]) e10.c(fArr, i10);
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        try {
                            fArr[i10] = _parseFloatPrimitive;
                            i10 = i11;
                        } catch (Exception e11) {
                            e = e11;
                            i10 = i11;
                            throw l.p(e, fArr, e10.d() + i10);
                        }
                    } else {
                        qVar.getNullValue(gVar);
                    }
                } catch (Exception e12) {
                    e = e12;
                    throw l.p(e, fArr, e10.d() + i10);
                }
            }
        }

        /* renamed from: j */
        public float[] e(k kVar, k3.g gVar) {
            return new float[]{_parseFloatPrimitive(kVar, gVar)};
        }

        public e(e eVar, q qVar, Boolean bool) {
            super(eVar, qVar, bool);
        }
    }

    public static final class f extends x {

        /* renamed from: d  reason: collision with root package name */
        public static final f f5721d = new f();

        public f() {
            super(int[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new f(this, qVar, bool);
        }

        /* renamed from: g */
        public int[] a(int[] iArr, int[] iArr2) {
            int length = iArr.length;
            int length2 = iArr2.length;
            int[] copyOf = Arrays.copyOf(iArr, length + length2);
            System.arraycopy(iArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public int[] b() {
            return new int[0];
        }

        /* renamed from: i */
        public int[] deserialize(k kVar, k3.g gVar) {
            int i10;
            if (!kVar.n0()) {
                return (int[]) d(kVar, gVar);
            }
            c.f f10 = gVar.L().f();
            int[] iArr = (int[]) f10.f();
            int i11 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (int[]) f10.e(iArr, i11);
                    }
                    if (s02 == n.VALUE_NUMBER_INT) {
                        i10 = kVar.P();
                    } else if (s02 == n.VALUE_NULL) {
                        q qVar = this.f5720c;
                        if (qVar != null) {
                            qVar.getNullValue(gVar);
                        } else {
                            _verifyNullForPrimitive(gVar);
                            i10 = 0;
                        }
                    } else {
                        i10 = _parseIntPrimitive(kVar, gVar);
                    }
                    if (i11 >= iArr.length) {
                        iArr = (int[]) f10.c(iArr, i11);
                        i11 = 0;
                    }
                    int i12 = i11 + 1;
                    try {
                        iArr[i11] = i10;
                        i11 = i12;
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i12;
                        throw l.p(e, iArr, f10.d() + i11);
                    }
                } catch (Exception e11) {
                    e = e11;
                    throw l.p(e, iArr, f10.d() + i11);
                }
            }
        }

        /* renamed from: j */
        public int[] e(k kVar, k3.g gVar) {
            return new int[]{_parseIntPrimitive(kVar, gVar)};
        }

        public f(f fVar, q qVar, Boolean bool) {
            super(fVar, qVar, bool);
        }
    }

    public static final class g extends x {

        /* renamed from: d  reason: collision with root package name */
        public static final g f5722d = new g();

        public g() {
            super(long[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new g(this, qVar, bool);
        }

        /* renamed from: g */
        public long[] a(long[] jArr, long[] jArr2) {
            int length = jArr.length;
            int length2 = jArr2.length;
            long[] copyOf = Arrays.copyOf(jArr, length + length2);
            System.arraycopy(jArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public long[] b() {
            return new long[0];
        }

        /* renamed from: i */
        public long[] deserialize(k kVar, k3.g gVar) {
            long j10;
            if (!kVar.n0()) {
                return (long[]) d(kVar, gVar);
            }
            c.g g10 = gVar.L().g();
            long[] jArr = (long[]) g10.f();
            int i10 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (long[]) g10.e(jArr, i10);
                    }
                    if (s02 == n.VALUE_NUMBER_INT) {
                        j10 = kVar.Q();
                    } else if (s02 == n.VALUE_NULL) {
                        q qVar = this.f5720c;
                        if (qVar != null) {
                            qVar.getNullValue(gVar);
                        } else {
                            _verifyNullForPrimitive(gVar);
                            j10 = 0;
                        }
                    } else {
                        j10 = _parseLongPrimitive(kVar, gVar);
                    }
                    if (i10 >= jArr.length) {
                        jArr = (long[]) g10.c(jArr, i10);
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    try {
                        jArr[i10] = j10;
                        i10 = i11;
                    } catch (Exception e10) {
                        e = e10;
                        i10 = i11;
                        throw l.p(e, jArr, g10.d() + i10);
                    }
                } catch (Exception e11) {
                    e = e11;
                    throw l.p(e, jArr, g10.d() + i10);
                }
            }
        }

        /* renamed from: j */
        public long[] e(k kVar, k3.g gVar) {
            return new long[]{_parseLongPrimitive(kVar, gVar)};
        }

        public g(g gVar, q qVar, Boolean bool) {
            super(gVar, qVar, bool);
        }
    }

    public static final class h extends x {
        public h() {
            super(short[].class);
        }

        public x f(q qVar, Boolean bool) {
            return new h(this, qVar, bool);
        }

        /* renamed from: g */
        public short[] a(short[] sArr, short[] sArr2) {
            int length = sArr.length;
            int length2 = sArr2.length;
            short[] copyOf = Arrays.copyOf(sArr, length + length2);
            System.arraycopy(sArr2, 0, copyOf, length, length2);
            return copyOf;
        }

        /* renamed from: h */
        public short[] b() {
            return new short[0];
        }

        /* renamed from: i */
        public short[] deserialize(k kVar, k3.g gVar) {
            short s10;
            if (!kVar.n0()) {
                return (short[]) d(kVar, gVar);
            }
            c.h h10 = gVar.L().h();
            short[] sArr = (short[]) h10.f();
            int i10 = 0;
            while (true) {
                try {
                    n s02 = kVar.s0();
                    if (s02 == n.END_ARRAY) {
                        return (short[]) h10.e(sArr, i10);
                    }
                    if (s02 == n.VALUE_NULL) {
                        q qVar = this.f5720c;
                        if (qVar != null) {
                            qVar.getNullValue(gVar);
                        } else {
                            _verifyNullForPrimitive(gVar);
                            s10 = 0;
                        }
                    } else {
                        s10 = _parseShortPrimitive(kVar, gVar);
                    }
                    if (i10 >= sArr.length) {
                        sArr = (short[]) h10.c(sArr, i10);
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    try {
                        sArr[i10] = s10;
                        i10 = i11;
                    } catch (Exception e10) {
                        e = e10;
                        i10 = i11;
                        throw l.p(e, sArr, h10.d() + i10);
                    }
                } catch (Exception e11) {
                    e = e11;
                    throw l.p(e, sArr, h10.d() + i10);
                }
            }
        }

        /* renamed from: j */
        public short[] e(k kVar, k3.g gVar) {
            return new short[]{_parseShortPrimitive(kVar, gVar)};
        }

        public h(h hVar, q qVar, Boolean bool) {
            super(hVar, qVar, bool);
        }
    }

    public x(Class cls) {
        super(cls);
        this.f5718a = null;
        this.f5720c = null;
    }

    public static k3.k c(Class cls) {
        if (cls == Integer.TYPE) {
            return f.f5721d;
        }
        if (cls == Long.TYPE) {
            return g.f5722d;
        }
        if (cls == Byte.TYPE) {
            return new b();
        }
        if (cls == Short.TYPE) {
            return new h();
        }
        if (cls == Float.TYPE) {
            return new e();
        }
        if (cls == Double.TYPE) {
            return new d();
        }
        if (cls == Boolean.TYPE) {
            return new a();
        }
        if (cls == Character.TYPE) {
            return new c();
        }
        throw new IllegalStateException();
    }

    public abstract Object a(Object obj, Object obj2);

    public abstract Object b();

    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        q qVar;
        Boolean findFormatFeature = findFormatFeature(gVar, dVar, this._valueClass, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        j0 findContentNullStyle = findContentNullStyle(gVar, dVar);
        if (findContentNullStyle == j0.SKIP) {
            qVar = o3.q.d();
        } else if (findContentNullStyle != j0.FAIL) {
            qVar = null;
        } else if (dVar == null) {
            qVar = r.c(gVar.x(this._valueClass.getComponentType()));
        } else {
            qVar = r.b(dVar, dVar.getType().k());
        }
        if (!Objects.equals(findFormatFeature, this.f5718a) || qVar != this.f5720c) {
            return f(qVar, findFormatFeature);
        }
        return this;
    }

    public Object d(c3.k kVar, k3.g gVar) {
        boolean z10;
        if (kVar.j0(n.VALUE_STRING)) {
            return _deserializeFromString(kVar, gVar);
        }
        Boolean bool = this.f5718a;
        if (bool == Boolean.TRUE || (bool == null && gVar.n0(k3.h.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return e(kVar, gVar);
        }
        return gVar.a0(this._valueClass, kVar);
    }

    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        Object deserialize = deserialize(kVar, gVar);
        if (obj == null || Array.getLength(obj) == 0) {
            return deserialize;
        }
        return a(obj, deserialize);
    }

    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.d(kVar, gVar);
    }

    public abstract Object e(c3.k kVar, k3.g gVar);

    public abstract x f(q qVar, Boolean bool);

    public d4.a getEmptyAccessPattern() {
        return d4.a.CONSTANT;
    }

    public Object getEmptyValue(k3.g gVar) {
        Object obj = this.f5719b;
        if (obj != null) {
            return obj;
        }
        Object b10 = b();
        this.f5719b = b10;
        return b10;
    }

    public c4.f logicalType() {
        return c4.f.Array;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.TRUE;
    }

    public x(x xVar, q qVar, Boolean bool) {
        super((Class) xVar._valueClass);
        this.f5718a = bool;
        this.f5720c = qVar;
    }
}
