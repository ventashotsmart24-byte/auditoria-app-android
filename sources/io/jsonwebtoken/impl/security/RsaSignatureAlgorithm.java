package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyPairBuilder;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureAlgorithm;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import io.jsonwebtoken.security.WeakKeyException;
import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

final class RsaSignatureAlgorithm extends AbstractSignatureAlgorithm {
    private static final Set<String> KEY_ALG_NAMES = Collections.setOf("RSA", PSS_JCA_NAME, PSS_OID, RS256_OID, RS384_OID, RS512_OID);
    private static final int MIN_KEY_BIT_LENGTH = 2048;
    private static final Map<String, SignatureAlgorithm> PKCSv15_ALGS;
    static final SignatureAlgorithm PS256 = rsaSsaPss(256);
    static final SignatureAlgorithm PS384 = rsaSsaPss(384);
    static final SignatureAlgorithm PS512 = rsaSsaPss(512);
    private static final Set<String> PSS_ALG_NAMES = Collections.setOf(PSS_JCA_NAME, PSS_OID);
    static final String PSS_JCA_NAME = "RSASSA-PSS";
    static final String PSS_OID = "1.2.840.113549.1.1.10";
    static final SignatureAlgorithm RS256;
    private static final String RS256_OID = "1.2.840.113549.1.1.11";
    static final SignatureAlgorithm RS384;
    private static final String RS384_OID = "1.2.840.113549.1.1.12";
    static final SignatureAlgorithm RS512;
    private static final String RS512_OID = "1.2.840.113549.1.1.13";
    /* access modifiers changed from: private */
    public final AlgorithmParameterSpec algorithmParameterSpec;
    private final int preferredKeyBitLength;

    static {
        RsaSignatureAlgorithm rsaSignatureAlgorithm = new RsaSignatureAlgorithm(256);
        RS256 = rsaSignatureAlgorithm;
        RsaSignatureAlgorithm rsaSignatureAlgorithm2 = new RsaSignatureAlgorithm(384);
        RS384 = rsaSignatureAlgorithm2;
        RsaSignatureAlgorithm rsaSignatureAlgorithm3 = new RsaSignatureAlgorithm(512);
        RS512 = rsaSignatureAlgorithm3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        PKCSv15_ALGS = linkedHashMap;
        linkedHashMap.put(RS256_OID, rsaSignatureAlgorithm);
        linkedHashMap.put(RS384_OID, rsaSignatureAlgorithm2);
        linkedHashMap.put(RS512_OID, rsaSignatureAlgorithm3);
    }

    private RsaSignatureAlgorithm(String str, String str2, int i10, AlgorithmParameterSpec algorithmParameterSpec2) {
        super(str, str2);
        int i11 = i10 * 8;
        this.preferredKeyBitLength = i11;
        Assert.state(i11 >= 2048);
        this.algorithmParameterSpec = algorithmParameterSpec2;
    }

    public static SignatureAlgorithm findByKey(Key key) {
        String findAlgorithm = KeysBridge.findAlgorithm(key);
        if (!Strings.hasText(findAlgorithm)) {
            return null;
        }
        String upperCase = findAlgorithm.toUpperCase(Locale.ENGLISH);
        int findBitLength = KeysBridge.findBitLength(key);
        if (PSS_ALG_NAMES.contains(upperCase)) {
            if (findBitLength >= 4096) {
                return PS512;
            }
            if (findBitLength >= 3072) {
                return PS384;
            }
            if (findBitLength >= 2048) {
                return PS256;
            }
        }
        SignatureAlgorithm signatureAlgorithm = PKCSv15_ALGS.get(upperCase);
        if (signatureAlgorithm != null) {
            return signatureAlgorithm;
        }
        if ("RSA".equals(upperCase)) {
            if (findBitLength >= 4096) {
                return RS512;
            }
            if (findBitLength >= 3072) {
                return RS384;
            }
            if (findBitLength >= 2048) {
                return RS256;
            }
        }
        return null;
    }

