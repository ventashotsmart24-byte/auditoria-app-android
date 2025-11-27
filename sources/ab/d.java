package ab;

import ab.b;
import eb.b;
import eb.m;
import java.util.Arrays;

public class d extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final m f240e = new eb.d();

    /* renamed from: a  reason: collision with root package name */
    public b f241a = new b(f240e);

    /* renamed from: b  reason: collision with root package name */
    public b.a f242b;

    /* renamed from: c  reason: collision with root package name */
    public cb.d f243c = new cb.d();

    /* renamed from: d  reason: collision with root package name */
    public byte[] f244d = new byte[2];

    public d() {
        i();
    }

    public String c() {
        return za.b.f10003j;
    }

    public float d() {
        return this.f243c.a();
    }

    public b.a e() {
        return this.f242b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f241a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0) {
                    int b10 = this.f241a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f244d;
                        bArr2[1] = bArr[i10];
                        this.f243c.d(bArr2, 0, b10);
                    } else {
                        this.f243c.d(bArr, i13 - 1, b10);
                    }
                }
                i13++;
            }
        }
        this.f242b = aVar;
        this.f244d[0] = bArr[i12 - 1];
        if (this.f242b == b.a.DETECTING && this.f243c.c() && d() > 0.95f) {
            this.f242b = b.a.FOUND_IT;
        }
        return this.f242b;
    }

    public void i() {
        this.f241a.d();
        this.f242b = b.a.DETECTING;
        this.f243c.e();
        Arrays.fill(this.f244d, (byte) 0);
    }
}
