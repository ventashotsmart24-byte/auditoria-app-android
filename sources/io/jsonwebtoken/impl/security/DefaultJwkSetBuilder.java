package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.ParameterMap;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkSet;
import io.jsonwebtoken.security.JwkSetBuilder;
import io.jsonwebtoken.security.KeyOperationPolicy;
import java.security.Provider;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DefaultJwkSetBuilder extends AbstractSecurityBuilder<JwkSet, JwkSetBuilder> implements JwkSetBuilder {
    private JwkSetConverter converter = new JwkSetConverter();
    private ParameterMap map = new ParameterMap((Registry<String, ? extends Parameter<?>>) Parameters.registry((Parameter<?>[]) new Parameter[]{DefaultJwkSet.KEYS}));
    private KeyOperationPolicy operationPolicy = AbstractJwkBuilder.DEFAULT_OPERATION_POLICY;

    private JwkSetBuilder refresh() {
        JwkConverter jwkConverter = new JwkConverter((Supplier<DynamicJwkBuilder<?, ?>>) new JwkBuilderSupplier(this.provider, this.operationPolicy));
        this.converter = new JwkSetConverter((Converter<Jwk<?>, Object>) jwkConverter, this.converter.isIgnoreUnsupported());
        Parameter param = DefaultJwkSet.param(jwkConverter);
        ParameterMap parameterMap = new ParameterMap(Parameters.registry((Parameter<?>[]) new Parameter[]{param}), this.map, true);
        this.map = parameterMap;
        Set<Jwk> set = (Set) parameterMap.get(param);
        if (!Collections.isEmpty((Collection<?>) set)) {
            for (Jwk operations : set) {
                this.operationPolicy.validate(operations.getOperations());
            }
        }
        return this;
    }

    public Collection<Jwk<?>> ensureKeys() {
        Collection<Jwk<?>> collection = (Collection) this.map.get(DefaultJwkSet.KEYS);
        if (Collections.isEmpty((Collection<?>) collection)) {
            return new LinkedHashSet();
        }
        return collection;
    }

    public JwkSetBuilder keys(Collection<Jwk<?>> collection) {
        return add(DefaultJwkSet.KEYS.getId(), (Object) collection);
    }

    public JwkSet build() {
        return this.converter.applyFrom((Object) this.map);
    }

    public JwkSetBuilder delete(String str) {
        this.map.remove(str);
        return this;
    }

    public JwkSetBuilder empty() {
        this.map.clear();
        return this;
    }

    public JwkSetBuilder operationPolicy(KeyOperationPolicy keyOperationPolicy) {
        if (keyOperationPolicy == null) {
            keyOperationPolicy = AbstractJwkBuilder.DEFAULT_OPERATION_POLICY;
        }
        this.operationPolicy = keyOperationPolicy;
        return refresh();
    }

    public JwkSetBuilder provider(Provider provider) {
        super.provider(provider);
        return refresh();
    }

    public JwkSetBuilder add(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public JwkSetBuilder add(Map<? extends String, ?> map2) {
        this.map.putAll(map2);
        return this;
    }

    public JwkSetBuilder add(Jwk<?> jwk) {
        if (jwk != null) {
            this.operationPolicy.validate(jwk.getOperations());
            Collection<Jwk<?>> ensureKeys = ensureKeys();
            ensureKeys.add(jwk);
            keys(ensureKeys);
        }
        return this;
    }

    public JwkSetBuilder add(Collection<Jwk<?>> collection) {
        if (!Collections.isEmpty((Collection<?>) collection)) {
            for (Jwk<?> add : collection) {
                add(add);
            }
        }
        return this;
    }
}
