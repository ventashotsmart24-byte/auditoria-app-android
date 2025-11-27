package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import c4.f;
import java.util.Collection;
import java.util.Objects;
import k3.g;
import k3.h;
import k3.j;
import k3.k;
import k3.l;
import n3.i;
import n3.q;
import n3.w;
import w3.e;

public final class h0 extends i implements i {

    /* renamed from: e  reason: collision with root package name */
    public final k f5620e;

    /* renamed from: f  reason: collision with root package name */
    public final w f5621f;

    /* renamed from: g  reason: collision with root package name */
    public final k f5622g;

    public h0(j jVar, k kVar, w wVar) {
        this(jVar, wVar, (k) null, kVar, kVar, (Boolean) null);
    }

    public k a() {
        return this.f5620e;
    }

    /* renamed from: c */
    public Collection deserialize(c3.k kVar, g gVar) {
        k kVar2 = this.f5622g;
        if (kVar2 != null) {
            return (Collection) this.f5621f.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        return deserialize(kVar, gVar, (Collection) this.f5621f.x(gVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k3.k createContextual(k3.g r6, k3.d r7) {
        /*
            r5 = this;
            n3.w r0 = r5.f5621f
            r1 = 0
            if (r0 == 0) goto L_0x0031
            r3.n r0 = r0.z()
            if (r0 == 0) goto L_0x001a
            n3.w r0 = r5.f5621f
            k3.f r2 = r6.k()
            k3.j r0 = r0.A(r2)
            k3.k r0 = r5.findDeserializer(r6, r0, r7)
            goto L_0x0032
        L_0x001a:
            n3.w r0 = r5.f5621f
            r3.n r0 = r0.C()
            if (r0 == 0) goto L_0x0031
            n3.w r0 = r5.f5621f
            k3.f r2 = r6.k()
            k3.j r0 = r0.D(r2)
            k3.k r0 = r5.findDeserializer(r6, r0, r7)
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            k3.k r2 = r5.f5620e
            k3.j r3 = r5.f5623a
            k3.j r3 = r3.k()
            if (r2 != 0) goto L_0x0047
            k3.k r2 = r5.findConvertingContentDeserializer(r6, r7, r2)
            if (r2 != 0) goto L_0x004b
            k3.k r2 = r6.D(r3, r7)
            goto L_0x004b
        L_0x0047:
            k3.k r2 = r6.Z(r2, r7, r3)
        L_0x004b:
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            b3.k$a r4 = b3.k.a.ACCEPT_SINGLE_VALUE_AS_ARRAY
            java.lang.Boolean r3 = r5.findFormatFeature(r6, r7, r3, r4)
            n3.q r6 = r5.findContentNullProvider(r6, r7, r2)
            boolean r7 = r5.isDefaultDeserializer(r2)
            if (r7 == 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r1 = r2
        L_0x005f:
            com.fasterxml.jackson.databind.deser.std.h0 r6 = r5.g(r0, r1, r6, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.h0.createContextual(k3.g, k3.d):k3.k");
    }

    /* renamed from: d */
    public Collection deserialize(c3.k kVar, g gVar, Collection collection) {
        String str;
        if (!kVar.n0()) {
            return f(kVar, gVar, collection);
        }
        k kVar2 = this.f5620e;
        if (kVar2 != null) {
            return e(kVar, gVar, collection, kVar2);
        }
        while (true) {
            try {
                String r02 = kVar.r0();
                if (r02 != null) {
                    collection.add(r02);
                } else {
                    n n10 = kVar.n();
                    if (n10 == n.END_ARRAY) {
                        return collection;
                    }
                    if (n10 != n.VALUE_NULL) {
                        str = _parseString(kVar, gVar);
                    } else if (!this.f5625c) {
                        str = (String) this.f5624b.getNullValue(gVar);
                    }
                    collection.add(str);
                }
            } catch (Exception e10) {
                throw l.p(e10, collection, collection.size());
            }
        }
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.d(kVar, gVar);
    }

    public final Collection e(c3.k kVar, g gVar, Collection collection, k kVar2) {
        String str;
        while (true) {
            try {
                if (kVar.r0() == null) {
                    n n10 = kVar.n();
                    if (n10 == n.END_ARRAY) {
                        return collection;
                    }
                    if (n10 != n.VALUE_NULL) {
                        str = (String) kVar2.deserialize(kVar, gVar);
                    } else if (!this.f5625c) {
                        str = (String) this.f5624b.getNullValue(gVar);
                    }
                } else {
                    str = (String) kVar2.deserialize(kVar, gVar);
                }
                collection.add(str);
            } catch (Exception e10) {
                throw l.p(e10, collection, collection.size());
            }
        }
    }

    public final Collection f(c3.k kVar, g gVar, Collection collection) {
        boolean z10;
        String str;
        Boolean bool = this.f5626d;
        if (bool == Boolean.TRUE || (bool == null && gVar.n0(h.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            k kVar2 = this.f5620e;
            if (kVar.n() == n.VALUE_NULL) {
                if (this.f5625c) {
                    return collection;
                }
                str = (String) this.f5624b.getNullValue(gVar);
            } else if (kVar2 == null) {
                try {
                    str = _parseString(kVar, gVar);
                } catch (Exception e10) {
                    throw l.p(e10, collection, collection.size());
                }
            } else {
                str = (String) kVar2.deserialize(kVar, gVar);
            }
            collection.add(str);
            return collection;
        } else if (kVar.j0(n.VALUE_STRING)) {
            return (Collection) _deserializeFromString(kVar, gVar);
        } else {
            return (Collection) gVar.c0(this.f5623a, kVar);
        }
    }

    public h0 g(k kVar, k kVar2, q qVar, Boolean bool) {
        if (Objects.equals(this.f5626d, bool) && this.f5624b == qVar && this.f5620e == kVar2 && this.f5622g == kVar) {
            return this;
        }
        return new h0(this.f5623a, this.f5621f, kVar, kVar2, qVar, bool);
    }

    public w getValueInstantiator() {
        return this.f5621f;
    }

    public boolean isCachable() {
        if (this.f5620e == null && this.f5622g == null) {
            return true;
        }
        return false;
    }

    public f logicalType() {
        return f.Collection;
    }

    public h0(j jVar, w wVar, k kVar, k kVar2, q qVar, Boolean bool) {
        super(jVar, qVar, bool);
        this.f5620e = kVar2;
        this.f5621f = wVar;
        this.f5622g = kVar;
    }
}
