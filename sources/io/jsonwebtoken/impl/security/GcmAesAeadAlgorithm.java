package io.jsonwebtoken.impl.security;

import com.google.android.gms.stats.CodePackage;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.DecryptAeadRequest;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class GcmAesAeadAlgorithm extends AesAlgorithm implements AeadAlgorithm {
    private static final String TRANSFORMATION_STRING = "AES/GCM/NoPadding";

    public GcmAesAeadAlgorithm(int i10) {
        super("A" + i10 + CodePackage.GCM, "AES/GCM/NoPadding", i10);
    }

    public void decrypt(DecryptAeadRequest decryptAeadRequest, OutputStream outputStream) {
        Assert.notNull(decryptAeadRequest, "Request cannot be null.");
        Assert.notNull(outputStream, "Plaintext OutputStream cannot be null.");
        final SecretKey assertKey = assertKey((SecretKey) decryptAeadRequest.getKey());
        final InputStream associatedData = decryptAeadRequest.getAssociatedData();
        byte[] notEmpty = Assert.notEmpty(decryptAeadRequest.getDigest(), "Decryption request authentication tag cannot be null or empty.");
        final AlgorithmParameterSpec ivSpec = getIvSpec(assertDecryptionIv(decryptAeadRequest));
        final SequenceInputStream sequenceInputStream = new SequenceInputStream((InputStream) Assert.notNull(decryptAeadRequest.getPayload(), "Decryption request content (ciphertext) InputStream cannot be null."), Streams.of(notEmpty));
        final OutputStream outputStream2 = outputStream;
        jca(decryptAeadRequest).withCipher(new CheckedFunction<Cipher, byte[]>() {
            public byte[] apply(Cipher cipher) {
                cipher.init(2, assertKey, ivSpec);
                Streams.write(outputStream2, GcmAesAeadAlgorithm.this.withCipher(cipher, sequenceInputStream, associatedData, outputStream2), "GcmAesAeadAlgorithm#decrypt plaintext write failure.");
                return Bytes.EMPTY;
            }
        });
        Streams.flush(outputStream);
    }

    public void encrypt(AeadRequest aeadRequest, AeadResult aeadResult) {
        Assert.notNull(aeadRequest, "Request cannot be null.");
        Assert.notNull(aeadResult, "Result cannot be null.");
        final SecretKey assertKey = assertKey((SecretKey) aeadRequest.getKey());
        InputStream inputStream = (InputStream) Assert.notNull(aeadRequest.getPayload(), "Request content (plaintext) InputStream cannot be null.");
        OutputStream outputStream = (OutputStream) Assert.notNull(aeadResult.getOutputStream(), "Result ciphertext OutputStream cannot be null.");
        final InputStream associatedData = aeadRequest.getAssociatedData();
        byte[] ensureInitializationVector = ensureInitializationVector(aeadRequest);
        final AlgorithmParameterSpec ivSpec = getIvSpec(ensureInitializationVector);
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        Streams.flush(outputStream);
        Streams.reset(inputStream);
        aeadResult.setTag((byte[]) jca(aeadRequest).withCipher(new CheckedFunction<Cipher, byte[]>() {
            public byte[] apply(Cipher cipher) {
                cipher.init(1, assertKey, ivSpec);
                byte[] withCipher = GcmAesAeadAlgorithm.this.withCipher(cipher, inputStream2, associatedData, outputStream2);
                int length = Bytes.length(withCipher) - 16;
                Streams.write(outputStream2, withCipher, 0, length, "Ciphertext write failure.");
                byte[] bArr = new byte[16];
                System.arraycopy(withCipher, length, bArr, 0, 16);
                return bArr;
            }
        })).setIv(ensureInitializationVector);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ int getKeyBitLength() {
        return super.getKeyBitLength();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ SecretKeyBuilder key() {
        return super.key();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
