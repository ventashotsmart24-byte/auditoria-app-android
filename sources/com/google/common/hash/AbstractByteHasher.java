package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
@CanIgnoreReturnValue
abstract class AbstractByteHasher extends AbstractHasher {
    private final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public abstract void update(byte b10);

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public Hasher putByte(byte b10) {
        update(b10);
        return this;
    }

    public Hasher putChar(char c10) {
        this.scratch.putChar(c10);
        return update(2);
    }

    public Hasher putInt(int i10) {
        this.scratch.putInt(i10);
        return update(4);
    }

    public Hasher putLong(long j10) {
        this.scratch.putLong(j10);
        return update(8);
    }

    public Hasher putShort(short s10) {
        this.scratch.putShort(s10);
        return update(2);
    }

    public void update(byte[] bArr, int i10, int i11) {
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            update(bArr[i12]);
        }
    }

    public void update(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            update(byteBuffer.get());
        }
    }

    public Hasher putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        update(bArr);
        return this;
    }

    public Hasher putBytes(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        update(bArr, i10, i11);
        return this;
    }

    private Hasher update(int i10) {
        try {
            update(this.scratch.array(), 0, i10);
            return this;
        } finally {
            Java8Compatibility.clear(this.scratch);
        }
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }
}
