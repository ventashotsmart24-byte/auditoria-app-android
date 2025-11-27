package io.jsonwebtoken.impl;

import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.CompressionAlgorithm;
import io.jsonwebtoken.lang.Assert;

public class CompressionCodecLocator implements Function<Header, CompressionAlgorithm>, Locator<CompressionAlgorithm> {
    private final CompressionCodecResolver resolver;

    public CompressionCodecLocator(CompressionCodecResolver compressionCodecResolver) {
        this.resolver = (CompressionCodecResolver) Assert.notNull(compressionCodecResolver, "CompressionCodecResolver cannot be null.");
    }

    public CompressionAlgorithm apply(Header header) {
        return locate(header);
    }

    public CompressionAlgorithm locate(Header header) {
        return this.resolver.resolveCompressionCodec(header);
    }
}
