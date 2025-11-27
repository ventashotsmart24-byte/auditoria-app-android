package c4;

import java.lang.reflect.Array;
import k3.j;

public final class a extends m {

    /* renamed from: l  reason: collision with root package name */
    public final j f4809l;

    /* renamed from: m  reason: collision with root package name */
    public final Object f4810m;

    public a(j jVar, n nVar, Object obj, Object obj2, Object obj3, boolean z10) {
        super(obj.getClass(), nVar, (j) null, (j[]) null, jVar.hashCode(), obj2, obj3, z10);
        this.f4809l = jVar;
        this.f4810m = obj;
    }

    public static a b0(j jVar, n nVar) {
        return c0(jVar, nVar, (Object) null, (Object) null);
    }

    public static a c0(j jVar, n nVar, Object obj, Object obj2) {
        return new a(jVar, nVar, Array.newInstance(jVar.q(), 0), obj, obj2, false);
    }

    public boolean A() {
        return true;
    }

    public boolean C() {
        return true;
    }

    public boolean D() {
        return true;
    }

    public j P(Class cls, n nVar, j jVar, j[] jVarArr) {
        return null;
    }

    public j R(j jVar) {
        return new a(jVar, this.f4843h, Array.newInstance(jVar.q(), 0), this.f7411c, this.f7412d, this.f7413e);
    }

    public Object[] d0() {
        return (Object[]) this.f4810m;
    }

    /* renamed from: e0 */
    public a S(Object obj) {
        if (obj == this.f4809l.t()) {
            return this;
        }
        return new a(this.f4809l.W(obj), this.f4843h, this.f4810m, this.f7411c, this.f7412d, this.f7413e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == a.class) {
            return this.f4809l.equals(((a) obj).f4809l);
        }
        return false;
    }

    /* renamed from: f0 */
    public a T(Object obj) {
        if (obj == this.f4809l.u()) {
            return this;
        }
        return new a(this.f4809l.X(obj), this.f4843h, this.f4810m, this.f7411c, this.f7412d, this.f7413e);
    }

    /* renamed from: g0 */
    public a V() {
        if (this.f7413e) {
            return this;
        }
        return new a(this.f4809l.V(), this.f4843h, this.f4810m, this.f7411c, this.f7412d, true);
    }

    /* renamed from: h0 */
    public a W(Object obj) {
        if (obj == this.f7412d) {
            return this;
        }
        return new a(this.f4809l, this.f4843h, this.f4810m, this.f7411c, obj, this.f7413e);
    }

    /* renamed from: i0 */
    public a X(Object obj) {
        if (obj == this.f7411c) {
            return this;
        }
        return new a(this.f4809l, this.f4843h, this.f4810m, obj, this.f7412d, this.f7413e);
    }

    public j k() {
        return this.f4809l;
    }

    public StringBuilder l(StringBuilder sb) {
        sb.append('[');
        return this.f4809l.l(sb);
    }

    public StringBuilder n(StringBuilder sb) {
        sb.append('[');
        return this.f4809l.n(sb);
    }

    public String toString() {
        return "[array type, component type: " + this.f4809l + "]";
    }

    public boolean w() {
        return this.f4809l.w();
    }

    public boolean x() {
        if (super.x() || this.f4809l.x()) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return false;
    }
}
