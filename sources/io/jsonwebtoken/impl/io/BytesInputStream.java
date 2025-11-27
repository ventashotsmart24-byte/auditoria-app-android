package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import java.io.ByteArrayInputStream;

public final class BytesInputStream extends ByteArrayInputStream {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BytesInputStream(byte[] bArr) {
        super(Bytes.isEmpty(bArr) ? Bytes.EMPTY : bArr);
    }

    public void close() {
        reset();
    }

    public byte[] getBytes() {
        return this.buf;
    }
}
