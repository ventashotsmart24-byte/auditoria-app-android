package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@CanIgnoreReturnValue
abstract class AbstractHasher implements Hasher {
    public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b10) {
        return putByte(b10);
    }

    public <T> Hasher putObject(@ParametricNullness T t10, Funnel<? super T> funnel) {
        funnel.funnel(t10, this);
        return this;
    }

    public final Hasher putBoolean(boolean z10) {
        return putByte(z10 ? (byte) 1 : 0);
    }

    public Hasher putChar(char c10) {
        putByte((byte) c10);
        putByte((byte) (c10 >>> 8));
        return this;
    }

    public final Hasher putDouble(double d10) {
        return putLong(Double.doubleToRawLongBits(d10));
    }

    public final Hasher putFloat(float f10) {
        return putInt(Float.floatToRawIntBits(f10));
    }

    public Hasher putInt(int i10) {
        putByte((byte) i10);
        putByte((byte) (i10 >>> 8));
        putByte((byte) (i10 >>> 16));
        putByte((byte) (i10 >>> 24));
        return this;
    }

    public Hasher putLong(long j10) {
        for (int i10 = 0; i10 < 64; i10 += 8) {
            putByte((byte) ((int) (j10 >>> i10)));
        }
        return this;
    }

    public Hasher putShort(short s10) {
        putByte((byte) s10);
        putByte((byte) (s10 >>> 8));
        return this;
    }

    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            putChar(charSequence.charAt(i10));
        }
        return this;
    }

    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    public Hasher putBytes(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        for (int i12 = 0; i12 < i11; i12++) {
            putByte(bArr[i10 + i12]);
        }
        return this;
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                putByte(byteBuffer.get());
            }
        }
        return this;
    }
}
