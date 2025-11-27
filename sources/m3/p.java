package m3;

import a4.g;
import a4.r;
import d4.c;
import d4.d;
import java.io.Serializable;

public final class p implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final r[] f7898d = new r[0];

    /* renamed from: e  reason: collision with root package name */
    public static final g[] f7899e = new g[0];

    /* renamed from: a  reason: collision with root package name */
    public final r[] f7900a;

    /* renamed from: b  reason: collision with root package name */
    public final r[] f7901b;

    /* renamed from: c  reason: collision with root package name */
    public final g[] f7902c;

    public p() {
        this((r[]) null, (r[]) null, (g[]) null);
    }

    public boolean a() {
        if (this.f7901b.length > 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f7902c.length > 0) {
            return true;
        }
        return false;
    }

    public Iterable c() {
        return new d(this.f7901b);
    }

    public Iterable d() {
        return new d(this.f7902c);
    }

    public Iterable e() {
        return new d(this.f7900a);
    }

    public p f(r rVar) {
        if (rVar != null) {
            return new p(this.f7900a, (r[]) c.i(this.f7901b, rVar), this.f7902c);
        }
        throw new IllegalArgumentException("Cannot pass null Serializers");
    }

    public p g(r rVar) {
        if (rVar != null) {
            return new p((r[]) c.i(this.f7900a, rVar), this.f7901b, this.f7902c);
        }
        throw new IllegalArgumentException("Cannot pass null Serializers");
    }

    public p(r[] rVarArr, r[] rVarArr2, g[] gVarArr) {
        this.f7900a = rVarArr == null ? f7898d : rVarArr;
        this.f7901b = rVarArr2 == null ? f7898d : rVarArr2;
        this.f7902c = gVarArr == null ? f7899e : gVarArr;
    }
}
