package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import k3.f;
import k3.g;
import w3.e;

public class u extends b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u f5687a = new u();

    public u() {
        super(Object.class);
    }

    public Object deserialize(k kVar, g gVar) {
        if (kVar.j0(n.FIELD_NAME)) {
            while (true) {
                n s02 = kVar.s0();
                if (s02 == null || s02 == n.END_OBJECT) {
                    return null;
                }
                kVar.D0();
            }
        } else {
            kVar.D0();
            return null;
        }
    }

    public Object deserializeWithType(k kVar, g gVar, e eVar) {
        int q10 = kVar.q();
        if (q10 == 1 || q10 == 3 || q10 == 5) {
            return eVar.c(kVar, gVar);
        }
        return null;
    }

    public Boolean supportsUpdate(f fVar) {
        return Boolean.FALSE;
    }
}
