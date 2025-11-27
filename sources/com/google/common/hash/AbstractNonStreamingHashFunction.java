package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@Immutable
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {

    public final class BufferingHasher extends AbstractHasher {
        final ExposedByteArrayOutputStream stream;

        public BufferingHasher(int i10) {
            this.stream = new ExposedByteArrayOutputStream(i10);
        }

        public HashCode hash() {
            return AbstractNonStreamingHashFunction.this.hashBytes(this.stream.byteArray(), 0, this.stream.length());
        }

        public Hasher putByte(byte b10) {
            this.stream.write(b10);
            return this;
        }

        public Hasher putBytes(byte[] bArr, int i10, int i11) {
            this.stream.write(bArr, i10, i11);
            return this;
        }

        public Hasher putBytes(ByteBuffer byteBuffer) {
            this.stream.write(byteBuffer);
            return this;
        }
    }

    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream(int i10) {
            super(i10);
        }

        public byte[] byteArray() {
            return this.buf;
        }

        public int length() {
            return this.count;
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i10 = this.count;
            int i11 = i10 + remaining;
            byte[] bArr = this.buf;
            if (i11 > bArr.length) {
                this.buf = Arrays.copyOf(bArr, i10 + remaining);
            }
            byteBuffer.get(this.buf, this.count, remaining);
            this.count += remaining;
        }
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }

    public abstract HashCode hashBytes(byte[] bArr, int i10, int i11);

    public HashCode hashInt(int i10) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i10).array());
    }

    public HashCode hashLong(long j10) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j10).array());
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        ByteBuffer order = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i10 = 0; i10 < length; i10++) {
            order.putChar(charSequence.charAt(i10));
        }
        return hashBytes(order.array());
    }

    public Hasher newHasher() {
        return newHasher(32);
    }

    public Hasher newHasher(int i10) {
        Preconditions.checkArgument(i10 >= 0);
        return new BufferingHasher(i10);
    }
}
