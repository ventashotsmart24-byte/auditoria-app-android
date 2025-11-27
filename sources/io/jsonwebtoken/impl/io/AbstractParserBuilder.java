package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.io.ParserBuilder;
import java.security.Provider;
import java.util.Map;

public abstract class AbstractParserBuilder<T, B extends ParserBuilder<T, B>> implements ParserBuilder<T, B> {
    protected Deserializer<Map<String, ?>> deserializer;
    protected Provider provider;

    public abstract Parser<T> doBuild();

    public B json(Deserializer<Map<String, ?>> deserializer2) {
        this.deserializer = deserializer2;
        return self();
    }

    public B provider(Provider provider2) {
        this.provider = provider2;
        return self();
    }

    public final B self() {
        return this;
    }

    public final Parser<T> build() {
        if (this.deserializer == null) {
            this.deserializer = (Deserializer) Services.get(Deserializer.class);
        }
        return doBuild();
    }
}
