package com.fasterxml.jackson.databind.deser.std;

import c3.n;
import c4.f;
import d4.a;
import k3.d;
import k3.g;
import k3.j;
import k3.k;
import n3.i;
import n3.w;
import w3.e;

public abstract class y extends b0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final j f5723a;

    /* renamed from: b  reason: collision with root package name */
    public final w f5724b;

    /* renamed from: c  reason: collision with root package name */
    public final e f5725c;

    /* renamed from: d  reason: collision with root package name */
    public final k f5726d;

    public y(j jVar, w wVar, e eVar, k kVar) {
        super(jVar);
        this.f5724b = wVar;
        this.f5723a = jVar;
        this.f5726d = kVar;
        this.f5725c = eVar;
    }

    public abstract Object a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object c(Object obj, Object obj2);

    public k createContextual(g gVar, d dVar) {
        k kVar;
        k kVar2 = this.f5726d;
        if (kVar2 == null) {
            kVar = gVar.D(this.f5723a.a(), dVar);
        } else {
            kVar = gVar.Z(kVar2, dVar, this.f5723a.a());
        }
        e eVar = this.f5725c;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        if (kVar == this.f5726d && eVar == this.f5725c) {
            return this;
        }
        return d(eVar, kVar);
    }

    public abstract y d(e eVar, k kVar);

    public Object deserialize(c3.k kVar, g gVar) {
        Object obj;
        w wVar = this.f5724b;
        if (wVar != null) {
            return deserialize(kVar, gVar, wVar.x(gVar));
        }
        e eVar = this.f5725c;
        if (eVar == null) {
            obj = this.f5726d.deserialize(kVar, gVar);
        } else {
            obj = this.f5726d.deserializeWithType(kVar, gVar, eVar);
        }
        return b(obj);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        if (kVar.j0(n.VALUE_NULL)) {
            return getNullValue(gVar);
        }
        e eVar2 = this.f5725c;
        if (eVar2 == null) {
            return deserialize(kVar, gVar);
        }
        return b(eVar2.c(kVar, gVar));
    }

    public a getEmptyAccessPattern() {
        return a.DYNAMIC;
    }

    public a getNullAccessPattern() {
        return a.DYNAMIC;
    }

    public abstract Object getNullValue(g gVar);

    public w getValueInstantiator() {
        return this.f5724b;
    }

    public j getValueType() {
        return this.f5723a;
    }

    public f logicalType() {
        k kVar = this.f5726d;
        if (kVar != null) {
            return kVar.logicalType();
        }
        return super.logicalType();
    }

    public Object deserialize(c3.k kVar, g gVar, Object obj) {
        Object obj2;
        Object obj3;
        if (this.f5726d.supportsUpdate(gVar.k()).equals(Boolean.FALSE) || this.f5725c != null) {
            e eVar = this.f5725c;
            if (eVar == null) {
                obj2 = this.f5726d.deserialize(kVar, gVar);
            } else {
                obj2 = this.f5726d.deserializeWithType(kVar, gVar, eVar);
            }
        } else {
            Object a10 = a(obj);
            if (a10 == null) {
                e eVar2 = this.f5725c;
                if (eVar2 == null) {
                    obj3 = this.f5726d.deserialize(kVar, gVar);
                } else {
                    obj3 = this.f5726d.deserializeWithType(kVar, gVar, eVar2);
                }
                return b(obj3);
            }
            obj2 = this.f5726d.deserialize(kVar, gVar, a10);
        }
        return c(obj, obj2);
    }
}
