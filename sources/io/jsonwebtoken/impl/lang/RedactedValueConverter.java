package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Supplier;

public class RedactedValueConverter<T> implements Converter<T, Object> {
    private final Converter<T, Object> delegate;

    public RedactedValueConverter(Converter<T, Object> converter) {
        this.delegate = (Converter) Assert.notNull(converter, "Delegate cannot be null.");
    }

    public T applyFrom(Object obj) {
        if (obj instanceof RedactedSupplier) {
            obj = ((Supplier) obj).get();
        }
        return this.delegate.applyFrom(obj);
    }

    public Object applyTo(T t10) {
        Object applyTo = this.delegate.applyTo(t10);
        if (applyTo == null || (applyTo instanceof RedactedSupplier)) {
            return applyTo;
        }
        return new RedactedSupplier(applyTo);
    }
}
