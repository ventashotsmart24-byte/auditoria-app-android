package com.fasterxml.jackson.databind.deser.std;

import java.util.concurrent.atomic.AtomicReference;
import k3.f;
import k3.g;
import k3.j;
import k3.k;
import n3.w;

public class e extends y {
    public e(j jVar, w wVar, w3.e eVar, k kVar) {
        super(jVar, wVar, eVar, kVar);
    }

    /* renamed from: e */
    public AtomicReference getNullValue(g gVar) {
        return new AtomicReference(this.f5726d.getNullValue(gVar));
    }

    /* renamed from: f */
    public Object a(AtomicReference atomicReference) {
        return atomicReference.get();
    }

    /* renamed from: g */
    public AtomicReference b(Object obj) {
        return new AtomicReference(obj);
    }

    public Object getEmptyValue(g gVar) {
        return getNullValue(gVar);
    }

    /* renamed from: h */
    public AtomicReference c(AtomicReference atomicReference, Object obj) {
        atomicReference.set(obj);
        return atomicReference;
    }

    /* renamed from: i */
    public e d(w3.e eVar, k kVar) {
        return new e(this.f5723a, this.f5724b, eVar, kVar);
    }

    public Boolean supportsUpdate(f fVar) {
        return Boolean.TRUE;
    }
}
