package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface OctetPublicJwkBuilder<A extends PublicKey, B extends PrivateKey> extends PublicJwkBuilder<A, B, OctetPublicJwk<A>, OctetPrivateJwk<B, A>, OctetPrivateJwkBuilder<B, A>, OctetPublicJwkBuilder<A, B>> {
}
