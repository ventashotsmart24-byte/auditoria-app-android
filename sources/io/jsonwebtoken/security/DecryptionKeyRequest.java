package io.jsonwebtoken.security;

import java.security.Key;

public interface DecryptionKeyRequest<K extends Key> extends SecureRequest<byte[], K>, KeyRequest<byte[]> {
}
