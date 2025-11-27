package b4;

import a4.c;
import c3.h;
import d4.q;
import k3.c0;
import k3.o;

public abstract class d {

    public static final class a extends c {

        /* renamed from: u  reason: collision with root package name */
        public final c f4324u;

        /* renamed from: v  reason: collision with root package name */
        public final Class[] f4325v;

        public a(c cVar, Class[] clsArr) {
            super(cVar);
            this.f4324u = cVar;
            this.f4325v = clsArr;
        }

        public final boolean F(Class cls) {
            if (cls == null) {
                return true;
            }
            for (Class isAssignableFrom : this.f4325v) {
                if (isAssignableFrom.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: G */
        public a w(q qVar) {
            return new a(this.f4324u.w(qVar), this.f4325v);
        }

        public void k(o oVar) {
            this.f4324u.k(oVar);
        }

        public void l(o oVar) {
            this.f4324u.l(oVar);
        }

        public void x(Object obj, h hVar, c0 c0Var) {
            if (F(c0Var.V())) {
                this.f4324u.x(obj, hVar, c0Var);
            } else {
                this.f4324u.A(obj, hVar, c0Var);
            }
        }

        public void y(Object obj, h hVar, c0 c0Var) {
            if (F(c0Var.V())) {
                this.f4324u.y(obj, hVar, c0Var);
            } else {
                this.f4324u.z(obj, hVar, c0Var);
            }
        }
    }

    public static final class b extends c {

        /* renamed from: u  reason: collision with root package name */
        public final c f4326u;

        /* renamed from: v  reason: collision with root package name */
        public final Class f4327v;

        public b(c cVar, Class cls) {
            super(cVar);
            this.f4326u = cVar;
            this.f4327v = cls;
        }

        /* renamed from: F */
        public b w(q qVar) {
            return new b(this.f4326u.w(qVar), this.f4327v);
        }

        public void k(o oVar) {
            this.f4326u.k(oVar);
        }

        public void l(o oVar) {
            this.f4326u.l(oVar);
        }

        public void x(Object obj, h hVar, c0 c0Var) {
            Class V = c0Var.V();
            if (V == null || this.f4327v.isAssignableFrom(V)) {
                this.f4326u.x(obj, hVar, c0Var);
            } else {
                this.f4326u.A(obj, hVar, c0Var);
            }
        }

        public void y(Object obj, h hVar, c0 c0Var) {
            Class V = c0Var.V();
            if (V == null || this.f4327v.isAssignableFrom(V)) {
                this.f4326u.y(obj, hVar, c0Var);
            } else {
                this.f4326u.z(obj, hVar, c0Var);
            }
        }
    }

    public static c a(c cVar, Class[] clsArr) {
        if (clsArr.length == 1) {
            return new b(cVar, clsArr[0]);
        }
        return new a(cVar, clsArr);
    }
}
