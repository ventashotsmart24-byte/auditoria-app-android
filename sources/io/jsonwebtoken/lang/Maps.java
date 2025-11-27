package io.jsonwebtoken.lang;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Maps {

    public static class HashMapBuilder<K, V> implements MapBuilder<K, V> {
        private final Map<K, V> data;

        private HashMapBuilder() {
            this.data = new HashMap();
        }

        public MapBuilder<K, V> and(K k10, V v10) {
            this.data.put(k10, v10);
            return this;
        }

        public Map<K, V> build() {
            return Collections.unmodifiableMap(this.data);
        }
    }

    public interface MapBuilder<K, V> extends Builder<Map<K, V>> {
        MapBuilder<K, V> and(K k10, V v10);

        Map<K, V> build();
    }

    private Maps() {
    }

    public static <K, V> MapBuilder<K, V> of(K k10, V v10) {
        return new HashMapBuilder().and(k10, v10);
    }
}
