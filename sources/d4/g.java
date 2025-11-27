package d4;

import java.io.OutputStream;
import java.nio.ByteBuffer;

public class g extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f6260a;

    public g(ByteBuffer byteBuffer) {
        this.f6260a = byteBuffer;
    }

    public void write(int i10) {
        this.f6260a.put((byte) i10);
    }

    public void write(byte[] bArr, int i10, int i11) {
        this.f6260a.put(bArr, i10, i11);
    }
}
