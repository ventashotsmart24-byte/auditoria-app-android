package r3;

import b3.r0;
import d4.h;
import k3.x;

public class b0 {

    /* renamed from: f  reason: collision with root package name */
    public static final b0 f9016f = new b0(x.f7498e, Object.class, (Class) null, false, (Class) null);

    /* renamed from: a  reason: collision with root package name */
    public final x f9017a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f9018b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f9019c;

    /* renamed from: d  reason: collision with root package name */
    public final Class f9020d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f9021e;

    public b0(x xVar, Class cls, Class cls2, Class cls3) {
        this(xVar, cls, cls2, false, cls3);
    }

    public static b0 a() {
        return f9016f;
    }

    public boolean b() {
        return this.f9021e;
    }

    public Class c() {
        return this.f9018b;
    }

    public x d() {
        return this.f9017a;
    }

    public Class e() {
        return this.f9019c;
    }

    public Class f() {
        return this.f9020d;
    }

    public b0 g(boolean z10) {
        if (this.f9021e == z10) {
            return this;
        }
        return new b0(this.f9017a, this.f9020d, this.f9018b, z10, this.f9019c);
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.f9017a + ", scope=" + h.X(this.f9020d) + ", generatorType=" + h.X(this.f9018b) + ", alwaysAsId=" + this.f9021e;
    }

    public b0(x xVar, Class cls, Class cls2, boolean z10, Class cls3) {
        this.f9017a = xVar;
        this.f9020d = cls;
        this.f9018b = cls2;
        this.f9021e = z10;
        this.f9019c = cls3 == null ? r0.class : cls3;
    }
}
