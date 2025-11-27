package com.umeng.analytics.pro;

public final class dt extends du {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f14173a;

    /* renamed from: b  reason: collision with root package name */
    private int f14174b;

    /* renamed from: c  reason: collision with root package name */
    private int f14175c;

    public dt() {
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public void c() {
    }

    public void e() {
        this.f14173a = null;
    }

    public byte[] f() {
        return this.f14173a;
    }

    public int g() {
        return this.f14174b;
    }

    public int h() {
        return this.f14175c - this.f14174b;
    }

    public dt(byte[] bArr) {
        a(bArr);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    public void b(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public void c(byte[] bArr, int i10, int i11) {
        this.f14173a = bArr;
        this.f14174b = i10;
        this.f14175c = i10 + i11;
    }

    public int a(byte[] bArr, int i10, int i11) {
        int h10 = h();
        if (i11 > h10) {
            i11 = h10;
        }
        if (i11 > 0) {
            System.arraycopy(this.f14173a, this.f14174b, bArr, i10, i11);
            a(i11);
        }
        return i11;
    }

    public dt(byte[] bArr, int i10, int i11) {
        c(bArr, i10, i11);
    }

    public void a(int i10) {
        this.f14174b += i10;
    }
}
