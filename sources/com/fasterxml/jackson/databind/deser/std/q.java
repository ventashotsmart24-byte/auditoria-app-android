package com.fasterxml.jackson.databind.deser.std;

import b3.b;
import c3.i;
import d4.b;
import k3.f;
import k3.g;
import k3.x;
import n3.j;
import n3.t;
import n3.w;
import r3.m;
import w3.e;

public class q extends w.a {
    public q() {
        super(i.class);
    }

    public static final int G(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Number) obj).intValue();
    }

    public static final long H(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Number) obj).longValue();
    }

    public static j I(String str, k3.j jVar, int i10) {
        return j.O(x.a(str), jVar, (x) null, (e) null, (b) null, (m) null, i10, (b.a) null, k3.w.f7485h);
    }

    public t[] E(f fVar) {
        k3.j e10 = fVar.e(Integer.TYPE);
        k3.j e11 = fVar.e(Long.TYPE);
        return new t[]{I("sourceRef", fVar.e(Object.class), 0), I("byteOffset", e11, 1), I("charOffset", e11, 2), I("lineNr", e10, 3), I("columnNr", e10, 4)};
    }

    public boolean g() {
        return true;
    }

    public Object t(g gVar, Object[] objArr) {
        return new i(objArr[0], H(objArr[1]), H(objArr[2]), G(objArr[3]), G(objArr[4]));
    }
}
