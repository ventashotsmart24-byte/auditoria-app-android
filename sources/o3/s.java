package o3;

import b3.k0;
import b3.o0;
import java.io.Serializable;
import k3.g;
import k3.j;
import k3.k;
import k3.x;
import n3.t;

public class s implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final j f8534a;

    /* renamed from: b  reason: collision with root package name */
    public final x f8535b;

    /* renamed from: c  reason: collision with root package name */
    public final k0 f8536c;

    /* renamed from: d  reason: collision with root package name */
    public final k f8537d;

    /* renamed from: e  reason: collision with root package name */
    public final t f8538e;

    public s(j jVar, x xVar, k0 k0Var, k kVar, t tVar, o0 o0Var) {
        this.f8534a = jVar;
        this.f8535b = xVar;
        this.f8536c = k0Var;
        this.f8537d = kVar;
        this.f8538e = tVar;
    }

    public static s a(j jVar, x xVar, k0 k0Var, k kVar, t tVar, o0 o0Var) {
        return new s(jVar, xVar, k0Var, kVar, tVar, o0Var);
    }

    public k b() {
        return this.f8537d;
    }

    public j c() {
        return this.f8534a;
    }

    public boolean d(String str, c3.k kVar) {
        return this.f8536c.e(str, kVar);
    }

    public boolean e() {
        return this.f8536c.g();
    }

    public Object f(c3.k kVar, g gVar) {
        return this.f8537d.deserialize(kVar, gVar);
    }
}
