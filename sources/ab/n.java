package ab;

import ab.b;
import eb.b;
import eb.m;

public class n extends b {

    /* renamed from: d  reason: collision with root package name */
    public static final m f310d = new eb.n();

    /* renamed from: a  reason: collision with root package name */
    public b f311a = new b(f310d);

    /* renamed from: b  reason: collision with root package name */
    public b.a f312b;

    /* renamed from: c  reason: collision with root package name */
    public int f313c = 0;

    public n() {
        i();
    }

    public String c() {
        return za.b.f10014u;
    }

    public float d() {
        float f10 = 0.99f;
        if (this.f313c >= 6) {
            return 0.99f;
        }
        for (int i10 = 0; i10 < this.f313c; i10++) {
            f10 *= 0.5f;
        }
        return 1.0f - f10;
    }

    public b.a e() {
        return this.f312b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        while (true) {
            if (i10 >= i12) {
                break;
            }
            int c10 = this.f311a.c(bArr[i10]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0 && this.f311a.b() >= 2) {
                    this.f313c++;
                }
                i10++;
            }
        }
        this.f312b = aVar;
        if (this.f312b == b.a.DETECTING && d() > 0.95f) {
            this.f312b = b.a.FOUND_IT;
        }
        return this.f312b;
    }

    public void i() {
        this.f311a.d();
        this.f313c = 0;
        this.f312b = b.a.DETECTING;
    }
}
