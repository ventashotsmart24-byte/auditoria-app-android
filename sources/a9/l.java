package a9;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Buffer;
import z8.c;
import z8.t1;

public class l extends c {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f10880a;

    public l(Buffer buffer) {
        this.f10880a = buffer;
    }

    public void C(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            int read = this.f10880a.read(bArr, i10, i11);
            if (read != -1) {
                i11 -= read;
                i10 += read;
            } else {
                throw new IndexOutOfBoundsException("EOF trying to read " + i11 + " bytes");
            }
        }
    }

    public void H(OutputStream outputStream, int i10) {
        this.f10880a.writeTo(outputStream, (long) i10);
    }

    public final void b() {
    }

    public void close() {
        this.f10880a.clear();
    }

    public int h() {
        return (int) this.f10880a.size();
    }

    public t1 j(int i10) {
        Buffer buffer = new Buffer();
        buffer.write(this.f10880a, (long) i10);
        return new l(buffer);
    }

    public void r(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    public int readUnsignedByte() {
        try {
            b();
            return this.f10880a.readByte() & UnsignedBytes.MAX_VALUE;
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }

    public void skipBytes(int i10) {
        try {
            this.f10880a.skip((long) i10);
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }
}
