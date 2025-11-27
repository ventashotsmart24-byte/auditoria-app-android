package com.fasterxml.jackson.databind.deser.std;

import d4.a;
import d4.h;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import k3.f;
import k3.g;
import k3.j;
import k3.k;
import k3.l;
import n3.q;
import n3.t;
import n3.w;

public abstract class i extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public final j f5623a;

    /* renamed from: b  reason: collision with root package name */
    public final q f5624b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5625c;

    /* renamed from: d  reason: collision with root package name */
    public final Boolean f5626d;

    public i(j jVar, q qVar, Boolean bool) {
        super(jVar);
        this.f5623a = jVar;
        this.f5626d = bool;
        this.f5624b = qVar;
        this.f5625c = o3.q.b(qVar);
    }

    public abstract k a();

    public Object b(g gVar, Throwable th, Object obj, String str) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        h.h0(th);
        if (gVar != null && !gVar.n0(k3.h.WRAP_EXCEPTIONS)) {
            h.j0(th);
        }
        if (!(th instanceof IOException) || (th instanceof l)) {
            throw l.q(th, obj, (String) h.Y(str, "N/A"));
        }
        throw ((IOException) th);
    }

    public t findBackReference(String str) {
        k a10 = a();
        if (a10 != null) {
            return a10.findBackReference(str);
        }
        throw new IllegalArgumentException(String.format("Cannot handle managed/back reference '%s': type: container deserializer of type %s returned null for 'getContentDeserializer()'", new Object[]{str, getClass().getName()}));
    }

    public a getEmptyAccessPattern() {
        return a.DYNAMIC;
    }

    public Object getEmptyValue(g gVar) {
        w valueInstantiator = getValueInstantiator();
        if (valueInstantiator == null || !valueInstantiator.j()) {
            j valueType = getValueType();
            gVar.q(valueType, String.format("Cannot create empty instance of %s, no default Creator", new Object[]{valueType}));
        }
        try {
            return valueInstantiator.x(gVar);
        } catch (IOException e10) {
            return h.g0(gVar, e10);
        }
    }

    public j getValueType() {
        return this.f5623a;
    }

    public Boolean supportsUpdate(f fVar) {
        return Boolean.TRUE;
    }

    public i(j jVar) {
        this(jVar, (q) null, (Boolean) null);
    }

    public i(i iVar) {
        this(iVar, iVar.f5624b, iVar.f5626d);
    }

    public i(i iVar, q qVar, Boolean bool) {
        super(iVar.f5623a);
        this.f5623a = iVar.f5623a;
        this.f5624b = qVar;
        this.f5626d = bool;
        this.f5625c = o3.q.b(qVar);
    }
}
