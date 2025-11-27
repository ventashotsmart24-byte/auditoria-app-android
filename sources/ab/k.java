package ab;

import ab.b;
import db.d;
import db.e;
import db.f;
import db.g;
import db.h;
import db.i;
import db.j;
import db.l;
import db.m;
import db.n;
import db.o;
import java.nio.ByteBuffer;

public class k extends b {

    /* renamed from: f  reason: collision with root package name */
    public static final l f279f = new n();

    /* renamed from: g  reason: collision with root package name */
    public static final l f280g = new g();

    /* renamed from: h  reason: collision with root package name */
    public static final l f281h = new i();

    /* renamed from: i  reason: collision with root package name */
    public static final l f282i = new db.k();

    /* renamed from: j  reason: collision with root package name */
    public static final l f283j = new f();

    /* renamed from: k  reason: collision with root package name */
    public static final l f284k = new e();

    /* renamed from: l  reason: collision with root package name */
    public static final l f285l = new j();

    /* renamed from: m  reason: collision with root package name */
    public static final l f286m = new o();

    /* renamed from: n  reason: collision with root package name */
    public static final l f287n = new h();

    /* renamed from: o  reason: collision with root package name */
    public static final l f288o = new m();

    /* renamed from: p  reason: collision with root package name */
    public static final l f289p = new d();

    /* renamed from: a  reason: collision with root package name */
    public b.a f290a;

    /* renamed from: b  reason: collision with root package name */
    public b[] f291b;

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f292c = new boolean[13];

    /* renamed from: d  reason: collision with root package name */
    public int f293d;

    /* renamed from: e  reason: collision with root package name */
    public int f294e;

    public k() {
        b[] bVarArr = new b[13];
        this.f291b = bVarArr;
        bVarArr[0] = new m(f279f);
        this.f291b[1] = new m(f280g);
        this.f291b[2] = new m(f281h);
        this.f291b[3] = new m(f282i);
        this.f291b[4] = new m(f283j);
        this.f291b[5] = new m(f284k);
        this.f291b[6] = new m(f285l);
        this.f291b[7] = new m(f286m);
        this.f291b[8] = new m(f287n);
        this.f291b[9] = new m(f288o);
        h hVar = new h();
        b[] bVarArr2 = this.f291b;
        bVarArr2[10] = hVar;
        l lVar = f289p;
        bVarArr2[11] = new m(lVar, false, hVar);
        this.f291b[12] = new m(lVar, true, hVar);
        b[] bVarArr3 = this.f291b;
        hVar.l(bVarArr3[11], bVarArr3[12]);
        i();
    }

    public String c() {
        if (this.f293d == -1) {
            d();
            if (this.f293d == -1) {
                this.f293d = 0;
            }
        }
        return this.f291b[this.f293d].c();
    }

    public float d() {
        b.a aVar = this.f290a;
        if (aVar == b.a.FOUND_IT) {
            return 0.99f;
        }
        if (aVar == b.a.NOT_ME) {
            return 0.01f;
        }
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f291b;
            if (i10 >= bVarArr.length) {
                return f10;
            }
            if (this.f292c[i10]) {
                float d10 = bVarArr[i10].d();
                if (f10 < d10) {
                    this.f293d = i10;
                    f10 = d10;
                }
            }
            i10++;
        }
    }

    public b.a e() {
        return this.f290a;
    }

    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        ByteBuffer b10 = b(bArr, i10, i11);
        if (b10.position() != 0) {
            int i12 = 0;
            while (true) {
                b[] bVarArr = this.f291b;
                if (i12 >= bVarArr.length) {
                    break;
                }
                if (this.f292c[i12]) {
                    b.a f10 = bVarArr[i12].f(b10.array(), 0, b10.position());
                    aVar = b.a.FOUND_IT;
                    if (f10 == aVar) {
                        this.f293d = i12;
                        break;
                    }
                    aVar = b.a.NOT_ME;
                    if (f10 == aVar) {
                        this.f292c[i12] = false;
                        int i13 = this.f294e - 1;
                        this.f294e = i13;
                        if (i13 <= 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i12++;
            }
            this.f290a = aVar;
        }
        return this.f290a;
    }

    public void i() {
        int i10 = 0;
        this.f294e = 0;
        while (true) {
            b[] bVarArr = this.f291b;
            if (i10 < bVarArr.length) {
                bVarArr[i10].i();
                this.f292c[i10] = true;
                this.f294e++;
                i10++;
            } else {
                this.f293d = -1;
                this.f290a = b.a.DETECTING;
                return;
            }
        }
    }
}
