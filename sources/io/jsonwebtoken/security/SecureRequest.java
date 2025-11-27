package io.jsonwebtoken.security;

import java.security.Key;

public interface SecureRequest<T, K extends Key> extends Request<T>, KeySupplier<K> {
}
