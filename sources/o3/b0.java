package o3;

import c4.f;
import java.io.Serializable;
import java.util.Collection;
import k3.g;
import k3.k;
import w3.e;

public final class b0 extends k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final e f8456a;

    /* renamed from: b  reason: collision with root package name */
    public final k f8457b;

    public b0(e eVar, k kVar) {
        this.f8456a = eVar;
        this.f8457b = kVar;
    }

    public Object deserialize(c3.k kVar, g gVar) {
        return this.f8457b.deserializeWithType(kVar, gVar, this.f8456a);
    }

    public Object deserializeWithType(c3.k kVar, g gVar, e eVar) {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    public k getDelegatee() {
        return this.f8457b.getDelegatee();
    }

    public Object getEmptyValue(g gVar) {
        return this.f8457b.getEmptyValue(gVar);
    }

    public Collection getKnownPropertyNames() {
        return this.f8457b.getKnownPropertyNames();
    }

    public Object getNullValue(g gVar) {
        return this.f8457b.getNullValue(gVar);
    }

    public Class handledType() {
        return this.f8457b.handledType();
    }

    public f logicalType() {
        return this.f8457b.logicalType();
    }

    public Boolean supportsUpdate(k3.f fVar) {
        return this.f8457b.supportsUpdate(fVar);
    }

    public Object deserialize(c3.k kVar, g gVar, Object obj) {
        return this.f8457b.deserialize(kVar, gVar, obj);
    }
}
