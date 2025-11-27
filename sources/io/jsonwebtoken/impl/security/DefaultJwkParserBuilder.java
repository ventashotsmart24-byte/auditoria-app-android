package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.ConvertingParser;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkParserBuilder;

public class DefaultJwkParserBuilder extends AbstractJwkParserBuilder<Jwk<?>, JwkParserBuilder> implements JwkParserBuilder {
    public Parser<Jwk<?>> doBuild() {
        return new ConvertingParser(new JwkDeserializer(this.deserializer), new JwkConverter((Supplier<DynamicJwkBuilder<?, ?>>) new JwkBuilderSupplier(this.provider, this.operationPolicy)));
    }
}
