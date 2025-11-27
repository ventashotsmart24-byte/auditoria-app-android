package com.hpplay.glide.load.resource.bytes;

import com.hpplay.glide.load.engine.Resource;

public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        if (bArr != null) {
            this.bytes = bArr;
            return;
        }
        throw new NullPointerException("Bytes must not be null");
    }

    public int getSize() {
        return this.bytes.length;
    }

    public void recycle() {
    }

    public byte[] get() {
        return this.bytes;
    }
}
