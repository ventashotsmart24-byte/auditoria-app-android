package io.jsonwebtoken.security;

import java.security.Key;

public interface AsymmetricJwk<K extends Key> extends Jwk<K>, X509Accessor {
    String getPublicKeyUse();
}
