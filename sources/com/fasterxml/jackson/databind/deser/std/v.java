package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet f5688a = new HashSet();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5689a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                m3.b[] r0 = m3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5689a = r0
                m3.b r1 = m3.b.Fail     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5689a     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.b r1 = m3.b.AsNull     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5689a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.b r1 = m3.b.AsEmpty     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.v.a.<clinit>():void");
        }
    }

    public static class b extends e0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f5690a = new b();

        public b() {
            super(BigDecimal.class);
        }

        /* renamed from: a */
        public BigDecimal deserialize(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (BigDecimal) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return kVar.L();
                } else {
                    return (BigDecimal) gVar.c0(getValueType(gVar), kVar);
                }
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (BigDecimal) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (BigDecimal) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_hasTextualNull(trim)) {
                return (BigDecimal) getNullValue(gVar);
            }
            try {
                return new BigDecimal(trim);
            } catch (IllegalArgumentException unused) {
                return (BigDecimal) gVar.j0(this._valueClass, trim, "not a valid representation", new Object[0]);
            }
        }

        public Object getEmptyValue(k3.g gVar) {
            return BigDecimal.ZERO;
        }

        public final c4.f logicalType() {
            return c4.f.Float;
        }
    }

    public static class c extends e0 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f5691a = new c();

        public c() {
            super(BigInteger.class);
        }

        /* renamed from: a */
        public BigInteger deserialize(c3.k kVar, k3.g gVar) {
            String str;
            if (kVar.m0()) {
                return kVar.s();
            }
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (BigInteger) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 != 8) {
                    return (BigInteger) gVar.c0(getValueType(gVar), kVar);
                } else {
                    m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, this._valueClass);
                    if (_checkFloatToIntCoercion == m3.b.AsNull) {
                        return (BigInteger) getNullValue(gVar);
                    }
                    if (_checkFloatToIntCoercion == m3.b.AsEmpty) {
                        return (BigInteger) getEmptyValue(gVar);
                    }
                    return kVar.L().toBigInteger();
                }
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (BigInteger) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (BigInteger) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_hasTextualNull(trim)) {
                return (BigInteger) getNullValue(gVar);
            }
            try {
                return new BigInteger(trim);
            } catch (IllegalArgumentException unused) {
                return (BigInteger) gVar.j0(this._valueClass, trim, "not a valid representation", new Object[0]);
            }
        }

        public Object getEmptyValue(k3.g gVar) {
            return BigInteger.ZERO;
        }

        public final c4.f logicalType() {
            return c4.f.Integer;
        }
    }

    public static final class d extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final d f5692e = new d(Boolean.TYPE, Boolean.FALSE);

        /* renamed from: f  reason: collision with root package name */
        public static final d f5693f = new d(Boolean.class, (Boolean) null);

        public d(Class cls, Boolean bool) {
            super(cls, c4.f.Boolean, bool, Boolean.FALSE);
        }

        /* renamed from: a */
        public Boolean deserialize(c3.k kVar, k3.g gVar) {
            n n10 = kVar.n();
            if (n10 == n.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (n10 == n.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (this.f5710d) {
                return Boolean.valueOf(_parseBooleanPrimitive(kVar, gVar));
            }
            return _parseBoolean(kVar, gVar, this._valueClass);
        }

        /* renamed from: b */
        public Boolean deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            n n10 = kVar.n();
            if (n10 == n.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (n10 == n.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (this.f5710d) {
                return Boolean.valueOf(_parseBooleanPrimitive(kVar, gVar));
            }
            return _parseBoolean(kVar, gVar, this._valueClass);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class e extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final e f5694e = new e(Byte.TYPE, (byte) 0);

        /* renamed from: f  reason: collision with root package name */
        public static final e f5695f = new e(Byte.class, (Byte) null);

        public e(Class cls, Byte b10) {
            super(cls, c4.f.Integer, b10, (byte) 0);
        }

        public Byte a(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (Byte) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 11) {
                    return (Byte) getNullValue(gVar);
                }
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7) {
                    return Byte.valueOf(kVar.x());
                } else {
                    if (q10 != 8) {
                        return (Byte) gVar.c0(getValueType(gVar), kVar);
                    }
                    m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, this._valueClass);
                    if (_checkFloatToIntCoercion == m3.b.AsNull) {
                        return (Byte) getNullValue(gVar);
                    }
                    if (_checkFloatToIntCoercion == m3.b.AsEmpty) {
                        return (Byte) getEmptyValue(gVar);
                    }
                    return Byte.valueOf(kVar.x());
                }
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Byte) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Byte) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Byte) getNullValue(gVar);
            }
            try {
                int j10 = f3.f.j(trim);
                if (_byteOverflow(j10)) {
                    return (Byte) gVar.j0(this._valueClass, trim, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                }
                return Byte.valueOf((byte) j10);
            } catch (IllegalArgumentException unused) {
                return (Byte) gVar.j0(this._valueClass, trim, "not a valid Byte value", new Object[0]);
            }
        }

        /* renamed from: b */
        public Byte deserialize(c3.k kVar, k3.g gVar) {
            if (kVar.m0()) {
                return Byte.valueOf(kVar.x());
            }
            if (this.f5710d) {
                return Byte.valueOf(_parseBytePrimitive(kVar, gVar));
            }
            return a(kVar, gVar);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class f extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final f f5696e = new f(Character.TYPE, 0);

        /* renamed from: f  reason: collision with root package name */
        public static final f f5697f = new f(Character.class, (Character) null);

        public f(Class cls, Character ch) {
            super(cls, c4.f.Integer, ch, 0);
        }

        /* renamed from: a */
        public Character deserialize(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (Character) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 11) {
                    if (this.f5710d) {
                        _verifyNullForPrimitive(gVar);
                    }
                    return (Character) getNullValue(gVar);
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 != 7) {
                    return (Character) gVar.c0(getValueType(gVar), kVar);
                } else {
                    m3.b B = gVar.B(logicalType(), this._valueClass, m3.e.Integer);
                    int i10 = a.f5689a[B.ordinal()];
                    if (i10 == 1) {
                        Class<?> cls = this._valueClass;
                        Number S = kVar.S();
                        _checkCoercionFail(gVar, B, cls, S, "Integer value (" + kVar.Y() + ")");
                    } else if (i10 != 2) {
                        if (i10 == 3) {
                            return (Character) getEmptyValue(gVar);
                        }
                        int P = kVar.P();
                        if (P < 0 || P > 65535) {
                            return (Character) gVar.i0(handledType(), Integer.valueOf(P), "value outside valid Character range (0x0000 - 0xFFFF)", new Object[0]);
                        }
                        return Character.valueOf((char) P);
                    }
                    return (Character) getNullValue(gVar);
                }
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Character) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Character) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Character) getNullValue(gVar);
            }
            return (Character) gVar.j0(handledType(), trim, "Expected either Integer value code or 1-character String", new Object[0]);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class g extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final g f5698e = new g(Double.TYPE, Double.valueOf(0.0d));

        /* renamed from: f  reason: collision with root package name */
        public static final g f5699f = new g(Double.class, (Double) null);

        public g(Class cls, Double d10) {
            super(cls, c4.f.Float, d10, Double.valueOf(0.0d));
        }

        public final Double a(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (Double) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 11) {
                    return (Double) getNullValue(gVar);
                }
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return Double.valueOf(kVar.M());
                } else {
                    return (Double) gVar.c0(getValueType(gVar), kVar);
                }
            }
            Double _checkDoubleSpecialValue = _checkDoubleSpecialValue(str);
            if (_checkDoubleSpecialValue != null) {
                return _checkDoubleSpecialValue;
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Double) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Double) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Double) getNullValue(gVar);
            }
            try {
                return Double.valueOf(b0._parseDouble(trim));
            } catch (IllegalArgumentException unused) {
                return (Double) gVar.j0(this._valueClass, trim, "not a valid `Double` value", new Object[0]);
            }
        }

        /* renamed from: b */
        public Double deserialize(c3.k kVar, k3.g gVar) {
            if (kVar.j0(n.VALUE_NUMBER_FLOAT)) {
                return Double.valueOf(kVar.M());
            }
            if (this.f5710d) {
                return Double.valueOf(_parseDoublePrimitive(kVar, gVar));
            }
            return a(kVar, gVar);
        }

        /* renamed from: c */
        public Double deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            if (kVar.j0(n.VALUE_NUMBER_FLOAT)) {
                return Double.valueOf(kVar.M());
            }
            if (this.f5710d) {
                return Double.valueOf(_parseDoublePrimitive(kVar, gVar));
            }
            return a(kVar, gVar);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static class h extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final h f5700e = new h(Float.TYPE, Float.valueOf(0.0f));

        /* renamed from: f  reason: collision with root package name */
        public static final h f5701f = new h(Float.class, (Float) null);

        public h(Class cls, Float f10) {
            super(cls, c4.f.Float, f10, Float.valueOf(0.0f));
        }

        public final Float a(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (Float) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 11) {
                    return (Float) getNullValue(gVar);
                }
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return Float.valueOf(kVar.O());
                } else {
                    return (Float) gVar.c0(getValueType(gVar), kVar);
                }
            }
            Float _checkFloatSpecialValue = _checkFloatSpecialValue(str);
            if (_checkFloatSpecialValue != null) {
                return _checkFloatSpecialValue;
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Float) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Float) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Float) getNullValue(gVar);
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException unused) {
                return (Float) gVar.j0(this._valueClass, trim, "not a valid `Float` value", new Object[0]);
            }
        }

        /* renamed from: b */
        public Float deserialize(c3.k kVar, k3.g gVar) {
            if (kVar.j0(n.VALUE_NUMBER_FLOAT)) {
                return Float.valueOf(kVar.O());
            }
            if (this.f5710d) {
                return Float.valueOf(_parseFloatPrimitive(kVar, gVar));
            }
            return a(kVar, gVar);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    public static final class i extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final i f5702e = new i(Integer.TYPE, 0);

        /* renamed from: f  reason: collision with root package name */
        public static final i f5703f = new i(Integer.class, (Integer) null);

        public i(Class cls, Integer num) {
            super(cls, c4.f.Integer, num, 0);
        }

        /* renamed from: a */
        public Integer deserialize(c3.k kVar, k3.g gVar) {
            if (kVar.m0()) {
                return Integer.valueOf(kVar.P());
            }
            if (this.f5710d) {
                return Integer.valueOf(_parseIntPrimitive(kVar, gVar));
            }
            return _parseInteger(kVar, gVar, Integer.class);
        }

        /* renamed from: b */
        public Integer deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            if (kVar.m0()) {
                return Integer.valueOf(kVar.P());
            }
            if (this.f5710d) {
                return Integer.valueOf(_parseIntPrimitive(kVar, gVar));
            }
            return _parseInteger(kVar, gVar, Integer.class);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public boolean isCachable() {
            return true;
        }
    }

    public static final class j extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final j f5704e = new j(Long.TYPE, 0L);

        /* renamed from: f  reason: collision with root package name */
        public static final j f5705f = new j(Long.class, (Long) null);

        public j(Class cls, Long l10) {
            super(cls, c4.f.Integer, l10, 0L);
        }

        /* renamed from: a */
        public Long deserialize(c3.k kVar, k3.g gVar) {
            if (kVar.m0()) {
                return Long.valueOf(kVar.Q());
            }
            if (this.f5710d) {
                return Long.valueOf(_parseLongPrimitive(kVar, gVar));
            }
            return _parseLong(kVar, gVar, Long.class);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }

        public boolean isCachable() {
            return true;
        }
    }

    public static class k extends e0 {

        /* renamed from: a  reason: collision with root package name */
        public static final k f5706a = new k();

        public k() {
            super(Number.class);
        }

        public Object deserialize(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 != 7) {
                    if (q10 != 8) {
                        return gVar.c0(getValueType(gVar), kVar);
                    }
                    if (!gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) || kVar.p0()) {
                        return kVar.S();
                    }
                    return kVar.L();
                } else if (gVar.k0(b0.F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(kVar, gVar);
                } else {
                    return kVar.S();
                }
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_hasTextualNull(trim)) {
                return getNullValue(gVar);
            }
            if (_isPosInf(trim)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            if (_isNegInf(trim)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            if (_isNaN(trim)) {
                return Double.valueOf(Double.NaN);
            }
            try {
                if (!_isIntNumber(trim)) {
                    if (gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return new BigDecimal(trim);
                    }
                    return Double.valueOf(trim);
                } else if (gVar.n0(k3.h.USE_BIG_INTEGER_FOR_INTS)) {
                    return new BigInteger(trim);
                } else {
                    long parseLong = Long.parseLong(trim);
                    if (gVar.n0(k3.h.USE_LONG_FOR_INTS) || parseLong > TTL.MAX_VALUE || parseLong < -2147483648L) {
                        return Long.valueOf(parseLong);
                    }
                    return Integer.valueOf((int) parseLong);
                }
            } catch (IllegalArgumentException unused) {
                return gVar.j0(this._valueClass, trim, "not a valid number", new Object[0]);
            }
        }

        public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
            int q10 = kVar.q();
            if (q10 == 6 || q10 == 7 || q10 == 8) {
                return deserialize(kVar, gVar);
            }
            return eVar.f(kVar, gVar);
        }

        public final c4.f logicalType() {
            return c4.f.Integer;
        }
    }

    public static abstract class l extends e0 {

        /* renamed from: a  reason: collision with root package name */
        public final c4.f f5707a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f5708b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f5709c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5710d;

        public l(Class cls, c4.f fVar, Object obj, Object obj2) {
            super(cls);
            this.f5707a = fVar;
            this.f5708b = obj;
            this.f5709c = obj2;
            this.f5710d = cls.isPrimitive();
        }

        public Object getEmptyValue(k3.g gVar) {
            return this.f5709c;
        }

        public d4.a getNullAccessPattern() {
            if (this.f5710d) {
                return d4.a.DYNAMIC;
            }
            if (this.f5708b == null) {
                return d4.a.ALWAYS_NULL;
            }
            return d4.a.CONSTANT;
        }

        public final Object getNullValue(k3.g gVar) {
            if (this.f5710d && gVar.n0(k3.h.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                gVar.z0(this, "Cannot map `null` into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", d4.h.h(handledType()));
            }
            return this.f5708b;
        }

        public final c4.f logicalType() {
            return this.f5707a;
        }
    }

    public static class m extends l {

        /* renamed from: e  reason: collision with root package name */
        public static final m f5711e = new m(Short.TYPE, 0);

        /* renamed from: f  reason: collision with root package name */
        public static final m f5712f = new m(Short.class, (Short) null);

        public m(Class cls, Short sh) {
            super(cls, c4.f.Integer, sh, (short) 0);
        }

        public Short a(c3.k kVar, k3.g gVar) {
            String str;
            int q10 = kVar.q();
            if (q10 == 1) {
                str = gVar.z(kVar, this, this._valueClass);
            } else if (q10 == 3) {
                return (Short) _deserializeFromArray(kVar, gVar);
            } else {
                if (q10 == 11) {
                    return (Short) getNullValue(gVar);
                }
                if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7) {
                    return Short.valueOf(kVar.X());
                } else {
                    if (q10 != 8) {
                        return (Short) gVar.c0(getValueType(gVar), kVar);
                    }
                    m3.b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, this._valueClass);
                    if (_checkFloatToIntCoercion == m3.b.AsNull) {
                        return (Short) getNullValue(gVar);
                    }
                    if (_checkFloatToIntCoercion == m3.b.AsEmpty) {
                        return (Short) getEmptyValue(gVar);
                    }
                    return Short.valueOf(kVar.X());
                }
            }
            m3.b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
            if (_checkFromStringCoercion == m3.b.AsNull) {
                return (Short) getNullValue(gVar);
            }
            if (_checkFromStringCoercion == m3.b.AsEmpty) {
                return (Short) getEmptyValue(gVar);
            }
            String trim = str.trim();
            if (_checkTextualNull(gVar, trim)) {
                return (Short) getNullValue(gVar);
            }
            try {
                int j10 = f3.f.j(trim);
                if (_shortOverflow(j10)) {
                    return (Short) gVar.j0(this._valueClass, trim, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                }
                return Short.valueOf((short) j10);
            } catch (IllegalArgumentException unused) {
                return (Short) gVar.j0(this._valueClass, trim, "not a valid Short value", new Object[0]);
            }
        }

        /* renamed from: b */
        public Short deserialize(c3.k kVar, k3.g gVar) {
            if (kVar.m0()) {
                return Short.valueOf(kVar.X());
            }
            if (this.f5710d) {
                return Short.valueOf(_parseShortPrimitive(kVar, gVar));
            }
            return a(kVar, gVar);
        }

        public /* bridge */ /* synthetic */ Object getEmptyValue(k3.g gVar) {
            return super.getEmptyValue(gVar);
        }

        public /* bridge */ /* synthetic */ d4.a getNullAccessPattern() {
            return super.getNullAccessPattern();
        }
    }

    static {
        Class[] clsArr = {Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, Number.class, BigDecimal.class, BigInteger.class};
        for (int i10 = 0; i10 < 11; i10++) {
            f5688a.add(clsArr[i10].getName());
        }
    }

    public static k3.k a(Class cls, String str) {
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return i.f5702e;
            }
            if (cls == Boolean.TYPE) {
                return d.f5692e;
            }
            if (cls == Long.TYPE) {
                return j.f5704e;
            }
            if (cls == Double.TYPE) {
                return g.f5698e;
            }
            if (cls == Character.TYPE) {
                return f.f5696e;
            }
            if (cls == Byte.TYPE) {
                return e.f5694e;
            }
            if (cls == Short.TYPE) {
                return m.f5711e;
            }
            if (cls == Float.TYPE) {
                return h.f5700e;
            }
            if (cls == Void.TYPE) {
                return u.f5687a;
            }
        } else if (!f5688a.contains(str)) {
            return null;
        } else {
            if (cls == Integer.class) {
                return i.f5703f;
            }
            if (cls == Boolean.class) {
                return d.f5693f;
            }
            if (cls == Long.class) {
                return j.f5705f;
            }
            if (cls == Double.class) {
                return g.f5699f;
            }
            if (cls == Character.class) {
                return f.f5697f;
            }
            if (cls == Byte.class) {
                return e.f5695f;
            }
            if (cls == Short.class) {
                return m.f5712f;
            }
            if (cls == Float.class) {
                return h.f5701f;
            }
            if (cls == Number.class) {
                return k.f5706a;
            }
            if (cls == BigDecimal.class) {
                return b.f5690a;
            }
            if (cls == BigInteger.class) {
                return c.f5691a;
            }
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + cls.getName());
    }
}
