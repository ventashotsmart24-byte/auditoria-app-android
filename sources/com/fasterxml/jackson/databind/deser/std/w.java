package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import c3.n;
import c4.a;
import c4.f;
import d4.s;
import java.lang.reflect.Array;
import java.util.Objects;
import k3.d;
import k3.g;
import k3.h;
import k3.j;
import k3.k;
import k3.l;
import n3.i;
import n3.q;
import w3.e;

public class w extends i implements i {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5713e;

    /* renamed from: f  reason: collision with root package name */
    public final Class f5714f;

    /* renamed from: g  reason: collision with root package name */
    public k f5715g;

    /* renamed from: h  reason: collision with root package name */
    public final e f5716h;

    /* renamed from: i  reason: collision with root package name */
    public final Object[] f5717i;

    public w(j jVar, k kVar, e eVar) {
        super(jVar, (q) null, (Boolean) null);
        a aVar = (a) jVar;
        Class<Object> q10 = aVar.k().q();
        this.f5714f = q10;
        this.f5713e = q10 == Object.class;
        this.f5715g = kVar;
        this.f5716h = eVar;
        this.f5717i = aVar.d0();
    }

    public k a() {
        return this.f5715g;
    }

    /* renamed from: c */
    public Object[] deserialize(c3.k kVar, g gVar) {
        Object[] objArr;
        Object obj;
        if (!kVar.n0()) {
            return g(kVar, gVar);
        }
        s q02 = gVar.q0();
        Object[] i10 = q02.i();
        e eVar = this.f5716h;
        int i11 = 0;
        while (true) {
            try {
                n s02 = kVar.s0();
                if (s02 == n.END_ARRAY) {
                    break;
                }
                if (s02 == n.VALUE_NULL) {
                    if (!this.f5625c) {
                        obj = this.f5624b.getNullValue(gVar);
                    }
                } else if (eVar == null) {
                    obj = this.f5715g.deserialize(kVar, gVar);
                } else {
                    obj = this.f5715g.deserializeWithType(kVar, gVar, eVar);
                }
                if (i11 >= i10.length) {
                    i10 = q02.c(i10);
                    i11 = 0;
                }
                int i12 = i11 + 1;
                try {
                    i10[i11] = obj;
                    i11 = i12;
                } catch (Exception e10) {
                    e = e10;
                    i11 = i12;
                    throw l.p(e, i10, q02.d() + i11);
                }
            } catch (Exception e11) {
                e = e11;
                throw l.p(e, i10, q02.d() + i11);
            }
        }
        if (this.f5713e) {
            objArr = q02.f(i10, i11);
        } else {
            objArr = q02.g(i10, i11, this.f5714f);
        }
        gVar.H0(q02);
        return objArr;
    }

