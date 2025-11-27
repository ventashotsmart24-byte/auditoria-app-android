package io.jsonwebtoken.security;

import java.security.Provider;
import java.security.SecureRandom;

public interface Request<T> extends Message<T> {
    Provider getProvider();

    SecureRandom getSecureRandom();
}
