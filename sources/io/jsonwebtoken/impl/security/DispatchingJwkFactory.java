package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;

class DispatchingJwkFactory implements JwkFactory<Key, Jwk<Key>> {
    private static final Collection<FamilyJwkFactory<Key, ?>> DEFAULT_FACTORIES = createDefaultFactories();
    static final JwkFactory<Key, Jwk<Key>> DEFAULT_INSTANCE = new DispatchingJwkFactory();
    private final Collection<FamilyJwkFactory<Key, ?>> factories;

    public DispatchingJwkFactory() {
        this(DEFAULT_FACTORIES);
    }

    private static void assertKeyOrKeyType(Key key, String str) {
        if (key == null && !Strings.hasText(str)) {
            throw new InvalidKeyException("Either a Key instance or a " + AbstractJwk.KTY + " value is required to create a JWK.");
        }
    }

    private static Collection<FamilyJwkFactory<Key, ?>> createDefaultFactories() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new SecretJwkFactory());
        arrayList.add(new AsymmetricJwkFactory(EcPublicJwkFactory.INSTANCE, new EcPrivateJwkFactory()));
        arrayList.add(new AsymmetricJwkFactory(RsaPublicJwkFactory.INSTANCE, new RsaPrivateJwkFactory()));
        arrayList.add(new AsymmetricJwkFactory(OctetPublicJwkFactory.INSTANCE, new OctetPrivateJwkFactory()));
        return arrayList;
    }

    private static UnsupportedKeyException noFamily(Key key, String str) {
        String str2;
        if (key != null) {
            str2 = "key of type " + key.getClass().getName();
        } else {
            str2 = "kty value '" + str + "'";
        }
        return new UnsupportedKeyException("Unable to create JWK for unrecognized " + str2 + ": there is no known JWK Factory capable of creating JWKs for this key type.");
    }

    public Jwk<Key> createJwk(JwkContext<Key> jwkContext) {
        Assert.notNull(jwkContext, "JwkContext cannot be null.");
        Key key = jwkContext.getKey();
        String clean = Strings.clean(jwkContext.getType());
        assertKeyOrKeyType(key, clean);
        for (FamilyJwkFactory next : this.factories) {
            if (next.supports((JwkContext<?>) jwkContext)) {
                String str = (String) Assert.hasText(next.getId(), "factory id cannot be null or empty.");
                if (clean == null) {
                    jwkContext.setType(str);
                }
                return next.createJwk(jwkContext);
            }
        }
        throw noFamily(key, clean);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.impl.security.JwkContext<java.security.Key> newContext(io.jsonwebtoken.impl.security.JwkContext<?> r5, java.security.Key r6) {
        /*
            r4 = this;
            java.lang.String r0 = "JwkContext cannot be null."
            io.jsonwebtoken.lang.Assert.notNull(r5, r0)
            java.lang.String r0 = r5.getType()
            assertKeyOrKeyType(r6, r0)
            java.util.Collection<io.jsonwebtoken.impl.security.FamilyJwkFactory<java.security.Key, ?>> r1 = r4.factories
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()
            io.jsonwebtoken.impl.security.FamilyJwkFactory r2 = (io.jsonwebtoken.impl.security.FamilyJwkFactory) r2
            boolean r3 = r2.supports((java.security.Key) r6)
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.supports((io.jsonwebtoken.impl.security.JwkContext<?>) r5)
            if (r3 == 0) goto L_0x0012
        L_0x002a:
            io.jsonwebtoken.impl.security.JwkContext r5 = r2.newContext(r5, r6)
            java.lang.String r6 = "FamilyJwkFactory implementation cannot return null JwkContexts."
            java.lang.Object r5 = io.jsonwebtoken.lang.Assert.notNull(r5, r6)
            io.jsonwebtoken.impl.security.JwkContext r5 = (io.jsonwebtoken.impl.security.JwkContext) r5
            return r5
        L_0x0037:
            io.jsonwebtoken.security.UnsupportedKeyException r5 = noFamily(r6, r0)
            goto L_0x003d
        L_0x003c:
            throw r5
        L_0x003d:
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.DispatchingJwkFactory.newContext(io.jsonwebtoken.impl.security.JwkContext, java.security.Key):io.jsonwebtoken.impl.security.JwkContext");
    }

    public DispatchingJwkFactory(Collection<? extends FamilyJwkFactory<?, ?>> collection) {
        Assert.notEmpty(collection, "FamilyJwkFactory collection cannot be null or empty.");
        this.factories = new ArrayList(collection.size());
        for (FamilyJwkFactory familyJwkFactory : collection) {
            Assert.hasText(familyJwkFactory.getId(), "FamilyJwkFactory.getFactoryId() cannot return null or empty.");
            this.factories.add(familyJwkFactory);
        }
    }
}
