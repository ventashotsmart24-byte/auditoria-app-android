package p0;

public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final c f8791e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f8792f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f8793g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f8794h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f8795i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f8796j;

    /* renamed from: a  reason: collision with root package name */
    public final float[] f8797a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f8798b;

    /* renamed from: c  reason: collision with root package name */
    public final float[] f8799c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    public boolean f8800d = true;

    static {
        c cVar = new c();
        f8791e = cVar;
        m(cVar);
        p(cVar);
        c cVar2 = new c();
        f8792f = cVar2;
        o(cVar2);
        p(cVar2);
        c cVar3 = new c();
        f8793g = cVar3;
        l(cVar3);
        p(cVar3);
        c cVar4 = new c();
        f8794h = cVar4;
        m(cVar4);
        n(cVar4);
        c cVar5 = new c();
        f8795i = cVar5;
        o(cVar5);
        n(cVar5);
        c cVar6 = new c();
        f8796j = cVar6;
        l(cVar6);
        n(cVar6);
    }

    public c() {
        float[] fArr = new float[3];
        this.f8797a = fArr;
        float[] fArr2 = new float[3];
        this.f8798b = fArr2;
        r(fArr);
        r(fArr2);
        q();
    }

    public static void l(c cVar) {
        float[] fArr = cVar.f8798b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    public static void m(c cVar) {
        float[] fArr = cVar.f8798b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    public static void n(c cVar) {
        float[] fArr = cVar.f8797a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    public static void o(c cVar) {
        float[] fArr = cVar.f8798b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    public static void p(c cVar) {
        float[] fArr = cVar.f8797a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    public static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f8799c[1];
    }

    public float b() {
        return this.f8798b[2];
    }

    public float c() {
        return this.f8797a[2];
    }

    public float d() {
        return this.f8798b[0];
    }

    public float e() {
        return this.f8797a[0];
    }

    public float f() {
        return this.f8799c[2];
    }

    public float g() {
        return this.f8799c[0];
    }

    public float h() {
        return this.f8798b[1];
    }

    public float i() {
        return this.f8797a[1];
    }

    public boolean j() {
        return this.f8800d;
    }

    public void k() {
        float f10 = 0.0f;
        for (float f11 : this.f8799c) {
            if (f11 > 0.0f) {
                f10 += f11;
            }
        }
        if (f10 != 0.0f) {
            int length = this.f8799c.length;
            for (int i10 = 0; i10 < length; i10++) {
                float[] fArr = this.f8799c;
                float f12 = fArr[i10];
                if (f12 > 0.0f) {
                    fArr[i10] = f12 / f10;
                }
            }
        }
    }

    public final void q() {
        float[] fArr = this.f8799c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }
}
