package io.jsonwebtoken.impl;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.security.AbstractAsymmetricJwk;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

public class AbstractX509Context<T extends X509Mutator<T>> extends ParameterMap implements X509Context<T> {
    public AbstractX509Context(Set<Parameter<?>> set) {
        super(set);
    }

    public List<X509Certificate> getX509Chain() {
        return (List) get(AbstractAsymmetricJwk.X5C);
    }

    public byte[] getX509Sha1Thumbprint() {
        return (byte[]) get(AbstractAsymmetricJwk.X5T);
    }

    public byte[] getX509Sha256Thumbprint() {
        return (byte[]) get(AbstractAsymmetricJwk.X5T_S256);
    }

    public URI getX509Url() {
        return (URI) get(AbstractAsymmetricJwk.X5U);
    }

    public T self() {
        return this;
    }

    public T x509Chain(List<X509Certificate> list) {
        put(AbstractAsymmetricJwk.X5C, (Object) list);
        return self();
    }

    public T x509Sha1Thumbprint(byte[] bArr) {
        put(AbstractAsymmetricJwk.X5T, (Object) bArr);
        return self();
    }

    public T x509Sha256Thumbprint(byte[] bArr) {
        put(AbstractAsymmetricJwk.X5T_S256, (Object) bArr);
        return self();
    }

    public T x509Url(URI uri) {
        put(AbstractAsymmetricJwk.X5U, (Object) uri);
        return self();
    }
}
