package c3;

import j3.h;

public enum s implements h {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);
    

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4800a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4801b;

    /* access modifiers changed from: public */
    s(boolean z10) {
        this.f4800a = z10;
        this.f4801b = 1 << ordinal();
    }

    public boolean a() {
        return this.f4800a;
    }

    public int b() {
        return this.f4801b;
    }
}
