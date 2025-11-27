package io.jsonwebtoken;

import io.jsonwebtoken.io.IOException;

public class CompressionException extends IOException {
    public CompressionException(String str) {
        super(str);
    }

    public CompressionException(String str, Throwable th) {
        super(str, th);
    }
}
