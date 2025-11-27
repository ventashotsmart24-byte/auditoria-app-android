package io.jsonwebtoken.security;

import io.jsonwebtoken.security.PublicJwk;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface PrivateJwk<K extends PrivateKey, L extends PublicKey, M extends PublicJwk<L>> extends AsymmetricJwk<K> {
    KeyPair<L, K> toKeyPair();

    M toPublicJwk();
}
