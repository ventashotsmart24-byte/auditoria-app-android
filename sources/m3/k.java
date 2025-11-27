package m3;

import com.fasterxml.jackson.databind.deser.std.d0;
import d4.c;
import d4.d;
import java.io.Serializable;
import k3.a;
import n3.g;
import n3.o;
import n3.p;
import n3.x;

public class k implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final o[] f7874f = new o[0];

    /* renamed from: g  reason: collision with root package name */
    public static final g[] f7875g = new g[0];

    /* renamed from: h  reason: collision with root package name */
    public static final a[] f7876h = new a[0];

    /* renamed from: i  reason: collision with root package name */
    public static final x[] f7877i = new x[0];

    /* renamed from: j  reason: collision with root package name */
    public static final p[] f7878j = {new d0()};

    /* renamed from: a  reason: collision with root package name */
    public final o[] f7879a;

    /* renamed from: b  reason: collision with root package name */
    public final p[] f7880b;

    /* renamed from: c  reason: collision with root package name */
    public final g[] f7881c;

    /* renamed from: d  reason: collision with root package name */
    public final a[] f7882d;

    /* renamed from: e  reason: collision with root package name */
    public final x[] f7883e;

    public k() {
        this((o[]) null, (p[]) null, (g[]) null, (a[]) null, (x[]) null);
    }

    public Iterable a() {
        return new d(this.f7882d);
    }

    public Iterable b() {
        return new d(this.f7881c);
    }

    public Iterable c() {
        return new d(this.f7879a);
    }

    public boolean d() {
        if (this.f7882d.length > 0) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f7881c.length > 0) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f7880b.length > 0) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f7883e.length > 0) {
            return true;
        }
        return false;
    }

    public Iterable h() {
        return new d(this.f7880b);
    }

    public Iterable i() {
        return new d(this.f7883e);
    }

    public k j(o oVar) {
        if (oVar != null) {
            return new k((o[]) c.i(this.f7879a, oVar), this.f7880b, this.f7881c, this.f7882d, this.f7883e);
        }
        throw new IllegalArgumentException("Cannot pass null Deserializers");
    }

    public k(o[] oVarArr, p[] pVarArr, g[] gVarArr, a[] aVarArr, x[] xVarArr) {
        this.f7879a = oVarArr == null ? f7874f : oVarArr;
        this.f7880b = pVarArr == null ? f7878j : pVarArr;
        this.f7881c = gVarArr == null ? f7875g : gVarArr;
        this.f7882d = aVarArr == null ? f7876h : aVarArr;
        this.f7883e = xVarArr == null ? f7877i : xVarArr;
    }
}
