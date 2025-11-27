package io.jsonwebtoken.security;

import java.io.OutputStream;

public interface AeadResult {
    OutputStream getOutputStream();

    AeadResult setIv(byte[] bArr);

    AeadResult setTag(byte[] bArr);
}
