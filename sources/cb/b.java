package cb;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public int f4897a;

    /* renamed from: b  reason: collision with root package name */
    public int f4898b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f4899c;

    /* renamed from: d  reason: collision with root package name */
    public float f4900d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4901e;

    public b() {
        e();
    }

    public float a() {
        int i10;
        int i11 = this.f4898b;
        if (i11 <= 0 || (i10 = this.f4897a) <= 4) {
            return 0.01f;
        }
        if (i11 != i10) {
            float f10 = ((float) (i10 / (i11 - i10))) * this.f4900d;
            if (f10 < 0.99f) {
                return f10;
            }
        }
        return 0.99f;
    }

    public abstract int b(byte[] bArr, int i10);

    public boolean c() {
        return this.f4898b > 1024;
    }

    public void d(byte[] bArr, int i10, int i11) {
        int b10 = i11 == 2 ? b(bArr, i10) : -1;
        if (b10 >= 0) {
            this.f4898b++;
            int[] iArr = this.f4899c;
            if (b10 < iArr.length && 512 > iArr[b10]) {
                this.f4897a++;
            }
        }
    }

    public void e() {
        this.f4901e = false;
        this.f4898b = 0;
        this.f4897a = 0;
    }
}
