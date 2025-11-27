package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.net.URI;

public class UriStringConverter implements Converter<URI, CharSequence> {
    public URI applyFrom(CharSequence charSequence) {
        Assert.hasText(charSequence, "URI string cannot be null or empty.");
        try {
            return URI.create(charSequence.toString());
        } catch (Exception e10) {
            throw new IllegalArgumentException("Unable to convert String value '" + charSequence + "' to URI instance: " + e10.getMessage(), e10);
        }
    }

    public String applyTo(URI uri) {
        Assert.notNull(uri, "URI cannot be null.");
        return uri.toString();
    }
}
