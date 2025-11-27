package a9;

import okio.Buffer;
import z8.n2;

public class o implements n2 {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f10882a;

    /* renamed from: b  reason: collision with root package name */
    public int f10883b;

    /* renamed from: c  reason: collision with root package name */
    public int f10884c;

    public o(Buffer buffer, int i10) {
        this.f10882a = buffer;
        this.f10883b = i10;
    }

    public int a() {
        return this.f10883b;
    }

    public void b(byte b10) {
        this.f10882a.writeByte((int) b10);
        this.f10883b--;
        this.f10884c++;
    }

    public Buffer c() {
        return this.f10882a;
    }

    public int h() {
        return this.f10884c;
    }

    public void release() {
    }

    public void write(byte[] bArr, int i10, int i11) {
        this.f10882a.write(bArr, i10, i11);
        this.f10883b -= i11;
        this.f10884c += i11;
    }
}
