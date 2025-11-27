package io.jsonwebtoken;

import io.jsonwebtoken.Header;

public interface Jwt<H extends Header, P> {
    public static final JwtVisitor<Jwt<Header, Claims>> UNSECURED_CLAIMS = new SupportedJwtVisitor<Jwt<Header, Claims>>() {
        public Jwt<Header, Claims> onUnsecuredClaims(Jwt<Header, Claims> jwt) {
            return jwt;
        }
    };
    public static final JwtVisitor<Jwt<Header, byte[]>> UNSECURED_CONTENT = new SupportedJwtVisitor<Jwt<Header, byte[]>>() {
        public Jwt<Header, byte[]> onUnsecuredContent(Jwt<Header, byte[]> jwt) {
            return jwt;
        }
    };

    <T> T accept(JwtVisitor<T> jwtVisitor);

    @Deprecated
    P getBody();

    H getHeader();

    P getPayload();
}
