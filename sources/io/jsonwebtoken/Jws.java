package io.jsonwebtoken;

public interface Jws<P> extends ProtectedJwt<JwsHeader, P> {
    public static final JwtVisitor<Jws<Claims>> CLAIMS = new SupportedJwtVisitor<Jws<Claims>>() {
        public Jws<Claims> onVerifiedClaims(Jws<Claims> jws) {
            return jws;
        }
    };
    public static final JwtVisitor<Jws<byte[]>> CONTENT = new SupportedJwtVisitor<Jws<byte[]>>() {
        public Jws<byte[]> onVerifiedContent(Jws<byte[]> jws) {
            return jws;
        }
    };

    @Deprecated
    String getSignature();
}