    public static boolean isPss(Key key) {
        return PSS_ALG_NAMES.contains(KeysBridge.findAlgorithm(key));
    }

    public static boolean isRsaAlgorithmName(Key key) {
        return KEY_ALG_NAMES.contains(KeysBridge.findAlgorithm(key));
    }

    private static AlgorithmParameterSpec pssParamSpec(int i10) {
        MGF1ParameterSpec mGF1ParameterSpec = new MGF1ParameterSpec("SHA-" + i10);
        return new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, i10 / 8, 1);
    }

    private static SignatureAlgorithm rsaSsaPss(int i10) {
        return new RsaSignatureAlgorithm(i10, pssParamSpec(i10));
    }

    public byte[] doDigest(final SecureRequest<InputStream, PrivateKey> secureRequest) {
        return (byte[]) jca(secureRequest).withSignature(new CheckedFunction<Signature, byte[]>() {
            public byte[] apply(Signature signature) {
                if (RsaSignatureAlgorithm.this.algorithmParameterSpec != null) {
                    signature.setParameter(RsaSignatureAlgorithm.this.algorithmParameterSpec);
                }
                signature.initSign((PrivateKey) secureRequest.getKey());
                return RsaSignatureAlgorithm.this.sign(signature, (InputStream) secureRequest.getPayload());
            }
        });
    }

    public boolean doVerify(final VerifySecureDigestRequest<PublicKey> verifySecureDigestRequest) {
        return ((Boolean) jca(verifySecureDigestRequest).withSignature(new CheckedFunction<Signature, Boolean>() {
            public Boolean apply(Signature signature) {
                if (RsaSignatureAlgorithm.this.algorithmParameterSpec != null) {
                    signature.setParameter(RsaSignatureAlgorithm.this.algorithmParameterSpec);
                }
                signature.initVerify((PublicKey) verifySecureDigestRequest.getKey());
                return Boolean.valueOf(RsaSignatureAlgorithm.this.verify(signature, (InputStream) verifySecureDigestRequest.getPayload(), verifySecureDigestRequest.getDigest()));
            }
        })).booleanValue();
    }

    public KeyPairBuilder keyPair() {
        String str;
        if (this.algorithmParameterSpec != null) {
            str = PSS_JCA_NAME;
        } else {
            str = "RSA";
        }
        return (KeyPairBuilder) new DefaultKeyPairBuilder(str, this.preferredKeyBitLength).random(Randoms.secureRandom());
    }

    public void validateKey(Key key, boolean z10) {
        String str;
        super.validateKey(key, z10);
        if (isRsaAlgorithmName(key)) {
            int findBitLength = KeysBridge.findBitLength(key);
            if (findBitLength >= 0 && findBitLength < 2048) {
                String id = getId();
                if (id.startsWith("PS")) {
                    str = "3.5";
                } else {
                    str = "3.3";
                }
                throw new WeakKeyException("The RSA " + AbstractSecureDigestAlgorithm.keyType(z10) + " key size (aka modulus bit length) is " + findBitLength + " bits " + "which is not secure enough for the " + id + " algorithm.  The JWT JWA Specification " + "(RFC 7518, Section " + str + ") states that RSA keys MUST have a size >= " + 2048 + " bits.  Consider using the Jwts.SIG." + id + ".keyPair() builder to create a KeyPair guaranteed to be secure enough for " + id + ".  See " + "https://tools.ietf.org/html/rfc7518#section-" + str + " for more information.");
            }
            return;
        }
        throw new InvalidKeyException("Unrecognized RSA or RSASSA-PSS key algorithm name.");
    }

    private RsaSignatureAlgorithm(int i10) {
        this("RS" + i10, "SHA" + i10 + "withRSA", i10, (AlgorithmParameterSpec) null);
    }

    private RsaSignatureAlgorithm(int i10, AlgorithmParameterSpec algorithmParameterSpec2) {
        this("PS" + i10, PSS_JCA_NAME, i10, algorithmParameterSpec2);
    }
}
