package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.security.PublicJwk;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

public class DefaultMutableJweHeader extends DefaultJweHeaderMutator<DefaultMutableJweHeader> implements JweHeader {
    public DefaultMutableJweHeader(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator);
    }

    private <T> T get(Parameter<T> parameter) {
        return ((ParameterMap) this.DELEGATE).get(parameter);
    }

    public byte[] getAgreementPartyUInfo() {
        return (byte[]) get(DefaultJweHeader.APU);
    }

    public byte[] getAgreementPartyVInfo() {
        return (byte[]) get(DefaultJweHeader.APV);
    }

    public String getAlgorithm() {
        return (String) get(DefaultHeader.ALGORITHM);
    }

    public byte[] getAuthenticationTag() {
        return (byte[]) get(DefaultJweHeader.TAG);
    }

    public String getCompressionAlgorithm() {
        return (String) get(DefaultHeader.COMPRESSION_ALGORITHM);
    }

    public String getContentType() {
        return (String) get(DefaultHeader.CONTENT_TYPE);
    }

    public Set<String> getCritical() {
        return (Set) get(DefaultProtectedHeader.CRIT);
    }

    public String getEncryptionAlgorithm() {
        return (String) get(DefaultJweHeader.ENCRYPTION_ALGORITHM);
    }

    public PublicJwk<?> getEphemeralPublicKey() {
        return (PublicJwk) get(DefaultJweHeader.EPK);
    }

    public byte[] getInitializationVector() {
        return (byte[]) get(DefaultJweHeader.IV);
    }

    public PublicJwk<?> getJwk() {
        return (PublicJwk) get(DefaultProtectedHeader.JWK);
    }

    public URI getJwkSetUrl() {
        return (URI) get(DefaultProtectedHeader.JKU);
    }

    public String getKeyId() {
        return (String) get(DefaultProtectedHeader.KID);
    }

    public Integer getPbes2Count() {
        return (Integer) get(DefaultJweHeader.P2C);
    }

    public byte[] getPbes2Salt() {
        return (byte[]) get(DefaultJweHeader.P2S);
    }

    public String getType() {
        return (String) get(DefaultHeader.TYPE);
    }

    public List<X509Certificate> getX509Chain() {
        return (List) get(DefaultProtectedHeader.X5C);
    }

    public byte[] getX509Sha1Thumbprint() {
        return (byte[]) get(DefaultProtectedHeader.X5T);
    }

    public byte[] getX509Sha256Thumbprint() {
        return (byte[]) get(DefaultProtectedHeader.X5T_S256);
    }

    public URI getX509Url() {
        return (URI) get(DefaultProtectedHeader.X5U);
    }
}
