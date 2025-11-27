package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeyBuilder;
import java.security.Key;

abstract class ProvidedKeyBuilder<K extends Key, B extends KeyBuilder<K, B>> extends AbstractSecurityBuilder<K, B> implements KeyBuilder<K, B> {
    protected final K key;

    public ProvidedKeyBuilder(K k10) {
        this.key = (Key) Assert.notNull(k10, "Key cannot be null.");
    }

    public abstract K doBuild();

    public final K build() {
        K k10 = this.key;
        if (k10 instanceof ProviderKey) {
            return k10;
        }
        return doBuild();
    }
}
