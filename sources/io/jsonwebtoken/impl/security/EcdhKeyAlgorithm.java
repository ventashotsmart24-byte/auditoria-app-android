package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.impl.DefaultJweHeader;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.Curve;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyLengthSupplier;
import io.jsonwebtoken.security.KeyPairBuilder;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.Request;
import io.jsonwebtoken.security.SecureRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECKey;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

class EcdhKeyAlgorithm extends CryptoAlgorithm implements KeyAlgorithm<PublicKey, PrivateKey> {
    private static final ConcatKDF CONCAT_KDF = new ConcatKDF(CONCAT_KDF_HASH_ALG_NAME);
    private static final String CONCAT_KDF_HASH_ALG_NAME = "SHA-256";
    protected static final String DEFAULT_ID = "ECDH-ES";
    protected static final String JCA_NAME = "ECDH";
    protected static final String XDH_JCA_NAME = "XDH";
    private final KeyAlgorithm<SecretKey, SecretKey> WRAP_ALG;

    public EcdhKeyAlgorithm() {
        this(new DirectKeyAlgorithm());
    }

    private static AbstractCurve assertCurve(Key key) {
        String str;
        Curve findByKey = StandardCurves.findByKey(key);
        if (findByKey == null) {
            if (key instanceof PublicKey) {
                str = "encryption ";
            } else {
                str = "decryption ";
            }
            throw new InvalidKeyException("Unable to determine JWA-standard Elliptic Curve for " + str + "key [" + KeysBridge.toString(key) + "]");
        } else if (!(findByKey instanceof EdwardsCurve) || !((EdwardsCurve) findByKey).isSignatureCurve()) {
            return (AbstractCurve) Assert.isInstanceOf(AbstractCurve.class, findByKey, "AbstractCurve instance expected.");
        } else {
            throw new InvalidKeyException(findByKey.getId() + " keys may not be used with ECDH-ES key agreement algorithms per " + "https://www.rfc-editor.org/rfc/rfc8037#section-3.1.");
        }
    }

    private byte[] createOtherInfo(int i10, String str, byte[] bArr, byte[] bArr2) {
        Assert.hasText(str, "AlgorithmId cannot be null or empty.");
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        if (Arrays.length(bArr) == 0) {
            bArr = Bytes.EMPTY;
        }
        if (Arrays.length(bArr2) == 0) {
            bArr2 = Bytes.EMPTY;
        }
        return Bytes.concat(Bytes.toBytes(bytes.length), bytes, Bytes.toBytes(bArr.length), bArr, Bytes.toBytes(bArr2.length), bArr2, Bytes.toBytes(i10), Bytes.EMPTY);
    }

    private SecretKey deriveKey(KeyRequest<?> keyRequest, PublicKey publicKey, PrivateKey privateKey) {
        AeadAlgorithm aeadAlgorithm = (AeadAlgorithm) Assert.notNull(keyRequest.getEncryptionAlgorithm(), "Request encryptionAlgorithm cannot be null.");
        int keyBitLength = getKeyBitLength(aeadAlgorithm);
        byte[] createOtherInfo = createOtherInfo(keyBitLength, getConcatKDFAlgorithmId(aeadAlgorithm), keyRequest.getHeader().getAgreementPartyUInfo(), keyRequest.getHeader().getAgreementPartyVInfo());
        byte[] generateZ = generateZ(keyRequest, publicKey, privateKey);
        try {
            return CONCAT_KDF.deriveKey(generateZ, (long) keyBitLength, createOtherInfo);
        } finally {
            Bytes.clear(generateZ);
        }
    }

    private int getKeyBitLength(AeadAlgorithm aeadAlgorithm) {
        int i10;
        KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm = this.WRAP_ALG;
        if (keyAlgorithm instanceof KeyLengthSupplier) {
            i10 = ((KeyLengthSupplier) keyAlgorithm).getKeyBitLength();
        } else {
            i10 = aeadAlgorithm.getKeyBitLength();
        }
        return ((Integer) Assert.gt(Integer.valueOf(i10), 0, "Algorithm keyBitLength must be > 0")).intValue();
    }

    private static String idFor(KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm) {
        if (keyAlgorithm instanceof DirectKeyAlgorithm) {
            return DEFAULT_ID;
        }
        return "ECDH-ES+" + keyAlgorithm.getId();
    }

    public KeyPair generateKeyPair(Curve curve, Provider provider, SecureRandom secureRandom) {
        return (KeyPair) ((KeyPairBuilder) ((KeyPairBuilder) curve.keyPair().provider(provider)).random(secureRandom)).build();
    }

