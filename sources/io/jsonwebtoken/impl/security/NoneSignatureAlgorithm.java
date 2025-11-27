package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import java.io.InputStream;
import java.security.Key;

final class NoneSignatureAlgorithm implements SecureDigestAlgorithm<Key, Key> {
    private static final String ID = "none";
    static final SecureDigestAlgorithm<Key, Key> INSTANCE = new NoneSignatureAlgorithm();

    private NoneSignatureAlgorithm() {
    }

    public boolean equals(Object obj) {
        if (this == obj || ((obj instanceof SecureDigestAlgorithm) && "none".equalsIgnoreCase(((SecureDigestAlgorithm) obj).getId()))) {
            return true;
        }
        return false;
    }

    public String getId() {
        return "none";
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public String toString() {
        return "none";
    }

    public byte[] digest(SecureRequest<InputStream, Key> secureRequest) {
        throw new SignatureException("The 'none' algorithm cannot be used to create signatures.");
    }

    public boolean verify(VerifySecureDigestRequest<Key> verifySecureDigestRequest) {
        throw new SignatureException("The 'none' algorithm cannot be used to verify signatures.");
    }
}
