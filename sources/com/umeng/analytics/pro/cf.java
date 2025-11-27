package com.umeng.analytics.pro;

public class cf {

    /* renamed from: a  reason: collision with root package name */
    private short[] f14033a;

    /* renamed from: b  reason: collision with root package name */
    private int f14034b = -1;

    public cf(int i10) {
        this.f14033a = new short[i10];
    }

    private void d() {
        short[] sArr = this.f14033a;
        short[] sArr2 = new short[(sArr.length * 2)];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f14033a = sArr2;
    }

    public short a() {
        short[] sArr = this.f14033a;
        int i10 = this.f14034b;
        this.f14034b = i10 - 1;
        return sArr[i10];
    }

    public short b() {
        return this.f14033a[this.f14034b];
    }

    public void c() {
        this.f14034b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i10 = 0; i10 < this.f14033a.length; i10++) {
            if (i10 != 0) {
                sb.append(" ");
            }
            if (i10 == this.f14034b) {
                sb.append(">>");
            }
            sb.append(this.f14033a[i10]);
            if (i10 == this.f14034b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s10) {
        if (this.f14033a.length == this.f14034b + 1) {
            d();
        }
        short[] sArr = this.f14033a;
        int i10 = this.f14034b + 1;
        this.f14034b = i10;
        sArr[i10] = s10;
    }
}
