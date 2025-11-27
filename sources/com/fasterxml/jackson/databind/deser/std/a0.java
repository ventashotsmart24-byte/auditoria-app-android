package com.fasterxml.jackson.databind.deser.std;

import c4.f;
import d4.h;
import d4.j;
import k3.d;
import k3.g;
import k3.k;
import n3.i;
import n3.r;
import w3.e;

public class a0 extends b0 implements i, r {

    /* renamed from: a  reason: collision with root package name */
    public final j f5569a;

    /* renamed from: b  reason: collision with root package name */
    public final k3.j f5570b;

    /* renamed from: c  reason: collision with root package name */
    public final k f5571c;

    public a0(j jVar) {
        super(Object.class);
        this.f5569a = jVar;
        this.f5570b = null;
        this.f5571c = null;
    }

    public Object a(c3.k kVar, g gVar, Object obj) {
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)" + obj.getClass().getName(), new Object[]{this.f5570b}));
    }

    public Object b(Object obj) {
        return this.f5569a.convert(obj);
    }

    public a0 c(j jVar, k3.j jVar2, k kVar) {
        h.n0(a0.class, this, "withDelegate");
        return new a0(jVar, jVar2, kVar);
    }

    public k createContextual(g gVar, d dVar) {
        k kVar = this.f5571c;
        if (kVar != null) {
            k Z = gVar.Z(kVar, dVar, this.f5570b);
            if (Z != this.f5571c) {
                return c(this.f5569a, this.f5570b, Z);
            }
            return this;
        }
        k3.j b10 = this.f5569a.b(gVar.l());
        return c(this.f5569a, b10, gVar.D(b10, dVar));
    }

    public Object deserialize(c3.k kVar, g gVar) {
        Object deserialize = this.f5571c.deserialize(kVar, gVar);
        if (deserialize == null) {
            return null;
        }
        return b(deserialize);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        Object deserialize = this.f5571c.deserialize(kVar, gVar);
        if (deserialize == null) {
            return null;
        }
        return b(deserialize);
    }

    public k getDelegatee() {
        return this.f5571c;
    }

    public Class handledType() {
        return this.f5571c.handledType();
    }

    public f logicalType() {
        return this.f5571c.logicalType();
    }

    public void resolve(g gVar) {
        k kVar = this.f5571c;
        if (kVar != null && (kVar instanceof r)) {
            ((r) kVar).resolve(gVar);
        }
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return this.f5571c.supportsUpdate(fVar);
    }

    public Object deserialize(c3.k kVar, g gVar, Object obj) {
        if (this.f5570b.q().isAssignableFrom(obj.getClass())) {
            return this.f5571c.deserialize(kVar, gVar, obj);
        }
        return a(kVar, gVar, obj);
    }

    public a0(j jVar, k3.j jVar2, k kVar) {
        super(jVar2);
        this.f5569a = jVar;
        this.f5570b = jVar2;
        this.f5571c = kVar;
    }
}
