package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.io.Base64UrlStreamEncoder;
import io.jsonwebtoken.impl.io.ByteBase64UrlStreamEncoder;
import io.jsonwebtoken.impl.io.CountingInputStream;
import io.jsonwebtoken.impl.io.EncodingOutputStream;
import io.jsonwebtoken.impl.io.NamedSerializer;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.io.UncloseableInputStream;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Functions;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.impl.security.DefaultAeadRequest;
import io.jsonwebtoken.impl.security.DefaultAeadResult;
import io.jsonwebtoken.impl.security.DefaultKeyRequest;
import io.jsonwebtoken.impl.security.DefaultSecureRequest;
import io.jsonwebtoken.impl.security.Pbes2HsAkwAlgorithm;
import io.jsonwebtoken.impl.security.ProviderKey;
import io.jsonwebtoken.impl.security.StandardSecureDigestAlgorithms;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DefaultJwtBuilder implements JwtBuilder {
    private static final String PRIV_KEY_ENC_MSG = "PrivateKeys may not be used to encrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt.";
    private static final String PUB_KEY_SIGN_MSG = "PublicKeys may not be used to create digital signatures. PrivateKeys are used to sign, and PublicKeys are used to verify.";
    private final DefaultBuilderClaims claimsBuilder = new DefaultBuilderClaims(this);
    protected CompressionAlgorithm compressionAlgorithm;
    /* access modifiers changed from: private */
    public AeadAlgorithm enc;
    private boolean encodePayload = true;
    protected Encoder<OutputStream, OutputStream> encoder = Base64UrlStreamEncoder.INSTANCE;
    private final DefaultBuilderHeader headerBuilder = new DefaultBuilderHeader(this);
    private Key key;
    private KeyAlgorithm<Key, ?> keyAlg;
    private Function<KeyRequest<Key>, KeyResult> keyAlgFunction;
    private Payload payload = Payload.EMPTY;
    protected Provider provider;
    protected SecureRandom secureRandom;
    private Serializer<Map<String, ?>> serializer;
    /* access modifiers changed from: private */
    public SecureDigestAlgorithm<Key, ?> sigAlg = Jwts.SIG.NONE;
    private Function<SecureRequest<InputStream, Key>, byte[]> signFunction;

    public static class DefaultBuilderClaims extends DelegatingClaimsMutator<JwtBuilder.BuilderClaims> implements JwtBuilder.BuilderClaims {
        private final JwtBuilder builder;

        /* access modifiers changed from: private */
        public Claims build() {
            return new DefaultClaims((ParameterMap) this.DELEGATE);
        }

        private DefaultBuilderClaims(JwtBuilder jwtBuilder) {
            this.builder = jwtBuilder;
        }

        public JwtBuilder and() {
            return this.builder;
        }
    }

    public static class DefaultBuilderHeader extends DefaultJweHeaderBuilder<JwtBuilder.BuilderHeader> implements JwtBuilder.BuilderHeader {
        private final JwtBuilder builder;

        /* access modifiers changed from: private */
        public Header build() {
            return new DefaultJwtHeaderBuilder(this).build();
        }

        /* access modifiers changed from: private */
        public <T> T get(Parameter<T> parameter) {
            return ((ParameterMap) this.DELEGATE).get(parameter);
        }

        private DefaultBuilderHeader(JwtBuilder jwtBuilder) {
            this.builder = (JwtBuilder) Assert.notNull(jwtBuilder, "JwtBuilder cannot be null.");
        }

        public JwtBuilder and() {
            return this.builder;
        }
    }

    private void assertPayloadEncoding(String str) {
        if (!this.encodePayload) {
            throw new IllegalArgumentException("Payload encoding may not be disabled for " + str + "s, only JWSs.");
        }
    }

    private OutputStream encode(OutputStream outputStream, String str) {
        return new EncodingOutputStream(this.encoder.encode(outputStream), "base64url", str);
    }

    private void encodeAndWrite(String str, Map<String, ?> map, OutputStream outputStream) {
        writeAndClose(str, map, encode(outputStream, str));
    }

    private void encrypt(final AeadRequest aeadRequest, final AeadResult aeadResult) {
        Functions.wrap(new Function<Object, Object>() {
            public Object apply(Object obj) {
                DefaultJwtBuilder.this.enc.encrypt(aeadRequest, aeadResult);
                return null;
            }
        }, SecurityException.class, "%s encryption failed.", this.enc.getId()).apply(null);
    }

    public static <K extends Key> SecureDigestAlgorithm<K, ?> forSigningKey(K k10) {
        Assert.notNull(k10, "Key cannot be null.");
        SecureDigestAlgorithm<K, ?> findBySigningKey = StandardSecureDigestAlgorithms.findBySigningKey(k10);
        if (findBySigningKey != null) {
            return findBySigningKey;
        }
        throw new UnsupportedKeyException("Unable to determine a suitable MAC or Signature algorithm for the specified key using available heuristics: either the key size is too weak be used with available algorithms, or the key size is unavailable (e.g. if using a PKCS11 or HSM (Hardware Security Module) key store). If you are using a PKCS11 or HSM keystore, consider using the JwtBuilder.signWith(Key, SecureDigestAlgorithm) method instead.");
    }

    /* JADX INFO: finally extract failed */
    private String sign(Payload payload2, Key key2, Provider provider2) {
        InputStream inputStream;
        InputStream inputStream2;
        Assert.stateNotNull(key2, "Key is required.");
        Assert.stateNotNull(this.sigAlg, "SignatureAlgorithm is required.");
        Assert.stateNotNull(this.signFunction, "Signature Algorithm function cannot be null.");
        Assert.stateNotNull(payload2, "Payload argument cannot be null.");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        this.headerBuilder.add(DefaultHeader.ALGORITHM.getId(), this.sigAlg.getId());
        if (!this.encodePayload) {
            String id = DefaultJwsHeader.B64.getId();
            ((JwtBuilder.BuilderHeader) ((NestedCollection) this.headerBuilder.critical().add(id)).and()).add(id, Boolean.FALSE);
        }
        encodeAndWrite("JWS Protected Header", (Map<String, ?>) (JwsHeader) Assert.isInstanceOf(JwsHeader.class, this.headerBuilder.build()), (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        if (this.encodePayload) {
            encodeAndWrite("JWS Payload", payload2, (OutputStream) byteArrayOutputStream);
            inputStream2 = Streams.of(byteArrayOutputStream.toByteArray());
            inputStream = null;
        } else {
            InputStream of = Streams.of(byteArrayOutputStream.toByteArray());
            inputStream = toInputStream("JWS Unencoded Payload", payload2);
            if (!payload2.isClaims()) {
                inputStream = new CountingInputStream(inputStream);
            }
            if (inputStream.markSupported()) {
                inputStream.mark(0);
            }
            inputStream2 = new SequenceInputStream(of, new UncloseableInputStream(inputStream));
        }
        try {
            byte[] apply = this.signFunction.apply(new DefaultSecureRequest(inputStream2, provider2, this.secureRandom, key2));
            if (!this.encodePayload) {
                if (!payload2.isCompressed() && (payload2.isClaims() || payload2.isString())) {
                    Streams.copy(inputStream, byteArrayOutputStream, new byte[8192], "Unable to copy attached Payload InputStream.");
                }
                if (inputStream instanceof CountingInputStream) {
                    if (((CountingInputStream) inputStream).getCount() <= 0) {
                        throw new IllegalStateException("'b64' Unencoded payload option has been specified, but payload is empty.");
                    }
                }
            }
            Streams.reset(inputStream);
            byteArrayOutputStream.write(46);
            encodeAndWrite("JWS Signature", apply, (OutputStream) byteArrayOutputStream);
            return Strings.utf8(byteArrayOutputStream.toByteArray());
        } catch (Throwable th) {
            Streams.reset(inputStream);
            throw th;
        }
    }

    private InputStream toInputStream(String str, Payload payload2) {
        if (!payload2.isClaims() && !payload2.isCompressed()) {
            return (InputStream) Assert.stateNotNull(payload2.toInputStream(), "Payload InputStream cannot be null.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        writeAndClose(str, payload2, (OutputStream) byteArrayOutputStream);
        return Streams.of(byteArrayOutputStream.toByteArray());
    }

    private String unprotected(Payload payload2) {
        Assert.stateNotNull(payload2, "Content argument cannot be null.");
        assertPayloadEncoding("unprotected JWT");
        this.headerBuilder.add(DefaultHeader.ALGORITHM.getId(), Jwts.SIG.NONE.getId());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        encodeAndWrite("JWT Header", (Map<String, ?>) this.headerBuilder.build(), (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWT Payload", payload2, (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        return Strings.ascii(byteArrayOutputStream.toByteArray());
    }

    private void writeAndClose(String str, Map<String, ?> map, OutputStream outputStream) {
        try {
            new NamedSerializer(str, this.serializer).serialize(map, outputStream);
        } finally {
            Objects.nullSafeClose(outputStream);
        }
    }

    public JwtBuilder addClaims(Map<String, ?> map) {
        return claims(map);
    }

    public ClaimsMutator.AudienceCollection<JwtBuilder> audience() {
        return new DelegateAudienceCollection(this, claims().audience());
    }

    public JwtBuilder b64Url(Encoder<OutputStream, OutputStream> encoder2) {
        Assert.notNull(encoder2, "encoder cannot be null.");
        this.encoder = encoder2;
        return this;
    }

    public JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder2) {
        return b64Url(new ByteBase64UrlStreamEncoder(encoder2));
    }

    public JwtBuilder claim(String str, Object obj) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().add(str, obj)).and();
    }

    public JwtBuilder.BuilderClaims claims() {
        return this.claimsBuilder;
    }

    public String compact() {
        boolean z10;
        if (this.enc != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || this.signFunction == null) {
            Payload payload2 = (Payload) Assert.stateNotNull(this.payload, "Payload instance null, internal error");
            Claims access$400 = this.claimsBuilder.build();
            if (z10 && payload2.isEmpty() && Collections.isEmpty((Map<?, ?>) access$400)) {
                throw new IllegalStateException("Encrypted JWTs must have either 'claims' or non-empty 'content'.");
            } else if (payload2.isEmpty() || Collections.isEmpty((Map<?, ?>) access$400)) {
                if (this.serializer == null) {
                    json((Serializer) Services.get(Serializer.class));
                }
                if (!Collections.isEmpty((Map<?, ?>) access$400)) {
                    payload2 = new Payload(access$400);
                }
                if (this.compressionAlgorithm != null && !payload2.isEmpty()) {
                    payload2.setZip(this.compressionAlgorithm);
                    this.headerBuilder.put(DefaultHeader.COMPRESSION_ALGORITHM.getId(), this.compressionAlgorithm.getId());
                }
                if (Strings.hasText(payload2.getContentType())) {
                    this.headerBuilder.contentType(payload2.getContentType());
                }
                Provider provider2 = ProviderKey.getProvider(this.key, this.provider);
                Key key2 = ProviderKey.getKey(this.key);
                if (z10) {
                    return encrypt(payload2, key2, provider2);
                }
                if (key2 != null) {
                    return sign(payload2, key2, provider2);
                }
                return unprotected(payload2);
            } else {
                throw new IllegalStateException("Both 'content' and 'claims' cannot be specified. Choose either one.");
            }
        } else {
            throw new IllegalStateException("Both 'signWith' and 'encryptWith' cannot be specified. Choose either one.");
        }
    }

    public JwtBuilder compressWith(CompressionAlgorithm compressionAlgorithm2) {
        Assert.notNull(compressionAlgorithm2, "CompressionAlgorithm cannot be null");
        Assert.hasText(compressionAlgorithm2.getId(), "CompressionAlgorithm id cannot be null or empty.");
        this.compressionAlgorithm = compressionAlgorithm2;
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.COMPRESSION_ALGORITHM.getId())).and();
    }

    public JwtBuilder content(String str) {
        if (Strings.hasText(str)) {
            this.payload = new Payload((CharSequence) str, (String) null);
        }
        return this;
    }

    public JwtBuilder encodePayload(boolean z10) {
        this.encodePayload = z10;
        Parameter<Set<String>> parameter = DefaultProtectedHeader.CRIT;
        String id = parameter.getId();
        String id2 = DefaultJwsHeader.B64.getId();
        LinkedHashSet linkedHashSet = new LinkedHashSet(Collections.nullSafe((Set) this.headerBuilder.get(parameter)));
        linkedHashSet.remove(id2);
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) ((JwtBuilder.BuilderHeader) header().delete(id2)).add(id, linkedHashSet)).and();
    }

    public JwtBuilder encryptWith(SecretKey secretKey, AeadAlgorithm aeadAlgorithm) {
        if (secretKey instanceof Password) {
            return encryptWith((Password) secretKey, new Pbes2HsAkwAlgorithm(aeadAlgorithm.getKeyBitLength()), aeadAlgorithm);
        }
        return encryptWith(secretKey, Jwts.KEY.DIRECT, aeadAlgorithm);
    }

    public JwtBuilder.BuilderHeader header() {
        return this.headerBuilder;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.jsonwebtoken.io.Serializer<java.util.Map<java.lang.String, ?>>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.JwtBuilder json(io.jsonwebtoken.io.Serializer<java.util.Map<java.lang.String, ?>> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "JSON Serializer cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.io.Serializer r2 = (io.jsonwebtoken.io.Serializer) r2
            r1.serializer = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.DefaultJwtBuilder.json(io.jsonwebtoken.io.Serializer):io.jsonwebtoken.JwtBuilder");
    }

    public JwtBuilder provider(Provider provider2) {
        this.provider = provider2;
        return this;
    }

    public JwtBuilder random(SecureRandom secureRandom2) {
        this.secureRandom = secureRandom2;
        return this;
    }

    public JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer2) {
        return json(serializer2);
    }

    public JwtBuilder setClaims(Map<String, ?> map) {
        Assert.notNull(map, "Claims map cannot be null.");
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) ((JwtBuilder.BuilderClaims) claims().empty()).add(map)).and();
    }

    public JwtBuilder setHeader(Map<String, ?> map) {
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) ((JwtBuilder.BuilderHeader) header().empty()).add(map)).and();
    }

    public JwtBuilder setHeaderParam(String str, Object obj) {
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) header().add(str, obj)).and();
    }

    public JwtBuilder setHeaderParams(Map<String, ?> map) {
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) header().add(map)).and();
    }

    public JwtBuilder setPayload(String str) {
        return content(str);
    }

    public JwtBuilder signWith(Key key2) {
        Assert.notNull(key2, "Key argument cannot be null.");
        return signWith(key2, forSigningKey(key2));
    }

    public JwtBuilder claims(Map<String, ?> map) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().add(map)).and();
    }

    public JwtBuilder expiration(Date date) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().expiration(date)).and();
    }

    public JwtBuilder id(String str) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().id(str)).and();
    }

    public JwtBuilder issuedAt(Date date) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().issuedAt(date)).and();
    }

    public JwtBuilder issuer(String str) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().issuer(str)).and();
    }

    public JwtBuilder notBefore(Date date) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().notBefore(date)).and();
    }

    public JwtBuilder setAudience(String str) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().setAudience(str)).and();
    }

    public JwtBuilder setExpiration(Date date) {
        return expiration(date);
    }

    public JwtBuilder setId(String str) {
        return id(str);
    }

    public JwtBuilder setIssuedAt(Date date) {
        return issuedAt(date);
    }

    public JwtBuilder setIssuer(String str) {
        return issuer(str);
    }

    public JwtBuilder setNotBefore(Date date) {
        return notBefore(date);
    }

    public JwtBuilder setSubject(String str) {
        return subject(str);
    }

    public JwtBuilder subject(String str) {
        return (JwtBuilder) ((JwtBuilder.BuilderClaims) claims().subject(str)).and();
    }

    private void encodeAndWrite(String str, Payload payload2, OutputStream outputStream) {
        writeAndClose(str, payload2, encode(outputStream, str));
    }

    private String encrypt(Payload payload2, Key key2, Provider provider2) {
        Assert.stateNotNull(payload2, "Payload argument cannot be null.");
        Assert.stateNotNull(key2, "Key is required.");
        Assert.stateNotNull(this.enc, "Encryption algorithm is required.");
        Assert.stateNotNull(this.keyAlg, "KeyAlgorithm is required.");
        Assert.stateNotNull(this.keyAlgFunction, "KeyAlgorithm function cannot be null.");
        assertPayloadEncoding("JWE");
        InputStream inputStream = toInputStream("JWE Payload", payload2);
        Key key3 = key2;
        Provider provider3 = provider2;
        KeyResult apply = this.keyAlgFunction.apply(new DefaultKeyRequest(key3, provider3, this.secureRandom, new DefaultMutableJweHeader(this.headerBuilder), this.enc));
        Assert.stateNotNull(apply, "KeyAlgorithm must return a KeyResult.");
        this.headerBuilder.add(DefaultHeader.ALGORITHM.getId(), this.keyAlg.getId());
        this.headerBuilder.put(DefaultJweHeader.ENCRYPTION_ALGORITHM.getId(), this.enc.getId());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        encodeAndWrite("JWE Protected Header", (Map<String, ?>) (JweHeader) Assert.isInstanceOf(JweHeader.class, this.headerBuilder.build(), "Invalid header created: "), (OutputStream) byteArrayOutputStream);
        InputStream of = Streams.of(byteArrayOutputStream.toByteArray());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(8192);
        DefaultAeadRequest defaultAeadRequest = new DefaultAeadRequest(inputStream, (Provider) null, this.secureRandom, (SecretKey) Assert.notNull(apply.getKey(), "KeyResult must return a content encryption key."), of);
        DefaultAeadResult defaultAeadResult = new DefaultAeadResult(byteArrayOutputStream2);
        encrypt(defaultAeadRequest, defaultAeadResult);
        byte[] notEmpty = Assert.notEmpty(defaultAeadResult.getIv(), "Encryption result must have a non-empty initialization vector.");
        byte[] notEmpty2 = Assert.notEmpty(defaultAeadResult.getDigest(), "Encryption result must have a non-empty authentication tag.");
        byte[] notEmpty3 = Assert.notEmpty(byteArrayOutputStream2.toByteArray(), "Encryption result must have non-empty ciphertext.");
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE Encrypted CEK", (byte[]) Assert.notNull(apply.getPayload(), "KeyResult must return an encrypted key byte array, even if empty."), (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE Initialization Vector", notEmpty, (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE Ciphertext", notEmpty3, (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.write(46);
        encodeAndWrite("JWE AAD Tag", notEmpty2, (OutputStream) byteArrayOutputStream);
        return Strings.utf8(byteArrayOutputStream.toByteArray());
    }

    public JwtBuilder content(byte[] bArr) {
        if (!Bytes.isEmpty(bArr)) {
            this.payload = new Payload(bArr, (String) null);
        }
        return this;
    }

    private void writeAndClose(String str, Payload payload2, OutputStream outputStream) {
        OutputStream compress = payload2.compress(outputStream);
        if (payload2.isClaims()) {
            writeAndClose(str, (Map<String, ?>) payload2.getRequiredClaims(), compress);
            return;
        }
        try {
            Streams.copy(payload2.toInputStream(), compress, new byte[4096], "Unable to copy payload.");
        } finally {
            Objects.nullSafeClose(compress);
        }
    }

    public <K extends Key> JwtBuilder encryptWith(K k10, final KeyAlgorithm<? super K, ?> keyAlgorithm, AeadAlgorithm aeadAlgorithm) {
        this.enc = (AeadAlgorithm) Assert.notNull(aeadAlgorithm, "Encryption algorithm cannot be null.");
        Assert.hasText(aeadAlgorithm.getId(), "Encryption algorithm id cannot be null or empty.");
        Assert.notNull(k10, "Encryption key cannot be null.");
        if (!(k10 instanceof PrivateKey)) {
            Assert.notNull(keyAlgorithm, "KeyAlgorithm cannot be null.");
            this.key = k10;
            this.keyAlg = keyAlgorithm;
            this.keyAlgFunction = Functions.wrap(new Function<KeyRequest<Key>, KeyResult>() {
                public KeyResult apply(KeyRequest<Key> keyRequest) {
                    return keyAlgorithm.getEncryptionKey(keyRequest);
                }
            }, SecurityException.class, "Unable to obtain content encryption key from key management algorithm '%s'.", (String) Assert.hasText(keyAlgorithm.getId(), "KeyAlgorithm id cannot be null or empty."));
            return this;
        }
        throw new IllegalArgumentException(PRIV_KEY_ENC_MSG);
    }

    public <K extends Key> JwtBuilder signWith(K k10, SecureDigestAlgorithm<? super K, ?> secureDigestAlgorithm) {
        Assert.notNull(k10, "Key argument cannot be null.");
        if (!(k10 instanceof PublicKey)) {
            Assert.notNull(secureDigestAlgorithm, "SignatureAlgorithm cannot be null.");
            String str = (String) Assert.hasText(secureDigestAlgorithm.getId(), "SignatureAlgorithm id cannot be null or empty.");
            if (!Jwts.SIG.NONE.getId().equalsIgnoreCase(str)) {
                this.key = k10;
                this.sigAlg = secureDigestAlgorithm;
                this.signFunction = Functions.wrap(new Function<SecureRequest<InputStream, Key>, byte[]>() {
                    public byte[] apply(SecureRequest<InputStream, Key> secureRequest) {
                        return DefaultJwtBuilder.this.sigAlg.digest(secureRequest);
                    }
                }, SignatureException.class, "Unable to compute %s signature.", str);
                return this;
            }
            throw new IllegalArgumentException("The 'none' JWS algorithm cannot be used to sign JWTs.");
        }
        throw new IllegalArgumentException(PUB_KEY_SIGN_MSG);
    }

    private void encodeAndWrite(String str, byte[] bArr, OutputStream outputStream) {
        Streams.writeAndClose(encode(outputStream, str), bArr, "Unable to write bytes");
    }

    public JwtBuilder content(InputStream inputStream) {
        if (inputStream != null) {
            this.payload = new Payload(inputStream, (String) null);
        }
        return this;
    }

    public JwtBuilder content(byte[] bArr, String str) {
        Assert.notEmpty(bArr, "content byte array cannot be null or empty.");
        Assert.hasText(str, "Content Type String cannot be null or empty.");
        this.payload = new Payload(bArr, str);
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.CONTENT_TYPE.getId())).and();
    }

    public JwtBuilder content(String str, String str2) {
        Assert.hasText(str, "Content string cannot be null or empty.");
        Assert.hasText(str2, "ContentType string cannot be null or empty.");
        this.payload = new Payload((CharSequence) str, str2);
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.CONTENT_TYPE.getId())).and();
    }

    public JwtBuilder content(InputStream inputStream, String str) {
        Assert.notNull(inputStream, "Payload InputStream cannot be null.");
        Assert.hasText(str, "ContentType string cannot be null or empty.");
        this.payload = new Payload(inputStream, str);
        return (JwtBuilder) ((JwtBuilder.BuilderHeader) header().delete(DefaultHeader.CONTENT_TYPE.getId())).and();
    }

    public JwtBuilder signWith(Key key2, SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        signatureAlgorithm.assertValidSigningKey(key2);
        return signWith(key2, Jwts.SIG.get().forKey(signatureAlgorithm.getValue()));
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notEmpty(bArr, "secret key byte array cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith((Key) new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()), signatureAlgorithm);
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str) {
        Assert.hasText(str, "base64-encoded secret key cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Base64-encoded key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(signatureAlgorithm, Decoders.BASE64.decode(str));
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key2) {
        return signWith(key2, signatureAlgorithm);
    }
}
