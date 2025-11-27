package eb;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public int f6517a;

    /* renamed from: b  reason: collision with root package name */
    public int f6518b;

    /* renamed from: c  reason: collision with root package name */
    public int f6519c;

    /* renamed from: d  reason: collision with root package name */
    public int f6520d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f6521e;

    public k(int i10, int i11, int i12, int i13, int[] iArr) {
        this.f6517a = i10;
        this.f6518b = i11;
        this.f6519c = i12;
        this.f6520d = i13;
        this.f6521e = iArr;
    }

    public static int a(int i10, int i11) {
        return i10 | (i11 << 16);
    }

    public static int b(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return c(i10 | (i11 << 4), (i13 << 4) | i12, (i15 << 4) | i14, (i17 << 4) | i16);
    }

    public static int c(int i10, int i11, int i12, int i13) {
        return a(i10 | (i11 << 8), (i13 << 8) | i12);
    }

    public int d(int i10) {
        return (this.f6521e[i10 >> this.f6517a] >> ((i10 & this.f6518b) << this.f6519c)) & this.f6520d;
    }
}
