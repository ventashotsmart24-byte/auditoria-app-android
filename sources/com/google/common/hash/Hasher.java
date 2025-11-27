package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    Hasher putBoolean(boolean z10);

    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z10);

    Hasher putByte(byte b10);

    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b10);

    Hasher putBytes(ByteBuffer byteBuffer);

    Hasher putBytes(byte[] bArr);

    Hasher putBytes(byte[] bArr, int i10, int i11);

    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i10, int i11);

    Hasher putChar(char c10);

    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c10);

    Hasher putDouble(double d10);

    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d10);

    Hasher putFloat(float f10);

    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f10);

    Hasher putInt(int i10);

    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i10);

    Hasher putLong(long j10);

    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j10);

    <T> Hasher putObject(@ParametricNullness T t10, Funnel<? super T> funnel);

    Hasher putShort(short s10);

    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s10);

    Hasher putString(CharSequence charSequence, Charset charset);

    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    Hasher putUnencodedChars(CharSequence charSequence);

    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
