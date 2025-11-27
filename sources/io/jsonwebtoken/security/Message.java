package io.jsonwebtoken.security;

public interface Message<T> {
    T getPayload();
}
