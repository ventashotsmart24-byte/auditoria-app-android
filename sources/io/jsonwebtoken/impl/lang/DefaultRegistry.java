package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultRegistry<K, V> extends DelegatingMap<K, V, Map<K, V>> implements Registry<K, V>, Function<K, V> {
    private final String qualifiedKeyName;

    public DefaultRegistry(String str, String str2, Collection<? extends V> collection, Function<V, K> function) {
        super(toMap(collection, function));
        this.qualifiedKeyName = ((String) Assert.hasText(Strings.clean(str), "name cannot be null or empty.")) + " " + ((String) Assert.hasText(Strings.clean(str2), "keyName cannot be null or empty."));
    }

    public static <T> T immutable() {
        throw new UnsupportedOperationException("Registries are immutable and cannot be modified.");
    }

    private static <K, V> Map<K, V> toMap(Collection<? extends V> collection, Function<V, K> function) {
        Assert.notEmpty(collection, "Collection of values may not be null or empty.");
        Assert.notNull(function, "Key function cannot be null.");
        LinkedHashMap linkedHashMap = new LinkedHashMap(collection.size());
        for (Object next : collection) {
            linkedHashMap.put(Assert.notNull(function.apply(next), "Key function cannot return a null value."), next);
        }
        return Collections.immutable(linkedHashMap);
    }

    public V apply(K k10) {
        return get(k10);
    }

    public void clear() {
        immutable();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultRegistry)) {
            return false;
        }
        DefaultRegistry defaultRegistry = (DefaultRegistry) obj;
        if (!this.qualifiedKeyName.equals(defaultRegistry.qualifiedKeyName) || !this.DELEGATE.equals(defaultRegistry.DELEGATE)) {
            return false;
        }
        return true;
    }

    public V forKey(K k10) {
        V v10 = get(k10);
        if (v10 != null) {
            return v10;
        }
        throw new IllegalArgumentException("Unrecognized " + this.qualifiedKeyName + ": " + k10);
    }

    public int hashCode() {
        return this.DELEGATE.hashCode();
    }

    public V put(K k10, V v10) {
        return immutable();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        immutable();
    }

    public V remove(Object obj) {
        return immutable();
    }

    public String toString() {
        return this.DELEGATE.toString();
    }
}
