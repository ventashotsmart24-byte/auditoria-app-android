package io.jsonwebtoken.impl.security;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RandomSecretKeyBuilder extends DefaultSecretKeyBuilder {
    public RandomSecretKeyBuilder(String str, int i10) {
        super(str, i10);
    }

    public SecretKey build() {
        byte[] bArr = new byte[(this.BIT_LENGTH / 8)];
        this.random.nextBytes(bArr);
        return new SecretKeySpec(bArr, this.JCA_NAME);
    }
}
