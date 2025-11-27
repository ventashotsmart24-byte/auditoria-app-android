package kotlinx.coroutines.scheduling;

import ca.w0;

public abstract class f extends w0 {

    /* renamed from: d  reason: collision with root package name */
    public final int f18334d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18335e;

    /* renamed from: f  reason: collision with root package name */
    public final long f18336f;

    /* renamed from: g  reason: collision with root package name */
    public final String f18337g;

    /* renamed from: h  reason: collision with root package name */
    public a f18338h = O();

    public f(int i10, int i11, long j10, String str) {
        this.f18334d = i10;
        this.f18335e = i11;
        this.f18336f = j10;
        this.f18337g = str;
    }

    public void L(k9.f fVar, Runnable runnable) {
        a.m(this.f18338h, runnable, (i) null, false, 6, (Object) null);
    }

    public final a O() {
        return new a(this.f18334d, this.f18335e, this.f18336f, this.f18337g);
    }

    public final void P(Runnable runnable, i iVar, boolean z10) {
        this.f18338h.f(runnable, iVar, z10);
    }
}
