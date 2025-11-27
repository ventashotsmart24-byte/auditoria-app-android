package io.jsonwebtoken.impl;

import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import io.jsonwebtoken.impl.lang.JwtDateConverter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Registry;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class DefaultClaims extends ParameterMap implements Claims {
    static final Parameter<Set<String>> AUDIENCE;
    private static final String CONVERSION_ERROR_MSG = "Cannot convert existing claim value of type '%s' to desired type '%s'. JJWT only converts simple String, Date, Long, Integer, Short and Byte types automatically. Anything more complex is expected to be already converted to your desired type by the JSON Deserializer implementation. You may specify a custom Deserializer for a JwtParser with the desired conversion configuration via the JwtParserBuilder.deserializer() method. See https://github.com/jwtk/jjwt#custom-json-processor for more information. If using Jackson, you can specify custom claim POJO types as described in https://github.com/jwtk/jjwt#json-jackson-custom-types";
    static final Parameter<Date> EXPIRATION;
    static final Parameter<Date> ISSUED_AT;
    static final Parameter<String> ISSUER;
    static final Parameter<String> JTI;
    static final Parameter<Date> NOT_BEFORE;
    static final Registry<String, Parameter<?>> PARAMS;
    static final Parameter<String> SUBJECT;

    static {
        Parameter<String> string = Parameters.string(Claims.ISSUER, "Issuer");
        ISSUER = string;
        Parameter<String> string2 = Parameters.string(Claims.SUBJECT, "Subject");
        SUBJECT = string2;
        Parameter<Set<String>> stringSet = Parameters.stringSet(Claims.AUDIENCE, "Audience");
        AUDIENCE = stringSet;
        Parameter<Date> rfcDate = Parameters.rfcDate("exp", "Expiration Time");
        EXPIRATION = rfcDate;
        Parameter<Date> rfcDate2 = Parameters.rfcDate(Claims.NOT_BEFORE, "Not Before");
        NOT_BEFORE = rfcDate2;
        Parameter<Date> rfcDate3 = Parameters.rfcDate(Claims.ISSUED_AT, "Issued At");
        ISSUED_AT = rfcDate3;
        Parameter<String> string3 = Parameters.string(Claims.ID, "JWT ID");
        JTI = string3;
        PARAMS = Parameters.registry((Parameter<?>[]) new Parameter[]{string, string2, stringSet, rfcDate, rfcDate2, rfcDate3, string3});
    }

    public DefaultClaims() {
        super((Registry<String, ? extends Parameter<?>>) PARAMS);
    }

    private <T> T castClaimValue(String str, Object obj, Class<T> cls) {
        Class<Byte> cls2 = Byte.class;
        Class<Short> cls3 = Short.class;
        Class<Integer> cls4 = Integer.class;
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            long longValue = ((Number) obj).longValue();
            if (Long.class.equals(cls)) {
                obj = Long.valueOf(longValue);
            } else if (cls4.equals(cls) && -2147483648L <= longValue && longValue <= TTL.MAX_VALUE) {
                obj = Integer.valueOf((int) longValue);
            } else if (cls == cls3 && -32768 <= longValue && longValue <= 32767) {
                obj = Short.valueOf((short) ((int) longValue));
            } else if (cls == cls2 && -128 <= longValue && longValue <= 127) {
                obj = Byte.valueOf((byte) ((int) longValue));
            }
        }
        if ((obj instanceof Long) && (cls.equals(cls4) || cls.equals(cls3) || cls.equals(cls2))) {
            throw new RequiredTypeException("Claim '" + str + "' value is too large or too small to be represented as a " + cls.getName() + " instance (would cause numeric overflow).");
        } else if (cls.isInstance(obj)) {
            return cls.cast(obj);
        } else {
            throw new RequiredTypeException(String.format(CONVERSION_ERROR_MSG, new Object[]{obj.getClass(), cls}));
        }
    }

    public <T> T get(String str, Class<T> cls) {
        Assert.notNull(cls, "requiredType argument cannot be null.");
        Object obj = this.idiomaticValues.get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        Object obj2 = get((Object) str);
        if (obj2 == null) {
            return null;
        }
        if (Date.class.equals(cls)) {
            try {
                obj2 = JwtDateConverter.toDate(obj2);
            } catch (Exception e10) {
                throw new IllegalArgumentException("Cannot create Date from '" + str + "' value '" + obj2 + "'. Cause: " + e10.getMessage(), e10);
            }
        }
        return castClaimValue(str, obj2, cls);
    }

    public Set<String> getAudience() {
        return (Set) get(AUDIENCE);
    }

    public Date getExpiration() {
        return (Date) get(EXPIRATION);
    }

    public String getId() {
        return (String) get(JTI);
    }

    public Date getIssuedAt() {
        return (Date) get(ISSUED_AT);
    }

    public String getIssuer() {
        return (String) get(ISSUER);
    }

    public String getName() {
        return "JWT Claims";
    }

    public Date getNotBefore() {
        return (Date) get(NOT_BEFORE);
    }

    public String getSubject() {
        return (String) get(SUBJECT);
    }

    public DefaultClaims(ParameterMap parameterMap) {
        super(parameterMap.PARAMS, parameterMap);
    }

    public DefaultClaims(Map<String, ?> map) {
        super(PARAMS, map);
    }
}
