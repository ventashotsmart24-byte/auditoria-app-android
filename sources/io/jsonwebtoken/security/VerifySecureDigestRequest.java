package io.jsonwebtoken.security;

import java.io.InputStream;
import java.security.Key;

public interface VerifySecureDigestRequest<K extends Key> extends SecureRequest<InputStream, K>, VerifyDigestRequest {
}
