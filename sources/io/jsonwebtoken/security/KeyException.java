package io.jsonwebtoken.security;

public class KeyException extends SecurityException {
    public KeyException(String str) {
        super(str);
    }

    public KeyException(String str, Throwable th) {
        super(str, th);
    }
}
