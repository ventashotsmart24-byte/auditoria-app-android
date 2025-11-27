package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;

public class LocatingKeyResolver implements SigningKeyResolver {
    private final Locator<? extends Key> locator;

    public LocatingKeyResolver(Locator<? extends Key> locator2) {
        this.locator = (Locator) Assert.notNull(locator2, "Locator cannot be null.");
    }

    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        return (Key) this.locator.locate(jwsHeader);
    }

    public Key resolveSigningKey(JwsHeader jwsHeader, byte[] bArr) {
        return (Key) this.locator.locate(jwsHeader);
    }
}
