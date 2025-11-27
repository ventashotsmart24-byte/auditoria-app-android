package c4;

import d4.h;
import d4.n;
import d4.p;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import k3.j;
import k3.m;

public class o implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final j[] f4863e = new j[0];

    /* renamed from: f  reason: collision with root package name */
    public static final o f4864f = new o();

    /* renamed from: g  reason: collision with root package name */
    public static final n f4865g = n.i();

    /* renamed from: h  reason: collision with root package name */
    public static final Class f4866h;

    /* renamed from: i  reason: collision with root package name */
    public static final Class f4867i;

    /* renamed from: j  reason: collision with root package name */
    public static final Class f4868j;

    /* renamed from: k  reason: collision with root package name */
    public static final Class f4869k;

    /* renamed from: l  reason: collision with root package name */
    public static final Class f4870l;

    /* renamed from: m  reason: collision with root package name */
    public static final Class f4871m;

    /* renamed from: n  reason: collision with root package name */
    public static final Class f4872n;

    /* renamed from: o  reason: collision with root package name */
    public static final Class f4873o;

    /* renamed from: p  reason: collision with root package name */
    public static final Class f4874p;

    /* renamed from: q  reason: collision with root package name */
    public static final l f4875q;

    /* renamed from: r  reason: collision with root package name */
    public static final l f4876r;

    /* renamed from: s  reason: collision with root package name */
    public static final l f4877s;

    /* renamed from: t  reason: collision with root package name */
    public static final l f4878t;

    /* renamed from: u  reason: collision with root package name */
    public static final l f4879u;

    /* renamed from: v  reason: collision with root package name */
    public static final l f4880v;

    /* renamed from: w  reason: collision with root package name */
    public static final l f4881w;

    /* renamed from: x  reason: collision with root package name */
    public static final l f4882x;

    /* renamed from: y  reason: collision with root package name */
    public static final l f4883y;

    /* renamed from: a  reason: collision with root package name */
    public final p f4884a;

    /* renamed from: b  reason: collision with root package name */
    public final p[] f4885b;

    /* renamed from: c  reason: collision with root package name */
    public final q f4886c;

    /* renamed from: d  reason: collision with root package name */
    public final ClassLoader f4887d;

    static {
        Class<String> cls = String.class;
        f4866h = cls;
        Class<Object> cls2 = Object.class;
        f4867i = cls2;
        Class<Comparable> cls3 = Comparable.class;
        f4868j = cls3;
        Class<Class> cls4 = Class.class;
        f4869k = cls4;
        Class<Enum> cls5 = Enum.class;
        f4870l = cls5;
        Class<m> cls6 = m.class;
        f4871m = cls6;
        Class cls7 = Boolean.TYPE;
        f4872n = cls7;
        Class cls8 = Integer.TYPE;
        f4873o = cls8;
        Class cls9 = Long.TYPE;
        f4874p = cls9;
        f4875q = new l(cls7);
        f4876r = new l(cls8);
        f4877s = new l(cls9);
        f4878t = new l(cls);
        f4879u = new l(cls2);
        f4880v = new l(cls3);
        f4881w = new l(cls5);
        f4882x = new l(cls4);
        f4883y = new l(cls6);
    }

    public o() {
        this((p) null);
    }

    public static o I() {
        return f4864f;
    }

    public static j O() {
        return I().u();
    }

    public j A(String str) {
        return this.f4886c.c(str);
    }

    public j B(j jVar, Class cls) {
        Class q10 = jVar.q();
        if (q10 == cls) {
            return jVar;
        }
        j i10 = jVar.i(cls);
        if (i10 != null) {
            return i10;
        }
        if (!cls.isAssignableFrom(q10)) {
            throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", new Object[]{cls.getName(), jVar}));
        }
        throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", new Object[]{cls.getName(), jVar}));
    }

    public h C(Class cls, Class cls2, Class cls3) {
        j jVar;
        j jVar2;
        if (cls == Properties.class) {
            jVar2 = f4878t;
            jVar = jVar2;
        } else {
            n nVar = f4865g;
            jVar2 = i((c) null, cls2, nVar);
            jVar = i((c) null, cls3, nVar);
        }
        return D(cls, jVar2, jVar);
    }

    public h D(Class cls, j jVar, j jVar2) {
        n h10 = n.h(cls, new j[]{jVar, jVar2});
        h hVar = (h) i((c) null, cls, h10);
        if (h10.n()) {
            j i10 = hVar.i(Map.class);
            j p10 = i10.p();
            if (p10.equals(jVar)) {
                j k10 = i10.k();
                if (!k10.equals(jVar2)) {
                    throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", new Object[]{h.X(cls), jVar2, k10}));
                }
            } else {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", new Object[]{h.X(cls), jVar, p10}));
            }
        }
        return hVar;
    }

    public j E(Class cls, n nVar) {
        return a(cls, i((c) null, cls, nVar));
    }

    public j F(j jVar, Class cls) {
        return G(jVar, cls, false);
    }

    public j G(j jVar, Class cls, boolean z10) {
        j jVar2;
        Class<EnumSet> q10 = jVar.q();
        if (q10 == cls) {
            return jVar;
        }
        if (q10 == Object.class) {
            jVar2 = i((c) null, cls, f4865g);
        } else if (q10.isAssignableFrom(cls)) {
            if (jVar.D()) {
                if (jVar.J()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        jVar2 = i((c) null, cls, n.d(cls, jVar.p(), jVar.k()));
                    }
                } else if (jVar.B()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        jVar2 = i((c) null, cls, n.c(cls, jVar.k()));
                    } else if (q10 == EnumSet.class) {
                        return jVar;
                    }
                }
            }
            if (jVar.j().n()) {
                jVar2 = i((c) null, cls, f4865g);
            } else {
                int length = cls.getTypeParameters().length;
                if (length == 0) {
                    jVar2 = i((c) null, cls, f4865g);
                } else {
                    jVar2 = i((c) null, cls, b(jVar, length, cls, z10));
                }
            }
        } else {
            throw new IllegalArgumentException(String.format("Class %s not subtype of %s", new Object[]{h.X(cls), h.G(jVar)}));
        }
        return jVar2.U(jVar);
    }

    public j H(Type type) {
        return g((c) null, type, f4865g);
    }

    public Class J(String str) {
        Throwable th;
        Class e10;
        if (str.indexOf(46) < 0 && (e10 = e(str)) != null) {
            return e10;
        }
        ClassLoader L = L();
        if (L == null) {
            L = Thread.currentThread().getContextClassLoader();
        }
        if (L != null) {
            try {
                return x(str, true, L);
            } catch (Exception e11) {
                th = h.F(e11);
            }
        } else {
            th = null;
            try {
                return w(str);
            } catch (Exception e12) {
                if (th == null) {
                    th = h.F(e12);
                }
                h.j0(th);
                throw new ClassNotFoundException(th.getMessage(), th);
            }
        }
    }

    public j[] K(j jVar, Class cls) {
        j i10 = jVar.i(cls);
        if (i10 == null) {
            return f4863e;
        }
        return i10.j().p();
    }

    public ClassLoader L() {
        return this.f4887d;
    }

    public j M(Type type, n nVar) {
        return g((c) null, type, nVar);
    }

    public j N(Class cls) {
        return d(cls, f4865g, (j) null, (j[]) null);
    }

    public j a(Type type, j jVar) {
        if (this.f4885b == null) {
            return jVar;
        }
        jVar.j();
        p[] pVarArr = this.f4885b;
        if (pVarArr.length <= 0) {
            return jVar;
        }
        p pVar = pVarArr[0];
        throw null;
    }

    public final n b(j jVar, int i10, Class cls, boolean z10) {
        i[] iVarArr = new i[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iVarArr[i11] = new i(i11);
        }
        j i12 = i((c) null, cls, n.e(cls, iVarArr)).i(jVar.q());
        if (i12 != null) {
            String t10 = t(jVar, i12);
            if (t10 == null || z10) {
                j[] jVarArr = new j[i10];
                for (int i13 = 0; i13 < i10; i13++) {
                    j c02 = iVarArr[i13].c0();
                    if (c02 == null) {
                        c02 = O();
                    }
                    jVarArr[i13] = c02;
                }
                return n.e(cls, jVarArr);
            }
            throw new IllegalArgumentException("Failed to specialize base type " + jVar.c() + " as " + cls.getName() + ", problem: " + t10);
        }
        throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", new Object[]{jVar.q().getName(), cls.getName()}));
    }

    public final j c(Class cls, n nVar, j jVar, j[] jVarArr) {
        j jVar2;
        List l10 = nVar.l();
        if (l10.isEmpty()) {
            jVar2 = u();
        } else if (l10.size() == 1) {
            jVar2 = (j) l10.get(0);
        } else {
            throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": cannot determine type parameters");
        }
        return e.b0(cls, nVar, jVar, jVarArr, jVar2);
    }

    public j d(Class cls, n nVar, j jVar, j[] jVarArr) {
        j f10;
        if (!nVar.n() || (f10 = f(cls)) == null) {
            return p(cls, nVar, jVar, jVarArr);
        }
        return f10;
    }

    public Class e(String str) {
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        if ("char".equals(str)) {
            return Character.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("void".equals(str)) {
            return Void.TYPE;
        }
        return null;
    }

    public j f(Class cls) {
        if (cls.isPrimitive()) {
            if (cls == f4872n) {
                return f4875q;
            }
            if (cls == f4873o) {
                return f4876r;
            }
            if (cls == f4874p) {
                return f4877s;
            }
            return null;
        } else if (cls == f4866h) {
            return f4878t;
        } else {
            if (cls == f4867i) {
                return f4879u;
            }
            if (cls == f4871m) {
                return f4883y;
            }
            return null;
        }
    }

    public j g(c cVar, Type type, n nVar) {
        j jVar;
        String str;
        if (type instanceof Class) {
            jVar = i(cVar, (Class) type, f4865g);
        } else if (type instanceof ParameterizedType) {
            jVar = j(cVar, (ParameterizedType) type, nVar);
        } else if (type instanceof j) {
            return (j) type;
        } else {
            if (type instanceof GenericArrayType) {
                jVar = h(cVar, (GenericArrayType) type, nVar);
            } else if (type instanceof TypeVariable) {
                jVar = k(cVar, (TypeVariable) type, nVar);
            } else if (type instanceof WildcardType) {
                jVar = n(cVar, (WildcardType) type, nVar);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized Type: ");
                if (type == null) {
                    str = "[null]";
                } else {
                    str = type.toString();
                }
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return a(type, jVar);
    }

    public j h(c cVar, GenericArrayType genericArrayType, n nVar) {
        return a.b0(g(cVar, genericArrayType.getGenericComponentType(), nVar), nVar);
    }

    public j i(c cVar, Class cls, n nVar) {
        Object obj;
        c cVar2;
        j jVar;
        j jVar2;
        j[] jVarArr;
        j f10 = f(cls);
        if (f10 != null) {
            return f10;
        }
        if (nVar == null || nVar.n()) {
            obj = cls;
        } else {
            obj = nVar.a(cls);
        }
        j jVar3 = (j) this.f4884a.get(obj);
        if (jVar3 != null) {
            return jVar3;
        }
        if (cVar == null) {
            cVar2 = new c(cls);
        } else {
            c c10 = cVar.c(cls);
            if (c10 != null) {
                k kVar = new k(cls, f4865g);
                c10.a(kVar);
                return kVar;
            }
            cVar2 = cVar.b(cls);
        }
        if (cls.isArray()) {
            jVar = a.b0(g(cVar2, cls.getComponentType(), nVar), nVar);
        } else {
            if (cls.isInterface()) {
                jVarArr = s(cVar2, cls, nVar);
                jVar2 = null;
            } else {
                jVar2 = r(cVar2, cls, nVar);
                jVarArr = s(cVar2, cls, nVar);
            }
            j[] jVarArr2 = jVarArr;
            j jVar4 = jVar2;
            if (cls == Properties.class) {
                l lVar = f4878t;
                jVar3 = h.d0(cls, nVar, jVar4, jVarArr2, lVar, lVar);
            } else if (jVar4 != null) {
                jVar3 = jVar4.P(cls, nVar, jVar4, jVarArr2);
            }
            if (jVar3 == null && (jVar3 = l(cVar2, cls, nVar, jVar4, jVarArr2)) == null && (jVar3 = m(cVar2, cls, nVar, jVar4, jVarArr2)) == null) {
                jVar = p(cls, nVar, jVar4, jVarArr2);
            } else {
                jVar = jVar3;
            }
        }
        cVar2.d(jVar);
        if (!jVar.x()) {
            this.f4884a.putIfAbsent(obj, jVar);
        }
        return jVar;
    }

    public j j(c cVar, ParameterizedType parameterizedType, n nVar) {
        int i10;
        n nVar2;
        Class cls = (Class) parameterizedType.getRawType();
        if (cls == f4870l) {
            return f4881w;
        }
        if (cls == f4868j) {
            return f4880v;
        }
        if (cls == f4869k) {
            return f4882x;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments == null) {
            i10 = 0;
        } else {
            i10 = actualTypeArguments.length;
        }
        if (i10 == 0) {
            nVar2 = f4865g;
        } else {
            j[] jVarArr = new j[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                jVarArr[i11] = g(cVar, actualTypeArguments[i11], nVar);
            }
            nVar2 = n.e(cls, jVarArr);
        }
        return i(cVar, cls, nVar2);
    }

    public j k(c cVar, TypeVariable typeVariable, n nVar) {
        Type[] bounds;
        String name = typeVariable.getName();
        if (nVar != null) {
            j j10 = nVar.j(name);
            if (j10 != null) {
                return j10;
            }
            if (nVar.m(name)) {
                return f4879u;
            }
            n q10 = nVar.q(name);
            synchronized (typeVariable) {
                bounds = typeVariable.getBounds();
            }
            return g(cVar, bounds[0], q10);
        }
        throw new IllegalArgumentException("Null `bindings` passed (type variable \"" + name + "\")");
    }

    public j l(c cVar, Class cls, n nVar, j jVar, j[] jVarArr) {
        if (nVar == null) {
            nVar = f4865g;
        }
        if (cls == Map.class) {
            return o(cls, nVar, jVar, jVarArr);
        }
        if (cls == Collection.class) {
            return c(cls, nVar, jVar, jVarArr);
        }
        if (cls == AtomicReference.class) {
            return q(cls, nVar, jVar, jVarArr);
        }
        return null;
    }

    public j m(c cVar, Class cls, n nVar, j jVar, j[] jVarArr) {
        for (j P : jVarArr) {
            j P2 = P.P(cls, nVar, jVar, jVarArr);
            if (P2 != null) {
                return P2;
            }
        }
        return null;
    }

    public j n(c cVar, WildcardType wildcardType, n nVar) {
        return g(cVar, wildcardType.getUpperBounds()[0], nVar);
    }

    public final j o(Class cls, n nVar, j jVar, j[] jVarArr) {
        j jVar2;
        j jVar3;
        j u10;
        String str;
        if (cls == Properties.class) {
            u10 = f4878t;
        } else {
            List l10 = nVar.l();
            int size = l10.size();
            if (size == 0) {
                u10 = u();
            } else if (size != 2) {
                Object[] objArr = new Object[4];
                objArr[0] = h.X(cls);
                objArr[1] = Integer.valueOf(size);
                if (size == 1) {
                    str = "";
                } else {
                    str = "s";
                }
                objArr[2] = str;
                objArr[3] = nVar;
                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", objArr));
            } else {
                jVar2 = (j) l10.get(1);
                jVar3 = (j) l10.get(0);
                return h.d0(cls, nVar, jVar, jVarArr, jVar3, jVar2);
            }
        }
        jVar3 = u10;
        jVar2 = jVar3;
        return h.d0(cls, nVar, jVar, jVarArr, jVar3, jVar2);
    }

    public j p(Class cls, n nVar, j jVar, j[] jVarArr) {
        return new l(cls, nVar, jVar, jVarArr);
    }

    public final j q(Class cls, n nVar, j jVar, j[] jVarArr) {
        j jVar2;
        List l10 = nVar.l();
        if (l10.isEmpty()) {
            jVar2 = u();
        } else if (l10.size() == 1) {
            jVar2 = (j) l10.get(0);
        } else {
            throw new IllegalArgumentException("Strange Reference type " + cls.getName() + ": cannot determine type parameters");
        }
        return j.g0(cls, nVar, jVar, jVarArr, jVar2);
    }

    public j r(c cVar, Class cls, n nVar) {
        Type D = h.D(cls);
        if (D == null) {
            return null;
        }
        return g(cVar, D, nVar);
    }

    public j[] s(c cVar, Class cls, n nVar) {
        Type[] C = h.C(cls);
        if (C == null || C.length == 0) {
            return f4863e;
        }
        int length = C.length;
        j[] jVarArr = new j[length];
        for (int i10 = 0; i10 < length; i10++) {
            jVarArr[i10] = g(cVar, C[i10], nVar);
        }
        return jVarArr;
    }

    public final String t(j jVar, j jVar2) {
        j jVar3;
        List l10 = jVar.j().l();
        List l11 = jVar2.j().l();
        int size = l11.size();
        int size2 = l10.size();
        for (int i10 = 0; i10 < size2; i10++) {
            j jVar4 = (j) l10.get(i10);
            if (i10 < size) {
                jVar3 = (j) l11.get(i10);
            } else {
                jVar3 = O();
            }
            if (!v(jVar4, jVar3)) {
                Class<Object> cls = Object.class;
                if (!jVar4.y(cls) && ((i10 != 0 || !jVar.J() || !jVar3.y(cls)) && (!jVar4.H() || !jVar4.O(jVar3.q())))) {
                    return String.format("Type parameter #%d/%d differs; can not specialize %s with %s", new Object[]{Integer.valueOf(i10 + 1), Integer.valueOf(size2), jVar4.c(), jVar3.c()});
                }
            }
        }
        return null;
    }

    public j u() {
        return f4879u;
    }

    public final boolean v(j jVar, j jVar2) {
        if (jVar2 instanceof i) {
            ((i) jVar2).d0(jVar);
            return true;
        } else if (jVar.q() != jVar2.q()) {
            return false;
        } else {
            List l10 = jVar.j().l();
            List l11 = jVar2.j().l();
            int size = l10.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!v((j) l10.get(i10), (j) l11.get(i10))) {
                    return false;
                }
            }
            return true;
        }
    }

    public Class w(String str) {
        return Class.forName(str);
    }

    public Class x(String str, boolean z10, ClassLoader classLoader) {
        return Class.forName(str, true, classLoader);
    }

    public e y(Class cls, Class cls2) {
        return z(cls, i((c) null, cls2, f4865g));
    }

    public e z(Class cls, j jVar) {
        n g10 = n.g(cls, jVar);
        e eVar = (e) i((c) null, cls, g10);
        if (g10.n() && jVar != null) {
            j k10 = eVar.i(Collection.class).k();
            if (!k10.equals(jVar)) {
                throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", new Object[]{h.X(cls), jVar, k10}));
            }
        }
        return eVar;
    }

    public o(p pVar) {
        this.f4884a = pVar == null ? new n(16, 200) : pVar;
        this.f4886c = new q(this);
        this.f4885b = null;
        this.f4887d = null;
    }
}
