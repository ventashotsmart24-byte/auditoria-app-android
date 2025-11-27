package io.jsonwebtoken.io;

import java.io.Reader;

public interface Deserializer<T> {
    T deserialize(Reader reader);

    @Deprecated
    T deserialize(byte[] bArr);
}