    public k createContextual(g gVar, d dVar) {
        k kVar;
        k kVar2 = this.f5715g;
        Boolean findFormatFeature = findFormatFeature(gVar, dVar, this.f5623a.q(), k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        k3.k findConvertingContentDeserializer = findConvertingContentDeserializer(gVar, dVar, kVar2);
        j k10 = this.f5623a.k();
        if (findConvertingContentDeserializer == null) {
            kVar = gVar.D(k10, dVar);
        } else {
            kVar = gVar.Z(findConvertingContentDeserializer, dVar, k10);
        }
        e eVar = this.f5716h;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        return h(eVar, kVar, findContentNullProvider(gVar, dVar, kVar), findFormatFeature);
    }

    /* renamed from: d */
    public Object[] deserialize(c3.k kVar, g gVar, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        if (!kVar.n0()) {
            Object[] g10 = g(kVar, gVar);
            if (g10 == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArr3 = new Object[(g10.length + length)];
            System.arraycopy(objArr, 0, objArr3, 0, length);
            System.arraycopy(g10, 0, objArr3, length, g10.length);
            return objArr3;
        }
        s q02 = gVar.q0();
        int length2 = objArr.length;
        Object[] j10 = q02.j(objArr, length2);
        e eVar = this.f5716h;
        while (true) {
            try {
                n s02 = kVar.s0();
                if (s02 == n.END_ARRAY) {
                    break;
                }
                if (s02 == n.VALUE_NULL) {
                    if (!this.f5625c) {
                        obj = this.f5624b.getNullValue(gVar);
                    }
                } else if (eVar == null) {
                    obj = this.f5715g.deserialize(kVar, gVar);
                } else {
                    obj = this.f5715g.deserializeWithType(kVar, gVar, eVar);
                }
                if (length2 >= j10.length) {
                    j10 = q02.c(j10);
                    length2 = 0;
                }
                int i10 = length2 + 1;
                try {
                    j10[length2] = obj;
                    length2 = i10;
                } catch (Exception e10) {
                    e = e10;
                    length2 = i10;
                    throw l.p(e, j10, q02.d() + length2);
                }
            } catch (Exception e11) {
                e = e11;
                throw l.p(e, j10, q02.d() + length2);
            }
        }
        if (this.f5713e) {
            objArr2 = q02.f(j10, length2);
        } else {
            objArr2 = q02.g(j10, length2, this.f5714f);
        }
        gVar.H0(q02);
        return objArr2;
    }

    public Byte[] e(c3.k kVar, g gVar) {
        byte[] v10 = kVar.v(gVar.M());
        Byte[] bArr = new Byte[v10.length];
        int length = v10.length;
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = Byte.valueOf(v10[i10]);
        }
        return bArr;
    }

    /* renamed from: f */
    public Object[] deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return (Object[]) eVar.d(kVar, gVar);
    }

    public Object[] g(c3.k kVar, g gVar) {
        boolean z10;
        Object obj;
        Object[] objArr;
        Boolean bool = this.f5626d;
        if (bool == Boolean.TRUE || (bool == null && gVar.n0(h.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (!kVar.j0(n.VALUE_NULL)) {
                e eVar = this.f5716h;
                if (eVar == null) {
                    obj = this.f5715g.deserialize(kVar, gVar);
                } else {
                    obj = this.f5715g.deserializeWithType(kVar, gVar, eVar);
                }
            } else if (this.f5625c) {
                return this.f5717i;
            } else {
                obj = this.f5624b.getNullValue(gVar);
            }
            if (this.f5713e) {
                objArr = new Object[1];
            } else {
                objArr = (Object[]) Array.newInstance(this.f5714f, 1);
            }
            objArr[0] = obj;
            return objArr;
        } else if (!kVar.j0(n.VALUE_STRING)) {
            return (Object[]) gVar.c0(this.f5623a, kVar);
        } else {
            if (this.f5714f == Byte.class) {
                return e(kVar, gVar);
            }
            return (Object[]) _deserializeFromString(kVar, gVar);
        }
    }

    public d4.a getEmptyAccessPattern() {
        return d4.a.CONSTANT;
    }

    public Object getEmptyValue(g gVar) {
        return this.f5717i;
    }

    public w h(e eVar, k3.k kVar, q qVar, Boolean bool) {
        if (Objects.equals(bool, this.f5626d) && qVar == this.f5624b && kVar == this.f5715g && eVar == this.f5716h) {
            return this;
        }
        return new w(this, kVar, eVar, qVar, bool);
    }

    public boolean isCachable() {
        if (this.f5715g == null && this.f5716h == null) {
            return true;
        }
        return false;
    }

    public f logicalType() {
        return f.Array;
    }

    public w(w wVar, k3.k kVar, e eVar, q qVar, Boolean bool) {
        super((i) wVar, qVar, bool);
        this.f5714f = wVar.f5714f;
        this.f5713e = wVar.f5713e;
        this.f5717i = wVar.f5717i;
        this.f5715g = kVar;
        this.f5716h = eVar;
    }
}
