package r3;

import d4.h;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import k3.j;

public final class e extends n {

    /* renamed from: d  reason: collision with root package name */
    public final Constructor f9100d;

    public e(f0 f0Var, Constructor constructor, p pVar, p[] pVarArr) {
        super(f0Var, pVar, pVarArr);
        if (constructor != null) {
            this.f9100d = constructor;
            return;
        }
        throw new IllegalArgumentException("Null constructor not allowed");
    }

    /* renamed from: A */
    public e p(p pVar) {
        return new e(this.f9124a, this.f9100d, pVar, this.f9137c);
    }

    public String d() {
        return this.f9100d.getName();
    }

    public Class e() {
        return this.f9100d.getDeclaringClass();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!h.H(obj, e.class) || ((e) obj).f9100d != this.f9100d) {
            return false;
        }
        return true;
    }

    public j f() {
        return this.f9124a.a(e());
    }

    public int hashCode() {
        return this.f9100d.getName().hashCode();
    }

    public Class k() {
        return this.f9100d.getDeclaringClass();
    }

    public Member m() {
        return this.f9100d;
    }

    public Object n(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + k().getName());
    }

    public void o(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + k().getName());
    }

    public final Object q() {
        return this.f9100d.newInstance(new Object[0]);
    }

    public final Object r(Object[] objArr) {
        return this.f9100d.newInstance(objArr);
    }

    public final Object s(Object obj) {
        return this.f9100d.newInstance(new Object[]{obj});
    }

    public String toString() {
        String str;
        int length = this.f9100d.getParameterTypes().length;
        Object[] objArr = new Object[4];
        objArr[0] = h.X(this.f9100d.getDeclaringClass());
        objArr[1] = Integer.valueOf(length);
        if (length == 1) {
            str = "";
        } else {
            str = "s";
        }
        objArr[2] = str;
        objArr[3] = this.f9125b;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", objArr);
    }

    public int v() {
        return this.f9100d.getParameterTypes().length;
    }

    public j w(int i10) {
        Type[] genericParameterTypes = this.f9100d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f9124a.a(genericParameterTypes[i10]);
    }

    public Class x(int i10) {
        Class[] parameterTypes = this.f9100d.getParameterTypes();
        if (i10 >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i10];
    }

    /* renamed from: z */
    public Constructor b() {
        return this.f9100d;
    }
}
