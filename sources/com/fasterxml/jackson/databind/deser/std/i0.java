package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import c4.f;
import k3.g;
import w3.e;

public class i0 extends e0 {

    /* renamed from: a  reason: collision with root package name */
    public static final i0 f5627a = new i0();

    public i0() {
        super(String.class);
    }

    /* renamed from: a */
    public String deserialize(k kVar, g gVar) {
        String g02;
        if (kVar.j0(n.VALUE_STRING)) {
            return kVar.Y();
        }
        n n10 = kVar.n();
        if (n10 == n.START_ARRAY) {
            return (String) _deserializeFromArray(kVar, gVar);
        }
        if (n10 == n.VALUE_EMBEDDED_OBJECT) {
            Object N = kVar.N();
            if (N == null) {
                return null;
            }
            if (N instanceof byte[]) {
                return gVar.M().i((byte[]) N, false);
            }
            return N.toString();
        } else if (n10 == n.START_OBJECT) {
            return gVar.z(kVar, this, this._valueClass);
        } else {
            if (!n10.e() || (g02 = kVar.g0()) == null) {
                return (String) gVar.a0(this._valueClass, kVar);
            }
            return g02;
        }
    }

    /* renamed from: b */
    public String deserializeWithType(k kVar, g gVar, e eVar) {
        return deserialize(kVar, gVar);
    }

    public Object getEmptyValue(g gVar) {
        return "";
    }

    public boolean isCachable() {
        return true;
    }

    public f logicalType() {
        return f.Textual;
    }
}
