package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyPairBuilder;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.security.Key;
import java.security.PrivateKey;

final class EdSignatureAlgorithm extends AbstractSignatureAlgorithm {
    private static final String ID = "EdDSA";
    static final EdSignatureAlgorithm INSTANCE = new EdSignatureAlgorithm();
    private final EdwardsCurve preferredCurve;

    private EdSignatureAlgorithm() {
        super(ID, ID);
        EdwardsCurve edwardsCurve = EdwardsCurve.Ed448;
        this.preferredCurve = edwardsCurve;
        Assert.isTrue(edwardsCurve.isSignatureCurve(), "Must be signature curve, not key agreement curve.");
    }

    public static boolean isSigningKey(PrivateKey privateKey) {
        EdwardsCurve findByKey = EdwardsCurve.findByKey(privateKey);
        if (findByKey == null || !findByKey.isSignatureCurve()) {
            return false;
        }
        return true;
    }

    public String getJcaName(Request<?> request) {
        Key key = (Key) Assert.notNull(((SecureRequest) Assert.isInstanceOf(SecureRequest.class, request, "SecureRequests are required.")).getKey(), "Request key cannot be null.");
        String jcaName = getJcaName();
        if (!(request instanceof VerifyDigestRequest)) {
            return EdwardsCurve.forKey(key).getJcaName();
        }
        return jcaName;
    }

    public KeyPairBuilder keyPair() {
        return this.preferredCurve.keyPair();
    }

    public void validateKey(Key key, boolean z10) {
        super.validateKey(key, z10);
        EdwardsCurve forKey = EdwardsCurve.forKey(key);
        if (!forKey.isSignatureCurve()) {
            throw new InvalidKeyException(forKey.getId() + " keys may not be used with " + getId() + " digital signatures per " + "https://www.rfc-editor.org/rfc/rfc8037.html#section-3.2");
        }
    }
}
