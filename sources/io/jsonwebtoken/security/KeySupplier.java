package io.jsonwebtoken.security;

import java.security.Key;

public interface KeySupplier<K extends Key> {
    K getKey();
}
