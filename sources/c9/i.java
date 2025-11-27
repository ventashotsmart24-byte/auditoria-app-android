package c9;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public int f11477a;

    /* renamed from: b  reason: collision with root package name */
    public int f11478b;

    /* renamed from: c  reason: collision with root package name */
    public int f11479c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f11480d = new int[10];

    public int a(int i10) {
        return this.f11480d[i10];
    }

    public int b() {
        if ((this.f11477a & 2) != 0) {
            return this.f11480d[1];
        }
        return -1;
    }

    public int c(int i10) {
        if ((this.f11477a & 32) != 0) {
            return this.f11480d[5];
        }
        return i10;
    }

    public boolean d(int i10) {
        if (((1 << i10) & this.f11477a) != 0) {
            return true;
        }
        return false;
    }

    public i e(int i10, int i11, int i12) {
        int[] iArr = this.f11480d;
        if (i10 >= iArr.length) {
            return this;
        }
        int i13 = 1 << i10;
        this.f11477a |= i13;
        if ((i11 & 1) != 0) {
            this.f11478b |= i13;
        } else {
            this.f11478b &= i13 ^ -1;
        }
        if ((i11 & 2) != 0) {
            this.f11479c |= i13;
        } else {
            this.f11479c &= i13 ^ -1;
        }
        iArr[i10] = i12;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f11477a);
    }
}
