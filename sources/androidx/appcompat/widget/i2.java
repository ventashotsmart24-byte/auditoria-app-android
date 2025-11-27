package androidx.appcompat.widget;

public class i2 {

    /* renamed from: a  reason: collision with root package name */
    public int f1243a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1244b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1245c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f1246d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f1247e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1248f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1249g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1250h = false;

    public int a() {
        if (this.f1249g) {
            return this.f1243a;
        }
        return this.f1244b;
    }

    public int b() {
        return this.f1243a;
    }

    public int c() {
        return this.f1244b;
    }

    public int d() {
        if (this.f1249g) {
            return this.f1244b;
        }
        return this.f1243a;
    }

    public void e(int i10, int i11) {
        this.f1250h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1247e = i10;
            this.f1243a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1248f = i11;
            this.f1244b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 != this.f1249g) {
            this.f1249g = z10;
            if (!this.f1250h) {
                this.f1243a = this.f1247e;
                this.f1244b = this.f1248f;
            } else if (z10) {
                int i10 = this.f1246d;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f1247e;
                }
                this.f1243a = i10;
                int i11 = this.f1245c;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f1248f;
                }
                this.f1244b = i11;
            } else {
                int i12 = this.f1245c;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = this.f1247e;
                }
                this.f1243a = i12;
                int i13 = this.f1246d;
                if (i13 == Integer.MIN_VALUE) {
                    i13 = this.f1248f;
                }
                this.f1244b = i13;
            }
        }
    }

    public void g(int i10, int i11) {
        this.f1245c = i10;
        this.f1246d = i11;
        this.f1250h = true;
        if (this.f1249g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1243a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1244b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1243a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1244b = i11;
        }
    }
}
