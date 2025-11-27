package c4;

import k3.j;

public class i extends m {

    /* renamed from: l  reason: collision with root package name */
    public final int f4834l;

    /* renamed from: m  reason: collision with root package name */
    public j f4835m;

    public i(int i10) {
        super(Object.class, n.i(), o.O(), (j[]) null, 1, (Object) null, (Object) null, false);
        this.f4834l = i10;
    }

    public boolean D() {
        return false;
    }

    public j P(Class cls, n nVar, j jVar, j[] jVarArr) {
        return (j) b0();
    }

    public j R(j jVar) {
        return (j) b0();
    }

    public j S(Object obj) {
        return (j) b0();
    }

    public j T(Object obj) {
        return (j) b0();
    }

    public j V() {
        return (j) b0();
    }

    public j W(Object obj) {
        return (j) b0();
    }

    public j X(Object obj) {
        return (j) b0();
    }

    public String a0() {
        return toString();
    }

    public final Object b0() {
        throw new UnsupportedOperationException("Operation should not be attempted on " + getClass().getName());
    }

    public j c0() {
        return this.f4835m;
    }

    public void d0(j jVar) {
        this.f4835m = jVar;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public StringBuilder l(StringBuilder sb) {
        sb.append('$');
        sb.append(this.f4834l + 1);
        return sb;
    }

    public StringBuilder n(StringBuilder sb) {
        return l(sb);
    }

    public String toString() {
        return l(new StringBuilder()).toString();
    }
}
