package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

public class EncodedObjectConverter<T> implements Converter<T, Object> {
    private final Converter<T, ? super CharSequence> converter;
    private final Class<T> type;

    public EncodedObjectConverter(Class<T> cls, Converter<T, ? super CharSequence> converter2) {
        this.type = (Class) Assert.notNull(cls, "Value type cannot be null.");
        this.converter = (Converter) Assert.notNull(converter2, "Value converter cannot be null.");
    }

    public T applyFrom(Object obj) {
        Assert.notNull(obj, "Value argument cannot be null.");
        if (this.type.isInstance(obj)) {
            return this.type.cast(obj);
        }
        if (obj instanceof CharSequence) {
            return this.converter.applyFrom((CharSequence) obj);
        }
        throw new IllegalArgumentException("Values must be either String or " + this.type.getName() + " instances. Value type found: " + obj.getClass().getName() + ".");
    }

    public Object applyTo(T t10) {
        Assert.notNull(t10, "Value argument cannot be null.");
        return this.converter.applyTo(t10);
    }
}
