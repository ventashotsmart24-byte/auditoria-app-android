package ab;

import ab.b;
import eb.b;
import eb.m;
import java.util.Arrays;

public class a extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final m f225e = new eb.a();

    /* renamed from: a  reason: collision with root package name */
    public b f226a = new b(f225e);

    /* renamed from: b  reason: collision with root package name */
    public b.a f227b;

    /* renamed from: c  reason: collision with root package name */
    public cb.a f228c = new cb.a();

    /* renamed from: d  reason: collision with root package name */
    public byte[] f229d = new byte[2];

    public a() {
        i();
    }

    public String c() {
        return za.b.f10000g;
    }

    public float d() {
        return this.f228c.a();
    }

    public b.a e() {
        return this.f227b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f226a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0) {
                    int b10 = this.f226a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f229d;
                        bArr2[1] = bArr[i10];
                        this.f228c.d(bArr2, 0, b10);
                    } else {
                        this.f228c.d(bArr, i13 - 1, b10);
                    }
                }
                i13++;
            }
        }
        this.f227b = aVar;
        this.f229d[0] = bArr[i12 - 1];
        if (this.f227b == b.a.DETECTING && this.f228c.c() && d() > 0.95f) {
            this.f227b = b.a.FOUND_IT;
        }
        return this.f227b;
    }

    public void i() {
        this.f226a.d();
        this.f227b = b.a.DETECTING;
        this.f228c.e();
        Arrays.fill(this.f229d, (byte) 0);
    }
}
