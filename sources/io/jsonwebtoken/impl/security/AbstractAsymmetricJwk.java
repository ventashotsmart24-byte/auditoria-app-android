package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.AsymmetricJwk;
import java.net.URI;
import java.security.Key;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

public abstract class AbstractAsymmetricJwk<K extends Key> extends AbstractJwk<K> implements AsymmetricJwk<K> {
    static final Set<Parameter<?>> PARAMS;
    static final Parameter<String> USE;
    public static final Parameter<List<X509Certificate>> X5C;
    public static final Parameter<byte[]> X5T;
    public static final Parameter<byte[]> X5T_S256;
    public static final Parameter<URI> X5U;

    static {
        Parameter<String> string = Parameters.string("use", "Public Key Use");
        USE = string;
        Parameter<List<X509Certificate>> x509Chain = Parameters.x509Chain(JwsHeader.X509_CERT_CHAIN, "X.509 Certificate Chain");
        X5C = x509Chain;
        Parameter<byte[]> parameter = (Parameter) Parameters.bytes(JwsHeader.X509_CERT_SHA1_THUMBPRINT, "X.509 Certificate SHA-1 Thumbprint").build();
        X5T = parameter;
        Parameter<byte[]> parameter2 = (Parameter) Parameters.bytes(JwsHeader.X509_CERT_SHA256_THUMBPRINT, "X.509 Certificate SHA-256 Thumbprint").build();
        X5T_S256 = parameter2;
        Parameter<URI> uri = Parameters.uri(JwsHeader.X509_URL, "X.509 URL");
        X5U = uri;
        PARAMS = Collections.concat(AbstractJwk.PARAMS, string, x509Chain, parameter, parameter2, uri);
    }

    public AbstractAsymmetricJwk(JwkContext<K> jwkContext, List<Parameter<?>> list) {
        super(jwkContext, list);
    }

    public String getPublicKeyUse() {
        return this.context.getPublicKeyUse();
    }

    public List<X509Certificate> getX509Chain() {
        return Collections.immutable(this.context.getX509Chain());
    }

    public byte[] getX509Sha1Thumbprint() {
        return (byte[]) Arrays.copy(this.context.getX509Sha1Thumbprint());
    }

    public byte[] getX509Sha256Thumbprint() {
        return (byte[]) Arrays.copy(this.context.getX509Sha256Thumbprint());
    }

    public URI getX509Url() {
        return this.context.getX509Url();
    }
}
