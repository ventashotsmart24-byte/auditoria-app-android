package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.RsaPrivateJwk;
import io.jsonwebtoken.security.RsaPublicJwk;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Collection;
import java.util.List;
import java.util.Set;

class RsaPrivateJwkFactory extends AbstractFamilyJwkFactory<RSAPrivateKey, RsaPrivateJwk> {
    private static final Set<Parameter<BigInteger>> OPTIONAL_PRIVATE_PARAMS = Collections.setOf(DefaultRsaPrivateJwk.FIRST_PRIME, DefaultRsaPrivateJwk.SECOND_PRIME, DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT, DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT, DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT);
    private static final String PUBKEY_ERR_MSG = ("JwkContext publicKey must be an " + RSAPublicKey.class.getName() + " instance.");
    private static final String PUB_EXPONENT_EX_MSG = ("Unable to derive RSAPublicKey from RSAPrivateKey [%s]. Supported keys implement the " + RSAPrivateCrtKey.class.getName() + " or " + RSAMultiPrimePrivateCrtKey.class.getName() + " interfaces.  If the specified RSAPrivateKey cannot be one of these two, you must explicitly " + "provide an RSAPublicKey in addition to the RSAPrivateKey, as the " + "[JWA RFC, Section 6.3.2](https://www.rfc-editor.org/rfc/rfc7518.html#section-6.3.2) " + "requires public values to be present in private RSA JWKs.");

    public RsaPrivateJwkFactory() {
        super("RSA", RSAPrivateKey.class, DefaultRsaPrivateJwk.PARAMS);
    }

    private RSAPublicKey derivePublic(final JwkContext<RSAPrivateKey> jwkContext) {
        RSAPrivateKey key = jwkContext.getKey();
        final RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(key.getModulus(), getPublicExponent(key));
        return (RSAPublicKey) generateKey(jwkContext, RSAPublicKey.class, new CheckedFunction<KeyFactory, RSAPublicKey>() {
            public RSAPublicKey apply(KeyFactory keyFactory) {
                try {
                    return (RSAPublicKey) keyFactory.generatePublic(rSAPublicKeySpec);
                } catch (Exception e10) {
                    throw new InvalidKeyException("Unable to derive RSAPublicKey from RSAPrivateKey " + jwkContext + ". Cause: " + e10.getMessage());
                }
            }
        });
    }

