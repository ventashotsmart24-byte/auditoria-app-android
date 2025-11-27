package io.jsonwebtoken.security;

public class MalformedKeyException extends InvalidKeyException {
    public MalformedKeyException(String str) {
        super(str);
    }

    public MalformedKeyException(String str, Throwable th) {
        super(str, th);
    }
}
