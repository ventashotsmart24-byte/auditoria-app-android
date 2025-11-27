package io.jsonwebtoken;

public interface JwtVisitor<T> {
    T visit(Jwe<?> jwe);

    T visit(Jws<?> jws);

    T visit(Jwt<?, ?> jwt);
}
