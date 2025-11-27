package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface SignatureAlgorithm extends SecureDigestAlgorithm<PrivateKey, PublicKey>, KeyPairBuilderSupplier {
}
