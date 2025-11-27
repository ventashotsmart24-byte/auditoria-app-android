package m;

public class n extends o {

    /* renamed from: c  reason: collision with root package name */
    public float f7790c = 0.0f;

    public void e() {
        super.e();
        this.f7790c = 0.0f;
    }

    public void g() {
        this.f7792b = 2;
    }

    public void h(int i10) {
        int i11 = this.f7792b;
        if (i11 == 0 || this.f7790c != ((float) i10)) {
            this.f7790c = (float) i10;
            if (i11 == 1) {
                c();
            }
            b();
        }
    }
}
