package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.security.Key;
import java.util.Set;

public abstract class OctetJwkFactory<K extends Key, J extends Jwk<K>> extends AbstractFamilyJwkFactory<K, J> {
    public OctetJwkFactory(Class<K> cls, Set<Parameter<?>> set) {
        super("OKP", cls, set);
    }

    public static EdwardsCurve getCurve(ParameterReadable parameterReadable) {
        Parameter parameter = DefaultOctetPublicJwk.CRV;
        String str = (String) parameterReadable.get(parameter);
        EdwardsCurve findById = EdwardsCurve.findById(str);
        if (findById != null) {
            return findById;
        }
        throw new UnsupportedKeyException("Unrecognized OKP JWK " + parameter + " value '" + str + "'");
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ JwkContext newContext(JwkContext jwkContext, Key key) {
        return super.newContext(jwkContext, key);
    }

    public /* bridge */ /* synthetic */ boolean supports(JwkContext jwkContext) {
        return super.supports((JwkContext<?>) jwkContext);
    }

    public boolean supports(Key key) {
        return super.supports(key) && EdwardsCurve.isEdwards(key);
    }
}
