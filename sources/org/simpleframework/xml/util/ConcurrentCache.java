package org.simpleframework.xml.util;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCache<T> extends ConcurrentHashMap<Object, T> implements Cache<T> {
    public void cache(Object obj, T t10) {
        put(obj, t10);
    }

    public boolean contains(Object obj) {
        return containsKey(obj);
    }

    public T fetch(Object obj) {
        return get(obj);
    }

    public T take(Object obj) {
        return remove(obj);
    }
}
