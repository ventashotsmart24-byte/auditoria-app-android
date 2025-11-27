package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import org.simpleframework.xml.util.Entry;

public class Dictionary<T extends Entry> extends AbstractSet<T> {
    protected final Table<T> map = new Table<>();

    public static class Table<T> extends HashMap<String, T> {
    }

    public T get(String str) {
        return (Entry) this.map.get(str);
    }

    public Iterator<T> iterator() {
        return this.map.values().iterator();
    }

    public T remove(String str) {
        return (Entry) this.map.remove(str);
    }

    public int size() {
        return this.map.size();
    }

    public boolean add(T t10) {
        return this.map.put(t10.getName(), t10) != null;
    }
}
