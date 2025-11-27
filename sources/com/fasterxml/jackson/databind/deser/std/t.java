package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import c4.f;
import java.util.AbstractMap;
import java.util.Map;
import k3.d;
import k3.g;
import k3.j;
import k3.k;
import k3.p;
import n3.i;
import w3.e;

public class t extends i implements i {

    /* renamed from: e  reason: collision with root package name */
    public final p f5684e;

    /* renamed from: f  reason: collision with root package name */
    public final k f5685f;

    /* renamed from: g  reason: collision with root package name */
    public final e f5686g;

    public t(j jVar, p pVar, k kVar, e eVar) {
        super(jVar);
        if (jVar.g() == 2) {
            this.f5684e = pVar;
            this.f5685f = kVar;
            this.f5686g = eVar;
            return;
        }
        throw new IllegalArgumentException("Missing generic type information for " + jVar);
    }

    public k a() {
        return this.f5685f;
    }

    /* renamed from: c */
    public Map.Entry deserialize(c3.k kVar, g gVar) {
        Object obj;
        n n10 = kVar.n();
        if (n10 == n.START_OBJECT) {
            n10 = kVar.s0();
        } else if (!(n10 == n.FIELD_NAME || n10 == n.END_OBJECT)) {
            if (n10 == n.START_ARRAY) {
                return (Map.Entry) _deserializeFromArray(kVar, gVar);
            }
            return (Map.Entry) gVar.c0(getValueType(gVar), kVar);
        }
        if (n10 == n.FIELD_NAME) {
            p pVar = this.f5684e;
            k kVar2 = this.f5685f;
            e eVar = this.f5686g;
            String m10 = kVar.m();
            Object a10 = pVar.a(m10, gVar);
            try {
                if (kVar.s0() == n.VALUE_NULL) {
                    obj = kVar2.getNullValue(gVar);
                } else if (eVar == null) {
                    obj = kVar2.deserialize(kVar, gVar);
                } else {
                    obj = kVar2.deserializeWithType(kVar, gVar, eVar);
                }
            } catch (Exception e10) {
                b(gVar, e10, Map.Entry.class, m10);
                obj = null;
            }
            n s02 = kVar.s0();
            if (s02 == n.END_OBJECT) {
                return new AbstractMap.SimpleEntry(a10, obj);
            }
            if (s02 == n.FIELD_NAME) {
                gVar.z0(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", kVar.m());
            } else {
                gVar.z0(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + s02, new Object[0]);
            }
            return null;
        } else if (n10 == n.END_OBJECT) {
            return (Map.Entry) gVar.z0(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
        } else {
            return (Map.Entry) gVar.a0(handledType(), kVar);
        }
    }

    public k createContextual(g gVar, d dVar) {
        k kVar;
        p pVar = this.f5684e;
        if (pVar == null) {
            pVar = gVar.F(this.f5623a.f(0), dVar);
        }
        k findConvertingContentDeserializer = findConvertingContentDeserializer(gVar, dVar, this.f5685f);
        j f10 = this.f5623a.f(1);
        if (findConvertingContentDeserializer == null) {
            kVar = gVar.D(f10, dVar);
        } else {
            kVar = gVar.Z(findConvertingContentDeserializer, dVar, f10);
        }
        e eVar = this.f5686g;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        return e(pVar, eVar, kVar);
    }

    /* renamed from: d */
    public Map.Entry deserialize(c3.k kVar, g gVar, Map.Entry entry) {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.e(kVar, gVar);
    }

    public t e(p pVar, e eVar, k kVar) {
        if (this.f5684e == pVar && this.f5685f == kVar && this.f5686g == eVar) {
            return this;
        }
        return new t(this, pVar, kVar, eVar);
    }

    public f logicalType() {
        return f.Map;
    }

    public t(t tVar, p pVar, k kVar, e eVar) {
        super((i) tVar);
        this.f5684e = pVar;
        this.f5685f = kVar;
        this.f5686g = eVar;
    }
}
