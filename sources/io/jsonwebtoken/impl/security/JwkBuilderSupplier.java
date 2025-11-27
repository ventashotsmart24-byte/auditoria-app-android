package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperationPolicy;
import java.security.Provider;

public class JwkBuilderSupplier implements Supplier<DynamicJwkBuilder<?, ?>> {
    public static final JwkBuilderSupplier DEFAULT = new JwkBuilderSupplier((Provider) null, (KeyOperationPolicy) null);
    private final KeyOperationPolicy operationPolicy;
    private final Provider provider;

    public JwkBuilderSupplier(Provider provider2, KeyOperationPolicy keyOperationPolicy) {
        this.provider = provider2;
        this.operationPolicy = keyOperationPolicy;
    }

    public DynamicJwkBuilder<?, ?> get() {
        DynamicJwkBuilder<?, ?> dynamicJwkBuilder = (DynamicJwkBuilder) Jwks.builder().provider(this.provider);
        KeyOperationPolicy keyOperationPolicy = this.operationPolicy;
        if (keyOperationPolicy != null) {
            dynamicJwkBuilder.operationPolicy(keyOperationPolicy);
        }
        return dynamicJwkBuilder;
    }
}
