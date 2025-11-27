package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Nameable;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.EcPrivateJwk;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.OctetPrivateJwk;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.RsaPrivateJwk;
import io.jsonwebtoken.security.RsaPublicJwk;
import io.jsonwebtoken.security.SecretJwk;
import java.util.Map;

public final class JwkConverter<T extends Jwk<?>> implements Converter<T, Object> {
    public static final JwkConverter<Jwk<?>> ANY;
    public static final Class<Jwk<?>> JWK_CLASS;
    public static final JwkConverter<PublicJwk<?>> PUBLIC_JWK;
    public static final Class<PublicJwk<?>> PUBLIC_JWK_CLASS;
    private final Class<T> desiredType;
    private final Supplier<DynamicJwkBuilder<?, ?>> supplier;

    static {
        Class<Jwk> cls = Jwk.class;
        JWK_CLASS = cls;
        Class<PublicJwk> cls2 = PublicJwk.class;
        PUBLIC_JWK_CLASS = cls2;
        ANY = new JwkConverter<>(cls);
        PUBLIC_JWK = new JwkConverter<>(cls2);
    }

    public JwkConverter(Class<T> cls) {
        this(cls, JwkBuilderSupplier.DEFAULT);
    }

    private static String articleFor(String str) {
        char charAt = str.charAt(0);
        if (charAt == 'E' || charAt == 'R') {
            return "an";
        }
        return "a";
    }

    private static String typeString(Jwk<?> jwk) {
        Assert.isInstanceOf(Nameable.class, jwk, "All JWK implementations must implement Nameable.");
        return ((Nameable) jwk).getName();
    }

    private IllegalArgumentException unexpectedIAE(Jwk<?> jwk) {
        String typeString = typeString((Class<?>) this.desiredType);
        String typeString2 = typeString(jwk);
        return new IllegalArgumentException("Value must be " + articleFor(typeString) + " " + typeString + ", not " + articleFor(typeString2) + " " + typeString2 + ".");
    }

    public JwkConverter(Supplier<DynamicJwkBuilder<?, ?>> supplier2) {
        this(JWK_CLASS, supplier2);
    }

    public T applyFrom(Object obj) {
        Assert.notNull(obj, "JWK cannot be null.");
        if (this.desiredType.isInstance(obj)) {
            return (Jwk) this.desiredType.cast(obj);
        }
        if (obj instanceof Jwk) {
            throw unexpectedIAE((Jwk) obj);
        } else if (obj instanceof Map) {
            Map immutable = Collections.immutable((Map) obj);
            Parameter<String> parameter = AbstractJwk.KTY;
            if (Collections.isEmpty((Map<?, ?>) immutable) || !immutable.containsKey(parameter.getId())) {
                throw new MalformedKeyException("JWK is missing required " + parameter + " parameter.");
            }
            Object obj2 = immutable.get(parameter.getId());
            if (obj2 == null) {
                throw new MalformedKeyException("JWK " + parameter + " value cannot be null.");
            } else if (!(obj2 instanceof String)) {
                throw new MalformedKeyException("JWK " + parameter + " value must be a String. Type found: " + obj2.getClass().getName());
            } else if (Strings.hasText((String) obj2)) {
                DynamicJwkBuilder dynamicJwkBuilder = this.supplier.get();
                for (Map.Entry entry : immutable.entrySet()) {
                    Object key = entry.getKey();
                    Assert.notNull(key, "JWK map key cannot be null.");
                    if (key instanceof String) {
                        dynamicJwkBuilder.add((String) key, entry.getValue());
                    } else {
                        throw new IllegalArgumentException("JWK map keys must be Strings. Encountered key '" + key + "' of type " + key.getClass().getName() + ".");
                    }
                }
                Jwk jwk = (Jwk) dynamicJwkBuilder.build();
                if (this.desiredType.isInstance(jwk)) {
                    return (Jwk) this.desiredType.cast(jwk);
                }
                throw unexpectedIAE(jwk);
            } else {
                throw new MalformedKeyException("JWK " + parameter + " value cannot be empty.");
            }
        } else {
            throw new IllegalArgumentException("JWK must be a Map<String,?> (JSON Object). Type found: " + obj.getClass().getName() + ".");
        }
    }

    public Object applyTo(T t10) {
        return this.desiredType.cast(t10);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object, io.jsonwebtoken.lang.Supplier<io.jsonwebtoken.security.DynamicJwkBuilder<?, ?>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JwkConverter(java.lang.Class<T> r2, io.jsonwebtoken.lang.Supplier<io.jsonwebtoken.security.DynamicJwkBuilder<?, ?>> r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "desiredType cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            java.lang.Class r2 = (java.lang.Class) r2
            r1.desiredType = r2
            java.lang.String r2 = "supplier cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r3, r2)
            io.jsonwebtoken.lang.Supplier r2 = (io.jsonwebtoken.lang.Supplier) r2
            r1.supplier = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.JwkConverter.<init>(java.lang.Class, io.jsonwebtoken.lang.Supplier):void");
    }

    private static String typeString(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        if (SecretJwk.class.isAssignableFrom(cls)) {
            sb.append("Secret");
        } else if (RsaPublicJwk.class.isAssignableFrom(cls) || RsaPrivateJwk.class.isAssignableFrom(cls)) {
            sb.append("RSA");
        } else if (EcPublicJwk.class.isAssignableFrom(cls) || EcPrivateJwk.class.isAssignableFrom(cls)) {
            sb.append("EC");
        } else if (OctetPublicJwk.class.isAssignableFrom(cls) || OctetPrivateJwk.class.isAssignableFrom(cls)) {
            sb.append("Edwards Curve");
        }
        return typeString(sb, cls);
    }

    private static String typeString(StringBuilder sb, Class<?> cls) {
        if (PublicJwk.class.isAssignableFrom(cls)) {
            Strings.nespace(sb).append("Public");
        } else if (PrivateJwk.class.isAssignableFrom(cls)) {
            Strings.nespace(sb).append("Private");
        }
        Strings.nespace(sb).append("JWK");
        return sb.toString();
    }
}
