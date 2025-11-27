package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.AeadRequest;
import io.jsonwebtoken.security.IvSupplier;
import java.io.InputStream;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;

public class DefaultAeadRequest extends DefaultSecureRequest<InputStream, SecretKey> implements AeadRequest, IvSupplier {
    private final InputStream AAD;
    private final byte[] IV;

    public DefaultAeadRequest(InputStream inputStream, Provider provider, SecureRandom secureRandom, SecretKey secretKey, InputStream inputStream2, byte[] bArr) {
        super(inputStream, provider, secureRandom, secretKey);
        this.AAD = inputStream2;
        this.IV = bArr;
    }

    public InputStream getAssociatedData() {
        return this.AAD;
    }

    public byte[] getIv() {
        return this.IV;
    }

    public DefaultAeadRequest(InputStream inputStream, Provider provider, SecureRandom secureRandom, SecretKey secretKey, InputStream inputStream2) {
        this(inputStream, provider, secureRandom, secretKey, inputStream2, (byte[]) null);
    }
}
