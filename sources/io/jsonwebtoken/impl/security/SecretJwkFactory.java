package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.SecretJwk;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import io.jsonwebtoken.security.WeakKeyException;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

class SecretJwkFactory extends AbstractFamilyJwkFactory<SecretKey, SecretJwk> {
    public SecretJwkFactory() {
        super("oct", SecretKey.class, DefaultSecretJwk.PARAMS);
    }

    private static void assertKeyBitLength(byte[] bArr, MacAlgorithm macAlgorithm) {
        long bitLength = Bytes.bitLength(bArr);
        long keyBitLength = (long) macAlgorithm.getKeyBitLength();
        if (bitLength < keyBitLength) {
            throw new WeakKeyException("Secret JWK " + AbstractJwk.ALG + " value is '" + macAlgorithm.getId() + "', but the " + DefaultSecretJwk.K + " length is smaller than the " + macAlgorithm.getId() + " minimum length of " + Bytes.bitsMsg(keyBitLength) + " required by " + "[JWA RFC 7518, Section 3.2](https://www.rfc-editor.org/rfc/rfc7518.html#section-3.2), " + "2nd paragraph: 'A key of the same size as the hash output or larger MUST be used with this " + "algorithm.'");
        }
    }

    private static void assertSymmetric(Identifiable identifiable) {
        if (!(identifiable instanceof MacAlgorithm) && !(identifiable instanceof SecretKeyAlgorithm) && !(identifiable instanceof AeadAlgorithm)) {
            throw new MalformedKeyException("Invalid Secret JWK " + AbstractJwk.ALG + " value '" + identifiable.getId() + "'. Secret JWKs " + "may only be used with symmetric (secret) key algorithms.");
        }
    }

    public SecretJwk createJwkFromKey(JwkContext<SecretKey> jwkContext) {
        byte[] bArr;
        SecretKey secretKey = (SecretKey) Assert.notNull(jwkContext.getKey(), "JwkContext key cannot be null.");
        try {
            bArr = KeysBridge.getEncoded(secretKey);
            try {
                String encode = Encoders.BASE64URL.encode(bArr);
                Assert.hasText(encode, "k value cannot be null or empty.");
                Bytes.clear(bArr);
                DefaultMacAlgorithm findByKey = DefaultMacAlgorithm.findByKey(secretKey);
                if (findByKey != null) {
                    jwkContext.put(AbstractJwk.ALG.getId(), findByKey.getId());
                }
                jwkContext.put(DefaultSecretJwk.K.getId(), encode);
                return createJwkFromValues((JwkContext) jwkContext);
            } catch (Throwable th) {
                th = th;
                try {
                    throw new InvalidKeyException("Unable to encode SecretKey to JWK: " + th.getMessage(), th);
                } catch (Throwable th2) {
                    Bytes.clear(bArr);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
            throw new InvalidKeyException("Unable to encode SecretKey to JWK: " + th.getMessage(), th);
        }
    }

    public SecretJwk createJwkFromValues(JwkContext<SecretKey> jwkContext) {
        Key key;
        SecretKey secretKey;
        byte[] bArr = (byte[]) new RequiredParameterReader((ParameterReadable) jwkContext).get(DefaultSecretJwk.K);
        String algorithm = jwkContext.getAlgorithm();
        if (!Strings.hasText(algorithm)) {
            int bitLength = (int) Bytes.bitLength(bArr);
            if (jwkContext.isSigUse() || bitLength > Jwts.SIG.HS256.getKeyBitLength()) {
                secretKey = Keys.hmacShaKeyFor(bArr);
            } else {
                secretKey = AesAlgorithm.keyFor(bArr);
            }
            jwkContext.setKey(secretKey);
            return new DefaultSecretJwk(jwkContext);
        }
        Identifiable identifiable = Jwts.SIG.get().get(algorithm);
        if (identifiable == null) {
            identifiable = Jwts.KEY.get().get(algorithm);
        }
        if (identifiable == null) {
            identifiable = Jwts.ENC.get().get(algorithm);
        }
        if (identifiable != null) {
            assertSymmetric(identifiable);
        }
        if (identifiable instanceof MacAlgorithm) {
            assertKeyBitLength(bArr, (MacAlgorithm) identifiable);
            String jcaName = ((CryptoAlgorithm) identifiable).getJcaName();
            Assert.hasText(jcaName, "Algorithm jcaName cannot be null or empty.");
            key = new SecretKeySpec(bArr, jcaName);
        } else {
            key = AesAlgorithm.keyFor(bArr);
        }
        jwkContext.setKey(key);
        return new DefaultSecretJwk(jwkContext);
    }
}
