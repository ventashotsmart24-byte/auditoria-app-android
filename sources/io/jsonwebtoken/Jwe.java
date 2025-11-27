package io.jsonwebtoken;

public interface Jwe<B> extends ProtectedJwt<JweHeader, B> {
    public static final JwtVisitor<Jwe<Claims>> CLAIMS = new SupportedJwtVisitor<Jwe<Claims>>() {
        public Jwe<Claims> onDecryptedClaims(Jwe<Claims> jwe) {
            return jwe;
        }
    };
    public static final JwtVisitor<Jwe<byte[]>> CONTENT = new SupportedJwtVisitor<Jwe<byte[]>>() {
        public Jwe<byte[]> onDecryptedContent(Jwe<byte[]> jwe) {
            return jwe;
        }
    };

    byte[] getInitializationVector();
}
