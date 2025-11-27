package b9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Class f11284a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11285b;

    /* renamed from: c  reason: collision with root package name */
    public final Class[] f11286c;

    public g(Class cls, String str, Class... clsArr) {
        this.f11284a = cls;
        this.f11285b = str;
        this.f11286c = clsArr;
    }

    public static Method b(Class cls, String str, Class[] clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            if ((cls.getModifiers() & 1) == 0) {
                return b(cls.getSuperclass(), str, clsArr);
            }
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public final Method a(Class cls) {
        Class cls2;
        String str = this.f11285b;
        if (str == null) {
            return null;
        }
        Method b10 = b(cls, str, this.f11286c);
        if (b10 == null || (cls2 = this.f11284a) == null || cls2.isAssignableFrom(b10.getReturnType())) {
            return b10;
        }
        return null;
    }

    public Object c(Object obj, Object... objArr) {
        Method a10 = a(obj.getClass());
        if (a10 != null) {
            try {
                return a10.invoke(obj, objArr);
            } catch (IllegalAccessException e10) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a10);
                assertionError.initCause(e10);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f11285b + " not supported for object " + obj);
        }
    }

    public Object d(Object obj, Object... objArr) {
        Method a10 = a(obj.getClass());
        if (a10 == null) {
            return null;
        }
        try {
            return a10.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(Object obj, Object... objArr) {
        try {
            return d(obj, objArr);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(Object obj, Object... objArr) {
        try {
            return c(obj, objArr);
        } catch (InvocationTargetException e10) {
            Throwable targetException = e10.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean g(Object obj) {
        if (a(obj.getClass()) != null) {
            return true;
        }
        return false;
    }
}
