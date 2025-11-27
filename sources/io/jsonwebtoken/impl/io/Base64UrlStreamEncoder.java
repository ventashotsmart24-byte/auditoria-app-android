package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Encoder;
import java.io.OutputStream;

public final class Base64UrlStreamEncoder implements Encoder<OutputStream, OutputStream> {
    public static final Base64UrlStreamEncoder INSTANCE = new Base64UrlStreamEncoder();

    private Base64UrlStreamEncoder() {
    }

    public OutputStream encode(OutputStream outputStream) {
        return new Base64OutputStream(outputStream);
    }
}
