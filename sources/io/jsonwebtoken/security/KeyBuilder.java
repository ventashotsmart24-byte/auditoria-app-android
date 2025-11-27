package io.jsonwebtoken.security;

import io.jsonwebtoken.security.KeyBuilder;
import java.security.Key;

public interface KeyBuilder<K extends Key, B extends KeyBuilder<K, B>> extends SecurityBuilder<K, B> {
}
