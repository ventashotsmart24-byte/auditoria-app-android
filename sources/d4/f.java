package d4;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class f extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f6259a;

    public f(ByteBuffer byteBuffer) {
        this.f6259a = byteBuffer;
    }

    public int available() {
        return this.f6259a.remaining();
    }

    public int read() {
        if (this.f6259a.hasRemaining()) {
            return this.f6259a.get() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    public int read(byte[] bArr, int i10, int i11) {
        if (!this.f6259a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i11, this.f6259a.remaining());
        this.f6259a.get(bArr, i10, min);
        return min;
    }
}
