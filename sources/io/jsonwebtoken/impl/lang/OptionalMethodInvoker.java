package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Classes;
import java.lang.reflect.Method;

public class OptionalMethodInvoker<T, R> extends ReflectionFunction<T, R> {
    private final Class<?> CLASS;
    private final Method METHOD;
    private final Class<?>[] PARAM_TYPES;
    private final boolean STATIC;

    public OptionalMethodInvoker(String str, String str2) {
        this(str, str2, (Class<?>) null, false);
    }

    public R invoke(T t10) {
        if (!this.STATIC) {
            return this.METHOD.invoke(t10, new Object[0]);
        }
        return this.METHOD.invoke((Object) null, new Object[]{t10});
    }

    public boolean supports(T t10) {
        Class<?>[] clsArr;
        Class<?> cls = this.CLASS;
        if (cls == null || this.METHOD == null) {
            cls = null;
        } else if (this.STATIC && (clsArr = this.PARAM_TYPES) != null) {
            cls = clsArr[0];
        }
        if (cls == null || !cls.isInstance(t10)) {
            return false;
        }
        return true;
    }

    public OptionalMethodInvoker(String str, String str2, Class<?> cls, boolean z10) {
        Class<?> cls2;
        Method method = null;
        Class<?>[] clsArr = cls != null ? new Class[]{cls} : null;
        try {
            cls2 = Classes.forName(str);
            try {
                method = cls2.getMethod(str2, clsArr);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cls2 = null;
        }
        this.CLASS = cls2;
        this.METHOD = method;
        this.PARAM_TYPES = clsArr;
        this.STATIC = z10;
    }
}
