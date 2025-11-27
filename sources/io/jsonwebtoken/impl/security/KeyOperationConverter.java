package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;

final class KeyOperationConverter implements Converter<KeyOperation, Object> {
    static final Converter<KeyOperation, Object> DEFAULT = new KeyOperationConverter(Jwks.OP.get());
    private final Registry<String, KeyOperation> registry;

    public KeyOperationConverter(Registry<String, KeyOperation> registry2) {
        this.registry = (Registry) Assert.notEmpty(registry2, "KeyOperation registry cannot be null or empty.");
    }

    public KeyOperation applyFrom(Object obj) {
        if (obj instanceof KeyOperation) {
            return (KeyOperation) obj;
        }
        String str = (String) Assert.isInstanceOf(String.class, obj, "Argument must be a KeyOperation or String.");
        Assert.hasText(str, "KeyOperation string value cannot be null or empty.");
        KeyOperation keyOperation = this.registry.get(str);
        return keyOperation != null ? keyOperation : (KeyOperation) Jwks.OP.builder().id(str).build();
    }

    public String applyTo(KeyOperation keyOperation) {
        Assert.notNull(keyOperation, "KeyOperation cannot be null.");
        return keyOperation.getId();
    }
}
