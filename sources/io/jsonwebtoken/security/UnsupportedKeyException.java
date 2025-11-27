package io.jsonwebtoken.security;

public class UnsupportedKeyException extends KeyException {
    public UnsupportedKeyException(String str) {
        super(str);
    }

    public UnsupportedKeyException(String str, Throwable th) {
        super(str, th);
    }
}
