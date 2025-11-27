package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import c3.n;
import c4.f;
import d4.a;
import d4.s;
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

public final class g0 extends b0 implements i {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f5605e = new String[0];

    /* renamed from: f  reason: collision with root package name */
    public static final g0 f5606f = new g0();

    /* renamed from: a  reason: collision with root package name */
    public k f5607a;

    /* renamed from: b  reason: collision with root package name */
    public final q f5608b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f5609c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5610d;

    public g0() {
        this((k) null, (q) null, (Boolean) null);
    }

    public final String[] a(c3.k kVar, g gVar, String[] strArr) {
        Object[] objArr;
        int i10;
        String str;
        Class<String> cls = String.class;
        s q02 = gVar.q0();
        if (strArr == null) {
            objArr = q02.i();
            i10 = 0;
        } else {
            i10 = strArr.length;
            objArr = q02.j(strArr, i10);
        }
        k kVar2 = this.f5607a;
        while (true) {
            try {
                if (kVar.r0() == null) {
                    n n10 = kVar.n();
                    if (n10 == n.END_ARRAY) {
                        String[] strArr2 = (String[]) q02.g(objArr, i10, cls);
                        gVar.H0(q02);
                        return strArr2;
                    } else if (n10 != n.VALUE_NULL) {
                        str = (String) kVar2.deserialize(kVar, gVar);
                    } else if (!this.f5610d) {
                        str = (String) this.f5608b.getNullValue(gVar);
                    }
                } else {
                    str = (String) kVar2.deserialize(kVar, gVar);
                }
                if (i10 >= objArr.length) {
                    objArr = q02.c(objArr);
                    i10 = 0;
                }
                int i11 = i10 + 1;
                try {
                    objArr[i10] = str;
                    i10 = i11;
                } catch (Exception e10) {
                    e = e10;
                    i10 = i11;
                    throw l.p(e, cls, i10);
                }
            } catch (Exception e11) {
                e = e11;
                throw l.p(e, cls, i10);
            }
        }
    }

    /* renamed from: b */
    public String[] deserialize(c3.k kVar, g gVar) {
        if (!kVar.n0()) {
            return d(kVar, gVar);
        }
        if (this.f5607a != null) {
            return a(kVar, gVar, (String[]) null);
        }
        s q02 = gVar.q0();
        Object[] i10 = q02.i();
        int i11 = 0;
        while (true) {
            try {
                String r02 = kVar.r0();
                if (r02 == null) {
                    n n10 = kVar.n();
                    if (n10 == n.END_ARRAY) {
                        String[] strArr = (String[]) q02.g(i10, i11, String.class);
                        gVar.H0(q02);
                        return strArr;
                    } else if (n10 != n.VALUE_NULL) {
                        r02 = _parseString(kVar, gVar);
                    } else if (!this.f5610d) {
                        r02 = (String) this.f5608b.getNullValue(gVar);
                    }
                }
                if (i11 >= i10.length) {
                    i10 = q02.c(i10);
                    i11 = 0;
                }
                int i12 = i11 + 1;
                try {
                    i10[i11] = r02;
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
    }

    /* renamed from: c */
    public String[] deserialize(c3.k kVar, g gVar, String[] strArr) {
        if (!kVar.n0()) {
            String[] d10 = d(kVar, gVar);
            if (d10 == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[(d10.length + length)];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            System.arraycopy(d10, 0, strArr2, length, d10.length);
            return strArr2;
        } else if (this.f5607a != null) {
            return a(kVar, gVar, strArr);
        } else {
            s q02 = gVar.q0();
            int length2 = strArr.length;
            Object[] j10 = q02.j(strArr, length2);
            while (true) {
                try {
                    String r02 = kVar.r0();
                    if (r02 == null) {
                        n n10 = kVar.n();
                        if (n10 == n.END_ARRAY) {
                            String[] strArr3 = (String[]) q02.g(j10, length2, String.class);
                            gVar.H0(q02);
                            return strArr3;
                        } else if (n10 != n.VALUE_NULL) {
                            r02 = _parseString(kVar, gVar);
                        } else if (this.f5610d) {
                            return f5605e;
                        } else {
                            r02 = (String) this.f5608b.getNullValue(gVar);
                        }
                    }
                    if (length2 >= j10.length) {
                        j10 = q02.c(j10);
                        length2 = 0;
                    }
                    int i10 = length2 + 1;
                    try {
                        j10[length2] = r02;
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
        }
    }

    public k createContextual(g gVar, d dVar) {
        k kVar;
        k findConvertingContentDeserializer = findConvertingContentDeserializer(gVar, dVar, this.f5607a);
        j x10 = gVar.x(String.class);
        if (findConvertingContentDeserializer == null) {
            kVar = gVar.D(x10, dVar);
        } else {
            kVar = gVar.Z(findConvertingContentDeserializer, dVar, x10);
        }
        Boolean findFormatFeature = findFormatFeature(gVar, dVar, String[].class, k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        q findContentNullProvider = findContentNullProvider(gVar, dVar, kVar);
        if (kVar != null && isDefaultDeserializer(kVar)) {
            kVar = null;
        }
        if (this.f5607a == kVar && Objects.equals(this.f5609c, findFormatFeature) && this.f5608b == findContentNullProvider) {
            return this;
        }
        return new g0(kVar, findContentNullProvider, findFormatFeature);
    }

    public final String[] d(c3.k kVar, g gVar) {
        boolean z10;
        String str;
        Boolean bool = this.f5609c;
        if (bool == Boolean.TRUE || (bool == null && gVar.n0(h.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (kVar.j0(n.VALUE_NULL)) {
                str = (String) this.f5608b.getNullValue(gVar);
            } else {
                str = _parseString(kVar, gVar);
            }
            return new String[]{str};
        } else if (kVar.j0(n.VALUE_STRING)) {
            return (String[]) _deserializeFromString(kVar, gVar);
        } else {
            return (String[]) gVar.a0(this._valueClass, kVar);
        }
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.d(kVar, gVar);
    }

    public a getEmptyAccessPattern() {
        return a.CONSTANT;
    }

    public Object getEmptyValue(g gVar) {
        return f5605e;
    }

    public f logicalType() {
        return f.Array;
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.TRUE;
    }

    public g0(k3.k kVar, q qVar, Boolean bool) {
        super(String[].class);
        this.f5607a = kVar;
        this.f5608b = qVar;
        this.f5609c = bool;
        this.f5610d = o3.q.b(qVar);
    }
}
