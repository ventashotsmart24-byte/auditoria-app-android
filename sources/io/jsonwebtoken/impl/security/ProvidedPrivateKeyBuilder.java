package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.PrivateKeyBuilder;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECKey;

public class ProvidedPrivateKeyBuilder extends ProvidedKeyBuilder<PrivateKey, PrivateKeyBuilder> implements PrivateKeyBuilder {
    private PublicKey publicKey;

    public ProvidedPrivateKeyBuilder(PrivateKey privateKey) {
        super(privateKey);
    }

    public PrivateKeyBuilder publicKey(PublicKey publicKey2) {
        this.publicKey = publicKey2;
        return this;
    }

    public PrivateKey doBuild() {
        K k10 = this.key;
        PrivateKey privateKey = (PrivateKey) k10;
        String clean = Strings.clean(((PrivateKey) k10).getAlgorithm());
        if (!(privateKey instanceof ECKey) && ("EC".equalsIgnoreCase(clean) || "ECDSA".equalsIgnoreCase(clean))) {
            PublicKey publicKey2 = this.publicKey;
            if (publicKey2 instanceof ECKey) {
                privateKey = new PrivateECKey(privateKey, ((ECKey) publicKey2).getParams());
            }
        }
        Provider provider = this.provider;
        return provider != null ? new ProviderPrivateKey(provider, privateKey) : privateKey;
    }
}