    public byte[] generateZ(final KeyRequest<?> keyRequest, final PublicKey publicKey, final PrivateKey privateKey) {
        return (byte[]) jca(keyRequest).withKeyAgreement(new CheckedFunction<KeyAgreement, byte[]>() {
            public byte[] apply(KeyAgreement keyAgreement) {
                keyAgreement.init(KeysBridge.root(privateKey), CryptoAlgorithm.ensureSecureRandom(keyRequest));
                keyAgreement.doPhase(publicKey, true);
                return keyAgreement.generateSecret();
            }
        });
    }

    public String getConcatKDFAlgorithmId(AeadAlgorithm aeadAlgorithm) {
        if (this.WRAP_ALG instanceof DirectKeyAlgorithm) {
            return (String) Assert.hasText(aeadAlgorithm.getId(), "AeadAlgorithm id cannot be null or empty.");
        }
        return getId();
    }

    public SecretKey getDecryptionKey(DecryptionKeyRequest<PrivateKey> decryptionKeyRequest) {
        Class cls;
        Assert.notNull(decryptionKeyRequest, "Request cannot be null.");
        JweHeader jweHeader = (JweHeader) Assert.notNull(decryptionKeyRequest.getHeader(), "Request JweHeader cannot be null.");
        PrivateKey privateKey = (PrivateKey) Assert.notNull(decryptionKeyRequest.getKey(), "Decryption PrivateKey cannot be null.");
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader((Header) jweHeader);
        Parameter parameter = DefaultJweHeader.EPK;
        PublicJwk publicJwk = (PublicJwk) requiredParameterReader.get(parameter);
        AbstractCurve assertCurve = assertCurve(privateKey);
        Assert.stateNotNull(assertCurve, "Internal implementation state: Curve cannot be null.");
        if (assertCurve instanceof ECCurve) {
            cls = EcPublicJwk.class;
        } else {
            cls = OctetPublicJwk.class;
        }
        if (!cls.isInstance(publicJwk)) {
            throw new InvalidKeyException("JWE Header " + parameter + " value is not an Elliptic Curve " + "Public JWK. Value: " + publicJwk);
        } else if (assertCurve.contains(publicJwk.toKey())) {
            return this.WRAP_ALG.getDecryptionKey(new DefaultDecryptionKeyRequest((byte[]) decryptionKeyRequest.getPayload(), (Provider) null, decryptionKeyRequest.getSecureRandom(), jweHeader, decryptionKeyRequest.getEncryptionAlgorithm(), deriveKey(decryptionKeyRequest, (PublicKey) publicJwk.toKey(), privateKey)));
        } else {
            throw new InvalidKeyException("JWE Header " + parameter + " value does not represent " + "a point on the expected curve. Value: " + publicJwk);
        }
    }

    public KeyResult getEncryptionKey(KeyRequest<PublicKey> keyRequest) {
        Assert.notNull(keyRequest, "Request cannot be null.");
        PublicKey publicKey = (PublicKey) Assert.notNull(keyRequest.getPayload(), "Encryption PublicKey cannot be null.");
        AbstractCurve assertCurve = assertCurve(publicKey);
        Assert.stateNotNull(assertCurve, "Internal implementation state: Curve cannot be null.");
        SecureRandom ensureSecureRandom = CryptoAlgorithm.ensureSecureRandom(keyRequest);
        KeyPair generateKeyPair = generateKeyPair(assertCurve, (Provider) null, ensureSecureRandom);
        Assert.stateNotNull(generateKeyPair, "Internal implementation state: KeyPair cannot be null.");
        KeyResult encryptionKey = this.WRAP_ALG.getEncryptionKey(new DefaultKeyRequest(deriveKey(keyRequest, publicKey, generateKeyPair.getPrivate()), keyRequest.getProvider(), keyRequest.getSecureRandom(), keyRequest.getHeader(), keyRequest.getEncryptionAlgorithm()));
        ((JweHeader) Assert.notNull(keyRequest.getHeader(), "Request JweHeader cannot be null.")).put(DefaultJweHeader.EPK.getId(), (PublicJwk) ((DynamicJwkBuilder) Jwks.builder().random(ensureSecureRandom)).key(generateKeyPair.getPublic()).build());
        return encryptionKey;
    }

    public String getJcaName(Request<?> request) {
        if (request instanceof SecureRequest) {
            if (((SecureRequest) request).getKey() instanceof ECKey) {
                return super.getJcaName(request);
            }
            return XDH_JCA_NAME;
        } else if (request.getPayload() instanceof ECKey) {
            return super.getJcaName(request);
        } else {
            return XDH_JCA_NAME;
        }
    }

    public EcdhKeyAlgorithm(KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm) {
        super(idFor(keyAlgorithm), JCA_NAME);
        this.WRAP_ALG = (KeyAlgorithm) Assert.notNull(keyAlgorithm, "Wrap algorithm cannot be null.");
    }
}
