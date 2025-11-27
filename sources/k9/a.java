package k9;

import k9.f;
import s9.p;
import t9.i;

public abstract class a implements f.b {

    /* renamed from: a  reason: collision with root package name */
    public final f.c f18222a;

    public a(f.c cVar) {
        i.g(cVar, "key");
        this.f18222a = cVar;
    }

    public f E(f.c cVar) {
        return f.b.a.c(this, cVar);
    }

    public f.b a(f.c cVar) {
        return f.b.a.b(this, cVar);
    }

    public f.c getKey() {
        return this.f18222a;
    }

    public Object m(Object obj, p pVar) {
        return f.b.a.a(this, obj, pVar);
    }

    public f s(f fVar) {
        return f.b.a.d(this, fVar);
    }
}
