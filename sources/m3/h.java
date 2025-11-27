package m3;

import b3.b0;
import b3.k;
import b3.r;
import java.io.Serializable;
import java.util.Map;
import r3.h0;

public class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public Map f7852a;

    /* renamed from: b  reason: collision with root package name */
    public r.b f7853b;

    /* renamed from: c  reason: collision with root package name */
    public b0.a f7854c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f7855d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f7856e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f7857f;

    public h() {
        this((Map) null, r.b.c(), b0.a.c(), h0.a.o(), (Boolean) null, (Boolean) null);
    }

    public k.d a(Class cls) {
        g gVar;
        k.d b10;
        Map map = this.f7852a;
        if (map == null || (gVar = (g) map.get(cls)) == null || (b10 = gVar.b()) == null) {
            Boolean bool = this.f7857f;
            if (bool == null) {
                return k.d.b();
            }
            return k.d.c(bool.booleanValue());
        } else if (!b10.k()) {
            return b10.q(this.f7857f);
        } else {
            return b10;
        }
    }

    public g b(Class cls) {
        Map map = this.f7852a;
        if (map == null) {
            return null;
        }
        return (g) map.get(cls);
    }

    public r.b c() {
        return this.f7853b;
    }

    public Boolean d() {
        return this.f7856e;
    }

    public b0.a e() {
        return this.f7854c;
    }

    public h0 f() {
        return this.f7855d;
    }

    public h(Map map, r.b bVar, b0.a aVar, h0 h0Var, Boolean bool, Boolean bool2) {
        this.f7852a = map;
        this.f7853b = bVar;
        this.f7854c = aVar;
        this.f7855d = h0Var;
        this.f7856e = bool;
        this.f7857f = bool2;
    }
}
