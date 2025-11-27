package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@Beta
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    public void close() {
        this.out.close();
    }

    public void write(byte[] bArr, int i10, int i11) {
        this.out.write(bArr, i10, i11);
    }

    public void writeBoolean(boolean z10) {
        ((DataOutputStream) this.out).writeBoolean(z10);
    }

    public void writeByte(int i10) {
        ((DataOutputStream) this.out).writeByte(i10);
    }

    @Deprecated
    public void writeBytes(String str) {
        ((DataOutputStream) this.out).writeBytes(str);
    }

    public void writeChar(int i10) {
        writeShort(i10);
    }

    public void writeChars(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            writeChar(str.charAt(i10));
        }
    }

    public void writeDouble(double d10) {
        writeLong(Double.doubleToLongBits(d10));
    }

    public void writeFloat(float f10) {
        writeInt(Float.floatToIntBits(f10));
    }

    public void writeInt(int i10) {
        this.out.write(i10 & 255);
        this.out.write((i10 >> 8) & 255);
        this.out.write((i10 >> 16) & 255);
        this.out.write((i10 >> 24) & 255);
    }

    public void writeLong(long j10) {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j10));
        write(byteArray, 0, byteArray.length);
    }

    public void writeShort(int i10) {
        this.out.write(i10 & 255);
        this.out.write((i10 >> 8) & 255);
    }

    public void writeUTF(String str) {
        ((DataOutputStream) this.out).writeUTF(str);
    }
}
