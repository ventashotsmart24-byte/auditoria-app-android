package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.impl.io.DelegateStringDecoder;
import io.jsonwebtoken.impl.io.StandardCompressionAlgorithms;
import io.jsonwebtoken.impl.lang.DefaultNestedCollection;
import io.jsonwebtoken.impl.lang.IdRegistry;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.impl.security.ConstantKeyLocator;
import io.jsonwebtoken.impl.security.StandardEncryptionAlgorithms;
import io.jsonwebtoken.impl.security.StandardKeyAlgorithms;
import io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import java.io.InputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;

public class DefaultJwtParserBuilder implements JwtParserBuilder {
    static final String MAX_CLOCK_SKEW_ILLEGAL_MSG = "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.";
    static final long MAX_CLOCK_SKEW_MILLIS = 9223372036854775L;
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private long allowedClockSkewMillis = 0;
    private Clock clock = DefaultClock.INSTANCE;
    private CompressionCodecResolver compressionCodecResolver;
    /* access modifiers changed from: private */
    public Set<String> critical = Collections.emptySet();
    private Decoder<InputStream, InputStream> decoder = new DelegateStringDecoder(Decoders.BASE64URL);
    private Key decryptionKey;
    private Deserializer<Map<String, ?>> deserializer;
    /* access modifiers changed from: private */
    public Registry<String, AeadAlgorithm> encAlgs = Jwts.ENC.get();
    private final ClaimsBuilder expectedClaims = Jwts.claims();
    /* access modifiers changed from: private */
    public Registry<String, KeyAlgorithm<?, ?>> keyAlgs = Jwts.KEY.get();
    private Locator<? extends Key> keyLocator;
    private Provider provider;
    /* access modifiers changed from: private */
    public Registry<String, SecureDigestAlgorithm<?, ?>> sigAlgs = Jwts.SIG.get();
    private Key signatureVerificationKey;
    private SigningKeyResolver signingKeyResolver = null;
    private boolean unsecured = false;
    private boolean unsecuredDecompression = false;
    /* access modifiers changed from: private */
    public Registry<String, CompressionAlgorithm> zipAlgs = Jwts.ZIP.get();

    public JwtParserBuilder b64Url(Decoder<InputStream, InputStream> decoder2) {
        Assert.notNull(decoder2, "decoder cannot be null.");
        this.decoder = decoder2;
        return this;
    }

    public JwtParserBuilder base64UrlDecodeWith(Decoder<CharSequence, byte[]> decoder2) {
        Assert.notNull(decoder2, "decoder cannot be null.");
        return b64Url(new DelegateStringDecoder(decoder2));
    }

    public JwtParserBuilder clock(Clock clock2) {
        Assert.notNull(clock2, "Clock instance cannot be null.");
        this.clock = clock2;
        return this;
    }

    public JwtParserBuilder clockSkewSeconds(long j10) {
        boolean z10;
        if (j10 <= MAX_CLOCK_SKEW_MILLIS) {
            z10 = true;
        } else {
            z10 = false;
        }
        Assert.isTrue(z10, MAX_CLOCK_SKEW_ILLEGAL_MSG);
        this.allowedClockSkewMillis = Math.max(0, j10 * 1000);
        return this;
    }

    public NestedCollection<String, JwtParserBuilder> critical() {
        return new DefaultNestedCollection<String, JwtParserBuilder>(this, this.critical) {
            public void changed() {
                Set unused = DefaultJwtParserBuilder.this.critical = Collections.asSet(getCollection());
            }
        };
    }

    public JwtParserBuilder decryptWith(SecretKey secretKey) {
        return decryptWith((Key) secretKey);
    }

    public JwtParserBuilder deserializeJsonWith(Deserializer<Map<String, ?>> deserializer2) {
        return json(deserializer2);
    }

