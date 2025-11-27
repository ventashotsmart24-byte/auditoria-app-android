package io.jsonwebtoken;

public class PrematureJwtException extends ClaimJwtException {
    public PrematureJwtException(Header header, Claims claims, String str) {
        super(header, claims, str);
    }

    @Deprecated
    public PrematureJwtException(Header header, Claims claims, String str, Throwable th) {
        super(header, claims, str, th);
    }
}
