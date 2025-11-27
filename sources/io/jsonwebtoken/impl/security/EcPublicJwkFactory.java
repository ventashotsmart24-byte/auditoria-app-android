package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.InvalidKeyException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Map;

class EcPublicJwkFactory extends AbstractEcJwkFactory<ECPublicKey, EcPublicJwk> {
    static final EcPublicJwkFactory INSTANCE = new EcPublicJwkFactory();
    private static final String UNSUPPORTED_CURVE_MSG = "The specified ECKey curve does not match a JWA standard curve id.";

    public EcPublicJwkFactory() {
        super(ECPublicKey.class, DefaultEcPublicJwk.PARAMS);
    }

    public static String getJwaIdByCurve(EllipticCurve ellipticCurve) {
        ECCurve findByJcaCurve = ECCurve.findByJcaCurve(ellipticCurve);
        if (findByJcaCurve != null) {
            return findByJcaCurve.getId();
        }
        throw new InvalidKeyException(UNSUPPORTED_CURVE_MSG);
    }

    public static String jwkContainsErrorMessage(String str, Map<String, ?> map) {
        Assert.hasText(str, "curveId cannot be null or empty.");
        return String.format("EC JWK x,y coordinates do not exist on elliptic curve '%s'. This could be due simply to an incorrectly-created JWK or possibly an attempted Invalid Curve Attack (see https://safecurves.cr.yp.to/twist.html for more information).", new Object[]{str, map});
    }

    public static String keyContainsErrorMessage(String str) {
        Assert.hasText(str, "curveId cannot be null or empty.");
        return String.format("ECPublicKey's ECPoint does not exist on elliptic curve '%s' and may not be used to create '%s' JWKs.", new Object[]{str, str});
    }

    public EcPublicJwk createJwkFromKey(JwkContext<ECPublicKey> jwkContext) {
        ECPublicKey key = jwkContext.getKey();
        EllipticCurve curve = key.getParams().getCurve();
        ECPoint w10 = key.getW();
        String jwaIdByCurve = getJwaIdByCurve(curve);
        if (ECCurve.contains(curve, w10)) {
            jwkContext.put(DefaultEcPublicJwk.CRV.getId(), jwaIdByCurve);
            jwkContext.put(DefaultEcPublicJwk.X.getId(), AbstractEcJwkFactory.toOctetString(curve, w10.getAffineX()));
            jwkContext.put(DefaultEcPublicJwk.Y.getId(), AbstractEcJwkFactory.toOctetString(curve, w10.getAffineY()));
            return new DefaultEcPublicJwk(jwkContext);
        }
        throw new InvalidKeyException(keyContainsErrorMessage(jwaIdByCurve));
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.ECPublicKey>, io.jsonwebtoken.impl.security.JwkContext, java.util.Map, io.jsonwebtoken.impl.lang.ParameterReadable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.jsonwebtoken.security.EcPublicJwk createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext<java.security.interfaces.ECPublicKey> r6) {
        /*
            r5 = this;
            io.jsonwebtoken.impl.lang.RequiredParameterReader r0 = new io.jsonwebtoken.impl.lang.RequiredParameterReader
            r0.<init>((io.jsonwebtoken.impl.lang.ParameterReadable) r6)
            io.jsonwebtoken.impl.lang.Parameter<java.lang.String> r1 = io.jsonwebtoken.impl.security.DefaultEcPublicJwk.CRV
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r2 = io.jsonwebtoken.impl.security.DefaultEcPublicJwk.X
            java.lang.Object r2 = r0.get(r2)
            java.math.BigInteger r2 = (java.math.BigInteger) r2
            io.jsonwebtoken.impl.lang.Parameter<java.math.BigInteger> r3 = io.jsonwebtoken.impl.security.DefaultEcPublicJwk.Y
            java.lang.Object r0 = r0.get(r3)
            java.math.BigInteger r0 = (java.math.BigInteger) r0
            io.jsonwebtoken.impl.security.ECCurve r3 = io.jsonwebtoken.impl.security.AbstractEcJwkFactory.getCurveByJwaId(r1)
            java.security.spec.ECPoint r4 = new java.security.spec.ECPoint
            r4.<init>(r2, r0)
            boolean r0 = r3.contains((java.security.spec.ECPoint) r4)
            if (r0 == 0) goto L_0x0049
            java.security.spec.ECPublicKeySpec r0 = new java.security.spec.ECPublicKeySpec
            java.security.spec.ECParameterSpec r1 = r3.toParameterSpec()
            r0.<init>(r4, r1)
            io.jsonwebtoken.impl.security.EcPublicJwkFactory$1 r1 = new io.jsonwebtoken.impl.security.EcPublicJwkFactory$1
            r1.<init>(r0)
            java.security.Key r0 = r5.generateKey(r6, r1)
            java.security.interfaces.ECPublicKey r0 = (java.security.interfaces.ECPublicKey) r0
            r6.setKey(r0)
            io.jsonwebtoken.impl.security.DefaultEcPublicJwk r0 = new io.jsonwebtoken.impl.security.DefaultEcPublicJwk
            r0.<init>(r6)
            return r0
        L_0x0049:
            java.lang.String r6 = jwkContainsErrorMessage(r1, r6)
            io.jsonwebtoken.security.InvalidKeyException r0 = new io.jsonwebtoken.security.InvalidKeyException
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.EcPublicJwkFactory.createJwkFromValues(io.jsonwebtoken.impl.security.JwkContext):io.jsonwebtoken.security.EcPublicJwk");
    }
}
