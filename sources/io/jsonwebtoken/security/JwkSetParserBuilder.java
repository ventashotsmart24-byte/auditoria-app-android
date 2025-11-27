package io.jsonwebtoken.security;

import io.jsonwebtoken.io.ParserBuilder;

public interface JwkSetParserBuilder extends ParserBuilder<JwkSet, JwkSetParserBuilder>, KeyOperationPolicied<JwkSetParserBuilder> {
    JwkSetParserBuilder ignoreUnsupported(boolean z10);
}
