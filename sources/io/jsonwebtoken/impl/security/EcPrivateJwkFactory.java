package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.EcPrivateJwk;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;

class EcPrivateJwkFactory extends AbstractEcJwkFactory<ECPrivateKey, EcPrivateJwk> {
    private static final String ECPUBKEY_ERR_MSG = ("JwkContext publicKey must be an " + ECPublicKey.class.getName() + " instance.");
    private static final EcPublicJwkFactory PUB_FACTORY = EcPublicJwkFactory.INSTANCE;

    public EcPrivateJwkFactory() {
        super(ECPrivateKey.class, DefaultEcPrivateJwk.PARAMS);
    }

    public ECPublicKey derivePublic(KeyFactory keyFactory, ECPublicKeySpec eCPublicKeySpec) {
        return (ECPublicKey) keyFactory.generatePublic(eCPublicKeySpec);
    }

    public boolean supportsKeyValues(JwkContext<?> jwkContext) {
        if (!super.supportsKeyValues(jwkContext) || !jwkContext.containsKey(DefaultEcPrivateJwk.D.getId())) {
            return false;
        }
        return true;
    }

    public EcPrivateJwk createJwkFromKey(JwkContext<ECPrivateKey> jwkContext) {
        ECPublicKey eCPublicKey;
        ECPrivateKey key = jwkContext.getKey();
        PublicKey publicKey = jwkContext.getPublicKey();
        if (publicKey != null) {
            eCPublicKey = (ECPublicKey) Assert.isInstanceOf(ECPublicKey.class, publicKey, ECPUBKEY_ERR_MSG);
        } else {
            eCPublicKey = derivePublic(jwkContext);
        }
        boolean z10 = !Strings.hasText(jwkContext.getId()) && jwkContext.getIdThumbprintAlgorithm() != null;
        EcPublicJwkFactory ecPublicJwkFactory = PUB_FACTORY;
        EcPublicJwk ecPublicJwk = (EcPublicJwk) ecPublicJwkFactory.createJwk(ecPublicJwkFactory.newContext(jwkContext, eCPublicKey));
        jwkContext.putAll(ecPublicJwk);
        if (z10) {
            jwkContext.setId(ecPublicJwk.getId());
        }
        jwkContext.put(DefaultEcPrivateJwk.D.getId(), AbstractEcJwkFactory.toOctetString(key.getParams().getCurve(), key.getS()));
        return new DefaultEcPrivateJwk(jwkContext, ecPublicJwk);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.ECPrivateKey>, io.jsonwebtoken.impl.security.JwkContext, io.jsonwebtoken.impl.lang.ParameterReadable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.security.EcPrivateJwk createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.ECPrivateKey> r5) {
        /*
            r4 = this;
            io.jsonwebtoken.impl.lang.RequiredParameterReader r0 = new io.jsonwebtoken.impl.lang.RequiredParameterReader
            r0.<init>((io.jsonwebtoken.impl.lang.ParameterReadable) r5)
            io.jsonwebtoken.impl.lang.Parameter<java.lang.String> r1 = io.jsonwebtoken.impl.security.DefaultEcPublicJwk.CRV
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultEcPrivateJwk.D
            java.lang.Object r0 = r0.get(r2)
            java.math.BigInteger r0 = (java.math.BigInteger) r0
            io.jsonwebtoken.impl.security.DefaultJwkContext r2 = new io.jsonwebtoken.impl.security.DefaultJwkContext
            java.util.Set<io.jsonwebtoken.impl.lang.Parameter<?>> r3 = io.jsonwebtoken.impl.security.DefaultEcPublicJwk.PARAMS
            r2.<init>(r3, r5)
            io.jsonwebtoken.impl.security.EcPublicJwkFactory r3 = io.jsonwebtoken.impl.security.EcPublicJwkFactory.INSTANCE
            io.jsonwebtoken.security.Jwk r2 = r3.createJwk(r2)
            io.jsonwebtoken.security.EcPublicJwk r2 = (io.jsonwebtoken.security.EcPublicJwk) r2
            io.jsonwebtoken.impl.security.ECCurve r1 = io.jsonwebtoken.impl.security.AbstractEcJwkFactory.getCurveByJwaId(r1)
            java.security.spec.ECPrivateKeySpec r3 = new java.security.spec.ECPrivateKeySpec
            java.security.spec.ECParameterSpec r1 = r1.toParameterSpec()
            r3.<init>(r0, r1)
            io.jsonwebtoken.impl.security.EcPrivateJwkFactory$2 r0 = new io.jsonwebtoken.impl.security.EcPrivateJwkFactory$2
            r0.<init>(r3)
            java.security.Key r0 = r4.generateKey(r5, r0)
            java.security.interfaces.ECPrivateKey r0 = (java.security.interfaces.ECPrivateKey) r0
            r5.setKey(r0)
            io.jsonwebtoken.impl.security.DefaultEcPrivateJwk r0 = new io.jsonwebtoken.impl.security.DefaultEcPrivateJwk
            r0.<init>(r5, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.EcPrivateJwkFactory.createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext):io.jsonwebtoken.security.EcPrivateJwk");
    }

    public ECPublicKey derivePublic(JwkContext<ECPrivateKey> jwkContext) {
        final ECPrivateKey key = jwkContext.getKey();
        return (ECPublicKey) generateKey(jwkContext, ECPublicKey.class, new CheckedFunction<KeyFactory, ECPublicKey>() {
            public ECPublicKey apply(KeyFactory keyFactory) {
                try {
                    return EcPrivateJwkFactory.this.derivePublic(keyFactory, ECCurve.publicKeySpec(key));
                } catch (Exception e10) {
                    throw new InvalidKeyException("Unable to derive ECPublicKey from ECPrivateKey: " + e10.getMessage(), e10);
                }
            }
        });
    }
}
