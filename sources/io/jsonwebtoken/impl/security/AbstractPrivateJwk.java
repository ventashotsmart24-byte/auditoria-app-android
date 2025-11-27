package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.KeyPair;
import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.PublicJwk;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

abstract class AbstractPrivateJwk<K extends PrivateKey, L extends PublicKey, M extends PublicJwk<L>> extends AbstractAsymmetricJwk<K> implements PrivateJwk<K, L, M> {
    private final KeyPair<L, K> keyPair;
    private final M publicJwk;

    public AbstractPrivateJwk(JwkContext<K> jwkContext, List<Parameter<?>> list, M m10) {
        super(jwkContext, list);
        this.publicJwk = (PublicJwk) Assert.notNull(m10, "PublicJwk instance cannot be null.");
        PublicKey publicKey = (PublicKey) Assert.notNull(m10.toKey(), "PublicJwk key instance cannot be null.");
        this.context.setPublicKey(publicKey);
        this.keyPair = new DefaultKeyPair(publicKey, (PrivateKey) toKey());
    }

    public final boolean equals(Jwk<?> jwk) {
        return (jwk instanceof PrivateJwk) && equals((PrivateJwk<?, ?, ?>) (PrivateJwk) jwk);
    }

    public abstract boolean equals(PrivateJwk<?, ?, ?> privateJwk);

    public KeyPair<L, K> toKeyPair() {
        return this.keyPair;
    }

    public M toPublicJwk() {
        return this.publicJwk;
    }
}
