package anet.channel.strategy.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SerialLruCache<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private int f3987a;

    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap, int i10) {
        super(linkedHashMap);
        this.f3987a = i10;
    }

    public boolean entryRemoved(Map.Entry<K, V> entry) {
        return true;
    }

    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.f3987a) {
            return entryRemoved(entry);
        }
        return false;
    }

    @Deprecated
    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap) {
        this(linkedHashMap, 256);
    }

    public SerialLruCache(int i10) {
        super(i10 + 1, 1.0f, true);
        this.f3987a = i10;
    }
}
