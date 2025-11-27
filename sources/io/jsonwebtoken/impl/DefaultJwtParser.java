package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jwe;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.io.AbstractParser;
import io.jsonwebtoken.impl.io.BytesInputStream;
import io.jsonwebtoken.impl.io.CharSequenceReader;
import io.jsonwebtoken.impl.io.JsonObjectDeserializer;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.io.UncloseableInputStream;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RedactedSupplier;
import io.jsonwebtoken.impl.security.DefaultVerifySecureDigestRequest;
import io.jsonwebtoken.impl.security.ProviderKey;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.io.InputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class DefaultJwtParser extends AbstractParser<Jwt<?, ?>> implements JwtParser {
    private static final String B64_DECOMPRESSION_MSG;
    private static final String B64_MISSING_PAYLOAD = "Unable to verify JWS signature: the parser has encountered an Unencoded Payload JWS with detached payload, but the detached payload value required for signature verification has not been provided. If you expect to receive and parse Unencoded Payload JWSs in your application, the overloaded JwtParser.parseSignedContent or JwtParser.parseSignedClaims methods that accept a byte[] or InputStream must be used for these kinds of JWSs. Header: %s";
    private static final String CRIT_MISSING_MSG;
    private static final String CRIT_UNSECURED_MSG;
    private static final String CRIT_UNSUPPORTED_MSG;
    public static final String INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was: %s.";
    private static final String JWE_NONE_MSG;
    private static final String JWS_NONE_SIG_MISMATCH_MSG;
    private static final String MISSING_ENC_MSG = "JWE header does not contain a required 'enc' (Encryption Algorithm) header parameter.  This header parameter is mandatory per the JWE Specification, Section 4.1.2. See https://www.rfc-editor.org/rfc/rfc7516.html#section-4.1.2 for more information.";
    public static final String MISSING_EXPECTED_CLAIM_VALUE_MESSAGE_TEMPLATE = "Missing expected '%s' value in '%s' claim %s.";
    public static final String MISSING_JWE_ALG_MSG = "JWE header does not contain a required 'alg' (Algorithm) header parameter.  This header parameter is mandatory per the JWE Specification, Section 4.1.1. See https://www.rfc-editor.org/rfc/rfc7516.html#section-4.1.1 for more information.";
    public static final String MISSING_JWE_DIGEST_MSG_FMT = "The JWE header references key management algorithm '%s' but the compact JWE string is missing the required AAD authentication tag.";
    public static final String MISSING_JWS_ALG_MSG = "JWS header does not contain a required 'alg' (Algorithm) header parameter.  This header parameter is mandatory per the JWS Specification, Section 4.1.1. See https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.1 for more information.";
    public static final String MISSING_JWS_DIGEST_MSG_FMT = "The JWS header references signature algorithm '%s' but the compact JWE string is missing the required signature.";
    static final String PRIV_KEY_VERIFY_MSG = "PrivateKeys may not be used to verify digital signatures. PrivateKeys are used to sign, and PublicKeys are used to verify.";
    static final String PUB_KEY_DECRYPT_MSG = "PublicKeys may not be used to decrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt.";
    static final char SEPARATOR_CHAR = '.';
    private static final String UNPROTECTED_DECOMPRESSION_MSG;
    private static final String UNSECURED_DISABLED_MSG_PREFIX;
    private static final JwtTokenizer jwtTokenizer = new JwtTokenizer();
    private final long allowedClockSkewMillis;
    private final Clock clock;
    private final Set<String> critical;
    private final Decoder<InputStream, InputStream> decoder;
    private final Deserializer<Map<String, ?>> deserializer;
    private final Function<JweHeader, AeadAlgorithm> encAlgs;
    private final ClaimsBuilder expectedClaims;
    private final Function<JweHeader, KeyAlgorithm<?, ?>> keyAlgs;
    private final Locator<? extends Key> keyLocator;
    private final Provider provider;
    private final Function<JwsHeader, SecureDigestAlgorithm<?, ?>> sigAlgs;
    private final SigningKeyResolver signingKeyResolver;
    private final boolean unsecured;
    private final boolean unsecuredDecompression;
    private final Function<Header, CompressionAlgorithm> zipAlgs;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsecured JWSs (those with an ");
        Parameter<String> parameter = DefaultHeader.ALGORITHM;
        sb.append(parameter);
        sb.append(" header value of '");
        SecureDigestAlgorithm<Key, Key> secureDigestAlgorithm = Jwts.SIG.NONE;
        sb.append(secureDigestAlgorithm.getId());
        sb.append("') are disallowed by ");
        sb.append("default as mandated by https://www.rfc-editor.org/rfc/rfc7518.html#section-3.6. If you wish to ");
        sb.append("allow them to be parsed, call the JwtParserBuilder.unsecured() method, but please read the ");
        sb.append("security considerations covered in that method's JavaDoc before doing so. Header: ");
        UNSECURED_DISABLED_MSG_PREFIX = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unsecured JWSs (those with an ");
        sb2.append(parameter);
        sb2.append(" header value of '");
        sb2.append(secureDigestAlgorithm.getId());
        sb2.append("') may not use the ");
        Parameter<Set<String>> parameter2 = DefaultProtectedHeader.CRIT;
        sb2.append(parameter2);
        sb2.append(" header parameter per https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.11 (\"the [crit] Header ");
        sb2.append("Parameter MUST be integrity protected; therefore, it MUST occur only within [a] JWS Protected Header)\".");
        sb2.append(" Header: %s");
        CRIT_UNSECURED_MSG = sb2.toString();
        CRIT_MISSING_MSG = "Protected Header " + parameter2 + " set references header name '%s', but the header does not contain an " + "associated '%s' header parameter as required by " + "https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.11. Header: %s";
        CRIT_UNSUPPORTED_MSG = "Protected Header " + parameter2 + " set references unsupported header name '%s'. Application developers expecting to support a JWT " + "extension using header '%s' in their application code must indicate it " + "is supported by using the JwtParserBuilder.critical method. Header: %s";
        JWE_NONE_MSG = "JWEs do not support key management " + parameter + " header value '" + secureDigestAlgorithm.getId() + "' per " + "https://www.rfc-editor.org/rfc/rfc7518.html#section-4.1";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("The JWS header references signature algorithm '");
        sb3.append(secureDigestAlgorithm.getId());
        sb3.append("' yet the compact JWS string contains a signature. This is not permitted ");
        sb3.append("per https://tools.ietf.org/html/rfc7518#section-3.6.");
        JWS_NONE_SIG_MISMATCH_MSG = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("The JWT header references compression algorithm '%s', but payload decompression for Unencoded JWSs (those with an ");
        Parameter<Boolean> parameter3 = DefaultJwsHeader.B64;
        sb4.append(parameter3);
        sb4.append(" header value of false) that rely on a SigningKeyResolver are disallowed ");
        sb4.append("by default to protect against [Denial of Service attacks](");
        sb4.append("https://www.usenix.org/system/files/conference/usenixsecurity15/sec15-paper-pellegrino.pdf).  If you ");
        sb4.append("wish to enable Unencoded JWS payload decompression, configure the JwtParserBuilder.");
        sb4.append("keyLocator(Locator) and do not configure a SigningKeyResolver.");
        B64_DECOMPRESSION_MSG = sb4.toString();
        UNPROTECTED_DECOMPRESSION_MSG = "The JWT header references compression algorithm '%s', but payload decompression for Unprotected JWTs (those with an " + parameter + " header value of '" + secureDigestAlgorithm.getId() + "') or Unencoded JWSs (those with a " + parameter3 + " header value of false) that also rely on a SigningKeyResolver are disallowed " + "by default to protect against [Denial of Service attacks](" + "https://www.usenix.org/system/files/conference/usenixsecurity15/sec15-paper-pellegrino.pdf).  If you " + "wish to enable Unsecure JWS or Unencoded JWS payload decompression, call the JwtParserBuilder." + "unsecuredDecompression() method, but please read the security considerations covered in that " + "method's JavaDoc before doing so.";
    }

    public DefaultJwtParser(Provider provider2, SigningKeyResolver signingKeyResolver2, boolean z10, boolean z11, Locator<? extends Key> locator, Clock clock2, Set<String> set, long j10, DefaultClaims defaultClaims, Decoder<InputStream, InputStream> decoder2, Deserializer<Map<String, ?>> deserializer2, CompressionCodecResolver compressionCodecResolver, Registry<String, CompressionAlgorithm> registry, Registry<String, SecureDigestAlgorithm<?, ?>> registry2, Registry<String, KeyAlgorithm<?, ?>> registry3, Registry<String, AeadAlgorithm> registry4) {
        CompressionCodecResolver compressionCodecResolver2 = compressionCodecResolver;
        this.provider = provider2;
        this.unsecured = z10;
        this.unsecuredDecompression = z11;
        this.signingKeyResolver = signingKeyResolver2;
        Locator<? extends Key> locator2 = locator;
        this.keyLocator = (Locator) Assert.notNull(locator, "Key Locator cannot be null.");
        Clock clock3 = clock2;
        this.clock = (Clock) Assert.notNull(clock2, "Clock cannot be null.");
        this.critical = Collections.nullSafe(set);
        this.allowedClockSkewMillis = j10;
        this.expectedClaims = (ClaimsBuilder) Jwts.claims().add(defaultClaims);
        this.decoder = (Decoder) Assert.notNull(decoder2, "base64UrlDecoder cannot be null.");
        this.deserializer = (Deserializer) Assert.notNull(deserializer2, "JSON Deserializer cannot be null.");
        Parameter<String> parameter = DefaultHeader.ALGORITHM;
        this.sigAlgs = new IdLocator(parameter, registry2, MISSING_JWS_ALG_MSG);
        this.keyAlgs = new IdLocator(parameter, registry3, MISSING_JWE_ALG_MSG);
        this.encAlgs = new IdLocator(DefaultJweHeader.ENCRYPTION_ALGORITHM, registry4, MISSING_ENC_MSG);
        this.zipAlgs = compressionCodecResolver2 != null ? new CompressionCodecLocator(compressionCodecResolver2) : new IdLocator<>(DefaultHeader.COMPRESSION_ALGORITHM, registry, (String) null);
    }

    private static boolean hasContentType(Header header) {
        if (header == null || !Strings.hasText(header.getContentType())) {
            return false;
        }
        return true;
    }

    private static Object normalize(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        return obj;
    }

    private static Payload payloadFor(InputStream inputStream) {
        if (inputStream instanceof BytesInputStream) {
            return new Payload(Streams.bytes(inputStream, "Unable to obtain payload InputStream bytes."), (String) null);
        }
        return new Payload(inputStream, (String) null);
    }

    private void validateExpectedClaims(Header header, Claims claims) {
        String str;
        Collection collection;
        Claims claims2 = (Claims) this.expectedClaims.build();
        for (String str2 : claims2.keySet()) {
            Object normalize = normalize(claims2.get(str2));
            Object normalize2 = normalize(claims.get(str2));
            if (normalize instanceof Date) {
                try {
                    normalize2 = claims.get(str2, Date.class);
                } catch (Exception unused) {
                    throw new IncorrectClaimException(header, claims, str2, normalize, "JWT Claim '" + str2 + "' was expected to be a Date, but its value " + "cannot be converted to a Date using current heuristics.  Value: " + normalize2);
                }
            }
            if (normalize2 == null) {
                String str3 = "Missing '" + str2 + "' claim. Expected value";
                if (normalize instanceof Collection) {
                    str = str3 + "s: " + normalize;
                } else {
                    str = str3 + ": " + normalize;
                }
                throw new MissingClaimException(header, claims, str2, normalize, str);
            } else if (normalize instanceof Collection) {
                Collection collection2 = (Collection) normalize;
                if (normalize2 instanceof Collection) {
                    collection = (Collection) normalize2;
                } else {
                    collection = Collections.setOf(normalize2);
                }
                for (Object next : collection2) {
                    if (!Collections.contains(collection.iterator(), next)) {
                        throw new IncorrectClaimException(header, claims, str2, normalize, String.format(MISSING_EXPECTED_CLAIM_VALUE_MESSAGE_TEMPLATE, new Object[]{next, str2, collection}));
                    }
                }
                continue;
            } else if (!normalize.equals(normalize2)) {
                throw new IncorrectClaimException(header, claims, str2, normalize, String.format("Expected %s claim to be: %s, but was: %s.", new Object[]{str2, normalize, normalize2}));
            }
        }
    }

    private byte[] verifySignature(TokenizedJwt tokenizedJwt, JwsHeader jwsHeader, String str, SigningKeyResolver signingKeyResolver2, Claims claims, Payload payload) {
        Key key;
        InputStream inputStream;
        SequenceInputStream sequenceInputStream;
        Assert.notNull(signingKeyResolver2, "SigningKeyResolver instance cannot be null.");
        try {
            SecureDigestAlgorithm apply = this.sigAlgs.apply(jwsHeader);
            Assert.stateNotNull(apply, "JWS Signature Algorithm cannot be null.");
            if (claims != null) {
                key = signingKeyResolver2.resolveSigningKey(jwsHeader, claims);
            } else {
                key = signingKeyResolver2.resolveSigningKey(jwsHeader, payload.getBytes());
            }
            if (key != null) {
                Provider provider2 = ProviderKey.getProvider(key, this.provider);
                Key key2 = ProviderKey.getKey(key);
                Assert.stateNotNull(key2, "ProviderKey cannot be null.");
                if (!(key2 instanceof PrivateKey)) {
                    byte[] decode = decode(tokenizedJwt.getDigest(), "JWS signature");
                    if (jwsHeader.isPayloadEncoded()) {
                        CharBuffer allocate = CharBuffer.allocate(tokenizedJwt.getProtected().length() + 1 + tokenizedJwt.getPayload().length());
                        allocate.put(Strings.wrap(tokenizedJwt.getProtected()));
                        allocate.put(SEPARATOR_CHAR);
                        allocate.put(Strings.wrap(tokenizedJwt.getPayload()));
                        allocate.rewind();
                        ByteBuffer encode = StandardCharsets.US_ASCII.encode(allocate);
                        encode.rewind();
                        byte[] bArr = new byte[encode.remaining()];
                        encode.get(bArr);
                        InputStream of = Streams.of(bArr);
                        inputStream = null;
                        sequenceInputStream = of;
                    } else {
                        ByteBuffer encode2 = StandardCharsets.US_ASCII.encode(Strings.wrap(tokenizedJwt.getProtected()));
                        encode2.rewind();
                        ByteBuffer allocate2 = ByteBuffer.allocate(encode2.remaining() + 1);
                        allocate2.put(encode2);
                        allocate2.put((byte) 46);
                        allocate2.rewind();
                        byte[] bArr2 = new byte[allocate2.remaining()];
                        allocate2.get(bArr2);
                        InputStream of2 = Streams.of(bArr2);
                        inputStream = payload.toInputStream();
                        sequenceInputStream = new SequenceInputStream(of2, new UncloseableInputStream(inputStream));
                    }
                    try {
                        if (apply.verify(new DefaultVerifySecureDigestRequest(sequenceInputStream, provider2, (SecureRandom) null, key2, decode))) {
                            Streams.reset(inputStream);
                            return decode;
                        }
                        throw new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                    } catch (WeakKeyException e10) {
                        throw e10;
                    } catch (InvalidKeyException | IllegalArgumentException e11) {
                        String id = apply.getId();
                        throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the '" + id + "' signature " + "algorithm, but the provided " + key2.getClass().getName() + " key may " + "not be used to verify " + id + " signatures.  Because the specified " + "key reflects a specific and expected algorithm, and the JWT does not reflect " + "this algorithm, it is likely that the JWT was not expected and therefore should not be " + "trusted.  Another possibility is that the parser was provided the incorrect " + "signature verification key, but this cannot be assumed for security reasons.", e11);
                    } catch (Throwable th) {
                        Streams.reset(inputStream);
                        throw th;
                    }
                } else {
                    throw new InvalidKeyException(PRIV_KEY_VERIFY_MSG);
                }
            } else {
                throw new UnsupportedJwtException("Cannot verify JWS signature: unable to locate signature verification key for JWS with header: " + jwsHeader);
            }
        } catch (UnsupportedJwtException e12) {
            throw new SignatureException("Unsupported signature algorithm '" + str + "'", e12);
        }
    }

    public byte[] decode(CharSequence charSequence, String str) {
        String str2;
        try {
            return Streams.bytes(this.decoder.decode(Streams.of(Strings.utf8(charSequence))), "Unable to Base64Url-decode input.");
        } catch (Throwable th) {
            if ("payload".equals(str)) {
                str2 = RedactedSupplier.REDACTED_VALUE;
            } else {
                str2 = charSequence.toString();
            }
            throw new MalformedJwtException("Invalid Base64Url " + str + ": " + str2, th);
        }
    }

    public Map<String, ?> deserialize(InputStream inputStream, String str) {
        try {
            return new JsonObjectDeserializer(this.deserializer, str).apply(Streams.reader(inputStream));
        } finally {
            Objects.nullSafeClose(inputStream);
        }
    }

    public boolean isSigned(CharSequence charSequence) {
        if (!Strings.hasText(charSequence)) {
            return false;
        }
        try {
            TokenizedJwt tokenizedJwt = jwtTokenizer.tokenize(new CharSequenceReader(charSequence));
            if ((tokenizedJwt instanceof TokenizedJwe) || !Strings.hasText(tokenizedJwt.getDigest())) {
                return false;
            }
            return true;
        } catch (MalformedJwtException unused) {
            return false;
        }
    }

    public /* bridge */ /* synthetic */ Jwt parse(CharSequence charSequence) {
        return (Jwt) super.parse(charSequence);
    }

    public Jws<Claims> parseClaimsJws(CharSequence charSequence) {
        return parseSignedClaims(charSequence);
    }

    public Jwt<Header, Claims> parseClaimsJwt(CharSequence charSequence) {
        return (Jwt) ((Jwt) parse(charSequence)).accept(Jwt.UNSECURED_CLAIMS);
    }

    public Jws<byte[]> parseContentJws(CharSequence charSequence) {
        return parseSignedContent(charSequence);
    }

    public Jwt<Header, byte[]> parseContentJwt(CharSequence charSequence) {
        return (Jwt) ((Jwt) parse(charSequence)).accept(Jwt.UNSECURED_CONTENT);
    }

    public Jwe<Claims> parseEncryptedClaims(CharSequence charSequence) {
        return (Jwe) ((Jwt) parse(charSequence)).accept(Jwe.CLAIMS);
    }

    public Jwe<byte[]> parseEncryptedContent(CharSequence charSequence) {
        return (Jwe) ((Jwt) parse(charSequence)).accept(Jwe.CONTENT);
    }

    public Jws<Claims> parseSignedClaims(CharSequence charSequence) {
        return (Jws) ((Jwt) parse(charSequence)).accept(Jws.CLAIMS);
    }

    public Jws<byte[]> parseSignedContent(CharSequence charSequence) {
        return (Jws) ((Jwt) parse(charSequence)).accept(Jws.CONTENT);
    }

    public Jwt<Header, Claims> parseUnsecuredClaims(CharSequence charSequence) {
        return (Jwt) ((Jwt) parse(charSequence)).accept(Jwt.UNSECURED_CLAIMS);
    }

    public Jwt<Header, byte[]> parseUnsecuredContent(CharSequence charSequence) {
        return (Jwt) ((Jwt) parse(charSequence)).accept(Jwt.UNSECURED_CONTENT);
    }

    private Jws<Claims> parseSignedClaims(CharSequence charSequence, Payload payload) {
        payload.setClaimsExpected(true);
        return (Jws) parse(charSequence, payload).accept(Jws.CLAIMS);
    }

    private Jws<byte[]> parseSignedContent(CharSequence charSequence, Payload payload) {
        return (Jws) parse(charSequence, payload).accept(Jws.CONTENT);
    }

    public Jwt<?, ?> parse(Reader reader) {
        Assert.notNull(reader, "Reader cannot be null.");
        return parse(reader, Payload.EMPTY);
    }

    public Jws<byte[]> parseSignedContent(CharSequence charSequence, byte[] bArr) {
        Assert.notEmpty(bArr, "unencodedPayload argument cannot be null or empty.");
        return parseSignedContent(charSequence, new Payload(bArr, (String) null));
    }

    public Jws<Claims> parseSignedClaims(CharSequence charSequence, byte[] bArr) {
        Assert.notEmpty(bArr, "unencodedPayload argument cannot be null or empty.");
        return parseSignedClaims(charSequence, new Payload(bArr, (String) null));
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [io.jsonwebtoken.Claims] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r6v4, types: [io.jsonwebtoken.Claims] */
    /* JADX WARNING: type inference failed for: r5v6, types: [io.jsonwebtoken.impl.DefaultClaims] */
    /* JADX WARNING: type inference failed for: r0v55 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x03c2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x038b A[SYNTHETIC, Splitter:B:133:0x038b] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03c9 A[SYNTHETIC, Splitter:B:163:0x03c9] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03ef A[Catch:{ all -> 0x03d1, all -> 0x03f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0433  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x046b  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.jsonwebtoken.Jwt<?, ?> parse(java.io.Reader r28, io.jsonwebtoken.impl.Payload r29) {
        /*
            r27 = this;
            r8 = r27
            r0 = r28
            java.lang.String r1 = "Compact reader cannot be null."
            io.jsonwebtoken.lang.Assert.notNull(r0, r1)
            java.lang.String r1 = "internal error: unencodedPayload is null."
            r2 = r29
            io.jsonwebtoken.lang.Assert.stateNotNull(r2, r1)
            io.jsonwebtoken.impl.JwtTokenizer r1 = jwtTokenizer
            io.jsonwebtoken.impl.TokenizedJwt r0 = r1.tokenize(r0)
            java.lang.CharSequence r1 = r0.getProtected()
            boolean r3 = io.jsonwebtoken.lang.Strings.hasText((java.lang.CharSequence) r1)
            if (r3 == 0) goto L_0x0564
            java.lang.String r3 = "protected header"
            byte[] r4 = r8.decode(r1, r3)
            java.io.InputStream r4 = io.jsonwebtoken.impl.io.Streams.of((byte[]) r4)
            java.util.Map r3 = r8.deserialize(r4, r3)
            io.jsonwebtoken.Header r9 = r0.createHeader(r3)     // Catch:{ Exception -> 0x0547 }
            java.lang.String r3 = r9.getAlgorithm()
            java.lang.String r10 = io.jsonwebtoken.lang.Strings.clean((java.lang.String) r3)
            boolean r3 = io.jsonwebtoken.lang.Strings.hasText((java.lang.String) r10)
            if (r3 != 0) goto L_0x004f
            boolean r0 = r0 instanceof io.jsonwebtoken.impl.TokenizedJwe
            if (r0 == 0) goto L_0x0047
            java.lang.String r0 = "JWE header does not contain a required 'alg' (Algorithm) header parameter.  This header parameter is mandatory per the JWE Specification, Section 4.1.1. See https://www.rfc-editor.org/rfc/rfc7516.html#section-4.1.1 for more information."
            goto L_0x0049
        L_0x0047:
            java.lang.String r0 = "JWS header does not contain a required 'alg' (Algorithm) header parameter.  This header parameter is mandatory per the JWS Specification, Section 4.1.1. See https://www.rfc-editor.org/rfc/rfc7515.html#section-4.1.1 for more information."
        L_0x0049:
            io.jsonwebtoken.MalformedJwtException r1 = new io.jsonwebtoken.MalformedJwtException
            r1.<init>(r0)
            throw r1
        L_0x004f:
            io.jsonwebtoken.security.SecureDigestAlgorithm<java.security.Key, java.security.Key> r3 = io.jsonwebtoken.Jwts.SIG.NONE
            java.lang.String r3 = r3.getId()
            boolean r3 = r3.equalsIgnoreCase(r10)
            java.lang.CharSequence r11 = r0.getDigest()
            boolean r12 = io.jsonwebtoken.lang.Strings.hasText((java.lang.CharSequence) r11)
            r13 = 0
            r14 = 1
            if (r3 == 0) goto L_0x00b3
            boolean r3 = r0 instanceof io.jsonwebtoken.impl.TokenizedJwe
            if (r3 != 0) goto L_0x00ab
            boolean r3 = r8.unsecured
            if (r3 == 0) goto L_0x0094
            if (r12 != 0) goto L_0x008c
            io.jsonwebtoken.impl.lang.Parameter<java.util.Set<java.lang.String>> r3 = io.jsonwebtoken.impl.DefaultProtectedHeader.CRIT
            java.lang.String r3 = r3.getId()
            boolean r3 = r9.containsKey(r3)
            if (r3 != 0) goto L_0x007c
            goto L_0x00cc
        L_0x007c:
            java.lang.String r0 = CRIT_UNSECURED_MSG
            java.lang.Object[] r1 = new java.lang.Object[r14]
            r1[r13] = r9
            java.lang.String r0 = java.lang.String.format(r0, r1)
            io.jsonwebtoken.MalformedJwtException r1 = new io.jsonwebtoken.MalformedJwtException
            r1.<init>(r0)
            throw r1
        L_0x008c:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = JWS_NONE_SIG_MISMATCH_MSG
            r0.<init>(r1)
            throw r0
        L_0x0094:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = UNSECURED_DISABLED_MSG_PREFIX
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            io.jsonwebtoken.UnsupportedJwtException r1 = new io.jsonwebtoken.UnsupportedJwtException
            r1.<init>(r0)
            throw r1
        L_0x00ab:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = JWE_NONE_MSG
            r0.<init>(r1)
            throw r0
        L_0x00b3:
            if (r12 != 0) goto L_0x00cc
            boolean r0 = r0 instanceof io.jsonwebtoken.impl.TokenizedJwe
            if (r0 == 0) goto L_0x00bc
            java.lang.String r0 = "The JWE header references key management algorithm '%s' but the compact JWE string is missing the required AAD authentication tag."
            goto L_0x00be
        L_0x00bc:
            java.lang.String r0 = "The JWS header references signature algorithm '%s' but the compact JWE string is missing the required signature."
        L_0x00be:
            java.lang.Object[] r1 = new java.lang.Object[r14]
            r1[r13] = r10
            java.lang.String r0 = java.lang.String.format(r0, r1)
            io.jsonwebtoken.MalformedJwtException r1 = new io.jsonwebtoken.MalformedJwtException
            r1.<init>(r0)
            throw r1
        L_0x00cc:
            boolean r3 = r9 instanceof io.jsonwebtoken.ProtectedHeader
            if (r3 == 0) goto L_0x0150
            r3 = r9
            io.jsonwebtoken.ProtectedHeader r3 = (io.jsonwebtoken.ProtectedHeader) r3
            java.util.Set r3 = r3.getCritical()
            java.util.Set r3 = io.jsonwebtoken.lang.Collections.nullSafe(r3)
            java.util.Set<java.lang.String> r4 = r8.critical
            io.jsonwebtoken.impl.lang.Parameter<java.lang.Boolean> r5 = io.jsonwebtoken.impl.DefaultJwsHeader.B64
            java.lang.String r6 = r5.getId()
            boolean r7 = r29.isEmpty()
            if (r7 != 0) goto L_0x0109
            java.util.Set<java.lang.String> r7 = r8.critical
            boolean r6 = r7.contains(r6)
            if (r6 != 0) goto L_0x0109
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            java.util.Set<java.lang.String> r6 = r8.critical
            int r6 = io.jsonwebtoken.lang.Collections.size((java.util.Collection<?>) r6)
            int r6 = r6 + r14
            r4.<init>(r6)
            java.lang.String r5 = r5.getId()
            r4.add(r5)
            java.util.Set<java.lang.String> r5 = r8.critical
            r4.addAll(r5)
        L_0x0109:
            java.util.Iterator r3 = r3.iterator()
        L_0x010d:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0150
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = r9.containsKey(r5)
            r7 = 2
            r15 = 3
            if (r6 == 0) goto L_0x013c
            boolean r6 = r4.contains(r5)
            if (r6 == 0) goto L_0x0128
            goto L_0x010d
        L_0x0128:
            java.lang.String r0 = CRIT_UNSUPPORTED_MSG
            java.lang.Object[] r1 = new java.lang.Object[r15]
            r1[r13] = r5
            r1[r14] = r5
            r1[r7] = r9
            java.lang.String r0 = java.lang.String.format(r0, r1)
            io.jsonwebtoken.UnsupportedJwtException r1 = new io.jsonwebtoken.UnsupportedJwtException
            r1.<init>(r0)
            throw r1
        L_0x013c:
            java.lang.String r0 = CRIT_MISSING_MSG
            java.lang.Object[] r1 = new java.lang.Object[r15]
            r1[r13] = r5
            r1[r14] = r5
            r1[r7] = r9
            java.lang.String r0 = java.lang.String.format(r0, r1)
            io.jsonwebtoken.MalformedJwtException r1 = new io.jsonwebtoken.MalformedJwtException
            r1.<init>(r0)
            throw r1
        L_0x0150:
            java.lang.CharSequence r3 = r0.getPayload()
            boolean r4 = r9 instanceof io.jsonwebtoken.JwsHeader
            if (r4 == 0) goto L_0x0164
            r4 = r9
            io.jsonwebtoken.JwsHeader r4 = (io.jsonwebtoken.JwsHeader) r4
            boolean r4 = r4.isPayloadEncoded()
            if (r4 == 0) goto L_0x0162
            goto L_0x0164
        L_0x0162:
            r15 = 0
            goto L_0x0165
        L_0x0164:
            r15 = 1
        L_0x0165:
            if (r15 == 0) goto L_0x017d
            java.lang.CharSequence r2 = r0.getPayload()
            java.lang.String r3 = "payload"
            byte[] r2 = r8.decode(r2, r3)
            io.jsonwebtoken.impl.Payload r3 = new io.jsonwebtoken.impl.Payload
            java.lang.String r4 = r9.getContentType()
            r3.<init>((byte[]) r2, (java.lang.String) r4)
            r16 = r3
            goto L_0x0196
        L_0x017d:
            boolean r4 = io.jsonwebtoken.lang.Strings.hasText((java.lang.CharSequence) r3)
            if (r4 == 0) goto L_0x018f
            io.jsonwebtoken.impl.Payload r2 = new io.jsonwebtoken.impl.Payload
            java.lang.String r4 = r9.getContentType()
            r2.<init>((java.lang.CharSequence) r3, (java.lang.String) r4)
        L_0x018c:
            r16 = r2
            goto L_0x0196
        L_0x018f:
            boolean r3 = r29.isEmpty()
            if (r3 != 0) goto L_0x0535
            goto L_0x018c
        L_0x0196:
            boolean r2 = r0 instanceof io.jsonwebtoken.impl.TokenizedJwe
            if (r2 == 0) goto L_0x01a9
            boolean r3 = r16.isEmpty()
            if (r3 != 0) goto L_0x01a1
            goto L_0x01a9
        L_0x01a1:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = "Compact JWE strings MUST always contain a payload (ciphertext)."
            r0.<init>(r1)
            throw r0
        L_0x01a9:
            java.lang.String r7 = "Not a JwsHeader. "
            java.lang.Class<io.jsonwebtoken.JwsHeader> r6 = io.jsonwebtoken.JwsHeader.class
            r17 = 0
            if (r2 == 0) goto L_0x0309
            r2 = r0
            io.jsonwebtoken.impl.TokenizedJwe r2 = (io.jsonwebtoken.impl.TokenizedJwe) r2
            java.lang.Class<io.jsonwebtoken.JweHeader> r3 = io.jsonwebtoken.JweHeader.class
            java.lang.String r4 = "Not a JweHeader. "
            java.lang.Object r3 = io.jsonwebtoken.lang.Assert.stateIsInstance(r3, r9, r4)
            io.jsonwebtoken.JweHeader r3 = (io.jsonwebtoken.JweHeader) r3
            byte[] r4 = io.jsonwebtoken.impl.lang.Bytes.EMPTY
            java.lang.CharSequence r5 = r2.getEncryptedKey()
            boolean r18 = io.jsonwebtoken.lang.Strings.hasText((java.lang.CharSequence) r5)
            if (r18 == 0) goto L_0x01df
            java.lang.String r4 = "JWE encrypted key"
            byte[] r4 = r8.decode(r5, r4)
            boolean r5 = io.jsonwebtoken.impl.lang.Bytes.isEmpty(r4)
            if (r5 != 0) goto L_0x01d7
            goto L_0x01df
        L_0x01d7:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = "Compact JWE string represents an encrypted key, but the key is empty."
            r0.<init>(r1)
            throw r0
        L_0x01df:
            r19 = r4
            java.lang.CharSequence r2 = r2.getIv()
            boolean r4 = io.jsonwebtoken.lang.Strings.hasText((java.lang.CharSequence) r2)
            if (r4 == 0) goto L_0x01f2
            java.lang.String r4 = "JWE Initialization Vector"
            byte[] r2 = r8.decode(r2, r4)
            goto L_0x01f4
        L_0x01f2:
            r2 = r17
        L_0x01f4:
            boolean r4 = io.jsonwebtoken.impl.lang.Bytes.isEmpty(r2)
            if (r4 != 0) goto L_0x0301
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.US_ASCII
            java.nio.CharBuffer r1 = io.jsonwebtoken.lang.Strings.wrap(r1)
            java.nio.ByteBuffer r1 = r4.encode(r1)
            int r4 = r1.remaining()
            byte[] r4 = new byte[r4]
            r1.get(r4)
            java.io.InputStream r1 = io.jsonwebtoken.impl.io.Streams.of((byte[]) r4)
            java.lang.String r4 = "JWE AAD Authentication Tag cannot be null or empty."
            io.jsonwebtoken.lang.Assert.hasText(r11, r4)
            java.lang.String r4 = "JWE AAD Authentication Tag"
            byte[] r4 = r8.decode(r11, r4)
            boolean r5 = io.jsonwebtoken.impl.lang.Bytes.isEmpty(r4)
            if (r5 != 0) goto L_0x02f9
            java.lang.String r5 = r3.getEncryptionAlgorithm()
            boolean r5 = io.jsonwebtoken.lang.Strings.hasText((java.lang.String) r5)
            if (r5 == 0) goto L_0x02f1
            io.jsonwebtoken.impl.lang.Function<io.jsonwebtoken.JweHeader, io.jsonwebtoken.security.AeadAlgorithm> r5 = r8.encAlgs
            java.lang.Object r5 = r5.apply(r3)
            io.jsonwebtoken.security.AeadAlgorithm r5 = (io.jsonwebtoken.security.AeadAlgorithm) r5
            java.lang.String r13 = "JWE Encryption Algorithm cannot be null."
            io.jsonwebtoken.lang.Assert.stateNotNull(r5, r13)
            io.jsonwebtoken.impl.lang.Function<io.jsonwebtoken.JweHeader, io.jsonwebtoken.security.KeyAlgorithm<?, ?>> r13 = r8.keyAlgs
            java.lang.Object r13 = r13.apply(r3)
            io.jsonwebtoken.security.KeyAlgorithm r13 = (io.jsonwebtoken.security.KeyAlgorithm) r13
            java.lang.String r14 = "JWE Key Algorithm cannot be null."
            io.jsonwebtoken.lang.Assert.stateNotNull(r13, r14)
            io.jsonwebtoken.Locator<? extends java.security.Key> r14 = r8.keyLocator
            java.lang.Object r14 = r14.locate(r3)
            java.security.Key r14 = (java.security.Key) r14
            if (r14 == 0) goto L_0x02da
            r26 = r11
            boolean r11 = r14 instanceof java.security.PublicKey
            if (r11 != 0) goto L_0x02d2
            java.security.Provider r11 = r8.provider
            java.security.Provider r20 = io.jsonwebtoken.impl.security.ProviderKey.getProvider(r14, r11)
            java.security.Key r24 = io.jsonwebtoken.impl.security.ProviderKey.getKey(r14)
            io.jsonwebtoken.impl.security.DefaultDecryptionKeyRequest r11 = new io.jsonwebtoken.impl.security.DefaultDecryptionKeyRequest
            r21 = 0
            r18 = r11
            r22 = r3
            r23 = r5
            r18.<init>(r19, r20, r21, r22, r23, r24)
            javax.crypto.SecretKey r22 = r13.getDecryptionKey(r11)
            if (r22 == 0) goto L_0x02a1
            java.io.InputStream r21 = r16.toInputStream()
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r11 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r11)
            io.jsonwebtoken.impl.security.DefaultDecryptAeadRequest r11 = new io.jsonwebtoken.impl.security.DefaultDecryptAeadRequest
            r20 = r11
            r23 = r1
            r24 = r2
            r25 = r4
            r20.<init>(r21, r22, r23, r24, r25)
            r5.decrypt(r11, r3)
            io.jsonwebtoken.impl.Payload r1 = new io.jsonwebtoken.impl.Payload
            byte[] r3 = r3.toByteArray()
            java.lang.String r5 = r9.getContentType()
            r1.<init>((byte[]) r3, (java.lang.String) r5)
            r14 = r2
            r13 = r6
            r11 = r7
            r2 = r1
            goto L_0x0331
        L_0x02a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The '"
            r0.append(r1)
            java.lang.String r1 = r13.getId()
            r0.append(r1)
            java.lang.String r1 = "' JWE key algorithm did not return a decryption key. "
            r0.append(r1)
            java.lang.String r1 = "Unable to perform '"
            r0.append(r1)
            java.lang.String r1 = r5.getId()
            r0.append(r1)
            java.lang.String r1 = "' decryption."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x02d2:
            io.jsonwebtoken.security.InvalidKeyException r0 = new io.jsonwebtoken.security.InvalidKeyException
            java.lang.String r1 = "PublicKeys may not be used to decrypt data. PublicKeys are used to encrypt, and PrivateKeys are used to decrypt."
            r0.<init>(r1)
            throw r0
        L_0x02da:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot decrypt JWE payload: unable to locate key for JWE with header: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            io.jsonwebtoken.UnsupportedJwtException r1 = new io.jsonwebtoken.UnsupportedJwtException
            r1.<init>(r0)
            throw r1
        L_0x02f1:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = "JWE header does not contain a required 'enc' (Encryption Algorithm) header parameter.  This header parameter is mandatory per the JWE Specification, Section 4.1.2. See https://www.rfc-editor.org/rfc/rfc7516.html#section-4.1.2 for more information."
            r0.<init>(r1)
            throw r0
        L_0x02f9:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = "Compact JWE strings must always contain an AAD Authentication Tag."
            r0.<init>(r1)
            throw r0
        L_0x0301:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = "Compact JWE strings must always contain an Initialization Vector."
            r0.<init>(r1)
            throw r0
        L_0x0309:
            r26 = r11
            if (r12 == 0) goto L_0x0333
            io.jsonwebtoken.SigningKeyResolver r1 = r8.signingKeyResolver
            if (r1 != 0) goto L_0x0333
            java.lang.Object r1 = io.jsonwebtoken.lang.Assert.stateIsInstance(r6, r9, r7)
            r3 = r1
            io.jsonwebtoken.JwsHeader r3 = (io.jsonwebtoken.JwsHeader) r3
            io.jsonwebtoken.impl.security.LocatingKeyResolver r5 = new io.jsonwebtoken.impl.security.LocatingKeyResolver
            io.jsonwebtoken.Locator<? extends java.security.Key> r1 = r8.keyLocator
            r5.<init>(r1)
            r11 = 0
            r1 = r27
            r2 = r0
            r4 = r10
            r13 = r6
            r6 = r11
            r11 = r7
            r7 = r16
            byte[] r4 = r1.verifySignature(r2, r3, r4, r5, r6, r7)
            r2 = r16
            r14 = r17
        L_0x0331:
            r1 = 1
            goto L_0x033b
        L_0x0333:
            r13 = r6
            r11 = r7
            r2 = r16
            r4 = r17
            r14 = r4
            r1 = 0
        L_0x033b:
            io.jsonwebtoken.impl.lang.Function<io.jsonwebtoken.Header, io.jsonwebtoken.io.CompressionAlgorithm> r3 = r8.zipAlgs
            java.lang.Object r3 = r3.apply(r9)
            io.jsonwebtoken.io.CompressionAlgorithm r3 = (io.jsonwebtoken.io.CompressionAlgorithm) r3
            if (r3 == 0) goto L_0x0380
            if (r1 != 0) goto L_0x037a
            if (r15 == 0) goto L_0x0364
            boolean r1 = r8.unsecuredDecompression
            if (r1 == 0) goto L_0x034e
            goto L_0x037a
        L_0x034e:
            java.lang.String r0 = UNPROTECTED_DECOMPRESSION_MSG
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r3.getId()
            r4 = 0
            r1[r4] = r2
            java.lang.String r0 = java.lang.String.format(r0, r1)
            io.jsonwebtoken.UnsupportedJwtException r1 = new io.jsonwebtoken.UnsupportedJwtException
            r1.<init>(r0)
            throw r1
        L_0x0364:
            r1 = 1
            r4 = 0
            java.lang.String r0 = B64_DECOMPRESSION_MSG
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r3.getId()
            r1[r4] = r2
            java.lang.String r0 = java.lang.String.format(r0, r1)
            io.jsonwebtoken.UnsupportedJwtException r1 = new io.jsonwebtoken.UnsupportedJwtException
            r1.<init>(r0)
            throw r1
        L_0x037a:
            io.jsonwebtoken.impl.Payload r1 = r2.decompress(r3)
            r7 = r1
            goto L_0x0381
        L_0x0380:
            r7 = r2
        L_0x0381:
            byte[] r1 = r7.getBytes()
            boolean r2 = r7.isConsumable()
            if (r2 == 0) goto L_0x0415
            java.io.InputStream r2 = r7.toInputStream()     // Catch:{ all -> 0x040a }
            boolean r3 = hasContentType(r9)     // Catch:{ all -> 0x0404 }
            if (r3 != 0) goto L_0x03ed
            boolean r3 = r2.markSupported()     // Catch:{ MalformedJwtException | DeserializationException -> 0x03c2, all -> 0x03bb }
            if (r3 != 0) goto L_0x03ac
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ MalformedJwtException | DeserializationException -> 0x03c2, all -> 0x03bb }
            r3.<init>(r2)     // Catch:{ MalformedJwtException | DeserializationException -> 0x03c2, all -> 0x03bb }
            r2 = 0
            r3.mark(r2)     // Catch:{ MalformedJwtException | DeserializationException -> 0x03aa, all -> 0x03a6 }
            r2 = r3
            goto L_0x03ac
        L_0x03a6:
            r0 = move-exception
            r17 = r3
            goto L_0x03be
        L_0x03aa:
            r2 = r3
            goto L_0x03c2
        L_0x03ac:
            io.jsonwebtoken.impl.io.UncloseableInputStream r3 = new io.jsonwebtoken.impl.io.UncloseableInputStream     // Catch:{ MalformedJwtException | DeserializationException -> 0x03c2, all -> 0x03bb }
            r3.<init>(r2)     // Catch:{ MalformedJwtException | DeserializationException -> 0x03c2, all -> 0x03bb }
            java.lang.String r5 = "claims"
            java.util.Map r3 = r8.deserialize(r3, r5)     // Catch:{ MalformedJwtException | DeserializationException -> 0x03c2, all -> 0x03bb }
            io.jsonwebtoken.impl.io.Streams.reset(r2)     // Catch:{ all -> 0x03f6 }
            goto L_0x03c7
        L_0x03bb:
            r0 = move-exception
            r17 = r2
        L_0x03be:
            io.jsonwebtoken.impl.io.Streams.reset(r17)     // Catch:{ all -> 0x040a }
            throw r0     // Catch:{ all -> 0x040a }
        L_0x03c2:
            io.jsonwebtoken.impl.io.Streams.reset(r2)     // Catch:{ all -> 0x03f6 }
            r3 = r17
        L_0x03c7:
            if (r3 == 0) goto L_0x03ed
            io.jsonwebtoken.impl.DefaultClaims r5 = new io.jsonwebtoken.impl.DefaultClaims     // Catch:{ all -> 0x03d1 }
            r5.<init>((java.util.Map<java.lang.String, ?>) r3)     // Catch:{ all -> 0x03d1 }
            r17 = r5
            goto L_0x03ed
        L_0x03d1:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x03f6 }
            r1.<init>()     // Catch:{ all -> 0x03f6 }
            java.lang.String r3 = "Invalid claims: "
            r1.append(r3)     // Catch:{ all -> 0x03f6 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x03f6 }
            r1.append(r0)     // Catch:{ all -> 0x03f6 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x03f6 }
            io.jsonwebtoken.MalformedJwtException r1 = new io.jsonwebtoken.MalformedJwtException     // Catch:{ all -> 0x03f6 }
            r1.<init>(r0)     // Catch:{ all -> 0x03f6 }
            throw r1     // Catch:{ all -> 0x03f6 }
        L_0x03ed:
            if (r17 != 0) goto L_0x03fa
            java.lang.String r1 = "Unable to convert payload to byte array."
            byte[] r1 = io.jsonwebtoken.impl.io.Streams.bytes(r2, r1)     // Catch:{ all -> 0x03f6 }
            goto L_0x03fa
        L_0x03f6:
            r0 = move-exception
            r17 = r2
            goto L_0x040b
        L_0x03fa:
            r3 = 1
            java.io.Closeable[] r5 = new java.io.Closeable[r3]
            r6 = 0
            r5[r6] = r2
            io.jsonwebtoken.lang.Objects.nullSafeClose(r5)
            goto L_0x0415
        L_0x0404:
            r0 = move-exception
            r3 = 1
            r6 = 0
            r17 = r2
            goto L_0x040d
        L_0x040a:
            r0 = move-exception
        L_0x040b:
            r3 = 1
            r6 = 0
        L_0x040d:
            java.io.Closeable[] r1 = new java.io.Closeable[r3]
            r1[r6] = r17
            io.jsonwebtoken.lang.Objects.nullSafeClose(r1)
            throw r0
        L_0x0415:
            r15 = r1
            r5 = r17
            if (r12 == 0) goto L_0x0433
            io.jsonwebtoken.SigningKeyResolver r1 = r8.signingKeyResolver
            if (r1 == 0) goto L_0x0433
            java.lang.Object r1 = io.jsonwebtoken.lang.Assert.stateIsInstance(r13, r9, r11)
            r3 = r1
            io.jsonwebtoken.JwsHeader r3 = (io.jsonwebtoken.JwsHeader) r3
            io.jsonwebtoken.SigningKeyResolver r6 = r8.signingKeyResolver
            r1 = r27
            r2 = r0
            r4 = r10
            r0 = r5
            r5 = r6
            r6 = r0
            byte[] r4 = r1.verifySignature(r2, r3, r4, r5, r6, r7)
            goto L_0x0434
        L_0x0433:
            r0 = r5
        L_0x0434:
            if (r0 == 0) goto L_0x0437
            r15 = r0
        L_0x0437:
            boolean r1 = r9 instanceof io.jsonwebtoken.JweHeader
            if (r1 == 0) goto L_0x0444
            io.jsonwebtoken.impl.DefaultJwe r1 = new io.jsonwebtoken.impl.DefaultJwe
            r2 = r9
            io.jsonwebtoken.JweHeader r2 = (io.jsonwebtoken.JweHeader) r2
            r1.<init>(r2, r15, r14, r4)
            goto L_0x045e
        L_0x0444:
            if (r12 == 0) goto L_0x0459
            java.lang.String r1 = "JwsHeader required."
            java.lang.Object r1 = io.jsonwebtoken.lang.Assert.isInstanceOf(r13, r9, r1)
            io.jsonwebtoken.JwsHeader r1 = (io.jsonwebtoken.JwsHeader) r1
            io.jsonwebtoken.impl.DefaultJws r2 = new io.jsonwebtoken.impl.DefaultJws
            java.lang.String r3 = r26.toString()
            r2.<init>(r1, r15, r4, r3)
            r1 = r2
            goto L_0x045e
        L_0x0459:
            io.jsonwebtoken.impl.DefaultJwt r1 = new io.jsonwebtoken.impl.DefaultJwt
            r1.<init>(r9, r15)
        L_0x045e:
            long r2 = r8.allowedClockSkewMillis
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0468
            r13 = 1
            goto L_0x0469
        L_0x0468:
            r13 = 0
        L_0x0469:
            if (r0 == 0) goto L_0x0534
            io.jsonwebtoken.Clock r2 = r8.clock
            java.util.Date r2 = r2.now()
            long r3 = r2.getTime()
            java.util.Date r5 = r0.getExpiration()
            java.lang.String r6 = " milliseconds."
            java.lang.String r7 = ". Allowed clock skew: "
            if (r5 == 0) goto L_0x04d8
            long r10 = r8.allowedClockSkewMillis
            long r10 = r3 - r10
            if (r13 == 0) goto L_0x048b
            java.util.Date r12 = new java.util.Date
            r12.<init>(r10)
            goto L_0x048c
        L_0x048b:
            r12 = r2
        L_0x048c:
            boolean r10 = r12.after(r5)
            if (r10 != 0) goto L_0x0493
            goto L_0x04d8
        L_0x0493:
            r10 = 1
            java.lang.String r1 = io.jsonwebtoken.lang.DateFormats.formatIso8601(r5, r10)
            java.lang.String r2 = io.jsonwebtoken.lang.DateFormats.formatIso8601(r2, r10)
            long r10 = r5.getTime()
            long r3 = r3 - r10
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = "JWT expired "
            r5.append(r10)
            r5.append(r3)
            java.lang.String r3 = " milliseconds ago at "
            r5.append(r3)
            r5.append(r1)
            java.lang.String r1 = ". "
            r5.append(r1)
            java.lang.String r1 = "Current time: "
            r5.append(r1)
            r5.append(r2)
            r5.append(r7)
            long r1 = r8.allowedClockSkewMillis
            r5.append(r1)
            r5.append(r6)
            java.lang.String r1 = r5.toString()
            io.jsonwebtoken.ExpiredJwtException r2 = new io.jsonwebtoken.ExpiredJwtException
            r2.<init>(r9, r0, r1)
            throw r2
        L_0x04d8:
            java.util.Date r5 = r0.getNotBefore()
            if (r5 == 0) goto L_0x0531
            long r10 = r8.allowedClockSkewMillis
            long r10 = r10 + r3
            if (r13 == 0) goto L_0x04e9
            java.util.Date r12 = new java.util.Date
            r12.<init>(r10)
            goto L_0x04ea
        L_0x04e9:
            r12 = r2
        L_0x04ea:
            boolean r10 = r12.before(r5)
            if (r10 != 0) goto L_0x04f1
            goto L_0x0531
        L_0x04f1:
            r10 = 1
            java.lang.String r1 = io.jsonwebtoken.lang.DateFormats.formatIso8601(r5, r10)
            java.lang.String r2 = io.jsonwebtoken.lang.DateFormats.formatIso8601(r2, r10)
            long r10 = r5.getTime()
            long r10 = r10 - r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "JWT early by "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r4 = " milliseconds before "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ". Current time: "
            r3.append(r1)
            r3.append(r2)
            r3.append(r7)
            long r1 = r8.allowedClockSkewMillis
            r3.append(r1)
            r3.append(r6)
            java.lang.String r1 = r3.toString()
            io.jsonwebtoken.PrematureJwtException r2 = new io.jsonwebtoken.PrematureJwtException
            r2.<init>(r9, r0, r1)
            throw r2
        L_0x0531:
            r8.validateExpectedClaims(r9, r0)
        L_0x0534:
            return r1
        L_0x0535:
            r1 = 1
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r1 = 0
            r0[r1] = r9
            java.lang.String r1 = "Unable to verify JWS signature: the parser has encountered an Unencoded Payload JWS with detached payload, but the detached payload value required for signature verification has not been provided. If you expect to receive and parse Unencoded Payload JWSs in your application, the overloaded JwtParser.parseSignedContent or JwtParser.parseSignedClaims methods that accept a byte[] or InputStream must be used for these kinds of JWSs. Header: %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            io.jsonwebtoken.security.SignatureException r1 = new io.jsonwebtoken.security.SignatureException
            r1.<init>(r0)
            throw r1
        L_0x0547:
            r0 = move-exception
            r1 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Invalid protected header: "
            r0.append(r2)
            java.lang.String r2 = r1.getMessage()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            io.jsonwebtoken.MalformedJwtException r2 = new io.jsonwebtoken.MalformedJwtException
            r2.<init>(r0, r1)
            throw r2
        L_0x0564:
            io.jsonwebtoken.MalformedJwtException r0 = new io.jsonwebtoken.MalformedJwtException
            java.lang.String r1 = "Compact JWT strings MUST always have a Base64Url protected header per https://tools.ietf.org/html/rfc7519#section-7.2 (steps 2-4)."
            r0.<init>(r1)
            goto L_0x056d
        L_0x056c:
            throw r0
        L_0x056d:
            goto L_0x056c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.DefaultJwtParser.parse(java.io.Reader, io.jsonwebtoken.impl.Payload):io.jsonwebtoken.Jwt");
    }

    public Jws<byte[]> parseSignedContent(CharSequence charSequence, InputStream inputStream) {
        Assert.notNull(inputStream, "unencodedPayload InputStream cannot be null.");
        return parseSignedContent(charSequence, payloadFor(inputStream));
    }

    public Jws<Claims> parseSignedClaims(CharSequence charSequence, InputStream inputStream) {
        Assert.notNull(inputStream, "unencodedPayload InputStream cannot be null.");
        return parseSignedClaims(charSequence, new Payload(Streams.bytes(inputStream, "Unable to obtain Claims bytes from unencodedPayload InputStream"), (String) null));
    }

    public <T> T parse(CharSequence charSequence, JwtHandler<T> jwtHandler) {
        return parse(charSequence, Payload.EMPTY).accept(jwtHandler);
    }

    private Jwt<?, ?> parse(CharSequence charSequence, Payload payload) {
        Assert.hasText(charSequence, "JWT String argument cannot be null or empty.");
        return parse((Reader) new CharSequenceReader(charSequence), payload);
    }
}
