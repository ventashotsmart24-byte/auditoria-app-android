package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.DigestSupplier;
import io.jsonwebtoken.security.IvSupplier;
import java.io.OutputStream;

public class DefaultAeadResult implements AeadResult, DigestSupplier, IvSupplier {
    private byte[] iv;
    private final OutputStream out;
    private byte[] tag;

    public DefaultAeadResult(OutputStream outputStream) {
        this.out = (OutputStream) Assert.notNull(outputStream, "OutputStream cannot be null.");
    }

    public byte[] getDigest() {
        return this.tag;
    }

    public byte[] getIv() {
        return this.iv;
    }

    public OutputStream getOutputStream() {
        return this.out;
    }

    public AeadResult setIv(byte[] bArr) {
        this.iv = Assert.notEmpty(bArr, "Initialization Vector cannot be null or empty.");
        return this;
    }

    public AeadResult setTag(byte[] bArr) {
        this.tag = Assert.notEmpty(bArr, "Authentication Tag cannot be null or empty.");
        return this;
    }
}
