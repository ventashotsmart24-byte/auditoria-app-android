package ca;

import kotlinx.coroutines.internal.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public abstract class q0 extends y {

    /* renamed from: c  reason: collision with root package name */
    public long f11537c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11538d;

    /* renamed from: e  reason: collision with root package name */
    public a f11539e;

    public static /* synthetic */ void T(q0 q0Var, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            q0Var.S(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void O(boolean z10) {
        long P = this.f11537c - P(z10);
        this.f11537c = P;
        if (P <= 0 && this.f11538d) {
            shutdown();
        }
    }

    public final long P(boolean z10) {
        if (z10) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1;
    }

    public final void Q(l0 l0Var) {
        a aVar = this.f11539e;
        if (aVar == null) {
            aVar = new a();
            this.f11539e = aVar;
        }
        aVar.a(l0Var);
    }

    public long R() {
        a aVar = this.f11539e;
        if (aVar != null && !aVar.c()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public final void S(boolean z10) {
        this.f11537c += P(z10);
        if (!z10) {
            this.f11538d = true;
        }
    }

    public final boolean U() {
        if (this.f11537c >= P(true)) {
            return true;
        }
        return false;
    }

    public final boolean V() {
        a aVar = this.f11539e;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean W() {
        l0 l0Var;
        a aVar = this.f11539e;
        if (aVar == null || (l0Var = (l0) aVar.d()) == null) {
            return false;
        }
        l0Var.run();
        return true;
    }

    public abstract void shutdown();
}
