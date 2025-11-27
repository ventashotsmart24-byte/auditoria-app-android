package io.jsonwebtoken.lang;

import java.util.Map;

public interface Registry<K, V> extends Map<K, V> {
    V forKey(K k10);
}
