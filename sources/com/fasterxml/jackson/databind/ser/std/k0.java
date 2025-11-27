package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import c3.n;
import i3.b;
import java.util.TimeZone;
import k3.c0;

public class k0 extends h0 {
    public k0() {
        super(TimeZone.class);
    }

    /* renamed from: c */
    public void serialize(TimeZone timeZone, h hVar, c0 c0Var) {
        hVar.z0(timeZone.getID());
    }

    /* renamed from: d */
    public void serializeWithType(TimeZone timeZone, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.f(timeZone, TimeZone.class, n.VALUE_STRING));
        serialize(timeZone, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
