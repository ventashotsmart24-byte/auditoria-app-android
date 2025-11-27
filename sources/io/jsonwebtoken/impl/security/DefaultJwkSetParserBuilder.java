package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.ConvertingParser;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.JwkSet;
import io.jsonwebtoken.security.JwkSetParserBuilder;

public class DefaultJwkSetParserBuilder extends AbstractJwkParserBuilder<JwkSet, JwkSetParserBuilder> implements JwkSetParserBuilder {
    private boolean ignoreUnsupported = true;

    public Parser<JwkSet> doBuild() {
        return new ConvertingParser(new JwkSetDeserializer(this.deserializer), new JwkSetConverter((Supplier<DynamicJwkBuilder<?, ?>>) new JwkBuilderSupplier(this.provider, this.operationPolicy), this.ignoreUnsupported));
    }

    public JwkSetParserBuilder ignoreUnsupported(boolean z10) {
        this.ignoreUnsupported = z10;
        return this;
    }
}
