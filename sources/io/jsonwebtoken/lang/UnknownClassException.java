package io.jsonwebtoken.lang;

public class UnknownClassException extends RuntimeException {
    public UnknownClassException(String str) {
        super(str);
    }

    public UnknownClassException(String str, Throwable th) {
        super(str, th);
    }
}
