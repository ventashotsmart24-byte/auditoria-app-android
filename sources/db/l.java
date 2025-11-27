package db;

import com.google.common.primitives.UnsignedBytes;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public short[] f6382a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6383b;

    /* renamed from: c  reason: collision with root package name */
    public float f6384c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6385d;

    /* renamed from: e  reason: collision with root package name */
    public String f6386e;

    public l(short[] sArr, byte[] bArr, float f10, boolean z10, String str) {
        this.f6382a = sArr;
        this.f6383b = bArr;
        this.f6384c = f10;
        this.f6385d = z10;
        this.f6386e = str;
    }

    public String a() {
        return this.f6386e;
    }

    public short b(byte b10) {
        return this.f6382a[b10 & UnsignedBytes.MAX_VALUE];
    }

    public byte c(int i10) {
        return this.f6383b[i10];
    }

    public float d() {
        return this.f6384c;
    }
}
