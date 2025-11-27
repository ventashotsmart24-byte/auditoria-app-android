package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import c4.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k3.g;
import k3.j;
import k3.k;
import k3.l;
import n3.i;
import n3.q;
import n3.u;
import n3.w;
import o3.z;
import w3.e;

public class h extends i implements i {

    /* renamed from: e  reason: collision with root package name */
    public final k f5611e;

    /* renamed from: f  reason: collision with root package name */
    public final e f5612f;

    /* renamed from: g  reason: collision with root package name */
    public final w f5613g;

    /* renamed from: h  reason: collision with root package name */
    public final k f5614h;

    public static final class a extends z.a {

        /* renamed from: c  reason: collision with root package name */
        public final b f5615c;

        /* renamed from: d  reason: collision with root package name */
        public final List f5616d = new ArrayList();

        public a(b bVar, u uVar, Class cls) {
            super(uVar, cls);
            this.f5615c = bVar;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class f5617a;

        /* renamed from: b  reason: collision with root package name */
        public final Collection f5618b;

        /* renamed from: c  reason: collision with root package name */
        public List f5619c = new ArrayList();

        public b(Class cls, Collection collection) {
            this.f5617a = cls;
            this.f5618b = collection;
        }

        public void a(Object obj) {
            if (this.f5619c.isEmpty()) {
                this.f5618b.add(obj);
                return;
            }
            List list = this.f5619c;
            ((a) list.get(list.size() - 1)).f5616d.add(obj);
        }

        public z.a b(u uVar) {
            a aVar = new a(this, uVar, this.f5617a);
            this.f5619c.add(aVar);
            return aVar;
        }
    }

    public h(j jVar, k kVar, e eVar, w wVar) {
        this(jVar, kVar, eVar, wVar, (k) null, (q) null, (Boolean) null);
    }

    public k a() {
        return this.f5611e;
    }

    public Collection c(c3.k kVar, g gVar, Collection collection) {
        boolean z10;
        Object obj;
        kVar.A0(collection);
        k kVar2 = this.f5611e;
        if (kVar2.getObjectIdReader() != null) {
            return e(kVar, gVar, collection);
        }
        e eVar = this.f5612f;
        while (true) {
            n s02 = kVar.s0();
            if (s02 == n.END_ARRAY) {
                return collection;
            }
            try {
                if (s02 == n.VALUE_NULL) {
                    if (!this.f5625c) {
                        obj = this.f5624b.getNullValue(gVar);
                    }
                } else if (eVar == null) {
                    obj = kVar2.deserialize(kVar, gVar);
                } else {
                    obj = kVar2.deserializeWithType(kVar, gVar, eVar);
                }
                collection.add(obj);
            } catch (Exception e10) {
                if (gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    d4.h.j0(e10);
                }
                throw l.p(e10, collection, collection.size());
            }
        }
    }

    public Collection d(c3.k kVar, g gVar, String str) {
        Class<?> handledType = handledType();
        if (str.isEmpty()) {
            m3.b _checkCoercionFail = _checkCoercionFail(gVar, gVar.B(logicalType(), handledType, m3.e.EmptyString), handledType, str, "empty String (\"\")");
            if (_checkCoercionFail != null) {
                return (Collection) _deserializeFromEmptyString(kVar, gVar, _checkCoercionFail, handledType, "empty String (\"\")");
            }
        } else if (b0._isBlank(str)) {
            return (Collection) _deserializeFromEmptyString(kVar, gVar, gVar.C(logicalType(), handledType, m3.b.Fail), handledType, "blank String (all whitespace)");
        }
        return j(kVar, gVar, g(gVar));
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.d(kVar, gVar);
    }

