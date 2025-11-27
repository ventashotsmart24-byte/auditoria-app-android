package r3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class y {

    /* renamed from: c  reason: collision with root package name */
    public static final Class[] f9190c = new Class[0];

    /* renamed from: a  reason: collision with root package name */
    public final String f9191a;

    /* renamed from: b  reason: collision with root package name */
    public final Class[] f9192b;

    public y(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public int a() {
        return this.f9192b.length;
    }

    public String b() {
        return this.f9191a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != y.class) {
            return false;
        }
        y yVar = (y) obj;
        if (!this.f9191a.equals(yVar.f9191a)) {
            return false;
        }
        Class[] clsArr = yVar.f9192b;
        int length = this.f9192b.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (clsArr[i10] != this.f9192b[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f9191a.hashCode() + this.f9192b.length;
    }

    public String toString() {
        return this.f9191a + "(" + this.f9192b.length + "-args)";
    }

    public y(Constructor constructor) {
        this("", constructor.getParameterTypes());
    }

    public y(String str, Class[] clsArr) {
        this.f9191a = str;
        this.f9192b = clsArr == null ? f9190c : clsArr;
    }
}
