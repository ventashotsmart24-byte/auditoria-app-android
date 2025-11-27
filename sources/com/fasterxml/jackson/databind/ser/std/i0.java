package com.fasterxml.jackson.databind.ser.std;

import a4.m;
import b3.k;
import b3.r;
import c3.k;
import d4.h;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;
import k3.b;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import r3.i;
import u3.f;
import v3.c;
import z3.l;
import z3.r;

public abstract class i0 extends o implements c, Serializable {
    private static final Object KEY_CONTENT_CONVERTER_LOCK = new Object();
    private static final long serialVersionUID = 1;
    protected final Class<Object> _handledType;

    public i0(Class cls) {
        this._handledType = cls;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final boolean _nonEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.c(jVar);
    }

    public r createSchemaNode(String str) {
        r k10 = l.f9962d.k();
        k10.C("type", str);
        return k10;
    }

    public o findAnnotatedContentSerializer(c0 c0Var, d dVar) {
        Object g10;
        if (dVar == null) {
            return null;
        }
        i d10 = dVar.d();
        b W = c0Var.W();
        if (d10 == null || (g10 = W.g(d10)) == null) {
            return null;
        }
        return c0Var.t0(d10, g10);
    }

    public o findContextualConvertingSerializer(c0 c0Var, d dVar, o oVar) {
        Object obj = KEY_CONTENT_CONVERTER_LOCK;
        Map map = (Map) c0Var.X(obj);
        if (map == null) {
            map = new IdentityHashMap();
            c0Var.u0(obj, map);
        } else if (map.get(dVar) != null) {
            return oVar;
        }
        map.put(dVar, Boolean.TRUE);
        try {
            o findConvertingContentSerializer = findConvertingContentSerializer(c0Var, dVar, oVar);
            if (findConvertingContentSerializer != null) {
                return c0Var.i0(findConvertingContentSerializer, dVar);
            }
            map.remove(dVar);
            return oVar;
        } finally {
            map.remove(dVar);
        }
    }

    @Deprecated
    public o findConvertingContentSerializer(c0 c0Var, d dVar, o oVar) {
        i d10;
        Object T;
        b W = c0Var.W();
        if (!_neitherNull(W, dVar) || (d10 = dVar.d()) == null || (T = W.T(d10)) == null) {
            return oVar;
        }
        d4.j j10 = c0Var.j(dVar.d(), T);
        j a10 = j10.a(c0Var.l());
        if (oVar == null && !a10.I()) {
            oVar = c0Var.T(a10);
        }
        return new d0(j10, a10, oVar);
    }

    public Boolean findFormatFeature(c0 c0Var, d dVar, Class<?> cls, k.a aVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, cls);
        if (findFormatOverrides != null) {
            return findFormatOverrides.e(aVar);
        }
        return null;
    }

    public k.d findFormatOverrides(c0 c0Var, d dVar, Class<?> cls) {
        if (dVar != null) {
            return dVar.a(c0Var.k(), cls);
        }
        return c0Var.a0(cls);
    }

    public r.b findIncludeOverrides(c0 c0Var, d dVar, Class<?> cls) {
        if (dVar != null) {
            return dVar.b(c0Var.k(), cls);
        }
        return c0Var.b0(cls);
    }

    public m findPropertyFilter(c0 c0Var, Object obj, Object obj2) {
        c0Var.c0();
        Class<Object> handledType = handledType();
        c0Var.p(handledType, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    public k3.m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("string");
    }

    public Class<Object> handledType() {
        return this._handledType;
    }

    public boolean isDefaultSerializer(o oVar) {
        return h.O(oVar);
    }

    public abstract void serialize(Object obj, c3.h hVar, c0 c0Var);

    public void visitArrayFormat(f fVar, j jVar, o oVar, j jVar2) {
        fVar.g(jVar);
        if (_neitherNull((Object) null, oVar)) {
            throw null;
        }
    }

    public void visitFloatFormat(f fVar, j jVar, k.b bVar) {
        fVar.h(jVar);
    }

    public void visitIntFormat(f fVar, j jVar, k.b bVar) {
        fVar.e(jVar);
        if (_neitherNull((Object) null, bVar)) {
            throw null;
        }
    }

    public void visitStringFormat(f fVar, j jVar) {
        fVar.a(jVar);
    }

    public void wrapAndThrow(c0 c0Var, Throwable th, Object obj, String str) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        h.h0(th);
        boolean z10 = c0Var == null || c0Var.m0(b0.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof k3.l)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            h.j0(th);
        }
        throw k3.l.q(th, obj, str);
    }

    public k3.m getSchema(c0 c0Var, Type type, boolean z10) {
        z3.r rVar = (z3.r) getSchema(c0Var, type);
        if (!z10) {
            rVar.D("required", !z10);
        }
        return rVar;
    }

    public void visitStringFormat(f fVar, j jVar, u3.m mVar) {
        fVar.a(jVar);
    }

    public i0(j jVar) {
        this._handledType = jVar.q();
    }

    public z3.r createSchemaNode(String str, boolean z10) {
        z3.r createSchemaNode = createSchemaNode(str);
        if (!z10) {
            createSchemaNode.D("required", !z10);
        }
        return createSchemaNode;
    }

    public void visitArrayFormat(f fVar, j jVar, u3.d dVar) {
        fVar.g(jVar);
    }

    public void visitIntFormat(f fVar, j jVar, k.b bVar, u3.m mVar) {
        fVar.e(jVar);
    }

    public i0(Class cls, boolean z10) {
        this._handledType = cls;
    }

    public i0(i0 i0Var) {
        this._handledType = i0Var._handledType;
    }

    public void wrapAndThrow(c0 c0Var, Throwable th, Object obj, int i10) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        h.h0(th);
        boolean z10 = c0Var == null || c0Var.m0(b0.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof k3.l)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            h.j0(th);
        }
        throw k3.l.p(th, obj, i10);
    }
}
