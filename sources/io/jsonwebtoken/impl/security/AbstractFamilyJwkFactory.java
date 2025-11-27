package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.KeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.util.Set;

abstract class AbstractFamilyJwkFactory<K extends Key, J extends Jwk<K>> implements FamilyJwkFactory<K, J> {
    private final Class<K> keyType;
    private final String ktyValue;
    private final Set<Parameter<?>> params;

    public AbstractFamilyJwkFactory(String str, Class<K> cls, Set<Parameter<?>> set) {
        this.ktyValue = (String) Assert.hasText(str, "keyType argument cannot be null or empty.");
        this.keyType = (Class) Assert.notNull(cls, "keyType class cannot be null.");
        this.params = (Set) Assert.notEmpty(set, "Parameters collection cannot be null or empty.");
    }

    public static <T> void put(JwkContext<?> jwkContext, Parameter<T> parameter, T t10) {
        jwkContext.put(parameter.getId(), parameter.applyTo(t10));
    }

    public final J createJwk(JwkContext<K> jwkContext) {
        Assert.notNull(jwkContext, "JwkContext argument cannot be null.");
        if (!supports((JwkContext<?>) jwkContext)) {
            throw new IllegalArgumentException("Unsupported JwkContext.");
        } else if (jwkContext.getKey() == null) {
            return createJwkFromValues(jwkContext);
        } else {
            jwkContext.setType(this.ktyValue);
            return createJwkFromKey(jwkContext);
        }
    }

    public abstract J createJwkFromKey(JwkContext<K> jwkContext);

    public abstract J createJwkFromValues(JwkContext<K> jwkContext);

    /* JADX WARNING: type inference failed for: r3v0, types: [io.jsonwebtoken.impl.lang.CheckedFunction, io.jsonwebtoken.impl.lang.CheckedFunction<java.security.KeyFactory, K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public K generateKey(io.jsonwebtoken.impl.security.JwkContext<K> r2, io.jsonwebtoken.impl.lang.CheckedFunction<java.security.KeyFactory, K> r3) {
        /*
            r1 = this;
            java.lang.Class<K> r0 = r1.keyType
            java.security.Key r2 = r1.generateKey(r2, r0, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory.generateKey(io.jsonwebtoken.impl.security.JwkContext, io.jsonwebtoken.impl.lang.CheckedFunction):java.security.Key");
    }

    public String getId() {
        return this.ktyValue;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.jsonwebtoken.impl.security.JwkContext, io.jsonwebtoken.impl.security.JwkContext<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getKeyFactoryJcaName(io.jsonwebtoken.impl.security.JwkContext<?> r2) {
        /*
            r1 = this;
            java.security.Key r2 = r2.getKey()
            java.lang.String r2 = io.jsonwebtoken.impl.security.KeysBridge.findAlgorithm(r2)
            boolean r0 = io.jsonwebtoken.lang.Strings.hasText((java.lang.String) r2)
            if (r0 == 0) goto L_0x000f
            goto L_0x0013
        L_0x000f:
            java.lang.String r2 = r1.getId()
        L_0x0013:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory.getKeyFactoryJcaName(io.jsonwebtoken.impl.security.JwkContext):java.lang.String");
    }

    public JwkContext<K> newContext(JwkContext<?> jwkContext, K k10) {
        DefaultJwkContext defaultJwkContext;
        Assert.notNull(jwkContext, "Source JwkContext cannot be null.");
        if (k10 != null) {
            Set<Parameter<?>> set = this.params;
        } else {
            defaultJwkContext = new DefaultJwkContext(this.params, jwkContext, false);
        }
        return defaultJwkContext;
    }

    public boolean supports(Key key) {
        return this.keyType.isInstance(key);
    }

    public boolean supportsKeyValues(JwkContext<?> jwkContext) {
        return this.ktyValue.equals(jwkContext.getType());
    }

    public <T extends Key> T generateKey(final JwkContext<?> jwkContext, final Class<T> cls, final CheckedFunction<KeyFactory, T> checkedFunction) {
        return (Key) new JcaTemplate(getKeyFactoryJcaName(jwkContext), jwkContext.getProvider(), jwkContext.getRandom()).withKeyFactory(new CheckedFunction<KeyFactory, T>() {
            public T apply(KeyFactory keyFactory) {
                try {
                    return (Key) checkedFunction.apply(keyFactory);
                } catch (KeyException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new InvalidKeyException("Unable to create " + cls.getSimpleName() + " from JWK " + jwkContext + ": " + e11.getMessage(), e11);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.jsonwebtoken.impl.security.JwkContext, io.jsonwebtoken.impl.security.JwkContext<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean supports(io.jsonwebtoken.impl.security.JwkContext<?> r2) {
        /*
            r1 = this;
            java.security.Key r0 = r2.getKey()
            boolean r0 = r1.supports((java.security.Key) r0)
            if (r0 != 0) goto L_0x0013
            boolean r2 = r1.supportsKeyValues(r2)
            if (r2 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = 0
            goto L_0x0014
        L_0x0013:
            r2 = 1
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory.supports(io.jsonwebtoken.impl.security.JwkContext):boolean");
    }
}
