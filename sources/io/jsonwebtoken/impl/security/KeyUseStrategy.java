package io.jsonwebtoken.impl.security;

public interface KeyUseStrategy {
    String toJwkValue(KeyUsage keyUsage);
}
