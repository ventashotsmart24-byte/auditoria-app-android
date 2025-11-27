package io.jsonwebtoken.impl;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtVisitor;

public class DefaultJws<P> extends DefaultProtectedJwt<JwsHeader, P> implements Jws<P> {
    private static final String DIGEST_NAME = "signature";
    private final String signature;

    public DefaultJws(JwsHeader jwsHeader, P p10, byte[] bArr, String str) {
        super(jwsHeader, p10, bArr, "signature");
        this.signature = str;
    }

    public <T> T accept(JwtVisitor<T> jwtVisitor) {
        return jwtVisitor.visit((Jws<?>) this);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ byte[] getDigest() {
        return super.getDigest();
    }

    public String getSignature() {
        return this.signature;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }
}
