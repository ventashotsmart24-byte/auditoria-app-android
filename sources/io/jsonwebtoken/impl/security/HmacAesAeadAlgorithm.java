package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.io.TeeOutputStream;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.DecryptAeadRequest;
import io.jsonwebtoken.security.SecretKeyBuilder;
import io.jsonwebtoken.security.SecureRequest;
import io.jsonwebtoken.security.SignatureException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacAesAeadAlgorithm extends AesAlgorithm implements AeadAlgorithm {
    private static final String TRANSFORMATION_STRING = "AES/CBC/PKCS5Padding";
    private final DefaultMacAlgorithm SIGALG;

    public HmacAesAeadAlgorithm(String str, DefaultMacAlgorithm defaultMacAlgorithm) {
        super(str, TRANSFORMATION_STRING, defaultMacAlgorithm.getKeyBitLength());
        this.SIGALG = defaultMacAlgorithm;
    }

    private static int digestLength(int i10) {
        return i10 * 2;
    }

    private static String id(int i10) {
        return "A" + i10 + "CBC-HS" + digestLength(i10);
    }

    private byte[] sign(byte[] bArr, byte[] bArr2, InputStream inputStream, byte[] bArr3) {
        byte[] bytes = Bytes.toBytes((((long) Arrays.length(bArr)) * 8) & 4294967295L);
        ArrayList arrayList = new ArrayList(4);
        if (!Bytes.isEmpty(bArr)) {
            arrayList.add(Streams.of(bArr));
        }
        arrayList.add(Streams.of(bArr2));
        arrayList.add(inputStream);
        arrayList.add(Streams.of(bytes));
        return assertTag(java.util.Arrays.copyOfRange(this.SIGALG.digest(new DefaultSecureRequest(new SequenceInputStream(Collections.enumeration(arrayList)), (Provider) null, (SecureRandom) null, new SecretKeySpec(bArr3, this.SIGALG.getJcaName()))), 0, bArr3.length));
    }

    public byte[] assertKeyBytes(SecureRequest<?, SecretKey> secureRequest) {
        return validateLength((SecretKey) Assert.notNull(secureRequest.getKey(), "Request key cannot be null."), this.keyBitLength * 2, true);
    }

    /* JADX INFO: finally extract failed */
    public void decrypt(DecryptAeadRequest decryptAeadRequest, OutputStream outputStream) {
        byte[] bArr;
        Assert.notNull(decryptAeadRequest, "Request cannot be null.");
        Assert.notNull(outputStream, "Plaintext OutputStream cannot be null.");
        byte[] assertKeyBytes = assertKeyBytes(decryptAeadRequest);
        int length = assertKeyBytes.length / 2;
        byte[] copyOfRange = java.util.Arrays.copyOfRange(assertKeyBytes, 0, length);
        byte[] copyOfRange2 = java.util.Arrays.copyOfRange(assertKeyBytes, length, assertKeyBytes.length);
        try {
            final SecretKeySpec secretKeySpec = new SecretKeySpec(copyOfRange2, "AES");
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            final InputStream inputStream = (InputStream) Assert.notNull(decryptAeadRequest.getPayload(), "Decryption request content (ciphertext) InputStream cannot be null.");
            InputStream associatedData = decryptAeadRequest.getAssociatedData();
            byte[] assertTag = assertTag(decryptAeadRequest.getDigest());
            byte[] assertDecryptionIv = assertDecryptionIv(decryptAeadRequest);
            final AlgorithmParameterSpec ivSpec = getIvSpec(assertDecryptionIv);
            if (associatedData == null) {
                bArr = Bytes.EMPTY;
            } else {
                bArr = Streams.bytes(associatedData, "Unable to read AAD bytes.");
            }
            try {
                byte[] sign = sign(bArr, assertDecryptionIv, inputStream, copyOfRange);
                Bytes.clear(copyOfRange);
                if (MessageDigest.isEqual(sign, assertTag)) {
                    Streams.reset(inputStream);
                    final OutputStream outputStream2 = outputStream;
                    jca(decryptAeadRequest).withCipher(new CheckedFunction<Cipher, byte[]>() {
                        public byte[] apply(Cipher cipher) {
                            cipher.init(2, secretKeySpec, ivSpec);
                            HmacAesAeadAlgorithm.this.withCipher(cipher, inputStream, outputStream2);
                            return Bytes.EMPTY;
                        }
                    });
                    return;
                }
                throw new SignatureException("Ciphertext decryption failed: Authentication tag verification failed.");
            } catch (Throwable th) {
                Bytes.clear(copyOfRange);
                throw th;
            }
        } catch (Throwable th2) {
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void encrypt(AeadRequest aeadRequest, AeadResult aeadResult) {
        byte[] bArr;
        Assert.notNull(aeadRequest, "Request cannot be null.");
        Assert.notNull(aeadResult, "Result cannot be null.");
        byte[] assertKeyBytes = assertKeyBytes(aeadRequest);
        int length = assertKeyBytes.length / 2;
        byte[] copyOfRange = java.util.Arrays.copyOfRange(assertKeyBytes, 0, length);
        byte[] copyOfRange2 = java.util.Arrays.copyOfRange(assertKeyBytes, length, assertKeyBytes.length);
        try {
            final SecretKeySpec secretKeySpec = new SecretKeySpec(copyOfRange2, "AES");
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            final InputStream inputStream = (InputStream) Assert.notNull(aeadRequest.getPayload(), "Request content (plaintext) InputStream cannot be null.");
            InputStream associatedData = aeadRequest.getAssociatedData();
            byte[] ensureInitializationVector = ensureInitializationVector(aeadRequest);
            final AlgorithmParameterSpec ivSpec = getIvSpec(ensureInitializationVector);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            final TeeOutputStream teeOutputStream = new TeeOutputStream((OutputStream) Assert.notNull(aeadResult.getOutputStream(), "Result ciphertext OutputStream cannot be null."), byteArrayOutputStream);
            jca(aeadRequest).withCipher(new CheckedFunction<Cipher, Object>() {
                public Object apply(Cipher cipher) {
                    cipher.init(1, secretKeySpec, ivSpec);
                    HmacAesAeadAlgorithm.this.withCipher(cipher, inputStream, teeOutputStream);
                    return null;
                }
            });
            if (associatedData == null) {
                bArr = Bytes.EMPTY;
            } else {
                bArr = Streams.bytes(associatedData, "Unable to read AAD bytes.");
            }
            try {
                aeadResult.setTag(sign(bArr, ensureInitializationVector, Streams.of(byteArrayOutputStream.toByteArray()), copyOfRange)).setIv(ensureInitializationVector);
            } finally {
                Bytes.clear(copyOfRange);
            }
        } catch (Throwable th) {
            Bytes.clear(copyOfRange2);
            Bytes.clear(assertKeyBytes);
            throw th;
        }
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public int getKeyBitLength() {
        return super.getKeyBitLength() * 2;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SecretKeyBuilder key() {
        return new RandomSecretKeyBuilder("AES", getKeyBitLength());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HmacAesAeadAlgorithm(int r6) {
        /*
            r5 = this;
            java.lang.String r0 = id(r6)
            io.jsonwebtoken.impl.security.DefaultMacAlgorithm r1 = new io.jsonwebtoken.impl.security.DefaultMacAlgorithm
            java.lang.String r2 = id(r6)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "HmacSHA"
            r3.append(r4)
            int r4 = digestLength(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3, r6)
            r5.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.HmacAesAeadAlgorithm.<init>(int):void");
    }
}
