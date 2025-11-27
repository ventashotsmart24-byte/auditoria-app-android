package io.jsonwebtoken.impl.security;

import com.raizlabs.android.dbflow.sql.language.Operator;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.DefaultJweHeader;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import io.jsonwebtoken.security.Password;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Pbes2HsAkwAlgorithm extends CryptoAlgorithm implements KeyAlgorithm<Password, Password> {
    private static final int DEFAULT_SHA256_ITERATIONS = 310000;
    private static final int DEFAULT_SHA384_ITERATIONS = 210000;
    private static final int DEFAULT_SHA512_ITERATIONS = 120000;
    private static final double MAX_ITERATIONS_FACTOR = 2.5d;
    private static final String MIN_ITERATIONS_MSG_PREFIX = "[JWA RFC 7518, Section 4.8.1.2](https://www.rfc-editor.org/rfc/rfc7518.html#section-4.8.1.2) recommends password-based-encryption iterations be greater than or equal to 1000. Provided: ";
    private static final int MIN_RECOMMENDED_ITERATIONS = 1000;
    private final int DEFAULT_ITERATIONS;
    private final int DERIVED_KEY_BIT_LENGTH;
    private final int HASH_BYTE_LENGTH;
    private final int MAX_ITERATIONS;
    private final byte[] SALT_PREFIX;
    private final KeyAlgorithm<SecretKey, SecretKey> wrapAlg;

    public Pbes2HsAkwAlgorithm(int i10) {
        this(hashBitLength(i10), new AesWrapKeyAlgorithm(i10));
    }

    public static int assertIterations(int i10) {
        if (i10 >= 1000) {
            return i10;
        }
        throw new IllegalArgumentException(MIN_ITERATIONS_MSG_PREFIX + i10);
    }

    private static int hashBitLength(int i10) {
        return i10 * 2;
    }

    private static String idFor(int i10, KeyAlgorithm<SecretKey, SecretKey> keyAlgorithm) {
        Assert.notNull(keyAlgorithm, "wrapAlg argument cannot be null.");
        return "PBES2-HS" + i10 + Operator.Operation.PLUS + keyAlgorithm.getId();
    }

    private static byte[] toRfcSaltPrefix(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public SecretKey deriveKey(SecretKeyFactory secretKeyFactory, char[] cArr, byte[] bArr, int i10) {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i10, this.DERIVED_KEY_BIT_LENGTH);
        try {
            return new SecretKeySpec(secretKeyFactory.generateSecret(pBEKeySpec).getEncoded(), "AES");
        } finally {
            pBEKeySpec.clearPassword();
        }
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public byte[] generateInputSalt(KeyRequest<?> keyRequest) {
        byte[] bArr = new byte[this.HASH_BYTE_LENGTH];
        CryptoAlgorithm.ensureSecureRandom(keyRequest).nextBytes(bArr);
        return bArr;
    }

    public SecretKey getDecryptionKey(DecryptionKeyRequest<Password> decryptionKeyRequest) {
        JweHeader jweHeader = (JweHeader) Assert.notNull(decryptionKeyRequest.getHeader(), "Request JweHeader cannot be null.");
        Password password = (Password) Assert.notNull(decryptionKeyRequest.getKey(), "Decryption Password cannot be null.");
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader((Header) jweHeader);
        byte[] bArr = (byte[]) requiredParameterReader.get(DefaultJweHeader.P2S);
        Parameter parameter = DefaultJweHeader.P2C;
        int intValue = ((Integer) requiredParameterReader.get(parameter)).intValue();
        if (intValue <= this.MAX_ITERATIONS) {
            return this.wrapAlg.getDecryptionKey(new DefaultDecryptionKeyRequest((byte[]) decryptionKeyRequest.getPayload(), decryptionKeyRequest.getProvider(), decryptionKeyRequest.getSecureRandom(), jweHeader, decryptionKeyRequest.getEncryptionAlgorithm(), deriveKey((KeyRequest<?>) decryptionKeyRequest, password.toCharArray(), Bytes.concat(this.SALT_PREFIX, bArr), intValue)));
        }
        throw new UnsupportedJwtException("JWE Header " + parameter + " value " + intValue + " exceeds " + getId() + " maximum " + "allowed value " + this.MAX_ITERATIONS + ". The larger value is rejected to help mitigate " + "potential Denial of Service attacks.");
    }

    public KeyResult getEncryptionKey(KeyRequest<Password> keyRequest) {
        Assert.notNull(keyRequest, "request cannot be null.");
        Password password = (Password) Assert.notNull(keyRequest.getPayload(), "Encryption Password cannot be null.");
        JweHeader jweHeader = (JweHeader) Assert.notNull(keyRequest.getHeader(), "JweHeader cannot be null.");
        Integer pbes2Count = jweHeader.getPbes2Count();
        if (pbes2Count == null) {
            pbes2Count = Integer.valueOf(this.DEFAULT_ITERATIONS);
            jweHeader.put(DefaultJweHeader.P2C.getId(), pbes2Count);
        }
        int assertIterations = assertIterations(pbes2Count.intValue());
        byte[] generateInputSalt = generateInputSalt(keyRequest);
        KeyResult encryptionKey = this.wrapAlg.getEncryptionKey(new DefaultKeyRequest(deriveKey((KeyRequest<?>) keyRequest, password.toCharArray(), toRfcSalt(generateInputSalt), assertIterations), keyRequest.getProvider(), keyRequest.getSecureRandom(), keyRequest.getHeader(), keyRequest.getEncryptionAlgorithm()));
        keyRequest.getHeader().put(DefaultJweHeader.P2S.getId(), generateInputSalt);
        return encryptionKey;
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public byte[] toRfcSalt(byte[] bArr) {
        return Bytes.concat(this.SALT_PREFIX, bArr);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Pbes2HsAkwAlgorithm(int r5, io.jsonwebtoken.security.KeyAlgorithm<javax.crypto.SecretKey, javax.crypto.SecretKey> r6) {
        /*
            r4 = this;
            java.lang.String r0 = idFor(r5, r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "PBKDF2WithHmacSHA"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r4.<init>(r0, r1)
            r4.wrapAlg = r6
            int r6 = r5 / 8
            r4.HASH_BYTE_LENGTH = r6
            r6 = 512(0x200, float:7.175E-43)
            if (r5 < r6) goto L_0x0028
            r6 = 120000(0x1d4c0, float:1.68156E-40)
            r4.DEFAULT_ITERATIONS = r6
            goto L_0x0037
        L_0x0028:
            r6 = 384(0x180, float:5.38E-43)
            if (r5 < r6) goto L_0x0032
            r6 = 210000(0x33450, float:2.94273E-40)
            r4.DEFAULT_ITERATIONS = r6
            goto L_0x0037
        L_0x0032:
            r6 = 310000(0x4baf0, float:4.34403E-40)
            r4.DEFAULT_ITERATIONS = r6
        L_0x0037:
            int r6 = r4.DEFAULT_ITERATIONS
            double r0 = (double) r6
            r2 = 4612811918334230528(0x4004000000000000, double:2.5)
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            int r6 = (int) r0
            r4.MAX_ITERATIONS = r6
            int r5 = r5 / 2
            r4.DERIVED_KEY_BIT_LENGTH = r5
            java.lang.String r5 = r4.getId()
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r5 = r5.getBytes(r6)
            byte[] r5 = toRfcSaltPrefix(r5)
            r4.SALT_PREFIX = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.Pbes2HsAkwAlgorithm.<init>(int, io.jsonwebtoken.security.KeyAlgorithm):void");
    }

    private SecretKey deriveKey(KeyRequest<?> keyRequest, final char[] cArr, final byte[] bArr, final int i10) {
        try {
            Assert.notEmpty(cArr, "Key password character array cannot be null or empty.");
            return (SecretKey) jca(keyRequest).withSecretKeyFactory(new CheckedFunction<SecretKeyFactory, SecretKey>() {
                public SecretKey apply(SecretKeyFactory secretKeyFactory) {
                    return Pbes2HsAkwAlgorithm.this.deriveKey(secretKeyFactory, cArr, bArr, i10);
                }
            });
        } finally {
            Arrays.fill(cArr, 0);
        }
    }
}
