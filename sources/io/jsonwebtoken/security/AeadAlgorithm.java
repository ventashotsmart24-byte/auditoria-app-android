package io.jsonwebtoken.security;

import io.jsonwebtoken.Identifiable;
import java.io.OutputStream;
import javax.crypto.SecretKey;

public interface AeadAlgorithm extends Identifiable, KeyLengthSupplier, KeyBuilderSupplier<SecretKey, SecretKeyBuilder> {
    void decrypt(DecryptAeadRequest decryptAeadRequest, OutputStream outputStream);

    void encrypt(AeadRequest aeadRequest, AeadResult aeadResult);
}
