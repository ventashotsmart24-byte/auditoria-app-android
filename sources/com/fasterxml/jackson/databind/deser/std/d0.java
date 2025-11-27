package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.std.c0;
import d4.h;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import k3.c;
import k3.f;
import k3.j;
import k3.k;
import k3.q;
import n3.p;

public class d0 implements p, Serializable {
    public static k3.p b(f fVar, j jVar, k kVar) {
        return new c0.a(jVar.q(), kVar);
    }

    public static k3.p c(d4.k kVar) {
        return new c0.b(kVar, (r3.j) null);
    }

    public static k3.p d(d4.k kVar, r3.j jVar) {
        return new c0.b(kVar, jVar);
    }

    public static k3.p e(f fVar, j jVar) {
        c g02 = fVar.g0(jVar);
        Class<String> cls = String.class;
        Constructor r10 = g02.r(cls);
        if (r10 != null) {
            if (fVar.b()) {
                h.g(r10, fVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new c0.c(r10);
        }
        Method h10 = g02.h(cls);
        if (h10 == null) {
            return null;
        }
        if (fVar.b()) {
            h.g(h10, fVar.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new c0.d(h10);
    }

    public k3.p a(j jVar, f fVar, c cVar) {
        Class q10 = jVar.q();
        if (q10.isPrimitive()) {
            q10 = h.o0(q10);
        }
        return c0.g(q10);
    }
}
