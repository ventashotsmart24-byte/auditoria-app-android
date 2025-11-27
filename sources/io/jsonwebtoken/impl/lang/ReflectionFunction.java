package io.jsonwebtoken.impl.lang;

abstract class ReflectionFunction<T, R> implements Function<T, R> {
    public static final String ERR_MSG = "Reflection operation failed. This is likely due to an internal implementation programming error.  Please report this to the JJWT development team.  Cause: ";

    public final R apply(T t10) {
        if (!supports(t10)) {
            return null;
        }
        try {
            return invoke(t10);
        } catch (Throwable th) {
            throw new IllegalStateException(ERR_MSG + th.getMessage(), th);
        }
    }

    public abstract R invoke(T t10);

    public abstract boolean supports(T t10);
}
