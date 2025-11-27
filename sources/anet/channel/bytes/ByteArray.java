package anet.channel.bytes;

import anet.channel.bytes.a;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArray implements Comparable<ByteArray> {
    final byte[] buffer;
    int bufferLength;
    int dataLength;

    private ByteArray(byte[] bArr, int i10) {
        bArr = bArr == null ? new byte[i10] : bArr;
        this.buffer = bArr;
        this.bufferLength = bArr.length;
        this.dataLength = i10;
    }

    public static ByteArray create(int i10) {
        return new ByteArray((byte[]) null, i10);
    }

    public static ByteArray wrap(byte[] bArr, int i10) {
        if (bArr == null || i10 < 0 || i10 > bArr.length) {
            return null;
        }
        return new ByteArray(bArr, i10);
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getBufferLength() {
        return this.bufferLength;
    }

    public int getDataLength() {
        return this.dataLength;
    }

    public int readFrom(InputStream inputStream) {
        int i10 = 0;
        int read = inputStream.read(this.buffer, 0, this.bufferLength);
        if (read != -1) {
            i10 = read;
        }
        this.dataLength = i10;
        return read;
    }

    public void recycle() {
        if (this.bufferLength != 0) {
            a.C0060a.f3631a.a(this);
        }
    }

    public void setDataLength(int i10) {
        this.dataLength = i10;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.buffer, 0, this.dataLength);
    }

    public int compareTo(ByteArray byteArray) {
        int i10 = this.bufferLength;
        int i11 = byteArray.bufferLength;
        if (i10 != i11) {
            return i10 - i11;
        }
        if (this.buffer == null) {
            return -1;
        }
        if (byteArray.buffer == null) {
            return 1;
        }
        return hashCode() - byteArray.hashCode();
    }

    public static ByteArray wrap(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return wrap(bArr, bArr.length);
    }
}