    private static BigInteger getPublicExponent(RSAPrivateKey rSAPrivateKey) {
        if (rSAPrivateKey instanceof RSAPrivateCrtKey) {
            return ((RSAPrivateCrtKey) rSAPrivateKey).getPublicExponent();
        }
        if (rSAPrivateKey instanceof RSAMultiPrimePrivateCrtKey) {
            return ((RSAMultiPrimePrivateCrtKey) rSAPrivateKey).getPublicExponent();
        }
        throw new UnsupportedKeyException(String.format(PUB_EXPONENT_EX_MSG, new Object[]{KeysBridge.toString(rSAPrivateKey)}));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.jsonwebtoken.impl.security.JwkContext, io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.RSAPrivateKey>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.interfaces.RSAPrivateKey generateFromSpec(io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.RSAPrivateKey> r2, final java.security.spec.KeySpec r3) {
        /*
            r1 = this;
            io.jsonwebtoken.impl.security.RsaPrivateJwkFactory$2 r0 = new io.jsonwebtoken.impl.security.RsaPrivateJwkFactory$2
            r0.<init>(r3)
            java.security.Key r2 = r1.generateKey(r2, r0)
            java.security.interfaces.RSAPrivateKey r2 = (java.security.interfaces.RSAPrivateKey) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.RsaPrivateJwkFactory.generateFromSpec(io.jsonwebtoken.impl.security.JwkContext, java.security.spec.KeySpec):java.security.interfaces.RSAPrivateKey");
    }

    public boolean supportsKeyValues(JwkContext<?> jwkContext) {
        if (!super.supportsKeyValues(jwkContext) || !jwkContext.containsKey(DefaultRsaPrivateJwk.PRIVATE_EXPONENT.getId())) {
            return false;
        }
        return true;
    }

    public RsaPrivateJwk createJwkFromKey(JwkContext<RSAPrivateKey> jwkContext) {
        RSAPublicKey rSAPublicKey;
        RSAPrivateKey key = jwkContext.getKey();
        PublicKey publicKey = jwkContext.getPublicKey();
        if (publicKey != null) {
            rSAPublicKey = (RSAPublicKey) Assert.isInstanceOf(RSAPublicKey.class, publicKey, PUBKEY_ERR_MSG);
        } else {
            rSAPublicKey = derivePublic(jwkContext);
        }
        boolean z10 = !Strings.hasText(jwkContext.getId()) && jwkContext.getIdThumbprintAlgorithm() != null;
        RsaPublicJwkFactory rsaPublicJwkFactory = RsaPublicJwkFactory.INSTANCE;
        RsaPublicJwk rsaPublicJwk = (RsaPublicJwk) rsaPublicJwkFactory.createJwk(rsaPublicJwkFactory.newContext(jwkContext, rSAPublicKey));
        jwkContext.putAll(rsaPublicJwk);
        if (z10) {
            jwkContext.setId(rsaPublicJwk.getId());
        }
        AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.PRIVATE_EXPONENT, key.getPrivateExponent());
        if (key instanceof RSAPrivateCrtKey) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_PRIME, rSAPrivateCrtKey.getPrimeP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_PRIME, rSAPrivateCrtKey.getPrimeQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT, rSAPrivateCrtKey.getPrimeExponentP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT, rSAPrivateCrtKey.getPrimeExponentQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT, rSAPrivateCrtKey.getCrtCoefficient());
        } else if (key instanceof RSAMultiPrimePrivateCrtKey) {
            RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey = (RSAMultiPrimePrivateCrtKey) key;
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_PRIME, rSAMultiPrimePrivateCrtKey.getPrimeP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_PRIME, rSAMultiPrimePrivateCrtKey.getPrimeQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT, rSAMultiPrimePrivateCrtKey.getPrimeExponentP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT, rSAMultiPrimePrivateCrtKey.getPrimeExponentQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT, rSAMultiPrimePrivateCrtKey.getCrtCoefficient());
            List asList = Arrays.asList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo());
            if (!Collections.isEmpty((Collection<?>) asList)) {
                AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.OTHER_PRIMES_INFO, asList);
            }
        }
        return new DefaultRsaPrivateJwk(jwkContext, rsaPublicJwk);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.security.spec.KeySpec] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r2v24, types: [java.security.spec.RSAPrivateCrtKeySpec] */
    /* JADX WARNING: type inference failed for: r2v25, types: [java.security.spec.RSAMultiPrimePrivateCrtKeySpec] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.security.RsaPrivateJwk createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.RSAPrivateKey> r13) {
        /*
            r12 = this;
            io.jsonwebtoken.impl.lang.RequiredParameterReader r0 = new io.jsonwebtoken.impl.lang.RequiredParameterReader
            r0.<init>((io.jsonwebtoken.impl.lang.ParameterReadable) r13)
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r1 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.PRIVATE_EXPONENT
            java.lang.Object r1 = r0.get(r1)
            r5 = r1
            java.math.BigInteger r5 = (java.math.BigInteger) r5
            io.jsonwebtoken.impl.security.DefaultJwkContext r1 = new io.jsonwebtoken.impl.security.DefaultJwkContext
            java.util.Set<io.jsonwebtoken.impl.lang.Parameter<?>> r2 = io.jsonwebtoken.impl.security.DefaultRsaPublicJwk.PARAMS
            r1.<init>(r2, r13)
            io.jsonwebtoken.impl.security.RsaPublicJwkFactory r2 = io.jsonwebtoken.impl.security.RsaPublicJwkFactory.INSTANCE
            io.jsonwebtoken.security.RsaPublicJwk r1 = r2.createJwkFromValues((io.jsonwebtoken.impl.security.JwkContext) r1)
            java.security.Key r2 = r1.toKey()
            java.security.interfaces.RSAPublicKey r2 = (java.security.interfaces.RSAPublicKey) r2
            java.math.BigInteger r3 = r2.getModulus()
            java.math.BigInteger r4 = r2.getPublicExponent()
            java.util.Set<io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger>> r2 = OPTIONAL_PRIVATE_PARAMS
            java.util.Iterator r2 = r2.iterator()
        L_0x002f:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0047
            java.lang.Object r6 = r2.next()
            io.jsonwebtoken.impl.lang.Parameter r6 = (io.jsonwebtoken.impl.lang.Parameter) r6
            java.lang.String r6 = r6.getId()
            boolean r6 = r13.containsKey(r6)
            if (r6 == 0) goto L_0x002f
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            if (r2 == 0) goto L_0x00a4
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.FIRST_PRIME
            java.lang.Object r2 = r0.get(r2)
            r6 = r2
            java.math.BigInteger r6 = (java.math.BigInteger) r6
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.SECOND_PRIME
            java.lang.Object r2 = r0.get(r2)
            r7 = r2
            java.math.BigInteger r7 = (java.math.BigInteger) r7
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT
            java.lang.Object r2 = r0.get(r2)
            r8 = r2
            java.math.BigInteger r8 = (java.math.BigInteger) r8
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT
            java.lang.Object r2 = r0.get(r2)
            r9 = r2
            java.math.BigInteger r9 = (java.math.BigInteger) r9
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT
            java.lang.Object r2 = r0.get(r2)
            r10 = r2
            java.math.BigInteger r10 = (java.math.BigInteger) r10
            io.jsonwebtoken.impl.lang.Parameter<java.util.List<java.security.spec.RSAOtherPrimeInfo>> r2 = io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk.OTHER_PRIMES_INFO
            java.lang.String r11 = r2.getId()
            boolean r11 = r13.containsKey(r11)
            if (r11 == 0) goto L_0x009d
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
            int r2 = io.jsonwebtoken.lang.Collections.size((java.util.Collection<?>) r0)
            java.security.spec.RSAOtherPrimeInfo[] r2 = new java.security.spec.RSAOtherPrimeInfo[r2]
            java.lang.Object[] r0 = r0.toArray(r2)
            r11 = r0
            java.security.spec.RSAOtherPrimeInfo[] r11 = (java.security.spec.RSAOtherPrimeInfo[]) r11
            java.security.spec.RSAMultiPrimePrivateCrtKeySpec r0 = new java.security.spec.RSAMultiPrimePrivateCrtKeySpec
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x00a9
        L_0x009d:
            java.security.spec.RSAPrivateCrtKeySpec r0 = new java.security.spec.RSAPrivateCrtKeySpec
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x00a9
        L_0x00a4:
            java.security.spec.RSAPrivateKeySpec r0 = new java.security.spec.RSAPrivateKeySpec
            r0.<init>(r3, r5)
        L_0x00a9:
            java.security.interfaces.RSAPrivateKey r0 = r12.generateFromSpec(r13, r0)
            r13.setKey(r0)
            io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk r0 = new io.jsonwebtoken.impl.security.DefaultRsaPrivateJwk
            r0.<init>(r13, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.RsaPrivateJwkFactory.createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext):io.jsonwebtoken.security.RsaPrivateJwk");
    }
}
