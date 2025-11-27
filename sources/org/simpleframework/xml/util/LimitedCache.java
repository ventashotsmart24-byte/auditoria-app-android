package org.simpleframework.xml.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LimitedCache<T> extends LinkedHashMap<Object, T> implements Cache<T> {
    private final int capacity;

    public LimitedCache() {
        this(50000);
    }

    public void cache(Object obj, T t10) {
        put(obj, t10);
    }

    public boolean contains(Object obj) {
        return containsKey(obj);
    }

    public T fetch(Object obj) {
        return get(obj);
    }

    public boolean removeEldestEntry(Map.Entry<Object, T> entry) {
        if (size() > this.capacity) {
            return true;
        }
        return false;
    }

    public T take(Object obj) {
        return remove(obj);
    }

    public LimitedCache(int i10) {
        this.capacity = i10;
    }
}