    public Collection e(c3.k kVar, g gVar, Collection collection) {
        boolean z10;
        Object obj;
        if (!kVar.n0()) {
            return j(kVar, gVar, collection);
        }
        kVar.A0(collection);
        k kVar2 = this.f5611e;
        e eVar = this.f5612f;
        b bVar = new b(this.f5623a.k().q(), collection);
        while (true) {
            n s02 = kVar.s0();
            if (s02 == n.END_ARRAY) {
                return collection;
            }
            try {
                if (s02 == n.VALUE_NULL) {
                    if (!this.f5625c) {
                        obj = this.f5624b.getNullValue(gVar);
                    }
                } else if (eVar == null) {
                    obj = kVar2.deserialize(kVar, gVar);
                } else {
                    obj = kVar2.deserializeWithType(kVar, gVar, eVar);
                }
                bVar.a(obj);
            } catch (u e10) {
                e10.t().a(bVar.b(e10));
            } catch (Exception e11) {
                if (gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    d4.h.j0(e11);
                }
                throw l.p(e11, collection, collection.size());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b6  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.deser.std.h createContextual(k3.g r8, k3.d r9) {
        /*
            r7 = this;
            n3.w r0 = r7.f5613g
            if (r0 == 0) goto L_0x006d
            boolean r0 = r0.k()
            r1 = 1
            r2 = 0
            r3 = 2
            if (r0 == 0) goto L_0x0039
            n3.w r0 = r7.f5613g
            k3.f r4 = r8.k()
            k3.j r0 = r0.D(r4)
            if (r0 != 0) goto L_0x0034
            k3.j r4 = r7.f5623a
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r4
            n3.w r2 = r7.f5613g
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            r3[r1] = r2
            java.lang.String r1 = "Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'"
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r8.q(r4, r1)
        L_0x0034:
            k3.k r0 = r7.findDeserializer(r8, r0, r9)
            goto L_0x006e
        L_0x0039:
            n3.w r0 = r7.f5613g
            boolean r0 = r0.i()
            if (r0 == 0) goto L_0x006d
            n3.w r0 = r7.f5613g
            k3.f r4 = r8.k()
            k3.j r0 = r0.A(r4)
            if (r0 != 0) goto L_0x0068
            k3.j r4 = r7.f5623a
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r4
            n3.w r2 = r7.f5613g
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            r3[r1] = r2
            java.lang.String r1 = "Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'"
            java.lang.String r1 = java.lang.String.format(r1, r3)
            r8.q(r4, r1)
        L_0x0068:
            k3.k r0 = r7.findDeserializer(r8, r0, r9)
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            r2 = r0
            java.lang.Class<java.util.Collection> r0 = java.util.Collection.class
            b3.k$a r1 = b3.k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY
            java.lang.Boolean r6 = r7.findFormatFeature(r8, r9, r0, r1)
            k3.k r0 = r7.f5611e
            k3.k r0 = r7.findConvertingContentDeserializer(r8, r9, r0)
            k3.j r1 = r7.f5623a
            k3.j r1 = r1.k()
            if (r0 != 0) goto L_0x008a
            k3.k r0 = r8.D(r1, r9)
            goto L_0x008e
        L_0x008a:
            k3.k r0 = r8.Z(r0, r9, r1)
        L_0x008e:
            r3 = r0
            w3.e r0 = r7.f5612f
            if (r0 == 0) goto L_0x0097
            w3.e r0 = r0.g(r9)
        L_0x0097:
            r4 = r0
            n3.q r5 = r7.findContentNullProvider(r8, r9, r3)
            java.lang.Boolean r8 = r7.f5626d
            boolean r8 = java.util.Objects.equals(r6, r8)
            if (r8 == 0) goto L_0x00b6
            n3.q r8 = r7.f5624b
            if (r5 != r8) goto L_0x00b6
            k3.k r8 = r7.f5614h
            if (r2 != r8) goto L_0x00b6
            k3.k r8 = r7.f5611e
            if (r3 != r8) goto L_0x00b6
            w3.e r8 = r7.f5612f
            if (r4 == r8) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            return r7
        L_0x00b6:
            r1 = r7
            com.fasterxml.jackson.databind.deser.std.h r8 = r1.k(r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.h.createContextual(k3.g, k3.d):com.fasterxml.jackson.databind.deser.std.h");
    }

    public Collection g(g gVar) {
        return (Collection) this.f5613g.x(gVar);
    }

    public w getValueInstantiator() {
        return this.f5613g;
    }

    /* renamed from: h */
    public Collection deserialize(c3.k kVar, g gVar) {
        k kVar2 = this.f5614h;
        if (kVar2 != null) {
            return (Collection) this.f5613g.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (kVar.n0()) {
            return c(kVar, gVar, g(gVar));
        }
        if (kVar.j0(n.VALUE_STRING)) {
            return d(kVar, gVar, kVar.Y());
        }
        return j(kVar, gVar, g(gVar));
    }

    /* renamed from: i */
    public Collection deserialize(c3.k kVar, g gVar, Collection collection) {
        if (kVar.n0()) {
            return c(kVar, gVar, collection);
        }
        return j(kVar, gVar, collection);
    }

    public boolean isCachable() {
        if (this.f5611e == null && this.f5612f == null && this.f5614h == null) {
            return true;
        }
        return false;
    }

    public final Collection j(c3.k kVar, g gVar, Collection collection) {
        boolean z10;
        Object obj;
        Boolean bool = this.f5626d;
        if (bool == Boolean.TRUE || (bool == null && gVar.n0(k3.h.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return (Collection) gVar.c0(this.f5623a, kVar);
        }
        k kVar2 = this.f5611e;
        e eVar = this.f5612f;
        try {
            if (kVar.j0(n.VALUE_NULL)) {
                if (this.f5625c) {
                    return collection;
                }
                obj = this.f5624b.getNullValue(gVar);
            } else if (eVar == null) {
                obj = kVar2.deserialize(kVar, gVar);
            } else {
                obj = kVar2.deserializeWithType(kVar, gVar, eVar);
            }
            collection.add(obj);
            return collection;
        } catch (Exception e10) {
            if (!gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
                d4.h.j0(e10);
            }
            throw l.p(e10, Object.class, collection.size());
        }
    }

    public h k(k kVar, k kVar2, e eVar, q qVar, Boolean bool) {
        return new h(this.f5623a, kVar2, eVar, this.f5613g, kVar, qVar, bool);
    }

    public f logicalType() {
        return f.Collection;
    }

    public h(j jVar, k kVar, e eVar, w wVar, k kVar2, q qVar, Boolean bool) {
        super(jVar, qVar, bool);
        this.f5611e = kVar;
        this.f5612f = eVar;
        this.f5613g = wVar;
        this.f5614h = kVar2;
    }
}
