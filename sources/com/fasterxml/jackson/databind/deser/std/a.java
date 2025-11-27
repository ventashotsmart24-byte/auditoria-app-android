package com.fasterxml.jackson.databind.deser.std;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import k3.g;
import k3.j;
import k3.k;
import n3.q;
import n3.w;
import w3.e;

public class a extends h {
    public a(j jVar, k kVar, e eVar, w wVar) {
        super(jVar, kVar, eVar, wVar);
    }

    public Collection c(c3.k kVar, g gVar, Collection collection) {
        if (collection == null) {
            collection = new ArrayList();
        }
        Collection c10 = super.c(kVar, gVar, collection);
        if (c10.isEmpty()) {
            return new ArrayBlockingQueue(1, false);
        }
        return new ArrayBlockingQueue(c10.size(), false, c10);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        return eVar.d(kVar, gVar);
    }

    public Collection g(g gVar) {
        return null;
    }

    /* renamed from: l */
    public a k(k kVar, k kVar2, e eVar, q qVar, Boolean bool) {
        return new a(this.f5623a, kVar2, eVar, this.f5613g, kVar, qVar, bool);
    }

    public a(j jVar, k kVar, e eVar, w wVar, k kVar2, q qVar, Boolean bool) {
        super(jVar, kVar, eVar, wVar, kVar2, qVar, bool);
    }
}
