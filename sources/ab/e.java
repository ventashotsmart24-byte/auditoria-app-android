package ab;

import ab.b;
import eb.b;
import eb.m;
import java.util.Arrays;

public class e extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final m f245e = new eb.e();

    /* renamed from: a  reason: collision with root package name */
    public b f246a = new b(f245e);

    /* renamed from: b  reason: collision with root package name */
    public b.a f247b;

    /* renamed from: c  reason: collision with root package name */
    public cb.e f248c = new cb.e();

    /* renamed from: d  reason: collision with root package name */
    public byte[] f249d = new byte[2];

    public e() {
        i();
    }

    public String c() {
        return za.b.f10004k;
    }

    public float d() {
        return this.f248c.a();
    }

    public b.a e() {
        return this.f247b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f246a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0) {
                    int b10 = this.f246a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f249d;
                        bArr2[1] = bArr[i10];
                        this.f248c.d(bArr2, 0, b10);
                    } else {
                        this.f248c.d(bArr, i13 - 1, b10);
                    }
                }
                i13++;
            }
        }
        this.f247b = aVar;
        this.f249d[0] = bArr[i12 - 1];
        if (this.f247b == b.a.DETECTING && this.f248c.c() && d() > 0.95f) {
            this.f247b = b.a.FOUND_IT;
        }
        return this.f247b;
    }

    public void i() {
        this.f246a.d();
        this.f247b = b.a.DETECTING;
        this.f248c.e();
        Arrays.fill(this.f249d, (byte) 0);
    }
}
