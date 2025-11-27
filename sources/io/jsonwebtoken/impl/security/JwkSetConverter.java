package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkSet;
import io.jsonwebtoken.security.KeyException;
import io.jsonwebtoken.security.MalformedKeySetException;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class JwkSetConverter implements Converter<JwkSet, Object> {
    private final Converter<Jwk<?>, Object> JWK_CONVERTER;
    private final Parameter<Set<Jwk<?>>> PARAM;
    private final boolean ignoreUnsupported;

    public JwkSetConverter() {
        this((Supplier<DynamicJwkBuilder<?, ?>>) JwkBuilderSupplier.DEFAULT, true);
    }

    public Object applyTo(JwkSet jwkSet) {
        return jwkSet;
    }

    public boolean isIgnoreUnsupported() {
        return this.ignoreUnsupported;
    }

    public JwkSetConverter(boolean z10) {
        this((Supplier<DynamicJwkBuilder<?, ?>>) JwkBuilderSupplier.DEFAULT, z10);
    }

    public JwkSet applyFrom(Object obj) {
        Assert.notNull(obj, "Value cannot be null.");
        if (obj instanceof JwkSet) {
            return (JwkSet) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Map immutable = Collections.immutable(map);
            if (Collections.isEmpty((Map<?, ?>) immutable) || !immutable.containsKey(this.PARAM.getId())) {
                throw new MalformedKeySetException("Missing required " + this.PARAM + " parameter.");
            }
            Object obj2 = immutable.get(this.PARAM.getId());
            if (obj2 != null) {
                if (obj2 instanceof Supplier) {
                    obj2 = ((Supplier) obj2).get();
                }
                if (obj2 instanceof Collection) {
                    Collection<Object> collection = (Collection) obj2;
                    int size = Collections.size((Collection<?>) collection);
                    if (size != 0) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(Collections.size((Map<?, ?>) map));
                        for (Map.Entry entry : map.entrySet()) {
                            Object notNull = Assert.notNull(entry.getKey(), "JWK Set map key cannot be null.");
                            if (notNull instanceof String) {
                                linkedHashMap.put((String) notNull, entry.getValue());
                            } else {
                                throw new IllegalArgumentException("JWK Set map keys must be Strings. Encountered key '" + notNull + "' of type " + notNull.getClass().getName());
                            }
                        }
                        LinkedHashSet linkedHashSet = new LinkedHashSet(size);
                        int i10 = 0;
                        for (Object applyFrom : collection) {
                            try {
                                linkedHashSet.add(this.JWK_CONVERTER.applyFrom(applyFrom));
                            } catch (UnsupportedKeyException e10) {
                                if (!this.ignoreUnsupported) {
                                    throw new UnsupportedKeyException("JWK Set keys[" + i10 + "]: " + e10.getMessage(), e10);
                                }
                            } catch (KeyException | IllegalArgumentException e11) {
                                if (!this.ignoreUnsupported) {
                                    throw new MalformedKeySetException("JWK Set keys[" + i10 + "]: " + e11.getMessage(), e11);
                                }
                            }
                            i10++;
                        }
                        linkedHashMap.remove(this.PARAM.getId());
                        linkedHashMap.put(this.PARAM.getId(), linkedHashSet);
                        return new DefaultJwkSet(this.PARAM, linkedHashMap);
                    }
                    throw new MalformedKeySetException("JWK Set " + this.PARAM + " collection cannot be empty.");
                }
                throw new MalformedKeySetException("JWK Set " + this.PARAM + " value must be a Collection (JSON Array). Type found: " + obj2.getClass().getName());
            }
            throw new MalformedKeySetException("JWK Set " + this.PARAM + " value cannot be null.");
        }
        throw new IllegalArgumentException("Value must be a Map<String,?> (JSON Object). Type found: " + obj.getClass().getName() + ".");
    }

    public JwkSetConverter(Supplier<DynamicJwkBuilder<?, ?>> supplier, boolean z10) {
        this((Converter<Jwk<?>, Object>) new JwkConverter(supplier), z10);
    }

    public JwkSetConverter(Converter<Jwk<?>, Object> converter, boolean z10) {
        this.JWK_CONVERTER = (Converter) Assert.notNull(converter, "JWK converter cannot be null.");
        this.PARAM = DefaultJwkSet.param(converter);
        this.ignoreUnsupported = z10;
    }
}
