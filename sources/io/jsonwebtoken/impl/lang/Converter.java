package io.jsonwebtoken.impl.lang;

public interface Converter<A, B> {
    A applyFrom(B b10);

    B applyTo(A a10);
}
