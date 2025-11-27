package io.jsonwebtoken.impl.lang;

public final class ConstantFunction<T, R> implements Function<T, R> {
    private final R value;

    public ConstantFunction(R r10) {
        this.value = r10;
    }

    public R apply(T t10) {
        return this.value;
    }
}
