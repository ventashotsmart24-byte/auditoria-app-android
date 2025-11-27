package io.jsonwebtoken.impl.io;

import java.io.InputStream;

public class Base64InputStream extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public /* bridge */ /* synthetic */ int available() {
        return super.available();
    }

    public /* bridge */ /* synthetic */ boolean isStrictDecoding() {
        return super.isStrictDecoding();
    }

    public /* bridge */ /* synthetic */ void mark(int i10) {
        super.mark(i10);
    }

    public /* bridge */ /* synthetic */ boolean markSupported() {
        return super.markSupported();
    }

    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    public /* bridge */ /* synthetic */ long skip(long j10) {
        return super.skip(j10);
    }

    public Base64InputStream(InputStream inputStream, boolean z10) {
        super(inputStream, new Base64Codec(0, BaseNCodec.CHUNK_SEPARATOR, false, CodecPolicy.STRICT), z10);
    }

    public /* bridge */ /* synthetic */ int read(byte[] bArr, int i10, int i11) {
        return super.read(bArr, i10, i11);
    }
}
