package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public abstract class n0 implements t1 {

    /* renamed from: a  reason: collision with root package name */
    public final t1 f20804a;

    public n0(t1 t1Var) {
        this.f20804a = (t1) Preconditions.checkNotNull(t1Var, "buf");
    }

    public void C(byte[] bArr, int i10, int i11) {
        this.f20804a.C(bArr, i10, i11);
    }

    public void D() {
        this.f20804a.D();
    }

    public void H(OutputStream outputStream, int i10) {
        this.f20804a.H(outputStream, i10);
    }

    public int h() {
        return this.f20804a.h();
    }

    public t1 j(int i10) {
        return this.f20804a.j(i10);
    }

    public boolean markSupported() {
        return this.f20804a.markSupported();
    }

    public void r(ByteBuffer byteBuffer) {
        this.f20804a.r(byteBuffer);
    }

    public int readUnsignedByte() {
        return this.f20804a.readUnsignedByte();
    }

    public void reset() {
        this.f20804a.reset();
    }

    public void skipBytes(int i10) {
        this.f20804a.skipBytes(i10);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) this.f20804a).toString();
    }
}
