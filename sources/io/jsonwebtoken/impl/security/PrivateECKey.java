package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeySupplier;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;

public class PrivateECKey implements PrivateKey, ECKey, KeySupplier<PrivateKey> {
    private final ECParameterSpec params;
    private final PrivateKey privateKey;

    public PrivateECKey(PrivateKey privateKey2, ECParameterSpec eCParameterSpec) {
        this.privateKey = (PrivateKey) Assert.notNull(privateKey2, "PrivateKey cannot be null.");
        this.params = (ECParameterSpec) Assert.notNull(eCParameterSpec, "ECParameterSpec cannot be null.");
    }

    public String getAlgorithm() {
        return this.privateKey.getAlgorithm();
    }

    public byte[] getEncoded() {
        return this.privateKey.getEncoded();
    }

    public String getFormat() {
        return this.privateKey.getFormat();
    }

    public ECParameterSpec getParams() {
        return this.params;
    }

    public PrivateKey getKey() {
        return this.privateKey;
    }
}
