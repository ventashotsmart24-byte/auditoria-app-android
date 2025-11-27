package io.jsonwebtoken.io;

import java.io.OutputStream;

public interface Serializer<T> {
    void serialize(T t10, OutputStream outputStream);

    @Deprecated
    byte[] serialize(T t10);
}
