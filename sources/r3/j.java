package r3;

import d4.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class j extends n {

    /* renamed from: d  reason: collision with root package name */
    public final transient Method f9126d;

    /* renamed from: e  reason: collision with root package name */
    public Class[] f9127e;

    public j(f0 f0Var, Method method, p pVar, p[] pVarArr) {
        super(f0Var, pVar, pVarArr);
        if (method != null) {
            this.f9126d = method;
            return;
        }
        throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
    }

    /* renamed from: A */
    public Method b() {
        return this.f9126d;
    }

    /* renamed from: B */
    public Method m() {
        return this.f9126d;
    }

    public Class[] C() {
        if (this.f9127e == null) {
            this.f9127e = this.f9126d.getParameterTypes();
        }
        return this.f9127e;
    }

    public Class D() {
        return this.f9126d.getReturnType();
    }

    /* renamed from: E */
    public j p(p pVar) {
        return new j(this.f9124a, this.f9126d, pVar, this.f9137c);
    }

    public String d() {
        return this.f9126d.getName();
    }

    public Class e() {
        return this.f9126d.getReturnType();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!h.H(obj, j.class) || ((j) obj).f9126d != this.f9126d) {
            return false;
        }
        return true;
    }

    public k3.j f() {
        return this.f9124a.a(this.f9126d.getGenericReturnType());
    }

    public int hashCode() {
        return this.f9126d.getName().hashCode();
    }

    public Class k() {
        return this.f9126d.getDeclaringClass();
    }

    public String l() {
        String l10 = super.l();
        int v10 = v();
        if (v10 == 0) {
            return l10 + "()";
        } else if (v10 != 1) {
            return String.format("%s(%d params)", new Object[]{super.l(), Integer.valueOf(v())});
        } else {
            return l10 + "(" + x(0).getName() + ")";
        }
    }

    public Object n(Object obj) {
        try {
            return this.f9126d.invoke(obj, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new IllegalArgumentException("Failed to getValue() with method " + l() + ": " + e10.getMessage(), e10);
        }
    }

    public void o(Object obj, Object obj2) {
        try {
            this.f9126d.invoke(obj, new Object[]{obj2});
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new IllegalArgumentException("Failed to setValue() with method " + l() + ": " + e10.getMessage(), e10);
        }
    }

    public final Object q() {
        return this.f9126d.invoke((Object) null, new Object[0]);
    }

    public final Object r(Object[] objArr) {
        return this.f9126d.invoke((Object) null, objArr);
    }

    public final Object s(Object obj) {
        return this.f9126d.invoke((Object) null, new Object[]{obj});
    }

    public String toString() {
        return "[method " + l() + "]";
    }

    public int v() {
        return C().length;
    }

    public k3.j w(int i10) {
        Type[] genericParameterTypes = this.f9126d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f9124a.a(genericParameterTypes[i10]);
    }

    public Class x(int i10) {
        Class[] C = C();
        if (i10 >= C.length) {
            return null;
        }
        return C[i10];
    }

    public final Object z(Object obj, Object... objArr) {
        return this.f9126d.invoke(obj, objArr);
    }
}