    public NestedCollection<AeadAlgorithm, JwtParserBuilder> enc() {
        return new DefaultNestedCollection<AeadAlgorithm, JwtParserBuilder>(this, this.encAlgs.values()) {
            public void changed() {
                Registry unused = DefaultJwtParserBuilder.this.encAlgs = new IdRegistry(StandardEncryptionAlgorithms.NAME, getCollection());
            }
        };
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, io.jsonwebtoken.io.Deserializer<java.util.Map<java.lang.String, ?>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.JwtParserBuilder json(io.jsonwebtoken.io.Deserializer<java.util.Map<java.lang.String, ?>> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "JSON Deserializer cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.io.Deserializer r2 = (io.jsonwebtoken.io.Deserializer) r2
            r1.deserializer = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.DefaultJwtParserBuilder.json(io.jsonwebtoken.io.Deserializer):io.jsonwebtoken.JwtParserBuilder");
    }

    public NestedCollection<KeyAlgorithm<?, ?>, JwtParserBuilder> key() {
        return new DefaultNestedCollection<KeyAlgorithm<?, ?>, JwtParserBuilder>(this, this.keyAlgs.values()) {
            public void changed() {
                Registry unused = DefaultJwtParserBuilder.this.keyAlgs = new IdRegistry(StandardKeyAlgorithms.NAME, getCollection());
            }
        };
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.jsonwebtoken.Locator<java.security.Key>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.JwtParserBuilder keyLocator(io.jsonwebtoken.Locator<java.security.Key> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "Key locator cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.Locator r2 = (io.jsonwebtoken.Locator) r2
            r1.keyLocator = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.DefaultJwtParserBuilder.keyLocator(io.jsonwebtoken.Locator):io.jsonwebtoken.JwtParserBuilder");
    }

    public JwtParserBuilder provider(Provider provider2) {
        this.provider = provider2;
        return this;
    }

    public JwtParserBuilder require(String str, Object obj) {
        Assert.hasText(str, "claim name cannot be null or empty.");
        Assert.notNull(obj, "The value cannot be null for claim name: " + str);
        this.expectedClaims.add(str, obj);
        return this;
    }

    public JwtParserBuilder requireAudience(String str) {
        ((NestedCollection) this.expectedClaims.audience().add(str)).and();
        return this;
    }

    public JwtParserBuilder requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    public JwtParserBuilder requireId(String str) {
        this.expectedClaims.setId(str);
        return this;
    }

    public JwtParserBuilder requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    public JwtParserBuilder requireIssuer(String str) {
        this.expectedClaims.setIssuer(str);
        return this;
    }

    public JwtParserBuilder requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    public JwtParserBuilder requireSubject(String str) {
        this.expectedClaims.setSubject(str);
        return this;
    }

    public JwtParserBuilder setAllowedClockSkewSeconds(long j10) {
        return clockSkewSeconds(j10);
    }

    public JwtParserBuilder setClock(Clock clock2) {
        return clock(clock2);
    }

    public JwtParserBuilder setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver2) {
        this.compressionCodecResolver = (CompressionCodecResolver) Assert.notNull(compressionCodecResolver2, "CompressionCodecResolver cannot be null.");
        return this;
    }

    public JwtParserBuilder setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signature verification key cannot be null or empty.");
        return setSigningKey((Key) Keys.hmacShaKeyFor(bArr));
    }

