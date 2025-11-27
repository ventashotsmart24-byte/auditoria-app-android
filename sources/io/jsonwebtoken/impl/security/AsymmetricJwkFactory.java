package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Jwk;
import java.security.Key;

class AsymmetricJwkFactory implements FamilyJwkFactory<Key, Jwk<Key>> {
    private final String id;
    private final FamilyJwkFactory<Key, Jwk<Key>> privateFactory;
    private final FamilyJwkFactory<Key, Jwk<Key>> publicFactory;

    public AsymmetricJwkFactory(FamilyJwkFactory familyJwkFactory, FamilyJwkFactory familyJwkFactory2) {
        this.publicFactory = (FamilyJwkFactory) Assert.notNull(familyJwkFactory, "publicFactory cannot be null.");
        this.privateFactory = (FamilyJwkFactory) Assert.notNull(familyJwkFactory2, "privateFactory cannot be null.");
        String str = (String) Assert.notNull(familyJwkFactory.getId(), "publicFactory id cannot be null or empty.");
        this.id = str;
        Assert.isTrue(str.equals(familyJwkFactory2.getId()), "privateFactory id must equal publicFactory id");
    }

    public Jwk<Key> createJwk(JwkContext<Key> jwkContext) {
        if (this.privateFactory.supports((JwkContext<?>) jwkContext)) {
            return this.privateFactory.createJwk(jwkContext);
        }
        return this.publicFactory.createJwk(jwkContext);
    }

    public String getId() {
        return this.id;
    }

    public JwkContext<Key> newContext(JwkContext<?> jwkContext, Key key) {
        FamilyJwkFactory<Key, Jwk<Key>> familyJwkFactory;
        if (this.privateFactory.supports(key) || this.privateFactory.supports(jwkContext)) {
            familyJwkFactory = this.privateFactory;
        } else {
            familyJwkFactory = this.publicFactory;
        }
        return familyJwkFactory.newContext(jwkContext, key);
    }

    public boolean supports(JwkContext<?> jwkContext) {
        return jwkContext != null && (this.id.equals(jwkContext.getType()) || this.privateFactory.supports(jwkContext) || this.publicFactory.supports(jwkContext));
    }

    public boolean supports(Key key) {
        return key != null && (this.privateFactory.supports(key) || this.publicFactory.supports(key));
    }
}
