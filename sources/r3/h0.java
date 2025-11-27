package r3;

import b3.f;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public interface h0 {

    public static class a implements h0, Serializable {

        /* renamed from: f  reason: collision with root package name */
        public static final a f9118f;

        /* renamed from: a  reason: collision with root package name */
        public final f.c f9119a;

        /* renamed from: b  reason: collision with root package name */
        public final f.c f9120b;

        /* renamed from: c  reason: collision with root package name */
        public final f.c f9121c;

        /* renamed from: d  reason: collision with root package name */
        public final f.c f9122d;

        /* renamed from: e  reason: collision with root package name */
        public final f.c f9123e;

        static {
            f.c cVar = f.c.PUBLIC_ONLY;
            f.c cVar2 = f.c.ANY;
            f9118f = new a(cVar, cVar, cVar2, cVar2, cVar);
        }

        public a(f.c cVar, f.c cVar2, f.c cVar3, f.c cVar4, f.c cVar5) {
            this.f9119a = cVar;
            this.f9120b = cVar2;
            this.f9121c = cVar3;
            this.f9122d = cVar4;
            this.f9123e = cVar5;
        }

        public static a o() {
            return f9118f;
        }

        /* renamed from: A */
        public a h(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f9118f.f9121c;
            }
            f.c cVar2 = cVar;
            if (this.f9121c == cVar2) {
                return this;
            }
            return new a(this.f9119a, this.f9120b, cVar2, this.f9122d, this.f9123e);
        }

        public boolean d(j jVar) {
            return s(jVar.b());
        }

        public boolean e(g gVar) {
            return q(gVar.b());
        }

        public boolean f(j jVar) {
            return t(jVar.b());
        }

        public boolean g(j jVar) {
            return r(jVar.b());
        }

        public boolean j(i iVar) {
            return p(iVar.m());
        }

        public final f.c m(f.c cVar, f.c cVar2) {
            if (cVar2 == f.c.DEFAULT) {
                return cVar;
            }
            return cVar2;
        }

        public a n(f.c cVar, f.c cVar2, f.c cVar3, f.c cVar4, f.c cVar5) {
            if (cVar == this.f9119a && cVar2 == this.f9120b && cVar3 == this.f9121c && cVar4 == this.f9122d && cVar5 == this.f9123e) {
                return this;
            }
            return new a(cVar, cVar2, cVar3, cVar4, cVar5);
        }

        public boolean p(Member member) {
            return this.f9122d.a(member);
        }

        public boolean q(Field field) {
            return this.f9123e.a(field);
        }

        public boolean r(Method method) {
            return this.f9119a.a(method);
        }

        public boolean s(Method method) {
            return this.f9120b.a(method);
        }

        public boolean t(Method method) {
            return this.f9121c.a(method);
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", new Object[]{this.f9119a, this.f9120b, this.f9121c, this.f9122d, this.f9123e});
        }

        /* renamed from: u */
        public a a(f fVar) {
            if (fVar == null) {
                return this;
            }
            return n(m(this.f9119a, fVar.getterVisibility()), m(this.f9120b, fVar.isGetterVisibility()), m(this.f9121c, fVar.setterVisibility()), m(this.f9122d, fVar.creatorVisibility()), m(this.f9123e, fVar.fieldVisibility()));
        }

        /* renamed from: v */
        public a l(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f9118f.f9122d;
            }
            f.c cVar2 = cVar;
            if (this.f9122d == cVar2) {
                return this;
            }
            return new a(this.f9119a, this.f9120b, this.f9121c, cVar2, this.f9123e);
        }

        /* renamed from: w */
        public a c(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f9118f.f9123e;
            }
            f.c cVar2 = cVar;
            if (this.f9123e == cVar2) {
                return this;
            }
            return new a(this.f9119a, this.f9120b, this.f9121c, this.f9122d, cVar2);
        }

        /* renamed from: x */
        public a b(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f9118f.f9119a;
            }
            f.c cVar2 = cVar;
            if (this.f9119a == cVar2) {
                return this;
            }
            return new a(cVar2, this.f9120b, this.f9121c, this.f9122d, this.f9123e);
        }

        /* renamed from: y */
        public a k(f.c cVar) {
            if (cVar == f.c.DEFAULT) {
                cVar = f9118f.f9120b;
            }
            f.c cVar2 = cVar;
            if (this.f9120b == cVar2) {
                return this;
            }
            return new a(this.f9119a, cVar2, this.f9121c, this.f9122d, this.f9123e);
        }

        /* renamed from: z */
        public a i(f.b bVar) {
            return this;
        }
    }

    h0 a(f fVar);

    h0 b(f.c cVar);

    h0 c(f.c cVar);

    boolean d(j jVar);

    boolean e(g gVar);

    boolean f(j jVar);

    boolean g(j jVar);

    h0 h(f.c cVar);

    h0 i(f.b bVar);

    boolean j(i iVar);

    h0 k(f.c cVar);

    h0 l(f.c cVar);
}
