package x3;

import b3.e0;
import k3.d;
import w3.f;

public class h extends b {

    /* renamed from: c  reason: collision with root package name */
    public final String f9689c;

    public h(f fVar, d dVar, String str) {
        super(fVar, dVar);
        this.f9689c = str;
    }

    public String b() {
        return this.f9689c;
    }

    public e0.a c() {
        return e0.a.PROPERTY;
    }

    /* renamed from: n */
    public h m(d dVar) {
        if (this.f9721b == dVar) {
            return this;
        }
        return new h(this.f9720a, dVar, this.f9689c);
    }
}
