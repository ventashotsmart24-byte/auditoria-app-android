package io.jsonwebtoken.security;

import javax.crypto.SecretKey;

public interface MacAlgorithm extends SecureDigestAlgorithm<SecretKey, SecretKey>, KeyBuilderSupplier<SecretKey, SecretKeyBuilder>, KeyLengthSupplier {
}
