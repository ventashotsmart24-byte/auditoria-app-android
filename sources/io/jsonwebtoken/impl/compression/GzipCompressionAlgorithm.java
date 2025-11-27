package io.jsonwebtoken.impl.compression;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressionAlgorithm extends AbstractCompressionAlgorithm {
    private static final String ID = "GZIP";

    public GzipCompressionAlgorithm() {
        super(ID);
    }

    public OutputStream doCompress(OutputStream outputStream) {
        return new GZIPOutputStream(outputStream);
    }

    public InputStream doDecompress(InputStream inputStream) {
        return new GZIPInputStream(inputStream);
    }
}
