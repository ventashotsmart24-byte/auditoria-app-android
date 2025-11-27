package com.umeng.message.proguard;

abstract class bg {

    /* renamed from: a  reason: collision with root package name */
    protected final byte f15503a = 61;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f15504b;

    /* renamed from: c  reason: collision with root package name */
    protected int f15505c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f15506d;

    /* renamed from: e  reason: collision with root package name */
    protected int f15507e;

    /* renamed from: f  reason: collision with root package name */
    protected int f15508f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15509g = 3;

    /* renamed from: h  reason: collision with root package name */
    private final int f15510h = 4;

    /* renamed from: i  reason: collision with root package name */
    private int f15511i;

    public final void a(int i10) {
        byte[] bArr = this.f15504b;
        if (bArr != null && bArr.length >= this.f15505c + i10) {
            return;
        }
        if (bArr == null) {
            this.f15504b = new byte[8192];
            this.f15505c = 0;
            this.f15511i = 0;
            return;
        }
        byte[] bArr2 = new byte[(bArr.length * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f15504b = bArr2;
    }

    public abstract void a(byte[] bArr, int i10, int i11);

    public abstract void b(byte[] bArr, int i10, int i11);

    public byte[] b(String str) {
        return e(str.getBytes());
    }

    public long c(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f15509g;
        return ((long) (((length + i10) - 1) / i10)) * ((long) this.f15510h);
    }

    public byte[] d(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        int i10 = this.f15505c - this.f15511i;
        byte[] bArr2 = new byte[i10];
        a(bArr2, i10);
        return bArr2;
    }

    public byte[] e(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i10 = this.f15505c;
        byte[] bArr2 = new byte[i10];
        a(bArr2, i10);
        return bArr2;
    }

    private int a(byte[] bArr, int i10) {
        byte[] bArr2 = this.f15504b;
        if (bArr2 != null) {
            int min = Math.min(bArr2 != null ? this.f15505c - this.f15511i : 0, i10);
            System.arraycopy(this.f15504b, this.f15511i, bArr, 0, min);
            int i11 = this.f15511i + min;
            this.f15511i = i11;
            if (i11 >= this.f15505c) {
                this.f15504b = null;
            }
            return min;
        } else if (this.f15506d) {
            return -1;
        } else {
            return 0;
        }
    }

    private void a() {
        this.f15504b = null;
        this.f15505c = 0;
        this.f15511i = 0;
        this.f15507e = 0;
        this.f15508f = 0;
        this.f15506d = false;
    }
}
