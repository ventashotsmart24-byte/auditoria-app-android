package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

public class NullSafeConverter<A, B> implements Converter<A, B> {
    private final Converter<A, B> converter;

    public NullSafeConverter(Converter<A, B> converter2) {
        this.converter = (Converter) Assert.notNull(converter2, "Delegate converter cannot be null.");
    }

    public A applyFrom(B b10) {
        if (b10 == null) {
            return null;
        }
        return this.converter.applyFrom(b10);
    }

    public B applyTo(A a10) {
        if (a10 == null) {
            return null;
        }
        return this.converter.applyTo(a10);
    }
}
