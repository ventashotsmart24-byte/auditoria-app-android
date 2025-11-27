package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Supplier;

public final class Functions {
    private Functions() {
    }

    public static <T, V, R> Function<T, R> andThen(final Function<T, ? extends V> function, final Function<V, R> function2) {
        Assert.notNull(function, "Before function cannot be null.");
        Assert.notNull(function2, "After function cannot be null.");
        return new Function<T, R>() {
            public R apply(T t10) {
                return function2.apply(function.apply(t10));
            }
        };
    }

    @SafeVarargs
    public static <T, R> Function<T, R> firstResult(final Function<T, R>... functionArr) {
        Assert.notEmpty((Object[]) functionArr, "Function list cannot be null or empty.");
        return new Function<T, R>() {
            public R apply(T t10) {
                for (Function function : functionArr) {
                    Assert.notNull(function, "Function cannot be null.");
                    R apply = function.apply(t10);
                    if (apply != null) {
                        return apply;
                    }
                }
                return null;
            }
        };
    }

    public static <T> Function<T, T> identity() {
        return new Function<T, T>() {
            public T apply(T t10) {
                return t10;
            }
        };
    }

    public static <T, R, E extends RuntimeException> Function<T, R> wrap(Function<T, R> function, Class<E> cls, String str, Object... objArr) {
        return new PropagatingExceptionFunction(new DelegatingCheckedFunction(function), cls, (Supplier<String>) new FormattedStringSupplier(str, objArr));
    }

    public static <T, R, E extends RuntimeException> Function<T, R> wrapFmt(CheckedFunction<T, R> checkedFunction, Class<E> cls, String str) {
        return new PropagatingExceptionFunction(checkedFunction, cls, new FormattedStringFunction(str));
    }
}
