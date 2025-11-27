package ab;

import ab.b;
import db.l;

public class m extends b {

    /* renamed from: a  reason: collision with root package name */
    public b.a f301a;

    /* renamed from: b  reason: collision with root package name */
    public l f302b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f303c;

    /* renamed from: d  reason: collision with root package name */
    public short f304d;

    /* renamed from: e  reason: collision with root package name */
    public int f305e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f306f;

    /* renamed from: g  reason: collision with root package name */
    public int f307g;

    /* renamed from: h  reason: collision with root package name */
    public int f308h;

    /* renamed from: i  reason: collision with root package name */
    public b f309i;

    public m(l lVar) {
        this.f302b = lVar;
        this.f303c = false;
        this.f309i = null;
        this.f306f = new int[4];
        i();
    }

    public String c() {
        b bVar = this.f309i;
        return bVar == null ? this.f302b.a() : bVar.c();
    }

    public float d() {
        int i10 = this.f305e;
        if (i10 <= 0) {
            return 0.01f;
        }
        float d10 = ((((((float) this.f306f[3]) * 1.0f) / ((float) i10)) / this.f302b.d()) * ((float) this.f308h)) / ((float) this.f307g);
        if (d10 >= 1.0f) {
            return 0.99f;
        }
        return d10;
    }

    public b.a e() {
        return this.f301a;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        while (i10 < i12) {
            short b10 = this.f302b.b(bArr[i10]);
            if (b10 < 250) {
                this.f307g++;
            }
            if (b10 < 64) {
                this.f308h++;
                short s10 = this.f304d;
                if (s10 < 64) {
                    this.f305e++;
                    if (!this.f303c) {
                        int[] iArr = this.f306f;
                        byte c10 = this.f302b.c((s10 * 64) + b10);
                        iArr[c10] = iArr[c10] + 1;
                    } else {
                        int[] iArr2 = this.f306f;
                        byte c11 = this.f302b.c((b10 * 64) + s10);
                        iArr2[c11] = iArr2[c11] + 1;
                    }
                }
            }
            this.f304d = b10;
            i10++;
        }
        if (this.f301a == b.a.DETECTING && this.f305e > 1024) {
            float d10 = d();
            if (d10 > 0.95f) {
                aVar = b.a.FOUND_IT;
            } else if (d10 < 0.05f) {
                aVar = b.a.NOT_ME;
            }
            this.f301a = aVar;
        }
        return this.f301a;
    }

    public void i() {
        this.f301a = b.a.DETECTING;
        this.f304d = 255;
        for (int i10 = 0; i10 < 4; i10++) {
            this.f306f[i10] = 0;
        }
        this.f305e = 0;
        this.f307g = 0;
        this.f308h = 0;
    }

    public m(l lVar, boolean z10, b bVar) {
        this.f302b = lVar;
        this.f303c = z10;
        this.f309i = bVar;
        this.f306f = new int[4];
        i();
    }
}
