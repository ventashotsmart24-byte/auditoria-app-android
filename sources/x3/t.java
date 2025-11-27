package x3;

import i3.b;
import k3.d;
import w3.f;
import w3.h;

public abstract class t extends h {

    /* renamed from: a  reason: collision with root package name */
    public final f f9720a;

    /* renamed from: b  reason: collision with root package name */
    public final d f9721b;

    public t(f fVar, d dVar) {
        this.f9720a = fVar;
        this.f9721b = dVar;
    }

    public String b() {
        return null;
    }

    public b g(c3.h hVar, b bVar) {
        i(bVar);
        return hVar.D0(bVar);
    }

    public b h(c3.h hVar, b bVar) {
        return hVar.E0(bVar);
    }

    public void i(b bVar) {
        String str;
        if (bVar.f7032c == null) {
            Object obj = bVar.f7030a;
            Class cls = bVar.f7031b;
            if (cls == null) {
                str = k(obj);
            } else {
                str = l(obj, cls);
            }
            bVar.f7032c = str;
        }
    }

    public void j(Object obj) {
    }

    public String k(Object obj) {
        String a10 = this.f9720a.a(obj);
        if (a10 == null) {
            j(obj);
        }
        return a10;
    }

    public String l(Object obj, Class cls) {
        String d10 = this.f9720a.d(obj, cls);
        if (d10 == null) {
            j(obj);
        }
        return d10;
    }
}
