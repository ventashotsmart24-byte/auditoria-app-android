package m3;

import d4.h;
import java.io.Serializable;

public final class i implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final i f7858d = new i(a.HEURISTIC);

    /* renamed from: e  reason: collision with root package name */
    public static final i f7859e = new i(a.PROPERTIES);

    /* renamed from: f  reason: collision with root package name */
    public static final i f7860f = new i(a.DELEGATING);

    /* renamed from: g  reason: collision with root package name */
    public static final i f7861g = new i(a.REQUIRE_MODE);

    /* renamed from: a  reason: collision with root package name */
    public final a f7862a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7863b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7864c;

    public enum a {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }

    public i(a aVar, boolean z10, boolean z11) {
        this.f7862a = aVar;
        this.f7863b = z10;
        this.f7864c = z11;
    }

    public boolean a() {
        return this.f7863b;
    }

    public boolean b(Class cls) {
        if (this.f7863b) {
            return false;
        }
        if (this.f7864c || !h.M(cls) || Throwable.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f7862a == a.DELEGATING) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f7862a == a.PROPERTIES) {
            return true;
        }
        return false;
    }

    public a e() {
        return this.f7862a;
    }

    public i(a aVar) {
        this(aVar, false, false);
    }
}
