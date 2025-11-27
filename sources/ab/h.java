package ab;

import ab.b;
import com.google.common.primitives.UnsignedBytes;
import za.b;

public class h extends b {

    /* renamed from: a  reason: collision with root package name */
    public int f263a;

    /* renamed from: b  reason: collision with root package name */
    public int f264b;

    /* renamed from: c  reason: collision with root package name */
    public byte f265c;

    /* renamed from: d  reason: collision with root package name */
    public byte f266d;

    /* renamed from: e  reason: collision with root package name */
    public b f267e = null;

    /* renamed from: f  reason: collision with root package name */
    public b f268f = null;

    public h() {
        i();
    }

    public static boolean j(byte b10) {
        byte b11 = b10 & UnsignedBytes.MAX_VALUE;
        return b11 == 234 || b11 == 237 || b11 == 239 || b11 == 243 || b11 == 245;
    }

    public static boolean k(byte b10) {
        byte b11 = b10 & UnsignedBytes.MAX_VALUE;
        return b11 == 235 || b11 == 238 || b11 == 240 || b11 == 244;
    }

    public String c() {
        int i10 = this.f263a - this.f264b;
        if (i10 >= 5) {
            return b.f10013t;
        }
        if (i10 <= -5) {
            return b.f9999f;
        }
        float d10 = this.f267e.d() - this.f268f.d();
        if (d10 > 0.01f) {
            return b.f10013t;
        }
        if (d10 < -0.01f) {
            return b.f9999f;
        }
        return i10 < 0 ? b.f9999f : b.f10013t;
    }

    public float d() {
        return 0.0f;
    }

    public b.a e() {
        b.a e10 = this.f267e.e();
        b.a aVar = b.a.NOT_ME;
        return (e10 == aVar && this.f268f.e() == aVar) ? aVar : b.a.DETECTING;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a e10 = e();
        b.a aVar = b.a.NOT_ME;
        if (e10 == aVar) {
            return aVar;
        }
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            byte b11 = this.f266d;
            if (b10 == 32) {
                if (b11 != 32) {
                    if (j(this.f265c)) {
                        this.f263a++;
                    } else if (!k(this.f265c)) {
                    }
                }
                this.f266d = this.f265c;
                this.f265c = b10;
                i10++;
            } else {
                if (b11 == 32) {
                    if (j(this.f265c)) {
                        if (b10 == 32) {
                        }
                    }
                }
                this.f266d = this.f265c;
                this.f265c = b10;
                i10++;
            }
            this.f264b++;
            this.f266d = this.f265c;
            this.f265c = b10;
            i10++;
        }
        return b.a.DETECTING;
    }

    public void i() {
        this.f263a = 0;
        this.f264b = 0;
        this.f265c = 32;
        this.f266d = 32;
    }

    public void l(b bVar, b bVar2) {
        this.f267e = bVar;
        this.f268f = bVar2;
    }
}
