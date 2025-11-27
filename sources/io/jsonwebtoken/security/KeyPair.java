package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface KeyPair<A extends PublicKey, B extends PrivateKey> {
    B getPrivate();

    A getPublic();

    java.security.KeyPair toJavaKeyPair();
}
