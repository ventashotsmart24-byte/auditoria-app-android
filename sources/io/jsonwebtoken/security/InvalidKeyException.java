package io.jsonwebtoken.security;

public class InvalidKeyException extends KeyException {
    public InvalidKeyException(String str) {
        super(str);
    }

    public InvalidKeyException(String str, Throwable th) {
        super(str, th);
    }
}
