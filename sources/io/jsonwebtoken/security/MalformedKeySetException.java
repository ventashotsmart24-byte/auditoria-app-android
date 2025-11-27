package io.jsonwebtoken.security;

public class MalformedKeySetException extends SecurityException {
    public MalformedKeySetException(String str) {
        super(str);
    }

    public MalformedKeySetException(String str, Throwable th) {
        super(str, th);
    }
}
