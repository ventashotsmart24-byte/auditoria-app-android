package io.jsonwebtoken;

public abstract class JwtHandlerAdapter<T> extends SupportedJwtVisitor<T> implements JwtHandler<T> {
    public T onClaimsJwe(Jwe<Claims> jwe) {
        return super.onDecryptedClaims(jwe);
    }

    public T onClaimsJws(Jws<Claims> jws) {
        return super.onVerifiedClaims(jws);
    }

    public T onClaimsJwt(Jwt<Header, Claims> jwt) {
        return super.onUnsecuredClaims(jwt);
    }

    public T onContentJwe(Jwe<byte[]> jwe) {
        return super.onDecryptedContent(jwe);
    }

    public T onContentJws(Jws<byte[]> jws) {
        return super.onVerifiedContent(jws);
    }

    public T onContentJwt(Jwt<Header, byte[]> jwt) {
        return super.onUnsecuredContent(jwt);
    }

    public T onDecryptedClaims(Jwe<Claims> jwe) {
        return onClaimsJwe(jwe);
    }

    public T onDecryptedContent(Jwe<byte[]> jwe) {
        return onContentJwe(jwe);
    }

    public T onUnsecuredClaims(Jwt<Header, Claims> jwt) {
        return onClaimsJwt(jwt);
    }

    public T onUnsecuredContent(Jwt<Header, byte[]> jwt) {
        return onContentJwt(jwt);
    }

    public T onVerifiedClaims(Jws<Claims> jws) {
        return onClaimsJws(jws);
    }

    public T onVerifiedContent(Jws<byte[]> jws) {
        return onContentJws(jws);
    }
}
