package io.jsonwebtoken.security;

import io.jsonwebtoken.JweHeader;

public interface KeyRequest<T> extends Request<T> {
    AeadAlgorithm getEncryptionAlgorithm();

    JweHeader getHeader();
}
