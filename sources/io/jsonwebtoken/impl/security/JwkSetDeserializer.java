package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.JsonObjectDeserializer;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.security.MalformedKeySetException;

public class JwkSetDeserializer extends JsonObjectDeserializer {
    public JwkSetDeserializer(Deserializer<?> deserializer) {
        super(deserializer, "JWK Set");
    }

    public RuntimeException malformed(Throwable th) {
        throw new MalformedKeySetException("Malformed JWK Set JSON: " + th.getMessage(), th);
    }
}
