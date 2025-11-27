package io.jsonwebtoken;

@Deprecated
public interface CompressionCodecResolver {
    CompressionCodec resolveCompressionCodec(Header header);
}
