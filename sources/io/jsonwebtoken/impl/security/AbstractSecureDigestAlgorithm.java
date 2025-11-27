package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeyException;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import java.io.InputStream;
import java.security.Key;

abstract class AbstractSecureDigestAlgorithm<S extends Key, V extends Key> extends CryptoAlgorithm implements SecureDigestAlgorithm<S, V> {
    public AbstractSecureDigestAlgorithm(String str, String str2) {
        super(str, str2);
    }

    public static String keyType(boolean z10) {
        return z10 ? "signing" : "verification";
    }

    public abstract byte[] doDigest(SecureRequest<InputStream, S> secureRequest);

    public abstract boolean doVerify(VerifySecureDigestRequest<V> verifySecureDigestRequest);

    public abstract void validateKey(Key key, boolean z10);

    public final byte[] digest(SecureRequest<InputStream, S> secureRequest) {
        Assert.notNull(secureRequest, "Request cannot be null.");
        Key key = (Key) Assert.notNull(secureRequest.getKey(), "Signing key cannot be null.");
        Assert.notNull(secureRequest.getPayload(), "Request content cannot be null.");
        try {
            validateKey(key, true);
            return doDigest(secureRequest);
        } catch (KeyException | SignatureException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new SignatureException("Unable to compute " + getId() + " signature with JCA algorithm '" + getJcaName() + "' " + "using key {" + KeysBridge.toString(key) + "}: " + e11.getMessage(), e11);
        }
    }

    public final boolean verify(VerifySecureDigestRequest<V> verifySecureDigestRequest) {
        Assert.notNull(verifySecureDigestRequest, "Request cannot be null.");
        Key key = (Key) Assert.notNull(verifySecureDigestRequest.getKey(), "Verification key cannot be null.");
        Assert.notNull(verifySecureDigestRequest.getPayload(), "Request content cannot be null or empty.");
        Assert.notEmpty(verifySecureDigestRequest.getDigest(), "Request signature byte array cannot be null or empty.");
        try {
            validateKey(key, false);
            return doVerify(verifySecureDigestRequest);
        } catch (KeyException | SignatureException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new SignatureException("Unable to verify " + getId() + " signature with JCA algorithm '" + getJcaName() + "' " + "using key {" + KeysBridge.toString(key) + "}: " + e11.getMessage(), e11);
        }
    }
}
