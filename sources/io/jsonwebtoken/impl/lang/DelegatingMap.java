package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DelegatingMap<K, V, T extends Map<K, V>> implements Map<K, V> {
    protected T DELEGATE;

    public DelegatingMap(T t10) {
        setDelegate(t10);
    }

    public void clear() {
        this.DELEGATE.clear();
    }

    public boolean containsKey(Object obj) {
        return this.DELEGATE.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.DELEGATE.containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.DELEGATE.entrySet();
    }

    public V get(Object obj) {
        return this.DELEGATE.get(obj);
    }

    public boolean isEmpty() {
        return this.DELEGATE.isEmpty();
    }

    public Set<K> keySet() {
        return this.DELEGATE.keySet();
    }

    public V put(K k10, V v10) {
        return this.DELEGATE.put(k10, v10);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        this.DELEGATE.putAll(map);
    }

    public V remove(Object obj) {
        return this.DELEGATE.remove(obj);
    }

    public void setDelegate(T t10) {
        this.DELEGATE = (Map) Assert.notNull(t10, "Delegate cannot be null.");
    }

    public int size() {
        return this.DELEGATE.size();
    }

    public Collection<V> values() {
        return this.DELEGATE.values();
    }
}
