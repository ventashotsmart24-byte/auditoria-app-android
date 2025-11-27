package ab;

import ab.b;
import bb.c;
import cb.h;
import eb.b;
import eb.m;
import java.util.Arrays;

public class l extends b {

    /* renamed from: f  reason: collision with root package name */
    public static final m f295f = new eb.l();

    /* renamed from: a  reason: collision with root package name */
    public b f296a = new b(f295f);

    /* renamed from: b  reason: collision with root package name */
    public b.a f297b;

    /* renamed from: c  reason: collision with root package name */
    public c f298c = new c();

    /* renamed from: d  reason: collision with root package name */
    public h f299d = new h();

    /* renamed from: e  reason: collision with root package name */
    public byte[] f300e = new byte[2];

    public l() {
        i();
    }

    public String c() {
        return za.b.f10005l;
    }

    public float d() {
        return Math.max(this.f298c.a(), this.f299d.a());
    }

    public b.a e() {
        return this.f297b;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        int i13 = i10;
        while (true) {
            if (i13 >= i12) {
                break;
            }
            int c10 = this.f296a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
                break;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
                break;
            } else {
                if (c10 == 0) {
                    int b10 = this.f296a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f300e;
                        bArr2[1] = bArr[i10];
                        this.f298c.d(bArr2, 2 - b10, b10);
                        this.f299d.d(this.f300e, 0, b10);
                    } else {
                        this.f298c.d(bArr, (i13 + 1) - b10, b10);
                        this.f299d.d(bArr, i13 - 1, b10);
                    }
                }
                i13++;
            }
        }
        this.f297b = aVar;
        this.f300e[0] = bArr[i12 - 1];
        if (this.f297b == b.a.DETECTING && this.f298c.c() && d() > 0.95f) {
            this.f297b = b.a.FOUND_IT;
        }
        return this.f297b;
    }

    public void i() {
        this.f296a.d();
        this.f297b = b.a.DETECTING;
        this.f298c.e();
        this.f299d.e();
        Arrays.fill(this.f300e, (byte) 0);
    }
}
