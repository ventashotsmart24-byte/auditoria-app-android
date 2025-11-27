package eb;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public m f6489a;

    /* renamed from: b  reason: collision with root package name */
    public int f6490b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f6491c;

    /* renamed from: d  reason: collision with root package name */
    public int f6492d;

    public b(m mVar) {
        this.f6489a = mVar;
    }

    public String a() {
        return this.f6489a.c();
    }

    public int b() {
        return this.f6491c;
    }

    public int c(byte b10) {
        int b11 = this.f6489a.b(b10);
        if (this.f6490b == 0) {
            this.f6492d = 0;
            this.f6491c = this.f6489a.a(b11);
        }
        int d10 = this.f6489a.d(b11, this.f6490b);
        this.f6490b = d10;
        this.f6492d++;
        return d10;
    }

    public void d() {
        this.f6490b = 0;
    }
}
