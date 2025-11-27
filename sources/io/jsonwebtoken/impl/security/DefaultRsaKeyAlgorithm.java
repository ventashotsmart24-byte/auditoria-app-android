package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.WeakKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DefaultRsaKeyAlgorithm extends CryptoAlgorithm implements KeyAlgorithm<PublicKey, PrivateKey> {
    private static final int MIN_KEY_BIT_LENGTH = 2048;
    /* access modifiers changed from: private */
    public final AlgorithmParameterSpec SPEC;

    public DefaultRsaKeyAlgorithm(String str, String str2) {
        this(str, str2, (AlgorithmParameterSpec) null);
    }

    private static String keyType(boolean z10) {
        return z10 ? "encryption" : "decryption";
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public SecretKey getDecryptionKey(DecryptionKeyRequest<PrivateKey> decryptionKeyRequest) {
        Assert.notNull(decryptionKeyRequest, "request cannot be null.");
        final PrivateKey privateKey = (PrivateKey) Assert.notNull(decryptionKeyRequest.getKey(), "RSA PrivateKey decryption key cannot be null.");
        validate(privateKey, false);
        final byte[] notEmpty = Assert.notEmpty((byte[]) decryptionKeyRequest.getPayload(), "Request content (encrypted key) cannot be null or empty.");
        return (SecretKey) jca(decryptionKeyRequest).withCipher(new CheckedFunction<Cipher, SecretKey>() {
            public SecretKey apply(Cipher cipher) {
                if (DefaultRsaKeyAlgorithm.this.SPEC == null) {
                    cipher.init(4, privateKey);
                } else {
                    cipher.init(4, privateKey, DefaultRsaKeyAlgorithm.this.SPEC);
                }
                return (SecretKey) Assert.isInstanceOf(SecretKey.class, cipher.unwrap(notEmpty, "AES", 3), "Cipher unwrap must return a SecretKey instance.");
            }
        });
    }

    public KeyResult getEncryptionKey(final KeyRequest<PublicKey> keyRequest) {
        Assert.notNull(keyRequest, "Request cannot be null.");
        final PublicKey publicKey = (PublicKey) Assert.notNull(keyRequest.getPayload(), "RSA PublicKey encryption key cannot be null.");
        validate(publicKey, true);
        final SecretKey generateCek = generateCek(keyRequest);
        return new DefaultKeyResult(generateCek, (byte[]) jca(keyRequest).withCipher(new CheckedFunction<Cipher, byte[]>() {
            public byte[] apply(Cipher cipher) {
                if (DefaultRsaKeyAlgorithm.this.SPEC == null) {
                    cipher.init(3, publicKey, CryptoAlgorithm.ensureSecureRandom(keyRequest));
                } else {
                    cipher.init(3, publicKey, DefaultRsaKeyAlgorithm.this.SPEC, CryptoAlgorithm.ensureSecureRandom(keyRequest));
                }
                return cipher.wrap(generateCek);
            }
        }));
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public void validate(Key key, boolean z10) {
        String str;
        if (!RsaSignatureAlgorithm.isRsaAlgorithmName(key)) {
            throw new InvalidKeyException("Invalid RSA key algorithm name.");
        } else if (!RsaSignatureAlgorithm.isPss(key)) {
            int findBitLength = KeysBridge.findBitLength(key);
            if (findBitLength >= 0 && findBitLength < 2048) {
                String id = getId();
                if (id.startsWith("RSA1")) {
                    str = "4.2";
                } else {
                    str = "4.3";
                }
                throw new WeakKeyException("The RSA " + keyType(z10) + " key size (aka modulus bit length) is " + findBitLength + " bits which is not secure enough for the " + id + " algorithm. " + "The JWT JWA Specification (RFC 7518, Section " + str + ") states that RSA keys MUST " + "have a size >= " + 2048 + " bits. See " + "https://www.rfc-editor.org/rfc/rfc7518.html#section-" + str + " for more information.");
            }
        } else {
            throw new InvalidKeyException("RSASSA-PSS keys may not be used for " + keyType(z10) + ", only digital signature algorithms.");
        }
    }

    public DefaultRsaKeyAlgorithm(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec) {
        super(str, str2);
        this.SPEC = algorithmParameterSpec;
    }
}
