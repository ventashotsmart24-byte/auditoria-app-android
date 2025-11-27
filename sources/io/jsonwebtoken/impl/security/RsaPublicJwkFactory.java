package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.security.RsaPublicJwk;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;

class RsaPublicJwkFactory extends AbstractFamilyJwkFactory<RSAPublicKey, RsaPublicJwk> {
    static final RsaPublicJwkFactory INSTANCE = new RsaPublicJwkFactory();

    public RsaPublicJwkFactory() {
        super("RSA", RSAPublicKey.class, DefaultRsaPublicJwk.PARAMS);
    }

    public RsaPublicJwk createJwkFromKey(JwkContext<RSAPublicKey> jwkContext) {
        RSAPublicKey key = jwkContext.getKey();
        Parameter<BigInteger> parameter = DefaultRsaPublicJwk.MODULUS;
        jwkContext.put(parameter.getId(), parameter.applyTo(key.getModulus()));
        Parameter<BigInteger> parameter2 = DefaultRsaPublicJwk.PUBLIC_EXPONENT;
        jwkContext.put(parameter2.getId(), parameter2.applyTo(key.getPublicExponent()));
        return new DefaultRsaPublicJwk(jwkContext);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.RSAPublicKey>, io.jsonwebtoken.impl.security.JwkContext, io.jsonwebtoken.impl.lang.ParameterReadable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.security.RsaPublicJwk createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.RSAPublicKey> r4) {
        /*
            r3 = this;
            io.jsonwebtoken.impl.lang.RequiredParameterReader r0 = new io.jsonwebtoken.impl.lang.RequiredParameterReader
            r0.<init>((io.jsonwebtoken.impl.lang.ParameterReadable) r4)
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r1 = io.jsonwebtoken.impl.security.DefaultRsaPublicJwk.MODULUS
            java.lang.Object r1 = r0.get(r1)
            java.math.BigInteger r1 = (java.math.BigInteger) r1
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultRsaPublicJwk.PUBLIC_EXPONENT
            java.lang.Object r0 = r0.get(r2)
            java.math.BigInteger r0 = (java.math.BigInteger) r0
            java.security.spec.RSAPublicKeySpec r2 = new java.security.spec.RSAPublicKeySpec
            r2.<init>(r1, r0)
            io.jsonwebtoken.impl.security.RsaPublicJwkFactory$1 r0 = new io.jsonwebtoken.impl.security.RsaPublicJwkFactory$1
            r0.<init>(r2)
            java.security.Key r0 = r3.generateKey(r4, r0)
            java.security.interfaces.RSAPublicKey r0 = (java.security.interfaces.RSAPublicKey) r0
            r4.setKey(r0)
            io.jsonwebtoken.impl.security.DefaultRsaPublicJwk r0 = new io.jsonwebtoken.impl.security.DefaultRsaPublicJwk
            r0.<init>(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.RsaPublicJwkFactory.createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext):io.jsonwebtoken.security.RsaPublicJwk");
    }
}
