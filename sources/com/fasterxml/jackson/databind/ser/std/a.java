package com.fasterxml.jackson.databind.ser.std;

import a4.h;
import a4.i;
import b3.k;
import c3.n;
import i3.b;
import java.util.Objects;
import k3.b0;
import k3.c0;
import k3.d;
import k3.o;

public abstract class a extends h implements i {

    /* renamed from: a  reason: collision with root package name */
    public final d f5727a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f5728b;

    public a(Class cls) {
        super(cls);
        this.f5727a = null;
        this.f5728b = null;
    }

    public o b(c0 c0Var, d dVar) {
        k.d findFormatOverrides;
        if (!(dVar == null || (findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType())) == null)) {
            Boolean e10 = findFormatOverrides.e(k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(e10, this.f5728b)) {
                return f(dVar, e10);
            }
        }
        return this;
    }

    public final boolean e(c0 c0Var) {
        Boolean bool = this.f5728b;
        if (bool == null) {
            return c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        }
        return bool.booleanValue();
    }

    public abstract o f(d dVar, Boolean bool);

    public abstract void g(Object obj, c3.h hVar, c0 c0Var);

    public final void serializeWithType(Object obj, c3.h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.d(obj, n.START_ARRAY));
        hVar.z(obj);
        g(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    public a(a aVar, d dVar, Boolean bool) {
        super(aVar._handledType, false);
        this.f5727a = dVar;
        this.f5728b = bool;
    }
}
