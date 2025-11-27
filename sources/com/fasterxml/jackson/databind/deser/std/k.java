package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import c3.n;
import d4.h;
import java.util.Objects;
import k3.d;
import k3.f;
import k3.g;
import k3.q;
import m3.b;
import m3.e;
import n3.i;
import n3.t;
import n3.w;
import r3.j;

public class k extends e0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public Object[] f5634a;

    /* renamed from: b  reason: collision with root package name */
    public final Enum f5635b;

    /* renamed from: c  reason: collision with root package name */
    public final d4.i f5636c;

    /* renamed from: d  reason: collision with root package name */
    public d4.i f5637d;

    /* renamed from: e  reason: collision with root package name */
    public final Boolean f5638e;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5639a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                m3.b[] r0 = m3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5639a = r0
                m3.b r1 = m3.b.AsNull     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5639a     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.b r1 = m3.b.AsEmpty     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5639a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.b r1 = m3.b.TryConvert     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.k.a.<clinit>():void");
        }
    }

    public k(d4.k kVar, Boolean bool) {
        super(kVar.n());
        this.f5636c = kVar.i();
        this.f5634a = kVar.p();
        this.f5635b = kVar.m();
        this.f5638e = bool;
    }

    public static k3.k g(f fVar, Class cls, j jVar, w wVar, t[] tVarArr) {
        if (fVar.b()) {
            h.g(jVar.m(), fVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new n(cls, jVar, jVar.w(0), wVar, tVarArr);
    }

    public static k3.k h(f fVar, Class cls, j jVar) {
        if (fVar.b()) {
            h.g(jVar.m(), fVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new n(cls, jVar);
    }

    public final Object a(c3.k kVar, g gVar, d4.i iVar, String str) {
        char charAt;
        b bVar;
        String trim = str.trim();
        if (!trim.isEmpty()) {
            if (Boolean.TRUE.equals(this.f5638e)) {
                Object d10 = iVar.d(trim);
                if (d10 != null) {
                    return d10;
                }
            } else if (!gVar.n0(k3.h.FAIL_ON_NUMBERS_FOR_ENUMS) && (charAt = trim.charAt(0)) >= '0' && charAt <= '9') {
                try {
                    int parseInt = Integer.parseInt(trim);
                    if (!gVar.o0(q.ALLOW_COERCION_OF_SCALARS)) {
                        return gVar.j0(c(), trim, "value looks like quoted Enum index, but `MapperFeature.ALLOW_COERCION_OF_SCALARS` prevents use", new Object[0]);
                    }
                    if (parseInt >= 0) {
                        Object[] objArr = this.f5634a;
                        if (parseInt < objArr.length) {
                            return objArr[parseInt];
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (this.f5635b != null && gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
                return this.f5635b;
            }
            if (gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            return gVar.j0(c(), trim, "not one of the values accepted for Enum class: %s", iVar.f());
        } else if (this.f5635b != null && gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
            return this.f5635b;
        } else {
            if (gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            if (str.isEmpty()) {
                bVar = _checkCoercionFail(gVar, _findCoercionFromEmptyString(gVar), handledType(), str, "empty String (\"\")");
            } else {
                bVar = _checkCoercionFail(gVar, _findCoercionFromBlankString(gVar), handledType(), str, "blank String (all whitespace)");
            }
            int i10 = a.f5639a[bVar.ordinal()];
            if (i10 == 2 || i10 == 3) {
                return getEmptyValue(gVar);
            }
            return null;
        }
    }

    public Object b(c3.k kVar, g gVar) {
        if (kVar.j0(n.START_ARRAY)) {
            return _deserializeFromArray(kVar, gVar);
        }
        return gVar.a0(c(), kVar);
    }

    public Class c() {
        return handledType();
    }

    public k3.k createContextual(g gVar, d dVar) {
        Boolean findFormatFeature = findFormatFeature(gVar, dVar, handledType(), k.a.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        if (findFormatFeature == null) {
            findFormatFeature = this.f5638e;
        }
        return i(findFormatFeature);
    }

    public Object d(c3.k kVar, g gVar, int i10) {
        b B = gVar.B(logicalType(), handledType(), e.Integer);
        if (B == b.Fail) {
            if (gVar.n0(k3.h.FAIL_ON_NUMBERS_FOR_ENUMS)) {
                return gVar.i0(c(), Integer.valueOf(i10), "not allowed to deserialize Enum value out of number: disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow", new Object[0]);
            }
            Class<?> handledType = handledType();
            Integer valueOf = Integer.valueOf(i10);
            _checkCoercionFail(gVar, B, handledType, valueOf, "Integer value (" + i10 + ")");
        }
        int i11 = a.f5639a[B.ordinal()];
        if (i11 == 1) {
            return null;
        }
        if (i11 == 2) {
            return getEmptyValue(gVar);
        }
        if (i10 >= 0) {
            Object[] objArr = this.f5634a;
            if (i10 < objArr.length) {
                return objArr[i10];
            }
        }
        if (this.f5635b != null && gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
            return this.f5635b;
        }
        if (gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
            return null;
        }
        return gVar.i0(c(), Integer.valueOf(i10), "index value outside legal index range [0..%s]", Integer.valueOf(this.f5634a.length - 1));
    }

    public Object deserialize(c3.k kVar, g gVar) {
        if (kVar.j0(n.VALUE_STRING)) {
            return e(kVar, gVar, kVar.Y());
        }
        if (kVar.j0(n.VALUE_NUMBER_INT)) {
            return d(kVar, gVar, kVar.P());
        }
        if (kVar.o0()) {
            return e(kVar, gVar, gVar.z(kVar, this, this._valueClass));
        }
        return b(kVar, gVar);
    }

    public Object e(c3.k kVar, g gVar, String str) {
        d4.i iVar;
        Object c10;
        if (gVar.n0(k3.h.READ_ENUMS_USING_TO_STRING)) {
            iVar = f(gVar);
        } else {
            iVar = this.f5636c;
        }
        Object c11 = iVar.c(str);
        if (c11 != null) {
            return c11;
        }
        String trim = str.trim();
        if (trim == str || (c10 = iVar.c(trim)) == null) {
            return a(kVar, gVar, iVar, trim);
        }
        return c10;
    }

    public d4.i f(g gVar) {
        d4.i iVar = this.f5637d;
        if (iVar == null) {
            synchronized (this) {
                iVar = d4.k.k(gVar.k(), c()).i();
            }
            this.f5637d = iVar;
        }
        return iVar;
    }

    public Object getEmptyValue(g gVar) {
        return this.f5635b;
    }

    public k i(Boolean bool) {
        if (Objects.equals(this.f5638e, bool)) {
            return this;
        }
        return new k(this, bool);
    }

    public boolean isCachable() {
        return true;
    }

    public c4.f logicalType() {
        return c4.f.Enum;
    }

    public k(k kVar, Boolean bool) {
        super((e0) kVar);
        this.f5636c = kVar.f5636c;
        this.f5634a = kVar.f5634a;
        this.f5635b = kVar.f5635b;
        this.f5638e = bool;
    }
}
