package io.jsonwebtoken.io;

import io.jsonwebtoken.io.ParserBuilder;
import io.jsonwebtoken.lang.Builder;
import java.security.Provider;
import java.util.Map;

public interface ParserBuilder<T, B extends ParserBuilder<T, B>> extends Builder<Parser<T>> {
    B json(Deserializer<Map<String, ?>> deserializer);

    B provider(Provider provider);
}
