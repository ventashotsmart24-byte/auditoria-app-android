package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.SecurityBuilder;
import java.security.Provider;
import java.security.SecureRandom;

abstract class AbstractSecurityBuilder<T, B extends SecurityBuilder<T, B>> implements SecurityBuilder<T, B> {
    protected Provider provider;
    protected SecureRandom random;

    public B provider(Provider provider2) {
        this.provider = provider2;
        return self();
    }

    public B random(SecureRandom secureRandom) {
        if (secureRandom == null) {
            secureRandom = Randoms.secureRandom();
        }
        this.random = secureRandom;
        return self();
    }

    public final B self() {
        return this;
    }
}
