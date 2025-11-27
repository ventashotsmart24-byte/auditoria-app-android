package ab;

import ab.b;
import eb.b;
import eb.f;
import eb.m;
import java.util.Arrays;

public class g extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final m f258e = new f();

    /* renamed from: a  reason: collision with root package name */
    public b f259a = new b(f258e);

    /* renamed from: b  reason: collision with root package name */
    public b.a f260b;

    /* renamed from: c  reason: collision with root package name */
    public cb.f f261c = new cb.f();

    /* renamed from: d  reason: collision with root package name */
    public byte[] f262d = new byte[2];

    public g() {
        i();
    }

    public String c() {
        return za.b.f10001h;
    }

    public float d() {
        return this.f261c.a();
    }

    public b.a e() {
        return this.f260b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f259a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0) {
                    int b10 = this.f259a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f262d;
                        bArr2[1] = bArr[i10];
                        this.f261c.d(bArr2, 0, b10);
                    } else {
                        this.f261c.d(bArr, i13 - 1, b10);
                    }
                }
                i13++;
            }
        }
        this.f260b = aVar;
        this.f262d[0] = bArr[i12 - 1];
        if (this.f260b == b.a.DETECTING && this.f261c.c() && d() > 0.95f) {
            this.f260b = b.a.FOUND_IT;
        }
        return this.f260b;
    }

    public void i() {
        this.f259a.d();
        this.f260b = b.a.DETECTING;
        this.f261c.e();
        Arrays.fill(this.f262d, (byte) 0);
    }
}
