package io.jsonwebtoken.impl.security;

import java.security.PrivateKey;
import java.security.Provider;

public final class ProviderPrivateKey extends ProviderKey<PrivateKey> implements PrivateKey {
    public ProviderPrivateKey(Provider provider, PrivateKey privateKey) {
        super(provider, privateKey);
    }
}
