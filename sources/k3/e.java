package k3;

import b3.k0;
import b3.o0;
import c4.o;
import d4.h;
import d4.j;
import java.lang.reflect.Type;
import m3.m;
import r3.b;
import r3.b0;
import w3.c;

public abstract class e {
    public String a(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + ": " + str2;
    }

    public final String b(String str, Object... objArr) {
        if (objArr.length > 0) {
            return String.format(str, objArr);
        }
        return str;
    }

    public String c(String str) {
        if (str == null) {
            return "[N/A]";
        }
        return String.format("\"%s\"", new Object[]{h(str)});
    }

    public final j d(j jVar, String str, c cVar, int i10) {
        m k10 = k();
        c.b b10 = cVar.b(k10, jVar, str.substring(0, i10));
        if (b10 == c.b.DENIED) {
            return (j) g(jVar, str, cVar);
        }
        j A = l().A(str);
        if (!A.N(jVar.q())) {
            return (j) e(jVar, str);
        }
        c.b bVar = c.b.ALLOWED;
        if (b10 == bVar || cVar.c(k10, jVar, A) == bVar) {
            return A;
        }
        return (j) f(jVar, str, cVar);
    }

    public Object e(j jVar, String str) {
        throw m(jVar, str, "Not a subtype");
    }

    public Object f(j jVar, String str, c cVar) {
        throw m(jVar, str, "Configured `PolymorphicTypeValidator` (of type " + h.h(cVar) + ") denied resolution");
    }

    public Object g(j jVar, String str, c cVar) {
        throw m(jVar, str, "Configured `PolymorphicTypeValidator` (of type " + h.h(cVar) + ") denied resolution");
    }

    public final String h(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 500) {
            return str;
        }
        return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
    }

    public j i(Type type) {
        if (type == null) {
            return null;
        }
        return l().H(type);
    }

    public j j(b bVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof Class) {
            Class<j.a> cls = (Class) obj;
            if (cls == j.a.class || h.J(cls)) {
                return null;
            }
            if (j.class.isAssignableFrom(cls)) {
                m k10 = k();
                k10.u();
                return (j) h.l(cls, k10.b());
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }

    public abstract m k();

    public abstract o l();

    public abstract l m(j jVar, String str, String str2);

    public k0 n(b bVar, b0 b0Var) {
        Class c10 = b0Var.c();
        m k10 = k();
        k10.u();
        return ((k0) h.l(c10, k10.b())).b(b0Var.f());
    }

    public o0 o(b bVar, b0 b0Var) {
        Class e10 = b0Var.e();
        m k10 = k();
        k10.u();
        androidx.appcompat.app.m.a(h.l(e10, k10.b()));
        return null;
    }

    public Object p(Class cls, String str) {
        return q(i(cls), str);
    }

    public abstract Object q(j jVar, String str);

    public j r(j jVar, String str, c cVar) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            return d(jVar, str, cVar, indexOf);
        }
        m k10 = k();
        c.b b10 = cVar.b(k10, jVar, str);
        if (b10 == c.b.DENIED) {
            return (j) g(jVar, str, cVar);
        }
        try {
            Class J = l().J(str);
            if (!jVar.O(J)) {
                return (j) e(jVar, str);
            }
            j F = k10.z().F(jVar, J);
            if (b10 != c.b.INDETERMINATE || cVar.c(k10, jVar, F) == c.b.ALLOWED) {
                return F;
            }
            return (j) f(jVar, str, cVar);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e10) {
            throw m(jVar, str, String.format("problem: (%s) %s", new Object[]{e10.getClass().getName(), h.o(e10)}));
        }
    }
}
