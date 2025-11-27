package x3;

import b3.e0;
import k3.d;

public class f extends t {

    /* renamed from: c  reason: collision with root package name */
    public final String f9686c;

    public f(w3.f fVar, d dVar, String str) {
        super(fVar, dVar);
        this.f9686c = str;
    }

    public String b() {
        return this.f9686c;
    }

    public e0.a c() {
        return e0.a.EXTERNAL_PROPERTY;
    }

    /* renamed from: m */
    public f a(d dVar) {
        if (this.f9721b == dVar) {
            return this;
        }
        return new f(this.f9720a, dVar, this.f9686c);
    }
}
