package t9;

import java.io.Serializable;
import r9.b;

public abstract class c implements z9.a, Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f19579g = a.f19586a;

    /* renamed from: a  reason: collision with root package name */
    public transient z9.a f19580a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f19581b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f19582c;

    /* renamed from: d  reason: collision with root package name */
    public final String f19583d;

    /* renamed from: e  reason: collision with root package name */
    public final String f19584e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f19585f;

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19586a = new a();
    }

    public c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f19581b = obj;
        this.f19582c = cls;
        this.f19583d = str;
        this.f19584e = str2;
        this.f19585f = z10;
    }

    public z9.a b() {
        z9.a aVar = this.f19580a;
        if (aVar != null) {
            return aVar;
        }
        z9.a c10 = c();
        this.f19580a = c10;
        return c10;
    }

    public abstract z9.a c();

    public Object d() {
        return this.f19581b;
    }

    public z9.c e() {
        Class cls = this.f19582c;
        if (cls == null) {
            return null;
        }
        if (this.f19585f) {
            return x.b(cls);
        }
        return x.a(cls);
    }

    public z9.a f() {
        z9.a b10 = b();
        if (b10 != this) {
            return b10;
        }
        throw new b();
    }

    public String g() {
        return this.f19584e;
    }

    public String getName() {
        return this.f19583d;
    }
}
