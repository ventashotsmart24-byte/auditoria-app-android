package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyPairBuilder;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

final class EdwardsPublicKeyDeriver implements Function<PrivateKey, PublicKey> {
    public static final Function<PrivateKey, PublicKey> INSTANCE = new EdwardsPublicKeyDeriver();

    public static final class ConstantRandom extends SecureRandom {
        private final byte[] value;

        public ConstantRandom(byte[] bArr) {
            this.value = (byte[]) bArr.clone();
        }

        public void nextBytes(byte[] bArr) {
            byte[] bArr2 = this.value;
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        }
    }

    private EdwardsPublicKeyDeriver() {
    }

    public PublicKey apply(PrivateKey privateKey) {
        EdwardsCurve findByKey = EdwardsCurve.findByKey(privateKey);
        if (findByKey != null) {
            KeyPair keyPair = (KeyPair) ((KeyPairBuilder) findByKey.keyPair().random(new ConstantRandom(findByKey.getKeyMaterial(privateKey)))).build();
            Assert.stateNotNull(keyPair, "Edwards curve generated keypair cannot be null.");
            return (PublicKey) Assert.stateNotNull(keyPair.getPublic(), "Edwards curve KeyPair must have a PublicKey");
        }
        throw new InvalidKeyException("Unable to derive Edwards-curve PublicKey for specified PrivateKey: " + KeysBridge.toString(privateKey));
    }
}
