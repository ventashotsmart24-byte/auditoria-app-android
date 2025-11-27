package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeySupplier;
import java.security.Key;
import java.security.Provider;

public class ProviderKey<T extends Key> implements Key, KeySupplier<T> {
    private final T key;
    private final Provider provider;

    public ProviderKey(Provider provider2, T t10) {
        this.provider = (Provider) Assert.notNull(provider2, "Provider cannot be null.");
        this.key = (Key) Assert.notNull(t10, "Key argument cannot be null.");
        if (t10 instanceof ProviderKey) {
            throw new IllegalArgumentException("Nesting not permitted.");
        }
    }

    public static <K extends Key> K getKey(K k10) {
        return k10 instanceof ProviderKey ? ((ProviderKey) k10).getKey() : k10;
    }

    public static Provider getProvider(Key key2, Provider provider2) {
        return key2 instanceof ProviderKey ? (Provider) Assert.stateNotNull(((ProviderKey) key2).getProvider(), "ProviderKey provider can never be null.") : provider2;
    }

    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    public String getFormat() {
        return this.key.getFormat();
    }

    public T getKey() {
        return this.key;
    }

    public final Provider getProvider() {
        return this.provider;
    }
}
