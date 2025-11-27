package com.fasterxml.jackson.databind.deser.std;

import b3.j0;
import b3.k;
import c3.k;
import c3.n;
import c4.f;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import k3.d;
import k3.g;
import k3.h;
import k3.j;
import k3.k;
import k3.q;
import m3.b;
import m3.e;
import n3.t;
import n3.w;
import o3.p;
import o3.r;
import r3.i;

public abstract class b0 extends k implements Serializable {
    @Deprecated
    protected static final int F_MASK_ACCEPT_ARRAYS = (h.UNWRAP_SINGLE_VALUE_ARRAYS.b() | h.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.b());
    protected static final int F_MASK_INT_COERCIONS = (h.USE_BIG_INTEGER_FOR_INTS.b() | h.USE_LONG_FOR_INTS.b());
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;
    protected final j _valueType;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5572a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                m3.b[] r0 = m3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5572a = r0
                m3.b r1 = m3.b.AsEmpty     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5572a     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.b r1 = m3.b.AsNull     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5572a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.b r1 = m3.b.TryConvert     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5572a     // Catch:{ NoSuchFieldError -> 0x0033 }
                m3.b r1 = m3.b.Fail     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.b0.a.<clinit>():void");
        }
    }

    public b0(Class cls) {
        this._valueClass = cls;
        this._valueType = null;
    }

    public static final boolean _isBlank(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) > ' ') {
                return false;
            }
        }
        return true;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final double _parseDouble(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(str);
    }

    public final boolean _byteOverflow(int i10) {
        return i10 < -128 || i10 > 255;
    }

    public b _checkCoercionFail(g gVar, b bVar, Class<?> cls, Object obj, String str) {
        if (bVar == b.Fail) {
            gVar.t0(this, cls, obj, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", str, _coercedTypeDesc());
        }
        return bVar;
    }

    public Double _checkDoubleSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt != '-') {
            if (charAt != 'I') {
                if (charAt == 'N' && _isNaN(str)) {
                    return Double.valueOf(Double.NaN);
                }
                return null;
            } else if (_isPosInf(str)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            } else {
                return null;
            }
        } else if (_isNegInf(str)) {
            return Double.valueOf(Double.NEGATIVE_INFINITY);
        } else {
            return null;
        }
    }

    public Float _checkFloatSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char charAt = str.charAt(0);
        if (charAt != '-') {
            if (charAt != 'I') {
                if (charAt == 'N' && _isNaN(str)) {
                    return Float.valueOf(Float.NaN);
                }
                return null;
            } else if (_isPosInf(str)) {
                return Float.valueOf(Float.POSITIVE_INFINITY);
            } else {
                return null;
            }
        } else if (_isNegInf(str)) {
            return Float.valueOf(Float.NEGATIVE_INFINITY);
        } else {
            return null;
        }
    }

    public b _checkFloatToIntCoercion(c3.k kVar, g gVar, Class<?> cls) {
        b B = gVar.B(f.Integer, cls, e.Float);
        if (B != b.Fail) {
            return B;
        }
        Number S = kVar.S();
        return _checkCoercionFail(gVar, B, cls, S, "Floating-point value (" + kVar.Y() + ")");
    }

    public b _checkFromStringCoercion(g gVar, String str) {
        return _checkFromStringCoercion(gVar, str, logicalType(), handledType());
    }

    public boolean _checkTextualNull(g gVar, String str) {
        if (!_hasTextualNull(str)) {
            return false;
        }
        q qVar = q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            _reportFailedNullCoerce(gVar, true, qVar, "String \"null\"");
        }
        return true;
    }

    public Boolean _coerceBooleanFromInt(c3.k kVar, g gVar, Class<?> cls) {
        b B = gVar.B(f.Boolean, cls, e.Integer);
        int i10 = a.f5572a[B.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            return Boolean.FALSE;
        }
        if (i10 == 2) {
            return null;
        }
        if (i10 == 4) {
            Number S = kVar.S();
            _checkCoercionFail(gVar, B, cls, S, "Integer value (" + kVar.Y() + ")");
            return Boolean.FALSE;
        } else if (kVar.R() != k.b.INT) {
            return Boolean.valueOf(!"0".equals(kVar.Y()));
        } else {
            if (kVar.P() == 0) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: k3.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: k3.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: k3.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: k3.q} */
    /* JADX WARNING: Multi-variable type inference failed */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _coerceEmptyString(k3.g r3, boolean r4) {
        /*
            r2 = this;
            k3.q r0 = k3.q.ALLOW_COERCION_OF_SCALARS
            boolean r1 = r3.o0(r0)
            if (r1 != 0) goto L_0x000a
            r4 = 1
            goto L_0x0015
        L_0x000a:
            if (r4 == 0) goto L_0x001c
            k3.h r0 = k3.h.FAIL_ON_NULL_FOR_PRIMITIVES
            boolean r4 = r3.n0(r0)
            if (r4 == 0) goto L_0x001c
            r4 = 0
        L_0x0015:
            java.lang.String r1 = "empty String (\"\")"
            r2._reportFailedNullCoerce(r3, r4, r0, r1)
            r3 = 0
            return r3
        L_0x001c:
            java.lang.Object r3 = r2.getNullValue(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.b0._coerceEmptyString(k3.g, boolean):java.lang.Object");
    }

    public Object _coerceIntegral(c3.k kVar, g gVar) {
        int P = gVar.P();
        if (h.USE_BIG_INTEGER_FOR_INTS.c(P)) {
            return kVar.s();
        }
        if (h.USE_LONG_FOR_INTS.c(P)) {
            return Long.valueOf(kVar.Q());
        }
        return kVar.S();
    }

    @Deprecated
    public Object _coerceNullToken(g gVar, boolean z10) {
        if (z10) {
            _verifyNullForPrimitive(gVar);
        }
        return getNullValue(gVar);
    }

    @Deprecated
    public Object _coerceTextualNull(g gVar, boolean z10) {
        q qVar = q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            _reportFailedNullCoerce(gVar, true, qVar, "String \"null\"");
        }
        return getNullValue(gVar);
    }

    public String _coercedTypeDesc() {
        String str;
        j valueType = getValueType();
        boolean z10 = false;
        if (valueType == null || valueType.K()) {
            Class<?> handledType = handledType();
            if (handledType.isArray() || Collection.class.isAssignableFrom(handledType) || Map.class.isAssignableFrom(handledType)) {
                z10 = true;
            }
            str = d4.h.y(handledType);
        } else {
            if (valueType.D() || valueType.b()) {
                z10 = true;
            }
            str = d4.h.G(valueType);
        }
        if (z10) {
            return "element of " + str;
        }
        return str + " value";
    }

    public Object _deserializeFromArray(c3.k kVar, g gVar) {
        b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
        boolean n02 = gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (n02 || _findCoercionFromEmptyArray != b.Fail) {
            n s02 = kVar.s0();
            n nVar = n.END_ARRAY;
            if (s02 == nVar) {
                int i10 = a.f5572a[_findCoercionFromEmptyArray.ordinal()];
                if (i10 == 1) {
                    return getEmptyValue(gVar);
                }
                if (i10 == 2 || i10 == 3) {
                    return getNullValue(gVar);
                }
            } else if (n02) {
                Object _deserializeWrappedValue = _deserializeWrappedValue(kVar, gVar);
                if (kVar.s0() != nVar) {
                    handleMissingEndArrayForSingle(kVar, gVar);
                }
                return _deserializeWrappedValue;
            }
        }
        return gVar.d0(getValueType(gVar), n.START_ARRAY, kVar, (String) null, new Object[0]);
    }

    @Deprecated
    public Object _deserializeFromEmpty(c3.k kVar, g gVar) {
        if (!kVar.j0(n.START_ARRAY) || !gVar.n0(h.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            return gVar.c0(getValueType(gVar), kVar);
        }
        if (kVar.s0() == n.END_ARRAY) {
            return null;
        }
        return gVar.c0(getValueType(gVar), kVar);
    }

    public Object _deserializeFromEmptyString(c3.k kVar, g gVar, b bVar, Class<?> cls, String str) {
        int i10 = a.f5572a[bVar.ordinal()];
        if (i10 == 1) {
            return getEmptyValue(gVar);
        }
        if (i10 != 4) {
            return null;
        }
        _checkCoercionFail(gVar, bVar, cls, "", "empty String (\"\")");
        return null;
    }

    public Object _deserializeFromString(c3.k kVar, g gVar) {
        w valueInstantiator = getValueInstantiator();
        Class<?> handledType = handledType();
        String g02 = kVar.g0();
        if (valueInstantiator != null && valueInstantiator.h()) {
            return valueInstantiator.v(gVar, g02);
        }
        if (g02.isEmpty()) {
            return _deserializeFromEmptyString(kVar, gVar, gVar.B(logicalType(), handledType, e.EmptyString), handledType, "empty String (\"\")");
        } else if (_isBlank(g02)) {
            return _deserializeFromEmptyString(kVar, gVar, gVar.C(logicalType(), handledType, b.Fail), handledType, "blank String (all whitespace)");
        } else {
            if (valueInstantiator != null) {
                g02 = g02.trim();
                if (valueInstantiator.e() && gVar.B(f.Integer, Integer.class, e.String) == b.TryConvert) {
                    return valueInstantiator.r(gVar, _parseIntPrimitive(gVar, g02));
                }
                if (valueInstantiator.f() && gVar.B(f.Integer, Long.class, e.String) == b.TryConvert) {
                    return valueInstantiator.s(gVar, _parseLongPrimitive(gVar, g02));
                }
                if (valueInstantiator.c() && gVar.B(f.Boolean, Boolean.class, e.String) == b.TryConvert) {
                    String trim = g02.trim();
                    if ("true".equals(trim)) {
                        return valueInstantiator.p(gVar, true);
                    }
                    if ("false".equals(trim)) {
                        return valueInstantiator.p(gVar, false);
                    }
                }
            }
            return gVar.W(handledType, valueInstantiator, gVar.S(), "no String-argument constructor/factory method to deserialize from String value ('%s')", g02);
        }
    }

    public Object _deserializeWrappedValue(c3.k kVar, g gVar) {
        if (kVar.j0(n.START_ARRAY)) {
            return handleNestedArrayForSingle(kVar, gVar);
        }
        return deserialize(kVar, gVar);
    }

    @Deprecated
    public void _failDoubleToIntCoercion(c3.k kVar, g gVar, String str) {
        gVar.w0(handledType(), "Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", kVar.g0(), str);
    }

    public b _findCoercionFromBlankString(g gVar) {
        return gVar.C(logicalType(), handledType(), b.Fail);
    }

    public b _findCoercionFromEmptyArray(g gVar) {
        return gVar.B(logicalType(), handledType(), e.EmptyArray);
    }

    public b _findCoercionFromEmptyString(g gVar) {
        return gVar.B(logicalType(), handledType(), e.EmptyString);
    }

    public final n3.q _findNullProvider(g gVar, d dVar, j0 j0Var, k3.k kVar) {
        if (j0Var == j0.FAIL) {
            if (dVar == null) {
                return r.c(gVar.x(kVar.handledType()));
            }
            return r.a(dVar);
        } else if (j0Var == j0.AS_EMPTY) {
            if (kVar == null) {
                return null;
            }
            if ((kVar instanceof n3.d) && !((n3.d) kVar).getValueInstantiator().j()) {
                j type = dVar.getType();
                gVar.q(type, String.format("Cannot create empty instance of %s, no default Creator", new Object[]{type}));
            }
            d4.a emptyAccessPattern = kVar.getEmptyAccessPattern();
            if (emptyAccessPattern == d4.a.ALWAYS_NULL) {
                return o3.q.c();
            }
            if (emptyAccessPattern == d4.a.CONSTANT) {
                return o3.q.a(kVar.getEmptyValue(gVar));
            }
            return new p(kVar);
        } else if (j0Var == j0.SKIP) {
            return o3.q.d();
        } else {
            return null;
        }
    }

    public boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    public final boolean _intOverflow(long j10) {
        return j10 < -2147483648L || j10 > TTL.MAX_VALUE;
    }

    @Deprecated
    public boolean _isEmptyOrTextualNull(String str) {
        if (str.isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }

    public boolean _isFalse(String str) {
        char charAt = str.charAt(0);
        if (charAt == 'f') {
            return "false".equals(str);
        }
        if (charAt != 'F') {
            return false;
        }
        if ("FALSE".equals(str) || "False".equals(str)) {
            return true;
        }
        return false;
    }

    public final boolean _isIntNumber(String str) {
        int i10;
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt != '-' && charAt != '+') {
            i10 = 0;
        } else if (length == 1) {
            return false;
        } else {
            i10 = 1;
        }
        while (i10 < length) {
            char charAt2 = str.charAt(i10);
            if (charAt2 > '9' || charAt2 < '0') {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    public final boolean _isNegInf(String str) {
        if ("-Infinity".equals(str) || "-INF".equals(str)) {
            return true;
        }
        return false;
    }

    public final boolean _isPosInf(String str) {
        if ("Infinity".equals(str) || "INF".equals(str)) {
            return true;
        }
        return false;
    }

    public boolean _isTrue(String str) {
        char charAt = str.charAt(0);
        if (charAt == 't') {
            return "true".equals(str);
        }
        if (charAt != 'T') {
            return false;
        }
        if ("TRUE".equals(str) || "True".equals(str)) {
            return true;
        }
        return false;
    }

    public Number _nonNullNumber(Number number) {
        if (number == null) {
            return 0;
        }
        return number;
    }

    public final Boolean _parseBoolean(c3.k kVar, g gVar, Class<?> cls) {
        String str;
        int q10 = kVar.q();
        if (q10 == 1) {
            str = gVar.z(kVar, this, cls);
        } else if (q10 == 3) {
            return (Boolean) _deserializeFromArray(kVar, gVar);
        } else {
            if (q10 == 6) {
                str = kVar.Y();
            } else if (q10 == 7) {
                return _coerceBooleanFromInt(kVar, gVar, cls);
            } else {
                switch (q10) {
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    default:
                        return (Boolean) gVar.a0(cls, kVar);
                }
            }
        }
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Boolean, cls);
        if (_checkFromStringCoercion == b.AsNull) {
            return null;
        }
        if (_checkFromStringCoercion == b.AsEmpty) {
            return Boolean.FALSE;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 4) {
            if (_isTrue(trim)) {
                return Boolean.TRUE;
            }
        } else if (length == 5 && _isFalse(trim)) {
            return Boolean.FALSE;
        }
        if (_checkTextualNull(gVar, trim)) {
            return null;
        }
        return (Boolean) gVar.j0(cls, trim, "only \"true\" or \"false\" recognized", new Object[0]);
    }

    @Deprecated
    public boolean _parseBooleanFromInt(c3.k kVar, g gVar) {
        _verifyNumberForScalarCoercion(gVar, kVar);
        return !"0".equals(kVar.Y());
    }

    @Deprecated
    public final boolean _parseBooleanPrimitive(g gVar, c3.k kVar, Class<?> cls) {
        return _parseBooleanPrimitive(kVar, gVar);
    }

    public final byte _parseBytePrimitive(c3.k kVar, g gVar) {
        String str;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0;
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7) {
                    return kVar.x();
                } else {
                    if (q10 == 8) {
                        b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Byte.TYPE);
                        if (_checkFloatToIntCoercion == b.AsNull || _checkFloatToIntCoercion == b.AsEmpty) {
                            return 0;
                        }
                        return kVar.x();
                    }
                }
            } else if (gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == n.START_ARRAY) {
                    return ((Byte) handleNestedArrayForSingle(kVar, gVar)).byteValue();
                }
                byte _parseBytePrimitive = _parseBytePrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseBytePrimitive;
            }
            return ((Byte) gVar.c0(gVar.x(Byte.TYPE), kVar)).byteValue();
        }
        str = gVar.z(kVar, this, Byte.TYPE);
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Integer, Byte.TYPE);
        if (_checkFromStringCoercion == b.AsNull || _checkFromStringCoercion == b.AsEmpty) {
            return 0;
        }
        String trim = str.trim();
        if (_hasTextualNull(trim)) {
            _verifyNullForPrimitiveCoercion(gVar, trim);
            return 0;
        }
        try {
            int j10 = f3.f.j(trim);
            if (_byteOverflow(j10)) {
                return ((Byte) gVar.j0(this._valueClass, trim, "overflow, value cannot be represented as 8-bit value", new Object[0])).byteValue();
            }
            return (byte) j10;
        } catch (IllegalArgumentException unused) {
            return ((Byte) gVar.j0(this._valueClass, trim, "not a valid `byte` value", new Object[0])).byteValue();
        }
    }

    public Date _parseDate(c3.k kVar, g gVar) {
        String str;
        long j10;
        int q10 = kVar.q();
        if (q10 == 1) {
            str = gVar.z(kVar, this, this._valueClass);
        } else if (q10 == 3) {
            return _parseDateFromArray(kVar, gVar);
        } else {
            if (q10 == 11) {
                return (Date) getNullValue(gVar);
            }
            if (q10 == 6) {
                str = kVar.Y();
            } else if (q10 != 7) {
                return (Date) gVar.a0(this._valueClass, kVar);
            } else {
                try {
                    j10 = kVar.Q();
                } catch (c3.j | e3.a unused) {
                    j10 = ((Number) gVar.i0(this._valueClass, kVar.S(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0])).longValue();
                }
                return new Date(j10);
            }
        }
        return _parseDate(str.trim(), gVar);
    }

    public Date _parseDateFromArray(c3.k kVar, g gVar) {
        b _findCoercionFromEmptyArray = _findCoercionFromEmptyArray(gVar);
        boolean n02 = gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (n02 || _findCoercionFromEmptyArray != b.Fail) {
            n s02 = kVar.s0();
            if (s02 == n.END_ARRAY) {
                int i10 = a.f5572a[_findCoercionFromEmptyArray.ordinal()];
                if (i10 == 1) {
                    return (Date) getEmptyValue(gVar);
                }
                if (i10 == 2 || i10 == 3) {
                    return (Date) getNullValue(gVar);
                }
            } else if (n02) {
                if (s02 == n.START_ARRAY) {
                    return (Date) handleNestedArrayForSingle(kVar, gVar);
                }
                Date _parseDate = _parseDate(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseDate;
            }
        }
        return (Date) gVar.b0(this._valueClass, n.START_ARRAY, kVar, (String) null, new Object[0]);
    }

    public final double _parseDoublePrimitive(c3.k kVar, g gVar) {
        String str;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0.0d;
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return kVar.M();
                }
            } else if (gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == n.START_ARRAY) {
                    return ((Double) handleNestedArrayForSingle(kVar, gVar)).doubleValue();
                }
                double _parseDoublePrimitive = _parseDoublePrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseDoublePrimitive;
            }
            return ((Number) gVar.a0(Double.TYPE, kVar)).doubleValue();
        }
        str = gVar.z(kVar, this, Double.TYPE);
        Double _checkDoubleSpecialValue = _checkDoubleSpecialValue(str);
        if (_checkDoubleSpecialValue != null) {
            return _checkDoubleSpecialValue.doubleValue();
        }
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Integer, Double.TYPE);
        if (_checkFromStringCoercion == b.AsNull || _checkFromStringCoercion == b.AsEmpty) {
            return 0.0d;
        }
        String trim = str.trim();
        if (!_hasTextualNull(trim)) {
            return _parseDoublePrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0.0d;
    }

    public final float _parseFloatPrimitive(c3.k kVar, g gVar) {
        String str;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0.0f;
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7 || q10 == 8) {
                    return kVar.O();
                }
            } else if (gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == n.START_ARRAY) {
                    return ((Float) handleNestedArrayForSingle(kVar, gVar)).floatValue();
                }
                float _parseFloatPrimitive = _parseFloatPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseFloatPrimitive;
            }
            return ((Number) gVar.a0(Float.TYPE, kVar)).floatValue();
        }
        str = gVar.z(kVar, this, Float.TYPE);
        Float _checkFloatSpecialValue = _checkFloatSpecialValue(str);
        if (_checkFloatSpecialValue != null) {
            return _checkFloatSpecialValue.floatValue();
        }
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Integer, Float.TYPE);
        if (_checkFromStringCoercion == b.AsNull || _checkFromStringCoercion == b.AsEmpty) {
            return 0.0f;
        }
        String trim = str.trim();
        if (!_hasTextualNull(trim)) {
            return _parseFloatPrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0.0f;
    }

    public final int _parseIntPrimitive(c3.k kVar, g gVar) {
        String str;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0;
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7) {
                    return kVar.P();
                } else {
                    if (q10 == 8) {
                        b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Integer.TYPE);
                        if (_checkFloatToIntCoercion == b.AsNull || _checkFloatToIntCoercion == b.AsEmpty) {
                            return 0;
                        }
                        return kVar.e0();
                    }
                }
            } else if (gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == n.START_ARRAY) {
                    return ((Integer) handleNestedArrayForSingle(kVar, gVar)).intValue();
                }
                int _parseIntPrimitive = _parseIntPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseIntPrimitive;
            }
            return ((Number) gVar.a0(Integer.TYPE, kVar)).intValue();
        }
        str = gVar.z(kVar, this, Integer.TYPE);
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Integer, Integer.TYPE);
        if (_checkFromStringCoercion == b.AsNull || _checkFromStringCoercion == b.AsEmpty) {
            return 0;
        }
        String trim = str.trim();
        if (!_hasTextualNull(trim)) {
            return _parseIntPrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0;
    }

    public final Integer _parseInteger(c3.k kVar, g gVar, Class<?> cls) {
        String str;
        int q10 = kVar.q();
        if (q10 == 1) {
            str = gVar.z(kVar, this, cls);
        } else if (q10 == 3) {
            return (Integer) _deserializeFromArray(kVar, gVar);
        } else {
            if (q10 == 11) {
                return (Integer) getNullValue(gVar);
            }
            if (q10 == 6) {
                str = kVar.Y();
            } else if (q10 == 7) {
                return Integer.valueOf(kVar.P());
            } else {
                if (q10 != 8) {
                    return (Integer) gVar.c0(getValueType(gVar), kVar);
                }
                b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, cls);
                if (_checkFloatToIntCoercion == b.AsNull) {
                    return (Integer) getNullValue(gVar);
                }
                if (_checkFloatToIntCoercion == b.AsEmpty) {
                    return (Integer) getEmptyValue(gVar);
                }
                return Integer.valueOf(kVar.e0());
            }
        }
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
        if (_checkFromStringCoercion == b.AsNull) {
            return (Integer) getNullValue(gVar);
        }
        if (_checkFromStringCoercion == b.AsEmpty) {
            return (Integer) getEmptyValue(gVar);
        }
        String trim = str.trim();
        if (_checkTextualNull(gVar, trim)) {
            return (Integer) getNullValue(gVar);
        }
        return Integer.valueOf(_parseIntPrimitive(gVar, trim));
    }

    public final Long _parseLong(c3.k kVar, g gVar, Class<?> cls) {
        String str;
        int q10 = kVar.q();
        if (q10 == 1) {
            str = gVar.z(kVar, this, cls);
        } else if (q10 == 3) {
            return (Long) _deserializeFromArray(kVar, gVar);
        } else {
            if (q10 == 11) {
                return (Long) getNullValue(gVar);
            }
            if (q10 == 6) {
                str = kVar.Y();
            } else if (q10 == 7) {
                return Long.valueOf(kVar.Q());
            } else {
                if (q10 != 8) {
                    return (Long) gVar.c0(getValueType(gVar), kVar);
                }
                b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, cls);
                if (_checkFloatToIntCoercion == b.AsNull) {
                    return (Long) getNullValue(gVar);
                }
                if (_checkFloatToIntCoercion == b.AsEmpty) {
                    return (Long) getEmptyValue(gVar);
                }
                return Long.valueOf(kVar.f0());
            }
        }
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str);
        if (_checkFromStringCoercion == b.AsNull) {
            return (Long) getNullValue(gVar);
        }
        if (_checkFromStringCoercion == b.AsEmpty) {
            return (Long) getEmptyValue(gVar);
        }
        String trim = str.trim();
        if (_checkTextualNull(gVar, trim)) {
            return (Long) getNullValue(gVar);
        }
        return Long.valueOf(_parseLongPrimitive(gVar, trim));
    }

    public final long _parseLongPrimitive(c3.k kVar, g gVar) {
        String str;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0;
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7) {
                    return kVar.Q();
                } else {
                    if (q10 == 8) {
                        b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Long.TYPE);
                        if (_checkFloatToIntCoercion == b.AsNull || _checkFloatToIntCoercion == b.AsEmpty) {
                            return 0;
                        }
                        return kVar.f0();
                    }
                }
            } else if (gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == n.START_ARRAY) {
                    return ((Long) handleNestedArrayForSingle(kVar, gVar)).longValue();
                }
                long _parseLongPrimitive = _parseLongPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseLongPrimitive;
            }
            return ((Number) gVar.a0(Long.TYPE, kVar)).longValue();
        }
        str = gVar.z(kVar, this, Long.TYPE);
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Integer, Long.TYPE);
        if (_checkFromStringCoercion == b.AsNull || _checkFromStringCoercion == b.AsEmpty) {
            return 0;
        }
        String trim = str.trim();
        if (!_hasTextualNull(trim)) {
            return _parseLongPrimitive(gVar, trim);
        }
        _verifyNullForPrimitiveCoercion(gVar, trim);
        return 0;
    }

    public final short _parseShortPrimitive(c3.k kVar, g gVar) {
        String str;
        int q10 = kVar.q();
        if (q10 != 1) {
            if (q10 != 3) {
                if (q10 == 11) {
                    _verifyNullForPrimitive(gVar);
                    return 0;
                } else if (q10 == 6) {
                    str = kVar.Y();
                } else if (q10 == 7) {
                    return kVar.X();
                } else {
                    if (q10 == 8) {
                        b _checkFloatToIntCoercion = _checkFloatToIntCoercion(kVar, gVar, Short.TYPE);
                        if (_checkFloatToIntCoercion == b.AsNull || _checkFloatToIntCoercion == b.AsEmpty) {
                            return 0;
                        }
                        return kVar.X();
                    }
                }
            } else if (gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (kVar.s0() == n.START_ARRAY) {
                    return ((Short) handleNestedArrayForSingle(kVar, gVar)).shortValue();
                }
                short _parseShortPrimitive = _parseShortPrimitive(kVar, gVar);
                _verifyEndArrayForSingle(kVar, gVar);
                return _parseShortPrimitive;
            }
            return ((Short) gVar.c0(gVar.x(Short.TYPE), kVar)).shortValue();
        }
        str = gVar.z(kVar, this, Short.TYPE);
        b _checkFromStringCoercion = _checkFromStringCoercion(gVar, str, f.Integer, Short.TYPE);
        if (_checkFromStringCoercion == b.AsNull || _checkFromStringCoercion == b.AsEmpty) {
            return 0;
        }
        String trim = str.trim();
        if (_hasTextualNull(trim)) {
            _verifyNullForPrimitiveCoercion(gVar, trim);
            return 0;
        }
        try {
            int j10 = f3.f.j(trim);
            if (_shortOverflow(j10)) {
                return ((Short) gVar.j0(Short.TYPE, trim, "overflow, value cannot be represented as 16-bit value", new Object[0])).shortValue();
            }
            return (short) j10;
        } catch (IllegalArgumentException unused) {
            return ((Short) gVar.j0(Short.TYPE, trim, "not a valid `short` value", new Object[0])).shortValue();
        }
    }

    public final String _parseString(c3.k kVar, g gVar) {
        if (kVar.j0(n.VALUE_STRING)) {
            return kVar.Y();
        }
        if (kVar.j0(n.VALUE_EMBEDDED_OBJECT)) {
            Object N = kVar.N();
            if (N instanceof byte[]) {
                return gVar.M().i((byte[]) N, false);
            }
            if (N == null) {
                return null;
            }
            return N.toString();
        } else if (kVar.j0(n.START_OBJECT)) {
            return gVar.z(kVar, this, this._valueClass);
        } else {
            String g02 = kVar.g0();
            if (g02 != null) {
                return g02;
            }
            return (String) gVar.a0(String.class, kVar);
        }
    }

    public void _reportFailedNullCoerce(g gVar, boolean z10, Enum<?> enumR, String str) {
        String str2;
        if (z10) {
            str2 = "enable";
        } else {
            str2 = "disable";
        }
        gVar.z0(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", str, _coercedTypeDesc(), str2, enumR.getDeclaringClass().getSimpleName(), enumR.name());
    }

    public final boolean _shortOverflow(int i10) {
        return i10 < -32768 || i10 > 32767;
    }

    public void _verifyEndArrayForSingle(c3.k kVar, g gVar) {
        if (kVar.s0() != n.END_ARRAY) {
            handleMissingEndArrayForSingle(kVar, gVar);
        }
    }

    public final void _verifyNullForPrimitive(g gVar) {
        if (gVar.n0(h.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            gVar.z0(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: k3.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: k3.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: k3.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: k3.q} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void _verifyNullForPrimitiveCoercion(k3.g r6, java.lang.String r7) {
        /*
            r5 = this;
            k3.q r0 = k3.q.ALLOW_COERCION_OF_SCALARS
            boolean r1 = r6.o0(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x000c
            r1 = 1
            goto L_0x0015
        L_0x000c:
            k3.h r0 = k3.h.FAIL_ON_NULL_FOR_PRIMITIVES
            boolean r1 = r6.n0(r0)
            if (r1 == 0) goto L_0x002b
            r1 = 0
        L_0x0015:
            boolean r4 = r7.isEmpty()
            if (r4 == 0) goto L_0x001e
            java.lang.String r7 = "empty String (\"\")"
            goto L_0x0028
        L_0x001e:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r7
            java.lang.String r7 = "String \"%s\""
            java.lang.String r7 = java.lang.String.format(r7, r3)
        L_0x0028:
            r5._reportFailedNullCoerce(r6, r1, r0, r7)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.b0._verifyNullForPrimitiveCoercion(k3.g, java.lang.String):void");
    }

    @Deprecated
    public final void _verifyNullForScalarCoercion(g gVar, String str) {
        String str2;
        q qVar = q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            if (str.isEmpty()) {
                str2 = "empty String (\"\")";
            } else {
                str2 = String.format("String \"%s\"", new Object[]{str});
            }
            _reportFailedNullCoerce(gVar, true, qVar, str2);
        }
    }

    @Deprecated
    public void _verifyNumberForScalarCoercion(g gVar, c3.k kVar) {
        q qVar = q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            gVar.z0(this, "Cannot coerce Number (%s) to %s (enable `%s.%s` to allow)", kVar.Y(), _coercedTypeDesc(), qVar.getDeclaringClass().getSimpleName(), qVar.name());
        }
    }

    @Deprecated
    public void _verifyStringForScalarCoercion(g gVar, String str) {
        q qVar = q.ALLOW_COERCION_OF_SCALARS;
        if (!gVar.o0(qVar)) {
            gVar.z0(this, "Cannot coerce String \"%s\" to %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), qVar.getDeclaringClass().getSimpleName(), qVar.name());
        }
    }

    public Object deserializeWithType(c3.k kVar, g gVar, w3.e eVar) {
        return eVar.c(kVar, gVar);
    }

    public n3.q findContentNullProvider(g gVar, d dVar, k3.k kVar) {
        j0 findContentNullStyle = findContentNullStyle(gVar, dVar);
        if (findContentNullStyle == j0.SKIP) {
            return o3.q.d();
        }
        if (findContentNullStyle != j0.FAIL) {
            n3.q _findNullProvider = _findNullProvider(gVar, dVar, findContentNullStyle, kVar);
            if (_findNullProvider != null) {
                return _findNullProvider;
            }
            return kVar;
        } else if (dVar != null) {
            return r.b(dVar, dVar.getType().k());
        } else {
            j x10 = gVar.x(kVar.handledType());
            if (x10.D()) {
                x10 = x10.k();
            }
            return r.c(x10);
        }
    }

    public j0 findContentNullStyle(g gVar, d dVar) {
        if (dVar != null) {
            return dVar.getMetadata().b();
        }
        return null;
    }

    public k3.k findConvertingContentDeserializer(g gVar, d dVar, k3.k kVar) {
        i d10;
        Object k10;
        k3.b K = gVar.K();
        if (!_neitherNull(K, dVar) || (d10 = dVar.d()) == null || (k10 = K.k(d10)) == null) {
            return kVar;
        }
        d4.j j10 = gVar.j(dVar.d(), k10);
        j b10 = j10.b(gVar.l());
        if (kVar == null) {
            kVar = gVar.D(b10, dVar);
        }
        return new a0(j10, b10, kVar);
    }

    public k3.k findDeserializer(g gVar, j jVar, d dVar) {
        return gVar.D(jVar, dVar);
    }

    public Boolean findFormatFeature(g gVar, d dVar, Class<?> cls, k.a aVar) {
        k.d findFormatOverrides = findFormatOverrides(gVar, dVar, cls);
        if (findFormatOverrides != null) {
            return findFormatOverrides.e(aVar);
        }
        return null;
    }

    public k.d findFormatOverrides(g gVar, d dVar, Class<?> cls) {
        if (dVar != null) {
            return dVar.a(gVar.k(), cls);
        }
        return gVar.O(cls);
    }

    public final n3.q findValueNullProvider(g gVar, t tVar, k3.w wVar) {
        if (tVar != null) {
            return _findNullProvider(gVar, tVar, wVar.e(), tVar.u());
        }
        return null;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public w getValueInstantiator() {
        return null;
    }

    public j getValueType() {
        return this._valueType;
    }

    public void handleMissingEndArrayForSingle(c3.k kVar, g gVar) {
        gVar.G0(this, n.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
    }

    public Object handleNestedArrayForSingle(c3.k kVar, g gVar) {
        return gVar.d0(getValueType(gVar), kVar.n(), kVar, String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", new Object[]{d4.h.X(this._valueClass), n.START_ARRAY, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"}), new Object[0]);
    }

    public void handleUnknownProperty(c3.k kVar, g gVar, Object obj, String str) {
        if (obj == null) {
            obj = handledType();
        }
        if (!gVar.e0(kVar, this, obj, str)) {
            kVar.D0();
        }
    }

    public Class<?> handledType() {
        return this._valueClass;
    }

    public boolean isDefaultDeserializer(k3.k kVar) {
        return d4.h.O(kVar);
    }

    public boolean isDefaultKeyDeserializer(k3.p pVar) {
        return d4.h.O(pVar);
    }

    public b _checkFromStringCoercion(g gVar, String str, f fVar, Class<?> cls) {
        if (str.isEmpty()) {
            return _checkCoercionFail(gVar, gVar.B(fVar, cls, e.EmptyString), cls, str, "empty String (\"\")");
        } else if (_isBlank(str)) {
            return _checkCoercionFail(gVar, gVar.C(fVar, cls, b.Fail), cls, str, "blank String (all whitespace)");
        } else if (gVar.m0(c3.r.UNTYPED_SCALARS)) {
            return b.TryConvert;
        } else {
            b B = gVar.B(fVar, cls, e.String);
            if (B == b.Fail) {
                gVar.z0(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", str, _coercedTypeDesc());
            }
            return B;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean _parseBooleanPrimitive(c3.k r6, k3.g r7) {
        /*
            r5 = this;
            int r0 = r6.q()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x005c
            r3 = 3
            if (r0 == r3) goto L_0x002c
            r3 = 6
            if (r0 == r3) goto L_0x0027
            r3 = 7
            if (r0 == r3) goto L_0x001a
            switch(r0) {
                case 9: goto L_0x0019;
                case 10: goto L_0x0018;
                case 11: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x004f
        L_0x0015:
            r5._verifyNullForPrimitive(r7)
        L_0x0018:
            return r2
        L_0x0019:
            return r1
        L_0x001a:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Class r1 = java.lang.Boolean.TYPE
            java.lang.Boolean r6 = r5._coerceBooleanFromInt(r6, r7, r1)
            boolean r6 = r0.equals(r6)
            return r6
        L_0x0027:
            java.lang.String r6 = r6.Y()
            goto L_0x0062
        L_0x002c:
            k3.h r0 = k3.h.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r7.n0(r0)
            if (r0 == 0) goto L_0x004f
            c3.n r0 = r6.s0()
            c3.n r1 = c3.n.START_ARRAY
            if (r0 != r1) goto L_0x0047
            java.lang.Object r6 = r5.handleNestedArrayForSingle(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L_0x0047:
            boolean r0 = r5._parseBooleanPrimitive(r6, r7)
            r5._verifyEndArrayForSingle(r6, r7)
            return r0
        L_0x004f:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.Object r6 = r7.a0(r0, r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L_0x005c:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.String r6 = r7.z(r6, r5, r0)
        L_0x0062:
            c4.f r0 = c4.f.Boolean
            java.lang.Class r3 = java.lang.Boolean.TYPE
            m3.b r0 = r5._checkFromStringCoercion(r7, r6, r0, r3)
            m3.b r4 = m3.b.AsNull
            if (r0 != r4) goto L_0x0072
            r5._verifyNullForPrimitive(r7)
            return r2
        L_0x0072:
            m3.b r4 = m3.b.AsEmpty
            if (r0 != r4) goto L_0x0077
            return r2
        L_0x0077:
            java.lang.String r6 = r6.trim()
            int r0 = r6.length()
            r4 = 4
            if (r0 != r4) goto L_0x0089
            boolean r0 = r5._isTrue(r6)
            if (r0 == 0) goto L_0x0093
            return r1
        L_0x0089:
            r1 = 5
            if (r0 != r1) goto L_0x0093
            boolean r0 = r5._isFalse(r6)
            if (r0 == 0) goto L_0x0093
            return r2
        L_0x0093:
            boolean r0 = r5._hasTextualNull(r6)
            if (r0 == 0) goto L_0x009d
            r5._verifyNullForPrimitiveCoercion(r7, r6)
            return r2
        L_0x009d:
            java.lang.String r0 = "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Object r6 = r7.j0(r3, r6, r0, r1)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            boolean r6 = r7.equals(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.b0._parseBooleanPrimitive(c3.k, k3.g):boolean");
    }

    public j getValueType(g gVar) {
        j jVar = this._valueType;
        if (jVar != null) {
            return jVar;
        }
        return gVar.x(this._valueClass);
    }

    public b0(j jVar) {
        this._valueClass = jVar == null ? Object.class : jVar.q();
        this._valueType = jVar;
    }

    public b0(b0 b0Var) {
        this._valueClass = b0Var._valueClass;
        this._valueType = b0Var._valueType;
    }

    public Date _parseDate(String str, g gVar) {
        try {
            if (str.isEmpty()) {
                if (a.f5572a[_checkFromStringCoercion(gVar, str).ordinal()] != 1) {
                    return null;
                }
                return new Date(0);
            } else if (_hasTextualNull(str)) {
                return null;
            } else {
                return gVar.s0(str);
            }
        } catch (IllegalArgumentException e10) {
            return (Date) gVar.j0(this._valueClass, str, "not a valid representation (error: %s)", d4.h.o(e10));
        }
    }

    public final double _parseDoublePrimitive(g gVar, String str) {
        try {
            return _parseDouble(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Double.TYPE, str, "not a valid `double` value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    public final float _parseFloatPrimitive(g gVar, String str) {
        try {
            return Float.parseFloat(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Float.TYPE, str, "not a valid `float` value", new Object[0])).floatValue();
        }
    }

    public final int _parseIntPrimitive(g gVar, String str) {
        try {
            if (str.length() <= 9) {
                return f3.f.j(str);
            }
            long parseLong = Long.parseLong(str);
            if (!_intOverflow(parseLong)) {
                return (int) parseLong;
            }
            return _nonNullNumber((Number) gVar.j0(Integer.TYPE, str, "Overflow: numeric value (%s) out of range of int (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE)).intValue();
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Integer.TYPE, str, "not a valid `int` value", new Object[0])).intValue();
        }
    }

    public final long _parseLongPrimitive(g gVar, String str) {
        try {
            return f3.f.l(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) gVar.j0(Long.TYPE, str, "not a valid `long` value", new Object[0])).longValue();
        }
    }
}
