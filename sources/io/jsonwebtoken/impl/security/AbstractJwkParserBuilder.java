package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.AbstractParserBuilder;
import io.jsonwebtoken.io.ParserBuilder;
import io.jsonwebtoken.security.KeyOperationPolicied;
import io.jsonwebtoken.security.KeyOperationPolicy;

abstract class AbstractJwkParserBuilder<T, B extends ParserBuilder<T, B> & KeyOperationPolicied<B>> extends AbstractParserBuilder<T, B> implements KeyOperationPolicied<B> {
    protected KeyOperationPolicy operationPolicy = AbstractJwkBuilder.DEFAULT_OPERATION_POLICY;

    public B operationPolicy(KeyOperationPolicy keyOperationPolicy) {
        this.operationPolicy = keyOperationPolicy;
        return self();
    }
}
