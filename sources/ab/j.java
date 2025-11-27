package ab;

import ab.b;
import com.google.common.primitives.UnsignedBytes;

public class j extends b {

    /* renamed from: a  reason: collision with root package name */
    public b.a f274a;

    /* renamed from: b  reason: collision with root package name */
    public b[] f275b;

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f276c = new boolean[7];

    /* renamed from: d  reason: collision with root package name */
    public int f277d;

    /* renamed from: e  reason: collision with root package name */
    public int f278e;

    public j() {
        b[] bVarArr = new b[7];
        this.f275b = bVarArr;
        bVarArr[0] = new n();
        this.f275b[1] = new l();
        this.f275b[2] = new c();
        this.f275b[3] = new g();
        this.f275b[4] = new d();
        this.f275b[5] = new a();
        this.f275b[6] = new e();
        i();
    }

    public String c() {
        if (this.f277d == -1) {
            d();
            if (this.f277d == -1) {
                this.f277d = 0;
            }
        }
        return this.f275b[this.f277d].c();
    }

    public float d() {
        b.a aVar = this.f274a;
        if (aVar == b.a.FOUND_IT) {
            return 0.99f;
        }
        if (aVar == b.a.NOT_ME) {
            return 0.01f;
        }
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f275b;
            if (i10 >= bVarArr.length) {
                return f10;
            }
            if (this.f276c[i10]) {
                float d10 = bVarArr[i10].d();
                if (f10 < d10) {
                    this.f277d = i10;
                    f10 = d10;
                }
            }
            i10++;
        }
    }

    public b.a e() {
        return this.f274a;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        byte[] bArr2 = new byte[i11];
        int i12 = i11 + i10;
        boolean z10 = true;
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                bArr2[i13] = b10;
                i13++;
                z10 = true;
            } else if (z10) {
                bArr2[i13] = b10;
                i13++;
                z10 = false;
            }
            i10++;
        }
        int i14 = 0;
        while (true) {
            b[] bVarArr = this.f275b;
            if (i14 >= bVarArr.length) {
                break;
            }
            if (this.f276c[i14]) {
                b.a f10 = bVarArr[i14].f(bArr2, 0, i13);
                aVar = b.a.FOUND_IT;
                if (f10 == aVar) {
                    this.f277d = i14;
                    break;
                }
                aVar = b.a.NOT_ME;
                if (f10 == aVar) {
                    this.f276c[i14] = false;
                    int i15 = this.f278e - 1;
                    this.f278e = i15;
                    if (i15 <= 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i14++;
        }
        this.f274a = aVar;
        return this.f274a;
    }

    public void i() {
        int i10 = 0;
        this.f278e = 0;
        while (true) {
            b[] bVarArr = this.f275b;
            if (i10 < bVarArr.length) {
                bVarArr[i10].i();
                this.f276c[i10] = true;
                this.f278e++;
                i10++;
            } else {
                this.f277d = -1;
                this.f274a = b.a.DETECTING;
                return;
            }
        }
    }
}
