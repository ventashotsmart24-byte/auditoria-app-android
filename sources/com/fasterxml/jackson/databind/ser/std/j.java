package com.fasterxml.jackson.databind.ser.std;

import b4.k;
import java.util.Collection;
import java.util.Iterator;
import k3.b0;
import k3.c0;
import k3.d;
import k3.o;
import w3.h;

public class j extends b {
    public j(k3.j jVar, boolean z10, h hVar, o oVar) {
        super(Collection.class, jVar, z10, hVar, oVar);
    }

    public a4.h c(h hVar) {
        return new j(this, this.f5731b, hVar, this.f5735f, this.f5733d);
    }

    /* renamed from: i */
    public boolean isEmpty(c0 c0Var, Collection collection) {
        return collection.isEmpty();
    }

    /* renamed from: j */
    public final void serialize(Collection collection, c3.h hVar, c0 c0Var) {
        int size = collection.size();
        if (size != 1 || ((this.f5733d != null || !c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5733d != Boolean.TRUE)) {
            hVar.u0(collection, size);
            g(collection, hVar, c0Var);
            hVar.V();
            return;
        }
        g(collection, hVar, c0Var);
    }

    /* renamed from: k */
    public void g(Collection collection, c3.h hVar, c0 c0Var) {
        o oVar;
        hVar.z(collection);
        o oVar2 = this.f5735f;
        if (oVar2 != null) {
            l(collection, hVar, c0Var, oVar2);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            k kVar = this.f5736g;
            h hVar2 = this.f5734e;
            int i10 = 0;
            do {
                try {
                    Object next = it.next();
                    if (next == null) {
                        c0Var.E(hVar);
                    } else {
                        Class<?> cls = next.getClass();
                        o j10 = kVar.j(cls);
                        if (j10 == null) {
                            if (this.f5730a.w()) {
                                oVar = f(kVar, c0Var.A(this.f5730a, cls), c0Var);
                            } else {
                                oVar = e(kVar, cls, c0Var);
                            }
                            j10 = oVar;
                            kVar = this.f5736g;
                        }
                        if (hVar2 == null) {
                            j10.serialize(next, hVar, c0Var);
                        } else {
                            j10.serializeWithType(next, hVar, c0Var, hVar2);
                        }
                    }
                    i10++;
                } catch (Exception e10) {
                    wrapAndThrow(c0Var, (Throwable) e10, (Object) collection, i10);
                    return;
                }
            } while (it.hasNext());
        }
    }

    public void l(Collection collection, c3.h hVar, c0 c0Var, o oVar) {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            h hVar2 = this.f5734e;
            int i10 = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        c0Var.E(hVar);
                    } catch (Exception e10) {
                        wrapAndThrow(c0Var, (Throwable) e10, (Object) collection, i10);
                    }
                } else if (hVar2 == null) {
                    oVar.serialize(next, hVar, c0Var);
                } else {
                    oVar.serializeWithType(next, hVar, c0Var, hVar2);
                }
                i10++;
            } while (it.hasNext());
        }
    }

    /* renamed from: m */
    public j h(d dVar, h hVar, o oVar, Boolean bool) {
        return new j(this, dVar, hVar, oVar, bool);
    }

    public j(j jVar, d dVar, h hVar, o oVar, Boolean bool) {
        super((b) jVar, dVar, hVar, oVar, bool);
    }
}
