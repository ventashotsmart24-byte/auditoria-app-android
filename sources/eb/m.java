package eb;

import com.google.common.primitives.UnsignedBytes;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public k f6525a;

    /* renamed from: b  reason: collision with root package name */
    public int f6526b;

    /* renamed from: c  reason: collision with root package name */
    public k f6527c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f6528d;

    /* renamed from: e  reason: collision with root package name */
    public String f6529e;

    public m(k kVar, int i10, k kVar2, int[] iArr, String str) {
        this.f6525a = kVar;
        this.f6526b = i10;
        this.f6527c = kVar2;
        this.f6528d = iArr;
        this.f6529e = str;
    }

    public int a(int i10) {
        return this.f6528d[i10];
    }

    public int b(byte b10) {
        return this.f6525a.d(b10 & UnsignedBytes.MAX_VALUE);
    }

    public String c() {
        return this.f6529e;
    }

    public int d(int i10, int i11) {
        return this.f6527c.d((i11 * this.f6526b) + i10);
    }
}
