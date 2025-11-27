package c3;

import j3.h;

public enum r implements h {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);
    

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4795a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4796b;

    /* access modifiers changed from: public */
    r(boolean z10) {
        this.f4795a = z10;
        this.f4796b = 1 << ordinal();
    }

    public boolean a() {
        return this.f4795a;
    }

    public int b() {
        return this.f4796b;
    }
}
