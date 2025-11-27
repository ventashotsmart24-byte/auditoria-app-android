package ab;

import ab.b;
import bb.a;
import eb.b;
import eb.m;
import java.util.Arrays;

public class c extends b {

    /* renamed from: f  reason: collision with root package name */
    public static final m f234f = new eb.c();

    /* renamed from: a  reason: collision with root package name */
    public b f235a = new b(f234f);

    /* renamed from: b  reason: collision with root package name */
    public b.a f236b;

    /* renamed from: c  reason: collision with root package name */
    public a f237c = new a();

    /* renamed from: d  reason: collision with root package name */
    public cb.c f238d = new cb.c();

    /* renamed from: e  reason: collision with root package name */
    public byte[] f239e = new byte[2];

    public c() {
        i();
    }

    public String c() {
        return za.b.f10002i;
    }

    public float d() {
        return Math.max(this.f237c.a(), this.f238d.a());
    }

    public b.a e() {
        return this.f236b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f235a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0) {
                    int b10 = this.f235a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f239e;
                        bArr2[1] = bArr[i10];
                        this.f237c.d(bArr2, 0, b10);
                        this.f238d.d(this.f239e, 0, b10);
                    } else {
                        int i14 = i13 - 1;
                        this.f237c.d(bArr, i14, b10);
                        this.f238d.d(bArr, i14, b10);
                    }
                }
                i13++;
            }
        }
        this.f236b = aVar;
        this.f239e[0] = bArr[i12 - 1];
        if (this.f236b == b.a.DETECTING && this.f237c.c() && d() > 0.95f) {
            this.f236b = b.a.FOUND_IT;
        }
        return this.f236b;
    }

    public void i() {
        this.f235a.d();
        this.f236b = b.a.DETECTING;
        this.f237c.e();
        this.f238d.e();
        Arrays.fill(this.f239e, (byte) 0);
    }
}
