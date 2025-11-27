package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
@CanIgnoreReturnValue
abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    public AbstractStreamingHasher(int i10) {
        this(i10, i10);
    }

    private void munch() {
        Java8Compatibility.flip(this.buffer);
        while (this.buffer.remaining() >= this.chunkSize) {
            process(this.buffer);
        }
        this.buffer.compact();
    }

    private void munchIfFull() {
        if (this.buffer.remaining() < 8) {
            munch();
        }
    }

    private Hasher putBytesInternal(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            munchIfFull();
            return this;
        }
        int position = this.bufferSize - this.buffer.position();
        for (int i10 = 0; i10 < position; i10++) {
            this.buffer.put(byteBuffer.get());
        }
        munch();
        while (byteBuffer.remaining() >= this.chunkSize) {
            process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }

    public final HashCode hash() {
        munch();
        Java8Compatibility.flip(this.buffer);
        if (this.buffer.remaining() > 0) {
            processRemaining(this.buffer);
            ByteBuffer byteBuffer = this.buffer;
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        }
        return makeHash();
    }

    public abstract HashCode makeHash();

    public abstract void process(ByteBuffer byteBuffer);

    public void processRemaining(ByteBuffer byteBuffer) {
        Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        Java8Compatibility.limit(byteBuffer, this.chunkSize + 7);
        while (true) {
            int position = byteBuffer.position();
            int i10 = this.chunkSize;
            if (position < i10) {
                byteBuffer.putLong(0);
            } else {
                Java8Compatibility.limit(byteBuffer, i10);
                Java8Compatibility.flip(byteBuffer);
                process(byteBuffer);
                return;
            }
        }
    }

    public AbstractStreamingHasher(int i10, int i11) {
        Preconditions.checkArgument(i11 % i10 == 0);
        this.buffer = ByteBuffer.allocate(i11 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = i11;
        this.chunkSize = i10;
    }

    public final Hasher putByte(byte b10) {
        this.buffer.put(b10);
        munchIfFull();
        return this;
    }

    public final Hasher putChar(char c10) {
        this.buffer.putChar(c10);
        munchIfFull();
        return this;
    }

    public final Hasher putInt(int i10) {
        this.buffer.putInt(i10);
        munchIfFull();
        return this;
    }

    public final Hasher putLong(long j10) {
        this.buffer.putLong(j10);
        munchIfFull();
        return this;
    }

    public final Hasher putShort(short s10) {
        this.buffer.putShort(s10);
        munchIfFull();
        return this;
    }

    public final Hasher putBytes(byte[] bArr, int i10, int i11) {
        return putBytesInternal(ByteBuffer.wrap(bArr, i10, i11).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* JADX INFO: finally extract failed */
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            Hasher putBytesInternal = putBytesInternal(byteBuffer);
            byteBuffer.order(order);
            return putBytesInternal;
        } catch (Throwable th) {
            byteBuffer.order(order);
            throw th;
        }
    }
}
