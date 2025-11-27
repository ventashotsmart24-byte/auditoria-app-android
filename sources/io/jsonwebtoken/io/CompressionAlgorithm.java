package io.jsonwebtoken.io;

import io.jsonwebtoken.Identifiable;
import java.io.InputStream;
import java.io.OutputStream;

public interface CompressionAlgorithm extends Identifiable {
    OutputStream compress(OutputStream outputStream);

    InputStream decompress(InputStream inputStream);
}
