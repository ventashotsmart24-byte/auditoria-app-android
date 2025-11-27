package io.jsonwebtoken.impl.security;

import java.security.Provider;
import javax.crypto.SecretKey;

public final class ProviderSecretKey extends ProviderKey<SecretKey> implements SecretKey {
    public ProviderSecretKey(Provider provider, SecretKey secretKey) {
        super(provider, secretKey);
    }
}
