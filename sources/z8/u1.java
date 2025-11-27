package z8;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import y8.n0;

public abstract class u1 {

    /* renamed from: a  reason: collision with root package name */
    public static final t1 f20991a = new c(new byte[0]);

    public class a extends n0 {
        public a(t1 t1Var) {
            super(t1Var);
        }

        public void close() {
        }
    }

    public static class c extends c {

        /* renamed from: a  reason: collision with root package name */
        public int f20993a;

        /* renamed from: b  reason: collision with root package name */
        public final int f20994b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f20995c;

        /* renamed from: d  reason: collision with root package name */
        public int f20996d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public void C(byte[] bArr, int i10, int i11) {
            System.arraycopy(this.f20995c, this.f20993a, bArr, i10, i11);
            this.f20993a += i11;
        }

        public void D() {
            this.f20996d = this.f20993a;
        }

        public void H(OutputStream outputStream, int i10) {
            a(i10);
            outputStream.write(this.f20995c, this.f20993a, i10);
            this.f20993a += i10;
        }

        /* renamed from: b */
        public c j(int i10) {
            a(i10);
            int i11 = this.f20993a;
            this.f20993a = i11 + i10;
            return new c(this.f20995c, i11, i10);
        }

        public int h() {
            return this.f20994b - this.f20993a;
        }

        public boolean markSupported() {
            return true;
        }

        public void r(ByteBuffer byteBuffer) {
            Preconditions.checkNotNull(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            a(remaining);
            byteBuffer.put(this.f20995c, this.f20993a, remaining);
            this.f20993a += remaining;
        }

        public int readUnsignedByte() {
            a(1);
            byte[] bArr = this.f20995c;
            int i10 = this.f20993a;
            this.f20993a = i10 + 1;
            return bArr[i10] & UnsignedBytes.MAX_VALUE;
        }

        public void reset() {
            int i10 = this.f20996d;
            if (i10 != -1) {
                this.f20993a = i10;
                return;
            }
            throw new InvalidMarkException();
        }

        public void skipBytes(int i10) {
            a(i10);
            this.f20993a += i10;
        }

        public c(byte[] bArr, int i10, int i11) {
            this.f20996d = -1;
            boolean z10 = true;
            Preconditions.checkArgument(i10 >= 0, "offset must be >= 0");
            Preconditions.checkArgument(i11 >= 0, "length must be >= 0");
            int i12 = i11 + i10;
            Preconditions.checkArgument(i12 > bArr.length ? false : z10, "offset + length exceeds array boundary");
            this.f20995c = (byte[]) Preconditions.checkNotNull(bArr, HTTP.CONTENT_RANGE_BYTES);
            this.f20993a = i10;
            this.f20994b = i12;
        }
    }

    public static t1 a() {
        return f20991a;
    }

    public static t1 b(t1 t1Var) {
        return new a(t1Var);
    }

    public static InputStream c(t1 t1Var, boolean z10) {
        if (!z10) {
            t1Var = b(t1Var);
        }
        return new b(t1Var);
    }

    public static byte[] d(t1 t1Var) {
        Preconditions.checkNotNull(t1Var, "buffer");
        int h10 = t1Var.h();
        byte[] bArr = new byte[h10];
        t1Var.C(bArr, 0, h10);
        return bArr;
    }

    public static String e(t1 t1Var, Charset charset) {
        Preconditions.checkNotNull(charset, HTTP.CHARSET);
        return new String(d(t1Var), charset);
    }

    public static t1 f(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static final class b extends InputStream implements n0 {

        /* renamed from: a  reason: collision with root package name */
        public t1 f20992a;

        public b(t1 t1Var) {
            this.f20992a = (t1) Preconditions.checkNotNull(t1Var, "buffer");
        }

        public int available() {
            return this.f20992a.h();
        }

        public void close() {
            this.f20992a.close();
        }

        public void mark(int i10) {
            this.f20992a.D();
        }

        public boolean markSupported() {
            return this.f20992a.markSupported();
        }

        public int read() {
            if (this.f20992a.h() == 0) {
                return -1;
            }
            return this.f20992a.readUnsignedByte();
        }

        public void reset() {
            this.f20992a.reset();
        }

        public long skip(long j10) {
            int min = (int) Math.min((long) this.f20992a.h(), j10);
            this.f20992a.skipBytes(min);
            return (long) min;
        }

        public int read(byte[] bArr, int i10, int i11) {
            if (this.f20992a.h() == 0) {
                return -1;
            }
            int min = Math.min(this.f20992a.h(), i11);
            this.f20992a.C(bArr, i10, min);
            return min;
        }
    }
}
