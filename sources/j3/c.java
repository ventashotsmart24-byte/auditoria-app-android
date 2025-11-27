package j3;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends OutputStream {

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f7143f = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final a f7144a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList f7145b;

    /* renamed from: c  reason: collision with root package name */
    public int f7146c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f7147d;

    /* renamed from: e  reason: collision with root package name */
    public int f7148e;

    public c() {
        this((a) null);
    }

    public static c n(byte[] bArr, int i10) {
        return new c((a) null, bArr, i10);
    }

    public final void a() {
        int length = this.f7146c + this.f7147d.length;
        if (length >= 0) {
            this.f7146c = length;
            int max = Math.max(length >> 1, 1000);
            if (max > 131072) {
                max = 131072;
            }
            this.f7145b.add(this.f7147d);
            this.f7147d = new byte[max];
            this.f7148e = 0;
            return;
        }
        throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
    }

    public void b(int i10) {
        if (this.f7148e >= this.f7147d.length) {
            a();
        }
        byte[] bArr = this.f7147d;
        int i11 = this.f7148e;
        this.f7148e = i11 + 1;
        bArr[i11] = (byte) i10;
    }

    public void c(int i10) {
        int i11 = this.f7148e;
        int i12 = i11 + 2;
        byte[] bArr = this.f7147d;
        if (i12 < bArr.length) {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 16);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (i10 >> 8);
            this.f7148e = i14 + 1;
            bArr[i14] = (byte) i10;
            return;
        }
        b(i10 >> 16);
        b(i10 >> 8);
        b(i10);
    }

    public void close() {
    }

    public void e(int i10) {
        int i11 = this.f7148e;
        int i12 = i11 + 1;
        byte[] bArr = this.f7147d;
        if (i12 < bArr.length) {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
            this.f7148e = i13 + 1;
            bArr[i13] = (byte) i10;
            return;
        }
        b(i10 >> 8);
        b(i10);
    }

    public byte[] f(int i10) {
        this.f7148e = i10;
        return v();
    }

    public void flush() {
    }

    public byte[] m() {
        a();
        return this.f7147d;
    }

    public byte[] q() {
        return this.f7147d;
    }

    public void reset() {
        this.f7146c = 0;
        this.f7148e = 0;
        if (!this.f7145b.isEmpty()) {
            this.f7145b.clear();
        }
    }

    public int s() {
        return this.f7148e;
    }

    public void u(int i10) {
        this.f7148e = i10;
    }

    public byte[] v() {
        int i10 = this.f7146c + this.f7148e;
        if (i10 == 0) {
            return f7143f;
        }
        byte[] bArr = new byte[i10];
        Iterator it = this.f7145b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i11, length);
            i11 += length;
        }
        System.arraycopy(this.f7147d, 0, bArr, i11, this.f7148e);
        int i12 = i11 + this.f7148e;
        if (i12 == i10) {
            if (!this.f7145b.isEmpty()) {
                reset();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i10 + ", copied " + i12 + " bytes");
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public c(a aVar) {
        this(aVar, 500);
    }

    public void write(byte[] bArr, int i10, int i11) {
        while (true) {
            int min = Math.min(this.f7147d.length - this.f7148e, i11);
            if (min > 0) {
                System.arraycopy(bArr, i10, this.f7147d, this.f7148e, min);
                i10 += min;
                this.f7148e += min;
                i11 -= min;
            }
            if (i11 > 0) {
                a();
            } else {
                return;
            }
        }
    }

    public c(int i10) {
        this((a) null, i10);
    }

    public c(a aVar, int i10) {
        this.f7145b = new LinkedList();
        this.f7144a = aVar;
        this.f7147d = aVar == null ? new byte[(i10 > 131072 ? 131072 : i10)] : aVar.a(2);
    }

    public void write(int i10) {
        b(i10);
    }

    public c(a aVar, byte[] bArr, int i10) {
        this.f7145b = new LinkedList();
        this.f7144a = null;
        this.f7147d = bArr;
        this.f7148e = i10;
    }
}