    public JwtParserBuilder setSigningKeyResolver(SigningKeyResolver signingKeyResolver2) {
        Assert.notNull(signingKeyResolver2, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver2;
        return this;
    }

    public NestedCollection<SecureDigestAlgorithm<?, ?>, JwtParserBuilder> sig() {
        return new DefaultNestedCollection<SecureDigestAlgorithm<?, ?>, JwtParserBuilder>(this, this.sigAlgs.values()) {
            public void changed() {
                Registry unused = DefaultJwtParserBuilder.this.sigAlgs = new IdRegistry(StandardSecureDigestAlgorithms.NAME, getCollection());
            }
        };
    }

    public JwtParserBuilder unsecured() {
        this.unsecured = true;
        return this;
    }

    public JwtParserBuilder unsecuredDecompression() {
        this.unsecuredDecompression = true;
        return this;
    }

    public JwtParserBuilder verifyWith(SecretKey secretKey) {
        return verifyWith((Key) secretKey);
    }

    public NestedCollection<CompressionAlgorithm, JwtParserBuilder> zip() {
        return new DefaultNestedCollection<CompressionAlgorithm, JwtParserBuilder>(this, this.zipAlgs.values()) {
            public void changed() {
                Registry unused = DefaultJwtParserBuilder.this.zipAlgs = new IdRegistry(StandardCompressionAlgorithms.NAME, getCollection());
            }
        };
    }

    public JwtParser build() {
        if (this.deserializer == null) {
            json((Deserializer) Services.get(Deserializer.class));
        }
        if (this.signingKeyResolver == null || this.signatureVerificationKey == null) {
            Locator locator = this.keyLocator;
            if (locator != null) {
                if (this.signatureVerificationKey != null) {
                    throw new IllegalStateException("Both 'keyLocator' and a 'verifyWith' key cannot be configured. Prefer 'keyLocator' if possible.");
                } else if (this.decryptionKey != null) {
                    throw new IllegalStateException("Both 'keyLocator' and a 'decryptWith' key cannot be configured. Prefer 'keyLocator' if possible.");
                }
            }
            if (locator == null) {
                locator = new ConstantKeyLocator(this.signatureVerificationKey, this.decryptionKey);
            }
            Locator locator2 = locator;
            if (!this.unsecured && this.unsecuredDecompression) {
                throw new IllegalStateException("'unsecuredDecompression' is only relevant if 'unsecured' is also configured. Please read the JavaDoc of both features before enabling either due to their security implications.");
            } else if (this.compressionCodecResolver == null || Jwts.ZIP.get().equals(this.zipAlgs)) {
                Assert.stateNotNull(locator2, "Key locator should never be null.");
                return new DefaultJwtParser(this.provider, this.signingKeyResolver, this.unsecured, this.unsecuredDecompression, locator2, this.clock, this.critical, this.allowedClockSkewMillis, (DefaultClaims) this.expectedClaims.build(), this.decoder, this.deserializer, this.compressionCodecResolver, this.zipAlgs, this.sigAlgs, this.keyAlgs, this.encAlgs);
            } else {
                throw new IllegalStateException("Both 'zip()' and 'compressionCodecResolver' cannot be configured. Choose either.");
            }
        } else {
            throw new IllegalStateException("Both a 'signingKeyResolver and a 'verifyWith' key cannot be configured. Choose either, or prefer `keyLocator` when possible.");
        }
    }

    public JwtParserBuilder decryptWith(PrivateKey privateKey) {
        return decryptWith((Key) privateKey);
    }

    public JwtParserBuilder verifyWith(PublicKey publicKey) {
        return verifyWith((Key) publicKey);
    }

    private JwtParserBuilder decryptWith(Key key) {
        if (!(key instanceof PublicKey)) {
            this.decryptionKey = (Key) Assert.notNull(key, "decryption key cannot be null.");
            return this;
        }
        throw new IllegalArgumentException("PublicKeys may not be used to decrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt.");
    }

    private JwtParserBuilder verifyWith(Key key) {
        if (!(key instanceof PrivateKey)) {
            this.signatureVerificationKey = (Key) Assert.notNull(key, "signature verification key cannot be null.");
            return this;
        }
        throw new IllegalArgumentException("PrivateKeys may not be used to verify digital signatures. PrivateKeys are used to sign, and PublicKeys are used to verify.");
    }

    public JwtParserBuilder setSigningKey(String str) {
        Assert.hasText(str, "signature verification key cannot be null or empty.");
        return setSigningKey(Decoders.BASE64.decode(str));
    }

    public JwtParserBuilder setSigningKey(Key key) {
        if (key instanceof SecretKey) {
            return verifyWith((SecretKey) key);
        }
        if (key instanceof PublicKey) {
            return verifyWith((PublicKey) key);
        }
        throw new InvalidKeyException("JWS verification key must be either a SecretKey (for MAC algorithms) or a PublicKey (for Signature algorithms).");
    }
}
