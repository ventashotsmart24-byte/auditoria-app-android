package io.jsonwebtoken.security;

import io.jsonwebtoken.security.X509Builder;

public interface X509Builder<T extends X509Builder<T>> extends X509Mutator<T> {
    T x509Sha1Thumbprint(boolean z10);

    T x509Sha256Thumbprint(boolean z10);
}
