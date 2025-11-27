package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInput;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public interface ByteArrayDataInput extends DataInput {
    @CanIgnoreReturnValue
    boolean readBoolean();

    @CanIgnoreReturnValue
    byte readByte();

    @CanIgnoreReturnValue
    char readChar();

    @CanIgnoreReturnValue
    double readDouble();

    @CanIgnoreReturnValue
    float readFloat();

    void readFully(byte[] bArr);

    void readFully(byte[] bArr, int i10, int i11);

    @CanIgnoreReturnValue
    int readInt();

    @CheckForNull
    @CanIgnoreReturnValue
    String readLine();

    @CanIgnoreReturnValue
    long readLong();

    @CanIgnoreReturnValue
    short readShort();

    @CanIgnoreReturnValue
    String readUTF();

    @CanIgnoreReturnValue
    int readUnsignedByte();

    @CanIgnoreReturnValue
    int readUnsignedShort();

    int skipBytes(int i10);
}
