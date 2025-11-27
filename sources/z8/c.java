package z8;

public abstract class c implements t1 {
    public void D() {
    }

    public final void a(int i10) {
        if (h() < i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void close() {
    }

    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        a(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }
}
