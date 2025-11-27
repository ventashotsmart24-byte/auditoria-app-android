package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeaderMutator;
import io.jsonwebtoken.security.X509Builder;

public class DefaultJweHeaderBuilder<T extends JweHeaderMutator<T> & X509Builder<T>> extends DefaultJweHeaderMutator<T> implements X509Builder<T> {
    public DefaultJweHeaderBuilder() {
    }

    public DefaultJweHeaderBuilder(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator);
    }

    public T x509Sha1Thumbprint(boolean z10) {
        this.x509.x509Sha1Thumbprint(z10);
        return (JweHeaderMutator) self();
    }

    public T x509Sha256Thumbprint(boolean z10) {
        this.x509.x509Sha256Thumbprint(z10);
        return (JweHeaderMutator) self();
    }
}
