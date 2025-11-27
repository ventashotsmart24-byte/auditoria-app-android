package l;

import java.util.Arrays;

public class i {

    /* renamed from: k  reason: collision with root package name */
    public static int f7569k = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f7570a;

    /* renamed from: b  reason: collision with root package name */
    public int f7571b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f7572c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f7573d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f7574e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f7575f = new float[7];

    /* renamed from: g  reason: collision with root package name */
    public a f7576g;

    /* renamed from: h  reason: collision with root package name */
    public b[] f7577h = new b[8];

    /* renamed from: i  reason: collision with root package name */
    public int f7578i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f7579j = 0;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        f7583d,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f7576g = aVar;
    }

    public static void b() {
        f7569k++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f7578i;
            if (i10 >= i11) {
                b[] bVarArr = this.f7577h;
                if (i11 >= bVarArr.length) {
                    this.f7577h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f7577h;
                int i12 = this.f7578i;
                bVarArr2[i12] = bVar;
                this.f7578i = i12 + 1;
                return;
            } else if (this.f7577h[i10] != bVar) {
                i10++;
            } else {
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i10 = this.f7578i;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f7577h[i11] == bVar) {
                for (int i12 = 0; i12 < (i10 - i11) - 1; i12++) {
                    b[] bVarArr = this.f7577h;
                    int i13 = i11 + i12;
                    bVarArr[i13] = bVarArr[i13 + 1];
                }
                this.f7578i--;
                return;
            }
        }
    }

    public void d() {
        this.f7570a = null;
        this.f7576g = a.UNKNOWN;
        this.f7573d = 0;
        this.f7571b = -1;
        this.f7572c = -1;
        this.f7574e = 0.0f;
        this.f7578i = 0;
        this.f7579j = 0;
    }

    public void e(a aVar, String str) {
        this.f7576g = aVar;
    }

    public final void f(b bVar) {
        int i10 = this.f7578i;
        for (int i11 = 0; i11 < i10; i11++) {
            b bVar2 = this.f7577h[i11];
            bVar2.f7545d.n(bVar2, bVar, false);
        }
        this.f7578i = 0;
    }

    public String toString() {
        return "" + this.f7570a;
    }
}
