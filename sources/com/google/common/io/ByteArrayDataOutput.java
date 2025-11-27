package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    void write(int i10);

    void write(byte[] bArr);

    void write(byte[] bArr, int i10, int i11);

    void writeBoolean(boolean z10);

    void writeByte(int i10);

    @Deprecated
    void writeBytes(String str);

    void writeChar(int i10);

    void writeChars(String str);

    void writeDouble(double d10);

    void writeFloat(float f10);

    void writeInt(int i10);

    void writeLong(long j10);

    void writeShort(int i10);

    void writeUTF(String str);
}
