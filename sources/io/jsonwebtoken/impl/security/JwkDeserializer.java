package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.JsonObjectDeserializer;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.security.MalformedKeyException;

public class JwkDeserializer extends JsonObjectDeserializer {
    public JwkDeserializer(Deserializer<?> deserializer) {
        super(deserializer, "JWK");
    }

    public RuntimeException malformed(Throwable th) {
        return new MalformedKeyException("Malformed JWK JSON: " + th.getMessage());
    }
}
