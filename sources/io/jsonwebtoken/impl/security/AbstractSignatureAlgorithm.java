package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureAlgorithm;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.text.MessageFormat;

abstract class AbstractSignatureAlgorithm extends AbstractSecureDigestAlgorithm<PrivateKey, PublicKey> implements SignatureAlgorithm {
    private static final String KEY_TYPE_MSG_PATTERN = "{0} {1} keys must be {2}s (implement {3}). Provided key type: {4}.";

    public AbstractSignatureAlgorithm(String str, String str2) {
        super(str, str2);
    }

    public byte[] doDigest(final SecureRequest<InputStream, PrivateKey> secureRequest) {
        return (byte[]) jca(secureRequest).withSignature(new CheckedFunction<Signature, byte[]>() {
            public byte[] apply(Signature signature) {
                signature.initSign((PrivateKey) secureRequest.getKey());
                return AbstractSignatureAlgorithm.this.sign(signature, (InputStream) secureRequest.getPayload());
            }
        });
    }

    public boolean doVerify(final VerifySecureDigestRequest<PublicKey> verifySecureDigestRequest) {
        return ((Boolean) jca(verifySecureDigestRequest).withSignature(new CheckedFunction<Signature, Boolean>() {
            public Boolean apply(Signature signature) {
                signature.initVerify((PublicKey) verifySecureDigestRequest.getKey());
                return Boolean.valueOf(AbstractSignatureAlgorithm.this.verify(signature, (InputStream) verifySecureDigestRequest.getPayload(), verifySecureDigestRequest.getDigest()));
            }
        })).booleanValue();
    }

    public final byte[] sign(Signature signature, InputStream inputStream) {
        byte[] bArr = new byte[2048];
        int i10 = 0;
        while (i10 != -1) {
            i10 = inputStream.read(bArr);
            if (i10 > 0) {
                signature.update(bArr, 0, i10);
            }
        }
        return signature.sign();
    }

    public void validateKey(Key key, boolean z10) {
        Class cls;
        if (z10) {
            cls = PrivateKey.class;
        } else {
            cls = PublicKey.class;
        }
        if (!cls.isInstance(key)) {
            throw new InvalidKeyException(MessageFormat.format(KEY_TYPE_MSG_PATTERN, new Object[]{getId(), AbstractSecureDigestAlgorithm.keyType(z10), cls.getSimpleName(), cls.getName(), key.getClass().getName()}));
        }
    }

    public boolean verify(Signature signature, InputStream inputStream, byte[] bArr) {
        byte[] bArr2 = new byte[1024];
        int i10 = 0;
        while (i10 != -1) {
            i10 = inputStream.read(bArr2);
            if (i10 > 0) {
                signature.update(bArr2, 0, i10);
            }
        }
        return signature.verify(bArr);
    }
}
