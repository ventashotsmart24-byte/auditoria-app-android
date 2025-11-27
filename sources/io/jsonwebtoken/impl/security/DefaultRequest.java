package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.Request;
import java.security.Provider;
import java.security.SecureRandom;

public class DefaultRequest<T> extends DefaultMessage<T> implements Request<T> {
    private final Provider provider;
    private final SecureRandom secureRandom;

    public DefaultRequest(T t10, Provider provider2, SecureRandom secureRandom2) {
        super(t10);
        this.provider = provider2;
        this.secureRandom = secureRandom2;
    }

    public /* bridge */ /* synthetic */ Object getPayload() {
        return super.getPayload();
    }

    public Provider getProvider() {
        return this.provider;
    }

    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }
}
