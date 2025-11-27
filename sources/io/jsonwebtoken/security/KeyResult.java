package io.jsonwebtoken.security;

import javax.crypto.SecretKey;

public interface KeyResult extends Message<byte[]>, KeySupplier<SecretKey> {
}
