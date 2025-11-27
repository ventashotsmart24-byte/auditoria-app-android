package ab;

import ab.b;
import eb.b;
import eb.g;
import eb.h;
import eb.i;
import eb.j;

public class f extends b {

    /* renamed from: e  reason: collision with root package name */
    public static final g f250e = new g();

    /* renamed from: f  reason: collision with root package name */
    public static final h f251f = new h();

    /* renamed from: g  reason: collision with root package name */
    public static final i f252g = new i();

    /* renamed from: h  reason: collision with root package name */
    public static final j f253h = new j();

    /* renamed from: a  reason: collision with root package name */
    public b[] f254a;

    /* renamed from: b  reason: collision with root package name */
    public int f255b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f256c;

    /* renamed from: d  reason: collision with root package name */
    public String f257d;

    public f() {
        eb.b[] bVarArr = new eb.b[4];
        this.f254a = bVarArr;
        bVarArr[0] = new eb.b(f250e);
        this.f254a[1] = new eb.b(f251f);
        this.f254a[2] = new eb.b(f252g);
        this.f254a[3] = new eb.b(f253h);
        i();
    }

    public String c() {
        return this.f257d;
    }

    public float d() {
        return 0.99f;
    }

    public b.a e() {
        return this.f256c;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12 && this.f256c == b.a.DETECTING) {
            for (int i13 = this.f255b - 1; i13 >= 0; i13--) {
                int c10 = this.f254a[i13].c(bArr[i10]);
                if (c10 == 1) {
                    int i14 = this.f255b - 1;
                    this.f255b = i14;
                    if (i14 <= 0) {
                        b.a aVar = b.a.NOT_ME;
                        this.f256c = aVar;
                        return aVar;
                    } else if (i13 != i14) {
                        eb.b[] bVarArr = this.f254a;
                        eb.b bVar = bVarArr[i14];
                        bVarArr[i14] = bVarArr[i13];
                        bVarArr[i13] = bVar;
                    }
                } else if (c10 == 2) {
                    this.f256c = b.a.FOUND_IT;
                    this.f257d = this.f254a[i13].a();
                    return this.f256c;
                }
            }
            i10++;
        }
        return this.f256c;
    }

    public void i() {
        this.f256c = b.a.DETECTING;
        int i10 = 0;
        while (true) {
            eb.b[] bVarArr = this.f254a;
            if (i10 < bVarArr.length) {
                bVarArr[i10].d();
                i10++;
            } else {
                this.f255b = bVarArr.length;
                this.f257d = null;
                return;
            }
        }
    }
}
