package k9;

import java.io.Serializable;
import k9.f;
import s9.p;
import t9.i;
import t9.j;

public final class c implements f, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final f f18225a;

    /* renamed from: b  reason: collision with root package name */
    public final f.b f18226b;

    public static final class a extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18227a = new a();

        public a() {
            super(2);
        }

        /* renamed from: b */
        public final String invoke(String str, f.b bVar) {
            boolean z10;
            i.g(str, "acc");
            i.g(bVar, "element");
            if (str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(f fVar, f.b bVar) {
        i.g(fVar, "left");
        i.g(bVar, "element");
        this.f18225a = fVar;
        this.f18226b = bVar;
    }

    public f E(f.c cVar) {
        i.g(cVar, "key");
        if (this.f18226b.a(cVar) != null) {
            return this.f18225a;
        }
        f E = this.f18225a.E(cVar);
        if (E == this.f18225a) {
            return this;
        }
        if (E == g.f18231a) {
            return this.f18226b;
        }
        return new c(E, this.f18226b);
    }

    public f.b a(f.c cVar) {
        i.g(cVar, "key");
        c cVar2 = this;
        while (true) {
            f.b a10 = cVar2.f18226b.a(cVar);
            if (a10 != null) {
                return a10;
            }
            f fVar = cVar2.f18225a;
            if (!(fVar instanceof c)) {
                return fVar.a(cVar);
            }
            cVar2 = (c) fVar;
        }
    }

    public final boolean d(f.b bVar) {
        return i.b(a(bVar.getKey()), bVar);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.h() != h() || !cVar.g(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean g(c cVar) {
        while (d(cVar.f18226b)) {
            f fVar = cVar.f18225a;
            if (fVar instanceof c) {
                cVar = (c) fVar;
            } else {
                i.e(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((f.b) fVar);
            }
        }
        return false;
    }

    public final int h() {
        int i10 = 2;
        c cVar = this;
        while (true) {
            f fVar = cVar.f18225a;
            if (fVar instanceof c) {
                cVar = (c) fVar;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public int hashCode() {
        return this.f18225a.hashCode() + this.f18226b.hashCode();
    }

    public Object m(Object obj, p pVar) {
        i.g(pVar, "operation");
        return pVar.invoke(this.f18225a.m(obj, pVar), this.f18226b);
    }

    public f s(f fVar) {
        return f.a.a(this, fVar);
    }

    public String toString() {
        return '[' + ((String) m("", a.f18227a)) + ']';
    }
}
