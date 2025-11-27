package io.jsonwebtoken.impl.lang;

public class DelegatingCheckedFunction<T, R> implements CheckedFunction<T, R> {
    final Function<T, R> delegate;

    public DelegatingCheckedFunction(Function<T, R> function) {
        this.delegate = function;
    }

    public R apply(T t10) {
        return this.delegate.apply(t10);
    }
}
