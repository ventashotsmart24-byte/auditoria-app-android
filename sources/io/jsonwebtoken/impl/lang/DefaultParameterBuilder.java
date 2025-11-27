package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class DefaultParameterBuilder<T> implements ParameterBuilder<T> {
    private Class<? extends Collection<T>> collectionType;
    private Converter<T, ?> converter;
    private String id;
    private String name;
    private boolean secret;
    private final Class<T> type;

    public DefaultParameterBuilder(Class<T> cls) {
        this.type = (Class) Assert.notNull(cls, "Type cannot be null.");
    }

    public ParameterBuilder<List<T>> list() {
        this.collectionType = List.class;
        return this;
    }

    public ParameterBuilder<Set<T>> set() {
        this.collectionType = Set.class;
        return this;
    }

    public ParameterBuilder<T> setConverter(Converter<T, ?> converter2) {
        this.converter = converter2;
        return this;
    }

    public ParameterBuilder<T> setId(String str) {
        this.id = str;
        return this;
    }

    public ParameterBuilder<T> setName(String str) {
        this.name = str;
        return this;
    }

    public ParameterBuilder<T> setSecret(boolean z10) {
        this.secret = z10;
        return this;
    }

    public Parameter<T> build() {
        Assert.notNull(this.type, "Type must be set.");
        Converter<List<T>, Object> converter2 = this.converter;
        if (converter2 == null) {
            converter2 = Converters.forType(this.type);
        }
        Class<? extends Collection<T>> cls = this.collectionType;
        if (cls != null) {
            converter2 = List.class.isAssignableFrom(cls) ? Converters.forList(converter2) : Converters.forSet(converter2);
        }
        return new DefaultParameter(this.id, this.name, this.secret, this.type, this.collectionType, this.secret ? new RedactedValueConverter(converter2) : converter2);
    }
}
